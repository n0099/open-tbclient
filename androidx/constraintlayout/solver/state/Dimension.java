package androidx.constraintlayout.solver.state;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static Dimension Fixed(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            Dimension dimension = new Dimension(FIXED_DIMENSION);
            dimension.fixed(i2);
            return dimension;
        }
        return (Dimension) invokeI.objValue;
    }

    public static Dimension Parent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new Dimension(PARENT_DIMENSION) : (Dimension) invokeV.objValue;
    }

    public static Dimension Percent(Object obj, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, null, obj, f2)) == null) {
            Dimension dimension = new Dimension(PERCENT_DIMENSION);
            dimension.percent(obj, f2);
            return dimension;
        }
        return (Dimension) invokeLF.objValue;
    }

    public static Dimension Spread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new Dimension(SPREAD_DIMENSION) : (Dimension) invokeV.objValue;
    }

    public static Dimension Suggested(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            Dimension dimension = new Dimension();
            dimension.suggested(i2);
            return dimension;
        }
        return (Dimension) invokeI.objValue;
    }

    public static Dimension Wrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new Dimension(WRAP_DIMENSION) : (Dimension) invokeV.objValue;
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, state, constraintWidget, i2) == null) {
            int i3 = 2;
            if (i2 == 0) {
                if (this.mIsSuggested) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    Object obj = this.mInitialValue;
                    if (obj == WRAP_DIMENSION) {
                        i3 = 1;
                    } else if (obj != PERCENT_DIMENSION) {
                        i3 = 0;
                    }
                    constraintWidget.setHorizontalMatchStyle(i3, this.mMin, this.mMax, this.mPercent);
                    return;
                }
                int i4 = this.mMin;
                if (i4 > 0) {
                    constraintWidget.setMinWidth(i4);
                }
                int i5 = this.mMax;
                if (i5 < Integer.MAX_VALUE) {
                    constraintWidget.setMaxWidth(i5);
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
                    i3 = 1;
                } else if (obj3 != PERCENT_DIMENSION) {
                    i3 = 0;
                }
                constraintWidget.setVerticalMatchStyle(i3, this.mMin, this.mMax, this.mPercent);
            } else {
                int i6 = this.mMin;
                if (i6 > 0) {
                    constraintWidget.setMinHeight(i6);
                }
                int i7 = this.mMax;
                if (i7 < Integer.MAX_VALUE) {
                    constraintWidget.setMaxHeight(i7);
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

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRatio : invokeV.floatValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mValue : invokeV.intValue;
    }

    public Dimension max(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.mMax >= 0) {
                this.mMax = i2;
            }
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension min(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 >= 0) {
                this.mMin = i2;
            }
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension percent(Object obj, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, obj, f2)) == null) {
            this.mPercent = f2;
            return this;
        }
        return (Dimension) invokeLF.objValue;
    }

    public Dimension ratio(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f2)) == null) ? this : (Dimension) invokeF.objValue;
    }

    public void setRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.mRatio = f2;
        }
    }

    public void setValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mIsSuggested = false;
            this.mInitialValue = null;
            this.mValue = i2;
        }
    }

    public Dimension suggested(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.mIsSuggested = true;
            return this;
        }
        return (Dimension) invokeI.objValue;
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

    public Dimension fixed(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.mInitialValue = null;
            this.mValue = i2;
            return this;
        }
        return (Dimension) invokeI.objValue;
    }

    public Dimension(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
