package c.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.g.j;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes9.dex */
public class e implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f28373b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f28374c;

    /* renamed from: d  reason: collision with root package name */
    public x0.d f28375d;

    /* renamed from: e  reason: collision with root package name */
    public C1647e f28376e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f28377f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f28378g;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 100) {
                C1647e c1647e = (C1647e) message.obj;
                if (c1647e == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    c1647e.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements t<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28380c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f28381d;

        public b(e eVar, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity, viewGroup, str, funNativeAdInflater};
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
            this.f28379b = viewGroup;
            this.f28380c = str;
            this.f28381d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.g.t
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f28379b, this.f28380c, this.f28381d)) : invokeL.objValue;
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
    public class c implements t<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28383c;

        public c(e eVar, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity, viewGroup, str};
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
            this.f28382b = viewGroup;
            this.f28383c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.g.t
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f28382b, this.f28383c) : invokeL.objValue;
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
    public class d implements r<j.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f28384b;

        public d(e eVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28384b = eVar;
            this.a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                PidLoader pidLoader = this.f28384b.f28373b.get(((j.a) obj).f28418c);
                List list = this.a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1647e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f28385b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<j.b> f28386c;

        /* renamed from: d  reason: collision with root package name */
        public final x0.d f28387d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<j.a> f28388e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28389f;

        /* renamed from: g  reason: collision with root package name */
        public int f28390g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f28391h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f28392i;

        public C1647e(e eVar, Context context, FunAdSlot funAdSlot, Iterator<j.b> it, FunAdLoadListener funAdLoadListener, x0.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, funAdSlot, it, funAdLoadListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28392i = eVar;
            this.f28388e = new HashSet<>();
            this.f28390g = 0;
            this.f28391h = funAdLoadListener;
            this.a = context;
            this.f28385b = funAdSlot;
            this.f28386c = it;
            this.f28387d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f28392i) {
                    FunAdLoadListener funAdLoadListener = this.f28391h;
                    if (this.f28389f) {
                        this.f28390g++;
                        this.f28389f = false;
                    }
                    int i2 = this.f28390g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f28387d.g(i2, -1);
                    } else if (this.f28392i.f28376e != this) {
                        this.f28387d.g(i2, -101);
                        funAdLoadListener.onError(this.f28392i.a.a);
                        c();
                    } else if (!this.f28386c.hasNext() && this.f28388e.isEmpty()) {
                        this.f28387d.g(i2, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.f28392i.a.a);
                        funAdLoadListener.onError(this.f28392i.a.a);
                        c();
                    } else if (!this.f28386c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        j.b next = this.f28386c.next();
                        this.f28389f = true;
                        if (next.f28419b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.f28392i.a.a);
                            this.f28387d.h(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (j.a aVar : next.f28419b) {
                            PidLoader pidLoader = this.f28392i.f28373b.get(aVar.f28418c);
                            if (pidLoader != null) {
                                this.f28388e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.f28387d.h(i2, aVar.f28418c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.f28392i.a.a);
                            this.f28387d.h(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            this.f28387d.h(i2, pidLoader2.getPid().type, pidLoader2.load(this.a, this.f28385b) ? 1 : 2);
                        }
                        this.f28392i.f28378g.removeMessages(100, this);
                        this.f28392i.f28378g.sendMessageDelayed(this.f28392i.f28378g.obtainMessage(100, this), next.a);
                    }
                }
            }
        }

        public void b(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f28392i) {
                    if (this.f28392i.f28376e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f28391h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f28388e.remove(aVar)) {
                        x0.d dVar = this.f28387d;
                        int i2 = this.f28390g;
                        String str = aVar.f28418c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(this.f28392i.a.a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f28392i) {
                    this.f28392i.f28378g.removeMessages(100, this);
                    this.f28391h = null;
                    this.f28388e.clear();
                    e eVar = this.f28392i;
                    if (eVar.f28376e == this) {
                        eVar.f28376e = null;
                    }
                }
            }
        }
    }

    public e(j jVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28374c = new Random();
        this.f28378g = new a(this, Looper.getMainLooper());
        this.a = jVar;
        HashMap hashMap = new HashMap();
        for (j.b bVar : jVar.f28415b) {
            for (j.a aVar : bVar.f28419b) {
                PidLoader a2 = kVar.a(aVar.f28418c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar));
                    hashMap.put(aVar.f28418c, a2);
                }
            }
        }
        this.f28373b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(j.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            j.a aVar = (j.a) c.g.d.a(this.f28374c, bVar.f28419b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f28373b.get(aVar.f28418c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, IRipperCallBack iRipperCallBack, t<Result> tVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, iRipperCallBack, tVar)) == null) {
            if (this.f28375d == null) {
                this.f28375d = new x0.d(this.a);
            }
            this.f28377f = funAdInteractionListener;
            x0.d dVar = this.f28375d;
            if (iRipperCallBack == null) {
                dVar.e();
            } else {
                dVar.f();
            }
            for (j.b bVar : this.a.f28415b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        Result a3 = (iRipperCallBack == null || iRipperCallBack.accept(a2.getRippedAd())) ? tVar.a(a2) : null;
                        if (a3 != null && tVar.a((t<Result>) a3)) {
                            return a3;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.a.a);
            this.f28377f = null;
            LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.a.a);
            return null;
        }
        return (Result) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f28378g.removeMessages(100);
                C1647e c1647e = this.f28376e;
                if (c1647e != null) {
                    c1647e.c();
                }
                this.f28376e = null;
                this.f28377f = null;
                for (j.b bVar : this.a.f28415b) {
                    for (j.a aVar : bVar.f28419b) {
                        PidLoader pidLoader = this.f28373b.get(aVar.f28418c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd getNativeAd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            for (j.b bVar : this.a.f28415b) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            for (j.b bVar : this.a.f28415b) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Iterator<j.b> it = this.a.f28415b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (j.a aVar : it.next().f28419b) {
                        PidLoader pidLoader = this.f28373b.get(aVar.f28418c);
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
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                x0.d dVar = new x0.d(this.a);
                this.f28378g.removeMessages(100);
                if (this.f28376e != null) {
                    dVar.i(true);
                    this.f28376e.c();
                } else {
                    dVar.i(false);
                }
                if (this.a.f28415b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.a.a);
                    dVar.g(-1, -100);
                    funAdLoadListener.onError(this.a.a);
                    return;
                }
                this.f28375d = dVar;
                C1647e c1647e = new C1647e(this, context, funAdSlot, this.a.f28415b.iterator(), funAdLoadListener, dVar);
                this.f28376e = c1647e;
                c1647e.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            C1647e c1647e = this.f28376e;
            if (c1647e != null) {
                c1647e.c();
            }
            this.f28376e = null;
            this.f28377f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater, IRipperCallBack iRipperCallBack) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, t, str, funAdInteractionListener, funNativeAdInflater, iRipperCallBack})) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, iRipperCallBack, new b(this, activity, t, str, funNativeAdInflater));
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
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, null, new c(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes9.dex */
    public class f implements i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28393c;
        public transient /* synthetic */ FieldHolder $fh;
        public final j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f28394b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1724766892, "Lc/g/e$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1724766892, "Lc/g/e$f;");
                    return;
                }
            }
            f28393c = !e.class.desiredAssertionStatus();
        }

        public f(e eVar, j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28394b = eVar;
            this.a = aVar;
        }

        @Override // c.g.i
        public void a(RippedAd rippedAd) {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (eVar = this.f28394b).f28377f) == null) {
                return;
            }
            if (!f28393c && this.a.f28418c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = eVar.a.a;
            Ssp.Pid pid = this.a.f28418c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // c.g.i
        public void b() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (eVar = this.f28394b).f28377f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(eVar.a.a);
        }

        @Override // c.g.i
        public void c() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (eVar = this.f28394b).f28377f) == null) {
                return;
            }
            if (!f28393c && this.a.f28418c == null) {
                throw new AssertionError();
            }
            String str = eVar.a.a;
            Ssp.Pid pid = this.a.f28418c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // c.g.i
        public void d() {
            C1647e c1647e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (c1647e = this.f28394b.f28376e) == null) {
                return;
            }
            c1647e.b(this.a);
        }

        @Override // c.g.i
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // c.g.i
        public void b(int i2, String str) {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (eVar = this.f28394b).f28377f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(eVar.a.a);
        }

        @Override // c.g.i
        public void a(int i2, String str) {
            C1647e c1647e;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (c1647e = this.f28394b.f28376e) == null) {
                return;
            }
            j.a aVar = this.a;
            synchronized (c1647e.f28392i) {
                if (c1647e.f28392i.f28376e == c1647e && c1647e.f28388e.remove(aVar) && (funAdLoadListener = c1647e.f28391h) != null) {
                    if (!c1647e.f28386c.hasNext() && c1647e.f28388e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", c1647e.f28392i.a.a);
                        c1647e.f28387d.g(c1647e.f28390g, -103);
                        funAdLoadListener.onError(c1647e.f28392i.a.a);
                        c1647e.c();
                    } else if (c1647e.f28388e.isEmpty()) {
                        c1647e.f28392i.f28378g.removeMessages(100, c1647e);
                        c1647e.f28392i.f28378g.obtainMessage(100, c1647e).sendToTarget();
                    }
                }
            }
        }

        @Override // c.g.i
        public void a() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (eVar = this.f28394b).f28377f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(eVar.a.a);
        }
    }
}
