package com.baidu.searchbox.network.outback.statistics;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yy.gslbsdk.db.ProbeTB;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NetworkStatRecord {
    public static final int DEFAULT_FROM_ID = 0;
    public static final int DEFAULT_SUBFROM_ID = 0;
    public static final String HEAD_X_BFE_SVBBRERS = "X-Bfe-Svbbrers";
    public long appLaunchTimestamp;
    public String bdTraceId;
    public String clientIP;
    public String clientIPv6;
    public String contentType;
    public String errheaders;
    public Exception exception;
    public JSONObject extraUserInfo;
    public String freeCardIsp;
    public String freeCardProduct;
    public String httpDnsAreaInfo;
    public long httpDnsAreaInfoLastUpdateTime;
    public int ipStack;
    public boolean isConnReused;
    public boolean isProxyConnect;
    public boolean isVPNConnect;
    public List<String> localDnsIpList;
    public String localIP;
    public String netType;
    public int networkQuality;
    public String processName;
    public String protocol;
    public String proxyAddress;
    public String proxyHostString;
    public String remoteIP;
    public String url;
    public boolean useFallbackConn;
    public long startTs = -1;
    public long tcpStartTs = -1;
    public long tcpEndTs = -1;
    public long sslStartTs = -1;
    public long sslEndSTs = -1;
    public long connTs = -1;
    public long responseTs = -1;
    public long finishTs = -1;
    public long getNetworkInfoTs = -1;
    public long failTs = -1;
    public long sendHeaderTs = -1;
    public long receiveHeaderTs = -1;
    public JSONObject dnsDetail = new JSONObject();
    public int statusCode = -1;
    public long responseLength = 0;
    public long requestBodyLength = 0;
    public long realResponseLength = 0;
    public long readOverTs = -1;
    public int netEngine = -1;
    public int from = 0;
    public int subFrom = 0;
    public boolean isConnected = true;
    public long callStartTimeStamp = -1;
    public long callEndTimeStamp = -1;
    public long switchThreadStart = -1;
    public long switchThreadEnd = -1;
    public long switchThreadInQueue = -1;
    public long dnsStartTs = -1;
    public long dnsEndTs = -1;
    public long dnsTs = -1;

    private JSONObject deepCopyDnsDetail(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
        }
        return jSONObject2;
    }

    private String getExceptionMsg(Throwable th) {
        if (th == null || th.getMessage() == null) {
            return "";
        }
        return th.getMessage();
    }

    private String getStackTraceString(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        if (th == null) {
            return "";
        }
        PrintWriter printWriter2 = null;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable th3) {
            th = th3;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    public long getDnsTime() {
        long j = this.dnsTs;
        if (j == -1) {
            return this.dnsEndTs - this.dnsStartTs;
        }
        return j;
    }

    public String toString() {
        long j;
        long j2;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkStatRecord{, netEngine=");
        sb.append(this.netEngine);
        sb.append("，url=");
        sb.append(this.url);
        sb.append(", protocol=");
        sb.append(this.protocol);
        sb.append(", netType=");
        sb.append(this.netType);
        sb.append(", startTs=");
        sb.append(this.startTs);
        sb.append(", tcpStartTs");
        sb.append(this.tcpStartTs);
        sb.append(", tcpEndTs");
        sb.append(this.tcpEndTs);
        sb.append(", sslStartTs");
        sb.append(this.tcpStartTs);
        sb.append(", sslEndTs");
        sb.append(this.sslEndSTs);
        sb.append(", connTs=");
        sb.append(this.connTs);
        sb.append(", dnsStartTs=");
        sb.append(this.dnsStartTs);
        sb.append(", dnsEndTs=");
        sb.append(this.dnsEndTs);
        sb.append(", dnsTs=");
        sb.append(this.dnsTs);
        sb.append(", dnsDetail=");
        sb.append(this.dnsDetail.toString());
        sb.append(", responseTs=");
        sb.append(this.responseTs);
        sb.append(", sendHeaderTs=");
        sb.append(this.sendHeaderTs);
        sb.append(", receiveHeaderTs=");
        sb.append(this.receiveHeaderTs);
        sb.append(", finishTs=");
        sb.append(this.finishTs);
        sb.append(", getNetworkInfoTs=");
        sb.append(this.getNetworkInfoTs);
        sb.append(", failTs=");
        sb.append(this.failTs);
        sb.append(", responseLength=");
        sb.append(this.responseLength);
        sb.append(", requestBodyLength=");
        sb.append(this.requestBodyLength);
        sb.append(", remoteIP=");
        sb.append(this.remoteIP);
        sb.append(", localIP=");
        sb.append(this.localIP);
        sb.append(", connectConsume=");
        long j3 = this.connTs;
        if (j3 <= 0) {
            j = 0;
        } else {
            j = j3 - this.startTs;
        }
        sb.append(j);
        sb.append(", responseConsume=");
        long j4 = this.connTs;
        if (j4 <= 0) {
            j2 = this.responseTs - this.startTs;
        } else {
            j2 = this.responseTs - j4;
        }
        sb.append(j2);
        sb.append(", totalConsume=");
        sb.append(this.responseTs - this.startTs);
        sb.append(", errheaders=");
        sb.append(this.errheaders);
        sb.append(", excetion=");
        sb.append(getStackTraceString(this.exception));
        sb.append(", exceptionMsg=");
        sb.append(getExceptionMsg(this.exception));
        sb.append(", clientIP=");
        sb.append(this.clientIP);
        sb.append(", clientIPv6=");
        sb.append(this.clientIPv6);
        sb.append(", isConnReused=");
        if (this.isConnReused) {
            str = "1";
        } else {
            str = "0";
        }
        sb.append(str);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", realResponseLength=");
        sb.append(this.realResponseLength);
        sb.append(", readOverTime=");
        sb.append(this.readOverTs);
        sb.append(", from=");
        sb.append(this.from);
        sb.append(", subFrom=");
        sb.append(this.subFrom);
        sb.append(", networkQuality=");
        sb.append(this.networkQuality);
        sb.append(", ipStack=");
        sb.append(this.ipStack);
        sb.append(", isConnected=");
        sb.append(this.isConnected);
        sb.append(", isVPNConnect=");
        sb.append(this.isVPNConnect);
        sb.append(", isProxyConnect=");
        sb.append(this.isProxyConnect);
        sb.append(", proxyHost = ");
        sb.append(this.proxyHostString);
        sb.append(", proxyAddress = ");
        sb.append(this.proxyAddress);
        sb.append(", httpDnsAreaInfo=");
        sb.append(this.httpDnsAreaInfo);
        sb.append(", httpDnsAreaUpdateTime=");
        sb.append(this.httpDnsAreaInfoLastUpdateTime);
        sb.append(", processName=");
        sb.append(this.processName);
        sb.append(", appLaunchTimestamp=");
        sb.append(this.appLaunchTimestamp);
        sb.append(", callStartTimeStamp=");
        sb.append(this.callStartTimeStamp);
        sb.append(", callEndTimeStamp=");
        sb.append(this.callEndTimeStamp);
        sb.append(", switchThreadStart=");
        sb.append(this.switchThreadStart);
        sb.append(", switchThreadEnd=");
        sb.append(this.switchThreadEnd);
        sb.append(", switchThreadInQueue=");
        sb.append(this.switchThreadInQueue);
        sb.append(", extraUserInfo=");
        JSONObject jSONObject = this.extraUserInfo;
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", freeCardProduct=");
        sb.append(this.freeCardProduct);
        sb.append(", freeCardIsp=");
        sb.append(this.freeCardIsp);
        sb.append('}');
        return sb.toString();
    }

    public JSONObject toUBCJson() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 2);
            jSONObject.put("type", "common");
            if (!TextUtils.isEmpty(this.url)) {
                jSONObject.put("url", this.url);
            }
            if (!TextUtils.isEmpty(this.protocol)) {
                jSONObject.put(ProbeTB.PROTOCOL, this.protocol);
            }
            if (!TextUtils.isEmpty(this.netType)) {
                jSONObject.put("netType", this.netType);
            }
            if (this.startTs != -1) {
                jSONObject.put("startTime", this.startTs);
            }
            if (this.tcpStartTs != -1) {
                jSONObject.put("tcpStartTime", this.tcpStartTs);
            }
            if (this.tcpEndTs != -1) {
                jSONObject.put("tcpEndTime", this.tcpEndTs);
            }
            if (this.sslStartTs != -1) {
                jSONObject.put("sslStartTime", this.sslStartTs);
            }
            if (this.sslEndSTs != -1) {
                jSONObject.put("sslEndTime", this.sslEndSTs);
            }
            if (this.connTs != -1) {
                jSONObject.put("connectedTime", this.connTs);
            }
            if (this.dnsStartTs != -1) {
                jSONObject.put("dnsStartTime", this.dnsStartTs);
            }
            if (this.dnsEndTs != -1) {
                jSONObject.put("dnsEndTime", this.dnsEndTs);
            }
            if (this.dnsTs != -1) {
                jSONObject.put("dnsTtme", this.dnsTs);
            }
            JSONObject deepCopyDnsDetail = deepCopyDnsDetail(this.dnsDetail);
            if (this.dnsDetail != null) {
                jSONObject.put("dnsDetail", deepCopyDnsDetail);
            }
            if (this.localDnsIpList != null && !this.localDnsIpList.isEmpty()) {
                jSONObject.put("localDnsIpList", new JSONArray((Collection) this.localDnsIpList));
            }
            if (this.sendHeaderTs != -1) {
                jSONObject.put("sendHeaderTime", this.sendHeaderTs);
            }
            if (this.receiveHeaderTs != -1) {
                jSONObject.put("receiveHeaderTime", this.receiveHeaderTs);
            }
            if (this.responseTs != -1) {
                jSONObject.put("responseTime", this.responseTs);
            }
            if (this.finishTs != -1) {
                jSONObject.put("finishedTime", this.finishTs);
            }
            if (this.getNetworkInfoTs != -1) {
                jSONObject.put("getNetworkInfoTs", this.getNetworkInfoTs);
            }
            if (this.failTs != -1) {
                jSONObject.put("failTime", this.failTs);
            }
            if (!TextUtils.isEmpty(getStackTraceString(this.exception))) {
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, getStackTraceString(this.exception));
                jSONObject.put("exceptionMsg", getExceptionMsg(this.exception));
            }
            if (this.statusCode != -1) {
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, this.statusCode);
            }
            if (!TextUtils.isEmpty(this.localIP)) {
                jSONObject.put("localIP", this.localIP);
            }
            if (!TextUtils.isEmpty(this.remoteIP)) {
                jSONObject.put("remoteIP", this.remoteIP);
            }
            if (!TextUtils.isEmpty(this.errheaders)) {
                jSONObject.put("header", this.errheaders);
            }
            jSONObject.put("responseLength", this.responseLength);
            jSONObject.put("requestBodyLength", this.requestBodyLength);
            if (!TextUtils.isEmpty(this.clientIP)) {
                jSONObject.put("clientIP", this.clientIP);
            }
            if (!TextUtils.isEmpty(this.clientIPv6)) {
                jSONObject.put("clientIPv6", this.clientIPv6);
            }
            if (!TextUtils.isEmpty(this.contentType)) {
                jSONObject.put("Content-Type", this.contentType);
            }
            if (this.realResponseLength > 0) {
                jSONObject.put("realResponseLength", this.realResponseLength);
            }
            if (this.realResponseLength > 0 && this.readOverTs != -1) {
                jSONObject.put("readOverTime", this.readOverTs);
            }
            if (this.netEngine != -1) {
                jSONObject.put("netEngine", this.netEngine);
            }
            jSONObject.put("from", this.from);
            jSONObject.put("subFrom", this.subFrom);
            String str = "1";
            if (this.isConnReused) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("socketReuse", obj);
            jSONObject.put(CloudStabilityUBCUtils.KEY_WEAK_QUALITY, this.networkQuality);
            if (this.extraUserInfo != null) {
                jSONObject.put("user_log", this.extraUserInfo.toString());
            }
            jSONObject.put("ipStack", this.ipStack);
            if (this.useFallbackConn) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            jSONObject.put("useFallback", obj2);
            if (!TextUtils.isEmpty(this.bdTraceId)) {
                jSONObject.put("bdTraceId", this.bdTraceId);
            }
            if (this.isConnected) {
                obj3 = "1";
            } else {
                obj3 = "0";
            }
            jSONObject.put("isConnected", obj3);
            if (this.isVPNConnect) {
                obj4 = "1";
            } else {
                obj4 = "0";
            }
            jSONObject.put("viaVPN", obj4);
            if (!this.isProxyConnect) {
                str = "0";
            }
            jSONObject.put("viaProxy", str);
            if (this.isProxyConnect) {
                if (this.proxyHostString != null) {
                    jSONObject.put("proxyHost", this.proxyHostString);
                }
                if (this.proxyAddress != null) {
                    jSONObject.put("proxyAddress", this.proxyAddress);
                }
            }
            if (!TextUtils.isEmpty(this.httpDnsAreaInfo)) {
                jSONObject.put("httpDnsAreaInfo", this.httpDnsAreaInfo);
                jSONObject.put("httpDnsAreaUpdateTime", this.httpDnsAreaInfoLastUpdateTime);
            }
            if (!TextUtils.isEmpty(this.processName)) {
                jSONObject.put("processName", this.processName);
            }
            if (this.appLaunchTimestamp > 0) {
                jSONObject.put("appLaunchTimestamp", this.appLaunchTimestamp);
            }
            if (this.callStartTimeStamp != -1) {
                jSONObject.put("callStartTimeStamp", this.callStartTimeStamp);
            }
            if (this.callEndTimeStamp != -1) {
                jSONObject.put("callEndTimeStamp", this.callEndTimeStamp);
            }
            if (this.switchThreadStart != -1) {
                jSONObject.put("switchThreadStart", this.switchThreadStart);
            }
            if (this.switchThreadEnd != -1) {
                jSONObject.put("switchThreadEnd", this.switchThreadEnd);
            }
            if (this.switchThreadInQueue != -1) {
                jSONObject.put("switchThreadInQueue", this.switchThreadInQueue);
            }
            if (this.freeCardProduct != null || this.freeCardIsp != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("product", this.freeCardProduct);
                jSONObject2.put("isp", this.freeCardIsp);
                jSONObject.put("freeCard", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
