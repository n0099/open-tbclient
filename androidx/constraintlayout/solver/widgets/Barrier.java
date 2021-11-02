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

    public Barrier() {
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
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        Object[] objArr;
        boolean z2;
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
            if (i5 < 0 || i5 >= 4) {
                return;
            }
            ConstraintAnchor constraintAnchor = objArr[i5];
            if (!this.resolved) {
                allSolved();
            }
            if (this.resolved) {
                this.resolved = false;
                int i6 = this.mBarrierType;
                if (i6 == 0 || i6 == 1) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                    return;
                } else if (i6 == 2 || i6 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                    return;
                } else {
                    return;
                }
            }
            for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
                ConstraintWidget constraintWidget = this.mWidgets[i7];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
            boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
            int i8 = !z2 && ((this.mBarrierType == 0 && z3) || ((this.mBarrierType == 2 && z4) || ((this.mBarrierType == 1 && z3) || (this.mBarrierType == 3 && z4)))) ? 5 : 4;
            for (int i9 = 0; i9 < this.mWidgetsCount; i9++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i9];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                    int i10 = this.mBarrierType;
                    constraintAnchorArr2[i10].mSolverVariable = createObjectVariable;
                    int i11 = (constraintAnchorArr2[i10].mTarget == null || constraintAnchorArr2[i10].mTarget.mOwner != this) ? 0 : constraintAnchorArr2[i10].mMargin + 0;
                    int i12 = this.mBarrierType;
                    if (i12 != 0 && i12 != 2) {
                        linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i11, z2);
                    } else {
                        linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin - i11, z2);
                    }
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i11, i8);
                }
            }
            int i13 = this.mBarrierType;
            if (i13 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            } else if (i13 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (i13 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (i13 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    public boolean allSolved() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i5 = 0;
            boolean z = true;
            while (true) {
                i2 = this.mWidgetsCount;
                if (i5 >= i2) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i5];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i3 = this.mBarrierType) == 0 || i3 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i4 = this.mBarrierType) == 2 || i4 == 3) && !constraintWidget.isResolvedVertically()))) {
                    z = false;
                }
                i5++;
            }
            if (!z || i2 <= 0) {
                return false;
            }
            int i6 = 0;
            boolean z2 = false;
            for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i7];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    if (!z2) {
                        int i8 = this.mBarrierType;
                        if (i8 == 0) {
                            i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                        } else if (i8 == 1) {
                            i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                        } else if (i8 == 2) {
                            i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                        } else if (i8 == 3) {
                            i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                        }
                        z2 = true;
                    }
                    int i9 = this.mBarrierType;
                    if (i9 == 0) {
                        i6 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                    } else if (i9 == 1) {
                        i6 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                    } else if (i9 == 2) {
                        i6 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                    } else if (i9 == 3) {
                        i6 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                    }
                }
            }
            int i10 = i6 + this.mMargin;
            int i11 = this.mBarrierType;
            if (i11 != 0 && i11 != 1) {
                setFinalVertical(i10, i10);
            } else {
                setFinalHorizontal(i10, i10);
            }
            this.resolved = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean allowsGoneWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAllowsGoneWidget : invokeV.booleanValue;
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

    public int getBarrierType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBarrierType : invokeV.intValue;
    }

    public int getMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMargin : invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.mBarrierType;
            if (i2 == 0 || i2 == 1) {
                return 0;
            }
            return (i2 == 2 || i2 == 3) ? 1 : -1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.resolved : invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.resolved : invokeV.booleanValue;
    }

    public void markWidgets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                int i3 = this.mBarrierType;
                if (i3 == 0 || i3 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i3 == 2 || i3 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mAllowsGoneWidget = z;
        }
    }

    public void setBarrierType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mBarrierType = i2;
        }
    }

    public void setMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mMargin = i2;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String str = "[Barrier] " + getDebugName() + " {";
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (i2 > 0) {
                    str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
                str = str + constraintWidget.getDebugName();
            }
            return str + "}";
        }
        return (String) invokeV.objValue;
    }

    public Barrier(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
