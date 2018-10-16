package com.baidu.searchbox.http.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.request.HttpRequest;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class NetworkStatImpl implements NetworkStat<Request> {
    private Context context;
    private ConcurrentHashMap<Request, NetworkStatRecord> mRequestMap;
    private NetworkInfoRecord networkInfoRecord;
    private boolean shouldStat;

    public NetworkStatImpl(Context context, NetworkInfoRecord networkInfoRecord) {
        boolean z = false;
        this.shouldStat = false;
        this.networkInfoRecord = networkInfoRecord;
        if (networkInfoRecord != null && networkInfoRecord.shouldRecord()) {
            z = true;
        }
        this.shouldStat = z;
        this.mRequestMap = new ConcurrentHashMap<>();
        this.context = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onStartExecute(Request request, long j) {
        if (this.shouldStat) {
            NetworkStatRecord networkStatRecord = new NetworkStatRecord();
            networkStatRecord.url = request.url().toString();
            networkStatRecord.startTs = j;
            this.mRequestMap.put(request, networkStatRecord);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onReceiveRemoteIp(Request request, String str) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.remoteIP = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onReceiveLocalIp(Request request, String str) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.localIP = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onConnect(Request request, long j, String str) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.connTs = j;
            networkStatRecord.protocol = str;
            Object tag = request.tag();
            if (tag instanceof HttpRequest) {
                networkStatRecord.isConnReused = ((HttpRequest) tag).isConnReused;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onDnsParse(Request request, long j, long j2, DnsParseResult dnsParseResult) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.dnsStartTs = j;
            networkStatRecord.dnsEndTs = j2;
            if (dnsParseResult != null) {
                networkStatRecord.dnsDetail = dnsParseResult.toJson();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onSendHeader(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.sendHeaderTs = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onRequestBodyLength(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.requestBodyLength = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onReceiveHeader(Request request, long j, Headers headers) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.receiveHeaderTs = j;
            String str = headers.get(NetworkStatRecord.HEAD_X_BFE_SVBBRERS);
            if (!TextUtils.isEmpty(str)) {
                networkStatRecord.clientIP = str;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onServerErrorHeader(Request request, String str) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.errheaders = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onResponse(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.responseTs = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onResponseBodyLength(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.responseLength = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onStatusCode(Request request, int i) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.statusCode = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onException(Request request, Exception exc) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.exception = exc;
            networkStatRecord.failTs = System.currentTimeMillis();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onFinish(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.finishTs = j;
            if (networkStatRecord.isNeedFinishRightNow()) {
                doRecord(request);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onRedirect(Request request, String str) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.url = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.statistics.NetworkStat
    public void onFinishReadContent(Request request, long j) {
        NetworkStatRecord networkStatRecord;
        if (this.shouldStat && (networkStatRecord = this.mRequestMap.get(request)) != null) {
            networkStatRecord.readOverTs = System.currentTimeMillis();
            networkStatRecord.realResponseLength = j;
            doRecord(request);
        }
    }

    private void doRecord(Request request) {
        NetworkStatRecord networkStatRecord = this.mRequestMap.get(request);
        if (networkStatRecord != null) {
            this.mRequestMap.remove(request);
            networkStatRecord.netType = ConnectManager.getNetworkInfo(this.context);
            if (this.networkInfoRecord != null) {
                this.networkInfoRecord.doRecord(networkStatRecord);
            }
        }
    }
}
