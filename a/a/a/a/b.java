package a.a.a.a;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<A> implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f1008a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f1009b;

    /* renamed from: c  reason: collision with root package name */
    public final List<A> f1010c;

    /* renamed from: d  reason: collision with root package name */
    public final b<A>.C0000b f1011d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1013f;

    /* renamed from: g  reason: collision with root package name */
    public a.a.a.a.u.p f1014g;

    /* renamed from: h  reason: collision with root package name */
    public final a.a.a.a.v.g.g.c f1015h;

    /* renamed from: i  reason: collision with root package name */
    public final h.a f1016i;
    public final boolean j;
    public final boolean k;
    public final a.a.a.a.u.a l;
    public boolean m;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f1017a;

        public C0000b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1017a = bVar;
        }

        public /* synthetic */ C0000b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(h.a aVar) {
        this(aVar, true, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(h.a aVar, boolean z) {
        this(aVar, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b(h.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f1008a = new ArrayList();
        this.f1009b = new ArrayList();
        this.f1010c = new ArrayList();
        this.f1011d = new C0000b(this, null);
        this.f1012e = true;
        this.f1013f = true;
        this.f1015h = new a.a.a.a.v.g.g.c();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.f1016i = aVar;
        this.j = z;
        this.k = z2;
        this.l = a(aVar);
    }

    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? a.a.a.a.u.b.f1389c : (a.a.a.a.u.a) invokeL.objValue;
    }

    public FunNativeAd a(Context context, String str, A a2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, a2)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    @Override // a.a.a.a.m
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f1012e = true;
                this.f1014g = null;
                Iterator<A> it = this.f1009b.iterator();
                while (it.hasNext()) {
                    A next = it.next();
                    b(next);
                    this.l.a(next);
                    it.remove();
                }
                if (!this.j) {
                    Iterator<A> it2 = this.f1010c.iterator();
                    while (it2.hasNext()) {
                        A next2 = it2.next();
                        b(next2);
                        this.l.a(next2);
                        it2.remove();
                    }
                }
            }
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdShowError(c0000b.f1017a.f1016i, i2, str);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.a(i2, str);
                    }
                }
                return;
            }
            throw null;
        }
    }

    @Override // a.a.a.a.m
    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            synchronized (this.f1008a) {
                this.f1008a.add(nVar);
            }
        }
    }

    public final void a(A a2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a2) == null) {
            if (this.j || !this.f1012e) {
                this.f1010c.add(a2);
            } else {
                b(a2);
            }
        }
    }

    public final void a(List<A> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            for (A a2 : list) {
                a((b<A>) a2);
            }
            h();
        }
    }

    @Override // a.a.a.a.m
    public final synchronized boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (c()) {
                    if (this.f1010c.isEmpty()) {
                        return false;
                    }
                    this.f1014g = null;
                    A remove = this.f1010c.remove(0);
                    if (remove == null) {
                        return false;
                    }
                    this.f1009b.add(remove);
                    return funNativeAdInflater == null ? a(activity, viewGroup, str, (String) remove) : a(activity, str, funNativeAdInflater, (FunNativeAdInflater) remove);
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public abstract boolean a(Activity activity, ViewGroup viewGroup, String str, A a2);

    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, activity, str, funNativeAdInflater, a2)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.m
    public final synchronized boolean a(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, funAdSlot)) == null) {
            synchronized (this) {
                this.f1012e = false;
                if (this.m) {
                    return false;
                }
                this.f1014g = null;
                this.m = true;
                this.f1009b.addAll(this.f1010c);
                this.f1010c.clear();
                b(context, funAdSlot);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // a.a.a.a.m
    public h.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1016i : (h.a) invokeV.objValue;
    }

    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            this.m = false;
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoadError(c0000b.f1017a.f1016i, i2, str);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.onError(i2, str);
                    }
                }
                return;
            }
            throw null;
        }
    }

    public abstract void b(Context context, FunAdSlot funAdSlot);

    public abstract void b(A a2);

    @Override // a.a.a.a.m
    public final synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                Iterator<A> it = this.f1010c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (c(it.next())) {
                        z = true;
                        break;
                    } else {
                        it.remove();
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean c(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, a2)) == null) ? a2 != null : invokeL.booleanValue;
    }

    @Override // a.a.a.a.m
    public final synchronized a.a.a.a.u.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                if (this.f1013f) {
                    if (c()) {
                        if (this.f1010c.isEmpty()) {
                            return null;
                        }
                        a.a.a.a.u.p pVar = this.f1014g;
                        if (pVar != null) {
                            return pVar;
                        }
                        a.a.a.a.u.p b2 = this.l.b(this.f1010c.get(0));
                        if (b2 == null) {
                            this.f1013f = false;
                            return null;
                        }
                        this.f1014g = b2;
                        return b2;
                    }
                    return null;
                }
                return null;
            }
        }
        return (a.a.a.a.u.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdClicked(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.onAdClicked();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdClose(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.onAdClose();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoad(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.b();
                    }
                }
                return;
            }
            throw null;
        }
    }

    @Override // a.a.a.a.m
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, context, str)) == null) {
            synchronized (this) {
                if (this.k) {
                    if (c()) {
                        if (this.f1010c.isEmpty()) {
                            return null;
                        }
                        this.f1014g = null;
                        A remove = this.f1010c.remove(0);
                        if (remove == null) {
                            return null;
                        }
                        this.f1009b.add(remove);
                        return a(context, str, remove);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.m = false;
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoaded(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.onLoaded();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onRewardedVideo(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.a();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void a(A a2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, a2, str) == null) {
            this.l.a(a2, str);
            b<A>.C0000b c0000b = this.f1011d;
            if (c0000b != null) {
                e adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdShow(c0000b.f1017a.f1016i);
                }
                synchronized (this.f1008a) {
                    for (n nVar : this.f1008a) {
                        nVar.onAdShow();
                    }
                }
                return;
            }
            throw null;
        }
    }
}
