package c.a.d0.v.j0;

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
import c.a.d0.v.v;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n extends j implements View.OnClickListener, c.a.d0.v.f0.f {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable A;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f3314i;

    /* renamed from: j  reason: collision with root package name */
    public BdVideoSeekbarImageView f3315j;
    public BdVideoSeekbarImageView k;
    public BdVideoPopImageView l;
    public BdVideoPopImageView m;
    public BdVideoPopImageView n;
    public BdVideoCacheView o;
    public BdThumbSeekBar p;
    public LockImageView q;
    public BdVideoGesture r;
    public GestureDetector s;
    public GestureDetector.SimpleOnGestureListener t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public float y;
    public String z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f3316e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3316e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f3316e.x) {
                n nVar = this.f3316e;
                nVar.m0(Math.max(0, nVar.getCurrentPosition() - 5));
                Handler handler = this.f3316e.f3306h;
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f3317e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n nVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3317e = nVar;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                n nVar = this.f3317e;
                Context context = nVar.f3305g;
                if (context != null) {
                    nVar.r.f(context);
                }
                if (this.f3317e.x) {
                    this.f3317e.j0();
                }
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.f3317e.u().p1()) {
                    if (this.f3317e.x) {
                        if (motionEvent.getAction() == 1 || !this.f3317e.u().Y()) {
                            this.f3317e.j0();
                        }
                        return true;
                    } else if (!this.f3317e.u().V0() || v.W0() || this.f3317e.u().A() == null || this.f3317e.u().A().getContentView() == null || this.f3317e.u().A().N() == null || !this.f3317e.u().A().getContentView().onTouchEvent(motionEvent)) {
                        if (this.f3317e.k0() && getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        IVideoUpdateStrategy n1 = this.f3317e.u().n1();
                        if (!n1.b()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        if (n1.c()) {
                            boolean V0 = this.f3317e.u().V0();
                            if (this.f3317e.u().o1() != null) {
                                this.f3317e.u().o1().getPage();
                            }
                            if (V0 && !this.f3317e.f0() && this.f3317e.i0(motionEvent)) {
                                return true;
                            }
                            if (this.f3317e.s.onTouchEvent(motionEvent) && this.f3317e.R()) {
                                return true;
                            }
                            if (!v.W0() && this.f3317e.d0()) {
                                if (!this.f3317e.u().V0()) {
                                    this.f3317e.T(motionEvent);
                                }
                                if (this.f3317e.f0()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    return true;
                                } else if (this.f3317e.r.b(motionEvent)) {
                                    return true;
                                }
                            }
                            if (motionEvent.getAction() == 0) {
                                return this.f3317e.h0(motionEvent);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f3318e;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3318e = nVar;
        }

        public final void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                n nVar = this.f3318e;
                if (nVar.f3314i == null) {
                    nVar.x = false;
                    return;
                }
                if (nVar.u().W()) {
                    this.f3318e.u().l0();
                }
                if (this.f3318e.u().Y()) {
                    if (this.f3318e.f3314i.getParent() != null) {
                        this.f3318e.f3314i.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.f3318e.x = true;
                    if (this.f3318e.u().V0() && v.W0()) {
                        if (this.f3318e.q.getVisibility() == 0) {
                            this.f3318e.r0();
                        }
                    } else {
                        this.f3318e.F(c.a.d0.v.c0.f.w(LayerEvent.ACTION_LONG_PRESS));
                    }
                    boolean z = ((double) motionEvent.getX()) > ((double) this.f3318e.f3314i.getWidth()) / 2.0d;
                    if (z) {
                        this.f3318e.z = "speed";
                        this.f3318e.u().z0(this.f3318e.W());
                    } else {
                        this.f3318e.z = "backward";
                        n nVar2 = this.f3318e;
                        nVar2.f3306h.post(nVar2.A);
                    }
                    if (this.f3318e.u().y() != null) {
                        this.f3318e.u().y().D(z, true);
                    }
                }
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.f3318e.u().Q() && !this.f3318e.u().R()) {
                    if (this.f3318e.c0()) {
                        c(motionEvent);
                    } else {
                        this.f3318e.r0();
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
                this.f3318e.f3314i.setVisibility(0);
                if (motionEvent.getAction() != 0 || this.f3318e.u().Q()) {
                    return false;
                }
                this.f3318e.F(c.a.d0.v.c0.f.w(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                c.a.d0.v.f u = this.f3318e.u();
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
            if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && this.f3318e.R() && this.f3318e.S()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(341757312, "Lc/a/d0/v/j0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(341757312, "Lc/a/d0/v/j0/n;");
                return;
            }
        }
        B = c.a.d0.i0.a.d.b.a(124.0f);
        C = c.a.d0.i0.a.d.b.a(85.0f);
        D = c.a.d0.i0.a.d.b.a(119.0f);
        E = c.a.d0.i0.a.d.b.a(50.0f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = false;
        this.y = 1.0f;
        this.z = "speed";
        this.A = new a(this);
    }

    @Override // c.a.d0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b0();
            this.f3314i = new b(this, this.f3305g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.d0.i0.a.d.b.a(300.0f), c.a.d0.i0.a.d.b.a(300.0f));
            this.o = new BdVideoNewCacheView(this.f3305g);
            p0(false);
            layoutParams.gravity = 17;
            this.f3314i.addView(this.o, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = c.a.d0.i0.a.d.b.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.f3305g, 2);
            this.p = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.p.setDragable(false);
            this.f3314i.addView(this.p, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.f3305g);
            this.q = lockImageView;
            lockImageView.setBackground(this.f3305g.getResources().getDrawable(c.a.d0.l0.l.nad_videoplayer_playbtn_bg));
            this.q.updateLockState(v.W0() ? 1000 : 2000);
            this.q.setOnClickListener(this);
            this.q.setVisibility(4);
            this.f3314i.addView(this.q, X());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView V = V();
            this.f3315j = V;
            if (V == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.f3305g);
                this.f3315j = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(c.a.d0.l0.l.nad_videoplayer_player_seek_forward);
                this.f3315j.setWidth(c.a.d0.i0.a.d.b.a(124.0f));
                this.f3315j.setHeight(c.a.d0.i0.a.d.b.a(85.0f));
            }
            this.f3315j.setVisibility(4);
            this.f3314i.addView(this.f3315j, layoutParams3);
            BdVideoSeekbarImageView U = U();
            this.k = U;
            if (U == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.f3305g);
                this.k = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(c.a.d0.l0.l.nad_videoplayer_player_seek_back);
                this.k.setWidth(c.a.d0.i0.a.d.b.a(124.0f));
                this.k.setHeight(c.a.d0.i0.a.d.b.a(85.0f));
            }
            this.k.setVisibility(4);
            this.f3314i.addView(this.k, layoutParams3);
            if (!this.v) {
                BdVideoPopImageView bdVideoPopImageView = new BdVideoPopImageView(this.f3305g);
                this.l = bdVideoPopImageView;
                bdVideoPopImageView.setIcon(c.a.d0.l0.l.nad_videoplayer_player_volume_open_big);
                this.l.setMsg("100%");
                this.l.setVisibility(4);
                this.f3314i.addView(this.l, layoutParams3);
                BdVideoPopImageView bdVideoPopImageView2 = new BdVideoPopImageView(this.f3305g);
                this.m = bdVideoPopImageView2;
                bdVideoPopImageView2.setMsg("0%");
                this.m.setIcon(c.a.d0.l0.l.nad_videoplayer_player_volume_close_big);
                this.m.setVisibility(4);
                this.f3314i.addView(this.m, layoutParams3);
            }
            BdVideoPopImageView bdVideoPopImageView3 = new BdVideoPopImageView(this.f3305g);
            this.n = bdVideoPopImageView3;
            bdVideoPopImageView3.setMsg("0%");
            this.n.setIcon(c.a.d0.l0.l.nad_videoplayer_player_bright);
            this.n.setVisibility(4);
            this.f3314i.addView(this.n, layoutParams3);
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
            this.y = u().G();
            float min = Math.min(this.y * c.a.d0.v.v0.r.j(), c.a.d0.v.v0.r.i());
            return min > 0.0f ? min : this.y;
        }
        return invokeV.floatValue;
    }

    public FrameLayout.LayoutParams X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.d0.i0.a.d.b.a(37.0f), c.a.d0.i0.a.d.b.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = c.a.d0.i0.a.d.b.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.u) {
                this.p.setVisibility(4);
            } else {
                this.p.setVisibility(0);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f3315j.setVisibility(4);
            this.k.setVisibility(4);
            if (!this.v) {
                this.l.setVisibility(4);
                this.m.setVisibility(4);
            }
            this.n.setVisibility(4);
            F(c.a.d0.v.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f3306h.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    @Override // c.a.d0.v.f0.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            F(c.a.d0.v.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.r = new c.a.d0.v.d0.b(this.f3305g, this);
            this.t = new c(this);
            this.s = new GestureDetector(this.f3305g, this.t);
        }
    }

    @Override // c.a.d0.v.f0.f
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            int r = u().r();
            int g0 = g0(i3 + i2, r);
            int i4 = g0 - i2;
            boolean z = r >= 3600;
            String a2 = c.a.d0.h0.c.a(g0, z);
            String a3 = c.a.d0.h0.c.a(r, z);
            if (i4 >= 0) {
                this.f3315j.setVisibility(0);
                this.k.setVisibility(8);
                this.f3315j.setMsg(a2, a3);
                this.f3315j.refreshPositionAndDuration(g0, r);
                if (V() == null) {
                    s0(this.f3315j);
                }
            } else {
                this.f3315j.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setMsg(a2, a3);
                this.k.refreshPositionAndDuration(g0, r);
                if (U() == null) {
                    s0(this.k);
                }
            }
            this.k.requestLayout();
            this.f3315j.requestLayout();
            c.a.d0.v.c0.p w = c.a.d0.v.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE);
            w.n(2, Integer.valueOf(i2));
            w.n(3, Integer.valueOf(i4));
            F(w);
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (u().V0() && v.W0()) ? false : true : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void d(@NonNull c.a.d0.v.c0.p pVar) {
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
                this.f3314i.setVisibility(4);
                this.r.g();
                Z();
            } else if (c2 == 2 || c2 == 3) {
                p0(false);
            } else if (c2 != 4) {
                if (c2 == 5 && this.x) {
                    j0();
                }
            } else {
                this.p.setProgress(0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R() && c.a.d0.v.v0.r.q() && S() && u().r() >= 60 : invokeV.booleanValue;
    }

    @Override // c.a.d0.v.f0.f
    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            int b2 = (int) ((f2 / c.a.d0.v.v0.k.b(this.f3305g)) * 100.0f);
            if (c.a.d0.v.v0.k.c(this.f3305g) == 0) {
                b2 = 0;
            }
            if (!this.v) {
                if (b2 == 0) {
                    if (this.m.getVisibility() == 4) {
                        if (this.l.getVisibility() == 0) {
                            this.l.setVisibility(4);
                            this.l.requestLayout();
                        }
                        this.m.setVisibility(0);
                        this.m.requestLayout();
                    }
                } else if (this.l.getVisibility() == 4) {
                    if (this.m.getVisibility() == 0) {
                        this.m.setVisibility(4);
                        this.m.requestLayout();
                    }
                    this.l.setVisibility(0);
                    this.l.requestLayout();
                }
                BdVideoPopImageView bdVideoPopImageView = this.l;
                bdVideoPopImageView.setMsg(b2 + "%");
                BdVideoPopImageView bdVideoPopImageView2 = this.m;
                bdVideoPopImageView2.setMsg(b2 + "%");
            }
            c.a.d0.v.v0.k.d(c.a.d0.h.a.b(), (int) f2);
            c.a.d0.v.c0.p w = c.a.d0.v.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME);
            w.n(20, Integer.valueOf(b2));
            F(w);
            c.a.d0.v.v0.h.b("GestureLayer", "onVolumeSlide : " + f2);
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

    public final int g0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            if (i2 < 0) {
                return 0;
            }
            return i2 > i3 ? i3 : i2;
        }
        return invokeII.intValue;
    }

    @Override // c.a.d0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f3314i : (View) invokeV.objValue;
    }

    @Override // c.a.d0.v.f0.f
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? u().C() : invokeV.intValue;
    }

    @Override // c.a.d0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new int[]{4, 2, 3, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f3314i.setVisibility(0);
                p0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                p0(true);
                this.f3314i.setVisibility(0);
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

    @Override // c.a.d0.v.f0.f
    public void i(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            this.n.setVisibility(0);
            this.n.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.n;
            bdVideoPopImageView.setMsg(((int) ((f2 / 255.0f) * 100.0f)) + "%");
            c.a.d0.h0.o.d(getActivity(), (int) f2);
            F(c.a.d0.v.c0.f.w(LayerEvent.ACTION_ADJUST_LIGHT));
            c.a.d0.v.v0.h.b("GestureLayer", "onBrightSlide : " + f2);
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
            this.x = false;
            boolean equals = TextUtils.equals(this.z, "speed");
            if (equals) {
                u().z0(this.y);
            } else {
                this.f3306h.removeCallbacks(this.A);
            }
            if (u().y() != null) {
                u().y().D(equals, false);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void k(@NonNull c.a.d0.v.c0.p pVar) {
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
                    this.q.setVisibility(4);
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
                    this.u = ((Boolean) pVar.f(9)).booleanValue();
                    Y();
                    if (u().V0()) {
                        this.f3306h.removeMessages(20);
                        if (!v.W0()) {
                            this.q.setVisibility(this.u ? 0 : 4);
                            return;
                        } else {
                            a0();
                            return;
                        }
                    } else if (u().U0()) {
                        this.p.setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                case 7:
                    this.q.updateLockState(v.W0() ? 1000 : 2000);
                    return;
                case '\b':
                    this.p.setVisibility(0);
                    this.q.setVisibility(4);
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

    @Override // c.a.d0.v.f0.f
    public void l(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            m0((int) (i2 + f2));
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.d0.v.v0.q.i(this);
        }
    }

    @Override // c.a.d0.v.f0.f
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

    public final void m0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            int r = u().r();
            if (r > 1 && i2 > (i3 = r - 1)) {
                i2 = i3;
            }
            u().o0(i2);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.d0.v.v0.q.k(this);
        }
    }

    @Override // c.a.d0.v.f0.f
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
        if ((interceptable == null || interceptable.invokeL(1048614, this, view) == null) && view.equals(this.q)) {
            u().a1();
            this.q.animateToggle();
            c.a.d0.v.q0.b.c().d(c.a.d0.v.c0.f.w(LayerEvent.ACTION_LOCK_SCREEN));
            u().y().E(v.W0());
        }
    }

    @Override // c.a.d0.v.j0.j, c.a.d0.v.j0.b, c.a.d0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onLayerRelease();
            this.r.h();
            this.s.setOnDoubleTapListener(null);
        }
    }

    @Override // c.a.d0.v.f0.f
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? u().Q() : invokeV.booleanValue;
    }

    public void p0(boolean z) {
        BdVideoCacheView bdVideoCacheView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && this.w && (bdVideoCacheView = this.o) != null) {
            if (z) {
                bdVideoCacheView.startCacheRotation(0);
            } else {
                bdVideoCacheView.startCacheRotation(4);
            }
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void q(@NonNull c.a.d0.v.c0.p pVar) {
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
                this.f3314i.setVisibility(0);
            }
        }
    }

    public void q0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048619, this, i2, i3, i4) == null) {
            if (u().r1()) {
                i2 = u().k1();
                i3 = u().j1();
            }
            this.p.syncPos(i2, i3, i4);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f3306h.removeMessages(20);
            if (this.q.getVisibility() != 0) {
                this.q.setVisibility(0);
                a0();
                return;
            }
            this.q.setVisibility(4);
        }
    }

    public final void s0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bdVideoSeekbarImageView) == null) {
            if (u().V0()) {
                bdVideoSeekbarImageView.setIconVisible(true);
                bdVideoSeekbarImageView.setWidth(B);
                bdVideoSeekbarImageView.setHeight(C);
                return;
            }
            bdVideoSeekbarImageView.setIconVisible(false);
            bdVideoSeekbarImageView.setWidth(D);
            bdVideoSeekbarImageView.setHeight(E);
        }
    }

    @Override // c.a.d0.v.j0.b
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, message) == null) {
            super.z(message);
            if (message == null || message.what != 20 || this.u) {
                return;
            }
            this.q.setVisibility(4);
            this.f3306h.removeMessages(20);
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = false;
        this.y = 1.0f;
        this.z = "speed";
        this.A = new a(this);
    }
}
