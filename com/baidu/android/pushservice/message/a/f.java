package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends b {
    public f(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (m.a(context, bArr, str2, bArr2)) {
            String[] strArr = new String[2];
            if (i == j.MSG_TYPE_SINGLE_PRIVATE.b() || i == j.MSG_TYPE_MULTI_PRIVATE.b()) {
                strArr[0] = new String(bArr2);
                strArr[1] = null;
            } else if (i == j.MSG_TYPE_PRIVATE_MESSAGE.b()) {
                PublicMsg a2 = h.a(context, str2, str, bArr2);
                strArr[0] = a2.mDescription;
                strArr[1] = a2.mCustomContent;
            }
            return strArr;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.b
    public com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr) {
        int i;
        String str;
        String b = kVar.b();
        String e = kVar.e();
        int f = kVar.f();
        byte[] h = kVar.h();
        String c = kVar.c();
        com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.f1237a, b);
        if (TextUtils.isEmpty(c) || !m.b(this.f1237a, c)) {
            c = a2.a() == com.baidu.android.pushservice.a.c.PUSH_CLIENT ? a2.f1081a.b() : null;
        }
        switch (a2.a()) {
            case PUSH_CLIENT:
                String a3 = a(c);
                try {
                    this.f1237a.getPackageManager().getPackageInfo(a3, 128);
                    PublicMsg a4 = h.a(this.f1237a, e, b, bArr);
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
                            str = "com.baidu.android.pushservice.action.MESSAGE";
                        }
                        intent.putExtra("message_string", a4.mDescription);
                        intent.putExtra("message_id", e);
                        intent.putExtra("baidu_message_type", f);
                        intent.putExtra("baidu_message_body", bArr);
                        intent.putExtra("app_id", b);
                        intent.putExtra("baidu_message_secur_info", h);
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
                                new b.c(this.f1237a).a(Log.getStackTraceString(e2)).a();
                            }
                        }
                        i = m.a(this.f1237a, intent, str, a3);
                        m.a(">>> Deliver message to client: " + a3 + " msg: " + a4.mDescription + " result: " + i, this.f1237a);
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    i = 8;
                    m.a(">>> NOT deliver to app: " + a2.f1081a.b(), this.f1237a);
                    break;
                }
            default:
                i = 7;
                m.a(">>> NOT found client for privateMessageHandler appid " + b, this.f1237a);
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i);
        return gVar;
    }
}
