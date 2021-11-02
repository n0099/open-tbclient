package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintWidget[] mAlignedBiggestElementsInCols;
    public ConstraintWidget[] mAlignedBiggestElementsInRows;
    public int[] mAlignedDimensions;
    public ArrayList<WidgetsList> mChainList;
    public ConstraintWidget[] mDisplayedWidgets;
    public int mDisplayedWidgetsCount;
    public float mFirstHorizontalBias;
    public int mFirstHorizontalStyle;
    public float mFirstVerticalBias;
    public int mFirstVerticalStyle;
    public int mHorizontalAlign;
    public float mHorizontalBias;
    public int mHorizontalGap;
    public int mHorizontalStyle;
    public float mLastHorizontalBias;
    public int mLastHorizontalStyle;
    public float mLastVerticalBias;
    public int mLastVerticalStyle;
    public int mMaxElementsWrap;
    public int mOrientation;
    public int mVerticalAlign;
    public float mVerticalBias;
    public int mVerticalGap;
    public int mVerticalStyle;
    public int mWrapMode;

    /* loaded from: classes.dex */
    public class WidgetsList {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintWidget biggest;
        public int biggestDimension;
        public ConstraintAnchor mBottom;
        public int mCount;
        public int mHeight;
        public ConstraintAnchor mLeft;
        public int mMax;
        public int mNbMatchConstraintsWidgets;
        public int mOrientation;
        public int mPaddingBottom;
        public int mPaddingLeft;
        public int mPaddingRight;
        public int mPaddingTop;
        public ConstraintAnchor mRight;
        public int mStartIndex;
        public ConstraintAnchor mTop;
        public int mWidth;
        public final /* synthetic */ Flow this$0;

        public WidgetsList(Flow flow, int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flow, Integer.valueOf(i2), constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flow;
            this.mOrientation = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = flow.getPaddingLeft();
            this.mPaddingTop = flow.getPaddingTop();
            this.mPaddingRight = flow.getPaddingRight();
            this.mPaddingBottom = flow.getPaddingBottom();
            this.mMax = i3;
        }

        private void recomputeDimensions() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.mWidth = 0;
                this.mHeight = 0;
                this.biggest = null;
                this.biggestDimension = 0;
                int i2 = this.mCount;
                for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < this.this$0.mDisplayedWidgetsCount; i3++) {
                    ConstraintWidget constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + i3];
                    if (this.mOrientation != 0) {
                        int widgetWidth = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                        int widgetHeight = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                        int i4 = this.this$0.mVerticalGap;
                        if (constraintWidget.getVisibility() == 8) {
                            i4 = 0;
                        }
                        this.mHeight += widgetHeight + i4;
                        if (this.biggest == null || this.biggestDimension < widgetWidth) {
                            this.biggest = constraintWidget;
                            this.biggestDimension = widgetWidth;
                            this.mWidth = widgetWidth;
                        }
                    } else {
                        int width = constraintWidget.getWidth();
                        int i5 = this.this$0.mHorizontalGap;
                        if (constraintWidget.getVisibility() == 8) {
                            i5 = 0;
                        }
                        this.mWidth += width + i5;
                        int widgetHeight2 = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                        if (this.biggest == null || this.biggestDimension < widgetHeight2) {
                            this.biggest = constraintWidget;
                            this.biggestDimension = widgetHeight2;
                            this.mHeight = widgetHeight2;
                        }
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) {
                if (this.mOrientation == 0) {
                    int widgetWidth = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        this.mNbMatchConstraintsWidgets++;
                        widgetWidth = 0;
                    }
                    this.mWidth += widgetWidth + (constraintWidget.getVisibility() != 8 ? this.this$0.mHorizontalGap : 0);
                    int widgetHeight = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth2 = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                    if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        this.mNbMatchConstraintsWidgets++;
                        widgetHeight2 = 0;
                    }
                    this.mHeight += widgetHeight2 + (constraintWidget.getVisibility() != 8 ? this.this$0.mVerticalGap : 0);
                    if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth2;
                        this.mWidth = widgetWidth2;
                    }
                }
                this.mCount++;
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.biggestDimension = 0;
                this.biggest = null;
                this.mWidth = 0;
                this.mHeight = 0;
                this.mStartIndex = 0;
                this.mCount = 0;
                this.mNbMatchConstraintsWidgets = 0;
            }
        }

        public void createConstraints(boolean z, int i2, boolean z2) {
            ConstraintWidget constraintWidget;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
                int i3 = this.mCount;
                for (int i4 = 0; i4 < i3 && this.mStartIndex + i4 < this.this$0.mDisplayedWidgetsCount; i4++) {
                    ConstraintWidget constraintWidget2 = this.this$0.mDisplayedWidgets[this.mStartIndex + i4];
                    if (constraintWidget2 != null) {
                        constraintWidget2.resetAnchors();
                    }
                }
                if (i3 == 0 || this.biggest == null) {
                    return;
                }
                boolean z3 = z2 && i2 == 0;
                int i5 = -1;
                int i6 = -1;
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = z ? (i3 - 1) - i7 : i7;
                    if (this.mStartIndex + i8 >= this.this$0.mDisplayedWidgetsCount) {
                        break;
                    }
                    if (this.this$0.mDisplayedWidgets[this.mStartIndex + i8].getVisibility() == 0) {
                        if (i5 == -1) {
                            i5 = i7;
                        }
                        i6 = i7;
                    }
                }
                ConstraintWidget constraintWidget3 = null;
                if (this.mOrientation == 0) {
                    ConstraintWidget constraintWidget4 = this.biggest;
                    constraintWidget4.setVerticalChainStyle(this.this$0.mVerticalStyle);
                    int i9 = this.mPaddingTop;
                    if (i2 > 0) {
                        i9 += this.this$0.mVerticalGap;
                    }
                    constraintWidget4.mTop.connect(this.mTop, i9);
                    if (z2) {
                        constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                    }
                    if (i2 > 0) {
                        this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                    }
                    if (this.this$0.mVerticalAlign == 3 && !constraintWidget4.hasBaseline()) {
                        for (int i10 = 0; i10 < i3; i10++) {
                            int i11 = z ? (i3 - 1) - i10 : i10;
                            if (this.mStartIndex + i11 >= this.this$0.mDisplayedWidgetsCount) {
                                break;
                            }
                            constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + i11];
                            if (constraintWidget.hasBaseline()) {
                                break;
                            }
                        }
                    }
                    constraintWidget = constraintWidget4;
                    int i12 = 0;
                    while (i12 < i3) {
                        int i13 = z ? (i3 - 1) - i12 : i12;
                        if (this.mStartIndex + i13 >= this.this$0.mDisplayedWidgetsCount) {
                            return;
                        }
                        ConstraintWidget constraintWidget5 = this.this$0.mDisplayedWidgets[this.mStartIndex + i13];
                        if (i12 == 0) {
                            constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                        }
                        if (i13 == 0) {
                            int i14 = this.this$0.mHorizontalStyle;
                            float f2 = this.this$0.mHorizontalBias;
                            if (this.mStartIndex != 0 || this.this$0.mFirstHorizontalStyle == -1) {
                                if (z2 && this.this$0.mLastHorizontalStyle != -1) {
                                    i14 = this.this$0.mLastHorizontalStyle;
                                    f2 = this.this$0.mLastHorizontalBias;
                                }
                            } else {
                                i14 = this.this$0.mFirstHorizontalStyle;
                                f2 = this.this$0.mFirstHorizontalBias;
                            }
                            constraintWidget5.setHorizontalChainStyle(i14);
                            constraintWidget5.setHorizontalBiasPercent(f2);
                        }
                        if (i12 == i3 - 1) {
                            constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                        }
                        if (constraintWidget3 != null) {
                            constraintWidget5.mLeft.connect(constraintWidget3.mRight, this.this$0.mHorizontalGap);
                            if (i12 == i5) {
                                constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                            }
                            constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                            if (i12 == i6 + 1) {
                                constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                            }
                        }
                        if (constraintWidget5 != constraintWidget4) {
                            if (this.this$0.mVerticalAlign != 3 || !constraintWidget.hasBaseline() || constraintWidget5 == constraintWidget || !constraintWidget5.hasBaseline()) {
                                int i15 = this.this$0.mVerticalAlign;
                                if (i15 == 0) {
                                    constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                } else if (i15 == 1) {
                                    constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                } else if (z3) {
                                    constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                    constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                } else {
                                    constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                    constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                }
                            } else {
                                constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                            }
                        }
                        i12++;
                        constraintWidget3 = constraintWidget5;
                    }
                    return;
                }
                ConstraintWidget constraintWidget6 = this.biggest;
                constraintWidget6.setHorizontalChainStyle(this.this$0.mHorizontalStyle);
                int i16 = this.mPaddingLeft;
                if (i2 > 0) {
                    i16 += this.this$0.mHorizontalGap;
                }
                if (z) {
                    constraintWidget6.mRight.connect(this.mRight, i16);
                    if (z2) {
                        constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                    }
                } else {
                    constraintWidget6.mLeft.connect(this.mLeft, i16);
                    if (z2) {
                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                    }
                }
                int i17 = 0;
                while (i17 < i3 && this.mStartIndex + i17 < this.this$0.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget7 = this.this$0.mDisplayedWidgets[this.mStartIndex + i17];
                    if (i17 == 0) {
                        constraintWidget7.connect(constraintWidget7.mTop, this.mTop, this.mPaddingTop);
                        int i18 = this.this$0.mVerticalStyle;
                        float f3 = this.this$0.mVerticalBias;
                        if (this.mStartIndex != 0 || this.this$0.mFirstVerticalStyle == -1) {
                            if (z2 && this.this$0.mLastVerticalStyle != -1) {
                                i18 = this.this$0.mLastVerticalStyle;
                                f3 = this.this$0.mLastVerticalBias;
                            }
                        } else {
                            i18 = this.this$0.mFirstVerticalStyle;
                            f3 = this.this$0.mFirstVerticalBias;
                        }
                        constraintWidget7.setVerticalChainStyle(i18);
                        constraintWidget7.setVerticalBiasPercent(f3);
                    }
                    if (i17 == i3 - 1) {
                        constraintWidget7.connect(constraintWidget7.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget7.mTop.connect(constraintWidget3.mBottom, this.this$0.mVerticalGap);
                        if (i17 == i5) {
                            constraintWidget7.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                        if (i17 == i6 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget7 != constraintWidget6) {
                        if (z) {
                            int i19 = this.this$0.mHorizontalAlign;
                            if (i19 == 0) {
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            } else if (i19 == 1) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            } else if (i19 == 2) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            }
                        } else {
                            int i20 = this.this$0.mHorizontalAlign;
                            if (i20 == 0) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            } else if (i20 == 1) {
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            } else if (i20 == 2) {
                                if (z3) {
                                    constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                }
                            }
                            i17++;
                            constraintWidget3 = constraintWidget7;
                        }
                    }
                    i17++;
                    constraintWidget3 = constraintWidget7;
                }
            }
        }

        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mOrientation == 1) {
                    return this.mHeight - this.this$0.mVerticalGap;
                }
                return this.mHeight;
            }
            return invokeV.intValue;
        }

        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.mOrientation == 0) {
                    return this.mWidth - this.this$0.mHorizontalGap;
                }
                return this.mWidth;
            }
            return invokeV.intValue;
        }

        public void measureMatchConstraints(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (i3 = this.mNbMatchConstraintsWidgets) == 0) {
                return;
            }
            int i4 = this.mCount;
            int i5 = i2 / i3;
            for (int i6 = 0; i6 < i4 && this.mStartIndex + i6 < this.this$0.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        this.this$0.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    this.this$0.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.mStartIndex = i2;
            }
        }

        public void setup(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
                this.mOrientation = i2;
                this.mLeft = constraintAnchor;
                this.mTop = constraintAnchor2;
                this.mRight = constraintAnchor3;
                this.mBottom = constraintAnchor4;
                this.mPaddingLeft = i3;
                this.mPaddingTop = i4;
                this.mPaddingRight = i5;
                this.mPaddingBottom = i6;
                this.mMax = i7;
            }
        }
    }

    public Flow() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHorizontalStyle = -1;
        this.mVerticalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mFirstVerticalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = 2;
        this.mVerticalAlign = 2;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mChainList = new ArrayList<>();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65557, this, z) == null) || this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mDisplayedWidgetsCount; i2++) {
            this.mDisplayedWidgets[i2].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i3 = iArr[0];
        int i4 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i5 = 0; i5 < i3; i5++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i3 - i5) - 1 : i5];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i5 == i3 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i5 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i6];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i6 == i4 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i6 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.mOrientation == 1) {
                    i9 = (i7 * i4) + i8;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i9 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i9]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i7];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i8];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, this, constraintWidget, i2)) == null) {
            if (constraintWidget == null) {
                return 0;
            }
            if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i3 = constraintWidget.mMatchConstraintDefaultHeight;
                if (i3 == 0) {
                    return 0;
                }
                if (i3 == 2) {
                    int i4 = (int) (constraintWidget.mMatchConstraintPercentHeight * i2);
                    if (i4 != constraintWidget.getHeight()) {
                        constraintWidget.setMeasureRequested(true);
                        measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                    }
                    return i4;
                } else if (i3 == 1) {
                    return constraintWidget.getHeight();
                } else {
                    if (i3 == 3) {
                        return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
                    }
                }
            }
            return constraintWidget.getHeight();
        }
        return invokeLI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, this, constraintWidget, i2)) == null) {
            if (constraintWidget == null) {
                return 0;
            }
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i3 = constraintWidget.mMatchConstraintDefaultWidth;
                if (i3 == 0) {
                    return 0;
                }
                if (i3 == 2) {
                    int i4 = (int) (constraintWidget.mMatchConstraintPercentWidth * i2);
                    if (i4 != constraintWidget.getWidth()) {
                        constraintWidget.setMeasureRequested(true);
                        measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                    return i4;
                } else if (i3 == 1) {
                    return constraintWidget.getWidth();
                } else {
                    if (i3 == 3) {
                        return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
                    }
                }
            }
            return constraintWidget.getWidth();
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x006c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x011f -> B:44:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0121 -> B:44:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0127 -> B:44:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0129 -> B:44:0x0067). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureAligned(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        boolean z;
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{constraintWidgetArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr}) == null) {
            if (i3 == 0) {
                int i7 = this.mMaxElementsWrap;
                if (i7 <= 0) {
                    i7 = 0;
                    int i8 = 0;
                    for (int i9 = 0; i9 < i2; i9++) {
                        if (i9 > 0) {
                            i8 += this.mHorizontalGap;
                        }
                        ConstraintWidget constraintWidget2 = constraintWidgetArr[i9];
                        if (constraintWidget2 != null) {
                            i8 += getWidgetWidth(constraintWidget2, i4);
                            if (i8 > i4) {
                                break;
                            }
                            i7++;
                        }
                    }
                }
                i6 = i7;
                i5 = 0;
            } else {
                i5 = this.mMaxElementsWrap;
                if (i5 <= 0) {
                    i5 = 0;
                    int i10 = 0;
                    for (int i11 = 0; i11 < i2; i11++) {
                        if (i11 > 0) {
                            i10 += this.mVerticalGap;
                        }
                        ConstraintWidget constraintWidget3 = constraintWidgetArr[i11];
                        if (constraintWidget3 != null) {
                            i10 += getWidgetHeight(constraintWidget3, i4);
                            if (i10 > i4) {
                                break;
                            }
                            i5++;
                        }
                    }
                }
                i6 = 0;
            }
            if (this.mAlignedDimensions == null) {
                this.mAlignedDimensions = new int[2];
            }
            if ((i5 != 0 || i3 != 1) && (i6 != 0 || i3 != 0)) {
                z = false;
                while (!z) {
                    if (i3 == 0) {
                        i5 = (int) Math.ceil(i2 / i6);
                    } else {
                        i6 = (int) Math.ceil(i2 / i5);
                    }
                    ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
                    if (constraintWidgetArr2 != null && constraintWidgetArr2.length >= i6) {
                        Arrays.fill(constraintWidgetArr2, (Object) null);
                    } else {
                        this.mAlignedBiggestElementsInCols = new ConstraintWidget[i6];
                    }
                    ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
                    if (constraintWidgetArr3 != null && constraintWidgetArr3.length >= i5) {
                        Arrays.fill(constraintWidgetArr3, (Object) null);
                    } else {
                        this.mAlignedBiggestElementsInRows = new ConstraintWidget[i5];
                    }
                    for (int i12 = 0; i12 < i6; i12++) {
                        for (int i13 = 0; i13 < i5; i13++) {
                            int i14 = (i13 * i6) + i12;
                            if (i3 == 1) {
                                i14 = (i12 * i5) + i13;
                            }
                            if (i14 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i14]) != null) {
                                int widgetWidth = getWidgetWidth(constraintWidget, i4);
                                ConstraintWidget[] constraintWidgetArr4 = this.mAlignedBiggestElementsInCols;
                                if (constraintWidgetArr4[i12] == null || constraintWidgetArr4[i12].getWidth() < widgetWidth) {
                                    this.mAlignedBiggestElementsInCols[i12] = constraintWidget;
                                }
                                int widgetHeight = getWidgetHeight(constraintWidget, i4);
                                ConstraintWidget[] constraintWidgetArr5 = this.mAlignedBiggestElementsInRows;
                                if (constraintWidgetArr5[i13] == null || constraintWidgetArr5[i13].getHeight() < widgetHeight) {
                                    this.mAlignedBiggestElementsInRows[i13] = constraintWidget;
                                }
                            }
                        }
                    }
                    int i15 = 0;
                    for (int i16 = 0; i16 < i6; i16++) {
                        ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i16];
                        if (constraintWidget4 != null) {
                            if (i16 > 0) {
                                i15 += this.mHorizontalGap;
                            }
                            i15 += getWidgetWidth(constraintWidget4, i4);
                        }
                    }
                    int i17 = 0;
                    for (int i18 = 0; i18 < i5; i18++) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i18];
                        if (constraintWidget5 != null) {
                            if (i18 > 0) {
                                i17 += this.mVerticalGap;
                            }
                            i17 += getWidgetHeight(constraintWidget5, i4);
                        }
                    }
                    iArr[0] = i15;
                    iArr[1] = i17;
                    if (i3 != 0) {
                        if (i17 > i4 && i5 > 1) {
                            i5--;
                        }
                    } else if (i15 > i4 && i6 > 1) {
                        i6--;
                    }
                    while (!z) {
                    }
                }
                int[] iArr2 = this.mAlignedDimensions;
                iArr2[0] = i6;
                iArr2[1] = i5;
            }
            z = true;
            while (!z) {
            }
            int[] iArr22 = this.mAlignedDimensions;
            iArr22[0] = i6;
            iArr22[1] = i5;
        }
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{constraintWidgetArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr}) == null) || i2 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(this, i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
        this.mChainList.add(widgetsList);
        if (i3 == 0) {
            i5 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i2) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i10];
                int widgetWidth = getWidgetWidth(constraintWidget, i4);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i11 = i5;
                boolean z = (i9 == i4 || (this.mHorizontalGap + i9) + widgetWidth > i4) && widgetsList.biggest != null;
                if (!z && i10 > 0 && (i8 = this.mMaxElementsWrap) > 0 && i10 % i8 == 0) {
                    z = true;
                }
                if (z) {
                    widgetsList = new WidgetsList(this, i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
                    widgetsList.setStartIndex(i10);
                    this.mChainList.add(widgetsList);
                } else if (i10 > 0) {
                    i9 += this.mHorizontalGap + widgetWidth;
                    widgetsList.add(constraintWidget);
                    i10++;
                    i5 = i11;
                }
                i9 = widgetWidth;
                widgetsList.add(constraintWidget);
                i10++;
                i5 = i11;
            }
        } else {
            i5 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i2) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                int widgetHeight = getWidgetHeight(constraintWidget2, i4);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i14 = i5;
                boolean z2 = (i12 == i4 || (this.mVerticalGap + i12) + widgetHeight > i4) && widgetsList.biggest != null;
                if (!z2 && i13 > 0 && (i6 = this.mMaxElementsWrap) > 0 && i13 % i6 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = new WidgetsList(this, i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
                    widgetsList.setStartIndex(i13);
                    this.mChainList.add(widgetsList);
                } else if (i13 > 0) {
                    i12 += this.mVerticalGap + widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i13++;
                    i5 = i14;
                }
                i12 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i13++;
                i5 = i14;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i5 > 0 && z3) {
            for (int i15 = 0; i15 < size; i15++) {
                WidgetsList widgetsList2 = this.mChainList.get(i15);
                if (i3 == 0) {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getHeight());
                }
            }
        }
        int i16 = paddingTop;
        int i17 = paddingRight2;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i22 = paddingBottom2;
        while (i20 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i20);
            if (i3 == 0) {
                if (i20 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i20 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i23 = i18;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i24 = i19;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i7 = i20;
                widgetsList3.setup(i3, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i21, i16, i17, paddingBottom, i4);
                int max = Math.max(i24, widgetsList3.getWidth());
                i18 = i23 + widgetsList3.getHeight();
                if (i7 > 0) {
                    i18 += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                i19 = max;
                constraintAnchor7 = constraintAnchor9;
                i16 = 0;
                constraintAnchor = constraintAnchor14;
                int i25 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i22 = i25;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i26 = i18;
                int i27 = i19;
                i7 = i20;
                if (i7 < size - 1) {
                    constraintAnchor = this.mChainList.get(i7 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i3, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i21, i16, paddingRight, i22, i4);
                i19 = i27 + widgetsList3.getWidth();
                int max2 = Math.max(i26, widgetsList3.getHeight());
                if (i7 > 0) {
                    i19 += this.mHorizontalGap;
                }
                i18 = max2;
                i17 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
                i21 = 0;
            }
            i20 = i7 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i19;
        iArr[1] = i18;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        WidgetsList widgetsList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{constraintWidgetArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr}) == null) || i2 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(this, i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i4);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            widgetsList.add(constraintWidgetArr[i5]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, linearSystem, z) == null) {
            super.addToSolver(linearSystem, z);
            boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
            int i2 = this.mWrapMode;
            if (i2 != 0) {
                if (i2 == 1) {
                    int size = this.mChainList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        this.mChainList.get(i3).createConstraints(isRtl, i3, i3 == size + (-1));
                        i3++;
                    }
                } else if (i2 == 2) {
                    createAlignedConstraints(isRtl);
                }
            } else if (this.mChainList.size() > 0) {
                this.mChainList.get(0).createConstraints(isRtl, 0, true);
            }
            needsCallbackFromSolver(false);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidget, hashMap) == null) {
            super.copy(constraintWidget, hashMap);
            Flow flow = (Flow) constraintWidget;
            this.mHorizontalStyle = flow.mHorizontalStyle;
            this.mVerticalStyle = flow.mVerticalStyle;
            this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
            this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
            this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
            this.mLastVerticalStyle = flow.mLastVerticalStyle;
            this.mHorizontalBias = flow.mHorizontalBias;
            this.mVerticalBias = flow.mVerticalBias;
            this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
            this.mFirstVerticalBias = flow.mFirstVerticalBias;
            this.mLastHorizontalBias = flow.mLastHorizontalBias;
            this.mLastVerticalBias = flow.mLastVerticalBias;
            this.mHorizontalGap = flow.mHorizontalGap;
            this.mVerticalGap = flow.mVerticalGap;
            this.mHorizontalAlign = flow.mHorizontalAlign;
            this.mVerticalAlign = flow.mVerticalAlign;
            this.mWrapMode = flow.mWrapMode;
            this.mMaxElementsWrap = flow.mMaxElementsWrap;
            this.mOrientation = flow.mOrientation;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010a  */
    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measure(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr;
        boolean z;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            if (this.mWidgetsCount > 0 && !measureChildren()) {
                setMeasure(0, 0);
                needsCallbackFromSolver(false);
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int[] iArr2 = new int[2];
            int i8 = (i3 - paddingLeft) - paddingRight;
            if (this.mOrientation == 1) {
                i8 = (i5 - paddingTop) - paddingBottom;
            }
            int i9 = i8;
            if (this.mOrientation == 0) {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            } else {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            }
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i6 = this.mWidgetsCount;
                if (i10 >= i6) {
                    break;
                }
                if (this.mWidgets[i10].getVisibility() == 8) {
                    i11++;
                }
                i10++;
            }
            if (i11 > 0) {
                constraintWidgetArr = new ConstraintWidget[i6 - i11];
                int i12 = 0;
                for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
                    ConstraintWidget constraintWidget = this.mWidgets[i13];
                    if (constraintWidget.getVisibility() != 8) {
                        constraintWidgetArr[i12] = constraintWidget;
                        i12++;
                    }
                }
                i7 = i12;
            } else {
                i7 = i6;
            }
            this.mDisplayedWidgets = constraintWidgetArr;
            this.mDisplayedWidgetsCount = i7;
            int i14 = this.mWrapMode;
            if (i14 == 0) {
                iArr = iArr2;
                z = true;
                measureNoWrap(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
            } else if (i14 == 1) {
                iArr = iArr2;
                z = true;
                measureChainWrap(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
            } else if (i14 == 2) {
                z = true;
                iArr = iArr2;
                measureAligned(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
            } else {
                iArr = iArr2;
                c2 = 0;
                z = true;
                int i15 = iArr[c2] + paddingLeft + paddingRight;
                int i16 = iArr[z ? 1 : 0] + paddingTop + paddingBottom;
                if (i2 != 1073741824) {
                    i15 = i3;
                } else if (i2 == Integer.MIN_VALUE) {
                    i15 = Math.min(i15, i3);
                } else if (i2 != 0) {
                    i15 = 0;
                }
                if (i4 != 1073741824) {
                    i16 = i5;
                } else if (i4 == Integer.MIN_VALUE) {
                    i16 = Math.min(i16, i5);
                } else if (i4 != 0) {
                    i16 = 0;
                }
                setMeasure(i15, i16);
                setWidth(i15);
                setHeight(i16);
                if (this.mWidgetsCount <= 0) {
                    z = false;
                }
                needsCallbackFromSolver(z);
            }
            c2 = 0;
            int i152 = iArr[c2] + paddingLeft + paddingRight;
            int i162 = iArr[z ? 1 : 0] + paddingTop + paddingBottom;
            if (i2 != 1073741824) {
            }
            if (i4 != 1073741824) {
            }
            setMeasure(i152, i162);
            setWidth(i152);
            setHeight(i162);
            if (this.mWidgetsCount <= 0) {
            }
            needsCallbackFromSolver(z);
        }
    }

    public void setFirstHorizontalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.mFirstHorizontalBias = f2;
        }
    }

    public void setFirstHorizontalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mFirstHorizontalStyle = i2;
        }
    }

    public void setFirstVerticalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mFirstVerticalBias = f2;
        }
    }

    public void setFirstVerticalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mFirstVerticalStyle = i2;
        }
    }

    public void setHorizontalAlign(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mHorizontalAlign = i2;
        }
    }

    public void setHorizontalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mHorizontalBias = f2;
        }
    }

    public void setHorizontalGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mHorizontalGap = i2;
        }
    }

    public void setHorizontalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mHorizontalStyle = i2;
        }
    }

    public void setLastHorizontalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.mLastHorizontalBias = f2;
        }
    }

    public void setLastHorizontalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mLastHorizontalStyle = i2;
        }
    }

    public void setLastVerticalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.mLastVerticalBias = f2;
        }
    }

    public void setLastVerticalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mLastVerticalStyle = i2;
        }
    }

    public void setMaxElementsWrap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mMaxElementsWrap = i2;
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mOrientation = i2;
        }
    }

    public void setVerticalAlign(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mVerticalAlign = i2;
        }
    }

    public void setVerticalBias(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.mVerticalBias = f2;
        }
    }

    public void setVerticalGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mVerticalGap = i2;
        }
    }

    public void setVerticalStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mVerticalStyle = i2;
        }
    }

    public void setWrapMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mWrapMode = i2;
        }
    }
}
