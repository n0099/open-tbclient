package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int NOT_FOUND = -1;
    public static final float epsilon = 1.0E-4f;
    public transient /* synthetic */ FieldHolder $fh;
    public int TABLE_SIZE;
    public GoalVariableAccessor accessor;
    public SolverVariable[] arrayGoals;
    public Cache mCache;
    public int numGoals;
    public SolverVariable[] sortArray;

    /* loaded from: classes.dex */
    public class GoalVariableAccessor implements Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PriorityGoalRow row;
        public final /* synthetic */ PriorityGoalRow this$0;
        public SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {priorityGoalRow, priorityGoalRow2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = priorityGoalRow;
            this.row = priorityGoalRow2;
        }

        public void add(SolverVariable solverVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, solverVariable) == null) {
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.variable.goalStrengthVector;
                    fArr[i] = fArr[i] + solverVariable.goalStrengthVector[i];
                    if (Math.abs(fArr[i]) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i] = 0.0f;
                    }
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, solverVariable, f)) == null) {
                boolean z = true;
                if (!this.variable.inGoal) {
                    for (int i = 0; i < 9; i++) {
                        float f2 = solverVariable.goalStrengthVector[i];
                        if (f2 != 0.0f) {
                            float f3 = f2 * f;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            this.variable.goalStrengthVector[i] = f3;
                        } else {
                            this.variable.goalStrengthVector[i] = 0.0f;
                        }
                    }
                    return true;
                }
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.variable.goalStrengthVector;
                    fArr[i2] = fArr[i2] + (solverVariable.goalStrengthVector[i2] * f);
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i2] = 0.0f;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.this$0.removeGoal(this.variable);
                }
                return false;
            }
            return invokeLF.booleanValue;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.variable.id - ((SolverVariable) obj).id : invokeL.intValue;
        }

        public void init(SolverVariable solverVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, solverVariable) == null) {
                this.variable = solverVariable;
            }
        }

        public final boolean isNegative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                for (int i = 8; i >= 0; i--) {
                    float f = this.variable.goalStrengthVector[i];
                    if (f > 0.0f) {
                        return false;
                    }
                    if (f < 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isNull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                for (int i = 0; i < 9; i++) {
                    if (this.variable.goalStrengthVector[i] != 0.0f) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, solverVariable)) == null) {
                int i = 8;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    float f = solverVariable.goalStrengthVector[i];
                    float f2 = this.variable.goalStrengthVector[i];
                    if (f2 == f) {
                        i--;
                    } else if (f2 < f) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                Arrays.fill(this.variable.goalStrengthVector, 0.0f);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String str = "[ ";
                if (this.variable != null) {
                    for (int i = 0; i < 9; i++) {
                        str = str + this.variable.goalStrengthVector[i] + " ";
                    }
                }
                return str + "] " + this.variable;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityGoalRow(Cache cache) {
        super(cache);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Cache) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, solverVariable) == null) {
            int i2 = this.numGoals + 1;
            SolverVariable[] solverVariableArr = this.arrayGoals;
            if (i2 > solverVariableArr.length) {
                SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
                this.arrayGoals = solverVariableArr2;
                this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
            }
            SolverVariable[] solverVariableArr3 = this.arrayGoals;
            int i3 = this.numGoals;
            solverVariableArr3[i3] = solverVariable;
            int i4 = i3 + 1;
            this.numGoals = i4;
            if (i4 > 1 && solverVariableArr3[i4 - 1].id > solverVariable.id) {
                int i5 = 0;
                while (true) {
                    i = this.numGoals;
                    if (i5 >= i) {
                        break;
                    }
                    this.sortArray[i5] = this.arrayGoals[i5];
                    i5++;
                }
                Arrays.sort(this.sortArray, 0, i, new Comparator<SolverVariable>(this) { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PriorityGoalRow this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, solverVariable2, solverVariable3)) == null) ? solverVariable2.id - solverVariable3.id : invokeLL.intValue;
                    }
                });
                for (int i6 = 0; i6 < this.numGoals; i6++) {
                    this.arrayGoals[i6] = this.sortArray[i6];
                }
            }
            solverVariable.inGoal = true;
            solverVariable.addToRow(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, solverVariable) == null) {
            int i = 0;
            while (i < this.numGoals) {
                if (this.arrayGoals[i] == solverVariable) {
                    while (true) {
                        int i2 = this.numGoals;
                        if (i < i2 - 1) {
                            SolverVariable[] solverVariableArr = this.arrayGoals;
                            int i3 = i + 1;
                            solverVariableArr[i] = solverVariableArr[i3];
                            i = i3;
                        } else {
                            this.numGoals = i2 - 1;
                            solverVariable.inGoal = false;
                            return;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, solverVariable) == null) {
            this.accessor.init(solverVariable);
            this.accessor.reset();
            solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
            addToGoal(solverVariable);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.numGoals = 0;
            this.constantValue = 0.0f;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, linearSystem, zArr)) == null) {
            int i = -1;
            for (int i2 = 0; i2 < this.numGoals; i2++) {
                SolverVariable solverVariable = this.arrayGoals[i2];
                if (!zArr[solverVariable.id]) {
                    this.accessor.init(solverVariable);
                    if (i == -1) {
                        if (!this.accessor.isNegative()) {
                        }
                        i = i2;
                    } else {
                        if (!this.accessor.isSmallerThan(this.arrayGoals[i])) {
                        }
                        i = i2;
                    }
                }
            }
            if (i == -1) {
                return null;
            }
            return this.arrayGoals[i];
        }
        return (SolverVariable) invokeLL.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.numGoals == 0 : invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = " goal -> (" + this.constantValue + ") : ";
            for (int i = 0; i < this.numGoals; i++) {
                this.accessor.init(this.arrayGoals[i]);
                str = str + this.accessor + " ";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, linearSystem, arrayRow, z) == null) || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            float variableValue = arrayRowVariables.getVariableValue(i);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue += arrayRow.constantValue * variableValue;
        }
        removeGoal(solverVariable);
    }
}
