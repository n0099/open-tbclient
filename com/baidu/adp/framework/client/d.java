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
    private HttpMessage oh;
    private HttpMessageTask oi;
    private final com.baidu.adp.lib.network.http.e oj;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    final /* synthetic */ HttpClient om;

    public HttpMessage dU() {
        return this.oh;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.om = httpClient;
        this.oh = null;
        this.oi = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.oh = httpMessage;
        this.oi = httpMessageTask;
        this.oj = new com.baidu.adp.lib.network.http.e();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x01ed */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0072 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01a8 A[Catch: Exception -> 0x0303, TRY_LEAVE, TryCatch #4 {Exception -> 0x0303, blocks: (B:22:0x01a2, B:24:0x01a8), top: B:63:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x022d  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [long] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01f1 -> B:10:0x00c1). Please submit an issue!!! */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        boolean z;
        com.baidu.adp.lib.network.http.c cVar;
        long gX;
        long j;
        long j2;
        long j3;
        long j4;
        HttpResponsedMessage newInstance;
        List<Map.Entry<String, Object>> encodeInBackGround = this.oh.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.oj.gY().setUrl(this.oi.getUrl());
        this.oj.gY().setMethod(this.oi.getMethod());
        this.oj.gY().c(this.oh.getHeaders());
        this.oj.gY().d(encodeInBackGround);
        int timeOut = this.oi.getTimeOut().getTimeOut();
        int timeOut2 = this.oi.getConnectTimeOut().getTimeOut();
        int retry = this.oi.getRetry();
        com.baidu.adp.lib.network.http.c cVar2 = null;
        ?? r9 = 0;
        r9 = 0;
        boolean z2 = false;
        try {
            this.ol = new com.baidu.adp.lib.network.http.c(this.oj);
        } catch (Exception e) {
            e = e;
        }
        if (this.oi.getDownloadTask() != null && this.oi.getDownloadTask().fe() != null) {
            try {
                z = this.ol.a(this.oi.getDownloadTask().fe(), new e(this), retry, timeOut, timeOut2, this.oi.getDownloadTask().ff());
                cVar = 1;
            } catch (Exception e2) {
                e = e2;
                cVar2 = 1;
                BdLog.detailException(e);
                z2 = r9;
                z = z2;
                cVar = cVar2;
                long startTime = this.oh.getStartTime();
                long gV = this.ol.gV();
                r9 = this.ol.gW();
                cVar2 = this.ol;
                gX = cVar2.gX();
                j = currentTimeMillis - startTime;
                j2 = gV - currentTimeMillis;
                j3 = r9 - gV;
                j4 = gX - r9;
                newInstance = this.oi.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oh.getCmd()));
                if (cVar == null) {
                }
                newInstance.setOrginalMessage(this.oh);
                if (cVar == null) {
                    try {
                        newInstance.decodeInBackGround(this.oh.getCmd(), this.oj.gZ().vk);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qx = j;
                        newInstance.performanceData.qy = j2;
                        newInstance.performanceData.qz = j3;
                        newInstance.performanceData.qA = j4;
                        newInstance.performanceData.qB = currentTimeMillis2 - gX;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.oh.getCmd(), this.oj.gZ().vk);
                    } catch (Exception e3) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e3);
                    }
                }
                newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
                publishProgress(newInstance);
                if (newInstance.isSuccess()) {
                }
                return null;
            }
        } else if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
            this.ol.i(retry, timeOut, timeOut2);
            z = false;
            cVar = null;
        } else {
            if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.ol.k(retry, timeOut, timeOut2);
                z = false;
                cVar = null;
            }
            z = z2;
            cVar = cVar2;
        }
        long startTime2 = this.oh.getStartTime();
        long gV2 = this.ol.gV();
        r9 = this.ol.gW();
        cVar2 = this.ol;
        gX = cVar2.gX();
        j = currentTimeMillis - startTime2;
        j2 = gV2 - currentTimeMillis;
        j3 = r9 - gV2;
        j4 = gX - r9;
        try {
            newInstance = this.oi.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oh.getCmd()));
            if (cVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oj.gZ().contentLength);
            } else {
                String str = "";
                if (this.oj.ha().size() > 0) {
                    String str2 = this.oj.ha().get(this.oj.ha().size() - 1).uX;
                    this.oh.setEncodedBinarySize(this.oj.ha().get(this.oj.ha().size() - 1).uQ);
                    str = str2;
                }
                newInstance.setStatusCode(this.oj.gZ().responseCode, str);
                newInstance.setHeader(this.oj.gZ().vj);
                newInstance.setContentEncoding(this.oj.gZ().contentEncoding);
                newInstance.setContentLength(this.oj.gZ().contentLength);
                newInstance.setContentType(this.oj.gZ().contentType);
                newInstance.setDownSize(this.oj.gZ().vl);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oh);
            if (cVar == null && newInstance.isSuccess()) {
                newInstance.decodeInBackGround(this.oh.getCmd(), this.oj.gZ().vk);
                long currentTimeMillis22 = System.currentTimeMillis();
                newInstance.performanceData.qx = j;
                newInstance.performanceData.qy = j2;
                newInstance.performanceData.qz = j3;
                newInstance.performanceData.qA = j4;
                newInstance.performanceData.qB = currentTimeMillis22 - gX;
                newInstance.setCostTime(currentTimeMillis22 - currentTimeMillis);
                newInstance.beforeDispatchInBackGround(this.oh.getCmd(), this.oj.gZ().vk);
            }
            newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oh.getCmd(), this.oj.gZ().vk);
                }
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
            return null;
        } catch (Exception e5) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
            }
            return new HttpClient.ErrorHttpResponsedMessage(this.oh.getCmd(), this.oh);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.ol != null) {
            this.ol.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
        if (responsedMessageArr != null && responsedMessageArr.length > 0) {
            this.om.od.dispatchResponsedMessage(responsedMessageArr[0]);
        }
    }
}
