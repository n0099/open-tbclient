package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Dimension {
    public static /* synthetic */ Interceptable $ic;
    public static final Object FIXED_DIMENSION;
    public static final Object PARENT_DIMENSION;
    public static final Object PERCENT_DIMENSION;
    public static final Object SPREAD_DIMENSION;
    public static final Object WRAP_DIMENSION;
    public transient /* synthetic */ FieldHolder $fh;
    public final int WRAP_CONTENT;
    public Object mInitialValue;
    public boolean mIsSuggested;
    public int mMax;
    public int mMin;
    public float mPercent;
    public float mRatio;
    public int mValue;

    public Dimension ratio(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) ? this : (Dimension) invokeF.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type FIXED;
        public static final Type MATCH_CONSTRAINT;
        public static final Type MATCH_PARENT;
        public static final Type WRAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-344322505, "Landroidx/constraintlayout/solver/state/Dimension$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-344322505, "Landroidx/constraintlayout/solver/state/Dimension$Type;");
                    return;
                }
            }
            FIXED = new Type("FIXED", 0);
            WRAP = new Type("WRAP", 1);
            MATCH_PARENT = new Type("MATCH_PARENT", 2);
            Type type = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = type;
            $VALUES = new Type[]{FIXED, WRAP, MATCH_PARENT, type};
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Type) Enum.valueOf(Type.class, str);
            }
            return (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Type[]) $VALUES.clone();
            }
            return (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-290954175, "Landroidx/constraintlayout/solver/state/Dimension;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-290954175, "Landroidx/constraintlayout/solver/state/Dimension;");
                return;
            }
        }
        FIXED_DIMENSION = new Object();
        WRAP_DIMENSION = new Object();
        SPREAD_DIMENSION = new Object();
        PARENT_DIMENSION = new Object();
        PERCENT_DIMENSION = new Object();
    }

    public Dimension() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public Dimension(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }

    public static Dimension Fixed(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            Dimension dimension = new Dimension(FIXED_DIMENSION);
            dimension.fixed(i);
            return dimension;
        }
        return (Dimension) invokeI.objValue;
    }

    public static Dimension Suggested(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            Dimension dimension = new Dimension();
            dimension.suggested(i);
            return dimension;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension fixed(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.mInitialValue = null;
            this.mValue = i;
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension max(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.mMax >= 0) {
                this.mMax = i;
            }
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension min(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i >= 0) {
                this.mMin = i;
            }
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public void setRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            this.mRatio = f;
        }
    }

    public void setValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mIsSuggested = false;
            this.mInitialValue = null;
            this.mValue = i;
        }
    }

    public Dimension suggested(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.mIsSuggested = true;
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public static Dimension Fixed(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            Dimension dimension = new Dimension(FIXED_DIMENSION);
            dimension.fixed(obj);
            return dimension;
        }
        return (Dimension) invokeL.objValue;
    }

    public static Dimension Suggested(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            Dimension dimension = new Dimension();
            dimension.suggested(obj);
            return dimension;
        }
        return (Dimension) invokeL.objValue;
    }

    public Dimension fixed(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            this.mInitialValue = obj;
            if (obj instanceof Integer) {
                this.mValue = ((Integer) obj).intValue();
                this.mInitialValue = null;
            }
            return this;
        }
        return (Dimension) invokeL.objValue;
    }

    public Dimension max(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            Object obj2 = WRAP_DIMENSION;
            if (obj == obj2 && this.mIsSuggested) {
                this.mInitialValue = obj2;
                this.mMax = Integer.MAX_VALUE;
            }
            return this;
        }
        return (Dimension) invokeL.objValue;
    }

    public Dimension min(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == WRAP_DIMENSION) {
                this.mMin = -2;
            }
            return this;
        }
        return (Dimension) invokeL.objValue;
    }

    public Dimension suggested(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            this.mInitialValue = obj;
            this.mIsSuggested = true;
            return this;
        }
        return (Dimension) invokeL.objValue;
    }

    public static Dimension Parent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new Dimension(PARENT_DIMENSION);
        }
        return (Dimension) invokeV.objValue;
    }

    public static Dimension Spread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new Dimension(SPREAD_DIMENSION);
        }
        return (Dimension) invokeV.objValue;
    }

    public static Dimension Wrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return new Dimension(WRAP_DIMENSION);
        }
        return (Dimension) invokeV.objValue;
    }

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRatio;
        }
        return invokeV.floatValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mValue;
        }
        return invokeV.intValue;
    }

    public static Dimension Percent(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65542, null, obj, f)) == null) {
            Dimension dimension = new Dimension(PERCENT_DIMENSION);
            dimension.percent(obj, f);
            return dimension;
        }
        return (Dimension) invokeLF.objValue;
    }

    public Dimension percent(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, obj, f)) == null) {
            this.mPercent = f;
            return this;
        }
        return (Dimension) invokeLF.objValue;
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, state, constraintWidget, i) == null) {
            int i2 = 2;
            if (i == 0) {
                if (this.mIsSuggested) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    Object obj = this.mInitialValue;
                    if (obj == WRAP_DIMENSION) {
                        i2 = 1;
                    } else if (obj != PERCENT_DIMENSION) {
                        i2 = 0;
                    }
                    constraintWidget.setHorizontalMatchStyle(i2, this.mMin, this.mMax, this.mPercent);
                    return;
                }
                int i3 = this.mMin;
                if (i3 > 0) {
                    constraintWidget.setMinWidth(i3);
                }
                int i4 = this.mMax;
                if (i4 < Integer.MAX_VALUE) {
                    constraintWidget.setMaxWidth(i4);
                }
                Object obj2 = this.mInitialValue;
                if (obj2 == WRAP_DIMENSION) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                } else if (obj2 == PARENT_DIMENSION) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                } else if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                }
            } else if (this.mIsSuggested) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj3 = this.mInitialValue;
                if (obj3 == WRAP_DIMENSION) {
                    i2 = 1;
                } else if (obj3 != PERCENT_DIMENSION) {
                    i2 = 0;
                }
                constraintWidget.setVerticalMatchStyle(i2, this.mMin, this.mMax, this.mPercent);
            } else {
                int i5 = this.mMin;
                if (i5 > 0) {
                    constraintWidget.setMinHeight(i5);
                }
                int i6 = this.mMax;
                if (i6 < Integer.MAX_VALUE) {
                    constraintWidget.setMaxHeight(i6);
                }
                Object obj4 = this.mInitialValue;
                if (obj4 == WRAP_DIMENSION) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                } else if (obj4 == PARENT_DIMENSION) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                } else if (obj4 == null) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setHeight(this.mValue);
                }
            }
        }
    }
}
