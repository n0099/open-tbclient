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
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ea;
import com.baidu.tieba.qb;
import com.baidu.tieba.rh;
import com.baidu.tieba.vf;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends ea<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            }
        }

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
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HttpMessage a;
        public HttpMessageTask b;
        public final yf c;
        public volatile vf d;

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
            this.c = new yf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0351  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x03c0 A[Catch: Exception -> 0x03d2, TRY_LEAVE, TryCatch #8 {Exception -> 0x03d2, blocks: (B:94:0x03ba, B:96:0x03c0), top: B:127:0x03ba }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            InterceptResult invokeL;
            String str;
            long j;
            long j2;
            String str2;
            String str3;
            HttpResponsedMessage newInstance;
            String str4;
            HttpResponsedMessage httpResponsedMessage;
            long j3;
            long j4;
            long j5;
            long j6;
            HttpResponsedMessage httpResponsedMessage2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpMessageArr)) == null) {
                if (MessageManager.getInstance().getController().g(this.a, this.b) == null) {
                    return null;
                }
                NetLog.getInstance().c(rh.a, "HttpClient开始请求：cmd:" + this.a.getCmd() + " url:" + this.b.getUrl() + " ResponseClass:" + this.b.getResponsedClass());
                List<Map.Entry<String, Object>> encodeInBackGround = this.a.encodeInBackGround();
                long currentTimeMillis = System.currentTimeMillis();
                this.c.b().s(this.b.getUrl());
                this.c.b().q(this.b.getMethod());
                this.c.b().p(this.a.getHeaders());
                this.c.b().r(encodeInBackGround);
                int a = this.b.getTimeOut().a();
                int a2 = this.b.getConnectTimeOut().a();
                int retry = this.b.getRetry();
                try {
                    this.d = new vf(this.c);
                    if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                        this.d.d(retry, a, a2);
                    } else if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.d.m(retry, a, a2);
                    }
                } catch (Exception e) {
                    NetLog.getInstance().c(rh.a, " httpclient has error : " + e.getMessage());
                    BdLog.detailException(e);
                }
                int cmd = this.b.getCmd();
                if (cmd == 1001703) {
                    str = "frs";
                } else if (cmd == 1001801) {
                    str = "pb";
                } else if (cmd == 1003070) {
                    str = "home_page";
                } else if (cmd == 1003528) {
                    str = "enter_forum";
                } else if (cmd == 1002700) {
                    str = "user_center";
                } else if (cmd == 1001503) {
                    str = "person_center_post";
                } else if (cmd == 1003446) {
                    str = "person_center_dynamic";
                } else {
                    str = "other";
                }
                String str5 = str;
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
                long j14 = e2 - h;
                if (e2 <= 0) {
                    j2 = j13;
                    j = 0;
                } else {
                    j = j14;
                    j2 = j13;
                }
                Map<String, List<String>> map = this.c.c().h;
                if (map == null || map.isEmpty()) {
                    str2 = "";
                    str3 = str2;
                } else {
                    str2 = "";
                    str3 = String.valueOf(map.get("tracecode"));
                }
                long j15 = j12;
                NetLog.getInstance().c(rh.a, "底层网络库返回：tracecode:" + str3 + " success:" + this.b.getUrl());
                try {
                    try {
                        newInstance = this.b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception e3) {
                        if (BdLog.isDebugMode()) {
                            BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                        }
                        ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.a.getCmd(), this.a);
                        rh.a(str5, cmd, this.b.getUrl(), false, true, j8, 0L, 0L, 0L, 0L, 0);
                        return errorHttpResponsedMessage;
                    }
                } catch (Exception unused) {
                    newInstance = this.b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.a.getCmd()));
                }
                HttpResponsedMessage httpResponsedMessage3 = newInstance;
                if (this.c.d().size() > 0) {
                    str4 = this.c.d().get(this.c.d().size() - 1).h;
                } else {
                    str4 = str2;
                }
                httpResponsedMessage3.setStatusCode(this.c.c().b, str4);
                httpResponsedMessage3.setHeader(this.c.c().h);
                httpResponsedMessage3.setContentLength(this.c.c().f);
                httpResponsedMessage3.setContentType(this.c.c().e);
                httpResponsedMessage3.setDownSize(this.c.c().j);
                if (!httpResponsedMessage3.isSuccess()) {
                    httpResponsedMessage3.setError(httpResponsedMessage3.getStatusCode());
                }
                httpResponsedMessage3.setOrginalMessage(this.a);
                if (httpResponsedMessage3.isSuccess()) {
                    try {
                        httpResponsedMessage3.decodeInBackGround(this.a.getCmd(), this.c.c().i);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j5 = currentTimeMillis2 - currentTimeMillis;
                        j6 = currentTimeMillis2 - e2;
                        httpResponsedMessage3.performanceData.a = j7;
                        httpResponsedMessage3.performanceData.l = j9;
                        httpResponsedMessage3.performanceData.k = j10;
                        httpResponsedMessage3.performanceData.b = j8;
                        j4 = j11;
                        try {
                            httpResponsedMessage3.performanceData.c = j4;
                        } catch (Exception e4) {
                            e = e4;
                        }
                        try {
                            httpResponsedMessage3.performanceData.d = j15;
                            j15 = j15;
                            j3 = j2;
                            try {
                                httpResponsedMessage3.performanceData.e = j3;
                                try {
                                    httpResponsedMessage3.performanceData.f = j;
                                    httpResponsedMessage = httpResponsedMessage3;
                                } catch (Exception e5) {
                                    e = e5;
                                    httpResponsedMessage = httpResponsedMessage3;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                httpResponsedMessage = httpResponsedMessage3;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            j15 = j15;
                            httpResponsedMessage = httpResponsedMessage3;
                            j3 = j2;
                            NetLog.getInstance().c(rh.a, " 解码失败 : " + e.getMessage());
                            httpResponsedMessage.setError(-1003);
                            httpResponsedMessage.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0695));
                            BdLog.detailException(e);
                            if (this.a.getExtra() instanceof NetMessage) {
                            }
                            String url = this.b.getUrl();
                            boolean isSuccess = httpResponsedMessage.isSuccess();
                            qb qbVar = httpResponsedMessage.performanceData;
                            httpResponsedMessage2 = httpResponsedMessage;
                            rh.a(str5, cmd, url, isSuccess, true, j8, j4, qbVar.g, j15, j3, qbVar.i);
                            httpResponsedMessage2.logStatInBackground(this.a.getCmd(), this.c);
                            httpResponsedMessage2.setStartTime(System.currentTimeMillis());
                            publishProgress(httpResponsedMessage2);
                            if (httpResponsedMessage2.isSuccess()) {
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        httpResponsedMessage = httpResponsedMessage3;
                        j3 = j2;
                        j4 = j11;
                    }
                    try {
                        httpResponsedMessage.performanceData.g = j6;
                        httpResponsedMessage.setCostTime(j5);
                        httpResponsedMessage.beforeDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                    } catch (Exception e9) {
                        e = e9;
                        NetLog.getInstance().c(rh.a, " 解码失败 : " + e.getMessage());
                        httpResponsedMessage.setError(-1003);
                        httpResponsedMessage.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0695));
                        BdLog.detailException(e);
                        if (this.a.getExtra() instanceof NetMessage) {
                        }
                        String url2 = this.b.getUrl();
                        boolean isSuccess2 = httpResponsedMessage.isSuccess();
                        qb qbVar2 = httpResponsedMessage.performanceData;
                        httpResponsedMessage2 = httpResponsedMessage;
                        rh.a(str5, cmd, url2, isSuccess2, true, j8, j4, qbVar2.g, j15, j3, qbVar2.i);
                        httpResponsedMessage2.logStatInBackground(this.a.getCmd(), this.c);
                        httpResponsedMessage2.setStartTime(System.currentTimeMillis());
                        publishProgress(httpResponsedMessage2);
                        if (httpResponsedMessage2.isSuccess()) {
                        }
                    }
                } else {
                    httpResponsedMessage = httpResponsedMessage3;
                    j3 = j2;
                    j4 = j11;
                }
                if (this.a.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.a.getExtra();
                    httpResponsedMessage.performanceData.i = netMessage.getSocketErrNo();
                    httpResponsedMessage.performanceData.j = netMessage.getSocketCostTime();
                }
                String url22 = this.b.getUrl();
                boolean isSuccess22 = httpResponsedMessage.isSuccess();
                qb qbVar22 = httpResponsedMessage.performanceData;
                httpResponsedMessage2 = httpResponsedMessage;
                rh.a(str5, cmd, url22, isSuccess22, true, j8, j4, qbVar22.g, j15, j3, qbVar22.i);
                httpResponsedMessage2.logStatInBackground(this.a.getCmd(), this.c);
                httpResponsedMessage2.setStartTime(System.currentTimeMillis());
                publishProgress(httpResponsedMessage2);
                try {
                    if (httpResponsedMessage2.isSuccess()) {
                        httpResponsedMessage2.afterDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                        return null;
                    }
                    return null;
                } catch (Exception e10) {
                    NetLog.getInstance().c(rh.a, " httpclient has error : " + e10.getMessage());
                    BdLog.e(e10.getMessage());
                    return null;
                }
            }
            return (HttpResponsedMessage) invokeL.objValue;
        }

        public HttpMessage c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (HttpMessage) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, responsedMessageArr) == null) && responsedMessageArr != null && responsedMessageArr.length > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(responsedMessageArr[0]);
            }
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

    @Override // com.baidu.tieba.ba
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) {
            return i(String.valueOf(i), bdUniqueId);
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.ba
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ba
    /* renamed from: k */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, httpMessage, httpMessageTask) == null) {
            new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
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
}
