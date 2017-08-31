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
        private HttpMessage nE;
        private HttpMessageTask nF;
        private final e nG;
        private volatile c nH = null;

        public HttpMessage cr() {
            return this.nE;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.nE = null;
            this.nF = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.nE = httpMessage;
            this.nF = httpMessageTask;
            this.nG = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.nE.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.nG.fz().setUrl(this.nF.getUrl());
            this.nG.fz().setMethod(this.nF.getMethod());
            this.nG.fz().d(this.nE.getHeaders());
            this.nG.fz().f(encodeInBackGround);
            int timeOut = this.nF.getTimeOut().getTimeOut();
            int timeOut2 = this.nF.getConnectTimeOut().getTimeOut();
            int retry = this.nF.getRetry();
            boolean z3 = false;
            try {
                this.nH = new c(this.nG);
                if (this.nF.getDownloadTask() != null && this.nF.getDownloadTask().dx() != null) {
                    try {
                        z2 = this.nH.a(this.nF.getDownloadTask().dx(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.nF.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.nF.getDownloadTask().dy());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.nE.getStartTime();
                        long fu = this.nH.fu();
                        long fv = this.nH.fv();
                        long fn = this.nH.fn();
                        long fw = this.nH.fw();
                        long fx = this.nH.fx();
                        long j = currentTimeMillis - startTime;
                        long j2 = fu - currentTimeMillis;
                        long j3 = fv - fu;
                        int fy = this.nH.fy();
                        long j4 = fw - fv;
                        long j5 = fn - fv;
                        long j6 = fw - fn;
                        long j7 = fx - fw;
                        newInstance = this.nF.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.nE);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.nE.getCmd(), this.nG);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.nF.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.nH.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.nF.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.nH.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.nE.getStartTime();
            long fu2 = this.nH.fu();
            long fv2 = this.nH.fv();
            long fn2 = this.nH.fn();
            long fw2 = this.nH.fw();
            long fx2 = this.nH.fx();
            long j8 = currentTimeMillis - startTime2;
            long j22 = fu2 - currentTimeMillis;
            long j32 = fv2 - fu2;
            int fy2 = this.nH.fy();
            long j42 = fw2 - fv2;
            long j52 = fn2 - fv2;
            long j62 = fw2 - fn2;
            long j72 = fx2 - fw2;
            try {
                newInstance = this.nF.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.nF.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.nE.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.nE.getCmd(), this.nE);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.nG.fA().contentLength);
            } else {
                String str = "";
                if (this.nG.fB().size() > 0) {
                    String str2 = this.nG.fB().get(this.nG.fB().size() - 1).uV;
                    this.nE.setEncodedBinarySize(this.nG.fB().get(this.nG.fB().size() - 1).uP);
                    str = str2;
                }
                newInstance.setStatusCode(this.nG.fA().responseCode, str);
                newInstance.setHeader(this.nG.fA().vn);
                newInstance.setContentEncoding(this.nG.fA().contentEncoding);
                newInstance.setContentLength(this.nG.fA().contentLength);
                newInstance.setContentType(this.nG.fA().contentType);
                newInstance.setDownSize(this.nG.fA().vp);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.nE);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.nE.getCmd(), this.nG.fA().vo);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qf = j8;
                        newInstance.performanceData.qq = j32;
                        newInstance.performanceData.qp = fy2;
                        newInstance.performanceData.qg = j22;
                        newInstance.performanceData.qh = j42;
                        newInstance.performanceData.qi = j52;
                        newInstance.performanceData.qj = j62;
                        newInstance.performanceData.qk = j72;
                        newInstance.performanceData.ql = currentTimeMillis2 - fx2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.nE.getCmd(), this.nG.fA().vo);
                    } catch (Exception e6) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.nE.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.nE.getExtra();
                    newInstance.performanceData.qn = netMessage.getSocketErrNo();
                    newInstance.performanceData.qo = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.nE.getCmd(), this.nG);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.nE.getCmd(), this.nG.fA().vo);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.nH != null) {
                this.nH.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.nA.dispatchResponsedMessage(responsedMessageArr[0]);
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
