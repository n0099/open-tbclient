package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends c {
    private static final String b = h.class.getSimpleName();

    public h(Context context) {
        super(context);
    }

    public static String[] a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (q.a(context, bArr, str, str2, bArr2)) {
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
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        int i2;
        String str4;
        int i3 = 0;
        com.baidu.android.pushservice.b.d a = com.baidu.android.pushservice.b.d.a(this.a, str);
        String str5 = null;
        if (TextUtils.isEmpty(str3) || !q.c(this.a, str3)) {
            if (a.a() == com.baidu.android.pushservice.b.c.PUSH_CLIENT) {
                str5 = a.a.c();
            } else if (a.a() == com.baidu.android.pushservice.b.c.SDK_CLIENT) {
                str5 = a.b.c();
            }
            com.baidu.android.pushservice.g.a.c(b, "PrivateMessage PackageName is from  PushClient");
            str3 = str5;
        } else {
            com.baidu.android.pushservice.g.a.c(b, "PrivateMessage has PackageName = " + str3);
        }
        switch (a.a()) {
            case PUSH_CLIENT:
                byte[] a2 = q.a(this.a, str2, bArr2, bArr, str3);
                try {
                    this.a.getPackageManager().getPackageInfo(str3, 128);
                    PublicMsg a3 = j.a(this.a, str2, str, bArr2);
                    boolean a4 = a(bArr2);
                    if (a3 == null) {
                        i2 = 0;
                        break;
                    } else {
                        Intent intent = new Intent();
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                        }
                        if (a4) {
                            str4 = "com.baidu.android.pushservice.action.FB_MESSAGE";
                        } else {
                            intent.putExtra(PbActivityConfig.KEY_MSG_ID, str2);
                            str4 = PushConstants.ACTION_MESSAGE;
                        }
                        intent.putExtra("message_string", a3.mDescription);
                        intent.putExtra("message_id", str2);
                        intent.putExtra("baidu_message_type", i);
                        intent.putExtra("baidu_message_body", bArr2);
                        intent.putExtra("app_id", str);
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
                            } catch (JSONException e) {
                                com.baidu.android.pushservice.g.a.a(b, "Custom content to JSONObject exception:", e);
                            }
                        }
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                        }
                        i2 = q.a(this.a, intent, str4, str3);
                        String str6 = ">>> Deliver message to client: " + str3 + " msg: " + a3.mDescription + " result: " + i2;
                        com.baidu.android.pushservice.g.a.b(b, str6);
                        q.b(str6, this.a);
                        break;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    String str7 = ">>> NOT deliver to app: " + a.a.c() + ", package has been uninstalled.";
                    f.a(this.a, str);
                    com.baidu.android.pushservice.g.a.b(b, str7);
                    q.b(str7, this.a);
                    i2 = 8;
                    break;
                }
            case SDK_CLIENT:
                byte[] a5 = q.a(this.a, str2, bArr2, bArr, str3);
                com.baidu.android.pushservice.g.a.c(b, "receive sdk message " + new String(bArr2) + " pkgName = " + str3);
                try {
                    String optString = new JSONObject(new String(bArr2)).optString("description");
                    if (TextUtils.isEmpty(optString)) {
                        i3 = 2;
                    } else {
                        try {
                            this.a.getPackageManager().getPackageInfo(str3, 128);
                            Intent intent2 = new Intent();
                            intent2.setPackage(a.b.c());
                            intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr2);
                            intent2.putExtra("message_string", optString);
                            intent2.setFlags(32);
                            intent2.putExtra("baidu_message_body", bArr2);
                            intent2.putExtra("baidu_message_secur_info", a5);
                            intent2.putExtra("message_id", str2);
                            intent2.putExtra("baidu_message_type", i);
                            q.b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", str3);
                        } catch (PackageManager.NameNotFoundException e3) {
                            com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) a.b, false);
                            com.baidu.android.pushservice.g.a.b(b, ">>> NOT deliver to app: " + a.b.c() + ", package has been uninstalled.");
                            i3 = 8;
                        }
                    }
                    i2 = i3;
                    break;
                } catch (JSONException e4) {
                    com.baidu.android.pushservice.g.a.c(b, "description is null return invalid");
                    i2 = 2;
                    break;
                }
            default:
                i2 = 7;
                String str8 = ">>> NOT found client for privateMessageHandler appid " + str;
                f.a(this.a, str);
                com.baidu.android.pushservice.g.a.b(b, str8 + " msgbody " + new String(bArr2));
                q.b(str8, this.a);
                break;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
