package androidx.constraintlayout.solver;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public class SolverVariable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public static final boolean VAR_USE_HASH = false;
    public static int uniqueConstantId = 1;
    public static int uniqueErrorId = 1;
    public static int uniqueId = 1;
    public static int uniqueSlackId = 1;
    public static int uniqueUnrestrictedId = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public float computedValue;
    public int definitionId;
    public float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    public HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    public boolean isSynonym;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    public String mName;
    public Type mType;
    public int strength;
    public float[] strengthVector;
    public int synonym;
    public float synonymDelta;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1693736815, "Landroidx/constraintlayout/solver/SolverVariable$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1693736815, "Landroidx/constraintlayout/solver/SolverVariable$1;");
                    return;
                }
            }
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type CONSTANT;
        public static final Type ERROR;
        public static final Type SLACK;
        public static final Type UNKNOWN;
        public static final Type UNRESTRICTED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-803381158, "Landroidx/constraintlayout/solver/SolverVariable$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-803381158, "Landroidx/constraintlayout/solver/SolverVariable$Type;");
                    return;
                }
            }
            UNRESTRICTED = new Type("UNRESTRICTED", 0);
            CONSTANT = new Type("CONSTANT", 1);
            SLACK = new Type("SLACK", 2);
            ERROR = new Type("ERROR", 3);
            Type type = new Type(RomUtils.UNKNOWN, 4);
            UNKNOWN = type;
            $VALUES = new Type[]{UNRESTRICTED, CONSTANT, SLACK, ERROR, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1915553854, "Landroidx/constraintlayout/solver/SolverVariable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1915553854, "Landroidx/constraintlayout/solver/SolverVariable;");
        }
    }

    public SolverVariable(String str, Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, type};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    public static String getUniqueName(Type type, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, type, str)) == null) {
            if (str != null) {
                return str + uniqueErrorId;
            }
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
            if (i2 == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("U");
                int i3 = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i3;
                sb.append(i3);
                return sb.toString();
            } else if (i2 == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("C");
                int i4 = uniqueConstantId + 1;
                uniqueConstantId = i4;
                sb2.append(i4);
                return sb2.toString();
            } else if (i2 == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ExifInterface.LATITUDE_SOUTH);
                int i5 = uniqueSlackId + 1;
                uniqueSlackId = i5;
                sb3.append(i5);
                return sb3.toString();
            } else if (i2 == 4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("e");
                int i6 = uniqueErrorId + 1;
                uniqueErrorId = i6;
                sb4.append(i6);
                return sb4.toString();
            } else if (i2 == 5) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                int i7 = uniqueId + 1;
                uniqueId = i7;
                sb5.append(i7);
                return sb5.toString();
            } else {
                throw new AssertionError(type.name());
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void increaseErrorId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            uniqueErrorId++;
        }
    }

    public final void addToRow(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, arrayRow) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = this.mClientEquationsCount;
            if (i2 < i3) {
                if (this.mClientEquations[i2] == arrayRow) {
                    return;
                }
                i2++;
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i3 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i4 = this.mClientEquationsCount;
                arrayRowArr2[i4] = arrayRow;
                this.mClientEquationsCount = i4 + 1;
                return;
            }
        }
    }

    public void clearStrengths() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                this.strengthVector[i2] = 0.0f;
            }
        }
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayRow) == null) {
            int i2 = this.mClientEquationsCount;
            int i3 = 0;
            while (i3 < i2) {
                if (this.mClientEquations[i3] == arrayRow) {
                    while (i3 < i2 - 1) {
                        ArrayRow[] arrayRowArr = this.mClientEquations;
                        int i4 = i3 + 1;
                        arrayRowArr[i3] = arrayRowArr[i4];
                        i3 = i4;
                    }
                    this.mClientEquationsCount--;
                    return;
                }
                i3++;
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mName = null;
            this.mType = Type.UNKNOWN;
            this.strength = 0;
            this.id = -1;
            this.definitionId = -1;
            this.computedValue = 0.0f;
            this.isFinalValue = false;
            this.isSynonym = false;
            this.synonym = -1;
            this.synonymDelta = 0.0f;
            int i2 = this.mClientEquationsCount;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mClientEquations[i3] = null;
            }
            this.mClientEquationsCount = 0;
            this.usageInRowCount = 0;
            this.inGoal = false;
            Arrays.fill(this.goalStrengthVector, 0.0f);
        }
    }

    public void setFinalValue(LinearSystem linearSystem, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, linearSystem, f2) == null) {
            this.computedValue = f2;
            this.isFinalValue = true;
            this.isSynonym = false;
            this.synonym = -1;
            this.synonymDelta = 0.0f;
            int i2 = this.mClientEquationsCount;
            this.definitionId = -1;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mClientEquations[i3].updateFromFinalVariable(linearSystem, this, false);
            }
            this.mClientEquationsCount = 0;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mName = str;
        }
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{linearSystem, solverVariable, Float.valueOf(f2)}) == null) {
            this.isSynonym = true;
            this.synonym = solverVariable.id;
            this.synonymDelta = f2;
            int i2 = this.mClientEquationsCount;
            this.definitionId = -1;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mClientEquations[i3].updateFromSynonymVariable(linearSystem, this, false);
            }
            this.mClientEquationsCount = 0;
            linearSystem.displayReadableRows();
        }
    }

    public void setType(Type type, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, type, str) == null) {
            this.mType = type;
        }
    }

    public String strengthsToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this + PreferencesUtil.LEFT_MOUNT;
            boolean z = false;
            boolean z2 = true;
            for (int i2 = 0; i2 < this.strengthVector.length; i2++) {
                String str2 = str + this.strengthVector[i2];
                float[] fArr = this.strengthVector;
                if (fArr[i2] > 0.0f) {
                    z = false;
                } else if (fArr[i2] < 0.0f) {
                    z = true;
                }
                if (this.strengthVector[i2] != 0.0f) {
                    z2 = false;
                }
                str = i2 < this.strengthVector.length - 1 ? str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR : str2 + "] ";
            }
            if (z) {
                str = str + " (-)";
            }
            if (z2) {
                return str + " (*)";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mName != null) {
                return "" + this.mName;
            }
            return "" + this.id;
        }
        return (String) invokeV.objValue;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, linearSystem, arrayRow) == null) {
            int i2 = this.mClientEquationsCount;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mClientEquations[i3].updateFromRow(linearSystem, arrayRow, false);
            }
            this.mClientEquationsCount = 0;
        }
    }

    public SolverVariable(Type type, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = type;
    }
}
