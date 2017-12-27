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
import org.apache.http.HttpStatus;
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
                linkedList.add(((a) next).jW());
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
        private HttpMessage acr;
        private HttpMessageTask acs;
        private final e act;
        private volatile c acu = null;

        public HttpMessage jW() {
            return this.acr;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.acr = null;
            this.acs = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.acr = httpMessage;
            this.acs = httpMessageTask;
            this.act = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.acr.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.act.na().setUrl(this.acs.getUrl());
            this.act.na().setMethod(this.acs.getMethod());
            this.act.na().c(this.acr.getHeaders());
            this.act.na().p(encodeInBackGround);
            int timeOut = this.acs.getTimeOut().getTimeOut();
            int timeOut2 = this.acs.getConnectTimeOut().getTimeOut();
            int retry = this.acs.getRetry();
            boolean z3 = false;
            try {
                this.acu = new c(this.act);
                if (this.acs.getDownloadTask() != null && this.acs.getDownloadTask().lb() != null) {
                    try {
                        z2 = this.acu.a(this.acs.getDownloadTask().lb(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void an(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.acs.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.acs.getDownloadTask().lc());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.acr.getStartTime();
                        long mV = this.acu.mV();
                        long mW = this.acu.mW();
                        long mP = this.acu.mP();
                        long mX = this.acu.mX();
                        long mY = this.acu.mY();
                        long j = currentTimeMillis - startTime;
                        long j2 = mV - currentTimeMillis;
                        long j3 = mW - mV;
                        int mZ = this.acu.mZ();
                        long j4 = mX - mW;
                        long j5 = mP - mW;
                        long j6 = mX - mP;
                        long j7 = mY - mX;
                        newInstance = this.acs.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.acr);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.acr.getCmd(), this.act);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.acs.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.acu.m(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.acs.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.acu.o(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.acr.getStartTime();
            long mV2 = this.acu.mV();
            long mW2 = this.acu.mW();
            long mP2 = this.acu.mP();
            long mX2 = this.acu.mX();
            long mY2 = this.acu.mY();
            long j8 = currentTimeMillis - startTime2;
            long j22 = mV2 - currentTimeMillis;
            long j32 = mW2 - mV2;
            int mZ2 = this.acu.mZ();
            long j42 = mX2 - mW2;
            long j52 = mP2 - mW2;
            long j62 = mX2 - mP2;
            long j72 = mY2 - mX2;
            try {
                newInstance = this.acs.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.acs.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.acr.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.acr.getCmd(), this.acr);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.act.nb().contentLength);
            } else {
                String str = "";
                if (this.act.nc().size() > 0) {
                    String str2 = this.act.nc().get(this.act.nc().size() - 1).ajj;
                    this.acr.setEncodedBinarySize(this.act.nc().get(this.act.nc().size() - 1).ajd);
                    str = str2;
                }
                newInstance.setStatusCode(this.act.nb().responseCode, str);
                newInstance.setHeader(this.act.nb().ajB);
                newInstance.setContentEncoding(this.act.nb().contentEncoding);
                newInstance.setContentLength(this.act.nb().contentLength);
                newInstance.setContentType(this.act.nb().contentType);
                newInstance.setDownSize(this.act.nb().ajD);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.acr);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.acr.getCmd(), this.act.nb().ajC);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.aeI = j8;
                        newInstance.performanceData.aeT = j32;
                        newInstance.performanceData.aeS = mZ2;
                        newInstance.performanceData.aeJ = j22;
                        newInstance.performanceData.aeK = j42;
                        newInstance.performanceData.aeL = j52;
                        newInstance.performanceData.aeM = j62;
                        newInstance.performanceData.aeN = j72;
                        newInstance.performanceData.aeO = currentTimeMillis2 - mY2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.acr.getCmd(), this.act.nb().ajC);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.acr.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.acr.getExtra();
                    newInstance.performanceData.aeQ = netMessage.getSocketErrNo();
                    newInstance.performanceData.aeR = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.acr.getCmd(), this.act);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.acr.getCmd(), this.act.nb().ajC);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.acu != null) {
                this.acu.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.acn.dispatchResponsedMessage(responsedMessageArr[0]);
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
