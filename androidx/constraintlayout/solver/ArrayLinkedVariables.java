package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public class ArrayLinkedVariables {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean FULL_NEW_CHECK = false;
    public static final int NONE = -1;
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

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayRow, cache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, solverVariable, linearSystem)) == null) ? solverVariable.usageInRowCount <= 1 : invokeLL.booleanValue;
    }

    public final void add(SolverVariable solverVariable, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{solverVariable, Float.valueOf(f2), Boolean.valueOf(z)}) == null) || f2 == 0.0f) {
            return;
        }
        int i = this.mHead;
        if (i == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f2;
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
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] + f2;
                if (fArr[i] == 0.0f) {
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
        this.mArrayValues[i7] = f2;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SolverVariable chooseSubject(LinearSystem linearSystem) {
        InterceptResult invokeL;
        boolean isNew;
        boolean isNew2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearSystem)) == null) {
            int i = this.mHead;
            SolverVariable solverVariable = null;
            SolverVariable solverVariable2 = null;
            boolean z = false;
            boolean z2 = false;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                float[] fArr = this.mArrayValues;
                float f4 = fArr[i];
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (f4 < 0.0f) {
                    if (f4 > -0.001f) {
                        fArr[i] = 0.0f;
                        solverVariable3.removeFromRow(this.mRow);
                        f4 = 0.0f;
                    }
                    if (f4 != 0.0f) {
                        if (solverVariable3.mType == SolverVariable.Type.UNRESTRICTED) {
                            if (solverVariable2 == null) {
                                isNew2 = isNew(solverVariable3, linearSystem);
                            } else if (f2 > f4) {
                                isNew2 = isNew(solverVariable3, linearSystem);
                            } else if (!z && isNew(solverVariable3, linearSystem)) {
                                f2 = f4;
                                solverVariable2 = solverVariable3;
                                z = true;
                            }
                            z = isNew2;
                            f2 = f4;
                            solverVariable2 = solverVariable3;
                        } else if (solverVariable2 == null && f4 < 0.0f) {
                            if (solverVariable == null) {
                                isNew = isNew(solverVariable3, linearSystem);
                            } else if (f3 > f4) {
                                isNew = isNew(solverVariable3, linearSystem);
                            } else if (!z2 && isNew(solverVariable3, linearSystem)) {
                                f3 = f4;
                                solverVariable = solverVariable3;
                                z2 = true;
                            }
                            z2 = isNew;
                            f3 = f4;
                            solverVariable = solverVariable3;
                        }
                    }
                    i = this.mArrayNextIndices[i];
                } else {
                    if (f4 < 0.001f) {
                        fArr[i] = 0.0f;
                        solverVariable3.removeFromRow(this.mRow);
                        f4 = 0.0f;
                    }
                    if (f4 != 0.0f) {
                    }
                    i = this.mArrayNextIndices[i];
                }
            }
            return solverVariable2 != null ? solverVariable2 : solverVariable;
        }
        return (SolverVariable) invokeL.objValue;
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    public final boolean containsKey(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, solverVariable)) == null) {
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

    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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

    public void divideByAmount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] / f2;
                i = this.mArrayNextIndices[i];
            }
        }
    }

    public final float get(SolverVariable solverVariable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, solverVariable)) == null) {
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

    public SolverVariable getPivotCandidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

    public final SolverVariable getVariable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
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

    public final float getVariableValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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

    public void invert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = this.mHead;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] * (-1.0f);
                i = this.mArrayNextIndices[i];
            }
        }
    }

    public final void put(SolverVariable solverVariable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, solverVariable, f2) == null) {
            if (f2 == 0.0f) {
                remove(solverVariable, true);
                return;
            }
            int i = this.mHead;
            if (i == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f2;
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
                    this.mArrayValues[i] = f2;
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
            this.mArrayValues[i7] = f2;
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

    public final float remove(SolverVariable solverVariable, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, solverVariable, z)) == null) {
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

    public int sizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.mArrayIndices.length * 4 * 3) + 0 + 36 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, arrayRow, arrayRow2, z) == null) {
            int i = this.mHead;
            while (true) {
                for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                    int i3 = this.mArrayIndices[i];
                    SolverVariable solverVariable = arrayRow2.variable;
                    if (i3 == solverVariable.id) {
                        float f2 = this.mArrayValues[i];
                        remove(solverVariable, z);
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                        int i4 = arrayLinkedVariables.mHead;
                        for (int i5 = 0; i4 != -1 && i5 < arrayLinkedVariables.currentSize; i5++) {
                            add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i4]], arrayLinkedVariables.mArrayValues[i4] * f2, z);
                            i4 = arrayLinkedVariables.mArrayNextIndices[i4];
                        }
                        arrayRow.constantValue += arrayRow2.constantValue * f2;
                        if (z) {
                            arrayRow2.variable.removeFromRow(arrayRow);
                        }
                        i = this.mHead;
                    } else {
                        i = this.mArrayNextIndices[i];
                    }
                }
                return;
            }
        }
    }

    public void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, arrayRow, arrayRowArr) == null) {
            int i = this.mHead;
            while (true) {
                for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                    SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                    if (solverVariable.definitionId != -1) {
                        float f2 = this.mArrayValues[i];
                        remove(solverVariable, true);
                        ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                        if (!arrayRow2.isSimpleDefinition) {
                            ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                            int i3 = arrayLinkedVariables.mHead;
                            for (int i4 = 0; i3 != -1 && i4 < arrayLinkedVariables.currentSize; i4++) {
                                add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f2, true);
                                i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                            }
                        }
                        arrayRow.constantValue += arrayRow2.constantValue * f2;
                        arrayRow2.variable.removeFromRow(arrayRow);
                        i = this.mHead;
                    } else {
                        i = this.mArrayNextIndices[i];
                    }
                }
                return;
            }
        }
    }

    public SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        InterceptResult invokeLL;
        SolverVariable.Type type;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zArr, solverVariable)) == null) {
            int i = this.mHead;
            SolverVariable solverVariable2 = null;
            float f2 = 0.0f;
            for (int i2 = 0; i != -1 && i2 < this.currentSize; i2++) {
                if (this.mArrayValues[i] < 0.0f) {
                    SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                    if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && ((type = solverVariable3.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR)) {
                        float f3 = this.mArrayValues[i];
                        if (f3 < f2) {
                            solverVariable2 = solverVariable3;
                            f2 = f3;
                        }
                    }
                }
                i = this.mArrayNextIndices[i];
            }
            return solverVariable2;
        }
        return (SolverVariable) invokeLL.objValue;
    }
}
