package com.baidu.adp.framework.client;

import b.a.e.f.j.a.c;
import b.a.e.f.j.a.e;
import b.a.e.f.j.a.h;
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
/* loaded from: classes6.dex */
public class HttpClient extends b.a.e.c.e.a<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HttpMessage f35196a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f35197b;

        /* renamed from: c  reason: collision with root package name */
        public final e f35198c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f35199d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HttpClient f35200e;

        /* renamed from: com.baidu.adp.framework.client.HttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1570a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35201a;

            public C1570a(a aVar) {
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
                this.f35201a = aVar;
            }

            @Override // b.a.e.f.j.a.h
            public void onProgress(int i2, int i3) {
                HttpMessageTask.a downloadTask;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (downloadTask = this.f35201a.f35197b.getDownloadTask()) == null || downloadTask.a() <= 0) {
                    return;
                }
                HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.a());
                httpProgressResponsedMessage.setProgress(i2 / i3);
                this.f35201a.publishProgress(httpProgressResponsedMessage);
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
            this.f35200e = httpClient;
            this.f35196a = null;
            this.f35197b = null;
            this.f35199d = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.f35196a = httpMessage;
            this.f35197b = httpMessageTask;
            this.f35198c = new e();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                if (this.f35199d != null) {
                    this.f35199d.b();
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessageArr)) == null) {
                if (this.f35200e.f1475a.getController().i(this.f35196a, this.f35197b) == null) {
                    return null;
                }
                List<Map.Entry<String, Object>> encodeInBackGround = this.f35196a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.f35198c.b().s(this.f35197b.getUrl());
                this.f35198c.b().q(this.f35197b.getMethod());
                this.f35198c.b().p(this.f35196a.getHeaders());
                this.f35198c.b().r(encodeInBackGround);
                int a2 = this.f35197b.getTimeOut().a();
                int a3 = this.f35197b.getConnectTimeOut().a();
                int retry = this.f35197b.getRetry();
                try {
                    this.f35199d = new c(this.f35198c);
                    if (this.f35197b.getDownloadTask() != null && this.f35197b.getDownloadTask().b() != null) {
                        try {
                            z2 = this.f35199d.d(this.f35197b.getDownloadTask().b(), new C1570a(this), retry, a2, a3, this.f35197b.getDownloadTask().c());
                            z = true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            BdLog.detailException(e);
                            z2 = false;
                            cmd = this.f35197b.getCmd();
                            str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                            long startTime = this.f35196a.getStartTime();
                            long h2 = this.f35199d.h();
                            long j14 = this.f35199d.j();
                            long g2 = this.f35199d.g();
                            long i4 = this.f35199d.i();
                            f2 = this.f35199d.f();
                            long j15 = currentTimeMillis - startTime;
                            j = h2 - currentTimeMillis;
                            long j16 = j14 - h2;
                            int k = this.f35199d.k();
                            j2 = i4 - j14;
                            long j17 = g2 - j14;
                            j3 = i4 - g2;
                            long j18 = f2 - i4;
                            if (f2 > 0) {
                            }
                            j5 = j3;
                            try {
                                newInstance = this.f35197b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                                i3 = i2;
                                j6 = j2;
                            } catch (Exception unused) {
                                try {
                                    i3 = i2;
                                    j6 = j2;
                                    newInstance = this.f35197b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.f35196a.getCmd()));
                                    String str2 = "";
                                    if (z) {
                                    }
                                    newInstance.setOrginalMessage(this.f35196a);
                                    if (!z) {
                                    }
                                    newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
                                    newInstance.setStartTime(System.currentTimeMillis());
                                    publishProgress(newInstance);
                                    if (newInstance.isSuccess()) {
                                    }
                                } catch (Exception e3) {
                                    if (BdLog.isDebugMode()) {
                                        BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                                    }
                                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.f35196a.getCmd(), this.f35196a);
                                    b.a.e.f.n.l.a.a(str, cmd, this.f35197b.getUrl(), false, true, j, 0L, 0L, 0L, 0L, 0);
                                    return errorHttpResponsedMessage;
                                }
                            }
                            String str22 = "";
                            if (z) {
                            }
                            newInstance.setOrginalMessage(this.f35196a);
                            if (!z) {
                            }
                            newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } else {
                        if (this.f35197b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                            this.f35199d.e(retry, a2, a3);
                        } else if (this.f35197b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                            this.f35199d.n(retry, a2, a3);
                        }
                        z2 = false;
                        z = false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
                cmd = this.f35197b.getCmd();
                str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                long startTime2 = this.f35196a.getStartTime();
                long h22 = this.f35199d.h();
                long j142 = this.f35199d.j();
                long g22 = this.f35199d.g();
                long i42 = this.f35199d.i();
                f2 = this.f35199d.f();
                long j152 = currentTimeMillis - startTime2;
                j = h22 - currentTimeMillis;
                long j162 = j142 - h22;
                int k2 = this.f35199d.k();
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
                    newInstance = this.f35197b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
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
                    newInstance.setContentLength(this.f35198c.c().f1813f);
                    j7 = j;
                } else {
                    if (this.f35198c.d().size() > 0) {
                        String str3 = this.f35198c.d().get(this.f35198c.d().size() - 1).f1795h;
                        j7 = j;
                        this.f35196a.setEncodedBinarySize(this.f35198c.d().get(this.f35198c.d().size() - 1).f1788a);
                        str222 = str3;
                    } else {
                        j7 = j;
                    }
                    newInstance.setStatusCode(this.f35198c.c().f1809b, str222);
                    newInstance.setHeader(this.f35198c.c().f1814g);
                    newInstance.setContentEncoding(this.f35198c.c().f1811d);
                    newInstance.setContentLength(this.f35198c.c().f1813f);
                    newInstance.setContentType(this.f35198c.c().f1812e);
                    newInstance.setDownSize(this.f35198c.c().f1816i);
                    if (!newInstance.isSuccess()) {
                        newInstance.setError(newInstance.getStatusCode());
                    }
                }
                newInstance.setOrginalMessage(this.f35196a);
                if (!z) {
                    if (newInstance.isSuccess()) {
                        try {
                            newInstance.decodeInBackGround(this.f35196a.getCmd(), this.f35198c.c().f1815h);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            j11 = currentTimeMillis2 - currentTimeMillis;
                            j12 = currentTimeMillis2 - f2;
                            newInstance.performanceData.f1557a = j152;
                            newInstance.performanceData.l = j162;
                            newInstance.performanceData.k = i3;
                            j10 = j7;
                            try {
                                newInstance.performanceData.f1558b = j10;
                                j13 = j6;
                            } catch (Exception e5) {
                                e = e5;
                            }
                            try {
                                newInstance.performanceData.f1559c = j13;
                                j8 = j172;
                            } catch (Exception e6) {
                                e = e6;
                                j6 = j13;
                                j8 = j172;
                                j9 = j5;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f35196a.getExtra() instanceof NetMessage) {
                                }
                                String url = this.f35197b.getUrl();
                                boolean isSuccess = newInstance.isSuccess();
                                b.a.e.c.i.a aVar = newInstance.performanceData;
                                b.a.e.f.n.l.a.a(str, cmd, url, isSuccess, true, j10, j6, aVar.f1563g, j8, j9, aVar.f1565i);
                                newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                            try {
                                newInstance.performanceData.f1560d = j8;
                                j9 = j5;
                                try {
                                    newInstance.performanceData.f1561e = j9;
                                    j6 = j13;
                                } catch (Exception e7) {
                                    e = e7;
                                    j6 = j13;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                j6 = j13;
                                j9 = j5;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f35196a.getExtra() instanceof NetMessage) {
                                }
                                String url2 = this.f35197b.getUrl();
                                boolean isSuccess2 = newInstance.isSuccess();
                                b.a.e.c.i.a aVar2 = newInstance.performanceData;
                                b.a.e.f.n.l.a.a(str, cmd, url2, isSuccess2, true, j10, j6, aVar2.f1563g, j8, j9, aVar2.f1565i);
                                newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            j8 = j172;
                            j9 = j5;
                            j10 = j7;
                        }
                        try {
                            newInstance.performanceData.f1562f = j4;
                            newInstance.performanceData.f1563g = j12;
                            newInstance.setCostTime(j11);
                            newInstance.beforeDispatchInBackGround(this.f35196a.getCmd(), this.f35198c.c().f1815h);
                        } catch (Exception e10) {
                            e = e10;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                            BdLog.detailException(e);
                            if (this.f35196a.getExtra() instanceof NetMessage) {
                            }
                            String url22 = this.f35197b.getUrl();
                            boolean isSuccess22 = newInstance.isSuccess();
                            b.a.e.c.i.a aVar22 = newInstance.performanceData;
                            b.a.e.f.n.l.a.a(str, cmd, url22, isSuccess22, true, j10, j6, aVar22.f1563g, j8, j9, aVar22.f1565i);
                            newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
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
                    if (this.f35196a.getExtra() instanceof NetMessage) {
                        NetMessage netMessage = (NetMessage) this.f35196a.getExtra();
                        newInstance.performanceData.f1565i = netMessage.getSocketErrNo();
                        newInstance.performanceData.j = netMessage.getSocketCostTime();
                    }
                    String url222 = this.f35197b.getUrl();
                    boolean isSuccess222 = newInstance.isSuccess();
                    b.a.e.c.i.a aVar222 = newInstance.performanceData;
                    b.a.e.f.n.l.a.a(str, cmd, url222, isSuccess222, true, j10, j6, aVar222.f1563g, j8, j9, aVar222.f1565i);
                }
                newInstance.logStatInBackground(this.f35196a.getCmd(), this.f35198c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        return null;
                    }
                    newInstance.afterDispatchInBackGround(this.f35196a.getCmd(), this.f35198c.c().f1815h);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35196a : (HttpMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            this.f35200e.f1475a.dispatchResponsedMessage(responsedMessageArr[0]);
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

    @Override // b.a.e.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? j(String.valueOf(i2), bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // b.a.e.c.b
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
    @Override // b.a.e.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask) == null) {
            new a(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
        }
    }
}
