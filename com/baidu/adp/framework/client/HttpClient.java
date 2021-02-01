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
                linkedList.add(((a) next).kL());
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
        private HttpMessage IL;
        private HttpMessageTask IO;
        private final e IP;
        private volatile c IQ = null;

        public HttpMessage kL() {
            return this.IL;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.IL = null;
            this.IO = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.IL = httpMessage;
            this.IO = httpMessageTask;
            this.IP = new e();
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
            long lS;
            HttpResponsedMessage newInstance;
            boolean z3;
            if (HttpClient.this.IH.getController().b(this.IL, this.IO) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.IL.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.IP.lU().setUrl(this.IO.getUrl());
            this.IP.lU().setMethod(this.IO.getMethod());
            this.IP.lU().t(this.IL.getHeaders());
            this.IP.lU().n(encodeInBackGround);
            int timeOut = this.IO.getTimeOut().getTimeOut();
            int timeOut2 = this.IO.getConnectTimeOut().getTimeOut();
            int retry = this.IO.getRetry();
            boolean z4 = false;
            try {
                this.IQ = new c(this.IP);
                if (this.IO.getDownloadTask() != null && this.IO.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z3 = this.IQ.a(this.IO.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.IO.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.IO.getDownloadTask().getIsOverWrite());
                        z4 = true;
                    } catch (Exception e) {
                        e = e;
                        z4 = true;
                        BdLog.detailException(e);
                        z = false;
                        z2 = z4;
                        cmd = this.IO.getCmd();
                        String str = "other";
                        if (cmd != 1001703) {
                        }
                        long startTime = this.IL.getStartTime();
                        long lP = this.IQ.lP();
                        long lQ = this.IQ.lQ();
                        long lN = this.IQ.lN();
                        long lR = this.IQ.lR();
                        lS = this.IQ.lS();
                        long j = currentTimeMillis - startTime;
                        long j2 = lP - currentTimeMillis;
                        long j3 = lQ - lP;
                        int lT = this.IQ.lT();
                        long j4 = lR - lQ;
                        long j5 = lN - lQ;
                        long j6 = lR - lN;
                        long j7 = lS - lR;
                        if (lS <= 0) {
                        }
                        newInstance = this.IO.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z2) {
                        }
                        newInstance.setOrginalMessage(this.IL);
                        if (!z2) {
                        }
                        newInstance.logStatInBackground(this.IL.getCmd(), this.IP);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.IO.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.IQ.d(retry, timeOut, timeOut2);
                    z3 = false;
                } else {
                    if (this.IO.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.IQ.f(retry, timeOut, timeOut2);
                    }
                    z3 = false;
                }
                z = z3;
                z2 = z4;
            } catch (Exception e2) {
                e = e2;
            }
            cmd = this.IO.getCmd();
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
            long startTime2 = this.IL.getStartTime();
            long lP2 = this.IQ.lP();
            long lQ2 = this.IQ.lQ();
            long lN2 = this.IQ.lN();
            long lR2 = this.IQ.lR();
            lS = this.IQ.lS();
            long j8 = currentTimeMillis - startTime2;
            long j22 = lP2 - currentTimeMillis;
            long j32 = lQ2 - lP2;
            int lT2 = this.IQ.lT();
            long j42 = lR2 - lQ2;
            long j52 = lN2 - lQ2;
            long j62 = lR2 - lN2;
            long j72 = lS - lR2;
            if (lS <= 0) {
                j72 = 0;
            }
            try {
                newInstance = this.IO.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.IO.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.IL.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.IL.getCmd(), this.IL);
                    com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.IO.getUrl(), false, true, j22, 0L, 0L, 0L, 0L, 0);
                    return errorHttpResponsedMessage;
                }
            }
            if (!z2) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.IP.lV().contentLength);
            } else {
                String str3 = "";
                if (this.IP.lW().size() > 0) {
                    String str4 = this.IP.lW().get(this.IP.lW().size() - 1).exception;
                    this.IL.setEncodedBinarySize(this.IP.lW().get(this.IP.lW().size() - 1).LZ);
                    str3 = str4;
                }
                newInstance.setStatusCode(this.IP.lV().responseCode, str3);
                newInstance.setHeader(this.IP.lV().ME);
                newInstance.setContentEncoding(this.IP.lV().contentEncoding);
                newInstance.setContentLength(this.IP.lV().contentLength);
                newInstance.setContentType(this.IP.lV().contentType);
                newInstance.setDownSize(this.IP.lV().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.IL);
            if (!z2) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.IL.getCmd(), this.IP.lV().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j8;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = lT2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j72;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - lS;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.IL.getCmd(), this.IP.lV().retBytes);
                    } catch (Exception e5) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.IL.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.IL.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
                com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.IO.getUrl(), newInstance.isSuccess(), true, j22, j42, newInstance.performanceData.mAnalysisTime, j52, j62, newInstance.performanceData.mSocketErrNo);
            }
            newInstance.logStatInBackground(this.IL.getCmd(), this.IP);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.IL.getCmd(), this.IP.lV().retBytes);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.IQ != null) {
                this.IQ.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.IH.dispatchResponsedMessage(responsedMessageArr[0]);
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
