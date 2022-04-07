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
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final float epsilon = 0.001f;
    public transient /* synthetic */ FieldHolder $fh;
    public float constantValue;
    public boolean isSimpleDefinition;
    public boolean used;
    public SolverVariable variable;
    public final ArrayLinkedVariables variables;

    public ArrayRow(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache};
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
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, cache);
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

    public boolean chooseSubject(LinearSystem linearSystem) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, linearSystem)) == null) {
            SolverVariable chooseSubject = this.variables.chooseSubject(linearSystem);
            if (chooseSubject == null) {
                z = true;
            } else {
                pivot(chooseSubject);
                z = false;
            }
            if (this.variables.currentSize == 0) {
                this.isSimpleDefinition = true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.variables.clear();
            this.variable = null;
            this.constantValue = 0.0f;
        }
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i), Float.valueOf(f), solverVariable3, solverVariable4, Integer.valueOf(i2)})) == null) {
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
                this.variables.put(solverVariable3, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.constantValue = i2;
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

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, solverVariable, i)) == null) {
            this.variable = solverVariable;
            float f = i;
            solverVariable.computedValue = f;
            this.constantValue = f;
            this.isSimpleDefinition = true;
            return this;
        }
        return (ArrayRow) invokeLI.objValue;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{solverVariable, solverVariable2, solverVariable3, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f - f);
            this.variables.put(solverVariable3, f);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, f);
            this.variables.put(solverVariable4, -f);
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), solverVariable, Integer.valueOf(i), solverVariable2, Integer.valueOf(i2), solverVariable3, Integer.valueOf(i3), solverVariable4, Integer.valueOf(i4)})) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), solverVariable, solverVariable2, solverVariable3, solverVariable4})) == null) {
            this.constantValue = 0.0f;
            if (f2 == 0.0f || f == f3) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, 1.0f);
                this.variables.put(solverVariable3, -1.0f);
            } else if (f == 0.0f) {
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
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, solverVariable, i)) == null) {
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

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048590, this, solverVariable, solverVariable2, solverVariable3, i)) == null) {
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

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f)})) == null) {
            this.variables.put(solverVariable3, 0.5f);
            this.variables.put(solverVariable4, 0.5f);
            this.variables.put(solverVariable, -0.5f);
            this.variables.put(solverVariable2, -0.5f);
            this.constantValue = -f;
            return this;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public void ensurePositiveConstant() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.variable : (SolverVariable) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, linearSystem, zArr)) == null) ? this.variables.getPivotCandidate(zArr, null) : (SolverVariable) invokeLL.objValue;
    }

    public boolean hasKeyVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SolverVariable solverVariable = this.variable;
            return solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
        }
        return invokeV.booleanValue;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, solverVariable)) == null) ? this.variables.containsKey(solverVariable) : invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, row) != null) || !(row instanceof ArrayRow)) {
            return;
        }
        ArrayRow arrayRow = (ArrayRow) row;
        this.variable = null;
        this.variables.clear();
        int i = 0;
        while (true) {
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
            if (i >= arrayLinkedVariables.currentSize) {
                return;
            }
            this.variables.add(arrayLinkedVariables.getVariable(i), arrayRow.variables.getVariableValue(i), true);
            i++;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.variable == null && this.constantValue == 0.0f && this.variables.currentSize == 0 : invokeV.booleanValue;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, solverVariable)) == null) ? this.variables.getPivotCandidate(null, solverVariable) : (SolverVariable) invokeL.objValue;
    }

    public void pivot(SolverVariable solverVariable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, solverVariable) == null) {
            SolverVariable solverVariable2 = this.variable;
            if (solverVariable2 != null) {
                this.variables.put(solverVariable2, -1.0f);
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
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.variable = null;
            this.variables.clear();
            this.constantValue = 0.0f;
            this.isSimpleDefinition = false;
        }
    }

    public int sizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (this.variable != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toReadableString() {
        InterceptResult invokeV;
        boolean z;
        float variableValue;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            String str = (this.variable == null ? "0" : "" + this.variable) + " = ";
            if (this.constantValue != 0.0f) {
                str = str + this.constantValue;
                z = true;
            } else {
                z = false;
            }
            int i2 = this.variables.currentSize;
            for (int i3 = 0; i3 < i2; i3++) {
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
                    } else if (i > 0) {
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
            return str + "0.0";
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? toReadableString() : (String) invokeV.objValue;
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

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048588, this, solverVariable, solverVariable2, i)) == null) {
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

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i, SolverVariable solverVariable2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048589, this, solverVariable, i, solverVariable2)) == null) {
            this.constantValue = i;
            this.variables.put(solverVariable, -1.0f);
            return this;
        }
        return (ArrayRow) invokeLIL.objValue;
    }
}
