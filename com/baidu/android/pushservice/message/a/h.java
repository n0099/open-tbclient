package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends c {
    public h(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (p.a(context, bArr, str, str2, bArr2)) {
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
        if (TextUtils.isEmpty(f) || !p.c(this.a, f)) {
            if (a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                str2 = a.a.c();
            } else if (a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                str2 = a.b.c();
            }
            com.baidu.android.pushservice.g.a.c("PrivateMessageHandler", "PrivateMessage PackageName is from  PushClient");
            f = str2;
        } else {
            com.baidu.android.pushservice.g.a.c("PrivateMessageHandler", "PrivateMessage has PackageName = " + f);
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = p.a(this.a, h, bArr, j, f);
                try {
                    this.a.getPackageManager().getPackageInfo(f, 128);
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
                        intent.putExtra("app_id", e);
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
                                com.baidu.android.pushservice.g.a.a("PrivateMessageHandler", "Custom content to JSONObject exception:", e2);
                            }
                        }
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                        }
                        i = p.a(this.a, intent, str, f);
                        String str3 = ">>> Deliver message to client: " + f + " msg: " + a3.mDescription + " result: " + i;
                        com.baidu.android.pushservice.g.a.b("PrivateMessageHandler", str3);
                        p.b(str3, this.a);
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    i = 8;
                    String str4 = ">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.";
                    f.a(this.a, e);
                    com.baidu.android.pushservice.g.a.b("PrivateMessageHandler", str4);
                    p.b(str4, this.a);
                    break;
                }
            case SDK_CLIENT:
                byte[] a5 = p.a(this.a, h, bArr, j, f);
                com.baidu.android.pushservice.g.a.c("PrivateMessageHandler", "receive sdk message " + new String(bArr) + " pkgName = " + f);
                try {
                    String optString = new JSONObject(new String(bArr)).optString("description");
                    if (TextUtils.isEmpty(optString)) {
                        i3 = 2;
                    } else {
                        try {
                            this.a.getPackageManager().getPackageInfo(f, 128);
                            Intent intent2 = new Intent();
                            intent2.setPackage(a.b.c());
                            intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                            intent2.putExtra("message_string", optString);
                            intent2.setFlags(32);
                            intent2.putExtra("baidu_message_body", bArr);
                            intent2.putExtra("baidu_message_secur_info", a5);
                            intent2.putExtra("message_id", h);
                            intent2.putExtra("baidu_message_type", i2);
                            p.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", f);
                        } catch (PackageManager.NameNotFoundException e4) {
                            com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                            i3 = 8;
                            com.baidu.android.pushservice.g.a.b("PrivateMessageHandler", ">>> NOT deliver to app: " + a.b.c() + ", package has been uninstalled.");
                        }
                    }
                    i = i3;
                    break;
                } catch (JSONException e5) {
                    i = 2;
                    com.baidu.android.pushservice.g.a.c("PrivateMessageHandler", "description is null return invalid");
                    break;
                }
            default:
                i = 7;
                String str5 = ">>> NOT found client for privateMessageHandler appid " + e;
                if (Build.VERSION.SDK_INT < 24) {
                    f.a(this.a, e);
                }
                com.baidu.android.pushservice.g.a.b("PrivateMessageHandler", str5 + " msgBody " + new String(bArr));
                p.b(str5, this.a);
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
