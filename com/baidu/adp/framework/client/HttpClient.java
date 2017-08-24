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
        private HttpMessage pX;
        private HttpMessageTask pY;
        private final e pZ;
        private volatile c qa = null;

        public HttpMessage cC() {
            return this.pX;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.pX = null;
            this.pY = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.pX = httpMessage;
            this.pY = httpMessageTask;
            this.pZ = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.pX.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.pZ.fJ().setUrl(this.pY.getUrl());
            this.pZ.fJ().setMethod(this.pY.getMethod());
            this.pZ.fJ().d(this.pX.getHeaders());
            this.pZ.fJ().f(encodeInBackGround);
            int timeOut = this.pY.getTimeOut().getTimeOut();
            int timeOut2 = this.pY.getConnectTimeOut().getTimeOut();
            int retry = this.pY.getRetry();
            boolean z3 = false;
            try {
                this.qa = new c(this.pZ);
                if (this.pY.getDownloadTask() != null && this.pY.getDownloadTask().dH() != null) {
                    try {
                        z2 = this.qa.a(this.pY.getDownloadTask().dH(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void n(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.pY.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.pY.getDownloadTask().dI());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.pX.getStartTime();
                        long fE = this.qa.fE();
                        long fF = this.qa.fF();
                        long fy = this.qa.fy();
                        long fG = this.qa.fG();
                        long fH = this.qa.fH();
                        long j = currentTimeMillis - startTime;
                        long j2 = fE - currentTimeMillis;
                        long j3 = fF - fE;
                        int fI = this.qa.fI();
                        long j4 = fG - fF;
                        long j5 = fy - fF;
                        long j6 = fG - fy;
                        long j7 = fH - fG;
                        newInstance = this.pY.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.pX);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.pX.getCmd(), this.pZ);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.pY.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.qa.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.pY.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.qa.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.pX.getStartTime();
            long fE2 = this.qa.fE();
            long fF2 = this.qa.fF();
            long fy2 = this.qa.fy();
            long fG2 = this.qa.fG();
            long fH2 = this.qa.fH();
            long j8 = currentTimeMillis - startTime2;
            long j22 = fE2 - currentTimeMillis;
            long j32 = fF2 - fE2;
            int fI2 = this.qa.fI();
            long j42 = fG2 - fF2;
            long j52 = fy2 - fF2;
            long j62 = fG2 - fy2;
            long j72 = fH2 - fG2;
            try {
                newInstance = this.pY.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.pY.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.pX.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.pX.getCmd(), this.pX);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.pZ.fK().contentLength);
            } else {
                String str = "";
                if (this.pZ.fL().size() > 0) {
                    String str2 = this.pZ.fL().get(this.pZ.fL().size() - 1).xe;
                    this.pX.setEncodedBinarySize(this.pZ.fL().get(this.pZ.fL().size() - 1).wZ);
                    str = str2;
                }
                newInstance.setStatusCode(this.pZ.fK().responseCode, str);
                newInstance.setHeader(this.pZ.fK().xw);
                newInstance.setContentEncoding(this.pZ.fK().contentEncoding);
                newInstance.setContentLength(this.pZ.fK().contentLength);
                newInstance.setContentType(this.pZ.fK().contentType);
                newInstance.setDownSize(this.pZ.fK().xy);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.pX);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.pX.getCmd(), this.pZ.fK().xx);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.sr = j8;
                        newInstance.performanceData.sD = j32;
                        newInstance.performanceData.sC = fI2;
                        newInstance.performanceData.ss = j22;
                        newInstance.performanceData.su = j42;
                        newInstance.performanceData.sv = j52;
                        newInstance.performanceData.sw = j62;
                        newInstance.performanceData.sx = j72;
                        newInstance.performanceData.sy = currentTimeMillis2 - fH2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.pX.getCmd(), this.pZ.fK().xx);
                    } catch (Exception e6) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.pX.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.pX.getExtra();
                    newInstance.performanceData.sA = netMessage.getSocketErrNo();
                    newInstance.performanceData.sB = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.pX.getCmd(), this.pZ);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.pX.getCmd(), this.pZ.fK().xx);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.qa != null) {
                this.qa.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.pT.dispatchResponsedMessage(responsedMessageArr[0]);
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
