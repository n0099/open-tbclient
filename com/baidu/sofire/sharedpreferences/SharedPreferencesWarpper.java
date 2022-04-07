package com.baidu.sofire.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.ProviderAccessUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class SharedPreferencesWarpper implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences mBase;
    public Context mContext;
    public SharedPreferences.Editor mEditor;
    public String mHandleSharedPlatformName;
    public int mIsMainProcess;
    public boolean mIsPlatformShared;
    public String mPreferenceName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesWarpper(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i) {
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

    private Bundle callProviderGet(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, str2, str3)) == null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("operation", str);
                bundle.putString(SharedPreferenceManager.PROVIDER_CALL_PREFERENCE_BUNDLE_NAME, this.mPreferenceName);
                bundle.putString("key", str2);
                bundle.putString(SharedPreferenceManager.PROVIDER_CALL_PREFERENCE_BUNDLE_DEFULT_VALUE, str3);
                if (this.mIsPlatformShared) {
                    if (TextUtils.isEmpty(this.mHandleSharedPlatformName)) {
                        return ProviderAccessUtil.callPrivateProvider(this.mContext, SharedPreferenceManager.PROVIDER_METHOD_CALL_PREFERENCE, bundle);
                    }
                    return ProviderAccessUtil.callTargetSharedProvider(this.mContext, SharedPreferenceManager.PROVIDER_METHOD_CALL_PREFERENCE, bundle, this.mHandleSharedPlatformName);
                }
                return ProviderAccessUtil.callPrivateProvider(this.mContext, SharedPreferenceManager.PROVIDER_METHOD_CALL_PREFERENCE, bundle);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            throw new RuntimeException("This preference not allow to call contains.");
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SharedPreferences.Editor editor = this.mEditor;
            if (editor != null) {
                return editor;
            }
            SharedPreferences sharedPreferences = this.mBase;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("This preference not allow to call getAll.");
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                return this.mBase == null ? z : this.mBase.getBoolean(str, z);
            }
            Bundle callProviderGet = callProviderGet(SharedPreferenceManager.OPERATION_GET_BOOLEAN, str, String.valueOf(z));
            if (callProviderGet != null) {
                return callProviderGet.getBoolean("result", z);
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                return this.mBase == null ? f : this.mBase.getFloat(str, f);
            }
            Bundle callProviderGet = callProviderGet(SharedPreferenceManager.OPERATION_GET_FLOAT, str, String.valueOf(f));
            if (callProviderGet != null) {
                return callProviderGet.getFloat("result", f);
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                return this.mBase == null ? i : this.mBase.getInt(str, i);
            }
            Bundle callProviderGet = callProviderGet(SharedPreferenceManager.OPERATION_GET_INT, str, String.valueOf(i));
            if (callProviderGet != null) {
                return callProviderGet.getInt("result", i);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                return this.mBase == null ? j : this.mBase.getLong(str, j);
            }
            Bundle callProviderGet = callProviderGet(SharedPreferenceManager.OPERATION_GET_LONG, str, String.valueOf(j));
            if (callProviderGet != null) {
                return callProviderGet.getLong("result", j);
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                return this.mBase == null ? str2 : this.mBase.getString(str, str2);
            }
            Bundle callProviderGet = callProviderGet(SharedPreferenceManager.OPERATION_GET_STRING, str, str2);
            if (callProviderGet != null) {
                return callProviderGet.getString("result", str2);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            throw new RuntimeException("This preference not allow to call getStringSet.");
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onSharedPreferenceChangeListener) == null) {
            try {
                if (this.mBase != null) {
                    this.mBase.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onSharedPreferenceChangeListener) == null) {
            try {
                if (this.mBase != null) {
                    this.mBase.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public SharedPreferencesWarpper(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i, String str2) {
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
        this.mContext = context;
        this.mIsMainProcess = i;
        this.mBase = sharedPreferences;
        this.mEditor = new SharedPreferencesEditorWarpper(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.mIsMainProcess, str2);
        this.mIsPlatformShared = z;
        this.mPreferenceName = str;
        this.mHandleSharedPlatformName = str2;
    }
}
