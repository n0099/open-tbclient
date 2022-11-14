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
import android.util.Log;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m71;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class SlidingPaneLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final f A;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Drawable c;
    public final int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public View h;
    public float i;
    public float j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public float o;
    public float p;
    public e q;
    public final m71 r;
    public double s;
    public double t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final Rect x;
    public final ArrayList<c> y;
    public boolean z;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onPanelClosed(View view2);

        void onPanelOpened(View view2);

        void onPanelSlide(View view2, float f);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(SlidingPaneLayout slidingPaneLayout, View view2);
    }

    public abstract void m(Activity activity);

    public abstract void q();

    public abstract void r();

    public abstract void w(boolean z);

    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isOpen;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isOpen = z;
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] e;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public boolean b;
        public boolean c;
        public Paint d;

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
            e = new int[]{16843137};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.a = 0.0f;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect a;
        public final /* synthetic */ SlidingPaneLayout b;

        public b(SlidingPaneLayout slidingPaneLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = slidingPaneLayout;
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

        public boolean filter(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                return this.b.y(view2);
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view2, accessibilityNodeInfoCompat) == null) {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view2, obtain);
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
                accessibilityNodeInfoCompat.setSource(view2);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view2);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                int childCount = this.b.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.b.getChildAt(i);
                    if (!filter(childAt) && childAt.getVisibility() == 0) {
                        ViewCompat.setImportantForAccessibility(childAt, 1);
                        accessibilityNodeInfoCompat.addChild(childAt);
                    }
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewGroup, view2, accessibilityEvent)) == null) {
                if (!filter(view2)) {
                    return super.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;
        public final /* synthetic */ SlidingPaneLayout b;

        public c(SlidingPaneLayout slidingPaneLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = slidingPaneLayout;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.getParent() == this.b) {
                    ViewCompat.setLayerType(this.a, 0, null);
                    this.b.x(this.a);
                }
                this.b.y.remove(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends m71.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ SlidingPaneLayout b;

        public d(SlidingPaneLayout slidingPaneLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingPaneLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = slidingPaneLayout;
        }

        @Override // com.baidu.tieba.m71.c
        public int d(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) != null) {
                return invokeL.intValue;
            }
            return this.b.k;
        }

        public /* synthetic */ d(SlidingPaneLayout slidingPaneLayout, a aVar) {
            this(slidingPaneLayout);
        }

        @Override // com.baidu.tieba.m71.c
        public void g(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                if (!this.b.f) {
                    this.b.r();
                }
                this.b.r.c(this.b.h, i2);
            }
        }

        @Override // com.baidu.tieba.m71.c
        public void j(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
                this.b.G();
            }
        }

        @Override // com.baidu.tieba.m71.c
        public boolean n(View view2, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i)) == null) {
                if (this.b.l) {
                    return false;
                }
                if (!this.b.f) {
                    this.b.r();
                }
                return ((LayoutParams) view2.getLayoutParams()).b;
            }
            return invokeLI.booleanValue;
        }

        @Override // com.baidu.tieba.m71.c
        public int a(View view2, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view2, i, i2)) == null) {
                int paddingLeft = this.b.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.b.h.getLayoutParams())).leftMargin;
                return Math.min(Math.max(i, paddingLeft), this.b.k + paddingLeft);
            }
            return invokeLII.intValue;
        }

        @Override // com.baidu.tieba.m71.c
        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return invokeV.booleanValue;
            }
            return this.b.f;
        }

        @Override // com.baidu.tieba.m71.c
        public void k(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.b.r.y() == 0) {
                if (this.b.i == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout = this.b;
                    slidingPaneLayout.I(slidingPaneLayout.h);
                    SlidingPaneLayout slidingPaneLayout2 = this.b;
                    slidingPaneLayout2.t(slidingPaneLayout2.h);
                    this.b.v = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = this.b;
                slidingPaneLayout3.u(slidingPaneLayout3.h);
                this.b.v = true;
            }
        }

        @Override // com.baidu.tieba.m71.c
        public void l(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                this.a = i;
                this.b.C(i);
                this.b.invalidate();
            }
        }

        @Override // com.baidu.tieba.m71.c
        public void m(View view2, float f, float f2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                int paddingLeft = this.b.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).leftMargin;
                if (!this.b.g && !this.b.f) {
                    return;
                }
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 == 0 && this.b.i > 0.25f) {
                    if (this.b.z) {
                        i = this.b.k;
                    } else {
                        i = this.a + 10;
                    }
                    this.b.r.J(paddingLeft + i, view2.getTop());
                    this.b.invalidate();
                    return;
                }
                if (i2 > 0) {
                    paddingLeft += this.b.k;
                }
                this.b.r.J(paddingLeft, view2.getTop());
                this.b.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view2) == null) {
                ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.g, com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view2) == null) {
                ViewCompat.setLayerPaint(view2, ((LayoutParams) view2.getLayoutParams()).d);
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
            A = new h();
        } else {
            A = new g();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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

    public boolean H(float f2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i)})) == null) {
            if (!this.e) {
                return false;
            }
            int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.h.getLayoutParams())).leftMargin + (f2 * this.k));
            m71 m71Var = this.r;
            View view2 = this.h;
            if (!m71Var.L(view2, paddingLeft, view2.getTop())) {
                return false;
            }
            G();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.a = -858993460;
        this.g = true;
        this.s = 0.25d;
        this.t = 0.15d;
        this.u = true;
        this.w = true;
        this.x = new Rect();
        this.y = new ArrayList<>();
        this.z = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.d = 5;
        this.m = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new b(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        m71 m = m71.m(this, 0.5f, new d(this, null));
        this.r = m;
        m.H(1);
        this.r.I(f2 * 400.0f);
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ObsoleteSdkInt"})
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        boolean drawChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int save = canvas.save();
            if (this.e && !layoutParams.b && this.h != null && this.z) {
                canvas.getClipBounds(this.x);
                Rect rect = this.x;
                rect.right = Math.min(rect.right, this.h.getLeft());
                canvas.clipRect(this.x);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                drawChild = super.drawChild(canvas, view2, j);
            } else if (layoutParams.c && this.i > 0.0f) {
                if (!view2.isDrawingCacheEnabled()) {
                    view2.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view2.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, view2.getLeft(), view2.getTop(), layoutParams.d);
                    drawChild = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + view2 + " returned null drawing cache");
                    drawChild = super.drawChild(canvas, view2, j);
                }
            } else {
                if (view2.isDrawingCacheEnabled()) {
                    view2.setDrawingCacheEnabled(false);
                }
                drawChild = super.drawChild(canvas, view2, j);
            }
            canvas.restoreToCount(save);
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean J(View view2) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 18 || (background = view2.getBackground()) == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.u = z;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) {
            if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.isOpen) {
                D();
            } else {
                o();
            }
            this.v = savedState.isOpen;
        }
    }

    public void setActivityIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f = z;
        }
    }

    public void setAutoSlideToRight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.z = z;
        }
    }

    public void setCanSlideRegionFactor(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.s = d2;
        }
    }

    public void setCoveredFadeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.b = i;
        }
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.g = z;
        }
    }

    public void setPanelSlideListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, eVar) == null) {
            this.q = eVar;
        }
    }

    public void setParallaxDistance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.n = i;
            requestLayout();
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, drawable) == null) {
            this.c = drawable;
        }
    }

    public void setShadowResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            setShadowDrawable(getResources().getDrawable(i));
        }
    }

    public void setSliderFadeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.a = i;
        }
    }

    public void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            e eVar = this.q;
            if (eVar != null) {
                eVar.onPanelClosed(view2);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void u(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            e eVar = this.q;
            if (eVar != null) {
                eVar.onPanelOpened(view2);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void v(View view2) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, view2) == null) && (eVar = this.q) != null) {
            eVar.onPanelSlide(view2, this.i);
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, view2) == null) {
            A.a(this, view2);
        }
    }

    public boolean y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!this.e || !layoutParams.c || this.i <= 0.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, view2, i)) == null) {
            if (!this.w && !H(1.0f, i)) {
                return false;
            }
            this.v = true;
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final boolean p(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, view2, i)) == null) {
            if (!this.w && !H(0.0f, i)) {
                return false;
            }
            this.v = false;
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, view2, view3) == null) {
            super.requestChildFocus(view2, view3);
            if (!isInTouchMode() && !this.e) {
                if (view2 == this.h) {
                    z = true;
                } else {
                    z = false;
                }
                this.v = z;
            }
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return E(this.h, 0);
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.r.l(true)) {
            if (!this.e) {
                this.r.a();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new LayoutParams();
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public int getCoveredFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int getParallaxDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public int getSliderFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return p(this.h, 0);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onAttachedToWindow();
            this.w = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetachedFromWindow();
            this.w = true;
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                this.y.get(i).run();
            }
            this.y.clear();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            if (B()) {
                z = z();
            } else {
                z = this.v;
            }
            savedState.isOpen = z;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.e && this.i != 1.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void C(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || !this.e || (view2 = this.h) == null) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        float paddingLeft = (i - (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)) / this.k;
        this.i = paddingLeft;
        if (this.n != 0) {
            F(paddingLeft);
        }
        if (layoutParams.c) {
            s(this.h, this.i, this.a);
        }
        v(this.h);
    }

    public final void F(float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
            if (layoutParams.c && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                z = true;
            } else {
                z = false;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != this.h) {
                    int i2 = this.n;
                    this.j = f2;
                    childAt.offsetLeftAndRight(((int) ((1.0f - this.j) * i2)) - ((int) ((1.0f - f2) * i2)));
                    if (z) {
                        s(childAt, 1.0f - this.j, this.b);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            try {
                super.draw(canvas);
                if (getChildCount() > 1) {
                    view2 = getChildAt(1);
                } else {
                    view2 = null;
                }
                if (this.u && view2 != null && this.c != null) {
                    int intrinsicWidth = this.c.getIntrinsicWidth();
                    int left = view2.getLeft();
                    int top = view2.getTop();
                    int bottom = view2.getBottom();
                    this.c.setBounds(left - intrinsicWidth, top, left, bottom);
                    this.c.draw(canvas);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void I(View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            View view3 = view2;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (view3 != null && J(view2)) {
                i = view2.getLeft();
                i2 = view2.getRight();
                i3 = view2.getTop();
                i4 = view2.getBottom();
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            int childCount = getChildCount();
            int i6 = 0;
            while (i6 < childCount && (childAt = getChildAt(i6)) != view3) {
                int max = Math.max(paddingLeft, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                int min = Math.min(width, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= i && max2 >= i3 && min <= i2 && min2 <= i4) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                childAt.setVisibility(i5);
                i6++;
                view3 = view2;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, layoutParams)) == null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public boolean n(View view2, boolean z, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i5 = i2 + scrollX;
                    if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && n(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            if (z && ViewCompat.canScrollHorizontally(view2, -i)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
        if (y(r13.h) != false) goto L35;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (!this.e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
                this.v = !this.r.A(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getX() >= ((int) (this.m * this.s))) {
                this.r.b();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (this.e && (!this.l || actionMasked == 0)) {
                if (actionMasked != 3 && actionMasked != 1) {
                    if (actionMasked != 0) {
                        if (actionMasked == 2) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float abs = Math.abs(x - this.o);
                            float abs2 = Math.abs(y - this.p);
                            int x2 = this.r.x();
                            if (abs <= 0.0f || abs <= abs2 || !this.e || x >= this.m * this.t) {
                                if ((abs > x2 && abs2 > abs) || n(this, false, Math.round(x - this.o), Math.round(x), Math.round(y))) {
                                    this.r.b();
                                    this.l = true;
                                    return false;
                                }
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        this.l = false;
                        float x3 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        this.o = x3;
                        this.p = y2;
                        if (this.r.A(this.h, (int) x3, (int) y2)) {
                        }
                        z = false;
                    }
                    try {
                        z2 = this.r.K(motionEvent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        z2 = false;
                    }
                    if (z2 || z) {
                        return true;
                    }
                    return false;
                }
                this.r.b();
                return false;
            } else {
                this.r.b();
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean z2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i7 = i3 - i;
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.w) {
                if (this.e && this.v) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                this.i = f2;
            }
            int i8 = paddingLeft;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams.b) {
                        int i10 = i7 - paddingRight;
                        int min = (Math.min(paddingLeft, i10 - this.d) - i8) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        this.k = min;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i8 + min + (measuredWidth / 2) > i10) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        layoutParams.c = z2;
                        i8 += ((int) (min * this.i)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else if (this.e && (i5 = this.n) != 0) {
                        i6 = (int) ((1.0f - this.i) * i5);
                        i8 = paddingLeft;
                        int i11 = i8 - i6;
                        childAt.layout(i11, paddingTop, measuredWidth + i11, childAt.getMeasuredHeight() + paddingTop);
                        paddingLeft += childAt.getWidth();
                    } else {
                        i8 = paddingLeft;
                    }
                    i6 = 0;
                    int i112 = i8 - i6;
                    childAt.layout(i112, paddingTop, measuredWidth + i112, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getWidth();
                }
            }
            if (this.w) {
                if (this.e) {
                    if (this.n != 0) {
                        F(this.i);
                    }
                    if (((LayoutParams) this.h.getLayoutParams()).c) {
                        s(this.h, this.i, this.a);
                    }
                } else {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        s(getChildAt(i12), 0.0f, this.a);
                    }
                }
                I(this.h);
            }
            this.w = false;
        }
    }

    @Override // android.view.View
    @SuppressLint({"BDThrowableCheck"})
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        boolean z;
        int measuredWidth;
        int i5;
        int makeMeasureSpec;
        int i6;
        int makeMeasureSpec2;
        int i7;
        int i8;
        int makeMeasureSpec3;
        int i9;
        int makeMeasureSpec4;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                if (isInEditMode()) {
                    if (mode != Integer.MIN_VALUE && mode == 0) {
                        size = 300;
                    }
                } else {
                    throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                }
            } else if (mode2 == 0) {
                if (isInEditMode()) {
                    if (mode2 == 0) {
                        mode2 = Integer.MIN_VALUE;
                        size2 = 300;
                    }
                } else {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                }
            }
            boolean z3 = false;
            if (mode2 != Integer.MIN_VALUE) {
                if (mode2 != 1073741824) {
                    i3 = 0;
                    paddingTop = 0;
                } else {
                    i3 = (size2 - getPaddingTop()) - getPaddingBottom();
                    paddingTop = i3;
                }
            } else {
                paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                i3 = 0;
            }
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            if (childCount > 2) {
                Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
            }
            this.h = null;
            float f2 = 0.0f;
            int i10 = 0;
            boolean z4 = false;
            float f3 = 0.0f;
            while (true) {
                i4 = 8;
                if (i10 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    layoutParams.c = z3;
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
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i9 && measuredHeight > i3) {
                        i3 = Math.min(measuredHeight, paddingTop);
                    }
                    paddingLeft -= measuredWidth2;
                    if (paddingLeft < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    layoutParams.b = z2;
                    z4 |= z2;
                    if (z2) {
                        this.h = childAt;
                    }
                }
                i10++;
                z3 = false;
                f2 = 0.0f;
            }
            if (z4 || f3 > 0.0f) {
                int i14 = size - this.d;
                int i15 = 0;
                while (i15 < childCount) {
                    View childAt2 = getChildAt(i15);
                    if (childAt2.getVisibility() != i4) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        if (childAt2.getVisibility() != i4) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.a > 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                measuredWidth = 0;
                            } else {
                                measuredWidth = childAt2.getMeasuredWidth();
                            }
                            if (z4 && childAt2 != this.h) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth > i14 || layoutParams2.a > 0.0f)) {
                                    if (z) {
                                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                        if (i16 == -2) {
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                            i6 = 1073741824;
                                        } else if (i16 == -1) {
                                            i6 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                        } else {
                                            i6 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                        }
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                    }
                                    if (this.z) {
                                        i7 = i14;
                                    } else {
                                        i7 = size;
                                    }
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), makeMeasureSpec2);
                                }
                            } else if (layoutParams2.a > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i17 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i17 == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i5 = 1073741824;
                                    } else if (i17 == -1) {
                                        i5 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i5 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                                    }
                                } else {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z4) {
                                    int i18 = size - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i18, i5);
                                    if (measuredWidth != i18) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((layoutParams2.a * Math.max(0, paddingLeft)) / f3)), 1073741824), makeMeasureSpec);
                                    i15++;
                                    i4 = 8;
                                }
                            }
                        }
                    }
                    i15++;
                    i4 = 8;
                }
            }
            setMeasuredDimension(size, i3);
            this.e = z4;
            if (this.r.y() != 0 && !z4) {
                this.r.a();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i != i3) {
                this.w = true;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            if (!this.e) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Math.abs(motionEvent.getY() - this.p) > Math.abs(motionEvent.getX() - this.o)) {
                            return true;
                        }
                    }
                } else if (y(this.h)) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f2 = x - this.o;
                    float f3 = y - this.p;
                    int x2 = this.r.x();
                    if ((f2 * f2) + (f3 * f3) < x2 * x2 && this.r.A(this.h, (int) x, (int) y)) {
                        p(this.h, 0);
                    }
                }
            } else {
                float x3 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.o = x3;
                this.p = y2;
            }
            try {
                this.r.B(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(View view2, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{view2, Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (f2 > 0.0f && i != 0) {
                int i2 = (((int) ((((-16777216) & i) >>> 24) * f2)) << 24) | (i & 16777215);
                if (layoutParams.d == null) {
                    layoutParams.d = new Paint();
                }
                layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
                if (ViewCompat.getLayerType(view2) != 2) {
                    ViewCompat.setLayerType(view2, 2, layoutParams.d);
                }
                x(view2);
            } else if (ViewCompat.getLayerType(view2) != 0) {
                Paint paint = layoutParams.d;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                c cVar = new c(this, view2);
                this.y.add(cVar);
                ViewCompat.postOnAnimation(this, cVar);
            }
        }
    }
}
