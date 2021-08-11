package b.a.a.a;

import a.a.a.a.w.g.g.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.a.a.a.u.e;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public final class i implements b.a.a.a.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Random f1070a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.a.a.u.e f1071b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<h.a, n> f1072c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.w.g.g.d f1073d;

    /* renamed from: e  reason: collision with root package name */
    public final h f1074e;

    /* renamed from: f  reason: collision with root package name */
    public f f1075f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f1076g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1077h;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1078a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, looper};
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
            this.f1078a = iVar;
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
                    f fVar2 = this.f1078a.f1075f;
                    if (fVar2 == null || fVar2 != fVar || (funAdLoadListener = fVar.f1091c) == null) {
                        return;
                    }
                    b.a.a.a.u.e eVar = fVar.f1092d.f1071b;
                    b.a.a.a.x.d.f("callback onError(%s) because of timeout(%d)", eVar.f1427b, Long.valueOf(eVar.f1429d));
                    funAdLoadListener.onError(fVar.f1092d.f1071b.f1427b);
                    fVar.a();
                } else if (i2 == 101) {
                    f fVar3 = (f) message.obj;
                    f fVar4 = this.f1078a.f1075f;
                    if (fVar4 == null || fVar4 != fVar3) {
                        return;
                    }
                    synchronized (fVar3) {
                        synchronized (fVar3) {
                            Iterator<Map.Entry<e.b, Integer>> it = fVar3.f1089a.entrySet().iterator();
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
                        fVar3.d(fVar3.f1091c);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f1080f;

        public b(i iVar, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1080f = iVar;
            this.f1079e = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1079e.onAdError(this.f1080f.f1071b.f1427b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements s<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f1081a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1082b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1083c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInflater f1084d;

        public c(i iVar, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1081a = activity;
            this.f1082b = viewGroup;
            this.f1083c = str;
            this.f1084d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // b.a.a.a.s
        public Boolean a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) ? Boolean.valueOf(nVar.c(this.f1081a, this.f1082b, this.f1083c, this.f1084d)) : invokeL.objValue;
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
    public class d implements s<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f1085a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1086b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1087c;

        public d(i iVar, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1085a = activity;
            this.f1086b = viewGroup;
            this.f1087c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // b.a.a.a.s
        public FunSplashAd a(n nVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) ? nVar.b(this.f1085a, this.f1086b, this.f1087c) : invokeL.objValue;
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
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1088a;

        public e(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1088a = iVar;
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this(iVar);
        }

        public n a(boolean z, List<n> list) {
            InterceptResult invokeZL;
            b.a.a.a.w.p d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (e.b bVar : this.f1088a.f1071b.f1431f) {
                    for (e.a aVar : bVar.f1437c) {
                        n c2 = this.f1088a.c(aVar);
                        if (c2 != null && !list.contains(c2) && c2.c() && (!z || ((d2 = c2.d()) != null && d2.f1481a))) {
                            List list2 = (List) hashMap.get(bVar);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                hashMap.put(bVar, list2);
                            }
                            list2.add(aVar);
                        }
                    }
                }
                return this.f1088a.c((e.a) r.c(this.f1088a.f1070a, (List) hashMap.get((e.b) r.c(this.f1088a.f1070a, new ArrayList(hashMap.keySet()), null)), null));
            }
            return (n) invokeZL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<e.b, Integer> f1089a;

        /* renamed from: b  reason: collision with root package name */
        public long f1090b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f1091c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f1092d;

        public f(i iVar, FunAdLoadListener funAdLoadListener, List<e.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1092d = iVar;
            this.f1089a = new LinkedHashMap<>();
            this.f1091c = funAdLoadListener;
            for (e.a aVar : list) {
                this.f1089a.put(aVar.f1435e, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1091c = null;
                this.f1092d.f1077h.removeMessages(100, this);
                this.f1092d.f1077h.removeMessages(101, this);
            }
        }

        public synchronized void b(e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this) {
                    h.a aVar2 = aVar.f1434d;
                    b.a.a.a.x.d.b("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1435e.f1436b), aVar2.f1449d, aVar2.f1448c);
                    FunAdLoadListener funAdLoadListener = this.f1091c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    e.b bVar = aVar.f1435e;
                    if (this.f1089a.containsKey(bVar)) {
                        this.f1089a.put(bVar, 1);
                        if (this.f1092d.f1071b.f1428c > 0 && System.currentTimeMillis() - this.f1090b < this.f1092d.f1071b.f1428c) {
                            e(funAdLoadListener);
                            return;
                        }
                        d(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void c(e.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, str) == null) {
                synchronized (this) {
                    h.a aVar2 = aVar.f1434d;
                    b.a.a.a.x.d.b("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f1435e.f1436b), aVar2.f1449d, aVar2.f1448c);
                    if (this.f1089a.containsKey(aVar.f1435e)) {
                        this.f1089a.put(aVar.f1435e, -1);
                        FunAdLoadListener funAdLoadListener = this.f1091c;
                        if (funAdLoadListener == null) {
                            return;
                        }
                        e(funAdLoadListener);
                    }
                }
            }
        }

        public final void d(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f1092d.f1071b.f1427b);
            a();
        }

        public final synchronized void e(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, funAdLoadListener) == null) {
                synchronized (this) {
                    boolean z = true;
                    int i2 = -1;
                    for (Map.Entry<e.b, Integer> entry : this.f1089a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            e.b key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.f1436b;
                            } else if (i2 != key.f1436b) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    b.a.a.a.x.d.b("callback onAdLoaded(%s) because max priority adId is loaded", this.f1092d.f1071b.f1427b);
                                    d(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        b.a.a.a.x.d.f("callback onError(%s) as all group failed to load", this.f1092d.f1071b.f1427b);
                        funAdLoadListener.onError(this.f1092d.f1071b.f1427b);
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface h {
    }

    public i(b.a.a.a.u.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1070a = new Random();
        this.f1074e = new e(this, null);
        this.f1077h = new a(this, Looper.getMainLooper());
        this.f1071b = eVar;
        this.f1073d = new d.c(eVar);
        HashMap hashMap = new HashMap();
        for (e.b bVar : this.f1071b.f1431f) {
            for (e.a aVar : bVar.f1437c) {
                n a2 = pVar.a(aVar.f1434d);
                if (a2 != null) {
                    a2.d(new g(this, aVar));
                    hashMap.put(aVar.f1434d, a2);
                }
            }
        }
        this.f1072c = Collections.unmodifiableMap(hashMap);
    }

    @Override // b.a.a.a.h
    public FunNativeAd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, context)) != null) {
            return (FunNativeAd) invokeL.objValue;
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            n a2 = ((e) this.f1074e).a(z, arrayList);
            if (a2 == null) {
                b.a.a.a.x.d.f("getNativeAd for sid:%s with No ready pidLoader found", this.f1071b.f1427b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1071b.f1427b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // b.a.a.a.h
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f1077h.removeMessages(100);
                this.f1076g = null;
                f fVar = this.f1075f;
                if (fVar != null) {
                    fVar.a();
                    this.f1075f = null;
                }
                for (n nVar : this.f1072c.values()) {
                    nVar.a();
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
                Boolean bool = (Boolean) d(funAdInteractionListener, new c(this, activity, t, str, funNativeAdInflater));
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
        boolean z;
        n c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.f1073d.d();
                this.f1077h.removeMessages(101);
                this.f1077h.removeMessages(100);
                b.a.a.a.u.e eVar = this.f1071b;
                ArrayList arrayList = null;
                if (eVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (e.b bVar : eVar.f1431f) {
                        e.a aVar = (e.a) r.c(this.f1070a, bVar.f1437c, null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new j(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    f fVar = new f(this, funAdLoadListener, arrayList);
                    this.f1075f = fVar;
                    fVar.f1090b = System.currentTimeMillis();
                    Message obtainMessage = fVar.f1092d.f1077h.obtainMessage(100);
                    obtainMessage.obj = fVar;
                    i iVar = fVar.f1092d;
                    iVar.f1077h.sendMessageDelayed(obtainMessage, iVar.f1071b.f1429d);
                    i iVar2 = fVar.f1092d;
                    if (iVar2.f1071b.f1428c > 0) {
                        Message obtainMessage2 = iVar2.f1077h.obtainMessage(101);
                        obtainMessage2.obj = fVar;
                        i iVar3 = fVar.f1092d;
                        iVar3.f1077h.sendMessageDelayed(obtainMessage2, iVar3.f1071b.f1428c);
                    }
                    b.a.a.a.x.d.b("Start load for sid:%s", eVar.f1427b);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        e.a aVar2 = (e.a) arrayList.get(i2);
                        n c3 = c(aVar2);
                        if (c3 == null) {
                            z = true;
                        } else if (c3.c()) {
                            fVar.b(aVar2);
                        } else {
                            c3.a(context, funAdSlot);
                            z = false;
                        }
                        Iterator<e.a> it = aVar2.f1435e.f1437c.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e.a next = it.next();
                            if (next != aVar2 && (c2 = c(next)) != null && c2.c()) {
                                fVar.b(next);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            fVar.c(aVar2, 0, "F1:No ready loader found");
                        }
                    }
                    return;
                }
                b.a.a.a.x.d.f("No selected adIds found for sid:%s", eVar.f1427b);
                funAdLoadListener.onError(eVar.f1427b);
            }
        }
    }

    @Override // b.a.a.a.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (n nVar : this.f1072c.values()) {
                if (nVar.c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final n c(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f1072c.get(aVar.f1434d);
        }
        return (n) invokeL.objValue;
    }

    public final <Result> Result d(FunAdInteractionListener funAdInteractionListener, s<Result> sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, funAdInteractionListener, sVar)) == null) {
            this.f1073d.e();
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            ArrayList arrayList = new ArrayList();
            n a2 = ((e) this.f1074e).a(z, arrayList);
            this.f1076g = funAdInteractionListener;
            while (a2 != null) {
                Result a3 = sVar.a(a2);
                if (a3 != null && sVar.a((s<Result>) a3)) {
                    return a3;
                }
                arrayList.add(a2);
                a2 = ((e) this.f1074e).a(z, arrayList);
            }
            b.a.a.a.x.d.f("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1071b.f1427b);
            this.f1077h.post(new b(this, funAdInteractionListener));
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
                funSplashAd = (FunSplashAd) d(funAdInteractionListener, new d(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes.dex */
    public class g implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f1093a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f1094b;

        public g(i iVar, e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1094b = iVar;
            this.f1093a = aVar;
        }

        @Override // b.a.a.a.o
        public void a(int i2, String str) {
            i iVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (iVar = this.f1094b).f1076g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(iVar.f1071b.f1427b);
        }

        @Override // b.a.a.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.a.a.o
        public void onAdClicked() {
            i iVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (iVar = this.f1094b).f1076g) == null) {
                return;
            }
            String str = iVar.f1071b.f1427b;
            h.a aVar = this.f1093a.f1434d;
            funAdInteractionListener.onAdClicked(str, aVar.l.f1445c, aVar.f1448c);
        }

        @Override // b.a.a.a.o
        public void onAdClose() {
            i iVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (iVar = this.f1094b).f1076g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(iVar.f1071b.f1427b);
        }

        @Override // b.a.a.a.o
        public void onAdShow() {
            i iVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (iVar = this.f1094b).f1076g) == null) {
                return;
            }
            String str = iVar.f1071b.f1427b;
            h.a aVar = this.f1093a.f1434d;
            funAdInteractionListener.onAdShow(str, aVar.l.f1445c, aVar.f1448c);
        }

        @Override // b.a.a.a.o
        public void onError(int i2, String str) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (fVar = this.f1094b.f1075f) == null) {
                return;
            }
            fVar.c(this.f1093a, i2, str);
        }

        @Override // b.a.a.a.o
        public void onLoaded() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (fVar = this.f1094b.f1075f) == null) {
                return;
            }
            fVar.b(this.f1093a);
        }

        @Override // b.a.a.a.o
        public void a() {
            i iVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (iVar = this.f1094b).f1076g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(iVar.f1071b.f1427b);
        }
    }
}
