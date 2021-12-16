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
import com.fun.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes9.dex */
public class b implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f29187b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f29188c;

    /* renamed from: d  reason: collision with root package name */
    public u0.d f29189d;

    /* renamed from: e  reason: collision with root package name */
    public e f29190e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f29191f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f29192g;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
                e eVar = (e) message.obj;
                if (eVar == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    eVar.a();
                }
            }
        }
    }

    /* renamed from: c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1627b implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29194c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f29195d;

        public C1627b(b bVar, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, viewGroup, str, funNativeAdInflater};
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
            this.f29193b = viewGroup;
            this.f29194c = str;
            this.f29195d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // c.g.q
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.f29193b, this.f29194c, this.f29195d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.g.q
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements q<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29196b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29197c;

        public c(b bVar, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, viewGroup, str};
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
            this.f29196b = viewGroup;
            this.f29197c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // c.g.q
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.f29196b, this.f29197c) : invokeL.objValue;
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

    /* loaded from: classes9.dex */
    public class d implements o<j.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f29198b;

        public d(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29198b = bVar;
            this.a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                PidLoader pidLoader = this.f29198b.f29187b.get(((j.a) obj).f29244c);
                List list = this.a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f29199b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<j.b> f29200c;

        /* renamed from: d  reason: collision with root package name */
        public final u0.d f29201d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<j.a> f29202e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29203f;

        /* renamed from: g  reason: collision with root package name */
        public int f29204g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f29205h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f29206i;

        public e(b bVar, Context context, FunAdSlot funAdSlot, Iterator<j.b> it, FunAdLoadListener funAdLoadListener, u0.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, funAdSlot, it, funAdLoadListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29206i = bVar;
            this.f29202e = new HashSet<>();
            this.f29204g = 0;
            this.f29205h = funAdLoadListener;
            this.a = context;
            this.f29199b = funAdSlot;
            this.f29200c = it;
            this.f29201d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f29206i) {
                    FunAdLoadListener funAdLoadListener = this.f29205h;
                    if (this.f29203f) {
                        this.f29204g++;
                        this.f29203f = false;
                    }
                    int i2 = this.f29204g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f29201d.g(i2, -1);
                    } else if (this.f29206i.f29190e != this) {
                        this.f29201d.g(i2, -101);
                        funAdLoadListener.onError(this.f29206i.a.a);
                        c();
                    } else if (!this.f29200c.hasNext() && this.f29202e.isEmpty()) {
                        this.f29201d.g(i2, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.f29206i.a.a);
                        funAdLoadListener.onError(this.f29206i.a.a);
                        c();
                    } else if (!this.f29200c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        j.b next = this.f29200c.next();
                        this.f29203f = true;
                        if (next.f29245b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.f29206i.a.a);
                            this.f29201d.h(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (j.a aVar : next.f29245b) {
                            PidLoader pidLoader = this.f29206i.f29187b.get(aVar.f29244c);
                            if (pidLoader != null) {
                                this.f29202e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.f29201d.h(i2, aVar.f29244c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.f29206i.a.a);
                            this.f29201d.h(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            this.f29201d.h(i2, pidLoader2.getPid().type, pidLoader2.load(this.a, this.f29199b) ? 1 : 2);
                        }
                        this.f29206i.f29192g.removeMessages(100, this);
                        this.f29206i.f29192g.sendMessageDelayed(this.f29206i.f29192g.obtainMessage(100, this), next.a);
                    }
                }
            }
        }

        public void b(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f29206i) {
                    if (this.f29206i.f29190e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f29205h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f29202e.remove(aVar)) {
                        u0.d dVar = this.f29201d;
                        int i2 = this.f29204g;
                        String str = aVar.f29244c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(this.f29206i.a.a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f29206i) {
                    this.f29206i.f29192g.removeMessages(100, this);
                    this.f29205h = null;
                    this.f29202e.clear();
                    b bVar = this.f29206i;
                    if (bVar.f29190e == this) {
                        bVar.f29190e = null;
                    }
                }
            }
        }
    }

    public b(j jVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29188c = new Random();
        this.f29192g = new a(this, Looper.getMainLooper());
        this.a = jVar;
        HashMap hashMap = new HashMap();
        for (j.b bVar : jVar.f29241b) {
            for (j.a aVar : bVar.f29245b) {
                PidLoader a2 = iVar.a(aVar.f29244c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar));
                    hashMap.put(aVar.f29244c, a2);
                }
            }
        }
        this.f29187b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(j.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            j.a aVar = (j.a) c.g.d.a(this.f29188c, bVar.f29245b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f29187b.get(aVar.f29244c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, IRipperCallBack iRipperCallBack, q<Result> qVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, iRipperCallBack, qVar)) == null) {
            if (this.f29189d == null) {
                this.f29189d = new u0.d(this.a);
            }
            this.f29191f = funAdInteractionListener;
            u0.d dVar = this.f29189d;
            if (iRipperCallBack == null) {
                dVar.e();
            } else {
                dVar.f();
            }
            for (j.b bVar : this.a.f29241b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        Result a3 = (iRipperCallBack == null || iRipperCallBack.accept(a2.getRippedAd())) ? qVar.a(a2) : null;
                        if (a3 != null && qVar.a((q<Result>) a3)) {
                            return a3;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.a.a);
            this.f29191f = null;
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
                this.f29192g.removeMessages(100);
                e eVar = this.f29190e;
                if (eVar != null) {
                    eVar.c();
                }
                this.f29190e = null;
                this.f29191f = null;
                for (j.b bVar : this.a.f29241b) {
                    for (j.a aVar : bVar.f29245b) {
                        PidLoader pidLoader = this.f29187b.get(aVar.f29244c);
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
            for (j.b bVar : this.a.f29241b) {
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
            for (j.b bVar : this.a.f29241b) {
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
                Iterator<j.b> it = this.a.f29241b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (j.a aVar : it.next().f29245b) {
                        PidLoader pidLoader = this.f29187b.get(aVar.f29244c);
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
                u0.d dVar = new u0.d(this.a);
                this.f29192g.removeMessages(100);
                if (this.f29190e != null) {
                    dVar.i(true);
                    this.f29190e.c();
                } else {
                    dVar.i(false);
                }
                if (this.a.f29241b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.a.a);
                    dVar.g(-1, -100);
                    funAdLoadListener.onError(this.a.a);
                    return;
                }
                this.f29189d = dVar;
                e eVar = new e(this, context, funAdSlot, this.a.f29241b.iterator(), funAdLoadListener, dVar);
                this.f29190e = eVar;
                eVar.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e eVar = this.f29190e;
            if (eVar != null) {
                eVar.c();
            }
            this.f29190e = null;
            this.f29191f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater, IRipperCallBack iRipperCallBack) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, t, str, funAdInteractionListener, funNativeAdInflater, iRipperCallBack})) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, iRipperCallBack, new C1627b(this, activity, t, str, funNativeAdInflater));
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
    public class f implements c.g.f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f29207c;
        public transient /* synthetic */ FieldHolder $fh;
        public final j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f29208b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1724856265, "Lc/g/b$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1724856265, "Lc/g/b$f;");
                    return;
                }
            }
            f29207c = !b.class.desiredAssertionStatus();
        }

        public f(b bVar, j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f29208b = bVar;
            this.a = aVar;
        }

        @Override // c.g.f
        public void a(RippedAd rippedAd) {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (bVar = this.f29208b).f29191f) == null) {
                return;
            }
            if (!f29207c && this.a.f29244c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = bVar.a.a;
            Ssp.Pid pid = this.a.f29244c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // c.g.f
        public void b() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (bVar = this.f29208b).f29191f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(bVar.a.a);
        }

        @Override // c.g.f
        public void c() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (bVar = this.f29208b).f29191f) == null) {
                return;
            }
            if (!f29207c && this.a.f29244c == null) {
                throw new AssertionError();
            }
            String str = bVar.a.a;
            Ssp.Pid pid = this.a.f29244c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // c.g.f
        public void d() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f29208b.f29190e) == null) {
                return;
            }
            eVar.b(this.a);
        }

        @Override // c.g.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // c.g.f
        public void b(int i2, String str) {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (bVar = this.f29208b).f29191f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(bVar.a.a);
        }

        @Override // c.g.f
        public void a(int i2, String str) {
            e eVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (eVar = this.f29208b.f29190e) == null) {
                return;
            }
            j.a aVar = this.a;
            synchronized (eVar.f29206i) {
                if (eVar.f29206i.f29190e == eVar && eVar.f29202e.remove(aVar) && (funAdLoadListener = eVar.f29205h) != null) {
                    if (!eVar.f29200c.hasNext() && eVar.f29202e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", eVar.f29206i.a.a);
                        eVar.f29201d.g(eVar.f29204g, -103);
                        funAdLoadListener.onError(eVar.f29206i.a.a);
                        eVar.c();
                    } else if (eVar.f29202e.isEmpty()) {
                        eVar.f29206i.f29192g.removeMessages(100, eVar);
                        eVar.f29206i.f29192g.obtainMessage(100, eVar).sendToTarget();
                    }
                }
            }
        }

        @Override // c.g.f
        public void a() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (bVar = this.f29208b).f29191f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(bVar.a.a);
        }
    }
}
