package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
/* loaded from: classes.dex */
public class SolverVariable {
    public static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public static int uniqueConstantId = 1;
    public static int uniqueErrorId = 1;
    public static int uniqueId = 1;
    public static int uniqueSlackId = 1;
    public static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId;
    public int id;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    public String mName;
    public Type mType;
    public int strength;
    public float[] strengthVector;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mName = str;
        this.mType = type;
    }

    public static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("U");
            int i2 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i2;
            sb.append(i2);
            return sb.toString();
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("C");
            int i3 = uniqueConstantId + 1;
            uniqueConstantId = i3;
            sb2.append(i3);
            return sb2.toString();
        } else if (i == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ExifInterface.LATITUDE_SOUTH);
            int i4 = uniqueSlackId + 1;
            uniqueSlackId = i4;
            sb3.append(i4);
            return sb3.toString();
        } else if (i == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("e");
            int i5 = uniqueErrorId + 1;
            uniqueErrorId = i5;
            sb4.append(i5);
            return sb4.toString();
        } else if (i == 5) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int i6 = uniqueId + 1;
            uniqueId = i6;
            sb5.append(i6);
            return sb5.toString();
        } else {
            throw new AssertionError(type.name());
        }
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i < i2) {
                if (this.mClientEquations[i] == arrayRow) {
                    return;
                }
                i++;
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i4 = i2 + i3;
                    arrayRowArr[i4] = arrayRowArr[i4 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.strengthVector.length; i++) {
            String str2 = str + this.strengthVector[i];
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z = false;
            } else if (fArr[i] < 0.0f) {
                z = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z2 = false;
            }
            str = i < this.strengthVector.length - 1 ? str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR : str2 + "] ";
        }
        if (z) {
            str = str + " (-)";
        }
        if (z2) {
            return str + " (*)";
        }
        return str;
    }

    public String toString() {
        return "" + this.mName;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayRow[] arrayRowArr = this.mClientEquations;
            arrayRowArr[i2].variables.updateFromRow(arrayRowArr[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mType = type;
    }
}
