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
import java.util.Set;
/* loaded from: classes2.dex */
public class SharedPreferencesEditorWarpper implements SharedPreferences.Editor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor mBase;
    public Context mContext;
    public String mHandleSharedPlatformName;
    public int mIsMainProcess;
    public boolean mIsPlatformShared;
    public String mPreferenceName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesEditorWarpper(Context context, SharedPreferences.Editor editor, String str, boolean z, int i) {
        this(context, editor, str, z, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editor, str, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (SharedPreferences.Editor) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Bundle callProviderPut(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bundle)) == null) {
            try {
                bundle.putString(SharedPreferenceManager.PROVIDER_CALL_PREFERENCE_BUNDLE_NAME, this.mPreferenceName);
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
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mIsMainProcess == 1) {
            if ((!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName)) && (editor = this.mBase) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("This editor not allow to call clear.");
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        InterceptResult invokeV;
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mIsMainProcess != 1 || ((this.mIsPlatformShared && !TextUtils.isEmpty(this.mHandleSharedPlatformName)) || (editor = this.mBase) == null)) {
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            try {
                if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                    if (this.mBase != null && this.mBase != null) {
                        this.mBase.putBoolean(str, z);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("operation", SharedPreferenceManager.OPERATION_PUT_BOOLEAN);
                    bundle.putString("key", str);
                    bundle.putBoolean("value", z);
                    callProviderPut(bundle);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f)) == null) {
            try {
                if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                    if (this.mBase != null && this.mBase != null) {
                        this.mBase.putFloat(str, f);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("operation", SharedPreferenceManager.OPERATION_PUT_FLOAT);
                    bundle.putString("key", str);
                    bundle.putFloat("value", f);
                    callProviderPut(bundle);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            try {
                if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                    if (this.mBase != null && this.mBase != null) {
                        this.mBase.putInt(str, i);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("operation", SharedPreferenceManager.OPERATION_PUT_INT);
                    bundle.putString("key", str);
                    bundle.putInt("value", i);
                    callProviderPut(bundle);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            try {
                if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                    if (this.mBase != null && this.mBase != null) {
                        this.mBase.putLong(str, j);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("operation", SharedPreferenceManager.OPERATION_PUT_LONG);
                    bundle.putString("key", str);
                    bundle.putLong("value", j);
                    callProviderPut(bundle);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
                if (this.mIsMainProcess == 1 && (!this.mIsPlatformShared || TextUtils.isEmpty(this.mHandleSharedPlatformName))) {
                    if (this.mBase != null && this.mBase != null) {
                        this.mBase.putString(str, str2);
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("operation", SharedPreferenceManager.OPERATION_PUT_STRING);
                    bundle.putString("key", str);
                    bundle.putString("value", str2);
                    callProviderPut(bundle);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            throw new RuntimeException("This editor not allow to call putStringSet.");
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            throw new RuntimeException("This editor not allow to call remove.");
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    public SharedPreferencesEditorWarpper(Context context, SharedPreferences.Editor editor, String str, boolean z, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editor, str, Boolean.valueOf(z), Integer.valueOf(i), str2};
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
        this.mBase = editor;
        this.mIsMainProcess = i;
        this.mPreferenceName = str;
        this.mIsPlatformShared = z;
        this.mHandleSharedPlatformName = str2;
    }
}
