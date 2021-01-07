package com.baidu.m;

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
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static com.baidu.poly.a cnd = null;
    private static com.baidu.poly.d.a.a cne = null;
    private static int cnf = 1;

    public boolean a(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.afi().e(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.afi().f(activity, str, aVar);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
        if (r0.equals("Alipay") != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity, JSONObject jSONObject, String[] strArr, final com.baidu.m.a.a aVar) {
        char c;
        char c2 = 0;
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
                    switch (str.hashCode()) {
                        case -2122629326:
                            if (str.equals("Huabei")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1708856474:
                            if (str.equals("WeChat")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1001747525:
                            if (str.equals("Quickpay")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1725926417:
                            if (str.equals("Chinapay")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1865715419:
                            if (str.equals("BDWallet")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1963873898:
                            if (str.equals("Alipay")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
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
                        case 5:
                            strArr2[i] = "BAIDU-CHINAPAY-B2C";
                            break;
                    }
                }
                bundle.putStringArray("blockedPayChannels", strArr2);
            }
            String string = bundle.getString("chosenChannel", "");
            if (!TextUtils.isEmpty(string)) {
                switch (string.hashCode()) {
                    case -2122629326:
                        if (string.equals("Huabei")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1708856474:
                        if (string.equals("WeChat")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1001747525:
                        if (string.equals("Quickpay")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1725926417:
                        if (string.equals("Chinapay")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1865715419:
                        if (string.equals("BDWallet")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1963873898:
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        string = "BAIDU-ALIPAY-WISE";
                        break;
                    case 1:
                        string = "BAIDU-SUPER-WECHAT-WISE";
                        break;
                    case 2:
                        string = "BAIDU-BAIFUBAO-WISE";
                        break;
                    case 3:
                        string = "BAIDU-QUICKPAY";
                        break;
                    case 4:
                        string = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                        break;
                    case 5:
                        string = "BAIDU-CHINAPAY-B2C";
                        break;
                }
                bundle.putString("chosenChannel", string);
            }
            bundle.putString("zid", b.afi().getZid(activity));
            bH(activity).a(activity, bundle, afg(), new a.b() { // from class: com.baidu.m.a.1
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

    private static com.baidu.poly.d.a.c afg() {
        return new com.baidu.poly.d.a.c() { // from class: com.baidu.m.a.2
            @Override // com.baidu.poly.d.a.c
            public void a(Activity activity, com.baidu.poly.d.a.b bVar, final com.baidu.poly.d.a.a aVar) {
                if (bVar == null || TextUtils.isEmpty(bVar.channel) || bVar.cpB == null) {
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
                    case 1525377225:
                        if (str.equals("BAIDU-CHINAPAY-B2C")) {
                            c = 5;
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
                        c.afj().d(activity, bVar.cpB.optString("orderInfo"), new com.baidu.m.a.a() { // from class: com.baidu.m.a.2.1
                            @Override // com.baidu.m.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 2:
                        c.afj().a((Context) activity, bVar.cpB, new com.baidu.m.a.a() { // from class: com.baidu.m.a.2.2
                            @Override // com.baidu.m.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 3:
                        c.afj().c(activity, bVar.cpB.optString("orderInfo"), new com.baidu.m.a.a() { // from class: com.baidu.m.a.2.3
                            @Override // com.baidu.m.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
                        break;
                    case 4:
                        com.baidu.poly.d.a.a unused = a.cne = aVar;
                        d.afk();
                        c.afj().e(activity, bVar.cpB);
                        break;
                    case 5:
                        c.afj().a(activity, bVar.cpB, new com.baidu.m.a.a() { // from class: com.baidu.m.a.2.4
                            @Override // com.baidu.m.a.a
                            public void onPayResult(int i, String str2) {
                                a.a(aVar, i, str2);
                            }
                        });
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
        bH(AppRuntime.getAppContext()).a(1, jSONObject, aVar);
    }

    public void a(com.baidu.poly.b.a aVar) {
        bH(AppRuntime.getAppContext()).a(2, null, aVar);
    }

    private static com.baidu.poly.a bH(Context context) {
        if (cnd != null) {
            return cnd;
        }
        cnf = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        cnd = new a.C0307a().he(cnf).bJ(context.getApplicationContext()).eg(false).afn();
        return cnd;
    }

    public static void ae(int i, String str) {
        if (cne != null) {
            cne.onResult(i, str);
            cne = null;
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

    public static boolean afh() {
        return false;
    }
}
