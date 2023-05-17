package com.baidu.down.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.CommonParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class IdentityManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "IdentityManager";
    public static IdentityManager sIdentityManager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mCuid;
    public String mEncodeCuid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1603873015, "Lcom/baidu/down/utils/IdentityManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1603873015, "Lcom/baidu/down/utils/IdentityManager;");
        }
    }

    public IdentityManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
    }

    public static synchronized IdentityManager getInstance(Context context) {
        InterceptResult invokeL;
        IdentityManager identityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (IdentityManager.class) {
                if (sIdentityManager == null) {
                    sIdentityManager = new IdentityManager(context);
                }
                identityManager = sIdentityManager;
            }
            return identityManager;
        }
        return (IdentityManager) invokeL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public String getEncodedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.mEncodeCuid)) {
                return this.mEncodeCuid;
            }
            String encodedValue = Utils.getEncodedValue(getUid());
            if (!TextUtils.isEmpty(encodedValue)) {
                byte[] encode = Base64.encode(encodedValue.getBytes(), 0);
                if (encode != null) {
                    this.mEncodeCuid = Utils.getEncodedValue(new String(encode));
                }
            } else {
                this.mEncodeCuid = "";
            }
            return this.mEncodeCuid;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.mCuid)) {
                return this.mCuid;
            }
            String string = DownPrefUtils.getString(this.mContext, "uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                try {
                    string = CommonParam.getCUID(this.mContext);
                } catch (Exception unused) {
                }
                DownPrefUtils.setString(this.mContext, "uid_v3", string);
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public String processCommonParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            UriHelper uriHelper = new UriHelper(str);
            uriHelper.addParameterReplaceIfExist("from", "as");
            uriHelper.addParameterReplaceIfExist("sdk_ver", Constants.SDK_VER);
            uriHelper.addParameterReplaceIfExist("uid", getInstance(this.mContext).getEncodedUid());
            uriHelper.addParameterReplaceIfExist("network", Utils.getWifiOr2gOr3G(this.mContext));
            try {
                PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                uriHelper.addParameterReplaceIfExist("ver", packageInfo.versionCode + "");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return uriHelper.toString();
        }
        return (String) invokeL.objValue;
    }
}
