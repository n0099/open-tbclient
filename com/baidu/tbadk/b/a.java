package com.baidu.tbadk.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.stats.p;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.httpNet.j;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.a.d {
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
            TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
            a(httpMessage, tbHttpMessageTask);
            b(httpMessage, tbHttpMessageTask);
        }
        return httpMessage;
    }

    private void a(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        if (tbHttpMessageTask.isFromCDN()) {
            httpMessage.removeAllParams();
            return;
        }
        if (tbHttpMessageTask.isUseCurrentBDUSS()) {
            a(httpMessage);
        }
        if (tbHttpMessageTask.isNeedAddCommenParam()) {
            c(httpMessage, tbHttpMessageTask);
        }
        c(httpMessage);
        if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
            if (httpMessage.hasRaw()) {
                b(httpMessage);
            } else if (tbHttpMessageTask.isBaiduServer()) {
                b(httpMessage);
            }
        }
    }

    private void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader("Accept-Encoding", "gzip");
        }
        httpMessage.addHeader("Charset", "UTF-8");
        httpMessage.addHeader("User-Agent", "bdtb for Android " + TbConfig.getVersion());
        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkApplication.getCurrentAccount());
        }
        String a = p.a();
        if (!TextUtils.isEmpty(a)) {
            httpMessage.addHeader("sid", a);
        }
        String a2 = j.a();
        if (!TextUtils.isEmpty(a2)) {
            httpMessage.addHeader("net", a2);
        }
    }

    private void c(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        if (!TbadkApplication.m252getInst().isOfficial()) {
            httpMessage.addParam("apid", TbConfig.SW_APID);
        }
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m252getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkApplication.m252getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            httpMessage.addParam("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.FROM, from);
        }
        String a = j.a();
        if (a != null) {
            String c = com.baidu.tbadk.coreExtra.a.a.a().c();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(a)) {
                if (TbadkApplication.m252getInst().getKeepaliveWifi() == 1) {
                    c = String.valueOf(c) + "ka=open";
                }
            } else if (TbadkApplication.m252getInst().getKeepaliveNonWifi() == 1) {
                c = String.valueOf(c) + "ka=open";
            }
            httpMessage.addHeader("Cookie", c);
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkApplication.m252getInst().getTbs());
        }
        httpMessage.addParam("cuid", TbadkApplication.m252getInst().getCuid());
        httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
        httpMessage.addParam("model", Build.MODEL);
    }

    private void a(HttpMessage httpMessage) {
        String currentBduss = TbadkApplication.getCurrentBduss();
        if (currentBduss != null) {
            httpMessage.addParam("BDUSS", currentBduss);
        }
    }

    private void b(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    stringBuffer.append(String.valueOf(key) + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam("sign", i.a(stringBuffer.toString()));
    }

    private void c(HttpMessage httpMessage) {
        ao a = an.a();
        if (a != null) {
            httpMessage.addParam("stTime", String.valueOf(a.b));
            httpMessage.addParam("stSize", String.valueOf(a.c));
            httpMessage.addParam("stTimesNum", String.valueOf(a.d));
            httpMessage.addParam("stMode", String.valueOf(a.e));
            httpMessage.addParam("stMethod", String.valueOf(a.a));
        }
        int a2 = an.a(0);
        if (a2 == 0 && a != null) {
            a2 = a.d;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(a2));
    }
}
