package com.baidu.live.framework.net;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.jb0;
import com.baidu.tieba.lb0;
import com.baidu.tieba.nb0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJI\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0003J#\u0010\u0013\u001a\u00020\u00012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010&¨\u0006)"}, d2 = {"Lcom/baidu/live/framework/net/LiveNetwork;", "", "cancel", "()V", "ResponseDataT", "", "", "params", "Lcom/baidu/live/framework/net/LiveNetCallback;", WebChromeClient.KEY_ARG_CALLBACK, "get", "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;)V", "", "grFeedList", "post", "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;Ljava/util/List;)V", "release", "", "extra", "setExtra", "(Ljava/util/Map;)V", "", "retryCount", "setRetryCount", "(I)V", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "kotlin.jvm.PlatformType", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNetwork {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public String b;
    public INetWork c;

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
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveNetwork a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ jb0 c;
        public final /* synthetic */ List d;

        /* loaded from: classes2.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ a b;

            public a(b bVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                jb0 jb0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jb0Var = this.a.c) == null) {
                    return;
                }
                a aVar = this.b;
                NetResponse b = aVar != null ? aVar.b() : null;
                a aVar2 = this.b;
                Object a = aVar2 != null ? aVar2.a() : null;
                b bVar = this.a;
                jb0Var.onNetResponse(b, a, bVar.b, bVar.d);
            }
        }

        public b(LiveNetwork liveNetwork, Map map, jb0 jb0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveNetwork, map, jb0Var, list};
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
            this.c = jb0Var;
            this.d = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                INetWork iNetWork = this.a.c;
                if (iNetWork == null) {
                    Intrinsics.throwNpe();
                }
                NetResponse res = iNetWork.postSync(this.b);
                Object obj = null;
                try {
                    jb0 jb0Var = this.c;
                    if (jb0Var != null) {
                        obj = jb0Var.onParseResponseInBackground(res);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intrinsics.checkExpressionValueIsNotNull(res, "res");
                this.a.c().post(new a(this, new a(res, obj)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132013487, "Lcom/baidu/live/framework/net/LiveNetwork;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132013487, "Lcom/baidu/live/framework/net/LiveNetwork;");
                return;
            }
        }
        d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveNetwork.class), "mainHandler", "getMainHandler()Landroid/os/Handler;"))};
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
        this.a = LazyKt__LazyJVMKt.lazy(LiveNetwork$mainHandler$2.INSTANCE);
        this.c = lb0.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.live.framework.net.LiveNetwork */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(LiveNetwork liveNetwork, Map map, jb0 jb0Var, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        liveNetwork.d(map, jb0Var, list);
    }

    public final Handler c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Lazy lazy = this.a;
            KProperty kProperty = d[0];
            return (Handler) lazy.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    public final <ResponseDataT> void d(Map<String, String> map, jb0<ResponseDataT> jb0Var, List<String> list) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, jb0Var, list) == null) || (str = this.b) == null || !(!StringsKt__StringsJVMKt.isBlank(str)) || this.c == null) {
            return;
        }
        nb0.b(new b(this, map, jb0Var, list), "live-feedpage-net", 0);
    }

    public final void f(Map<String, ? extends Object> map) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) || (iNetWork = this.c) == null) {
            return;
        }
        iNetWork.setExtra(map);
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = str;
            INetWork iNetWork = this.c;
            if (iNetWork != null) {
                iNetWork.setUrl(str);
            }
        }
    }
}
