package com.baidu.swan.apps.core.i;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.p;
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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cTL = null;
    public static final boolean cTQ = com.baidu.swan.apps.t.a.azd().getSwitch("swan_hot_start_prelink_switch", false);
    @Nullable
    private volatile String cTM = null;
    @Nullable
    private volatile String cTN = null;
    private volatile boolean cTO = false;
    private Map<String, String> cTP = new LinkedHashMap();

    public static a aty() {
        if (cTL == null) {
            synchronized (a.class) {
                if (cTL == null) {
                    cTL = new a();
                }
            }
        }
        return cTL;
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
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.i.a.1
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
        SwanAppConfigData.d dVar = swanAppConfigData.dzb;
        if (dVar == null) {
            if (DEBUG) {
                Log.d("SwanPrelink", "prelink: prelink config is null");
            }
            trace("校验失败", "app.json 中未配置 prelinks");
            return;
        }
        ArrayList<String> arrayList = dVar.dzk;
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
        this.cTM = parse == null ? null : parse.host();
        boolean ajl = com.baidu.swan.apps.t.a.azd().ajl();
        if (DEBUG) {
            Log.d("SwanPrelink", "prelink: isPrelinkEnable " + ajl);
        }
        if (!ajl) {
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
                trace("校验失败", "配置的 url 为空");
            } else {
                HttpUrl lQ = c.lQ(str);
                if (lQ == null) {
                    if (DEBUG) {
                        Log.w("SwanPrelink", "prelink: url cannot be " + str);
                    }
                    trace("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                } else {
                    String httpUrl = lQ.toString();
                    if (com.baidu.swan.apps.ag.a.b.V("request", httpUrl, "") != 0) {
                        if (DEBUG) {
                            Log.w("SwanPrelink", "prelink: url check fail " + httpUrl);
                        }
                        trace("校验失败", "配置的 url 非法，参考 request api url 要求。url=" + str);
                    } else {
                        ob(httpUrl);
                    }
                }
            }
        }
    }

    private void ob(@NonNull final String str) {
        if (DEBUG) {
            Log.d("SwanPrelink", "doPrelink: " + str);
        }
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = HttpHead.METHOD_NAME;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        d.setHeader("Referer", c.amq());
        aVar.url = str;
        aVar.emE = true;
        aVar.emF = false;
        aVar.emG = true;
        com.baidu.swan.a.c.a.bdi().a(d, aVar);
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
                        Log.d("SwanPrelink", "doPrelink: hit: url: " + str + " firstPrelinkUrlHost: " + a.this.cTM);
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
        if (atB() && this.cTN == null) {
            if (!TextUtils.equals(httpUrl.host(), this.cTM)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cTM);
                    return;
                }
                return;
            }
            this.cTN = str;
            if (DEBUG) {
                Log.d("SwanPrelink", "onBusinessRequest: hit: tag: " + str + " url: " + httpUrl.toString() + " firstPrelinkUrlHost: " + this.cTM);
            }
            trace("业务方触发第一个同域名请求", "url=" + httpUrl);
        }
    }

    public void a(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        if (atB() && !this.cTO && this.cTN != null) {
            if (!TextUtils.equals(this.cTN, str)) {
                if (DEBUG) {
                    Log.d("SwanPrelink", "tryRecordNetworkStat: miss : tag: " + str + " firstBusinessRequestTag:" + this.cTN + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cTM);
                    return;
                }
                return;
            }
            this.cTO = true;
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
                Log.d("SwanPrelink", "tryRecordNetworkStat: hit: tag: " + str + " firstBusinessRequestTag:" + this.cTN + " url: " + httpUrl + " firstPrelinkUrlHost: " + this.cTM);
                Log.d("SwanPrelink", "tryRecordNetworkStat: networkStatRecord: \n" + networkStatRecord.toUBCJson());
                Log.d("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                Log.d("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + j5 + " connTime: " + j6);
            }
            trace("业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j5 + "ms 网络连接时长=" + j6 + "ms url=" + httpUrl);
            i.rk("startup").f(new UbcFlowEvent("request_network_start").cx(j4)).f(new UbcFlowEvent("request_network_conn").cx(j3)).f(new UbcFlowEvent("request_dns_start").cx(j2)).f(new UbcFlowEvent("request_dns_end").cx(j)).f(new UbcFlowEvent("request_network_response").cx(networkStatRecord.responseTs)).f(new UbcFlowEvent("request_send_header").cx(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("request_receive_header").cx(networkStatRecord.receiveHeaderTs));
        }
    }

    public synchronized void release() {
        if (DEBUG) {
            Log.d("SwanPrelink", "release: ");
        }
        if (cTL != null) {
            cTL = null;
        }
    }

    public void atz() {
        if (DEBUG) {
            this.cTN = null;
            this.cTO = false;
            this.cTM = null;
        }
    }

    public synchronized void trace(@NonNull String str, @NonNull String str2) {
        if (!this.cTP.containsKey(str)) {
            this.cTP.put(str, str2);
            e.dIk.aa(atA());
        }
    }

    @NonNull
    private synchronized String atA() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("========== prelink start ==========").append("\r\n");
        for (Map.Entry<String, String> entry : this.cTP.entrySet()) {
            if (entry != null) {
                sb.append("----- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n\r\n");
            }
        }
        sb.append("========== prelink end ==========").append("\r\n");
        return sb.toString();
    }

    private boolean atB() {
        return this.cTM != null;
    }
}
