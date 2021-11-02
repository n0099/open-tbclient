package b.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.g.l;
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
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.v0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public final class v0 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Random f31249a;

    /* renamed from: b  reason: collision with root package name */
    public final l f31250b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f31251c;

    /* renamed from: d  reason: collision with root package name */
    public final com.fun.v0 f31252d;

    /* renamed from: e  reason: collision with root package name */
    public final h f31253e;

    /* renamed from: f  reason: collision with root package name */
    public f f31254f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f31255g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f31256h;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f31257a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v0 v0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, looper};
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
            this.f31257a = v0Var;
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
                    f fVar2 = this.f31257a.f31254f;
                    if (fVar2 == null || fVar2 != fVar || (funAdLoadListener = fVar.f31270c) == null) {
                        return;
                    }
                    l lVar = fVar.f31271d.f31250b;
                    LogPrinter.e("callback onError(%s) because of timeout(%d)", lVar.f31186a, Long.valueOf(lVar.f31188c));
                    funAdLoadListener.onError(fVar.f31271d.f31250b.f31186a);
                    fVar.a();
                } else if (i2 == 101) {
                    f fVar3 = (f) message.obj;
                    f fVar4 = this.f31257a.f31254f;
                    if (fVar4 == null || fVar4 != fVar3) {
                        return;
                    }
                    synchronized (fVar3) {
                        synchronized (fVar3) {
                            Iterator<Map.Entry<l.b, Integer>> it = fVar3.f31268a.entrySet().iterator();
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
                        fVar3.b(fVar3.f31270c);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f31258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v0 f31259f;

        public b(v0 v0Var, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31259f = v0Var;
            this.f31258e = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31258e.onAdError(this.f31259f.f31250b.f31186a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f31260a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f31261b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f31262c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f31263d;

        public c(v0 v0Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31260a = activity;
            this.f31261b = viewGroup;
            this.f31262c = str;
            this.f31263d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // b.g.q
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.f31260a, this.f31261b, this.f31262c, this.f31263d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.g.q
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements q<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f31264a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f31265b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f31266c;

        public d(v0 v0Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31264a = activity;
            this.f31265b = viewGroup;
            this.f31266c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // b.g.q
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.f31264a, this.f31265b, this.f31266c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.g.q
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f31267a;

        public e(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31267a = v0Var;
        }

        public /* synthetic */ e(v0 v0Var, a aVar) {
            this(v0Var);
        }

        public PidLoader a(boolean z, List<PidLoader> list) {
            InterceptResult invokeZL;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (l.b bVar : this.f31267a.f31250b.f31190e) {
                    for (l.a aVar : bVar.f31196b) {
                        PidLoader a2 = this.f31267a.a(aVar);
                        if (a2 != null && !list.contains(a2) && a2.isLoaded() && (!z || ((rippedAd = a2.getRippedAd()) != null && rippedAd.isDeepLinkAd))) {
                            List list2 = (List) hashMap.get(bVar);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                hashMap.put(bVar, list2);
                            }
                            list2.add(aVar);
                        }
                    }
                }
                return this.f31267a.a((l.a) b.g.d.a(this.f31267a.f31249a, (List) hashMap.get((l.b) b.g.d.a(this.f31267a.f31249a, new ArrayList(hashMap.keySet()), null)), null));
            }
            return (PidLoader) invokeZL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<l.b, Integer> f31268a;

        /* renamed from: b  reason: collision with root package name */
        public long f31269b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f31270c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ v0 f31271d;

        public f(v0 v0Var, FunAdLoadListener funAdLoadListener, List<l.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31271d = v0Var;
            this.f31268a = new LinkedHashMap<>();
            this.f31270c = funAdLoadListener;
            for (l.a aVar : list) {
                this.f31268a.put(aVar.f31194d, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31270c = null;
                this.f31271d.f31256h.removeMessages(100, this);
                this.f31271d.f31256h.removeMessages(101, this);
            }
        }

        public final void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f31271d.f31250b.f31186a);
            a();
        }

        public synchronized void c(l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = aVar.f31193c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f31194d.f31195a), pid.type, pid.pid);
                    FunAdLoadListener funAdLoadListener = this.f31270c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    l.b bVar = aVar.f31194d;
                    if (this.f31268a.containsKey(bVar)) {
                        this.f31268a.put(bVar, 1);
                        if (this.f31271d.f31250b.f31187b > 0 && System.currentTimeMillis() - this.f31269b < this.f31271d.f31250b.f31187b) {
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
                    Ssp.Pid pid = aVar.f31193c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f31194d.f31195a), pid.type, pid.pid);
                    if (this.f31268a.containsKey(aVar.f31194d)) {
                        this.f31268a.put(aVar.f31194d, -1);
                        FunAdLoadListener funAdLoadListener = this.f31270c;
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
                    for (Map.Entry<l.b, Integer> entry : this.f31268a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            l.b key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.f31195a;
                            } else if (i2 != key.f31195a) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.f31271d.f31250b.f31186a);
                                    b(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.f31271d.f31250b.f31186a);
                        funAdLoadListener.onError(this.f31271d.f31250b.f31186a);
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
    }

    public v0(l lVar, i iVar) {
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
        this.f31249a = new Random();
        this.f31253e = new e(this, null);
        this.f31256h = new a(this, Looper.getMainLooper());
        this.f31250b = lVar;
        this.f31252d = new v0.c(lVar);
        HashMap hashMap = new HashMap();
        for (l.b bVar : lVar.f31190e) {
            for (l.a aVar : bVar.f31196b) {
                PidLoader a2 = iVar.a(aVar.f31193c);
                if (a2 != null) {
                    a2.addListener(new g(this, aVar));
                    hashMap.put(aVar.f31193c, a2);
                }
            }
        }
        this.f31251c = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f31251c.get(aVar.f31193c);
        }
        return (PidLoader) invokeL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, q<Result> qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, qVar)) == null) {
            this.f31252d.e();
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            ArrayList arrayList = new ArrayList();
            PidLoader a2 = ((e) this.f31253e).a(z, arrayList);
            this.f31255g = funAdInteractionListener;
            while (a2 != null) {
                Result a3 = qVar.a(a2);
                if (a3 != null && qVar.a((q<Result>) a3)) {
                    return a3;
                }
                arrayList.add(a2);
                a2 = ((e) this.f31253e).a(z, arrayList);
            }
            LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f31250b.f31186a);
            this.f31256h.post(new b(this, funAdInteractionListener));
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f31256h.removeMessages(100);
                this.f31255g = null;
                f fVar = this.f31254f;
                if (fVar != null) {
                    fVar.a();
                    this.f31254f = null;
                }
                for (PidLoader pidLoader : this.f31251c.values()) {
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
            PidLoader a2 = ((e) this.f31253e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f31250b.f31186a);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f31250b.f31186a);
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
            PidLoader a2 = ((e) this.f31253e).a(z, arrayList);
            if (a2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.f31250b.f31186a);
                return null;
            }
            FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.f31250b.f31186a);
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
            for (PidLoader pidLoader : this.f31251c.values()) {
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
                this.f31252d.d();
                this.f31256h.removeMessages(101);
                this.f31256h.removeMessages(100);
                l lVar = this.f31250b;
                ArrayList arrayList = null;
                if (lVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (l.b bVar : lVar.f31190e) {
                        l.a aVar = (l.a) b.g.d.a(this.f31249a, bVar.f31196b, null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new w0(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    f fVar = new f(this, funAdLoadListener, arrayList);
                    this.f31254f = fVar;
                    fVar.f31269b = System.currentTimeMillis();
                    Message obtainMessage = this.f31256h.obtainMessage(100);
                    obtainMessage.obj = fVar;
                    this.f31256h.sendMessageDelayed(obtainMessage, this.f31250b.f31188c);
                    if (this.f31250b.f31187b > 0) {
                        Message obtainMessage2 = this.f31256h.obtainMessage(101);
                        obtainMessage2.obj = fVar;
                        this.f31256h.sendMessageDelayed(obtainMessage2, this.f31250b.f31187b);
                    }
                    LogPrinter.d("Start load for sid:%s", lVar.f31186a);
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
                        Iterator<l.a> it = aVar2.f31194d.f31196b.iterator();
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
                LogPrinter.e("No selected adIds found for sid:%s", lVar.f31186a);
                funAdLoadListener.onError(lVar.f31186a);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31255g = null;
            f fVar = this.f31254f;
            if (fVar != null) {
                fVar.a();
            }
            this.f31254f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, new c(this, activity, t, str, funNativeAdInflater));
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, new d(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class g implements b.g.f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f31272c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l.a f31273a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v0 f31274b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-104716291, "Lb/g/v0$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-104716291, "Lb/g/v0$g;");
                    return;
                }
            }
            f31272c = !v0.class.desiredAssertionStatus();
        }

        public g(v0 v0Var, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f31274b = v0Var;
            this.f31273a = aVar;
        }

        @Override // b.g.f
        public void a(RippedAd rippedAd) {
            v0 v0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (v0Var = this.f31274b).f31255g) == null) {
                return;
            }
            if (!f31272c && this.f31273a.f31193c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = v0Var.f31250b.f31186a;
            Ssp.Pid pid = this.f31273a.f31193c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // b.g.f
        public void b() {
            v0 v0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (v0Var = this.f31274b).f31255g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(v0Var.f31250b.f31186a);
        }

        @Override // b.g.f
        public void c() {
            v0 v0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (v0Var = this.f31274b).f31255g) == null) {
                return;
            }
            if (!f31272c && this.f31273a.f31193c == null) {
                throw new AssertionError();
            }
            String str = v0Var.f31250b.f31186a;
            Ssp.Pid pid = this.f31273a.f31193c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // b.g.f
        public void d() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fVar = this.f31274b.f31254f) == null) {
                return;
            }
            fVar.c(this.f31273a);
        }

        @Override // b.g.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // b.g.f
        public void b(int i2, String str) {
            v0 v0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (v0Var = this.f31274b).f31255g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(v0Var.f31250b.f31186a);
        }

        @Override // b.g.f
        public void a(int i2, String str) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (fVar = this.f31274b.f31254f) == null) {
                return;
            }
            fVar.d(this.f31273a, i2, str);
        }

        @Override // b.g.f
        public void a() {
            v0 v0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (v0Var = this.f31274b).f31255g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(v0Var.f31250b.f31186a);
        }
    }
}
