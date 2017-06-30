package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends com.baidu.adp.framework.client.a<HttpMessage, HttpMessageTask> {
    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        a.removeAllTask(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        a.removeAllTask(bdUniqueId, String.valueOf(i));
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return a((String) null, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return a(String.valueOf(i), bdUniqueId);
    }

    public LinkedList<HttpMessage> a(String str, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof a) {
                linkedList.add(((a) next).cr());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        private HttpMessage oi;
        private HttpMessageTask oj;
        private final f ol;
        private volatile d om = null;

        public HttpMessage cr() {
            return this.oi;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.oi = null;
            this.oj = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.oi = httpMessage;
            this.oj = httpMessageTask;
            this.ol = new f();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0239 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0072 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01f4 A[Catch: Exception -> 0x0383, TRY_LEAVE, TryCatch #4 {Exception -> 0x0383, blocks: (B:26:0x01ee, B:28:0x01f4), top: B:70:0x01ee }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x02ae  */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v5, types: [long] */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x023d -> B:10:0x00c1). Please submit an issue!!! */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            d dVar;
            HttpResponsedMessage newInstance;
            List<Map.Entry<String, Object>> encodeInBackGround = this.oi.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.ol.fA().setUrl(this.oj.getUrl());
            this.ol.fA().setMethod(this.oj.getMethod());
            this.ol.fA().d(this.oi.getHeaders());
            this.ol.fA().f(encodeInBackGround);
            int timeOut = this.oj.getTimeOut().getTimeOut();
            int timeOut2 = this.oj.getConnectTimeOut().getTimeOut();
            int retry = this.oj.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.om = new d(this.ol);
            } catch (Exception e) {
                e = e;
            }
            if (this.oj.getDownloadTask() != null && this.oj.getDownloadTask().dx() != null) {
                try {
                    z = this.om.a(this.oj.getDownloadTask().dx(), new c(this), retry, timeOut, timeOut2, this.oj.getDownloadTask().dy());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.oi.getStartTime();
                    long fv = this.om.fv();
                    long fw = this.om.fw();
                    long fp = this.om.fp();
                    long fx = this.om.fx();
                    long fy = this.om.fy();
                    long j = currentTimeMillis - startTime;
                    long j2 = fv - currentTimeMillis;
                    long j3 = fw - fv;
                    dVar2 = this.om;
                    int fz = dVar2.fz();
                    long j4 = fx - fw;
                    r9 = fp - fw;
                    long j5 = fx - fp;
                    long j6 = fy - fx;
                    newInstance = this.oj.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.oi);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.oi.getCmd(), this.ol);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.oj.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.om.d(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.oj.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.om.f(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.oi.getStartTime();
            long fv2 = this.om.fv();
            long fw2 = this.om.fw();
            long fp2 = this.om.fp();
            long fx2 = this.om.fx();
            long fy2 = this.om.fy();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fv2 - currentTimeMillis;
            long j32 = fw2 - fv2;
            dVar2 = this.om;
            int fz2 = dVar2.fz();
            long j42 = fx2 - fw2;
            r9 = fp2 - fw2;
            long j52 = fx2 - fp2;
            long j62 = fy2 - fx2;
            try {
                newInstance = this.oj.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.oj.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oi.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.oi.getCmd(), this.oi);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.ol.fB().contentLength);
            } else {
                String str = "";
                if (this.ol.fC().size() > 0) {
                    String str2 = this.ol.fC().get(this.ol.fC().size() - 1).vz;
                    this.oi.setEncodedBinarySize(this.ol.fC().get(this.ol.fC().size() - 1).vt);
                    str = str2;
                }
                newInstance.setStatusCode(this.ol.fB().responseCode, str);
                newInstance.setHeader(this.ol.fB().vR);
                newInstance.setContentEncoding(this.ol.fB().contentEncoding);
                newInstance.setContentLength(this.ol.fB().contentLength);
                newInstance.setContentType(this.ol.fB().contentType);
                newInstance.setDownSize(this.ol.fB().vT);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oi);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.oi.getCmd(), this.ol.fB().vS);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qJ = j7;
                        newInstance.performanceData.qU = j32;
                        newInstance.performanceData.qT = fz2;
                        newInstance.performanceData.qK = j22;
                        newInstance.performanceData.qL = j42;
                        newInstance.performanceData.qM = r9;
                        newInstance.performanceData.qN = j52;
                        newInstance.performanceData.qO = j62;
                        newInstance.performanceData.qP = currentTimeMillis2 - fy2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.oi.getCmd(), this.ol.fB().vS);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.oi.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.oi.getExtra();
                    newInstance.performanceData.qR = netMessage.getSocketErrNo();
                    newInstance.performanceData.qS = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.oi.getCmd(), this.ol);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oi.getCmd(), this.ol.fB().vS);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.om != null) {
                this.om.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.oe.dispatchResponsedMessage(responsedMessageArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(TbErrInfo.ERR_IMG_SEND);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
