package c.a.w.b.f;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public class d implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f30378a;

    @JvmOverloads
    public d(Context context, String fileName) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fileName};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.f30378a = context.getSharedPreferences(fileName, 0);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.contains(str);
        }
        return invokeL.booleanValue;
    }

    public final void e(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            sharedPreferences.edit().putLong(str, j2).apply();
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public final void f(String key, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, key, str) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            sharedPreferences.edit().putString(key, str).apply();
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            sharedPreferences.edit().remove(str).apply();
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getAll();
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getLong(str, j2);
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, set)) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences.getStringSet(str, set);
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onSharedPreferenceChangeListener) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSharedPreferenceChangeListener) == null) {
            SharedPreferences sharedPreferences = this.f30378a;
            Intrinsics.checkNotNull(sharedPreferences);
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
