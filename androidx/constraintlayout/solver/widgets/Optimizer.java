package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Optimizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_CHAIN_DANGLING = 1;
    public static final int FLAG_RECOMPUTE_BOUNDS = 2;
    public static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;
    public static boolean[] flags;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343398412, "Landroidx/constraintlayout/solver/widgets/Optimizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343398412, "Landroidx/constraintlayout/solver/widgets/Optimizer;");
                return;
            }
        }
        flags = new boolean[3];
    }

    public Optimizer() {
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

    public static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, constraintWidgetContainer, linearSystem, constraintWidget) == null) {
            constraintWidget.mHorizontalResolution = -1;
            constraintWidget.mVerticalResolution = -1;
            if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int i2 = constraintWidget.mLeft.mMargin;
                int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
                ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
                constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i2);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(i2, width);
            }
            if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                return;
            }
            int i3 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.mBottom;
            constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i3);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.mBaseline;
                constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i3);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i3, height);
        }
    }

    public static final boolean enabled(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? (i2 & i3) == i3 : invokeII.booleanValue;
    }
}
