package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gb;
import com.repackage.kh;
import com.repackage.of;
import com.repackage.rf;
import com.repackage.u9;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends u9<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HttpMessage a;
        public HttpMessageTask b;
        public final rf c;
        public volatile of d;

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
            this.b = null;
            this.d = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.a = httpMessage;
            this.b = httpMessageTask;
            this.c = new rf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d3  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0275  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0284  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x02e7 A[Catch: Exception -> 0x02f9, TRY_LEAVE, TryCatch #2 {Exception -> 0x02f9, blocks: (B:87:0x02e1, B:89:0x02e7), top: B:111:0x02e1 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            InterceptResult invokeL;
            long j;
            HttpResponsedMessage newInstance;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpMessageArr)) == null) {
                if (MessageManager.getInstance().getController().g(this.a, this.b) == null) {
                    return null;
                }
                List<Map.Entry<String, Object>> encodeInBackGround = this.a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.c.b().v(this.b.getUrl());
                this.c.b().t(this.b.getMethod());
                this.c.b().r(this.a.getHeaders());
                this.c.b().u(encodeInBackGround);
                int a = this.b.getTimeOut().a();
                int a2 = this.b.getConnectTimeOut().a();
                int retry = this.b.getRetry();
                try {
                    this.d = new of(this.c);
                    if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                        this.d.d(retry, a, a2);
                    } else if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.d.m(retry, a, a2);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                int cmd = this.b.getCmd();
                String str = cmd == 1001703 ? "frs" : cmd == 1001801 ? "pb" : cmd == 1003070 ? "home_page" : cmd == 1003528 ? "enter_forum" : cmd == 1002700 ? "user_center" : cmd == 1001503 ? "person_center_post" : cmd == 1003446 ? "person_center_dynamic" : ImageViewerConfig.FROM_OTHER;
                long startTime = this.a.getStartTime();
                long g = this.d.g();
                long i = this.d.i();
                long f = this.d.f();
                long h = this.d.h();
                long e2 = this.d.e();
                long j7 = currentTimeMillis - startTime;
                long j8 = g - currentTimeMillis;
                long j9 = i - g;
                int j10 = this.d.j();
                long j11 = h - i;
                long j12 = f - i;
                long j13 = h - f;
                long j14 = e2 <= 0 ? 0L : e2 - h;
                try {
                    j = j13;
                    try {
                        newInstance = this.b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception unused) {
                        try {
                            newInstance = this.b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.a.getCmd()));
                            newInstance.setStatusCode(this.c.c().b, this.c.d().size() <= 0 ? this.c.d().get(this.c.d().size() - 1).h : "");
                            newInstance.setHeader(this.c.c().h);
                            newInstance.setContentLength(this.c.c().f);
                            newInstance.setContentType(this.c.c().e);
                            newInstance.setDownSize(this.c.c().j);
                            if (!newInstance.isSuccess()) {
                            }
                            newInstance.setOrginalMessage(this.a);
                            if (newInstance.isSuccess()) {
                            }
                            if (this.a.getExtra() instanceof NetMessage) {
                            }
                            String url = this.b.getUrl();
                            boolean isSuccess = newInstance.isSuccess();
                            gb gbVar = newInstance.performanceData;
                            kh.a(str, cmd, url, isSuccess, true, j2, j11, gbVar.g, j3, j4, gbVar.i);
                            newInstance.logStatInBackground(this.a.getCmd(), this.c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        } catch (Exception e3) {
                            if (BdLog.isDebugMode()) {
                                BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                            }
                            ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.a.getCmd(), this.a);
                            kh.a(str, cmd, this.b.getUrl(), false, true, j8, 0L, 0L, 0L, 0L, 0);
                            return errorHttpResponsedMessage;
                        }
                    }
                } catch (Exception unused2) {
                    j = j13;
                }
                newInstance.setStatusCode(this.c.c().b, this.c.d().size() <= 0 ? this.c.d().get(this.c.d().size() - 1).h : "");
                newInstance.setHeader(this.c.c().h);
                newInstance.setContentLength(this.c.c().f);
                newInstance.setContentType(this.c.c().e);
                newInstance.setDownSize(this.c.c().j);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
                newInstance.setOrginalMessage(this.a);
                if (newInstance.isSuccess()) {
                    j2 = j8;
                    j3 = j12;
                    j4 = j;
                } else {
                    try {
                        newInstance.decodeInBackGround(this.a.getCmd(), this.c.c().i);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j5 = currentTimeMillis2 - currentTimeMillis;
                        j6 = currentTimeMillis2 - e2;
                        try {
                            newInstance.performanceData.a = j7;
                            newInstance.performanceData.l = j9;
                            newInstance.performanceData.k = j10;
                            newInstance.performanceData.b = j8;
                            newInstance.performanceData.c = j11;
                            j3 = j12;
                        } catch (Exception e4) {
                            e = e4;
                            j2 = j8;
                            j4 = j;
                            j3 = j12;
                        }
                        try {
                            newInstance.performanceData.d = j3;
                            j4 = j;
                            try {
                                newInstance.performanceData.e = j4;
                                j2 = j8;
                            } catch (Exception e5) {
                                e = e5;
                                j2 = j8;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            j2 = j8;
                            j4 = j;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f05a0));
                            BdLog.detailException(e);
                            if (this.a.getExtra() instanceof NetMessage) {
                            }
                            String url2 = this.b.getUrl();
                            boolean isSuccess2 = newInstance.isSuccess();
                            gb gbVar2 = newInstance.performanceData;
                            kh.a(str, cmd, url2, isSuccess2, true, j2, j11, gbVar2.g, j3, j4, gbVar2.i);
                            newInstance.logStatInBackground(this.a.getCmd(), this.c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (newInstance.isSuccess()) {
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        j2 = j8;
                        j3 = j12;
                    }
                    try {
                        newInstance.performanceData.f = j14;
                        newInstance.performanceData.g = j6;
                        newInstance.setCostTime(j5);
                        newInstance.beforeDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                    } catch (Exception e8) {
                        e = e8;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f05a0));
                        BdLog.detailException(e);
                        if (this.a.getExtra() instanceof NetMessage) {
                        }
                        String url22 = this.b.getUrl();
                        boolean isSuccess22 = newInstance.isSuccess();
                        gb gbVar22 = newInstance.performanceData;
                        kh.a(str, cmd, url22, isSuccess22, true, j2, j11, gbVar22.g, j3, j4, gbVar22.i);
                        newInstance.logStatInBackground(this.a.getCmd(), this.c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (newInstance.isSuccess()) {
                        }
                    }
                }
                if (this.a.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.a.getExtra();
                    newInstance.performanceData.i = netMessage.getSocketErrNo();
                    newInstance.performanceData.j = netMessage.getSocketCostTime();
                }
                String url222 = this.b.getUrl();
                boolean isSuccess222 = newInstance.isSuccess();
                gb gbVar222 = newInstance.performanceData;
                kh.a(str, cmd, url222, isSuccess222, true, j2, j11, gbVar222.g, j3, j4, gbVar222.i);
                newInstance.logStatInBackground(this.a.getCmd(), this.c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (newInstance.isSuccess()) {
                        return null;
                    }
                    newInstance.afterDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                    return null;
                } catch (Exception e9) {
                    BdLog.e(e9.getMessage());
                    return null;
                }
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }

        public HttpMessage c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (HttpMessage) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.d != null) {
                    this.d.b();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, responsedMessageArr) == null) || responsedMessageArr == null || responsedMessageArr.length <= 0) {
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

    @Override // com.repackage.r9
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) ? i(String.valueOf(i), bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // com.repackage.r9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
        }
    }

    public LinkedList<HttpMessage> i(String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bdUniqueId)) == null) {
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
        return (LinkedList) invokeLL.objValue;
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.r9
    /* renamed from: k */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, httpMessage, httpMessageTask) == null) {
            new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
        }
    }
}
