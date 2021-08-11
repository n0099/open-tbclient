package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.a.a.u.h;
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
import com.fun.ad.sdk.FunSplashAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<A> implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<o> f1050a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f1051b;

    /* renamed from: c  reason: collision with root package name */
    public final List<A> f1052c;

    /* renamed from: d  reason: collision with root package name */
    public final c<A>.b f1053d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1054e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1055f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.a.a.w.p f1056g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.a.a.x.f.g.b f1057h;

    /* renamed from: i  reason: collision with root package name */
    public final h.a f1058i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1059j;
    public final boolean k;
    public final boolean l;
    public final b.a.a.a.w.a m;
    public boolean n;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1060a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1060a = cVar;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(h.a aVar) {
        this(aVar, true, false, false);
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
                this((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(h.a aVar, boolean z) {
        this(aVar, z, false, false);
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
                this((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(h.a aVar, boolean z, boolean z2) {
        this(aVar, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public c(h.a aVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f1050a = new ArrayList();
        this.f1051b = new ArrayList();
        this.f1052c = new ArrayList();
        this.f1053d = new b(this, null);
        this.f1054e = true;
        this.f1055f = true;
        this.f1057h = new b.a.a.a.x.f.g.b();
        if (aVar == null) {
            throw new IllegalArgumentException();
        }
        this.f1058i = aVar;
        this.f1059j = z;
        this.k = z2;
        this.l = z3;
        this.m = e(aVar);
    }

    @Override // b.a.a.a.n
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f1054e = true;
                this.f1056g = null;
                Iterator<A> it = this.f1051b.iterator();
                while (it.hasNext()) {
                    A next = it.next();
                    p(next);
                    this.m.a(next);
                    it.remove();
                }
                if (!this.f1059j) {
                    Iterator<A> it2 = this.f1052c.iterator();
                    while (it2.hasNext()) {
                        A next2 = it2.next();
                        p(next2);
                        this.m.a(next2);
                        it2.remove();
                    }
                }
            }
        }
    }

    @Override // b.a.a.a.n
    public final synchronized boolean a(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot)) == null) {
            synchronized (this) {
                this.f1054e = false;
                if (this.n) {
                    return false;
                }
                this.f1056g = null;
                this.n = true;
                this.f1051b.addAll(this.f1052c);
                this.f1052c.clear();
                o(context, funAdSlot);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.a.a.n
    public h.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1058i : (h.a) invokeV.objValue;
    }

    @Override // b.a.a.a.n
    public final synchronized FunSplashAd b(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, viewGroup, str)) == null) {
            synchronized (this) {
                if (this.l) {
                    if (c()) {
                        if (this.f1052c.isEmpty()) {
                            return null;
                        }
                        this.f1056g = null;
                        A remove = this.f1052c.remove(0);
                        if (remove == null) {
                            return null;
                        }
                        this.f1051b.add(remove);
                        return m(activity, viewGroup, str, remove);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunSplashAd) invokeLLL.objValue;
    }

    @Override // b.a.a.a.n
    public final synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                Iterator<A> it = this.f1052c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (q(it.next())) {
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

    @Override // b.a.a.a.n
    public final synchronized boolean c(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (c()) {
                    if (this.f1052c.isEmpty()) {
                        return false;
                    }
                    this.f1056g = null;
                    A remove = this.f1052c.remove(0);
                    if (remove == null) {
                        return false;
                    }
                    this.f1051b.add(remove);
                    return funNativeAdInflater == null ? k(activity, viewGroup, str, remove) : l(activity, str, funNativeAdInflater, remove);
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.n
    public final synchronized b.a.a.a.w.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f1055f) {
                    if (c()) {
                        if (this.f1052c.isEmpty()) {
                            return null;
                        }
                        b.a.a.a.w.p pVar = this.f1056g;
                        if (pVar != null) {
                            return pVar;
                        }
                        b.a.a.a.w.p b2 = this.m.b(this.f1052c.get(0));
                        if (b2 == null) {
                            this.f1055f = false;
                            return null;
                        }
                        this.f1056g = b2;
                        return b2;
                    }
                    return null;
                }
                return null;
            }
        }
        return (b.a.a.a.w.p) invokeV.objValue;
    }

    @Override // b.a.a.a.n
    public void d(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) {
            synchronized (this.f1050a) {
                this.f1050a.add(oVar);
            }
        }
    }

    public b.a.a.a.w.a e(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) ? b.a.a.a.w.b.f1477c : (b.a.a.a.w.a) invokeL.objValue;
    }

    public FunNativeAd f(Context context, String str, A a2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, str, a2)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdShowError(bVar.f1060a.f1058i, i2, str);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.a(i2, str);
                    }
                }
                return;
            }
            throw null;
        }
    }

    @Override // b.a.a.a.n
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, str)) == null) {
            synchronized (this) {
                if (this.k) {
                    if (c()) {
                        if (this.f1052c.isEmpty()) {
                            return null;
                        }
                        this.f1056g = null;
                        A remove = this.f1052c.remove(0);
                        if (remove == null) {
                            return null;
                        }
                        this.f1051b.add(remove);
                        return f(context, str, remove);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    public final void h(A a2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, a2) == null) {
            if (this.f1059j || !this.f1054e) {
                this.f1052c.add(a2);
            } else {
                p(a2);
            }
        }
    }

    public void i(A a2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, a2, str) == null) {
            this.m.a(a2, str);
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdShow(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.onAdShow();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public final void j(List<A> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            for (A a2 : list) {
                h(a2);
            }
            u();
        }
    }

    public abstract boolean k(Activity activity, ViewGroup viewGroup, String str, A a2);

    public boolean l(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, activity, str, funNativeAdInflater, a2)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public FunSplashAd m(Activity activity, ViewGroup viewGroup, String str, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, activity, viewGroup, str, a2)) == null) {
            if (k(activity, viewGroup, str, a2)) {
                return new b.a.a.a.t.a.a();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    public void n(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            this.n = false;
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoadError(bVar.f1060a.f1058i, i2, str);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.onError(i2, str);
                    }
                }
                return;
            }
            throw null;
        }
    }

    public abstract void o(Context context, FunAdSlot funAdSlot);

    public abstract void p(A a2);

    public boolean q(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, a2)) == null) ? a2 != null : invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdClicked(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.onAdClicked();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdClose(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.onAdClose();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoad(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.b();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.n = false;
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onAdLoaded(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.onLoaded();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c<A>.b bVar = this.f1053d;
            if (bVar != null) {
                f adCallback = FunAdSdk.getAdCallback();
                if (adCallback != null) {
                    adCallback.onRewardedVideo(bVar.f1060a.f1058i);
                }
                synchronized (this.f1050a) {
                    for (o oVar : this.f1050a) {
                        oVar.a();
                    }
                }
                return;
            }
            throw null;
        }
    }
}
