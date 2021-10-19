package c.a.r0.l0.g;

import c.a.e.c.f.d;
import c.a.r0.l0.c;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f21376a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f21377b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f21378c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
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
        this.f21378c = new Gson();
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.contains("?")) {
                str = str.split("[?]")[0];
            }
            String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
            HashMap<String, String> hashMap = this.f21377b;
            if (hashMap != null) {
                return hashMap.get(replace);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        String json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessage, httpMessageTask)) == null) {
            String a2 = a(httpMessageTask.getUrl());
            if (a2 != null && this.f21376a != null) {
                if (httpMessage.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                    json = netMessage.getSocketMessage() != null ? this.f21378c.toJson(netMessage.getSocketMessage().getData()) : "";
                } else {
                    json = this.f21378c.toJson(httpMessage.getParams());
                }
                this.f21376a.a(httpMessageTask.getUrl(), this.f21378c.toJson(a2), this.f21378c.toJson(json));
            }
            return httpMessage;
        }
        return (HttpMessage) invokeLL.objValue;
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f21376a = cVar;
        }
    }

    public void d(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            this.f21377b = hashMap;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // c.a.e.c.f.f
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        b(httpMessage2, httpMessageTask);
        return httpMessage2;
    }
}
