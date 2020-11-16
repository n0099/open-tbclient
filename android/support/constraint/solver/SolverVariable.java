package android.support.constraint.solver;

import android.support.media.ExifInterface;
import java.util.Arrays;
/* loaded from: classes14.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public float computedValue;
    int definitionId;
    public int id;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;
    private static int uniqueSlackId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueUnrestrictedId = 1;
    private static int uniqueConstantId = 1;
    private static int uniqueId = 1;

    /* loaded from: classes14.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        switch (type) {
            case UNRESTRICTED:
                StringBuilder append = new StringBuilder().append("U");
                int i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
                return append.append(i).toString();
            case CONSTANT:
                StringBuilder append2 = new StringBuilder().append("C");
                int i2 = uniqueConstantId + 1;
                uniqueConstantId = i2;
                return append2.append(i2).toString();
            case SLACK:
                StringBuilder append3 = new StringBuilder().append(ExifInterface.LATITUDE_SOUTH);
                int i3 = uniqueSlackId + 1;
                uniqueSlackId = i3;
                return append3.append(i3).toString();
            case ERROR:
                StringBuilder append4 = new StringBuilder().append("e");
                int i4 = uniqueErrorId + 1;
                uniqueErrorId = i4;
                return append4.append(i4).toString();
            case UNKNOWN:
                StringBuilder append5 = new StringBuilder().append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                int i5 = uniqueId + 1;
                uniqueId = i5;
                return append5.append(i5).toString();
            default:
                throw new AssertionError(type.name());
        }
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

    void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    String strengthsToString() {
        boolean z = true;
        boolean z2 = false;
        String str = this + "[";
        for (int i = 0; i < this.strengthVector.length; i++) {
            String str2 = str + this.strengthVector[i];
            if (this.strengthVector[i] > 0.0f) {
                z2 = false;
            } else if (this.strengthVector[i] < 0.0f) {
                z2 = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z = false;
            }
            if (i < this.strengthVector.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        String str3 = z2 ? str + " (-)" : str;
        if (z) {
            return str3 + " (*)";
        }
        return str3;
    }

    public final void addToRow(ArrayRow arrayRow) {
        for (int i = 0; i < this.mClientEquationsCount; i++) {
            if (this.mClientEquations[i] == arrayRow) {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    this.mClientEquations[i2 + i3] = this.mClientEquations[i2 + i3 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].variables.updateFromRow(this.mClientEquations[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
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

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String toString() {
        return "" + this.mName;
    }
}
