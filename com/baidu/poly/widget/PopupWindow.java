package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P;
    public static final int[] Q;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int[] B;
    public int[] C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public boolean G;
    public int H;
    public b I;
    public boolean J;
    public int K;
    public WeakReference<View> L;
    public ViewTreeObserver.OnScrollChangedListener M;
    public int N;
    public int O;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f28245b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28246c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28247d;

    /* renamed from: e  reason: collision with root package name */
    public View f28248e;

    /* renamed from: f  reason: collision with root package name */
    public View f28249f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28250g;

    /* renamed from: h  reason: collision with root package name */
    public int f28251h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public View.OnTouchListener s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow a;

        public a(PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popupWindow;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View view = this.a.L != null ? (View) this.a.L.get() : null;
                if (view == null || this.a.f28249f == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.a.f28249f.getLayoutParams();
                PopupWindow popupWindow = this.a;
                popupWindow.F(popupWindow.p(view, layoutParams, popupWindow.N, this.a.O));
                this.a.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PopupWindow popupWindow, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupWindow, context};
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
            this.a = popupWindow;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            KeyEvent.DispatcherState keyDispatcherState;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
                if (keyEvent.getKeyCode() == 4) {
                    if (getKeyDispatcherState() == null) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                        if (keyDispatcherState2 != null) {
                            keyDispatcherState2.startTracking(keyEvent, this);
                        }
                        return true;
                    } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                        this.a.n();
                        return true;
                    } else {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.a.s == null || !this.a.s.onTouch(this, motionEvent)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (this.a.G) {
                    int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                    View.mergeDrawableStates(onCreateDrawableState, PopupWindow.Q);
                    return onCreateDrawableState;
                }
                return super.onCreateDrawableState(i);
            }
            return (int[]) invokeI.objValue;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                    this.a.n();
                    return true;
                } else if (motionEvent.getAction() == 4) {
                    this.a.n();
                    return true;
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (this.a.f28248e != null) {
                    this.a.f28248e.sendAccessibilityEvent(i);
                } else {
                    super.sendAccessibilityEvent(i);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997996629, "Lcom/baidu/poly/widget/PopupWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997996629, "Lcom/baidu/poly/widget/PopupWindow;");
                return;
            }
        }
        P = h.f2807d;
        Q = new int[]{16842922};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.I = bVar;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = z;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.u = i;
        }
    }

    public void D(View view, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, view, i, i2, i3) == null) {
            o(view.getWindowToken(), i, i2, i3);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WeakReference<View> weakReference = this.L;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.M);
            }
            this.L = null;
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || z == this.G) {
            return;
        }
        this.G = z;
        if (this.D != null) {
            Drawable drawable = this.E;
            if (drawable == null) {
                this.f28249f.refreshDrawableState();
            } else if (z) {
                this.f28249f.setBackgroundDrawable(drawable);
            } else {
                this.f28249f.setBackgroundDrawable(this.F);
            }
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.K;
            if (i == -1) {
                if (this.f28247d) {
                    return this.G ? R.style.obfuscated_res_0x7f100163 : R.style.obfuscated_res_0x7f100162;
                }
                return 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r4.f28251h == 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r4.f28251h == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r5 = r5 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int i2 = i & (-8815129);
            if (this.J) {
                i2 |= 32768;
            }
            if (!this.f28250g) {
                i2 |= 8;
            }
            if (!this.j) {
                i2 |= 16;
            }
            if (this.k) {
                i2 |= 262144;
            }
            if (!this.l) {
                i2 |= 512;
            }
            if (s()) {
                i2 |= 8388608;
            }
            if (this.n) {
                i2 |= 256;
            }
            if (this.q) {
                i2 |= 65536;
            }
            return this.r ? i2 | 32 : i2;
        }
        return invokeI.intValue;
    }

    public final WindowManager.LayoutParams m(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iBinder)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 51;
            int i = this.u;
            this.v = i;
            layoutParams.width = i;
            int i2 = this.x;
            this.y = i2;
            layoutParams.height = i2;
            Drawable drawable = this.D;
            if (drawable != null) {
                layoutParams.format = drawable.getOpacity();
            } else {
                layoutParams.format = -3;
            }
            layoutParams.flags = l(layoutParams.flags);
            layoutParams.type = this.H;
            layoutParams.token = iBinder;
            layoutParams.softInputMode = this.i;
            layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    public void n() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && r() && this.f28249f != null) {
            this.f28246c = false;
            E();
            try {
                try {
                    this.f28245b.removeView(this.f28249f);
                    View view = this.f28249f;
                    View view2 = this.f28248e;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.f28249f = null;
                    bVar = this.I;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e2) {
                    if (!P) {
                        View view3 = this.f28249f;
                        View view4 = this.f28248e;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.f28249f = null;
                        bVar = this.I;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e2;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.f28249f;
                View view6 = this.f28248e;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.f28249f = null;
                b bVar2 = this.I;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public void o(IBinder iBinder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048586, this, iBinder, i, i2, i3) == null) || iBinder == null || r() || this.f28248e == null) {
            return;
        }
        E();
        this.f28246c = true;
        this.f28247d = false;
        WindowManager.LayoutParams m = m(iBinder);
        m.windowAnimations = k();
        t(m);
        if (i == 0) {
            i = 51;
        }
        m.gravity = i;
        m.x = i2;
        m.y = i3;
        int i4 = this.w;
        if (i4 < 0) {
            this.y = i4;
            m.height = i4;
        }
        int i5 = this.t;
        if (i5 < 0) {
            this.v = i5;
            m.width = i5;
        }
        q(m);
    }

    public final boolean p(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, view, layoutParams, i, i2)) == null) {
            int height = view.getHeight();
            view.getLocationInWindow(this.B);
            int[] iArr = this.B;
            layoutParams.x = iArr[0] + i;
            layoutParams.y = iArr[1] + height + i2;
            layoutParams.gravity = 51;
            view.getLocationOnScreen(this.C);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            View rootView = view.getRootView();
            if (this.C[1] + height + i2 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
                if (this.p) {
                    int scrollX = view.getScrollX();
                    int scrollY = view.getScrollY();
                    view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i, this.A + scrollY + view.getHeight() + i2), true);
                }
                view.getLocationInWindow(this.B);
                int[] iArr2 = this.B;
                layoutParams.x = iArr2[0] + i;
                layoutParams.y = iArr2[1] + view.getHeight() + i2;
                view.getLocationOnScreen(this.C);
                r2 = ((rect.bottom - this.C[1]) - view.getHeight()) - i2 < (this.C[1] - i2) - rect.top;
                if (r2) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.B[1]) + i2;
                } else {
                    layoutParams.y = this.B[1] + view.getHeight() + i2;
                }
            }
            if (this.o) {
                int i3 = rect.right - rect.left;
                int i4 = layoutParams.x;
                int i5 = layoutParams.width + i4;
                if (i5 > i3) {
                    layoutParams.x = i4 - (i5 - i3);
                }
                int i6 = layoutParams.x;
                int i7 = rect.left;
                if (i6 < i7) {
                    layoutParams.x = i7;
                    layoutParams.width = Math.min(layoutParams.width, i3);
                }
                if (r2) {
                    int i8 = (this.C[1] + i2) - this.A;
                    if (i8 < 0) {
                        layoutParams.y += i8;
                    }
                } else {
                    layoutParams.y = Math.max(layoutParams.y, rect.top);
                }
            }
            layoutParams.gravity |= LaunchTaskConstants.OTHER_PROCESS;
            return r2;
        }
        return invokeLLII.booleanValue;
    }

    public final void q(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, layoutParams) == null) {
            Context context = this.a;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            this.f28245b.addView(this.f28249f, layoutParams);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f28246c : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.m >= 0 || (context = this.a) == null) ? this.m == 1 : context.getApplicationInfo().targetSdkVersion >= 11 : invokeV.booleanValue;
    }

    public final void t(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            View view = this.f28248e;
            if (view != null && this.a != null && this.f28245b != null) {
                if (this.D != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    int i = -2;
                    i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    c cVar = new c(this, this.a);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                    cVar.setBackgroundDrawable(this.D);
                    cVar.addView(this.f28248e, layoutParams3);
                    this.f28249f = cVar;
                } else {
                    this.f28249f = view;
                }
                this.z = layoutParams.width;
                this.A = layoutParams.height;
                return;
            }
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
    }

    public final void u(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, view, i, i2) == null) {
            E();
            this.L = new WeakReference<>(view);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.M);
            }
            this.N = i;
            this.O = i2;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && r() && this.f28248e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f28249f.getLayoutParams();
            boolean z = false;
            int k = k();
            boolean z2 = true;
            if (k != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = k;
                z = true;
            }
            int l = l(layoutParams.flags);
            if (l != layoutParams.flags) {
                layoutParams.flags = l;
            } else {
                z2 = z;
            }
            if (z2) {
                this.f28245b.updateViewLayout(this.f28249f, layoutParams);
            }
        }
    }

    public void v(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, drawable) == null) {
            this.D = drawable;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.l = z;
        }
    }

    public void x(View view) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, view) == null) || r()) {
            return;
        }
        this.f28248e = view;
        if (this.a == null && view != null) {
            this.a = view.getContext();
        }
        if (this.f28245b != null || this.f28248e == null || (context = this.a) == null) {
            return;
        }
        this.f28245b = (WindowManager) context.getSystemService("window");
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f28250g = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.x = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f28251h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.B = new int[2];
        this.C = new int[2];
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a(this);
        this.a = context;
        this.f28245b = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843126, 16843465, R.attr.overlapAnchor, R.attr.obfuscated_res_0x7f04049b, R.attr.obfuscated_res_0x7f04049c}, i, i2);
        this.D = obtainStyledAttributes.getDrawable(4);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        this.K = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f28249f.getLayoutParams();
            update(layoutParams.x, layoutParams.y, i, i2, false);
        }
    }

    public void update(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i, i2, i3, i4) == null) {
            update(i, i2, i3, i4, false);
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (i3 != -1) {
                this.v = i3;
                C(i3);
            }
            if (i4 != -1) {
                this.y = i4;
                z(i4);
            }
            if (!r() || this.f28248e == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f28249f.getLayoutParams();
            int i5 = this.t;
            if (i5 >= 0) {
                i5 = this.v;
            }
            boolean z2 = true;
            if (i3 != -1 && layoutParams.width != i5) {
                this.v = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.w;
            if (i6 >= 0) {
                i6 = this.y;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.y = i6;
                layoutParams.height = i6;
                z = true;
            }
            if (layoutParams.x != i) {
                layoutParams.x = i;
                z = true;
            }
            if (layoutParams.y != i2) {
                layoutParams.y = i2;
                z = true;
            }
            int k = k();
            if (k != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = k;
                z = true;
            }
            int l = l(layoutParams.flags);
            if (l != layoutParams.flags) {
                layoutParams.flags = l;
            } else {
                z2 = z;
            }
            if (z2) {
                this.f28245b.updateViewLayout(this.f28249f, layoutParams);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow() {
        this((View) null, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((View) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.f28251h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.B = new int[2];
        this.C = new int[2];
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a(this);
        if (view != null) {
            Context context = view.getContext();
            this.a = context;
            this.f28245b = (WindowManager) context.getSystemService("window");
        }
        x(view);
        C(i);
        z(i2);
        y(z);
    }

    public void update(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048597, this, view, i, i2) == null) {
            update(view, false, 0, 0, true, i, i2);
        }
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            update(view, true, i, i2, true, i3, i4);
        }
    }

    private void update(View view, boolean z, int i, int i2, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = i3;
            int i6 = i4;
            if (!r() || this.f28248e == null) {
                return;
            }
            WeakReference<View> weakReference = this.L;
            boolean z3 = false;
            boolean z4 = z && !(this.N == i && this.O == i2);
            if (weakReference == null || weakReference.get() != view || (z4 && !this.f28247d)) {
                u(view, i, i2);
            } else if (z4) {
                this.N = i;
                this.O = i2;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f28249f.getLayoutParams();
            if (z2) {
                if (i5 == -1) {
                    i5 = this.z;
                } else {
                    this.z = i5;
                }
                if (i6 == -1) {
                    i6 = this.A;
                } else {
                    this.A = i6;
                }
            }
            int i7 = layoutParams.x;
            int i8 = layoutParams.y;
            if (z) {
                F(p(view, layoutParams, i, i2));
            } else {
                F(p(view, layoutParams, this.N, this.O));
            }
            int i9 = layoutParams.x;
            int i10 = layoutParams.y;
            update(i9, i10, i5, i6, (i7 == i9 && i8 == i10) ? true : true);
        }
    }
}
