package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BasicMeasure.Measure mMeasure;
    public int mMeasuredHeight;
    public int mMeasuredWidth;
    public BasicMeasure.Measurer mMeasurer;
    public boolean mNeedsCallFromSolver;
    public int mPaddingBottom;
    public int mPaddingEnd;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingStart;
    public int mPaddingTop;
    public int mResolvedPaddingLeft;
    public int mResolvedPaddingRight;

    public void measure(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
        }
    }

    public VirtualLayout() {
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
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingStart = 0;
        this.mPaddingEnd = 0;
        this.mResolvedPaddingLeft = 0;
        this.mResolvedPaddingRight = 0;
        this.mNeedsCallFromSolver = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.mMeasure = new BasicMeasure.Measure();
        this.mMeasurer = null;
    }

    public void applyRtl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.mPaddingStart > 0 || this.mPaddingEnd > 0) {
                if (z) {
                    this.mResolvedPaddingLeft = this.mPaddingEnd;
                    this.mResolvedPaddingRight = this.mPaddingStart;
                    return;
                }
                this.mResolvedPaddingLeft = this.mPaddingStart;
                this.mResolvedPaddingRight = this.mPaddingEnd;
            }
        }
    }

    public void needsCallbackFromSolver(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mNeedsCallFromSolver = z;
        }
    }

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mPaddingLeft = i;
            this.mPaddingTop = i;
            this.mPaddingRight = i;
            this.mPaddingBottom = i;
            this.mPaddingStart = i;
            this.mPaddingEnd = i;
        }
    }

    public void setPaddingBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mPaddingBottom = i;
        }
    }

    public void setPaddingEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mPaddingEnd = i;
        }
    }

    public void setPaddingLeft(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mPaddingLeft = i;
            this.mResolvedPaddingLeft = i;
        }
    }

    public void setPaddingRight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mPaddingRight = i;
            this.mResolvedPaddingRight = i;
        }
    }

    public void setPaddingStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mPaddingStart = i;
            this.mResolvedPaddingLeft = i;
            this.mResolvedPaddingRight = i;
        }
    }

    public void setPaddingTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mPaddingTop = i;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, constraintWidgetContainer) == null) {
            captureWidgets();
        }
    }

    public void captureWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.mWidgetsCount; i++) {
                ConstraintWidget constraintWidget = this.mWidgets[i];
                if (constraintWidget != null) {
                    constraintWidget.setInVirtualLayout(true);
                }
            }
        }
    }

    public int getMeasuredHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMeasuredHeight;
        }
        return invokeV.intValue;
    }

    public int getMeasuredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMeasuredWidth;
        }
        return invokeV.intValue;
    }

    public int getPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPaddingBottom;
        }
        return invokeV.intValue;
    }

    public int getPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mResolvedPaddingLeft;
        }
        return invokeV.intValue;
    }

    public int getPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mResolvedPaddingRight;
        }
        return invokeV.intValue;
    }

    public int getPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPaddingTop;
        }
        return invokeV.intValue;
    }

    public boolean needSolverPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mNeedsCallFromSolver;
        }
        return invokeV.booleanValue;
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{constraintWidget, dimensionBehaviour, Integer.valueOf(i), dimensionBehaviour2, Integer.valueOf(i2)}) == null) {
            while (this.mMeasurer == null && getParent() != null) {
                this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
            }
            BasicMeasure.Measure measure = this.mMeasure;
            measure.horizontalBehavior = dimensionBehaviour;
            measure.verticalBehavior = dimensionBehaviour2;
            measure.horizontalDimension = i;
            measure.verticalDimension = i2;
            this.mMeasurer.measure(constraintWidget, measure);
            constraintWidget.setWidth(this.mMeasure.measuredWidth);
            constraintWidget.setHeight(this.mMeasure.measuredHeight);
            constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        }
    }

    public boolean measureChildren() {
        InterceptResult invokeV;
        BasicMeasure.Measurer measurer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ConstraintWidget constraintWidget = this.mParent;
            if (constraintWidget != null) {
                measurer = ((ConstraintWidgetContainer) constraintWidget).getMeasurer();
            } else {
                measurer = null;
            }
            if (measurer == null) {
                return false;
            }
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= this.mWidgetsCount) {
                    return true;
                }
                ConstraintWidget constraintWidget2 = this.mWidgets[i];
                if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (!((dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) ? false : false)) {
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        }
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        }
                        BasicMeasure.Measure measure = this.mMeasure;
                        measure.horizontalBehavior = dimensionBehaviour;
                        measure.verticalBehavior = dimensionBehaviour2;
                        measure.horizontalDimension = constraintWidget2.getWidth();
                        this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                        measurer.measure(constraintWidget2, this.mMeasure);
                        constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                        constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                        constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                    }
                }
                i++;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public void setMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.mMeasuredWidth = i;
            this.mMeasuredHeight = i2;
        }
    }
}
