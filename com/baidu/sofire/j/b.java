package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.o;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes3.dex */
public class b implements SharedPreferences.Editor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor a;
    public Context b;
    public int c;
    public String d;
    public boolean e;
    public String f;

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editor, str, Boolean.valueOf(z), Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.a = editor;
        this.c = i;
        this.d = str;
        this.e = z;
        this.f = str2;
    }

    public final Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            try {
                bundle.putString("pref_name", this.d);
                if (this.e) {
                    if (TextUtils.isEmpty(this.f)) {
                        return o.a(this.b, "CallPreferences", bundle, "sofire");
                    }
                    return o.a(this.b, "CallPreferences", bundle, this.f);
                }
                return o.a(this.b, "CallPreferences", bundle, "sofire");
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c == 1) {
            if ((!this.e || TextUtils.isEmpty(this.f)) && (editor = this.a) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("This editor not allow to call clear.");
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        InterceptResult invokeV;
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c != 1 || ((this.e && !TextUtils.isEmpty(this.f)) || (editor = this.a) == null)) {
                return true;
            }
            return editor.commit();
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            try {
                if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.f))) {
                    SharedPreferences.Editor editor = this.a;
                    if (editor == null) {
                        return this;
                    }
                    if (editor != null) {
                        editor.putBoolean(str, z);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putBoolean");
                    bundle.putString("key", str);
                    bundle.putBoolean("value", z);
                    a(bundle);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, str, f)) == null) {
            try {
                if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.f))) {
                    SharedPreferences.Editor editor = this.a;
                    if (editor == null) {
                        return this;
                    }
                    if (editor != null) {
                        editor.putFloat(str, f);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putFloat");
                    bundle.putString("key", str);
                    bundle.putFloat("value", f);
                    a(bundle);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            try {
                if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.f))) {
                    SharedPreferences.Editor editor = this.a;
                    if (editor == null) {
                        return this;
                    }
                    if (editor != null) {
                        editor.putInt(str, i);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putInt");
                    bundle.putString("key", str);
                    bundle.putInt("value", i);
                    a(bundle);
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
            try {
                if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.f))) {
                    SharedPreferences.Editor editor = this.a;
                    if (editor == null) {
                        return this;
                    }
                    if (editor != null) {
                        editor.putLong(str, j);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putLong");
                    bundle.putString("key", str);
                    bundle.putLong("value", j);
                    a(bundle);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            try {
                if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.f))) {
                    SharedPreferences.Editor editor = this.a;
                    if (editor == null) {
                        return this;
                    }
                    if (editor != null) {
                        editor.putString(str, str2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putString");
                    bundle.putString("key", str);
                    bundle.putString("value", str2);
                    a(bundle);
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
            throw new RuntimeException("This editor not allow to call putStringSet.");
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            throw new RuntimeException("This editor not allow to call remove.");
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }
}
