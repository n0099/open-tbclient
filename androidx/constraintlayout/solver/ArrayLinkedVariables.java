package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.PrintStream;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean FULL_NEW_CHECK = false;
    public static final int NONE = -1;
    public static float epsilon = 0.001f;
    public transient /* synthetic */ FieldHolder $fh;
    public int ROW_SIZE;
    public SolverVariable candidate;
    public int currentSize;
    public int[] mArrayIndices;
    public int[] mArrayNextIndices;
    public float[] mArrayValues;
    public final Cache mCache;
    public boolean mDidFillOnce;
    public int mHead;
    public int mLast;
    public final ArrayRow mRow;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1808085656, "Landroidx/constraintlayout/solver/ArrayLinkedVariables;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1808085656, "Landroidx/constraintlayout/solver/ArrayLinkedVariables;");
        }
    }

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayRow, cache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{solverVariable, Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            float f2 = epsilon;
            if (f <= (-f2) || f >= f2) {
                int i = this.mHead;
                if (i == -1) {
                    this.mHead = 0;
                    this.mArrayValues[0] = f;
                    this.mArrayIndices[0] = solverVariable.id;
                    this.mArrayNextIndices[0] = -1;
                    solverVariable.usageInRowCount++;
                    solverVariable.addToRow(this.mRow);
                    this.currentSize++;
                    if (this.mDidFillOnce) {
                        return;
                    }
                    int i2 = this.mLast + 1;
                    this.mLast = i2;
                    int[] iArr = this.mArrayIndices;
                    if (i2 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                int i3 = -1;
                for (int i4 = 0; i != -1 && i4 < this.currentSize; i4++) {
                    int[] iArr2 = this.mArrayIndices;
                    int i5 = iArr2[i];
                    int i6 = solverVariable.id;
                    if (i5 == i6) {
                        float f3 = this.mArrayValues[i] + f;
                        float f4 = epsilon;
                        if (f3 > (-f4) && f3 < f4) {
                            f3 = 0.0f;
                        }
                        this.mArrayValues[i] = f3;
                        if (f3 == 0.0f) {
                            if (i == this.mHead) {
                                this.mHead = this.mArrayNextIndices[i];
                            } else {
                                int[] iArr3 = this.mArrayNextIndices;
                                iArr3[i3] = iArr3[i];
                            }
                            if (z) {
                                solverVariable.removeFromRow(this.mRow);
                            }
                            if (this.mDidFillOnce) {
                                this.mLast = i;
                            }
                            solverVariable.usageInRowCount--;
                            this.currentSize--;
                            return;
                        }
                        return;
                    }
                    if (iArr2[i] < i6) {
                        i3 = i;
                    }
                    i = this.mArrayNextIndices[i];
                }
                int i7 = this.mLast;
                int i8 = i7 + 1;
                if (this.mDidFillOnce) {
                    int[] iArr4 = this.mArrayIndices;
                    if (iArr4[i7] != -1) {
                        i7 = iArr4.length;
                    }
                } else {
                    i7 = i8;
                }
                int[] iArr5 = this.mArrayIndices;
                if (i7 >= iArr5.length && this.currentSize < iArr5.length) {
                    int i9 = 0;
                    while (true) {
                        int[] iArr6 = this.mArrayIndices;
                        if (i9 >= iArr6.length) {
                            break;
                        } else if (iArr6[i9] == -1) {
                            i7 = i9;
                            break;
                        } else {
                            i9++;
                        }
                    }
                }
                int[] iArr7 = this.mArrayIndices;
                if (i7 >= iArr7.length) {
                    i7 = iArr7.length;
                    int i10 = this.ROW_SIZE * 2;
                    this.ROW_SIZE = i10;
                    this.mDidFillOnce = false;
                    this.mLast = i7 - 1;
                    this.mArrayValues = Arrays.copyOf(this.mArrayValues, i10);
                    this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                    this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
                }
                this.mArrayIndices[i7] = solverVariable.id;
                this.mArrayValues[i7] = f;
                if (i3 != -1) {
                    int[] iArr8 = this.mArrayNextIndices;
                    iArr8[i7] = iArr8[i3];
                    iArr8[i3] = i7;
                } else {
                    this.mArrayNextIndices[i7] = this.mHead;
                    this.mHead = i7;
                }
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    this.mLast++;
                }
                int i11 = this.mLast;
                int[] iArr9 = this.mArrayIndices;
                if (i11 >= iArr9.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr9.length - 1;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable != null) {
                    solverVariable.removeFromRow(this.mRow);
                }
                i = this.mArrayNextIndices[i];
            }
            this.mHead = -1;
            this.mLast = -1;
            this.mDidFillOnce = false;
            this.currentSize = 0;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, solverVariable)) == null) {
            int i = this.mHead;
            if (i == -1) {
                return false;
            }
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    return true;
                }
                i = this.mArrayNextIndices[i];
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.currentSize;
            System.out.print("{ ");
            for (int i2 = 0; i2 < i; i2++) {
                SolverVariable variable = getVariable(i2);
                if (variable != null) {
                    PrintStream printStream = System.out;
                    printStream.print(variable + " = " + getVariableValue(i2) + " ");
                }
            }
            System.out.println(" }");
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] / f;
                i = this.mArrayNextIndices[i];
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, solverVariable)) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    return this.mArrayValues[i];
                }
                i = this.mArrayNextIndices[i];
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.currentSize : invokeV.intValue;
    }

    public int getHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mHead : invokeV.intValue;
    }

    public final int getId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.mArrayIndices[i] : invokeI.intValue;
    }

    public final int getNextIndice(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.mArrayNextIndices[i] : invokeI.intValue;
    }

    public SolverVariable getPivotCandidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SolverVariable solverVariable = this.candidate;
            if (solverVariable == null) {
                int i = this.mHead;
                SolverVariable solverVariable2 = null;
                for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                    if (this.mArrayValues[i] < 0.0f) {
                        SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                        if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                            solverVariable2 = solverVariable3;
                        }
                    }
                    i = this.mArrayNextIndices[i];
                }
                return solverVariable2;
            }
            return solverVariable;
        }
        return (SolverVariable) invokeV.objValue;
    }

    public final float getValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this.mArrayValues[i] : invokeI.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int i2 = this.mHead;
            for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
                if (i3 == i) {
                    return this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
                }
                i2 = this.mArrayNextIndices[i2];
            }
            return null;
        }
        return (SolverVariable) invokeI.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            int i2 = this.mHead;
            for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
                if (i3 == i) {
                    return this.mArrayValues[i2];
                }
                i2 = this.mArrayNextIndices[i2];
            }
            return 0.0f;
        }
        return invokeI.floatValue;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                if (this.mArrayValues[i] > 0.0f) {
                    return true;
                }
                i = this.mArrayNextIndices[i];
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, solverVariable)) == null) {
            int i = this.mHead;
            if (i == -1) {
                return -1;
            }
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    return i;
                }
                i = this.mArrayNextIndices[i];
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] * (-1.0f);
                i = this.mArrayNextIndices[i];
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048593, this, solverVariable, f) == null) {
            if (f == 0.0f) {
                remove(solverVariable, true);
                return;
            }
            int i = this.mHead;
            if (i == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i2 = this.mLast + 1;
                this.mLast = i2;
                int[] iArr = this.mArrayIndices;
                if (i2 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.currentSize; i4++) {
                int[] iArr2 = this.mArrayIndices;
                int i5 = iArr2[i];
                int i6 = solverVariable.id;
                if (i5 == i6) {
                    this.mArrayValues[i] = f;
                    return;
                }
                if (iArr2[i] < i6) {
                    i3 = i;
                }
                i = this.mArrayNextIndices[i];
            }
            int i7 = this.mLast;
            int i8 = i7 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i7] != -1) {
                    i7 = iArr3.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i7 >= iArr4.length && this.currentSize < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i9 >= iArr5.length) {
                        break;
                    } else if (iArr5[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i7 >= iArr6.length) {
                i7 = iArr6.length;
                int i10 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i10;
                this.mDidFillOnce = false;
                this.mLast = i7 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i10);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i7] = solverVariable.id;
            this.mArrayValues[i7] = f;
            if (i3 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i7] = iArr7[i3];
                iArr7[i3] = i7;
            } else {
                this.mArrayNextIndices[i7] = this.mHead;
                this.mHead = i7;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.currentSize >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
            }
            int i11 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i11 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, solverVariable, z)) == null) {
            if (this.candidate == solverVariable) {
                this.candidate = null;
            }
            int i = this.mHead;
            if (i == -1) {
                return 0.0f;
            }
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.currentSize) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    if (i == this.mHead) {
                        this.mHead = this.mArrayNextIndices[i];
                    } else {
                        int[] iArr = this.mArrayNextIndices;
                        iArr[i3] = iArr[i];
                    }
                    if (z) {
                        solverVariable.removeFromRow(this.mRow);
                    }
                    solverVariable.usageInRowCount--;
                    this.currentSize--;
                    this.mArrayIndices[i] = -1;
                    if (this.mDidFillOnce) {
                        this.mLast = i;
                    }
                    return this.mArrayValues[i];
                }
                i2++;
                i3 = i;
                i = this.mArrayNextIndices[i];
            }
            return 0.0f;
        }
        return invokeLZ.floatValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.mArrayIndices.length * 4 * 3) + 0 + 36 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i = this.mHead;
            String str = "";
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                str = ((str + LoadErrorCode.TOKEN_NEXT) + this.mArrayValues[i] + ZeusCrashHandler.NAME_SEPERATOR) + this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                i = this.mArrayNextIndices[i];
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, arrayRow, z)) == null) {
            float f = get(arrayRow.variable);
            remove(arrayRow.variable, z);
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                SolverVariable variable = arrayRowVariables.getVariable(i);
                add(variable, arrayRowVariables.get(variable) * f, z);
            }
            return f;
        }
        return invokeLZ.floatValue;
    }
}
