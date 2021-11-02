package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class State {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONSTRAINT_RATIO = 2;
    public static final int CONSTRAINT_SPREAD = 0;
    public static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT;
    public static final int UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    public HashMap<Object, Reference> mReferences;
    public int numHelpers;

    /* renamed from: androidx.constraintlayout.solver.state.State$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-85945655, "Landroidx/constraintlayout/solver/state/State$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-85945655, "Landroidx/constraintlayout/solver/state/State$1;");
                    return;
                }
            }
            int[] iArr = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = iArr;
            try {
                iArr[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.BARRIER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Chain {
        public static final /* synthetic */ Chain[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Chain PACKED;
        public static final Chain SPREAD;
        public static final Chain SPREAD_INSIDE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1061743911, "Landroidx/constraintlayout/solver/state/State$Chain;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1061743911, "Landroidx/constraintlayout/solver/state/State$Chain;");
                    return;
                }
            }
            SPREAD = new Chain("SPREAD", 0);
            SPREAD_INSIDE = new Chain("SPREAD_INSIDE", 1);
            Chain chain = new Chain("PACKED", 2);
            PACKED = chain;
            $VALUES = new Chain[]{SPREAD, SPREAD_INSIDE, chain};
        }

        public Chain(String str, int i2) {
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

        public static Chain valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Chain) Enum.valueOf(Chain.class, str) : (Chain) invokeL.objValue;
        }

        public static Chain[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Chain[]) $VALUES.clone() : (Chain[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Constraint {
        public static final /* synthetic */ Constraint[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Constraint BASELINE_TO_BASELINE;
        public static final Constraint BOTTOM_TO_BOTTOM;
        public static final Constraint BOTTOM_TO_TOP;
        public static final Constraint CENTER_HORIZONTALLY;
        public static final Constraint CENTER_VERTICALLY;
        public static final Constraint END_TO_END;
        public static final Constraint END_TO_START;
        public static final Constraint LEFT_TO_LEFT;
        public static final Constraint LEFT_TO_RIGHT;
        public static final Constraint RIGHT_TO_LEFT;
        public static final Constraint RIGHT_TO_RIGHT;
        public static final Constraint START_TO_END;
        public static final Constraint START_TO_START;
        public static final Constraint TOP_TO_BOTTOM;
        public static final Constraint TOP_TO_TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(675251231, "Landroidx/constraintlayout/solver/state/State$Constraint;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(675251231, "Landroidx/constraintlayout/solver/state/State$Constraint;");
                    return;
                }
            }
            LEFT_TO_LEFT = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_RIGHT = new Constraint("LEFT_TO_RIGHT", 1);
            RIGHT_TO_LEFT = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_RIGHT = new Constraint("RIGHT_TO_RIGHT", 3);
            START_TO_START = new Constraint("START_TO_START", 4);
            START_TO_END = new Constraint("START_TO_END", 5);
            END_TO_START = new Constraint("END_TO_START", 6);
            END_TO_END = new Constraint("END_TO_END", 7);
            TOP_TO_TOP = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_BOTTOM = new Constraint("TOP_TO_BOTTOM", 9);
            BOTTOM_TO_TOP = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_BOTTOM = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BASELINE_TO_BASELINE = new Constraint("BASELINE_TO_BASELINE", 12);
            CENTER_HORIZONTALLY = new Constraint("CENTER_HORIZONTALLY", 13);
            Constraint constraint = new Constraint("CENTER_VERTICALLY", 14);
            CENTER_VERTICALLY = constraint;
            $VALUES = new Constraint[]{LEFT_TO_LEFT, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_RIGHT, START_TO_START, START_TO_END, END_TO_START, END_TO_END, TOP_TO_TOP, TOP_TO_BOTTOM, BOTTOM_TO_TOP, BOTTOM_TO_BOTTOM, BASELINE_TO_BASELINE, CENTER_HORIZONTALLY, constraint};
        }

        public Constraint(String str, int i2) {
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

        public static Constraint valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Constraint) Enum.valueOf(Constraint.class, str) : (Constraint) invokeL.objValue;
        }

        public static Constraint[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Constraint[]) $VALUES.clone() : (Constraint[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Direction {
        public static final /* synthetic */ Direction[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Direction BOTTOM;
        public static final Direction END;
        public static final Direction LEFT;
        public static final Direction RIGHT;
        public static final Direction START;
        public static final Direction TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(575160923, "Landroidx/constraintlayout/solver/state/State$Direction;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(575160923, "Landroidx/constraintlayout/solver/state/State$Direction;");
                    return;
                }
            }
            LEFT = new Direction("LEFT", 0);
            RIGHT = new Direction("RIGHT", 1);
            START = new Direction("START", 2);
            END = new Direction("END", 3);
            TOP = new Direction("TOP", 4);
            Direction direction = new Direction("BOTTOM", 5);
            BOTTOM = direction;
            $VALUES = new Direction[]{LEFT, RIGHT, START, END, TOP, direction};
        }

        public Direction(String str, int i2) {
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

        public static Direction valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Direction) Enum.valueOf(Direction.class, str) : (Direction) invokeL.objValue;
        }

        public static Direction[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Direction[]) $VALUES.clone() : (Direction[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Helper {
        public static final /* synthetic */ Helper[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Helper ALIGN_HORIZONTALLY;
        public static final Helper ALIGN_VERTICALLY;
        public static final Helper BARRIER;
        public static final Helper FLOW;
        public static final Helper HORIZONTAL_CHAIN;
        public static final Helper LAYER;
        public static final Helper VERTICAL_CHAIN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1512701166, "Landroidx/constraintlayout/solver/state/State$Helper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1512701166, "Landroidx/constraintlayout/solver/state/State$Helper;");
                    return;
                }
            }
            HORIZONTAL_CHAIN = new Helper("HORIZONTAL_CHAIN", 0);
            VERTICAL_CHAIN = new Helper("VERTICAL_CHAIN", 1);
            ALIGN_HORIZONTALLY = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_VERTICALLY = new Helper("ALIGN_VERTICALLY", 3);
            BARRIER = new Helper("BARRIER", 4);
            LAYER = new Helper("LAYER", 5);
            Helper helper = new Helper("FLOW", 6);
            FLOW = helper;
            $VALUES = new Helper[]{HORIZONTAL_CHAIN, VERTICAL_CHAIN, ALIGN_HORIZONTALLY, ALIGN_VERTICALLY, BARRIER, LAYER, helper};
        }

        public Helper(String str, int i2) {
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

        public static Helper valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Helper) Enum.valueOf(Helper.class, str) : (Helper) invokeL.objValue;
        }

        public static Helper[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Helper[]) $VALUES.clone() : (Helper[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125228938, "Landroidx/constraintlayout/solver/state/State;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125228938, "Landroidx/constraintlayout/solver/state/State;");
                return;
            }
        }
        PARENT = 0;
    }

    public State() {
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
        this.mReferences = new HashMap<>();
        this.mHelperReferences = new HashMap<>();
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, constraintReference);
    }

    private String createHelperKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("__HELPER_KEY_");
            int i2 = this.numHelpers;
            this.numHelpers = i2 + 1;
            sb.append(i2);
            sb.append("__");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidgetContainer) == null) {
            constraintWidgetContainer.removeAllChildren();
            this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
            this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
            for (Object obj : this.mHelperReferences.keySet()) {
                HelperWidget helperWidget = this.mHelperReferences.get(obj).getHelperWidget();
                if (helperWidget != null) {
                    Reference reference = this.mReferences.get(obj);
                    if (reference == null) {
                        reference = constraints(obj);
                    }
                    reference.setConstraintWidget(helperWidget);
                }
            }
            for (Object obj2 : this.mReferences.keySet()) {
                Reference reference2 = this.mReferences.get(obj2);
                if (reference2 != this.mParent) {
                    ConstraintWidget constraintWidget = reference2.getConstraintWidget();
                    constraintWidget.setParent(null);
                    if (reference2 instanceof GuidelineReference) {
                        reference2.apply();
                    }
                    constraintWidgetContainer.add(constraintWidget);
                } else {
                    reference2.setConstraintWidget(constraintWidgetContainer);
                }
            }
            for (Object obj3 : this.mHelperReferences.keySet()) {
                HelperReference helperReference = this.mHelperReferences.get(obj3);
                if (helperReference.getHelperWidget() != null) {
                    Iterator<Object> it = helperReference.mReferences.iterator();
                    while (it.hasNext()) {
                        helperReference.getHelperWidget().add(this.mReferences.get(it.next()).getConstraintWidget());
                    }
                    helperReference.apply();
                }
            }
            for (Object obj4 : this.mReferences.keySet()) {
                this.mReferences.get(obj4).apply();
            }
        }
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, direction)) == null) {
            BarrierReference barrierReference = (BarrierReference) helper(obj, Helper.BARRIER);
            barrierReference.setBarrierDirection(direction);
            return barrierReference;
        }
        return (BarrierReference) invokeLL.objValue;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
            AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
            alignHorizontallyReference.add(objArr);
            return alignHorizontallyReference;
        }
        return (AlignHorizontallyReference) invokeL.objValue;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
            alignVerticallyReference.add(objArr);
            return alignVerticallyReference;
        }
        return (AlignVerticallyReference) invokeL.objValue;
    }

    public ConstraintReference constraints(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            Reference reference = this.mReferences.get(obj);
            if (reference == null) {
                reference = createConstraintReference(obj);
                this.mReferences.put(obj, reference);
                reference.setKey(obj);
            }
            if (reference instanceof ConstraintReference) {
                return (ConstraintReference) reference;
            }
            return null;
        }
        return (ConstraintReference) invokeL.objValue;
    }

    public int convertDimension(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? new ConstraintReference(this) : (ConstraintReference) invokeL.objValue;
    }

    public void directMapping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (Object obj : this.mReferences.keySet()) {
                constraints(obj).setView(obj);
            }
        }
    }

    public GuidelineReference guideline(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) {
            Reference reference = this.mReferences.get(obj);
            GuidelineReference guidelineReference = reference;
            if (reference == null) {
                GuidelineReference guidelineReference2 = new GuidelineReference(this);
                guidelineReference2.setOrientation(i2);
                guidelineReference2.setKey(obj);
                this.mReferences.put(obj, guidelineReference2);
                guidelineReference = guidelineReference2;
            }
            return (GuidelineReference) guidelineReference;
        }
        return (GuidelineReference) invokeLI.objValue;
    }

    public State height(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dimension)) == null) ? setHeight(dimension) : (State) invokeL.objValue;
    }

    public HelperReference helper(Object obj, Helper helper) {
        InterceptResult invokeLL;
        HelperReference horizontalChainReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, obj, helper)) == null) {
            if (obj == null) {
                obj = createHelperKey();
            }
            HelperReference helperReference = this.mHelperReferences.get(obj);
            if (helperReference == null) {
                int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[helper.ordinal()];
                if (i2 == 1) {
                    horizontalChainReference = new HorizontalChainReference(this);
                } else if (i2 == 2) {
                    horizontalChainReference = new VerticalChainReference(this);
                } else if (i2 == 3) {
                    horizontalChainReference = new AlignHorizontallyReference(this);
                } else if (i2 == 4) {
                    horizontalChainReference = new AlignVerticallyReference(this);
                } else if (i2 != 5) {
                    helperReference = new HelperReference(this, helper);
                    this.mHelperReferences.put(obj, helperReference);
                } else {
                    horizontalChainReference = new BarrierReference(this);
                }
                helperReference = horizontalChainReference;
                this.mHelperReferences.put(obj, helperReference);
            }
            return helperReference;
        }
        return (HelperReference) invokeLL.objValue;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, objArr)) == null) {
            HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
            horizontalChainReference.add(objArr);
            return horizontalChainReference;
        }
        return (HorizontalChainReference) invokeL.objValue;
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? guideline(obj, 0) : (GuidelineReference) invokeL.objValue;
    }

    public void map(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, obj, obj2) == null) {
            constraints(obj).setView(obj2);
        }
    }

    public Reference reference(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) ? this.mReferences.get(obj) : (Reference) invokeL.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mHelperReferences.clear();
        }
    }

    public State setHeight(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dimension)) == null) {
            this.mParent.setHeight(dimension);
            return this;
        }
        return (State) invokeL.objValue;
    }

    public State setWidth(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, dimension)) == null) {
            this.mParent.setWidth(dimension);
            return this;
        }
        return (State) invokeL.objValue;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, objArr)) == null) {
            VerticalChainReference verticalChainReference = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
            verticalChainReference.add(objArr);
            return verticalChainReference;
        }
        return (VerticalChainReference) invokeL.objValue;
    }

    public GuidelineReference verticalGuideline(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) ? guideline(obj, 1) : (GuidelineReference) invokeL.objValue;
    }

    public State width(Dimension dimension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, dimension)) == null) ? setWidth(dimension) : (State) invokeL.objValue;
    }
}
