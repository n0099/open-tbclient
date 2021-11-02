package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.Arrays;
/* loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean HASH = true;
    public static float epsilon = 0.001f;
    public transient /* synthetic */ FieldHolder $fh;
    public int HASH_SIZE;
    public final int NONE;
    public int SIZE;
    public int head;
    public int[] keys;
    public final Cache mCache;
    public int mCount;
    public final ArrayRow mRow;
    public int[] next;
    public int[] nextKeys;
    public int[] previous;
    public float[] values;
    public int[] variables;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1644144388, "Landroidx/constraintlayout/solver/SolverVariableValues;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1644144388, "Landroidx/constraintlayout/solver/SolverVariableValues;");
        }
    }

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayRow, cache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.NONE = -1;
        this.SIZE = 16;
        this.HASH_SIZE = 16;
        this.keys = new int[16];
        this.nextKeys = new int[16];
        this.variables = new int[16];
        this.values = new float[16];
        this.previous = new int[16];
        this.next = new int[16];
        this.mCount = 0;
        this.head = -1;
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i2) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, solverVariable, i2) == null) {
            int i3 = solverVariable.id % this.HASH_SIZE;
            int[] iArr2 = this.keys;
            int i4 = iArr2[i3];
            if (i4 == -1) {
                iArr2[i3] = i2;
            } else {
                while (true) {
                    iArr = this.nextKeys;
                    if (iArr[i4] == -1) {
                        break;
                    }
                    i4 = iArr[i4];
                }
                iArr[i4] = i2;
            }
            this.nextKeys[i2] = -1;
        }
    }

    private void addVariable(int i2, SolverVariable solverVariable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), solverVariable, Float.valueOf(f2)}) == null) {
            this.variables[i2] = solverVariable.id;
            this.values[i2] = f2;
            this.previous[i2] = -1;
            this.next[i2] = -1;
            solverVariable.addToRow(this.mRow);
            solverVariable.usageInRowCount++;
            this.mCount++;
        }
    }

    private void displayHash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            for (int i2 = 0; i2 < this.HASH_SIZE; i2++) {
                if (this.keys[i2] != -1) {
                    String str = hashCode() + " hash [" + i2 + "] => ";
                    int i3 = this.keys[i2];
                    boolean z = false;
                    while (!z) {
                        str = str + " " + this.variables[i3];
                        int[] iArr = this.nextKeys;
                        if (iArr[i3] != -1) {
                            i3 = iArr[i3];
                        } else {
                            z = true;
                        }
                    }
                    System.out.println(str);
                }
            }
        }
    }

    private int findEmptySlot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            for (int i2 = 0; i2 < this.SIZE; i2++) {
                if (this.variables[i2] == -1) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private void increaseSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = this.SIZE * 2;
            this.variables = Arrays.copyOf(this.variables, i2);
            this.values = Arrays.copyOf(this.values, i2);
            this.previous = Arrays.copyOf(this.previous, i2);
            this.next = Arrays.copyOf(this.next, i2);
            this.nextKeys = Arrays.copyOf(this.nextKeys, i2);
            for (int i3 = this.SIZE; i3 < i2; i3++) {
                this.variables[i3] = -1;
                this.nextKeys[i3] = -1;
            }
            this.SIZE = i2;
        }
    }

    private void insertVariable(int i2, SolverVariable solverVariable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), solverVariable, Float.valueOf(f2)}) == null) {
            int findEmptySlot = findEmptySlot();
            addVariable(findEmptySlot, solverVariable, f2);
            if (i2 != -1) {
                this.previous[findEmptySlot] = i2;
                int[] iArr = this.next;
                iArr[findEmptySlot] = iArr[i2];
                iArr[i2] = findEmptySlot;
            } else {
                this.previous[findEmptySlot] = -1;
                if (this.mCount > 0) {
                    this.next[findEmptySlot] = this.head;
                    this.head = findEmptySlot;
                } else {
                    this.next[findEmptySlot] = -1;
                }
            }
            int[] iArr2 = this.next;
            if (iArr2[findEmptySlot] != -1) {
                this.previous[iArr2[findEmptySlot]] = findEmptySlot;
            }
            addToHashMap(solverVariable, findEmptySlot);
        }
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, solverVariable) == null) || (i4 = (iArr = this.keys)[(i3 = (i2 = solverVariable.id) % this.HASH_SIZE)]) == -1) {
            return;
        }
        if (this.variables[i4] == i2) {
            int[] iArr2 = this.nextKeys;
            iArr[i3] = iArr2[i4];
            iArr2[i4] = -1;
            return;
        }
        while (true) {
            int[] iArr3 = this.nextKeys;
            if (iArr3[i4] == -1 || this.variables[iArr3[i4]] == i2) {
                break;
            }
            i4 = iArr3[i4];
        }
        int[] iArr4 = this.nextKeys;
        int i5 = iArr4[i4];
        if (i5 == -1 || this.variables[i5] != i2) {
            return;
        }
        iArr4[i4] = iArr4[i5];
        iArr4[i5] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{solverVariable, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            float f3 = epsilon;
            if (f2 <= (-f3) || f2 >= f3) {
                int indexOf = indexOf(solverVariable);
                if (indexOf == -1) {
                    put(solverVariable, f2);
                    return;
                }
                float[] fArr = this.values;
                fArr[indexOf] = fArr[indexOf] + f2;
                float f4 = fArr[indexOf];
                float f5 = epsilon;
                if (f4 <= (-f5) || fArr[indexOf] >= f5) {
                    return;
                }
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2; i3++) {
                SolverVariable variable = getVariable(i3);
                if (variable != null) {
                    variable.removeFromRow(this.mRow);
                }
            }
            for (int i4 = 0; i4 < this.SIZE; i4++) {
                this.variables[i4] = -1;
                this.nextKeys[i4] = -1;
            }
            for (int i5 = 0; i5 < this.HASH_SIZE; i5++) {
                this.keys[i5] = -1;
            }
            this.mCount = 0;
            this.head = -1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, solverVariable)) == null) ? indexOf(solverVariable) != -1 : invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.mCount;
            System.out.print("{ ");
            for (int i3 = 0; i3 < i2; i3++) {
                SolverVariable variable = getVariable(i3);
                if (variable != null) {
                    PrintStream printStream = System.out;
                    printStream.print(variable + " = " + getVariableValue(i3) + " ");
                }
            }
            System.out.println(" }");
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            int i2 = this.mCount;
            int i3 = this.head;
            for (int i4 = 0; i4 < i2; i4++) {
                float[] fArr = this.values;
                fArr[i3] = fArr[i3] / f2;
                i3 = this.next[i3];
                if (i3 == -1) {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, solverVariable)) == null) {
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                return this.values[indexOf];
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCount : invokeV.intValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = this.mCount;
            if (i3 == 0) {
                return null;
            }
            int i4 = this.head;
            for (int i5 = 0; i5 < i3; i5++) {
                if (i5 == i2 && i4 != -1) {
                    return this.mCache.mIndexedVariables[this.variables[i4]];
                }
                i4 = this.next[i4];
                if (i4 == -1) {
                    break;
                }
            }
            return null;
        }
        return (SolverVariable) invokeI.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int i3 = this.mCount;
            int i4 = this.head;
            for (int i5 = 0; i5 < i3; i5++) {
                if (i5 == i2) {
                    return this.values[i4];
                }
                i4 = this.next[i4];
                if (i4 == -1) {
                    return 0.0f;
                }
            }
            return 0.0f;
        }
        return invokeI.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, solverVariable)) == null) {
            if (this.mCount != 0 && solverVariable != null) {
                int i2 = solverVariable.id;
                int i3 = this.keys[i2 % this.HASH_SIZE];
                if (i3 == -1) {
                    return -1;
                }
                if (this.variables[i3] == i2) {
                    return i3;
                }
                while (true) {
                    int[] iArr = this.nextKeys;
                    if (iArr[i3] == -1 || this.variables[iArr[i3]] == i2) {
                        break;
                    }
                    i3 = iArr[i3];
                }
                int[] iArr2 = this.nextKeys;
                if (iArr2[i3] != -1 && this.variables[iArr2[i3]] == i2) {
                    return iArr2[i3];
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i2 = this.mCount;
            int i3 = this.head;
            for (int i4 = 0; i4 < i2; i4++) {
                float[] fArr = this.values;
                fArr[i3] = fArr[i3] * (-1.0f);
                i3 = this.next[i3];
                if (i3 == -1) {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048587, this, solverVariable, f2) == null) {
            float f3 = epsilon;
            if (f2 > (-f3) && f2 < f3) {
                remove(solverVariable, true);
                return;
            }
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f2);
                addToHashMap(solverVariable, 0);
                this.head = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.values[indexOf] = f2;
                return;
            }
            if (this.mCount + 1 >= this.SIZE) {
                increaseSize();
            }
            int i2 = this.mCount;
            int i3 = this.head;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                int[] iArr = this.variables;
                int i6 = iArr[i3];
                int i7 = solverVariable.id;
                if (i6 == i7) {
                    this.values[i3] = f2;
                    return;
                }
                if (iArr[i3] < i7) {
                    i4 = i3;
                }
                i3 = this.next[i3];
                if (i3 == -1) {
                    break;
                }
            }
            insertVariable(i4, solverVariable, f2);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, solverVariable, z)) == null) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                return 0.0f;
            }
            removeFromHashMap(solverVariable);
            float f2 = this.values[indexOf];
            if (this.head == indexOf) {
                this.head = this.next[indexOf];
            }
            this.variables[indexOf] = -1;
            int[] iArr = this.previous;
            if (iArr[indexOf] != -1) {
                int[] iArr2 = this.next;
                iArr2[iArr[indexOf]] = iArr2[indexOf];
            }
            int[] iArr3 = this.next;
            if (iArr3[indexOf] != -1) {
                int[] iArr4 = this.previous;
                iArr4[iArr3[indexOf]] = iArr4[indexOf];
            }
            this.mCount--;
            solverVariable.usageInRowCount--;
            if (z) {
                solverVariable.removeFromRow(this.mRow);
            }
            return f2;
        }
        return invokeLZ.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String str = hashCode() + " { ";
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2; i3++) {
                SolverVariable variable = getVariable(i3);
                if (variable != null) {
                    String str2 = str + variable + " = " + getVariableValue(i3) + " ";
                    int indexOf = indexOf(variable);
                    String str3 = str2 + "[p: ";
                    String str4 = (this.previous[indexOf] != -1 ? str3 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]] : str3 + "none") + ", n: ";
                    str = (this.next[indexOf] != -1 ? str4 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]] : str4 + "none") + PreferencesUtil.RIGHT_MOUNT;
                }
            }
            return str + " }";
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, arrayRow, z)) == null) {
            float f2 = get(arrayRow.variable);
            remove(arrayRow.variable, z);
            SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
            int currentSize = solverVariableValues.getCurrentSize();
            int i2 = solverVariableValues.head;
            int i3 = 0;
            int i4 = 0;
            while (i3 < currentSize) {
                int[] iArr = solverVariableValues.variables;
                if (iArr[i4] != -1) {
                    add(this.mCache.mIndexedVariables[iArr[i4]], solverVariableValues.values[i4] * f2, z);
                    i3++;
                }
                i4++;
            }
            return f2;
        }
        return invokeLZ.floatValue;
    }
}
