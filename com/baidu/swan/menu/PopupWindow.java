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
@SuppressLint({"ClickableViewAccessibility", "BDThrowableCheck", "SyntheticAccessor"})
/* loaded from: classes2.dex */
public class PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] P;
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
    public WindowManager b;
    public boolean c;
    public boolean d;
    public View e;
    public View f;
    public boolean g;
    public int h;
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

    /* loaded from: classes2.dex */
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
                View view2 = this.a.L != null ? (View) this.a.L.get() : null;
                if (view2 == null || this.a.f == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.a.f.getLayoutParams();
                PopupWindow popupWindow = this.a;
                popupWindow.Q(popupWindow.u(view2, layoutParams, popupWindow.N, this.a.O));
                this.a.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes2.dex */
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
                        this.a.r();
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
                    View.mergeDrawableStates(onCreateDrawableState, PopupWindow.P);
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
                    this.a.r();
                    return true;
                } else if (motionEvent.getAction() == 4) {
                    this.a.r();
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
                if (this.a.e != null) {
                    this.a.e.sendAccessibilityEvent(i);
                } else {
                    super.sendAccessibilityEvent(i);
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
        P = new int[]{16842922};
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void A(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, view2, i, i2) == null) {
            P();
            this.L = new WeakReference<>(view2);
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.M);
            }
            this.N = i;
            this.O = i2;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.K = i;
        }
    }

    public void C(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            this.D = drawable;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void E(View view2) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || x()) {
            return;
        }
        this.e = view2;
        if (this.a == null && view2 != null) {
            this.a = view2.getContext();
        }
        if (this.b != null || (context = this.a) == null) {
            return;
        }
        this.b = (WindowManager) context.getSystemService("window");
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.g = z;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.x = i;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void I(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.I = bVar;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i = i;
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.u = i;
        }
    }

    public void N(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, view2, i, i2) == null) {
            s(view2, i, i2);
        }
    }

    public void O(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048589, this, view2, i, i2, i3) == null) {
            t(view2.getWindowToken(), i, i2, i3);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            WeakReference<View> weakReference = this.L;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (view2 != null) {
                view2.getViewTreeObserver().removeOnScrollChangedListener(this.M);
            }
            this.L = null;
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || z == this.G) {
            return;
        }
        this.G = z;
        if (this.D != null) {
            Drawable drawable = this.E;
            if (drawable == null) {
                this.f.refreshDrawableState();
            } else if (z) {
                this.f.setBackgroundDrawable(drawable);
            } else {
                this.f.setBackgroundDrawable(this.F);
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i = this.K;
            if (i == -1) {
                if (this.d) {
                    return this.G ? R.style.obfuscated_res_0x7f100164 : R.style.obfuscated_res_0x7f100163;
                }
                return 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r4.h == 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r4.h == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        r5 = r5 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            int i2 = i & (-8815129);
            if (this.J) {
                i2 |= 32768;
            }
            if (!this.g) {
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
            if (y()) {
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

    public final WindowManager.LayoutParams q(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, iBinder)) == null) {
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
            layoutParams.flags = p(layoutParams.flags);
            layoutParams.type = this.H;
            layoutParams.token = iBinder;
            layoutParams.softInputMode = this.i;
            layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    public void r() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && x() && this.f != null) {
            this.c = false;
            P();
            try {
                this.b.removeView(this.f);
                View view2 = this.f;
                View view3 = this.e;
                if (view2 != view3 && (view2 instanceof ViewGroup)) {
                    ((ViewGroup) view2).removeView(view3);
                }
                this.f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                View view4 = this.f;
                View view5 = this.e;
                if (view4 != view5 && (view4 instanceof ViewGroup)) {
                    ((ViewGroup) view4).removeView(view5);
                }
                this.f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (Throwable th) {
                View view6 = this.f;
                View view7 = this.e;
                if (view6 != view7 && (view6 instanceof ViewGroup)) {
                    ((ViewGroup) view6).removeView(view7);
                }
                this.f = null;
                b bVar2 = this.I;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
            bVar.onDismiss();
        }
    }

    public void s(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048596, this, view2, i, i2) == null) || x() || this.e == null) {
            return;
        }
        A(view2, i, i2);
        this.c = true;
        this.d = true;
        WindowManager.LayoutParams q = q(view2.getWindowToken());
        z(q);
        Q(u(view2, q, i, i2));
        int i3 = this.w;
        if (i3 < 0) {
            this.y = i3;
            q.height = i3;
        }
        int i4 = this.t;
        if (i4 < 0) {
            this.v = i4;
            q.width = i4;
        }
        q.windowAnimations = o();
        w(q);
    }

    public void t(IBinder iBinder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048597, this, iBinder, i, i2, i3) == null) || iBinder == null || x() || this.e == null) {
            return;
        }
        P();
        this.c = true;
        this.d = false;
        WindowManager.LayoutParams q = q(iBinder);
        q.windowAnimations = o();
        z(q);
        if (i == 0) {
            i = 51;
        }
        q.gravity = i;
        q.x = i2;
        q.y = i3;
        int i4 = this.w;
        if (i4 < 0) {
            this.y = i4;
            q.height = i4;
        }
        int i5 = this.t;
        if (i5 < 0) {
            this.v = i5;
            q.width = i5;
        }
        w(q);
    }

    public final boolean u(View view2, WindowManager.LayoutParams layoutParams, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048598, this, view2, layoutParams, i, i2)) == null) {
            int height = view2.getHeight();
            view2.getLocationInWindow(this.B);
            int[] iArr = this.B;
            layoutParams.x = iArr[0] + i;
            layoutParams.y = iArr[1] + height + i2;
            layoutParams.gravity = 51;
            view2.getLocationOnScreen(this.C);
            Rect rect = new Rect();
            view2.getWindowVisibleDisplayFrame(rect);
            View rootView = view2.getRootView();
            if (this.C[1] + height + i2 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
                if (this.p) {
                    int scrollX = view2.getScrollX();
                    int scrollY = view2.getScrollY();
                    view2.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i, this.A + scrollY + view2.getHeight() + i2), true);
                }
                view2.getLocationInWindow(this.B);
                int[] iArr2 = this.B;
                layoutParams.x = iArr2[0] + i;
                layoutParams.y = iArr2[1] + view2.getHeight() + i2;
                view2.getLocationOnScreen(this.C);
                r2 = ((rect.bottom - this.C[1]) - view2.getHeight()) - i2 < (this.C[1] - i2) - rect.top;
                if (r2) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.B[1]) + i2;
                } else {
                    layoutParams.y = this.B[1] + view2.getHeight() + i2;
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

    public void update() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && x() && this.e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
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
                this.b.updateViewLayout(this.f, layoutParams);
            }
        }
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public final void w(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, layoutParams) == null) {
            Context context = this.a;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            this.b.addView(this.f, layoutParams);
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.m >= 0 || (context = this.a) == null) ? this.m == 1 : context.getApplicationInfo().targetSdkVersion >= 11 : invokeV.booleanValue;
    }

    public final void z(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, layoutParams) == null) {
            View view2 = this.e;
            if (view2 != null && this.a != null && this.b != null) {
                if (this.D != null) {
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    int i = -2;
                    i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    c cVar = new c(this, this.a);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                    cVar.setBackgroundDrawable(this.D);
                    cVar.addView(this.e, layoutParams3);
                    this.f = cVar;
                } else {
                    this.f = view2;
                }
                this.z = layoutParams.width;
                this.A = layoutParams.height;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
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
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
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
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.h = 0;
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
        this.b = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843126, 16843465, R.attr.overlapAnchor, R.attr.obfuscated_res_0x7f0404e2, R.attr.obfuscated_res_0x7f0404e3}, i, i2);
        this.D = obtainStyledAttributes.getDrawable(4);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        this.K = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            update(layoutParams.x, layoutParams.y, i, i2, false);
        }
    }

    public void update(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048601, this, i, i2, i3, i4) == null) {
            update(i, i2, i3, i4, false);
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (i3 != -1) {
                this.v = i3;
                M(i3);
            }
            if (i4 != -1) {
                this.y = i4;
                G(i4);
            }
            if (!x() || this.e == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
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
                this.b.updateViewLayout(this.f, layoutParams);
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
    public PopupWindow(View view2, int i, int i2) {
        this(view2, i, i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(View view2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.h = 0;
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
        if (view2 != null) {
            Context context = view2.getContext();
            this.a = context;
            this.b = (WindowManager) context.getSystemService("window");
        }
        E(view2);
        M(i);
        G(i2);
        F(z);
    }

    public void update(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048603, this, view2, i, i2) == null) {
            update(view2, false, 0, 0, true, i, i2);
        }
    }

    public void update(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            update(view2, true, i, i2, true, i3, i4);
        }
    }

    private void update(View view2, boolean z, int i, int i2, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = i3;
            int i6 = i4;
            if (!x() || this.e == null) {
                return;
            }
            WeakReference<View> weakReference = this.L;
            boolean z3 = false;
            boolean z4 = z && !(this.N == i && this.O == i2);
            if (weakReference == null || weakReference.get() != view2 || (z4 && !this.d)) {
                A(view2, i, i2);
            } else if (z4) {
                this.N = i;
                this.O = i2;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
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
                Q(u(view2, layoutParams, i, i2));
            } else {
                Q(u(view2, layoutParams, this.N, this.O));
            }
            int i9 = layoutParams.x;
            int i10 = layoutParams.y;
            update(i9, i10, i5, i6, (i7 == i9 && i8 == i10) ? true : true);
        }
    }
}
