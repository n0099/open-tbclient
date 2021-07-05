package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FADE_COLOR = -858993460;
    public static final int DEFAULT_OVERHANG_SIZE = 32;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final String TAG = "SlidingPaneLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public boolean mDisplayListReflectionLoaded;
    public final ViewDragHelper mDragHelper;
    public boolean mFirstLayout;
    public Method mGetDisplayList;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsUnableToDrag;
    public final int mOverhangSize;
    public PanelSlideListener mPanelSlideListener;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    public Field mRecreateDisplayList;
    public Drawable mShadowDrawableLeft;
    public Drawable mShadowDrawableRight;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;

    /* loaded from: classes.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public boolean filter(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.this$0.isDimmed(view) : invokeL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, accessibilityNodeInfoCompat) == null) {
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
                int childCount = this.this$0.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.this$0.getChildAt(i2);
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
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, viewGroup, view, accessibilityEvent)) == null) {
                if (filter(view)) {
                    return false;
                }
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class DisableLayerRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View mChildView;
        public final /* synthetic */ SlidingPaneLayout this$0;

        public DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
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
            this.this$0 = slidingPaneLayout;
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.mChildView.getParent() == this.this$0) {
                    this.mChildView.setLayerType(0, null);
                    this.this$0.invalidateChildRegion(this.mChildView);
                }
                this.this$0.mPostedRunnables.remove(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class DragHelperCallback extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SlidingPaneLayout this$0;

        public DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
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
            this.this$0 = slidingPaneLayout;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) {
                LayoutParams layoutParams = (LayoutParams) this.this$0.mSlideableView.getLayoutParams();
                if (this.this$0.isLayoutRtlSupport()) {
                    int width = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + this.this$0.mSlideableView.getWidth());
                    return Math.max(Math.min(i2, width), width - this.this$0.mSlideRange);
                }
                int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                return Math.min(Math.max(i2, paddingLeft), this.this$0.mSlideRange + paddingLeft);
            }
            return invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3)) == null) ? view.getTop() : invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? this.this$0.mSlideRange : invokeL.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                SlidingPaneLayout slidingPaneLayout = this.this$0;
                slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i3);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
                this.this$0.setAllChildrenVisible();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && this.this$0.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = this.this$0;
                if (slidingPaneLayout.mSlideOffset == 0.0f) {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = this.this$0;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    this.this$0.mPreservedOpenState = false;
                    return;
                }
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                this.this$0.mPreservedOpenState = true;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.this$0.onPanelDragged(i2);
                this.this$0.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int paddingLeft;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (this.this$0.isLayoutRtlSupport()) {
                    int paddingRight = this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    if (f2 < 0.0f || (f2 == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                        paddingRight += this.this$0.mSlideRange;
                    }
                    paddingLeft = (this.this$0.getWidth() - paddingRight) - this.this$0.mSlideableView.getWidth();
                } else {
                    paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + this.this$0.getPaddingLeft();
                    int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i2 > 0 || (i2 == 0 && this.this$0.mSlideOffset > 0.5f)) {
                        paddingLeft += this.this$0.mSlideRange;
                    }
                }
                this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
                this.this$0.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2)) == null) {
                if (this.this$0.mIsUnableToDrag) {
                    return false;
                }
                return ((LayoutParams) view.getLayoutParams()).slideable;
            }
            return invokeLI.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f2);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isOpen;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1380496843, "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1380496843, "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, null) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.isOpen ? 1 : 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isOpen = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimplePanelSlideListener() {
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

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean closePane(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, view, i2)) == null) {
            if (this.mFirstLayout || smoothSlideTo(0.0f, i2)) {
                this.mPreservedOpenState = false;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private void dimChildView(View view, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{view, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (f2 > 0.0f && i2 != 0) {
                int i3 = (((int) ((((-16777216) & i2) >>> 24) * f2)) << 24) | (i2 & 16777215);
                if (layoutParams.dimPaint == null) {
                    layoutParams.dimPaint = new Paint();
                }
                layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
                if (view.getLayerType() != 2) {
                    view.setLayerType(2, layoutParams.dimPaint);
                }
                invalidateChildRegion(view);
            } else if (view.getLayerType() != 0) {
                Paint paint = layoutParams.dimPaint;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(this, view);
                this.mPostedRunnables.add(disableLayerRunnable);
                ViewCompat.postOnAnimation(this, disableLayerRunnable);
            }
        }
    }

    private boolean openPane(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, view, i2)) == null) {
            if (this.mFirstLayout || smoothSlideTo(1.0f, i2)) {
                this.mPreservedOpenState = true;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f2) {
        boolean z;
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, this, f2) == null) {
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            if (layoutParams.dimWhenOffset) {
                if ((isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) <= 0) {
                    z = true;
                    childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = getChildAt(i2);
                        if (childAt != this.mSlideableView) {
                            int i3 = this.mParallaxBy;
                            this.mParallaxOffset = f2;
                            int i4 = ((int) ((1.0f - this.mParallaxOffset) * i3)) - ((int) ((1.0f - f2) * i3));
                            if (isLayoutRtlSupport) {
                                i4 = -i4;
                            }
                            childAt.offsetLeftAndRight(i4);
                            if (z) {
                                float f3 = this.mParallaxOffset;
                                dimChildView(childAt, isLayoutRtlSupport ? f3 - 1.0f : 1.0f - f3, this.mCoveredFadeColor);
                            }
                        }
                    }
                }
            }
            z = false;
            childCount = getChildCount();
            while (i2 < childCount) {
            }
        }
    }

    public static boolean viewIsOpaque(View view) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (view.isOpaque()) {
                return true;
            }
            return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
        }
        return invokeL.booleanValue;
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
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
            if (z) {
                if (view.canScrollHorizontally(isLayoutRtlSupport() ? i2 : -i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean canSlide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCanSlide : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public void dispatchOnPanelClosed(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            PanelSlideListener panelSlideListener = this.mPanelSlideListener;
            if (panelSlideListener != null) {
                panelSlideListener.onPanelClosed(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnPanelOpened(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            PanelSlideListener panelSlideListener = this.mPanelSlideListener;
            if (panelSlideListener != null) {
                panelSlideListener.onPanelOpened(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (panelSlideListener = this.mPanelSlideListener) == null) {
            return;
        }
        panelSlideListener.onPanelSlide(view, this.mSlideOffset);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.draw(canvas);
            if (isLayoutRtlSupport()) {
                drawable = this.mShadowDrawableRight;
            } else {
                drawable = this.mShadowDrawableLeft;
            }
            View childAt = getChildCount() > 1 ? getChildAt(1) : null;
            if (childAt == null || drawable == null) {
                return;
            }
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int save = canvas.save();
            if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
                canvas.getClipBounds(this.mTmpRect);
                if (isLayoutRtlSupport()) {
                    Rect rect = this.mTmpRect;
                    rect.left = Math.max(rect.left, this.mSlideableView.getRight());
                } else {
                    Rect rect2 = this.mTmpRect;
                    rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
                }
                canvas.clipRect(this.mTmpRect);
            }
            boolean drawChild = super.drawChild(canvas, view, j);
            canvas.restoreToCount(save);
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new LayoutParams() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mCoveredFadeColor : invokeV.intValue;
    }

    @Px
    public int getParallaxDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mParallaxBy : invokeV.intValue;
    }

    @ColorInt
    public int getSliderFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSliderFadeColor : invokeV.intValue;
    }

    public void invalidateChildRegion(View view) {
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
                return;
            }
            if (i2 >= 16) {
                if (!this.mDisplayListReflectionLoaded) {
                    try {
                        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
                    } catch (NoSuchMethodException e2) {
                        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
                    }
                    try {
                        Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                        this.mRecreateDisplayList = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
                    }
                    this.mDisplayListReflectionLoaded = true;
                }
                if (this.mGetDisplayList != null && (field = this.mRecreateDisplayList) != null) {
                    try {
                        field.setBoolean(view, true);
                        this.mGetDisplayList.invoke(view, null);
                    } catch (Exception e4) {
                        Log.e("SlidingPaneLayout", "Error refreshing display list state", e4);
                    }
                } else {
                    view.invalidate();
                    return;
                }
            }
            ViewCompat.postInvalidateOnAnimation(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean isDimmed(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
        }
        return invokeL.booleanValue;
    }

    public boolean isLayoutRtlSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? ViewCompat.getLayoutDirection(this) == 1 : invokeV.booleanValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? !this.mCanSlide || this.mSlideOffset == 1.0f : invokeV.booleanValue;
    }

    public boolean isSlideable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mCanSlide : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onAttachedToWindow();
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
            this.mFirstLayout = true;
            int size = this.mPostedRunnables.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mPostedRunnables.get(i2).run();
            }
            this.mPostedRunnables.clear();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048599, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    z = true;
                    return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.mInitialMotionX);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z = false;
            if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            if (isLayoutRtlSupport) {
                this.mDragHelper.setEdgeTrackingEnabled(2);
            } else {
                this.mDragHelper.setEdgeTrackingEnabled(1);
            }
            int i10 = i4 - i2;
            int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.mFirstLayout) {
                this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
            }
            int i11 = paddingRight;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (layoutParams.slideable) {
                        int i13 = i10 - paddingLeft;
                        int min = (Math.min(paddingRight, i13 - this.mOverhangSize) - i11) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        this.mSlideRange = min;
                        int i14 = isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        layoutParams.dimWhenOffset = ((i11 + i14) + min) + (measuredWidth / 2) > i13;
                        int i15 = (int) (min * this.mSlideOffset);
                        i11 += i14 + i15;
                        this.mSlideOffset = i15 / this.mSlideRange;
                        i6 = 0;
                    } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                        i11 = paddingRight;
                        i6 = 0;
                    } else {
                        i6 = (int) ((1.0f - this.mSlideOffset) * i7);
                        i11 = paddingRight;
                    }
                    if (isLayoutRtlSupport) {
                        i9 = (i10 - i11) + i6;
                        i8 = i9 - measuredWidth;
                    } else {
                        i8 = i11 - i6;
                        i9 = i8 + measuredWidth;
                    }
                    childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                    paddingRight += childAt.getWidth();
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
                    for (int i16 = 0; i16 < childCount; i16++) {
                        dimChildView(getChildAt(i16), 0.0f, this.mSliderFadeColor);
                    }
                }
                updateObscuredViewsVisibility(this.mSlideableView);
            }
            this.mFirstLayout = false;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingTop;
        int i4;
        int i5;
        int makeMeasureSpec;
        int i6;
        int i7;
        int makeMeasureSpec2;
        float f2;
        int i8;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
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
            if (childCount > 2) {
                Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
            }
            this.mSlideableView = null;
            int i10 = paddingLeft;
            int i11 = 0;
            boolean z2 = false;
            float f3 = 0.0f;
            while (true) {
                i5 = 8;
                if (i11 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    layoutParams.dimWhenOffset = z;
                } else {
                    float f4 = layoutParams.weight;
                    if (f4 > 0.0f) {
                        f3 += f4;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                        }
                    }
                    int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    if (i13 == -2) {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, Integer.MIN_VALUE);
                        f2 = f3;
                        i8 = Integer.MIN_VALUE;
                    } else {
                        f2 = f3;
                        i8 = Integer.MIN_VALUE;
                        if (i13 == -1) {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824);
                        } else {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                        }
                    }
                    int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i14 == -2) {
                        i9 = View.MeasureSpec.makeMeasureSpec(paddingTop, i8);
                    } else {
                        if (i14 == -1) {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                        } else {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                        }
                        i9 = makeMeasureSpec4;
                    }
                    childAt.measure(makeMeasureSpec3, i9);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i8 && measuredHeight > i4) {
                        i4 = Math.min(measuredHeight, paddingTop);
                    }
                    i10 -= measuredWidth;
                    boolean z3 = i10 < 0;
                    layoutParams.slideable = z3;
                    z2 |= z3;
                    if (z3) {
                        this.mSlideableView = childAt;
                    }
                    f3 = f2;
                }
                i11++;
                z = false;
            }
            if (z2 || f3 > 0.0f) {
                int i15 = paddingLeft - this.mOverhangSize;
                int i16 = 0;
                while (i16 < childCount) {
                    View childAt2 = getChildAt(i16);
                    if (childAt2.getVisibility() != i5) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        if (childAt2.getVisibility() != i5) {
                            boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                            int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                            if (z2 && childAt2 != this.mSlideableView) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i15 || layoutParams2.weight > 0.0f)) {
                                    if (z4) {
                                        int i17 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                        if (i17 == -2) {
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                            i7 = 1073741824;
                                        } else if (i17 == -1) {
                                            i7 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                        } else {
                                            i7 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                                        }
                                    } else {
                                        i7 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                    }
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i15, i7), makeMeasureSpec2);
                                }
                            } else if (layoutParams2.weight > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i18 == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else if (i18 == -1) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                                    }
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i19 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    i6 = i15;
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                                    if (measuredWidth2 != i19) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                    i16++;
                                    i15 = i6;
                                    i5 = 8;
                                } else {
                                    i6 = i15;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * Math.max(0, i10)) / f3)), 1073741824), makeMeasureSpec);
                                    i16++;
                                    i15 = i6;
                                    i5 = 8;
                                }
                            }
                        }
                    }
                    i6 = i15;
                    i16++;
                    i15 = i6;
                    i5 = 8;
                }
            }
            setMeasuredDimension(size, i4 + getPaddingTop() + getPaddingBottom());
            this.mCanSlide = z2;
            if (this.mDragHelper.getViewDragState() == 0 || z2) {
                return;
            }
            this.mDragHelper.abort();
        }
    }

    public void onPanelDragged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (this.mSlideableView == null) {
                this.mSlideOffset = 0.0f;
                return;
            }
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            int width = this.mSlideableView.getWidth();
            if (isLayoutRtlSupport) {
                i2 = (getWidth() - i2) - width;
            }
            float paddingRight = (i2 - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.mSlideRange;
            this.mSlideOffset = paddingRight;
            if (this.mParallaxBy != 0) {
                parallaxOtherViews(paddingRight);
            }
            if (layoutParams.dimWhenOffset) {
                dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
            dispatchOnPanelSlide(this.mSlideableView);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
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

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 != i4) {
                this.mFirstLayout = true;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            if (!this.mCanSlide) {
                return super.onTouchEvent(motionEvent);
            }
            this.mDragHelper.processTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f2 = x - this.mInitialMotionX;
                    float f3 = y - this.mInitialMotionY;
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if ((f2 * f2) + (f3 * f3) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y)) {
                        closePane(this.mSlideableView, 0);
                    }
                }
            } else {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.mInitialMotionX = x2;
                this.mInitialMotionY = y2;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, view, view2) == null) {
            super.requestChildFocus(view, view2);
            if (isInTouchMode() || this.mCanSlide) {
                return;
            }
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    public void setAllChildrenVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.mCoveredFadeColor = i2;
        }
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, panelSlideListener) == null) {
            this.mPanelSlideListener = panelSlideListener;
        }
    }

    public void setParallaxDistance(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mParallaxBy = i2;
            requestLayout();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, drawable) == null) {
            setShadowDrawableLeft(drawable);
        }
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, drawable) == null) {
            this.mShadowDrawableLeft = drawable;
        }
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) {
            this.mShadowDrawableRight = drawable;
        }
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            setShadowDrawable(getResources().getDrawable(i2));
        }
    }

    public void setShadowResourceLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setShadowResourceRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setSliderFadeColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mSliderFadeColor = i2;
        }
    }

    @Deprecated
    public void smoothSlideClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            closePane();
        }
    }

    @Deprecated
    public void smoothSlideOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            openPane();
        }
    }

    public boolean smoothSlideTo(float f2, int i2) {
        InterceptResult invokeCommon;
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (this.mCanSlide) {
                boolean isLayoutRtlSupport = isLayoutRtlSupport();
                LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
                if (isLayoutRtlSupport) {
                    paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f2 * this.mSlideRange)) + this.mSlideableView.getWidth()));
                } else {
                    paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f2 * this.mSlideRange));
                }
                ViewDragHelper viewDragHelper = this.mDragHelper;
                View view = this.mSlideableView;
                if (viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
                    setAllChildrenVisible();
                    ViewCompat.postInvalidateOnAnimation(this);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void updateObscuredViewsVisibility(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view) == null) {
            View view2 = view;
            boolean isLayoutRtlSupport = isLayoutRtlSupport();
            int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
            int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (view2 == null || !viewIsOpaque(view)) {
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
                if (childAt.getVisibility() == 8) {
                    z = isLayoutRtlSupport;
                } else {
                    z = isLayoutRtlSupport;
                    childAt.setVisibility((Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < i2 || Math.max(paddingTop, childAt.getTop()) < i4 || Math.min(isLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i5) ? 0 : 4);
                }
                i6++;
                view2 = view;
                isLayoutRtlSupport = z;
            }
        }
    }

    /* loaded from: classes.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1929273605, "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1929273605, "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams;");
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
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65540, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65540, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                    return;
                }
            }
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSliderFadeColor = -858993460;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this));
        this.mDragHelper = create;
        create.setMinVelocity(f2 * 400.0f);
    }

    public boolean closePane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? closePane(this.mSlideableView, 0) : invokeV.booleanValue;
    }

    public boolean openPane() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? openPane(this.mSlideableView, 0) : invokeV.booleanValue;
    }
}
