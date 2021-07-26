package a.a.a.a;

import a.a.a.a.q;
import a.a.a.a.s.e;
import a.a.a.a.s.h;
import a.a.a.a.v.g.g.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public final class h implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Random f1028a;

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.s.e f1029b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<h.a, m> f1030c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.v.g.g.d f1031d;

    /* renamed from: e  reason: collision with root package name */
    public final f f1032e;

    /* renamed from: f  reason: collision with root package name */
    public d f1033f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f1034g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1035h;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f1036a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, looper};
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
            this.f1036a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                boolean z = false;
                if (i2 == 100) {
                    d dVar = (d) message.obj;
                    d dVar2 = this.f1036a.f1033f;
                    if (dVar2 == null || dVar2 != dVar || (funAdLoadListener = dVar.f1042c) == null) {
                        return;
                    }
                    a.a.a.a.s.e eVar = dVar.f1043d.f1029b;
                    a.a.a.a.v.d.b("callback onError(%s) because of timeout(%d)", eVar.f1340b, Long.valueOf(eVar.f1342d));
                    funAdLoadListener.onError(dVar.f1043d.f1029b.f1340b);
                    dVar.a();
                } else if (i2 == 101) {
                    d dVar3 = (d) message.obj;
                    d dVar4 = this.f1036a.f1033f;
                    if (dVar4 == null || dVar4 != dVar3) {
                        return;
                    }
                    synchronized (dVar3) {
                        synchronized (dVar3) {
                            Iterator<Map.Entry<e.b, Integer>> it = dVar3.f1040a.entrySet().iterator();
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
                        dVar3.a(dVar3.f1042c);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1038b;

        public b(h hVar, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1038b = hVar;
            this.f1037a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1037a.onAdError(this.f1038b.f1029b.f1340b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f1039a;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1039a = hVar;
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this(hVar);
        }

        public m a(boolean z, List<m> list) {
            InterceptResult invokeZL;
            a.a.a.a.u.p d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (e.b bVar : this.f1039a.f1029b.f1344f) {
                    for (e.a aVar : bVar.f1350c) {
                        m a2 = this.f1039a.a(aVar);
                        if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((d2 = a2.d()) != null && d2.f1393a))) {
                            List list2 = (List) hashMap.get(bVar);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                hashMap.put(bVar, list2);
                            }
                            list2.add(aVar);
                        }
                    }
                }
                return this.f1039a.a((e.a) q.a(this.f1039a.f1028a, (List) hashMap.get((e.b) q.a(this.f1039a.f1028a, new ArrayList(hashMap.keySet()), (q.b<p>) null)), (q.b<p>) null));
            }
            return (m) invokeZL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    public h(a.a.a.a.s.e eVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1028a = new Random();
        this.f1032e = new c(this, null);
        this.f1035h = new a(this, Looper.getMainLooper());
        this.f1029b = eVar;
        this.f1031d = new d.c(eVar);
        HashMap hashMap = new HashMap();
        for (e.b bVar : this.f1029b.f1344f) {
            for (e.a aVar : bVar.f1350c) {
                m a2 = oVar.a(aVar.f1347d);
                if (a2 != null) {
                    a2.a(new e(this, aVar));
                    hashMap.put(aVar.f1347d, a2);
                }
            }
        }
        this.f1030c = Collections.unmodifiableMap(hashMap);
    }

    public final m a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f1030c.get(aVar.f1347d);
        }
        return (m) invokeL.objValue;
    }

    @Override // a.a.a.a.g
    public FunNativeAd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) != null) {
            return (FunNativeAd) invokeL.objValue;
        }
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            m a2 = ((c) this.f1032e).a(z, arrayList);
            if (a2 == null) {
                a.a.a.a.v.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.f1029b.f1340b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1029b.f1340b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f1035h.removeMessages(100);
                this.f1034g = null;
                d dVar = this.f1033f;
                if (dVar != null) {
                    dVar.a();
                    this.f1033f = null;
                }
                for (m mVar : this.f1030c.values()) {
                    mVar.a();
                }
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        m a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.f1031d.b();
                this.f1035h.removeMessages(101);
                this.f1035h.removeMessages(100);
                a.a.a.a.s.e eVar = this.f1029b;
                ArrayList arrayList = null;
                if (eVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (e.b bVar : eVar.f1344f) {
                        e.a aVar = (e.a) q.a(this.f1028a, bVar.f1350c, (q.b<p>) null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new i(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    d dVar = new d(this, funAdLoadListener, arrayList);
                    this.f1033f = dVar;
                    dVar.f1041b = System.currentTimeMillis();
                    Message obtainMessage = dVar.f1043d.f1035h.obtainMessage(100);
                    obtainMessage.obj = dVar;
                    h hVar = dVar.f1043d;
                    hVar.f1035h.sendMessageDelayed(obtainMessage, hVar.f1029b.f1342d);
                    h hVar2 = dVar.f1043d;
                    if (hVar2.f1029b.f1341c > 0) {
                        Message obtainMessage2 = hVar2.f1035h.obtainMessage(101);
                        obtainMessage2.obj = dVar;
                        h hVar3 = dVar.f1043d;
                        hVar3.f1035h.sendMessageDelayed(obtainMessage2, hVar3.f1029b.f1341c);
                    }
                    a.a.a.a.v.d.a("Start load for sid:%s", eVar.f1340b);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        e.a aVar2 = (e.a) arrayList.get(i2);
                        m a3 = a(aVar2);
                        if (a3 == null) {
                            z = true;
                        } else if (a3.c()) {
                            dVar.a(aVar2);
                        } else {
                            a3.a(context, funAdSlot);
                            z = false;
                        }
                        Iterator<e.a> it = aVar2.f1348e.f1350c.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e.a next = it.next();
                            if (next != aVar2 && (a2 = a(next)) != null && a2.c()) {
                                dVar.a(next);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            dVar.a(aVar2, 0, "F1:No ready loader found");
                        }
                    }
                    return;
                }
                a.a.a.a.v.d.b("No selected adIds found for sid:%s", eVar.f1340b);
                funAdLoadListener.onError(eVar.f1340b);
            }
        }
    }

    @Override // a.a.a.a.g
    public <T extends ViewGroup> boolean a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            this.f1031d.c();
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            ArrayList arrayList = new ArrayList();
            m a2 = ((c) this.f1032e).a(z, arrayList);
            this.f1034g = funAdInteractionListener;
            while (a2 != null) {
                if (a2.a(activity, t, str, funNativeAdInflater)) {
                    return true;
                }
                arrayList.add(a2);
                a2 = ((c) this.f1032e).a(z, arrayList);
            }
            a.a.a.a.v.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1029b.f1340b);
            this.f1035h.post(new b(this, funAdInteractionListener));
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // a.a.a.a.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (m mVar : this.f1030c.values()) {
                if (mVar.c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<e.b, Integer> f1040a;

        /* renamed from: b  reason: collision with root package name */
        public long f1041b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f1042c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f1043d;

        public d(h hVar, FunAdLoadListener funAdLoadListener, List<e.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1043d = hVar;
            this.f1040a = new LinkedHashMap<>();
            this.f1042c = funAdLoadListener;
            for (e.a aVar : list) {
                this.f1040a.put(aVar.f1348e, 0);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f1043d.f1029b.f1340b);
            a();
        }

        public final synchronized void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, funAdLoadListener) == null) {
                synchronized (this) {
                    boolean z = true;
                    int i2 = -1;
                    for (Map.Entry<e.b, Integer> entry : this.f1040a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            e.b key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.f1349b;
                            } else if (i2 != key.f1349b) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    a.a.a.a.v.d.a("callback onAdLoaded(%s) because max priority adId is loaded", this.f1043d.f1029b.f1340b);
                                    a(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        a.a.a.a.v.d.b("callback onError(%s) as all group failed to load", this.f1043d.f1029b.f1340b);
                        funAdLoadListener.onError(this.f1043d.f1029b.f1340b);
                    }
                }
            }
        }

        public synchronized void a(e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this) {
                    h.a aVar2 = aVar.f1347d;
                    a.a.a.a.v.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1348e.f1349b), aVar2.f1362d, aVar2.f1361c);
                    FunAdLoadListener funAdLoadListener = this.f1042c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    e.b bVar = aVar.f1348e;
                    if (this.f1040a.containsKey(bVar)) {
                        this.f1040a.put(bVar, 1);
                        if (this.f1043d.f1029b.f1341c > 0 && System.currentTimeMillis() - this.f1041b < this.f1043d.f1029b.f1341c) {
                            b(funAdLoadListener);
                            return;
                        }
                        a(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void a(e.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, str) == null) {
                synchronized (this) {
                    h.a aVar2 = aVar.f1347d;
                    a.a.a.a.v.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f1348e.f1349b), aVar2.f1362d, aVar2.f1361c);
                    if (this.f1040a.containsKey(aVar.f1348e)) {
                        this.f1040a.put(aVar.f1348e, -1);
                        FunAdLoadListener funAdLoadListener = this.f1042c;
                        if (funAdLoadListener == null) {
                            return;
                        }
                        b(funAdLoadListener);
                    }
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1042c = null;
                this.f1043d.f1035h.removeMessages(100, this);
                this.f1043d.f1035h.removeMessages(101, this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f1044a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1045b;

        public e(h hVar, e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1045b = hVar;
            this.f1044a = aVar;
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (hVar = this.f1045b).f1034g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(hVar.f1029b.f1340b);
        }

        @Override // a.a.a.a.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (hVar = this.f1045b).f1034g) == null) {
                return;
            }
            String str = hVar.f1029b.f1340b;
            h.a aVar = this.f1044a.f1347d;
            funAdInteractionListener.onAdClicked(str, aVar.l.f1358c, aVar.f1361c);
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (hVar = this.f1045b).f1034g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(hVar.f1029b.f1340b);
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (hVar = this.f1045b).f1034g) == null) {
                return;
            }
            String str = hVar.f1029b.f1340b;
            h.a aVar = this.f1044a.f1347d;
            funAdInteractionListener.onAdShow(str, aVar.l.f1358c, aVar.f1361c);
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (dVar = this.f1045b.f1033f) == null) {
                return;
            }
            dVar.a(this.f1044a, i2, str);
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f1045b.f1033f) == null) {
                return;
            }
            dVar.a(this.f1044a);
        }

        @Override // a.a.a.a.n
        public void a() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (hVar = this.f1045b).f1034g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(hVar.f1029b.f1340b);
        }
    }
}
