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
    private HttpMessage cS;
    private HttpMessageTask cT;
    private final e cU;
    private volatile com.baidu.adp.lib.network.http.c cV = null;
    final /* synthetic */ HttpClient cW;

    public HttpMessage at() {
        return this.cS;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.cW = httpClient;
        this.cS = null;
        this.cT = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.cS = httpMessage;
        this.cT = httpMessageTask;
        this.cU = new e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        List<Map.Entry<String, Object>> encodeInBackGround = this.cS.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.cU.dN().setUrl(this.cT.getUrl());
        this.cU.dN().setMethod(this.cT.getMethod());
        this.cU.dN().c(this.cS.getHeaders());
        this.cU.dN().c(encodeInBackGround);
        int timeOut = this.cT.getTimeOut().getTimeOut();
        int timeOut2 = this.cT.getConnectTimeOut().getTimeOut();
        int retry = this.cT.getRetry();
        try {
            this.cV = new com.baidu.adp.lib.network.http.c(this.cU);
            if (this.cT.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.cV.i(retry, timeOut, timeOut2);
            } else if (this.cT.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.cV.k(retry, timeOut, timeOut2);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        long startTime = this.cS.getStartTime();
        long dK = this.cV.dK();
        long dL = this.cV.dL();
        long dM = this.cV.dM();
        long j = currentTimeMillis - startTime;
        long j2 = dK - currentTimeMillis;
        long j3 = dL - dK;
        long j4 = dM - dL;
        try {
            HttpResponsedMessage newInstance = this.cT.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.cS.getCmd()));
            String str = "";
            if (this.cU.dP().size() > 0) {
                str = this.cU.dP().get(this.cU.dP().size() - 1).kv;
            }
            newInstance.setStatusCode(this.cU.dO().responseCode, str);
            newInstance.setHeader(this.cU.dO().kJ);
            newInstance.setContentEncoding(this.cU.dO().contentEncoding);
            newInstance.setContentLength(this.cU.dO().contentLength);
            newInstance.setContentType(this.cU.dO().contentType);
            newInstance.setDownSize(this.cU.dO().kL);
            if (!newInstance.isSuccess()) {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.setOrginalMessage(this.cS);
            if (newInstance.isSuccess()) {
                try {
                    newInstance.decodeInBackGround(this.cS.getCmd(), this.cU.dO().kK);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    newInstance.performanceData.fb = j;
                    newInstance.performanceData.fc = j2;
                    newInstance.performanceData.fd = j3;
                    newInstance.performanceData.fe = j4;
                    newInstance.performanceData.ff = currentTimeMillis2 - dM;
                    newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                    newInstance.beforeDispatchInBackGround(this.cS.getCmd(), this.cU.dO().kK);
                } catch (Exception e2) {
                    newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                    newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                    BdLog.detailException(e2);
                }
            }
            newInstance.logStatInBackground(this.cS.getCmd(), this.cU);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.cS.getCmd(), this.cU.dO().kK);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            return null;
        } catch (Exception e4) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
            }
            HttpClient.ErrorHttpResponsedMessage errorHttpResponsedMessage = new HttpClient.ErrorHttpResponsedMessage(this.cS.getCmd(), this.cS);
            au();
            return errorHttpResponsedMessage;
        }
    }

    private void au() {
        String ab = this.cU.dN().ab("sid");
        if (this.cU.dP().size() > 0) {
            com.baidu.adp.lib.network.http.d dVar = this.cU.dP().get(this.cU.dP().size() - 1);
            f.eq().b(this.cU.dN().getUrl(), ab, "", dVar.kq, dVar.kp, dVar.kt, dVar.kr, dVar.ks, dVar.retry, TbErrInfo.ERR_IMG_CACHE, "init " + this.cT.getResponsedClass() + " error", new Object[0]);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.cV != null) {
            this.cV.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(HttpResponsedMessage... httpResponsedMessageArr) {
        if (httpResponsedMessageArr != null && httpResponsedMessageArr.length > 0) {
            this.cW.cO.dispatchResponsedMessage(httpResponsedMessageArr[0]);
        }
    }
}
