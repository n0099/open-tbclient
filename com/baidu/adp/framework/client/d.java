package com.baidu.adp.framework.client;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
    private HttpMessage oc;
    private HttpMessageTask od;
    private final com.baidu.adp.lib.network.http.e oe;
    private volatile com.baidu.adp.lib.network.http.c of = null;
    final /* synthetic */ HttpClient og;

    public HttpMessage dR() {
        return this.oc;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.og = httpClient;
        this.oc = null;
        this.od = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.oc = httpMessage;
        this.od = httpMessageTask;
        this.oe = new com.baidu.adp.lib.network.http.e();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x01e1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0072 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x019c A[Catch: Exception -> 0x02f3, TRY_LEAVE, TryCatch #3 {Exception -> 0x02f3, blocks: (B:22:0x0196, B:24:0x019c), top: B:61:0x0196 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0221  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [long] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01e5 -> B:10:0x00b5). Please submit an issue!!! */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        boolean z;
        com.baidu.adp.lib.network.http.c cVar;
        long hl;
        long j;
        long j2;
        long j3;
        HttpResponsedMessage newInstance;
        List<Map.Entry<String, Object>> encodeInBackGround = this.oc.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.oe.hm().setUrl(this.od.getUrl());
        this.oe.hm().setMethod(this.od.getMethod());
        this.oe.hm().c(this.oc.getHeaders());
        this.oe.hm().c(encodeInBackGround);
        int timeOut = this.od.getTimeOut().getTimeOut();
        int timeOut2 = this.od.getConnectTimeOut().getTimeOut();
        int retry = this.od.getRetry();
        com.baidu.adp.lib.network.http.c cVar2 = null;
        ?? r8 = 0;
        r8 = 0;
        boolean z2 = false;
        try {
            this.of = new com.baidu.adp.lib.network.http.c(this.oe);
        } catch (Exception e) {
            e = e;
        }
        if (this.od.getDownloadTask() != null && this.od.getDownloadTask().fa() != null) {
            try {
                z = this.of.a(this.od.getDownloadTask().fa(), new e(this), retry, timeOut, timeOut2);
                cVar = 1;
            } catch (Exception e2) {
                e = e2;
                cVar2 = 1;
                BdLog.detailException(e);
                z2 = r8;
                z = z2;
                cVar = cVar2;
                long startTime = this.oc.getStartTime();
                long hj = this.of.hj();
                long hk = this.of.hk();
                cVar2 = this.of;
                hl = cVar2.hl();
                j = currentTimeMillis - startTime;
                j2 = hj - currentTimeMillis;
                j3 = hk - hj;
                r8 = hl - hk;
                newInstance = this.od.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oc.getCmd()));
                if (cVar == null) {
                }
                newInstance.setOrginalMessage(this.oc);
                if (cVar == null) {
                    try {
                        newInstance.decodeInBackGround(this.oc.getCmd(), this.oe.hn().vY);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qt = j;
                        newInstance.performanceData.qu = j2;
                        newInstance.performanceData.qv = j3;
                        newInstance.performanceData.qw = r8;
                        newInstance.performanceData.qx = currentTimeMillis2 - hl;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.oc.getCmd(), this.oe.hn().vY);
                    } catch (Exception e3) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e3);
                    }
                }
                newInstance.logStatInBackground(this.oc.getCmd(), this.oe);
                publishProgress(newInstance);
                if (newInstance.isSuccess()) {
                }
                return null;
            }
        } else if (this.od.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
            this.of.i(retry, timeOut, timeOut2);
            z = false;
            cVar = null;
        } else {
            if (this.od.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.of.k(retry, timeOut, timeOut2);
                z = false;
                cVar = null;
            }
            z = z2;
            cVar = cVar2;
        }
        long startTime2 = this.oc.getStartTime();
        long hj2 = this.of.hj();
        long hk2 = this.of.hk();
        cVar2 = this.of;
        hl = cVar2.hl();
        j = currentTimeMillis - startTime2;
        j2 = hj2 - currentTimeMillis;
        j3 = hk2 - hj2;
        r8 = hl - hk2;
        try {
            newInstance = this.od.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oc.getCmd()));
            if (cVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oe.hn().contentLength);
            } else {
                String str = "";
                if (this.oe.ho().size() > 0) {
                    String str2 = this.oe.ho().get(this.oe.ho().size() - 1).vL;
                    this.oc.setEncodedBinarySize(this.oe.ho().get(this.oe.ho().size() - 1).vE);
                    str = str2;
                }
                newInstance.setStatusCode(this.oe.hn().responseCode, str);
                newInstance.setHeader(this.oe.hn().vX);
                newInstance.setContentEncoding(this.oe.hn().contentEncoding);
                newInstance.setContentLength(this.oe.hn().contentLength);
                newInstance.setContentType(this.oe.hn().contentType);
                newInstance.setDownSize(this.oe.hn().vZ);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oc);
            if (cVar == null && newInstance.isSuccess()) {
                newInstance.decodeInBackGround(this.oc.getCmd(), this.oe.hn().vY);
                long currentTimeMillis22 = System.currentTimeMillis();
                newInstance.performanceData.qt = j;
                newInstance.performanceData.qu = j2;
                newInstance.performanceData.qv = j3;
                newInstance.performanceData.qw = r8;
                newInstance.performanceData.qx = currentTimeMillis22 - hl;
                newInstance.setCostTime(currentTimeMillis22 - currentTimeMillis);
                newInstance.beforeDispatchInBackGround(this.oc.getCmd(), this.oe.hn().vY);
            }
            newInstance.logStatInBackground(this.oc.getCmd(), this.oe);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oc.getCmd(), this.oe.hn().vY);
                }
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
            return null;
        } catch (Exception e5) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
            }
            return new HttpClient.ErrorHttpResponsedMessage(this.oc.getCmd(), this.oc);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.of != null) {
            this.of.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
        if (responsedMessageArr != null && responsedMessageArr.length > 0) {
            this.og.nY.dispatchResponsedMessage(responsedMessageArr[0]);
        }
    }
}
