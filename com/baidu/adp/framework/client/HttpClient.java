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
        private HttpMessage sS;
        private HttpMessageTask sT;
        private final e sU;
        private volatile c sV = null;

        public HttpMessage eO() {
            return this.sS;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.sS = null;
            this.sT = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.sS = httpMessage;
            this.sT = httpMessageTask;
            this.sU = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.sS.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.sU.hV().setUrl(this.sT.getUrl());
            this.sU.hV().setMethod(this.sT.getMethod());
            this.sU.hV().g(this.sS.getHeaders());
            this.sU.hV().j(encodeInBackGround);
            int timeOut = this.sT.getTimeOut().getTimeOut();
            int timeOut2 = this.sT.getConnectTimeOut().getTimeOut();
            int retry = this.sT.getRetry();
            boolean z3 = false;
            try {
                this.sV = new c(this.sU);
                if (this.sT.getDownloadTask() != null && this.sT.getDownloadTask().fU() != null) {
                    try {
                        z2 = this.sV.a(this.sT.getDownloadTask().fU(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void m(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.sT.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.sT.getDownloadTask().fV());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.sS.getStartTime();
                        long hQ = this.sV.hQ();
                        long hR = this.sV.hR();
                        long hL = this.sV.hL();
                        long hS = this.sV.hS();
                        long hT = this.sV.hT();
                        long j = currentTimeMillis - startTime;
                        long j2 = hQ - currentTimeMillis;
                        long j3 = hR - hQ;
                        int hU = this.sV.hU();
                        long j4 = hS - hR;
                        long j5 = hL - hR;
                        long j6 = hS - hL;
                        if (hT > 0) {
                        }
                        newInstance = this.sT.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.sS);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.sS.getCmd(), this.sU);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.sT.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.sV.d(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.sT.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.sV.f(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.sS.getStartTime();
            long hQ2 = this.sV.hQ();
            long hR2 = this.sV.hR();
            long hL2 = this.sV.hL();
            long hS2 = this.sV.hS();
            long hT2 = this.sV.hT();
            long j7 = currentTimeMillis - startTime2;
            long j22 = hQ2 - currentTimeMillis;
            long j32 = hR2 - hQ2;
            int hU2 = this.sV.hU();
            long j42 = hS2 - hR2;
            long j52 = hL2 - hR2;
            long j62 = hS2 - hL2;
            long j8 = hT2 > 0 ? 0L : hT2 - hS2;
            try {
                newInstance = this.sT.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.sT.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.sS.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.sS.getCmd(), this.sS);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.sU.hW().contentLength);
            } else {
                String str = "";
                if (this.sU.hX().size() > 0) {
                    String str2 = this.sU.hX().get(this.sU.hX().size() - 1).zI;
                    this.sS.setEncodedBinarySize(this.sU.hX().get(this.sU.hX().size() - 1).zC);
                    str = str2;
                }
                newInstance.setStatusCode(this.sU.hW().responseCode, str);
                newInstance.setHeader(this.sU.hW().Aa);
                newInstance.setContentEncoding(this.sU.hW().contentEncoding);
                newInstance.setContentLength(this.sU.hW().contentLength);
                newInstance.setContentType(this.sU.hW().contentType);
                newInstance.setDownSize(this.sU.hW().Ac);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.sS);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.sS.getCmd(), this.sU.hW().Ab);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.vo = j7;
                        newInstance.performanceData.vz = j32;
                        newInstance.performanceData.vy = hU2;
                        newInstance.performanceData.vp = j22;
                        newInstance.performanceData.vq = j42;
                        newInstance.performanceData.vr = j52;
                        newInstance.performanceData.vs = j62;
                        newInstance.performanceData.vt = j8;
                        newInstance.performanceData.vu = currentTimeMillis2 - hT2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.sS.getCmd(), this.sU.hW().Ab);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.sS.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.sS.getExtra();
                    newInstance.performanceData.vw = netMessage.getSocketErrNo();
                    newInstance.performanceData.vx = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.sS.getCmd(), this.sU);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.sS.getCmd(), this.sU.hW().Ab);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.sV != null) {
                this.sV.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.sO.dispatchResponsedMessage(responsedMessageArr[0]);
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
