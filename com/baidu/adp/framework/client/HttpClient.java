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
                linkedList.add(((a) next).cs());
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
        private HttpMessage oM;
        private HttpMessageTask oN;
        private final f oO;
        private volatile d oP = null;

        public HttpMessage cs() {
            return this.oM;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.oM = null;
            this.oN = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.oM = httpMessage;
            this.oN = httpMessageTask;
            this.oO = new f();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.oM.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.oO.fv().setUrl(this.oN.getUrl());
            this.oO.fv().setMethod(this.oN.getMethod());
            this.oO.fv().d(this.oM.getHeaders());
            this.oO.fv().d(encodeInBackGround);
            int timeOut = this.oN.getTimeOut().getTimeOut();
            int timeOut2 = this.oN.getConnectTimeOut().getTimeOut();
            int retry = this.oN.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.oP = new d(this.oO);
            } catch (Exception e) {
                e = e;
            }
            if (this.oN.getDownloadTask() != null && this.oN.getDownloadTask().dx() != null) {
                try {
                    z = this.oP.a(this.oN.getDownloadTask().dx(), new c(this), retry, timeOut, timeOut2, this.oN.getDownloadTask().dy());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.oM.getStartTime();
                    long fq = this.oP.fq();
                    long fr = this.oP.fr();
                    long fk = this.oP.fk();
                    long fs = this.oP.fs();
                    long ft = this.oP.ft();
                    long j = currentTimeMillis - startTime;
                    long j2 = fq - currentTimeMillis;
                    long j3 = fr - fq;
                    dVar2 = this.oP;
                    int fu = dVar2.fu();
                    long j4 = fs - fr;
                    r9 = fk - fr;
                    long j5 = fs - fk;
                    long j6 = ft - fs;
                    newInstance = this.oN.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.oM);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.oM.getCmd(), this.oO);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.oN.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.oP.d(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.oN.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.oP.f(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.oM.getStartTime();
            long fq2 = this.oP.fq();
            long fr2 = this.oP.fr();
            long fk2 = this.oP.fk();
            long fs2 = this.oP.fs();
            long ft2 = this.oP.ft();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fq2 - currentTimeMillis;
            long j32 = fr2 - fq2;
            dVar2 = this.oP;
            int fu2 = dVar2.fu();
            long j42 = fs2 - fr2;
            r9 = fk2 - fr2;
            long j52 = fs2 - fk2;
            long j62 = ft2 - fs2;
            try {
                newInstance = this.oN.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.oN.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oM.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.oM.getCmd(), this.oM);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oO.fw().contentLength);
            } else {
                String str = "";
                if (this.oO.fx().size() > 0) {
                    String str2 = this.oO.fx().get(this.oO.fx().size() - 1).vS;
                    this.oM.setEncodedBinarySize(this.oO.fx().get(this.oO.fx().size() - 1).vL);
                    str = str2;
                }
                newInstance.setStatusCode(this.oO.fw().responseCode, str);
                newInstance.setHeader(this.oO.fw().wk);
                newInstance.setContentEncoding(this.oO.fw().contentEncoding);
                newInstance.setContentLength(this.oO.fw().contentLength);
                newInstance.setContentType(this.oO.fw().contentType);
                newInstance.setDownSize(this.oO.fw().wm);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oM);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.oM.getCmd(), this.oO.fw().wl);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.re = j7;
                        newInstance.performanceData.rq = j32;
                        newInstance.performanceData.rp = fu2;
                        newInstance.performanceData.rf = j22;
                        newInstance.performanceData.rg = j42;
                        newInstance.performanceData.rh = r9;
                        newInstance.performanceData.ri = j52;
                        newInstance.performanceData.rj = j62;
                        newInstance.performanceData.rk = currentTimeMillis2 - ft2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.oM.getCmd(), this.oO.fw().wl);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.oM.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.oM.getExtra();
                    newInstance.performanceData.rm = netMessage.getSocketErrNo();
                    newInstance.performanceData.ro = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.oM.getCmd(), this.oO);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oM.getCmd(), this.oO.fw().wl);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.oP != null) {
                this.oP.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.oI.dispatchResponsedMessage(responsedMessageArr[0]);
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
