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
                linkedList.add(((a) next).ew());
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
        private HttpMessage lf;
        private HttpMessageTask lg;
        private final e lh;
        private volatile c li = null;

        public HttpMessage ew() {
            return this.lf;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.lf = null;
            this.lg = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.lf = httpMessage;
            this.lg = httpMessageTask;
            this.lh = new e();
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
            if (HttpClient.this.lb.getController().b(this.lf, this.lg) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.lf.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.lh.fJ().setUrl(this.lg.getUrl());
            this.lh.fJ().setMethod(this.lg.getMethod());
            this.lh.fJ().j(this.lf.getHeaders());
            this.lh.fJ().i(encodeInBackGround);
            int timeOut = this.lg.getTimeOut().getTimeOut();
            int timeOut2 = this.lg.getConnectTimeOut().getTimeOut();
            int retry = this.lg.getRetry();
            boolean z3 = false;
            try {
                this.li = new c(this.lh);
                if (this.lg.getDownloadTask() != null && this.lg.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.li.a(this.lg.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void h(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.lg.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.lg.getDownloadTask().getIsOverWrite());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.lf.getStartTime();
                        long fE = this.li.fE();
                        long fF = this.li.fF();
                        long fC = this.li.fC();
                        long fG = this.li.fG();
                        long fH = this.li.fH();
                        long j = currentTimeMillis - startTime;
                        long j2 = fE - currentTimeMillis;
                        long j3 = fF - fE;
                        int fI = this.li.fI();
                        long j4 = fG - fF;
                        long j5 = fC - fF;
                        long j6 = fG - fC;
                        if (fH > 0) {
                        }
                        newInstance = this.lg.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.lf);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.lf.getCmd(), this.lh);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.lg.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.li.c(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.lg.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.li.e(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.lf.getStartTime();
            long fE2 = this.li.fE();
            long fF2 = this.li.fF();
            long fC2 = this.li.fC();
            long fG2 = this.li.fG();
            long fH2 = this.li.fH();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fE2 - currentTimeMillis;
            long j32 = fF2 - fE2;
            int fI2 = this.li.fI();
            long j42 = fG2 - fF2;
            long j52 = fC2 - fF2;
            long j62 = fG2 - fC2;
            long j8 = fH2 > 0 ? 0L : fH2 - fG2;
            try {
                newInstance = this.lg.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.lg.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.lf.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.lf.getCmd(), this.lf);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.lh.fK().contentLength);
            } else {
                String str = "";
                if (this.lh.fL().size() > 0) {
                    String str2 = this.lh.fL().get(this.lh.fL().size() - 1).exception;
                    this.lf.setEncodedBinarySize(this.lh.fL().get(this.lh.fL().size() - 1).ou);
                    str = str2;
                }
                newInstance.setStatusCode(this.lh.fK().responseCode, str);
                newInstance.setHeader(this.lh.fK().oU);
                newInstance.setContentEncoding(this.lh.fK().contentEncoding);
                newInstance.setContentLength(this.lh.fK().contentLength);
                newInstance.setContentType(this.lh.fK().contentType);
                newInstance.setDownSize(this.lh.fK().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.lf);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.lf.getCmd(), this.lh.fK().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j7;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = fI2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j8;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - fH2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.lf.getCmd(), this.lh.fK().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.lf.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.lf.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.lf.getCmd(), this.lh);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.lf.getCmd(), this.lh.fK().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.li != null) {
                this.li.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.lb.dispatchResponsedMessage(responsedMessageArr[0]);
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
