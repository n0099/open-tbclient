package c.a.k.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class e implements SharedPreferences, SharedPreferences.Editor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, e> f3345e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f3346b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f3347c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f3348d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1328758034, "Lc/a/k/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1328758034, "Lc/a/k/a/e;");
                return;
            }
        }
        f3345e = new HashMap();
    }

    public e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = b.a().getBaseContext();
        this.f3346b = str;
        if (TextUtils.isEmpty(str)) {
            this.f3346b = this.a.getPackageName() + "_preferences";
        }
        this.f3348d = new ConcurrentHashMap<>();
        f();
    }

    public static synchronized e e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (e.class) {
                if (TextUtils.isEmpty(str)) {
                    str = b.a().getPackageName() + "_preferences";
                }
                if (f3345e.containsKey(str)) {
                    return f3345e.get(str);
                }
                e eVar = new e(str);
                f3345e.put(str, eVar);
                return eVar;
            }
        }
        return (e) invokeL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f3347c.clear();
            f.e(this.f3346b);
            return this;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d();
            f.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.f3347c.containsKey(str)) {
                return true;
            }
            return this.a.getSharedPreferences(this.f3346b, 0).contains(str);
        }
        return invokeL.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                Log.d("BdPreferenceImpl", "modified size: " + this.f3348d.size());
                for (Map.Entry<String, Object> entry : this.f3348d.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Log.d("BdPreferenceImpl", "modified. key: " + key + " value: " + value);
                    if (key != null) {
                        if (value != null && value != this) {
                            if (this.f3347c.containsKey(key)) {
                                Object obj = this.f3347c.get(key);
                                Log.d("BdPreferenceImpl", "cache. key: " + key + " value: " + obj);
                                if (obj != null && obj.equals(value)) {
                                }
                            }
                            this.f3347c.put(key, value);
                            Log.d("BdPreferenceImpl", "write to file. key: " + key + " value: " + value);
                            f.c(this.f3346b, key, value);
                        }
                        this.f3347c.remove(key);
                        f.c(this.f3346b, key, null);
                    }
                }
                this.f3348d.clear();
            }
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (SharedPreferences.Editor) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f3347c = new ConcurrentHashMap<>();
            Map<String, ?> all = this.a.getSharedPreferences(this.f3346b, 0).getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.f3347c.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3347c : (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            if (this.f3347c.containsKey(str)) {
                return ((Boolean) this.f3347c.get(str)).booleanValue();
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, str, f2)) == null) {
            if (this.f3347c.containsKey(str)) {
                return ((Float) this.f3347c.get(str)).floatValue();
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (this.f3347c.containsKey(str)) {
                return ((Integer) this.f3347c.get(str)).intValue();
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, str, j)) == null) {
            if (this.f3347c.containsKey(str)) {
                return ((Long) this.f3347c.get(str)).longValue();
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (this.f3347c.containsKey(str)) {
                return (String) this.f3347c.get(str);
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, set)) == null) {
            if (this.f3347c.containsKey(str)) {
                return (Set) this.f3347c.get(str);
            }
            return this.a.getSharedPreferences(this.f3346b, 0).getStringSet(str, set);
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            if (str == null) {
                return this;
            }
            this.f3348d.put(str, Boolean.valueOf(z));
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048591, this, str, f2)) == null) {
            if (str == null) {
                return this;
            }
            this.f3348d.put(str, Float.valueOf(f2));
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i)) == null) {
            if (str == null) {
                return this;
            }
            this.f3348d.put(str, Integer.valueOf(i));
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j)) == null) {
            if (str == null) {
                return this;
            }
            this.f3348d.put(str, Long.valueOf(j));
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            if (str == null) {
                return this;
            }
            if (str2 == null) {
                remove(str);
            } else {
                this.f3348d.put(str, str2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, set)) == null) {
            if (str == null) {
                return this;
            }
            if (set == null) {
                remove(str);
            } else {
                this.f3348d.put(str, set);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onSharedPreferenceChangeListener) == null) {
            this.a.getSharedPreferences(this.f3346b, 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (str == null) {
                return this;
            }
            this.f3347c.remove(str);
            f.c(this.f3346b, str, null);
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onSharedPreferenceChangeListener) == null) {
            this.a.getSharedPreferences(this.f3346b, 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
