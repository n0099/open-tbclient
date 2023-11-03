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
import com.baidu.tieba.bb;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.o5;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class HttpClient extends o5<HttpMessage, HttpMessageTask> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "net_work_http_log";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1571774629, "Lcom/baidu/adp/framework/client/HttpClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1571774629, "Lcom/baidu/adp/framework/client/HttpClient;");
        }
    }

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
        public final bb c;
        public volatile za d;

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
            this.c = new bb();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            InterceptResult invokeL;
            String str;
            String str2;
            HttpResponsedMessage newInstance;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpMessageArr)) == null) {
                if (MessageManager.getInstance().getController().g(this.a, this.b) == null) {
                    return null;
                }
                TbLog netLog = NetLog.getInstance();
                String str4 = HttpClient.b;
                netLog.i(str4, "HttpClient开始请求：cmd:" + this.a.getCmd() + " url:" + this.b.getUrl() + " ResponseClass:" + this.b.getResponsedClass());
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
                    this.d = new za(this.c);
                    if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                        this.d.d(retry, a, a2);
                    } else if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.d.m(retry, a, a2);
                    }
                } catch (Exception e) {
                    TbLog netLog2 = NetLog.getInstance();
                    String str5 = HttpClient.b;
                    netLog2.i(str5, " httpclient has error : " + e.getMessage());
                    BdLog.detailException(e);
                }
                this.b.getCmd();
                long startTime = this.a.getStartTime();
                long g = this.d.g();
                long i = this.d.i();
                long f = this.d.f();
                long h = this.d.h();
                long e2 = this.d.e();
                long j = currentTimeMillis - startTime;
                long j2 = g - currentTimeMillis;
                long j3 = i - g;
                int j4 = this.d.j();
                long j5 = h - i;
                long j6 = f - i;
                long j7 = h - f;
                long j8 = e2 - h;
                long j9 = 0;
                if (e2 > 0) {
                    j9 = j8;
                }
                Map<String, List<String>> map = this.c.c().h;
                if (map == null || map.isEmpty()) {
                    str = "";
                    str2 = str;
                } else {
                    str = "";
                    str2 = String.valueOf(map.get("tracecode"));
                }
                TbLog netLog3 = NetLog.getInstance();
                String str6 = HttpClient.b;
                netLog3.i(str6, "底层网络库返回：tracecode:" + str2 + " success:" + this.b.getUrl());
                try {
                    try {
                        newInstance = this.b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception unused) {
                        newInstance = this.b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.a.getCmd()));
                    }
                    if (this.c.d().size() > 0) {
                        str3 = this.c.d().get(this.c.d().size() - 1).exception;
                    } else {
                        str3 = str;
                    }
                    newInstance.setStatusCode(this.c.c().b, str3);
                    newInstance.setHeader(this.c.c().h);
                    newInstance.setContentLength(this.c.c().f);
                    newInstance.setContentType(this.c.c().e);
                    newInstance.setDownSize(this.c.c().j);
                    if (!newInstance.isSuccess()) {
                        newInstance.setError(newInstance.getStatusCode());
                    }
                    newInstance.setOrginalMessage(this.a);
                    if (newInstance.isSuccess()) {
                        try {
                            newInstance.decodeInBackGround(this.a.getCmd(), this.c.c().i);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            newInstance.performanceData.a = j;
                            newInstance.performanceData.l = j3;
                            newInstance.performanceData.k = j4;
                            newInstance.performanceData.b = j2;
                            newInstance.performanceData.c = j5;
                            newInstance.performanceData.d = j6;
                            newInstance.performanceData.e = j7;
                            newInstance.performanceData.f = j9;
                            newInstance.performanceData.g = currentTimeMillis2 - e2;
                            newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                            newInstance.beforeDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                        } catch (Exception e3) {
                            TbLog netLog4 = NetLog.getInstance();
                            String str7 = HttpClient.b;
                            netLog4.i(str7, " 解码失败 : " + e3.getMessage());
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f06b4));
                            newInstance.setDecodeException(e3);
                            BdLog.detailException(e3);
                        }
                    }
                    if (this.a.getExtra() instanceof NetMessage) {
                        NetMessage netMessage = (NetMessage) this.a.getExtra();
                        newInstance.performanceData.i = netMessage.getSocketErrNo();
                        newInstance.performanceData.j = netMessage.getSocketCostTime();
                    }
                    newInstance.logStatInBackground(this.a.getCmd(), this.c);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    try {
                        if (newInstance.isSuccess()) {
                            newInstance.afterDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                            return null;
                        }
                        return null;
                    } catch (Exception e4) {
                        TbLog netLog5 = NetLog.getInstance();
                        String str8 = HttpClient.b;
                        netLog5.i(str8, " httpclient has error : " + e4.getMessage());
                        BdLog.e(e4.getMessage());
                        return null;
                    }
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.a.getCmd(), this.a);
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.l5
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) {
            return i(String.valueOf(i), bdUniqueId);
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.l5
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l5
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
