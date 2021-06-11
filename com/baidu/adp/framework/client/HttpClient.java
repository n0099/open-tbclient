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
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.j.a.c;
import d.a.c.e.j.a.e;
import d.a.c.e.j.a.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends d.a.c.c.e.a<HttpMessage, HttpMessageTask> {

    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i2, HttpMessage httpMessage) {
            super(i2);
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        }
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {

        /* renamed from: a  reason: collision with root package name */
        public HttpMessage f2135a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f2136b;

        /* renamed from: c  reason: collision with root package name */
        public final e f2137c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f2138d = null;

        /* renamed from: com.baidu.adp.framework.client.HttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0021a implements h {
            public C0021a() {
            }

            @Override // d.a.c.e.j.a.h
            public void onProgress(int i2, int i3) {
                HttpMessageTask.a downloadTask = a.this.f2136b.getDownloadTask();
                if (downloadTask == null || downloadTask.a() <= 0) {
                    return;
                }
                HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.a());
                httpProgressResponsedMessage.setProgress(i2 / i3);
                a.this.publishProgress(httpProgressResponsedMessage);
            }
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.f2135a = null;
            this.f2136b = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.f2135a = httpMessage;
            this.f2136b = httpMessageTask;
            this.f2137c = new e();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.f2138d != null) {
                this.f2138d.b();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0321  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0385 A[Catch: Exception -> 0x0397, TRY_LEAVE, TryCatch #5 {Exception -> 0x0397, blocks: (B:107:0x037f, B:109:0x0385), top: B:132:0x037f }] */
        /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0277  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            boolean z2;
            int cmd;
            String str;
            long f2;
            long j;
            long j2;
            long j3;
            long j4;
            int i2;
            long j5;
            int i3;
            long j6;
            HttpResponsedMessage newInstance;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            if (HttpClient.this.f41969a.getController().i(this.f2135a, this.f2136b) == null) {
                return null;
            }
            List<Map.Entry<String, Object>> encodeInBackGround = this.f2135a.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.f2137c.b().s(this.f2136b.getUrl());
            this.f2137c.b().q(this.f2136b.getMethod());
            this.f2137c.b().p(this.f2135a.getHeaders());
            this.f2137c.b().r(encodeInBackGround);
            int a2 = this.f2136b.getTimeOut().a();
            int a3 = this.f2136b.getConnectTimeOut().a();
            int retry = this.f2136b.getRetry();
            try {
                this.f2138d = new c(this.f2137c);
                if (this.f2136b.getDownloadTask() != null && this.f2136b.getDownloadTask().b() != null) {
                    try {
                        z2 = this.f2138d.d(this.f2136b.getDownloadTask().b(), new C0021a(), retry, a2, a3, this.f2136b.getDownloadTask().c());
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        BdLog.detailException(e);
                        z2 = false;
                        cmd = this.f2136b.getCmd();
                        str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                        long startTime = this.f2135a.getStartTime();
                        long h2 = this.f2138d.h();
                        long j14 = this.f2138d.j();
                        long g2 = this.f2138d.g();
                        long i4 = this.f2138d.i();
                        f2 = this.f2138d.f();
                        long j15 = currentTimeMillis - startTime;
                        j = h2 - currentTimeMillis;
                        long j16 = j14 - h2;
                        int k = this.f2138d.k();
                        j2 = i4 - j14;
                        long j17 = g2 - j14;
                        j3 = i4 - g2;
                        long j18 = f2 - i4;
                        if (f2 > 0) {
                        }
                        j5 = j3;
                        try {
                            newInstance = this.f2136b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                            i3 = i2;
                            j6 = j2;
                        } catch (Exception unused) {
                            try {
                                i3 = i2;
                                j6 = j2;
                                newInstance = this.f2136b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.f2135a.getCmd()));
                                String str2 = "";
                                if (z) {
                                }
                                newInstance.setOrginalMessage(this.f2135a);
                                if (!z) {
                                }
                                newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            } catch (Exception e3) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                                }
                                ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.f2135a.getCmd(), this.f2135a);
                                d.a.c.e.n.j.a.a(str, cmd, this.f2136b.getUrl(), false, true, j, 0L, 0L, 0L, 0L, 0);
                                return errorHttpResponsedMessage;
                            }
                        }
                        String str22 = "";
                        if (z) {
                        }
                        newInstance.setOrginalMessage(this.f2135a);
                        if (!z) {
                        }
                        newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                } else {
                    if (this.f2136b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                        this.f2138d.e(retry, a2, a3);
                    } else if (this.f2136b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.f2138d.n(retry, a2, a3);
                    }
                    z2 = false;
                    z = false;
                }
            } catch (Exception e4) {
                e = e4;
                z = false;
            }
            cmd = this.f2136b.getCmd();
            str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
            long startTime2 = this.f2135a.getStartTime();
            long h22 = this.f2138d.h();
            long j142 = this.f2138d.j();
            long g22 = this.f2138d.g();
            long i42 = this.f2138d.i();
            f2 = this.f2138d.f();
            long j152 = currentTimeMillis - startTime2;
            j = h22 - currentTimeMillis;
            long j162 = j142 - h22;
            int k2 = this.f2138d.k();
            j2 = i42 - j142;
            long j172 = g22 - j142;
            j3 = i42 - g22;
            long j182 = f2 - i42;
            if (f2 > 0) {
                i2 = k2;
                j4 = 0;
            } else {
                j4 = j182;
                i2 = k2;
            }
            try {
                j5 = j3;
                newInstance = this.f2136b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                i3 = i2;
                j6 = j2;
            } catch (Exception unused2) {
                j5 = j3;
            }
            String str222 = "";
            if (z) {
                if (z2) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.f2137c.c().f42299f);
                j7 = j;
            } else {
                if (this.f2137c.d().size() > 0) {
                    String str3 = this.f2137c.d().get(this.f2137c.d().size() - 1).f42281h;
                    j7 = j;
                    this.f2135a.setEncodedBinarySize(this.f2137c.d().get(this.f2137c.d().size() - 1).f42274a);
                    str222 = str3;
                } else {
                    j7 = j;
                }
                newInstance.setStatusCode(this.f2137c.c().f42295b, str222);
                newInstance.setHeader(this.f2137c.c().f42300g);
                newInstance.setContentEncoding(this.f2137c.c().f42297d);
                newInstance.setContentLength(this.f2137c.c().f42299f);
                newInstance.setContentType(this.f2137c.c().f42298e);
                newInstance.setDownSize(this.f2137c.c().f42302i);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.f2135a);
            if (!z) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.f2135a.getCmd(), this.f2137c.c().f42301h);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j11 = currentTimeMillis2 - currentTimeMillis;
                        j12 = currentTimeMillis2 - f2;
                        newInstance.performanceData.f42051a = j152;
                        newInstance.performanceData.l = j162;
                        newInstance.performanceData.k = i3;
                        j10 = j7;
                        try {
                            newInstance.performanceData.f42052b = j10;
                            j13 = j6;
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        j8 = j172;
                        j9 = j5;
                        j10 = j7;
                    }
                    try {
                        newInstance.performanceData.f42053c = j13;
                        j8 = j172;
                    } catch (Exception e7) {
                        e = e7;
                        j6 = j13;
                        j8 = j172;
                        j9 = j5;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e);
                        if (this.f2135a.getExtra() instanceof NetMessage) {
                        }
                        String url = this.f2136b.getUrl();
                        boolean isSuccess = newInstance.isSuccess();
                        d.a.c.c.i.a aVar = newInstance.performanceData;
                        d.a.c.e.n.j.a.a(str, cmd, url, isSuccess, true, j10, j6, aVar.f42057g, j8, j9, aVar.f42059i);
                        newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                    try {
                        newInstance.performanceData.f42054d = j8;
                        j9 = j5;
                        try {
                            newInstance.performanceData.f42055e = j9;
                            j6 = j13;
                        } catch (Exception e8) {
                            e = e8;
                            j6 = j13;
                        }
                        try {
                            newInstance.performanceData.f42056f = j4;
                            newInstance.performanceData.f42057g = j12;
                            newInstance.setCostTime(j11);
                            newInstance.beforeDispatchInBackGround(this.f2135a.getCmd(), this.f2137c.c().f42301h);
                        } catch (Exception e9) {
                            e = e9;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                            BdLog.detailException(e);
                            if (this.f2135a.getExtra() instanceof NetMessage) {
                            }
                            String url2 = this.f2136b.getUrl();
                            boolean isSuccess2 = newInstance.isSuccess();
                            d.a.c.c.i.a aVar2 = newInstance.performanceData;
                            d.a.c.e.n.j.a.a(str, cmd, url2, isSuccess2, true, j10, j6, aVar2.f42057g, j8, j9, aVar2.f42059i);
                            newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        j6 = j13;
                        j9 = j5;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e);
                        if (this.f2135a.getExtra() instanceof NetMessage) {
                        }
                        String url22 = this.f2136b.getUrl();
                        boolean isSuccess22 = newInstance.isSuccess();
                        d.a.c.c.i.a aVar22 = newInstance.performanceData;
                        d.a.c.e.n.j.a.a(str, cmd, url22, isSuccess22, true, j10, j6, aVar22.f42057g, j8, j9, aVar22.f42059i);
                        newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                } else {
                    j8 = j172;
                    j9 = j5;
                    j10 = j7;
                }
                if (this.f2135a.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.f2135a.getExtra();
                    newInstance.performanceData.f42059i = netMessage.getSocketErrNo();
                    newInstance.performanceData.j = netMessage.getSocketCostTime();
                }
                String url222 = this.f2136b.getUrl();
                boolean isSuccess222 = newInstance.isSuccess();
                d.a.c.c.i.a aVar222 = newInstance.performanceData;
                d.a.c.e.n.j.a.a(str, cmd, url222, isSuccess222, true, j10, j6, aVar222.f42057g, j8, j9, aVar222.f42059i);
            }
            newInstance.logStatInBackground(this.f2135a.getCmd(), this.f2137c);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    return null;
                }
                newInstance.afterDispatchInBackGround(this.f2135a.getCmd(), this.f2137c.c().f42301h);
                return null;
            } catch (Exception e11) {
                BdLog.e(e11.getMessage());
                return null;
            }
        }

        public HttpMessage e() {
            return this.f2135a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            HttpClient.this.f41969a.dispatchResponsedMessage(responsedMessageArr[0]);
        }
    }

    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    @Override // d.a.c.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        return j(String.valueOf(i2), bdUniqueId);
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i2));
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
                linkedList.add(((a) next).e());
            }
        }
        return linkedList;
    }

    public void k(BdUniqueId bdUniqueId) {
        BdAsyncTask.removeAllTask(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }
}
