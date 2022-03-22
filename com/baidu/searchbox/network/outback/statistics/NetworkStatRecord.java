package com.baidu.searchbox.network.outback.statistics;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NetworkStatRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FROM_ID = 0;
    public static final int DEFAULT_SUBFROM_ID = 0;
    public static final String HEAD_X_BFE_SVBBRERS = "X-Bfe-Svbbrers";
    public transient /* synthetic */ FieldHolder $fh;
    public long appLaunchTimestamp;
    public String bdTraceId;
    public long callEndTimeStamp;
    public long callStartTimeStamp;
    public String clientIP;
    public String clientIPv6;
    public long connTs;
    public String contentType;
    public JSONObject dnsDetail;
    public long dnsEndTs;
    public long dnsStartTs;
    public long dnsTs;
    public String errheaders;
    public Exception exception;
    public JSONObject extraUserInfo;
    public long failTs;
    public long finishTs;
    public String freeCardIsp;
    public String freeCardProduct;
    public int from;
    public long getNetworkInfoTs;
    public String httpDnsAreaInfo;
    public long httpDnsAreaInfoLastUpdateTime;
    public int ipStack;
    public boolean isConnReused;
    public boolean isConnected;
    public boolean isProxyConnect;
    public boolean isVPNConnect;
    public List<String> localDnsIpList;
    public String localIP;
    public int netEngine;
    public String netType;
    public int networkQuality;
    public String processName;
    public String protocol;
    public String proxyAddress;
    public String proxyHostString;
    public long readOverTs;
    public long realResponseLength;
    public long receiveHeaderTs;
    public String remoteIP;
    public long requestBodyLength;
    public long responseLength;
    public long responseTs;
    public long sendHeaderTs;
    public long sslEndSTs;
    public long sslStartTs;
    public long startTs;
    public int statusCode;
    public int subFrom;
    public long switchThreadEnd;
    public long switchThreadInQueue;
    public long switchThreadStart;
    public long tcpEndTs;
    public long tcpStartTs;
    public String url;
    public boolean useFallbackConn;

    public NetworkStatRecord() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.startTs = -1L;
        this.tcpStartTs = -1L;
        this.tcpEndTs = -1L;
        this.sslStartTs = -1L;
        this.sslEndSTs = -1L;
        this.connTs = -1L;
        this.responseTs = -1L;
        this.finishTs = -1L;
        this.getNetworkInfoTs = -1L;
        this.failTs = -1L;
        this.sendHeaderTs = -1L;
        this.receiveHeaderTs = -1L;
        this.dnsDetail = new JSONObject();
        this.statusCode = -1;
        this.responseLength = 0L;
        this.requestBodyLength = 0L;
        this.realResponseLength = 0L;
        this.readOverTs = -1L;
        this.netEngine = -1;
        this.from = 0;
        this.subFrom = 0;
        this.isConnected = true;
        this.callStartTimeStamp = -1L;
        this.callEndTimeStamp = -1L;
        this.switchThreadStart = -1L;
        this.switchThreadEnd = -1L;
        this.switchThreadInQueue = -1L;
        this.dnsStartTs = -1L;
        this.dnsEndTs = -1L;
        this.dnsTs = -1L;
    }

    private JSONObject deepCopyDnsDetail(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
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
        return (JSONObject) invokeL.objValue;
    }

    private String getExceptionMsg(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, th)) == null) ? (th == null || th.getMessage() == null) ? "" : th.getMessage() : (String) invokeL.objValue;
    }

    private String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, th)) != null) {
            return (String) invokeL.objValue;
        }
        if (th == null) {
            return "";
        }
        PrintWriter printWriter = null;
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter2 = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter2);
                printWriter2.flush();
                String stringWriter2 = stringWriter.toString();
                printWriter2.close();
                return stringWriter2;
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public long getDnsTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.dnsTs;
            return j == -1 ? this.dnsEndTs - this.dnsStartTs : j;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            long j = this.connTs;
            sb.append(j <= 0 ? 0L : j - this.startTs);
            sb.append(", responseConsume=");
            long j2 = this.connTs;
            sb.append(j2 <= 0 ? this.responseTs - this.startTs : this.responseTs - j2);
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
            sb.append(this.isConnReused ? "1" : "0");
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
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            sb.append(", freeCardProduct=");
            sb.append(this.freeCardProduct);
            sb.append(", freeCardIsp=");
            sb.append(this.freeCardIsp);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public JSONObject toUBCJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
                    jSONObject.put(FetchLog.START_TIME, this.startTs);
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
                jSONObject.put("socketReuse", this.isConnReused ? "1" : "0");
                jSONObject.put(CloudStabilityUBCUtils.KEY_WEAK_QUALITY, this.networkQuality);
                if (this.extraUserInfo != null) {
                    jSONObject.put("user_log", this.extraUserInfo.toString());
                }
                jSONObject.put("ipStack", this.ipStack);
                jSONObject.put("useFallback", this.useFallbackConn ? "1" : "0");
                if (!TextUtils.isEmpty(this.bdTraceId)) {
                    jSONObject.put("bdTraceId", this.bdTraceId);
                }
                jSONObject.put("isConnected", this.isConnected ? "1" : "0");
                jSONObject.put("viaVPN", this.isVPNConnect ? "1" : "0");
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
