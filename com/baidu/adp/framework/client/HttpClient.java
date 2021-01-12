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
                linkedList.add(((a) next).kM());
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
        private HttpMessage IO;
        private HttpMessageTask IP;
        private final e IQ;
        private volatile c IR = null;

        public HttpMessage kM() {
            return this.IO;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.IO = null;
            this.IP = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.IO = httpMessage;
            this.IP = httpMessageTask;
            this.IQ = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0282 A[Catch: Exception -> 0x0493, TRY_LEAVE, TryCatch #4 {Exception -> 0x0493, blocks: (B:37:0x027c, B:39:0x0282), top: B:96:0x027c }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x02d0  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x03a7  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            boolean z2;
            int cmd;
            long lT;
            HttpResponsedMessage newInstance;
            boolean z3;
            if (HttpClient.this.II.getController().b(this.IO, this.IP) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.IO.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.IQ.lV().setUrl(this.IP.getUrl());
            this.IQ.lV().setMethod(this.IP.getMethod());
            this.IQ.lV().t(this.IO.getHeaders());
            this.IQ.lV().n(encodeInBackGround);
            int timeOut = this.IP.getTimeOut().getTimeOut();
            int timeOut2 = this.IP.getConnectTimeOut().getTimeOut();
            int retry = this.IP.getRetry();
            boolean z4 = false;
            try {
                this.IR = new c(this.IQ);
                if (this.IP.getDownloadTask() != null && this.IP.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z3 = this.IR.a(this.IP.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.IP.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.IP.getDownloadTask().getIsOverWrite());
                        z4 = true;
                    } catch (Exception e) {
                        e = e;
                        z4 = true;
                        BdLog.detailException(e);
                        z = false;
                        z2 = z4;
                        cmd = this.IP.getCmd();
                        String str = "other";
                        if (cmd != 1001703) {
                        }
                        long startTime = this.IO.getStartTime();
                        long lQ = this.IR.lQ();
                        long lR = this.IR.lR();
                        long lO = this.IR.lO();
                        long lS = this.IR.lS();
                        lT = this.IR.lT();
                        long j = currentTimeMillis - startTime;
                        long j2 = lQ - currentTimeMillis;
                        long j3 = lR - lQ;
                        int lU = this.IR.lU();
                        long j4 = lS - lR;
                        long j5 = lO - lR;
                        long j6 = lS - lO;
                        long j7 = lT - lS;
                        if (lT <= 0) {
                        }
                        newInstance = this.IP.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z2) {
                        }
                        newInstance.setOrginalMessage(this.IO);
                        if (!z2) {
                        }
                        newInstance.logStatInBackground(this.IO.getCmd(), this.IQ);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.IP.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.IR.d(retry, timeOut, timeOut2);
                    z3 = false;
                } else {
                    if (this.IP.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.IR.f(retry, timeOut, timeOut2);
                    }
                    z3 = false;
                }
                z = z3;
                z2 = z4;
            } catch (Exception e2) {
                e = e2;
            }
            cmd = this.IP.getCmd();
            String str2 = "other";
            if (cmd != 1001703) {
                str2 = "frs";
            } else if (cmd == 1001801) {
                str2 = "pb";
            } else if (cmd == 1003070) {
                str2 = "home_page";
            } else if (cmd == 1002400) {
                str2 = "enter_forum";
            } else if (cmd == 1002700) {
                str2 = "user_center";
            } else if (cmd == 1001503) {
                str2 = "person_center_post";
            } else if (cmd == 1003446) {
                str2 = "person_center_dynamic";
            }
            long startTime2 = this.IO.getStartTime();
            long lQ2 = this.IR.lQ();
            long lR2 = this.IR.lR();
            long lO2 = this.IR.lO();
            long lS2 = this.IR.lS();
            lT = this.IR.lT();
            long j8 = currentTimeMillis - startTime2;
            long j22 = lQ2 - currentTimeMillis;
            long j32 = lR2 - lQ2;
            int lU2 = this.IR.lU();
            long j42 = lS2 - lR2;
            long j52 = lO2 - lR2;
            long j62 = lS2 - lO2;
            long j72 = lT - lS2;
            if (lT <= 0) {
                j72 = 0;
            }
            try {
                newInstance = this.IP.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.IP.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.IO.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.IO.getCmd(), this.IO);
                    com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.IP.getUrl(), false, true, j22, 0L, 0L, 0L, 0L, 0);
                    return errorHttpResponsedMessage;
                }
            }
            if (!z2) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.IQ.lW().contentLength);
            } else {
                String str3 = "";
                if (this.IQ.lX().size() > 0) {
                    String str4 = this.IQ.lX().get(this.IQ.lX().size() - 1).exception;
                    this.IO.setEncodedBinarySize(this.IQ.lX().get(this.IQ.lX().size() - 1).Mb);
                    str3 = str4;
                }
                newInstance.setStatusCode(this.IQ.lW().responseCode, str3);
                newInstance.setHeader(this.IQ.lW().MG);
                newInstance.setContentEncoding(this.IQ.lW().contentEncoding);
                newInstance.setContentLength(this.IQ.lW().contentLength);
                newInstance.setContentType(this.IQ.lW().contentType);
                newInstance.setDownSize(this.IQ.lW().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.IO);
            if (!z2) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.IO.getCmd(), this.IQ.lW().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j8;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = lU2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j72;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - lT;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.IO.getCmd(), this.IQ.lW().retBytes);
                    } catch (Exception e5) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.IO.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.IO.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
                com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.IP.getUrl(), newInstance.isSuccess(), true, j22, j42, newInstance.performanceData.mAnalysisTime, j52, j62, newInstance.performanceData.mSocketErrNo);
            }
            newInstance.logStatInBackground(this.IO.getCmd(), this.IQ);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.IO.getCmd(), this.IQ.lW().retBytes);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.IR != null) {
                this.IR.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.II.dispatchResponsedMessage(responsedMessageArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
