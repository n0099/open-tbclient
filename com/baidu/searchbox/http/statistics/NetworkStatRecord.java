package com.baidu.searchbox.http.statistics;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NetworkStatRecord {
    public static final int DEFAULT_FROM_ID = 0;
    public static final int DEFAULT_SUBFROM_ID = 0;
    public static final String HEAD_X_BFE_SVBBRERS = "X-Bfe-Svbbrers";
    public List<InetAddress> addressList;
    public String bdTraceId;
    public String clientIP;
    public String errheaders;
    public Exception exception;
    public JSONObject extraUserInfo;
    public String httpDnsAreaInfo;
    public long httpDnsAreaInfoLastUpdateTime;
    public int ipStack;
    public boolean isConnReused;
    public boolean isConnected;
    public boolean isProxyConnect;
    public boolean isVPNConnect;
    public String localIP;
    public String netType;
    public int networkQuality;
    public int networkQualityFrom;
    public String protocol;
    public String remoteIP;
    public JSONObject sdtProbeErrorCode;
    public String url;
    public boolean useFallbackConn;
    public long startTs = -1;
    public long connTs = -1;
    public long responseTs = -1;
    public long finishTs = -1;
    public long failTs = -1;
    public long sendHeaderTs = -1;
    public long receiveHeaderTs = -1;
    public long dnsStartTs = -1;
    public long dnsEndTs = -1;
    public JSONObject dnsDetail = new JSONObject();
    public int statusCode = -1;
    public long responseLength = 0;
    public long requestBodyLength = 0;
    public long realResponseLength = 0;
    public long readOverTs = -1;
    public int netEngine = -1;
    public int from = 0;
    public int subFrom = 0;

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

    private JSONArray parseAddressList() {
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : this.addressList) {
            if (!TextUtils.isEmpty(inetAddress.getHostAddress())) {
                arrayList.add(inetAddress.getHostAddress());
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    public boolean isNeedFinishRightNow() {
        return (this.exception == null && this.statusCode == 200) ? false : true;
    }

    public String toString() {
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
        sb.append(", connTs=");
        sb.append(this.connTs);
        sb.append(", dnsStartTs=");
        sb.append(this.dnsStartTs);
        sb.append(", dnsEndTs=");
        sb.append(this.dnsEndTs);
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
        sb.append(this.connTs - this.startTs);
        sb.append(", responseConsume=");
        sb.append(this.responseTs - this.connTs);
        sb.append(", totalConsume=");
        sb.append(this.responseTs - this.startTs);
        sb.append(", headers=");
        sb.append(this.errheaders);
        sb.append(", excetion=");
        sb.append(getStackTraceString(this.exception));
        sb.append(", clientIP=");
        sb.append(this.clientIP);
        sb.append(", isConnReused=");
        sb.append(this.isConnReused ? "1" : "0");
        sb.append(", realResponseLength=");
        sb.append(this.realResponseLength);
        sb.append(", readOverTime=");
        sb.append(this.readOverTs);
        sb.append(", from=");
        sb.append(this.from);
        sb.append(", subFrom=");
        sb.append(this.subFrom);
        sb.append(", extraUserInfo=");
        JSONObject jSONObject = this.extraUserInfo;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        sb.append(", ipStack=");
        sb.append(this.ipStack);
        sb.append(", isVPNConnect=");
        sb.append(this.isVPNConnect);
        sb.append(", isProxyConnect=");
        sb.append(this.isProxyConnect);
        sb.append(", networkQuality=");
        sb.append(this.networkQuality);
        sb.append(", sdtProbeErrorCode=");
        JSONObject jSONObject2 = this.sdtProbeErrorCode;
        sb.append(jSONObject2 != null ? jSONObject2.toString() : "");
        sb.append(", networkQualityFrom=");
        sb.append(this.networkQualityFrom);
        sb.append(", httpDnsAreaInfo=");
        sb.append(this.httpDnsAreaInfo);
        sb.append(", httpDnsAreaUpdateTime=");
        sb.append(this.httpDnsAreaInfoLastUpdateTime);
        sb.append('}');
        return sb.toString();
    }

    public JSONObject toUBCJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 2);
            jSONObject.put("type", "common");
            if (!TextUtils.isEmpty(this.url)) {
                jSONObject.put("url", this.url);
            }
            if (!TextUtils.isEmpty(this.protocol)) {
                jSONObject.put("protocol", this.protocol);
            }
            if (!TextUtils.isEmpty(this.netType)) {
                jSONObject.put("netType", this.netType);
            }
            if (this.startTs != -1) {
                jSONObject.put("startTime", this.startTs);
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
            if (!TextUtils.isEmpty(this.dnsDetail.toString())) {
                jSONObject.put("dnsDetail", this.dnsDetail);
            }
            if (this.isConnReused && this.addressList != null && !this.addressList.isEmpty() && this.dnsDetail.optJSONArray("ipList") == null) {
                this.dnsDetail.put("ipList", parseAddressList());
                jSONObject.put("dnsDetail", this.dnsDetail);
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
            if (this.failTs != -1) {
                jSONObject.put("failTime", this.failTs);
            }
            if (!TextUtils.isEmpty(getStackTraceString(this.exception))) {
                jSONObject.put("errMsg", getStackTraceString(this.exception));
            }
            if (this.statusCode != -1) {
                jSONObject.put("statusCode", this.statusCode);
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
            if (this.realResponseLength > 0) {
                jSONObject.put("realResponseLength", this.realResponseLength);
            }
            if (this.realResponseLength > 0 && this.readOverTs != -1) {
                jSONObject.put("readOverTime", this.readOverTs);
            }
            if (this.netEngine != -1) {
                jSONObject.put("netEngine", this.netEngine);
            }
            if (this.extraUserInfo != null) {
                jSONObject.put("user_log", this.extraUserInfo.toString());
            }
            jSONObject.put("from", this.from);
            jSONObject.put("subFrom", this.subFrom);
            String str = "1";
            jSONObject.put("socketReuse", this.isConnReused ? "1" : "0");
            jSONObject.put("ipStack", this.ipStack);
            jSONObject.put("useFallback", this.useFallbackConn ? "1" : "0");
            if (!TextUtils.isEmpty(this.bdTraceId)) {
                jSONObject.put("bdTraceId", this.bdTraceId);
            }
            jSONObject.put("isConnected", this.isConnected ? "1" : "0");
            jSONObject.put(CloudStabilityUBCUtils.KEY_WEAK_QUALITY, this.networkQuality);
            jSONObject.put("networkQualityFrom", this.networkQualityFrom);
            if (this.sdtProbeErrorCode != null) {
                jSONObject.put("sdtProbeErrorCode", this.sdtProbeErrorCode.toString());
            }
            jSONObject.put("viaVPN", this.isVPNConnect ? "1" : "0");
            if (!this.isProxyConnect) {
                str = "0";
            }
            jSONObject.put("viaProxy", str);
            if (!TextUtils.isEmpty(this.httpDnsAreaInfo)) {
                jSONObject.put("httpDnsAreaInfo", this.httpDnsAreaInfo);
                jSONObject.put("httpDnsAreaUpdateTime", this.httpDnsAreaInfoLastUpdateTime);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
