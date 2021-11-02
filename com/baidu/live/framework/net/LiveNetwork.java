package com.baidu.live.framework.net;

import android.os.Handler;
import b.a.w.e.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000:\u00016B\u0007¢\u0006\u0004\b5\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0003J\u0015\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\u00020\u00012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\"\u001a\u00020\u00012&\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001` ¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b$\u0010\u001bJ\u0015\u0010&\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0018¢\u0006\u0004\b&\u0010\u001bJ\u0015\u0010(\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)R\u001d\u0010/\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u00102\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00104¨\u00067"}, d2 = {"Lcom/baidu/live/framework/net/LiveNetwork;", "", QueryResponse.Options.CANCEL, "()V", "", "key", "", "localPath", "Lcom/baidu/live/framework/net/LiveNetDownloadCallback;", "callback", "download", "(Ljava/lang/Object;Ljava/lang/String;Lcom/baidu/live/framework/net/LiveNetDownloadCallback;)V", "downloadSync", "ResponseDataT", "", "params", "Lcom/baidu/live/framework/net/LiveNetCallback;", "get", "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;)V", "", "grFeedList", "post", "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;Ljava/util/List;)V", "release", "", "timeout", "setConnectTimeout", "(I)V", "extra", "setExtra", "(Ljava/util/Map;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "setHeaderData", "(Ljava/util/HashMap;)V", "setReadTimeout", "retryCount", "setRetryCount", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "kotlin.jvm.PlatformType", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class LiveNetwork {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f38871a;

    /* renamed from: b  reason: collision with root package name */
    public String f38872b;

    /* renamed from: c  reason: collision with root package name */
    public INetWork f38873c;

    /* loaded from: classes7.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final NetResponse f38874a;

        /* renamed from: b  reason: collision with root package name */
        public final T f38875b;

        public a(NetResponse response, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {response, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(response, "response");
            this.f38874a = response;
            this.f38875b = t;
        }

        public final T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38875b : (T) invokeV.objValue;
        }

        public final NetResponse b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38874a : (NetResponse) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        return Intrinsics.areEqual(this.f38874a, aVar.f38874a) && Intrinsics.areEqual(this.f38875b, aVar.f38875b);
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
                NetResponse netResponse = this.f38874a;
                int hashCode = (netResponse != null ? netResponse.hashCode() : 0) * 31;
                T t = this.f38875b;
                return hashCode + (t != null ? t.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Response(response=" + this.f38874a + ", data=" + this.f38875b + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveNetwork f38876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f38877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.w.e.d.a f38878g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ List f38879h;

        /* loaded from: classes7.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f38880e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f38881f;

            public a(b bVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38880e = bVar;
                this.f38881f = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.a.w.e.d.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f38880e.f38878g) == null) {
                    return;
                }
                a aVar2 = this.f38881f;
                NetResponse b2 = aVar2 != null ? aVar2.b() : null;
                a aVar3 = this.f38881f;
                Object a2 = aVar3 != null ? aVar3.a() : null;
                b bVar = this.f38880e;
                aVar.a(b2, a2, bVar.f38877f, bVar.f38879h);
            }
        }

        public b(LiveNetwork liveNetwork, Map map, b.a.w.e.d.a aVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveNetwork, map, aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38876e = liveNetwork;
            this.f38877f = map;
            this.f38878g = aVar;
            this.f38879h = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                INetWork iNetWork = this.f38876e.f38873c;
                Intrinsics.checkNotNull(iNetWork);
                NetResponse res = iNetWork.postSync(this.f38877f);
                Object obj = null;
                try {
                    b.a.w.e.d.a aVar = this.f38878g;
                    if (aVar != null) {
                        obj = aVar.onParseResponseInBackground(res);
                    }
                } catch (Exception e2) {
                    b.a.w.e.g.a.a(e2);
                }
                Intrinsics.checkNotNullExpressionValue(res, "res");
                this.f38876e.c().post(new a(this, new a(res, obj)));
            }
        }
    }

    public LiveNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38871a = LazyKt__LazyJVMKt.lazy(LiveNetwork$mainHandler$2.INSTANCE);
        this.f38873c = c.a();
    }

    public final Handler c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (Handler) this.f38871a.getValue() : (Handler) invokeV.objValue;
    }

    public final <ResponseDataT> void d(Map<String, String> params, b.a.w.e.d.a<ResponseDataT> aVar, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params, aVar, list) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            String str = this.f38872b;
            if (str == null || !(!StringsKt__StringsJVMKt.isBlank(str)) || this.f38873c == null) {
                return;
            }
            b.a.w.e.f.a.b(new b(this, params, aVar, list), "live-feedpage-net", 0);
        }
    }

    public final void e(Map<String, ? extends Object> map) {
        INetWork iNetWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) || (iNetWork = this.f38873c) == null) {
            return;
        }
        iNetWork.setExtra(map);
    }

    public final void f(String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, url) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f38872b = url;
            INetWork iNetWork = this.f38873c;
            if (iNetWork != null) {
                iNetWork.setUrl(url);
            }
        }
    }
}
