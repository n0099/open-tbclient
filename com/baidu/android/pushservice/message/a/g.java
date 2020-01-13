package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends b {
    public g(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (l.a(context, bArr, str, str2, bArr2)) {
            String[] strArr = new String[2];
            if (i == k.MSG_TYPE_SINGLE_PRIVATE.a() || i == k.MSG_TYPE_MULTI_PRIVATE.a()) {
                strArr[0] = new String(bArr2);
                strArr[1] = null;
            } else if (i == k.MSG_TYPE_PRIVATE_MESSAGE.a()) {
                PublicMsg a = i.a(context, str2, str, bArr2);
                strArr[0] = a.mDescription;
                strArr[1] = a.mCustomContent;
            }
            return strArr;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        int i;
        String str;
        int i2 = 0;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] g = kVar.g();
        String c = kVar.c();
        com.baidu.android.pushservice.a.d a = com.baidu.android.pushservice.a.d.a(this.a, b);
        if (TextUtils.isEmpty(c) || !l.c(this.a, c)) {
            c = a.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a.a.c() : a.a() == com.baidu.android.pushservice.a.c.SDK_CLIENT ? a.b.c() : null;
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                String a2 = a(c);
                byte[] a3 = l.a(this.a, e, bArr, g, a2);
                try {
                    this.a.getPackageManager().getPackageInfo(a2, 128);
                    PublicMsg a4 = i.a(this.a, e, b, bArr);
                    boolean a5 = a(bArr);
                    if (a4 == null) {
                        i = 0;
                        break;
                    } else {
                        Intent intent = new Intent();
                        if (a5) {
                            str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                        } else {
                            intent.putExtra("msg_id", e);
                            str = PushConstants.ACTION_MESSAGE;
                        }
                        intent.putExtra("message_string", a4.mDescription);
                        intent.putExtra("message_id", e);
                        intent.putExtra("baidu_message_type", f);
                        intent.putExtra("baidu_message_body", bArr);
                        intent.putExtra(Constants.APP_ID, b);
                        intent.putExtra("baidu_message_secur_info", a3);
                        if (!TextUtils.isEmpty(a4.mCustomContent)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a4.mCustomContent);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    intent.putExtra(next, jSONObject.getString(next));
                                }
                                intent.putExtra("extra_extra_custom_content", a4.mCustomContent);
                            } catch (JSONException e2) {
                            }
                        }
                        i = l.a(this.a, intent, str, a2);
                        l.b(">>> Deliver message to client: " + a2 + " msg: " + a4.mDescription + " result: " + i, this.a);
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    e.a(this.a, b);
                    l.b(">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.", this.a);
                    i = 8;
                    break;
                }
            case SDK_CLIENT:
                byte[] a6 = l.a(this.a, e, bArr, g, c);
                try {
                    String optString = new JSONObject(new String(bArr)).optString("description");
                    if (TextUtils.isEmpty(optString)) {
                        i2 = 2;
                    } else {
                        try {
                            this.a.getPackageManager().getPackageInfo(c, 128);
                            Intent intent2 = new Intent();
                            intent2.setPackage(a.b.c());
                            intent2.putExtra("message", bArr);
                            intent2.putExtra("message_string", optString);
                            intent2.setFlags(32);
                            intent2.putExtra("baidu_message_body", bArr);
                            intent2.putExtra("baidu_message_secur_info", a6);
                            intent2.putExtra("message_id", e);
                            intent2.putExtra("baidu_message_type", f);
                            l.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", c);
                        } catch (PackageManager.NameNotFoundException e4) {
                            String str2 = ">>> NOT deliver to app: " + a.b.c() + ", package has been uninstalled.";
                            com.baidu.android.pushservice.a.h.a(this.a).a((com.baidu.android.pushservice.a.a) a.b, false);
                            i2 = 8;
                        }
                    }
                    i = i2;
                    break;
                } catch (JSONException e5) {
                    i = 2;
                    break;
                }
            default:
                i = 7;
                String str3 = ">>> NOT found client for privateMessageHandler appid " + b;
                if (Build.VERSION.SDK_INT < 24) {
                    e.a(this.a, b);
                }
                l.b(str3, this.a);
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
