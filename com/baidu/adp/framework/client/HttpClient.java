package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpProgressResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.i;
import com.baidu.adp.lib.util.BdLog;
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
                linkedList.add(((a) next).eQ());
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
        private HttpMessage nC;
        private HttpMessageTask nD;
        private final f nE;
        private volatile c nF = null;

        public HttpMessage eQ() {
            return this.nC;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.nC = null;
            this.nD = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.nC = httpMessage;
            this.nD = httpMessageTask;
            this.nE = new f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0145  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x021e A[Catch: Exception -> 0x03b6, TRY_LEAVE, TryCatch #3 {Exception -> 0x03b6, blocks: (B:33:0x0217, B:35:0x021e), top: B:75:0x0217 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x02e0  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x03c4  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            Exception e;
            HttpResponsedMessage newInstance;
            boolean z2;
            if (HttpClient.this.ny.getController().b(this.nC, this.nD) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.nC.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.nE.fY().setUrl(this.nD.getUrl());
            this.nE.fY().setMethod(this.nD.getMethod());
            this.nE.fY().i(this.nC.getHeaders());
            this.nE.fY().h(encodeInBackGround);
            int timeOut = this.nD.getTimeOut().getTimeOut();
            int timeOut2 = this.nD.getConnectTimeOut().getTimeOut();
            int retry = this.nD.getRetry();
            boolean z3 = false;
            try {
                this.nF = new c(this.nE);
                if (this.nD.getDownloadTask() != null && this.nD.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.nF.a(this.nD.getDownloadTask().getDownloadPath(), new i() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.i
                            public void j(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.nD.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.nD.getDownloadTask().getIsOverWrite());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.nC.getStartTime();
                        long fS = this.nF.fS();
                        long fT = this.nF.fT();
                        long fQ = this.nF.fQ();
                        long fU = this.nF.fU();
                        long fV = this.nF.fV();
                        long j = currentTimeMillis - startTime;
                        long j2 = fS - currentTimeMillis;
                        long j3 = fT - fS;
                        int fW = this.nF.fW();
                        long j4 = fU - fT;
                        long j5 = fQ - fT;
                        long j6 = fU - fQ;
                        if (fV > 0) {
                        }
                        newInstance = this.nD.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.nC);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.nC.getCmd(), this.nE);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.nD.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.nF.c(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.nD.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.nF.e(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.nC.getStartTime();
            long fS2 = this.nF.fS();
            long fT2 = this.nF.fT();
            long fQ2 = this.nF.fQ();
            long fU2 = this.nF.fU();
            long fV2 = this.nF.fV();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fS2 - currentTimeMillis;
            long j32 = fT2 - fS2;
            int fW2 = this.nF.fW();
            long j42 = fU2 - fT2;
            long j52 = fQ2 - fT2;
            long j62 = fU2 - fQ2;
            long j8 = fV2 > 0 ? 0L : fV2 - fU2;
            try {
                newInstance = this.nD.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.nD.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.nC.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.nC.getCmd(), this.nC);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.nE.fZ().contentLength);
            } else {
                String str = "";
                if (this.nE.ga().size() > 0) {
                    String str2 = this.nE.ga().get(this.nE.ga().size() - 1).exception;
                    this.nC.setEncodedBinarySize(this.nE.ga().get(this.nE.ga().size() - 1).qN);
                    str = str2;
                }
                newInstance.setStatusCode(this.nE.fZ().responseCode, str);
                newInstance.setHeader(this.nE.fZ().rp);
                newInstance.setContentEncoding(this.nE.fZ().contentEncoding);
                newInstance.setContentLength(this.nE.fZ().contentLength);
                newInstance.setContentType(this.nE.fZ().contentType);
                newInstance.setDownSize(this.nE.fZ().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.nC);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.nC.getCmd(), this.nE.fZ().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j7;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = fW2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j8;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - fV2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.nC.getCmd(), this.nE.fZ().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.nC.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.nC.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.nC.getCmd(), this.nE);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.nC.getCmd(), this.nE.fZ().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.nF != null) {
                this.nF.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.ny.dispatchResponsedMessage(responsedMessageArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
