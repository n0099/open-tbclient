package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.j.a.c;
import d.b.b.e.j.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends d.b.b.c.e.a<HttpMessage, HttpMessageTask> {

    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {

        /* renamed from: a  reason: collision with root package name */
        public HttpMessage f2118a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f2119b;

        /* renamed from: c  reason: collision with root package name */
        public final e f2120c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f2121d = null;

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.f2118a = null;
            this.f2119b = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.f2118a = httpMessage;
            this.f2119b = httpMessageTask;
            this.f2120c = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0212  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x02ad  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x02bb  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x031f A[Catch: Exception -> 0x0331, TRY_LEAVE, TryCatch #9 {Exception -> 0x0331, blocks: (B:89:0x0319, B:91:0x031f), top: B:121:0x0319 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            long j;
            HttpResponsedMessage newInstance;
            long j2;
            String str;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            if (HttpClient.this.f41484a.getController().i(this.f2118a, this.f2119b) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.f2118a.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.f2120c.b().s(this.f2119b.getUrl());
            this.f2120c.b().q(this.f2119b.getMethod());
            this.f2120c.b().p(this.f2118a.getHeaders());
            this.f2120c.b().r(encodeInBackGround);
            int a2 = this.f2119b.getTimeOut().a();
            int a3 = this.f2119b.getConnectTimeOut().a();
            int retry = this.f2119b.getRetry();
            try {
                this.f2121d = new c(this.f2120c);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            if (this.f2119b.getDownloadTask() == null) {
                if (this.f2119b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    this.f2121d.d(retry, a2, a3);
                } else if (this.f2119b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.f2121d.m(retry, a2, a3);
                }
                int cmd = this.f2119b.getCmd();
                String str2 = cmd == 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                long startTime = this.f2118a.getStartTime();
                long g2 = this.f2121d.g();
                long i = this.f2121d.i();
                long f2 = this.f2121d.f();
                long h2 = this.f2121d.h();
                long e3 = this.f2121d.e();
                long j8 = currentTimeMillis - startTime;
                long j9 = g2 - currentTimeMillis;
                long j10 = i - g2;
                int j11 = this.f2121d.j();
                long j12 = h2 - i;
                long j13 = f2 - i;
                long j14 = h2 - f2;
                long j15 = e3 <= 0 ? 0L : e3 - h2;
                try {
                    j = j14;
                    try {
                        newInstance = this.f2119b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception unused) {
                        try {
                            newInstance = this.f2119b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.f2118a.getCmd()));
                            if (this.f2120c.d().size() <= 0) {
                            }
                            newInstance.setStatusCode(this.f2120c.c().f41797b, str);
                            newInstance.setHeader(this.f2120c.c().f41802g);
                            newInstance.setContentEncoding(this.f2120c.c().f41799d);
                            newInstance.setContentLength(this.f2120c.c().f41801f);
                            newInstance.setContentType(this.f2120c.c().f41800e);
                            newInstance.setDownSize(this.f2120c.c().i);
                            if (!newInstance.isSuccess()) {
                            }
                            newInstance.setOrginalMessage(this.f2118a);
                            if (newInstance.isSuccess()) {
                            }
                            if (this.f2118a.getExtra() instanceof NetMessage) {
                            }
                            String url = this.f2119b.getUrl();
                            boolean isSuccess = newInstance.isSuccess();
                            d.b.b.c.i.a aVar = newInstance.performanceData;
                            d.b.b.e.n.j.a.a(str2, cmd, url, isSuccess, true, j5, j12, aVar.f41565g, j3, j4, aVar.i);
                            newInstance.logStatInBackground(this.f2118a.getCmd(), this.f2120c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        } catch (Exception e4) {
                            if (BdLog.isDebugMode()) {
                                BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                            }
                            ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.f2118a.getCmd(), this.f2118a);
                            d.b.b.e.n.j.a.a(str2, cmd, this.f2119b.getUrl(), false, true, j9, 0L, 0L, 0L, 0L, 0);
                            return errorHttpResponsedMessage;
                        }
                    }
                } catch (Exception unused2) {
                    j = j14;
                }
                if (this.f2120c.d().size() <= 0) {
                    String str3 = this.f2120c.d().get(this.f2120c.d().size() - 1).f41784h;
                    j2 = j13;
                    this.f2118a.setEncodedBinarySize(this.f2120c.d().get(this.f2120c.d().size() - 1).f41777a);
                    str = str3;
                } else {
                    j2 = j13;
                    str = "";
                }
                newInstance.setStatusCode(this.f2120c.c().f41797b, str);
                newInstance.setHeader(this.f2120c.c().f41802g);
                newInstance.setContentEncoding(this.f2120c.c().f41799d);
                newInstance.setContentLength(this.f2120c.c().f41801f);
                newInstance.setContentType(this.f2120c.c().f41800e);
                newInstance.setDownSize(this.f2120c.c().i);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
                newInstance.setOrginalMessage(this.f2118a);
                if (newInstance.isSuccess()) {
                    j3 = j2;
                    j4 = j;
                    j5 = j9;
                } else {
                    try {
                        newInstance.decodeInBackGround(this.f2118a.getCmd(), this.f2120c.c().f41803h);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j6 = currentTimeMillis2 - currentTimeMillis;
                        j7 = currentTimeMillis2 - e3;
                        long j16 = j2;
                        try {
                            newInstance.performanceData.f41559a = j8;
                            newInstance.performanceData.l = j10;
                            newInstance.performanceData.k = j11;
                            newInstance.performanceData.f41560b = j9;
                            newInstance.performanceData.f41561c = j12;
                            j3 = j16;
                        } catch (Exception e5) {
                            e = e5;
                            j5 = j9;
                            j3 = j16;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        j3 = j2;
                        j4 = j;
                    }
                    try {
                        newInstance.performanceData.f41562d = j3;
                        j4 = j;
                    } catch (Exception e7) {
                        e = e7;
                        j5 = j9;
                        j4 = j;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e);
                        if (this.f2118a.getExtra() instanceof NetMessage) {
                        }
                        String url2 = this.f2119b.getUrl();
                        boolean isSuccess2 = newInstance.isSuccess();
                        d.b.b.c.i.a aVar2 = newInstance.performanceData;
                        d.b.b.e.n.j.a.a(str2, cmd, url2, isSuccess2, true, j5, j12, aVar2.f41565g, j3, j4, aVar2.i);
                        newInstance.logStatInBackground(this.f2118a.getCmd(), this.f2120c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                    try {
                        newInstance.performanceData.f41563e = j4;
                        j5 = j9;
                        try {
                            newInstance.performanceData.f41564f = j15;
                            newInstance.performanceData.f41565g = j7;
                            newInstance.setCostTime(j6);
                            newInstance.beforeDispatchInBackGround(this.f2118a.getCmd(), this.f2120c.c().f41803h);
                        } catch (Exception e8) {
                            e = e8;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                            BdLog.detailException(e);
                            if (this.f2118a.getExtra() instanceof NetMessage) {
                            }
                            String url22 = this.f2119b.getUrl();
                            boolean isSuccess22 = newInstance.isSuccess();
                            d.b.b.c.i.a aVar22 = newInstance.performanceData;
                            d.b.b.e.n.j.a.a(str2, cmd, url22, isSuccess22, true, j5, j12, aVar22.f41565g, j3, j4, aVar22.i);
                            newInstance.logStatInBackground(this.f2118a.getCmd(), this.f2120c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        j5 = j9;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e);
                        if (this.f2118a.getExtra() instanceof NetMessage) {
                        }
                        String url222 = this.f2119b.getUrl();
                        boolean isSuccess222 = newInstance.isSuccess();
                        d.b.b.c.i.a aVar222 = newInstance.performanceData;
                        d.b.b.e.n.j.a.a(str2, cmd, url222, isSuccess222, true, j5, j12, aVar222.f41565g, j3, j4, aVar222.i);
                        newInstance.logStatInBackground(this.f2118a.getCmd(), this.f2120c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                }
                if (this.f2118a.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.f2118a.getExtra();
                    newInstance.performanceData.i = netMessage.getSocketErrNo();
                    newInstance.performanceData.j = netMessage.getSocketCostTime();
                }
                String url2222 = this.f2119b.getUrl();
                boolean isSuccess2222 = newInstance.isSuccess();
                d.b.b.c.i.a aVar2222 = newInstance.performanceData;
                d.b.b.e.n.j.a.a(str2, cmd, url2222, isSuccess2222, true, j5, j12, aVar2222.f41565g, j3, j4, aVar2222.i);
                newInstance.logStatInBackground(this.f2118a.getCmd(), this.f2120c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        newInstance.afterDispatchInBackGround(this.f2118a.getCmd(), this.f2120c.c().f41803h);
                        return null;
                    }
                    return null;
                } catch (Exception e10) {
                    BdLog.e(e10.getMessage());
                    return null;
                }
            }
            this.f2119b.getDownloadTask().a();
            throw null;
        }

        public HttpMessage c() {
            return this.f2118a;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f2121d != null) {
                this.f2121d.b();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            HttpClient.this.f41484a.dispatchResponsedMessage(responsedMessageArr[0]);
        }
    }

    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    @Override // d.b.b.c.b
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        return j(String.valueOf(i), bdUniqueId);
    }

    @Override // d.b.b.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
    }

    public LinkedList<HttpMessage> i(BdUniqueId bdUniqueId) {
        return j(null, bdUniqueId);
    }

    public LinkedList<HttpMessage> j(String str, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof a) {
                linkedList.add(((a) next).c());
            }
        }
        return linkedList;
    }

    public void k(BdUniqueId bdUniqueId) {
        BdAsyncTask.removeAllTask(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }
}
