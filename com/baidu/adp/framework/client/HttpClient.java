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
        private HttpMessage GK;
        private HttpMessageTask GL;
        private final e GM;
        private volatile c GN = null;

        public HttpMessage jw() {
            return this.GK;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.GK = null;
            this.GL = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.GK = httpMessage;
            this.GL = httpMessageTask;
            this.GM = new e();
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
            if (HttpClient.this.GG.getController().b(this.GK, this.GL) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.GK.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.GM.kB().setUrl(this.GL.getUrl());
            this.GM.kB().setMethod(this.GL.getMethod());
            this.GM.kB().v(this.GK.getHeaders());
            this.GM.kB().k(encodeInBackGround);
            int timeOut = this.GL.getTimeOut().getTimeOut();
            int timeOut2 = this.GL.getConnectTimeOut().getTimeOut();
            int retry = this.GL.getRetry();
            boolean z3 = false;
            try {
                this.GN = new c(this.GM);
                if (this.GL.getDownloadTask() != null && this.GL.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.GN.a(this.GL.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.GL.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.GL.getDownloadTask().getIsOverWrite());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.GK.getStartTime();
                        long kw = this.GN.kw();
                        long kx = this.GN.kx();
                        long ku = this.GN.ku();
                        long ky = this.GN.ky();
                        long kz = this.GN.kz();
                        long j = currentTimeMillis - startTime;
                        long j2 = kw - currentTimeMillis;
                        long j3 = kx - kw;
                        int kA = this.GN.kA();
                        long j4 = ky - kx;
                        long j5 = ku - kx;
                        long j6 = ky - ku;
                        if (kz > 0) {
                        }
                        newInstance = this.GL.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.GK);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.GK.getCmd(), this.GM);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.GL.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.GN.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.GL.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.GN.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.GK.getStartTime();
            long kw2 = this.GN.kw();
            long kx2 = this.GN.kx();
            long ku2 = this.GN.ku();
            long ky2 = this.GN.ky();
            long kz2 = this.GN.kz();
            long j7 = currentTimeMillis - startTime2;
            long j22 = kw2 - currentTimeMillis;
            long j32 = kx2 - kw2;
            int kA2 = this.GN.kA();
            long j42 = ky2 - kx2;
            long j52 = ku2 - kx2;
            long j62 = ky2 - ku2;
            long j8 = kz2 > 0 ? 0L : kz2 - ky2;
            try {
                newInstance = this.GL.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.GL.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.GK.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.GK.getCmd(), this.GK);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.GM.kC().contentLength);
            } else {
                String str = "";
                if (this.GM.kD().size() > 0) {
                    String str2 = this.GM.kD().get(this.GM.kD().size() - 1).exception;
                    this.GK.setEncodedBinarySize(this.GM.kD().get(this.GM.kD().size() - 1).JM);
                    str = str2;
                }
                newInstance.setStatusCode(this.GM.kC().responseCode, str);
                newInstance.setHeader(this.GM.kC().Kq);
                newInstance.setContentEncoding(this.GM.kC().contentEncoding);
                newInstance.setContentLength(this.GM.kC().contentLength);
                newInstance.setContentType(this.GM.kC().contentType);
                newInstance.setDownSize(this.GM.kC().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.GK);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.GK.getCmd(), this.GM.kC().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j7;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = kA2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j8;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - kz2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.GK.getCmd(), this.GM.kC().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.GK.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.GK.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.GK.getCmd(), this.GM);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.GK.getCmd(), this.GM.kC().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.GN != null) {
                this.GN.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.GG.dispatchResponsedMessage(responsedMessageArr[0]);
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
