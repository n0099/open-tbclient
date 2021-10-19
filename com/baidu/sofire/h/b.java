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
import java.util.Set;
/* loaded from: classes6.dex */
public final class b implements SharedPreferences.Editor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f45349a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45350b;

    /* renamed from: c  reason: collision with root package name */
    public int f45351c;

    /* renamed from: d  reason: collision with root package name */
    public String f45352d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45353e;

    /* renamed from: f  reason: collision with root package name */
    public String f45354f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i2) {
        this(context, editor, str, z, i2, (byte) 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editor, str, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (SharedPreferences.Editor) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Byte) objArr2[5]).byteValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bundle)) == null) {
            try {
                bundle.putString("pref_name", this.f45352d);
                if (this.f45353e) {
                    if (TextUtils.isEmpty(this.f45354f)) {
                        return w.a(this.f45350b, "CallPreferences", bundle);
                    }
                    return w.b(this.f45350b, "CallPreferences", bundle, this.f45354f);
                }
                return w.a(this.f45350b, "CallPreferences", bundle);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45351c == 1) {
            if ((!this.f45353e || TextUtils.isEmpty(this.f45354f)) && (editor = this.f45349a) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("This editor not allow to call clear.");
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        InterceptResult invokeV;
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f45351c != 1 || ((this.f45353e && !TextUtils.isEmpty(this.f45354f)) || (editor = this.f45349a) == null)) {
                return true;
            }
            return editor.commit();
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            try {
                if (this.f45351c == 1 && (!this.f45353e || TextUtils.isEmpty(this.f45354f))) {
                    if (this.f45349a != null && this.f45349a != null) {
                        this.f45349a.putBoolean(str, z);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putBoolean");
                    bundle.putString("key", str);
                    bundle.putBoolean("value", z);
                    a(bundle);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
            try {
                if (this.f45351c == 1 && (!this.f45353e || TextUtils.isEmpty(this.f45354f))) {
                    if (this.f45349a != null && this.f45349a != null) {
                        this.f45349a.putFloat(str, f2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putFloat");
                    bundle.putString("key", str);
                    bundle.putFloat("value", f2);
                    a(bundle);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            try {
                if (this.f45351c == 1 && (!this.f45353e || TextUtils.isEmpty(this.f45354f))) {
                    if (this.f45349a != null && this.f45349a != null) {
                        this.f45349a.putInt(str, i2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putInt");
                    bundle.putString("key", str);
                    bundle.putInt("value", i2);
                    a(bundle);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
            try {
                if (this.f45351c == 1 && (!this.f45353e || TextUtils.isEmpty(this.f45354f))) {
                    if (this.f45349a != null && this.f45349a != null) {
                        this.f45349a.putLong(str, j2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putLong");
                    bundle.putString("key", str);
                    bundle.putLong("value", j2);
                    a(bundle);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
                if (this.f45351c == 1 && (!this.f45353e || TextUtils.isEmpty(this.f45354f))) {
                    if (this.f45349a != null && this.f45349a != null) {
                        this.f45349a.putString(str, str2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putString");
                    bundle.putString("key", str);
                    bundle.putString("value", str2);
                    a(bundle);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            throw new RuntimeException("This editor not allow to call putStringSet.");
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            throw new RuntimeException("This editor not allow to call remove.");
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i2, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editor, str, Boolean.valueOf(z), Integer.valueOf(i2), Byte.valueOf(b2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45350b = context;
        this.f45349a = editor;
        this.f45351c = i2;
        this.f45352d = str;
        this.f45353e = z;
        this.f45354f = null;
    }
}
