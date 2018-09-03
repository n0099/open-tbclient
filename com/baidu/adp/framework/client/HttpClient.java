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
                linkedList.add(((a) next).eN());
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
        private HttpMessage sL;
        private HttpMessageTask sM;
        private final e sN;
        private volatile c sO = null;

        public HttpMessage eN() {
            return this.sL;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.sL = null;
            this.sM = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.sL = httpMessage;
            this.sM = httpMessageTask;
            this.sN = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.sL.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.sN.hW().setUrl(this.sM.getUrl());
            this.sN.hW().setMethod(this.sM.getMethod());
            this.sN.hW().g(this.sL.getHeaders());
            this.sN.hW().j(encodeInBackGround);
            int timeOut = this.sM.getTimeOut().getTimeOut();
            int timeOut2 = this.sM.getConnectTimeOut().getTimeOut();
            int retry = this.sM.getRetry();
            boolean z3 = false;
            try {
                this.sO = new c(this.sN);
                if (this.sM.getDownloadTask() != null && this.sM.getDownloadTask().fT() != null) {
                    try {
                        z2 = this.sO.a(this.sM.getDownloadTask().fT(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.sM.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.sM.getDownloadTask().fU());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.sL.getStartTime();
                        long hR = this.sO.hR();
                        long hS = this.sO.hS();
                        long hL = this.sO.hL();
                        long hT = this.sO.hT();
                        long hU = this.sO.hU();
                        long j = currentTimeMillis - startTime;
                        long j2 = hR - currentTimeMillis;
                        long j3 = hS - hR;
                        int hV = this.sO.hV();
                        long j4 = hT - hS;
                        long j5 = hL - hS;
                        long j6 = hT - hL;
                        if (hU > 0) {
                        }
                        newInstance = this.sM.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.sL);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.sL.getCmd(), this.sN);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.sM.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.sO.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.sM.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.sO.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.sL.getStartTime();
            long hR2 = this.sO.hR();
            long hS2 = this.sO.hS();
            long hL2 = this.sO.hL();
            long hT2 = this.sO.hT();
            long hU2 = this.sO.hU();
            long j7 = currentTimeMillis - startTime2;
            long j22 = hR2 - currentTimeMillis;
            long j32 = hS2 - hR2;
            int hV2 = this.sO.hV();
            long j42 = hT2 - hS2;
            long j52 = hL2 - hS2;
            long j62 = hT2 - hL2;
            long j8 = hU2 > 0 ? 0L : hU2 - hT2;
            try {
                newInstance = this.sM.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.sM.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.sL.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.sL.getCmd(), this.sL);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.sN.hX().contentLength);
            } else {
                String str = "";
                if (this.sN.hY().size() > 0) {
                    String str2 = this.sN.hY().get(this.sN.hY().size() - 1).zE;
                    this.sL.setEncodedBinarySize(this.sN.hY().get(this.sN.hY().size() - 1).zy);
                    str = str2;
                }
                newInstance.setStatusCode(this.sN.hX().responseCode, str);
                newInstance.setHeader(this.sN.hX().zW);
                newInstance.setContentEncoding(this.sN.hX().contentEncoding);
                newInstance.setContentLength(this.sN.hX().contentLength);
                newInstance.setContentType(this.sN.hX().contentType);
                newInstance.setDownSize(this.sN.hX().zY);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.sL);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.sL.getCmd(), this.sN.hX().zX);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vh = j7;
                        newInstance.performanceData.vs = j32;
                        newInstance.performanceData.vr = hV2;
                        newInstance.performanceData.vi = j22;
                        newInstance.performanceData.vj = j42;
                        newInstance.performanceData.vk = j52;
                        newInstance.performanceData.vl = j62;
                        newInstance.performanceData.vm = j8;
                        newInstance.performanceData.vn = currentTimeMillis2 - hU2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.sL.getCmd(), this.sN.hX().zX);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.sL.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.sL.getExtra();
                    newInstance.performanceData.vp = netMessage.getSocketErrNo();
                    newInstance.performanceData.vq = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.sL.getCmd(), this.sN);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.sL.getCmd(), this.sN.hX().zX);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.sO != null) {
                this.sO.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.sH.dispatchResponsedMessage(responsedMessageArr[0]);
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
