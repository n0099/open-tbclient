package c.i.b.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.l;
import c.i.b.a.g;
import c.i.b.a.q;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes4.dex */
public final class i implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r[] f33765a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.f0.h f33766b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.f0.g f33767c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f33768d;

    /* renamed from: e  reason: collision with root package name */
    public final j f33769e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet<q.b> f33770f;

    /* renamed from: g  reason: collision with root package name */
    public final w.c f33771g;

    /* renamed from: h  reason: collision with root package name */
    public final w.b f33772h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33773i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33774j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public c.i.b.a.d0.t q;
    public c.i.b.a.f0.g r;
    public p s;
    public o t;
    public int u;
    public int v;
    public long w;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f33775a;

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
            this.f33775a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f33775a.x(message);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public i(r[] rVarArr, c.i.b.a.f0.h hVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVarArr, hVar, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + c.i.b.a.i0.v.f33842e + PreferencesUtil.RIGHT_MOUNT;
        c.i.b.a.i0.a.f(rVarArr.length > 0);
        c.i.b.a.i0.a.e(rVarArr);
        this.f33765a = rVarArr;
        c.i.b.a.i0.a.e(hVar);
        this.f33766b = hVar;
        this.f33774j = false;
        this.k = 0;
        this.l = false;
        this.m = 1;
        this.f33770f = new CopyOnWriteArraySet<>();
        this.f33767c = new c.i.b.a.f0.g(new c.i.b.a.f0.f[rVarArr.length]);
        this.f33771g = new w.c();
        this.f33772h = new w.b();
        this.q = c.i.b.a.d0.t.f33136d;
        this.r = this.f33767c;
        this.s = p.f33942d;
        this.f33768d = new a(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.t = new o(w.f33959a, null, 0, 0L);
        this.f33769e = new j(rVarArr, hVar, mVar, this.f33774j, this.k, this.l, this.f33768d, this);
    }

    public void A(c.i.b.a.d0.l lVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                this.u = k();
                this.v = w();
                this.w = getCurrentPosition();
            } else {
                this.u = 0;
                this.v = 0;
                this.w = 0L;
            }
            if (z2) {
                if (!this.t.f33935a.p() || this.t.f33936b != null) {
                    this.t = this.t.c(w.f33959a, null);
                    Iterator<q.b> it = this.f33770f.iterator();
                    while (it.hasNext()) {
                        o oVar = this.t;
                        it.next().c(oVar.f33935a, oVar.f33936b);
                    }
                }
                if (this.f33773i) {
                    this.f33773i = false;
                    this.q = c.i.b.a.d0.t.f33136d;
                    this.r = this.f33767c;
                    this.f33766b.b(null);
                    Iterator<q.b> it2 = this.f33770f.iterator();
                    while (it2.hasNext()) {
                        it2.next().i(this.q, this.r);
                    }
                }
            }
            this.o++;
            this.f33769e.z(lVar, z);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t.f33935a.p() || this.n > 0 || this.o > 0 : invokeV.booleanValue;
    }

    @Override // c.i.b.a.g
    public void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr) == null) {
            this.f33769e.a(bVarArr);
        }
    }

    @Override // c.i.b.a.g
    public void b(c.i.b.a.d0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            A(lVar, true, true);
        }
    }

    @Override // c.i.b.a.q
    public void c(@Nullable p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            if (pVar == null) {
                pVar = p.f33942d;
            }
            this.f33769e.T(pVar);
        }
    }

    @Override // c.i.b.a.q
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (p) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !B() && this.t.f33937c.b() : invokeV.booleanValue;
    }

    @Override // c.i.b.a.q
    public void f(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f33770f.remove(bVar);
        }
    }

    @Override // c.i.b.a.q
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33774j : invokeV.booleanValue;
    }

    @Override // c.i.b.a.q
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (B()) {
                return this.w;
            }
            return z(this.t.f33940f);
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            w wVar = this.t.f33935a;
            if (wVar.p()) {
                return -9223372036854775807L;
            }
            if (e()) {
                l.b bVar = this.t.f33937c;
                wVar.f(bVar.f33091a, this.f33772h);
                return b.b(this.f33772h.b(bVar.f33092b, bVar.f33093c));
            }
            return wVar.l(k(), this.f33771g).b();
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.l == z) {
            return;
        }
        this.l = z;
        this.f33769e.Y(z);
        Iterator<q.b> it = this.f33770f.iterator();
        while (it.hasNext()) {
            it.next().b(z);
        }
    }

    @Override // c.i.b.a.q
    public void i(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.f33770f.add(bVar);
        }
    }

    @Override // c.i.b.a.q
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            long t = t();
            long duration = getDuration();
            if (t == -9223372036854775807L || duration == -9223372036854775807L) {
                return 0;
            }
            if (duration == 0) {
                return 100;
            }
            return c.i.b.a.i0.v.k((int) ((t * 100) / duration), 0, 100);
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (B()) {
                return this.u;
            }
            o oVar = this.t;
            return oVar.f33935a.f(oVar.f33937c.f33091a, this.f33772h).f33962c;
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f33774j == z) {
            return;
        }
        this.f33774j = z;
        this.f33769e.R(z);
        Iterator<q.b> it = this.f33770f.iterator();
        while (it.hasNext()) {
            it.next().l(z, this.m);
        }
    }

    @Override // c.i.b.a.q
    public w m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t.f33935a : (w) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public c.i.b.a.f0.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r : (c.i.b.a.f0.g) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.f33765a[i2].e() : invokeI.intValue;
    }

    @Override // c.i.b.a.q
    public void p(int i2, long j2) {
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            w wVar = this.t.f33935a;
            if (i2 >= 0 && (wVar.p() || i2 < wVar.o())) {
                if (e()) {
                    if (this.n == 0) {
                        Iterator<q.b> it = this.f33770f.iterator();
                        while (it.hasNext()) {
                            it.next().e();
                        }
                        return;
                    }
                    return;
                }
                this.n++;
                this.u = i2;
                if (wVar.p()) {
                    this.w = j2 == -9223372036854775807L ? 0L : j2;
                    this.v = 0;
                } else {
                    wVar.l(i2, this.f33771g);
                    if (j2 == -9223372036854775807L) {
                        a2 = this.f33771g.a();
                    } else {
                        a2 = b.a(j2);
                    }
                    w.c cVar = this.f33771g;
                    int i3 = cVar.f33975f;
                    long c2 = cVar.c() + a2;
                    long h2 = wVar.f(i3, this.f33772h).h();
                    while (h2 != -9223372036854775807L && c2 >= h2 && i3 < this.f33771g.f33976g) {
                        c2 -= h2;
                        i3++;
                        h2 = wVar.f(i3, this.f33772h).h();
                    }
                    this.w = b.b(a2);
                    this.v = i3;
                }
                this.f33769e.L(wVar, i2, b.a(j2));
                Iterator<q.b> it2 = this.f33770f.iterator();
                while (it2.hasNext()) {
                    it2.next().k(1);
                }
                return;
            }
            throw new IllegalSeekPositionException(wVar, i2, j2);
        }
    }

    @Override // c.i.b.a.q
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (e()) {
                o oVar = this.t;
                oVar.f33935a.f(oVar.f33937c.f33091a, this.f33772h);
                return this.f33772h.j() + b.b(this.t.f33939e);
            }
            return getCurrentPosition();
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            w wVar = this.t.f33935a;
            if (wVar.p()) {
                return -1;
            }
            return wVar.k(k(), this.k, this.l);
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String str = "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + c.i.b.a.i0.v.f33842e + "] [" + k.b() + PreferencesUtil.RIGHT_MOUNT;
            this.f33769e.B();
            this.f33768d.removeCallbacksAndMessages(null);
        }
    }

    @Override // c.i.b.a.g
    public void s(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVarArr) == null) {
            this.f33769e.O(bVarArr);
        }
    }

    @Override // c.i.b.a.q
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.k == i2) {
            return;
        }
        this.k = i2;
        this.f33769e.W(i2);
        Iterator<q.b> it = this.f33770f.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(i2);
        }
    }

    @Override // c.i.b.a.q
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f33769e.d0();
        }
    }

    @Override // c.i.b.a.q
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (B()) {
                return this.w;
            }
            return z(this.t.f33941g);
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            w wVar = this.t.f33935a;
            if (wVar.p()) {
                return -1;
            }
            return wVar.e(k(), this.k, this.l);
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (B()) {
                return this.v;
            }
            return this.t.f33937c.f33091a;
        }
        return invokeV.intValue;
    }

    public void x(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, message) == null) {
            switch (message.what) {
                case 0:
                    this.m = message.arg1;
                    Iterator<q.b> it = this.f33770f.iterator();
                    while (it.hasNext()) {
                        it.next().l(this.f33774j, this.m);
                    }
                    return;
                case 1:
                    this.p = message.arg1 != 0;
                    Iterator<q.b> it2 = this.f33770f.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(this.p);
                    }
                    return;
                case 2:
                    if (this.o == 0) {
                        c.i.b.a.f0.i iVar = (c.i.b.a.f0.i) message.obj;
                        this.f33773i = true;
                        this.q = iVar.f33673a;
                        this.r = iVar.f33675c;
                        this.f33766b.b(iVar.f33676d);
                        Iterator<q.b> it3 = this.f33770f.iterator();
                        while (it3.hasNext()) {
                            it3.next().i(this.q, this.r);
                        }
                        return;
                    }
                    return;
                case 3:
                    y((o) message.obj, 0, 1, message.arg1 != 0, 2);
                    return;
                case 4:
                    y((o) message.obj, 0, 0, true, message.arg1);
                    return;
                case 5:
                    y((o) message.obj, message.arg1, message.arg2, false, 3);
                    return;
                case 6:
                    p pVar = (p) message.obj;
                    if (this.s.equals(pVar)) {
                        return;
                    }
                    this.s = pVar;
                    Iterator<q.b> it4 = this.f33770f.iterator();
                    while (it4.hasNext()) {
                        it4.next().j(pVar);
                    }
                    return;
                case 7:
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator<q.b> it5 = this.f33770f.iterator();
                    while (it5.hasNext()) {
                        it5.next().d(exoPlaybackException);
                    }
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public final void y(o oVar, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{oVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            c.i.b.a.i0.a.e(oVar.f33935a);
            int i5 = this.o - i2;
            this.o = i5;
            int i6 = this.n - i3;
            this.n = i6;
            if (i5 == 0 && i6 == 0) {
                o oVar2 = this.t;
                boolean z2 = (oVar2.f33935a == oVar.f33935a && oVar2.f33936b == oVar.f33936b) ? false : true;
                this.t = oVar;
                if (oVar.f33935a.p()) {
                    this.v = 0;
                    this.u = 0;
                    this.w = 0L;
                }
                if (z2) {
                    Iterator<q.b> it = this.f33770f.iterator();
                    while (it.hasNext()) {
                        it.next().c(oVar.f33935a, oVar.f33936b);
                    }
                }
                if (z) {
                    Iterator<q.b> it2 = this.f33770f.iterator();
                    while (it2.hasNext()) {
                        it2.next().k(i4);
                    }
                }
            }
            if (this.n != 0 || i3 <= 0) {
                return;
            }
            Iterator<q.b> it3 = this.f33770f.iterator();
            while (it3.hasNext()) {
                it3.next().e();
            }
        }
    }

    public final long z(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j2)) == null) {
            long b2 = b.b(j2);
            if (this.t.f33937c.b()) {
                return b2;
            }
            o oVar = this.t;
            oVar.f33935a.f(oVar.f33937c.f33091a, this.f33772h);
            return b2 + this.f33772h.j();
        }
        return invokeJ.longValue;
    }
}
