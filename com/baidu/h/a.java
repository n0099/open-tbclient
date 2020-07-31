package com.baidu.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.poly.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static com.baidu.poly.a byJ = null;
    private static com.baidu.poly.d.a.a byK = null;
    private static int byL = 1;

    public boolean a(Activity activity, String str, com.baidu.h.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.NT().e(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, com.baidu.h.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.NT().f(activity, str, aVar);
        return true;
    }

    public void a(Activity activity, JSONObject jSONObject, String[] strArr, final com.baidu.h.a.a aVar) {
        if (activity != null) {
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
                        case -2122629326:
                            if (str.equals("Huabei")) {
                                c = 4;
                                break;
                            }
                            break;
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
                        case 4:
                            strArr2[i] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                            break;
                    }
                }
                bundle.putStringArray("blockedPayChannels", strArr2);
            }
            bundle.putString("zid", b.NT().getZid(activity));
            aF(activity).a(activity, bundle, NR(), new a.b() { // from class: com.baidu.h.a.1
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
    }

    private static com.baidu.poly.d.a.c NR() {
        return new com.baidu.poly.d.a.c() { // from class: com.baidu.h.a.2
            @Override // com.baidu.poly.d.a.c
            public void a(Activity activity, com.baidu.poly.d.a.b bVar, final com.baidu.poly.d.a.a aVar) {
                if (bVar == null || TextUtils.isEmpty(bVar.channel) || bVar.bBg == null) {
                    a.a(aVar, 6, "支付信息不能为空");
                    return;
                }
                String str = bVar.channel;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1537577171:
                        if (str.equals("BAIDU-QUICKPAY")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1021180251:
                        if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-PAY")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 299450696:
                        if (str.equals("BAIDU-BAIFUBAO-WISE")) {
                            c = 3;
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
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        c.NU().d(activity, bVar.bBg.optString("orderInfo"), new com.baidu.h.a.a() { // from class: com.baidu.h.a.2.1
                            @Override // com.baidu.h.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 2:
                        c.NU().a(activity, bVar.bBg, new com.baidu.h.a.a() { // from class: com.baidu.h.a.2.2
                            @Override // com.baidu.h.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 3:
                        c.NU().c(activity, bVar.bBg.optString("orderInfo"), new com.baidu.h.a.a() { // from class: com.baidu.h.a.2.3
                            @Override // com.baidu.h.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 4:
                        com.baidu.poly.d.a.a unused = a.byK = aVar;
                        d.NV();
                        c.NU().f(activity, bVar.bBg);
                        break;
                    default:
                        aVar.onResult(3, "未知的支付方式");
                        break;
                }
                activity.finish();
            }
        };
    }

    public void a(JSONObject jSONObject, com.baidu.poly.b.a aVar) {
        aF(AppRuntime.getAppContext()).a(1, jSONObject, aVar);
    }

    public void a(com.baidu.poly.b.a aVar) {
        aF(AppRuntime.getAppContext()).a(2, null, aVar);
    }

    private static com.baidu.poly.a aF(Context context) {
        if (byJ != null) {
            return byJ;
        }
        byL = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        byJ = new a.C0238a().dR(byL).aH(context.getApplicationContext()).cY(false).NY();
        return byJ;
    }

    public static void L(int i, String str) {
        if (byK != null) {
            byK.onResult(i, str);
            byK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.poly.d.a.a aVar, int i, String str) {
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

    public static boolean NS() {
        return false;
    }
}
