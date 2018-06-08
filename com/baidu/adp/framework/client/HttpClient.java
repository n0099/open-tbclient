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
                linkedList.add(((a) next).eO());
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
        private HttpMessage sU;
        private HttpMessageTask sV;
        private final e sW;
        private volatile c sX = null;

        public HttpMessage eO() {
            return this.sU;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.sU = null;
            this.sV = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.sU = httpMessage;
            this.sV = httpMessageTask;
            this.sW = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.sU.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.sW.hV().setUrl(this.sV.getUrl());
            this.sW.hV().setMethod(this.sV.getMethod());
            this.sW.hV().g(this.sU.getHeaders());
            this.sW.hV().j(encodeInBackGround);
            int timeOut = this.sV.getTimeOut().getTimeOut();
            int timeOut2 = this.sV.getConnectTimeOut().getTimeOut();
            int retry = this.sV.getRetry();
            boolean z3 = false;
            try {
                this.sX = new c(this.sW);
                if (this.sV.getDownloadTask() != null && this.sV.getDownloadTask().fU() != null) {
                    try {
                        z2 = this.sX.a(this.sV.getDownloadTask().fU(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.sV.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.sV.getDownloadTask().fV());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.sU.getStartTime();
                        long hQ = this.sX.hQ();
                        long hR = this.sX.hR();
                        long hL = this.sX.hL();
                        long hS = this.sX.hS();
                        long hT = this.sX.hT();
                        long j = currentTimeMillis - startTime;
                        long j2 = hQ - currentTimeMillis;
                        long j3 = hR - hQ;
                        int hU = this.sX.hU();
                        long j4 = hS - hR;
                        long j5 = hL - hR;
                        long j6 = hS - hL;
                        if (hT > 0) {
                        }
                        newInstance = this.sV.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.sU);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.sU.getCmd(), this.sW);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.sV.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.sX.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.sV.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.sX.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.sU.getStartTime();
            long hQ2 = this.sX.hQ();
            long hR2 = this.sX.hR();
            long hL2 = this.sX.hL();
            long hS2 = this.sX.hS();
            long hT2 = this.sX.hT();
            long j7 = currentTimeMillis - startTime2;
            long j22 = hQ2 - currentTimeMillis;
            long j32 = hR2 - hQ2;
            int hU2 = this.sX.hU();
            long j42 = hS2 - hR2;
            long j52 = hL2 - hR2;
            long j62 = hS2 - hL2;
            long j8 = hT2 > 0 ? 0L : hT2 - hS2;
            try {
                newInstance = this.sV.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.sV.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.sU.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.sU.getCmd(), this.sU);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.sW.hW().contentLength);
            } else {
                String str = "";
                if (this.sW.hX().size() > 0) {
                    String str2 = this.sW.hX().get(this.sW.hX().size() - 1).zK;
                    this.sU.setEncodedBinarySize(this.sW.hX().get(this.sW.hX().size() - 1).zE);
                    str = str2;
                }
                newInstance.setStatusCode(this.sW.hW().responseCode, str);
                newInstance.setHeader(this.sW.hW().Ac);
                newInstance.setContentEncoding(this.sW.hW().contentEncoding);
                newInstance.setContentLength(this.sW.hW().contentLength);
                newInstance.setContentType(this.sW.hW().contentType);
                newInstance.setDownSize(this.sW.hW().Af);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.sU);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.sU.getCmd(), this.sW.hW().Ae);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vq = j7;
                        newInstance.performanceData.vB = j32;
                        newInstance.performanceData.vA = hU2;
                        newInstance.performanceData.vr = j22;
                        newInstance.performanceData.vs = j42;
                        newInstance.performanceData.vt = j52;
                        newInstance.performanceData.vu = j62;
                        newInstance.performanceData.vv = j8;
                        newInstance.performanceData.vw = currentTimeMillis2 - hT2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.sU.getCmd(), this.sW.hW().Ae);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.sU.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.sU.getExtra();
                    newInstance.performanceData.vy = netMessage.getSocketErrNo();
                    newInstance.performanceData.vz = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.sU.getCmd(), this.sW);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.sU.getCmd(), this.sW.hW().Ae);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.sX != null) {
                this.sX.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.sQ.dispatchResponsedMessage(responsedMessageArr[0]);
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
