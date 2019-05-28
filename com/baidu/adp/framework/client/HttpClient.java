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
        private HttpMessage tE;
        private HttpMessageTask tF;
        private final e tG;
        private volatile c tH = null;

        public HttpMessage fd() {
            return this.tE;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.tE = null;
            this.tF = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.tE = httpMessage;
            this.tF = httpMessageTask;
            this.tG = new e();
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
            if (HttpClient.this.tA.getController().b(this.tE, this.tF) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.tE.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.tG.ik().setUrl(this.tF.getUrl());
            this.tG.ik().setMethod(this.tF.getMethod());
            this.tG.ik().j(this.tE.getHeaders());
            this.tG.ik().j(encodeInBackGround);
            int timeOut = this.tF.getTimeOut().getTimeOut();
            int timeOut2 = this.tF.getConnectTimeOut().getTimeOut();
            int retry = this.tF.getRetry();
            boolean z3 = false;
            try {
                this.tH = new c(this.tG);
                if (this.tF.getDownloadTask() != null && this.tF.getDownloadTask().gj() != null) {
                    try {
                        z2 = this.tH.a(this.tF.getDownloadTask().gj(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.tF.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.tF.getDownloadTask().gk());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.tE.getStartTime();
                        long m9if = this.tH.m9if();
                        long ig = this.tH.ig();
                        long hY = this.tH.hY();
                        long ih = this.tH.ih();
                        long ii = this.tH.ii();
                        long j = currentTimeMillis - startTime;
                        long j2 = m9if - currentTimeMillis;
                        long j3 = ig - m9if;
                        int ij = this.tH.ij();
                        long j4 = ih - ig;
                        long j5 = hY - ig;
                        long j6 = ih - hY;
                        if (ii > 0) {
                        }
                        newInstance = this.tF.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.tE);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.tE.getCmd(), this.tG);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.tF.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.tH.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.tF.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.tH.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.tE.getStartTime();
            long m9if2 = this.tH.m9if();
            long ig2 = this.tH.ig();
            long hY2 = this.tH.hY();
            long ih2 = this.tH.ih();
            long ii2 = this.tH.ii();
            long j7 = currentTimeMillis - startTime2;
            long j22 = m9if2 - currentTimeMillis;
            long j32 = ig2 - m9if2;
            int ij2 = this.tH.ij();
            long j42 = ih2 - ig2;
            long j52 = hY2 - ig2;
            long j62 = ih2 - hY2;
            long j8 = ii2 > 0 ? 0L : ii2 - ih2;
            try {
                newInstance = this.tF.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.tF.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.tE.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.tE.getCmd(), this.tE);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.tG.il().contentLength);
            } else {
                String str = "";
                if (this.tG.im().size() > 0) {
                    String str2 = this.tG.im().get(this.tG.im().size() - 1).Au;
                    this.tE.setEncodedBinarySize(this.tG.im().get(this.tG.im().size() - 1).Ao);
                    str = str2;
                }
                newInstance.setStatusCode(this.tG.il().responseCode, str);
                newInstance.setHeader(this.tG.il().AN);
                newInstance.setContentEncoding(this.tG.il().contentEncoding);
                newInstance.setContentLength(this.tG.il().contentLength);
                newInstance.setContentType(this.tG.il().contentType);
                newInstance.setDownSize(this.tG.il().AP);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.tE);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.tE.getCmd(), this.tG.il().AO);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vU = j7;
                        newInstance.performanceData.wg = j32;
                        newInstance.performanceData.wf = ij2;
                        newInstance.performanceData.vV = j22;
                        newInstance.performanceData.vW = j42;
                        newInstance.performanceData.vX = j52;
                        newInstance.performanceData.vY = j62;
                        newInstance.performanceData.vZ = j8;
                        newInstance.performanceData.wa = currentTimeMillis2 - ii2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.tE.getCmd(), this.tG.il().AO);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.tE.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.tE.getExtra();
                    newInstance.performanceData.wc = netMessage.getSocketErrNo();
                    newInstance.performanceData.we = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.tE.getCmd(), this.tG);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.tE.getCmd(), this.tG.il().AO);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.tH != null) {
                this.tH.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.tA.dispatchResponsedMessage(responsedMessageArr[0]);
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
