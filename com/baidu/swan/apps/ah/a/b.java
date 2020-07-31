package com.baidu.swan.apps.ah.a;

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
    private static final Set<String> cIT = i.O("https", "wss");

    /* JADX WARN: Can't wrap try/catch for region: R(11:58|59|(3:62|(4:65|(1:102)(8:67|68|(3:96|97|(2:99|100)(1:101))(3:70|71|(2:73|74)(1:94))|77|(1:(1:80)(1:81))|(1:83)|84|(2:86|87)(1:88))|95|63)|103)|105|75|76|77|(0)|(0)|84|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01f7, code lost:
        if (com.baidu.swan.apps.ah.a.b.DEBUG != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f9, code lost:
        android.util.Log.e("WebSafeCheckers", android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x020e, code lost:
        r1 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean oG(String str) {
        boolean z;
        String host;
        e arv = e.arv();
        if (arv == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!com.baidu.swan.apps.ae.a.a.aoQ()) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
            }
            return true;
        }
        boolean SK = com.baidu.swan.apps.t.a.ahm().SK();
        if (!SK) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "ABTest : webDomains switch " + SK);
            }
            return true;
        } else if (!asA()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
            }
            return true;
        } else {
            String arx = e.arx();
            if (!c.oM(arx)) {
                return true;
            }
            ArrayList<String> R = arv.arP().R(arx, false);
            if (lowerCase.startsWith("weixin://wap/pay") && R.contains("wx.tenpay.com")) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + arv.getName());
                }
                h.a("wechatH5", str, R);
                return true;
            } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (R.contains("*.alipay.com") || R.contains("*.alipayobjects.com"))) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " name: " + arv.getName());
                }
                h.a("alipayH5", str, R);
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
                if (!TextUtils.isEmpty(host) && R != null) {
                    Iterator<String> it = R.iterator();
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
                com.baidu.swan.apps.console.c.c("WebSafeCheckers", "domain: " + host + ", domains: ", R);
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

    public static boolean oH(String str) {
        if (DEBUG && !com.baidu.swan.apps.ae.a.a.aoQ()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.w("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e arv = e.arv();
            if (arv == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> fu = arv.arP().fu(true);
            if (fu != null && fu.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + fu);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.c("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", fu);
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int H(String str, String str2, String str3) {
        boolean z;
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
        boolean z2 = !com.baidu.swan.apps.ae.a.a.aoR();
        if (z2) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                return 0;
            }
            return 0;
        }
        boolean asA = asA();
        if (!asA) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + asA);
                return 0;
            }
            return 0;
        } else if (!oI(str2)) {
            return 2;
        } else {
            boolean SJ = com.baidu.swan.apps.t.a.ahm().SJ();
            if (!SJ) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + SJ);
                    return 0;
                }
                return 0;
            }
            e arv = e.arv();
            if (arv == null) {
                return 1;
            }
            String str4 = arv.id;
            if (TextUtils.isEmpty(str4)) {
                return 1;
            }
            if (!TextUtils.isEmpty(str3)) {
                return !com.baidu.swan.apps.ad.g.a.a(str, str2, com.baidu.swan.apps.ad.g.b.nE(str3)) ? 1 : 0;
            } else if (!new File(c.I(str4, "aiapps_folder/cloud_config", "server_domains.json")).exists()) {
                if (DEBUG) {
                    Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                    return 0;
                }
                return 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    String host = new URI(str2).getHost();
                    ArrayList<String> arrayList = arv.arP().m(e.arx(), str, false).data;
                    z = f(host, arrayList);
                    try {
                        com.baidu.swan.apps.console.c.c("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", arrayList);
                        com.baidu.swan.apps.console.c.i("WebSafeCheckers", "domain: " + host);
                    } catch (URISyntaxException e) {
                        e = e;
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
                } catch (URISyntaxException e2) {
                    e = e2;
                    z = false;
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

    private static boolean oI(String str) {
        for (String str2 : cIT) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        if (com.baidu.swan.apps.ae.a.a.aoZ()) {
            return true;
        }
        boolean SP = com.baidu.swan.apps.t.a.ahm().SP();
        if (DEBUG) {
            Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + SP);
        }
        return !SP && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
    }

    public static boolean oJ(String str) {
        if (DEBUG && !com.baidu.swan.apps.ae.a.a.aoQ()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e arv = e.arv();
            if (arv == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> asz = arv.arP().asz();
            if (asz != null && asz.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + asz);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.i("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
            return false;
        }
    }

    public static boolean asA() {
        if (d.arr().RU() == 0 && SwanAppConfigData.f.asq()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
            }
            return false;
        }
        return true;
    }

    public static boolean oK(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay");
    }

    public static boolean oL(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp");
    }
}
