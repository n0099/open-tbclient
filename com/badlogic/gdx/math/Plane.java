package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Plane implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1240652082930747866L;
    public transient /* synthetic */ FieldHolder $fh;
    public float d;
    public final Vector3 normal;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class PlaneSide {
        public static final /* synthetic */ PlaneSide[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlaneSide Back;
        public static final PlaneSide Front;
        public static final PlaneSide OnPlane;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1266220249, "Lcom/badlogic/gdx/math/Plane$PlaneSide;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1266220249, "Lcom/badlogic/gdx/math/Plane$PlaneSide;");
                    return;
                }
            }
            OnPlane = new PlaneSide("OnPlane", 0);
            Back = new PlaneSide("Back", 1);
            PlaneSide planeSide = new PlaneSide("Front", 2);
            Front = planeSide;
            $VALUES = new PlaneSide[]{OnPlane, Back, planeSide};
        }

        public PlaneSide(String str, int i) {
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

        public static PlaneSide valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PlaneSide) Enum.valueOf(PlaneSide.class, str);
            }
            return (PlaneSide) invokeL.objValue;
        }

        public static PlaneSide[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PlaneSide[]) $VALUES.clone();
            }
            return (PlaneSide[]) invokeV.objValue;
        }
    }

    public Plane() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.normal = new Vector3();
        this.d = 0.0f;
    }

    public float getD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public Vector3 getNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.normal;
        }
        return (Vector3) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.normal.toString() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.d;
        }
        return (String) invokeV.objValue;
    }

    public Plane(Vector3 vector3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Vector3 vector32 = new Vector3();
        this.normal = vector32;
        this.d = 0.0f;
        vector32.set(vector3).m20nor();
        this.d = f;
    }

    public Plane(Vector3 vector3, Vector3 vector32) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, vector32};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Vector3 vector33 = new Vector3();
        this.normal = vector33;
        this.d = 0.0f;
        vector33.set(vector3).m20nor();
        this.d = -this.normal.dot(vector32);
    }

    public Plane(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, vector32, vector33};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.normal = new Vector3();
        this.d = 0.0f;
        set(vector3, vector32, vector33);
    }

    public void set(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vector3, vector32, vector33) == null) {
            this.normal.set(vector3).sub(vector32).crs(vector32.x - vector33.x, vector32.y - vector33.y, vector32.z - vector33.z).m20nor();
            this.d = -vector3.dot(this.normal);
        }
    }

    public float distance(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vector3)) == null) {
            return this.normal.dot(vector3) + this.d;
        }
        return invokeL.floatValue;
    }

    public boolean isFrontFacing(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vector3)) == null) {
            if (this.normal.dot(vector3) <= 0.0f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void set(Plane plane) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, plane) == null) {
            this.normal.set(plane.normal);
            this.d = plane.d;
        }
    }

    public PlaneSide testPoint(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, vector3)) == null) {
            float dot = this.normal.dot(vector3) + this.d;
            if (dot == 0.0f) {
                return PlaneSide.OnPlane;
            }
            if (dot < 0.0f) {
                return PlaneSide.Back;
            }
            return PlaneSide.Front;
        }
        return (PlaneSide) invokeL.objValue;
    }

    public void set(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.normal.set(f, f2, f3);
            this.d = f4;
        }
    }

    public void set(float f, float f2, float f3, float f4, float f5, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            this.normal.set(f4, f5, f6);
            this.d = -((f * f4) + (f2 * f5) + (f3 * f6));
        }
    }

    public void set(Vector3 vector3, Vector3 vector32) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, vector3, vector32) == null) {
            this.normal.set(vector32);
            this.d = -vector3.dot(vector32);
        }
    }

    public PlaneSide testPoint(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float dot = this.normal.dot(f, f2, f3) + this.d;
            if (dot == 0.0f) {
                return PlaneSide.OnPlane;
            }
            if (dot < 0.0f) {
                return PlaneSide.Back;
            }
            return PlaneSide.Front;
        }
        return (PlaneSide) invokeCommon.objValue;
    }
}
