package com.baidu.swan.menu;

import android.annotation.SuppressLint;
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
import c.a.o0.k.l;
import c.a.o0.k.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
@SuppressLint({"ClickableViewAccessibility", "BDThrowableCheck", "SyntheticAccessor"})
/* loaded from: classes6.dex */
public class PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] T;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int[] F;
    public int[] G;
    public Drawable H;
    public Drawable I;
    public Drawable J;
    public boolean K;
    public int L;
    public b M;
    public boolean N;
    public int O;
    public WeakReference<View> P;
    public ViewTreeObserver.OnScrollChangedListener Q;
    public int R;
    public int S;

    /* renamed from: e  reason: collision with root package name */
    public Context f47073e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f47074f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47075g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47076h;

    /* renamed from: i  reason: collision with root package name */
    public View f47077i;

    /* renamed from: j  reason: collision with root package name */
    public View f47078j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public View.OnTouchListener w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f47079a;

        public a(PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47079a = popupWindow;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View view = this.f47079a.P != null ? (View) this.f47079a.P.get() : null;
                if (view == null || this.f47079a.f47078j == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f47079a.f47078j.getLayoutParams();
                PopupWindow popupWindow = this.f47079a;
                popupWindow.Y(popupWindow.u(view, layoutParams, popupWindow.R, this.f47079a.S));
                this.f47079a.X(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public class c extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f47080e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PopupWindow popupWindow, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupWindow, context};
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
            this.f47080e = popupWindow;
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
                        this.f47080e.r();
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
                if (this.f47080e.w == null || !this.f47080e.w.onTouch(this, motionEvent)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (this.f47080e.K) {
                    int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
                    View.mergeDrawableStates(onCreateDrawableState, PopupWindow.T);
                    return onCreateDrawableState;
                }
                return super.onCreateDrawableState(i2);
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
                    this.f47080e.r();
                    return true;
                } else if (motionEvent.getAction() == 4) {
                    this.f47080e.r();
                    return true;
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (this.f47080e.f47077i != null) {
                    this.f47080e.f47077i.sendAccessibilityEvent(i2);
                } else {
                    super.sendAccessibilityEvent(i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1253321311, "Lcom/baidu/swan/menu/PopupWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1253321311, "Lcom/baidu/swan/menu/PopupWindow;");
                return;
            }
        }
        T = new int[]{16842922};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void A(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, view, i2, i3) == null) {
            V();
            this.P = new WeakReference<>(view);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.Q);
            }
            this.R = i2;
            this.S = i3;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.O = i2;
        }
    }

    public void D(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            this.H = drawable;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.p = z;
        }
    }

    public void K(View view) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || x()) {
            return;
        }
        this.f47077i = view;
        if (this.f47073e == null && view != null) {
            this.f47073e = view.getContext();
        }
        if (this.f47074f != null || (context = this.f47073e) == null) {
            return;
        }
        this.f47074f = (WindowManager) context.getSystemService("window");
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.k = z;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.B = i2;
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }

    public void P(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.M = bVar;
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.y = i2;
        }
    }

    public void T(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, view, i2, i3) == null) {
            s(view, i2, i3);
        }
    }

    public void U(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048589, this, view, i2, i3, i4) == null) {
            t(view.getWindowToken(), i2, i3, i4);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            WeakReference<View> weakReference = this.P;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.Q);
            }
            this.P = null;
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && x() && this.f47077i != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f47078j.getLayoutParams();
            boolean z = false;
            int o = o();
            boolean z2 = true;
            if (o != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = o;
                z = true;
            }
            int p = p(layoutParams.flags);
            if (p != layoutParams.flags) {
                layoutParams.flags = p;
            } else {
                z2 = z;
            }
            if (z2) {
                this.f47074f.updateViewLayout(this.f47078j, layoutParams);
            }
        }
    }

    public void X(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            if (i4 != -1) {
                this.z = i4;
                S(i4);
            }
            if (i5 != -1) {
                this.C = i5;
                N(i5);
            }
            if (!x() || this.f47077i == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f47078j.getLayoutParams();
            int i6 = this.x;
            if (i6 >= 0) {
                i6 = this.z;
            }
            boolean z2 = true;
            if (i4 != -1 && layoutParams.width != i6) {
                this.z = i6;
                layoutParams.width = i6;
                z = true;
            }
            int i7 = this.A;
            if (i7 >= 0) {
                i7 = this.C;
            }
            if (i5 != -1 && layoutParams.height != i7) {
                this.C = i7;
                layoutParams.height = i7;
                z = true;
            }
            if (layoutParams.x != i2) {
                layoutParams.x = i2;
                z = true;
            }
            if (layoutParams.y != i3) {
                layoutParams.y = i3;
                z = true;
            }
            int o = o();
            if (o != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = o;
                z = true;
            }
            int p = p(layoutParams.flags);
            if (p != layoutParams.flags) {
                layoutParams.flags = p;
            } else {
                z2 = z;
            }
            if (z2) {
                this.f47074f.updateViewLayout(this.f47078j, layoutParams);
            }
        }
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || z == this.K) {
            return;
        }
        this.K = z;
        if (this.H != null) {
            Drawable drawable = this.I;
            if (drawable == null) {
                this.f47078j.refreshDrawableState();
            } else if (z) {
                this.f47078j.setBackgroundDrawable(drawable);
            } else {
                this.f47078j.setBackgroundDrawable(this.J);
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i2 = this.O;
            if (i2 == -1) {
                if (this.f47076h) {
                    return this.K ? l.PopupWindow_DropDownUp : l.PopupWindow_DropDownDown;
                }
                return 0;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r4.l == 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r4.l == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        r5 = r5 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int i3 = i2 & (-8815129);
            if (this.N) {
                i3 |= 32768;
            }
            if (!this.k) {
                i3 |= 8;
            }
            if (!this.n) {
                i3 |= 16;
            }
            if (this.o) {
                i3 |= 262144;
            }
            if (!this.p) {
                i3 |= 512;
            }
            if (y()) {
                i3 |= 8388608;
            }
            if (this.r) {
                i3 |= 256;
            }
            if (this.u) {
                i3 |= 65536;
            }
            return this.v ? i3 | 32 : i3;
        }
        return invokeI.intValue;
    }

    public final WindowManager.LayoutParams q(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, iBinder)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 51;
            int i2 = this.y;
            this.z = i2;
            layoutParams.width = i2;
            int i3 = this.B;
            this.C = i3;
            layoutParams.height = i3;
            Drawable drawable = this.H;
            if (drawable != null) {
                layoutParams.format = drawable.getOpacity();
            } else {
                layoutParams.format = -3;
            }
            layoutParams.flags = p(layoutParams.flags);
            layoutParams.type = this.L;
            layoutParams.token = iBinder;
            layoutParams.softInputMode = this.m;
            layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    public void r() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && x() && this.f47078j != null) {
            this.f47075g = false;
            V();
            try {
                this.f47074f.removeView(this.f47078j);
                View view = this.f47078j;
                View view2 = this.f47077i;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.f47078j = null;
                bVar = this.M;
                if (bVar == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                View view3 = this.f47078j;
                View view4 = this.f47077i;
                if (view3 != view4 && (view3 instanceof ViewGroup)) {
                    ((ViewGroup) view3).removeView(view4);
                }
                this.f47078j = null;
                bVar = this.M;
                if (bVar == null) {
                    return;
                }
            } catch (Throwable th) {
                View view5 = this.f47078j;
                View view6 = this.f47077i;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.f47078j = null;
                b bVar2 = this.M;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
            bVar.onDismiss();
        }
    }

    public void s(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048598, this, view, i2, i3) == null) || x() || this.f47077i == null) {
            return;
        }
        A(view, i2, i3);
        this.f47075g = true;
        this.f47076h = true;
        WindowManager.LayoutParams q = q(view.getWindowToken());
        z(q);
        Y(u(view, q, i2, i3));
        int i4 = this.A;
        if (i4 < 0) {
            this.C = i4;
            q.height = i4;
        }
        int i5 = this.x;
        if (i5 < 0) {
            this.z = i5;
            q.width = i5;
        }
        q.windowAnimations = o();
        w(q);
    }

    public void t(IBinder iBinder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048599, this, iBinder, i2, i3, i4) == null) || iBinder == null || x() || this.f47077i == null) {
            return;
        }
        V();
        this.f47075g = true;
        this.f47076h = false;
        WindowManager.LayoutParams q = q(iBinder);
        q.windowAnimations = o();
        z(q);
        if (i2 == 0) {
            i2 = 51;
        }
        q.gravity = i2;
        q.x = i3;
        q.y = i4;
        int i5 = this.A;
        if (i5 < 0) {
            this.C = i5;
            q.height = i5;
        }
        int i6 = this.x;
        if (i6 < 0) {
            this.z = i6;
            q.width = i6;
        }
        w(q);
    }

    public final boolean u(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, view, layoutParams, i2, i3)) == null) {
            int height = view.getHeight();
            view.getLocationInWindow(this.F);
            int[] iArr = this.F;
            layoutParams.x = iArr[0] + i2;
            layoutParams.y = iArr[1] + height + i3;
            layoutParams.gravity = 51;
            view.getLocationOnScreen(this.G);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            View rootView = view.getRootView();
            if (this.G[1] + height + i3 + this.E > rect.bottom || (layoutParams.x + this.D) - rootView.getWidth() > 0) {
                if (this.t) {
                    int scrollX = view.getScrollX();
                    int scrollY = view.getScrollY();
                    view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.D + scrollX + i2, this.E + scrollY + view.getHeight() + i3), true);
                }
                view.getLocationInWindow(this.F);
                int[] iArr2 = this.F;
                layoutParams.x = iArr2[0] + i2;
                layoutParams.y = iArr2[1] + view.getHeight() + i3;
                view.getLocationOnScreen(this.G);
                r2 = ((rect.bottom - this.G[1]) - view.getHeight()) - i3 < (this.G[1] - i3) - rect.top;
                if (r2) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.F[1]) + i3;
                } else {
                    layoutParams.y = this.F[1] + view.getHeight() + i3;
                }
            }
            if (this.s) {
                int i4 = rect.right - rect.left;
                int i5 = layoutParams.x;
                int i6 = layoutParams.width + i5;
                if (i6 > i4) {
                    layoutParams.x = i5 - (i6 - i4);
                }
                int i7 = layoutParams.x;
                int i8 = rect.left;
                if (i7 < i8) {
                    layoutParams.x = i8;
                    layoutParams.width = Math.min(layoutParams.width, i4);
                }
                if (r2) {
                    int i9 = (this.G[1] + i3) - this.E;
                    if (i9 < 0) {
                        layoutParams.y += i9;
                    }
                } else {
                    layoutParams.y = Math.max(layoutParams.y, rect.top);
                }
            }
            layoutParams.gravity |= 268435456;
            return r2;
        }
        return invokeLLII.booleanValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f47077i : (View) invokeV.objValue;
    }

    public final void w(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, layoutParams) == null) {
            Context context = this.f47073e;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            this.f47074f.addView(this.f47078j, layoutParams);
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f47075g : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.q >= 0 || (context = this.f47073e) == null) ? this.q == 1 : context.getApplicationInfo().targetSdkVersion >= 11 : invokeV.booleanValue;
    }

    public final void z(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, layoutParams) == null) {
            View view = this.f47077i;
            if (view != null && this.f47073e != null && this.f47074f != null) {
                if (this.H != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    int i2 = -2;
                    i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    c cVar = new c(this, this.f47073e);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                    cVar.setBackgroundDrawable(this.H);
                    cVar.addView(this.f47077i, layoutParams3);
                    this.f47078j = cVar;
                } else {
                    this.f47078j = view;
                }
                this.D = layoutParams.width;
                this.E = layoutParams.height;
                return;
            }
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = 1;
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = -1;
        this.t = true;
        this.u = false;
        this.F = new int[2];
        this.G = new int[2];
        new Rect();
        this.L = 1000;
        this.N = false;
        this.O = -1;
        this.Q = new a(this);
        this.f47073e = context;
        this.f47074f = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.PopupWindow, i2, i3);
        this.H = obtainStyledAttributes.getDrawable(m.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(m.PopupWindow_popupAnimationStyle, -1);
        this.O = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow() {
        this((View) null, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((View) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view, int i2, int i3) {
        this(view, i2, i3, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(View view, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = 1;
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = -1;
        this.t = true;
        this.u = false;
        this.F = new int[2];
        this.G = new int[2];
        new Rect();
        this.L = 1000;
        this.N = false;
        this.O = -1;
        this.Q = new a(this);
        if (view != null) {
            Context context = view.getContext();
            this.f47073e = context;
            this.f47074f = (WindowManager) context.getSystemService("window");
        }
        K(view);
        S(i2);
        N(i3);
        L(z);
    }
}
