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
        private HttpMessage acj;
        private HttpMessageTask ack;
        private final e acl;
        private volatile c acm = null;

        public HttpMessage jW() {
            return this.acj;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.acj = null;
            this.ack = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.acj = httpMessage;
            this.ack = httpMessageTask;
            this.acl = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.acj.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.acl.nb().setUrl(this.ack.getUrl());
            this.acl.nb().setMethod(this.ack.getMethod());
            this.acl.nb().g(this.acj.getHeaders());
            this.acl.nb().p(encodeInBackGround);
            int timeOut = this.ack.getTimeOut().getTimeOut();
            int timeOut2 = this.ack.getConnectTimeOut().getTimeOut();
            int retry = this.ack.getRetry();
            boolean z3 = false;
            try {
                this.acm = new c(this.acl);
                if (this.ack.getDownloadTask() != null && this.ack.getDownloadTask().lb() != null) {
                    try {
                        z2 = this.acm.a(this.ack.getDownloadTask().lb(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void an(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.ack.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.ack.getDownloadTask().lc());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.acj.getStartTime();
                        long mW = this.acm.mW();
                        long mX = this.acm.mX();
                        long mQ = this.acm.mQ();
                        long mY = this.acm.mY();
                        long mZ = this.acm.mZ();
                        long j = currentTimeMillis - startTime;
                        long j2 = mW - currentTimeMillis;
                        long j3 = mX - mW;
                        int na = this.acm.na();
                        long j4 = mY - mX;
                        long j5 = mQ - mX;
                        long j6 = mY - mQ;
                        long j7 = mZ - mY;
                        newInstance = this.ack.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.acj);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.acj.getCmd(), this.acl);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.ack.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.acm.m(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.ack.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.acm.o(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.acj.getStartTime();
            long mW2 = this.acm.mW();
            long mX2 = this.acm.mX();
            long mQ2 = this.acm.mQ();
            long mY2 = this.acm.mY();
            long mZ2 = this.acm.mZ();
            long j8 = currentTimeMillis - startTime2;
            long j22 = mW2 - currentTimeMillis;
            long j32 = mX2 - mW2;
            int na2 = this.acm.na();
            long j42 = mY2 - mX2;
            long j52 = mQ2 - mX2;
            long j62 = mY2 - mQ2;
            long j72 = mZ2 - mY2;
            try {
                newInstance = this.ack.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.ack.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.acj.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.acj.getCmd(), this.acj);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.acl.nc().contentLength);
            } else {
                String str = "";
                if (this.acl.nd().size() > 0) {
                    String str2 = this.acl.nd().get(this.acl.nd().size() - 1).ajf;
                    this.acj.setEncodedBinarySize(this.acl.nd().get(this.acl.nd().size() - 1).aiZ);
                    str = str2;
                }
                newInstance.setStatusCode(this.acl.nc().responseCode, str);
                newInstance.setHeader(this.acl.nc().ajx);
                newInstance.setContentEncoding(this.acl.nc().contentEncoding);
                newInstance.setContentLength(this.acl.nc().contentLength);
                newInstance.setContentType(this.acl.nc().contentType);
                newInstance.setDownSize(this.acl.nc().ajz);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.acj);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.acj.getCmd(), this.acl.nc().ajy);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.aeA = j8;
                        newInstance.performanceData.aeL = j32;
                        newInstance.performanceData.aeK = na2;
                        newInstance.performanceData.aeB = j22;
                        newInstance.performanceData.aeC = j42;
                        newInstance.performanceData.aeD = j52;
                        newInstance.performanceData.aeE = j62;
                        newInstance.performanceData.aeF = j72;
                        newInstance.performanceData.aeG = currentTimeMillis2 - mZ2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.acj.getCmd(), this.acl.nc().ajy);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.acj.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.acj.getExtra();
                    newInstance.performanceData.aeI = netMessage.getSocketErrNo();
                    newInstance.performanceData.aeJ = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.acj.getCmd(), this.acl);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.acj.getCmd(), this.acl.nc().ajy);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.acm != null) {
                this.acm.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.acf.dispatchResponsedMessage(responsedMessageArr[0]);
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
