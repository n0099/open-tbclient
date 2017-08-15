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
                linkedList.add(((a) next).cC());
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
        private HttpMessage pW;
        private HttpMessageTask pX;
        private final e pY;
        private volatile c pZ = null;

        public HttpMessage cC() {
            return this.pW;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.pW = null;
            this.pX = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.pW = httpMessage;
            this.pX = httpMessageTask;
            this.pY = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01fb A[Catch: Exception -> 0x0392, TRY_LEAVE, TryCatch #5 {Exception -> 0x0392, blocks: (B:27:0x01f4, B:29:0x01fb), top: B:72:0x01f4 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x02bc  */
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.pW.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.pY.fJ().setUrl(this.pX.getUrl());
            this.pY.fJ().setMethod(this.pX.getMethod());
            this.pY.fJ().d(this.pW.getHeaders());
            this.pY.fJ().f(encodeInBackGround);
            int timeOut = this.pX.getTimeOut().getTimeOut();
            int timeOut2 = this.pX.getConnectTimeOut().getTimeOut();
            int retry = this.pX.getRetry();
            boolean z3 = false;
            try {
                this.pZ = new c(this.pY);
                if (this.pX.getDownloadTask() != null && this.pX.getDownloadTask().dH() != null) {
                    try {
                        z2 = this.pZ.a(this.pX.getDownloadTask().dH(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void n(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.pX.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.pX.getDownloadTask().dI());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.pW.getStartTime();
                        long fE = this.pZ.fE();
                        long fF = this.pZ.fF();
                        long fy = this.pZ.fy();
                        long fG = this.pZ.fG();
                        long fH = this.pZ.fH();
                        long j = currentTimeMillis - startTime;
                        long j2 = fE - currentTimeMillis;
                        long j3 = fF - fE;
                        int fI = this.pZ.fI();
                        long j4 = fG - fF;
                        long j5 = fy - fF;
                        long j6 = fG - fy;
                        long j7 = fH - fG;
                        newInstance = this.pX.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.pW);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.pW.getCmd(), this.pY);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.pX.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.pZ.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.pX.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.pZ.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.pW.getStartTime();
            long fE2 = this.pZ.fE();
            long fF2 = this.pZ.fF();
            long fy2 = this.pZ.fy();
            long fG2 = this.pZ.fG();
            long fH2 = this.pZ.fH();
            long j8 = currentTimeMillis - startTime2;
            long j22 = fE2 - currentTimeMillis;
            long j32 = fF2 - fE2;
            int fI2 = this.pZ.fI();
            long j42 = fG2 - fF2;
            long j52 = fy2 - fF2;
            long j62 = fG2 - fy2;
            long j72 = fH2 - fG2;
            try {
                newInstance = this.pX.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.pX.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.pW.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.pW.getCmd(), this.pW);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.pY.fK().contentLength);
            } else {
                String str = "";
                if (this.pY.fL().size() > 0) {
                    String str2 = this.pY.fL().get(this.pY.fL().size() - 1).xe;
                    this.pW.setEncodedBinarySize(this.pY.fL().get(this.pY.fL().size() - 1).wZ);
                    str = str2;
                }
                newInstance.setStatusCode(this.pY.fK().responseCode, str);
                newInstance.setHeader(this.pY.fK().xw);
                newInstance.setContentEncoding(this.pY.fK().contentEncoding);
                newInstance.setContentLength(this.pY.fK().contentLength);
                newInstance.setContentType(this.pY.fK().contentType);
                newInstance.setDownSize(this.pY.fK().xy);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.pW);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.pW.getCmd(), this.pY.fK().xx);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.sq = j8;
                        newInstance.performanceData.sC = j32;
                        newInstance.performanceData.sB = fI2;
                        newInstance.performanceData.sr = j22;
                        newInstance.performanceData.ss = j42;
                        newInstance.performanceData.su = j52;
                        newInstance.performanceData.sv = j62;
                        newInstance.performanceData.sw = j72;
                        newInstance.performanceData.sx = currentTimeMillis2 - fH2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.pW.getCmd(), this.pY.fK().xx);
                    } catch (Exception e6) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.pW.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.pW.getExtra();
                    newInstance.performanceData.sz = netMessage.getSocketErrNo();
                    newInstance.performanceData.sA = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.pW.getCmd(), this.pY);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.pW.getCmd(), this.pY.fK().xx);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.pZ != null) {
                this.pZ.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.pS.dispatchResponsedMessage(responsedMessageArr[0]);
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
