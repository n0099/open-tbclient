package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends c {
    private static final String b = n.class.getSimpleName();

    public n(Context context) {
        super(context);
    }

    private com.baidu.android.pushservice.message.g a(String str, long j, String str2, byte[] bArr, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
        intent.putExtra("message_id", str2);
        intent.putExtra("baidu_message_body", str3);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.setFlags(32);
        intent.setPackage(str);
        intent.setClassName(str, "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_DELIVER");
        intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.SOURCE_PACKAGE", this.a.getPackageName());
        return new com.baidu.android.pushservice.j.e(this.a, intent).b();
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        String str4;
        int i2;
        String str5;
        com.baidu.android.pushservice.message.g gVar;
        com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
        int i3 = 0;
        String str6 = new String(bArr2);
        com.baidu.android.pushservice.g.a.c(b, "ultronMsg: " + str6);
        try {
            JSONObject jSONObject = new JSONObject(str6);
            int optInt = jSONObject.optInt("version_require", -1);
            int optInt2 = jSONObject.optInt("command_type");
            String optString = jSONObject.optString("command_body");
            com.baidu.android.pushservice.g.a.c(b, "ultronMsg, vr: " + optInt + " ct: " + optInt2 + " b: " + optString);
            if (TextUtils.isEmpty(str) || str.equals("0")) {
                str4 = null;
            } else {
                if (TextUtils.isEmpty(str3) || !q.c(this.a, str3)) {
                    str3 = null;
                } else {
                    com.baidu.android.pushservice.g.a.c(b, "Ultron Message has PackageName = " + str3);
                }
                com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(str);
                if (d == null || d.c() == null) {
                    if (optInt2 == 1) {
                        i3 = 7;
                        str4 = str3;
                    }
                    str4 = str3;
                } else if (q.c(this.a, d.c())) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = d.c();
                        com.baidu.android.pushservice.g.a.c(b, "Ultron Message PackageName is from  PushClient");
                    }
                    if (optInt2 == 1 && d.d() < optInt) {
                        i3 = 6;
                        str4 = str3;
                    }
                    str4 = str3;
                } else {
                    if (optInt2 == 1) {
                        i3 = 8;
                        str4 = str3;
                    }
                    str4 = str3;
                }
            }
            if (str4 == null && i3 == 0) {
                com.baidu.android.pushservice.b.f a = com.baidu.android.pushservice.b.b.a(this.a).a(optInt, optInt2 == 2);
                if (a == null) {
                    i2 = 6;
                    str5 = str4;
                } else {
                    String c = a.c();
                    com.baidu.android.pushservice.g.a.c(b, "Ultron Message PackageName is from  PushClient  needBaiduAPP");
                    i2 = i3;
                    str5 = c;
                }
            } else {
                i2 = i3;
                str5 = str4;
            }
            if (i2 == 0) {
                com.baidu.android.pushservice.g.a.c(b, "ultronMsg, handleMsg: " + str5);
                gVar = a(str5, 0L, str2, bArr, optString);
            } else {
                gVar = gVar2;
            }
            gVar.a(i2);
            return gVar;
        } catch (JSONException e) {
            gVar2.a(2);
            return gVar2;
        }
    }
}
