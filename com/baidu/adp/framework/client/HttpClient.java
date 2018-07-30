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
        private HttpMessage sK;
        private HttpMessageTask sL;
        private final e sM;
        private volatile c sN = null;

        public HttpMessage eN() {
            return this.sK;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.sK = null;
            this.sL = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.sK = httpMessage;
            this.sL = httpMessageTask;
            this.sM = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.sK.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.sM.hW().setUrl(this.sL.getUrl());
            this.sM.hW().setMethod(this.sL.getMethod());
            this.sM.hW().g(this.sK.getHeaders());
            this.sM.hW().j(encodeInBackGround);
            int timeOut = this.sL.getTimeOut().getTimeOut();
            int timeOut2 = this.sL.getConnectTimeOut().getTimeOut();
            int retry = this.sL.getRetry();
            boolean z3 = false;
            try {
                this.sN = new c(this.sM);
                if (this.sL.getDownloadTask() != null && this.sL.getDownloadTask().fT() != null) {
                    try {
                        z2 = this.sN.a(this.sL.getDownloadTask().fT(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.sL.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.sL.getDownloadTask().fU());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.sK.getStartTime();
                        long hR = this.sN.hR();
                        long hS = this.sN.hS();
                        long hL = this.sN.hL();
                        long hT = this.sN.hT();
                        long hU = this.sN.hU();
                        long j = currentTimeMillis - startTime;
                        long j2 = hR - currentTimeMillis;
                        long j3 = hS - hR;
                        int hV = this.sN.hV();
                        long j4 = hT - hS;
                        long j5 = hL - hS;
                        long j6 = hT - hL;
                        if (hU > 0) {
                        }
                        newInstance = this.sL.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.sK);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.sK.getCmd(), this.sM);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.sL.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.sN.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.sL.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.sN.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.sK.getStartTime();
            long hR2 = this.sN.hR();
            long hS2 = this.sN.hS();
            long hL2 = this.sN.hL();
            long hT2 = this.sN.hT();
            long hU2 = this.sN.hU();
            long j7 = currentTimeMillis - startTime2;
            long j22 = hR2 - currentTimeMillis;
            long j32 = hS2 - hR2;
            int hV2 = this.sN.hV();
            long j42 = hT2 - hS2;
            long j52 = hL2 - hS2;
            long j62 = hT2 - hL2;
            long j8 = hU2 > 0 ? 0L : hU2 - hT2;
            try {
                newInstance = this.sL.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.sL.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.sK.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.sK.getCmd(), this.sK);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.sM.hX().contentLength);
            } else {
                String str = "";
                if (this.sM.hY().size() > 0) {
                    String str2 = this.sM.hY().get(this.sM.hY().size() - 1).zD;
                    this.sK.setEncodedBinarySize(this.sM.hY().get(this.sM.hY().size() - 1).zx);
                    str = str2;
                }
                newInstance.setStatusCode(this.sM.hX().responseCode, str);
                newInstance.setHeader(this.sM.hX().zV);
                newInstance.setContentEncoding(this.sM.hX().contentEncoding);
                newInstance.setContentLength(this.sM.hX().contentLength);
                newInstance.setContentType(this.sM.hX().contentType);
                newInstance.setDownSize(this.sM.hX().zX);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.sK);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.sK.getCmd(), this.sM.hX().zW);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vg = j7;
                        newInstance.performanceData.vr = j32;
                        newInstance.performanceData.vq = hV2;
                        newInstance.performanceData.vh = j22;
                        newInstance.performanceData.vi = j42;
                        newInstance.performanceData.vj = j52;
                        newInstance.performanceData.vk = j62;
                        newInstance.performanceData.vl = j8;
                        newInstance.performanceData.vm = currentTimeMillis2 - hU2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.sK.getCmd(), this.sM.hX().zW);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.sK.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.sK.getExtra();
                    newInstance.performanceData.vo = netMessage.getSocketErrNo();
                    newInstance.performanceData.vp = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.sK.getCmd(), this.sM);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.sK.getCmd(), this.sM.hX().zW);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.sN != null) {
                this.sN.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.sG.dispatchResponsedMessage(responsedMessageArr[0]);
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
