package c.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.g.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.IRipperCallBack;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes9.dex */
public final class y0 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28499b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f28500c;

    /* renamed from: d  reason: collision with root package name */
    public final com.fun.x0 f28501d;

    /* renamed from: e  reason: collision with root package name */
    public final h f28502e;

    /* renamed from: f  reason: collision with root package name */
    public f f28503f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f28504g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f28505h;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y0 y0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                boolean z = false;
                if (i2 == 100) {
                    f fVar = (f) message.obj;
                    f fVar2 = this.a.f28503f;
                    if (fVar2 == null || fVar2 != fVar || (funAdLoadListener = fVar.f28514c) == null) {
                        return;
                    }
                    l lVar = fVar.f28515d.f28499b;
                    LogPrinter.e("callback onError(%s) because of timeout(%d)", lVar.a, Long.valueOf(lVar.f28450c));
                    funAdLoadListener.onError(fVar.f28515d.f28499b.a);
                    fVar.a();
                } else if (i2 == 101) {
                    f fVar3 = (f) message.obj;
                    f fVar4 = this.a.f28503f;
                    if (fVar4 == null || fVar4 != fVar3) {
                        return;
                    }
                    synchronized (fVar3) {
                        synchronized (fVar3) {
                            Iterator<Map.Entry<l.b, Integer>> it = fVar3.a.entrySet().iterator();
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
                        fVar3.b(fVar3.f28514c);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f28506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ y0 f28507f;

        public b(y0 y0Var, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28507f = y0Var;
            this.f28506e = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28506e.onAdError(this.f28507f.f28499b.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements t<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28508b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28509c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f28510d;

        public c(y0 y0Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.f28508b = viewGroup;
            this.f28509c = str;
            this.f28510d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.g.t
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f28508b, this.f28509c, this.f28510d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.g.t
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements t<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28511b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28512c;

        public d(y0 y0Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.f28511b = viewGroup;
            this.f28512c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.g.t
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f28511b, this.f28512c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.g.t
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y0 a;

        public e(y0 y0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y0Var;
        }

        public /* synthetic */ e(y0 y0Var, a aVar) {
            this(y0Var);
        }

        public PidLoader a(boolean z, List<PidLoader> list) {
            InterceptResult invokeZL;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (l.b bVar : this.a.f28499b.f28452e) {
                    for (l.a aVar : bVar.f28456b) {
                        PidLoader a = this.a.a(aVar);
                        if (a != null && !list.contains(a) && a.isLoaded() && (!z || ((rippedAd = a.getRippedAd()) != null && rippedAd.isDeepLinkAd))) {
                            List list2 = (List) hashMap.get(bVar);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                hashMap.put(bVar, list2);
                            }
                            list2.add(aVar);
                        }
                    }
                }
                return this.a.a((l.a) c.g.d.a(this.a.a, (List) hashMap.get((l.b) c.g.d.a(this.a.a, new ArrayList(hashMap.keySet()), null)), null));
            }
            return (PidLoader) invokeZL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<l.b, Integer> a;

        /* renamed from: b  reason: collision with root package name */
        public long f28513b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f28514c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ y0 f28515d;

        public f(y0 y0Var, FunAdLoadListener funAdLoadListener, List<l.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28515d = y0Var;
            this.a = new LinkedHashMap<>();
            this.f28514c = funAdLoadListener;
            for (l.a aVar : list) {
                this.a.put(aVar.f28455d, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28514c = null;
                this.f28515d.f28505h.removeMessages(100, this);
                this.f28515d.f28505h.removeMessages(101, this);
            }
        }

        public final void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f28515d.f28499b.a);
            a();
        }

        public synchronized void c(l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = aVar.f28454c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f28455d.a), pid.type, pid.pid);
                    FunAdLoadListener funAdLoadListener = this.f28514c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    l.b bVar = aVar.f28455d;
                    if (this.a.containsKey(bVar)) {
                        this.a.put(bVar, 1);
                        if (this.f28515d.f28499b.f28449b > 0 && System.currentTimeMillis() - this.f28513b < this.f28515d.f28499b.f28449b) {
                            e(funAdLoadListener);
                            return;
                        }
                        b(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void d(l.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, aVar, i2, str) == null) {
                synchronized (this) {
                    Ssp.Pid pid = aVar.f28454c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f28455d.a), pid.type, pid.pid);
                    if (this.a.containsKey(aVar.f28455d)) {
                        this.a.put(aVar.f28455d, -1);
                        FunAdLoadListener funAdLoadListener = this.f28514c;
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
                    int i2 = -1;
                    for (Map.Entry<l.b, Integer> entry : this.a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            l.b key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.a;
                            } else if (i2 != key.a) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.f28515d.f28499b.a);
                                    b(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.f28515d.f28499b.a);
                        funAdLoadListener.onError(this.f28515d.f28499b.a);
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface h {
    }

    public y0(l lVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, kVar};
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
        this.f28502e = new e(this, null);
        this.f28505h = new a(this, Looper.getMainLooper());
        this.f28499b = lVar;
        this.f28501d = new x0.c(lVar);
        HashMap hashMap = new HashMap();
        for (l.b bVar : lVar.f28452e) {
            for (l.a aVar : bVar.f28456b) {
                PidLoader a2 = kVar.a(aVar.f28454c);
                if (a2 != null) {
                    a2.addListener(new g(this, aVar));
                    hashMap.put(aVar.f28454c, a2);
                }
            }
        }
        this.f28500c = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f28500c.get(aVar.f28454c);
        }
        return (PidLoader) invokeL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, IRipperCallBack iRipperCallBack, t<Result> tVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, iRipperCallBack, tVar)) != null) {
            return (Result) invokeLLL.objValue;
        }
        this.f28504g = funAdInteractionListener;
        com.fun.x0 x0Var = this.f28501d;
        if (iRipperCallBack == null) {
            x0Var.e();
        } else {
            x0Var.f();
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            PidLoader a2 = ((e) this.f28502e).a(z, arrayList);
            Result result = null;
            if (a2 == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f28499b.a);
                this.f28505h.post(new b(this, funAdInteractionListener));
                return null;
            }
            if (iRipperCallBack == null || iRipperCallBack.accept(a2.getRippedAd())) {
                result = tVar.a(a2);
            }
            if (result != null && tVar.a((t<Result>) result)) {
                return result;
            }
            arrayList.add(a2);
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f28505h.removeMessages(100);
                this.f28504g = null;
                f fVar = this.f28503f;
                if (fVar != null) {
                    fVar.a();
                    this.f28503f = null;
                }
                for (PidLoader pidLoader : this.f28500c.values()) {
                    pidLoader.destroy();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd getNativeAd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, context)) != null) {
            return (FunNativeAd) invokeL.objValue;
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            PidLoader a2 = ((e) this.f28502e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f28499b.a);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f28499b.a);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, context)) != null) {
            return (FunNativeAd2) invokeL.objValue;
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            PidLoader a2 = ((e) this.f28502e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f28499b.a);
                return null;
            }
            FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.f28499b.a);
            if (nativeAd2 != null) {
                return nativeAd2;
            }
            arrayList.add(a2);
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (PidLoader pidLoader : this.f28500c.values()) {
                if (pidLoader.isLoaded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        PidLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.f28501d.d();
                this.f28505h.removeMessages(101);
                this.f28505h.removeMessages(100);
                l lVar = this.f28499b;
                ArrayList arrayList = null;
                if (lVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (l.b bVar : lVar.f28452e) {
                        l.a aVar = (l.a) c.g.d.a(this.a, bVar.f28456b, null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new c.g.b(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    f fVar = new f(this, funAdLoadListener, arrayList);
                    this.f28503f = fVar;
                    fVar.f28513b = System.currentTimeMillis();
                    Message obtainMessage = this.f28505h.obtainMessage(100);
                    obtainMessage.obj = fVar;
                    this.f28505h.sendMessageDelayed(obtainMessage, this.f28499b.f28450c);
                    if (this.f28499b.f28449b > 0) {
                        Message obtainMessage2 = this.f28505h.obtainMessage(101);
                        obtainMessage2.obj = fVar;
                        this.f28505h.sendMessageDelayed(obtainMessage2, this.f28499b.f28449b);
                    }
                    LogPrinter.d("Start load for sid:%s", lVar.a);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        l.a aVar2 = (l.a) arrayList.get(i2);
                        PidLoader a3 = a(aVar2);
                        if (a3 == null) {
                            z = true;
                        } else if (a3.isLoaded()) {
                            fVar.c(aVar2);
                        } else {
                            a3.load(context, funAdSlot);
                            z = false;
                        }
                        Iterator<l.a> it = aVar2.f28455d.f28456b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            l.a next = it.next();
                            if (next != aVar2 && (a2 = a(next)) != null && a2.isLoaded()) {
                                fVar.c(next);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            fVar.d(aVar2, 0, "F1:No ready loader found");
                        }
                    }
                    return;
                }
                LogPrinter.e("No selected adIds found for sid:%s", lVar.a);
                funAdLoadListener.onError(lVar.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28504g = null;
            f fVar = this.f28503f;
            if (fVar != null) {
                fVar.a();
            }
            this.f28503f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater, IRipperCallBack iRipperCallBack) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, t, str, funAdInteractionListener, funNativeAdInflater, iRipperCallBack})) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, iRipperCallBack, new c(this, activity, t, str, funNativeAdInflater));
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, null, new d(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes9.dex */
    public class g implements i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28516c;
        public transient /* synthetic */ FieldHolder $fh;
        public final l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y0 f28517b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1909400191, "Lc/g/y0$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1909400191, "Lc/g/y0$g;");
                    return;
                }
            }
            f28516c = !y0.class.desiredAssertionStatus();
        }

        public g(y0 y0Var, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0Var, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28517b = y0Var;
            this.a = aVar;
        }

        @Override // c.g.i
        public void a(RippedAd rippedAd) {
            y0 y0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (y0Var = this.f28517b).f28504g) == null) {
                return;
            }
            if (!f28516c && this.a.f28454c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = y0Var.f28499b.a;
            Ssp.Pid pid = this.a.f28454c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // c.g.i
        public void b() {
            y0 y0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (y0Var = this.f28517b).f28504g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(y0Var.f28499b.a);
        }

        @Override // c.g.i
        public void c() {
            y0 y0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (y0Var = this.f28517b).f28504g) == null) {
                return;
            }
            if (!f28516c && this.a.f28454c == null) {
                throw new AssertionError();
            }
            String str = y0Var.f28499b.a;
            Ssp.Pid pid = this.a.f28454c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // c.g.i
        public void d() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fVar = this.f28517b.f28503f) == null) {
                return;
            }
            fVar.c(this.a);
        }

        @Override // c.g.i
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // c.g.i
        public void b(int i2, String str) {
            y0 y0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (y0Var = this.f28517b).f28504g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(y0Var.f28499b.a);
        }

        @Override // c.g.i
        public void a(int i2, String str) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (fVar = this.f28517b.f28503f) == null) {
                return;
            }
            fVar.d(this.a, i2, str);
        }

        @Override // c.g.i
        public void a() {
            y0 y0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (y0Var = this.f28517b).f28504g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(y0Var.f28499b.a);
        }
    }
}
