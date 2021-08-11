package com.baidu.adp.framework.client;

import c.a.e.e.j.a.c;
import c.a.e.e.j.a.e;
import c.a.e.e.j.a.h;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class HttpClient extends c.a.e.c.e.a<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorHttpResponsedMessage(int i2, HttpMessage httpMessage) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), httpMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HttpMessage f36016a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f36017b;

        /* renamed from: c  reason: collision with root package name */
        public final e f36018c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f36019d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HttpClient f36020e;

        /* renamed from: com.baidu.adp.framework.client.HttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1567a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f36021a;

            public C1567a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36021a = aVar;
            }

            @Override // c.a.e.e.j.a.h
            public void onProgress(int i2, int i3) {
                HttpMessageTask.a downloadTask;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (downloadTask = this.f36021a.f36017b.getDownloadTask()) == null || downloadTask.a() <= 0) {
                    return;
                }
                HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.a());
                httpProgressResponsedMessage.setProgress(i2 / i3);
                this.f36021a.publishProgress(httpProgressResponsedMessage);
            }
        }

        public a(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpClient, httpMessage, httpMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36020e = httpClient;
            this.f36016a = null;
            this.f36017b = null;
            this.f36019d = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.f36016a = httpMessage;
            this.f36017b = httpMessageTask;
            this.f36018c = new e();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                if (this.f36019d != null) {
                    this.f36019d.b();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0326  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x038a A[Catch: Exception -> 0x039c, TRY_LEAVE, TryCatch #1 {Exception -> 0x039c, blocks: (B:109:0x0384, B:111:0x038a), top: B:130:0x0384 }] */
        /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x027c  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            int cmd;
            String str;
            long f2;
            long j2;
            long j3;
            long j4;
            long j5;
            int i2;
            long j6;
            int i3;
            long j7;
            HttpResponsedMessage newInstance;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessageArr)) == null) {
                if (this.f36020e.f1934a.getController().i(this.f36016a, this.f36017b) == null) {
                    return null;
                }
                List<Map.Entry<String, Object>> encodeInBackGround = this.f36016a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.f36018c.b().s(this.f36017b.getUrl());
                this.f36018c.b().q(this.f36017b.getMethod());
                this.f36018c.b().p(this.f36016a.getHeaders());
                this.f36018c.b().r(encodeInBackGround);
                int a2 = this.f36017b.getTimeOut().a();
                int a3 = this.f36017b.getConnectTimeOut().a();
                int retry = this.f36017b.getRetry();
                try {
                    this.f36019d = new c(this.f36018c);
                    if (this.f36017b.getDownloadTask() != null && this.f36017b.getDownloadTask().b() != null) {
                        try {
                            z2 = this.f36019d.d(this.f36017b.getDownloadTask().b(), new C1567a(this), retry, a2, a3, this.f36017b.getDownloadTask().c());
                            z = true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            BdLog.detailException(e);
                            z2 = false;
                            cmd = this.f36017b.getCmd();
                            str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                            long startTime = this.f36016a.getStartTime();
                            long h2 = this.f36019d.h();
                            long j15 = this.f36019d.j();
                            long g2 = this.f36019d.g();
                            long i4 = this.f36019d.i();
                            f2 = this.f36019d.f();
                            long j16 = currentTimeMillis - startTime;
                            j2 = h2 - currentTimeMillis;
                            long j17 = j15 - h2;
                            int k = this.f36019d.k();
                            j3 = i4 - j15;
                            long j18 = g2 - j15;
                            j4 = i4 - g2;
                            long j19 = f2 - i4;
                            if (f2 > 0) {
                            }
                            j6 = j4;
                            try {
                                newInstance = this.f36017b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                                i3 = i2;
                                j7 = j3;
                            } catch (Exception unused) {
                                try {
                                    i3 = i2;
                                    j7 = j3;
                                    newInstance = this.f36017b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.f36016a.getCmd()));
                                    String str2 = "";
                                    if (z) {
                                    }
                                    newInstance.setOrginalMessage(this.f36016a);
                                    if (!z) {
                                    }
                                    newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                                    newInstance.setStartTime(System.currentTimeMillis());
                                    publishProgress(newInstance);
                                    if (newInstance.isSuccess()) {
                                    }
                                } catch (Exception e3) {
                                    if (BdLog.isDebugMode()) {
                                        BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                                    }
                                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.f36016a.getCmd(), this.f36016a);
                                    c.a.e.e.n.l.a.a(str, cmd, this.f36017b.getUrl(), false, true, j2, 0L, 0L, 0L, 0L, 0);
                                    return errorHttpResponsedMessage;
                                }
                            }
                            String str22 = "";
                            if (z) {
                            }
                            newInstance.setOrginalMessage(this.f36016a);
                            if (!z) {
                            }
                            newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } else {
                        if (this.f36017b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                            this.f36019d.e(retry, a2, a3);
                        } else if (this.f36017b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                            this.f36019d.n(retry, a2, a3);
                        }
                        z2 = false;
                        z = false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
                cmd = this.f36017b.getCmd();
                str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                long startTime2 = this.f36016a.getStartTime();
                long h22 = this.f36019d.h();
                long j152 = this.f36019d.j();
                long g22 = this.f36019d.g();
                long i42 = this.f36019d.i();
                f2 = this.f36019d.f();
                long j162 = currentTimeMillis - startTime2;
                j2 = h22 - currentTimeMillis;
                long j172 = j152 - h22;
                int k2 = this.f36019d.k();
                j3 = i42 - j152;
                long j182 = g22 - j152;
                j4 = i42 - g22;
                long j192 = f2 - i42;
                if (f2 > 0) {
                    i2 = k2;
                    j5 = 0;
                } else {
                    j5 = j192;
                    i2 = k2;
                }
                try {
                    j6 = j4;
                    newInstance = this.f36017b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    i3 = i2;
                    j7 = j3;
                } catch (Exception unused2) {
                    j6 = j4;
                }
                String str222 = "";
                if (z) {
                    if (z2) {
                        newInstance.setStatusCode(200, "");
                    } else {
                        newInstance.setStatusCode(400, "");
                    }
                    newInstance.setContentLength(this.f36018c.c().f2274f);
                    j8 = j2;
                } else {
                    if (this.f36018c.d().size() > 0) {
                        String str3 = this.f36018c.d().get(this.f36018c.d().size() - 1).f2255h;
                        j8 = j2;
                        this.f36016a.setEncodedBinarySize(this.f36018c.d().get(this.f36018c.d().size() - 1).f2248a);
                        str222 = str3;
                    } else {
                        j8 = j2;
                    }
                    newInstance.setStatusCode(this.f36018c.c().f2270b, str222);
                    newInstance.setHeader(this.f36018c.c().f2275g);
                    newInstance.setContentEncoding(this.f36018c.c().f2272d);
                    newInstance.setContentLength(this.f36018c.c().f2274f);
                    newInstance.setContentType(this.f36018c.c().f2273e);
                    newInstance.setDownSize(this.f36018c.c().f2277i);
                    if (!newInstance.isSuccess()) {
                        newInstance.setError(newInstance.getStatusCode());
                    }
                }
                newInstance.setOrginalMessage(this.f36016a);
                if (!z) {
                    if (newInstance.isSuccess()) {
                        try {
                            newInstance.decodeInBackGround(this.f36016a.getCmd(), this.f36018c.c().f2276h);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            j12 = currentTimeMillis2 - currentTimeMillis;
                            j13 = currentTimeMillis2 - f2;
                            newInstance.performanceData.f2020a = j162;
                            newInstance.performanceData.l = j172;
                            newInstance.performanceData.k = i3;
                            j11 = j8;
                            try {
                                newInstance.performanceData.f2021b = j11;
                                j14 = j7;
                            } catch (Exception e5) {
                                e = e5;
                            }
                            try {
                                newInstance.performanceData.f2022c = j14;
                                j9 = j182;
                            } catch (Exception e6) {
                                e = e6;
                                j7 = j14;
                                j9 = j182;
                                j10 = j6;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f36016a.getExtra() instanceof NetMessage) {
                                }
                                String url = this.f36017b.getUrl();
                                boolean isSuccess = newInstance.isSuccess();
                                c.a.e.c.i.a aVar = newInstance.performanceData;
                                c.a.e.e.n.l.a.a(str, cmd, url, isSuccess, true, j11, j7, aVar.f2026g, j9, j10, aVar.f2028i);
                                newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                            try {
                                newInstance.performanceData.f2023d = j9;
                                j10 = j6;
                                try {
                                    newInstance.performanceData.f2024e = j10;
                                    j7 = j14;
                                } catch (Exception e7) {
                                    e = e7;
                                    j7 = j14;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                j7 = j14;
                                j10 = j6;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f36016a.getExtra() instanceof NetMessage) {
                                }
                                String url2 = this.f36017b.getUrl();
                                boolean isSuccess2 = newInstance.isSuccess();
                                c.a.e.c.i.a aVar2 = newInstance.performanceData;
                                c.a.e.e.n.l.a.a(str, cmd, url2, isSuccess2, true, j11, j7, aVar2.f2026g, j9, j10, aVar2.f2028i);
                                newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            j9 = j182;
                            j10 = j6;
                            j11 = j8;
                        }
                        try {
                            newInstance.performanceData.f2025f = j5;
                            newInstance.performanceData.f2026g = j13;
                            newInstance.setCostTime(j12);
                            newInstance.beforeDispatchInBackGround(this.f36016a.getCmd(), this.f36018c.c().f2276h);
                        } catch (Exception e10) {
                            e = e10;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                            BdLog.detailException(e);
                            if (this.f36016a.getExtra() instanceof NetMessage) {
                            }
                            String url22 = this.f36017b.getUrl();
                            boolean isSuccess22 = newInstance.isSuccess();
                            c.a.e.c.i.a aVar22 = newInstance.performanceData;
                            c.a.e.e.n.l.a.a(str, cmd, url22, isSuccess22, true, j11, j7, aVar22.f2026g, j9, j10, aVar22.f2028i);
                            newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } else {
                        j9 = j182;
                        j10 = j6;
                        j11 = j8;
                    }
                    if (this.f36016a.getExtra() instanceof NetMessage) {
                        NetMessage netMessage = (NetMessage) this.f36016a.getExtra();
                        newInstance.performanceData.f2028i = netMessage.getSocketErrNo();
                        newInstance.performanceData.f2029j = netMessage.getSocketCostTime();
                    }
                    String url222 = this.f36017b.getUrl();
                    boolean isSuccess222 = newInstance.isSuccess();
                    c.a.e.c.i.a aVar222 = newInstance.performanceData;
                    c.a.e.e.n.l.a.a(str, cmd, url222, isSuccess222, true, j11, j7, aVar222.f2026g, j9, j10, aVar222.f2028i);
                }
                newInstance.logStatInBackground(this.f36016a.getCmd(), this.f36018c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        return null;
                    }
                    newInstance.afterDispatchInBackGround(this.f36016a.getCmd(), this.f36018c.c().f2276h);
                    return null;
                } catch (Exception e11) {
                    BdLog.e(e11.getMessage());
                    return null;
                }
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }

        public HttpMessage e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36016a : (HttpMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            this.f36020e.f1934a.dispatchResponsedMessage(responsedMessageArr[0]);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.e.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? j(String.valueOf(i2), bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.e.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i2));
        }
    }

    public LinkedList<HttpMessage> i(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) ? j(null, bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public LinkedList<HttpMessage> j(String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bdUniqueId)) == null) {
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
        return (LinkedList) invokeLL.objValue;
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask) == null) {
            new a(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
        }
    }
}
