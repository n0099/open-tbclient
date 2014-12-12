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
    private HttpMessage cR;
    private HttpMessageTask cS;
    private final e cT;
    private volatile com.baidu.adp.lib.network.http.c cU = null;
    final /* synthetic */ HttpClient cV;

    public HttpMessage at() {
        return this.cR;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.cV = httpClient;
        this.cR = null;
        this.cS = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.cR = httpMessage;
        this.cS = httpMessageTask;
        this.cT = new e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        List<Map.Entry<String, Object>> encodeInBackGround = this.cR.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.cT.dP().setUrl(this.cS.getUrl());
        this.cT.dP().setMethod(this.cS.getMethod());
        this.cT.dP().c(this.cR.getHeaders());
        this.cT.dP().c(encodeInBackGround);
        int timeOut = this.cS.getTimeOut().getTimeOut();
        int timeOut2 = this.cS.getConnectTimeOut().getTimeOut();
        int retry = this.cS.getRetry();
        try {
            this.cU = new com.baidu.adp.lib.network.http.c(this.cT);
            if (this.cS.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.cU.i(retry, timeOut, timeOut2);
            } else if (this.cS.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.cU.k(retry, timeOut, timeOut2);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        long startTime = this.cR.getStartTime();
        long dM = this.cU.dM();
        long dN = this.cU.dN();
        long dO = this.cU.dO();
        long j = currentTimeMillis - startTime;
        long j2 = dM - currentTimeMillis;
        long j3 = dN - dM;
        long j4 = dO - dN;
        try {
            HttpResponsedMessage newInstance = this.cS.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.cR.getCmd()));
            String str = "";
            if (this.cT.dR().size() > 0) {
                str = this.cT.dR().get(this.cT.dR().size() - 1).ks;
            }
            newInstance.setStatusCode(this.cT.dQ().responseCode, str);
            newInstance.setHeader(this.cT.dQ().kG);
            newInstance.setContentEncoding(this.cT.dQ().contentEncoding);
            newInstance.setContentLength(this.cT.dQ().contentLength);
            newInstance.setContentType(this.cT.dQ().contentType);
            newInstance.setDownSize(this.cT.dQ().kI);
            if (!newInstance.isSuccess()) {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.setOrginalMessage(this.cR);
            if (newInstance.isSuccess()) {
                try {
                    newInstance.decodeInBackGround(this.cR.getCmd(), this.cT.dQ().kH);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    newInstance.performanceData.eZ = j;
                    newInstance.performanceData.fa = j2;
                    newInstance.performanceData.fb = j3;
                    newInstance.performanceData.fc = j4;
                    newInstance.performanceData.fd = currentTimeMillis2 - dO;
                    newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                    newInstance.beforeDispatchInBackGround(this.cR.getCmd(), this.cT.dQ().kH);
                } catch (Exception e2) {
                    newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                    newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                    BdLog.detailException(e2);
                }
            }
            newInstance.logStatInBackground(this.cR.getCmd(), this.cT);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.cR.getCmd(), this.cT.dQ().kH);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            return null;
        } catch (Exception e4) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
            }
            HttpClient.ErrorHttpResponsedMessage errorHttpResponsedMessage = new HttpClient.ErrorHttpResponsedMessage(this.cR.getCmd(), this.cR);
            au();
            return errorHttpResponsedMessage;
        }
    }

    private void au() {
        String ab = this.cT.dP().ab("sid");
        if (this.cT.dR().size() > 0) {
            com.baidu.adp.lib.network.http.d dVar = this.cT.dR().get(this.cT.dR().size() - 1);
            f.es().b(this.cT.dP().getUrl(), ab, "", dVar.km, dVar.kl, dVar.kq, dVar.ko, dVar.kp, dVar.retry, TbErrInfo.ERR_IMG_CACHE, "init " + this.cS.getResponsedClass() + " error", new Object[0]);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.cU != null) {
            this.cU.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(HttpResponsedMessage... httpResponsedMessageArr) {
        if (httpResponsedMessageArr != null && httpResponsedMessageArr.length > 0) {
            this.cV.cN.dispatchResponsedMessage(httpResponsedMessageArr[0]);
        }
    }
}
