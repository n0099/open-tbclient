package androidx.constraintlayout.solver;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes.dex */
public class SolverVariable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
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

        public Type(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, type, str)) == null) {
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
                sb3.append("S");
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
                sb5.append("V");
                int i6 = uniqueId + 1;
                uniqueId = i6;
                sb5.append(i6);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < 7; i++) {
                this.strengthVector[i] = 0.0f;
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
            this.mClientEquationsCount = 0;
            this.usageInRowCount = 0;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mName = str;
        }
    }

    public void setType(Type type, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, type, str) == null) {
            this.mType = type;
        }
    }

    public String strengthsToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this + PreferencesUtil.LEFT_MOUNT;
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
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "" + this.mName;
        }
        return (String) invokeV.objValue;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayRow) == null) {
            int i = this.mClientEquationsCount;
            for (int i2 = 0; i2 < i; i2++) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                arrayRowArr[i2].variables.updateFromRow(arrayRowArr[i2], arrayRow, false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
