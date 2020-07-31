package com.baidu.searchbox.network.statistics;

import android.text.TextUtils;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NetworkStatRecord {
    public static final String HEAD_X_BFE_SVBBRERS = "X-Bfe-Svbbrers";
    public String clientIP;
    public String errheaders;
    public Exception exception;
    public JSONObject extraUserInfo;
    public int ipStack;
    public boolean isConnReused;
    public String localIP;
    public String netType;
    public int networkQuality;
    public String protocol;
    public String remoteIP;
    public String url;
    public long startTs = -1;
    public long connTs = -1;
    public long responseTs = -1;
    public long finishTs = -1;
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
    private long dnsStartTs = -1;
    private long dnsEndTs = -1;
    private long dnsTs = -1;

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
            if (this.dnsTs != -1) {
                jSONObject.put("dnsTtme", this.dnsTs);
            }
            if (!TextUtils.isEmpty(this.dnsDetail.toString())) {
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
                jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.errheaders);
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
            jSONObject.put("from", this.from);
            jSONObject.put("socketReuse", this.isConnReused ? "1" : "0");
            jSONObject.put("networkQuality", this.networkQuality);
            if (this.extraUserInfo != null) {
                jSONObject.put("user_log", this.extraUserInfo.toString());
            }
            jSONObject.put("ipStack", this.ipStack);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void setDnsStartTs(long j) {
        this.dnsStartTs = j;
    }

    public void setDnsEndTs(long j) {
        this.dnsEndTs = j;
    }

    public void setDnsTs(long j) {
        this.dnsTs = j;
    }

    public long getDnsTime() {
        return this.dnsTs == -1 ? this.dnsEndTs - this.dnsStartTs : this.dnsTs;
    }

    public String toString() {
        return "NetworkStatRecord{, netEngine=" + this.netEngine + "，url=" + this.url + ", protocol=" + this.protocol + ", netType=" + this.netType + ", startTs=" + this.startTs + ", connTs=" + this.connTs + ", dnsStartTs=" + this.dnsStartTs + ", dnsEndTs=" + this.dnsEndTs + ", dnsTs=" + this.dnsTs + ", dnsDetail=" + this.dnsDetail.toString() + ", responseTs=" + this.responseTs + ", sendHeaderTs=" + this.sendHeaderTs + ", receiveHeaderTs=" + this.receiveHeaderTs + ", finishTs=" + this.finishTs + ", failTs=" + this.failTs + ", responseLength=" + this.responseLength + ", requestBodyLength=" + this.requestBodyLength + ", remoteIP=" + this.remoteIP + ", localIP=" + this.localIP + ", connectConsume=" + (this.connTs - this.startTs) + ", responseConsume=" + (this.responseTs - this.connTs) + ", totalConsume=" + (this.responseTs - this.startTs) + ", headers=" + this.errheaders + ", excetion=" + getStackTraceString(this.exception) + ", clientIP=" + this.clientIP + ", isConnReused=" + (this.isConnReused ? "1" : "0") + ", realResponseLength=" + this.realResponseLength + ", readOverTime=" + this.readOverTs + ", from=" + this.from + ", networkQuality=" + this.networkQuality + ", extraUserInfo=" + (this.extraUserInfo != null ? this.extraUserInfo.toString() : "") + '}';
    }

    private String getStackTraceString(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
        } catch (Throwable th2) {
            th = th2;
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            if (printWriter == null) {
                return stringWriter2;
            }
            printWriter.close();
            return stringWriter2;
        } catch (Throwable th3) {
            th = th3;
            if (printWriter != null) {
                printWriter.close();
            }
            throw th;
        }
    }

    public boolean isNeedFinishRightNow() {
        return (this.exception == null && this.statusCode == 200) ? false : true;
    }
}
