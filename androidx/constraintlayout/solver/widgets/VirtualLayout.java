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

    public VirtualLayout() {
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

    public void captureWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (constraintWidget != null) {
                    constraintWidget.setInVirtualLayout(true);
                }
            }
        }
    }

    public int getMeasuredHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMeasuredHeight : invokeV.intValue;
    }

    public int getMeasuredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMeasuredWidth : invokeV.intValue;
    }

    public int getPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPaddingBottom : invokeV.intValue;
    }

    public int getPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mResolvedPaddingLeft : invokeV.intValue;
    }

    public int getPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mResolvedPaddingRight : invokeV.intValue;
    }

    public int getPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPaddingTop : invokeV.intValue;
    }

    public void measure(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
        }
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{constraintWidget, dimensionBehaviour, Integer.valueOf(i2), dimensionBehaviour2, Integer.valueOf(i3)}) == null) {
            while (this.mMeasurer == null && getParent() != null) {
                this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
            }
            BasicMeasure.Measure measure = this.mMeasure;
            measure.horizontalBehavior = dimensionBehaviour;
            measure.verticalBehavior = dimensionBehaviour2;
            measure.horizontalDimension = i2;
            measure.verticalDimension = i3;
            this.mMeasurer.measure(constraintWidget, measure);
            constraintWidget.setWidth(this.mMeasure.measuredWidth);
            constraintWidget.setHeight(this.mMeasure.measuredHeight);
            constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
            constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        }
    }

    public boolean measureChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
            return invokeV.booleanValue;
        }
        ConstraintWidget constraintWidget = this.mParent;
        BasicMeasure.Measurer measurer = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.mWidgets[i2];
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
            i2++;
        }
    }

    public boolean needSolverPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mNeedsCallFromSolver : invokeV.booleanValue;
    }

    public void needsCallbackFromSolver(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mNeedsCallFromSolver = z;
        }
    }

    public void setMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.mMeasuredWidth = i2;
            this.mMeasuredHeight = i3;
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mPaddingLeft = i2;
            this.mPaddingTop = i2;
            this.mPaddingRight = i2;
            this.mPaddingBottom = i2;
            this.mPaddingStart = i2;
            this.mPaddingEnd = i2;
        }
    }

    public void setPaddingBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mPaddingBottom = i2;
        }
    }

    public void setPaddingEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mPaddingEnd = i2;
        }
    }

    public void setPaddingLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mPaddingLeft = i2;
            this.mResolvedPaddingLeft = i2;
        }
    }

    public void setPaddingRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mPaddingRight = i2;
            this.mResolvedPaddingRight = i2;
        }
    }

    public void setPaddingStart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mPaddingStart = i2;
            this.mResolvedPaddingLeft = i2;
            this.mResolvedPaddingRight = i2;
        }
    }

    public void setPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mPaddingTop = i2;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, constraintWidgetContainer) == null) {
            captureWidgets();
        }
    }
}
