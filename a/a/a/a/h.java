package a.a.a.a;

import a.a.a.a.v.d;
import a.a.a.a.v.e;
import a.a.a.a.y.f.g.d;
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
    public final Random f1029a;

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.v.d f1030b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.a, n> f1031c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.y.f.g.d f1032d;

    /* renamed from: e  reason: collision with root package name */
    public final f f1033e;

    /* renamed from: f  reason: collision with root package name */
    public d f1034f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f1035g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1036h;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f1037a;

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
            this.f1037a = hVar;
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
                    d dVar2 = this.f1037a.f1034f;
                    if (dVar2 == null || dVar2 != dVar || (funAdLoadListener = dVar.f1043c) == null) {
                        return;
                    }
                    a.a.a.a.v.d dVar3 = dVar.f1044d.f1030b;
                    a.a.a.a.y.d.b("callback onError(%s) because of timeout(%d)", dVar3.f1331b, Long.valueOf(dVar3.f1333d));
                    funAdLoadListener.onError(dVar.f1044d.f1030b.f1331b);
                    dVar.a();
                } else if (i2 == 101) {
                    d dVar4 = (d) message.obj;
                    d dVar5 = this.f1037a.f1034f;
                    if (dVar5 == null || dVar5 != dVar4) {
                        return;
                    }
                    synchronized (dVar4) {
                        synchronized (dVar4) {
                            Iterator<Map.Entry<d.b, Integer>> it = dVar4.f1041a.entrySet().iterator();
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
                        dVar4.a(dVar4.f1043c);
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
        public final /* synthetic */ FunAdInteractionListener f1038a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1039b;

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
            this.f1039b = hVar;
            this.f1038a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1038a.onAdError(this.f1039b.f1030b.f1331b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f1040a;

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
            this.f1040a = hVar;
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this(hVar);
        }

        public n a(boolean z, List<n> list) {
            InterceptResult invokeZL;
            a.a.a.a.x.p d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, list)) == null) {
                HashMap hashMap = new HashMap();
                for (d.b bVar : this.f1040a.f1030b.f1334e) {
                    for (d.a aVar : bVar.f1340c) {
                        n a2 = this.f1040a.a(aVar);
                        if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((d2 = a2.d()) != null && d2.f1369a))) {
                            List list2 = (List) hashMap.get(bVar);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                hashMap.put(bVar, list2);
                            }
                            list2.add(aVar);
                        }
                    }
                }
                return this.f1040a.a((d.a) a.a.a.a.a.a(this.f1040a.f1029a, (List) hashMap.get((d.b) a.a.a.a.a.a(this.f1040a.f1029a, new ArrayList(hashMap.keySet()), (s<q>) null)), (s<q>) null));
            }
            return (n) invokeZL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    public h(a.a.a.a.v.d dVar, p pVar) {
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
        this.f1029a = new Random();
        this.f1033e = new c(this, null);
        this.f1036h = new a(this, Looper.getMainLooper());
        this.f1030b = dVar;
        this.f1032d = new d.c(dVar.f1331b);
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1030b.f1334e) {
            for (d.a aVar : bVar.f1340c) {
                n a2 = pVar.a(aVar.f1337d);
                if (a2 != null) {
                    a2.a(new e(this, aVar));
                    hashMap.put(aVar.f1337d, a2);
                }
            }
        }
        this.f1031c = Collections.unmodifiableMap(hashMap);
    }

    public final n a(d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return this.f1031c.get(aVar.f1337d);
        }
        return (n) invokeL.objValue;
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
            n a2 = ((c) this.f1033e).a(z, arrayList);
            if (a2 == null) {
                a.a.a.a.y.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.f1030b.f1331b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1030b.f1331b);
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
                this.f1036h.removeMessages(100);
                this.f1035g = null;
                d dVar = this.f1034f;
                if (dVar != null) {
                    dVar.a();
                    this.f1034f = null;
                }
                for (n nVar : this.f1031c.values()) {
                    nVar.a();
                }
            }
        }
    }

    @Override // a.a.a.a.g
    public <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, activity, t, str, funAdInteractionListener, funNativeAdInflater) == null) {
            this.f1032d.c();
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            ArrayList arrayList = new ArrayList();
            n a2 = ((c) this.f1033e).a(z, arrayList);
            this.f1035g = funAdInteractionListener;
            while (a2 != null) {
                if (a2.a(activity, t, str, funNativeAdInflater)) {
                    return;
                }
                arrayList.add(a2);
                a2 = ((c) this.f1033e).a(z, arrayList);
            }
            a.a.a.a.y.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1030b.f1331b);
            this.f1036h.post(new b(this, funAdInteractionListener));
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        n a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.f1032d.b();
                this.f1036h.removeMessages(101);
                this.f1036h.removeMessages(100);
                a.a.a.a.v.d dVar = this.f1030b;
                ArrayList arrayList = null;
                if (dVar != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (d.b bVar : dVar.f1334e) {
                        d.a aVar = (d.a) a.a.a.a.a.a(this.f1029a, bVar.f1340c, (s<q>) null);
                        if (aVar != null) {
                            arrayList2.add(aVar);
                        }
                    }
                    Collections.sort(arrayList2, new i(this));
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    d dVar2 = new d(this, funAdLoadListener, arrayList);
                    this.f1034f = dVar2;
                    dVar2.f1042b = System.currentTimeMillis();
                    Message obtainMessage = dVar2.f1044d.f1036h.obtainMessage(100);
                    obtainMessage.obj = dVar2;
                    h hVar = dVar2.f1044d;
                    hVar.f1036h.sendMessageDelayed(obtainMessage, hVar.f1030b.f1333d);
                    h hVar2 = dVar2.f1044d;
                    if (hVar2.f1030b.f1332c > 0) {
                        Message obtainMessage2 = hVar2.f1036h.obtainMessage(101);
                        obtainMessage2.obj = dVar2;
                        h hVar3 = dVar2.f1044d;
                        hVar3.f1036h.sendMessageDelayed(obtainMessage2, hVar3.f1030b.f1332c);
                    }
                    a.a.a.a.y.d.a("Start load for sid:%s", dVar.f1331b);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        d.a aVar2 = (d.a) arrayList.get(i2);
                        n a3 = a(aVar2);
                        if (a3 == null) {
                            z = true;
                        } else if (a3.c()) {
                            dVar2.a(aVar2);
                        } else {
                            a3.a(context, funAdSlot);
                            z = false;
                        }
                        Iterator<d.a> it = aVar2.f1338e.f1340c.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d.a next = it.next();
                            if (next != aVar2 && (a2 = a(next)) != null && a2.c()) {
                                dVar2.a(next);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            dVar2.a(aVar2, 0, "F1:No ready loader found");
                        }
                    }
                    return;
                }
                a.a.a.a.y.d.b("No selected adIds found for sid:%s", dVar.f1331b);
                funAdLoadListener.onError(dVar.f1331b);
            }
        }
    }

    @Override // a.a.a.a.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (n nVar : this.f1031c.values()) {
                if (nVar.c()) {
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
        public final LinkedHashMap<d.b, Integer> f1041a;

        /* renamed from: b  reason: collision with root package name */
        public long f1042b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f1043c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f1044d;

        public d(h hVar, FunAdLoadListener funAdLoadListener, List<d.a> list) {
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
            this.f1044d = hVar;
            this.f1041a = new LinkedHashMap<>();
            this.f1043c = funAdLoadListener;
            for (d.a aVar : list) {
                this.f1041a.put(aVar.f1338e, 0);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.f1044d.f1030b.f1331b);
            a();
        }

        public final synchronized void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, funAdLoadListener) == null) {
                synchronized (this) {
                    boolean z = true;
                    int i2 = -1;
                    for (Map.Entry<d.b, Integer> entry : this.f1041a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            d.b key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.f1339b;
                            } else if (i2 != key.f1339b) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    a.a.a.a.y.d.a("callback onAdLoaded(%s) because max priority adId is loaded", this.f1044d.f1030b.f1331b);
                                    a(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        a.a.a.a.y.d.b("callback onError(%s) as all group failed to load", this.f1044d.f1030b.f1331b);
                        funAdLoadListener.onError(this.f1044d.f1030b.f1331b);
                    }
                }
            }
        }

        public synchronized void a(d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this) {
                    e.a aVar2 = aVar.f1337d;
                    a.a.a.a.y.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1338e.f1339b), aVar2.f1346d, aVar2.f1345c);
                    FunAdLoadListener funAdLoadListener = this.f1043c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    d.b bVar = aVar.f1338e;
                    if (this.f1041a.containsKey(bVar)) {
                        this.f1041a.put(bVar, 1);
                        if (this.f1044d.f1030b.f1332c > 0 && System.currentTimeMillis() - this.f1042b < this.f1044d.f1030b.f1332c) {
                            b(funAdLoadListener);
                            return;
                        }
                        a(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void a(d.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, str) == null) {
                synchronized (this) {
                    e.a aVar2 = aVar.f1337d;
                    a.a.a.a.y.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f1338e.f1339b), aVar2.f1346d, aVar2.f1345c);
                    if (this.f1041a.containsKey(aVar.f1338e)) {
                        this.f1041a.put(aVar.f1338e, -1);
                        FunAdLoadListener funAdLoadListener = this.f1043c;
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
                this.f1043c = null;
                this.f1044d.f1036h.removeMessages(100, this);
                this.f1044d.f1036h.removeMessages(101, this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1045a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1046b;

        public e(h hVar, d.a aVar) {
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
            this.f1046b = hVar;
            this.f1045a = aVar;
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (hVar = this.f1046b).f1035g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(hVar.f1030b.f1331b);
        }

        @Override // a.a.a.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (hVar = this.f1046b).f1035g) == null) {
                return;
            }
            funAdInteractionListener.onAdClicked(hVar.f1030b.f1331b);
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (hVar = this.f1046b).f1035g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(hVar.f1030b.f1331b);
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (hVar = this.f1046b).f1035g) == null) {
                return;
            }
            funAdInteractionListener.onAdShow(hVar.f1030b.f1331b);
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (dVar = this.f1046b.f1034f) == null) {
                return;
            }
            dVar.a(this.f1045a, i2, str);
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f1046b.f1034f) == null) {
                return;
            }
            dVar.a(this.f1045a);
        }

        @Override // a.a.a.a.o
        public void a() {
            h hVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (hVar = this.f1046b).f1035g) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(hVar.f1030b.f1331b);
        }
    }
}
