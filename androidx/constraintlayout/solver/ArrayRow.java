package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public static final boolean FULL_NEW_CHECK = false;
    public transient /* synthetic */ FieldHolder $fh;
    public float constantValue;
    public boolean isSimpleDefinition;
    public boolean used;
    public SolverVariable variable;
    public ArrayRowVariables variables;
    public ArrayList<SolverVariable> variablesToUpdate;

    /* loaded from: classes.dex */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i);

        float getVariableValue(int i);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
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
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList<>();
        this.isSimpleDefinition = false;
    }

    public ArrayRow(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList<>();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, solverVariable, linearSystem)) == null) {
            if (solverVariable.usageInRowCount <= 1) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, linearSystem, i)) == null) {
            this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
            this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, solverVariable, i)) == null) {
            this.variables.put(solverVariable, i);
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, solverVariable, i)) == null) {
            this.variable = solverVariable;
            float f = i;
            solverVariable.computedValue = f;
            this.constantValue = f;
            this.isSimpleDefinition = true;
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, solverVariable, i)) == null) {
            if (i < 0) {
                this.constantValue = i * (-1);
                this.variables.put(solverVariable, 1.0f);
            } else {
                this.constantValue = i;
                this.variables.put(solverVariable, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, linearSystem, zArr)) == null) {
            return pickPivotInVariables(zArr, null);
        }
        return (SolverVariable) invokeLL.objValue;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        InterceptResult invokeLL;
        SolverVariable.Type type;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, zArr, solverVariable)) == null) {
            int currentSize = this.variables.getCurrentSize();
            SolverVariable solverVariable2 = null;
            float f = 0.0f;
            for (int i = 0; i < currentSize; i++) {
                float variableValue = this.variables.getVariableValue(i);
                if (variableValue < 0.0f) {
                    SolverVariable variable = this.variables.getVariable(i);
                    if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                        f = variableValue;
                        solverVariable2 = variable;
                    }
                }
            }
            return solverVariable2;
        }
        return (SolverVariable) invokeLL.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, solverVariable) == null) {
            int i = solverVariable.strength;
            float f = 1.0f;
            if (i != 1) {
                if (i == 2) {
                    f = 1000.0f;
                } else if (i == 3) {
                    f = 1000000.0f;
                } else if (i == 4) {
                    f = 1.0E9f;
                } else if (i == 5) {
                    f = 1.0E12f;
                }
            }
            this.variables.put(solverVariable, f);
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, row) == null) && (row instanceof ArrayRow)) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i = 0; i < arrayRow.variables.getCurrentSize(); i++) {
                this.variables.add(arrayRow.variables.getVariable(i), arrayRow.variables.getVariableValue(i), true);
            }
        }
    }

    public void pivot(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, solverVariable) == null) {
            SolverVariable solverVariable2 = this.variable;
            if (solverVariable2 != null) {
                this.variables.put(solverVariable2, -1.0f);
                this.variable.definitionId = -1;
                this.variable = null;
            }
            float remove = this.variables.remove(solverVariable, true) * (-1.0f);
            this.variable = solverVariable;
            if (remove == 1.0f) {
                return;
            }
            this.constantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    public boolean chooseSubject(LinearSystem linearSystem) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, linearSystem)) == null) {
            SolverVariable chooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
            if (chooseSubjectInVariables == null) {
                z = true;
            } else {
                pivot(chooseSubjectInVariables);
                z = false;
            }
            if (this.variables.getCurrentSize() == 0) {
                this.isSimpleDefinition = true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, solverVariable)) == null) {
            return this.variables.contains(solverVariable);
        }
        return invokeL.booleanValue;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, solverVariable)) == null) {
            return pickPivotInVariables(null, solverVariable);
        }
        return (SolverVariable) invokeL.objValue;
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        InterceptResult invokeL;
        boolean isNew;
        boolean isNew2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearSystem)) == null) {
            int currentSize = this.variables.getCurrentSize();
            SolverVariable solverVariable = null;
            SolverVariable solverVariable2 = null;
            boolean z = false;
            boolean z2 = false;
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < currentSize; i++) {
                float variableValue = this.variables.getVariableValue(i);
                SolverVariable variable = this.variables.getVariable(i);
                if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable == null) {
                        isNew2 = isNew(variable, linearSystem);
                    } else if (f > variableValue) {
                        isNew2 = isNew(variable, linearSystem);
                    } else if (!z && isNew(variable, linearSystem)) {
                        f = variableValue;
                        solverVariable = variable;
                        z = true;
                    }
                    z = isNew2;
                    f = variableValue;
                    solverVariable = variable;
                } else if (solverVariable == null && variableValue < 0.0f) {
                    if (solverVariable2 == null) {
                        isNew = isNew(variable, linearSystem);
                    } else if (f2 > variableValue) {
                        isNew = isNew(variable, linearSystem);
                    } else if (!z2 && isNew(variable, linearSystem)) {
                        f2 = variableValue;
                        solverVariable2 = variable;
                        z2 = true;
                    }
                    z2 = isNew;
                    f2 = variableValue;
                    solverVariable2 = variable;
                }
            }
            if (solverVariable != null) {
                return solverVariable;
            }
            return solverVariable2;
        }
        return (SolverVariable) invokeL.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, linearSystem) != null) || linearSystem.mRows.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.variables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                SolverVariable variable = this.variables.getVariable(i);
                if (variable.definitionId != -1 || variable.isFinalValue || variable.isSynonym) {
                    this.variablesToUpdate.add(variable);
                }
            }
            int size = this.variablesToUpdate.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    SolverVariable solverVariable = this.variablesToUpdate.get(i2);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.isSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.variables.clear();
            this.variable = null;
            this.constantValue = 0.0f;
        }
    }

    public void ensurePositiveConstant() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            float f = this.constantValue;
            if (f < 0.0f) {
                this.constantValue = f * (-1.0f);
                this.variables.invert();
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.variable;
        }
        return (SolverVariable) invokeV.objValue;
    }

    public boolean hasKeyVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SolverVariable solverVariable = this.variable;
            if (solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.variable = null;
            this.variables.clear();
            this.constantValue = 0.0f;
            this.isSimpleDefinition = false;
        }
    }

    public int sizeInBytes() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.variable != null) {
                i = 4;
            } else {
                i = 0;
            }
            return i + 4 + 4 + this.variables.sizeInBytes();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return toReadableString();
        }
        return (String) invokeV.objValue;
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i), Float.valueOf(f), solverVariable3, solverVariable4, Integer.valueOf(i2)})) == null) {
            if (solverVariable2 == solverVariable3) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable2, -2.0f);
                return this;
            }
            if (f == 0.5f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable3, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                if (i > 0 || i2 > 0) {
                    this.constantValue = (-i) + i2;
                }
            } else if (f <= 0.0f) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.constantValue = i;
            } else if (f >= 1.0f) {
                this.variables.put(solverVariable4, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
                this.constantValue = -i2;
            } else {
                float f2 = 1.0f - f;
                this.variables.put(solverVariable, f2 * 1.0f);
                this.variables.put(solverVariable2, f2 * (-1.0f));
                this.variables.put(solverVariable3, (-1.0f) * f);
                this.variables.put(solverVariable4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    this.constantValue = ((-i) * f2) + (i2 * f);
                }
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{solverVariable, solverVariable2, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, f);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, solverVariable, solverVariable2, i)) == null) {
            boolean z = false;
            if (i != 0) {
                if (i < 0) {
                    i *= -1;
                    z = true;
                }
                this.constantValue = i;
            }
            if (!z) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
            } else {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeLLI.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048607, this, linearSystem, solverVariable, z) != null) || !solverVariable.isFinalValue) {
            return;
        }
        this.constantValue += solverVariable.computedValue * this.variables.get(solverVariable);
        this.variables.remove(solverVariable, z);
        if (z) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && solverVariable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048608, this, linearSystem, arrayRow, z) == null) {
            this.constantValue += arrayRow.constantValue * this.variables.use(arrayRow, z);
            if (z) {
                arrayRow.variable.removeFromRow(this);
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
                this.isSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, f);
            this.variables.put(solverVariable4, -f);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable3, 0.5f);
            this.variables.put(solverVariable4, 0.5f);
            this.variables.put(solverVariable, -0.5f);
            this.variables.put(solverVariable2, -0.5f);
            this.constantValue = -f;
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), solverVariable, Integer.valueOf(i), solverVariable2, Integer.valueOf(i2), solverVariable3, Integer.valueOf(i3), solverVariable4, Integer.valueOf(i4)})) == null) {
            if (f2 != 0.0f && f != f3) {
                float f4 = (f / f2) / (f3 / f2);
                this.constantValue = ((-i) - i2) + (i3 * f4) + (i4 * f4);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f4);
                this.variables.put(solverVariable3, -f4);
            } else {
                this.constantValue = ((-i) - i2) + i3 + i4;
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), solverVariable, solverVariable2, solverVariable3, solverVariable4})) == null) {
            this.constantValue = 0.0f;
            if (f2 != 0.0f && f != f3) {
                if (f == 0.0f) {
                    this.variables.put(solverVariable, 1.0f);
                    this.variables.put(solverVariable2, -1.0f);
                } else if (f3 == 0.0f) {
                    this.variables.put(solverVariable3, 1.0f);
                    this.variables.put(solverVariable4, -1.0f);
                } else {
                    float f4 = (f / f2) / (f3 / f2);
                    this.variables.put(solverVariable, 1.0f);
                    this.variables.put(solverVariable2, -1.0f);
                    this.variables.put(solverVariable4, f4);
                    this.variables.put(solverVariable3, -f4);
                }
            } else {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i, SolverVariable solverVariable2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048590, this, solverVariable, i, solverVariable2)) == null) {
            this.constantValue = i;
            this.variables.put(solverVariable, -1.0f);
            return this;
        }
        return (ArrayRow) invokeLIL.objValue;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048591, this, solverVariable, solverVariable2, solverVariable3, i)) == null) {
            boolean z = false;
            if (i != 0) {
                if (i < 0) {
                    i *= -1;
                    z = true;
                }
                this.constantValue = i;
            }
            if (!z) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.variables.put(solverVariable3, 1.0f);
            } else {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable3, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeLLLI.objValue;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048592, this, solverVariable, solverVariable2, solverVariable3, i)) == null) {
            boolean z = false;
            if (i != 0) {
                if (i < 0) {
                    i *= -1;
                    z = true;
                }
                this.constantValue = i;
            }
            if (!z) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            } else {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeLLLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toReadableString() {
        InterceptResult invokeV;
        String str;
        boolean z;
        float variableValue;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.variable == null) {
                str = "0";
            } else {
                str = "" + this.variable;
            }
            String str2 = str + " = ";
            if (this.constantValue != 0.0f) {
                str2 = str2 + this.constantValue;
                z = true;
            } else {
                z = false;
            }
            int currentSize = this.variables.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                SolverVariable variable = this.variables.getVariable(i2);
                if (variable != null && (this.variables.getVariableValue(i2)) != 0.0f) {
                    String solverVariable = variable.toString();
                    if (!z) {
                        if (variableValue < 0.0f) {
                            str2 = str2 + "- ";
                            variableValue *= -1.0f;
                        }
                        if (variableValue == 1.0f) {
                            str2 = str2 + solverVariable;
                        } else {
                            str2 = str2 + variableValue + " " + solverVariable;
                        }
                        z = true;
                    } else if (i > 0) {
                        str2 = str2 + " + ";
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    } else {
                        str2 = str2 + " - ";
                        variableValue *= -1.0f;
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
            if (!z) {
                return str2 + "0.0";
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048609, this, linearSystem, solverVariable, z) != null) || !solverVariable.isSynonym) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue += solverVariable.synonymDelta * f;
        this.variables.remove(solverVariable, z);
        if (z) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f, z);
        if (LinearSystem.SIMPLIFY_SYNONYMS && solverVariable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }
}
