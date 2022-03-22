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
/* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    ViewCompat.setLayerType(this.mChildView, 0, null);
                    this.this$0.invalidateChildRegion(this.mChildView);
                }
                this.this$0.mPostedRunnables.remove(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f2);
    }

    /* loaded from: classes4.dex */
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
                }
            };
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
            this.isOpen = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* loaded from: classes4.dex */
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
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view) == null) {
                ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
    }

    /* loaded from: classes4.dex */
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
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, com.baidu.searchbox.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            Field field;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view) == null) {
                if (this.mGetDisplayList != null && (field = this.mRecreateDisplayList) != null) {
                    try {
                        field.setBoolean(view, true);
                        this.mGetDisplayList.invoke(view, null);
                    } catch (Exception e2) {
                        Log.e("SlidingPaneLayout", "Error refreshing display list state", e2);
                    }
                    super.invalidateChildRegion(slidingPaneLayout, view);
                    return;
                }
                view.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, slidingPaneLayout, view) == null) {
                ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
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

    private void dimChildView(View view, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{view, Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (f2 > 0.0f && i != 0) {
                int i2 = (((int) ((((-16777216) & i) >>> 24) * f2)) << 24) | (i & 16777215);
                if (layoutParams.dimPaint == null) {
                    layoutParams.dimPaint = new Paint();
                }
                layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
                if (ViewCompat.getLayerType(view) != 2) {
                    ViewCompat.setLayerType(view, 2, layoutParams.dimPaint);
                }
                invalidateChildRegion(view);
            } else if (ViewCompat.getLayerType(view) != 0) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateChildRegion(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, view) == null) {
            IMPL.invalidateChildRegion(this, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPanelDragged(int i) {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65555, this, i) == null) && this.mCanSlide && (view = this.mSlideableView) != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
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
    }

    private void parallaxOtherViews(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65557, this, f2) == null) {
            LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
            boolean z = layoutParams.dimWhenOffset && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != this.mSlideableView) {
                    int i2 = this.mParallaxBy;
                    this.mParallaxOffset = f2;
                    childAt.offsetLeftAndRight(((int) ((1.0f - this.mParallaxOffset) * i2)) - ((int) ((1.0f - f2) * i2)));
                    if (z) {
                        dimChildView(childAt, 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                    }
                }
            }
        }
    }

    public static boolean viewIsOpaque(View view) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, view)) == null) ? Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1 : invokeL.booleanValue;
    }

    public abstract void attachActivity(Activity activity);

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i5 = i2 + scrollX;
                    if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && ViewCompat.canScrollHorizontally(view, -i);
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean canSlide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCanSlide : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? closePane(this.mSlideableView, 0) : invokeV.booleanValue;
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

    public abstract void convertActivityFromTranslucent();

    public abstract void convertActivityToTranslucent();

    public void dispatchOnPanelClosed(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            PanelSlideListener panelSlideListener = this.mPanelSlideListener;
            if (panelSlideListener != null) {
                panelSlideListener.onPanelClosed(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnPanelOpened(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || (panelSlideListener = this.mPanelSlideListener) == null) {
            return;
        }
        panelSlideListener.onPanelSlide(view, this.mSlideOffset);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            try {
                super.draw(canvas);
                View childAt = getChildCount() > 1 ? getChildAt(1) : null;
                if (this.showShadow && childAt != null && this.mShadowDrawable != null) {
                    int intrinsicWidth = this.mShadowDrawable.getIntrinsicWidth();
                    int left = childAt.getLeft();
                    this.mShadowDrawable.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
                    this.mShadowDrawable.draw(canvas);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        boolean drawChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int save = canvas.save();
            if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null && this.mAutoSlide) {
                canvas.getClipBounds(this.mTmpRect);
                Rect rect = this.mTmpRect;
                rect.right = Math.min(rect.right, this.mSlideableView.getLeft());
                canvas.clipRect(this.mTmpRect);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                drawChild = super.drawChild(canvas, view, j);
            } else if (layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), layoutParams.dimPaint);
                    drawChild = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                    drawChild = super.drawChild(canvas, view, j);
                }
            } else {
                if (view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(false);
                }
                drawChild = super.drawChild(canvas, view, j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new LayoutParams() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, layoutParams)) == null) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public int getCoveredFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mCoveredFadeColor : invokeV.intValue;
    }

    public int getParallaxDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mParallaxBy : invokeV.intValue;
    }

    public int getSliderFadeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mSliderFadeColor : invokeV.intValue;
    }

    public boolean isDimmed(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
        }
        return invokeL.booleanValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? !this.mCanSlide || this.mSlideOffset == 1.0f : invokeV.booleanValue;
    }

    public void isShowShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.showShadow = z;
        }
    }

    public boolean isSlideable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mCanSlide : invokeV.booleanValue;
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
            } else if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
                this.mDragHelper.cancel();
                return super.onInterceptTouchEvent(motionEvent);
            } else if (actionMasked != 3 && actionMasked != 1) {
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
                return z2 || z;
            } else {
                this.mDragHelper.cancel();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i7 = i3 - i;
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.mFirstLayout) {
                this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
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
                        layoutParams.dimWhenOffset = ((((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i8) + min) + (measuredWidth / 2) > i10;
                        i8 += ((int) (min * this.mSlideOffset)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else if (!this.mCanSlide || (i5 = this.mParallaxBy) == 0) {
                        i8 = paddingLeft;
                    } else {
                        i6 = (int) ((1.0f - this.mSlideOffset) * i5);
                        i8 = paddingLeft;
                        int i11 = i8 - i6;
                        childAt.layout(i11, paddingTop, measuredWidth + i11, childAt.getMeasuredHeight() + paddingTop);
                        paddingLeft += childAt.getWidth();
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
        int i5;
        int makeMeasureSpec;
        int i6;
        int makeMeasureSpec2;
        int i7;
        int makeMeasureSpec3;
        int i8;
        int makeMeasureSpec4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
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
                i3 = 0;
            } else if (mode2 != 1073741824) {
                i3 = 0;
                paddingTop = -1;
            } else {
                i3 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i3;
            }
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            if (childCount > 2) {
                Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
            }
            this.mSlideableView = null;
            float f2 = 0.0f;
            int i9 = 0;
            boolean z2 = false;
            float f3 = 0.0f;
            while (true) {
                i4 = 8;
                if (i9 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i9);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    layoutParams.dimWhenOffset = z;
                } else {
                    float f4 = layoutParams.weight;
                    if (f4 > f2) {
                        f3 += f4;
                        if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                        }
                    }
                    int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    if (i11 == -2) {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i10, Integer.MIN_VALUE);
                        i7 = -1;
                    } else {
                        i7 = -1;
                        if (i11 == -1) {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i10, 1073741824);
                        } else {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                        }
                    }
                    int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i12 == -2) {
                        i8 = Integer.MIN_VALUE;
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                    } else {
                        i8 = Integer.MIN_VALUE;
                        if (i12 == i7) {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                        } else {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                        }
                    }
                    childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i8 && measuredHeight > i3) {
                        i3 = Math.min(measuredHeight, paddingTop);
                    }
                    paddingLeft -= measuredWidth;
                    boolean z3 = paddingLeft < 0;
                    layoutParams.slideable = z3;
                    z2 |= z3;
                    if (z3) {
                        this.mSlideableView = childAt;
                    }
                }
                i9++;
                z = false;
                f2 = 0.0f;
            }
            if (z2 || f3 > 0.0f) {
                int i13 = size - this.mOverhangSize;
                int i14 = 0;
                while (i14 < childCount) {
                    View childAt2 = getChildAt(i14);
                    if (childAt2.getVisibility() != i4) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        if (childAt2.getVisibility() != i4) {
                            boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                            int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                            if (z2 && childAt2 != this.mSlideableView) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i13 || layoutParams2.weight > 0.0f)) {
                                    if (z4) {
                                        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                        if (i15 == -2) {
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                            i6 = 1073741824;
                                        } else if (i15 == -1) {
                                            i6 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                        } else {
                                            i6 = 1073741824;
                                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                        }
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                    }
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.mAutoSlide ? i13 : size, i6), makeMeasureSpec2);
                                }
                            } else if (layoutParams2.weight > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i16 == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i5 = 1073741824;
                                    } else if (i16 == -1) {
                                        i5 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i5 = 1073741824;
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                    }
                                } else {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i17 = size - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i17, i5);
                                    if (measuredWidth2 != i17) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * Math.max(0, paddingLeft)) / f3)), 1073741824), makeMeasureSpec);
                                    i14++;
                                    i4 = 8;
                                }
                            }
                        }
                    }
                    i14++;
                    i4 = 8;
                }
            }
            setMeasuredDimension(size, i3);
            this.mCanSlide = z2;
            if (this.mDragHelper.getViewDragState() == 0 || z2) {
                return;
            }
            this.mDragHelper.abort();
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

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
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
            if (action == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
            } else if (action != 1) {
                if (action == 2) {
                    if (Math.abs(motionEvent.getY() - this.mInitialMotionY) > Math.abs(motionEvent.getX() - this.mInitialMotionX)) {
                        return true;
                    }
                }
            } else if (isDimmed(this.mSlideableView)) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f2 = x2 - this.mInitialMotionX;
                float f3 = y2 - this.mInitialMotionY;
                int touchSlop = this.mDragHelper.getTouchSlop();
                if ((f2 * f2) + (f3 * f3) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                    closePane(this.mSlideableView, 0);
                }
            }
            try {
                this.mDragHelper.processTouchEvent(motionEvent);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? openPane(this.mSlideableView, 0) : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, view, view2) == null) {
            super.requestChildFocus(view, view2);
            if (isInTouchMode() || this.mCanSlide) {
                return;
            }
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    public void setActivityIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mIsActivityTranslucent = z;
        }
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

    public void setAutoSlideToRight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mAutoSlide = z;
        }
    }

    public void setCanSlideRegionFactor(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.slideWidthFactor = d2;
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

    public boolean smoothSlideTo(float f2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i)})) == null) {
            if (this.mCanSlide) {
                int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSlideableView.getLayoutParams())).leftMargin + (f2 * this.mSlideRange));
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
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view) == null) {
            View view2 = view;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (view2 == null || !viewIsOpaque(view)) {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i = view.getLeft();
                i2 = view.getRight();
                i3 = view.getTop();
                i4 = view.getBottom();
            }
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
                childAt.setVisibility((Math.max(paddingLeft, childAt.getLeft()) < i || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(width, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
                i5++;
                view2 = view;
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i, i2)) == null) {
                int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.this$0.mSlideableView.getLayoutParams())).leftMargin;
                return Math.min(Math.max(i, paddingLeft), this.this$0.mSlideRange + paddingLeft);
            }
            return invokeLII.intValue;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) ? this.this$0.mSlideRange : invokeL.intValue;
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean isPageTranslucent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.mIsActivityTranslucent : invokeV.booleanValue;
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
        public void onViewCaptured(View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, view, i) == null) {
                this.this$0.setAllChildrenVisible();
            }
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
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                this.currX = i;
                this.this$0.onPanelDragged(i);
                this.this$0.invalidate();
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                if (this.this$0.mEnableReleaseWhenNoTranslucent || this.this$0.mIsActivityTranslucent) {
                    int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i2 != 0 || this.this$0.mSlideOffset <= 0.25f) {
                        if (i2 > 0) {
                            paddingLeft += this.this$0.mSlideRange;
                        }
                        this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
                        this.this$0.invalidate();
                        return;
                    }
                    if (this.this$0.mAutoSlide) {
                        i = this.this$0.mSlideRange;
                    } else {
                        i = this.currX + 10;
                    }
                    this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft + i, view.getTop());
                    this.this$0.invalidate();
                }
            }
        }

        @Override // com.baidu.searchbox.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i)) == null) {
                if (this.this$0.mIsUnableToDrag) {
                    return false;
                }
                if (!this.this$0.mIsActivityTranslucent) {
                    this.this$0.convertActivityToTranslucent();
                }
                return ((LayoutParams) view.getLayoutParams()).slideable;
            }
            return invokeLI.booleanValue;
        }

        public /* synthetic */ DragHelperCallback(SlidingPaneLayout slidingPaneLayout, AnonymousClass1 anonymousClass1) {
            this(slidingPaneLayout);
        }
    }

    /* loaded from: classes4.dex */
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

    private boolean closePane(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, this, view, i)) == null) {
            if (this.mFirstLayout || smoothSlideTo(0.0f, i)) {
                this.mPreservedOpenState = false;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private boolean openPane(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, this, view, i)) == null) {
            if (this.mFirstLayout || smoothSlideTo(1.0f, i)) {
                this.mPreservedOpenState = true;
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
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
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = 5;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this, null));
        this.mDragHelper = create;
        create.setEdgeTrackingEnabled(1);
        this.mDragHelper.setMinVelocity(f2 * 400.0f);
    }
}
