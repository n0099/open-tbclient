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
                linkedList.add(((a) next).fd());
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
        private HttpMessage tD;
        private HttpMessageTask tE;
        private final e tF;
        private volatile c tG = null;

        public HttpMessage fd() {
            return this.tD;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.tD = null;
            this.tE = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.tD = httpMessage;
            this.tE = httpMessageTask;
            this.tF = new e();
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
            if (HttpClient.this.tz.getController().b(this.tD, this.tE) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.tD.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.tF.ik().setUrl(this.tE.getUrl());
            this.tF.ik().setMethod(this.tE.getMethod());
            this.tF.ik().j(this.tD.getHeaders());
            this.tF.ik().j(encodeInBackGround);
            int timeOut = this.tE.getTimeOut().getTimeOut();
            int timeOut2 = this.tE.getConnectTimeOut().getTimeOut();
            int retry = this.tE.getRetry();
            boolean z3 = false;
            try {
                this.tG = new c(this.tF);
                if (this.tE.getDownloadTask() != null && this.tE.getDownloadTask().gj() != null) {
                    try {
                        z2 = this.tG.a(this.tE.getDownloadTask().gj(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.tE.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.tE.getDownloadTask().gk());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.tD.getStartTime();
                        long m9if = this.tG.m9if();
                        long ig = this.tG.ig();
                        long hY = this.tG.hY();
                        long ih = this.tG.ih();
                        long ii = this.tG.ii();
                        long j = currentTimeMillis - startTime;
                        long j2 = m9if - currentTimeMillis;
                        long j3 = ig - m9if;
                        int ij = this.tG.ij();
                        long j4 = ih - ig;
                        long j5 = hY - ig;
                        long j6 = ih - hY;
                        if (ii > 0) {
                        }
                        newInstance = this.tE.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.tD);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.tD.getCmd(), this.tF);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.tE.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.tG.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.tE.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.tG.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.tD.getStartTime();
            long m9if2 = this.tG.m9if();
            long ig2 = this.tG.ig();
            long hY2 = this.tG.hY();
            long ih2 = this.tG.ih();
            long ii2 = this.tG.ii();
            long j7 = currentTimeMillis - startTime2;
            long j22 = m9if2 - currentTimeMillis;
            long j32 = ig2 - m9if2;
            int ij2 = this.tG.ij();
            long j42 = ih2 - ig2;
            long j52 = hY2 - ig2;
            long j62 = ih2 - hY2;
            long j8 = ii2 > 0 ? 0L : ii2 - ih2;
            try {
                newInstance = this.tE.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.tE.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.tD.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.tD.getCmd(), this.tD);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.tF.il().contentLength);
            } else {
                String str = "";
                if (this.tF.im().size() > 0) {
                    String str2 = this.tF.im().get(this.tF.im().size() - 1).At;
                    this.tD.setEncodedBinarySize(this.tF.im().get(this.tF.im().size() - 1).An);
                    str = str2;
                }
                newInstance.setStatusCode(this.tF.il().responseCode, str);
                newInstance.setHeader(this.tF.il().AM);
                newInstance.setContentEncoding(this.tF.il().contentEncoding);
                newInstance.setContentLength(this.tF.il().contentLength);
                newInstance.setContentType(this.tF.il().contentType);
                newInstance.setDownSize(this.tF.il().AO);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.tD);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.tD.getCmd(), this.tF.il().AN);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vT = j7;
                        newInstance.performanceData.wf = j32;
                        newInstance.performanceData.we = ij2;
                        newInstance.performanceData.vU = j22;
                        newInstance.performanceData.vV = j42;
                        newInstance.performanceData.vW = j52;
                        newInstance.performanceData.vX = j62;
                        newInstance.performanceData.vY = j8;
                        newInstance.performanceData.vZ = currentTimeMillis2 - ii2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.tD.getCmd(), this.tF.il().AN);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.tD.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.tD.getExtra();
                    newInstance.performanceData.wb = netMessage.getSocketErrNo();
                    newInstance.performanceData.wc = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.tD.getCmd(), this.tF);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.tD.getCmd(), this.tF.il().AN);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.tG != null) {
                this.tG.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.tz.dispatchResponsedMessage(responsedMessageArr[0]);
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
