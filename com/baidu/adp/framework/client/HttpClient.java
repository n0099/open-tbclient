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
        private HttpMessage oh;
        private HttpMessageTask oi;
        private final f oj;
        private volatile d ol = null;

        public HttpMessage cr() {
            return this.oh;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
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
            this.oj = new f();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.oh.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.oj.fA().setUrl(this.oi.getUrl());
            this.oj.fA().setMethod(this.oi.getMethod());
            this.oj.fA().d(this.oh.getHeaders());
            this.oj.fA().d(encodeInBackGround);
            int timeOut = this.oi.getTimeOut().getTimeOut();
            int timeOut2 = this.oi.getConnectTimeOut().getTimeOut();
            int retry = this.oi.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.ol = new d(this.oj);
            } catch (Exception e) {
                e = e;
            }
            if (this.oi.getDownloadTask() != null && this.oi.getDownloadTask().dw() != null) {
                try {
                    z = this.ol.a(this.oi.getDownloadTask().dw(), new c(this), retry, timeOut, timeOut2, this.oi.getDownloadTask().dx());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.oh.getStartTime();
                    long fv = this.ol.fv();
                    long fw = this.ol.fw();
                    long fp = this.ol.fp();
                    long fx = this.ol.fx();
                    long fy = this.ol.fy();
                    long j = currentTimeMillis - startTime;
                    long j2 = fv - currentTimeMillis;
                    long j3 = fw - fv;
                    dVar2 = this.ol;
                    int fz = dVar2.fz();
                    long j4 = fx - fw;
                    r9 = fp - fw;
                    long j5 = fx - fp;
                    long j6 = fy - fx;
                    newInstance = this.oi.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.oh);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.ol.d(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.ol.f(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.oh.getStartTime();
            long fv2 = this.ol.fv();
            long fw2 = this.ol.fw();
            long fp2 = this.ol.fp();
            long fx2 = this.ol.fx();
            long fy2 = this.ol.fy();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fv2 - currentTimeMillis;
            long j32 = fw2 - fv2;
            dVar2 = this.ol;
            int fz2 = dVar2.fz();
            long j42 = fx2 - fw2;
            r9 = fp2 - fw2;
            long j52 = fx2 - fp2;
            long j62 = fy2 - fx2;
            try {
                newInstance = this.oi.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.oi.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oh.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.oh.getCmd(), this.oh);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oj.fB().contentLength);
            } else {
                String str = "";
                if (this.oj.fC().size() > 0) {
                    String str2 = this.oj.fC().get(this.oj.fC().size() - 1).vv;
                    this.oh.setEncodedBinarySize(this.oj.fC().get(this.oj.fC().size() - 1).vo);
                    str = str2;
                }
                newInstance.setStatusCode(this.oj.fB().responseCode, str);
                newInstance.setHeader(this.oj.fB().vN);
                newInstance.setContentEncoding(this.oj.fB().contentEncoding);
                newInstance.setContentLength(this.oj.fB().contentLength);
                newInstance.setContentType(this.oj.fB().contentType);
                newInstance.setDownSize(this.oj.fB().vP);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oh);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.oh.getCmd(), this.oj.fB().vO);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qD = j7;
                        newInstance.performanceData.qO = j32;
                        newInstance.performanceData.qN = fz2;
                        newInstance.performanceData.qE = j22;
                        newInstance.performanceData.qF = j42;
                        newInstance.performanceData.qG = r9;
                        newInstance.performanceData.qH = j52;
                        newInstance.performanceData.qI = j62;
                        newInstance.performanceData.qJ = currentTimeMillis2 - fy2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.oh.getCmd(), this.oj.fB().vO);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.oh.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.oh.getExtra();
                    newInstance.performanceData.qL = netMessage.getSocketErrNo();
                    newInstance.performanceData.qM = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oh.getCmd(), this.oj.fB().vO);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
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
                HttpClient.this.od.dispatchResponsedMessage(responsedMessageArr[0]);
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
