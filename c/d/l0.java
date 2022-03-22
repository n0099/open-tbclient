package c.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.d.l;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes3.dex */
public class l0 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f23187b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f23188c;

    /* renamed from: d  reason: collision with root package name */
    public o0.d f23189d;

    /* renamed from: e  reason: collision with root package name */
    public e f23190e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f23191f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f23192g;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l0 l0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 100) {
                e eVar = (e) message.obj;
                if (eVar == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    eVar.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23194c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f23195d;

        public b(l0 l0Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, activity, viewGroup, str, funNativeAdInflater};
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
            this.f23193b = viewGroup;
            this.f23194c = str;
            this.f23195d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.d.h
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f23193b, this.f23194c, this.f23195d)) : invokeL.objValue;
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
    public class c implements h<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23196b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23197c;

        public c(l0 l0Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, activity, viewGroup, str};
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
            this.f23196b = viewGroup;
            this.f23197c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.d.h
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f23196b, this.f23197c) : invokeL.objValue;
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
    public class d implements g<l.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l0 f23198b;

        public d(l0 l0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23198b = l0Var;
            this.a = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.d.g
        public boolean a(l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                PidLoader pidLoader = this.f23198b.f23187b.get(aVar.f23185c);
                List list = this.a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f23199b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<l.b> f23200c;

        /* renamed from: d  reason: collision with root package name */
        public final o0.d f23201d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<l.a> f23202e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f23203f;

        /* renamed from: g  reason: collision with root package name */
        public int f23204g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f23205h;
        public final /* synthetic */ l0 i;

        public e(l0 l0Var, Context context, FunAdSlot funAdSlot, Iterator<l.b> it, FunAdLoadListener funAdLoadListener, o0.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, context, funAdSlot, it, funAdLoadListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = l0Var;
            this.f23202e = new HashSet<>();
            this.f23204g = 0;
            this.f23205h = funAdLoadListener;
            this.a = context;
            this.f23199b = funAdSlot;
            this.f23200c = it;
            this.f23201d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.i) {
                    FunAdLoadListener funAdLoadListener = this.f23205h;
                    if (this.f23203f) {
                        this.f23204g++;
                        this.f23203f = false;
                    }
                    int i = this.f23204g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f23201d.f(i, -1);
                    } else if (this.i.f23190e != this) {
                        this.f23201d.f(i, -101);
                        funAdLoadListener.onError(this.i.a.a);
                        c();
                    } else if (!this.f23200c.hasNext() && this.f23202e.isEmpty()) {
                        this.f23201d.f(i, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.i.a.a);
                        funAdLoadListener.onError(this.i.a.a);
                        c();
                    } else if (!this.f23200c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        l.b next = this.f23200c.next();
                        this.f23203f = true;
                        if (next.f23186b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.i.a.a);
                            this.f23201d.g(i, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (l.a aVar : next.f23186b) {
                            PidLoader pidLoader = this.i.f23187b.get(aVar.f23185c);
                            if (pidLoader != null) {
                                this.f23202e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.f23201d.g(i, aVar.f23185c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.i.a.a);
                            this.f23201d.g(i, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        boolean z = true;
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader2.getPid().pid, pidLoader2.getAdType());
                            if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                this.f23201d.g(i, pidLoader2.getPid().type, pidLoader2.load(this.a, this.f23199b) ? 1 : 2);
                                z = false;
                            }
                        }
                        if (z) {
                            a();
                            return;
                        }
                        this.i.f23192g.removeMessages(100, this);
                        this.i.f23192g.sendMessageDelayed(this.i.f23192g.obtainMessage(100, this), next.a);
                    }
                }
            }
        }

        public void b(l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.i) {
                    if (this.i.f23190e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f23205h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f23202e.remove(aVar)) {
                        o0.d dVar = this.f23201d;
                        int i = this.f23204g;
                        String str = aVar.f23185c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i), "stype", str);
                        funAdLoadListener.onAdLoaded(this.i.a.a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.i) {
                    this.i.f23192g.removeMessages(100, this);
                    this.f23205h = null;
                    this.f23202e.clear();
                    l0 l0Var = this.i;
                    if (l0Var.f23190e == this) {
                        l0Var.f23190e = null;
                    }
                }
            }
        }
    }

    public l0(l lVar, o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, o0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23188c = new Random();
        this.f23192g = new a(this, Looper.getMainLooper());
        this.a = lVar;
        HashMap hashMap = new HashMap();
        for (l.b bVar : lVar.f23182b) {
            for (l.a aVar : bVar.f23186b) {
                PidLoader a2 = o0Var.a(aVar.f23185c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar, a2));
                    hashMap.put(aVar.f23185c, a2);
                }
            }
        }
        this.f23187b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(l.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            l.a aVar = (l.a) c.d.f.a(this.f23188c, bVar.f23186b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f23187b.get(aVar.f23185c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, h<Result> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, hVar)) == null) {
            if (this.f23189d == null) {
                this.f23189d = new o0.d(this.a);
            }
            this.f23191f = funAdInteractionListener;
            this.f23189d.e();
            for (l.b bVar : this.a.f23182b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        Result a3 = hVar.a(a2);
                        if (a3 != null && hVar.a((h<Result>) a3)) {
                            return a3;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.a.a);
            this.f23191f = null;
            LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.a.a);
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f23192g.removeMessages(100);
                e eVar = this.f23190e;
                if (eVar != null) {
                    eVar.c();
                }
                this.f23190e = null;
                this.f23191f = null;
                for (l.b bVar : this.a.f23182b) {
                    for (l.a aVar : bVar.f23186b) {
                        PidLoader pidLoader = this.f23187b.get(aVar.f23185c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (l.b bVar : this.a.f23182b) {
                    for (l.a aVar : bVar.f23186b) {
                        if (aVar != null && (pidLoader = this.f23187b.get(aVar.f23185c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getPid().basePrice));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            for (l.b bVar : this.a.f23182b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd nativeAd = a2.getNativeAd(context, this.a.a);
                        if (nativeAd != null) {
                            return nativeAd;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            return null;
        }
        return (FunNativeAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            for (l.b bVar : this.a.f23182b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.a.a);
                        if (nativeAd2 != null) {
                            return nativeAd2;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            return null;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                Iterator<l.b> it = this.a.f23182b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (l.a aVar : it.next().f23186b) {
                        PidLoader pidLoader = this.f23187b.get(aVar.f23185c);
                        if (pidLoader != null && pidLoader.isLoaded()) {
                            z = true;
                            break loop0;
                        }
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                o0.d dVar = new o0.d(this.a);
                this.f23192g.removeMessages(100);
                if (this.f23190e != null) {
                    dVar.h(true);
                    this.f23190e.c();
                } else {
                    dVar.h(false);
                }
                if (this.a.f23182b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.a.a);
                    dVar.f(-1, -100);
                    funAdLoadListener.onError(this.a.a);
                    return;
                }
                this.f23189d = dVar;
                e eVar = new e(this, context, funAdSlot, this.a.f23182b.iterator(), funAdLoadListener, dVar);
                this.f23190e = eVar;
                eVar.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e eVar = this.f23190e;
            if (eVar != null) {
                eVar.c();
            }
            this.f23190e = null;
            this.f23191f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, new b(this, activity, t, str, funNativeAdInflater));
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, new c(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes3.dex */
    public class f implements n0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ boolean f23206d;
        public transient /* synthetic */ FieldHolder $fh;
        public final l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final PidLoader f23207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l0 f23208c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-288949742, "Lc/d/l0$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-288949742, "Lc/d/l0$f;");
                    return;
                }
            }
            f23206d = !l0.class.desiredAssertionStatus();
        }

        public f(l0 l0Var, l.a aVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var, aVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f23208c = l0Var;
            this.a = aVar;
            this.f23207b = pidLoader;
        }

        @Override // c.d.n0
        public void a() {
            l0 l0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (l0Var = this.f23208c).f23191f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(l0Var.a.a);
        }

        @Override // c.d.n0
        public void b(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048581, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.f23208c.f23191f) == null) {
                return;
            }
            if (!f23206d && this.a.f23185c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.f23185c.pid, this.f23207b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdClick(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.f23208c.a.a;
            Ssp.Pid pid = this.a.f23185c;
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
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.f23208c.f23191f) == null) {
                return;
            }
            if (!f23206d && this.a.f23185c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.f23185c.pid, this.f23207b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdShow(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.f23208c.a.a;
            Ssp.Pid pid = this.a.f23185c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd, strArr);
        }

        @Override // c.d.n0
        public void a(int i, String str) {
            e eVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (eVar = this.f23208c.f23190e) == null) {
                return;
            }
            l.a aVar = this.a;
            synchronized (eVar.i) {
                if (eVar.i.f23190e == eVar && eVar.f23202e.remove(aVar) && (funAdLoadListener = eVar.f23205h) != null) {
                    if (!eVar.f23200c.hasNext() && eVar.f23202e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", eVar.i.a.a);
                        eVar.f23201d.f(eVar.f23204g, -103);
                        funAdLoadListener.onError(eVar.i.a.a);
                        eVar.c();
                    } else if (eVar.f23202e.isEmpty()) {
                        eVar.i.f23192g.removeMessages(100, eVar);
                        eVar.i.f23192g.obtainMessage(100, eVar).sendToTarget();
                    }
                }
            }
        }

        @Override // c.d.n0
        public void b(int i, String str) {
            l0 l0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (funAdInteractionListener = (l0Var = this.f23208c).f23191f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(l0Var.a.a);
        }

        @Override // c.d.n0
        public void b() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f23208c.f23190e) == null) {
                return;
            }
            eVar.b(this.a);
        }

        @Override // c.d.n0
        public void a(boolean z, String... strArr) {
            l0 l0Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, strArr) == null) || (funAdInteractionListener = (l0Var = this.f23208c).f23191f) == null) {
                return;
            }
            Flavors.CALL_BACK_AWARE.onRewardedVideo(funAdInteractionListener, l0Var.a.a, z, strArr);
        }
    }
}
