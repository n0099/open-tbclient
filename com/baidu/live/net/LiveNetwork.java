package com.baidu.live.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.jc0;
import com.baidu.tieba.kc0;
import com.baidu.tieba.lc0;
import com.baidu.tieba.mc0;
import com.baidu.tieba.vc0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001f\u001a\u00020\u00012&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\u0018J\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010\u0018J\u0015\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00100¨\u00063"}, d2 = {"Lcom/baidu/live/net/LiveNetwork;", "", "cancel", "()V", "", "key", "", "localPath", "Lcom/baidu/live/net/LiveNetDownloadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "download", "(Ljava/lang/Object;Ljava/lang/String;Lcom/baidu/live/net/LiveNetDownloadCallback;)V", "downloadSync", "ResponseDataT", "", "params", "Lcom/baidu/live/net/LiveNetCallback;", "get", "(Ljava/util/Map;Lcom/baidu/live/net/LiveNetCallback;)V", "post", "release", "", "timeout", "setConnectTimeout", "(I)V", "extra", "setExtra", "(Ljava/util/Map;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "setHeaderData", "(Ljava/util/HashMap;)V", "setReadTimeout", "retryCount", "setRetryCount", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-net_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNetwork {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public INetWork b;

    /* loaded from: classes2.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NetResponse a;
        public final T b;

        public a(NetResponse netResponse, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netResponse, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = netResponse;
            this.b = t;
        }

        public final T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
        }

        public final NetResponse b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (NetResponse) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                NetResponse netResponse = this.a;
                int hashCode = (netResponse != null ? netResponse.hashCode() : 0) * 31;
                T t = this.b;
                return hashCode + (t != null ? t.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Response(response=" + this.a + ", data=" + this.b + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements lc0<a<ResponseDataT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveNetwork a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ jc0 c;

        public b(LiveNetwork liveNetwork, Map map, jc0 jc0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveNetwork, map, jc0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveNetwork;
            this.b = map;
            this.c = jc0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lc0
        /* renamed from: b */
        public final a<ResponseDataT> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                INetWork iNetWork = this.a.b;
                if (iNetWork == null) {
                    Intrinsics.throwNpe();
                }
                NetResponse res = iNetWork.postSync(this.b);
                Object obj = null;
                try {
                    jc0 jc0Var = this.c;
                    if (jc0Var != null) {
                        obj = jc0Var.onParseResponseInBackground(res);
                    }
                } catch (Exception e) {
                    vc0.e(e);
                }
                Intrinsics.checkExpressionValueIsNotNull(res, "res");
                return new a<>(res, obj);
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements mc0<a<ResponseDataT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc0 a;

        public c(jc0 jc0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.jc0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.mc0
        /* renamed from: a */
        public final void onReturnDataInUI(a<ResponseDataT> aVar) {
            jc0 jc0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (jc0Var = this.a) == 0) {
                return;
            }
            jc0Var.onNetResponse(aVar != 0 ? aVar.b() : null, aVar != 0 ? aVar.a() : null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1210323104, "Lcom/baidu/live/net/LiveNetwork;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1210323104, "Lcom/baidu/live/net/LiveNetwork;");
                return;
            }
        }
        Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveNetwork.class), "handler", "getHandler()Landroid/os/Handler;"));
    }

    public LiveNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        LazyKt__LazyJVMKt.lazy(LiveNetwork$handler$2.INSTANCE);
        NetworkAgentService networkAgentService = (NetworkAgentService) ServiceManager.getService(NetworkAgentService.SERVICE_REFERENCE);
        this.b = networkAgentService != null ? networkAgentService.buildNetworkInstance() : null;
    }

    public final <ResponseDataT> void b(Map<String, ? extends Object> map, jc0<ResponseDataT> jc0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, map, jc0Var) == null) || (str = this.a) == null || !(!StringsKt__StringsJVMKt.isBlank(str)) || this.b == null) {
            return;
        }
        kc0.a(new b(this, map, jc0Var), new c(jc0Var));
    }

    public final void c(Map<String, ? extends Object> map) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || (iNetWork = this.b) == null) {
            return;
        }
        iNetWork.setExtra(map);
    }

    public final void d(int i) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (iNetWork = this.b) == null) {
            return;
        }
        iNetWork.setRetryCount(i);
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
            INetWork iNetWork = this.b;
            if (iNetWork != null) {
                iNetWork.setUrl(str);
            }
        }
    }
}
