package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: com.baidu.android.pushservice.message.a.h$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3477a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.a.c.values().length];
            f3477a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public h(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (m.a(context, bArr, str2, bArr2)) {
            String[] strArr = new String[2];
            if (i == l.MSG_TYPE_SINGLE_PRIVATE.b() || i == l.MSG_TYPE_MULTI_PRIVATE.b()) {
                strArr[0] = new String(bArr2);
                strArr[1] = null;
            } else if (i == l.MSG_TYPE_PRIVATE_MESSAGE.b()) {
                PublicMsg a2 = j.a(context, str2, str, bArr2);
                strArr[0] = a2.mDescription;
                strArr[1] = a2.mCustomContent;
            } else if (i == l.MSG_TYPE_APP_PRIORITY.b()) {
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

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        StringBuilder sb;
        String str;
        String c2 = kVar.c();
        String f2 = kVar.f();
        int g2 = kVar.g();
        byte[] i2 = kVar.i();
        String d2 = kVar.d();
        int a2 = kVar.a();
        com.baidu.android.pushservice.a.d a3 = com.baidu.android.pushservice.a.d.a(this.f3468a, c2);
        if (TextUtils.isEmpty(d2) || !m.b(this.f3468a, d2)) {
            d2 = a3.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a3.f2723a.b() : null;
        }
        if (AnonymousClass1.f3477a[a3.a().ordinal()] == 1) {
            String a4 = a(d2);
            try {
                this.f3468a.getPackageManager().getPackageInfo(a4, 128);
                PublicMsg a5 = j.a(this.f3468a, f2, c2, bArr);
                boolean a6 = a(bArr);
                if (a5 != null) {
                    Intent intent = new Intent();
                    if (a6) {
                        str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                    } else {
                        str = "com.baidu.android.pushservice.action.MESSAGE";
                        intent.putExtra("msg_id", f2);
                    }
                    intent.putExtra("message_string", a5.mDescription);
                    intent.putExtra("message_id", f2);
                    intent.putExtra("baidu_message_type", g2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra(Constants.APP_ID, c2);
                    intent.putExtra("baidu_message_secur_info", i2);
                    intent.putExtra("notify_id", a2);
                    if (!TextUtils.isEmpty(a5.mCustomContent)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a5.mCustomContent);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                intent.putExtra(next, jSONObject.getString(next));
                            }
                            intent.putExtra("extra_extra_custom_content", a5.mCustomContent);
                        } catch (JSONException e2) {
                            new b.c(this.f3468a).a(Log.getStackTraceString(e2)).a();
                        }
                    }
                    i = m.a(this.f3468a, intent, str, a4);
                    m.a(">>> Deliver message to client: " + a4 + " msg: " + a5.mDescription + " result: " + i, this.f3468a);
                } else {
                    i = 0;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                i = 8;
                sb = new StringBuilder();
                sb.append(">>> NOT deliver to app: ");
                c2 = a3.f2723a.b();
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i);
            return gVar;
        }
        i = 7;
        sb = new StringBuilder();
        sb.append(">>> NOT found client for privateMessageHandler appid ");
        sb.append(c2);
        m.a(sb.toString(), this.f3468a);
        com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
        gVar2.a(i);
        return gVar2;
    }
}
