package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class LinearSystem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    public static int POOL_SIZE = 1000;
    public static Metrics sMetrics;
    public transient /* synthetic */ FieldHolder $fh;
    public int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean[] mAlreadyTestedCandidates;
    public final Cache mCache;
    public Row mGoal;
    public int mMaxColumns;
    public int mMaxRows;
    public int mNumColumns;
    public int mNumRows;
    public SolverVariable[] mPoolVariables;
    public int mPoolVariablesCount;
    public ArrayRow[] mRows;
    public final Row mTempGoal;
    public HashMap<String, SolverVariable> mVariables;
    public int mVariablesID;
    public ArrayRow[] tempClientsCopy;

    /* loaded from: classes.dex */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1783223463, "Landroidx/constraintlayout/solver/LinearSystem;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1783223463, "Landroidx/constraintlayout/solver/LinearSystem;");
        }
    }

    public LinearSystem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.tempClientsCopy = new ArrayRow[32];
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new GoalRow(cache);
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, type, str)) == null) {
            SolverVariable acquire = this.mCache.solverVariablePool.acquire();
            if (acquire == null) {
                acquire = new SolverVariable(type, str);
                acquire.setType(type, str);
            } else {
                acquire.reset();
                acquire.setType(type, str);
            }
            int i2 = this.mPoolVariablesCount;
            int i3 = POOL_SIZE;
            if (i2 >= i3) {
                int i4 = i3 * 2;
                POOL_SIZE = i4;
                this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i4);
            }
            SolverVariable[] solverVariableArr = this.mPoolVariables;
            int i5 = this.mPoolVariablesCount;
            this.mPoolVariablesCount = i5 + 1;
            solverVariableArr[i5] = acquire;
            return acquire;
        }
        return (SolverVariable) invokeLL.objValue;
    }

    private void addError(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, arrayRow) == null) {
            arrayRow.addError(this, 0);
        }
    }

    private final void addRow(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, arrayRow) == null) {
            ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            if (arrayRowArr[i2] != null) {
                this.mCache.arrayRowPool.release(arrayRowArr[i2]);
            }
            ArrayRow[] arrayRowArr2 = this.mRows;
            int i3 = this.mNumRows;
            arrayRowArr2[i3] = arrayRow;
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i3;
            this.mNumRows = i3 + 1;
            solverVariable.updateReferencesWithNewDefinition(arrayRow);
        }
    }

    private void addSingleError(ArrayRow arrayRow, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, arrayRow, i2) == null) {
            addSingleError(arrayRow, i2, 0);
        }
    }

    private void computeValues() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                ArrayRow arrayRow = this.mRows[i2];
                arrayRow.variable.computedValue = arrayRow.constantValue;
            }
        }
    }

    public static ArrayRow createRowCentering(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{linearSystem, solverVariable, solverVariable2, Integer.valueOf(i2), Float.valueOf(f2), solverVariable3, solverVariable4, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ArrayRow createRow = linearSystem.createRow();
            createRow.createRowCentering(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
            if (z) {
                createRow.addError(linearSystem, 4);
            }
            return createRow;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{linearSystem, solverVariable, solverVariable2, solverVariable3, Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            ArrayRow createRow = linearSystem.createRow();
            if (z) {
                linearSystem.addError(createRow);
            }
            return createRow.createRowDimensionPercent(solverVariable, solverVariable2, solverVariable3, f2);
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public static ArrayRow createRowEquals(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{linearSystem, solverVariable, solverVariable2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayRow createRow = linearSystem.createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i2);
            if (z) {
                linearSystem.addSingleError(createRow, 1);
            }
            return createRow;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public static ArrayRow createRowGreaterThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{linearSystem, solverVariable, solverVariable2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SolverVariable createSlackVariable = linearSystem.createSlackVariable();
            ArrayRow createRow = linearSystem.createRow();
            createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (z) {
                linearSystem.addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
            }
            return createRow;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    public static ArrayRow createRowLowerThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{linearSystem, solverVariable, solverVariable2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SolverVariable createSlackVariable = linearSystem.createSlackVariable();
            ArrayRow createRow = linearSystem.createRow();
            createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (z) {
                linearSystem.addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
            }
            return createRow;
        }
        return (ArrayRow) invokeCommon.objValue;
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, type)) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.variables++;
            }
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
            acquireSolverVariable.setName(str);
            int i2 = this.mVariablesID + 1;
            this.mVariablesID = i2;
            this.mNumColumns++;
            acquireSolverVariable.id = i2;
            if (this.mVariables == null) {
                this.mVariables = new HashMap<>();
            }
            this.mVariables.put(str, acquireSolverVariable);
            this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
            return acquireSolverVariable;
        }
        return (SolverVariable) invokeLL.objValue;
    }

    private void displayRows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            displaySolverVariables();
            String str = "";
            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                str = (str + this.mRows[i2]) + StringUtils.LF;
            }
            System.out.println(str + this.mGoal + StringUtils.LF);
        }
    }

    private void displaySolverVariables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
        }
    }

    private int enforceBFS(Row row) throws Exception {
        InterceptResult invokeL;
        float f2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, row)) == null) {
            int i2 = 0;
            while (true) {
                f2 = 0.0f;
                if (i2 >= this.mNumRows) {
                    z = false;
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i2].variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i2].constantValue < 0.0f) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                boolean z2 = false;
                int i3 = 0;
                while (!z2) {
                    Metrics metrics = sMetrics;
                    if (metrics != null) {
                        metrics.bfs++;
                    }
                    i3++;
                    float f3 = Float.MAX_VALUE;
                    int i4 = 0;
                    int i5 = -1;
                    int i6 = -1;
                    int i7 = 0;
                    while (i4 < this.mNumRows) {
                        ArrayRow arrayRow = this.mRows[i4];
                        if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < f2) {
                            int i8 = 1;
                            while (i8 < this.mNumColumns) {
                                SolverVariable solverVariable = this.mCache.mIndexedVariables[i8];
                                float f4 = arrayRow.variables.get(solverVariable);
                                if (f4 > f2) {
                                    for (int i9 = 0; i9 < 7; i9++) {
                                        float f5 = solverVariable.strengthVector[i9] / f4;
                                        if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                            i6 = i8;
                                            i7 = i9;
                                            f3 = f5;
                                            i5 = i4;
                                        }
                                    }
                                }
                                i8++;
                                f2 = 0.0f;
                            }
                        }
                        i4++;
                        f2 = 0.0f;
                    }
                    if (i5 != -1) {
                        ArrayRow arrayRow2 = this.mRows[i5];
                        arrayRow2.variable.definitionId = -1;
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow2.pivot(this.mCache.mIndexedVariables[i6]);
                        SolverVariable solverVariable2 = arrayRow2.variable;
                        solverVariable2.definitionId = i5;
                        solverVariable2.updateReferencesWithNewDefinition(arrayRow2);
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.mNumColumns / 2) {
                        z2 = true;
                    }
                    f2 = 0.0f;
                }
                return i3;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private String getDisplaySize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) {
            int i3 = i2 * 4;
            int i4 = i3 / 1024;
            int i5 = i4 / 1024;
            if (i5 > 0) {
                return "" + i5 + " Mb";
            } else if (i4 > 0) {
                return "" + i4 + " Kb";
            } else {
                return "" + i3 + " bytes";
            }
        }
        return (String) invokeI.objValue;
    }

    private String getDisplayStrength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, this, i2)) == null) ? i2 == 1 ? "LOW" : i2 == 2 ? "MEDIUM" : i2 == 3 ? "HIGH" : i2 == 4 ? "HIGHEST" : i2 == 5 ? "EQUALITY" : i2 == 6 ? "FIXED" : "NONE" : (String) invokeI.objValue;
    }

    public static Metrics getMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? sMetrics : (Metrics) invokeV.objValue;
    }

    private void increaseTableSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            int i2 = this.TABLE_SIZE * 2;
            this.TABLE_SIZE = i2;
            this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i2);
            Cache cache = this.mCache;
            cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
            int i3 = this.TABLE_SIZE;
            this.mAlreadyTestedCandidates = new boolean[i3];
            this.mMaxColumns = i3;
            this.mMaxRows = i3;
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.tableSizeIncrease++;
                metrics.maxTableSize = Math.max(metrics.maxTableSize, i3);
                Metrics metrics2 = sMetrics;
                metrics2.lastTableSize = metrics2.maxTableSize;
            }
        }
    }

    private final int optimize(Row row, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65556, this, row, z)) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.optimize++;
            }
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                this.mAlreadyTestedCandidates[i2] = false;
            }
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.iterations++;
                }
                i3++;
                if (i3 >= this.mNumColumns * 2) {
                    return i3;
                }
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i4 = pivotCandidate.id;
                    if (zArr[i4]) {
                        return i3;
                    }
                    zArr[i4] = true;
                }
                if (pivotCandidate != null) {
                    float f2 = Float.MAX_VALUE;
                    int i5 = -1;
                    for (int i6 = 0; i6 < this.mNumRows; i6++) {
                        ArrayRow arrayRow = this.mRows[i6];
                        if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f3 = arrayRow.variables.get(pivotCandidate);
                            if (f3 < 0.0f) {
                                float f4 = (-arrayRow.constantValue) / f3;
                                if (f4 < f2) {
                                    i5 = i6;
                                    f2 = f4;
                                }
                            }
                        }
                    }
                    if (i5 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i5];
                        arrayRow2.variable.definitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.variable;
                        solverVariable.definitionId = i5;
                        solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                    }
                }
                z2 = true;
            }
            return i3;
        }
        return invokeLZ.intValue;
    }

    private void releaseRows() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65557, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (i2 >= arrayRowArr.length) {
                return;
            }
            ArrayRow arrayRow = arrayRowArr[i2];
            if (arrayRow != null) {
                this.mCache.arrayRowPool.release(arrayRow);
            }
            this.mRows[i2] = null;
            i2++;
        }
    }

    private final void updateRowFromVariables(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, arrayRow) == null) || this.mNumRows <= 0) {
            return;
        }
        arrayRow.variables.updateFromSystem(arrayRow, this.mRows);
        if (arrayRow.variables.currentSize == 0) {
            arrayRow.isSimpleDefinition = true;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{constraintWidget, constraintWidget2, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
            SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
            SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
            SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
            SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
            SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
            SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
            SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
            ArrayRow createRow = createRow();
            double d2 = f2;
            double d3 = i2;
            createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d2) * d3));
            addConstraint(createRow);
            ArrayRow createRow2 = createRow();
            createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d2) * d3));
            addConstraint(createRow2);
        }
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i2), Float.valueOf(f2), solverVariable3, solverVariable4, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            ArrayRow createRow = createRow();
            createRow.createRowCentering(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
            if (i4 != 6) {
                createRow.addError(this, i4);
            }
            addConstraint(createRow);
        }
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayRow) == null) || arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z2 = false;
        if (!arrayRow.isSimpleDefinition) {
            updateRowFromVariables(arrayRow);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                addRow(arrayRow);
                this.mTempGoal.initFromRow(arrayRow);
                optimize(this.mTempGoal, true);
                if (createExtraVariable.definitionId == -1) {
                    if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow.pivot(pickPivot);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.mNumRows--;
                }
            } else {
                z = false;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, solverVariable, solverVariable2, i2, i3)) == null) {
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i2);
            if (i3 != 6) {
                createRow.addError(this, i3);
            }
            addConstraint(createRow);
            return createRow;
        }
        return (ArrayRow) invokeLLII.objValue;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, solverVariable, solverVariable2, z) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, 0);
            if (z) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), 1);
            }
            addConstraint(createRow);
        }
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, solverVariable, solverVariable2, i2, i3) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (i3 != 6) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
            }
            addConstraint(createRow);
        }
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, solverVariable, solverVariable2, z) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, 0);
            if (z) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), 1);
            }
            addConstraint(createRow);
        }
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, solverVariable, solverVariable2, i2, i3) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (i3 != 6) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
            }
            addConstraint(createRow);
        }
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            ArrayRow createRow = createRow();
            createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
            if (i2 != 6) {
                createRow.addError(this, i2);
            }
            addConstraint(createRow);
        }
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, str)) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.errors++;
            }
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
            int i3 = this.mVariablesID + 1;
            this.mVariablesID = i3;
            this.mNumColumns++;
            acquireSolverVariable.id = i3;
            acquireSolverVariable.strength = i2;
            this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
            this.mGoal.addError(acquireSolverVariable);
            return acquireSolverVariable;
        }
        return (SolverVariable) invokeIL.objValue;
    }

    public SolverVariable createExtraVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.extravariables++;
            }
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
            int i2 = this.mVariablesID + 1;
            this.mVariablesID = i2;
            this.mNumColumns++;
            acquireSolverVariable.id = i2;
            this.mCache.mIndexedVariables[i2] = acquireSolverVariable;
            return acquireSolverVariable;
        }
        return (SolverVariable) invokeV.objValue;
    }

    public SolverVariable createObjectVariable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            SolverVariable solverVariable = null;
            if (obj == null) {
                return null;
            }
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            if (obj instanceof ConstraintAnchor) {
                ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
                solverVariable = constraintAnchor.getSolverVariable();
                if (solverVariable == null) {
                    constraintAnchor.resetSolverVariable(this.mCache);
                    solverVariable = constraintAnchor.getSolverVariable();
                }
                int i2 = solverVariable.id;
                if (i2 == -1 || i2 > this.mVariablesID || this.mCache.mIndexedVariables[i2] == null) {
                    if (solverVariable.id != -1) {
                        solverVariable.reset();
                    }
                    int i3 = this.mVariablesID + 1;
                    this.mVariablesID = i3;
                    this.mNumColumns++;
                    solverVariable.id = i3;
                    solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                    this.mCache.mIndexedVariables[i3] = solverVariable;
                }
            }
            return solverVariable;
        }
        return (SolverVariable) invokeL.objValue;
    }

    public ArrayRow createRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ArrayRow acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
            } else {
                acquire.reset();
            }
            SolverVariable.increaseErrorId();
            return acquire;
        }
        return (ArrayRow) invokeV.objValue;
    }

    public SolverVariable createSlackVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.slackvariables++;
            }
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
            int i2 = this.mVariablesID + 1;
            this.mVariablesID = i2;
            this.mNumColumns++;
            acquireSolverVariable.id = i2;
            this.mCache.mIndexedVariables[i2] = acquireSolverVariable;
            return acquireSolverVariable;
        }
        return (SolverVariable) invokeV.objValue;
    }

    public void displayReadableRows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            displaySolverVariables();
            String str = " #  ";
            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                str = (str + this.mRows[i2].toReadableString()) + "\n #  ";
            }
            if (this.mGoal != null) {
                str = str + this.mGoal + StringUtils.LF;
            }
            System.out.println(str);
        }
    }

    public void displaySystemInformations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.TABLE_SIZE; i3++) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i3] != null) {
                    i2 += arrayRowArr[i3].sizeInBytes();
                }
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.mNumRows; i5++) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (arrayRowArr2[i5] != null) {
                    i4 += arrayRowArr2[i5].sizeInBytes();
                }
            }
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Linear System -> Table size: ");
            sb.append(this.TABLE_SIZE);
            sb.append(" (");
            int i6 = this.TABLE_SIZE;
            sb.append(getDisplaySize(i6 * i6));
            sb.append(") -- row sizes: ");
            sb.append(getDisplaySize(i2));
            sb.append(", actual size: ");
            sb.append(getDisplaySize(i4));
            sb.append(" rows: ");
            sb.append(this.mNumRows);
            sb.append("/");
            sb.append(this.mMaxRows);
            sb.append(" cols: ");
            sb.append(this.mNumColumns);
            sb.append("/");
            sb.append(this.mMaxColumns);
            sb.append(" ");
            sb.append(0);
            sb.append(" occupied cells, ");
            sb.append(getDisplaySize(0));
            printStream.println(sb.toString());
        }
    }

    public void displayVariablesReadableRows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            displaySolverVariables();
            String str = "";
            for (int i2 = 0; i2 < this.mNumRows; i2++) {
                if (this.mRows[i2].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                    str = (str + this.mRows[i2].toReadableString()) + StringUtils.LF;
                }
            }
            System.out.println(str + this.mGoal + StringUtils.LF);
        }
    }

    public void fillMetrics(Metrics metrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, metrics) == null) {
            sMetrics = metrics;
        }
    }

    public Cache getCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mCache : (Cache) invokeV.objValue;
    }

    public Row getGoal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mGoal : (Row) invokeV.objValue;
    }

    public int getMemoryUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.mNumRows; i3++) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i3] != null) {
                    i2 += arrayRowArr[i3].sizeInBytes();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getNumEquations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mNumRows : invokeV.intValue;
    }

    public int getNumVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mVariablesID : invokeV.intValue;
    }

    public int getObjectVariableValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
            if (solverVariable != null) {
                return (int) (solverVariable.computedValue + 0.5f);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public ArrayRow getRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.mRows[i2] : (ArrayRow) invokeI.objValue;
    }

    public float getValueFor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
            if (variable == null) {
                return 0.0f;
            }
            return variable.computedValue;
        }
        return invokeL.floatValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, type)) == null) {
            if (this.mVariables == null) {
                this.mVariables = new HashMap<>();
            }
            SolverVariable solverVariable = this.mVariables.get(str);
            return solverVariable == null ? createVariable(str, type) : solverVariable;
        }
        return (SolverVariable) invokeLL.objValue;
    }

    public void minimize() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.minimize++;
            }
            if (this.graphOptimizer) {
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.graphOptimizer++;
                }
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mNumRows) {
                        z = true;
                        break;
                    } else if (!this.mRows[i2].isSimpleDefinition) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    minimizeGoal(this.mGoal);
                    return;
                }
                Metrics metrics3 = sMetrics;
                if (metrics3 != null) {
                    metrics3.fullySolved++;
                }
                computeValues();
                return;
            }
            minimizeGoal(this.mGoal);
        }
    }

    public void minimizeGoal(Row row) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, row) == null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.minimizeGoal++;
                metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
                Metrics metrics2 = sMetrics;
                metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
            }
            updateRowFromVariables((ArrayRow) row);
            enforceBFS(row);
            optimize(row, false);
            computeValues();
        }
    }

    public void reset() {
        Cache cache;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int i2 = 0;
            while (true) {
                cache = this.mCache;
                SolverVariable[] solverVariableArr = cache.mIndexedVariables;
                if (i2 >= solverVariableArr.length) {
                    break;
                }
                SolverVariable solverVariable = solverVariableArr[i2];
                if (solverVariable != null) {
                    solverVariable.reset();
                }
                i2++;
            }
            cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
            this.mPoolVariablesCount = 0;
            Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
            HashMap<String, SolverVariable> hashMap = this.mVariables;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.mVariablesID = 0;
            this.mGoal.clear();
            this.mNumColumns = 1;
            for (int i3 = 0; i3 < this.mNumRows; i3++) {
                this.mRows[i3].used = false;
            }
            releaseRows();
            this.mNumRows = 0;
        }
    }

    public void addSingleError(ArrayRow arrayRow, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, arrayRow, i2, i3) == null) {
            arrayRow.addSingleError(createErrorVariable(i3, null), i2);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, solverVariable, i2) == null) {
            int i3 = solverVariable.definitionId;
            if (i3 != -1) {
                ArrayRow arrayRow = this.mRows[i3];
                if (arrayRow.isSimpleDefinition) {
                    arrayRow.constantValue = i2;
                    return;
                } else if (arrayRow.variables.currentSize == 0) {
                    arrayRow.isSimpleDefinition = true;
                    arrayRow.constantValue = i2;
                    return;
                } else {
                    ArrayRow createRow = createRow();
                    createRow.createRowEquals(solverVariable, i2);
                    addConstraint(createRow);
                    return;
                }
            }
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i2);
            addConstraint(createRow2);
        }
    }

    public void addGreaterThan(SolverVariable solverVariable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, solverVariable, i2) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowGreaterThan(solverVariable, i2, createSlackVariable);
            addConstraint(createRow);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, solverVariable, i2, i3) == null) {
            int i4 = solverVariable.definitionId;
            if (i4 != -1) {
                ArrayRow arrayRow = this.mRows[i4];
                if (arrayRow.isSimpleDefinition) {
                    arrayRow.constantValue = i2;
                    return;
                }
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i2);
                createRow.addError(this, i3);
                addConstraint(createRow);
                return;
            }
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i2);
            createRow2.addError(this, i3);
            addConstraint(createRow2);
        }
    }
}
