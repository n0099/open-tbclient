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
import com.fun.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes7.dex */
public final class u0 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28916b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f28917c;

    /* renamed from: d  reason: collision with root package name */
    public final com.fun.u0 f28918d;

    /* renamed from: e  reason: collision with root package name */
    public final h f28919e;

    /* renamed from: f  reason: collision with root package name */
    public f f28920f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f28921g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f28922h;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u0 u0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, looper};
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
            this.a = u0Var;
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
                    f fVar2 = this.a.f28920f;
                    if (fVar2 == null || fVar2 != fVar || (funAdLoadListener = fVar.f28931c) == null) {
                        return;
                    }
                    l lVar = fVar.f28932d.f28916b;
                    LogPrinter.e("callback onError(%s) because of timeout(%d)", lVar.a, Long.valueOf(lVar.f28886c));
                    funAdLoadListener.onError(fVar.f28932d.f28916b.a);
                    fVar.a();
                } else if (i2 == 101) {
                    f fVar3 = (f) message.obj;
                    f fVar4 = this.a.f28920f;
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
                        fVar3.b(fVar3.f28931c);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f28923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f28924f;

        public b(u0 u0Var, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28924f = u0Var;
            this.f28923e = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28923e.onAdError(this.f28924f.f28916b.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28926c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f28927d;

        public c(u0 u0Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, activity, viewGroup, str, funNativeAdInflater};
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
            this.f28925b = viewGroup;
            this.f28926c = str;
            this.f28927d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.g.q
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f28925b, this.f28926c, this.f28927d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.g.q
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements q<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28929c;

        public d(u0 u0Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, activity, viewGroup, str};
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
            this.f28928b = viewGroup;
            this.f28929c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.g.q
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f28928b, this.f28929c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.g.q
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public e(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        public /* synthetic */ e(u0 u0Var, a aVar) {
            this(u0Var);
        }

        public PidLoader a(boolean z, List<PidLoader> list) {
            InterceptResult invokeZL;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (l.b bVar : this.a.f28916b.f28888e) {
                    for (l.a aVar : bVar.f28892b) {
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

    /* loaded from: classes7.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<l.b, Integer> a;

        /* renamed from: b  reason: collision with root package name */
        public long f28930b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f28931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ u0 f28932d;

        public f(u0 u0Var, FunAdLoadListener funAdLoadListener, List<l.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28932d = u0Var;
            this.a = new LinkedHashMap<>();
            this.f28931c = funAdLoadListener;
            for (l.a aVar : list) {
                this.a.put(aVar.f28891d, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28931c = null;
                this.f28932d.f28922h.removeMessages(100, this);
                this.f28932d.f28922h.removeMessages(101, this);
            }
        }

        public final void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f28932d.f28916b.a);
            a();
        }

        public synchronized void c(l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = aVar.f28890c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f28891d.a), pid.type, pid.pid);
                    FunAdLoadListener funAdLoadListener = this.f28931c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    l.b bVar = aVar.f28891d;
                    if (this.a.containsKey(bVar)) {
                        this.a.put(bVar, 1);
                        if (this.f28932d.f28916b.f28885b > 0 && System.currentTimeMillis() - this.f28930b < this.f28932d.f28916b.f28885b) {
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
                    Ssp.Pid pid = aVar.f28890c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f28891d.a), pid.type, pid.pid);
                    if (this.a.containsKey(aVar.f28891d)) {
                        this.a.put(aVar.f28891d, -1);
                        FunAdLoadListener funAdLoadListener = this.f28931c;
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
                                    LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.f28932d.f28916b.a);
                                    b(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.f28932d.f28916b.a);
                        funAdLoadListener.onError(this.f28932d.f28916b.a);
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
    }

    public u0(l lVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, iVar};
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
        this.f28919e = new e(this, null);
        this.f28922h = new a(this, Looper.getMainLooper());
        this.f28916b = lVar;
        this.f28918d = new u0.c(lVar);
        HashMap hashMap = new HashMap();
        for (l.b bVar : lVar.f28888e) {
            for (l.a aVar : bVar.f28892b) {
                PidLoader a2 = iVar.a(aVar.f28890c);
                if (a2 != null) {
                    a2.addListener(new g(this, aVar));
                    hashMap.put(aVar.f28890c, a2);
                }
            }
        }
        this.f28917c = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f28917c.get(aVar.f28890c);
        }
        return (PidLoader) invokeL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, IRipperCallBack iRipperCallBack, q<Result> qVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, iRipperCallBack, qVar)) != null) {
            return (Result) invokeLLL.objValue;
        }
        this.f28921g = funAdInteractionListener;
        com.fun.u0 u0Var = this.f28918d;
        if (iRipperCallBack == null) {
            u0Var.e();
        } else {
            u0Var.f();
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            PidLoader a2 = ((e) this.f28919e).a(z, arrayList);
            Result result = null;
            if (a2 == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f28916b.a);
                this.f28922h.post(new b(this, funAdInteractionListener));
                return null;
            }
            if (iRipperCallBack == null || iRipperCallBack.accept(a2.getRippedAd())) {
                result = qVar.a(a2);
            }
            if (result != null && qVar.a((q<Result>) result)) {
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
                this.f28922h.removeMessages(100);
                this.f28921g = null;
                f fVar = this.f28920f;
                if (fVar != null) {
                    fVar.a();
                    this.f28920f = null;
                }
                for (PidLoader pidLoader : this.f28917c.values()) {
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
            PidLoader a2 = ((e) this.f28919e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f28916b.a);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f28916b.a);
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
            PidLoader a2 = ((e) this.f28919e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f28916b.a);
                return null;
            }
            FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.f28916b.a);
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
            for (PidLoader pidLoader : this.f28917c.values()) {
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
                this.f28918d.d();
                this.f28922h.removeMessages(101);
                this.f28922h.removeMessages(100);
                l lVar = this.f28916b;
                ArrayList arrayList = null;
                if (lVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (l.b bVar : lVar.f28888e) {
                        l.a aVar = (l.a) c.g.d.a(this.a, bVar.f28892b, null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new v0(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    f fVar = new f(this, funAdLoadListener, arrayList);
                    this.f28920f = fVar;
                    fVar.f28930b = System.currentTimeMillis();
                    Message obtainMessage = this.f28922h.obtainMessage(100);
                    obtainMessage.obj = fVar;
                    this.f28922h.sendMessageDelayed(obtainMessage, this.f28916b.f28886c);
                    if (this.f28916b.f28885b > 0) {
                        Message obtainMessage2 = this.f28922h.obtainMessage(101);
                        obtainMessage2.obj = fVar;
                        this.f28922h.sendMessageDelayed(obtainMessage2, this.f28916b.f28885b);
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
                        Iterator<l.a> it = aVar2.f28891d.f28892b.iterator();
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
            this.f28921g = null;
            f fVar = this.f28920f;
            if (fVar != null) {
                fVar.a();
            }
            this.f28920f = null;
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

    /* loaded from: classes7.dex */
    public class g implements c.g.f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28933c;
        public transient /* synthetic */ FieldHolder $fh;
        public final l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u0 f28934b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1913094275, "Lc/g/u0$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1913094275, "Lc/g/u0$g;");
                    return;
                }
            }
            f28933c = !u0.class.desiredAssertionStatus();
        }

        public g(u0 u0Var, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28934b = u0Var;
            this.a = aVar;
        }

        @Override // c.g.f
        public void a(RippedAd rippedAd) {
            u0 u0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (u0Var = this.f28934b).f28921g) == null) {
                return;
            }
            if (!f28933c && this.a.f28890c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = u0Var.f28916b.a;
            Ssp.Pid pid = this.a.f28890c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // c.g.f
        public void b() {
            u0 u0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (u0Var = this.f28934b).f28921g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(u0Var.f28916b.a);
        }

        @Override // c.g.f
        public void c() {
            u0 u0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (u0Var = this.f28934b).f28921g) == null) {
                return;
            }
            if (!f28933c && this.a.f28890c == null) {
                throw new AssertionError();
            }
            String str = u0Var.f28916b.a;
            Ssp.Pid pid = this.a.f28890c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // c.g.f
        public void d() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fVar = this.f28934b.f28920f) == null) {
                return;
            }
            fVar.c(this.a);
        }

        @Override // c.g.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // c.g.f
        public void b(int i2, String str) {
            u0 u0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (u0Var = this.f28934b).f28921g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(u0Var.f28916b.a);
        }

        @Override // c.g.f
        public void a(int i2, String str) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (fVar = this.f28934b.f28920f) == null) {
                return;
            }
            fVar.d(this.a, i2, str);
        }

        @Override // c.g.f
        public void a() {
            u0 u0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (u0Var = this.f28934b).f28921g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(u0Var.f28916b.a);
        }
    }
}
