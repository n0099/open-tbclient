package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.c;
import com.baidu.swan.apps.statistic.e;
import com.facebook.common.internal.h;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aSf = h.M("https", "wss");

    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean gV(String str) {
        MalformedURLException e;
        boolean z;
        if (DEBUG && !com.baidu.swan.apps.ac.a.a.IZ()) {
            Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
            return true;
        }
        boolean wq = com.baidu.swan.apps.u.a.Er().wq();
        if (!wq) {
            Log.w("WebSafeCheckers", "ABTest : webDomains switch " + wq);
            return true;
        } else if (!MP()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
                return true;
            }
            return true;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.w("WebSafeCheckers", "checkWebDomain: url is empty");
                }
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("weixin://wap/pay")) {
                com.baidu.swan.apps.console.c.d("WebSafeCheckers", "url is weixin pay, Domain in white list");
                e.hu("wechatH5");
                z = true;
            } else if (lowerCase.startsWith("alipays://platformapi/startapp")) {
                com.baidu.swan.apps.console.c.d("WebSafeCheckers", "url is ali pay, Domain in white list");
                e.hu("alipayH5");
                z = true;
            } else {
                try {
                    String host = new URL(str).getHost();
                    com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                    if (Mh == null) {
                        return false;
                    }
                    ArrayList<String> u = Mh.Mu().u(com.baidu.swan.apps.ae.b.Ms(), false);
                    if (!TextUtils.isEmpty(host) && u != null) {
                        Iterator<String> it = u.iterator();
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
                            }
                        }
                    }
                    z = false;
                    try {
                        if (DEBUG) {
                            Log.d("WebSafeCheckers", "domain: " + host + ", domains: " + u);
                        }
                        com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain: " + host);
                    } catch (MalformedURLException e2) {
                        e = e2;
                        if (DEBUG) {
                            Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                        }
                        if (DEBUG) {
                        }
                        if (!z) {
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (DEBUG) {
                        }
                        return z;
                    }
                } catch (MalformedURLException e3) {
                    e = e3;
                    z = false;
                }
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
            long currentTimeMillis22 = System.currentTimeMillis();
            if (DEBUG) {
                Log.d("WebSafeCheckers", "checkWebDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
            }
            return z;
        }
    }

    public static boolean gW(String str) {
        if (DEBUG && !com.baidu.swan.apps.ac.a.a.IZ()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkWebAction: action is empty");
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> cu = Mh.Mu().cu(true);
            if (cu != null && cu.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + cu);
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.d("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=" + cu);
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean av(String str, String str2) {
        boolean z;
        String host;
        ArrayList<String> arrayList;
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "server domains: requestName or requestUrl is empty");
            }
            return false;
        }
        if (DEBUG) {
            Log.i("WebSafeCheckers", "requestName : " + str);
            Log.i("WebSafeCheckers", "requestUrl : " + str2);
        }
        boolean z3 = DEBUG && !com.baidu.swan.apps.ac.a.a.Ja();
        if (z3) {
            Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z3);
            return true;
        }
        boolean MP = MP();
        if (!MP) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + MP);
            }
            return true;
        } else if (!gX(str2)) {
            return false;
        } else {
            boolean wp = com.baidu.swan.apps.u.a.Er().wp();
            if (!wp) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + wp);
                }
                return true;
            }
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh == null) {
                return false;
            }
            String str3 = Mh.id;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (!new File(c.r(str3, "aiapps_folder/cloud_config", "server_domains.json")).exists()) {
                if (DEBUG) {
                    Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                }
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                host = new URI(str2).getHost();
                arrayList = Mh.Mu().g(com.baidu.swan.apps.ae.b.Ms(), str, false).data;
            } catch (URISyntaxException e) {
                if (DEBUG) {
                }
                z = z2;
            }
            if (!TextUtils.isEmpty(host) && arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (next != null) {
                        if (next.startsWith("*.")) {
                            if (host.endsWith(next.substring("*.".length()))) {
                                z2 = true;
                                break;
                            }
                        } else if (TextUtils.equals(host, next)) {
                            z2 = true;
                            break;
                        }
                        if (DEBUG) {
                            Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                        }
                        z = z2;
                        if (!z) {
                            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain is not in white list");
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (!DEBUG) {
                            Log.d("WebSafeCheckers", "serverDomain: cost time = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                            if (z) {
                                Log.d("WebSafeCheckers", "serverDomain in white list");
                                return z;
                            }
                            Log.d("WebSafeCheckers", "serverDomain not in white list");
                            return z;
                        }
                        return z;
                    }
                }
            }
            if (DEBUG) {
                Log.d("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: " + arrayList);
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "domain: " + host);
            z = z2;
            if (!z) {
            }
            long currentTimeMillis22 = System.currentTimeMillis();
            if (!DEBUG) {
            }
        }
    }

    private static boolean gX(String str) {
        for (String str2 : aSf) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        boolean wA = com.baidu.swan.apps.u.a.Er().wA();
        if (DEBUG) {
            Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + wA);
        }
        return !wA && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
    }

    public static boolean gY(String str) {
        if (DEBUG && !com.baidu.swan.apps.ac.a.a.IZ()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeCheckers", "checkAdLandingWebAction: action is empty");
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh == null) {
                com.baidu.swan.apps.console.c.w("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> MO = Mh.Mu().MO();
            if (MO != null && MO.contains(str)) {
                if (DEBUG) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + ", " + MO);
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.console.c.d("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
            return false;
        }
    }

    public static boolean MP() {
        if (com.baidu.swan.apps.ae.b.vH() == 0 && c.b.MF()) {
            if (DEBUG) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
            }
            return false;
        }
        return true;
    }
}
