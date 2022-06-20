package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class ConstraintAnchor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ALLOW_BINARY = false;
    public static final int AUTO_CONSTRAINT_CREATOR = 2;
    public static final int SCOUT_CREATOR = 1;
    public static final int UNSET_GONE_MARGIN = -1;
    public static final int USER_CREATOR = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mConnectionCreator;
    public ConnectionType mConnectionType;
    public int mGoneMargin;
    public int mMargin;
    public final ConstraintWidget mOwner;
    public ResolutionAnchor mResolutionAnchor;
    public SolverVariable mSolverVariable;
    public Strength mStrength;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317708658, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1317708658, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$1;");
                    return;
                }
            }
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ConnectionType {
        public static final /* synthetic */ ConnectionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ConnectionType RELAXED;
        public static final ConnectionType STRICT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1063098369, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$ConnectionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1063098369, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$ConnectionType;");
                    return;
                }
            }
            RELAXED = new ConnectionType("RELAXED", 0);
            ConnectionType connectionType = new ConnectionType("STRICT", 1);
            STRICT = connectionType;
            $VALUES = new ConnectionType[]{RELAXED, connectionType};
        }

        public ConnectionType(String str, int i) {
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

        public static ConnectionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ConnectionType) Enum.valueOf(ConnectionType.class, str) : (ConnectionType) invokeL.objValue;
        }

        public static ConnectionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ConnectionType[]) $VALUES.clone() : (ConnectionType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Strength {
        public static final /* synthetic */ Strength[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Strength NONE;
        public static final Strength STRONG;
        public static final Strength WEAK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330268438, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Strength;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1330268438, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Strength;");
                    return;
                }
            }
            NONE = new Strength(HlsPlaylistParser.METHOD_NONE, 0);
            STRONG = new Strength("STRONG", 1);
            Strength strength = new Strength("WEAK", 2);
            WEAK = strength;
            $VALUES = new Strength[]{NONE, STRONG, strength};
        }

        public Strength(String str, int i) {
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

        public static Strength valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Strength) Enum.valueOf(Strength.class, str) : (Strength) invokeL.objValue;
        }

        public static Strength[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Strength[]) $VALUES.clone() : (Strength[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type BASELINE;
        public static final Type BOTTOM;
        public static final Type CENTER;
        public static final Type CENTER_X;
        public static final Type CENTER_Y;
        public static final Type LEFT;
        public static final Type NONE;
        public static final Type RIGHT;
        public static final Type TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(176736061, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(176736061, "Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;");
                    return;
                }
            }
            NONE = new Type(HlsPlaylistParser.METHOD_NONE, 0);
            LEFT = new Type("LEFT", 1);
            TOP = new Type("TOP", 2);
            RIGHT = new Type("RIGHT", 3);
            BOTTOM = new Type("BOTTOM", 4);
            BASELINE = new Type("BASELINE", 5);
            CENTER = new Type("CENTER", 6);
            CENTER_X = new Type("CENTER_X", 7);
            Type type = new Type("CENTER_Y", 8);
            CENTER_Y = type;
            $VALUES = new Type[]{NONE, LEFT, TOP, RIGHT, BOTTOM, BASELINE, CENTER, CENTER_X, type};
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

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget, type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResolutionAnchor = new ResolutionAnchor(this);
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mStrength = Strength.NONE;
        this.mConnectionType = ConnectionType.RELAXED;
        this.mConnectionCreator = 0;
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    private boolean isConnectionToMe(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, constraintWidget, hashSet)) == null) {
            if (hashSet.contains(constraintWidget)) {
                return false;
            }
            hashSet.add(constraintWidget);
            if (constraintWidget == getOwner()) {
                return true;
            }
            ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
            int size = anchors.size();
            for (int i = 0; i < size; i++) {
                ConstraintAnchor constraintAnchor = anchors.get(i);
                if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && isConnectionToMe(constraintAnchor.getTarget().getOwner(), hashSet)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{constraintAnchor, Integer.valueOf(i), strength, Integer.valueOf(i2)})) == null) ? connect(constraintAnchor, i, -1, strength, i2, false) : invokeCommon.booleanValue;
    }

    public int getConnectionCreator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConnectionCreator : invokeV.intValue;
    }

    public ConnectionType getConnectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mConnectionType : (ConnectionType) invokeV.objValue;
    }

    public int getMargin() {
        InterceptResult invokeV;
        ConstraintAnchor constraintAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mOwner.getVisibility() == 8) {
                return 0;
            }
            if (this.mGoneMargin > -1 && (constraintAnchor = this.mTarget) != null && constraintAnchor.mOwner.getVisibility() == 8) {
                return this.mGoneMargin;
            }
            return this.mMargin;
        }
        return invokeV.intValue;
    }

    public final ConstraintAnchor getOpposite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                case 6:
                case 7:
                case 8:
                case 9:
                    return null;
                case 2:
                    return this.mOwner.mRight;
                case 3:
                    return this.mOwner.mLeft;
                case 4:
                    return this.mOwner.mBottom;
                case 5:
                    return this.mOwner.mTop;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return (ConstraintAnchor) invokeV.objValue;
    }

    public ConstraintWidget getOwner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mOwner : (ConstraintWidget) invokeV.objValue;
    }

    public int getPriorityLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return 2;
                case 6:
                    return 1;
                case 7:
                case 8:
                case 9:
                    return 0;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeV.intValue;
    }

    public ResolutionAnchor getResolutionNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mResolutionAnchor : (ResolutionAnchor) invokeV.objValue;
    }

    public int getSnapPriorityLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                    return 3;
                case 2:
                case 3:
                    return 1;
                case 4:
                case 5:
                    return 0;
                case 6:
                    return 2;
                case 7:
                    return 0;
                case 8:
                    return 1;
                case 9:
                    return 0;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeV.intValue;
    }

    public SolverVariable getSolverVariable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSolverVariable : (SolverVariable) invokeV.objValue;
    }

    public Strength getStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mStrength : (Strength) invokeV.objValue;
    }

    public ConstraintAnchor getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTarget : (ConstraintAnchor) invokeV.objValue;
    }

    public Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mType : (Type) invokeV.objValue;
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTarget != null : invokeV.booleanValue;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, constraintWidget, constraintAnchor)) == null) ? isConnectionAllowed(constraintWidget) : invokeLL.booleanValue;
    }

    public boolean isSideAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                case 2:
                case 3:
                case 4:
                case 5:
                    return true;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, constraintAnchor)) == null) {
            Type type = constraintAnchor.getType();
            Type type2 = this.mType;
            if (type == type2) {
                return true;
            }
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type2.ordinal()]) {
                case 1:
                    return type != Type.BASELINE;
                case 2:
                case 3:
                case 7:
                    return type == Type.LEFT || type == Type.RIGHT || type == Type.CENTER_X;
                case 4:
                case 5:
                case 6:
                case 8:
                    return type == Type.TOP || type == Type.BOTTOM || type == Type.CENTER_Y || type == Type.BASELINE;
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isSnapCompatibleWith(ConstraintAnchor constraintAnchor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, constraintAnchor)) == null) {
            Type type = this.mType;
            if (type == Type.CENTER) {
                return false;
            }
            if (type == constraintAnchor.getType()) {
                return true;
            }
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                case 6:
                case 9:
                    return false;
                case 2:
                    int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i == 3 || i == 7;
                case 3:
                    int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i2 == 2 || i2 == 7;
                case 4:
                    int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i3 == 5 || i3 == 8;
                case 5:
                    int i4 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i4 == 4 || i4 == 8;
                case 7:
                    int i5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i5 == 2 || i5 == 3;
                case 8:
                    int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                    return i6 == 4 || i6 == 5;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, constraintAnchor)) == null) {
            boolean z = false;
            if (constraintAnchor == null) {
                return false;
            }
            Type type = constraintAnchor.getType();
            Type type2 = this.mType;
            if (type == type2) {
                return type2 != Type.BASELINE || (constraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline());
            }
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type2.ordinal()]) {
                case 1:
                    return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
                case 2:
                case 3:
                    boolean z2 = type == Type.LEFT || type == Type.RIGHT;
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        return (z2 || type == Type.CENTER_X) ? true : true;
                    }
                    return z2;
                case 4:
                case 5:
                    boolean z3 = type == Type.TOP || type == Type.BOTTOM;
                    if (constraintAnchor.getOwner() instanceof Guideline) {
                        return (z3 || type == Type.CENTER_Y) ? true : true;
                    }
                    return z3;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isVerticalAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 7:
                    return false;
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                    return true;
                default:
                    throw new AssertionError(this.mType.name());
            }
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mTarget = null;
            this.mMargin = 0;
            this.mGoneMargin = -1;
            this.mStrength = Strength.STRONG;
            this.mConnectionCreator = 0;
            this.mConnectionType = ConnectionType.RELAXED;
            this.mResolutionAnchor.reset();
        }
    }

    public void resetSolverVariable(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cache) == null) {
            SolverVariable solverVariable = this.mSolverVariable;
            if (solverVariable == null) {
                this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
            } else {
                solverVariable.reset();
            }
        }
    }

    public void setConnectionCreator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mConnectionCreator = i;
        }
    }

    public void setConnectionType(ConnectionType connectionType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, connectionType) == null) {
            this.mConnectionType = connectionType;
        }
    }

    public void setGoneMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i) == null) && isConnected()) {
            this.mGoneMargin = i;
        }
    }

    public void setMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i) == null) && isConnected()) {
            this.mMargin = i;
        }
    }

    public void setStrength(Strength strength) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, strength) == null) && isConnected()) {
            this.mStrength = strength;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mOwner.getDebugName() + ":" + this.mType.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{constraintAnchor, Integer.valueOf(i), Integer.valueOf(i2), strength, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (constraintAnchor == null) {
                this.mTarget = null;
                this.mMargin = 0;
                this.mGoneMargin = -1;
                this.mStrength = Strength.NONE;
                this.mConnectionCreator = 2;
                return true;
            } else if (z || isValidConnection(constraintAnchor)) {
                this.mTarget = constraintAnchor;
                if (i > 0) {
                    this.mMargin = i;
                } else {
                    this.mMargin = 0;
                }
                this.mGoneMargin = i2;
                this.mStrength = strength;
                this.mConnectionCreator = i3;
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, constraintWidget)) == null) {
            if (isConnectionToMe(constraintWidget, new HashSet<>())) {
                return false;
            }
            ConstraintWidget parent = getOwner().getParent();
            return parent == constraintWidget || constraintWidget.getParent() == parent;
        }
        return invokeL.booleanValue;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintAnchor, i, i2)) == null) ? connect(constraintAnchor, i, -1, Strength.STRONG, i2, false) : invokeLII.booleanValue;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, constraintAnchor, i)) == null) ? connect(constraintAnchor, i, -1, Strength.STRONG, 0, false) : invokeLI.booleanValue;
    }
}
