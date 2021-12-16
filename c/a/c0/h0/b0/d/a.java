package c.a.c0.h0.b0.d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import c.a.c0.d0.f;
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
    public boolean f1678e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1679f;

    /* renamed from: g  reason: collision with root package name */
    public int f1680g;

    /* renamed from: h  reason: collision with root package name */
    public BubbleManager.b f1681h;

    /* renamed from: i  reason: collision with root package name */
    public BubbleManager.a f1682i;

    /* renamed from: j  reason: collision with root package name */
    public g f1683j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1684k;
    public boolean l;
    public boolean m;
    public ObjectAnimator n;
    public boolean o;
    public c.a.c0.h0.b0.e.a p;
    public c.a.c0.h0.b0.b q;

    /* renamed from: c.a.c0.h0.b0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0053a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1685e;

        public RunnableC0053a(a aVar) {
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
            this.f1685e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1685e.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1686e;

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
            this.f1686e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f1686e;
                BubblePosition b2 = aVar.q.b(aVar.p);
                if (b2 == BubblePosition.INVALID) {
                    this.f1686e.p.m();
                    c.a.c0.h0.b0.a.a().b("——>show: remove bubble view end");
                    a aVar2 = this.f1686e;
                    if (aVar2.f1684k) {
                        aVar2.p.l();
                        c.a.c0.h0.b0.a.a().b("——>show: remove bg view end");
                    }
                    a aVar3 = this.f1686e;
                    if (aVar3.l) {
                        aVar3.p.k();
                        c.a.c0.h0.b0.a.a().b("——>show: remove anchorlayer view end");
                        return;
                    }
                    return;
                }
                this.f1686e.p.z(b2);
                this.f1686e.q(b2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BubblePosition f1687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1688f;

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
            this.f1688f = aVar;
            this.f1687e = bubblePosition;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f1688f;
                int[] i2 = aVar.q.i(this.f1687e, aVar.p);
                this.f1688f.p.A(i2);
                a aVar2 = this.f1688f;
                if (aVar2.m) {
                    int a = f.c.a(null, aVar2.q.f1670b + 11.0f);
                    BubblePosition bubblePosition = this.f1687e;
                    if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                        if (bubblePosition == BubblePosition.RIGHT || bubblePosition == BubblePosition.LEFT) {
                            int i3 = this.f1687e == BubblePosition.LEFT ? i2[0] + a : i2[0] - a;
                            a aVar3 = this.f1688f;
                            aVar3.b(aVar3.p.f1693b, i3, i2[0], i2[1], i2[1]);
                        }
                    } else {
                        int i4 = this.f1687e == BubblePosition.UP ? i2[1] + a : i2[1] - a;
                        a aVar4 = this.f1688f;
                        aVar4.b(aVar4.p.f1693b, i2[0], i2[0], i4, i2[1]);
                    }
                }
                a aVar5 = this.f1688f;
                if (aVar5.l) {
                    aVar5.p.y();
                }
                a aVar6 = this.f1688f;
                aVar6.f1678e = true;
                if (aVar6.f1679f) {
                    aVar6.f1683j.sendEmptyMessageDelayed(0, aVar6.f1680g);
                }
                BubbleManager.b bVar = this.f1688f.f1681h;
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
        public final /* synthetic */ a f1689e;

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
            this.f1689e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1689e.i(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1690e;

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
            this.f1690e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1690e.i(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1691e;

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
            this.f1691e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1691e.i(view);
                BubbleManager.a aVar = this.f1691e.f1682i;
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

    public a(c.a.c0.h0.b0.e.a aVar) {
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
        this.f1679f = true;
        this.f1680g = w0.Y3;
        this.o = true;
        this.q = new c.a.c0.h0.b0.b();
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f1678e) {
            c.a.c0.e.g.b(new RunnableC0053a(this));
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    public c.a.c0.h0.b0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (c.a.c0.h0.b0.b) invokeV.objValue;
    }

    public abstract c.a.c0.h0.b0.e.a f();

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.p.g()) {
            this.f1683j = new g(this);
            this.p.v(new d(this));
            this.p.u(new e(this));
            this.p.t(new f(this));
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f1678e : invokeV.booleanValue;
    }

    public void i(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            BubbleManager.b bVar = this.f1681h;
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f1678e) {
            ObjectAnimator objectAnimator = this.n;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.n.cancel();
            }
            if (this.f1684k) {
                this.p.l();
                c.a.c0.h0.b0.a.a().b("——>dismiss BgView end");
            }
            if (this.l) {
                this.p.k();
                c.a.c0.h0.b0.a.a().b("——>dismiss anchorLayer end");
            }
            this.p.m();
            c.a.c0.h0.b0.a.a().b("——>dismiss BubbleView end");
            this.f1678e = false;
            g gVar = this.f1683j;
            if (gVar != null) {
                gVar.removeMessages(0);
            }
            BubbleManager.b bVar = this.f1681h;
            if (bVar != null) {
                bVar.b();
            }
            l();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.c0.h0.b0.e.a aVar = this.p;
            if (aVar != null) {
                aVar.n();
                this.p = null;
            }
            this.f1681h = null;
            this.f1683j = null;
            this.n = null;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 <= 0) {
                this.f1680g = w0.Y3;
            } else {
                this.f1680g = i2;
            }
        }
    }

    public void n(BubbleManager.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f1681h = bVar;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.c0.h0.b0.a.a().b("——>show");
            g();
            if (this.f1684k) {
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
        c.a.c0.h0.b0.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.p) == null || aVar.f1694c == null || TextUtils.isEmpty(aVar.c()) || !this.p.h() || !h()) {
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
