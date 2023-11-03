package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends c {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.k.c.values().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.k.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public h(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2, int i2) {
        if (Utility.a(context, bArr, str2, bArr2)) {
            String[] strArr = new String[2];
            if (i == l.MSG_TYPE_SINGLE_PRIVATE.a() || i == l.MSG_TYPE_MULTI_PRIVATE.a() || i == l.MSG_TYPE_LOCAL_PUSH_MESSAGE.a()) {
                strArr[0] = new String(bArr2);
                if (i2 == 2) {
                    strArr[0] = j.a(context, str2, str, bArr2).mCustomContent;
                }
                strArr[1] = null;
            } else if (i == l.MSG_TYPE_PRIVATE_MESSAGE.a()) {
                PublicMsg a2 = j.a(context, str2, str, bArr2);
                strArr[0] = a2.mDescription;
                strArr[1] = a2.mCustomContent;
            } else if (i == l.MSG_TYPE_APP_PRIORITY.a()) {
                strArr[0] = new String(bArr2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("push_ack_msgid", str2);
                    jSONObject.put("push_ack_msgtype", i);
                } catch (JSONException unused) {
                }
                strArr[1] = jSONObject.toString();
            }
            return strArr;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.w.m.c
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        int i;
        String str;
        String a2 = kVar.a();
        String h = kVar.h();
        int q = kVar.q();
        byte[] n = kVar.n();
        String j = kVar.j();
        int i2 = kVar.i();
        int o = kVar.o();
        com.baidu.android.pushservice.k.d a3 = com.baidu.android.pushservice.k.d.a(this.a, a2);
        if (TextUtils.isEmpty(j) || !Utility.m(this.a, j)) {
            j = a3.a() == com.baidu.android.pushservice.k.c.PUSH_CLIENT ? a3.b.b() : null;
        }
        if (a.a[a3.a().ordinal()] != 1) {
            i = 7;
            String str2 = ">>> NOT found client for privateMessageHandler appid " + a2;
        } else {
            String a4 = a(j);
            try {
                this.a.getPackageManager().getPackageInfo(a4, 128);
                PublicMsg a5 = j.a(this.a, h, a2, bArr);
                boolean a6 = a(bArr);
                if (a5 != null) {
                    Intent intent = new Intent();
                    if (a6) {
                        str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                    } else {
                        intent.putExtra("msg_id", h);
                        str = "com.baidu.android.pushservice.action.MESSAGE";
                    }
                    intent.putExtra("message_string", a5.mDescription);
                    intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, h);
                    intent.putExtra("baidu_message_type", q);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("app_id", a2);
                    intent.putExtra("baidu_message_secur_info", n);
                    intent.putExtra(Constants.EXTRA_NOTIFY_ID, i2);
                    intent.putExtra("connect_source", o);
                    intent.putExtra("widget_badge_info", kVar.r());
                    intent.putExtra("foreground_show_num", kVar.d());
                    intent.putExtra("notification_log_ext", kVar.f());
                    if (!TextUtils.isEmpty(a5.mCustomContent)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a5.mCustomContent);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                intent.putExtra(next, jSONObject.getString(next));
                            }
                            intent.putExtra("extra_extra_custom_content", a5.mCustomContent);
                        } catch (JSONException unused) {
                        }
                    }
                    if (kVar.d() < 1 || !Utility.B(this.a)) {
                        i = Utility.a(this.a, intent, str, a4);
                        String str3 = ">>> Deliver message to client: " + a4 + " msg: " + a5.mDescription + " result: " + i;
                    } else {
                        i = new e(this.a).a(kVar, bArr).a();
                    }
                } else {
                    i = 0;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                i = 8;
                String str4 = ">>> NOT deliver to app: " + a3.b.b();
            }
        }
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        gVar.a(i);
        return gVar;
    }
}
