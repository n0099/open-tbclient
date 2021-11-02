package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    public static final boolean MEASURE = false;
    public static final String TAG = "ConstraintLayout";
    public static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<View> mChildrenByIds;
    public ArrayList<ConstraintHelper> mConstraintHelpers;
    public ConstraintLayoutStates mConstraintLayoutSpec;
    public ConstraintSet mConstraintSet;
    public int mConstraintSetId;
    public ConstraintsChangedListener mConstraintsChangedListener;
    public HashMap<String, Integer> mDesignIds;
    public boolean mDirtyHierarchy;
    public int mLastMeasureHeight;
    public int mLastMeasureHeightMode;
    public int mLastMeasureHeightSize;
    public int mLastMeasureWidth;
    public int mLastMeasureWidthMode;
    public int mLastMeasureWidthSize;
    public ConstraintWidgetContainer mLayoutWidget;
    public int mMaxHeight;
    public int mMaxWidth;
    public Measurer mMeasurer;
    public Metrics mMetrics;
    public int mMinHeight;
    public int mMinWidth;
    public int mOnMeasureHeightMeasureSpec;
    public int mOnMeasureWidthMeasureSpec;
    public int mOptimizationLevel;
    public SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(395591946, "Landroidx/constraintlayout/widget/ConstraintLayout$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(395591946, "Landroidx/constraintlayout/widget/ConstraintLayout$1;");
                    return;
                }
            }
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class Measurer implements BasicMeasure.Measurer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintLayout layout;
        public int layoutHeightSpec;
        public int layoutWidthSpec;
        public int paddingBottom;
        public int paddingHeight;
        public int paddingTop;
        public int paddingWidth;
        public final /* synthetic */ ConstraintLayout this$0;

        public Measurer(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constraintLayout, constraintLayout2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constraintLayout;
            this.layout = constraintLayout2;
        }

        private boolean isSimilarSpec(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, this, i2, i3, i4)) == null) {
                if (i2 == i3) {
                    return true;
                }
                int mode = View.MeasureSpec.getMode(i2);
                View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size = View.MeasureSpec.getSize(i3);
                if (mode2 == 1073741824) {
                    return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
                }
                return false;
            }
            return invokeIII.booleanValue;
        }

        public void captureLayoutInfos(int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
                this.paddingTop = i4;
                this.paddingBottom = i5;
                this.paddingWidth = i6;
                this.paddingHeight = i7;
                this.layoutWidthSpec = i2;
                this.layoutHeightSpec = i3;
            }
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.layout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.layout.getChildAt(i2);
                    if (childAt instanceof Placeholder) {
                        ((Placeholder) childAt).updatePostMeasure(this.layout);
                    }
                }
                int size = this.layout.mConstraintHelpers.size();
                if (size > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        ((ConstraintHelper) this.layout.mConstraintHelpers.get(i3)).updatePostMeasure(this.layout);
                    }
                }
            }
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            int baseline;
            int max;
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, constraintWidget, measure) == null) || constraintWidget == null) {
                return;
            }
            if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
            } else if (constraintWidget.getParent() == null) {
            } else {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.verticalBehavior;
                int i5 = measure.horizontalDimension;
                int i6 = measure.verticalDimension;
                int i7 = this.paddingTop + this.paddingBottom;
                int i8 = this.paddingWidth;
                View view = (View) constraintWidget.getCompanionWidget();
                int i9 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
                if (i9 == 1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                } else if (i9 == 2) {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i8, -2);
                } else if (i9 == 3) {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i8 + constraintWidget.getHorizontalMargin(), -1);
                } else if (i9 != 4) {
                    makeMeasureSpec = 0;
                } else {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i8, -2);
                    boolean z = constraintWidget.mMatchConstraintDefaultWidth == 1;
                    int i10 = measure.measureStrategy;
                    if (i10 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i10 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                        if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z || (z && (view.getMeasuredHeight() == constraintWidget.getHeight())) || (view instanceof Placeholder) || constraintWidget.isResolvedHorizontally()) {
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                        }
                    }
                }
                int i11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour2.ordinal()];
                if (i11 == 1) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                } else if (i11 == 2) {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i7, -2);
                } else if (i11 == 3) {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i7 + constraintWidget.getVerticalMargin(), -1);
                } else if (i11 != 4) {
                    makeMeasureSpec2 = 0;
                } else {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i7, -2);
                    boolean z2 = constraintWidget.mMatchConstraintDefaultHeight == 1;
                    int i12 = measure.measureStrategy;
                    if (i12 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i12 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                        if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z2 || (z2 && (view.getMeasuredWidth() == constraintWidget.getWidth())) || (view instanceof Placeholder) || constraintWidget.isResolvedVertically()) {
                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                        }
                    }
                }
                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
                if (constraintWidgetContainer != null && Optimizer.enabled(this.this$0.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
                    if (isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), makeMeasureSpec, constraintWidget.getWidth()) && isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), makeMeasureSpec2, constraintWidget.getHeight())) {
                        measure.measuredWidth = constraintWidget.getWidth();
                        measure.measuredHeight = constraintWidget.getHeight();
                        measure.measuredBaseline = constraintWidget.getBaselineDistance();
                        return;
                    }
                }
                boolean z3 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z4 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z5 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
                boolean z6 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
                boolean z7 = z3 && constraintWidget.mDimensionRatio > 0.0f;
                boolean z8 = z4 && constraintWidget.mDimensionRatio > 0.0f;
                if (view == null) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i13 = measure.measureStrategy;
                if (i13 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i13 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && z4 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    i4 = -1;
                    baseline = 0;
                    max = 0;
                    i3 = 0;
                } else {
                    if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                        ((VirtualLayout) view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                    } else {
                        view.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    int i14 = constraintWidget.mMatchConstraintMinWidth;
                    max = i14 > 0 ? Math.max(i14, measuredWidth) : measuredWidth;
                    int i15 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i15 > 0) {
                        max = Math.min(i15, max);
                    }
                    int i16 = constraintWidget.mMatchConstraintMinHeight;
                    if (i16 > 0) {
                        i3 = Math.max(i16, measuredHeight);
                        i2 = makeMeasureSpec2;
                    } else {
                        i2 = makeMeasureSpec2;
                        i3 = measuredHeight;
                    }
                    int i17 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i17 > 0) {
                        i3 = Math.min(i17, i3);
                    }
                    if (!Optimizer.enabled(this.this$0.mOptimizationLevel, 1)) {
                        if (z7 && z5) {
                            max = (int) ((i3 * constraintWidget.mDimensionRatio) + 0.5f);
                        } else if (z8 && z6) {
                            i3 = (int) ((max / constraintWidget.mDimensionRatio) + 0.5f);
                        }
                    }
                    if (measuredWidth != max || measuredHeight != i3) {
                        if (measuredWidth != max) {
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                        }
                        int makeMeasureSpec3 = measuredHeight != i3 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : i2;
                        view.measure(makeMeasureSpec, makeMeasureSpec3);
                        constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec3);
                        max = view.getMeasuredWidth();
                        i3 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i4 = -1;
                }
                boolean z9 = baseline != i4;
                measure.measuredNeedsSolverPass = (max == measure.horizontalDimension && i3 == measure.verticalDimension) ? false : true;
                if (layoutParams.needsBaseline) {
                    z9 = true;
                }
                if (z9 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
                    measure.measuredNeedsSolverPass = true;
                }
                measure.measuredWidth = max;
                measure.measuredHeight = i3;
                measure.measuredHasBaseline = z9;
                measure.measuredBaseline = baseline;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
            int max2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart()) : 0;
            return max2 > 0 ? max2 : max;
        }
        return invokeV.intValue;
    }

    private final ConstraintWidget getTargetWidget(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            if (i2 == 0) {
                return this.mLayoutWidget;
            }
            View view = this.mChildrenByIds.get(i2);
            if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
                onViewAdded(view);
            }
            if (view == this) {
                return this.mLayoutWidget;
            }
            if (view == null) {
                return null;
            }
            return ((LayoutParams) view.getLayoutParams()).widget;
        }
        return (ConstraintWidget) invokeI.objValue;
    }

    private void init(AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, this, attributeSet, i2, i3) == null) {
            this.mLayoutWidget.setCompanionWidget(this);
            this.mLayoutWidget.setMeasurer(this.mMeasurer);
            this.mChildrenByIds.put(getId(), this);
            this.mConstraintSet = null;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i2, i3);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i4 = 0; i4 < indexCount; i4++) {
                    int index = obtainStyledAttributes.getIndex(i4);
                    if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                        this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                        this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                    } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                    } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                        this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                    } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                        if (resourceId != 0) {
                            try {
                                parseLayoutDescription(resourceId);
                            } catch (Resources.NotFoundException unused) {
                                this.mConstraintLayoutSpec = null;
                            }
                        }
                    } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                        try {
                            ConstraintSet constraintSet = new ConstraintSet();
                            this.mConstraintSet = constraintSet;
                            constraintSet.load(getContext(), resourceId2);
                        } catch (Resources.NotFoundException unused2) {
                            this.mConstraintSet = null;
                        }
                        this.mConstraintSetId = resourceId2;
                    }
                }
                obtainStyledAttributes.recycle();
            }
            this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
        }
    }

    private void markHierarchyDirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mDirtyHierarchy = true;
            this.mLastMeasureWidth = -1;
            this.mLastMeasureHeight = -1;
            this.mLastMeasureWidthSize = -1;
            this.mLastMeasureHeightSize = -1;
            this.mLastMeasureWidthMode = 0;
            this.mLastMeasureHeightMode = 0;
        }
    }

    private void setChildrenConstraints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            boolean isInEditMode = isInEditMode();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ConstraintWidget viewWidget = getViewWidget(getChildAt(i2));
                if (viewWidget != null) {
                    viewWidget.reset();
                }
            }
            if (isInEditMode) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    try {
                        String resourceName = getResources().getResourceName(childAt.getId());
                        setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                        int indexOf = resourceName.indexOf(47);
                        if (indexOf != -1) {
                            resourceName = resourceName.substring(indexOf + 1);
                        }
                        getTargetWidget(childAt.getId()).setDebugName(resourceName);
                    } catch (Resources.NotFoundException unused) {
                    }
                }
            }
            if (this.mConstraintSetId != -1) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                        this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                    }
                }
            }
            ConstraintSet constraintSet = this.mConstraintSet;
            if (constraintSet != null) {
                constraintSet.applyToInternal(this, true);
            }
            this.mLayoutWidget.removeAllChildren();
            int size = this.mConstraintHelpers.size();
            if (size > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    this.mConstraintHelpers.get(i5).updatePreLayout(this);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt3 = getChildAt(i6);
                if (childAt3 instanceof Placeholder) {
                    ((Placeholder) childAt3).updatePreLayout(this);
                }
            }
            this.mTempMapIdToWidget.clear();
            this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
            this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt4 = getChildAt(i7);
                this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt5 = getChildAt(i8);
                ConstraintWidget viewWidget2 = getViewWidget(childAt5);
                if (viewWidget2 != null) {
                    LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                    this.mLayoutWidget.add(viewWidget2);
                    applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
                }
            }
        }
    }

    private boolean updateHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                } else if (getChildAt(i2).isLayoutRequested()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                setChildrenConstraints();
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, layoutParams) == null) {
            super.addView(view, i2, layoutParams);
            if (Build.VERSION.SDK_INT < 14) {
                onViewAdded(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i2;
        int i3;
        int i4;
        float f2;
        int i5;
        float f3;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), view, constraintWidget, layoutParams, sparseArray}) == null) {
            layoutParams.validate();
            layoutParams.helped = false;
            constraintWidget.setVisibility(view.getVisibility());
            if (layoutParams.isInPlaceholder) {
                constraintWidget.setInPlaceholder(true);
                constraintWidget.setVisibility(8);
            }
            constraintWidget.setCompanionWidget(view);
            if (view instanceof ConstraintHelper) {
                ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
            }
            if (layoutParams.isGuideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                int i6 = layoutParams.resolvedGuideBegin;
                int i7 = layoutParams.resolvedGuideEnd;
                float f4 = layoutParams.resolvedGuidePercent;
                if (Build.VERSION.SDK_INT < 17) {
                    i6 = layoutParams.guideBegin;
                    i7 = layoutParams.guideEnd;
                    f4 = layoutParams.guidePercent;
                }
                if (f4 != -1.0f) {
                    guideline.setGuidePercent(f4);
                    return;
                } else if (i6 != -1) {
                    guideline.setGuideBegin(i6);
                    return;
                } else if (i7 != -1) {
                    guideline.setGuideEnd(i7);
                    return;
                } else {
                    return;
                }
            }
            int i8 = layoutParams.resolvedLeftToLeft;
            int i9 = layoutParams.resolvedLeftToRight;
            int i10 = layoutParams.resolvedRightToLeft;
            int i11 = layoutParams.resolvedRightToRight;
            int i12 = layoutParams.resolveGoneLeftMargin;
            int i13 = layoutParams.resolveGoneRightMargin;
            float f5 = layoutParams.resolvedHorizontalBias;
            if (Build.VERSION.SDK_INT < 17) {
                i8 = layoutParams.leftToLeft;
                int i14 = layoutParams.leftToRight;
                int i15 = layoutParams.rightToLeft;
                i11 = layoutParams.rightToRight;
                int i16 = layoutParams.goneLeftMargin;
                int i17 = layoutParams.goneRightMargin;
                f5 = layoutParams.horizontalBias;
                if (i8 == -1 && i14 == -1) {
                    int i18 = layoutParams.startToStart;
                    if (i18 != -1) {
                        i8 = i18;
                    } else {
                        int i19 = layoutParams.startToEnd;
                        if (i19 != -1) {
                            i14 = i19;
                        }
                    }
                }
                if (i15 == -1 && i11 == -1) {
                    i3 = layoutParams.endToStart;
                    if (i3 == -1) {
                        int i20 = layoutParams.endToEnd;
                        if (i20 != -1) {
                            i2 = i17;
                            f2 = f5;
                            i12 = i16;
                            i4 = i20;
                            i9 = i14;
                            i3 = i15;
                            i5 = layoutParams.circleConstraint;
                            if (i5 == -1) {
                                ConstraintWidget constraintWidget6 = sparseArray.get(i5);
                                if (constraintWidget6 != null) {
                                    constraintWidget.connectCircularConstraint(constraintWidget6, layoutParams.circleAngle, layoutParams.circleRadius);
                                }
                            } else {
                                if (i8 != -1) {
                                    ConstraintWidget constraintWidget7 = sparseArray.get(i8);
                                    if (constraintWidget7 != null) {
                                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                        f3 = f2;
                                        constraintWidget.immediateConnect(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i12);
                                    } else {
                                        f3 = f2;
                                    }
                                } else {
                                    f3 = f2;
                                    if (i9 != -1 && (constraintWidget2 = sparseArray.get(i9)) != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i12);
                                    }
                                }
                                if (i3 != -1) {
                                    ConstraintWidget constraintWidget8 = sparseArray.get(i3);
                                    if (constraintWidget8 != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i2);
                                    }
                                } else if (i4 != -1 && (constraintWidget3 = sparseArray.get(i4)) != null) {
                                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                                    constraintWidget.immediateConnect(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i2);
                                }
                                int i21 = layoutParams.topToTop;
                                if (i21 != -1) {
                                    ConstraintWidget constraintWidget9 = sparseArray.get(i21);
                                    if (constraintWidget9 != null) {
                                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                                        constraintWidget.immediateConnect(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                    }
                                } else {
                                    int i22 = layoutParams.topToBottom;
                                    if (i22 != -1 && (constraintWidget4 = sparseArray.get(i22)) != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                    }
                                }
                                int i23 = layoutParams.bottomToTop;
                                if (i23 != -1) {
                                    ConstraintWidget constraintWidget10 = sparseArray.get(i23);
                                    if (constraintWidget10 != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                    }
                                } else {
                                    int i24 = layoutParams.bottomToBottom;
                                    if (i24 != -1 && (constraintWidget5 = sparseArray.get(i24)) != null) {
                                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                                        constraintWidget.immediateConnect(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                    }
                                }
                                int i25 = layoutParams.baselineToBaseline;
                                if (i25 != -1) {
                                    View view2 = this.mChildrenByIds.get(i25);
                                    ConstraintWidget constraintWidget11 = sparseArray.get(layoutParams.baselineToBaseline);
                                    if (constraintWidget11 != null && view2 != null && (view2.getLayoutParams() instanceof LayoutParams)) {
                                        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                                        layoutParams.needsBaseline = true;
                                        layoutParams2.needsBaseline = true;
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(constraintWidget11.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                                        constraintWidget.setHasBaseline(true);
                                        layoutParams2.widget.setHasBaseline(true);
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                                    }
                                }
                                float f6 = f3;
                                if (f6 >= 0.0f) {
                                    constraintWidget.setHorizontalBiasPercent(f6);
                                }
                                float f7 = layoutParams.verticalBias;
                                if (f7 >= 0.0f) {
                                    constraintWidget.setVerticalBiasPercent(f7);
                                }
                            }
                            if (z && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1)) {
                                constraintWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                            }
                            if (layoutParams.horizontalDimensionFixed) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                                    if (layoutParams.constrainedWidth) {
                                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                    } else {
                                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                                    }
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                                } else {
                                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                    constraintWidget.setWidth(0);
                                }
                            } else {
                                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                                constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                                }
                            }
                            if (layoutParams.verticalDimensionFixed) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                    if (layoutParams.constrainedHeight) {
                                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                    } else {
                                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                                    }
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                } else {
                                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                    constraintWidget.setHeight(0);
                                }
                            } else {
                                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                                constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                                }
                            }
                            constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
                            constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
                            constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
                            constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                            constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
                            constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                            constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                        }
                    }
                    i2 = i17;
                    i12 = i16;
                    i9 = i14;
                }
                i3 = i15;
                i2 = i17;
                i12 = i16;
                i9 = i14;
            } else {
                i2 = i13;
                i3 = i10;
            }
            float f8 = f5;
            i4 = i11;
            f2 = f8;
            i5 = layoutParams.circleConstraint;
            if (i5 == -1) {
            }
            if (z) {
                constraintWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
            }
            if (layoutParams.horizontalDimensionFixed) {
            }
            if (layoutParams.verticalDimensionFixed) {
            }
            constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
            constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
            constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
            constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
            constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
            constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
            constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    this.mConstraintHelpers.get(i2).updatePreDraw(this);
                }
            }
            super.dispatchDraw(canvas);
            if (isInEditMode()) {
                int childCount = getChildCount();
                float width = getWidth();
                float height = getHeight();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int parseInt3 = Integer.parseInt(split[2]);
                            int i4 = (int) ((parseInt / 1080.0f) * width);
                            int i5 = (int) ((parseInt2 / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            float f2 = i4;
                            float f3 = i5;
                            float f4 = i4 + ((int) ((parseInt3 / 1080.0f) * width));
                            canvas.drawLine(f2, f3, f4, f3, paint);
                            float parseInt4 = i5 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                            canvas.drawLine(f4, f3, f4, parseInt4, paint);
                            canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                            canvas.drawLine(f2, parseInt4, f2, f3, paint);
                            paint.setColor(DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
                            canvas.drawLine(f2, f3, f4, parseInt4, paint);
                            canvas.drawLine(f2, parseInt4, f4, f3, paint);
                        }
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, metrics) == null) {
            this.mMetrics = metrics;
            this.mLayoutWidget.fillMetrics(metrics);
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            markHierarchyDirty();
            super.forceLayout();
        }
    }

    public Object getDesignInformation(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, obj)) == null) {
            if (i2 == 0 && (obj instanceof String)) {
                String str = (String) obj;
                HashMap<String, Integer> hashMap = this.mDesignIds;
                if (hashMap == null || !hashMap.containsKey(str)) {
                    return null;
                }
                return this.mDesignIds.get(str);
            }
            return null;
        }
        return invokeIL.objValue;
    }

    public int getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mMaxHeight : invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMaxWidth : invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mMinHeight : invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mMinWidth : invokeV.intValue;
    }

    public int getOptimizationLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mLayoutWidget.getOptimizationLevel() : invokeV.intValue;
    }

    public View getViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? this.mChildrenByIds.get(i2) : (View) invokeI.objValue;
    }

    public final ConstraintWidget getViewWidget(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) {
            if (view == this) {
                return this.mLayoutWidget;
            }
            if (view == null) {
                return null;
            }
            return ((LayoutParams) view.getLayoutParams()).widget;
        }
        return (ConstraintWidget) invokeL.objValue;
    }

    public boolean isRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadLayoutDescription(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 0) {
                try {
                    this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i2);
                    return;
                } catch (Resources.NotFoundException unused) {
                    this.mConstraintLayoutSpec = null;
                    return;
                }
            }
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            boolean isInEditMode = isInEditMode();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                    int x = constraintWidget.getX();
                    int y = constraintWidget.getY();
                    int width = constraintWidget.getWidth() + x;
                    int height = constraintWidget.getHeight() + y;
                    childAt.layout(x, y, width, height);
                    if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                        content.setVisibility(0);
                        content.layout(x, y, width, height);
                    }
                }
            }
            int size = this.mConstraintHelpers.size();
            if (size > 0) {
                for (int i7 = 0; i7 < size; i7++) {
                    this.mConstraintHelpers.get(i7).updatePostLayout(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            if (!this.mDirtyHierarchy) {
                int childCount = getChildCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    } else if (getChildAt(i4).isLayoutRequested()) {
                        this.mDirtyHierarchy = true;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if (!this.mDirtyHierarchy) {
                if (this.mOnMeasureWidthMeasureSpec == i2 && this.mOnMeasureHeightMeasureSpec == i3) {
                    resolveMeasuredDimension(i2, i3, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                    return;
                } else if (this.mOnMeasureWidthMeasureSpec == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.mLayoutWidget.getHeight()) {
                    this.mOnMeasureWidthMeasureSpec = i2;
                    this.mOnMeasureHeightMeasureSpec = i3;
                    resolveMeasuredDimension(i2, i3, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                    return;
                }
            }
            this.mOnMeasureWidthMeasureSpec = i2;
            this.mOnMeasureHeightMeasureSpec = i3;
            this.mLayoutWidget.setRtl(isRtl());
            if (this.mDirtyHierarchy) {
                this.mDirtyHierarchy = false;
                if (updateHierarchy()) {
                    this.mLayoutWidget.updateHierarchy();
                }
            }
            resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i2, i3);
            resolveMeasuredDimension(i2, i3, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onViewAdded(view);
            }
            ConstraintWidget viewWidget = getViewWidget(view);
            if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                androidx.constraintlayout.solver.widgets.Guideline guideline = new androidx.constraintlayout.solver.widgets.Guideline();
                layoutParams.widget = guideline;
                layoutParams.isGuideline = true;
                guideline.setOrientation(layoutParams.orientation);
            }
            if (view instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view;
                constraintHelper.validateParams();
                ((LayoutParams) view.getLayoutParams()).isHelper = true;
                if (!this.mConstraintHelpers.contains(constraintHelper)) {
                    this.mConstraintHelpers.add(constraintHelper);
                }
            }
            this.mChildrenByIds.put(view.getId(), view);
            this.mDirtyHierarchy = true;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onViewRemoved(view);
            }
            this.mChildrenByIds.remove(view.getId());
            this.mLayoutWidget.remove(getViewWidget(view));
            this.mConstraintHelpers.remove(view);
            this.mDirtyHierarchy = true;
        }
    }

    public void parseLayoutDescription(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            super.removeView(view);
            if (Build.VERSION.SDK_INT < 14) {
                onViewRemoved(view);
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            markHierarchyDirty();
            super.requestLayout();
        }
    }

    public void resolveMeasuredDimension(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Measurer measurer = this.mMeasurer;
            int i6 = measurer.paddingHeight;
            int i7 = i4 + measurer.paddingWidth;
            int i8 = i5 + i6;
            if (Build.VERSION.SDK_INT >= 11) {
                int min = Math.min(this.mMaxWidth, ViewGroup.resolveSizeAndState(i7, i2, 0) & 16777215);
                int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(i8, i3, 0) & 16777215);
                if (z) {
                    min |= 16777216;
                }
                if (z2) {
                    min2 |= 16777216;
                }
                setMeasuredDimension(min, min2);
                this.mLastMeasureWidth = min;
                this.mLastMeasureHeight = min2;
                return;
            }
            setMeasuredDimension(i7, i8);
            this.mLastMeasureWidth = i7;
            this.mLastMeasureHeight = i8;
        }
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4) {
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048605, this, constraintWidgetContainer, i2, i3, i4) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            int size2 = View.MeasureSpec.getSize(i4);
            int max2 = Math.max(0, getPaddingTop());
            int max3 = Math.max(0, getPaddingBottom());
            int i5 = max2 + max3;
            int paddingWidth = getPaddingWidth();
            this.mMeasurer.captureLayoutInfos(i3, i4, max2, max3, paddingWidth, i5);
            if (Build.VERSION.SDK_INT >= 17) {
                int max4 = Math.max(0, getPaddingStart());
                int max5 = Math.max(0, getPaddingEnd());
                if (max4 <= 0 && max5 <= 0) {
                    max4 = Math.max(0, getPaddingLeft());
                } else if (isRtl()) {
                    max4 = max5;
                }
                max = max4;
            } else {
                max = Math.max(0, getPaddingLeft());
            }
            int i6 = size - paddingWidth;
            int i7 = size2 - i5;
            setSelfDimensionBehaviour(constraintWidgetContainer, mode, i6, mode2, i7);
            constraintWidgetContainer.measure(i2, mode, i6, mode2, i7, this.mLastMeasureWidth, this.mLastMeasureHeight, max, max2);
        }
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, constraintSet) == null) {
            this.mConstraintSet = constraintSet;
        }
    }

    public void setDesignInformation(int i2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048607, this, i2, obj, obj2) == null) && i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mChildrenByIds.remove(getId());
            super.setId(i2);
            this.mChildrenByIds.put(getId(), this);
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || i2 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || i2 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || i2 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i2) == null) || i2 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i2;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, constraintsChangedListener) == null) {
            this.mConstraintsChangedListener = constraintsChangedListener;
            ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
            if (constraintLayoutStates != null) {
                constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
            }
        }
    }

    public void setOptimizationLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mOptimizationLevel = i2;
            this.mLayoutWidget.setOptimizationLevel(i2);
        }
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4, int i5) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{constraintWidgetContainer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            Measurer measurer = this.mMeasurer;
            int i6 = measurer.paddingHeight;
            int i7 = measurer.paddingWidth;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
            int childCount = getChildCount();
            if (i2 == Integer.MIN_VALUE) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i3 = Math.max(0, this.mMinWidth);
                }
            } else if (i2 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i3 = Math.max(0, this.mMinWidth);
                }
                i3 = 0;
            } else if (i2 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
                i3 = 0;
            } else {
                i3 = Math.min(this.mMaxWidth - i7, i3);
                dimensionBehaviour = dimensionBehaviour2;
            }
            if (i4 == Integer.MIN_VALUE) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i5 = Math.max(0, this.mMinHeight);
                }
            } else if (i4 != 0) {
                if (i4 == 1073741824) {
                    i5 = Math.min(this.mMaxHeight - i6, i5);
                }
                i5 = 0;
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i5 = Math.max(0, this.mMinHeight);
                }
                i5 = 0;
            }
            if (i3 != constraintWidgetContainer.getWidth() || i5 != constraintWidgetContainer.getHeight()) {
                constraintWidgetContainer.invalidateMeasures();
            }
            constraintWidgetContainer.setX(0);
            constraintWidgetContainer.setY(0);
            constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i7);
            constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i6);
            constraintWidgetContainer.setMinWidth(0);
            constraintWidgetContainer.setMinHeight(0);
            constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
            constraintWidgetContainer.setWidth(i3);
            constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
            constraintWidgetContainer.setHeight(i5);
            constraintWidgetContainer.setMinWidth(this.mMinWidth - i7);
            constraintWidgetContainer.setMinHeight(this.mMinHeight - i6);
        }
    }

    public void setState(int i2, int i3, int i4) {
        ConstraintLayoutStates constraintLayoutStates;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048616, this, i2, i3, i4) == null) || (constraintLayoutStates = this.mConstraintLayoutSpec) == null) {
            return;
        }
        constraintLayoutStates.updateConstraints(i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i2, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i2, i3);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        public int dimensionRatioSide;
        public float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        public boolean horizontalDimensionFixed;
        public float horizontalWeight;
        public boolean isGuideline;
        public boolean isHelper;
        public boolean isInPlaceholder;
        public boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public boolean needsBaseline;
        public int orientation;
        public int resolveGoneLeftMargin;
        public int resolveGoneRightMargin;
        public int resolvedGuideBegin;
        public int resolvedGuideEnd;
        public float resolvedGuidePercent;
        public float resolvedHorizontalBias;
        public int resolvedLeftToLeft;
        public int resolvedLeftToRight;
        public int resolvedRightToLeft;
        public int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public boolean verticalDimensionFixed;
        public float verticalWeight;
        public ConstraintWidget widget;

        /* loaded from: classes.dex */
        public static class Table {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1821592287, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams$Table;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1821592287, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams$Table;");
                        return;
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            public Table() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.constraintTag = layoutParams.constraintTag;
            this.widget = layoutParams.widget;
        }

        public String getConstraintTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.constraintTag : (String) invokeV.objValue;
        }

        public ConstraintWidget getConstraintWidget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.widget : (ConstraintWidget) invokeV.objValue;
        }

        public void reset() {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (constraintWidget = this.widget) == null) {
                return;
            }
            constraintWidget.reset();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i2) {
            boolean z;
            int i3;
            int i4;
            int i5;
            int i6;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                int i7 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                int i8 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
                boolean z2 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    super.resolveLayoutDirection(i2);
                    if (1 == getLayoutDirection()) {
                        z = true;
                        this.resolvedRightToLeft = -1;
                        this.resolvedRightToRight = -1;
                        this.resolvedLeftToLeft = -1;
                        this.resolvedLeftToRight = -1;
                        this.resolveGoneLeftMargin = -1;
                        this.resolveGoneRightMargin = -1;
                        this.resolveGoneLeftMargin = this.goneLeftMargin;
                        this.resolveGoneRightMargin = this.goneRightMargin;
                        this.resolvedHorizontalBias = this.horizontalBias;
                        this.resolvedGuideBegin = this.guideBegin;
                        this.resolvedGuideEnd = this.guideEnd;
                        this.resolvedGuidePercent = this.guidePercent;
                        if (!z) {
                            int i9 = this.startToEnd;
                            if (i9 != -1) {
                                this.resolvedRightToLeft = i9;
                            } else {
                                int i10 = this.startToStart;
                                if (i10 != -1) {
                                    this.resolvedRightToRight = i10;
                                }
                                i3 = this.endToStart;
                                if (i3 != -1) {
                                    this.resolvedLeftToRight = i3;
                                    z2 = true;
                                }
                                i4 = this.endToEnd;
                                if (i4 != -1) {
                                    this.resolvedLeftToLeft = i4;
                                    z2 = true;
                                }
                                i5 = this.goneStartMargin;
                                if (i5 != -1) {
                                    this.resolveGoneRightMargin = i5;
                                }
                                i6 = this.goneEndMargin;
                                if (i6 != -1) {
                                    this.resolveGoneLeftMargin = i6;
                                }
                                if (z2) {
                                    this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                                }
                                if (this.isGuideline && this.orientation == 1) {
                                    f2 = this.guidePercent;
                                    if (f2 == -1.0f) {
                                        this.resolvedGuidePercent = 1.0f - f2;
                                        this.resolvedGuideBegin = -1;
                                        this.resolvedGuideEnd = -1;
                                    } else {
                                        int i11 = this.guideBegin;
                                        if (i11 != -1) {
                                            this.resolvedGuideEnd = i11;
                                            this.resolvedGuideBegin = -1;
                                            this.resolvedGuidePercent = -1.0f;
                                        } else {
                                            int i12 = this.guideEnd;
                                            if (i12 != -1) {
                                                this.resolvedGuideBegin = i12;
                                                this.resolvedGuideEnd = -1;
                                                this.resolvedGuidePercent = -1.0f;
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = true;
                            i3 = this.endToStart;
                            if (i3 != -1) {
                            }
                            i4 = this.endToEnd;
                            if (i4 != -1) {
                            }
                            i5 = this.goneStartMargin;
                            if (i5 != -1) {
                            }
                            i6 = this.goneEndMargin;
                            if (i6 != -1) {
                            }
                            if (z2) {
                            }
                            if (this.isGuideline) {
                                f2 = this.guidePercent;
                                if (f2 == -1.0f) {
                                }
                            }
                        } else {
                            int i13 = this.startToEnd;
                            if (i13 != -1) {
                                this.resolvedLeftToRight = i13;
                            }
                            int i14 = this.startToStart;
                            if (i14 != -1) {
                                this.resolvedLeftToLeft = i14;
                            }
                            int i15 = this.endToStart;
                            if (i15 != -1) {
                                this.resolvedRightToLeft = i15;
                            }
                            int i16 = this.endToEnd;
                            if (i16 != -1) {
                                this.resolvedRightToRight = i16;
                            }
                            int i17 = this.goneStartMargin;
                            if (i17 != -1) {
                                this.resolveGoneLeftMargin = i17;
                            }
                            int i18 = this.goneEndMargin;
                            if (i18 != -1) {
                                this.resolveGoneRightMargin = i18;
                            }
                        }
                        if (this.endToStart != -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                            int i19 = this.rightToLeft;
                            if (i19 != -1) {
                                this.resolvedRightToLeft = i19;
                                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i8 > 0) {
                                    ((ViewGroup.MarginLayoutParams) this).rightMargin = i8;
                                }
                            } else {
                                int i20 = this.rightToRight;
                                if (i20 != -1) {
                                    this.resolvedRightToRight = i20;
                                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i8 > 0) {
                                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i8;
                                    }
                                }
                            }
                            int i21 = this.leftToLeft;
                            if (i21 != -1) {
                                this.resolvedLeftToLeft = i21;
                                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                                    return;
                                }
                                ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
                                return;
                            }
                            int i22 = this.leftToRight;
                            if (i22 != -1) {
                                this.resolvedLeftToRight = i22;
                                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                                    return;
                                }
                                ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z = false;
                this.resolvedRightToLeft = -1;
                this.resolvedRightToRight = -1;
                this.resolvedLeftToLeft = -1;
                this.resolvedLeftToRight = -1;
                this.resolveGoneLeftMargin = -1;
                this.resolveGoneRightMargin = -1;
                this.resolveGoneLeftMargin = this.goneLeftMargin;
                this.resolveGoneRightMargin = this.goneRightMargin;
                this.resolvedHorizontalBias = this.horizontalBias;
                this.resolvedGuideBegin = this.guideBegin;
                this.resolvedGuideEnd = this.guideEnd;
                this.resolvedGuidePercent = this.guidePercent;
                if (!z) {
                }
                if (this.endToStart != -1) {
                }
            }
        }

        public void setWidgetDebugName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.widget.setDebugName(str);
            }
        }

        public void validate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.isGuideline = false;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.constrainedWidth) {
                    this.horizontalDimensionFixed = false;
                    if (this.matchConstraintDefaultWidth == 0) {
                        this.matchConstraintDefaultWidth = 1;
                    }
                }
                if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.constrainedHeight) {
                    this.verticalDimensionFixed = false;
                    if (this.matchConstraintDefaultHeight == 0) {
                        this.matchConstraintDefaultHeight = 1;
                    }
                }
                int i2 = ((ViewGroup.MarginLayoutParams) this).width;
                if (i2 == 0 || i2 == -1) {
                    this.horizontalDimensionFixed = false;
                    if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.matchConstraintDefaultWidth == 1) {
                        ((ViewGroup.MarginLayoutParams) this).width = -2;
                        this.constrainedWidth = true;
                    }
                }
                int i3 = ((ViewGroup.MarginLayoutParams) this).height;
                if (i3 == 0 || i3 == -1) {
                    this.verticalDimensionFixed = false;
                    if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.matchConstraintDefaultHeight == 1) {
                        ((ViewGroup.MarginLayoutParams) this).height = -2;
                        this.constrainedHeight = true;
                    }
                }
                if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
                    return;
                }
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                    this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
                }
                ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = Table.map.get(index);
                switch (i6) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f2;
                        if (f2 < 0.0f) {
                            this.circleAngle = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        this.matchConstraintDefaultWidth = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.matchConstraintDefaultHeight = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i6) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i2, indexOf2);
                                        String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.dimensionRatioSide == 1) {
                                                        this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.dimensionRatio.substring(i2);
                                        if (substring4.length() > 0) {
                                            this.dimensionRatioValue = Float.parseFloat(substring4);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                continue;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                continue;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                continue;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                continue;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }
    }
}
