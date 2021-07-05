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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.j.a.c;
import d.a.c.e.j.a.e;
import d.a.c.e.j.a.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends d.a.c.c.e.a<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HttpMessage f2138a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f2139b;

        /* renamed from: c  reason: collision with root package name */
        public final e f2140c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f2141d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HttpClient f2142e;

        /* renamed from: com.baidu.adp.framework.client.HttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0021a implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f2143a;

            public C0021a(a aVar) {
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
                this.f2143a = aVar;
            }

            @Override // d.a.c.e.j.a.h
            public void onProgress(int i2, int i3) {
                HttpMessageTask.a downloadTask;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (downloadTask = this.f2143a.f2139b.getDownloadTask()) == null || downloadTask.a() <= 0) {
                    return;
                }
                HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.a());
                httpProgressResponsedMessage.setProgress(i2 / i3);
                this.f2143a.publishProgress(httpProgressResponsedMessage);
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
            this.f2142e = httpClient;
            this.f2138a = null;
            this.f2139b = null;
            this.f2141d = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.f2138a = httpMessage;
            this.f2139b = httpMessageTask;
            this.f2140c = new e();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                if (this.f2141d != null) {
                    this.f2141d.b();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0325  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0389 A[Catch: Exception -> 0x039b, TRY_LEAVE, TryCatch #2 {Exception -> 0x039b, blocks: (B:109:0x0383, B:111:0x0389), top: B:132:0x0383 }] */
        /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x027b  */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessageArr)) == null) {
                if (this.f2142e.f43881a.getController().i(this.f2138a, this.f2139b) == null) {
                    return null;
                }
                List<Map.Entry<String, Object>> encodeInBackGround = this.f2138a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.f2140c.b().s(this.f2139b.getUrl());
                this.f2140c.b().q(this.f2139b.getMethod());
                this.f2140c.b().p(this.f2138a.getHeaders());
                this.f2140c.b().r(encodeInBackGround);
                int a2 = this.f2139b.getTimeOut().a();
                int a3 = this.f2139b.getConnectTimeOut().a();
                int retry = this.f2139b.getRetry();
                try {
                    this.f2141d = new c(this.f2140c);
                    if (this.f2139b.getDownloadTask() != null && this.f2139b.getDownloadTask().b() != null) {
                        try {
                            z2 = this.f2141d.d(this.f2139b.getDownloadTask().b(), new C0021a(this), retry, a2, a3, this.f2139b.getDownloadTask().c());
                            z = true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            BdLog.detailException(e);
                            z2 = false;
                            cmd = this.f2139b.getCmd();
                            str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                            long startTime = this.f2138a.getStartTime();
                            long h2 = this.f2141d.h();
                            long j12 = this.f2141d.j();
                            long g2 = this.f2141d.g();
                            long i4 = this.f2141d.i();
                            f2 = this.f2141d.f();
                            long j13 = currentTimeMillis - startTime;
                            j = h2 - currentTimeMillis;
                            long j14 = j12 - h2;
                            int k = this.f2141d.k();
                            j2 = i4 - j12;
                            long j15 = g2 - j12;
                            j3 = i4 - g2;
                            long j16 = f2 - i4;
                            if (f2 > 0) {
                            }
                            j5 = j3;
                            try {
                                newInstance = this.f2139b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                                i3 = i2;
                                j6 = j2;
                            } catch (Exception unused) {
                                try {
                                    i3 = i2;
                                    j6 = j2;
                                    newInstance = this.f2139b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.f2138a.getCmd()));
                                    String str2 = "";
                                    if (z) {
                                    }
                                    newInstance.setOrginalMessage(this.f2138a);
                                    if (!z) {
                                    }
                                    newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                                    newInstance.setStartTime(System.currentTimeMillis());
                                    publishProgress(newInstance);
                                    if (newInstance.isSuccess()) {
                                    }
                                } catch (Exception e3) {
                                    if (BdLog.isDebugMode()) {
                                        BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                                    }
                                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.f2138a.getCmd(), this.f2138a);
                                    d.a.c.e.n.j.a.a(str, cmd, this.f2139b.getUrl(), false, true, j, 0L, 0L, 0L, 0L, 0);
                                    return errorHttpResponsedMessage;
                                }
                            }
                            String str22 = "";
                            if (z) {
                            }
                            newInstance.setOrginalMessage(this.f2138a);
                            if (!z) {
                            }
                            newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } else {
                        if (this.f2139b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                            this.f2141d.e(retry, a2, a3);
                        } else if (this.f2139b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                            this.f2141d.n(retry, a2, a3);
                        }
                        z2 = false;
                        z = false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
                cmd = this.f2139b.getCmd();
                str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1002400 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                long startTime2 = this.f2138a.getStartTime();
                long h22 = this.f2141d.h();
                long j122 = this.f2141d.j();
                long g22 = this.f2141d.g();
                long i42 = this.f2141d.i();
                f2 = this.f2141d.f();
                long j132 = currentTimeMillis - startTime2;
                j = h22 - currentTimeMillis;
                long j142 = j122 - h22;
                int k2 = this.f2141d.k();
                j2 = i42 - j122;
                long j152 = g22 - j122;
                j3 = i42 - g22;
                long j162 = f2 - i42;
                if (f2 > 0) {
                    i2 = k2;
                    j4 = 0;
                } else {
                    j4 = j162;
                    i2 = k2;
                }
                try {
                    j5 = j3;
                    newInstance = this.f2139b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
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
                    newInstance.setContentLength(this.f2140c.c().f44211f);
                    j7 = j;
                } else {
                    if (this.f2140c.d().size() > 0) {
                        String str3 = this.f2140c.d().get(this.f2140c.d().size() - 1).f44193h;
                        j7 = j;
                        this.f2138a.setEncodedBinarySize(this.f2140c.d().get(this.f2140c.d().size() - 1).f44186a);
                        str222 = str3;
                    } else {
                        j7 = j;
                    }
                    newInstance.setStatusCode(this.f2140c.c().f44207b, str222);
                    newInstance.setHeader(this.f2140c.c().f44212g);
                    newInstance.setContentEncoding(this.f2140c.c().f44209d);
                    newInstance.setContentLength(this.f2140c.c().f44211f);
                    newInstance.setContentType(this.f2140c.c().f44210e);
                    newInstance.setDownSize(this.f2140c.c().f44214i);
                    if (!newInstance.isSuccess()) {
                        newInstance.setError(newInstance.getStatusCode());
                    }
                }
                newInstance.setOrginalMessage(this.f2138a);
                if (!z) {
                    if (newInstance.isSuccess()) {
                        try {
                            newInstance.decodeInBackGround(this.f2138a.getCmd(), this.f2140c.c().f44213h);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j17 = currentTimeMillis2 - currentTimeMillis;
                            long j18 = currentTimeMillis2 - f2;
                            newInstance.performanceData.f43963a = j132;
                            newInstance.performanceData.l = j142;
                            newInstance.performanceData.k = i3;
                            j10 = j7;
                            try {
                                newInstance.performanceData.f43964b = j10;
                                j11 = j6;
                            } catch (Exception e5) {
                                e = e5;
                            }
                            try {
                                newInstance.performanceData.f43965c = j11;
                                j8 = j152;
                            } catch (Exception e6) {
                                e = e6;
                                j6 = j11;
                                j8 = j152;
                                j9 = j5;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f2138a.getExtra() instanceof NetMessage) {
                                }
                                String url = this.f2139b.getUrl();
                                boolean isSuccess = newInstance.isSuccess();
                                d.a.c.c.i.a aVar = newInstance.performanceData;
                                d.a.c.e.n.j.a.a(str, cmd, url, isSuccess, true, j10, j6, aVar.f43969g, j8, j9, aVar.f43971i);
                                newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                            try {
                                newInstance.performanceData.f43966d = j8;
                                j9 = j5;
                                try {
                                    newInstance.performanceData.f43967e = j9;
                                    j6 = j11;
                                    try {
                                        newInstance.performanceData.f43968f = j4;
                                        newInstance.performanceData.f43969g = j18;
                                        newInstance.setCostTime(j17);
                                        newInstance.beforeDispatchInBackGround(this.f2138a.getCmd(), this.f2140c.c().f44213h);
                                    } catch (Exception e7) {
                                        e = e7;
                                        newInstance.setError(-1003);
                                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                        BdLog.detailException(e);
                                        if (this.f2138a.getExtra() instanceof NetMessage) {
                                        }
                                        String url2 = this.f2139b.getUrl();
                                        boolean isSuccess2 = newInstance.isSuccess();
                                        d.a.c.c.i.a aVar2 = newInstance.performanceData;
                                        d.a.c.e.n.j.a.a(str, cmd, url2, isSuccess2, true, j10, j6, aVar2.f43969g, j8, j9, aVar2.f43971i);
                                        newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                                        newInstance.setStartTime(System.currentTimeMillis());
                                        publishProgress(newInstance);
                                        if (newInstance.isSuccess()) {
                                        }
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    j6 = j11;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                j6 = j11;
                                j9 = j5;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                                BdLog.detailException(e);
                                if (this.f2138a.getExtra() instanceof NetMessage) {
                                }
                                String url22 = this.f2139b.getUrl();
                                boolean isSuccess22 = newInstance.isSuccess();
                                d.a.c.c.i.a aVar22 = newInstance.performanceData;
                                d.a.c.e.n.j.a.a(str, cmd, url22, isSuccess22, true, j10, j6, aVar22.f43969g, j8, j9, aVar22.f43971i);
                                newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            j8 = j152;
                            j9 = j5;
                            j10 = j7;
                        }
                    } else {
                        j8 = j152;
                        j9 = j5;
                        j10 = j7;
                    }
                    if (this.f2138a.getExtra() instanceof NetMessage) {
                        NetMessage netMessage = (NetMessage) this.f2138a.getExtra();
                        newInstance.performanceData.f43971i = netMessage.getSocketErrNo();
                        newInstance.performanceData.j = netMessage.getSocketCostTime();
                    }
                    String url222 = this.f2139b.getUrl();
                    boolean isSuccess222 = newInstance.isSuccess();
                    d.a.c.c.i.a aVar222 = newInstance.performanceData;
                    d.a.c.e.n.j.a.a(str, cmd, url222, isSuccess222, true, j10, j6, aVar222.f43969g, j8, j9, aVar222.f43971i);
                }
                newInstance.logStatInBackground(this.f2138a.getCmd(), this.f2140c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        return null;
                    }
                    newInstance.afterDispatchInBackGround(this.f2138a.getCmd(), this.f2140c.c().f44213h);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2138a : (HttpMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            this.f2142e.f43881a.dispatchResponsedMessage(responsedMessageArr[0]);
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

    @Override // d.a.c.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? j(String.valueOf(i2), bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // d.a.c.c.b
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
    @Override // d.a.c.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask) == null) {
            new a(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
        }
    }
}
