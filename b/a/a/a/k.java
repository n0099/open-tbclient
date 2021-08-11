package b.a.a.a;

import a.a.a.a.w.g.g.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.a.a.a.r;
import b.a.a.a.u.d;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class k implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.a.a.u.d f1095a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<h.a, n> f1096b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f1097c;

    /* renamed from: d  reason: collision with root package name */
    public d.C0000d f1098d;

    /* renamed from: e  reason: collision with root package name */
    public e f1099e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1100f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1101g;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, looper};
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
                    b.a.a.a.x.d.b("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    eVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements s<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f1102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1103b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1104c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f1105d;

        public b(k kVar, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1102a = activity;
            this.f1103b = viewGroup;
            this.f1104c = str;
            this.f1105d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // b.a.a.a.s
        public Boolean a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) ? Boolean.valueOf(nVar.c(this.f1102a, this.f1103b, this.f1104c, this.f1105d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.a.a.s
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements s<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f1106a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1108c;

        public c(k kVar, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1106a = activity;
            this.f1107b = viewGroup;
            this.f1108c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // b.a.a.a.s
        public FunSplashAd a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) ? nVar.b(this.f1106a, this.f1107b, this.f1108c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.a.a.s
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements r.b<d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f1110b;

        public d(k kVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1110b = kVar;
            this.f1109a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                n nVar = this.f1110b.f1096b.get(((d.a) obj).f1424d);
                List list = this.f1109a;
                return (list == null || !list.contains(nVar)) && nVar != null && nVar.c();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1111a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1112b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<d.b> f1113c;

        /* renamed from: d  reason: collision with root package name */
        public final d.C0000d f1114d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<d.a> f1115e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1116f;

        /* renamed from: g  reason: collision with root package name */
        public int f1117g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f1118h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f1119i;

        public e(k kVar, Context context, FunAdSlot funAdSlot, Iterator<d.b> it, FunAdLoadListener funAdLoadListener, d.C0000d c0000d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, funAdSlot, it, funAdLoadListener, c0000d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1119i = kVar;
            this.f1115e = new HashSet<>();
            this.f1117g = 0;
            this.f1118h = funAdLoadListener;
            this.f1111a = context;
            this.f1112b = funAdSlot;
            this.f1113c = it;
            this.f1114d = c0000d;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1119i) {
                    FunAdLoadListener funAdLoadListener = this.f1118h;
                    if (this.f1116f) {
                        this.f1117g++;
                        this.f1116f = false;
                    }
                    int i2 = this.f1117g;
                    if (this.f1118h == null) {
                        b.a.a.a.x.d.b("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f1114d.f(i2, -1);
                    } else if (this.f1119i.f1099e != this) {
                        this.f1114d.f(i2, -101);
                        funAdLoadListener.onError(this.f1119i.f1095a.f1419b);
                        c();
                    } else if (!this.f1113c.hasNext() && this.f1115e.isEmpty()) {
                        this.f1114d.f(i2, -102);
                        b.a.a.a.x.d.b("All loader load failed, callback onError(%s)", this.f1119i.f1095a.f1419b);
                        funAdLoadListener.onError(this.f1119i.f1095a.f1419b);
                        c();
                    } else if (!this.f1113c.hasNext()) {
                        b.a.a.a.x.d.b("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        d.b next = this.f1113c.next();
                        this.f1116f = true;
                        if (next.f1426c.isEmpty()) {
                            b.a.a.a.x.d.f("There is an empty group in SerialSid(%s)", this.f1119i.f1095a.f1419b);
                            this.f1114d.g(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (d.a aVar : next.f1426c) {
                            n nVar = this.f1119i.f1096b.get(aVar.f1424d);
                            if (nVar != null) {
                                this.f1115e.add(aVar);
                                if (nVar.c()) {
                                    this.f1114d.g(i2, aVar.f1424d.f1449d, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(nVar);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            b.a.a.a.x.d.f("No group which ready to load found in SerialSid(%s)", this.f1119i.f1095a.f1419b);
                            this.f1114d.g(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            n nVar2 = (n) it.next();
                            this.f1114d.g(i2, nVar2.b().f1449d, nVar2.a(this.f1111a, this.f1112b) ? 1 : 2);
                        }
                        this.f1119i.f1101g.removeMessages(100, this);
                        this.f1119i.f1101g.sendMessageDelayed(this.f1119i.f1101g.obtainMessage(100, this), next.f1425b);
                    }
                }
            }
        }

        public void b(d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f1119i) {
                    if (this.f1119i.f1099e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f1118h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f1115e.remove(aVar)) {
                        d.C0000d c0000d = this.f1114d;
                        int i2 = this.f1117g;
                        String str = aVar.f1424d.f1449d;
                        if (c0000d != null) {
                            c0000d.c("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                            funAdLoadListener.onAdLoaded(this.f1119i.f1095a.f1419b);
                            c();
                            return;
                        }
                        throw null;
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f1119i) {
                    this.f1119i.f1101g.removeMessages(100, this);
                    this.f1118h = null;
                    this.f1115e.clear();
                    if (this.f1119i.f1099e == this) {
                        this.f1119i.f1099e = null;
                    }
                }
            }
        }
    }

    public k(b.a.a.a.u.d dVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1097c = new Random();
        this.f1101g = new a(this, Looper.getMainLooper());
        this.f1095a = dVar;
        HashMap hashMap = new HashMap();
        for (d.b bVar : dVar.f1420c) {
            for (d.a aVar : bVar.f1426c) {
                n a2 = pVar.a(aVar.f1424d);
                if (a2 != null) {
                    a2.d(new f(this, aVar));
                    hashMap.put(aVar.f1424d, a2);
                }
            }
        }
        this.f1096b = Collections.unmodifiableMap(hashMap);
    }

    @Override // b.a.a.a.h
    public FunNativeAd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            for (d.b bVar : this.f1095a.f1420c) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    n c2 = c(bVar, arrayList);
                    if (c2 != null) {
                        FunNativeAd nativeAd = c2.getNativeAd(context, this.f1095a.f1419b);
                        if (nativeAd != null) {
                            return nativeAd;
                        }
                        arrayList.add(c2);
                    }
                }
            }
            return null;
        }
        return (FunNativeAd) invokeL.objValue;
    }

    @Override // b.a.a.a.h
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f1101g.removeMessages(100);
                e eVar = this.f1099e;
                if (eVar != null) {
                    eVar.c();
                }
                this.f1099e = null;
                this.f1100f = null;
                for (d.b bVar : this.f1095a.f1420c) {
                    for (d.a aVar : bVar.f1426c) {
                        n nVar = this.f1096b.get(aVar.f1424d);
                        if (nVar != null) {
                            nVar.a();
                        }
                    }
                }
            }
        }
    }

    @Override // b.a.a.a.h
    public synchronized <T extends ViewGroup> boolean a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) d(funAdInteractionListener, new b(this, activity, t, str, funNativeAdInflater));
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // b.a.a.a.h
    public synchronized void b(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                d.C0000d c0000d = new d.C0000d(this.f1095a);
                this.f1101g.removeMessages(100);
                if (this.f1099e != null) {
                    c0000d.h(true);
                    this.f1099e.c();
                } else {
                    c0000d.h(false);
                }
                if (this.f1095a.f1420c.isEmpty()) {
                    b.a.a.a.x.d.f("No groups found in SerialSlotId(%s)", this.f1095a.f1419b);
                    c0000d.f(-1, -100);
                    funAdLoadListener.onError(this.f1095a.f1419b);
                    return;
                }
                this.f1098d = c0000d;
                e eVar = new e(this, context, funAdSlot, this.f1095a.f1420c.iterator(), funAdLoadListener, c0000d);
                this.f1099e = eVar;
                eVar.a();
            }
        }
    }

    @Override // b.a.a.a.h
    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                Iterator<d.b> it = this.f1095a.f1420c.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (d.a aVar : it.next().f1426c) {
                        n nVar = this.f1096b.get(aVar.f1424d);
                        if (nVar != null && nVar.c()) {
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

    public final n c(d.b bVar, List<n> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, list)) == null) {
            d.a aVar = (d.a) r.c(this.f1097c, bVar.f1426c, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f1096b.get(aVar.f1424d);
        }
        return (n) invokeLL.objValue;
    }

    public final <Result> Result d(FunAdInteractionListener funAdInteractionListener, s<Result> sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, funAdInteractionListener, sVar)) == null) {
            if (this.f1098d == null) {
                this.f1098d = new d.C0000d(this.f1095a);
            }
            this.f1098d.e();
            this.f1100f = funAdInteractionListener;
            for (d.b bVar : this.f1095a.f1420c) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    n c2 = c(bVar, arrayList);
                    if (c2 != null) {
                        Result a2 = sVar.a(c2);
                        if (a2 != null && sVar.a((s<Result>) a2)) {
                            return a2;
                        }
                        arrayList.add(c2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.f1095a.f1419b);
            this.f1100f = null;
            b.a.a.a.x.d.f("showFailed for SerialSlotId(%s), because no ready loader found", this.f1095a.f1419b);
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // b.a.a.a.h
    public synchronized <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) d(funAdInteractionListener, new c(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes.dex */
    public class f implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f1121b;

        public f(k kVar, d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1121b = kVar;
            this.f1120a = aVar;
        }

        @Override // b.a.a.a.o
        public void a(int i2, String str) {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (kVar = this.f1121b).f1100f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(kVar.f1095a.f1419b);
        }

        @Override // b.a.a.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.a.a.o
        public void onAdClicked() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (kVar = this.f1121b).f1100f) == null) {
                return;
            }
            String str = kVar.f1095a.f1419b;
            h.a aVar = this.f1120a.f1424d;
            funAdInteractionListener.onAdClicked(str, aVar.l.f1445c, aVar.f1448c);
        }

        @Override // b.a.a.a.o
        public void onAdClose() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (kVar = this.f1121b).f1100f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(kVar.f1095a.f1419b);
        }

        @Override // b.a.a.a.o
        public void onAdShow() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (kVar = this.f1121b).f1100f) == null) {
                return;
            }
            String str = kVar.f1095a.f1419b;
            h.a aVar = this.f1120a.f1424d;
            funAdInteractionListener.onAdShow(str, aVar.l.f1445c, aVar.f1448c);
        }

        @Override // b.a.a.a.o
        public void onError(int i2, String str) {
            e eVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (eVar = this.f1121b.f1099e) == null) {
                return;
            }
            d.a aVar = this.f1120a;
            synchronized (eVar.f1119i) {
                if (eVar.f1119i.f1099e == eVar && eVar.f1115e.remove(aVar) && (funAdLoadListener = eVar.f1118h) != null) {
                    if (!eVar.f1113c.hasNext() && eVar.f1115e.isEmpty()) {
                        b.a.a.a.x.d.b("All loader load failed, callback onError(%s)", eVar.f1119i.f1095a.f1419b);
                        eVar.f1114d.f(eVar.f1117g, -103);
                        funAdLoadListener.onError(eVar.f1119i.f1095a.f1419b);
                        eVar.c();
                    } else if (eVar.f1115e.isEmpty()) {
                        eVar.f1119i.f1101g.removeMessages(100, eVar);
                        eVar.f1119i.f1101g.obtainMessage(100, eVar).sendToTarget();
                    }
                }
            }
        }

        @Override // b.a.a.a.o
        public void onLoaded() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (eVar = this.f1121b.f1099e) == null) {
                return;
            }
            eVar.b(this.f1120a);
        }

        @Override // b.a.a.a.o
        public void a() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (kVar = this.f1121b).f1100f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(kVar.f1095a.f1419b);
        }
    }
}
