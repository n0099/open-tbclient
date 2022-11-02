package com.baidu.searchbox.widget;

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
import com.baidu.searchbox.widget.ViewDragHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class SlidingPaneLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FADE_COLOR = -858993460;
    public static final SlidingPanelLayoutImpl IMPL;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final String TAG = "SlidingPaneLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoSlide;
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public final ViewDragHelper mDragHelper;
    public boolean mEnableReleaseWhenNoTranslucent;
    public boolean mFirstLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsActivityTranslucent;
    public boolean mIsUnableToDrag;
    public final int mOverhangSize;
    public PanelSlideListener mPanelSlideListener;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    public int mScreenWidth;
    public Drawable mShadowDrawable;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;
    public boolean showShadow;
    public double slideEdgeFactor;
    public double slideWidthFactor;

    /* renamed from: com.baidu.searchbox.widget.SlidingPaneLayout$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface PanelSlideListener {
        void onPanelClosed(View view2);

        void onPanelOpened(View view2);

        void onPanelSlide(View view2, float f);
    }

    /* loaded from: classes2.dex */
    public interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view2);
    }

    public abstract void attachActivity(Activity activity);

    public abstract void convertActivityFromTranslucent();

    public abstract void convertActivityToTranslucent();

    public abstract void forceActivityTransparent(boolean z);

    /* loaded from: classes2.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect mTmpRect;
        public final /* synthetic */ SlidingPaneLayout this$0;

        public AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
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
            this.this$0 = slidingPaneLayout;
            this.mTmpRect = new Rect();
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2) == null) {
                Rect rect = this.mTmpRect;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return this.this$0.isDimmed(view2);
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, accessibilityNodeInfoCompat) == null) {
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
                int childCount = this.this$0.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.this$0.getChildAt(i);
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
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, viewGroup, view2, accessibilityEvent)) == null) {
                if (!filter(view2)) {
                    return super.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class DisableLayerRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View mChildView;
        public final /* synthetic */ SlidingPaneLayout this$0;

        public DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view2) {
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
            this.this$0 = slidingPaneLayout;
            this.mChildView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mChildView.getParent() == this.this$0) {
                    ViewCompat.setLayerType(this.mChildView, 0, null);
                    this.this$0.invalidateChildRegion(this.mChildView);
                }
                this.this$0.mPostedRunnables.remove(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class DragHelperCallback extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int OFFSET_X;
        public int currX;
        public final /* synthetic */ SlidingPaneLayout this$0;

        public DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
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
            this.this$0 = slidingPaneLayout;
            this.OFFSET_X = 10;
        }

        public /* synthetic */ DragHelperCallback(SlidingPaneLayout slidingPaneLayout, AnonymousClass1 anonymousClass1) {
            this(slidingPaneLayout);
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                if (!this.this$0.mIsActivityTranslucent) {
                    this.this$0.convertActivityToTranslucent();
                }
                this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, i2);
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
                this.this$0.setAllChildrenVisible();
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i)) == null) {
                if (this.this$0.mIsUnableToDrag) {
                    return false;
                }
                if (!this.this$0.mIsActivityTranslucent) {
                    this.this$0.convertActivityToTranslucent();
                }
                return ((LayoutParams) view2.getLayoutParams()).slideable;
            }
            return invokeLI.booleanValue;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view2, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view2, i, i2)) == null) {
                int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.this$0.mSlideableView.getLayoutParams())).leftMargin;
                return Math.min(Math.max(i, paddingLeft), this.this$0.mSlideRange + paddingLeft);
            }
            return invokeLII.intValue;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) != null) {
                return invokeL.intValue;
            }
            return this.this$0.mSlideRange;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean isPageTranslucent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.mIsActivityTranslucent;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.this$0.mDragHelper.getViewDragState() == 0) {
                if (this.this$0.mSlideOffset == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout = this.this$0;
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = this.this$0;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    this.this$0.mPreservedOpenState = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = this.this$0;
                slidingPaneLayout3.dispatchOnPanelOpened(slidingPaneLayout3.mSlideableView);
                this.this$0.mPreservedOpenState = true;
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                this.currX = i;
                this.this$0.onPanelDragged(i);
                this.this$0.invalidate();
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).leftMargin;
                if (!this.this$0.mEnableReleaseWhenNoTranslucent && !this.this$0.mIsActivityTranslucent) {
                    return;
                }
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 == 0 && this.this$0.mSlideOffset > 0.25f) {
                    if (this.this$0.mAutoSlide) {
                        i = this.this$0.mSlideRange;
                    } else {
                        i = this.currX + 10;
                    }
                    this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft + i, view2.getTop());
                    this.this$0.invalidate();
                    return;
                }
                if (i2 > 0) {
                    paddingLeft += this.this$0.mSlideRange;
                }
                this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view2.getTop());
                this.this$0.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] ATTRS;
        public transient /* synthetic */ FieldHolder $fh;
        public Paint dimPaint;
        public boolean dimWhenOffset;
        public boolean slideable;
        public float weight;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(247761974, "Lcom/baidu/searchbox/widget/SlidingPaneLayout$LayoutParams;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(247761974, "Lcom/baidu/searchbox/widget/SlidingPaneLayout$LayoutParams;");
                    return;
                }
            }
            ATTRS = new int[]{16843137};
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
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
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
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65542, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65542, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isOpen;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(189921596, "Lcom/baidu/searchbox/widget/SlidingPaneLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(189921596, "Lcom/baidu/searchbox/widget/SlidingPaneLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.widget.SlidingPaneLayout.SavedState.1
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
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SavedState(parcel, null);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }
            };
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

        public /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
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
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
            }
        }

        public SimplePanelSlideListener() {
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

    /* loaded from: classes2.dex */
    public static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SlidingPanelLayoutImplBase() {
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

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view2) == null) {
                ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method mGetDisplayList;
        public Field mRecreateDisplayList;

        public SlidingPanelLayoutImplJB() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view2) {
            Field field;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view2) == null) {
                if (this.mGetDisplayList != null && (field = this.mRecreateDisplayList) != null) {
                    try {
                        field.setBoolean(view2, true);
                        this.mGetDisplayList.invoke(view2, null);
                    } catch (Exception e) {
                        Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
                    }
                    super.invalidateChildRegion(slidingPaneLayout, view2);
                    return;
                }
                view2.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SlidingPanelLayoutImplJBMR1() {
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

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view2) == null) {
                ViewCompat.setLayerPaint(view2, ((LayoutParams) view2.getLayoutParams()).dimPaint);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-932691252, "Lcom/baidu/searchbox/widget/SlidingPaneLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-932691252, "Lcom/baidu/searchbox/widget/SlidingPaneLayout;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
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

    public boolean smoothSlideTo(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) {
            if (!this.mCanSlide) {
                return false;
            }
            int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSlideableView.getLayoutParams())).leftMargin + (f * this.mSlideRange));
            ViewDragHelper viewDragHelper = this.mDragHelper;
            View view2 = this.mSlideableView;
            if (!viewDragHelper.smoothSlideViewTo(view2, paddingLeft, view2.getTop())) {
                return false;
            }
            setAllChildrenVisible();
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
        this.mSliderFadeColor = -858993460;
        this.mEnableReleaseWhenNoTranslucent = true;
        this.slideWidthFactor = 0.25d;
        this.slideEdgeFactor = 0.15d;
        this.showShadow = true;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.mAutoSlide = true;
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = 5;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this, null));
        this.mDragHelper = create;
        create.setEdgeTrackingEnabled(1);
        this.mDragHelper.setMinVelocity(f * 400.0f);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        boolean drawChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int save = canvas.save();
            if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null && this.mAutoSlide) {
                canvas.getClipBounds(this.mTmpRect);
                Rect rect = this.mTmpRect;
                rect.right = Math.min(rect.right, this.mSlideableView.getLeft());
                canvas.clipRect(this.mTmpRect);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                drawChild = super.drawChild(canvas, view2, j);
            } else if (layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
                if (!view2.isDrawingCacheEnabled()) {
                    view2.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view2.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, view2.getLeft(), view2.getTop(), layoutParams.dimPaint);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateChildRegion(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, view2) == null) {
            IMPL.invalidateChildRegion(this, view2);
        }
    }

    public static boolean viewIsOpaque(View view2) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 18 || (background = view2.getBackground()) == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) {
            if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void dispatchOnPanelClosed(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            PanelSlideListener panelSlideListener = this.mPanelSlideListener;
            if (panelSlideListener != null) {
                panelSlideListener.onPanelClosed(view2);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnPanelOpened(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            PanelSlideListener panelSlideListener = this.mPanelSlideListener;
            if (panelSlideListener != null) {
                panelSlideListener.onPanelOpened(view2);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnPanelSlide(View view2) {
        PanelSlideListener panelSlideListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (panelSlideListener = this.mPanelSlideListener) != null) {
            panelSlideListener.onPanelSlide(view2, this.mSlideOffset);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public boolean isDimmed(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void isShowShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.showShadow = z;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.isOpen) {
                openPane();
            } else {
                closePane();
            }
            this.mPreservedOpenState = savedState.isOpen;
        }
    }

    public void setActivityIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mIsActivityTranslucent = z;
        }
    }

    public void setAutoSlideToRight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mAutoSlide = z;
        }
    }

    public void setCanSlideRegionFactor(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Double.valueOf(d)}) == null) {
            this.slideWidthFactor = d;
        }
    }

    public void setCoveredFadeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.mCoveredFadeColor = i;
        }
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.mEnableReleaseWhenNoTranslucent = z;
        }
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, panelSlideListener) == null) {
            this.mPanelSlideListener = panelSlideListener;
        }
    }

    public void setParallaxDistance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mParallaxBy = i;
            requestLayout();
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, drawable) == null) {
            this.mShadowDrawable = drawable;
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
            this.mSliderFadeColor = i;
        }
    }

    private boolean closePane(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, this, view2, i)) == null) {
            if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
                return false;
            }
            this.mPreservedOpenState = false;
            return true;
        }
        return invokeLI.booleanValue;
    }

    private boolean openPane(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, this, view2, i)) == null) {
            if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
                return false;
            }
            this.mPreservedOpenState = true;
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
            if (!isInTouchMode() && !this.mCanSlide) {
                if (view2 == this.mSlideableView) {
                    z = true;
                } else {
                    z = false;
                }
                this.mPreservedOpenState = z;
            }
        }
    }

    private void dimChildView(View view2, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{view2, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (f > 0.0f && i != 0) {
                int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
                if (layoutParams.dimPaint == null) {
                    layoutParams.dimPaint = new Paint();
                }
                layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
                if (ViewCompat.getLayerType(view2) != 2) {
                    ViewCompat.setLayerType(view2, 2, layoutParams.dimPaint);
                }
                invalidateChildRegion(view2);
            } else if (ViewCompat.getLayerType(view2) != 0) {
                Paint paint = layoutParams.dimPaint;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(this, view2);
                this.mPostedRunnables.add(disableLayerRunnable);
                ViewCompat.postOnAnimation(this, disableLayerRunnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPanelDragged(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65555, this, i) != null) || !this.mCanSlide || (view2 = this.mSlideableView) == null) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        float paddingLeft = (i - (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)) / this.mSlideRange;
        this.mSlideOffset = paddingLeft;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(paddingLeft);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    private void parallaxOtherViews(float f) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65557, this, f) == null) {
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            if (layoutParams.dimWhenOffset && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                z = true;
            } else {
                z = false;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != this.mSlideableView) {
                    int i2 = this.mParallaxBy;
                    this.mParallaxOffset = f;
                    childAt.offsetLeftAndRight(((int) ((1.0f - this.mParallaxOffset) * i2)) - ((int) ((1.0f - f) * i2)));
                    if (z) {
                        dimChildView(childAt, 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
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
                if (this.showShadow && view2 != null && this.mShadowDrawable != null) {
                    int intrinsicWidth = this.mShadowDrawable.getIntrinsicWidth();
                    int left = view2.getLeft();
                    int top = view2.getTop();
                    int bottom = view2.getBottom();
                    this.mShadowDrawable.setBounds(left - intrinsicWidth, top, left, bottom);
                    this.mShadowDrawable.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean canScroll(View view2, boolean z, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i5 = i2 + scrollX;
                    if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
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

    @Deprecated
    public boolean canSlide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCanSlide;
        }
        return invokeV.booleanValue;
    }

    public boolean closePane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return closePane(this.mSlideableView, 0);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new LayoutParams();
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public int getCoveredFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mCoveredFadeColor;
        }
        return invokeV.intValue;
    }

    public int getParallaxDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mParallaxBy;
        }
        return invokeV.intValue;
    }

    public int getSliderFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mSliderFadeColor;
        }
        return invokeV.intValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mCanSlide && this.mSlideOffset != 1.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mCanSlide;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onAttachedToWindow();
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            this.mFirstLayout = true;
            int size = this.mPostedRunnables.size();
            for (int i = 0; i < size; i++) {
                this.mPostedRunnables.get(i).run();
            }
            this.mPostedRunnables.clear();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            if (isSlideable()) {
                z = isOpen();
            } else {
                z = this.mPreservedOpenState;
            }
            savedState.isOpen = z;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public boolean openPane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return openPane(this.mSlideableView, 0);
        }
        return invokeV.booleanValue;
    }

    public void setAllChildrenVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    @Deprecated
    public void smoothSlideClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            closePane();
        }
    }

    @Deprecated
    public void smoothSlideOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            openPane();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, layoutParams)) == null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
        if (isDimmed(r13.mSlideableView) != false) goto L35;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
                this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getX() >= ((int) (this.mScreenWidth * this.slideWidthFactor))) {
                this.mDragHelper.cancel();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (this.mCanSlide && (!this.mIsUnableToDrag || actionMasked == 0)) {
                if (actionMasked != 3 && actionMasked != 1) {
                    if (actionMasked != 0) {
                        if (actionMasked == 2) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float abs = Math.abs(x - this.mInitialMotionX);
                            float abs2 = Math.abs(y - this.mInitialMotionY);
                            int touchSlop = this.mDragHelper.getTouchSlop();
                            if (abs <= 0.0f || abs <= abs2 || !this.mCanSlide || x >= this.mScreenWidth * this.slideEdgeFactor) {
                                if ((abs > touchSlop && abs2 > abs) || canScroll(this, false, Math.round(x - this.mInitialMotionX), Math.round(x), Math.round(y))) {
                                    this.mDragHelper.cancel();
                                    this.mIsUnableToDrag = true;
                                    return false;
                                }
                            }
                            z = true;
                        }
                        z = false;
                    } else {
                        this.mIsUnableToDrag = false;
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        this.mInitialMotionX = x2;
                        this.mInitialMotionY = y2;
                        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                        }
                        z = false;
                    }
                    try {
                        z2 = this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        z2 = false;
                    }
                    if (z2 || z) {
                        return true;
                    }
                    return false;
                }
                this.mDragHelper.cancel();
                return false;
            } else {
                this.mDragHelper.cancel();
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
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i7 = i3 - i;
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.mFirstLayout) {
                if (this.mCanSlide && this.mPreservedOpenState) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                this.mSlideOffset = f;
            }
            int i8 = paddingLeft;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams.slideable) {
                        int i10 = i7 - paddingRight;
                        int min = (Math.min(paddingLeft, i10 - this.mOverhangSize) - i8) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        this.mSlideRange = min;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i8 + min + (measuredWidth / 2) > i10) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        layoutParams.dimWhenOffset = z2;
                        i8 += ((int) (min * this.mSlideOffset)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else if (this.mCanSlide && (i5 = this.mParallaxBy) != 0) {
                        i6 = (int) ((1.0f - this.mSlideOffset) * i5);
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
            if (this.mFirstLayout) {
                if (this.mCanSlide) {
                    if (this.mParallaxBy != 0) {
                        parallaxOtherViews(this.mSlideOffset);
                    }
                    if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                    }
                } else {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        dimChildView(getChildAt(i12), 0.0f, this.mSliderFadeColor);
                    }
                }
                updateObscuredViewsVisibility(this.mSlideableView);
            }
            this.mFirstLayout = false;
        }
    }

    @Override // android.view.View
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
        if (interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) {
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
                    paddingTop = -1;
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
            this.mSlideableView = null;
            float f = 0.0f;
            int i10 = 0;
            boolean z4 = false;
            float f2 = 0.0f;
            while (true) {
                i4 = 8;
                if (i10 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    layoutParams.dimWhenOffset = z3;
                } else {
                    float f3 = layoutParams.weight;
                    if (f3 > f) {
                        f2 += f3;
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
                    layoutParams.slideable = z2;
                    z4 |= z2;
                    if (z2) {
                        this.mSlideableView = childAt;
                    }
                }
                i10++;
                z3 = false;
                f = 0.0f;
            }
            if (z4 || f2 > 0.0f) {
                int i14 = size - this.mOverhangSize;
                int i15 = 0;
                while (i15 < childCount) {
                    View childAt2 = getChildAt(i15);
                    if (childAt2.getVisibility() != i4) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        if (childAt2.getVisibility() != i4) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                measuredWidth = 0;
                            } else {
                                measuredWidth = childAt2.getMeasuredWidth();
                            }
                            if (z4 && childAt2 != this.mSlideableView) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth > i14 || layoutParams2.weight > 0.0f)) {
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
                                    if (this.mAutoSlide) {
                                        i7 = i14;
                                    } else {
                                        i7 = size;
                                    }
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), makeMeasureSpec2);
                                }
                            } else if (layoutParams2.weight > 0.0f) {
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
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((layoutParams2.weight * Math.max(0, paddingLeft)) / f2)), 1073741824), makeMeasureSpec);
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
            this.mCanSlide = z4;
            if (this.mDragHelper.getViewDragState() != 0 && !z4) {
                this.mDragHelper.abort();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048607, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i != i3) {
                this.mFirstLayout = true;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            if (!this.mCanSlide) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Math.abs(motionEvent.getY() - this.mInitialMotionY) > Math.abs(motionEvent.getX() - this.mInitialMotionX)) {
                            return true;
                        }
                    }
                } else if (isDimmed(this.mSlideableView)) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mInitialMotionX;
                    float f2 = y - this.mInitialMotionY;
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if ((f * f) + (f2 * f2) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y)) {
                        closePane(this.mSlideableView, 0);
                    }
                }
            } else {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.mInitialMotionX = x2;
                this.mInitialMotionY = y2;
            }
            try {
                this.mDragHelper.processTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void updateObscuredViewsVisibility(View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view2) == null) {
            View view3 = view2;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (view3 != null && viewIsOpaque(view2)) {
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
}
