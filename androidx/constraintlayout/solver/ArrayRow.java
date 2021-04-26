package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    public static final boolean DEBUG = false;
    public static final float epsilon = 0.001f;
    public final ArrayLinkedVariables variables;
    public SolverVariable variable = null;
    public float constantValue = 0.0f;
    public boolean used = false;
    public boolean isSimpleDefinition = false;

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow addError(LinearSystem linearSystem, int i2) {
        this.variables.put(linearSystem.createErrorVariable(i2, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i2, "em"), -1.0f);
        return this;
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i2) {
        this.variables.put(solverVariable, i2);
        return this;
    }

    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z;
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

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
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
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.constantValue = i3;
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

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i2) {
        this.variable = solverVariable;
        float f2 = i2;
        solverVariable.computedValue = f2;
        this.constantValue = f2;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f - f2);
        this.variables.put(solverVariable3, f2);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f2);
        this.variables.put(solverVariable4, -f2);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f2, float f3, float f4, SolverVariable solverVariable, int i2, SolverVariable solverVariable2, int i3, SolverVariable solverVariable3, int i4, SolverVariable solverVariable4, int i5) {
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

    public ArrayRow createRowEqualMatchDimensions(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
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

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i2) {
        if (i2 < 0) {
            this.constantValue = i2 * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = i2;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
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

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
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

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f2;
        return this;
    }

    public void ensurePositiveConstant() {
        float f2 = this.constantValue;
        if (f2 < 0.0f) {
            this.constantValue = f2 * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return this.variables.getPivotCandidate(zArr, null);
    }

    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        return solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.containsKey(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (!(row instanceof ArrayRow)) {
            return;
        }
        ArrayRow arrayRow = (ArrayRow) row;
        this.variable = null;
        this.variables.clear();
        int i2 = 0;
        while (true) {
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
            if (i2 >= arrayLinkedVariables.currentSize) {
                return;
            }
            this.variables.add(arrayLinkedVariables.getVariable(i2), arrayRow.variables.getVariableValue(i2), true);
            i2++;
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.currentSize == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.variables.getPivotCandidate(null, solverVariable);
    }

    public void pivot(SolverVariable solverVariable) {
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

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    public int sizeInBytes() {
        return (this.variable != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toReadableString() {
        boolean z;
        float variableValue;
        int i2;
        String str = (this.variable == null ? "0" : "" + this.variable) + " = ";
        if (this.constantValue != 0.0f) {
            str = str + this.constantValue;
            z = true;
        } else {
            z = false;
        }
        int i3 = this.variables.currentSize;
        for (int i4 = 0; i4 < i3; i4++) {
            SolverVariable variable = this.variables.getVariable(i4);
            if (variable != null && (this.variables.getVariableValue(i4)) != 0.0f) {
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

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
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

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
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

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i2, SolverVariable solverVariable2) {
        this.constantValue = i2;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
