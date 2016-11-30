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
                linkedList.add(((a) next).bj());
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
        private HttpMessage gU;
        private HttpMessageTask gV;
        private final f gW;
        private volatile d gX = null;

        public HttpMessage bj() {
            return this.gU;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.gU = null;
            this.gV = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.gU = httpMessage;
            this.gV = httpMessageTask;
            this.gW = new f();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.gU.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.gW.ep().setUrl(this.gV.getUrl());
            this.gW.ep().setMethod(this.gV.getMethod());
            this.gW.ep().d(this.gU.getHeaders());
            this.gW.ep().d(encodeInBackGround);
            int timeOut = this.gV.getTimeOut().getTimeOut();
            int timeOut2 = this.gV.getConnectTimeOut().getTimeOut();
            int retry = this.gV.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.gX = new d(this.gW);
            } catch (Exception e) {
                e = e;
            }
            if (this.gV.getDownloadTask() != null && this.gV.getDownloadTask().cq() != null) {
                try {
                    z = this.gX.a(this.gV.getDownloadTask().cq(), new c(this), retry, timeOut, timeOut2, this.gV.getDownloadTask().cr());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.gU.getStartTime();
                    long ek = this.gX.ek();
                    long el = this.gX.el();
                    long ee = this.gX.ee();
                    long em = this.gX.em();
                    long en = this.gX.en();
                    long j = currentTimeMillis - startTime;
                    long j2 = ek - currentTimeMillis;
                    long j3 = el - ek;
                    dVar2 = this.gX;
                    int eo = dVar2.eo();
                    long j4 = em - el;
                    r9 = ee - el;
                    long j5 = em - ee;
                    long j6 = en - em;
                    newInstance = this.gV.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.gU);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.gU.getCmd(), this.gW);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.gV.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.gX.e(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.gV.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.gX.g(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.gU.getStartTime();
            long ek2 = this.gX.ek();
            long el2 = this.gX.el();
            long ee2 = this.gX.ee();
            long em2 = this.gX.em();
            long en2 = this.gX.en();
            long j7 = currentTimeMillis - startTime2;
            long j22 = ek2 - currentTimeMillis;
            long j32 = el2 - ek2;
            dVar2 = this.gX;
            int eo2 = dVar2.eo();
            long j42 = em2 - el2;
            r9 = ee2 - el2;
            long j52 = em2 - ee2;
            long j62 = en2 - em2;
            try {
                newInstance = this.gV.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.gV.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.gU.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.gU.getCmd(), this.gU);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.gW.eq().contentLength);
            } else {
                String str = "";
                if (this.gW.er().size() > 0) {
                    String str2 = this.gW.er().get(this.gW.er().size() - 1).ol;
                    this.gU.setEncodedBinarySize(this.gW.er().get(this.gW.er().size() - 1).od);
                    str = str2;
                }
                newInstance.setStatusCode(this.gW.eq().responseCode, str);
                newInstance.setHeader(this.gW.eq().oG);
                newInstance.setContentEncoding(this.gW.eq().contentEncoding);
                newInstance.setContentLength(this.gW.eq().contentLength);
                newInstance.setContentType(this.gW.eq().contentType);
                newInstance.setDownSize(this.gW.eq().oI);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.gU);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.gU.getCmd(), this.gW.eq().oH);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.jq = j7;
                        newInstance.performanceData.jB = j32;
                        newInstance.performanceData.jA = eo2;
                        newInstance.performanceData.jr = j22;
                        newInstance.performanceData.js = j42;
                        newInstance.performanceData.jt = r9;
                        newInstance.performanceData.ju = j52;
                        newInstance.performanceData.jv = j62;
                        newInstance.performanceData.jw = currentTimeMillis2 - en2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.gU.getCmd(), this.gW.eq().oH);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.gU.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.gU.getExtra();
                    newInstance.performanceData.jy = netMessage.getSocketErrNo();
                    newInstance.performanceData.jz = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.gU.getCmd(), this.gW);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.gU.getCmd(), this.gW.eq().oH);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.gX != null) {
                this.gX.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.gQ.dispatchResponsedMessage(responsedMessageArr[0]);
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
