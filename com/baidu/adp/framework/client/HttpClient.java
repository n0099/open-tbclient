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
                linkedList.add(((a) next).lq());
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
        private HttpMessage It;
        private HttpMessageTask Iu;
        private final e Iv;
        private volatile c Iw = null;

        public HttpMessage lq() {
            return this.It;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.It = null;
            this.Iu = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.It = httpMessage;
            this.Iu = httpMessageTask;
            this.Iv = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0282 A[Catch: Exception -> 0x0483, TRY_LEAVE, TryCatch #3 {Exception -> 0x0483, blocks: (B:37:0x027c, B:39:0x0282), top: B:95:0x027c }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x02d7  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0397  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            Exception e;
            boolean z2;
            boolean z3;
            int cmd;
            long mv;
            HttpResponsedMessage newInstance;
            boolean z4;
            boolean z5;
            if (HttpClient.this.Ip.getController().b(this.It, this.Iu) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.It.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.Iv.mx().setUrl(this.Iu.getUrl());
            this.Iv.mx().setMethod(this.Iu.getMethod());
            this.Iv.mx().t(this.It.getHeaders());
            this.Iv.mx().n(encodeInBackGround);
            int timeOut = this.Iu.getTimeOut().getTimeOut();
            int timeOut2 = this.Iu.getConnectTimeOut().getTimeOut();
            int retry = this.Iu.getRetry();
            try {
                this.Iw = new c(this.Iv);
                if (this.Iu.getDownloadTask() != null && this.Iu.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z5 = this.Iw.a(this.Iu.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.Iu.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.Iu.getDownloadTask().getIsOverWrite());
                        z4 = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        z2 = false;
                        z3 = z;
                        cmd = this.Iu.getCmd();
                        String str = "other";
                        if (cmd != 1001703) {
                        }
                        long startTime = this.It.getStartTime();
                        long ms = this.Iw.ms();
                        long mt = this.Iw.mt();
                        long mq = this.Iw.mq();
                        long mu = this.Iw.mu();
                        mv = this.Iw.mv();
                        long j = currentTimeMillis - startTime;
                        long j2 = ms - currentTimeMillis;
                        long j3 = mt - ms;
                        int mw = this.Iw.mw();
                        long j4 = mu - mt;
                        long j5 = mq - mt;
                        long j6 = mu - mq;
                        long j7 = mv - mu;
                        if (mv <= 0) {
                        }
                        newInstance = this.Iu.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z3) {
                        }
                        newInstance.setOrginalMessage(this.It);
                        if (!z3) {
                        }
                        newInstance.logStatInBackground(this.It.getCmd(), this.Iv);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.Iu.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.Iw.d(retry, timeOut, timeOut2);
                    z4 = false;
                    z5 = false;
                } else {
                    if (this.Iu.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.Iw.f(retry, timeOut, timeOut2);
                    }
                    z4 = false;
                    z5 = false;
                }
                z2 = z5;
                z3 = z4;
            } catch (Exception e3) {
                z = false;
                e = e3;
            }
            cmd = this.Iu.getCmd();
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
            long startTime2 = this.It.getStartTime();
            long ms2 = this.Iw.ms();
            long mt2 = this.Iw.mt();
            long mq2 = this.Iw.mq();
            long mu2 = this.Iw.mu();
            mv = this.Iw.mv();
            long j8 = currentTimeMillis - startTime2;
            long j22 = ms2 - currentTimeMillis;
            long j32 = mt2 - ms2;
            int mw2 = this.Iw.mw();
            long j42 = mu2 - mt2;
            long j52 = mq2 - mt2;
            long j62 = mu2 - mq2;
            long j72 = mv - mu2;
            if (mv <= 0) {
                j72 = 0;
            }
            try {
                newInstance = this.Iu.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.Iu.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.It.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.It.getCmd(), this.It);
                }
            }
            if (!z3) {
                if (z2) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.Iv.my().contentLength);
            } else {
                String str3 = "";
                if (this.Iv.mz().size() > 0) {
                    String str4 = this.Iv.mz().get(this.Iv.mz().size() - 1).exception;
                    this.It.setEncodedBinarySize(this.Iv.mz().get(this.Iv.mz().size() - 1).LI);
                    str3 = str4;
                }
                newInstance.setStatusCode(this.Iv.my().responseCode, str3);
                newInstance.setHeader(this.Iv.my().Mp);
                newInstance.setContentEncoding(this.Iv.my().contentEncoding);
                newInstance.setContentLength(this.Iv.my().contentLength);
                newInstance.setContentType(this.Iv.my().contentType);
                newInstance.setDownSize(this.Iv.my().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.It);
            if (!z3) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.It.getCmd(), this.Iv.my().retBytes);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.mQueneTime = j8;
                        newInstance.performanceData.mHttpRetryCostTime = j32;
                        newInstance.performanceData.mHttpRetryNum = mw2;
                        newInstance.performanceData.mNetConTime = j22;
                        newInstance.performanceData.mNetRWTime = j42;
                        newInstance.performanceData.mFirstByteReachTime = j52;
                        newInstance.performanceData.mAllDataReadTime = j62;
                        newInstance.performanceData.mCompressTime = j72;
                        newInstance.performanceData.mAnalysisTime = currentTimeMillis2 - mv;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.It.getCmd(), this.Iv.my().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.It.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.It.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
                com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.Iu.getUrl(), newInstance.isSuccess(), true, j22, j42, newInstance.performanceData.mAnalysisTime, j52, j62, newInstance.performanceData.mSocketErrNo);
            }
            newInstance.logStatInBackground(this.It.getCmd(), this.Iv);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.It.getCmd(), this.Iv.my().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Iw != null) {
                this.Iw.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.Ip.dispatchResponsedMessage(responsedMessageArr[0]);
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
