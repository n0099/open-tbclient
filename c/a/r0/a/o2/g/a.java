package c.a.r0.a.o2.g;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8204g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f8205f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975116427, "Lc/a/r0/a/o2/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975116427, "Lc/a/r0/a/o2/g/a;");
                return;
            }
        }
        f8204g = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8205f = new HashSet();
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) ? k(str) ? super.getBoolean(str, z) : d(str, z) : invokeLZ.booleanValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f2)) == null) ? k(str) ? super.getFloat(str, f2) : e(str, f2) : invokeLF.floatValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) ? k(str) ? super.getInt(str, i2) : f(str, i2) : invokeLI.intValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) ? k(str) ? super.getLong(str, j2) : g(str, j2) : invokeLJ.longValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? k(str) ? super.getString(str, str2) : i(str, str2) : (String) invokeLL.objValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f8205f.contains(str) : invokeL.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f8204g) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            illegalAccessException.toString();
            illegalAccessException.printStackTrace();
        }
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putBoolean(str, z);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f2)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putFloat(str, f2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putInt(str, i2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j2)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putLong(str, j2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putString(str, str2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, set)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.putStringSet(str, set);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, c.a.r0.w.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSharedPreferenceChangeListener) == null) {
            if (j()) {
                super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            } else {
                l();
            }
        }
    }

    @Override // c.a.r0.a.o2.g.b, c.a.r0.a.o2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!j() && !k(str)) {
                l();
            } else {
                super.remove(str);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    @Override // c.a.r0.a.o2.g.g, c.a.r0.w.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onSharedPreferenceChangeListener) == null) {
            if (j()) {
                super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            } else {
                l();
            }
        }
    }
}
