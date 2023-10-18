package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class ViewPager2 extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = -1;
    public static boolean g = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int h;
    public boolean i;
    public RecyclerView j;
    public ScrollEventAdapter k;
    public AccessibilityProvider l;
    public final Rect m;
    public final Rect n;
    public final int[] o;
    public CompositeOnPageChangeCallback p;
    public RecyclerView.AdapterDataObserver q;
    public LinearLayoutManager r;
    public int s;
    public Parcelable t;
    public PagerSnapHelper u;
    public CompositeOnPageChangeCallback v;
    public FakeDrag w;
    public PageTransformerAdapter x;
    public RecyclerView.ItemAnimator y;
    public boolean z;

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OffscreenPageLimit {
    }

    /* loaded from: classes3.dex */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Orientation {
    }

    /* loaded from: classes3.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view2, float f);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScrollState {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-445615128, "Lcom/baidu/mobads/sdk/internal/widget/ViewPager2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-445615128, "Lcom/baidu/mobads/sdk/internal/widget/ViewPager2;");
        }
    }

    /* loaded from: classes3.dex */
    public abstract class AccessibilityProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewPager2 a;

        public void a(@NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accessibilityEvent) == null) {
            }
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accessibilityNodeInfo) == null) {
            }
        }

        public void a(@Nullable RecyclerView.Adapter<?> adapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adapter) == null) {
            }
        }

        public void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, compositeOnPageChangeCallback, recyclerView) == null) {
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean a(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, bundle)) == null) {
                return false;
            }
            return invokeIL.booleanValue;
        }

        public void b(@Nullable RecyclerView.Adapter<?> adapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adapter) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        public boolean handlesLmPerformAccessibilityAction(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, accessibilityNodeInfoCompat) == null) {
            }
        }

        public AccessibilityProvider(ViewPager2 viewPager2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewPager2;
        }

        public boolean onLmPerformAccessibilityAction(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                throw new IllegalStateException("Not implemented.");
            }
            return invokeI.booleanValue;
        }

        public boolean b(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bundle)) == null) {
                throw new IllegalStateException("Not implemented.");
            }
            return invokeIL.booleanValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                throw new IllegalStateException("Not implemented.");
            }
            return (String) invokeV.objValue;
        }

        public CharSequence onRvGetAccessibilityClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                throw new IllegalStateException("Not implemented.");
            }
            return (CharSequence) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewPager2 b;

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BasicAccessibilityProvider(ViewPager2 viewPager2) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = viewPager2;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if ((i == 8192 || i == 4096) && !this.b.isUserInputEnabled()) {
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityNodeInfoCompat) == null) && !this.b.isUserInputEnabled()) {
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.setScrollable(false);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (handlesLmPerformAccessibilityAction(i)) {
                    return false;
                }
                throw new IllegalStateException();
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (handlesRvGetAccessibilityClassName()) {
                    return "androidx.viewpager.widget.ViewPager";
                }
                throw new IllegalStateException();
            }
            return (CharSequence) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        public DataSetChangeObserver() {
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

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj) == null) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
                onChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewPager2 a;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view2, @NonNull Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{recyclerView, view2, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LinearLayoutManagerImpl(ViewPager2 viewPager2, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2, context};
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
            this.a = viewPager2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State state) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, state)) == null) {
                int offscreenPageLimit = this.a.getOffscreenPageLimit();
                if (offscreenPageLimit == -1) {
                    return super.getExtraLayoutSpace(state);
                }
                return this.a.b() * offscreenPageLimit;
            }
            return invokeL.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recycler, state, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
                this.a.l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, recycler, state, i, bundle)) == null) {
                if (this.a.l.handlesLmPerformAccessibilityAction(i)) {
                    return this.a.l.onLmPerformAccessibilityAction(i);
                }
                return super.performAccessibilityAction(recycler, state, i, bundle);
            }
            return invokeLLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class OnPageChangeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public void onPageScrolled(int i, float f, @Px int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public OnPageChangeCallback() {
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
    }

    /* loaded from: classes3.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewPager2 a;

        public PagerSnapHelperImpl(ViewPager2 viewPager2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewPager2;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutManager)) == null) {
                if (this.a.isFakeDragging()) {
                    return null;
                }
                return super.findSnapView(layoutManager);
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class RecyclerViewImpl extends RecyclerView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewPager2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecyclerViewImpl(ViewPager2 viewPager2, @NonNull Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2, context};
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
            this.a = viewPager2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) {
                this.a.o[1] = this.a.o[0];
                if (1 == this.a.getOrientation()) {
                    this.a.o[0] = i4;
                } else {
                    this.a.o[0] = i3;
                }
                return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.l.handlesRvGetAccessibilityClassName()) {
                    return this.a.l.onRvGetAccessibilityClassName();
                }
                return super.getAccessibilityClassName();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setFromIndex(this.a.h);
                accessibilityEvent.setToIndex(this.a.h);
                this.a.l.a(accessibilityEvent);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                if (this.a.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (this.a.isUserInputEnabled() && super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> d;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public Parcelable c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-782287200, "Lcom/baidu/mobads/sdk/internal/widget/ViewPager2$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-782287200, "Lcom/baidu/mobads/sdk/internal/widget/ViewPager2$SavedState;");
                    return;
                }
            }
            d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return createFromParcel(parcel, (ClassLoader) null);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            return new SavedState(parcel, classLoader);
                        }
                        return new SavedState(parcel);
                    }
                    return (SavedState) invokeLL.objValue;
                }
            };
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            a(parcel, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(24)
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            a(parcel, classLoader);
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

        private void a(Parcel parcel, ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, parcel, classLoader) == null) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                this.c = parcel.readParcelable(classLoader);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeParcelable(this.c, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SmoothScrollToPosition implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final RecyclerView b;

        public SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.smoothScrollToPosition(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2(@NonNull Context context) {
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
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2 a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewPager2 viewPager2 = this.a;
                    viewPager2.i = true;
                    viewPager2.k.a();
                }
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2 a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewPager2 viewPager2 = this.a;
                    viewPager2.i = true;
                    viewPager2.k.a();
                }
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2 a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewPager2 viewPager2 = this.a;
                    viewPager2.i = true;
                    viewPager2.k.a();
                }
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPager2 a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i42 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ViewPager2 viewPager2 = this.a;
                    viewPager2.i = true;
                    viewPager2.k.a();
                }
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            this.l = new BasicAccessibilityProvider(this);
            RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(this, context);
            this.j = recyclerViewImpl;
            recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
            this.j.setDescendantFocusability(131072);
            LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(this, context);
            this.r = linearLayoutManagerImpl;
            this.j.setLayoutManager(linearLayoutManagerImpl);
            this.j.setScrollingTouchSlop(1);
            setOrientation(0);
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.j.addOnChildAttachStateChangeListener(e());
            ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
            this.k = scrollEventAdapter;
            this.w = new FakeDrag(this, scrollEventAdapter, this.j);
            PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl(this);
            this.u = pagerSnapHelperImpl;
            pagerSnapHelperImpl.attachToRecyclerView(this.j);
            this.j.addOnScrollListener(this.k);
            CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
            this.v = compositeOnPageChangeCallback;
            this.k.a(compositeOnPageChangeCallback);
            OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewPager2 a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) && i == 0) {
                        this.a.a();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                        ViewPager2 viewPager2 = this.a;
                        if (viewPager2.h != i) {
                            viewPager2.h = i;
                            viewPager2.l.e();
                        }
                    }
                }
            };
            OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewPager2 a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.a.clearFocus();
                        if (this.a.hasFocus()) {
                            this.a.j.requestFocus(2);
                        }
                    }
                }
            };
            this.v.a(onPageChangeCallback);
            this.v.a(onPageChangeCallback2);
            this.l.a(this.v, this.j);
            this.v.a(this.p);
            PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.r);
            this.x = pageTransformerAdapter;
            this.v.a(pageTransformerAdapter);
            RecyclerView recyclerView = this.j;
            attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
        }
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, adapter) == null) && adapter != null) {
            adapter.registerAdapterDataObserver(this.q);
        }
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, adapter) == null) && adapter != null) {
            adapter.unregisterAdapterDataObserver(this.q);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemDecoration) == null) {
            this.j.addItemDecoration(itemDecoration);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.j.canScrollHorizontally(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.j.canScrollVertically(i);
        }
        return invokeI.booleanValue;
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            return this.w.a(f2);
        }
        return invokeF.booleanValue;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            return this.j.getItemDecorationAt(i);
        }
        return (RecyclerView.ItemDecoration) invokeI.objValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.l.a(accessibilityNodeInfo);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.s = savedState.b;
            this.t = savedState.c;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
        }
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onPageChangeCallback) == null) {
            this.p.a(onPageChangeCallback);
        }
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, itemDecoration) == null) {
            this.j.removeItemDecoration(itemDecoration);
        }
    }

    public void removeItemDecorationAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.j.removeItemDecorationAt(i);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, adapter) == null) {
            RecyclerView.Adapter adapter2 = this.j.getAdapter();
            this.l.b(adapter2);
            b(adapter2);
            this.j.setAdapter(adapter);
            this.h = 0;
            f();
            this.l.a(adapter);
            a(adapter);
        }
    }

    public void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            setCurrentItem(i, true);
        }
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            super.setLayoutDirection(i);
            this.l.g();
        }
    }

    public void setOffscreenPageLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            if (i < 1 && i != -1) {
                throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
            }
            this.B = i;
            this.j.requestLayout();
        }
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, onOverScrollListener) != null) || onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback(this, onOverScrollListener) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;
            public boolean b;
            public boolean c;
            public final /* synthetic */ OnOverScrollListener d;
            public final /* synthetic */ ViewPager2 e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, onOverScrollListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = this;
                this.d = onOverScrollListener;
                this.a = false;
                this.b = false;
                this.c = false;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                this.a = false;
                                this.b = false;
                                return;
                            }
                            return;
                        }
                        this.c = true;
                        return;
                    }
                    RecyclerView.Adapter adapter = this.e.getAdapter();
                    if (adapter != null && adapter.getItemCount() > 0 && this.c) {
                        if (1 == this.e.getOrientation()) {
                            if (!this.e.canScrollVertically(-1) && this.e.getOverScrolledDirection() < 0) {
                                this.d.onOverScrollStart();
                            } else if (!this.e.canScrollVertically(1) && this.e.getOverScrolledDirection() > 0) {
                                this.d.onOverScrollEnd();
                            }
                        } else if (this.e.getOrientation() == 0) {
                            if (!this.e.canScrollHorizontally(-1) && this.e.getOverScrolledDirection() < 0) {
                                this.d.onOverScrollStart();
                            } else if (!this.e.canScrollHorizontally(1) && this.e.getOverScrolledDirection() > 0) {
                                this.d.onOverScrollEnd();
                            }
                        }
                        this.c = false;
                    }
                }
            }
        });
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.r.setOrientation(i);
            this.l.d();
        }
    }

    public void setUserInputEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.A = z;
            this.l.f();
        }
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onPageChangeCallback) == null) {
            this.p.b(onPageChangeCallback);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return new RecyclerView.OnChildAttachStateChangeListener(this) { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewPager2 a;

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewDetachedFromWindow(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewAttachedToWindow(@NonNull View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                        if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            return;
                        }
                        throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                    }
                }
            };
        }
        return (RecyclerView.OnChildAttachStateChangeListener) invokeV.objValue;
    }

    public boolean beginFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.w.b();
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.r.getLayoutDirection() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean endFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.w.c();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.l.a()) {
                return this.l.b();
            }
            return super.getAccessibilityClassName();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.j.getAdapter();
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getItemDecorationCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.j.getItemDecorationCount();
        }
        return invokeV.intValue;
    }

    public int getOffscreenPageLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.r.getOrientation();
        }
        return invokeV.intValue;
    }

    public int getOverScrolledDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int[] iArr = this.o;
            if (iArr[0] == 0) {
                return iArr[1];
            }
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public int getScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.k.d();
        }
        return invokeV.intValue;
    }

    public void invalidateItemDecorations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.j.invalidateItemDecorations();
        }
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.w.a();
        }
        return invokeV.booleanValue;
    }

    public boolean isUserInputEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65546, this) != null) || this.s == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.t = null;
        }
        int max = Math.max(0, Math.min(this.s, adapter.getItemCount() - 1));
        this.h = max;
        this.s = -1;
        this.j.scrollToPosition(max);
        this.l.c();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.a = this.j.getId();
            int i = this.s;
            if (i == -1) {
                i = this.h;
            }
            savedState.b = i;
            Parcelable parcelable = this.t;
            if (parcelable != null) {
                savedState.c = parcelable;
            } else {
                RecyclerView.Adapter adapter = this.j.getAdapter();
                if (adapter instanceof StatefulAdapter) {
                    savedState.c = ((StatefulAdapter) adapter).saveState();
                }
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PagerSnapHelper pagerSnapHelper = this.u;
            if (pagerSnapHelper != null) {
                View findSnapView = pagerSnapHelper.findSnapView(this.r);
                if (findSnapView == null) {
                    return;
                }
                int position = this.r.getPosition(findSnapView);
                if (position != this.h && getScrollState() == 0) {
                    this.v.onPageSelected(position);
                }
                this.i = false;
                return;
            }
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public int b() {
        InterceptResult invokeV;
        int height;
        int paddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecyclerView recyclerView = this.j;
            if (getOrientation() == 0) {
                height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
                paddingBottom = recyclerView.getPaddingRight();
            } else {
                height = recyclerView.getHeight() - recyclerView.getPaddingTop();
                paddingBottom = recyclerView.getPaddingBottom();
            }
            return height - paddingBottom;
        }
        return invokeV.intValue;
    }

    public void d() {
        View findSnapView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (findSnapView = this.u.findSnapView(this.r)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.u.calculateDistanceToFinalSnap(this.r, findSnapView);
        if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        }
    }

    public void requestTransform() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || this.x.a() == null) {
            return;
        }
        double h = this.k.h();
        int i = (int) h;
        float f2 = (float) (h - i);
        this.x.onPageScrolled(i, f2, Math.round(b() * f2));
    }

    public void a(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter == null) {
                if (this.s != -1) {
                    this.s = Math.max(i, 0);
                }
            } else if (adapter.getItemCount() <= 0) {
            } else {
                int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
                if (min == this.h && this.k.e()) {
                    return;
                }
                if (min == this.h && z) {
                    return;
                }
                double d2 = this.h;
                this.h = min;
                this.l.e();
                if (!this.k.e()) {
                    d2 = this.k.h();
                }
                this.k.a(min, z);
                if (!z) {
                    this.j.scrollToPosition(min);
                    return;
                }
                double d3 = min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    RecyclerView recyclerView = this.j;
                    if (d3 > d2) {
                        i2 = min - 3;
                    } else {
                        i2 = min + 3;
                    }
                    recyclerView.scrollToPosition(i2);
                    RecyclerView recyclerView2 = this.j;
                    recyclerView2.post(new SmoothScrollToPosition(min, recyclerView2));
                    return;
                }
                this.j.smoothScrollToPosition(min);
            }
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, itemDecoration, i) == null) {
            this.j.addItemDecoration(itemDecoration, i);
        }
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i, bundle)) == null) {
            if (this.l.a(i, bundle)) {
                return this.l.b(i, bundle);
            }
            return super.performAccessibilityAction(i, bundle);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sparseArray) == null) {
            Parcelable parcelable = sparseArray.get(getId());
            if (parcelable instanceof SavedState) {
                int i = ((SavedState) parcelable).a;
                sparseArray.put(this.j.getId(), sparseArray.get(i));
                sparseArray.remove(i);
            }
            super.dispatchRestoreInstanceState(sparseArray);
            f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int measuredWidth = this.j.getMeasuredWidth();
            int measuredHeight = this.j.getMeasuredHeight();
            this.m.left = getPaddingLeft();
            this.m.right = (i3 - i) - getPaddingRight();
            this.m.top = getPaddingTop();
            this.m.bottom = (i4 - i2) - getPaddingBottom();
            Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.m, this.n);
            RecyclerView recyclerView = this.j;
            Rect rect = this.n;
            recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
            if (this.i) {
                a();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            measureChild(this.j, i, i2);
            int measuredWidth = this.j.getMeasuredWidth();
            int measuredHeight = this.j.getMeasuredHeight();
            int measuredState = this.j.getMeasuredState();
            int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
            int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
            setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
        }
    }

    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (!isFakeDragging()) {
                a(i, z);
                return;
            }
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, pageTransformer) == null) {
            if (pageTransformer != null) {
                if (!this.z) {
                    this.y = this.j.getItemAnimator();
                    this.z = true;
                }
                this.j.setItemAnimator(null);
            } else if (this.z) {
                this.j.setItemAnimator(this.y);
                this.y = null;
                this.z = false;
            }
            if (pageTransformer == this.x.a()) {
                return;
            }
            this.x.a(pageTransformer);
            requestTransform();
        }
    }
}
