package c.a.u0.s0.g;

import c.a.d.c.f.d;
import c.a.u0.s0.c;
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
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f21815b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f21816c;

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
        this.f21816c = new Gson();
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.contains("?")) {
                str = str.split("[?]")[0];
            }
            String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
            HashMap<String, String> hashMap = this.f21815b;
            if (hashMap != null) {
                return hashMap.get(replace);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void c(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.f21815b = hashMap;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // c.a.d.c.f.f
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        process2(httpMessage2, httpMessageTask);
        return httpMessage2;
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public HttpMessage process2(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        String json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, httpMessage, httpMessageTask)) == null) {
            String a = a(httpMessageTask.getUrl());
            if (a != null && this.a != null) {
                if (httpMessage.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                    json = netMessage.getSocketMessage() != null ? this.f21816c.toJson(netMessage.getSocketMessage().getData()) : "";
                } else {
                    json = this.f21816c.toJson(httpMessage.getParams());
                }
                this.a.a(httpMessageTask.getUrl(), this.f21816c.toJson(a), this.f21816c.toJson(json));
            }
            return httpMessage;
        }
        return (HttpMessage) invokeLL.objValue;
    }
}
