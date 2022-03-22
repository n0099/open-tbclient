package c.a.p0.t0.g;

import android.util.SparseArray;
import c.a.d.c.f.k;
import c.a.d.f.p.m;
import c.a.p0.t0.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f18577b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f18578c;

    /* renamed from: d  reason: collision with root package name */
    public Gson f18579d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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
        this.f18579d = new Gson();
        a();
    }

    public final void a() {
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18577b = new SparseArray<>();
            ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
            if (ListUtils.isEmpty(findHttpTasks)) {
                return;
            }
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!m.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!m.isEmpty(str) && str.contains("=") && (e2 = c.a.d.f.m.b.e(str.split("[=]")[1], 0)) != 0) {
                        this.f18577b.put(e2, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
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
            this.f18578c = hashMap;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // c.a.d.c.f.f
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        process2(socketMessage2, socketMessageTask);
        return socketMessage2;
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public SocketMessage process2(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, socketMessage, socketMessageTask)) == null) {
            String str = this.f18577b.get(socketMessage.getCmd());
            if (str != null && (hashMap = this.f18578c) != null && hashMap.get(str) != null && this.a != null) {
                this.a.a(str, this.f18579d.toJson(this.f18578c.get(str)), this.f18579d.toJson(this.f18579d.toJson(socketMessage.getData())));
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }
}
