package c.a.a0.v.j0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.helper.BdVideoGesture;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoNewCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoPopImageView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoSeekbarImageView;
import com.baidu.nadcore.video.videoplayer.widget.LockImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n extends j implements View.OnClickListener, c.a.a0.v.f0.f {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f1757e;

    /* renamed from: f  reason: collision with root package name */
    public BdVideoSeekbarImageView f1758f;

    /* renamed from: g  reason: collision with root package name */
    public BdVideoSeekbarImageView f1759g;

    /* renamed from: h  reason: collision with root package name */
    public BdVideoPopImageView f1760h;
    public BdVideoPopImageView i;
    public BdVideoPopImageView j;
    public BdVideoCacheView k;
    public BdThumbSeekBar l;
    public LockImageView m;
    public BdVideoGesture n;
    public GestureDetector o;
    public GestureDetector.SimpleOnGestureListener p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public String v;
    public final Runnable w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t) {
                n nVar = this.a;
                nVar.m0(Math.max(0, nVar.getCurrentPosition() - 5));
                Handler handler = this.a.f1744d;
                if (handler != null) {
                    handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n nVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                n nVar = this.a;
                Context context = nVar.f1743c;
                if (context != null) {
                    nVar.n.f(context);
                }
                if (this.a.t) {
                    this.a.j0();
                }
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.u().p1()) {
                    if (this.a.t) {
                        if (motionEvent.getAction() == 1 || !this.a.u().Y()) {
                            this.a.j0();
                        }
                        return true;
                    } else if (!this.a.u().V0() || v.W0() || this.a.u().A() == null || this.a.u().A().getContentView() == null || this.a.u().A().N() == null || !this.a.u().A().getContentView().onTouchEvent(motionEvent)) {
                        if (this.a.k0() && getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        IVideoUpdateStrategy n1 = this.a.u().n1();
                        if (!n1.b()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        if (n1.c()) {
                            boolean V0 = this.a.u().V0();
                            if (this.a.u().o1() != null) {
                                this.a.u().o1().getPage();
                            }
                            if (V0 && !this.a.f0() && this.a.i0(motionEvent)) {
                                return true;
                            }
                            if (this.a.o.onTouchEvent(motionEvent) && this.a.R()) {
                                return true;
                            }
                            if (!v.W0() && this.a.d0()) {
                                if (!this.a.u().V0()) {
                                    this.a.T(motionEvent);
                                }
                                if (this.a.f0()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    return true;
                                } else if (this.a.n.b(motionEvent)) {
                                    return true;
                                }
                            }
                            if (motionEvent.getAction() == 0) {
                                return this.a.h0(motionEvent);
                            }
                            return super.onTouchEvent(motionEvent);
                        }
                        return false;
                    } else {
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        public final void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                n nVar = this.a;
                if (nVar.f1757e == null) {
                    nVar.t = false;
                    return;
                }
                if (nVar.u().W()) {
                    this.a.u().l0();
                }
                if (this.a.u().Y()) {
                    if (this.a.f1757e.getParent() != null) {
                        this.a.f1757e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.a.t = true;
                    if (this.a.u().V0() && v.W0()) {
                        if (this.a.m.getVisibility() == 0) {
                            this.a.r0();
                        }
                    } else {
                        this.a.F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_LONG_PRESS));
                    }
                    boolean z = ((double) motionEvent.getX()) > ((double) this.a.f1757e.getWidth()) / 2.0d;
                    if (z) {
                        this.a.v = "speed";
                        this.a.u().z0(this.a.W());
                    } else {
                        this.a.v = "backward";
                        n nVar2 = this.a;
                        nVar2.f1744d.post(nVar2.w);
                    }
                    if (this.a.u().y() != null) {
                        this.a.u().y().D(z, true);
                    }
                }
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.u().Q() && !this.a.u().R()) {
                    if (this.a.c0()) {
                        c(motionEvent);
                    } else {
                        this.a.r0();
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean c(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.a.f1757e.setVisibility(0);
                if (motionEvent.getAction() != 0 || this.a.u().Q()) {
                    return false;
                }
                this.a.F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                c.a.a0.v.f u = this.a.u();
                if (u == null || u.y() == null || v.W0()) {
                    return false;
                }
                return u.y().x(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && this.a.R() && this.a.S()) {
                a(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) ? b(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(931297827, "Lc/a/a0/v/j0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(931297827, "Lc/a/a0/v/j0/n;");
                return;
            }
        }
        x = c.a.a0.i0.a.d.b.a(124.0f);
        y = c.a.a0.i0.a.d.b.a(85.0f);
        z = c.a.a0.i0.a.d.b.a(119.0f);
        A = c.a.a0.i0.a.d.b.a(50.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NonNull Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }

    @Override // c.a.a0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b0();
            this.f1757e = new b(this, this.f1743c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.a0.i0.a.d.b.a(300.0f), c.a.a0.i0.a.d.b.a(300.0f));
            this.k = new BdVideoNewCacheView(this.f1743c);
            p0(false);
            layoutParams.gravity = 17;
            this.f1757e.addView(this.k, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = c.a.a0.i0.a.d.b.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.f1743c, 2);
            this.l = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.l.setDragable(false);
            this.f1757e.addView(this.l, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.f1743c);
            this.m = lockImageView;
            lockImageView.setBackground(this.f1743c.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e02));
            this.m.e(v.W0() ? 1000 : 2000);
            this.m.setOnClickListener(this);
            this.m.setVisibility(4);
            this.f1757e.addView(this.m, X());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView V = V();
            this.f1758f = V;
            if (V == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.f1743c);
                this.f1758f = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(R.drawable.obfuscated_res_0x7f080e08);
                this.f1758f.setWidth(c.a.a0.i0.a.d.b.a(124.0f));
                this.f1758f.setHeight(c.a.a0.i0.a.d.b.a(85.0f));
            }
            this.f1758f.setVisibility(4);
            this.f1757e.addView(this.f1758f, layoutParams3);
            BdVideoSeekbarImageView U = U();
            this.f1759g = U;
            if (U == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.f1743c);
                this.f1759g = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(R.drawable.obfuscated_res_0x7f080e07);
                this.f1759g.setWidth(c.a.a0.i0.a.d.b.a(124.0f));
                this.f1759g.setHeight(c.a.a0.i0.a.d.b.a(85.0f));
            }
            this.f1759g.setVisibility(4);
            this.f1757e.addView(this.f1759g, layoutParams3);
            if (!this.r) {
                BdVideoPopImageView bdVideoPopImageView = new BdVideoPopImageView(this.f1743c);
                this.f1760h = bdVideoPopImageView;
                bdVideoPopImageView.setIcon(R.drawable.obfuscated_res_0x7f080e0a);
                this.f1760h.setMsg("100%");
                this.f1760h.setVisibility(4);
                this.f1757e.addView(this.f1760h, layoutParams3);
                BdVideoPopImageView bdVideoPopImageView2 = new BdVideoPopImageView(this.f1743c);
                this.i = bdVideoPopImageView2;
                bdVideoPopImageView2.setMsg("0%");
                this.i.setIcon(R.drawable.obfuscated_res_0x7f080e09);
                this.i.setVisibility(4);
                this.f1757e.addView(this.i, layoutParams3);
            }
            BdVideoPopImageView bdVideoPopImageView3 = new BdVideoPopImageView(this.f1743c);
            this.j = bdVideoPopImageView3;
            bdVideoPopImageView3.setMsg("0%");
            this.j.setIcon(R.drawable.obfuscated_res_0x7f080e04);
            this.j.setVisibility(4);
            this.f1757e.addView(this.j, layoutParams3);
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? u().V0() : invokeV.booleanValue;
    }

    public void T(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
        }
    }

    public BdVideoSeekbarImageView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public BdVideoSeekbarImageView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public final float W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.u = u().G();
            float min = Math.min(this.u * c.a.a0.v.v0.r.j(), c.a.a0.v.v0.r.i());
            return min > 0.0f ? min : this.u;
        }
        return invokeV.floatValue;
    }

    public FrameLayout.LayoutParams X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.a0.i0.a.d.b.a(37.0f), c.a.a0.i0.a.d.b.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = c.a.a0.i0.a.d.b.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.q) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1758f.setVisibility(4);
            this.f1759g.setVisibility(4);
            if (!this.r) {
                this.f1760h.setVisibility(4);
                this.i.setVisibility(4);
            }
            this.j.setVisibility(4);
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f1744d.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    @Override // c.a.a0.v.f0.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n = new c.a.a0.v.d0.b(this.f1743c, this);
            this.p = new c(this);
            this.o = new GestureDetector(this.f1743c, this.p);
        }
    }

    @Override // c.a.a0.v.f0.f
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            int r = u().r();
            int g0 = g0(i2 + i, r);
            int i3 = g0 - i;
            boolean z2 = r >= 3600;
            String a2 = c.a.a0.h0.c.a(g0, z2);
            String a3 = c.a.a0.h0.c.a(r, z2);
            if (i3 >= 0) {
                this.f1758f.setVisibility(0);
                this.f1759g.setVisibility(8);
                this.f1758f.setMsg(a2, a3);
                this.f1758f.c(g0, r);
                if (V() == null) {
                    s0(this.f1758f);
                }
            } else {
                this.f1758f.setVisibility(8);
                this.f1759g.setVisibility(0);
                this.f1759g.setMsg(a2, a3);
                this.f1759g.c(g0, r);
                if (U() == null) {
                    s0(this.f1759g);
                }
            }
            this.f1759g.requestLayout();
            this.f1758f.requestLayout();
            c.a.a0.v.c0.p w = c.a.a0.v.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE);
            w.n(2, Integer.valueOf(i));
            w.n(3, Integer.valueOf(i3));
            F(w);
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (u().V0() && v.W0()) ? false : true : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void d(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1759675333:
                    if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -971135626:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                int g2 = pVar.g(1);
                if (701 == g2) {
                    p0(true);
                } else if (702 == g2) {
                    p0(false);
                } else if (904 == g2 || g2 == 956) {
                    p0(false);
                    if (e0()) {
                        o0();
                    }
                }
            } else if (c2 == 1) {
                this.f1757e.setVisibility(4);
                this.n.g();
                Z();
            } else if (c2 == 2 || c2 == 3) {
                p0(false);
            } else if (c2 != 4) {
                if (c2 == 5 && this.t) {
                    j0();
                }
            } else {
                this.l.setProgress(0);
            }
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? u().V0() : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R() && c.a.a0.v.v0.r.q() && S() && u().r() >= 60 : invokeV.booleanValue;
    }

    @Override // c.a.a0.v.f0.f
    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            int b2 = (int) ((f2 / c.a.a0.v.v0.k.b(this.f1743c)) * 100.0f);
            if (c.a.a0.v.v0.k.c(this.f1743c) == 0) {
                b2 = 0;
            }
            if (!this.r) {
                if (b2 == 0) {
                    if (this.i.getVisibility() == 4) {
                        if (this.f1760h.getVisibility() == 0) {
                            this.f1760h.setVisibility(4);
                            this.f1760h.requestLayout();
                        }
                        this.i.setVisibility(0);
                        this.i.requestLayout();
                    }
                } else if (this.f1760h.getVisibility() == 4) {
                    if (this.i.getVisibility() == 0) {
                        this.i.setVisibility(4);
                        this.i.requestLayout();
                    }
                    this.f1760h.setVisibility(0);
                    this.f1760h.requestLayout();
                }
                BdVideoPopImageView bdVideoPopImageView = this.f1760h;
                bdVideoPopImageView.setMsg(b2 + "%");
                BdVideoPopImageView bdVideoPopImageView2 = this.i;
                bdVideoPopImageView2.setMsg(b2 + "%");
            }
            c.a.a0.v.v0.k.d(c.a.a0.h.a.b(), (int) f2);
            c.a.a0.v.c0.p w = c.a.a0.v.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME);
            w.n(20, Integer.valueOf(b2));
            F(w);
            c.a.a0.v.v0.h.b("GestureLayer", "onVolumeSlide : " + f2);
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int g0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            if (i < 0) {
                return 0;
            }
            return i > i2 ? i2 : i;
        }
        return invokeII.intValue;
    }

    @Override // c.a.a0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1757e : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.f
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? u().C() : invokeV.intValue;
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new int[]{4, 2, 3, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f1757e.setVisibility(0);
                p0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                p0(true);
                this.f1757e.setVisibility(0);
            }
        }
    }

    public boolean h0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.a0.v.f0.f
    public void i(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            this.j.setVisibility(0);
            this.j.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.j;
            bdVideoPopImageView.setMsg(((int) ((f2 / 255.0f) * 100.0f)) + "%");
            c.a.a0.h0.o.d(getActivity(), (int) f2);
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_ADJUST_LIGHT));
            c.a.a0.v.v0.h.b("GestureLayer", "onBrightSlide : " + f2);
        }
    }

    public final boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            if (v.W0()) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.t = false;
            boolean equals = TextUtils.equals(this.v, "speed");
            if (equals) {
                u().z0(this.u);
            } else {
                this.f1744d.removeCallbacks(this.w);
            }
            if (u().y() != null) {
                u().y().D(equals, false);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1638530599:
                    if (c3.equals(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -997577826:
                    if (c3.equals(LayerEvent.ACTION_CLICK_RETRY)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 250537257:
                    if (c3.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 264969781:
                    if (c3.equals(LayerEvent.ACTION_HIDE_CACHE_LOADING)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 665895127:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_VIEW)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1231554669:
                    if (c3.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1409909918:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (BdNetUtils.h()) {
                        p0(true);
                        return;
                    }
                    return;
                case 1:
                    this.m.setVisibility(4);
                    Z();
                    l0();
                    return;
                case 2:
                    n0();
                    return;
                case 3:
                default:
                    return;
                case 4:
                case 5:
                    p0(false);
                    return;
                case 6:
                    this.q = ((Boolean) pVar.f(9)).booleanValue();
                    Y();
                    if (u().V0()) {
                        this.f1744d.removeMessages(20);
                        if (!v.W0()) {
                            this.m.setVisibility(this.q ? 0 : 4);
                            return;
                        } else {
                            a0();
                            return;
                        }
                    } else if (u().U0()) {
                        this.l.setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                case 7:
                    this.m.e(v.W0() ? 1000 : 2000);
                    return;
                case '\b':
                    this.l.setVisibility(0);
                    this.m.setVisibility(4);
                    return;
            }
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a0.v.f0.f
    public void l(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            m0((int) (i + f2));
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.a0.v.v0.q.i(this);
        }
    }

    @Override // c.a.a0.v.f0.f
    public void m(BdVideoGesture.VideoPluginGesture videoPluginGesture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, videoPluginGesture) == null) {
            Z();
            if (videoPluginGesture == BdVideoGesture.VideoPluginGesture.InitChange) {
                u().y().w();
            } else {
                u().y().v();
            }
        }
    }

    public final void m0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            int r = u().r();
            if (r > 1 && i > (i2 = r - 1)) {
                i = i2;
            }
            u().o0(i);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.a0.v.v0.q.k(this);
        }
    }

    @Override // c.a.a0.v.f0.f
    public Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, view) == null) && view.equals(this.m)) {
            u().a1();
            this.m.b();
            c.a.a0.v.q0.b.c().d(c.a.a0.v.c0.f.w(LayerEvent.ACTION_LOCK_SCREEN));
            u().y().E(v.W0());
        }
    }

    @Override // c.a.a0.v.j0.j, c.a.a0.v.j0.b, c.a.a0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onLayerRelease();
            this.n.h();
            this.o.setOnDoubleTapListener(null);
        }
    }

    @Override // c.a.a0.v.f0.f
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? u().Q() : invokeV.booleanValue;
    }

    public void p0(boolean z2) {
        BdVideoCacheView bdVideoCacheView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) && this.s && (bdVideoCacheView = this.k) != null) {
            if (z2) {
                bdVideoCacheView.c(0);
            } else {
                bdVideoCacheView.c(4);
            }
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void q(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode != -1530009462) {
                if (hashCode == 906917140 && c3.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (c3.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                q0(pVar.g(1), pVar.g(2), pVar.g(3));
            } else if (c2 != 1) {
            } else {
                this.f1757e.setVisibility(0);
            }
        }
    }

    public void q0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048619, this, i, i2, i3) == null) {
            if (u().r1()) {
                i = u().k1();
                i2 = u().j1();
            }
            this.l.h(i, i2, i3);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f1744d.removeMessages(20);
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
                a0();
                return;
            }
            this.m.setVisibility(4);
        }
    }

    public final void s0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bdVideoSeekbarImageView) == null) {
            if (u().V0()) {
                bdVideoSeekbarImageView.setIconVisible(true);
                bdVideoSeekbarImageView.setWidth(x);
                bdVideoSeekbarImageView.setHeight(y);
                return;
            }
            bdVideoSeekbarImageView.setIconVisible(false);
            bdVideoSeekbarImageView.setWidth(z);
            bdVideoSeekbarImageView.setHeight(A);
        }
    }

    @Override // c.a.a0.v.j0.b
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, message) == null) {
            super.z(message);
            if (message == null || message.what != 20 || this.q) {
                return;
            }
            this.m.setVisibility(4);
            this.f1744d.removeMessages(20);
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }
}
