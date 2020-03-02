package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.facebook.common.internal.i;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bQw = i.K("https", "wss");

    /* JADX WARN: Can't wrap try/catch for region: R(13:58|59|(3:62|(4:65|(1:105)(8:67|68|(3:99|100|(2:102|103)(1:104))(3:70|71|(2:73|74)(1:97))|80|(1:(1:83)(1:84))|(1:86)|87|(2:89|90)(1:91))|98|63)|106)|108|75|76|(1:78)|79|80|(0)|(0)|87|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ff, code lost:
        if (com.baidu.swan.apps.aj.a.b.DEBUG != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0201, code lost:
        android.util.Log.e("WebSafeCheckers", android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0216, code lost:
        r1 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean lh(String str) {
        boolean z;
        String host;
        e acF = e.acF();
        if (acF == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!com.baidu.swan.apps.ah.a.a.aan()) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
            }
            return true;
        }
        boolean Hj = com.baidu.swan.apps.w.a.TZ().Hj();
        if (!Hj) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "ABTest : webDomains switch " + Hj);
            }
            return true;
        } else if (!adG()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
            }
            return true;
        } else {
            String acH = e.acH();
            if (!c.ln(acH)) {
                return true;
            }
            ArrayList<String> z2 = acF.acX().z(acH, false);
            if (lowerCase.startsWith("weixin://wap/pay") && z2.contains("wx.tenpay.com")) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + acF.getName());
                }
                f.a("wechatH5", str, z2);
                return true;
            } else if (lowerCase.startsWith("alipays://platformapi/startapp") && z2.contains("*.alipay.com") && z2.contains("*.alipayobjects.com")) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " name: " + acF.getName());
                }
                f.a("alipayH5", str, z2);
                return true;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.w("WebSafeCheckers", "checkWebDomain: url is empty");
                    }
                    return false;
                }
                try {
                    host = new URL(str).getHost();
                } catch (MalformedURLException e) {
                    z = false;
                    MalformedURLException e2 = e;
                }
                if (!TextUtils.isEmpty(host) && z2 != null) {
                    Iterator<String> it = z2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null) {
                            if (next.startsWith("*.")) {
                                if (host.endsWith(next.substring("*.".length()))) {
                                    z = true;
                                    break;
                                }
                            } else if (TextUtils.equals(next, host)) {
                                z = true;
                                break;
                            }
                            if (DEBUG) {
                                if (z) {
                                    Log.d("WebSafeCheckers", "Domain in white list");
                                } else {
                                    Log.d("WebSafeCheckers", "Domain not in white list");
                                }
                            }
                            if (!z) {
                                com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain is not in white list");
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (DEBUG) {
                                Log.d("WebSafeCheckers", "checkWebDomain: cost time = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                return z;
                            }
                            return z;
                        }
                    }
                }
                z = false;
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "domain: " + host + ", domains: " + z2);
                }
                com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain: " + host);
                if (DEBUG) {
                }
                if (!z) {
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (DEBUG) {
                }
            }
        }
    }

    public static boolean li(String str) {
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aan()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkWebAction: action is empty");
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e acF = e.acF();
            if (acF == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> dP = acF.acX().dP(true);
            if (dP != null && dP.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + dP);
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.d("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=" + dP);
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int D(String str, String str2, String str3) {
        boolean z;
        String host;
        ArrayList<String> arrayList;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "server domains: requestName or requestUrl is empty");
            }
            return 1;
        }
        if (DEBUG) {
            Log.i("WebSafeCheckers", "requestName : " + str);
            Log.i("WebSafeCheckers", "requestUrl : " + str2);
        }
        boolean z2 = !com.baidu.swan.apps.ah.a.a.aao();
        if (z2) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                return 0;
            }
            return 0;
        }
        boolean adG = adG();
        if (!adG) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + adG);
                return 0;
            }
            return 0;
        } else if (!lj(str2)) {
            return 2;
        } else {
            boolean Hi = com.baidu.swan.apps.w.a.TZ().Hi();
            if (!Hi) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + Hi);
                    return 0;
                }
                return 0;
            }
            e acF = e.acF();
            if (acF == null) {
                return 1;
            }
            String str4 = acF.id;
            if (TextUtils.isEmpty(str4)) {
                return 1;
            }
            if (!TextUtils.isEmpty(str3)) {
                return !com.baidu.swan.apps.ag.g.a.a(str, str2, com.baidu.swan.apps.ag.g.b.km(str3)) ? 1 : 0;
            } else if (!new File(c.E(str4, "aiapps_folder/cloud_config", "server_domains.json")).exists()) {
                if (DEBUG) {
                    Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                    return 0;
                }
                return 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    host = new URI(str2).getHost();
                    arrayList = acF.acX().l(e.acH(), str, false).data;
                    z = f(host, arrayList);
                } catch (URISyntaxException e) {
                    e = e;
                    z = false;
                }
                try {
                    if (DEBUG) {
                        Log.d("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: " + arrayList);
                    }
                    com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain: " + host);
                } catch (URISyntaxException e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                    }
                    if (!z) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (DEBUG) {
                    }
                    if (z) {
                    }
                }
                if (!z) {
                    com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain is not in white list");
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "serverDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                    if (z) {
                        Log.d("WebSafeCheckers", "serverDomain in white list");
                    } else {
                        Log.d("WebSafeCheckers", "serverDomain not in white list");
                    }
                }
                return z ? 1 : 0;
            }
        }
    }

    public static boolean f(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.size() == 0) {
            return false;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (TextUtils.equals(str, next)) {
                    return true;
                }
                if (next.startsWith("*.") && str.endsWith(next.substring("*.".length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean lj(String str) {
        for (String str2 : bQw) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        if (com.baidu.swan.apps.ah.a.a.aaw()) {
            return true;
        }
        boolean Ho = com.baidu.swan.apps.w.a.TZ().Ho();
        if (DEBUG) {
            Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + Ho);
        }
        return !Ho && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
    }

    public static boolean lk(String str) {
        if (DEBUG && !com.baidu.swan.apps.ah.a.a.aan()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkAdLandingWebAction: action is empty");
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e acF = e.acF();
            if (acF == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> adF = acF.acX().adF();
            if (adF != null && adF.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + adF);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
            return false;
        }
    }

    public static boolean adG() {
        if (d.acC().Gu() == 0 && SwanAppConfigData.c.adw()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
            }
            return false;
        }
        return true;
    }

    public static boolean ll(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay");
    }

    public static boolean lm(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp");
    }
}
