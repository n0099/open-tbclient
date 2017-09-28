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
                linkedList.add(((a) next).cr());
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
        private HttpMessage nF;
        private HttpMessageTask nG;
        private final e nH;
        private volatile c nI = null;

        public HttpMessage cr() {
            return this.nF;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.nF = null;
            this.nG = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.nF = httpMessage;
            this.nG = httpMessageTask;
            this.nH = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.nF.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.nH.fy().setUrl(this.nG.getUrl());
            this.nH.fy().setMethod(this.nG.getMethod());
            this.nH.fy().d(this.nF.getHeaders());
            this.nH.fy().f(encodeInBackGround);
            int timeOut = this.nG.getTimeOut().getTimeOut();
            int timeOut2 = this.nG.getConnectTimeOut().getTimeOut();
            int retry = this.nG.getRetry();
            boolean z3 = false;
            try {
                this.nI = new c(this.nH);
                if (this.nG.getDownloadTask() != null && this.nG.getDownloadTask().dx() != null) {
                    try {
                        z2 = this.nI.a(this.nG.getDownloadTask().dx(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.nG.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.nG.getDownloadTask().dy());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.nF.getStartTime();
                        long ft = this.nI.ft();
                        long fu = this.nI.fu();
                        long fm = this.nI.fm();
                        long fv = this.nI.fv();
                        long fw = this.nI.fw();
                        long j = currentTimeMillis - startTime;
                        long j2 = ft - currentTimeMillis;
                        long j3 = fu - ft;
                        int fx = this.nI.fx();
                        long j4 = fv - fu;
                        long j5 = fm - fu;
                        long j6 = fv - fm;
                        long j7 = fw - fv;
                        newInstance = this.nG.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.nF);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.nF.getCmd(), this.nH);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.nG.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.nI.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.nG.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.nI.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.nF.getStartTime();
            long ft2 = this.nI.ft();
            long fu2 = this.nI.fu();
            long fm2 = this.nI.fm();
            long fv2 = this.nI.fv();
            long fw2 = this.nI.fw();
            long j8 = currentTimeMillis - startTime2;
            long j22 = ft2 - currentTimeMillis;
            long j32 = fu2 - ft2;
            int fx2 = this.nI.fx();
            long j42 = fv2 - fu2;
            long j52 = fm2 - fu2;
            long j62 = fv2 - fm2;
            long j72 = fw2 - fv2;
            try {
                newInstance = this.nG.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.nG.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.nF.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.nF.getCmd(), this.nF);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.nH.fz().contentLength);
            } else {
                String str = "";
                if (this.nH.fA().size() > 0) {
                    String str2 = this.nH.fA().get(this.nH.fA().size() - 1).uX;
                    this.nF.setEncodedBinarySize(this.nH.fA().get(this.nH.fA().size() - 1).uR);
                    str = str2;
                }
                newInstance.setStatusCode(this.nH.fz().responseCode, str);
                newInstance.setHeader(this.nH.fz().vp);
                newInstance.setContentEncoding(this.nH.fz().contentEncoding);
                newInstance.setContentLength(this.nH.fz().contentLength);
                newInstance.setContentType(this.nH.fz().contentType);
                newInstance.setDownSize(this.nH.fz().vr);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.nF);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.nF.getCmd(), this.nH.fz().vq);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qg = j8;
                        newInstance.performanceData.qr = j32;
                        newInstance.performanceData.qq = fx2;
                        newInstance.performanceData.qh = j22;
                        newInstance.performanceData.qi = j42;
                        newInstance.performanceData.qj = j52;
                        newInstance.performanceData.qk = j62;
                        newInstance.performanceData.ql = j72;
                        newInstance.performanceData.qm = currentTimeMillis2 - fw2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.nF.getCmd(), this.nH.fz().vq);
                    } catch (Exception e6) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.nF.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.nF.getExtra();
                    newInstance.performanceData.qo = netMessage.getSocketErrNo();
                    newInstance.performanceData.qp = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.nF.getCmd(), this.nH);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.nF.getCmd(), this.nH.fz().vq);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.nI != null) {
                this.nI.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.nB.dispatchResponsedMessage(responsedMessageArr[0]);
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
