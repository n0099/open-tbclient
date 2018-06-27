package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.ar.constants.HttpConstants;
import com.tencent.open.SocialConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends c {
    public h(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (com.baidu.android.pushservice.j.m.a(context, bArr, str, str2, bArr2)) {
            String[] strArr = new String[2];
            if (i == l.MSG_TYPE_SINGLE_PRIVATE.a() || i == l.MSG_TYPE_MULTI_PRIVATE.a()) {
                strArr[0] = new String(bArr2);
                strArr[1] = null;
            } else if (i == l.MSG_TYPE_PRIVATE_MESSAGE.a()) {
                PublicMsg a = j.a(context, str2, str, bArr2);
                strArr[0] = a.mDescription;
                strArr[1] = a.mCustomContent;
            }
            return strArr;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String str;
        String e = kVar.e();
        String h = kVar.h();
        int i2 = kVar.i();
        byte[] j = kVar.j();
        String f = kVar.f();
        int i3 = 0;
        com.baidu.android.pushservice.b.d a = com.baidu.android.pushservice.b.d.a(this.a, e);
        String str2 = null;
        if (!TextUtils.isEmpty(f) && com.baidu.android.pushservice.j.m.c(this.a, f)) {
            str2 = f;
        } else if (a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
            str2 = a.a.c();
        } else if (a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
            str2 = a.b.c();
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = com.baidu.android.pushservice.j.m.a(this.a, h, bArr, j, str2);
                try {
                    this.a.getPackageManager().getPackageInfo(str2, 128);
                    PublicMsg a3 = j.a(this.a, h, e, bArr);
                    boolean a4 = a(bArr);
                    if (a3 == null) {
                        i = 0;
                        break;
                    } else {
                        Intent intent = new Intent();
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                            intent.putExtra("bd.message.rate.MH", true);
                        }
                        if (a4) {
                            str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                        } else {
                            intent.putExtra("msg_id", h);
                            str = PushConstants.ACTION_MESSAGE;
                        }
                        intent.putExtra("message_string", a3.mDescription);
                        intent.putExtra("message_id", h);
                        intent.putExtra("baidu_message_type", i2);
                        intent.putExtra("baidu_message_body", bArr);
                        intent.putExtra(HttpConstants.HTTP_APP_ID, e);
                        intent.putExtra("baidu_message_secur_info", a2);
                        if (!TextUtils.isEmpty(a3.mCustomContent)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a3.mCustomContent);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    intent.putExtra(next, jSONObject.getString(next));
                                }
                                intent.putExtra("extra_extra_custom_content", a3.mCustomContent);
                            } catch (JSONException e2) {
                            }
                        }
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                        }
                        i = com.baidu.android.pushservice.j.m.a(this.a, intent, str, str2);
                        com.baidu.android.pushservice.j.m.b(">>> Deliver message to client: " + str2 + " msg: " + a3.mDescription + " result: " + i, this.a);
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    i = 8;
                    f.a(this.a, e);
                    com.baidu.android.pushservice.j.m.b(">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.", this.a);
                    break;
                }
            case SDK_CLIENT:
                byte[] a5 = com.baidu.android.pushservice.j.m.a(this.a, h, bArr, j, str2);
                try {
                    String optString = new JSONObject(new String(bArr)).optString(SocialConstants.PARAM_COMMENT);
                    if (TextUtils.isEmpty(optString)) {
                        i3 = 2;
                    } else {
                        try {
                            this.a.getPackageManager().getPackageInfo(str2, 128);
                            Intent intent2 = new Intent();
                            intent2.setPackage(a.b.c());
                            intent2.putExtra("message", bArr);
                            intent2.putExtra("message_string", optString);
                            intent2.setFlags(32);
                            intent2.putExtra("baidu_message_body", bArr);
                            intent2.putExtra("baidu_message_secur_info", a5);
                            intent2.putExtra("message_id", h);
                            intent2.putExtra("baidu_message_type", i2);
                            com.baidu.android.pushservice.j.m.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", str2);
                        } catch (PackageManager.NameNotFoundException e4) {
                            String str3 = ">>> NOT deliver to app: " + a.b.c() + ", package has been uninstalled.";
                            com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                            i3 = 8;
                        }
                    }
                    i = i3;
                    break;
                } catch (JSONException e5) {
                    i = 2;
                    break;
                }
            default:
                i = 7;
                String str4 = ">>> NOT found client for privateMessageHandler appid " + e;
                if (Build.VERSION.SDK_INT < 24) {
                    f.a(this.a, e);
                }
                com.baidu.android.pushservice.j.m.b(str4, this.a);
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
