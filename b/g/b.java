package b.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.g.j;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public class b implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final j f31096a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f31097b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f31098c;

    /* renamed from: d  reason: collision with root package name */
    public v0.d f31099d;

    /* renamed from: e  reason: collision with root package name */
    public e f31100e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f31101f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f31102g;

    /* loaded from: classes6.dex */
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

    /* renamed from: b.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1470b implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f31103a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f31104b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f31105c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f31106d;

        public C1470b(b bVar, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
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
            this.f31103a = activity;
            this.f31104b = viewGroup;
            this.f31105c = str;
            this.f31106d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // b.g.q
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.f31103a, this.f31104b, this.f31105c, this.f31106d)) : invokeL.objValue;
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
    public class c implements q<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f31107a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f31108b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f31109c;

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
            this.f31107a = activity;
            this.f31108b = viewGroup;
            this.f31109c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // b.g.q
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.f31107a, this.f31108b, this.f31109c) : invokeL.objValue;
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
    public class d implements o<j.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f31110a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f31111b;

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
            this.f31111b = bVar;
            this.f31110a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                PidLoader pidLoader = this.f31111b.f31097b.get(((j.a) obj).f31173c);
                List list = this.f31110a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f31112a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f31113b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<j.b> f31114c;

        /* renamed from: d  reason: collision with root package name */
        public final v0.d f31115d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<j.a> f31116e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31117f;

        /* renamed from: g  reason: collision with root package name */
        public int f31118g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f31119h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f31120i;

        public e(b bVar, Context context, FunAdSlot funAdSlot, Iterator<j.b> it, FunAdLoadListener funAdLoadListener, v0.d dVar) {
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
            this.f31120i = bVar;
            this.f31116e = new HashSet<>();
            this.f31118g = 0;
            this.f31119h = funAdLoadListener;
            this.f31112a = context;
            this.f31113b = funAdSlot;
            this.f31114c = it;
            this.f31115d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f31120i) {
                    FunAdLoadListener funAdLoadListener = this.f31119h;
                    if (this.f31117f) {
                        this.f31118g++;
                        this.f31117f = false;
                    }
                    int i2 = this.f31118g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f31115d.f(i2, -1);
                    } else if (this.f31120i.f31100e != this) {
                        this.f31115d.f(i2, -101);
                        funAdLoadListener.onError(this.f31120i.f31096a.f31168a);
                        c();
                    } else if (!this.f31114c.hasNext() && this.f31116e.isEmpty()) {
                        this.f31115d.f(i2, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.f31120i.f31096a.f31168a);
                        funAdLoadListener.onError(this.f31120i.f31096a.f31168a);
                        c();
                    } else if (!this.f31114c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        j.b next = this.f31114c.next();
                        this.f31117f = true;
                        if (next.f31175b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.f31120i.f31096a.f31168a);
                            this.f31115d.g(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (j.a aVar : next.f31175b) {
                            PidLoader pidLoader = this.f31120i.f31097b.get(aVar.f31173c);
                            if (pidLoader != null) {
                                this.f31116e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.f31115d.g(i2, aVar.f31173c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.f31120i.f31096a.f31168a);
                            this.f31115d.g(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            this.f31115d.g(i2, pidLoader2.getPid().type, pidLoader2.load(this.f31112a, this.f31113b) ? 1 : 2);
                        }
                        this.f31120i.f31102g.removeMessages(100, this);
                        this.f31120i.f31102g.sendMessageDelayed(this.f31120i.f31102g.obtainMessage(100, this), next.f31174a);
                    }
                }
            }
        }

        public void b(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f31120i) {
                    if (this.f31120i.f31100e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f31119h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f31116e.remove(aVar)) {
                        v0.d dVar = this.f31115d;
                        int i2 = this.f31118g;
                        String str = aVar.f31173c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(this.f31120i.f31096a.f31168a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31120i) {
                    this.f31120i.f31102g.removeMessages(100, this);
                    this.f31119h = null;
                    this.f31116e.clear();
                    b bVar = this.f31120i;
                    if (bVar.f31100e == this) {
                        bVar.f31100e = null;
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
        this.f31098c = new Random();
        this.f31102g = new a(this, Looper.getMainLooper());
        this.f31096a = jVar;
        HashMap hashMap = new HashMap();
        for (j.b bVar : jVar.f31169b) {
            for (j.a aVar : bVar.f31175b) {
                PidLoader a2 = iVar.a(aVar.f31173c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar));
                    hashMap.put(aVar.f31173c, a2);
                }
            }
        }
        this.f31097b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(j.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            j.a aVar = (j.a) b.g.d.a(this.f31098c, bVar.f31175b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f31097b.get(aVar.f31173c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, q<Result> qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, qVar)) == null) {
            if (this.f31099d == null) {
                this.f31099d = new v0.d(this.f31096a);
            }
            this.f31099d.e();
            this.f31101f = funAdInteractionListener;
            for (j.b bVar : this.f31096a.f31169b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        Result a3 = qVar.a(a2);
                        if (a3 != null && qVar.a((q<Result>) a3)) {
                            return a3;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.f31096a.f31168a);
            this.f31101f = null;
            LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.f31096a.f31168a);
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f31102g.removeMessages(100);
                e eVar = this.f31100e;
                if (eVar != null) {
                    eVar.c();
                }
                this.f31100e = null;
                this.f31101f = null;
                for (j.b bVar : this.f31096a.f31169b) {
                    for (j.a aVar : bVar.f31175b) {
                        PidLoader pidLoader = this.f31097b.get(aVar.f31173c);
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
            for (j.b bVar : this.f31096a.f31169b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd nativeAd = a2.getNativeAd(context, this.f31096a.f31168a);
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
            for (j.b bVar : this.f31096a.f31169b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.f31096a.f31168a);
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
                Iterator<j.b> it = this.f31096a.f31169b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (j.a aVar : it.next().f31175b) {
                        PidLoader pidLoader = this.f31097b.get(aVar.f31173c);
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
                v0.d dVar = new v0.d(this.f31096a);
                this.f31102g.removeMessages(100);
                if (this.f31100e != null) {
                    dVar.h(true);
                    this.f31100e.c();
                } else {
                    dVar.h(false);
                }
                if (this.f31096a.f31169b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.f31096a.f31168a);
                    dVar.f(-1, -100);
                    funAdLoadListener.onError(this.f31096a.f31168a);
                    return;
                }
                this.f31099d = dVar;
                e eVar = new e(this, context, funAdSlot, this.f31096a.f31169b.iterator(), funAdLoadListener, dVar);
                this.f31100e = eVar;
                eVar.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e eVar = this.f31100e;
            if (eVar != null) {
                eVar.c();
            }
            this.f31100e = null;
            this.f31101f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, new C1470b(this, activity, t, str, funNativeAdInflater));
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
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, new c(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class f implements b.g.f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f31121c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final j.a f31122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f31123b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(827300696, "Lb/g/b$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(827300696, "Lb/g/b$f;");
                    return;
                }
            }
            f31121c = !b.class.desiredAssertionStatus();
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
            this.f31123b = bVar;
            this.f31122a = aVar;
        }

        @Override // b.g.f
        public void a(RippedAd rippedAd) {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) || (funAdInteractionListener = (bVar = this.f31123b).f31101f) == null) {
                return;
            }
            if (!f31121c && this.f31122a.f31173c == null) {
                throw new AssertionError();
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = bVar.f31096a.f31168a;
            Ssp.Pid pid = this.f31122a.f31173c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd);
        }

        @Override // b.g.f
        public void b() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (bVar = this.f31123b).f31101f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(bVar.f31096a.f31168a);
        }

        @Override // b.g.f
        public void c() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (bVar = this.f31123b).f31101f) == null) {
                return;
            }
            if (!f31121c && this.f31122a.f31173c == null) {
                throw new AssertionError();
            }
            String str = bVar.f31096a.f31168a;
            Ssp.Pid pid = this.f31122a.f31173c;
            funAdInteractionListener.onAdClicked(str, pid.ssp.type, pid.pid);
        }

        @Override // b.g.f
        public void d() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f31123b.f31100e) == null) {
                return;
            }
            eVar.b(this.f31122a);
        }

        @Override // b.g.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // b.g.f
        public void b(int i2, String str) {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (funAdInteractionListener = (bVar = this.f31123b).f31101f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(bVar.f31096a.f31168a);
        }

        @Override // b.g.f
        public void a(int i2, String str) {
            e eVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (eVar = this.f31123b.f31100e) == null) {
                return;
            }
            j.a aVar = this.f31122a;
            synchronized (eVar.f31120i) {
                if (eVar.f31120i.f31100e == eVar && eVar.f31116e.remove(aVar) && (funAdLoadListener = eVar.f31119h) != null) {
                    if (!eVar.f31114c.hasNext() && eVar.f31116e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", eVar.f31120i.f31096a.f31168a);
                        eVar.f31115d.f(eVar.f31118g, -103);
                        funAdLoadListener.onError(eVar.f31120i.f31096a.f31168a);
                        eVar.c();
                    } else if (eVar.f31116e.isEmpty()) {
                        eVar.f31120i.f31102g.removeMessages(100, eVar);
                        eVar.f31120i.f31102g.obtainMessage(100, eVar).sendToTarget();
                    }
                }
            }
        }

        @Override // b.g.f
        public void a() {
            b bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (bVar = this.f31123b).f31101f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(bVar.f31096a.f31168a);
        }
    }
}
