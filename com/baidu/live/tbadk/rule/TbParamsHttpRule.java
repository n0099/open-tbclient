package com.baidu.live.tbadk.rule;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.account.StokenPolicy;
import com.baidu.live.tbadk.core.util.NetWorkState;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class TbParamsHttpRule extends HttpRule {
    private static final String SIGN_SUFFIX = "tiebaclient!!!";

    public TbParamsHttpRule(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.MessageRule
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
            TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
            generateParams(httpMessage, tbHttpMessageTask);
            generateHeaders(httpMessage, tbHttpMessageTask);
        }
        return httpMessage;
    }

    private void generateParams(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        if (tbHttpMessageTask.isFromCDN()) {
            httpMessage.removeAllParams();
            return;
        }
        if (tbHttpMessageTask.isUseCurrentBDUSS()) {
            if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                addBdussData(httpMessage);
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                addBdussData(httpMessage);
            } else {
                httpMessage.addCookie("BDUSS", TbadkCoreApplication.getCurrentBduss());
            }
        }
        if (tbHttpMessageTask.isNeedAddCommenParam()) {
            addCommonParams(httpMessage, tbHttpMessageTask);
        }
        if (tbHttpMessageTask.isNeedAddStatisticsParam()) {
            addStatisticsDataParam(httpMessage);
        }
        if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
            if (tbHttpMessageTask.isBaiduServer()) {
                addSign(httpMessage);
            }
            generateHotParams(tbHttpMessageTask);
        }
    }

    private void generateHotParams(TbHttpMessageTask tbHttpMessageTask) {
        if (tbHttpMessageTask != null && !TextUtils.isEmpty(tbHttpMessageTask.getUrl())) {
            String url = tbHttpMessageTask.getUrl();
            if (AlaLiveSwitchData.isHotLive == 1) {
                if (!url.contains("&ishot=1") && !url.contains("?ishot=1")) {
                    url = url.contains("?") ? url + "&ishot=1" : url + "?ishot=1";
                }
            } else if (url.contains("&ishot=1")) {
                url = url.replace("&ishot=1", "");
            } else if (url.contains("?ishot=1")) {
                url = url.replace("?ishot=1", "");
            }
            tbHttpMessageTask.setUrl(url);
        }
    }

    private void generateHeaders(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        boolean z = true;
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader(Headers.ACCEPT_ENCODING, "gzip");
        } else {
            httpMessage.addHeader(Headers.ACCEPT_ENCODING, "");
        }
        httpMessage.addHeader("Charset", "UTF-8");
        String userAgent = httpMessage.getUserAgent();
        if (TextUtils.isEmpty(userAgent)) {
            httpMessage.addHeader("User-Agent", ExtraParamsManager.getUserAgent());
        } else {
            httpMessage.addHeader("User-Agent", userAgent);
        }
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
        }
        int netType = BdNetTypeUtil.netType();
        httpMessage.addHeader("net", String.valueOf(netType));
        if (1 != netType ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() != 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() != 1) {
            z = false;
        }
        if (z) {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, "close");
        }
        httpMessage.addHeader("client_logid", String.valueOf(httpMessage.getClientLogID()));
        httpMessage.addHeader("cuid", TbadkCoreApplication.getInst().getCuid());
    }

    private void addCommonParams(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", "2");
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            httpMessage.addParam("subapp_type", TbConfig.getSubappType());
        }
        httpMessage.addParam(HttpRequest.SUBAPP_VERSION, TbConfig.getSubappVersionCode());
        httpMessage.addParam(HttpRequest.SUBAPP_VERSION_NAME, TbConfig.getSubappVersionName());
        httpMessage.addParam(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        if (AlaLiveSwitchData.isHotLive == 1) {
            httpMessage.addParam(HttpRequest.SDK_LIVE_IS_HOT, 1);
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            httpMessage.addParam(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE, AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            httpMessage.addParam("live_enter_type", TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            httpMessage.addParam("from", from);
        }
        int netType = BdNetTypeUtil.netType();
        httpMessage.addParam("net_type", String.valueOf(netType));
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                httpMessage.addCookie("ka", "open");
            }
        } else if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
            httpMessage.addCookie("ka", "open");
        }
        httpMessage.addCookie("BAIDUZID", ExtraParamsManager.getBaiduzid());
        httpMessage.addCookie("BAIDUCUID", ExtraParamsManager.getBase64(ExtraParamsManager.getInstance().buildParamsExtra().getCuid()));
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
        httpMessage.addParam("model", Build.MODEL);
        httpMessage.addParam(Constants.PHONE_BRAND, Build.BRAND);
        httpMessage.addParam("_os_version", Build.VERSION.RELEASE);
        Map<String, String> commonParams = tbHttpMessageTask.getCommonParams();
        if (commonParams != null && !commonParams.isEmpty()) {
            for (Map.Entry<String, String> entry : commonParams.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    httpMessage.addParam(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private void addBdussData(HttpMessage httpMessage) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null) {
            httpMessage.addParam("BDUSS", currentBduss);
            String verificatedStoken = StokenPolicy.getVerificatedStoken(TbadkCoreApplication.getCurrentAccountInfo());
            if (!StringUtils.isNull(verificatedStoken)) {
                httpMessage.addParam("stoken", verificatedStoken);
            }
        }
    }

    private void addSign(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !"sign".equals(key)) {
                    stringBuffer.append(key + ETAG.EQUAL);
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append(SIGN_SUFFIX);
        httpMessage.addParam("sign", Md5.toMd5(stringBuffer.toString()));
    }

    private void addStatisticsDataParam(HttpMessage httpMessage) {
        NetWorkState.StatisticsData delStatisticsData = NetWorkState.delStatisticsData();
        if (delStatisticsData != null) {
            httpMessage.addParam("stTime", String.valueOf(delStatisticsData.mTime));
            httpMessage.addParam("stSize", String.valueOf(delStatisticsData.mSize));
            httpMessage.addParam("stTimesNum", String.valueOf(delStatisticsData.mTimesNum));
            httpMessage.addParam("stMode", String.valueOf(delStatisticsData.mMode));
            httpMessage.addParam("stMethod", String.valueOf(delStatisticsData.mMethod));
        }
        int errorNumsAndSet = NetWorkState.getErrorNumsAndSet(0);
        if (errorNumsAndSet == 0 && delStatisticsData != null) {
            errorNumsAndSet = delStatisticsData.mTimesNum;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(errorNumsAndSet));
    }
}
