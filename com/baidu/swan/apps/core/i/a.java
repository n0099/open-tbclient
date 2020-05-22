package com.baidu.swan.apps.core.i;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.api.module.network.c;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bZc = null;
    @Nullable
    private volatile String bZd = null;
    @Nullable
    private volatile String bZe = null;
    private volatile boolean bZf = false;

    public static a aaB() {
        if (bZc == null) {
            synchronized (a.class) {
                if (bZc == null) {
                    bZc = new a();
                }
            }
        }
        return bZc;
    }

    private a() {
    }

    public void b(@NonNull final SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("SwanPrelink", "prelinkAsync: start prelinkAsync");
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(swanAppConfigData);
            }
        }, "SwanPrelink");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("SwanPrelink", "start prelink");
        }
        SwanAppConfigData.c cVar = swanAppConfigData.cAB;
        if (cVar == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config is null");
                return;
            }
            return;
        }
        ArrayList<String> arrayList = cVar.cAI;
        if (arrayList == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config urls are null");
                return;
            }
            return;
        }
        int size = arrayList.size();
        if (size <= 0) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config urls are empty");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: urls " + arrayList.toString());
        }
        HttpUrl parse = HttpUrl.parse(arrayList.get(0));
        this.bZd = parse == null ? null : parse.host();
        boolean RH = com.baidu.swan.apps.u.a.aeU().RH();
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: isPrelinkEnable " + RH);
        }
        if (!RH) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: miss prelink");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: hit prelink");
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            if (i >= 1) {
                if (DEBUG) {
                    Log.w("SwanPrelink", "prelink: the number of prelink cannot exceed 1 url: " + str);
                    return;
                }
                return;
            }
            i++;
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.w("SwanPrelink", "prelink: url cannot be empty");
                }
            } else {
                HttpUrl hM = c.hM(str);
                if (hM == null) {
                    if (DEBUG) {
                        Log.w("SwanPrelink", "prelink: url cannot be " + str);
                    }
                } else {
                    String httpUrl = hM.toString();
                    if (com.baidu.swan.apps.ah.a.b.G("request", httpUrl, "") != 0 && DEBUG) {
                        Log.w("SwanPrelink", "prelink: url check fail " + httpUrl);
                    } else {
                        jH(httpUrl);
                    }
                }
            }
        }
    }

    private void jH(@NonNull final String str) {
        if (DEBUG) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a();
        aVar.method = HttpHead.METHOD_NAME;
        HttpRequestBuilder d = com.baidu.swan.c.c.b.d(aVar);
        d.setHeader("Referer", c.Uj());
        aVar.url = str;
        aVar.dld = true;
        aVar.dle = false;
        aVar.dlf = true;
        com.baidu.swan.c.c.a.aFx().a(d, aVar);
        d.enableStat(true).build().executeStat(new StatResponseCallback() { // from class: com.baidu.swan.apps.core.i.a.2
            @Override // com.baidu.searchbox.http.callback.StatResponseCallback
            public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
                if (a.DEBUG) {
                    Log.d("SwanPrelink", "doPrelink: parseResponse: url: " + str + " response: " + (response == null ? "null" : Integer.valueOf(response.code())));
                }
                if (a.DEBUG && networkStatRecord != null) {
                    long j = networkStatRecord.dnsEndTs;
                    long j2 = networkStatRecord.dnsStartTs;
                    long j3 = networkStatRecord.connTs;
                    long j4 = networkStatRecord.startTs;
                    Log.d("SwanPrelink", "doPrelink: hit: url: " + str + " firstPrelinkUrlHost: " + a.this.bZd);
                    Log.d("SwanPrelink", "doPrelink: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                    Log.d("SwanPrelink", "doPrelink: isConnReused: " + networkStatRecord.isConnReused);
                    Log.d("SwanPrelink", "doPrelink: dnsTime: " + (j - j2) + " connTime: " + (j3 - j4));
                }
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.StatResponseCallback
            public void onSuccess(Object obj, int i) {
                if (a.DEBUG) {
                    Log.d("SwanPrelink", "doPrelink: onSuccess: " + i);
                }
            }

            @Override // com.baidu.searchbox.http.callback.StatResponseCallback
            public void onFail(Exception exc) {
                if (a.DEBUG) {
                    Log.d("SwanPrelink", "doPrelink: onFail: " + exc.getMessage());
                }
            }
        });
    }

    public void a(@NonNull String str, @NonNull HttpUrl httpUrl) {
        if (aaC() && this.bZe == null) {
            if (!TextUtils.equals(httpUrl.host(), this.bZd)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.bZd);
                    return;
                }
                return;
            }
            this.bZe = str;
            if (DEBUG) {
                Log.d("SwanPrelink", "onBusinessRequest: hit: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.bZd);
            }
        }
    }

    public void a(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        if (aaC() && !this.bZf && this.bZe != null) {
            if (!TextUtils.equals(this.bZe, str)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "tryRecordNetworkStat: miss : tag: " + str + " firstBusinessRequestTag:" + this.bZe + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.bZd);
                    return;
                }
                return;
            }
            this.bZf = true;
            if (networkStatRecord == null) {
                if (DEBUG) {
                    Log.w("SwanPrelink", "tryRecordNetworkStat: networkStateRecord cannot be null");
                    return;
                }
                return;
            }
            long j = networkStatRecord.dnsEndTs;
            long j2 = networkStatRecord.dnsStartTs;
            long j3 = networkStatRecord.connTs;
            long j4 = networkStatRecord.startTs;
            if (DEBUG) {
                Log.d("SwanPrelink", "tryRecordNetworkStat: hit: tag: " + str + " firstBusinessRequestTag:" + this.bZe + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.bZd);
                Log.d("SwanPrelink", "tryRecordNetworkStat: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                Log.d("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                Log.d("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + (j - j2) + " connTime: " + (j3 - j4));
            }
            g.mp("startup").f(new UbcFlowEvent("request_network_start").bg(j4)).f(new UbcFlowEvent("request_network_conn").bg(j3)).f(new UbcFlowEvent("request_dns_start").bg(j2)).f(new UbcFlowEvent("request_dns_end").bg(j)).f(new UbcFlowEvent("request_network_response").bg(networkStatRecord.responseTs)).f(new UbcFlowEvent("request_send_header").bg(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("request_receive_header").bg(networkStatRecord.receiveHeaderTs));
        }
    }

    public synchronized void release() {
        if (DEBUG) {
            Log.d("SwanPrelink", "release: ");
        }
        if (bZc != null) {
            bZc = null;
        }
    }

    private boolean aaC() {
        return this.bZd != null;
    }
}
