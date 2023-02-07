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
import com.baidu.tieba.ai;
import com.baidu.tieba.dc;
import com.baidu.tieba.eg;
import com.baidu.tieba.hg;
import com.baidu.tieba.ra;
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
public class HttpClient extends ra<HttpMessage, HttpMessageTask> {
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
        public final hg c;
        public volatile eg d;

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
            this.c = new hg();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0276  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0285  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x02e8 A[Catch: Exception -> 0x02fa, TRY_LEAVE, TryCatch #2 {Exception -> 0x02fa, blocks: (B:87:0x02e2, B:89:0x02e8), top: B:111:0x02e2 }] */
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
            HttpResponsedMessage newInstance;
            String str2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpMessageArr)) == null) {
                if (MessageManager.getInstance().getController().g(this.a, this.b) == null) {
                    return null;
                }
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
                    this.d = new eg(this.c);
                    if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                        this.d.d(retry, a, a2);
                    } else if (this.b.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                        this.d.m(retry, a, a2);
                    }
                } catch (Exception e) {
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
                    str = ImageViewerConfig.FROM_OTHER;
                }
                String str3 = str;
                long startTime = this.a.getStartTime();
                long g = this.d.g();
                long i = this.d.i();
                long f = this.d.f();
                long h = this.d.h();
                long e2 = this.d.e();
                long j8 = currentTimeMillis - startTime;
                long j9 = g - currentTimeMillis;
                long j10 = i - g;
                int j11 = this.d.j();
                long j12 = h - i;
                long j13 = f - i;
                long j14 = h - f;
                long j15 = e2 - h;
                if (e2 <= 0) {
                    j = 0;
                } else {
                    j = j15;
                }
                try {
                    j2 = j14;
                    try {
                        newInstance = this.b.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception unused) {
                        try {
                            newInstance = this.b.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.a.getCmd()));
                            if (this.c.d().size() <= 0) {
                            }
                            newInstance.setStatusCode(this.c.c().b, str2);
                            newInstance.setHeader(this.c.c().h);
                            newInstance.setContentLength(this.c.c().f);
                            newInstance.setContentType(this.c.c().e);
                            newInstance.setDownSize(this.c.c().j);
                            if (!newInstance.isSuccess()) {
                            }
                            newInstance.setOrginalMessage(this.a);
                            if (!newInstance.isSuccess()) {
                            }
                            if (this.a.getExtra() instanceof NetMessage) {
                            }
                            String url = this.b.getUrl();
                            boolean isSuccess = newInstance.isSuccess();
                            dc dcVar = newInstance.performanceData;
                            ai.a(str3, cmd, url, isSuccess, true, j3, j12, dcVar.g, j4, j5, dcVar.i);
                            newInstance.logStatInBackground(this.a.getCmd(), this.c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (!newInstance.isSuccess()) {
                            }
                        } catch (Exception e3) {
                            if (BdLog.isDebugMode()) {
                                BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                            }
                            ErrorHttpResponsedMessage errorHttpResponsedMessage = new ErrorHttpResponsedMessage(this.a.getCmd(), this.a);
                            ai.a(str3, cmd, this.b.getUrl(), false, true, j9, 0L, 0L, 0L, 0L, 0);
                            return errorHttpResponsedMessage;
                        }
                    }
                } catch (Exception unused2) {
                    j2 = j14;
                }
                if (this.c.d().size() <= 0) {
                    str2 = this.c.d().get(this.c.d().size() - 1).h;
                } else {
                    str2 = "";
                }
                newInstance.setStatusCode(this.c.c().b, str2);
                newInstance.setHeader(this.c.c().h);
                newInstance.setContentLength(this.c.c().f);
                newInstance.setContentType(this.c.c().e);
                newInstance.setDownSize(this.c.c().j);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
                newInstance.setOrginalMessage(this.a);
                if (!newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.a.getCmd(), this.c.c().i);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j6 = currentTimeMillis2 - currentTimeMillis;
                        j7 = currentTimeMillis2 - e2;
                        try {
                            newInstance.performanceData.a = j8;
                            newInstance.performanceData.l = j10;
                            newInstance.performanceData.k = j11;
                            newInstance.performanceData.b = j9;
                            newInstance.performanceData.c = j12;
                            j4 = j13;
                        } catch (Exception e4) {
                            e = e4;
                            j3 = j9;
                            j5 = j2;
                            j4 = j13;
                        }
                        try {
                            newInstance.performanceData.d = j4;
                            j5 = j2;
                            try {
                                newInstance.performanceData.e = j5;
                                j3 = j9;
                            } catch (Exception e5) {
                                e = e5;
                                j3 = j9;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            j3 = j9;
                            j5 = j2;
                            newInstance.setError(-1003);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f05e4));
                            BdLog.detailException(e);
                            if (this.a.getExtra() instanceof NetMessage) {
                            }
                            String url2 = this.b.getUrl();
                            boolean isSuccess2 = newInstance.isSuccess();
                            dc dcVar2 = newInstance.performanceData;
                            ai.a(str3, cmd, url2, isSuccess2, true, j3, j12, dcVar2.g, j4, j5, dcVar2.i);
                            newInstance.logStatInBackground(this.a.getCmd(), this.c);
                            newInstance.setStartTime(System.currentTimeMillis());
                            publishProgress(newInstance);
                            if (!newInstance.isSuccess()) {
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        j3 = j9;
                        j4 = j13;
                    }
                    try {
                        newInstance.performanceData.f = j;
                        newInstance.performanceData.g = j7;
                        newInstance.setCostTime(j6);
                        newInstance.beforeDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                    } catch (Exception e8) {
                        e = e8;
                        newInstance.setError(-1003);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f05e4));
                        BdLog.detailException(e);
                        if (this.a.getExtra() instanceof NetMessage) {
                        }
                        String url22 = this.b.getUrl();
                        boolean isSuccess22 = newInstance.isSuccess();
                        dc dcVar22 = newInstance.performanceData;
                        ai.a(str3, cmd, url22, isSuccess22, true, j3, j12, dcVar22.g, j4, j5, dcVar22.i);
                        newInstance.logStatInBackground(this.a.getCmd(), this.c);
                        newInstance.setStartTime(System.currentTimeMillis());
                        publishProgress(newInstance);
                        if (!newInstance.isSuccess()) {
                        }
                    }
                } else {
                    j3 = j9;
                    j4 = j13;
                    j5 = j2;
                }
                if (this.a.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.a.getExtra();
                    newInstance.performanceData.i = netMessage.getSocketErrNo();
                    newInstance.performanceData.j = netMessage.getSocketCostTime();
                }
                String url222 = this.b.getUrl();
                boolean isSuccess222 = newInstance.isSuccess();
                dc dcVar222 = newInstance.performanceData;
                ai.a(str3, cmd, url222, isSuccess222, true, j3, j12, dcVar222.g, j4, j5, dcVar222.i);
                newInstance.logStatInBackground(this.a.getCmd(), this.c);
                newInstance.setStartTime(System.currentTimeMillis());
                publishProgress(newInstance);
                try {
                    if (!newInstance.isSuccess()) {
                        newInstance.afterDispatchInBackGround(this.a.getCmd(), this.c.c().i);
                        return null;
                    }
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

    @Override // com.baidu.tieba.oa
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) {
            return i(String.valueOf(i), bdUniqueId);
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.oa
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oa
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
