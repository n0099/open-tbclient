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
                linkedList.add(((a) next).ao());
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
        private HttpMessage eH;
        private HttpMessageTask eI;
        private final f eJ;
        private volatile d eK = null;

        public HttpMessage ao() {
            return this.eH;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.eH = null;
            this.eI = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.eH = httpMessage;
            this.eI = httpMessageTask;
            this.eJ = new f();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.eH.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.eJ.du().setUrl(this.eI.getUrl());
            this.eJ.du().setMethod(this.eI.getMethod());
            this.eJ.du().d(this.eH.getHeaders());
            this.eJ.du().d(encodeInBackGround);
            int timeOut = this.eI.getTimeOut().getTimeOut();
            int timeOut2 = this.eI.getConnectTimeOut().getTimeOut();
            int retry = this.eI.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.eK = new d(this.eJ);
            } catch (Exception e) {
                e = e;
            }
            if (this.eI.getDownloadTask() != null && this.eI.getDownloadTask().bv() != null) {
                try {
                    z = this.eK.a(this.eI.getDownloadTask().bv(), new c(this), retry, timeOut, timeOut2, this.eI.getDownloadTask().bw());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.eH.getStartTime();
                    long dp = this.eK.dp();
                    long dq = this.eK.dq();
                    long dj = this.eK.dj();
                    long dr = this.eK.dr();
                    long ds = this.eK.ds();
                    long j = currentTimeMillis - startTime;
                    long j2 = dp - currentTimeMillis;
                    long j3 = dq - dp;
                    dVar2 = this.eK;
                    int dt = dVar2.dt();
                    long j4 = dr - dq;
                    r9 = dj - dq;
                    long j5 = dr - dj;
                    long j6 = ds - dr;
                    newInstance = this.eI.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.eH);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.eH.getCmd(), this.eJ);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.eI.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.eK.e(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.eI.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.eK.g(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.eH.getStartTime();
            long dp2 = this.eK.dp();
            long dq2 = this.eK.dq();
            long dj2 = this.eK.dj();
            long dr2 = this.eK.dr();
            long ds2 = this.eK.ds();
            long j7 = currentTimeMillis - startTime2;
            long j22 = dp2 - currentTimeMillis;
            long j32 = dq2 - dp2;
            dVar2 = this.eK;
            int dt2 = dVar2.dt();
            long j42 = dr2 - dq2;
            r9 = dj2 - dq2;
            long j52 = dr2 - dj2;
            long j62 = ds2 - dr2;
            try {
                newInstance = this.eI.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.eI.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.eH.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.eH.getCmd(), this.eH);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.eJ.dv().contentLength);
            } else {
                String str = "";
                if (this.eJ.dw().size() > 0) {
                    String str2 = this.eJ.dw().get(this.eJ.dw().size() - 1).lQ;
                    this.eH.setEncodedBinarySize(this.eJ.dw().get(this.eJ.dw().size() - 1).lJ);
                    str = str2;
                }
                newInstance.setStatusCode(this.eJ.dv().responseCode, str);
                newInstance.setHeader(this.eJ.dv().mj);
                newInstance.setContentEncoding(this.eJ.dv().contentEncoding);
                newInstance.setContentLength(this.eJ.dv().contentLength);
                newInstance.setContentType(this.eJ.dv().contentType);
                newInstance.setDownSize(this.eJ.dv().ml);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.eH);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.eH.getCmd(), this.eJ.dv().mk);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.gW = j7;
                        newInstance.performanceData.hi = j32;
                        newInstance.performanceData.hh = dt2;
                        newInstance.performanceData.gX = j22;
                        newInstance.performanceData.gY = j42;
                        newInstance.performanceData.gZ = r9;
                        newInstance.performanceData.ha = j52;
                        newInstance.performanceData.hb = j62;
                        newInstance.performanceData.hc = currentTimeMillis2 - ds2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.eH.getCmd(), this.eJ.dv().mk);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.eH.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.eH.getExtra();
                    newInstance.performanceData.hf = netMessage.getSocketErrNo();
                    newInstance.performanceData.hg = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.eH.getCmd(), this.eJ);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.eH.getCmd(), this.eJ.dv().mk);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.eK != null) {
                this.eK.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.eD.dispatchResponsedMessage(responsedMessageArr[0]);
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
