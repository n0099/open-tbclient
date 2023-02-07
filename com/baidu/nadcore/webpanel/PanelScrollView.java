package com.baidu.nadcore.webpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.R;
import com.baidu.tieba.b51;
import com.baidu.tieba.k71;
import com.baidu.tieba.l71;
import com.baidu.tieba.m71;
import com.baidu.tieba.o71;
import com.baidu.tieba.pb1;
import com.baidu.tieba.q71;
import com.baidu.tieba.sm0;
import com.baidu.tieba.w71;
import com.baidu.tieba.x71;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PanelScrollView extends FrameLayout implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public q71 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public ObjectAnimator j;
    public int k;
    public int l;
    public k71 m;
    public m71 n;
    public o71 o;
    public GestureDetector p;
    public d q;
    public c r;
    public ExpandIconView s;
    public int t;
    public int u;
    public int v;
    public int w;
    public long x;
    public boolean y;
    public VelocityTracker z;

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelScrollView a;

        public a(PanelScrollView panelScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PanelScrollView panelScrollView = this.a;
                panelScrollView.e = panelScrollView.getMeasuredHeight();
                this.a.t();
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelScrollView a;

        public b(PanelScrollView panelScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelScrollView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.a.l = 0;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.l = 0;
                FrameLayout.LayoutParams webViewLayoutParams = this.a.getWebViewLayoutParams();
                if (webViewLayoutParams != null) {
                    webViewLayoutParams.height = (this.a.e - webViewLayoutParams.topMargin) + PanelScrollView.A;
                    this.a.n.i(webViewLayoutParams);
                    int i = webViewLayoutParams.topMargin;
                    if (i != 0) {
                        if (i != this.a.g || webViewLayoutParams.height != (this.a.e - this.a.g) + PanelScrollView.A) {
                            return;
                        }
                        this.a.m(1, false);
                        return;
                    }
                    this.a.m(2, false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PanelScrollView a;
        public float b;
        public float c;

        public e(PanelScrollView panelScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 0.0f;
            this.c = 0.0f;
            this.a = panelScrollView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.b != motionEvent.getX() || this.c != motionEvent.getY()) {
                    this.b = motionEvent.getX();
                    this.c = motionEvent.getY();
                    PanelScrollView panelScrollView = this.a;
                    if (panelScrollView != null && panelScrollView.r != null) {
                        this.a.r.a();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                PanelScrollView panelScrollView = this.a;
                if (panelScrollView != null && panelScrollView.r != null) {
                    this.a.q.a();
                }
                return super.onSingleTapUp(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1897983351, "Lcom/baidu/nadcore/webpanel/PanelScrollView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1897983351, "Lcom/baidu/nadcore/webpanel/PanelScrollView;");
                return;
            }
        }
        A = b51.c.a(pb1.a(), 18.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams getWebViewLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.n.b() == null) {
                return null;
            }
            ViewGroup.LayoutParams b2 = this.n.b();
            if (!(b2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            return (FrameLayout.LayoutParams) b2;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    @Keep
    public int getAnimateValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final void n() {
        FrameLayout.LayoutParams webViewLayoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (webViewLayoutParams = getWebViewLayoutParams()) != null) {
            if (webViewLayoutParams.topMargin == 0) {
                this.n.f();
            } else {
                this.n.v();
            }
        }
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
            if (webViewLayoutParams == null) {
                return -1;
            }
            int i = webViewLayoutParams.topMargin;
            if (i == 0) {
                return 2;
            }
            if (i != this.g) {
                return -1;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    public final void m(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.n.t(i, z);
            if (!z) {
                if (i == 1) {
                    sm0.a().a(new l71(4, this.d.a()));
                    q71 q71Var = this.d;
                    if (q71Var != null) {
                        w71.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", "down", q71Var.c());
                    }
                } else if (i == 2) {
                    sm0.a().a(new l71(3, this.d.a()));
                    q71 q71Var2 = this.d;
                    if (q71Var2 != null) {
                        w71.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, q71Var2.c());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    private void setExpandIconView(int i) {
        ExpandIconView expandIconView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65551, this, i) != null) || (expandIconView = this.s) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        layoutParams.topMargin = i;
        this.s.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            this.p.onTouchEvent(motionEvent);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final int p(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
            if (webViewLayoutParams == null || i < (i2 = webViewLayoutParams.topMargin)) {
                return 0;
            }
            if (i < i2 + this.f) {
                return 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Keep
    public void setAnimateValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
            w(i - this.l);
            this.l = i;
        }
    }

    public void setOnGestureScrollListener(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void setOnGestureSingleTapUpListener(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.q = dVar;
        }
    }

    public void setPanelData(q71 q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, q71Var) == null) {
            this.d = q71Var;
            String g = q71Var.g();
            if (!TextUtils.isEmpty(g)) {
                this.m.g(g);
            }
            this.m.k(q71Var.s());
        }
    }

    public void k(@NonNull m71 m71Var, o71 o71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m71Var, o71Var) == null) {
            this.n = m71Var;
            this.o = o71Var;
            m71Var.o(this);
            this.n.p(this.m);
            this.n.u(o71Var);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m = new k71();
            setClipChildren(false);
            setLayerType(2, null);
            setOnTouchListener(this);
            getViewTreeObserver().addOnPreDrawListener(new a(this));
            if (Build.VERSION.SDK_INT >= 21) {
                this.h = ((Activity) getContext()).getWindow().getStatusBarColor();
            } else {
                this.h = ((Activity) getContext()).getResources().getColor(R.color.nad_transparent);
            }
            this.p = new GestureDetector(getContext(), new e(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.d.j() || !(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams != null) {
            if (webViewLayoutParams.topMargin == 0) {
                x71.d(activity.getWindow(), 17170443);
                if (Build.VERSION.SDK_INT >= 23) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 8192);
                    return;
                }
                return;
            }
            x71.d(activity.getWindow(), this.h);
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
            }
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            o();
            n();
            if (this.n.n()) {
                FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
                if (webViewLayoutParams != null) {
                    int i9 = webViewLayoutParams.topMargin;
                    if (i9 == 0) {
                        m(2, false);
                    } else if (i9 == this.g) {
                        m(1, false);
                    }
                }
                this.n.m(false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, motionEvent)) == null) {
            if (this.z == null) {
                this.z = VelocityTracker.obtain();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            this.y = false;
                            this.i = false;
                        }
                    } else {
                        this.z.addMovement(motionEvent);
                        this.z.computeCurrentVelocity(1000);
                        this.v = ((int) motionEvent.getRawX()) - this.t;
                        this.w = ((int) motionEvent.getRawY()) - this.u;
                        this.t = (int) motionEvent.getRawX();
                        this.u = (int) motionEvent.getRawY();
                        if (Math.abs(this.v) >= Math.abs(this.w)) {
                            return false;
                        }
                        int i = this.a;
                        if (i == 2) {
                            boolean v = v(true, this.w);
                            if (v && !this.y) {
                                int i2 = this.b;
                                if (i2 != -1) {
                                    m(i2, true);
                                }
                                this.y = true;
                            }
                            return v;
                        } else if (i != 1) {
                            return true;
                        } else {
                            boolean v2 = v(false, this.w);
                            if (v2 && !this.y) {
                                int i3 = this.b;
                                if (i3 != -1) {
                                    m(i3, true);
                                }
                                this.y = true;
                            }
                            return v2;
                        }
                    }
                } else {
                    int i4 = this.a;
                    if (i4 == 0) {
                        if (this.w >= 20) {
                            return false;
                        }
                        if (System.currentTimeMillis() - this.x < ViewConfiguration.getLongPressTimeout()) {
                            if (this.m.d()) {
                                this.n.a();
                                w71.a(ClogBuilder.LogType.FREE_CLICK, "", "top_area", this.d.c());
                                return true;
                            }
                            o71 o71Var = this.o;
                            if (o71Var != null) {
                                o71Var.a(0);
                            }
                        }
                        return true;
                    }
                    if (i4 == 1 || i4 == 2) {
                        if (!this.m.a() && this.b == 1) {
                            if (this.y && this.z.getYVelocity() > 800.0f) {
                                if (!this.m.b()) {
                                    this.y = false;
                                    this.o.a(2);
                                    return false;
                                }
                            } else if (this.y && this.z.getYVelocity() < -800.0f && !this.m.c()) {
                                FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
                                if (webViewLayoutParams == null) {
                                    this.y = false;
                                    return false;
                                }
                                this.i = true;
                                u(160, webViewLayoutParams.topMargin + A);
                                this.y = false;
                                return false;
                            }
                        }
                        if (this.y) {
                            FrameLayout.LayoutParams webViewLayoutParams2 = getWebViewLayoutParams();
                            if (webViewLayoutParams2 == null) {
                                this.y = false;
                                return false;
                            }
                            int i5 = webViewLayoutParams2.topMargin;
                            if (i5 <= this.g / 2 && i5 >= 0) {
                                this.i = true;
                                u(160, i5);
                            }
                            int i6 = this.g;
                            if (i5 > i6 / 2 && i5 < i6) {
                                this.i = false;
                                u(160, i6 - i5);
                                setExpandIconView(this.g - b51.c.a(getContext(), 17.0f));
                            }
                            int i7 = this.g;
                            if (i5 > i7 + ((this.e - i7) / 4)) {
                                this.o.a(2);
                            }
                            int i8 = this.g;
                            if (i5 > i8 && i5 < ((this.e - i8) / 4) + i8) {
                                this.i = true;
                                u(160, i5 - i8);
                                setExpandIconView(this.g - b51.c.a(getContext(), 17.0f));
                            }
                        }
                    }
                    this.y = false;
                }
                return false;
            }
            this.v = 0;
            this.w = 0;
            this.x = System.currentTimeMillis();
            this.a = p((int) motionEvent.getY());
            this.b = q();
            this.u = (int) motionEvent.getRawY();
            this.y = false;
            this.z.clear();
            this.z.addMovement(motionEvent);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.n.e(this);
            if (!(getContext() instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) getContext();
            x71.d(activity.getWindow(), this.h);
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f = b51.c.a(pb1.a(), 100.0f);
            if (this.d.d() == 0) {
                if (this.d.e() < 0.0d || this.d.e() > 1.0d) {
                    this.d.w(0.7d);
                }
                this.g = (int) (this.e * (1.0d - this.d.e()));
            } else {
                if (this.d.e() <= 0.0d) {
                    this.d.w(1.95d);
                }
                this.g = (int) (b51.c.e(pb1.a()) / this.d.e());
            }
            this.n.k((this.e - this.g) + A);
            this.n.g(this.g);
            this.m.m(this.e);
            this.m.l(this.g);
            this.n.s(this);
            if (this.d.q()) {
                ExpandIconView expandIconView = new ExpandIconView(getContext());
                this.s = expandIconView;
                expandIconView.setFraction(0.0f, false);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.height = b51.c.a(getContext(), 24.0f);
                layoutParams.width = b51.c.a(getContext(), 24.0f);
                layoutParams.gravity = 1;
                layoutParams.topMargin = this.g - b51.c.a(getContext(), 17.0f);
                addView(this.s, layoutParams);
            }
        }
    }

    public final void u(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "animateValue", 0, i2);
            this.j = ofInt;
            ofInt.setDuration(i);
            this.j.start();
            this.j.addListener(new b(this));
        }
    }

    public final boolean v(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this.m.a()) {
                return false;
            }
            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
            FrameLayout.LayoutParams layoutParams = null;
            ExpandIconView expandIconView = this.s;
            if (expandIconView != null) {
                layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
            }
            if (webViewLayoutParams == null) {
                return false;
            }
            if (this.c == 0 && this.b == 2 && this.a == 2) {
                return false;
            }
            int i2 = webViewLayoutParams.topMargin;
            if (i2 + i >= this.g && i2 + i < this.e) {
                if (this.m.b()) {
                    return false;
                }
                if (this.c == 0 && this.a == 2 && webViewLayoutParams.topMargin == this.g) {
                    return false;
                }
                if (z) {
                    if (!this.n.j()) {
                        return false;
                    }
                    this.n.g(webViewLayoutParams.topMargin + i);
                    if (layoutParams != null) {
                        setExpandIconView(layoutParams.topMargin + i);
                    }
                } else {
                    this.n.g(webViewLayoutParams.topMargin + i);
                    if (layoutParams != null) {
                        setExpandIconView(layoutParams.topMargin + i);
                    }
                }
                return true;
            } else if (i < 0 && webViewLayoutParams.topMargin <= 0) {
                return false;
            } else {
                if (i > 0) {
                    if (this.m.b()) {
                        return false;
                    }
                    if (z) {
                        if (!this.n.j()) {
                            return false;
                        }
                        webViewLayoutParams.topMargin += i;
                        if (layoutParams != null) {
                            layoutParams.topMargin += i;
                        }
                    } else {
                        webViewLayoutParams.topMargin += i;
                        if (layoutParams != null) {
                            layoutParams.topMargin += i;
                        }
                    }
                } else if (i >= 0 || this.m.c()) {
                    return false;
                } else {
                    webViewLayoutParams.topMargin += i;
                    if (layoutParams != null) {
                        layoutParams.topMargin += i;
                    }
                }
                int i3 = webViewLayoutParams.topMargin;
                int i4 = this.g;
                if (i3 > i4) {
                    webViewLayoutParams.topMargin = i4;
                }
                if (webViewLayoutParams.topMargin < 0) {
                    webViewLayoutParams.topMargin = 0;
                }
                int i5 = webViewLayoutParams.height;
                int i6 = this.e;
                int i7 = A;
                if (i5 != i6 + i7) {
                    webViewLayoutParams.height = i6 + i7;
                }
                this.n.i(webViewLayoutParams);
                if (layoutParams != null) {
                    setExpandIconView(layoutParams.topMargin);
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void w(int i) {
        FrameLayout.LayoutParams webViewLayoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048595, this, i) != null) || (webViewLayoutParams = getWebViewLayoutParams()) == null) {
            return;
        }
        if (this.i) {
            int i2 = webViewLayoutParams.topMargin - i;
            webViewLayoutParams.topMargin = i2;
            if (i2 < 0) {
                webViewLayoutParams.topMargin = 0;
            }
        } else {
            int i3 = webViewLayoutParams.topMargin + i;
            webViewLayoutParams.topMargin = i3;
            int i4 = this.g;
            if (i3 > i4) {
                webViewLayoutParams.topMargin = i4;
            }
        }
        this.n.i(webViewLayoutParams);
        o();
        n();
    }
}
