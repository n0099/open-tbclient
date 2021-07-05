package a.a.a.a;

import a.a.a.a.v.c;
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
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class k implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.v.c f1055a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, n> f1056b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f1057c;

    /* renamed from: d  reason: collision with root package name */
    public d.C0006d f1058d;

    /* renamed from: e  reason: collision with root package name */
    public c f1059e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1060f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1061g;

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
                c cVar = (c) message.obj;
                if (cVar == null) {
                    a.a.a.a.y.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    cVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements s<c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1062a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f1063b;

        public b(k kVar, List list) {
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
            this.f1063b = kVar;
            this.f1062a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                n nVar = this.f1063b.f1056b.get(((c.a) obj).f1328d);
                List list = this.f1062a;
                return (list == null || !list.contains(nVar)) && nVar != null && nVar.c();
            }
            return invokeL.booleanValue;
        }
    }

    public k(a.a.a.a.v.c cVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1057c = new Random();
        this.f1061g = new a(this, Looper.getMainLooper());
        this.f1055a = cVar;
        HashMap hashMap = new HashMap();
        for (c.b bVar : cVar.f1325c) {
            for (c.a aVar : bVar.f1330c) {
                n a2 = pVar.a(aVar.f1328d);
                if (a2 != null) {
                    a2.a(new d(this, aVar));
                    hashMap.put(aVar.f1328d, a2);
                }
            }
        }
        this.f1056b = Collections.unmodifiableMap(hashMap);
    }

    public final n a(c.b bVar, List<n> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            c.a aVar = (c.a) a.a.a.a.a.a(this.f1057c, bVar.f1330c, new b(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f1056b.get(aVar.f1328d);
        }
        return (n) invokeLL.objValue;
    }

    @Override // a.a.a.a.g
    public FunNativeAd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            for (c.b bVar : this.f1055a.f1325c) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    n a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd nativeAd = a2.getNativeAd(context, this.f1055a.f1324b);
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

    @Override // a.a.a.a.g
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f1061g.removeMessages(100);
                c cVar = this.f1059e;
                if (cVar != null) {
                    cVar.b();
                }
                this.f1059e = null;
                this.f1060f = null;
                for (c.b bVar : this.f1055a.f1325c) {
                    for (c.a aVar : bVar.f1330c) {
                        n nVar = this.f1056b.get(aVar.f1328d);
                        if (nVar != null) {
                            nVar.a();
                        }
                    }
                }
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, activity, t, str, funAdInteractionListener, funNativeAdInflater) == null) {
            synchronized (this) {
                if (this.f1058d == null) {
                    this.f1058d = new d.C0006d(this.f1055a.f1324b);
                }
                this.f1058d.c();
                this.f1060f = funAdInteractionListener;
                for (c.b bVar : this.f1055a.f1325c) {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        n a2 = a(bVar, arrayList);
                        if (a2 != null) {
                            if (a2.a(activity, t, str, funNativeAdInflater)) {
                                return;
                            }
                            arrayList.add(a2);
                        }
                    }
                }
                funAdInteractionListener.onAdError(this.f1055a.f1324b);
                this.f1060f = null;
                a.a.a.a.y.d.b("showFailed for SerialSlotId(%s), because no ready loader found", this.f1055a.f1324b);
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                d.C0006d c0006d = new d.C0006d(this.f1055a.f1324b);
                this.f1061g.removeMessages(100);
                if (this.f1059e != null) {
                    c0006d.a(true);
                    this.f1059e.b();
                } else {
                    c0006d.a(false);
                }
                if (this.f1055a.f1325c.isEmpty()) {
                    a.a.a.a.y.d.b("No groups found in SerialSlotId(%s)", this.f1055a.f1324b);
                    c0006d.a(-1, -100);
                    funAdLoadListener.onError(this.f1055a.f1324b);
                    return;
                }
                this.f1058d = c0006d;
                c cVar = new c(this, context, funAdSlot, this.f1055a.f1325c.iterator(), funAdLoadListener, c0006d);
                this.f1059e = cVar;
                cVar.a();
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Iterator<c.b> it = this.f1055a.f1325c.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (c.a aVar : it.next().f1330c) {
                        n nVar = this.f1056b.get(aVar.f1328d);
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

    /* loaded from: classes.dex */
    public class d implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.a f1073a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f1074b;

        public d(k kVar, c.a aVar) {
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
            this.f1074b = kVar;
            this.f1073a = aVar;
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (kVar = this.f1074b).f1060f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(kVar.f1055a.f1324b);
        }

        @Override // a.a.a.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (kVar = this.f1074b).f1060f) == null) {
                return;
            }
            funAdInteractionListener.onAdClicked(kVar.f1055a.f1324b);
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (kVar = this.f1074b).f1060f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(kVar.f1055a.f1324b);
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (kVar = this.f1074b).f1060f) == null) {
                return;
            }
            funAdInteractionListener.onAdShow(kVar.f1055a.f1324b);
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            c cVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (cVar = this.f1074b.f1059e) == null) {
                return;
            }
            c.a aVar = this.f1073a;
            synchronized (cVar.f1072i) {
                if (cVar.f1072i.f1059e == cVar && cVar.f1068e.remove(aVar) && (funAdLoadListener = cVar.f1071h) != null) {
                    if (!cVar.f1066c.hasNext() && cVar.f1068e.isEmpty()) {
                        a.a.a.a.y.d.a("All loader load failed, callback onError(%s)", cVar.f1072i.f1055a.f1324b);
                        cVar.f1067d.a(cVar.f1070g, -103);
                        funAdLoadListener.onError(cVar.f1072i.f1055a.f1324b);
                        cVar.b();
                    } else if (cVar.f1068e.isEmpty()) {
                        cVar.f1072i.f1061g.removeMessages(100, cVar);
                        cVar.f1072i.f1061g.obtainMessage(100, cVar).sendToTarget();
                    }
                }
            }
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.f1074b.f1059e) == null) {
                return;
            }
            cVar.a(this.f1073a);
        }

        @Override // a.a.a.a.o
        public void a() {
            k kVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (kVar = this.f1074b).f1060f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(kVar.f1055a.f1324b);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1064a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1065b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<c.b> f1066c;

        /* renamed from: d  reason: collision with root package name */
        public final d.C0006d f1067d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<c.a> f1068e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1069f;

        /* renamed from: g  reason: collision with root package name */
        public int f1070g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f1071h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f1072i;

        public c(k kVar, Context context, FunAdSlot funAdSlot, Iterator<c.b> it, FunAdLoadListener funAdLoadListener, d.C0006d c0006d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, funAdSlot, it, funAdLoadListener, c0006d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1072i = kVar;
            this.f1068e = new HashSet<>();
            this.f1070g = 0;
            this.f1071h = funAdLoadListener;
            this.f1064a = context;
            this.f1065b = funAdSlot;
            this.f1066c = it;
            this.f1067d = c0006d;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1072i) {
                    FunAdLoadListener funAdLoadListener = this.f1071h;
                    if (this.f1069f) {
                        this.f1070g++;
                        this.f1069f = false;
                    }
                    int i2 = this.f1070g;
                    if (this.f1071h == null) {
                        a.a.a.a.y.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f1067d.a(i2, -1);
                    } else if (this.f1072i.f1059e != this) {
                        this.f1067d.a(i2, -101);
                        funAdLoadListener.onError(this.f1072i.f1055a.f1324b);
                        b();
                    } else if (!this.f1066c.hasNext() && this.f1068e.isEmpty()) {
                        this.f1067d.a(i2, -102);
                        a.a.a.a.y.d.a("All loader load failed, callback onError(%s)", this.f1072i.f1055a.f1324b);
                        funAdLoadListener.onError(this.f1072i.f1055a.f1324b);
                        b();
                    } else if (!this.f1066c.hasNext()) {
                        a.a.a.a.y.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        c.b next = this.f1066c.next();
                        this.f1069f = true;
                        if (next.f1330c.isEmpty()) {
                            a.a.a.a.y.d.b("There is an empty group in SerialSid(%s)", this.f1072i.f1055a.f1324b);
                            this.f1067d.a(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (c.a aVar : next.f1330c) {
                            n nVar = this.f1072i.f1056b.get(aVar.f1328d);
                            if (nVar != null) {
                                this.f1068e.add(aVar);
                                if (nVar.c()) {
                                    this.f1067d.a(i2, aVar.f1328d.f1346d, 0);
                                    a(aVar);
                                    return;
                                }
                                arrayList.add(nVar);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            a.a.a.a.y.d.b("No group which ready to load found in SerialSid(%s)", this.f1072i.f1055a.f1324b);
                            this.f1067d.a(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            n nVar2 = (n) it.next();
                            this.f1067d.a(i2, nVar2.b().f1346d, nVar2.a(this.f1064a, this.f1065b) ? 1 : 2);
                        }
                        this.f1072i.f1061g.removeMessages(100, this);
                        this.f1072i.f1061g.sendMessageDelayed(this.f1072i.f1061g.obtainMessage(100, this), next.f1329b);
                    }
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f1072i) {
                    this.f1072i.f1061g.removeMessages(100, this);
                    this.f1071h = null;
                    this.f1068e.clear();
                    if (this.f1072i.f1059e == this) {
                        this.f1072i.f1059e = null;
                    }
                }
            }
        }

        public void a(c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f1072i) {
                    if (this.f1072i.f1059e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f1071h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f1068e.remove(aVar)) {
                        d.C0006d c0006d = this.f1067d;
                        int i2 = this.f1070g;
                        String str = aVar.f1328d.f1346d;
                        if (c0006d != null) {
                            c0006d.a("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                            funAdLoadListener.onAdLoaded(this.f1072i.f1055a.f1324b);
                            b();
                            return;
                        }
                        throw null;
                    }
                }
            }
        }
    }
}
