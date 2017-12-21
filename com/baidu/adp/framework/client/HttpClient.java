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
        private HttpMessage nG;
        private HttpMessageTask nH;
        private final e nI;
        private volatile c nJ = null;

        public HttpMessage cr() {
            return this.nG;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.nG = null;
            this.nH = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.nG = httpMessage;
            this.nH = httpMessageTask;
            this.nI = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.nG.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.nI.fy().setUrl(this.nH.getUrl());
            this.nI.fy().setMethod(this.nH.getMethod());
            this.nI.fy().d(this.nG.getHeaders());
            this.nI.fy().f(encodeInBackGround);
            int timeOut = this.nH.getTimeOut().getTimeOut();
            int timeOut2 = this.nH.getConnectTimeOut().getTimeOut();
            int retry = this.nH.getRetry();
            boolean z3 = false;
            try {
                this.nJ = new c(this.nI);
                if (this.nH.getDownloadTask() != null && this.nH.getDownloadTask().dx() != null) {
                    try {
                        z2 = this.nJ.a(this.nH.getDownloadTask().dx(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.nH.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.nH.getDownloadTask().dy());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.nG.getStartTime();
                        long ft = this.nJ.ft();
                        long fu = this.nJ.fu();
                        long fm = this.nJ.fm();
                        long fv = this.nJ.fv();
                        long fw = this.nJ.fw();
                        long j = currentTimeMillis - startTime;
                        long j2 = ft - currentTimeMillis;
                        long j3 = fu - ft;
                        int fx = this.nJ.fx();
                        long j4 = fv - fu;
                        long j5 = fm - fu;
                        long j6 = fv - fm;
                        long j7 = fw - fv;
                        newInstance = this.nH.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.nG);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.nG.getCmd(), this.nI);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.nH.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.nJ.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.nH.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.nJ.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.nG.getStartTime();
            long ft2 = this.nJ.ft();
            long fu2 = this.nJ.fu();
            long fm2 = this.nJ.fm();
            long fv2 = this.nJ.fv();
            long fw2 = this.nJ.fw();
            long j8 = currentTimeMillis - startTime2;
            long j22 = ft2 - currentTimeMillis;
            long j32 = fu2 - ft2;
            int fx2 = this.nJ.fx();
            long j42 = fv2 - fu2;
            long j52 = fm2 - fu2;
            long j62 = fv2 - fm2;
            long j72 = fw2 - fv2;
            try {
                newInstance = this.nH.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.nH.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.nG.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.nG.getCmd(), this.nG);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.nI.fz().contentLength);
            } else {
                String str = "";
                if (this.nI.fA().size() > 0) {
                    String str2 = this.nI.fA().get(this.nI.fA().size() - 1).uW;
                    this.nG.setEncodedBinarySize(this.nI.fA().get(this.nI.fA().size() - 1).uQ);
                    str = str2;
                }
                newInstance.setStatusCode(this.nI.fz().responseCode, str);
                newInstance.setHeader(this.nI.fz().vo);
                newInstance.setContentEncoding(this.nI.fz().contentEncoding);
                newInstance.setContentLength(this.nI.fz().contentLength);
                newInstance.setContentType(this.nI.fz().contentType);
                newInstance.setDownSize(this.nI.fz().vq);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.nG);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.nG.getCmd(), this.nI.fz().vp);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qh = j8;
                        newInstance.performanceData.qt = j32;
                        newInstance.performanceData.qs = fx2;
                        newInstance.performanceData.qi = j22;
                        newInstance.performanceData.qj = j42;
                        newInstance.performanceData.ql = j52;
                        newInstance.performanceData.qm = j62;
                        newInstance.performanceData.qn = j72;
                        newInstance.performanceData.qo = currentTimeMillis2 - fw2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.nG.getCmd(), this.nI.fz().vp);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.nG.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.nG.getExtra();
                    newInstance.performanceData.qq = netMessage.getSocketErrNo();
                    newInstance.performanceData.qr = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.nG.getCmd(), this.nI);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.nG.getCmd(), this.nI.fz().vp);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.nJ != null) {
                this.nJ.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.nC.dispatchResponsedMessage(responsedMessageArr[0]);
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
