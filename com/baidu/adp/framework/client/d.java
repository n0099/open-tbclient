package com.baidu.adp.framework.client;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<HttpMessage, HttpResponsedMessage, HttpResponsedMessage> {
    private HttpMessage aL;
    private HttpMessageTask aM;
    private final e aN;
    private volatile com.baidu.adp.lib.network.http.c aO = null;
    final /* synthetic */ HttpClient aP;

    public HttpMessage T() {
        return this.aL;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.aP = httpClient;
        this.aL = null;
        this.aM = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.aL = httpMessage;
        this.aM = httpMessageTask;
        this.aN = new e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        List<Map.Entry<String, Object>> encodeInBackGround = this.aL.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.aN.dQ().setUrl(this.aM.getUrl());
        this.aN.dQ().setMethod(this.aM.getMethod());
        this.aN.dQ().b(this.aL.getHeaders());
        this.aN.dQ().c(encodeInBackGround);
        int timeOut = this.aM.getTimeOut().getTimeOut();
        int timeOut2 = this.aM.getConnectTimeOut().getTimeOut();
        int retry = this.aM.getRetry();
        try {
            this.aO = new com.baidu.adp.lib.network.http.c(this.aN);
            if (this.aM.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.aO.d(retry, timeOut, timeOut2);
            } else if (this.aM.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.aO.f(retry, timeOut, timeOut2);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        long startTime = this.aL.getStartTime();
        long dN = this.aO.dN();
        long dO = this.aO.dO();
        long dP = this.aO.dP();
        long j = currentTimeMillis - startTime;
        long j2 = dN - currentTimeMillis;
        long j3 = dO - dN;
        long j4 = dP - dO;
        try {
            HttpResponsedMessage newInstance = this.aM.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.aL.getCmd()));
            String str = "";
            if (this.aN.dS().size() > 0) {
                str = this.aN.dS().get(this.aN.dS().size() - 1).kr;
            }
            newInstance.setStatusCode(this.aN.dR().responseCode, str);
            newInstance.setHeader(this.aN.dR().kF);
            newInstance.setContentEncoding(this.aN.dR().contentEncoding);
            newInstance.setContentLength(this.aN.dR().contentLength);
            newInstance.setContentType(this.aN.dR().contentType);
            newInstance.setDownSize(this.aN.dR().kH);
            if (!newInstance.isSuccess()) {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.setOrginalMessage(this.aL);
            if (newInstance.isSuccess()) {
                try {
                    newInstance.decodeInBackGround(this.aL.getCmd(), this.aN.dR().kG);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    newInstance.performanceData.cT = j;
                    newInstance.performanceData.cU = j2;
                    newInstance.performanceData.cV = j3;
                    newInstance.performanceData.cW = j4;
                    newInstance.performanceData.cX = currentTimeMillis2 - dP;
                    newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                    newInstance.beforeDispatchInBackGround(this.aL.getCmd(), this.aN.dR().kG);
                } catch (Exception e2) {
                    newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                    newInstance.setErrorString(BdBaseApplication.getInst().getString(R.string.error_unkown_try_again));
                    BdLog.detailException(e2);
                }
            }
            newInstance.logStatInBackground(this.aL.getCmd(), this.aN);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.aL.getCmd(), this.aN.dR().kG);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            return null;
        } catch (Exception e4) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
            }
            HttpClient.ErrorHttpResponsedMessage errorHttpResponsedMessage = new HttpClient.ErrorHttpResponsedMessage(this.aL.getCmd(), this.aL);
            U();
            return errorHttpResponsedMessage;
        }
    }

    private void U() {
        String W = this.aN.dQ().W("sid");
        if (this.aN.dS().size() > 0) {
            com.baidu.adp.lib.network.http.d dVar = this.aN.dS().get(this.aN.dS().size() - 1);
            f.er().b(this.aN.dQ().getUrl(), W, "", dVar.kl, dVar.kk, dVar.kp, dVar.km, dVar.ko, dVar.retry, TbErrInfo.ERR_IMG_CACHE, "init " + this.aM.getResponsedClass() + " error", new Object[0]);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.aO != null) {
            this.aO.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(HttpResponsedMessage... httpResponsedMessageArr) {
        if (httpResponsedMessageArr != null && httpResponsedMessageArr.length > 0) {
            this.aP.aH.dispatchResponsedMessage(httpResponsedMessageArr[0]);
        }
    }
}
