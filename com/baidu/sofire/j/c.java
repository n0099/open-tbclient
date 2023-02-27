package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.s;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class c implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public Context b;
    public int c;
    public SharedPreferences.Editor d;
    public boolean e;
    public String f;
    public String g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i) {
        this(context, sharedPreferences, str, z, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sharedPreferences, str, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (SharedPreferences) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i, String str2) {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sharedPreferences, str, Boolean.valueOf(z), Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = i;
        this.a = sharedPreferences;
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else {
            editor = null;
        }
        this.d = new b(context, editor, str, z, this.c, null);
        this.e = z;
        this.f = str;
        this.g = null;
    }

    public final Bundle a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
                bundle.putString("pref_name", this.f);
                bundle.putString("key", str2);
                bundle.putString("defult_value", str3);
                if (this.e) {
                    if (TextUtils.isEmpty(this.g)) {
                        return s.a(this.b, "CallPreferences", bundle, "sofire");
                    }
                    return s.a(this.b, "CallPreferences", bundle, this.g);
                }
                return s.a(this.b, "CallPreferences", bundle, "sofire");
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            throw new RuntimeException("This preference not allow to call contains.");
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onSharedPreferenceChangeListener) == null) {
            try {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences != null) {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onSharedPreferenceChangeListener) == null) {
            try {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences != null) {
                    sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences.Editor editor = this.d;
            if (editor != null) {
                return editor;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                return sharedPreferences.edit();
            }
            return null;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("This preference not allow to call getAll.");
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences == null) {
                    return z;
                }
                return sharedPreferences.getBoolean(str, z);
            }
            Bundle a = a("getBoolean", str, String.valueOf(z));
            if (a != null) {
                return a.getBoolean("result", z);
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, str, f)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences == null) {
                    return f;
                }
                return sharedPreferences.getFloat(str, f);
            }
            Bundle a = a("getFloat", str, String.valueOf(f));
            if (a != null) {
                return a.getFloat("result", f);
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences == null) {
                    return i;
                }
                return sharedPreferences.getInt(str, i);
            }
            Bundle a = a("getInt", str, String.valueOf(i));
            if (a != null) {
                return a.getInt("result", i);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences == null) {
                    return j;
                }
                return sharedPreferences.getLong(str, j);
            }
            Bundle a = a("getLong", str, String.valueOf(j));
            if (a != null) {
                return a.getLong("result", j);
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences == null) {
                    return str2;
                }
                return sharedPreferences.getString(str, str2);
            }
            Bundle a = a("getString", str, str2);
            if (a != null) {
                return a.getString("result", str2);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
            throw new RuntimeException("This preference not allow to call getStringSet.");
        }
        return (Set) invokeLL.objValue;
    }
}
