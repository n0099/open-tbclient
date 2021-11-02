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
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    public transient /* synthetic */ FieldHolder $fh;
    public int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
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
    public Row mTempGoal;
    public HashMap<String, SolverVariable> mVariables;
    public int mVariablesID;
    public boolean newgraphOptimizer;

    /* loaded from: classes.dex */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* loaded from: classes.dex */
    public class ValuesRow extends ArrayRow {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearSystem this$0;

        public ValuesRow(LinearSystem linearSystem, Cache cache) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearSystem, cache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linearSystem;
            this.variables = new SolverVariableValues(this, cache);
        }
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
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this, this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, arrayRow) == null) {
            if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
                arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
            } else {
                ArrayRow[] arrayRowArr = this.mRows;
                int i3 = this.mNumRows;
                arrayRowArr[i3] = arrayRow;
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.definitionId = i3;
                this.mNumRows = i3 + 1;
                solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
            }
            if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
                int i4 = 0;
                while (i4 < this.mNumRows) {
                    if (this.mRows[i4] == null) {
                        System.out.println("WTF");
                    }
                    ArrayRow[] arrayRowArr2 = this.mRows;
                    if (arrayRowArr2[i4] != null && arrayRowArr2[i4].isSimpleDefinition) {
                        ArrayRow arrayRow2 = arrayRowArr2[i4];
                        arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow2);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow2);
                        }
                        this.mRows[i4] = null;
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (true) {
                            i2 = this.mNumRows;
                            if (i5 >= i2) {
                                break;
                            }
                            ArrayRow[] arrayRowArr3 = this.mRows;
                            int i7 = i5 - 1;
                            arrayRowArr3[i7] = arrayRowArr3[i5];
                            if (arrayRowArr3[i7].variable.definitionId == i5) {
                                arrayRowArr3[i7].variable.definitionId = i7;
                            }
                            i6 = i5;
                            i5++;
                        }
                        if (i6 < i2) {
                            this.mRows[i6] = null;
                        }
                        this.mNumRows--;
                        i4--;
                    }
                    i4++;
                }
                this.hasSimpleDefinition = false;
            }
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

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{linearSystem, solverVariable, solverVariable2, Float.valueOf(f2)})) == null) ? linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f2) : (ArrayRow) invokeCommon.objValue;
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, type)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
        }
    }

    private int enforceBFS(Row row) throws Exception {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, row)) == null) {
            int i2 = 0;
            while (true) {
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
                    float f2 = Float.MAX_VALUE;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    for (int i7 = 0; i7 < this.mNumRows; i7++) {
                        ArrayRow arrayRow = this.mRows[i7];
                        if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < 0.0f) {
                            int i8 = 9;
                            if (SKIP_COLUMNS) {
                                int currentSize = arrayRow.variables.getCurrentSize();
                                int i9 = 0;
                                while (i9 < currentSize) {
                                    SolverVariable variable = arrayRow.variables.getVariable(i9);
                                    float f3 = arrayRow.variables.get(variable);
                                    if (f3 > 0.0f) {
                                        int i10 = 0;
                                        while (i10 < i8) {
                                            float f4 = variable.strengthVector[i10] / f3;
                                            if ((f4 < f2 && i10 == i6) || i10 > i6) {
                                                i5 = variable.id;
                                                i6 = i10;
                                                i4 = i7;
                                                f2 = f4;
                                            }
                                            i10++;
                                            i8 = 9;
                                        }
                                    }
                                    i9++;
                                    i8 = 9;
                                }
                            } else {
                                for (int i11 = 1; i11 < this.mNumColumns; i11++) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i11];
                                    float f5 = arrayRow.variables.get(solverVariable);
                                    if (f5 > 0.0f) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f6 = solverVariable.strengthVector[i12] / f5;
                                            if ((f6 < f2 && i12 == i6) || i12 > i6) {
                                                i5 = i11;
                                                i6 = i12;
                                                i4 = i7;
                                                f2 = f6;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i4 != -1) {
                        ArrayRow arrayRow2 = this.mRows[i4];
                        arrayRow2.variable.definitionId = -1;
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow2.pivot(this.mCache.mIndexedVariables[i5]);
                        SolverVariable solverVariable2 = arrayRow2.variable;
                        solverVariable2.definitionId = i4;
                        solverVariable2.updateReferencesWithNewDefinition(this, arrayRow2);
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.mNumColumns / 2) {
                        z2 = true;
                    }
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) ? i2 == 1 ? "LOW" : i2 == 2 ? "MEDIUM" : i2 == 3 ? "HIGH" : i2 == 4 ? "HIGHEST" : i2 == 5 ? "EQUALITY" : i2 == 8 ? "FIXED" : i2 == 6 ? "BARRIER" : "NONE" : (String) invokeI.objValue;
    }

    public static Metrics getMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? sMetrics : (Metrics) invokeV.objValue;
    }

    private void increaseTableSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65552, this, row, z)) == null) {
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
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z2 = true;
                }
            }
            return i3;
        }
        return invokeLZ.intValue;
    }

    private void releaseRows() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            int i2 = 0;
            if (OPTIMIZED_ENGINE) {
                while (i2 < this.mNumRows) {
                    ArrayRow arrayRow = this.mRows[i2];
                    if (arrayRow != null) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow);
                    }
                    this.mRows[i2] = null;
                    i2++;
                }
                return;
            }
            while (i2 < this.mNumRows) {
                ArrayRow arrayRow2 = this.mRows[i2];
                if (arrayRow2 != null) {
                    this.mCache.arrayRowPool.release(arrayRow2);
                }
                this.mRows[i2] = null;
                i2++;
            }
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
            if (i4 != 8) {
                createRow.addError(this, i4);
            }
            addConstraint(createRow);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                int i2 = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i2 + 1) {
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
                            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                    if (arrayRow.hasKeyVariable()) {
                        return;
                    }
                    z2 = z;
                }
            }
            z = false;
            if (arrayRow.hasKeyVariable()) {
            }
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
            if (USE_BASIC_SYNONYMS && i3 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
                solverVariable.setFinalValue(this, solverVariable2.computedValue + i2);
                return null;
            }
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i2);
            if (i3 != 8) {
                createRow.addError(this, i3);
            }
            addConstraint(createRow);
            return createRow;
        }
        return (ArrayRow) invokeLLII.objValue;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
            addConstraint(createRow);
        }
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, solverVariable, solverVariable2, i2, i3) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (i3 != 8) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
            }
            addConstraint(createRow);
        }
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{solverVariable, solverVariable2, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
            addConstraint(createRow);
        }
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, solverVariable, solverVariable2, i2, i3) == null) {
            ArrayRow createRow = createRow();
            SolverVariable createSlackVariable = createSlackVariable();
            createSlackVariable.strength = 0;
            createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
            if (i3 != 8) {
                addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
            }
            addConstraint(createRow);
        }
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{solverVariable, solverVariable2, solverVariable3, solverVariable4, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            ArrayRow createRow = createRow();
            createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
            if (i2 != 8) {
                createRow.addError(this, i2);
            }
            addConstraint(createRow);
        }
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, solverVariable, solverVariable2, i2) == null) {
            if (solverVariable.definitionId == -1 && i2 == 0) {
                if (solverVariable2.isSynonym) {
                    float f2 = solverVariable2.synonymDelta;
                    solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
                }
                if (solverVariable.isSynonym) {
                    float f3 = solverVariable.synonymDelta;
                    SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
                    return;
                }
                solverVariable.setSynonym(this, solverVariable2, 0.0f);
                return;
            }
            addEquality(solverVariable, solverVariable2, i2, 8);
        }
    }

    public final void cleanupRows() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i3 = 0;
            while (i3 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i3];
                if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.isSimpleDefinition = true;
                }
                if (arrayRow.isSimpleDefinition) {
                    SolverVariable solverVariable = arrayRow.variable;
                    solverVariable.computedValue = arrayRow.constantValue;
                    solverVariable.removeFromRow(arrayRow);
                    int i4 = i3;
                    while (true) {
                        i2 = this.mNumRows;
                        if (i4 >= i2 - 1) {
                            break;
                        }
                        ArrayRow[] arrayRowArr = this.mRows;
                        int i5 = i4 + 1;
                        arrayRowArr[i4] = arrayRowArr[i5];
                        i4 = i5;
                    }
                    this.mRows[i2 - 1] = null;
                    this.mNumRows = i2 - 1;
                    i3--;
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow);
                    }
                }
                i3++;
            }
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
        ArrayRow acquire;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (OPTIMIZED_ENGINE) {
                acquire = this.mCache.optimizedArrayRowPool.acquire();
                if (acquire == null) {
                    acquire = new ValuesRow(this, this.mCache);
                    OPTIMIZED_ARRAY_ROW_CREATION++;
                } else {
                    acquire.reset();
                }
            } else {
                acquire = this.mCache.arrayRowPool.acquire();
                if (acquire == null) {
                    acquire = new ArrayRow(this.mCache);
                    ARRAY_ROW_CREATION++;
                } else {
                    acquire.reset();
                }
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
            String str = " num vars " + this.mVariablesID + StringUtils.LF;
            for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
                SolverVariable solverVariable = this.mCache.mIndexedVariables[i2];
                if (solverVariable != null && solverVariable.isFinalValue) {
                    str = str + " $[" + i2 + "] => " + solverVariable + " = " + solverVariable.computedValue + StringUtils.LF;
                }
            }
            String str2 = str + StringUtils.LF;
            for (int i3 = 0; i3 < this.mVariablesID + 1; i3++) {
                SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
                SolverVariable solverVariable2 = solverVariableArr[i3];
                if (solverVariable2 != null && solverVariable2.isSynonym) {
                    str2 = str2 + " ~[" + i3 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + StringUtils.LF;
                }
            }
            String str3 = str2 + "\n\n #  ";
            for (int i4 = 0; i4 < this.mNumRows; i4++) {
                str3 = (str3 + this.mRows[i4].toReadableString()) + "\n #  ";
            }
            if (this.mGoal != null) {
                str3 = str3 + "Goal: " + this.mGoal + StringUtils.LF;
            }
            System.out.println(str3);
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
            if (this.mGoal.isEmpty()) {
                computeValues();
            } else if (!this.graphOptimizer && !this.newgraphOptimizer) {
                minimizeGoal(this.mGoal);
            } else {
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
            }
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
            enforceBFS(row);
            optimize(row, false);
            computeValues();
        }
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, arrayRow) == null) && arrayRow.isSimpleDefinition && (solverVariable = arrayRow.variable) != null) {
            int i3 = solverVariable.definitionId;
            if (i3 != -1) {
                while (true) {
                    i2 = this.mNumRows;
                    if (i3 >= i2 - 1) {
                        break;
                    }
                    int i4 = i3 + 1;
                    SolverVariable solverVariable2 = this.mRows[i4].variable;
                    if (solverVariable2.definitionId == i4) {
                        solverVariable2.definitionId = i3;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.mNumRows = i2 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.variable;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.constantValue);
            }
            if (OPTIMIZED_ENGINE) {
                this.mCache.optimizedArrayRowPool.release(arrayRow);
            } else {
                this.mCache.arrayRowPool.release(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i3] != null) {
                    arrayRowArr[i3].used = false;
                }
            }
            releaseRows();
            this.mNumRows = 0;
            if (OPTIMIZED_ENGINE) {
                this.mTempGoal = new ValuesRow(this, this.mCache);
            } else {
                this.mTempGoal = new ArrayRow(this.mCache);
            }
        }
    }

    public void addSingleError(ArrayRow arrayRow, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, arrayRow, i2, i3) == null) {
            arrayRow.addSingleError(createErrorVariable(i3, null), i2);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, solverVariable, i2) == null) {
            if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
                float f2 = i2;
                solverVariable.setFinalValue(this, f2);
                for (int i3 = 0; i3 < this.mVariablesID + 1; i3++) {
                    SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i3];
                    if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.id) {
                        solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f2);
                    }
                }
                return;
            }
            int i4 = solverVariable.definitionId;
            if (i4 != -1) {
                ArrayRow arrayRow = this.mRows[i4];
                if (arrayRow.isSimpleDefinition) {
                    arrayRow.constantValue = i2;
                    return;
                } else if (arrayRow.variables.getCurrentSize() == 0) {
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
}
