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
                linkedList.add(((a) next).fV());
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
        private HttpMessage vl;
        private HttpMessageTask vm;
        private final e vn;
        private volatile c vo = null;

        public HttpMessage fV() {
            return this.vl;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.vl = null;
            this.vm = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.vl = httpMessage;
            this.vm = httpMessageTask;
            this.vn = new e();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.vl.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.vn.jc().setUrl(this.vm.getUrl());
            this.vn.jc().setMethod(this.vm.getMethod());
            this.vn.jc().l(this.vl.getHeaders());
            this.vn.jc().j(encodeInBackGround);
            int timeOut = this.vm.getTimeOut().getTimeOut();
            int timeOut2 = this.vm.getConnectTimeOut().getTimeOut();
            int retry = this.vm.getRetry();
            boolean z3 = false;
            try {
                this.vo = new c(this.vn);
                if (this.vm.getDownloadTask() != null && this.vm.getDownloadTask().hb() != null) {
                    try {
                        z2 = this.vo.a(this.vm.getDownloadTask().hb(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void o(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.vm.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.vm.getDownloadTask().hc());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        long startTime = this.vl.getStartTime();
                        long iX = this.vo.iX();
                        long iY = this.vo.iY();
                        long iR = this.vo.iR();
                        long iZ = this.vo.iZ();
                        long ja = this.vo.ja();
                        long j = currentTimeMillis - startTime;
                        long j2 = iX - currentTimeMillis;
                        long j3 = iY - iX;
                        int jb = this.vo.jb();
                        long j4 = iZ - iY;
                        long j5 = iR - iY;
                        long j6 = iZ - iR;
                        if (ja > 0) {
                        }
                        newInstance = this.vm.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z) {
                        }
                        newInstance.setOrginalMessage(this.vl);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.vl.getCmd(), this.vn);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.vm.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.vo.e(retry, timeOut, timeOut2);
                    z = false;
                    z2 = false;
                } else {
                    if (this.vm.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.vo.g(retry, timeOut, timeOut2);
                    }
                    z = false;
                    z2 = false;
                }
                z3 = z2;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            long startTime2 = this.vl.getStartTime();
            long iX2 = this.vo.iX();
            long iY2 = this.vo.iY();
            long iR2 = this.vo.iR();
            long iZ2 = this.vo.iZ();
            long ja2 = this.vo.ja();
            long j7 = currentTimeMillis - startTime2;
            long j22 = iX2 - currentTimeMillis;
            long j32 = iY2 - iX2;
            int jb2 = this.vo.jb();
            long j42 = iZ2 - iY2;
            long j52 = iR2 - iY2;
            long j62 = iZ2 - iR2;
            long j8 = ja2 > 0 ? 0L : ja2 - iZ2;
            try {
                newInstance = this.vm.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.vm.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.vl.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.vl.getCmd(), this.vl);
                }
            }
            if (!z) {
                if (z3) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(HttpStatus.SC_BAD_REQUEST, "");
                }
                newInstance.setContentLength(this.vn.jd().contentLength);
            } else {
                String str = "";
                if (this.vn.je().size() > 0) {
                    String str2 = this.vn.je().get(this.vn.je().size() - 1).BZ;
                    this.vl.setEncodedBinarySize(this.vn.je().get(this.vn.je().size() - 1).BT);
                    str = str2;
                }
                newInstance.setStatusCode(this.vn.jd().responseCode, str);
                newInstance.setHeader(this.vn.jd().Cr);
                newInstance.setContentEncoding(this.vn.jd().contentEncoding);
                newInstance.setContentLength(this.vn.jd().contentLength);
                newInstance.setContentType(this.vn.jd().contentType);
                newInstance.setDownSize(this.vn.jd().Ct);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.vl);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.vl.getCmd(), this.vn.jd().Cs);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.xA = j7;
                        newInstance.performanceData.xL = j32;
                        newInstance.performanceData.xK = jb2;
                        newInstance.performanceData.xB = j22;
                        newInstance.performanceData.xC = j42;
                        newInstance.performanceData.xD = j52;
                        newInstance.performanceData.xE = j62;
                        newInstance.performanceData.xF = j8;
                        newInstance.performanceData.xG = currentTimeMillis2 - ja2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.vl.getCmd(), this.vn.jd().Cs);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.vl.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.vl.getExtra();
                    newInstance.performanceData.xI = netMessage.getSocketErrNo();
                    newInstance.performanceData.xJ = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.vl.getCmd(), this.vn);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.vl.getCmd(), this.vn.jd().Cs);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.vo != null) {
                this.vo.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.vh.dispatchResponsedMessage(responsedMessageArr[0]);
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
