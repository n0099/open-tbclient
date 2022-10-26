package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public static final boolean USE_RELAX_GONE = false;
    public static final boolean USE_RESOLUTION = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowsGoneWidget;
    public int mBarrierType;
    public int mMargin;
    public boolean resolved;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public Barrier() {
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
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    public boolean allowsGoneWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAllowsGoneWidget;
        }
        return invokeV.booleanValue;
    }

    public int getBarrierType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mBarrierType;
        }
        return invokeV.intValue;
    }

    public int getMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mMargin;
        }
        return invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.mBarrierType;
            if (i != 0 && i != 1) {
                if (i == 2 || i == 3) {
                    return 1;
                }
                return -1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.resolved;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.resolved;
        }
        return invokeV.booleanValue;
    }

    public void markWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (int i = 0; i < this.mWidgetsCount; i++) {
                ConstraintWidget constraintWidget = this.mWidgets[i];
                int i2 = this.mBarrierType;
                if (i2 != 0 && i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        constraintWidget.setInBarrier(1, true);
                    }
                } else {
                    constraintWidget.setInBarrier(0, true);
                }
            }
        }
    }

    public Barrier(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(str);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        Object[] objArr;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, linearSystem, z) == null) {
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            constraintAnchorArr[0] = this.mLeft;
            constraintAnchorArr[2] = this.mTop;
            constraintAnchorArr[1] = this.mRight;
            constraintAnchorArr[3] = this.mBottom;
            int i4 = 0;
            while (true) {
                objArr = this.mListAnchors;
                if (i4 >= objArr.length) {
                    break;
                }
                objArr[i4].mSolverVariable = linearSystem.createObjectVariable(objArr[i4]);
                i4++;
            }
            int i5 = this.mBarrierType;
            if (i5 >= 0 && i5 < 4) {
                ConstraintAnchor constraintAnchor = objArr[i5];
                if (!this.resolved) {
                    allSolved();
                }
                if (this.resolved) {
                    this.resolved = false;
                    int i6 = this.mBarrierType;
                    if (i6 != 0 && i6 != 1) {
                        if (i6 == 2 || i6 == 3) {
                            linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                            return;
                        }
                        return;
                    }
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                    return;
                }
                for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
                    ConstraintWidget constraintWidget = this.mWidgets[i7];
                    if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!this.mLeft.hasCenteredDependents() && !this.mRight.hasCenteredDependents()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!this.mTop.hasCenteredDependents() && !this.mBottom.hasCenteredDependents()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!z2 && ((this.mBarrierType == 0 && z3) || ((this.mBarrierType == 2 && z4) || ((this.mBarrierType == 1 && z3) || (this.mBarrierType == 3 && z4))))) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                int i8 = 5;
                if (!z5) {
                    i8 = 4;
                }
                for (int i9 = 0; i9 < this.mWidgetsCount; i9++) {
                    ConstraintWidget constraintWidget2 = this.mWidgets[i9];
                    if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                        int i10 = this.mBarrierType;
                        constraintAnchorArr2[i10].mSolverVariable = createObjectVariable;
                        if (constraintAnchorArr2[i10].mTarget != null && constraintAnchorArr2[i10].mTarget.mOwner == this) {
                            i = constraintAnchorArr2[i10].mMargin + 0;
                        } else {
                            i = 0;
                        }
                        int i11 = this.mBarrierType;
                        if (i11 != 0 && i11 != 2) {
                            linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i, z2);
                        } else {
                            linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin - i, z2);
                        }
                        linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i, i8);
                    }
                }
                int i12 = this.mBarrierType;
                if (i12 == 0) {
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                } else if (i12 == 1) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
                } else if (i12 == 2) {
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
                } else if (i12 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
                }
            }
        }
    }

    public boolean allSolved() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i4 = 0;
            boolean z = true;
            while (true) {
                i = this.mWidgetsCount;
                if (i4 >= i) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i4];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && !constraintWidget.isResolvedVertically()))) {
                    z = false;
                }
                i4++;
            }
            if (!z || i <= 0) {
                return false;
            }
            int i5 = 0;
            boolean z2 = false;
            for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i6];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    if (!z2) {
                        int i7 = this.mBarrierType;
                        if (i7 == 0) {
                            i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                        } else if (i7 == 1) {
                            i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                        } else if (i7 == 2) {
                            i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                        } else if (i7 == 3) {
                            i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                        }
                        z2 = true;
                    }
                    int i8 = this.mBarrierType;
                    if (i8 == 0) {
                        i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                    } else if (i8 == 1) {
                        i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                    } else if (i8 == 2) {
                        i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                    } else if (i8 == 3) {
                        i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                    }
                }
            }
            int i9 = i5 + this.mMargin;
            int i10 = this.mBarrierType;
            if (i10 != 0 && i10 != 1) {
                setFinalVertical(i9, i9);
            } else {
                setFinalHorizontal(i9, i9);
            }
            this.resolved = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, constraintWidget, hashMap) == null) {
            super.copy(constraintWidget, hashMap);
            Barrier barrier = (Barrier) constraintWidget;
            this.mBarrierType = barrier.mBarrierType;
            this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
            this.mMargin = barrier.mMargin;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mAllowsGoneWidget = z;
        }
    }

    public void setBarrierType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mBarrierType = i;
        }
    }

    public void setMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mMargin = i;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String str = "[Barrier] " + getDebugName() + " {";
            for (int i = 0; i < this.mWidgetsCount; i++) {
                ConstraintWidget constraintWidget = this.mWidgets[i];
                if (i > 0) {
                    str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
                str = str + constraintWidget.getDebugName();
            }
            return str + "}";
        }
        return (String) invokeV.objValue;
    }
}
