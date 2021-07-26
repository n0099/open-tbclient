package a.a.a.a;

import a.a.a.a.q;
import a.a.a.a.s.d;
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
public class j implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.s.d f1046a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<h.a, m> f1047b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f1048c;

    /* renamed from: d  reason: collision with root package name */
    public d.C0006d f1049d;

    /* renamed from: e  reason: collision with root package name */
    public c f1050e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1051f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1052g;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, looper};
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
                    a.a.a.a.v.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    cVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements q.b<d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f1054b;

        public b(j jVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1054b = jVar;
            this.f1053a = list;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                m mVar = this.f1054b.f1047b.get(((d.a) obj).f1337d);
                List list = this.f1053a;
                return (list == null || !list.contains(mVar)) && mVar != null && mVar.c();
            }
            return invokeL.booleanValue;
        }
    }

    public j(a.a.a.a.s.d dVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1048c = new Random();
        this.f1052g = new a(this, Looper.getMainLooper());
        this.f1046a = dVar;
        HashMap hashMap = new HashMap();
        for (d.b bVar : dVar.f1333c) {
            for (d.a aVar : bVar.f1339c) {
                m a2 = oVar.a(aVar.f1337d);
                if (a2 != null) {
                    a2.a(new d(this, aVar));
                    hashMap.put(aVar.f1337d, a2);
                }
            }
        }
        this.f1047b = Collections.unmodifiableMap(hashMap);
    }

    public final m a(d.b bVar, List<m> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            d.a aVar = (d.a) q.a(this.f1048c, bVar.f1339c, new b(this, list));
            if (aVar == null) {
                return null;
            }
            return this.f1047b.get(aVar.f1337d);
        }
        return (m) invokeLL.objValue;
    }

    @Override // a.a.a.a.g
    public FunNativeAd a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            for (d.b bVar : this.f1046a.f1333c) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    m a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd nativeAd = a2.getNativeAd(context, this.f1046a.f1332b);
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
                this.f1052g.removeMessages(100);
                c cVar = this.f1050e;
                if (cVar != null) {
                    cVar.b();
                }
                this.f1050e = null;
                this.f1051f = null;
                for (d.b bVar : this.f1046a.f1333c) {
                    for (d.a aVar : bVar.f1339c) {
                        m mVar = this.f1047b.get(aVar.f1337d);
                        if (mVar != null) {
                            mVar.a();
                        }
                    }
                }
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                d.C0006d c0006d = new d.C0006d(this.f1046a);
                this.f1052g.removeMessages(100);
                if (this.f1050e != null) {
                    c0006d.a(true);
                    this.f1050e.b();
                } else {
                    c0006d.a(false);
                }
                if (this.f1046a.f1333c.isEmpty()) {
                    a.a.a.a.v.d.b("No groups found in SerialSlotId(%s)", this.f1046a.f1332b);
                    c0006d.a(-1, -100);
                    funAdLoadListener.onError(this.f1046a.f1332b);
                    return;
                }
                this.f1049d = c0006d;
                c cVar = new c(this, context, funAdSlot, this.f1046a.f1333c.iterator(), funAdLoadListener, c0006d);
                this.f1050e = cVar;
                cVar.a();
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized <T extends ViewGroup> boolean a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (this.f1049d == null) {
                    this.f1049d = new d.C0006d(this.f1046a);
                }
                this.f1049d.c();
                this.f1051f = funAdInteractionListener;
                for (d.b bVar : this.f1046a.f1333c) {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        m a2 = a(bVar, arrayList);
                        if (a2 != null) {
                            if (a2.a(activity, t, str, funNativeAdInflater)) {
                                return true;
                            }
                            arrayList.add(a2);
                        }
                    }
                }
                funAdInteractionListener.onAdError(this.f1046a.f1332b);
                this.f1051f = null;
                a.a.a.a.v.d.b("showFailed for SerialSlotId(%s), because no ready loader found", this.f1046a.f1332b);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // a.a.a.a.g
    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Iterator<d.b> it = this.f1046a.f1333c.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (d.a aVar : it.next().f1339c) {
                        m mVar = this.f1047b.get(aVar.f1337d);
                        if (mVar != null && mVar.c()) {
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
    public class d implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1064a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f1065b;

        public d(j jVar, d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1065b = jVar;
            this.f1064a = aVar;
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            j jVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (funAdInteractionListener = (jVar = this.f1065b).f1051f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(jVar.f1046a.f1332b);
        }

        @Override // a.a.a.a.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            j jVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (funAdInteractionListener = (jVar = this.f1065b).f1051f) == null) {
                return;
            }
            String str = jVar.f1046a.f1332b;
            h.a aVar = this.f1064a.f1337d;
            funAdInteractionListener.onAdClicked(str, aVar.l.f1358c, aVar.f1361c);
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            j jVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (funAdInteractionListener = (jVar = this.f1065b).f1051f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(jVar.f1046a.f1332b);
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            j jVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (funAdInteractionListener = (jVar = this.f1065b).f1051f) == null) {
                return;
            }
            String str = jVar.f1046a.f1332b;
            h.a aVar = this.f1064a.f1337d;
            funAdInteractionListener.onAdShow(str, aVar.l.f1358c, aVar.f1361c);
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            c cVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (cVar = this.f1065b.f1050e) == null) {
                return;
            }
            d.a aVar = this.f1064a;
            synchronized (cVar.f1063i) {
                if (cVar.f1063i.f1050e == cVar && cVar.f1059e.remove(aVar) && (funAdLoadListener = cVar.f1062h) != null) {
                    if (!cVar.f1057c.hasNext() && cVar.f1059e.isEmpty()) {
                        a.a.a.a.v.d.a("All loader load failed, callback onError(%s)", cVar.f1063i.f1046a.f1332b);
                        cVar.f1058d.a(cVar.f1061g, -103);
                        funAdLoadListener.onError(cVar.f1063i.f1046a.f1332b);
                        cVar.b();
                    } else if (cVar.f1059e.isEmpty()) {
                        cVar.f1063i.f1052g.removeMessages(100, cVar);
                        cVar.f1063i.f1052g.obtainMessage(100, cVar).sendToTarget();
                    }
                }
            }
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.f1065b.f1050e) == null) {
                return;
            }
            cVar.a(this.f1064a);
        }

        @Override // a.a.a.a.n
        public void a() {
            j jVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (jVar = this.f1065b).f1051f) == null) {
                return;
            }
            funAdInteractionListener.onRewardedVideo(jVar.f1046a.f1332b);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1055a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1056b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<d.b> f1057c;

        /* renamed from: d  reason: collision with root package name */
        public final d.C0006d f1058d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<d.a> f1059e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1060f;

        /* renamed from: g  reason: collision with root package name */
        public int f1061g;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f1062h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ j f1063i;

        public c(j jVar, Context context, FunAdSlot funAdSlot, Iterator<d.b> it, FunAdLoadListener funAdLoadListener, d.C0006d c0006d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, context, funAdSlot, it, funAdLoadListener, c0006d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1063i = jVar;
            this.f1059e = new HashSet<>();
            this.f1061g = 0;
            this.f1062h = funAdLoadListener;
            this.f1055a = context;
            this.f1056b = funAdSlot;
            this.f1057c = it;
            this.f1058d = c0006d;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1063i) {
                    FunAdLoadListener funAdLoadListener = this.f1062h;
                    if (this.f1060f) {
                        this.f1061g++;
                        this.f1060f = false;
                    }
                    int i2 = this.f1061g;
                    if (this.f1062h == null) {
                        a.a.a.a.v.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.f1058d.a(i2, -1);
                    } else if (this.f1063i.f1050e != this) {
                        this.f1058d.a(i2, -101);
                        funAdLoadListener.onError(this.f1063i.f1046a.f1332b);
                        b();
                    } else if (!this.f1057c.hasNext() && this.f1059e.isEmpty()) {
                        this.f1058d.a(i2, -102);
                        a.a.a.a.v.d.a("All loader load failed, callback onError(%s)", this.f1063i.f1046a.f1332b);
                        funAdLoadListener.onError(this.f1063i.f1046a.f1332b);
                        b();
                    } else if (!this.f1057c.hasNext()) {
                        a.a.a.a.v.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        d.b next = this.f1057c.next();
                        this.f1060f = true;
                        if (next.f1339c.isEmpty()) {
                            a.a.a.a.v.d.b("There is an empty group in SerialSid(%s)", this.f1063i.f1046a.f1332b);
                            this.f1058d.a(i2, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (d.a aVar : next.f1339c) {
                            m mVar = this.f1063i.f1047b.get(aVar.f1337d);
                            if (mVar != null) {
                                this.f1059e.add(aVar);
                                if (mVar.c()) {
                                    this.f1058d.a(i2, aVar.f1337d.f1362d, 0);
                                    a(aVar);
                                    return;
                                }
                                arrayList.add(mVar);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            a.a.a.a.v.d.b("No group which ready to load found in SerialSid(%s)", this.f1063i.f1046a.f1332b);
                            this.f1058d.a(i2, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            m mVar2 = (m) it.next();
                            this.f1058d.a(i2, mVar2.b().f1362d, mVar2.a(this.f1055a, this.f1056b) ? 1 : 2);
                        }
                        this.f1063i.f1052g.removeMessages(100, this);
                        this.f1063i.f1052g.sendMessageDelayed(this.f1063i.f1052g.obtainMessage(100, this), next.f1338b);
                    }
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f1063i) {
                    this.f1063i.f1052g.removeMessages(100, this);
                    this.f1062h = null;
                    this.f1059e.clear();
                    if (this.f1063i.f1050e == this) {
                        this.f1063i.f1050e = null;
                    }
                }
            }
        }

        public void a(d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.f1063i) {
                    if (this.f1063i.f1050e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.f1062h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.f1059e.remove(aVar)) {
                        d.C0006d c0006d = this.f1058d;
                        int i2 = this.f1061g;
                        String str = aVar.f1337d.f1362d;
                        if (c0006d != null) {
                            c0006d.a("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                            funAdLoadListener.onAdLoaded(this.f1063i.f1046a.f1332b);
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
