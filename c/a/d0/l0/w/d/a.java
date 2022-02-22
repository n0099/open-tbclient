package c.a.d0.l0.w.d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import c.a.d0.h.k;
import c.a.d0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3021e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3022f;

    /* renamed from: g  reason: collision with root package name */
    public int f3023g;

    /* renamed from: h  reason: collision with root package name */
    public BubbleManager.b f3024h;

    /* renamed from: i  reason: collision with root package name */
    public BubbleManager.a f3025i;

    /* renamed from: j  reason: collision with root package name */
    public g f3026j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ObjectAnimator n;
    public boolean o;
    public c.a.d0.l0.w.e.a p;
    public c.a.d0.l0.w.b q;

    /* renamed from: c.a.d0.l0.w.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0114a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3027e;

        public RunnableC0114a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3027e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3027e.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3028e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3028e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f3028e;
                BubblePosition b2 = aVar.q.b(aVar.p);
                if (b2 == BubblePosition.INVALID) {
                    this.f3028e.p.m();
                    c.a.d0.l0.w.a.a().b("——>show: remove bubble view end");
                    a aVar2 = this.f3028e;
                    if (aVar2.k) {
                        aVar2.p.l();
                        c.a.d0.l0.w.a.a().b("——>show: remove bg view end");
                    }
                    a aVar3 = this.f3028e;
                    if (aVar3.l) {
                        aVar3.p.k();
                        c.a.d0.l0.w.a.a().b("——>show: remove anchorlayer view end");
                        return;
                    }
                    return;
                }
                this.f3028e.p.z(b2);
                this.f3028e.q(b2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BubblePosition f3029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3030f;

        public c(a aVar, BubblePosition bubblePosition) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bubblePosition};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3030f = aVar;
            this.f3029e = bubblePosition;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f3030f;
                int[] i2 = aVar.q.i(this.f3029e, aVar.p);
                this.f3030f.p.A(i2);
                a aVar2 = this.f3030f;
                if (aVar2.m) {
                    int a = f.c.a(null, aVar2.q.f3013b + 11.0f);
                    BubblePosition bubblePosition = this.f3029e;
                    if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                        if (bubblePosition == BubblePosition.RIGHT || bubblePosition == BubblePosition.LEFT) {
                            int i3 = this.f3029e == BubblePosition.LEFT ? i2[0] + a : i2[0] - a;
                            a aVar3 = this.f3030f;
                            aVar3.b(aVar3.p.f3035b, i3, i2[0], i2[1], i2[1]);
                        }
                    } else {
                        int i4 = this.f3029e == BubblePosition.UP ? i2[1] + a : i2[1] - a;
                        a aVar4 = this.f3030f;
                        aVar4.b(aVar4.p.f3035b, i2[0], i2[0], i4, i2[1]);
                    }
                }
                a aVar5 = this.f3030f;
                if (aVar5.l) {
                    aVar5.p.y();
                }
                a aVar6 = this.f3030f;
                aVar6.f3021e = true;
                if (aVar6.f3022f) {
                    aVar6.f3026j.sendEmptyMessageDelayed(0, aVar6.f3023g);
                }
                BubbleManager.b bVar = this.f3030f.f3024h;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3031e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3031e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3031e.i(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3032e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3032e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3032e.i(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3033e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3033e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3033e.i(view);
                BubbleManager.a aVar = this.f3033e.f3025i;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0 && (aVar = this.a.get()) != null) {
                aVar.c();
            }
        }
    }

    public a(c.a.d0.l0.w.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3022f = true;
        this.f3023g = w0.Y3;
        this.o = true;
        this.q = new c.a.d0.l0.w.b();
        this.p = aVar;
    }

    public final void b(View view, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            ObjectAnimator objectAnimator = this.n;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.n.cancel();
            }
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_X, f2, f3), PropertyValuesHolder.ofFloat(AnimationProperty.TRANSLATE_Y, f4, f5)).setDuration(180L);
            this.n = duration;
            duration.start();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f3021e) {
            k.b(new RunnableC0114a(this));
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    public c.a.d0.l0.w.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (c.a.d0.l0.w.b) invokeV.objValue;
    }

    public abstract c.a.d0.l0.w.e.a f();

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.p.g()) {
            this.f3026j = new g(this);
            this.p.v(new d(this));
            this.p.u(new e(this));
            this.p.t(new f(this));
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f3021e : invokeV.booleanValue;
    }

    public void i(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            BubbleManager.b bVar = this.f3024h;
            if (bVar != null) {
                bVar.a();
            }
            if (this.o) {
                c();
            }
        }
    }

    public abstract void j();

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f3021e) {
            ObjectAnimator objectAnimator = this.n;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.n.cancel();
            }
            if (this.k) {
                this.p.l();
                c.a.d0.l0.w.a.a().b("——>dismiss BgView end");
            }
            if (this.l) {
                this.p.k();
                c.a.d0.l0.w.a.a().b("——>dismiss anchorLayer end");
            }
            this.p.m();
            c.a.d0.l0.w.a.a().b("——>dismiss BubbleView end");
            this.f3021e = false;
            g gVar = this.f3026j;
            if (gVar != null) {
                gVar.removeMessages(0);
            }
            BubbleManager.b bVar = this.f3024h;
            if (bVar != null) {
                bVar.b();
            }
            l();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.d0.l0.w.e.a aVar = this.p;
            if (aVar != null) {
                aVar.n();
                this.p = null;
            }
            this.f3024h = null;
            this.f3026j = null;
            this.n = null;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 <= 0) {
                this.f3023g = w0.Y3;
            } else {
                this.f3023g = i2;
            }
        }
    }

    public void n(BubbleManager.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f3024h = bVar;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.d0.l0.w.a.a().b("——>show");
            g();
            if (this.k) {
                this.p.q();
            }
            if (this.l) {
                this.p.p();
                this.p.o();
            }
            this.p.r();
            if (!this.o) {
                this.p.f();
            }
            j();
            this.p.j(new b(this));
        }
    }

    public void p() {
        c.a.d0.l0.w.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.p) == null || aVar.f3036c == null || TextUtils.isEmpty(aVar.c()) || !this.p.h() || !h()) {
            return;
        }
        o();
    }

    public void q(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bubblePosition) == null) {
            this.p.j(new c(this, bubblePosition));
        }
    }
}
