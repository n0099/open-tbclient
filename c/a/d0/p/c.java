package c.a.d0.p;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.i;
import c.a.d0.n.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c {
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

    /* renamed from: a  reason: collision with root package name */
    public Context f1902a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f1903b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1904c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1905d;

    /* renamed from: e  reason: collision with root package name */
    public View f1906e;

    /* renamed from: f  reason: collision with root package name */
    public View f1907f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1908g;

    /* renamed from: h  reason: collision with root package name */
    public int f1909h;

    /* renamed from: i  reason: collision with root package name */
    public int f1910i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1911j;
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

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1912a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1912a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View view = this.f1912a.L != null ? (View) this.f1912a.L.get() : null;
                if (view == null || this.f1912a.f1907f == null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f1912a.f1907f.getLayoutParams();
                c cVar = this.f1912a;
                cVar.p(cVar.j(view, layoutParams, cVar.N, this.f1912a.O));
                this.f1912a.F(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onDismiss();
    }

    /* renamed from: c.a.d0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037c extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f1913e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0037c(c cVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
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
            this.f1913e = cVar;
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
                        this.f1913e.q();
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
                if (this.f1913e.s == null || !this.f1913e.s.onTouch(this, motionEvent)) {
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
                if (this.f1913e.G) {
                    int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
                    View.mergeDrawableStates(onCreateDrawableState, c.Q);
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
                    this.f1913e.q();
                    return true;
                } else if (motionEvent.getAction() == 4) {
                    this.f1913e.q();
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
                if (this.f1913e.f1906e != null) {
                    this.f1913e.f1906e.sendAccessibilityEvent(i2);
                } else {
                    super.sendAccessibilityEvent(i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-175045644, "Lc/a/d0/p/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-175045644, "Lc/a/d0/p/c;");
                return;
            }
        }
        P = d.f1883d;
        Q = new int[]{16842922};
    }

    public c(View view, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1909h = 0;
        this.f1910i = 1;
        this.f1911j = true;
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
            this.f1902a = context;
            this.f1903b = (WindowManager) context.getSystemService("window");
        }
        z(view);
        D(i2);
        B(i3);
        A(z);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f1908g = z;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.x = i2;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.u = i2;
        }
    }

    public void E(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, view, i2, i3, i4) == null) {
            f(view.getWindowToken(), i2, i3, i4);
        }
    }

    public void F(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            if (i4 != -1) {
                this.v = i4;
                D(i4);
            }
            if (i5 != -1) {
                this.y = i5;
                B(i5);
            }
            if (!u() || this.f1906e == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f1907f.getLayoutParams();
            int i6 = this.t;
            if (i6 >= 0) {
                i6 = this.v;
            }
            boolean z2 = true;
            if (i4 != -1 && layoutParams.width != i6) {
                this.v = i6;
                layoutParams.width = i6;
                z = true;
            }
            int i7 = this.w;
            if (i7 >= 0) {
                i7 = this.y;
            }
            if (i5 != -1 && layoutParams.height != i7) {
                this.y = i7;
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
            int a2 = a();
            if (a2 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = a2;
                z = true;
            }
            int w = w(layoutParams.flags);
            if (w != layoutParams.flags) {
                layoutParams.flags = w;
            } else {
                z2 = z;
            }
            if (z2) {
                this.f1903b.updateViewLayout(this.f1907f, layoutParams);
            }
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.K;
            if (i2 == -1) {
                if (this.f1905d) {
                    return this.G ? i.PopupWindow_DropDownUp : i.PopupWindow_DropDownDown;
                }
                return 0;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WeakReference<View> weakReference = this.L;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.M);
            }
            this.L = null;
        }
    }

    public final WindowManager.LayoutParams d(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iBinder)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 51;
            int i2 = this.u;
            this.v = i2;
            layoutParams.width = i2;
            int i3 = this.x;
            this.y = i3;
            layoutParams.height = i3;
            Drawable drawable = this.D;
            if (drawable != null) {
                layoutParams.format = drawable.getOpacity();
            } else {
                layoutParams.format = -3;
            }
            layoutParams.flags = w(layoutParams.flags);
            layoutParams.type = this.H;
            layoutParams.token = iBinder;
            layoutParams.softInputMode = this.f1910i;
            layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    public void f(IBinder iBinder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048585, this, iBinder, i2, i3, i4) == null) || iBinder == null || u() || this.f1906e == null) {
            return;
        }
        b();
        this.f1904c = true;
        this.f1905d = false;
        WindowManager.LayoutParams d2 = d(iBinder);
        d2.windowAnimations = a();
        m(d2);
        if (i2 == 0) {
            i2 = 51;
        }
        d2.gravity = i2;
        d2.x = i3;
        d2.y = i4;
        int i5 = this.w;
        if (i5 < 0) {
            this.y = i5;
            d2.height = i5;
        }
        int i6 = this.t;
        if (i6 < 0) {
            this.v = i6;
            d2.width = i6;
        }
        g(d2);
    }

    public final void g(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) {
            Context context = this.f1902a;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            this.f1903b.addView(this.f1907f, layoutParams);
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.I = bVar;
        }
    }

    public final boolean j(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048588, this, view, layoutParams, i2, i3)) == null) {
            int height = view.getHeight();
            view.getLocationInWindow(this.B);
            int[] iArr = this.B;
            layoutParams.x = iArr[0] + i2;
            layoutParams.y = iArr[1] + height + i3;
            layoutParams.gravity = 51;
            view.getLocationOnScreen(this.C);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            View rootView = view.getRootView();
            if (this.C[1] + height + i3 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
                if (this.p) {
                    int scrollX = view.getScrollX();
                    int scrollY = view.getScrollY();
                    view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i2, this.A + scrollY + view.getHeight() + i3), true);
                }
                view.getLocationInWindow(this.B);
                int[] iArr2 = this.B;
                layoutParams.x = iArr2[0] + i2;
                layoutParams.y = iArr2[1] + view.getHeight() + i3;
                view.getLocationOnScreen(this.C);
                r2 = ((rect.bottom - this.C[1]) - view.getHeight()) - i3 < (this.C[1] - i3) - rect.top;
                if (r2) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.B[1]) + i3;
                } else {
                    layoutParams.y = this.B[1] + view.getHeight() + i3;
                }
            }
            if (this.o) {
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
                    int i9 = (this.C[1] + i3) - this.A;
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

    public final void m(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            View view = this.f1906e;
            if (view != null && this.f1902a != null && this.f1903b != null) {
                if (this.D != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    int i2 = -2;
                    i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    C0037c c0037c = new C0037c(this, this.f1902a);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                    c0037c.setBackgroundDrawable(this.D);
                    c0037c.addView(this.f1906e, layoutParams3);
                    this.f1907f = c0037c;
                } else {
                    this.f1907f = view;
                }
                this.z = layoutParams.width;
                this.A = layoutParams.height;
                return;
            }
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || z == this.G) {
            return;
        }
        this.G = z;
        if (this.D != null) {
            Drawable drawable = this.E;
            if (drawable == null) {
                this.f1907f.refreshDrawableState();
            } else if (z) {
                this.f1907f.setBackgroundDrawable(drawable);
            } else {
                this.f1907f.setBackgroundDrawable(this.F);
            }
        }
    }

    public void q() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && u() && this.f1907f != null) {
            this.f1904c = false;
            b();
            try {
                try {
                    this.f1903b.removeView(this.f1907f);
                    View view = this.f1907f;
                    View view2 = this.f1906e;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.f1907f = null;
                    bVar = this.I;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e2) {
                    if (!P) {
                        View view3 = this.f1907f;
                        View view4 = this.f1906e;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.f1907f = null;
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
                View view5 = this.f1907f;
                View view6 = this.f1906e;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.f1907f = null;
                b bVar2 = this.I;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1904c : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.m >= 0 || (context = this.f1902a) == null) ? this.m == 1 : context.getApplicationInfo().targetSdkVersion >= 11 : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r4.f1909h == 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r4.f1909h == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r5 = r5 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int i3 = i2 & (-8815129);
            if (this.J) {
                i3 |= 32768;
            }
            if (!this.f1908g) {
                i3 |= 8;
            }
            if (!this.f1911j) {
                i3 |= 16;
            }
            if (this.k) {
                i3 |= 262144;
            }
            if (!this.l) {
                i3 |= 512;
            }
            if (v()) {
                i3 |= 8388608;
            }
            if (this.n) {
                i3 |= 256;
            }
            if (this.q) {
                i3 |= 65536;
            }
            return this.r ? i3 | 32 : i3;
        }
        return invokeI.intValue;
    }

    public void x(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            this.D = drawable;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.l = z;
        }
    }

    public void z(View view) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view) == null) || u()) {
            return;
        }
        this.f1906e = view;
        if (this.f1902a == null && view != null) {
            this.f1902a = view.getContext();
        }
        if (this.f1903b != null || this.f1906e == null || (context = this.f1902a) == null) {
            return;
        }
        this.f1903b = (WindowManager) context.getSystemService("window");
    }
}
