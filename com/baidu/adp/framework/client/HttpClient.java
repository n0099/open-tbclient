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
        private HttpMessage lH;
        private HttpMessageTask lI;
        private final e lJ;
        private volatile c lK = null;

        public HttpMessage ew() {
            return this.lH;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.lH = null;
            this.lI = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.lH = httpMessage;
            this.lI = httpMessageTask;
            this.lJ = new e();
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
            if (HttpClient.this.lD.getController().b(this.lH, this.lI) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.lH.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.lJ.fJ().setUrl(this.lI.getUrl());
            this.lJ.fJ().setMethod(this.lI.getMethod());
            this.lJ.fJ().j(this.lH.getHeaders());
            this.lJ.fJ().i(encodeInBackGround);
            int timeOut = this.lI.getTimeOut().getTimeOut();
            int timeOut2 = this.lI.getConnectTimeOut().getTimeOut();
            int retry = this.lI.getRetry();
            boolean z3 = false;
            try {
                this.lK = new c(this.lJ);
                if (this.lI.getDownloadTask() != null && this.lI.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.lK.a(this.lI.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void j(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.lI.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.lI.getDownloadTask().getIsOverWrite());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.lH.getStartTime();
                        long fE = this.lK.fE();
                        long fF = this.lK.fF();
                        long fC = this.lK.fC();
                        long fG = this.lK.fG();
                        long fH = this.lK.fH();
                        long j = currentTimeMillis - startTime;
                        long j2 = fE - currentTimeMillis;
                        long j3 = fF - fE;
                        int fI = this.lK.fI();
                        long j4 = fG - fF;
                        long j5 = fC - fF;
                        long j6 = fG - fC;
                        if (fH > 0) {
                        }
                        newInstance = this.lI.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.lH);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.lH.getCmd(), this.lJ);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.lI.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.lK.c(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.lI.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.lK.e(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.lH.getStartTime();
            long fE2 = this.lK.fE();
            long fF2 = this.lK.fF();
            long fC2 = this.lK.fC();
            long fG2 = this.lK.fG();
            long fH2 = this.lK.fH();
            long j7 = currentTimeMillis - startTime2;
            long j22 = fE2 - currentTimeMillis;
            long j32 = fF2 - fE2;
            int fI2 = this.lK.fI();
            long j42 = fG2 - fF2;
            long j52 = fC2 - fF2;
            long j62 = fG2 - fC2;
            long j8 = fH2 > 0 ? 0L : fH2 - fG2;
            try {
                newInstance = this.lI.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.lI.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.lH.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.lH.getCmd(), this.lH);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.lJ.fK().contentLength);
            } else {
                String str = "";
                if (this.lJ.fL().size() > 0) {
                    String str2 = this.lJ.fL().get(this.lJ.fL().size() - 1).exception;
                    this.lH.setEncodedBinarySize(this.lJ.fL().get(this.lJ.fL().size() - 1).oT);
                    str = str2;
                }
                newInstance.setStatusCode(this.lJ.fK().responseCode, str);
                newInstance.setHeader(this.lJ.fK().pA);
                newInstance.setContentEncoding(this.lJ.fK().contentEncoding);
                newInstance.setContentLength(this.lJ.fK().contentLength);
                newInstance.setContentType(this.lJ.fK().contentType);
                newInstance.setDownSize(this.lJ.fK().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.lH);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.lH.getCmd(), this.lJ.fK().retBytes);
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
                        newInstance.beforeDispatchInBackGround(this.lH.getCmd(), this.lJ.fK().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.lH.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.lH.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.lH.getCmd(), this.lJ);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.lH.getCmd(), this.lJ.fK().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.lK != null) {
                this.lK.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.lD.dispatchResponsedMessage(responsedMessageArr[0]);
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
