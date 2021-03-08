package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.api.module.network.c;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cXI = null;
    public static final boolean cXN = com.baidu.swan.apps.t.a.axc().getSwitch("swan_hot_start_prelink_switch", false);
    @Nullable
    private volatile String cXJ = null;
    @Nullable
    private volatile String cXK = null;
    private volatile boolean cXL = false;
    private Map<String, String> cXM = new LinkedHashMap();

    public static a arw() {
        if (cXI == null) {
            synchronized (a.class) {
                if (cXI == null) {
                    cXI = new a();
                }
            }
        }
        return cXI;
    }

    private a() {
    }

    public void b(final SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("SwanPrelink", "prelinkAsync: start prelinkAsync");
        }
        if (swanAppConfigData == null) {
            if (DEBUG) {
                throw new RuntimeException("prelinkAsync: configData cannot be null");
            }
            return;
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.i.a.1
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
        SwanAppConfigData.d dVar = swanAppConfigData.dGz;
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config is null");
            }
            trace("校验失败", "app.json 中未配置 prelinks");
            return;
        }
        ArrayList<String> arrayList = dVar.dGI;
        if (arrayList == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config urls are null");
            }
            trace("校验失败", "app.json 中未配置 prelinks");
            return;
        }
        int size = arrayList.size();
        if (size <= 0) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config urls are empty");
            }
            trace("校验失败", "配置的 prelinks 内容为空");
            return;
        }
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: urls " + arrayList.toString());
        }
        HttpUrl parse = HttpUrl.parse(arrayList.get(0));
        this.cXJ = parse == null ? null : parse.host();
        boolean ahb = com.baidu.swan.apps.t.a.axc().ahb();
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: isPrelinkEnable " + ahb);
        }
        if (!ahb) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: miss prelink");
            }
            trace("校验失败", "未命中 prelink ab 开关");
            return;
        }
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: hit prelink");
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            String str = arrayList.get(i);
            if (i2 >= 1) {
                if (DEBUG) {
                    Log.w("SwanPrelink", "prelink: the number of prelink cannot exceed 1 url: " + str);
                    return;
                }
                return;
            }
            int i3 = i2 + 1;
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.w("SwanPrelink", "prelink: url cannot be empty");
                }
                trace("校验失败", "配置的 url 为空");
            } else {
                HttpUrl kX = c.kX(str);
                if (kX == null) {
                    if (DEBUG) {
                        Log.w("SwanPrelink", "prelink: url cannot be " + str);
                    }
                    trace("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                } else {
                    String httpUrl = kX.toString();
                    if (com.baidu.swan.apps.af.a.b.Y("request", httpUrl, "") != 0) {
                        if (DEBUG) {
                            Log.w("SwanPrelink", "prelink: url check fail " + httpUrl);
                        }
                        trace("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                    } else {
                        ni(httpUrl);
                    }
                }
            }
            i++;
            i2 = i3;
        }
    }

    private void ni(@NonNull final String str) {
        if (DEBUG) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = HttpHead.METHOD_NAME;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        d.setHeader("Referer", c.aki());
        aVar.url = str;
        aVar.evi = true;
        aVar.evj = false;
        aVar.evk = true;
        com.baidu.swan.a.c.a.bca().a(d, aVar);
        HttpRequest build = d.enableStat(true).build();
        trace("校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
        build.executeStat(new StatResponseCallback() { // from class: com.baidu.swan.apps.core.i.a.2
            @Override // com.baidu.searchbox.http.callback.StatResponseCallback
            public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
                if (a.DEBUG) {
                    Log.d("SwanPrelink", "doPrelink: parseResponse: url: " + str + " response: " + (response == null ? "null" : Integer.valueOf(response.code())));
                }
                if (networkStatRecord != null) {
                    long j = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                    long j2 = networkStatRecord.connTs - networkStatRecord.startTs;
                    if (a.DEBUG) {
                        Log.d("SwanPrelink", "doPrelink: hit: url: " + str + " firstPrelinkUrlHost: " + a.this.cXJ);
                        Log.d("SwanPrelink", "doPrelink: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                        Log.d("SwanPrelink", "doPrelink: isConnReused: " + networkStatRecord.isConnReused);
                        Log.d("SwanPrelink", "doPrelink: dnsTime: " + j + " connTime: " + j2);
                    }
                    int i2 = 0;
                    if (response != null) {
                        i2 = response.code();
                    }
                    a.this.trace("预连接请求返回", "code=" + i2 + " dns解析时长=" + j + "ms 网络连接时长=" + j2 + "ms url=" + str);
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
        if (arz() && this.cXK == null) {
            if (!TextUtils.equals(httpUrl.host(), this.cXJ)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cXJ);
                    return;
                }
                return;
            }
            this.cXK = str;
            if (DEBUG) {
                Log.d("SwanPrelink", "onBusinessRequest: hit: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cXJ);
            }
            trace("业务方触发第一个同域名请求", "url=" + httpUrl);
        }
    }

    public void a(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        if (arz() && !this.cXL && this.cXK != null) {
            if (!TextUtils.equals(this.cXK, str)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "tryRecordNetworkStat: miss : tag: " + str + " firstBusinessRequestTag:" + this.cXK + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cXJ);
                    return;
                }
                return;
            }
            this.cXL = true;
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
            long j5 = j - j2;
            long j6 = j3 - j4;
            if (DEBUG) {
                Log.d("SwanPrelink", "tryRecordNetworkStat: hit: tag: " + str + " firstBusinessRequestTag:" + this.cXK + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cXJ);
                Log.d("SwanPrelink", "tryRecordNetworkStat: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                Log.d("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                Log.d("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + j5 + " connTime: " + j6);
            }
            trace("业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j5 + "ms 网络连接时长=" + j6 + "ms url=" + httpUrl);
            i.qr("startup").f(new UbcFlowEvent("request_network_start").cE(j4)).f(new UbcFlowEvent("request_network_conn").cE(j3)).f(new UbcFlowEvent("request_dns_start").cE(j2)).f(new UbcFlowEvent("request_dns_end").cE(j)).f(new UbcFlowEvent("request_network_response").cE(networkStatRecord.responseTs)).f(new UbcFlowEvent("request_send_header").cE(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("request_receive_header").cE(networkStatRecord.receiveHeaderTs));
        }
    }

    public synchronized void release() {
        if (DEBUG) {
            Log.d("SwanPrelink", "release: ");
        }
        if (cXI != null) {
            cXI = null;
        }
    }

    public void arx() {
        if (DEBUG) {
            this.cXK = null;
            this.cXL = false;
            this.cXJ = null;
        }
    }

    public synchronized void trace(@NonNull String str, @NonNull String str2) {
        if (!this.cXM.containsKey(str)) {
            this.cXM.put(str, str2);
            e.dPI.ad(ary());
        }
    }

    @NonNull
    private synchronized String ary() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("========== prelink start ==========").append("\r\n");
        for (Map.Entry<String, String> entry : this.cXM.entrySet()) {
            if (entry != null) {
                sb.append("----- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n\r\n");
            }
        }
        sb.append("========== prelink end ==========").append("\r\n");
        return sb.toString();
    }

    private boolean arz() {
        return this.cXJ != null;
    }
}
