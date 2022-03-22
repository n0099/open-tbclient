package c.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.d.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes3.dex */
public final class k0 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;

    /* renamed from: b  reason: collision with root package name */
    public final n f23162b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f23163c;

    /* renamed from: d  reason: collision with root package name */
    public final com.fun.o0 f23164d;

    /* renamed from: e  reason: collision with root package name */
    public i f23165e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f23166f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f23167g;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k0 k0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                boolean z = false;
                if (i == 100) {
                    i iVar = (i) message.obj;
                    i iVar2 = this.a.f23165e;
                    if (iVar2 == null || iVar2 != iVar || (funAdLoadListener = iVar.f23177c) == null) {
                        return;
                    }
                    n nVar = iVar.f23178d.f23162b;
                    LogPrinter.e("callback onError(%s) because of timeout(%d)", nVar.a, Long.valueOf(nVar.f23215c));
                    funAdLoadListener.onError(iVar.f23178d.f23162b.a);
                    iVar.a();
                } else if (i == 101) {
                    i iVar3 = (i) message.obj;
                    i iVar4 = this.a.f23165e;
                    if (iVar4 == null || iVar4 != iVar3) {
                        return;
                    }
                    synchronized (iVar3) {
                        synchronized (iVar3) {
                            Iterator<Map.Entry<n.c, Integer>> it = iVar3.a.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else if (it.next().getValue().intValue() == 1) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (z) {
                        iVar3.b(iVar3.f23177c);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.d.b<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.d.h a;

        public b(k0 k0Var, c.d.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, Result] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, Result] */
        @Override // c.d.b
        public Result a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) {
                ?? a = this.a.a(pidLoader);
                if (a == 0 || !this.a.a((c.d.h) a)) {
                    return null;
                }
                return a;
            }
            return invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdInteractionListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k0 f23168b;

        public c(k0 k0Var, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23168b = k0Var;
            this.a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onAdError(this.f23168b.f23162b.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.d.g<n.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f23169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k0 f23170c;

        public d(k0 k0Var, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23170c = k0Var;
            this.a = list;
            this.f23169b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.d.g
        public boolean a(n.b bVar) {
            InterceptResult invokeL;
            List list;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                PidLoader pidLoader = this.f23170c.f23163c.get(bVar.f23219c);
                if (pidLoader == null || (((list = this.a) != null && list.contains(pidLoader)) || (this.f23169b && ((rippedAd = pidLoader.getRippedAd()) == null || !rippedAd.isDeepLinkAd)))) {
                    return false;
                }
                return pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.d.h<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23172c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f23173d;

        public e(k0 k0Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.f23171b = viewGroup;
            this.f23172c = str;
            this.f23173d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.d.h
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f23171b, this.f23172c, this.f23173d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.d.h
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.d.h<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23174b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23175c;

        public f(k0 k0Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.f23174b = viewGroup;
            this.f23175c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.d.h
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f23174b, this.f23175c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.d.h
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.d.b<FunNativeAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public g(k0 k0Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.fun.ad.sdk.FunNativeAd] */
        @Override // c.d.b
        public FunNativeAd a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) ? pidLoader.getNativeAd(this.a, str) : invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.d.b<FunNativeAd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public h(k0 k0Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunNativeAd2, java.lang.Object] */
        @Override // c.d.b
        public FunNativeAd2 a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) ? pidLoader.getNativeAd2(this.a, str) : invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<n.c, Integer> a;

        /* renamed from: b  reason: collision with root package name */
        public long f23176b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f23177c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k0 f23178d;

        public i(k0 k0Var, FunAdLoadListener funAdLoadListener, List<n.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23178d = k0Var;
            this.a = new LinkedHashMap<>();
            this.f23177c = funAdLoadListener;
            for (n.b bVar : list) {
                this.a.put(bVar.f23220d, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23177c = null;
                this.f23178d.f23167g.removeMessages(100, this);
                this.f23178d.f23167g.removeMessages(101, this);
            }
        }

        public final void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f23178d.f23162b.a);
            a();
        }

        public synchronized void c(n.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.f23219c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(bVar.f23220d.a), pid.type, pid.pid);
                    FunAdLoadListener funAdLoadListener = this.f23177c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    n.c cVar = bVar.f23220d;
                    if (this.a.containsKey(cVar)) {
                        this.a.put(cVar, 1);
                        if (this.f23178d.f23162b.f23214b > 0 && System.currentTimeMillis() - this.f23176b < this.f23178d.f23162b.f23214b) {
                            e(funAdLoadListener);
                            return;
                        }
                        b(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void d(n.b bVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, bVar, i, str) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.f23219c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i), str, Integer.valueOf(bVar.f23220d.a), pid.type, pid.pid);
                    if (this.a.containsKey(bVar.f23220d)) {
                        this.a.put(bVar.f23220d, -1);
                        FunAdLoadListener funAdLoadListener = this.f23177c;
                        if (funAdLoadListener == null) {
                            return;
                        }
                        e(funAdLoadListener);
                    }
                }
            }
        }

        public final synchronized void e(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, funAdLoadListener) == null) {
                synchronized (this) {
                    boolean z = true;
                    int i = -1;
                    for (Map.Entry<n.c, Integer> entry : this.a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            n.c key = entry.getKey();
                            if (i < 0) {
                                i = key.a;
                            } else if (i != key.a) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.f23178d.f23162b.a);
                                    b(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.f23178d.f23162b.a);
                        funAdLoadListener.onError(this.f23178d.f23162b.a);
                        a();
                    }
                }
            }
        }
    }

    public k0(n nVar, o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, o0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Random();
        this.f23167g = new a(this, Looper.getMainLooper());
        this.f23162b = nVar;
        this.f23164d = new o0.c(nVar);
        HashMap hashMap = new HashMap();
        for (n.c cVar : nVar.f23217e) {
            for (n.b bVar : cVar.f23221b) {
                PidLoader a2 = o0Var.a(bVar.f23219c);
                if (a2 != null) {
                    a2.addListener(new j(this, bVar, a2));
                    hashMap.put(bVar.f23219c, a2);
                }
            }
        }
        this.f23163c = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(n.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            return this.f23163c.get(bVar.f23219c);
        }
        return (PidLoader) invokeL.objValue;
    }

    public final PidLoader b(boolean z, n.c cVar, List<PidLoader> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), cVar, list})) == null) {
            n.b bVar = (n.b) c.d.f.a(this.a, cVar.f23221b, new d(this, list, z));
            if (bVar == null) {
                return null;
            }
            return this.f23163c.get(bVar.f23219c);
        }
        return (PidLoader) invokeCommon.objValue;
    }

    public final <N> N c(c.d.b<N> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            for (n.c cVar : this.f23162b.f23217e) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader b2 = b(z, cVar, arrayList);
                    if (b2 != null) {
                        N a2 = bVar.a(b2, this.f23162b.a);
                        if (a2 != null) {
                            return a2;
                        }
                        arrayList.add(b2);
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    public final <Result> Result d(FunAdInteractionListener funAdInteractionListener, c.d.h<Result> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, funAdInteractionListener, hVar)) == null) {
            this.f23166f = funAdInteractionListener;
            this.f23164d.e();
            Result result = (Result) c(new b(this, hVar));
            if (result == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f23162b.a);
                this.f23167g.post(new c(this, funAdInteractionListener));
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f23167g.removeMessages(100);
                this.f23166f = null;
                i iVar = this.f23165e;
                if (iVar != null) {
                    iVar.a();
                    this.f23165e = null;
                }
                for (PidLoader pidLoader : this.f23163c.values()) {
                    pidLoader.destroy();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (n.c cVar : this.f23162b.f23217e) {
                    for (n.b bVar : cVar.f23221b) {
                        if (bVar != null && (a2 = a(bVar)) != null && a2.isLoaded()) {
                            arrayList.add(new CacheStatistic(a2.getAdType(), a2.getPid().pid, a2.getAdCount(), a2.getPid().basePrice));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd getNativeAd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            FunNativeAd funNativeAd = (FunNativeAd) c(new g(this, context));
            if (funNativeAd == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f23162b.a);
            }
            return funNativeAd;
        }
        return (FunNativeAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) c(new h(this, context));
            if (funNativeAd2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f23162b.a);
            }
            return funNativeAd2;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (PidLoader pidLoader : this.f23163c.values()) {
                if (pidLoader.isLoaded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e1 A[Catch: all -> 0x011f, TryCatch #0 {, blocks: (B:6:0x0007, B:18:0x004c, B:21:0x0054, B:23:0x007c, B:24:0x008d, B:25:0x0099, B:27:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00b5, B:34:0x00c7, B:36:0x00cd, B:38:0x00d3, B:39:0x00db, B:41:0x00e1, B:44:0x00ea, B:47:0x00f1, B:49:0x00f7, B:51:0x00fd, B:55:0x0107, B:9:0x0020, B:10:0x002b, B:12:0x0031, B:14:0x0043, B:58:0x0119, B:59:0x011e), top: B:66:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd A[Catch: all -> 0x011f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:18:0x004c, B:21:0x0054, B:23:0x007c, B:24:0x008d, B:25:0x0099, B:27:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00b5, B:34:0x00c7, B:36:0x00cd, B:38:0x00d3, B:39:0x00db, B:41:0x00e1, B:44:0x00ea, B:47:0x00f1, B:49:0x00f7, B:51:0x00fd, B:55:0x0107, B:9:0x0020, B:10:0x002b, B:12:0x0031, B:14:0x0043, B:58:0x0119, B:59:0x011e), top: B:66:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb A[EDGE_INSN: B:72:0x00fb->B:50:0x00fb ?: BREAK  , SYNTHETIC] */
    @Override // com.fun.ad.sdk.FunAdLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        Iterator<n.b> it;
        PidLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.f23164d.d();
                this.f23167g.removeMessages(101);
                this.f23167g.removeMessages(100);
                n nVar = this.f23162b;
                ArrayList arrayList = null;
                if (nVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (n.c cVar : nVar.f23217e) {
                        n.b bVar = (n.b) c.d.f.a(this.a, cVar.f23221b, null);
                        if (bVar != null) {
                            arrayList2.add(bVar);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    i iVar = new i(this, funAdLoadListener, arrayList);
                    this.f23165e = iVar;
                    iVar.f23176b = System.currentTimeMillis();
                    Message obtainMessage = this.f23167g.obtainMessage(100);
                    obtainMessage.obj = iVar;
                    this.f23167g.sendMessageDelayed(obtainMessage, this.f23162b.f23215c);
                    if (this.f23162b.f23214b > 0) {
                        Message obtainMessage2 = this.f23167g.obtainMessage(101);
                        obtainMessage2.obj = iVar;
                        this.f23167g.sendMessageDelayed(obtainMessage2, this.f23162b.f23214b);
                    }
                    LogPrinter.d("Start load for sid:%s", nVar.a);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        n.b bVar2 = (n.b) arrayList.get(i2);
                        PidLoader a3 = a(bVar2);
                        if (a3 != null) {
                            if (a3.isLoaded()) {
                                iVar.c(bVar2);
                            } else {
                                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(a3.getPid().pid, a3.getAdType());
                                if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                    a3.load(context, funAdSlot);
                                    z = false;
                                    it = bVar2.f23220d.f23221b.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        n.b next = it.next();
                                        if (next != bVar2 && (a2 = a(next)) != null && a2.isLoaded()) {
                                            iVar.c(next);
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        iVar.d(bVar2, 0, "F1:No ready loader found");
                                    }
                                }
                            }
                        }
                        z = true;
                        it = bVar2.f23220d.f23221b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                            }
                        }
                        if (!z) {
                        }
                    }
                    return;
                }
                LogPrinter.e("No selected adIds found for sid:%s", nVar.a);
                funAdLoadListener.onError(nVar.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f23166f = null;
            i iVar = this.f23165e;
            if (iVar != null) {
                iVar.a();
            }
            this.f23165e = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048587, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) d(funAdInteractionListener, new e(this, activity, t, str, funNativeAdInflater));
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) d(funAdInteractionListener, new f(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes3.dex */
    public class j implements n0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ boolean f23179d;
        public transient /* synthetic */ FieldHolder $fh;
        public final n.b a;

        /* renamed from: b  reason: collision with root package name */
        public final PidLoader f23180b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k0 f23181c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-289873139, "Lc/d/k0$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-289873139, "Lc/d/k0$j;");
                    return;
                }
            }
            f23179d = !k0.class.desiredAssertionStatus();
        }

        public j(k0 k0Var, n.b bVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, bVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f23181c = k0Var;
            this.a = bVar;
            this.f23180b = pidLoader;
        }

        @Override // c.d.n0
        public void a() {
            k0 k0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (k0Var = this.f23181c).f23166f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(k0Var.f23162b.a);
        }

        @Override // c.d.n0
        public void b(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048581, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.f23181c.f23166f) == null) {
                return;
            }
            if (!f23179d && this.a.f23219c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.f23219c.pid, this.f23180b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdClick(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.f23181c.f23162b.a;
            Ssp.Pid pid = this.a.f23219c;
            callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, strArr);
        }

        @Override // c.d.n0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // c.d.n0
        public void c(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.f23181c.f23166f) == null) {
                return;
            }
            if (!f23179d && this.a.f23219c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.f23219c.pid, this.f23180b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdShow(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.f23181c.f23162b.a;
            Ssp.Pid pid = this.a.f23219c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd, strArr);
        }

        @Override // c.d.n0
        public void a(int i, String str) {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (iVar = this.f23181c.f23165e) == null) {
                return;
            }
            iVar.d(this.a, i, str);
        }

        @Override // c.d.n0
        public void a(boolean z, String... strArr) {
            k0 k0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, strArr) == null) || (funAdInteractionListener = (k0Var = this.f23181c).f23166f) == null) {
                return;
            }
            Flavors.CALL_BACK_AWARE.onRewardedVideo(funAdInteractionListener, k0Var.f23162b.a, z, strArr);
        }

        @Override // c.d.n0
        public void b(int i, String str) {
            k0 k0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (funAdInteractionListener = (k0Var = this.f23181c).f23166f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(k0Var.f23162b.a);
        }

        @Override // c.d.n0
        public void b() {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iVar = this.f23181c.f23165e) == null) {
                return;
            }
            iVar.c(this.a);
        }
    }
}
