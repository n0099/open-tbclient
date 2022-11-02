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
import android.util.Log;
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

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
                sparseIntArray.append(45, 8);
                map.append(46, 9);
                map.append(48, 10);
                map.append(49, 11);
                map.append(54, 12);
                map.append(53, 13);
                map.append(27, 14);
                map.append(26, 15);
                map.append(24, 16);
                map.append(28, 2);
                map.append(30, 3);
                map.append(29, 4);
                map.append(62, 49);
                map.append(63, 50);
                map.append(34, 5);
                map.append(35, 6);
                map.append(36, 7);
                map.append(0, 1);
                map.append(50, 17);
                map.append(51, 18);
                map.append(33, 19);
                map.append(32, 20);
                map.append(66, 21);
                map.append(69, 22);
                map.append(67, 23);
                map.append(64, 24);
                map.append(68, 25);
                map.append(65, 26);
                map.append(41, 29);
                map.append(55, 30);
                map.append(31, 44);
                map.append(43, 45);
                map.append(57, 46);
                map.append(42, 47);
                map.append(56, 48);
                map.append(22, 27);
                map.append(21, 28);
                map.append(58, 31);
                map.append(37, 32);
                map.append(60, 33);
                map.append(59, 34);
                map.append(61, 35);
                map.append(39, 36);
                map.append(38, 37);
                map.append(40, 38);
                map.append(44, 39);
                map.append(52, 40);
                map.append(47, 41);
                map.append(25, 42);
                map.append(23, 43);
                map.append(90, 51);
            }

            public Table() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
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
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                int i5 = Table.map.get(index);
                switch (i5) {
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
                        float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f;
                        if (f < 0.0f) {
                            this.circleAngle = (360.0f - f) % 360.0f;
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
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i6;
                        if (i6 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i7 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i7;
                        if (i7 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
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
                        switch (i5) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf > 0 && indexOf < length - 1) {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i = indexOf + 1;
                                    } else {
                                        i = 0;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i, indexOf2);
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
                                        String substring4 = this.dimensionRatio.substring(i);
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
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.constraintTag;
            }
            return (String) invokeV.objValue;
        }

        public ConstraintWidget getConstraintWidget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.widget;
            }
            return (ConstraintWidget) invokeV.objValue;
        }

        public void reset() {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (constraintWidget = this.widget) != null) {
                constraintWidget.reset();
            }
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
        public void resolveLayoutDirection(int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
                boolean z2 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    super.resolveLayoutDirection(i);
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
                            int i8 = this.startToEnd;
                            if (i8 != -1) {
                                this.resolvedRightToLeft = i8;
                            } else {
                                int i9 = this.startToStart;
                                if (i9 != -1) {
                                    this.resolvedRightToRight = i9;
                                }
                                i2 = this.endToStart;
                                if (i2 != -1) {
                                    this.resolvedLeftToRight = i2;
                                    z2 = true;
                                }
                                i3 = this.endToEnd;
                                if (i3 != -1) {
                                    this.resolvedLeftToLeft = i3;
                                    z2 = true;
                                }
                                i4 = this.goneStartMargin;
                                if (i4 != -1) {
                                    this.resolveGoneRightMargin = i4;
                                }
                                i5 = this.goneEndMargin;
                                if (i5 != -1) {
                                    this.resolveGoneLeftMargin = i5;
                                }
                                if (z2) {
                                    this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                                }
                                if (this.isGuideline && this.orientation == 1) {
                                    f = this.guidePercent;
                                    if (f == -1.0f) {
                                        this.resolvedGuidePercent = 1.0f - f;
                                        this.resolvedGuideBegin = -1;
                                        this.resolvedGuideEnd = -1;
                                    } else {
                                        int i10 = this.guideBegin;
                                        if (i10 != -1) {
                                            this.resolvedGuideEnd = i10;
                                            this.resolvedGuideBegin = -1;
                                            this.resolvedGuidePercent = -1.0f;
                                        } else {
                                            int i11 = this.guideEnd;
                                            if (i11 != -1) {
                                                this.resolvedGuideBegin = i11;
                                                this.resolvedGuideEnd = -1;
                                                this.resolvedGuidePercent = -1.0f;
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = true;
                            i2 = this.endToStart;
                            if (i2 != -1) {
                            }
                            i3 = this.endToEnd;
                            if (i3 != -1) {
                            }
                            i4 = this.goneStartMargin;
                            if (i4 != -1) {
                            }
                            i5 = this.goneEndMargin;
                            if (i5 != -1) {
                            }
                            if (z2) {
                            }
                            if (this.isGuideline) {
                                f = this.guidePercent;
                                if (f == -1.0f) {
                                }
                            }
                        } else {
                            int i12 = this.startToEnd;
                            if (i12 != -1) {
                                this.resolvedLeftToRight = i12;
                            }
                            int i13 = this.startToStart;
                            if (i13 != -1) {
                                this.resolvedLeftToLeft = i13;
                            }
                            int i14 = this.endToStart;
                            if (i14 != -1) {
                                this.resolvedRightToLeft = i14;
                            }
                            int i15 = this.endToEnd;
                            if (i15 != -1) {
                                this.resolvedRightToRight = i15;
                            }
                            int i16 = this.goneStartMargin;
                            if (i16 != -1) {
                                this.resolveGoneLeftMargin = i16;
                            }
                            int i17 = this.goneEndMargin;
                            if (i17 != -1) {
                                this.resolveGoneRightMargin = i17;
                            }
                        }
                        if (this.endToStart != -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                            int i18 = this.rightToLeft;
                            if (i18 != -1) {
                                this.resolvedRightToLeft = i18;
                                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                                    ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                                }
                            } else {
                                int i19 = this.rightToRight;
                                if (i19 != -1) {
                                    this.resolvedRightToRight = i19;
                                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                                    }
                                }
                            }
                            int i20 = this.leftToLeft;
                            if (i20 != -1) {
                                this.resolvedLeftToLeft = i20;
                                if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                                    return;
                                }
                                return;
                            }
                            int i21 = this.leftToRight;
                            if (i21 != -1) {
                                this.resolvedLeftToRight = i21;
                                if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                                    return;
                                }
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
                int i = ((ViewGroup.MarginLayoutParams) this).width;
                if (i == 0 || i == -1) {
                    this.horizontalDimensionFixed = false;
                    if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.matchConstraintDefaultWidth == 1) {
                        ((ViewGroup.MarginLayoutParams) this).width = -2;
                        this.constrainedWidth = true;
                    }
                }
                int i2 = ((ViewGroup.MarginLayoutParams) this).height;
                if (i2 == 0 || i2 == -1) {
                    this.verticalDimensionFixed = false;
                    if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.matchConstraintDefaultHeight == 1) {
                        ((ViewGroup.MarginLayoutParams) this).height = -2;
                        this.constrainedHeight = true;
                    }
                }
                if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                    this.isGuideline = true;
                    this.horizontalDimensionFixed = true;
                    this.verticalDimensionFixed = true;
                    if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                        this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
                    }
                    ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
                }
            }
        }
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constraintLayout;
            this.layout = constraintLayout2;
        }

        private boolean isSimilarSpec(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, this, i, i2, i3)) == null) {
                if (i == i2) {
                    return true;
                }
                int mode = View.MeasureSpec.getMode(i);
                View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                if (mode2 == 1073741824) {
                    if ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeIII.booleanValue;
        }

        public void captureLayoutInfos(int i, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                this.paddingTop = i3;
                this.paddingBottom = i4;
                this.paddingWidth = i5;
                this.paddingHeight = i6;
                this.layoutWidthSpec = i;
                this.layoutHeightSpec = i2;
            }
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.layout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.layout.getChildAt(i);
                    if (childAt instanceof Placeholder) {
                        ((Placeholder) childAt).updatePostMeasure(this.layout);
                    }
                }
                int size = this.layout.mConstraintHelpers.size();
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        ((ConstraintHelper) this.layout.mConstraintHelpers.get(i2)).updatePostMeasure(this.layout);
                    }
                }
            }
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            int baseline;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, constraintWidget, measure) != null) || constraintWidget == null) {
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
                int i6 = measure.horizontalDimension;
                int i7 = measure.verticalDimension;
                int i8 = this.paddingTop + this.paddingBottom;
                int i9 = this.paddingWidth;
                View view2 = (View) constraintWidget.getCompanionWidget();
                int i10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                makeMeasureSpec = 0;
                            } else {
                                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i9, -2);
                                if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                int i11 = measure.measureStrategy;
                                if (i11 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i11 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                                    if (view2.getMeasuredHeight() == constraintWidget.getHeight()) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z13 && ((!z13 || !z14) && !(view2 instanceof Placeholder) && !constraintWidget.isResolvedHorizontally())) {
                                        z15 = false;
                                    } else {
                                        z15 = true;
                                    }
                                    if (z15) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i9 + constraintWidget.getHorizontalMargin(), -1);
                        }
                    } else {
                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i9, -2);
                    }
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                }
                int i12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour2.ordinal()];
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 != 4) {
                                makeMeasureSpec2 = 0;
                            } else {
                                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i8, -2);
                                if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                int i13 = measure.measureStrategy;
                                if (i13 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i13 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                                    if (view2.getMeasuredWidth() == constraintWidget.getWidth()) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z10 && ((!z10 || !z11) && !(view2 instanceof Placeholder) && !constraintWidget.isResolvedVertically())) {
                                        z12 = false;
                                    } else {
                                        z12 = true;
                                    }
                                    if (z12) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i8 + constraintWidget.getVerticalMargin(), -1);
                        }
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i8, -2);
                    }
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                }
                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
                if (constraintWidgetContainer != null && Optimizer.enabled(this.this$0.mOptimizationLevel, 256) && view2.getMeasuredWidth() == constraintWidget.getWidth() && view2.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view2.getMeasuredHeight() == constraintWidget.getHeight() && view2.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view2.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
                    if (isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), makeMeasureSpec, constraintWidget.getWidth()) && isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), makeMeasureSpec2, constraintWidget.getHeight())) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        measure.measuredWidth = constraintWidget.getWidth();
                        measure.measuredHeight = constraintWidget.getHeight();
                        measure.measuredBaseline = constraintWidget.getBaselineDistance();
                        return;
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    z = true;
                } else {
                    z = false;
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z && constraintWidget.mDimensionRatio > 0.0f) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z2 && constraintWidget.mDimensionRatio > 0.0f) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (view2 == null) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                int i14 = measure.measureStrategy;
                if (i14 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i14 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z && constraintWidget.mMatchConstraintDefaultWidth == 0 && z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    i5 = -1;
                    baseline = 0;
                    i = 0;
                    i3 = 0;
                } else {
                    if ((view2 instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                        ((VirtualLayout) view2).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                    } else {
                        view2.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view2.getMeasuredWidth();
                    int measuredHeight = view2.getMeasuredHeight();
                    baseline = view2.getBaseline();
                    int i15 = constraintWidget.mMatchConstraintMinWidth;
                    if (i15 > 0) {
                        i = Math.max(i15, measuredWidth);
                    } else {
                        i = measuredWidth;
                    }
                    int i16 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i16 > 0) {
                        i = Math.min(i16, i);
                    }
                    int i17 = constraintWidget.mMatchConstraintMinHeight;
                    if (i17 > 0) {
                        i3 = Math.max(i17, measuredHeight);
                        i2 = makeMeasureSpec2;
                    } else {
                        i2 = makeMeasureSpec2;
                        i3 = measuredHeight;
                    }
                    int i18 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i18 > 0) {
                        i3 = Math.min(i18, i3);
                    }
                    if (!Optimizer.enabled(this.this$0.mOptimizationLevel, 1)) {
                        if (z5 && z3) {
                            i = (int) ((i3 * constraintWidget.mDimensionRatio) + 0.5f);
                        } else if (z6 && z4) {
                            i3 = (int) ((i / constraintWidget.mDimensionRatio) + 0.5f);
                        }
                    }
                    if (measuredWidth != i || measuredHeight != i3) {
                        if (measuredWidth != i) {
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                        }
                        if (measuredHeight != i3) {
                            i4 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                        } else {
                            i4 = i2;
                        }
                        view2.measure(makeMeasureSpec, i4);
                        constraintWidget.setLastMeasureSpec(makeMeasureSpec, i4);
                        i = view2.getMeasuredWidth();
                        i3 = view2.getMeasuredHeight();
                        baseline = view2.getBaseline();
                    }
                    i5 = -1;
                }
                if (baseline != i5) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (i == measure.horizontalDimension && i3 == measure.verticalDimension) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                measure.measuredNeedsSolverPass = z8;
                if (layoutParams.needsBaseline) {
                    z7 = true;
                }
                if (z7 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
                    measure.measuredNeedsSolverPass = true;
                }
                measure.measuredWidth = i;
                measure.measuredHeight = i3;
                measure.measuredHasBaseline = z7;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onViewAdded(view2);
            }
            ConstraintWidget viewWidget = getViewWidget(view2);
            if ((view2 instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                androidx.constraintlayout.solver.widgets.Guideline guideline = new androidx.constraintlayout.solver.widgets.Guideline();
                layoutParams.widget = guideline;
                layoutParams.isGuideline = true;
                guideline.setOrientation(layoutParams.orientation);
            }
            if (view2 instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view2;
                constraintHelper.validateParams();
                ((LayoutParams) view2.getLayoutParams()).isHelper = true;
                if (!this.mConstraintHelpers.contains(constraintHelper)) {
                    this.mConstraintHelpers.add(constraintHelper);
                }
            }
            this.mChildrenByIds.put(view2.getId(), view2);
            this.mDirtyHierarchy = true;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        init(attributeSet, i, 0);
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, this, attributeSet, i, i2) == null) {
            this.mLayoutWidget.setCompanionWidget(this);
            this.mLayoutWidget.setMeasurer(this.mMeasurer);
            this.mChildrenByIds.put(getId(), this);
            this.mConstraintSet = null;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i, i2);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == 9) {
                        this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                    } else if (index == 10) {
                        this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                    } else if (index == 7) {
                        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                    } else if (index == 8) {
                        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                    } else if (index == 70) {
                        this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                    } else if (index == 89) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                        if (resourceId != 0) {
                            try {
                                parseLayoutDescription(resourceId);
                            } catch (Resources.NotFoundException unused) {
                                this.mConstraintLayoutSpec = null;
                            }
                        }
                    } else if (index == 18) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        init(attributeSet, i, i2);
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048605, this, constraintWidgetContainer, i, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            int max2 = Math.max(0, getPaddingTop());
            int max3 = Math.max(0, getPaddingBottom());
            int i4 = max2 + max3;
            int paddingWidth = getPaddingWidth();
            this.mMeasurer.captureLayoutInfos(i2, i3, max2, max3, paddingWidth, i4);
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
            int i5 = size - paddingWidth;
            int i6 = size2 - i4;
            setSelfDimensionBehaviour(constraintWidgetContainer, mode, i5, mode2, i6);
            constraintWidgetContainer.measure(i, mode, i5, mode2, i6, this.mLastMeasureWidth, this.mLastMeasureHeight, max, max2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    public void fillMetrics(Metrics metrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, metrics) == null) {
            this.mMetrics = metrics;
            this.mLayoutWidget.fillMetrics(metrics);
        }
    }

    public View getViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            return this.mChildrenByIds.get(i);
        }
        return (View) invokeI.objValue;
    }

    public final ConstraintWidget getViewWidget(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            if (view2 == this) {
                return this.mLayoutWidget;
            }
            if (view2 == null) {
                return null;
            }
            return ((LayoutParams) view2.getLayoutParams()).widget;
        }
        return (ConstraintWidget) invokeL.objValue;
    }

    public void loadLayoutDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i != 0) {
                try {
                    this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
                    return;
                } catch (Resources.NotFoundException unused) {
                    this.mConstraintLayoutSpec = null;
                    return;
                }
            }
            this.mConstraintLayoutSpec = null;
        }
    }

    public void parseLayoutDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            super.removeView(view2);
            if (Build.VERSION.SDK_INT < 14) {
                onViewRemoved(view2);
            }
        }
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, constraintSet) == null) {
            this.mConstraintSet = constraintSet;
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.mChildrenByIds.remove(getId());
            super.setId(i);
            this.mChildrenByIds.put(getId(), this);
        }
    }

    public void setMaxHeight(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048609, this, i) != null) || i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048610, this, i) != null) || i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048611, this, i) != null) || i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048612, this, i) != null) || i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
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

    public void setOptimizationLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.mOptimizationLevel = i;
            this.mLayoutWidget.setOptimizationLevel(i);
        }
    }

    private int getPaddingWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int i = 0;
            int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
            if (Build.VERSION.SDK_INT >= 17) {
                i = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
            }
            if (i > 0) {
                return i;
            }
            return max;
        }
        return invokeV.intValue;
    }

    public boolean isRtl() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Build.VERSION.SDK_INT < 17) {
                return false;
            }
            if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || 1 != getLayoutDirection()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private final ConstraintWidget getTargetWidget(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            if (i == 0) {
                return this.mLayoutWidget;
            }
            View view2 = this.mChildrenByIds.get(i);
            if (view2 == null && (view2 = findViewById(i)) != null && view2 != this && view2.getParent() == this) {
                onViewAdded(view2);
            }
            if (view2 == this) {
                return this.mLayoutWidget;
            }
            if (view2 == null) {
                return null;
            }
            return ((LayoutParams) view2.getLayoutParams()).widget;
        }
        return (ConstraintWidget) invokeI.objValue;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view2) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                super.onViewRemoved(view2);
            }
            this.mChildrenByIds.remove(view2.getId());
            this.mLayoutWidget.remove(getViewWidget(view2));
            this.mConstraintHelpers.remove(view2);
            this.mDirtyHierarchy = true;
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

    private boolean updateHierarchy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                } else if (getChildAt(i).isLayoutRequested()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                setChildrenConstraints();
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void forceLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            markHierarchyDirty();
            super.forceLayout();
        }
    }

    public int getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mMaxHeight;
        }
        return invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mMaxWidth;
        }
        return invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mMinHeight;
        }
        return invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mMinWidth;
        }
        return invokeV.intValue;
    }

    public int getOptimizationLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mLayoutWidget.getOptimizationLevel();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            markHierarchyDirty();
            super.requestLayout();
        }
    }

    private void setChildrenConstraints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            boolean isInEditMode = isInEditMode();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
                if (viewWidget != null) {
                    viewWidget.reset();
                }
            }
            if (isInEditMode) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
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
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
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
                for (int i4 = 0; i4 < size; i4++) {
                    this.mConstraintHelpers.get(i4).updatePreLayout(this);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt3 = getChildAt(i5);
                if (childAt3 instanceof Placeholder) {
                    ((Placeholder) childAt3).updatePreLayout(this);
                }
            }
            this.mTempMapIdToWidget.clear();
            this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
            this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt4 = getChildAt(i6);
                this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt5 = getChildAt(i7);
                ConstraintWidget viewWidget2 = getViewWidget(childAt5);
                if (viewWidget2 != null) {
                    LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                    this.mLayoutWidget.add(viewWidget2);
                    applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            super.addView(view2, i, layoutParams);
            if (Build.VERSION.SDK_INT < 14) {
                onViewAdded(view2);
            }
        }
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048616, this, i, i2, i3) == null) && (constraintLayoutStates = this.mConstraintLayoutSpec) != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
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
    public void applyConstraintsFromLayoutParams(boolean z, View view2, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        float f2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), view2, constraintWidget, layoutParams, sparseArray}) == null) {
            layoutParams.validate();
            layoutParams.helped = false;
            constraintWidget.setVisibility(view2.getVisibility());
            if (layoutParams.isInPlaceholder) {
                constraintWidget.setInPlaceholder(true);
                constraintWidget.setVisibility(8);
            }
            constraintWidget.setCompanionWidget(view2);
            if (view2 instanceof ConstraintHelper) {
                ((ConstraintHelper) view2).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
            }
            if (layoutParams.isGuideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                int i5 = layoutParams.resolvedGuideBegin;
                int i6 = layoutParams.resolvedGuideEnd;
                float f3 = layoutParams.resolvedGuidePercent;
                if (Build.VERSION.SDK_INT < 17) {
                    i5 = layoutParams.guideBegin;
                    i6 = layoutParams.guideEnd;
                    f3 = layoutParams.guidePercent;
                }
                if (f3 != -1.0f) {
                    guideline.setGuidePercent(f3);
                    return;
                } else if (i5 != -1) {
                    guideline.setGuideBegin(i5);
                    return;
                } else if (i6 != -1) {
                    guideline.setGuideEnd(i6);
                    return;
                } else {
                    return;
                }
            }
            int i7 = layoutParams.resolvedLeftToLeft;
            int i8 = layoutParams.resolvedLeftToRight;
            int i9 = layoutParams.resolvedRightToLeft;
            int i10 = layoutParams.resolvedRightToRight;
            int i11 = layoutParams.resolveGoneLeftMargin;
            int i12 = layoutParams.resolveGoneRightMargin;
            float f4 = layoutParams.resolvedHorizontalBias;
            if (Build.VERSION.SDK_INT < 17) {
                i7 = layoutParams.leftToLeft;
                int i13 = layoutParams.leftToRight;
                int i14 = layoutParams.rightToLeft;
                i10 = layoutParams.rightToRight;
                int i15 = layoutParams.goneLeftMargin;
                int i16 = layoutParams.goneRightMargin;
                f4 = layoutParams.horizontalBias;
                if (i7 == -1 && i13 == -1) {
                    int i17 = layoutParams.startToStart;
                    if (i17 != -1) {
                        i7 = i17;
                    } else {
                        int i18 = layoutParams.startToEnd;
                        if (i18 != -1) {
                            i13 = i18;
                        }
                    }
                }
                if (i14 == -1 && i10 == -1) {
                    i2 = layoutParams.endToStart;
                    if (i2 == -1) {
                        int i19 = layoutParams.endToEnd;
                        if (i19 != -1) {
                            i = i16;
                            f = f4;
                            i11 = i15;
                            i3 = i19;
                            i8 = i13;
                            i2 = i14;
                            i4 = layoutParams.circleConstraint;
                            if (i4 == -1) {
                                ConstraintWidget constraintWidget6 = sparseArray.get(i4);
                                if (constraintWidget6 != null) {
                                    constraintWidget.connectCircularConstraint(constraintWidget6, layoutParams.circleAngle, layoutParams.circleRadius);
                                }
                            } else {
                                if (i7 != -1) {
                                    ConstraintWidget constraintWidget7 = sparseArray.get(i7);
                                    if (constraintWidget7 != null) {
                                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                        f2 = f;
                                        constraintWidget.immediateConnect(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11);
                                    } else {
                                        f2 = f;
                                    }
                                } else {
                                    f2 = f;
                                    if (i8 != -1 && (constraintWidget2 = sparseArray.get(i8)) != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11);
                                    }
                                }
                                if (i2 != -1) {
                                    ConstraintWidget constraintWidget8 = sparseArray.get(i2);
                                    if (constraintWidget8 != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i);
                                    }
                                } else if (i3 != -1 && (constraintWidget3 = sparseArray.get(i3)) != null) {
                                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                                    constraintWidget.immediateConnect(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i);
                                }
                                int i20 = layoutParams.topToTop;
                                if (i20 != -1) {
                                    ConstraintWidget constraintWidget9 = sparseArray.get(i20);
                                    if (constraintWidget9 != null) {
                                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                                        constraintWidget.immediateConnect(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                    }
                                } else {
                                    int i21 = layoutParams.topToBottom;
                                    if (i21 != -1 && (constraintWidget4 = sparseArray.get(i21)) != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                                    }
                                }
                                int i22 = layoutParams.bottomToTop;
                                if (i22 != -1) {
                                    ConstraintWidget constraintWidget10 = sparseArray.get(i22);
                                    if (constraintWidget10 != null) {
                                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                    }
                                } else {
                                    int i23 = layoutParams.bottomToBottom;
                                    if (i23 != -1 && (constraintWidget5 = sparseArray.get(i23)) != null) {
                                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                                        constraintWidget.immediateConnect(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                                    }
                                }
                                int i24 = layoutParams.baselineToBaseline;
                                if (i24 != -1) {
                                    View view3 = this.mChildrenByIds.get(i24);
                                    ConstraintWidget constraintWidget11 = sparseArray.get(layoutParams.baselineToBaseline);
                                    if (constraintWidget11 != null && view3 != null && (view3.getLayoutParams() instanceof LayoutParams)) {
                                        LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                                        layoutParams.needsBaseline = true;
                                        layoutParams2.needsBaseline = true;
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(constraintWidget11.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                                        constraintWidget.setHasBaseline(true);
                                        layoutParams2.widget.setHasBaseline(true);
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                        constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                                    }
                                }
                                float f5 = f2;
                                if (f5 >= 0.0f) {
                                    constraintWidget.setHorizontalBiasPercent(f5);
                                }
                                float f6 = layoutParams.verticalBias;
                                if (f6 >= 0.0f) {
                                    constraintWidget.setVerticalBiasPercent(f6);
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
                    i = i16;
                    i11 = i15;
                    i8 = i13;
                }
                i2 = i14;
                i = i16;
                i11 = i15;
                i8 = i13;
            } else {
                i = i12;
                i2 = i9;
            }
            float f7 = f4;
            i3 = i10;
            f = f7;
            i4 = layoutParams.circleConstraint;
            if (i4 == -1) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    this.mConstraintHelpers.get(i).updatePreDraw(this);
                }
            }
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
                            paint.setColor(-65536);
                            float f = i3;
                            float f2 = i4;
                            float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                            canvas.drawLine(f, f2, f3, f2, paint);
                            float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                            canvas.drawLine(f3, f2, f3, parseInt4, paint);
                            canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                            canvas.drawLine(f, parseInt4, f, f2, paint);
                            paint.setColor(DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
                            canvas.drawLine(f, f2, f3, parseInt4, paint);
                            canvas.drawLine(f, parseInt4, f3, f2, paint);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new LayoutParams(-2, -2);
        }
        return (LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) invokeL.objValue;
    }

    public Object getDesignInformation(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, obj)) == null) {
            if (i == 0 && (obj instanceof String)) {
                String str = (String) obj;
                HashMap<String, Integer> hashMap = this.mDesignIds;
                if (hashMap != null && hashMap.containsKey(str)) {
                    return this.mDesignIds.get(str);
                }
                return null;
            }
            return null;
        }
        return invokeIL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            boolean isInEditMode = isInEditMode();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
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
                for (int i6 = 0; i6 < size; i6++) {
                    this.mConstraintHelpers.get(i6).updatePostLayout(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            if (!this.mDirtyHierarchy) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    } else if (getChildAt(i3).isLayoutRequested()) {
                        this.mDirtyHierarchy = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (!this.mDirtyHierarchy) {
                if (this.mOnMeasureWidthMeasureSpec == i && this.mOnMeasureHeightMeasureSpec == i2) {
                    resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                    return;
                } else if (this.mOnMeasureWidthMeasureSpec == i && View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) >= this.mLayoutWidget.getHeight()) {
                    this.mOnMeasureWidthMeasureSpec = i;
                    this.mOnMeasureHeightMeasureSpec = i2;
                    resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                    return;
                }
            }
            this.mOnMeasureWidthMeasureSpec = i;
            this.mOnMeasureHeightMeasureSpec = i2;
            this.mLayoutWidget.setRtl(isRtl());
            if (this.mDirtyHierarchy) {
                this.mDirtyHierarchy = false;
                if (updateHierarchy()) {
                    this.mLayoutWidget.updateHierarchy();
                }
            }
            resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
            resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        }
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Measurer measurer = this.mMeasurer;
            int i5 = measurer.paddingHeight;
            int i6 = i3 + measurer.paddingWidth;
            int i7 = i4 + i5;
            if (Build.VERSION.SDK_INT >= 11) {
                int min = Math.min(this.mMaxWidth, ViewGroup.resolveSizeAndState(i6, i, 0) & 16777215);
                int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(i7, i2, 0) & 16777215);
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
            setMeasuredDimension(i6, i7);
            this.mLastMeasureWidth = i6;
            this.mLastMeasureHeight = i7;
        }
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048607, this, i, obj, obj2) == null) && i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
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

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{constraintWidgetContainer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Measurer measurer = this.mMeasurer;
            int i5 = measurer.paddingHeight;
            int i6 = measurer.paddingWidth;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
            int childCount = getChildCount();
            if (i != Integer.MIN_VALUE) {
                if (i != 0) {
                    if (i != 1073741824) {
                        dimensionBehaviour = dimensionBehaviour2;
                        i2 = 0;
                    } else {
                        i2 = Math.min(this.mMaxWidth - i6, i2);
                        dimensionBehaviour = dimensionBehaviour2;
                    }
                } else {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (childCount == 0) {
                        i2 = Math.max(0, this.mMinWidth);
                    }
                    i2 = 0;
                }
            } else {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i2 = Math.max(0, this.mMinWidth);
                }
            }
            if (i3 != Integer.MIN_VALUE) {
                if (i3 != 0) {
                    if (i3 == 1073741824) {
                        i4 = Math.min(this.mMaxHeight - i5, i4);
                    }
                    i4 = 0;
                } else {
                    dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (childCount == 0) {
                        i4 = Math.max(0, this.mMinHeight);
                    }
                    i4 = 0;
                }
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i4 = Math.max(0, this.mMinHeight);
                }
            }
            if (i2 != constraintWidgetContainer.getWidth() || i4 != constraintWidgetContainer.getHeight()) {
                constraintWidgetContainer.invalidateMeasures();
            }
            constraintWidgetContainer.setX(0);
            constraintWidgetContainer.setY(0);
            constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i6);
            constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i5);
            constraintWidgetContainer.setMinWidth(0);
            constraintWidgetContainer.setMinHeight(0);
            constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
            constraintWidgetContainer.setWidth(i2);
            constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
            constraintWidgetContainer.setHeight(i4);
            constraintWidgetContainer.setMinWidth(this.mMinWidth - i6);
            constraintWidgetContainer.setMinHeight(this.mMinHeight - i5);
        }
    }
}
