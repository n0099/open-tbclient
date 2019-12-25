package com.baidu.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static com.baidu.poly.a aKs = null;
    private static com.baidu.poly.c.a.a aKt = null;
    private static int aKu = 1;

    public boolean a(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Bz().e(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Bz().f(activity, str, aVar);
        return true;
    }

    public void a(Activity activity, JSONObject jSONObject, String[] strArr, final com.baidu.j.a.a aVar) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.optString(next));
        }
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                char c = 65535;
                switch (str.hashCode()) {
                    case -1708856474:
                        if (str.equals("WeChat")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1001747525:
                        if (str.equals("Quickpay")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1865715419:
                        if (str.equals("BDWallet")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1963873898:
                        if (str.equals("Alipay")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        strArr2[i] = "BAIDU-ALIPAY-WISE";
                        break;
                    case 1:
                        strArr2[i] = "BAIDU-SUPER-WECHAT-WISE";
                        break;
                    case 2:
                        strArr2[i] = "BAIDU-BAIFUBAO-WISE";
                        break;
                    case 3:
                        strArr2[i] = "BAIDU-QUICKPAY";
                        break;
                }
            }
            bundle.putStringArray("blockedPayChannels", strArr2);
        }
        z(activity).a(activity, bundle, new a.b() { // from class: com.baidu.j.a.1
            @Override // com.baidu.poly.a.b
            public void onResult(int i2, String str2) {
                if (i2 == 3) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        jSONObject2.put("statusCode", 6);
                        aVar.onPayResult(6, jSONObject2.toString());
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        aVar.onPayResult(6, str2);
                        return;
                    }
                }
                aVar.onPayResult(i2, str2);
            }
        });
    }

    private static com.baidu.poly.a z(Activity activity) {
        if (aKs != null) {
            return aKs;
        }
        aKs = new a.C0142a().a(new com.baidu.poly.c.a.c() { // from class: com.baidu.j.a.2
            @Override // com.baidu.poly.c.a.c
            public void a(Activity activity2, com.baidu.poly.c.a.b bVar, final com.baidu.poly.c.a.a aVar) {
                if (bVar == null || TextUtils.isEmpty(bVar.channel) || bVar.aMM == null) {
                    a.a(aVar, 6, "支付信息不能为空");
                    return;
                }
                String str = bVar.channel;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1537577171:
                        if (str.equals("BAIDU-QUICKPAY")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 299450696:
                        if (str.equals("BAIDU-BAIFUBAO-WISE")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1455583605:
                        if (str.equals("BAIDU-ALIPAY-WISE")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2009937959:
                        if (str.equals("BAIDU-SUPER-WECHAT-WISE")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        c.BA().d(activity2, bVar.aMM.optString("orderInfo"), new com.baidu.j.a.a() { // from class: com.baidu.j.a.2.1
                            @Override // com.baidu.j.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 1:
                        c.BA().a(activity2, bVar.aMM, new com.baidu.j.a.a() { // from class: com.baidu.j.a.2.2
                            @Override // com.baidu.j.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 2:
                        c.BA().c(activity2, bVar.aMM.optString("orderInfo"), new com.baidu.j.a.a() { // from class: com.baidu.j.a.2.3
                            @Override // com.baidu.j.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 3:
                        com.baidu.poly.c.a.a unused = a.aKt = aVar;
                        d.BB();
                        c.BA().f(activity2, bVar.aMM);
                        break;
                    default:
                        aVar.onResult(3, "未知的支付方式");
                        break;
                }
                activity2.finish();
            }
        }).db(aKu).aR(activity.getApplicationContext()).bA(false).BE();
        return aKs;
    }

    public static void n(int i, String str) {
        if (aKt != null) {
            aKt.onResult(i, str);
            aKt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.poly.c.a.a aVar, int i, String str) {
        int i2;
        if (aVar != null) {
            switch (i) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            aVar.onResult(i2, str);
        }
    }

    public static boolean By() {
        return false;
    }
}
