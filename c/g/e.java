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
    public final Map<Ssp.Pid, PidLoader> f28401b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f28402c;

    /* renamed from: d  reason: collision with root package name */
    public x0.d f28403d;

    /* renamed from: e  reason: collision with root package name */
    public C1648e f28404e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f28405f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f28406g;

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
                C1648e c1648e = (C1648e) message.obj;
                if (c1648e == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    c1648e.a();
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
        public final /* synthetic */ ViewGroup f28407b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28408c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f28409d;

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
            this.f28407b = viewGroup;
            this.f28408c = str;
            this.f28409d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.g.t
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f28407b, this.f28408c, this.f28409d)) : invokeL.objValue;
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
        public final /* synthetic */ ViewGroup f28410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28411c;

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
            this.f28410b = viewGroup;
            this.f28411c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.g.t
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f28410b, this.f28411c) : invokeL.objValue;
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
        public final /* synthetic */ e f28412b;

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
            this.f28412b = eVar;
            this.a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                PidLoader pidLoader = this.f28412b.f28401b.get(((j.a) obj).f28446c);
                List list = this.a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1648e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f28413b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<j.b> f28414c;

        /* renamed from: d  reason: collision with root package name */
        public final x0.d f28415d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<j.a> f28416e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28417f;

        /* renamed from: g  reason: collision with root package name */
        public int f28418g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f28419h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f28420i;

        public C1648e(e eVar, Context context, FunAdSlot funAdSlot, Iterator<j.b> it, FunAdLoadListener funAdLoadListener, x0.d dVar) {
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
            this.f28420i = eVar;
            this.f28416e = new HashSet<>();
            this.f28418g = 0;
            this.f28419h = funAdLoadListener;
            this.a = context;
            this.f28413b = funAdSlot;
            this.f28414c = it;
            this.f28415d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f28420i) {
                    FunAdLoadListener funAdLoadListener = this.f28419h;
                    if (this.f28417f) {
                        this.f28418g++;
                        this.f28417f = false;
                    }
                    int i2 = this.f28418g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f28415d.g(i2, -1);
                    } else if (this.f28420i.f28404e != this) {
                        this.f28415d.g(i2, -101);
                        funAdLoadListener.onError(this.f28420i.a.a);
                        c();
                    } else if (!this.f28414c.hasNext() && this.f28416e.isEmpty()) {
                        this.f28415d.g(i2, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.f28420i.a.a);
                        funAdLoadListener.onError(this.f28420i.a.a);
                        c();
                    } else if (!this.f28414c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        j.b next = this.f28414c.next();
                        this.f28417f = true;
                        if (next.f28447b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.f28420i.a.a);
                            this.f28415d.h(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (j.a aVar : next.f28447b) {
                            PidLoader pidLoader = this.f28420i.f28401b.get(aVar.f28446c);
                            if (pidLoader != null) {
                                this.f28416e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.f28415d.h(i2, aVar.f28446c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.f28420i.a.a);
                            this.f28415d.h(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            this.f28415d.h(i2, pidLoader2.getPid().type, pidLoader2.load(this.a, this.f28413b) ? 1 : 2);
                        }
                        this.f28420i.f28406g.removeMessages(100, this);
                        this.f28420i.f28406g.sendMessageDelayed(this.f28420i.f28406g.obtainMessage(100, this), next.a);
                    }
                }
            }
        }

        public void b(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f28420i) {
                    if (this.f28420i.f28404e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f28419h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f28416e.remove(aVar)) {
                        x0.d dVar = this.f28415d;
                        int i2 = this.f28418g;
                        String str = aVar.f28446c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(this.f28420i.a.a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f28420i) {
                    this.f28420i.f28406g.removeMessages(100, this);
                    this.f28419h = null;
                    this.f28416e.clear();
                    e eVar = this.f28420i;
                    if (eVar.f28404e == this) {
                        eVar.f28404e = null;
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
        this.f28402c = new Random();
        this.f28406g = new a(this, Looper.getMainLooper());
        this.a = jVar;
        HashMap hashMap = new HashMap();
        for (j.b bVar : jVar.f28443b) {
            for (j.a aVar : bVar.f28447b) {
                PidLoader a2 = kVar.a(aVar.f28446c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar));
                    hashMap.put(aVar.f28446c, a2);
                }
            }
        }
        this.f28401b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(j.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            j.a aVar = (j.a) c.g.d.a(this.f28402c, bVar.f28447b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f28401b.get(aVar.f28446c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, IRipperCallBack iRipperCallBack, t<Result> tVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, iRipperCallBack, tVar)) == null) {
            if (this.f28403d == null) {
                this.f28403d = new x0.d(this.a);
            }
            this.f28405f = funAdInteractionListener;
            x0.d dVar = this.f28403d;
            if (iRipperCallBack == null) {
                dVar.e();
            } else {
                dVar.f();
            }
            for (j.b bVar : this.a.f28443b) {
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
            this.f28405f = null;
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
                this.f28406g.removeMessages(100);
                C1648e c1648e = this.f28404e;
                if (c1648e != null) {
                    c1648e.c();
                }
                this.f28404e = null;
                this.f28405f = null;
                for (j.b bVar : this.a.f28443b) {
                    for (j.a aVar : bVar.f28447b) {
                        PidLoader pidLoader = this.f28401b.get(aVar.f28446c);
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
            for (j.b bVar : this.a.f28443b) {
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
            for (j.b bVar : this.a.f28443b) {
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
                Iterator<j.b> it = this.a.f28443b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (j.a aVar : it.next().f28447b) {
                        PidLoader pidLoader = this.f28401b.get(aVar.f28446c);
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
                this.f28406g.removeMessages(100);
                if (this.f28404e != null) {
                    dVar.i(true);
                    this.f28404e.c();
                } else {
                    dVar.i(false);
                }
                if (this.a.f28443b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.a.a);
                    dVar.g(-1, -100);
                    funAdLoadListener.onError(this.a.a);
                    return;
                }
                this.f28403d = dVar;
                C1648e c1648e = new C1648e(this, context, funAdSlot, this.a.f28443b.iterator(), funAdLoadListener, dVar);
                this.f28404e = c1648e;
                c1648e.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            C1648e c1648e = this.f28404e;
            if (c1648e != null) {
                c1648e.c();
            }
            this.f28404e = null;
            this.f28405f = null;
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
        public static final /* synthetic */ boolean f28421c;
        public transient /* synthetic */ FieldHolder $fh;
        public final j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f28422b;

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
            f28421c = !e.class.desiredAssertionStatus();
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
            this.f28422b = eVar;
            this.a = aVar;
        }

        @Override // c.g.i
        public void a(RippedAd rippedAd) {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (eVar = this.f28422b).f28405f) == null) {
                return;
            }
            if (!f28421c && this.a.f28446c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = eVar.a.a;
            Ssp.Pid pid = this.a.f28446c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // c.g.i
        public void b() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (eVar = this.f28422b).f28405f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(eVar.a.a);
        }

        @Override // c.g.i
        public void c() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (eVar = this.f28422b).f28405f) == null) {
                return;
            }
            if (!f28421c && this.a.f28446c == null) {
                throw new AssertionError();
            }
            String str = eVar.a.a;
            Ssp.Pid pid = this.a.f28446c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // c.g.i
        public void d() {
            C1648e c1648e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (c1648e = this.f28422b.f28404e) == null) {
                return;
            }
            c1648e.b(this.a);
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
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (eVar = this.f28422b).f28405f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(eVar.a.a);
        }

        @Override // c.g.i
        public void a(int i2, String str) {
            C1648e c1648e;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (c1648e = this.f28422b.f28404e) == null) {
                return;
            }
            j.a aVar = this.a;
            synchronized (c1648e.f28420i) {
                if (c1648e.f28420i.f28404e == c1648e && c1648e.f28416e.remove(aVar) && (funAdLoadListener = c1648e.f28419h) != null) {
                    if (!c1648e.f28414c.hasNext() && c1648e.f28416e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", c1648e.f28420i.a.a);
                        c1648e.f28415d.g(c1648e.f28418g, -103);
                        funAdLoadListener.onError(c1648e.f28420i.a.a);
                        c1648e.c();
                    } else if (c1648e.f28416e.isEmpty()) {
                        c1648e.f28420i.f28406g.removeMessages(100, c1648e);
                        c1648e.f28420i.f28406g.obtainMessage(100, c1648e).sendToTarget();
                    }
                }
            }
        }

        @Override // c.g.i
        public void a() {
            e eVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (eVar = this.f28422b).f28405f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(eVar.a.a);
        }
    }
}
