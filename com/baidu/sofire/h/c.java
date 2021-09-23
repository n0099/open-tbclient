package com.baidu.sofire.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.w;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class c implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f45443a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45444b;

    /* renamed from: c  reason: collision with root package name */
    public int f45445c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f45446d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45447e;

    /* renamed from: f  reason: collision with root package name */
    public String f45448f;

    /* renamed from: g  reason: collision with root package name */
    public String f45449g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, SharedPreferences sharedPreferences, String str, int i2) {
        this(context, sharedPreferences, str, false, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sharedPreferences, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (SharedPreferences) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Bundle a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, str2, str3)) == null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
                bundle.putString("pref_name", this.f45448f);
                bundle.putString("key", str2);
                bundle.putString("defult_value", str3);
                if (this.f45447e) {
                    if (TextUtils.isEmpty(this.f45449g)) {
                        return w.a(this.f45444b, "CallPreferences", bundle);
                    }
                    return w.b(this.f45444b, "CallPreferences", bundle, this.f45449g);
                }
                return w.a(this.f45444b, "CallPreferences", bundle);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            throw new RuntimeException("This preference not allow to call contains.");
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SharedPreferences.Editor editor = this.f45446d;
            if (editor != null) {
                return editor;
            }
            SharedPreferences sharedPreferences = this.f45443a;
            if (sharedPreferences != null) {
                return sharedPreferences.edit();
            }
            return null;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("This preference not allow to call getAll.");
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (this.f45445c == 1 && (!this.f45447e || TextUtils.isEmpty(this.f45449g))) {
                return this.f45443a == null ? z : this.f45443a.getBoolean(str, z);
            }
            Bundle a2 = a("getBoolean", str, String.valueOf(z));
            if (a2 != null) {
                return a2.getBoolean("result", z);
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (this.f45445c == 1 && (!this.f45447e || TextUtils.isEmpty(this.f45449g))) {
                return this.f45443a == null ? f2 : this.f45443a.getFloat(str, f2);
            }
            Bundle a2 = a("getFloat", str, String.valueOf(f2));
            if (a2 != null) {
                return a2.getFloat("result", f2);
            }
            return f2;
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (this.f45445c == 1 && (!this.f45447e || TextUtils.isEmpty(this.f45449g))) {
                return this.f45443a == null ? i2 : this.f45443a.getInt(str, i2);
            }
            Bundle a2 = a("getInt", str, String.valueOf(i2));
            if (a2 != null) {
                return a2.getInt("result", i2);
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (this.f45445c == 1 && (!this.f45447e || TextUtils.isEmpty(this.f45449g))) {
                return this.f45443a == null ? j2 : this.f45443a.getLong(str, j2);
            }
            Bundle a2 = a("getLong", str, String.valueOf(j2));
            if (a2 != null) {
                return a2.getLong("result", j2);
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (this.f45445c == 1 && (!this.f45447e || TextUtils.isEmpty(this.f45449g))) {
                return this.f45443a == null ? str2 : this.f45443a.getString(str, str2);
            }
            Bundle a2 = a("getString", str, str2);
            if (a2 != null) {
                return a2.getString("result", str2);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            throw new RuntimeException("This preference not allow to call getStringSet.");
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onSharedPreferenceChangeListener) == null) {
            try {
                if (this.f45443a != null) {
                    this.f45443a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onSharedPreferenceChangeListener) == null) {
            try {
                if (this.f45443a != null) {
                    this.f45443a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sharedPreferences, str, Boolean.valueOf(z), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45444b = context;
        this.f45445c = i2;
        this.f45443a = sharedPreferences;
        this.f45446d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.f45445c);
        this.f45447e = z;
        this.f45448f = str;
        this.f45449g = str2;
    }
}
