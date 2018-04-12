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
                linkedList.add(((a) next).ca());
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
        private final e mA;
        private volatile c mB = null;
        private HttpMessage my;
        private HttpMessageTask mz;

        public HttpMessage ca() {
            return this.my;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.my = null;
            this.mz = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.my = httpMessage;
            this.mz = httpMessageTask;
            this.mA = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.my.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.mA.fe().setUrl(this.mz.getUrl());
            this.mA.fe().setMethod(this.mz.getMethod());
            this.mA.fe().g(this.my.getHeaders());
            this.mA.fe().g(encodeInBackGround);
            int timeOut = this.mz.getTimeOut().getTimeOut();
            int timeOut2 = this.mz.getConnectTimeOut().getTimeOut();
            int retry = this.mz.getRetry();
            boolean z3 = false;
            try {
                this.mB = new c(this.mA);
                if (this.mz.getDownloadTask() != null && this.mz.getDownloadTask().df() != null) {
                    try {
                        z2 = this.mB.a(this.mz.getDownloadTask().df(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.mz.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.mz.getDownloadTask().dg());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.my.getStartTime();
                        long eZ = this.mB.eZ();
                        long fa = this.mB.fa();
                        long eU = this.mB.eU();
                        long fb = this.mB.fb();
                        long fc = this.mB.fc();
                        long j = currentTimeMillis - startTime;
                        long j2 = eZ - currentTimeMillis;
                        long j3 = fa - eZ;
                        int fd = this.mB.fd();
                        long j4 = fb - fa;
                        long j5 = eU - fa;
                        long j6 = fb - eU;
                        long j7 = fc - fb;
                        newInstance = this.mz.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.my);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.my.getCmd(), this.mA);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.mz.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.mB.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.mz.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.mB.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.my.getStartTime();
            long eZ2 = this.mB.eZ();
            long fa2 = this.mB.fa();
            long eU2 = this.mB.eU();
            long fb2 = this.mB.fb();
            long fc2 = this.mB.fc();
            long j8 = currentTimeMillis - startTime2;
            long j22 = eZ2 - currentTimeMillis;
            long j32 = fa2 - eZ2;
            int fd2 = this.mB.fd();
            long j42 = fb2 - fa2;
            long j52 = eU2 - fa2;
            long j62 = fb2 - eU2;
            long j72 = fc2 - fb2;
            try {
                newInstance = this.mz.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.mz.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.my.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.my.getCmd(), this.my);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.mA.ff().contentLength);
            } else {
                String str = "";
                if (this.mA.fg().size() > 0) {
                    String str2 = this.mA.fg().get(this.mA.fg().size() - 1).tG;
                    this.my.setEncodedBinarySize(this.mA.fg().get(this.mA.fg().size() - 1).tA);
                    str = str2;
                }
                newInstance.setStatusCode(this.mA.ff().responseCode, str);
                newInstance.setHeader(this.mA.ff().tY);
                newInstance.setContentEncoding(this.mA.ff().contentEncoding);
                newInstance.setContentLength(this.mA.ff().contentLength);
                newInstance.setContentType(this.mA.ff().contentType);
                newInstance.setDownSize(this.mA.ff().ub);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.my);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.my.getCmd(), this.mA.ff().tZ);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.oV = j8;
                        newInstance.performanceData.pi = j32;
                        newInstance.performanceData.ph = fd2;
                        newInstance.performanceData.oW = j22;
                        newInstance.performanceData.oX = j42;
                        newInstance.performanceData.oY = j52;
                        newInstance.performanceData.oZ = j62;
                        newInstance.performanceData.pa = j72;
                        newInstance.performanceData.pd = currentTimeMillis2 - fc2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.my.getCmd(), this.mA.ff().tZ);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.my.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.my.getExtra();
                    newInstance.performanceData.pf = netMessage.getSocketErrNo();
                    newInstance.performanceData.pg = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.my.getCmd(), this.mA);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.my.getCmd(), this.mA.ff().tZ);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mB != null) {
                this.mB.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.mt.dispatchResponsedMessage(responsedMessageArr[0]);
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
