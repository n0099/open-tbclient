package com.baidu.nadcore.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c.a.d0.l0.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class SlidingPaneLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final f E;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final Rect B;
    public final ArrayList<c> C;
    public boolean D;

    /* renamed from: e  reason: collision with root package name */
    public int f37504e;

    /* renamed from: f  reason: collision with root package name */
    public int f37505f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f37506g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37507h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37508i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37509j;
    public boolean k;
    public View l;
    public float m;
    public float n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public float s;
    public float t;
    public e u;
    public final t v;
    public double w;
    public double x;
    public boolean y;
    public boolean z;

    /* loaded from: classes10.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isOpen;

        /* loaded from: classes10.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(813025231, "Lcom/baidu/nadcore/widget/SlidingPaneLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(813025231, "Lcom/baidu/nadcore/widget/SlidingPaneLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.isOpen ? 1 : 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isOpen = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class b extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f37514b;

        public b(SlidingPaneLayout slidingPaneLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37514b = slidingPaneLayout;
            this.a = new Rect();
        }

        public final void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2) == null) {
                Rect rect = this.a;
                accessibilityNodeInfoCompat2.getBoundsInParent(rect);
                accessibilityNodeInfoCompat.setBoundsInParent(rect);
                accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
                accessibilityNodeInfoCompat.setBoundsInScreen(rect);
                accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
                accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
                accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
                accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
                accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
                accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
                accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
                accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
                accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
                accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
                accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
                accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
                accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
            }
        }

        public boolean filter(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.f37514b.s(view) : invokeL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view, accessibilityNodeInfoCompat) == null) {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                int childCount = this.f37514b.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f37514b.getChildAt(i2);
                    if (!filter(childAt) && childAt.getVisibility() == 0) {
                        ViewCompat.setImportantForAccessibility(childAt, 1);
                        accessibilityNodeInfoCompat.addChild(childAt);
                    }
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewGroup, view, accessibilityEvent)) == null) {
                if (filter(view)) {
                    return false;
                }
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final View f37515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f37516f;

        public c(SlidingPaneLayout slidingPaneLayout, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37516f = slidingPaneLayout;
            this.f37515e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f37515e.getParent() == this.f37516f) {
                    ViewCompat.setLayerType(this.f37515e, 0, null);
                    this.f37516f.r(this.f37515e);
                }
                this.f37516f.C.remove(this);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends t.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f37517b;

        public d(SlidingPaneLayout slidingPaneLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37517b = slidingPaneLayout;
        }

        @Override // c.a.d0.l0.t.c
        public int a(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) {
                int paddingLeft = this.f37517b.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f37517b.l.getLayoutParams())).leftMargin;
                return Math.min(Math.max(i2, paddingLeft), this.f37517b.o + paddingLeft);
            }
            return invokeLII.intValue;
        }

        @Override // c.a.d0.l0.t.c
        public int d(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.f37517b.o : invokeL.intValue;
        }

        @Override // c.a.d0.l0.t.c
        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37517b.f37509j : invokeV.booleanValue;
        }

        @Override // c.a.d0.l0.t.c
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                if (!this.f37517b.f37509j) {
                    this.f37517b.convertActivityToTranslucent();
                }
                this.f37517b.v.c(this.f37517b.l, i3);
            }
        }

        @Override // c.a.d0.l0.t.c
        public void j(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
                this.f37517b.w();
            }
        }

        @Override // c.a.d0.l0.t.c
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && this.f37517b.v.y() == 0) {
                if (this.f37517b.m == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout = this.f37517b;
                    slidingPaneLayout.y(slidingPaneLayout.l);
                    SlidingPaneLayout slidingPaneLayout2 = this.f37517b;
                    slidingPaneLayout2.o(slidingPaneLayout2.l);
                    this.f37517b.z = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = this.f37517b;
                slidingPaneLayout3.p(slidingPaneLayout3.l);
                this.f37517b.z = true;
            }
        }

        @Override // c.a.d0.l0.t.c
        public void l(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a = i2;
                this.f37517b.t(i2);
                this.f37517b.invalidate();
            }
        }

        @Override // c.a.d0.l0.t.c
        public void m(View view, float f2, float f3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                int paddingLeft = this.f37517b.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                if (this.f37517b.k || this.f37517b.f37509j) {
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 || this.f37517b.m <= 0.25f) {
                        if (i3 > 0) {
                            paddingLeft += this.f37517b.o;
                        }
                        this.f37517b.v.J(paddingLeft, view.getTop());
                        this.f37517b.invalidate();
                        return;
                    }
                    if (this.f37517b.D) {
                        i2 = this.f37517b.o;
                    } else {
                        i2 = this.a + 10;
                    }
                    this.f37517b.v.J(paddingLeft + i2, view.getTop());
                    this.f37517b.invalidate();
                }
            }
        }

        @Override // c.a.d0.l0.t.c
        public boolean n(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2)) == null) {
                if (this.f37517b.p) {
                    return false;
                }
                if (!this.f37517b.f37509j) {
                    this.f37517b.convertActivityToTranslucent();
                }
                return ((LayoutParams) view.getLayoutParams()).f37511b;
            }
            return invokeLI.booleanValue;
        }

        public /* synthetic */ d(SlidingPaneLayout slidingPaneLayout, a aVar) {
            this(slidingPaneLayout);
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f2);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* loaded from: classes10.dex */
    public static class g implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view) == null) {
                ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class h extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.g, com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view) == null) {
                ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).f37513d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1305226727, "Lcom/baidu/nadcore/widget/SlidingPaneLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1305226727, "Lcom/baidu/nadcore/widget/SlidingPaneLayout;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            E = new h();
        } else {
            E = new g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean z(View view) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view)) == null) ? Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1 : invokeL.booleanValue;
    }

    public abstract void attachActivity(Activity activity);

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i6 = i3 + scrollX;
                    if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && ViewCompat.canScrollHorizontally(view, -i2);
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean canSlide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37508i : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    public boolean closePane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? m(this.l, 0) : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.v.l(true)) {
            if (!this.f37508i) {
                this.v.a();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public abstract void convertActivityFromTranslucent();

    public abstract void convertActivityToTranslucent();

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            try {
                super.draw(canvas);
                View childAt = getChildCount() > 1 ? getChildAt(1) : null;
                if (this.y && childAt != null && this.f37506g != null) {
                    int intrinsicWidth = this.f37506g.getIntrinsicWidth();
                    int left = childAt.getLeft();
                    this.f37506g.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
                    this.f37506g.draw(canvas);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ObsoleteSdkInt"})
    public boolean drawChild(Canvas canvas, View view, long j2) {
        InterceptResult invokeCommon;
        boolean drawChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{canvas, view, Long.valueOf(j2)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int save = canvas.save();
            if (this.f37508i && !layoutParams.f37511b && this.l != null && this.D) {
                canvas.getClipBounds(this.B);
                Rect rect = this.B;
                rect.right = Math.min(rect.right, this.l.getLeft());
                canvas.clipRect(this.B);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                drawChild = super.drawChild(canvas, view, j2);
            } else if (layoutParams.f37512c && this.m > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), layoutParams.f37513d);
                    drawChild = false;
                } else {
                    String str = "drawChild: child view " + view + " returned null drawing cache";
                    drawChild = super.drawChild(canvas, view, j2);
                }
            } else {
                if (view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(false);
                }
                drawChild = super.drawChild(canvas, view, j2);
            }
            canvas.restoreToCount(save);
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    public abstract void forceActivityTransparent(boolean z);

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new LayoutParams() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, layoutParams)) == null) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public int getCoveredFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37505f : invokeV.intValue;
    }

    public int getParallaxDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.r : invokeV.intValue;
    }

    public int getSliderFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f37504e : invokeV.intValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? !this.f37508i || this.m == 1.0f : invokeV.booleanValue;
    }

    public void isShowShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.y = z;
        }
    }

    public boolean isSlideable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f37508i : invokeV.booleanValue;
    }

    public final boolean m(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, view, i2)) == null) {
            if (this.A || x(0.0f, i2)) {
                this.z = false;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void n(View view, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{view, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (f2 > 0.0f && i2 != 0) {
                int i3 = (((int) ((((-16777216) & i2) >>> 24) * f2)) << 24) | (i2 & 16777215);
                if (layoutParams.f37513d == null) {
                    layoutParams.f37513d = new Paint();
                }
                layoutParams.f37513d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
                if (ViewCompat.getLayerType(view) != 2) {
                    ViewCompat.setLayerType(view, 2, layoutParams.f37513d);
                }
                r(view);
            } else if (ViewCompat.getLayerType(view) != 0) {
                Paint paint = layoutParams.f37513d;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                c cVar = new c(this, view);
                this.C.add(cVar);
                ViewCompat.postOnAnimation(this, cVar);
            }
        }
    }

    public void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.onPanelClosed(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onAttachedToWindow();
            this.A = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetachedFromWindow();
            this.A = true;
            int size = this.C.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.C.get(i2).run();
            }
            this.C.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
        if (s(r13.l) != false) goto L35;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (!this.f37508i && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
                this.z = !this.v.A(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getX() >= ((int) (this.q * this.w))) {
                this.v.b();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (!this.f37508i || (this.p && actionMasked != 0)) {
                this.v.b();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (actionMasked != 3 && actionMasked != 1) {
                if (actionMasked != 0) {
                    if (actionMasked == 2) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float abs = Math.abs(x - this.s);
                        float abs2 = Math.abs(y - this.t);
                        int x2 = this.v.x();
                        if (abs <= 0.0f || abs <= abs2 || !this.f37508i || x >= this.q * this.x) {
                            if ((abs > x2 && abs2 > abs) || canScroll(this, false, Math.round(x - this.s), Math.round(x), Math.round(y))) {
                                this.v.b();
                                this.p = true;
                                return false;
                            }
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    this.p = false;
                    float x3 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.s = x3;
                    this.t = y2;
                    if (this.v.A(this.l, (int) x3, (int) y2)) {
                    }
                    z = false;
                }
                try {
                    z2 = this.v.K(motionEvent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
                return z2 || z;
            } else {
                this.v.b();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i8 = i4 - i2;
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.A) {
                this.m = (this.f37508i && this.z) ? 1.0f : 0.0f;
            }
            int i9 = paddingLeft;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams.f37511b) {
                        int i11 = i8 - paddingRight;
                        int min = (Math.min(paddingLeft, i11 - this.f37507h) - i9) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        this.o = min;
                        layoutParams.f37512c = ((((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i9) + min) + (measuredWidth / 2) > i11;
                        i9 += ((int) (min * this.m)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else if (!this.f37508i || (i6 = this.r) == 0) {
                        i9 = paddingLeft;
                    } else {
                        i7 = (int) ((1.0f - this.m) * i6);
                        i9 = paddingLeft;
                        int i12 = i9 - i7;
                        childAt.layout(i12, paddingTop, measuredWidth + i12, childAt.getMeasuredHeight() + paddingTop);
                        paddingLeft += childAt.getWidth();
                    }
                    i7 = 0;
                    int i122 = i9 - i7;
                    childAt.layout(i122, paddingTop, measuredWidth + i122, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getWidth();
                }
            }
            if (this.A) {
                if (this.f37508i) {
                    if (this.r != 0) {
                        v(this.m);
                    }
                    if (((LayoutParams) this.l.getLayoutParams()).f37512c) {
                        n(this.l, this.m, this.f37504e);
                    }
                } else {
                    for (int i13 = 0; i13 < childCount; i13++) {
                        n(getChildAt(i13), 0.0f, this.f37504e);
                    }
                }
                y(this.l);
            }
            this.A = false;
        }
    }

    @Override // android.view.View
    @SuppressLint({"BDThrowableCheck"})
    public void onMeasure(int i2, int i3) {
        int paddingTop;
        int i4;
        int i5;
        int i6;
        int makeMeasureSpec;
        int i7;
        int makeMeasureSpec2;
        int i8;
        int makeMeasureSpec3;
        int i9;
        int makeMeasureSpec4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode != 1073741824) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                }
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
            } else if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                }
                if (mode2 == 0) {
                    mode2 = Integer.MIN_VALUE;
                    size2 = 300;
                }
            }
            boolean z = false;
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                i4 = 0;
            } else if (mode2 != 1073741824) {
                i4 = 0;
                paddingTop = 0;
            } else {
                i4 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i4;
            }
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            this.l = null;
            float f2 = 0.0f;
            int i10 = 0;
            boolean z2 = false;
            float f3 = 0.0f;
            while (true) {
                i5 = 8;
                if (i10 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    layoutParams.f37512c = z;
                } else {
                    float f4 = layoutParams.a;
                    if (f4 > f2) {
                        f3 += f4;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                        }
                    }
                    int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    if (i12 == -2) {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i11, Integer.MIN_VALUE);
                        i8 = -1;
                    } else {
                        i8 = -1;
                        if (i12 == -1) {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i11, 1073741824);
                        } else {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                        }
                    }
                    int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i13 == -2) {
                        i9 = Integer.MIN_VALUE;
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                    } else {
                        i9 = Integer.MIN_VALUE;
                        if (i13 == i8) {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                        } else {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                        }
                    }
                    childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i9 && measuredHeight > i4) {
                        i4 = Math.min(measuredHeight, paddingTop);
                    }
                    paddingLeft -= measuredWidth;
                    boolean z3 = paddingLeft < 0;
                    layoutParams.f37511b = z3;
                    z2 |= z3;
                    if (z3) {
                        this.l = childAt;
                    }
                }
                i10++;
                z = false;
                f2 = 0.0f;
            }
            if (z2 || f3 > 0.0f) {
                int i14 = size - this.f37507h;
                int i15 = 0;
                while (i15 < childCount) {
                    View childAt2 = getChildAt(i15);
                    if (childAt2.getVisibility() != i5) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        if (childAt2.getVisibility() != i5) {
                            boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.a > 0.0f;
                            int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                            if (z2 && childAt2 != this.l) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i14 || layoutParams2.a > 0.0f)) {
                                    if (z4) {
                                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                        if (i16 == -2) {
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                            i7 = 1073741824;
                                        } else if (i16 == -1) {
                                            i7 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                        } else {
                                            i7 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                        }
                                    } else {
                                        i7 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                    }
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.D ? i14 : size, i7), makeMeasureSpec2);
                                }
                            } else if (layoutParams2.a > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i17 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i17 == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i6 = 1073741824;
                                    } else if (i17 == -1) {
                                        i6 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                                    }
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i18 = size - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i18, i6);
                                    if (measuredWidth2 != i18) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.a * Math.max(0, paddingLeft)) / f3)), 1073741824), makeMeasureSpec);
                                    i15++;
                                    i5 = 8;
                                }
                            }
                        }
                    }
                    i15++;
                    i5 = 8;
                }
            }
            setMeasuredDimension(size, i4);
            this.f37508i = z2;
            if (this.v.y() == 0 || z2) {
                return;
            }
            this.v.a();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.isOpen) {
                openPane();
            } else {
                closePane();
            }
            this.z = savedState.isOpen;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.isOpen = isSlideable() ? isOpen() : this.z;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048606, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 != i4) {
                this.A = true;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            if (!this.f37508i) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.s = x;
                this.t = y;
            } else if (action != 1) {
                if (action == 2) {
                    if (Math.abs(motionEvent.getY() - this.t) > Math.abs(motionEvent.getX() - this.s)) {
                        return true;
                    }
                }
            } else if (s(this.l)) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f2 = x2 - this.s;
                float f3 = y2 - this.t;
                int x3 = this.v.x();
                if ((f2 * f2) + (f3 * f3) < x3 * x3 && this.v.A(this.l, (int) x2, (int) y2)) {
                    m(this.l, 0);
                }
            }
            try {
                this.v.B(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean openPane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? u(this.l, 0) : invokeV.booleanValue;
    }

    public void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.onPanelOpened(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void q(View view) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, view) == null) || (eVar = this.u) == null) {
            return;
        }
        eVar.onPanelSlide(view, this.m);
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            E.a(this, view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, view, view2) == null) {
            super.requestChildFocus(view, view2);
            if (isInTouchMode() || this.f37508i) {
                return;
            }
            this.z = view == this.l;
        }
    }

    public boolean s(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return this.f37508i && ((LayoutParams) view.getLayoutParams()).f37512c && this.m > 0.0f;
        }
        return invokeL.booleanValue;
    }

    public void setActivityIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f37509j = z;
        }
    }

    public void setAutoSlideToRight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.D = z;
        }
    }

    public void setCanSlideRegionFactor(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.w = d2;
        }
    }

    public void setCoveredFadeColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f37505f = i2;
        }
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.k = z;
        }
    }

    public void setPanelSlideListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void setParallaxDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.r = i2;
            requestLayout();
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, drawable) == null) {
            this.f37506g = drawable;
        }
    }

    public void setShadowResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            setShadowDrawable(getResources().getDrawable(i2));
        }
    }

    public void setSliderFadeColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.f37504e = i2;
        }
    }

    @Deprecated
    public void smoothSlideClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            closePane();
        }
    }

    @Deprecated
    public void smoothSlideOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            openPane();
        }
    }

    public final void t(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048626, this, i2) == null) && this.f37508i && (view = this.l) != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            float paddingLeft = (i2 - (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)) / this.o;
            this.m = paddingLeft;
            if (this.r != 0) {
                v(paddingLeft);
            }
            if (layoutParams.f37512c) {
                n(this.l, this.m, this.f37504e);
            }
            q(this.l);
        }
    }

    public final boolean u(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048627, this, view, i2)) == null) {
            if (this.A || x(1.0f, i2)) {
                this.z = true;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
            boolean z = layoutParams.f37512c && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != this.l) {
                    int i3 = this.r;
                    this.n = f2;
                    childAt.offsetLeftAndRight(((int) ((1.0f - this.n) * i3)) - ((int) ((1.0f - f2) * i3)));
                    if (z) {
                        n(childAt, 1.0f - this.n, this.f37505f);
                    }
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    public boolean x(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (this.f37508i) {
                int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.l.getLayoutParams())).leftMargin + (f2 * this.o));
                t tVar = this.v;
                View view = this.l;
                if (tVar.L(view, paddingLeft, view.getTop())) {
                    w();
                    ViewCompat.postInvalidateOnAnimation(this);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void y(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, view) == null) {
            View view2 = view;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (view2 == null || !z(view)) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } else {
                i2 = view.getLeft();
                i3 = view.getRight();
                i4 = view.getTop();
                i5 = view.getBottom();
            }
            int childCount = getChildCount();
            int i6 = 0;
            while (i6 < childCount && (childAt = getChildAt(i6)) != view2) {
                childAt.setVisibility((Math.max(paddingLeft, childAt.getLeft()) < i2 || Math.max(paddingTop, childAt.getTop()) < i4 || Math.min(width, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i5) ? 0 : 4);
                i6++;
                view2 = view;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final int[] f37510e;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37511b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37512c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f37513d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2049901065, "Lcom/baidu/nadcore/widget/SlidingPaneLayout$LayoutParams;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2049901065, "Lcom/baidu/nadcore/widget/SlidingPaneLayout$LayoutParams;");
                    return;
                }
            }
            f37510e = new int[]{16843137};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f37510e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37504e = -858993460;
        this.k = true;
        this.w = 0.25d;
        this.x = 0.15d;
        this.y = true;
        this.A = true;
        this.B = new Rect();
        this.C = new ArrayList<>();
        this.D = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f37507h = 5;
        this.q = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new b(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        t m = t.m(this, 0.5f, new d(this, null));
        this.v = m;
        m.H(1);
        this.v.I(f2 * 400.0f);
    }
}
