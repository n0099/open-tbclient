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
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.h;
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
                linkedList.add(((a) next).jw());
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
        private HttpMessage GO;
        private HttpMessageTask GP;
        private final e GQ;
        private volatile c GR = null;

        public HttpMessage jw() {
            return this.GO;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.GO = null;
            this.GP = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.GO = httpMessage;
            this.GP = httpMessageTask;
            this.GQ = new e();
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
            if (HttpClient.this.GK.getController().b(this.GO, this.GP) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.GO.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.GQ.kD().setUrl(this.GP.getUrl());
            this.GQ.kD().setMethod(this.GP.getMethod());
            this.GQ.kD().v(this.GO.getHeaders());
            this.GQ.kD().k(encodeInBackGround);
            int timeOut = this.GP.getTimeOut().getTimeOut();
            int timeOut2 = this.GP.getConnectTimeOut().getTimeOut();
            int retry = this.GP.getRetry();
            boolean z3 = false;
            try {
                this.GR = new c(this.GQ);
                if (this.GP.getDownloadTask() != null && this.GP.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.GR.a(this.GP.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.GP.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.GP.getDownloadTask().getIsOverWrite());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.GO.getStartTime();
                        long ky = this.GR.ky();
                        long kz = this.GR.kz();
                        long kw = this.GR.kw();
                        long kA = this.GR.kA();
                        long kB = this.GR.kB();
                        long j = currentTimeMillis - startTime;
                        long j2 = ky - currentTimeMillis;
                        long j3 = kz - ky;
                        int kC = this.GR.kC();
                        long j4 = kA - kz;
                        long j5 = kw - kz;
                        long j6 = kA - kw;
                        if (kB > 0) {
                        }
                        newInstance = this.GP.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.GO);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.GO.getCmd(), this.GQ);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.GP.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.GR.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.GP.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.GR.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.GO.getStartTime();
            long ky2 = this.GR.ky();
            long kz2 = this.GR.kz();
            long kw2 = this.GR.kw();
            long kA2 = this.GR.kA();
            long kB2 = this.GR.kB();
            long j7 = currentTimeMillis - startTime2;
            long j22 = ky2 - currentTimeMillis;
            long j32 = kz2 - ky2;
            int kC2 = this.GR.kC();
            long j42 = kA2 - kz2;
            long j52 = kw2 - kz2;
            long j62 = kA2 - kw2;
            long j8 = kB2 > 0 ? 0L : kB2 - kA2;
            try {
                newInstance = this.GP.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.GP.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.GO.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.GO.getCmd(), this.GO);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.GQ.kE().contentLength);
            } else {
                String str = "";
                if (this.GQ.kF().size() > 0) {
                    String str2 = this.GQ.kF().get(this.GQ.kF().size() - 1).exception;
                    this.GO.setEncodedBinarySize(this.GQ.kF().get(this.GQ.kF().size() - 1).Kb);
                    str = str2;
                }
                newInstance.setStatusCode(this.GQ.kE().responseCode, str);
                newInstance.setHeader(this.GQ.kE().KF);
                newInstance.setContentEncoding(this.GQ.kE().contentEncoding);
                newInstance.setContentLength(this.GQ.kE().contentLength);
                newInstance.setContentType(this.GQ.kE().contentType);
                newInstance.setDownSize(this.GQ.kE().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.GO);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.GO.getCmd(), this.GQ.kE().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j7;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = kC2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j8;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - kB2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.GO.getCmd(), this.GQ.kE().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.GO.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.GO.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.GO.getCmd(), this.GQ);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.GO.getCmd(), this.GQ.kE().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.GR != null) {
                this.GR.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.GK.dispatchResponsedMessage(responsedMessageArr[0]);
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
