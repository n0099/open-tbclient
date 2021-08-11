package androidx.constraintlayout.widget;

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
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Analyzer;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.ResolutionAnchor;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ALLOWS_EMBEDDED = false;
    public static final boolean CACHE_MEASURED_DIMENSION = false;
    public static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    public static final String TAG = "ConstraintLayout";
    public static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<View> mChildrenByIds;
    public ArrayList<ConstraintHelper> mConstraintHelpers;
    public ConstraintSet mConstraintSet;
    public int mConstraintSetId;
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
    public Metrics mMetrics;
    public int mMinHeight;
    public int mMinWidth;
    public int mOptimizationLevel;
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(Context context) {
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
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(null);
    }

    private final ConstraintWidget getTargetWidget(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
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

    private void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeSet) == null) {
            this.mLayoutWidget.setCompanionWidget(this);
            this.mChildrenByIds.put(getId(), this);
            this.mConstraintSet = null;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
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
                    } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                        try {
                            ConstraintSet constraintSet = new ConstraintSet();
                            this.mConstraintSet = constraintSet;
                            constraintSet.load(getContext(), resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintSet = null;
                        }
                        this.mConstraintSetId = resourceId;
                    }
                }
                obtainStyledAttributes.recycle();
            }
            this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
        }
    }

    private void internalMeasureChildren(int i2, int i3) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3) == null) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ConstraintWidget constraintWidget = layoutParams.widget;
                    if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                        constraintWidget.setVisibility(childAt.getVisibility());
                        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        boolean z3 = layoutParams.horizontalDimensionFixed;
                        if (z3 || layoutParams.verticalDimensionFixed || (!z3 && layoutParams.matchConstraintDefaultWidth == 1) || ((ViewGroup.MarginLayoutParams) layoutParams).width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || ((ViewGroup.MarginLayoutParams) layoutParams).height == -1))) {
                            if (i5 == 0) {
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -2);
                                z = true;
                            } else if (i5 == -1) {
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -1);
                                z = false;
                            } else {
                                z = i5 == -2;
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, i5);
                            }
                            if (i6 == 0) {
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
                                z2 = true;
                            } else if (i6 == -1) {
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -1);
                                z2 = false;
                            } else {
                                z2 = i6 == -2;
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, i6);
                            }
                            childAt.measure(childMeasureSpec, childMeasureSpec2);
                            Metrics metrics = this.mMetrics;
                            if (metrics != null) {
                                metrics.measures++;
                            }
                            constraintWidget.setWidthWrapContent(i5 == -2);
                            constraintWidget.setHeightWrapContent(i6 == -2);
                            i5 = childAt.getMeasuredWidth();
                            i6 = childAt.getMeasuredHeight();
                        } else {
                            z = false;
                            z2 = false;
                        }
                        constraintWidget.setWidth(i5);
                        constraintWidget.setHeight(i6);
                        if (z) {
                            constraintWidget.setWrapWidth(i5);
                        }
                        if (z2) {
                            constraintWidget.setWrapHeight(i6);
                        }
                        if (layoutParams.needsBaseline && (baseline = childAt.getBaseline()) != -1) {
                            constraintWidget.setBaselineDistance(baseline);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02d1 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void internalMeasureDimensions(int i2, int i3) {
        long j2;
        int i4;
        ConstraintLayout constraintLayout;
        int i5;
        int i6;
        long j3;
        boolean z;
        int childMeasureSpec;
        boolean z2;
        int childMeasureSpec2;
        Metrics metrics;
        int baseline;
        int i7;
        int baseline2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3) == null) {
            ConstraintLayout constraintLayout2 = this;
            int i8 = i3;
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int childCount = getChildCount();
            int i9 = 0;
            while (true) {
                j2 = 1;
                i4 = 8;
                if (i9 >= childCount) {
                    break;
                }
                View childAt = constraintLayout2.getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ConstraintWidget constraintWidget = layoutParams.widget;
                    if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                        constraintWidget.setVisibility(childAt.getVisibility());
                        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i10 != 0 && i11 != 0) {
                            boolean z3 = i10 == -2;
                            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i2, paddingLeft, i10);
                            boolean z4 = i11 == -2;
                            childAt.measure(childMeasureSpec3, ViewGroup.getChildMeasureSpec(i8, paddingTop, i11));
                            Metrics metrics2 = constraintLayout2.mMetrics;
                            i7 = paddingTop;
                            if (metrics2 != null) {
                                metrics2.measures++;
                            }
                            constraintWidget.setWidthWrapContent(i10 == -2);
                            constraintWidget.setHeightWrapContent(i11 == -2);
                            int measuredWidth = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            constraintWidget.setWidth(measuredWidth);
                            constraintWidget.setHeight(measuredHeight);
                            if (z3) {
                                constraintWidget.setWrapWidth(measuredWidth);
                            }
                            if (z4) {
                                constraintWidget.setWrapHeight(measuredHeight);
                            }
                            if (layoutParams.needsBaseline && (baseline2 = childAt.getBaseline()) != -1) {
                                constraintWidget.setBaselineDistance(baseline2);
                            }
                            if (layoutParams.horizontalDimensionFixed && layoutParams.verticalDimensionFixed) {
                                constraintWidget.getResolutionWidth().resolve(measuredWidth);
                                constraintWidget.getResolutionHeight().resolve(measuredHeight);
                            }
                        } else {
                            i7 = paddingTop;
                            constraintWidget.getResolutionWidth().invalidate();
                            constraintWidget.getResolutionHeight().invalidate();
                        }
                        i9++;
                        i8 = i3;
                        paddingTop = i7;
                    }
                }
                i7 = paddingTop;
                i9++;
                i8 = i3;
                paddingTop = i7;
            }
            int i12 = paddingTop;
            constraintLayout2.mLayoutWidget.solveGraph();
            int i13 = 0;
            while (i13 < childCount) {
                View childAt2 = constraintLayout2.getChildAt(i13);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    ConstraintWidget constraintWidget2 = layoutParams2.widget;
                    if (!layoutParams2.isGuideline && !layoutParams2.isHelper) {
                        constraintWidget2.setVisibility(childAt2.getVisibility());
                        int i14 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                        if (i14 == 0 || i15 == 0) {
                            ResolutionAnchor resolutionNode = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
                            ResolutionAnchor resolutionNode2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getResolutionNode();
                            boolean z5 = (constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getTarget() == null || constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() == null) ? false : true;
                            ResolutionAnchor resolutionNode3 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
                            ResolutionAnchor resolutionNode4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getResolutionNode();
                            i6 = childCount;
                            boolean z6 = (constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getTarget() == null || constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() == null) ? false : true;
                            if (i14 == 0 && i15 == 0 && z5 && z6) {
                                constraintLayout = constraintLayout2;
                                i5 = i13;
                                j3 = 1;
                            } else {
                                i5 = i13;
                                boolean z7 = constraintLayout2.mLayoutWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                boolean z8 = constraintLayout2.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                if (!z7) {
                                    constraintWidget2.getResolutionWidth().invalidate();
                                }
                                if (!z8) {
                                    constraintWidget2.getResolutionHeight().invalidate();
                                }
                                if (i14 == 0) {
                                    if (z7 && constraintWidget2.isSpreadWidth() && z5 && resolutionNode.isResolved() && resolutionNode2.isResolved()) {
                                        i14 = (int) (resolutionNode2.getResolvedValue() - resolutionNode.getResolvedValue());
                                        constraintWidget2.getResolutionWidth().resolve(i14);
                                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, i14);
                                        z = false;
                                        if (i15 != 0) {
                                        }
                                    } else {
                                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -2);
                                        z7 = false;
                                        z = true;
                                        if (i15 != 0) {
                                            if (z8 && constraintWidget2.isSpreadHeight() && z6 && resolutionNode3.isResolved() && resolutionNode4.isResolved()) {
                                                i15 = (int) (resolutionNode4.getResolvedValue() - resolutionNode3.getResolvedValue());
                                                constraintWidget2.getResolutionHeight().resolve(i15);
                                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, i12, i15);
                                                z2 = false;
                                                childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                                constraintLayout = this;
                                                metrics = constraintLayout.mMetrics;
                                                if (metrics == null) {
                                                }
                                                constraintWidget2.setWidthWrapContent(i14 != -2);
                                                constraintWidget2.setHeightWrapContent(i15 != -2);
                                                int measuredWidth2 = childAt2.getMeasuredWidth();
                                                int measuredHeight2 = childAt2.getMeasuredHeight();
                                                constraintWidget2.setWidth(measuredWidth2);
                                                constraintWidget2.setHeight(measuredHeight2);
                                                if (z) {
                                                }
                                                if (z2) {
                                                }
                                                if (!z7) {
                                                }
                                                if (!z8) {
                                                }
                                                if (layoutParams2.needsBaseline) {
                                                    constraintWidget2.setBaselineDistance(baseline);
                                                }
                                            } else {
                                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, i12, -2);
                                                z8 = false;
                                                z2 = true;
                                                childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                                constraintLayout = this;
                                                metrics = constraintLayout.mMetrics;
                                                if (metrics == null) {
                                                    j3 = 1;
                                                    metrics.measures++;
                                                } else {
                                                    j3 = 1;
                                                }
                                                constraintWidget2.setWidthWrapContent(i14 != -2);
                                                constraintWidget2.setHeightWrapContent(i15 != -2);
                                                int measuredWidth22 = childAt2.getMeasuredWidth();
                                                int measuredHeight22 = childAt2.getMeasuredHeight();
                                                constraintWidget2.setWidth(measuredWidth22);
                                                constraintWidget2.setHeight(measuredHeight22);
                                                if (z) {
                                                    constraintWidget2.setWrapWidth(measuredWidth22);
                                                }
                                                if (z2) {
                                                    constraintWidget2.setWrapHeight(measuredHeight22);
                                                }
                                                if (!z7) {
                                                    constraintWidget2.getResolutionWidth().resolve(measuredWidth22);
                                                } else {
                                                    constraintWidget2.getResolutionWidth().remove();
                                                }
                                                if (!z8) {
                                                    constraintWidget2.getResolutionHeight().resolve(measuredHeight22);
                                                } else {
                                                    constraintWidget2.getResolutionHeight().remove();
                                                }
                                                if (layoutParams2.needsBaseline && (baseline = childAt2.getBaseline()) != -1) {
                                                    constraintWidget2.setBaselineDistance(baseline);
                                                }
                                            }
                                        } else if (i15 == -1) {
                                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, i12, -1);
                                            z2 = false;
                                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                            constraintLayout = this;
                                            metrics = constraintLayout.mMetrics;
                                            if (metrics == null) {
                                            }
                                            constraintWidget2.setWidthWrapContent(i14 != -2);
                                            constraintWidget2.setHeightWrapContent(i15 != -2);
                                            int measuredWidth222 = childAt2.getMeasuredWidth();
                                            int measuredHeight222 = childAt2.getMeasuredHeight();
                                            constraintWidget2.setWidth(measuredWidth222);
                                            constraintWidget2.setHeight(measuredHeight222);
                                            if (z) {
                                            }
                                            if (z2) {
                                            }
                                            if (!z7) {
                                            }
                                            if (!z8) {
                                            }
                                            if (layoutParams2.needsBaseline) {
                                            }
                                        } else {
                                            z2 = i15 == -2;
                                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, i12, i15);
                                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                            constraintLayout = this;
                                            metrics = constraintLayout.mMetrics;
                                            if (metrics == null) {
                                            }
                                            constraintWidget2.setWidthWrapContent(i14 != -2);
                                            constraintWidget2.setHeightWrapContent(i15 != -2);
                                            int measuredWidth2222 = childAt2.getMeasuredWidth();
                                            int measuredHeight2222 = childAt2.getMeasuredHeight();
                                            constraintWidget2.setWidth(measuredWidth2222);
                                            constraintWidget2.setHeight(measuredHeight2222);
                                            if (z) {
                                            }
                                            if (z2) {
                                            }
                                            if (!z7) {
                                            }
                                            if (!z8) {
                                            }
                                            if (layoutParams2.needsBaseline) {
                                            }
                                        }
                                    }
                                } else if (i14 == -1) {
                                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -1);
                                    z = false;
                                    if (i15 != 0) {
                                    }
                                } else {
                                    z = i14 == -2;
                                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, i14);
                                    if (i15 != 0) {
                                    }
                                }
                            }
                            i13 = i5 + 1;
                            constraintLayout2 = constraintLayout;
                            childCount = i6;
                            j2 = j3;
                            i4 = 8;
                        }
                    }
                }
                constraintLayout = constraintLayout2;
                i5 = i13;
                i6 = childCount;
                j3 = j2;
                i13 = i5 + 1;
                constraintLayout2 = constraintLayout;
                childCount = i6;
                j2 = j3;
                i4 = 8;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:253:0x03e3 */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01da, code lost:
        if (r11 != (-1)) goto L234;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03b6  */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.constraintlayout.widget.ConstraintLayout, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setChildrenConstraints() {
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        float f3;
        ConstraintWidget targetWidget;
        ConstraintWidget targetWidget2;
        ConstraintWidget targetWidget3;
        ConstraintWidget targetWidget4;
        String str;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            boolean isInEditMode = isInEditMode();
            int childCount = getChildCount();
            ?? r3 = 0;
            if (isInEditMode) {
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
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
            for (int i9 = 0; i9 < childCount; i9++) {
                ConstraintWidget viewWidget = getViewWidget(getChildAt(i9));
                if (viewWidget != null) {
                    viewWidget.reset();
                }
            }
            if (this.mConstraintSetId != -1) {
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt2 = getChildAt(i10);
                    if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                        this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                    }
                }
            }
            ConstraintSet constraintSet = this.mConstraintSet;
            if (constraintSet != null) {
                constraintSet.applyToInternal(this);
            }
            this.mLayoutWidget.removeAllChildren();
            int size = this.mConstraintHelpers.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    this.mConstraintHelpers.get(i11).updatePreLayout(this);
                }
            }
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt3 = getChildAt(i12);
                if (childAt3 instanceof Placeholder) {
                    ((Placeholder) childAt3).updatePreLayout(this);
                }
            }
            int i13 = 0;
            while (i13 < childCount) {
                View childAt4 = getChildAt(i13);
                ConstraintWidget viewWidget2 = getViewWidget(childAt4);
                if (viewWidget2 != null) {
                    LayoutParams layoutParams = (LayoutParams) childAt4.getLayoutParams();
                    layoutParams.validate();
                    if (layoutParams.helped) {
                        layoutParams.helped = r3;
                    } else if (isInEditMode) {
                        try {
                            String resourceName2 = getResources().getResourceName(childAt4.getId());
                            setDesignInformation(r3, resourceName2, Integer.valueOf(childAt4.getId()));
                            getTargetWidget(childAt4.getId()).setDebugName(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                        } catch (Resources.NotFoundException unused2) {
                        }
                    }
                    viewWidget2.setVisibility(childAt4.getVisibility());
                    if (layoutParams.isInPlaceholder) {
                        viewWidget2.setVisibility(8);
                    }
                    viewWidget2.setCompanionWidget(childAt4);
                    this.mLayoutWidget.add(viewWidget2);
                    if (!layoutParams.verticalDimensionFixed || !layoutParams.horizontalDimensionFixed) {
                        this.mVariableDimensionsWidgets.add(viewWidget2);
                    }
                    if (layoutParams.isGuideline) {
                        androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) viewWidget2;
                        int i14 = layoutParams.resolvedGuideBegin;
                        int i15 = layoutParams.resolvedGuideEnd;
                        float f4 = layoutParams.resolvedGuidePercent;
                        if (Build.VERSION.SDK_INT < 17) {
                            i14 = layoutParams.guideBegin;
                            i15 = layoutParams.guideEnd;
                            f4 = layoutParams.guidePercent;
                        }
                        if (f4 != -1.0f) {
                            guideline.setGuidePercent(f4);
                        } else if (i14 != -1) {
                            guideline.setGuideBegin(i14);
                        } else if (i15 != -1) {
                            guideline.setGuideEnd(i15);
                        }
                    } else if (layoutParams.leftToLeft != -1 || layoutParams.leftToRight != -1 || layoutParams.rightToLeft != -1 || layoutParams.rightToRight != -1 || layoutParams.startToStart != -1 || layoutParams.startToEnd != -1 || layoutParams.endToStart != -1 || layoutParams.endToEnd != -1 || layoutParams.topToTop != -1 || layoutParams.topToBottom != -1 || layoutParams.bottomToTop != -1 || layoutParams.bottomToBottom != -1 || layoutParams.baselineToBaseline != -1 || layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1 || layoutParams.circleConstraint != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).width == -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                        int i16 = layoutParams.resolvedLeftToLeft;
                        int i17 = layoutParams.resolvedLeftToRight;
                        int i18 = layoutParams.resolvedRightToLeft;
                        int i19 = layoutParams.resolvedRightToRight;
                        int i20 = layoutParams.resolveGoneLeftMargin;
                        int i21 = layoutParams.resolveGoneRightMargin;
                        float f5 = layoutParams.resolvedHorizontalBias;
                        if (Build.VERSION.SDK_INT < 17) {
                            int i22 = layoutParams.leftToLeft;
                            int i23 = layoutParams.leftToRight;
                            int i24 = layoutParams.rightToLeft;
                            i19 = layoutParams.rightToRight;
                            int i25 = layoutParams.goneLeftMargin;
                            int i26 = layoutParams.goneRightMargin;
                            f5 = layoutParams.horizontalBias;
                            if (i22 == -1 && i23 == -1) {
                                int i27 = layoutParams.startToStart;
                                if (i27 != -1) {
                                    i7 = i23;
                                    i16 = i27;
                                    if (i24 == -1 && i19 == -1) {
                                        i2 = layoutParams.endToStart;
                                        if (i2 == -1) {
                                            i4 = i25;
                                            i3 = i26;
                                            i17 = i7;
                                        } else {
                                            int i28 = layoutParams.endToEnd;
                                            if (i28 != -1) {
                                                i4 = i25;
                                                i3 = i26;
                                                i17 = i7;
                                                f2 = f5;
                                                i5 = i28;
                                                i2 = i24;
                                                i6 = layoutParams.circleConstraint;
                                                if (i6 == -1) {
                                                    ConstraintWidget targetWidget5 = getTargetWidget(i6);
                                                    if (targetWidget5 != null) {
                                                        viewWidget2.connectCircularConstraint(targetWidget5, layoutParams.circleAngle, layoutParams.circleRadius);
                                                    }
                                                } else {
                                                    if (i16 != -1) {
                                                        ConstraintWidget targetWidget6 = getTargetWidget(i16);
                                                        if (targetWidget6 != null) {
                                                            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                                            f3 = f2;
                                                            viewWidget2.immediateConnect(type, targetWidget6, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i4);
                                                        } else {
                                                            f3 = f2;
                                                        }
                                                    } else {
                                                        f3 = f2;
                                                        if (i17 != -1 && (targetWidget = getTargetWidget(i17)) != null) {
                                                            viewWidget2.immediateConnect(ConstraintAnchor.Type.LEFT, targetWidget, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i4);
                                                        }
                                                    }
                                                    if (i2 != -1) {
                                                        ConstraintWidget targetWidget7 = getTargetWidget(i2);
                                                        if (targetWidget7 != null) {
                                                            viewWidget2.immediateConnect(ConstraintAnchor.Type.RIGHT, targetWidget7, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                                                        }
                                                    } else if (i5 != -1 && (targetWidget2 = getTargetWidget(i5)) != null) {
                                                        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                                                        viewWidget2.immediateConnect(type2, targetWidget2, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                                                    }
                                                    int i29 = layoutParams.topToTop;
                                                    if (i29 != -1) {
                                                        ConstraintWidget targetWidget8 = getTargetWidget(i29);
                                                        if (targetWidget8 != null) {
                                                            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                                                            viewWidget2.immediateConnect(type3, targetWidget8, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                                        }
                                                    } else {
                                                        int i30 = layoutParams.topToBottom;
                                                        if (i30 != -1 && (targetWidget3 = getTargetWidget(i30)) != null) {
                                                            viewWidget2.immediateConnect(ConstraintAnchor.Type.TOP, targetWidget3, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                                        }
                                                    }
                                                    int i31 = layoutParams.bottomToTop;
                                                    if (i31 != -1) {
                                                        ConstraintWidget targetWidget9 = getTargetWidget(i31);
                                                        if (targetWidget9 != null) {
                                                            viewWidget2.immediateConnect(ConstraintAnchor.Type.BOTTOM, targetWidget9, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                                        }
                                                    } else {
                                                        int i32 = layoutParams.bottomToBottom;
                                                        if (i32 != -1 && (targetWidget4 = getTargetWidget(i32)) != null) {
                                                            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                                                            viewWidget2.immediateConnect(type4, targetWidget4, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                                        }
                                                    }
                                                    int i33 = layoutParams.baselineToBaseline;
                                                    if (i33 != -1) {
                                                        View view = this.mChildrenByIds.get(i33);
                                                        ConstraintWidget targetWidget10 = getTargetWidget(layoutParams.baselineToBaseline);
                                                        if (targetWidget10 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
                                                            layoutParams.needsBaseline = true;
                                                            ((LayoutParams) view.getLayoutParams()).needsBaseline = true;
                                                            viewWidget2.getAnchor(ConstraintAnchor.Type.BASELINE).connect(targetWidget10.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                                                            viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                                            viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                                                        }
                                                    }
                                                    float f6 = f3;
                                                    if (f6 >= 0.0f && f6 != 0.5f) {
                                                        viewWidget2.setHorizontalBiasPercent(f6);
                                                    }
                                                    float f7 = layoutParams.verticalBias;
                                                    if (f7 >= 0.0f && f7 != 0.5f) {
                                                        viewWidget2.setVerticalBiasPercent(f7);
                                                    }
                                                }
                                                if (isInEditMode && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1)) {
                                                    viewWidget2.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                                                }
                                                if (layoutParams.horizontalDimensionFixed) {
                                                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                                                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                                                        viewWidget2.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                                                        viewWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                                                    } else {
                                                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                                        viewWidget2.setWidth(0);
                                                    }
                                                } else {
                                                    viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                                                    viewWidget2.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
                                                }
                                                if (layoutParams.verticalDimensionFixed) {
                                                    if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                                                        viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                                                        viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                                        r3 = 0;
                                                    } else {
                                                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                                                        r3 = 0;
                                                        viewWidget2.setHeight(0);
                                                    }
                                                } else {
                                                    r3 = 0;
                                                    viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                                                    viewWidget2.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
                                                }
                                                str = layoutParams.dimensionRatio;
                                                if (str != null) {
                                                    viewWidget2.setDimensionRatio(str);
                                                }
                                                viewWidget2.setHorizontalWeight(layoutParams.horizontalWeight);
                                                viewWidget2.setVerticalWeight(layoutParams.verticalWeight);
                                                viewWidget2.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                                                viewWidget2.setVerticalChainStyle(layoutParams.verticalChainStyle);
                                                viewWidget2.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                                                viewWidget2.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                                            }
                                        }
                                    }
                                    i4 = i25;
                                    i3 = i26;
                                    i2 = i24;
                                    i17 = i7;
                                } else {
                                    i7 = layoutParams.startToEnd;
                                }
                            }
                            i7 = i23;
                            i16 = i22;
                            if (i24 == -1) {
                                i2 = layoutParams.endToStart;
                                if (i2 == -1) {
                                }
                            }
                            i4 = i25;
                            i3 = i26;
                            i2 = i24;
                            i17 = i7;
                        } else {
                            i2 = i18;
                            i3 = i21;
                            i4 = i20;
                        }
                        f2 = f5;
                        i5 = i19;
                        i6 = layoutParams.circleConstraint;
                        if (i6 == -1) {
                        }
                        if (isInEditMode) {
                            viewWidget2.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                        }
                        if (layoutParams.horizontalDimensionFixed) {
                        }
                        if (layoutParams.verticalDimensionFixed) {
                        }
                        str = layoutParams.dimensionRatio;
                        if (str != null) {
                        }
                        viewWidget2.setHorizontalWeight(layoutParams.horizontalWeight);
                        viewWidget2.setVerticalWeight(layoutParams.verticalWeight);
                        viewWidget2.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                        viewWidget2.setVerticalChainStyle(layoutParams.verticalChainStyle);
                        viewWidget2.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                        viewWidget2.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                    }
                }
                i13++;
                r3 = r3;
            }
        }
    }

    private void setSelfDimensionBehaviour(int i2, int i3) {
        int i4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
            getLayoutParams();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                } else if (mode != 1073741824) {
                    dimensionBehaviour = dimensionBehaviour2;
                } else {
                    i4 = Math.min(this.mMaxWidth, size) - paddingLeft;
                    dimensionBehaviour = dimensionBehaviour2;
                }
                i4 = 0;
            } else {
                i4 = size;
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            if (mode2 != Integer.MIN_VALUE) {
                if (mode2 == 0) {
                    dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                } else if (mode2 == 1073741824) {
                    size2 = Math.min(this.mMaxHeight, size2) - paddingTop;
                }
                size2 = 0;
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            this.mLayoutWidget.setMinWidth(0);
            this.mLayoutWidget.setMinHeight(0);
            this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
            this.mLayoutWidget.setWidth(i4);
            this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
            this.mLayoutWidget.setHeight(size2);
            this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
            this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
        }
    }

    private void updateHierarchy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
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
                this.mVariableDimensionsWidgets.clear();
                setChildrenConstraints();
            }
        }
    }

    private void updatePostMeasures() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this);
                }
            }
            int size = this.mConstraintHelpers.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    this.mConstraintHelpers.get(i3).updatePostMeasure(this);
                }
            }
        }
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

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (isInEditMode()) {
                int childCount = getChildCount();
                float width = getWidth();
                float height = getHeight();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int parseInt3 = Integer.parseInt(split[2]);
                            int i3 = (int) ((parseInt / 1080.0f) * width);
                            int i4 = (int) ((parseInt2 / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(SupportMenu.CATEGORY_MASK);
                            float f2 = i3;
                            float f3 = i4;
                            float f4 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                            canvas.drawLine(f2, f3, f4, f3, paint);
                            float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                            canvas.drawLine(f4, f3, f4, parseInt4, paint);
                            canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                            canvas.drawLine(f2, parseInt4, f2, f3, paint);
                            paint.setColor(-16711936);
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
        if (interceptable == null || interceptable.invokeL(1048579, this, metrics) == null) {
            this.mMetrics = metrics;
            this.mLayoutWidget.fillMetrics(metrics);
        }
    }

    public Object getDesignInformation(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, obj)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMaxHeight : invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mMaxWidth : invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mMinHeight : invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMinWidth : invokeV.intValue;
    }

    public int getOptimizationLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mLayoutWidget.getOptimizationLevel() : invokeV.intValue;
    }

    public View getViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? this.mChildrenByIds.get(i2) : (View) invokeI.objValue;
    }

    public final ConstraintWidget getViewWidget(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            boolean isInEditMode = isInEditMode();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                    int drawX = constraintWidget.getDrawX();
                    int drawY = constraintWidget.getDrawY();
                    int width = constraintWidget.getWidth() + drawX;
                    int height = constraintWidget.getHeight() + drawY;
                    childAt.layout(drawX, drawY, width, height);
                    if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                        content.setVisibility(0);
                        content.layout(drawX, drawY, width, height);
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

    /* JADX WARN: Removed duplicated region for block: B:180:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int size;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        int i7;
        boolean z4;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int i8;
        int i9;
        boolean z5;
        int baseline;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(1048594, this, i2, i3) != null) {
            return;
        }
        int i10 = i2;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.mLayoutWidget.setX(paddingLeft);
        this.mLayoutWidget.setY(paddingTop);
        this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
        this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mLayoutWidget.setRtl(getLayoutDirection() == 1);
        }
        setSelfDimensionBehaviour(i2, i3);
        int width = this.mLayoutWidget.getWidth();
        int height = this.mLayoutWidget.getHeight();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            updateHierarchy();
            z = true;
        } else {
            z = false;
        }
        boolean z6 = (this.mOptimizationLevel & 8) == 8;
        if (z6) {
            this.mLayoutWidget.preOptimize();
            this.mLayoutWidget.optimizeForDimensions(width, height);
            internalMeasureDimensions(i2, i3);
        } else {
            internalMeasureChildren(i2, i3);
        }
        updatePostMeasures();
        if (getChildCount() > 0 && z) {
            Analyzer.determineGroups(this.mLayoutWidget);
        }
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        if (constraintWidgetContainer.mGroupsWrapOptimized) {
            if (constraintWidgetContainer.mHorizontalWrapOptimized && mode == Integer.MIN_VALUE) {
                int i11 = constraintWidgetContainer.mWrapFixedWidth;
                if (i11 < size2) {
                    constraintWidgetContainer.setWidth(i11);
                }
                this.mLayoutWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            }
            ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
            if (constraintWidgetContainer2.mVerticalWrapOptimized && mode2 == Integer.MIN_VALUE) {
                int i12 = constraintWidgetContainer2.mWrapFixedHeight;
                if (i12 < size3) {
                    constraintWidgetContainer2.setHeight(i12);
                }
                this.mLayoutWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            }
        }
        if ((this.mOptimizationLevel & 32) == 32) {
            int width2 = this.mLayoutWidget.getWidth();
            int height2 = this.mLayoutWidget.getHeight();
            if (this.mLastMeasureWidth != width2 && mode == 1073741824) {
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, width2);
            }
            if (this.mLastMeasureHeight != height2 && mode2 == 1073741824) {
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, height2);
            }
            ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutWidget;
            if (constraintWidgetContainer3.mHorizontalWrapOptimized && constraintWidgetContainer3.mWrapFixedWidth > size2) {
                Analyzer.setPosition(constraintWidgetContainer3.mWidgetGroups, 0, size2);
            }
            ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutWidget;
            if (constraintWidgetContainer4.mVerticalWrapOptimized && constraintWidgetContainer4.mWrapFixedHeight > size3) {
                Analyzer.setPosition(constraintWidgetContainer4.mWidgetGroups, 1, size3);
                if (getChildCount() > 0) {
                    solveLinearSystem("First pass");
                }
                size = this.mVariableDimensionsWidgets.size();
                int paddingBottom = paddingTop + getPaddingBottom();
                int paddingRight = paddingLeft + getPaddingRight();
                if (size <= 0) {
                    boolean z7 = this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    boolean z8 = this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    int max = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
                    int max2 = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
                    int i13 = 0;
                    boolean z9 = false;
                    int i14 = 0;
                    while (i13 < size) {
                        ConstraintWidget constraintWidget = this.mVariableDimensionsWidgets.get(i13);
                        int i15 = size;
                        View view = (View) constraintWidget.getCompanionWidget();
                        if (view == null) {
                            i7 = width;
                            i6 = height;
                        } else {
                            i6 = height;
                            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                            i7 = width;
                            if (!layoutParams.isHelper && !layoutParams.isGuideline) {
                                z4 = z9;
                                if (view.getVisibility() != 8 && (!z6 || !constraintWidget.getResolutionWidth().isResolved() || !constraintWidget.getResolutionHeight().isResolved())) {
                                    int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                                    if (i16 == -2 && layoutParams.horizontalDimensionFixed) {
                                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingRight, i16);
                                    } else {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                                    }
                                    int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                                    if (i17 == -2 && layoutParams.verticalDimensionFixed) {
                                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingBottom, i17);
                                    } else {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                    }
                                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                                    Metrics metrics = this.mMetrics;
                                    i8 = paddingBottom;
                                    if (metrics != null) {
                                        metrics.additionalMeasures++;
                                    }
                                    int measuredWidth = view.getMeasuredWidth();
                                    int measuredHeight = view.getMeasuredHeight();
                                    if (measuredWidth != constraintWidget.getWidth()) {
                                        constraintWidget.setWidth(measuredWidth);
                                        if (z6) {
                                            constraintWidget.getResolutionWidth().resolve(measuredWidth);
                                        }
                                        if (z7 && constraintWidget.getRight() > max) {
                                            max = Math.max(max, constraintWidget.getRight() + constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                        }
                                        z4 = true;
                                    }
                                    if (measuredHeight != constraintWidget.getHeight()) {
                                        constraintWidget.setHeight(measuredHeight);
                                        if (z6) {
                                            constraintWidget.getResolutionHeight().resolve(measuredHeight);
                                        }
                                        if (z8 && constraintWidget.getBottom() > max2) {
                                            max2 = Math.max(max2, constraintWidget.getBottom() + constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                        }
                                        i9 = max2;
                                        z5 = true;
                                    } else {
                                        i9 = max2;
                                        z5 = z4;
                                    }
                                    if (layoutParams.needsBaseline && (baseline = view.getBaseline()) != -1 && baseline != constraintWidget.getBaselineDistance()) {
                                        constraintWidget.setBaselineDistance(baseline);
                                        z5 = true;
                                    }
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        i14 = ViewGroup.combineMeasuredStates(i14, view.getMeasuredState());
                                    }
                                    z4 = z5;
                                    max2 = i9;
                                    i13++;
                                    i10 = i2;
                                    paddingBottom = i8;
                                    width = i7;
                                    size = i15;
                                    height = i6;
                                    z9 = z4;
                                }
                                i8 = paddingBottom;
                                i14 = i14;
                                i13++;
                                i10 = i2;
                                paddingBottom = i8;
                                width = i7;
                                size = i15;
                                height = i6;
                                z9 = z4;
                            }
                        }
                        z4 = z9;
                        i8 = paddingBottom;
                        i14 = i14;
                        i13++;
                        i10 = i2;
                        paddingBottom = i8;
                        width = i7;
                        size = i15;
                        height = i6;
                        z9 = z4;
                    }
                    int i18 = size;
                    int i19 = width;
                    int i20 = height;
                    boolean z10 = z9;
                    i4 = paddingBottom;
                    int i21 = i14;
                    if (z10) {
                        this.mLayoutWidget.setWidth(i19);
                        this.mLayoutWidget.setHeight(i20);
                        if (z6) {
                            this.mLayoutWidget.solveGraph();
                        }
                        solveLinearSystem("2nd pass");
                        if (this.mLayoutWidget.getWidth() < max) {
                            this.mLayoutWidget.setWidth(max);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.mLayoutWidget.getHeight() < max2) {
                            this.mLayoutWidget.setHeight(max2);
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (z3) {
                            solveLinearSystem("3rd pass");
                        }
                    }
                    for (int i22 = 0; i22 < i18; i22++) {
                        ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i22);
                        View view2 = (View) constraintWidget2.getCompanionWidget();
                        if (view2 != null && (view2.getMeasuredWidth() != constraintWidget2.getWidth() || view2.getMeasuredHeight() != constraintWidget2.getHeight())) {
                            if (constraintWidget2.getVisibility() != 8) {
                                view2.measure(View.MeasureSpec.makeMeasureSpec(constraintWidget2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(constraintWidget2.getHeight(), 1073741824));
                                Metrics metrics2 = this.mMetrics;
                                if (metrics2 != null) {
                                    metrics2.additionalMeasures++;
                                }
                            }
                        }
                    }
                    i5 = i21;
                } else {
                    i4 = paddingBottom;
                    i5 = 0;
                }
                int width3 = this.mLayoutWidget.getWidth() + paddingRight;
                int height3 = this.mLayoutWidget.getHeight() + i4;
                if (Build.VERSION.SDK_INT < 11) {
                    int min = Math.min(this.mMaxWidth, ViewGroup.resolveSizeAndState(width3, i2, i5) & 16777215);
                    int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(height3, i3, i5 << 16) & 16777215);
                    if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
                        min |= 16777216;
                    }
                    if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
                        min2 |= 16777216;
                    }
                    setMeasuredDimension(min, min2);
                    this.mLastMeasureWidth = min;
                    this.mLastMeasureHeight = min2;
                    return;
                }
                setMeasuredDimension(width3, height3);
                this.mLastMeasureWidth = width3;
                this.mLastMeasureHeight = height3;
                return;
            }
        }
        if (getChildCount() > 0) {
        }
        size = this.mVariableDimensionsWidgets.size();
        int paddingBottom2 = paddingTop + getPaddingBottom();
        int paddingRight2 = paddingLeft + getPaddingRight();
        if (size <= 0) {
        }
        int width32 = this.mLayoutWidget.getWidth() + paddingRight2;
        int height32 = this.mLayoutWidget.getHeight() + i4;
        if (Build.VERSION.SDK_INT < 11) {
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onViewRemoved(view);
            }
            this.mChildrenByIds.remove(view.getId());
            ConstraintWidget viewWidget = getViewWidget(view);
            this.mLayoutWidget.remove(viewWidget);
            this.mConstraintHelpers.remove(view);
            this.mVariableDimensionsWidgets.remove(viewWidget);
            this.mDirtyHierarchy = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            super.removeView(view);
            if (Build.VERSION.SDK_INT < 14) {
                onViewRemoved(view);
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.requestLayout();
            this.mDirtyHierarchy = true;
            this.mLastMeasureWidth = -1;
            this.mLastMeasureHeight = -1;
            this.mLastMeasureWidthSize = -1;
            this.mLastMeasureHeightSize = -1;
            this.mLastMeasureWidthMode = 0;
            this.mLastMeasureHeightMode = 0;
        }
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, constraintSet) == null) {
            this.mConstraintSet = constraintSet;
        }
    }

    public void setDesignInformation(int i2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048600, this, i2, obj, obj2) == null) && i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
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
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mChildrenByIds.remove(getId());
            super.setId(i2);
            this.mChildrenByIds.put(getId(), this);
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || i2 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || i2 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || i2 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || i2 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i2;
        requestLayout();
    }

    public void setOptimizationLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.mLayoutWidget.setOptimizationLevel(i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void solveLinearSystem(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mLayoutWidget.layout();
            Metrics metrics = this.mMetrics;
            if (metrics != null) {
                metrics.resolutions++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(Context context, AttributeSet attributeSet) {
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
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(attributeSet);
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
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
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
            this.widget = layoutParams.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (constraintWidget = this.widget) == null) {
                return;
            }
            constraintWidget.reset();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i7 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                int i8 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
                super.resolveLayoutDirection(i2);
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
                boolean z = false;
                if (1 == getLayoutDirection()) {
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
                            z = true;
                        }
                        i4 = this.endToEnd;
                        if (i4 != -1) {
                            this.resolvedLeftToLeft = i4;
                            z = true;
                        }
                        i5 = this.goneStartMargin;
                        if (i5 != -1) {
                            this.resolveGoneRightMargin = i5;
                        }
                        i6 = this.goneEndMargin;
                        if (i6 != -1) {
                            this.resolveGoneLeftMargin = i6;
                        }
                        if (z) {
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
                    z = true;
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
                    if (z) {
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
                if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
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
                    }
                }
            }
        }

        public void validate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.isGuideline = false;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.constrainedWidth) {
                    this.horizontalDimensionFixed = false;
                    this.matchConstraintDefaultWidth = 1;
                }
                if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.constrainedHeight) {
                    this.verticalDimensionFixed = false;
                    this.matchConstraintDefaultHeight = 1;
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
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
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
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
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
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
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
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
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
