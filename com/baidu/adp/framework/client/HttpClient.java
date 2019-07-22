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
                linkedList.add(((a) next).fk());
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
        private HttpMessage tG;
        private HttpMessageTask tH;
        private final e tI;
        private volatile c tJ = null;

        public HttpMessage fk() {
            return this.tG;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.tG = null;
            this.tH = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.tG = httpMessage;
            this.tH = httpMessageTask;
            this.tI = new e();
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
            if (HttpClient.this.tC.getController().b(this.tG, this.tH) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.tG.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.tI.iu().setUrl(this.tH.getUrl());
            this.tI.iu().setMethod(this.tH.getMethod());
            this.tI.iu().j(this.tG.getHeaders());
            this.tI.iu().j(encodeInBackGround);
            int timeOut = this.tH.getTimeOut().getTimeOut();
            int timeOut2 = this.tH.getConnectTimeOut().getTimeOut();
            int retry = this.tH.getRetry();
            boolean z3 = false;
            try {
                this.tJ = new c(this.tI);
                if (this.tH.getDownloadTask() != null && this.tH.getDownloadTask().gs() != null) {
                    try {
                        z2 = this.tJ.a(this.tH.getDownloadTask().gs(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void o(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.tH.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.tH.getDownloadTask().gt());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.tG.getStartTime();
                        long ip = this.tJ.ip();
                        long iq = this.tJ.iq();
                        long ii = this.tJ.ii();
                        long ir = this.tJ.ir();
                        long is = this.tJ.is();
                        long j = currentTimeMillis - startTime;
                        long j2 = ip - currentTimeMillis;
                        long j3 = iq - ip;
                        int it = this.tJ.it();
                        long j4 = ir - iq;
                        long j5 = ii - iq;
                        long j6 = ir - ii;
                        if (is > 0) {
                        }
                        newInstance = this.tH.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.tG);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.tG.getCmd(), this.tI);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.tH.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.tJ.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.tH.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.tJ.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.tG.getStartTime();
            long ip2 = this.tJ.ip();
            long iq2 = this.tJ.iq();
            long ii2 = this.tJ.ii();
            long ir2 = this.tJ.ir();
            long is2 = this.tJ.is();
            long j7 = currentTimeMillis - startTime2;
            long j22 = ip2 - currentTimeMillis;
            long j32 = iq2 - ip2;
            int it2 = this.tJ.it();
            long j42 = ir2 - iq2;
            long j52 = ii2 - iq2;
            long j62 = ir2 - ii2;
            long j8 = is2 > 0 ? 0L : is2 - ir2;
            try {
                newInstance = this.tH.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.tH.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.tG.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.tG.getCmd(), this.tG);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.tI.iv().contentLength);
            } else {
                String str = "";
                if (this.tI.iw().size() > 0) {
                    String str2 = this.tI.iw().get(this.tI.iw().size() - 1).Az;
                    this.tG.setEncodedBinarySize(this.tI.iw().get(this.tI.iw().size() - 1).At);
                    str = str2;
                }
                newInstance.setStatusCode(this.tI.iv().responseCode, str);
                newInstance.setHeader(this.tI.iv().AT);
                newInstance.setContentEncoding(this.tI.iv().contentEncoding);
                newInstance.setContentLength(this.tI.iv().contentLength);
                newInstance.setContentType(this.tI.iv().contentType);
                newInstance.setDownSize(this.tI.iv().AV);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.tG);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.tG.getCmd(), this.tI.iv().AU);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vW = j7;
                        newInstance.performanceData.wi = j32;
                        newInstance.performanceData.wh = it2;
                        newInstance.performanceData.vX = j22;
                        newInstance.performanceData.vY = j42;
                        newInstance.performanceData.vZ = j52;
                        newInstance.performanceData.wa = j62;
                        newInstance.performanceData.wb = j8;
                        newInstance.performanceData.wc = currentTimeMillis2 - is2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.tG.getCmd(), this.tI.iv().AU);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.tG.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.tG.getExtra();
                    newInstance.performanceData.wf = netMessage.getSocketErrNo();
                    newInstance.performanceData.wg = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.tG.getCmd(), this.tI);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.tG.getCmd(), this.tI.iv().AU);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.tJ != null) {
                this.tJ.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.tC.dispatchResponsedMessage(responsedMessageArr[0]);
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
