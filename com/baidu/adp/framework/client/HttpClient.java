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
                linkedList.add(((a) next).go());
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
        private HttpMessage wa;
        private HttpMessageTask wb;
        private final e wc;
        private volatile c we = null;

        public HttpMessage go() {
            return this.wa;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.wa = null;
            this.wb = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.wa = httpMessage;
            this.wb = httpMessageTask;
            this.wc = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.wa.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.wc.jp().setUrl(this.wb.getUrl());
            this.wc.jp().setMethod(this.wb.getMethod());
            this.wc.jp().l(this.wa.getHeaders());
            this.wc.jp().j(encodeInBackGround);
            int timeOut = this.wb.getTimeOut().getTimeOut();
            int timeOut2 = this.wb.getConnectTimeOut().getTimeOut();
            int retry = this.wb.getRetry();
            boolean z3 = false;
            try {
                this.we = new c(this.wc);
                if (this.wb.getDownloadTask() != null && this.wb.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z2 = this.we.a(this.wb.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void o(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.wb.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.wb.getDownloadTask().hs());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.wa.getStartTime();
                        long jk = this.we.jk();
                        long jl = this.we.jl();
                        long je = this.we.je();
                        long jm = this.we.jm();
                        long jn = this.we.jn();
                        long j = currentTimeMillis - startTime;
                        long j2 = jk - currentTimeMillis;
                        long j3 = jl - jk;
                        int jo = this.we.jo();
                        long j4 = jm - jl;
                        long j5 = je - jl;
                        long j6 = jm - je;
                        if (jn > 0) {
                        }
                        newInstance = this.wb.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.wa);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.wa.getCmd(), this.wc);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.wb.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.we.e(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.wb.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.we.g(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.wa.getStartTime();
            long jk2 = this.we.jk();
            long jl2 = this.we.jl();
            long je2 = this.we.je();
            long jm2 = this.we.jm();
            long jn2 = this.we.jn();
            long j7 = currentTimeMillis - startTime2;
            long j22 = jk2 - currentTimeMillis;
            long j32 = jl2 - jk2;
            int jo2 = this.we.jo();
            long j42 = jm2 - jl2;
            long j52 = je2 - jl2;
            long j62 = jm2 - je2;
            long j8 = jn2 > 0 ? 0L : jn2 - jm2;
            try {
                newInstance = this.wb.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.wb.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.wa.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.wa.getCmd(), this.wa);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.wc.jq().contentLength);
            } else {
                String str = "";
                if (this.wc.jr().size() > 0) {
                    String str2 = this.wc.jr().get(this.wc.jr().size() - 1).CL;
                    this.wa.setEncodedBinarySize(this.wc.jr().get(this.wc.jr().size() - 1).CF);
                    str = str2;
                }
                newInstance.setStatusCode(this.wc.jq().responseCode, str);
                newInstance.setHeader(this.wc.jq().Df);
                newInstance.setContentEncoding(this.wc.jq().contentEncoding);
                newInstance.setContentLength(this.wc.jq().contentLength);
                newInstance.setContentType(this.wc.jq().contentType);
                newInstance.setDownSize(this.wc.jq().Dh);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.wa);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.wa.getCmd(), this.wc.jq().Dg);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.yp = j7;
                        newInstance.performanceData.yA = j32;
                        newInstance.performanceData.yz = jo2;
                        newInstance.performanceData.yq = j22;
                        newInstance.performanceData.yr = j42;
                        newInstance.performanceData.ys = j52;
                        newInstance.performanceData.yt = j62;
                        newInstance.performanceData.yu = j8;
                        newInstance.performanceData.yv = currentTimeMillis2 - jn2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.wa.getCmd(), this.wc.jq().Dg);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.wa.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.wa.getExtra();
                    newInstance.performanceData.yx = netMessage.getSocketErrNo();
                    newInstance.performanceData.yy = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.wa.getCmd(), this.wc);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.wa.getCmd(), this.wc.jq().Dg);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.we != null) {
                this.we.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.vW.dispatchResponsedMessage(responsedMessageArr[0]);
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
