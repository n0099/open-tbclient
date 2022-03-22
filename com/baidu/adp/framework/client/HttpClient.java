package com.baidu.adp.framework.client;

import c.a.d.f.j.b.c;
import c.a.d.f.j.b.f;
import c.a.d.f.j.b.i;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class HttpClient extends c.a.d.c.e.a<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), httpMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HttpMessage a;

        /* renamed from: b  reason: collision with root package name */
        public HttpMessageTask f23801b;

        /* renamed from: c  reason: collision with root package name */
        public final f f23802c;

        /* renamed from: d  reason: collision with root package name */
        public volatile c f23803d;

        /* renamed from: com.baidu.adp.framework.client.HttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1664a implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1664a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.d.f.j.b.i
            public void onProgress(int i, int i2) {
                HttpMessageTask.a downloadTask;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || (downloadTask = this.a.f23801b.getDownloadTask()) == null || downloadTask.a() <= 0) {
                    return;
                }
                HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.a());
                httpProgressResponsedMessage.setProgress(i / i2);
                this.a.publishProgress(httpProgressResponsedMessage);
            }
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpMessage, httpMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f23801b = null;
            this.f23803d = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.a = httpMessage;
            this.f23801b = httpMessageTask;
            this.f23802c = new f();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                if (this.f23803d != null) {
                    this.f23803d.b();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0326  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x038a A[Catch: Exception -> 0x039c, TRY_LEAVE, TryCatch #2 {Exception -> 0x039c, blocks: (B:109:0x0384, B:111:0x038a), top: B:132:0x0384 }] */
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
            int i;
            long j5;
            int i2;
            long j6;
            HttpResponsedMessage newInstance;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessageArr)) == null) {
                if (MessageManager.getInstance().getController().i(this.a, this.f23801b) == null) {
                    return null;
                }
                List<Map.Entry<String, Object>> encodeInBackGround = this.a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.f23802c.b().t(this.f23801b.getUrl());
                this.f23802c.b().r(this.f23801b.getMethod());
                this.f23802c.b().q(this.a.getHeaders());
                this.f23802c.b().s(encodeInBackGround);
                int a = this.f23801b.getTimeOut().a();
                int a2 = this.f23801b.getConnectTimeOut().a();
                int retry = this.f23801b.getRetry();
                try {
                    this.f23803d = new c(this.f23802c);
                    if (this.f23801b.getDownloadTask() != null && this.f23801b.getDownloadTask().b() != null) {
                        try {
                            z2 = this.f23803d.d(this.f23801b.getDownloadTask().b(), new C1664a(this), retry, a, a2, this.f23801b.getDownloadTask().c());
                            z = true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            BdLog.detailException(e);
                            z2 = false;
                            cmd = this.f23801b.getCmd();
                            str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1003528 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                            long startTime = this.a.getStartTime();
                            long h2 = this.f23803d.h();
                            long j12 = this.f23803d.j();
                            long g2 = this.f23803d.g();
                            long i3 = this.f23803d.i();
                            f2 = this.f23803d.f();
                            long j13 = currentTimeMillis - startTime;
                            j = h2 - currentTimeMillis;
                            long j14 = j12 - h2;
                            int k = this.f23803d.k();
                            j2 = i3 - j12;
                            long j15 = g2 - j12;
                            j3 = i3 - g2;
                            long j16 = f2 - i3;
                            if (f2 > 0) {
                            }
                            j5 = j3;
                            try {
                                newInstance = this.f23801b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                                i2 = i;
                                j6 = j2;
                            } catch (Exception unused) {
                                try {
                                    i2 = i;
                                    j6 = j2;
                                    newInstance = this.f23801b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.a.getCmd()));
                                    String str2 = "";
                                    if (z) {
                                    }
                                    newInstance.setOrginalMessage(this.a);
                                    if (!z) {
                                    }
                                    newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
                                    newInstance.setStartTime(System.currentTimeMillis());
                                    publishProgress(newInstance);
                                    if (newInstance.isSuccess()) {
                                    }
                                } catch (Exception e3) {
                                    if (BdLog.isDebugMode()) {
                                        BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                                    }
                                    ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.a.getCmd(), this.a);
                                    c.a.d.f.n.l.a.a(str, cmd, this.f23801b.getUrl(), false, true, j, 0L, 0L, 0L, 0L, 0);
                                    return errorHttpResponsedMessage;
                                }
                            }
                            String str22 = "";
                            if (z) {
                            }
                            newInstance.setOrginalMessage(this.a);
                            if (!z) {
                            }
                            newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } else {
                        if (this.f23801b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                            this.f23803d.e(retry, a, a2);
                        } else if (this.f23801b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                            this.f23803d.n(retry, a, a2);
                        }
                        z2 = false;
                        z = false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
                cmd = this.f23801b.getCmd();
                str = cmd != 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1003528 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : "other";
                long startTime2 = this.a.getStartTime();
                long h22 = this.f23803d.h();
                long j122 = this.f23803d.j();
                long g22 = this.f23803d.g();
                long i32 = this.f23803d.i();
                f2 = this.f23803d.f();
                long j132 = currentTimeMillis - startTime2;
                j = h22 - currentTimeMillis;
                long j142 = j122 - h22;
                int k2 = this.f23803d.k();
                j2 = i32 - j122;
                long j152 = g22 - j122;
                j3 = i32 - g22;
                long j162 = f2 - i32;
                if (f2 > 0) {
                    i = k2;
                    j4 = 0;
                } else {
                    j4 = j162;
                    i = k2;
                }
                try {
                    j5 = j3;
                    newInstance = this.f23801b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    i2 = i;
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
                    newInstance.setContentLength(this.f23802c.c().f2167f);
                    j7 = j;
                } else {
                    if (this.f23802c.d().size() > 0) {
                        String str3 = this.f23802c.d().get(this.f23802c.d().size() - 1).f2152h;
                        j7 = j;
                        this.a.setEncodedBinarySize(this.f23802c.d().get(this.f23802c.d().size() - 1).a);
                        str222 = str3;
                    } else {
                        j7 = j;
                    }
                    newInstance.setStatusCode(this.f23802c.c().f2163b, str222);
                    newInstance.setHeader(this.f23802c.c().f2169h);
                    newInstance.setContentEncoding(this.f23802c.c().f2165d);
                    newInstance.setContentLength(this.f23802c.c().f2167f);
                    newInstance.setContentType(this.f23802c.c().f2166e);
                    newInstance.setDownSize(this.f23802c.c().j);
                    if (!newInstance.isSuccess()) {
                        newInstance.setError(newInstance.getStatusCode());
                    }
                }
                newInstance.setOrginalMessage(this.a);
                if (!z) {
                    if (newInstance.isSuccess()) {
                        try {
                            newInstance.decodeInBackGround(this.a.getCmd(), this.f23802c.c().i);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j17 = currentTimeMillis2 - currentTimeMillis;
                            long j18 = currentTimeMillis2 - f2;
                            newInstance.performanceData.a = j132;
                            newInstance.performanceData.l = j142;
                            newInstance.performanceData.k = i2;
                            j10 = j7;
                            try {
                                newInstance.performanceData.f2014b = j10;
                                j11 = j6;
                            } catch (Exception e5) {
                                e = e5;
                            }
                            try {
                                newInstance.performanceData.f2015c = j11;
                                j8 = j152;
                            } catch (Exception e6) {
                                e = e6;
                                j6 = j11;
                                j8 = j152;
                                j9 = j5;
                                newInstance.setError(-1003);
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0598));
                                BdLog.detailException(e);
                                if (this.a.getExtra() instanceof NetMessage) {
                                }
                                String url = this.f23801b.getUrl();
                                boolean isSuccess = newInstance.isSuccess();
                                c.a.d.c.i.a aVar = newInstance.performanceData;
                                c.a.d.f.n.l.a.a(str, cmd, url, isSuccess, true, j10, j6, aVar.f2019g, j8, j9, aVar.i);
                                newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
                                newInstance.setStartTime(System.currentTimeMillis());
                                publishProgress(newInstance);
                                if (newInstance.isSuccess()) {
                                }
                            }
                            try {
                                newInstance.performanceData.f2016d = j8;
                                j9 = j5;
                                try {
                                    newInstance.performanceData.f2017e = j9;
                                    j6 = j11;
                                    try {
                                        newInstance.performanceData.f2018f = j4;
                                        newInstance.performanceData.f2019g = j18;
                                        newInstance.setCostTime(j17);
                                        newInstance.beforeDispatchInBackGround(this.a.getCmd(), this.f23802c.c().i);
                                    } catch (Exception e7) {
                                        e = e7;
                                        newInstance.setError(-1003);
                                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0598));
                                        BdLog.detailException(e);
                                        if (this.a.getExtra() instanceof NetMessage) {
                                        }
                                        String url2 = this.f23801b.getUrl();
                                        boolean isSuccess2 = newInstance.isSuccess();
                                        c.a.d.c.i.a aVar2 = newInstance.performanceData;
                                        c.a.d.f.n.l.a.a(str, cmd, url2, isSuccess2, true, j10, j6, aVar2.f2019g, j8, j9, aVar2.i);
                                        newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
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
                                newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0598));
                                BdLog.detailException(e);
                                if (this.a.getExtra() instanceof NetMessage) {
                                }
                                String url22 = this.f23801b.getUrl();
                                boolean isSuccess22 = newInstance.isSuccess();
                                c.a.d.c.i.a aVar22 = newInstance.performanceData;
                                c.a.d.f.n.l.a.a(str, cmd, url22, isSuccess22, true, j10, j6, aVar22.f2019g, j8, j9, aVar22.i);
                                newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
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
                    if (this.a.getExtra() instanceof NetMessage) {
                        NetMessage netMessage = (NetMessage) this.a.getExtra();
                        newInstance.performanceData.i = netMessage.getSocketErrNo();
                        newInstance.performanceData.j = netMessage.getSocketCostTime();
                    }
                    String url222 = this.f23801b.getUrl();
                    boolean isSuccess222 = newInstance.isSuccess();
                    c.a.d.c.i.a aVar222 = newInstance.performanceData;
                    c.a.d.f.n.l.a.a(str, cmd, url222, isSuccess222, true, j10, j6, aVar222.f2019g, j8, j9, aVar222.i);
                }
                newInstance.logStatInBackground(this.a.getCmd(), this.f23802c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        return null;
                    }
                    newInstance.afterDispatchInBackGround(this.a.getCmd(), this.f23802c.c().i);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (HttpMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(responsedMessageArr[0]);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.d.c.b
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) ? j(String.valueOf(i), bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.d.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
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
    @Override // c.a.d.c.b
    /* renamed from: l */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask) == null) {
            new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
        }
    }
}
