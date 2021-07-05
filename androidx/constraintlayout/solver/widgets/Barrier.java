package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Barrier extends Helper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowsGoneWidget;
    public int mBarrierType;
    public ArrayList<ResolutionAnchor> mNodes;

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
        this.mNodes = new ArrayList<>(4);
        this.mAllowsGoneWidget = true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        Object[] objArr;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearSystem) == null) {
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
            for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = this.mWidgets[i6];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                    z = true;
                    break;
                }
            }
            z = false;
            int i7 = this.mBarrierType;
            if (i7 == 0 || i7 == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
            for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i8];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                    int i9 = this.mBarrierType;
                    constraintAnchorArr2[i9].mSolverVariable = createObjectVariable;
                    if (i9 != 0 && i9 != 2) {
                        linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, z);
                    } else {
                        linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, z);
                    }
                }
            }
            int i10 = this.mBarrierType;
            if (i10 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
                if (z) {
                    return;
                }
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5);
            } else if (i10 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
                if (z) {
                    return;
                }
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5);
            } else if (i10 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
                if (z) {
                    return;
                }
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5);
            } else if (i10 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
                if (z) {
                    return;
                }
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean allowsGoneWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAllowsGoneWidget : invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i2) {
        ConstraintWidget constraintWidget;
        ResolutionAnchor resolutionNode;
        ResolutionAnchor resolutionNode2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (constraintWidget = this.mParent) != null && ((ConstraintWidgetContainer) constraintWidget).optimizeFor(2)) {
            int i3 = this.mBarrierType;
            if (i3 == 0) {
                resolutionNode = this.mLeft.getResolutionNode();
            } else if (i3 == 1) {
                resolutionNode = this.mRight.getResolutionNode();
            } else if (i3 == 2) {
                resolutionNode = this.mTop.getResolutionNode();
            } else if (i3 != 3) {
                return;
            } else {
                resolutionNode = this.mBottom.getResolutionNode();
            }
            resolutionNode.setType(5);
            int i4 = this.mBarrierType;
            if (i4 != 0 && i4 != 1) {
                this.mLeft.getResolutionNode().resolve(null, 0.0f);
                this.mRight.getResolutionNode().resolve(null, 0.0f);
            } else {
                this.mTop.getResolutionNode().resolve(null, 0.0f);
                this.mBottom.getResolutionNode().resolve(null, 0.0f);
            }
            this.mNodes.clear();
            for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i5];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    int i6 = this.mBarrierType;
                    if (i6 == 0) {
                        resolutionNode2 = constraintWidget2.mLeft.getResolutionNode();
                    } else if (i6 == 1) {
                        resolutionNode2 = constraintWidget2.mRight.getResolutionNode();
                    } else if (i6 != 2) {
                        resolutionNode2 = i6 != 3 ? null : constraintWidget2.mBottom.getResolutionNode();
                    } else {
                        resolutionNode2 = constraintWidget2.mTop.getResolutionNode();
                    }
                    if (resolutionNode2 != null) {
                        this.mNodes.add(resolutionNode2);
                        resolutionNode2.addDependent(resolutionNode);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetResolutionNodes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.resetResolutionNodes();
            this.mNodes.clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resolve() {
        ResolutionAnchor resolutionNode;
        float f2;
        ResolutionAnchor resolutionAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.mBarrierType;
            float f3 = Float.MAX_VALUE;
            if (i2 != 0) {
                if (i2 == 1) {
                    resolutionNode = this.mRight.getResolutionNode();
                } else if (i2 == 2) {
                    resolutionNode = this.mTop.getResolutionNode();
                } else if (i2 != 3) {
                    return;
                } else {
                    resolutionNode = this.mBottom.getResolutionNode();
                }
                f3 = 0.0f;
            } else {
                resolutionNode = this.mLeft.getResolutionNode();
            }
            int size = this.mNodes.size();
            ResolutionAnchor resolutionAnchor2 = null;
            for (int i3 = 0; i3 < size; i3++) {
                ResolutionAnchor resolutionAnchor3 = this.mNodes.get(i3);
                if (resolutionAnchor3.state != 1) {
                    return;
                }
                int i4 = this.mBarrierType;
                if (i4 != 0 && i4 != 2) {
                    f2 = resolutionAnchor3.resolvedOffset;
                    if (f2 > f3) {
                        resolutionAnchor = resolutionAnchor3.resolvedTarget;
                        resolutionAnchor2 = resolutionAnchor;
                        f3 = f2;
                    }
                } else {
                    f2 = resolutionAnchor3.resolvedOffset;
                    if (f2 < f3) {
                        resolutionAnchor = resolutionAnchor3.resolvedTarget;
                        resolutionAnchor2 = resolutionAnchor;
                        f3 = f2;
                    }
                }
            }
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().barrierConnectionResolved++;
            }
            resolutionNode.resolvedTarget = resolutionAnchor2;
            resolutionNode.resolvedOffset = f3;
            resolutionNode.didResolve();
            int i5 = this.mBarrierType;
            if (i5 == 0) {
                this.mRight.getResolutionNode().resolve(resolutionAnchor2, f3);
            } else if (i5 == 1) {
                this.mLeft.getResolutionNode().resolve(resolutionAnchor2, f3);
            } else if (i5 == 2) {
                this.mBottom.getResolutionNode().resolve(resolutionAnchor2, f3);
            } else if (i5 == 3) {
                this.mTop.getResolutionNode().resolve(resolutionAnchor2, f3);
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mAllowsGoneWidget = z;
        }
    }

    public void setBarrierType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mBarrierType = i2;
        }
    }
}
