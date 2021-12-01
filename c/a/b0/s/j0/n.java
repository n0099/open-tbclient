package c.a.b0.s.j0;

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
import c.a.b0.s.v;
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
public class n extends j implements View.OnClickListener, c.a.b0.s.f0.f {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable A;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f1982i;

    /* renamed from: j  reason: collision with root package name */
    public BdVideoSeekbarImageView f1983j;

    /* renamed from: k  reason: collision with root package name */
    public BdVideoSeekbarImageView f1984k;
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
        public final /* synthetic */ n f1985e;

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
            this.f1985e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f1985e.x) {
                n nVar = this.f1985e;
                nVar.u0(Math.max(0, nVar.getCurrentPosition() - 5));
                Handler handler = this.f1985e.f1970h;
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
        public final /* synthetic */ n f1986e;

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
            this.f1986e = nVar;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                n nVar = this.f1986e;
                Context context = nVar.f1969g;
                if (context != null) {
                    nVar.r.f(context);
                }
                if (this.f1986e.x) {
                    this.f1986e.r0();
                }
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.f1986e.v().p1()) {
                    if (this.f1986e.x) {
                        if (motionEvent.getAction() == 1 || !this.f1986e.v().Y()) {
                            this.f1986e.r0();
                        }
                        return true;
                    } else if (!this.f1986e.v().V0() || v.W0() || this.f1986e.v().A() == null || this.f1986e.v().A().getContentView() == null || this.f1986e.v().A().V() == null || !this.f1986e.v().A().getContentView().onTouchEvent(motionEvent)) {
                        if (this.f1986e.s0() && getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        IVideoUpdateStrategy n1 = this.f1986e.v().n1();
                        if (!n1.b()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        if (n1.c()) {
                            boolean V0 = this.f1986e.v().V0();
                            if (this.f1986e.v().o1() != null) {
                                this.f1986e.v().o1().getPage();
                            }
                            if (V0 && !this.f1986e.n0() && this.f1986e.q0(motionEvent)) {
                                return true;
                            }
                            if (this.f1986e.s.onTouchEvent(motionEvent) && this.f1986e.Z()) {
                                return true;
                            }
                            if (!v.W0() && this.f1986e.l0()) {
                                if (!this.f1986e.v().V0()) {
                                    this.f1986e.b0(motionEvent);
                                }
                                if (this.f1986e.n0()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    return true;
                                } else if (this.f1986e.r.b(motionEvent)) {
                                    return true;
                                }
                            }
                            if (motionEvent.getAction() == 0) {
                                return this.f1986e.p0(motionEvent);
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
        public final /* synthetic */ n f1987e;

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
            this.f1987e = nVar;
        }

        public final void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                n nVar = this.f1987e;
                if (nVar.f1982i == null) {
                    nVar.x = false;
                    return;
                }
                if (nVar.v().W()) {
                    this.f1987e.v().l0();
                }
                if (this.f1987e.v().Y()) {
                    if (this.f1987e.f1982i.getParent() != null) {
                        this.f1987e.f1982i.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.f1987e.x = true;
                    if (this.f1987e.v().V0() && v.W0()) {
                        if (this.f1987e.q.getVisibility() == 0) {
                            this.f1987e.z0();
                        }
                    } else {
                        this.f1987e.G(c.a.b0.s.c0.f.w("layer_event_long_press"));
                    }
                    boolean z = ((double) motionEvent.getX()) > ((double) this.f1987e.f1982i.getWidth()) / 2.0d;
                    if (z) {
                        this.f1987e.z = "speed";
                        this.f1987e.v().z0(this.f1987e.e0());
                    } else {
                        this.f1987e.z = "backward";
                        n nVar2 = this.f1987e;
                        nVar2.f1970h.post(nVar2.A);
                    }
                    if (this.f1987e.v().y() != null) {
                        this.f1987e.v().y().D(z, true);
                    }
                }
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.f1987e.v().Q() && !this.f1987e.v().R()) {
                    if (this.f1987e.k0()) {
                        c(motionEvent);
                    } else {
                        this.f1987e.z0();
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
                this.f1987e.f1982i.setVisibility(0);
                if (motionEvent.getAction() != 0 || this.f1987e.v().Q()) {
                    return false;
                }
                this.f1987e.G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                c.a.b0.s.f v = this.f1987e.v();
                if (v == null || v.y() == null || v.W0()) {
                    return false;
                }
                return v.y().x(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && this.f1987e.Z() && this.f1987e.a0()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1927726721, "Lc/a/b0/s/j0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1927726721, "Lc/a/b0/s/j0/n;");
                return;
            }
        }
        B = c.a.b0.e0.a.d.b.a(124.0f);
        C = c.a.b0.e0.a.d.b.a(85.0f);
        D = c.a.b0.e0.a.d.b.a(119.0f);
        E = c.a.b0.e0.a.d.b.a(50.0f);
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

    @Override // c.a.b0.s.j0.b
    public void A(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.A(message);
            if (message == null || message.what != 20 || this.u) {
                return;
            }
            this.q.setVisibility(4);
            this.f1970h.removeMessages(20);
        }
    }

    public final void A0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeekbarImageView) == null) {
            if (v().V0()) {
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

    @Override // c.a.b0.s.j0.b
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j0();
            this.f1982i = new b(this, this.f1969g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.b0.e0.a.d.b.a(300.0f), c.a.b0.e0.a.d.b.a(300.0f));
            this.o = new BdVideoNewCacheView(this.f1969g);
            x0(false);
            layoutParams.gravity = 17;
            this.f1982i.addView(this.o, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = c.a.b0.e0.a.d.b.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.f1969g, 2);
            this.p = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.p.setDragable(false);
            this.f1982i.addView(this.p, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.f1969g);
            this.q = lockImageView;
            lockImageView.setBackground(this.f1969g.getResources().getDrawable(c.a.b0.h0.q.nad_videoplayer_playbtn_bg));
            this.q.updateLockState(v.W0() ? 1000 : 2000);
            this.q.setOnClickListener(this);
            this.q.setVisibility(4);
            this.f1982i.addView(this.q, f0());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView d0 = d0();
            this.f1983j = d0;
            if (d0 == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.f1969g);
                this.f1983j = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(c.a.b0.h0.q.nad_videoplayer_player_seek_forward);
                this.f1983j.setWidth(c.a.b0.e0.a.d.b.a(124.0f));
                this.f1983j.setHeight(c.a.b0.e0.a.d.b.a(85.0f));
            }
            this.f1983j.setVisibility(4);
            this.f1982i.addView(this.f1983j, layoutParams3);
            BdVideoSeekbarImageView c0 = c0();
            this.f1984k = c0;
            if (c0 == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.f1969g);
                this.f1984k = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(c.a.b0.h0.q.nad_videoplayer_player_seek_back);
                this.f1984k.setWidth(c.a.b0.e0.a.d.b.a(124.0f));
                this.f1984k.setHeight(c.a.b0.e0.a.d.b.a(85.0f));
            }
            this.f1984k.setVisibility(4);
            this.f1982i.addView(this.f1984k, layoutParams3);
            if (!this.v) {
                BdVideoPopImageView bdVideoPopImageView = new BdVideoPopImageView(this.f1969g);
                this.l = bdVideoPopImageView;
                bdVideoPopImageView.setIcon(c.a.b0.h0.q.nad_videoplayer_player_volume_open_big);
                this.l.setMsg("100%");
                this.l.setVisibility(4);
                this.f1982i.addView(this.l, layoutParams3);
                BdVideoPopImageView bdVideoPopImageView2 = new BdVideoPopImageView(this.f1969g);
                this.m = bdVideoPopImageView2;
                bdVideoPopImageView2.setMsg("0%");
                this.m.setIcon(c.a.b0.h0.q.nad_videoplayer_player_volume_close_big);
                this.m.setVisibility(4);
                this.f1982i.addView(this.m, layoutParams3);
            }
            BdVideoPopImageView bdVideoPopImageView3 = new BdVideoPopImageView(this.f1969g);
            this.n = bdVideoPopImageView3;
            bdVideoPopImageView3.setMsg("0%");
            this.n.setIcon(c.a.b0.h0.q.nad_videoplayer_player_bright);
            this.n.setVisibility(4);
            this.f1982i.addView(this.n, layoutParams3);
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? v().V0() : invokeV.booleanValue;
    }

    public void b0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
        }
    }

    @Override // c.a.b0.s.f0.f
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public BdVideoSeekbarImageView c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    @Override // c.a.b0.s.f0.f
    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            int r = v().r();
            int o0 = o0(i3 + i2, r);
            int i4 = o0 - i2;
            boolean z = r >= 3600;
            String a2 = c.a.b0.d0.c.a(o0, z);
            String a3 = c.a.b0.d0.c.a(r, z);
            if (i4 >= 0) {
                this.f1983j.setVisibility(0);
                this.f1984k.setVisibility(8);
                this.f1983j.setMsg(a2, a3);
                this.f1983j.refreshPositionAndDuration(o0, r);
                if (d0() == null) {
                    A0(this.f1983j);
                }
            } else {
                this.f1983j.setVisibility(8);
                this.f1984k.setVisibility(0);
                this.f1984k.setMsg(a2, a3);
                this.f1984k.refreshPositionAndDuration(o0, r);
                if (c0() == null) {
                    A0(this.f1984k);
                }
            }
            this.f1984k.requestLayout();
            this.f1983j.requestLayout();
            c.a.b0.s.c0.p w = c.a.b0.s.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE);
            w.n(2, Integer.valueOf(i2));
            w.n(3, Integer.valueOf(i4));
            G(w);
        }
    }

    public BdVideoSeekbarImageView d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
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
                    x0(true);
                } else if (702 == g2) {
                    x0(false);
                } else if (904 == g2 || g2 == 956) {
                    x0(false);
                    if (m0()) {
                        w0();
                    }
                }
            } else if (c2 == 1) {
                this.f1982i.setVisibility(4);
                this.r.g();
                h0();
            } else if (c2 == 2 || c2 == 3) {
                x0(false);
            } else if (c2 != 4) {
                if (c2 == 5 && this.x) {
                    r0();
                }
            } else {
                this.p.setProgress(0);
            }
        }
    }

    public final float e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.y = v().G();
            float min = Math.min(this.y * c.a.b0.s.v0.s.j(), c.a.b0.s.v0.s.i());
            return min > 0.0f ? min : this.y;
        }
        return invokeV.floatValue;
    }

    public FrameLayout.LayoutParams f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.b0.e0.a.d.b.a(37.0f), c.a.b0.e0.a.d.b.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = c.a.b0.e0.a.d.b.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    @Override // c.a.b0.s.f0.f
    public void g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            if (v().f1() == 1) {
                v().y().v();
                return;
            }
            int b2 = (int) ((f2 / c.a.b0.s.v0.k.b(this.f1969g)) * 100.0f);
            if (c.a.b0.s.v0.k.c(this.f1969g) == 0) {
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
            c.a.b0.s.v0.k.d(c.a.b0.e.a.b(), (int) f2);
            c.a.b0.s.c0.p w = c.a.b0.s.c0.f.w(LayerEvent.ACTION_ADJUST_VOLUME);
            w.n(20, Integer.valueOf(b2));
            G(w);
            c.a.b0.s.v0.h.b("GestureLayer", "onVolumeSlide : " + f2);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.u) {
                this.p.setVisibility(4);
            } else {
                this.p.setVisibility(0);
            }
        }
    }

    @Override // c.a.b0.s.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1982i : (View) invokeV.objValue;
    }

    @Override // c.a.b0.s.f0.f
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? v().C() : invokeV.intValue;
    }

    @Override // c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new int[]{4, 2, 3, 5} : (int[]) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f1983j.setVisibility(4);
            this.f1984k.setVisibility(4);
            if (!this.v) {
                this.l.setVisibility(4);
                this.m.setVisibility(4);
            }
            this.n.setVisibility(4);
            G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void i(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, playerStatus, playerStatus2) == null) {
            super.i(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f1982i.setVisibility(0);
                x0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                x0(true);
                this.f1982i.setVisibility(0);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f1970h.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    @Override // c.a.b0.s.f0.f
    public void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            if (v().f1() == 1) {
                v().y().v();
                return;
            }
            this.n.setVisibility(0);
            this.n.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.n;
            bdVideoPopImageView.setMsg(((int) ((f2 / 255.0f) * 100.0f)) + "%");
            c.a.b0.d0.n.d(getActivity(), (int) f2);
            G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_ADJUST_LIGHT));
            c.a.b0.s.v0.h.b("GestureLayer", "onBrightSlide : " + f2);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.r = new c.a.b0.s.d0.b(this.f1969g, this);
            this.t = new c(this);
            this.s = new GestureDetector(this.f1969g, this.t);
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (v().V0() && v.W0()) ? false : true : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pVar) == null) {
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
                        x0(true);
                        return;
                    }
                    return;
                case 1:
                    this.q.setVisibility(4);
                    h0();
                    t0();
                    return;
                case 2:
                    v0();
                    return;
                case 3:
                default:
                    return;
                case 4:
                case 5:
                    x0(false);
                    return;
                case 6:
                    this.u = ((Boolean) pVar.f(9)).booleanValue();
                    g0();
                    if (v().V0()) {
                        this.f1970h.removeMessages(20);
                        if (!v.W0()) {
                            this.q.setVisibility(this.u ? 0 : 4);
                            return;
                        } else {
                            i0();
                            return;
                        }
                    } else if (v().U0()) {
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

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? v().V0() : invokeV.booleanValue;
    }

    @Override // c.a.b0.s.f0.f
    public void m(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            u0((int) (i2 + f2));
        }
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? Z() && c.a.b0.s.v0.s.q() && a0() && v().r() >= 60 : invokeV.booleanValue;
    }

    @Override // c.a.b0.s.f0.f
    public void n(BdVideoGesture.VideoPluginGesture videoPluginGesture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, videoPluginGesture) == null) {
            h0();
            if (videoPluginGesture == BdVideoGesture.VideoPluginGesture.InitChange) {
                v().y().w();
            } else {
                v().y().v();
            }
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int o0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048606, this, i2, i3)) == null) {
            if (i2 < 0) {
                return 0;
            }
            return i2 > i3 ? i3 : i2;
        }
        return invokeII.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, view) == null) && view.equals(this.q)) {
            v().a1();
            this.q.animateToggle();
            c.a.b0.s.q0.b.c().d(c.a.b0.s.c0.f.w(LayerEvent.ACTION_LOCK_SCREEN));
            v().y().E(v.W0());
        }
    }

    @Override // c.a.b0.s.j0.j, c.a.b0.s.j0.b, c.a.b0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onLayerRelease();
            this.r.h();
            this.s.setOnDoubleTapListener(null);
        }
    }

    @Override // c.a.b0.s.f0.f
    public Activity p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    public boolean p0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.b0.s.f0.f
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? v().Q() : invokeV.booleanValue;
    }

    public final boolean q0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
            if (v.W0()) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void r(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, pVar) == null) {
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
                y0(pVar.g(1), pVar.g(2), pVar.g(3));
            } else if (c2 != 1) {
            } else {
                this.f1982i.setVisibility(0);
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.x = false;
            boolean equals = TextUtils.equals(this.z, "speed");
            if (equals) {
                v().z0(this.y);
            } else {
                this.f1970h.removeCallbacks(this.A);
            }
            if (v().y() != null) {
                v().y().D(equals, false);
            }
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            c.a.b0.s.v0.r.i(this);
        }
    }

    public final void u0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            int r = v().r();
            if (r > 1 && i2 > (i3 = r - 1)) {
                i2 = i3;
            }
            v().o0(i2);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            c.a.b0.s.v0.r.k(this);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public void x0(boolean z) {
        BdVideoCacheView bdVideoCacheView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && this.w && (bdVideoCacheView = this.o) != null) {
            if (z) {
                bdVideoCacheView.startCacheRotation(0);
            } else {
                bdVideoCacheView.startCacheRotation(4);
            }
        }
    }

    public void y0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048621, this, i2, i3, i4) == null) {
            if (v().r1()) {
                i2 = v().k1();
                i3 = v().j1();
            }
            this.p.syncPos(i2, i3, i4);
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f1970h.removeMessages(20);
            if (this.q.getVisibility() != 0) {
                this.q.setVisibility(0);
                i0();
                return;
            }
            this.q.setVisibility(4);
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
