package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
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
/* loaded from: classes7.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dsU = i.N("https", "wss");

    /* JADX WARN: Can't wrap try/catch for region: R(11:58|59|(3:62|(4:65|(1:102)(8:67|68|(3:96|97|(2:99|100)(1:101))(3:70|71|(2:73|74)(1:94))|77|(1:(1:80)(1:81))|(1:83)|84|(2:86|87)(1:88))|95|63)|103)|105|75|76|77|(0)|(0)|84|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0200, code lost:
        if (com.baidu.swan.apps.ag.a.b.DEBUG != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0202, code lost:
        android.util.Log.e("WebSafeCheckers", android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0217, code lost:
        r1 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean sl(String str) {
        boolean z;
        String host;
        e aGM = e.aGM();
        if (aGM == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!com.baidu.swan.apps.ad.a.a.aDT()) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
            }
            return true;
        }
        boolean afM = com.baidu.swan.apps.t.a.avV().afM();
        if (!afM) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "ABTest : webDomains switch " + afM);
            }
            return true;
        } else if (!aHQ()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
            }
            return true;
        } else {
            String aGO = e.aGO();
            if (!c.ss(aGO)) {
                return true;
            }
            ArrayList<String> ac = aGM.aHg().ac(aGO, false);
            if (lowerCase.startsWith("weixin://wap/pay") && ac.contains("wx.tenpay.com")) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + aGM.getName());
                }
                h.a("wechatH5", str, ac);
                return true;
            } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (ac.contains("*.alipay.com") || ac.contains("*.alipayobjects.com"))) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " name: " + aGM.getName());
                }
                h.a("alipayH5", str, ac);
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
                if (!TextUtils.isEmpty(host) && ac != null) {
                    Iterator<String> it = ac.iterator();
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
                                com.baidu.swan.apps.console.c.i("WebSafeCheckers", "domain is not in white list");
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
                com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain: " + host + ", domains: ", ac);
                com.baidu.swan.apps.console.c.i("WebSafeCheckers", "domain: " + host);
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

    public static boolean sm(String str) {
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aDT()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.w("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e aGM = e.aGM();
            if (aGM == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> gH = aGM.aHg().gH(true);
            if (gH != null && gH.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + gH);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", gH);
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int S(String str, String str2, String str3) {
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
        boolean z2 = !com.baidu.swan.apps.ad.a.a.aDU();
        if (z2) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                return 0;
            }
            return 0;
        }
        boolean aHQ = aHQ();
        if (!aHQ) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + aHQ);
                return 0;
            }
            return 0;
        } else if (sn(str2)) {
            boolean afL = com.baidu.swan.apps.t.a.avV().afL();
            if (!afL) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + afL);
                    return 0;
                }
                return 0;
            }
            e aGM = e.aGM();
            if (aGM == null) {
                return 1;
            }
            String str4 = aGM.id;
            if (TextUtils.isEmpty(str4)) {
                return 1;
            }
            if (!TextUtils.isEmpty(str3)) {
                return !com.baidu.swan.apps.ac.g.a.a(str, str2, com.baidu.swan.apps.ac.g.b.rj(str3)) ? 1 : 0;
            } else if (!new File(c.T(str4, "aiapps_folder/cloud_config", "server_domains.json")).exists()) {
                if (DEBUG) {
                    Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                    return 0;
                }
                return 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    host = new URI(str2).getHost();
                    arrayList = aGM.aHg().n(e.aGO(), str, false).data;
                    z = f(host, arrayList);
                } catch (URISyntaxException e) {
                    e = e;
                    z = false;
                }
                try {
                    com.baidu.swan.apps.console.c.d("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", arrayList);
                    com.baidu.swan.apps.console.c.i("WebSafeCheckers", "domain: " + host);
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
                    com.baidu.swan.apps.console.c.i("WebSafeCheckers", "domain is not in white list");
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
        } else {
            return 2;
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

    private static boolean sn(String str) {
        for (String str2 : dsU) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        if (com.baidu.swan.apps.ad.a.a.aEc()) {
            return true;
        }
        boolean afR = com.baidu.swan.apps.t.a.avV().afR();
        if (DEBUG) {
            Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + afR);
        }
        return !afR && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
    }

    public static boolean so(String str) {
        if (DEBUG && !com.baidu.swan.apps.ad.a.a.aDT()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e aGM = e.aGM();
            if (aGM == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> aHP = aGM.aHg().aHP();
            if (aHP != null && aHP.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + aHP);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
            return false;
        }
    }

    public static boolean aHQ() {
        if (d.aGI().aeW() == 0 && SwanAppConfigData.f.aHG()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
            }
            return false;
        }
        return true;
    }

    public static boolean sp(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay");
    }

    public static boolean sq(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp");
    }
}
