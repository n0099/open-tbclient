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
    private static volatile a cdS = null;
    @Nullable
    private volatile String cdT = null;
    @Nullable
    private volatile String cdU = null;
    private volatile boolean cdV = false;

    public static a abH() {
        if (cdS == null) {
            synchronized (a.class) {
                if (cdS == null) {
                    cdS = new a();
                }
            }
        }
        return cdS;
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
        SwanAppConfigData.c cVar = swanAppConfigData.cFl;
        if (cVar == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config is null");
                return;
            }
            return;
        }
        ArrayList<String> arrayList = cVar.cFs;
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
        this.cdT = parse == null ? null : parse.host();
        boolean SN = com.baidu.swan.apps.u.a.aga().SN();
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: isPrelinkEnable " + SN);
        }
        if (!SN) {
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
                HttpUrl hU = c.hU(str);
                if (hU == null) {
                    if (DEBUG) {
                        Log.w("SwanPrelink", "prelink: url cannot be " + str);
                    }
                } else {
                    String httpUrl = hU.toString();
                    if (com.baidu.swan.apps.ah.a.b.H("request", httpUrl, "") != 0 && DEBUG) {
                        Log.w("SwanPrelink", "prelink: url check fail " + httpUrl);
                    } else {
                        jP(httpUrl);
                    }
                }
            }
        }
    }

    private void jP(@NonNull final String str) {
        if (DEBUG) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a();
        aVar.method = HttpHead.METHOD_NAME;
        HttpRequestBuilder d = com.baidu.swan.c.c.b.d(aVar);
        d.setHeader("Referer", c.Vp());
        aVar.url = str;
        aVar.dpO = true;
        aVar.dpP = false;
        aVar.dpQ = true;
        com.baidu.swan.c.c.a.aGD().a(d, aVar);
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
                    Log.d("SwanPrelink", "doPrelink: hit: url: " + str + " firstPrelinkUrlHost: " + a.this.cdT);
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
        if (abI() && this.cdU == null) {
            if (!TextUtils.equals(httpUrl.host(), this.cdT)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cdT);
                    return;
                }
                return;
            }
            this.cdU = str;
            if (DEBUG) {
                Log.d("SwanPrelink", "onBusinessRequest: hit: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cdT);
            }
        }
    }

    public void a(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        if (abI() && !this.cdV && this.cdU != null) {
            if (!TextUtils.equals(this.cdU, str)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "tryRecordNetworkStat: miss : tag: " + str + " firstBusinessRequestTag:" + this.cdU + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cdT);
                    return;
                }
                return;
            }
            this.cdV = true;
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
                Log.d("SwanPrelink", "tryRecordNetworkStat: hit: tag: " + str + " firstBusinessRequestTag:" + this.cdU + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cdT);
                Log.d("SwanPrelink", "tryRecordNetworkStat: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                Log.d("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                Log.d("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + (j - j2) + " connTime: " + (j3 - j4));
            }
            g.mx("startup").f(new UbcFlowEvent("request_network_start").bg(j4)).f(new UbcFlowEvent("request_network_conn").bg(j3)).f(new UbcFlowEvent("request_dns_start").bg(j2)).f(new UbcFlowEvent("request_dns_end").bg(j)).f(new UbcFlowEvent("request_network_response").bg(networkStatRecord.responseTs)).f(new UbcFlowEvent("request_send_header").bg(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("request_receive_header").bg(networkStatRecord.receiveHeaderTs));
        }
    }

    public synchronized void release() {
        if (DEBUG) {
            Log.d("SwanPrelink", "release: ");
        }
        if (cdS != null) {
            cdS = null;
        }
    }

    private boolean abI() {
        return this.cdT != null;
    }
}
