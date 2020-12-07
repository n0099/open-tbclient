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
        private HttpMessage Jr;
        private HttpMessageTask Js;
        private final e Jt;
        private volatile c Ju = null;

        public HttpMessage lq() {
            return this.Jr;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.Jr = null;
            this.Js = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.Jr = httpMessage;
            this.Js = httpMessageTask;
            this.Jt = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0282 A[Catch: Exception -> 0x049a, TRY_LEAVE, TryCatch #0 {Exception -> 0x049a, blocks: (B:37:0x027c, B:39:0x0282), top: B:90:0x027c }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x02d7  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x03ae  */
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
            if (HttpClient.this.Jn.getController().b(this.Jr, this.Js) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.Jr.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.Jt.mx().setUrl(this.Js.getUrl());
            this.Jt.mx().setMethod(this.Js.getMethod());
            this.Jt.mx().t(this.Jr.getHeaders());
            this.Jt.mx().n(encodeInBackGround);
            int timeOut = this.Js.getTimeOut().getTimeOut();
            int timeOut2 = this.Js.getConnectTimeOut().getTimeOut();
            int retry = this.Js.getRetry();
            try {
                this.Ju = new c(this.Jt);
                if (this.Js.getDownloadTask() != null && this.Js.getDownloadTask().getDownloadPath() != null) {
                    try {
                        z5 = this.Ju.a(this.Js.getDownloadTask().getDownloadPath(), new h() { // from class: com.baidu.adp.framework.client.HttpClient.a.1
                            @Override // com.baidu.adp.lib.network.http.h
                            public void onProgress(int i, int i2) {
                                HttpMessageTask.a downloadTask = a.this.Js.getDownloadTask();
                                if (downloadTask != null && downloadTask.getCmd() > 0) {
                                    HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
                                    httpProgressResponsedMessage.setProgress(i / i2);
                                    a.this.publishProgress(httpProgressResponsedMessage);
                                }
                            }
                        }, retry, timeOut, timeOut2, this.Js.getDownloadTask().getIsOverWrite());
                        z4 = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        z2 = false;
                        z3 = z;
                        cmd = this.Js.getCmd();
                        String str = "other";
                        if (cmd != 1001703) {
                        }
                        long startTime = this.Jr.getStartTime();
                        long ms = this.Ju.ms();
                        long mt = this.Ju.mt();
                        long mq = this.Ju.mq();
                        long mu = this.Ju.mu();
                        mv = this.Ju.mv();
                        long j = currentTimeMillis - startTime;
                        long j2 = ms - currentTimeMillis;
                        long j3 = mt - ms;
                        int mw = this.Ju.mw();
                        long j4 = mu - mt;
                        long j5 = mq - mt;
                        long j6 = mu - mq;
                        long j7 = mv - mu;
                        if (mv <= 0) {
                        }
                        newInstance = this.Js.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                        if (!z3) {
                        }
                        newInstance.setOrginalMessage(this.Jr);
                        if (!z3) {
                        }
                        newInstance.logStatInBackground(this.Jr.getCmd(), this.Jt);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                        return null;
                    }
                } else if (this.Js.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.Ju.d(retry, timeOut, timeOut2);
                    z4 = false;
                    z5 = false;
                } else {
                    if (this.Js.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.Ju.f(retry, timeOut, timeOut2);
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
            cmd = this.Js.getCmd();
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
            long startTime2 = this.Jr.getStartTime();
            long ms2 = this.Ju.ms();
            long mt2 = this.Ju.mt();
            long mq2 = this.Ju.mq();
            long mu2 = this.Ju.mu();
            mv = this.Ju.mv();
            long j8 = currentTimeMillis - startTime2;
            long j22 = ms2 - currentTimeMillis;
            long j32 = mt2 - ms2;
            int mw2 = this.Ju.mw();
            long j42 = mu2 - mt2;
            long j52 = mq2 - mt2;
            long j62 = mu2 - mq2;
            long j72 = mv - mu2;
            if (mv <= 0) {
                j72 = 0;
            }
            try {
                newInstance = this.Js.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.Js.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.Jr.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.Jr.getCmd(), this.Jr);
                    com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.Js.getUrl(), false, true, j22, 0L, 0L, 0L, 0L, 0);
                    return errorHttpResponsedMessage;
                }
            }
            if (!z3) {
                if (z2) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.Jt.my().contentLength);
            } else {
                String str3 = "";
                if (this.Jt.mz().size() > 0) {
                    String str4 = this.Jt.mz().get(this.Jt.mz().size() - 1).exception;
                    this.Jr.setEncodedBinarySize(this.Jt.mz().get(this.Jt.mz().size() - 1).ME);
                    str3 = str4;
                }
                newInstance.setStatusCode(this.Jt.my().responseCode, str3);
                newInstance.setHeader(this.Jt.my().Nk);
                newInstance.setContentEncoding(this.Jt.my().contentEncoding);
                newInstance.setContentLength(this.Jt.my().contentLength);
                newInstance.setContentType(this.Jt.my().contentType);
                newInstance.setDownSize(this.Jt.my().downSize);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.Jr);
            if (!z3) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.Jr.getCmd(), this.Jt.my().retBytes);
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
                        newInstance.beforeDispatchInBackGround(this.Jr.getCmd(), this.Jt.my().retBytes);
                    } catch (Exception e6) {
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e6);
                    }
                }
                if (this.Jr.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.Jr.getExtra();
                    newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                    newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
                }
                com.baidu.adp.lib.stats.b.a.a(str2, cmd, this.Js.getUrl(), newInstance.isSuccess(), true, j22, j42, newInstance.performanceData.mAnalysisTime, j52, j62, newInstance.performanceData.mSocketErrNo);
            }
            newInstance.logStatInBackground(this.Jr.getCmd(), this.Jt);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.Jr.getCmd(), this.Jt.my().retBytes);
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ju != null) {
                this.Ju.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.Jn.dispatchResponsedMessage(responsedMessageArr[0]);
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
