package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
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
        void add(SolverVariable solverVariable, float f2, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f2);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i2);

        float getVariableValue(int i2);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f2);

        float remove(SolverVariable solverVariable, boolean z);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
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
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList<>();
        this.isSimpleDefinition = false;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, solverVariable, linearSystem)) == null) ? solverVariable.usageInRowCount <= 1 : invokeLL.booleanValue;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        InterceptResult invokeLL;
        SolverVariable.Type type;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, zArr, solverVariable)) == null) {
            int currentSize = this.variables.getCurrentSize();
            SolverVariable solverVariable2 = null;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < currentSize; i2++) {
                float variableValue = this.variables.getVariableValue(i2);
                if (variableValue < 0.0f) {
                    SolverVariable variable = this.variables.getVariable(i2);
                    if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f2)) {
                        f2 = variableValue;
                        solverVariable2 = variable;
                    }
                }
            }
            return solverVariable2;
        }
        return (SolverVariable) invokeLL.objValue;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, linearSystem, i2)) == null) {
            this.variables.put(linearSystem.createErrorVariable(i2, "ep"), 1.0f);
            this.variables.put(linearSystem.createErrorVariable(i2, "em"), -1.0f);
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, solverVariable, i2)) == null) {
            this.variables.put(solverVariable, i2);
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
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
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i2 < currentSize; i2++) {
                float variableValue = this.variables.getVariableValue(i2);
                SolverVariable variable = this.variables.getVariable(i2);
                if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable == null) {
                        isNew2 = isNew(variable, linearSystem);
                    } else if (f2 > variableValue) {
                        isNew2 = isNew(variable, linearSystem);
                    } else if (!z && isNew(variable, linearSystem)) {
                        f2 = variableValue;
                        solverVariable = variable;
                        z = true;
                    }
                    z = isNew2;
                    f2 = variableValue;
                    solverVariable = variable;
                } else if (solverVariable == null && variableValue < 0.0f) {
                    if (solverVariable2 == null) {
                        isNew = isNew(variable, linearSystem);
                    } else if (f3 > variableValue) {
                        isNew = isNew(variable, linearSystem);
                    } else if (!z2 && isNew(variable, linearSystem)) {
                        f3 = variableValue;
                        solverVariable2 = variable;
                        z2 = true;
                    }
                    z2 = isNew;
                    f3 = variableValue;
                    solverVariable2 = variable;
                }
            }
            return solverVariable != null ? solverVariable : solverVariable2;
        }
        return (SolverVariable) invokeL.objValue;
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

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i2), Float.valueOf(f2), solverVariable3, solverVariable4, Integer.valueOf(i3)})) == null) {
            if (solverVariable2 == solverVariable3) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable2, -2.0f);
                return this;
            }
            if (f2 == 0.5f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable3, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                if (i2 > 0 || i3 > 0) {
                    this.constantValue = (-i2) + i3;
                }
            } else if (f2 <= 0.0f) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.constantValue = i2;
            } else if (f2 >= 1.0f) {
                this.variables.put(solverVariable4, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
                this.constantValue = -i3;
            } else {
                float f3 = 1.0f - f2;
                this.variables.put(solverVariable, f3 * 1.0f);
                this.variables.put(solverVariable2, f3 * (-1.0f));
                this.variables.put(solverVariable3, (-1.0f) * f2);
                this.variables.put(solverVariable4, 1.0f * f2);
                if (i2 > 0 || i3 > 0) {
                    this.constantValue = ((-i2) * f3) + (i3 * f2);
                }
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, solverVariable, i2)) == null) {
            this.variable = solverVariable;
            float f2 = i2;
            solverVariable.computedValue = f2;
            this.constantValue = f2;
            this.isSimpleDefinition = true;
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{solverVariable, solverVariable2, Float.valueOf(f2)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, f2);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f2)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, f2);
            this.variables.put(solverVariable4, -f2);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEqualDimension(float f2, float f3, float f4, SolverVariable solverVariable, int i2, SolverVariable solverVariable2, int i3, SolverVariable solverVariable3, int i4, SolverVariable solverVariable4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), solverVariable, Integer.valueOf(i2), solverVariable2, Integer.valueOf(i3), solverVariable3, Integer.valueOf(i4), solverVariable4, Integer.valueOf(i5)})) == null) {
            if (f3 != 0.0f && f2 != f4) {
                float f5 = (f2 / f3) / (f4 / f3);
                this.constantValue = ((-i2) - i3) + (i4 * f5) + (i5 * f5);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f5);
                this.variables.put(solverVariable3, -f5);
            } else {
                this.constantValue = ((-i2) - i3) + i4 + i5;
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEqualMatchDimensions(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), solverVariable, solverVariable2, solverVariable3, solverVariable4})) == null) {
            this.constantValue = 0.0f;
            if (f3 == 0.0f || f2 == f4) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            } else if (f2 == 0.0f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            } else if (f4 == 0.0f) {
                this.variables.put(solverVariable3, 1.0f);
                this.variables.put(solverVariable4, -1.0f);
            } else {
                float f5 = (f2 / f3) / (f4 / f3);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f5);
                this.variables.put(solverVariable3, -f5);
            }
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, solverVariable, i2)) == null) {
            if (i2 < 0) {
                this.constantValue = i2 * (-1);
                this.variables.put(solverVariable, 1.0f);
            } else {
                this.constantValue = i2;
                this.variables.put(solverVariable, -1.0f);
            }
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048591, this, solverVariable, solverVariable2, solverVariable3, i2)) == null) {
            boolean z = false;
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 *= -1;
                    z = true;
                }
                this.constantValue = i2;
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

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048592, this, solverVariable, solverVariable2, solverVariable3, i2)) == null) {
            boolean z = false;
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 *= -1;
                    z = true;
                }
                this.constantValue = i2;
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

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f2)})) == null) {
            this.variables.put(solverVariable3, 0.5f);
            this.variables.put(solverVariable4, 0.5f);
            this.variables.put(solverVariable, -0.5f);
            this.variables.put(solverVariable2, -0.5f);
            this.constantValue = -f2;
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public void ensurePositiveConstant() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            float f2 = this.constantValue;
            if (f2 < 0.0f) {
                this.constantValue = f2 * (-1.0f);
                this.variables.invert();
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.variable : (SolverVariable) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, linearSystem, zArr)) == null) ? pickPivotInVariables(zArr, null) : (SolverVariable) invokeLL.objValue;
    }

    public boolean hasKeyVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SolverVariable solverVariable = this.variable;
            return solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
        }
        return invokeV.booleanValue;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, solverVariable)) == null) ? this.variables.contains(solverVariable) : invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, row) == null) && (row instanceof ArrayRow)) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i2 = 0; i2 < arrayRow.variables.getCurrentSize(); i2++) {
                this.variables.add(arrayRow.variables.getVariable(i2), arrayRow.variables.getVariableValue(i2), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0 : invokeV.booleanValue;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, solverVariable)) == null) ? pickPivotInVariables(null, solverVariable) : (SolverVariable) invokeL.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return (this.variable != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toReadableString() {
        InterceptResult invokeV;
        boolean z;
        float variableValue;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String str = (this.variable == null ? "0" : "" + this.variable) + " = ";
            if (this.constantValue != 0.0f) {
                str = str + this.constantValue;
                z = true;
            } else {
                z = false;
            }
            int currentSize = this.variables.getCurrentSize();
            for (int i3 = 0; i3 < currentSize; i3++) {
                SolverVariable variable = this.variables.getVariable(i3);
                if (variable != null && (this.variables.getVariableValue(i3)) != 0.0f) {
                    String solverVariable = variable.toString();
                    if (!z) {
                        if (variableValue < 0.0f) {
                            str = str + "- ";
                            variableValue *= -1.0f;
                        }
                        str = variableValue == 1.0f ? str + solverVariable : str + variableValue + " " + solverVariable;
                        z = true;
                    } else if (i2 > 0) {
                        str = str + " + ";
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    } else {
                        str = str + " - ";
                        variableValue *= -1.0f;
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                return str;
            }
            return str + XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? toReadableString() : (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048607, this, linearSystem, solverVariable, z) == null) && solverVariable.isFinalValue) {
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

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048609, this, linearSystem, solverVariable, z) == null) && solverVariable.isSynonym) {
            float f2 = this.variables.get(solverVariable);
            this.constantValue += solverVariable.synonymDelta * f2;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f2, z);
            if (LinearSystem.SIMPLIFY_SYNONYMS && solverVariable != null && this.variables.getCurrentSize() == 0) {
                this.isSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, linearSystem) == null) || linearSystem.mRows.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.variables.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                SolverVariable variable = this.variables.getVariable(i2);
                if (variable.definitionId != -1 || variable.isFinalValue || variable.isSynonym) {
                    this.variablesToUpdate.add(variable);
                }
            }
            int size = this.variablesToUpdate.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    SolverVariable solverVariable = this.variablesToUpdate.get(i3);
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
    public void addError(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, solverVariable) == null) {
            int i2 = solverVariable.strength;
            float f2 = 1.0f;
            if (i2 != 1) {
                if (i2 == 2) {
                    f2 = 1000.0f;
                } else if (i2 == 3) {
                    f2 = 1000000.0f;
                } else if (i2 == 4) {
                    f2 = 1.0E9f;
                } else if (i2 == 5) {
                    f2 = 1.0E12f;
                }
            }
            this.variables.put(solverVariable, f2);
        }
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, solverVariable, solverVariable2, i2)) == null) {
            boolean z = false;
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 *= -1;
                    z = true;
                }
                this.constantValue = i2;
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

    public ArrayRow(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i2, SolverVariable solverVariable2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048590, this, solverVariable, i2, solverVariable2)) == null) {
            this.constantValue = i2;
            this.variables.put(solverVariable, -1.0f);
            return this;
        }
        return (ArrayRow) invokeLIL.objValue;
    }
}
