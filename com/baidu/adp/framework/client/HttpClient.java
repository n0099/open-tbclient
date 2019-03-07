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
                linkedList.add(((a) next).gl());
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
        private HttpMessage vW;
        private HttpMessageTask vX;
        private final e vY;
        private volatile c vZ = null;

        public HttpMessage gl() {
            return this.vW;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.vW = null;
            this.vX = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.vW = httpMessage;
            this.vX = httpMessageTask;
            this.vY = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:13:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0204 A[Catch: Exception -> 0x039b, TRY_LEAVE, TryCatch #1 {Exception -> 0x039b, blocks: (B:29:0x01fd, B:31:0x0204), top: B:68:0x01fd }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x02c5  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x03a9  */
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.vW.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.vY.jr().setUrl(this.vX.getUrl());
            this.vY.jr().setMethod(this.vX.getMethod());
            this.vY.jr().k(this.vW.getHeaders());
            this.vY.jr().j(encodeInBackGround);
            int timeOut = this.vX.getTimeOut().getTimeOut();
            int timeOut2 = this.vX.getConnectTimeOut().getTimeOut();
            int retry = this.vX.getRetry();
            boolean z3 = false;
            try {
                this.vZ = new c(this.vY);
                if (this.vX.getDownloadTask() != null && this.vX.getDownloadTask().hp() != null) {
                    try {
                        z2 = this.vZ.a(this.vX.getDownloadTask().hp(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void o(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.vX.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.vX.getDownloadTask().hq());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.vW.getStartTime();
                        long jm = this.vZ.jm();
                        long jn = this.vZ.jn();
                        long jg = this.vZ.jg();
                        long jo = this.vZ.jo();
                        long jp = this.vZ.jp();
                        long j = currentTimeMillis - startTime;
                        long j2 = jm - currentTimeMillis;
                        long j3 = jn - jm;
                        int jq = this.vZ.jq();
                        long j4 = jo - jn;
                        long j5 = jg - jn;
                        long j6 = jo - jg;
                        if (jp > 0) {
                        }
                        newInstance = this.vX.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.vW);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.vW.getCmd(), this.vY);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.vX.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.vZ.e(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.vX.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.vZ.g(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.vW.getStartTime();
            long jm2 = this.vZ.jm();
            long jn2 = this.vZ.jn();
            long jg2 = this.vZ.jg();
            long jo2 = this.vZ.jo();
            long jp2 = this.vZ.jp();
            long j7 = currentTimeMillis - startTime2;
            long j22 = jm2 - currentTimeMillis;
            long j32 = jn2 - jm2;
            int jq2 = this.vZ.jq();
            long j42 = jo2 - jn2;
            long j52 = jg2 - jn2;
            long j62 = jo2 - jg2;
            long j8 = jp2 > 0 ? 0L : jp2 - jo2;
            try {
                newInstance = this.vX.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.vX.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.vW.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.vW.getCmd(), this.vW);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.vY.js().contentLength);
            } else {
                String str = "";
                if (this.vY.jt().size() > 0) {
                    String str2 = this.vY.jt().get(this.vY.jt().size() - 1).CK;
                    this.vW.setEncodedBinarySize(this.vY.jt().get(this.vY.jt().size() - 1).CE);
                    str = str2;
                }
                newInstance.setStatusCode(this.vY.js().responseCode, str);
                newInstance.setHeader(this.vY.js().De);
                newInstance.setContentEncoding(this.vY.js().contentEncoding);
                newInstance.setContentLength(this.vY.js().contentLength);
                newInstance.setContentType(this.vY.js().contentType);
                newInstance.setDownSize(this.vY.js().Dg);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.vW);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.vW.getCmd(), this.vY.js().Df);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.ym = j7;
                        newInstance.performanceData.yx = j32;
                        newInstance.performanceData.yw = jq2;
                        newInstance.performanceData.yn = j22;
                        newInstance.performanceData.yo = j42;
                        newInstance.performanceData.yp = j52;
                        newInstance.performanceData.yq = j62;
                        newInstance.performanceData.yr = j8;
                        newInstance.performanceData.ys = currentTimeMillis2 - jp2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.vW.getCmd(), this.vY.js().Df);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.vW.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.vW.getExtra();
                    newInstance.performanceData.yu = netMessage.getSocketErrNo();
                    newInstance.performanceData.yv = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.vW.getCmd(), this.vY);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.vW.getCmd(), this.vY.js().Df);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.vZ != null) {
                this.vZ.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.vS.dispatchResponsedMessage(responsedMessageArr[0]);
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
