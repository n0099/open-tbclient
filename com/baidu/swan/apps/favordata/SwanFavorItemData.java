package com.baidu.swan.apps.favordata;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.NoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xl2;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SwanFavorItemData implements Serializable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IS_NEW_FAVOR = 1;
    public static final int IS_NOT_NEW_FAVOR = 0;
    public static final String SCHEME_AUTHORITY_SWAN_APP = "swan";
    public static final String SCHEME_AUTHORITY_SWAN_GAME = "swangame";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAppFrameType;
    public String mAppKey;
    public String mAppName;
    public int mAppPayProtected;
    public int mAppType;
    public long mCreateTime;
    public String mIconUrl;
    public int mIndex;
    public int mIsNewFavor;

    public SwanFavorItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppKey = "";
        this.mAppName = "";
        this.mIconUrl = "";
        this.mAppType = 0;
        this.mAppFrameType = -1;
        this.mAppPayProtected = 0;
        this.mIsNewFavor = 0;
    }

    public int getAppFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppFrameType : invokeV.intValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAppKey : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    public int getAppType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppType : invokeV.intValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCreateTime : invokeV.longValue;
    }

    public int getFrameTypeFromScheme(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String authority = Uri.parse(str).getAuthority();
            if (authority != null) {
                int hashCode = authority.hashCode();
                if (hashCode != -319738621) {
                    if (hashCode == 3543441 && authority.equals("swan")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (authority.equals(SCHEME_AUTHORITY_SWAN_GAME)) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c != 0) {
                    return c != 1 ? -1 : 1;
                }
                return 0;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIconUrl : (String) invokeV.objValue;
    }

    public int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIndex : invokeV.intValue;
    }

    public int getIsNewFavor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsNewFavor : invokeV.intValue;
    }

    public int getPayProtected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAppPayProtected : invokeV.intValue;
    }

    public String getSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? TextUtils.isEmpty(str) ? "" : xl2.h1(getAppKey(), str, getAppFrameType()) : (String) invokeL.objValue;
    }

    public void setAppFrameType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mAppFrameType = i;
        }
    }

    public void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mAppKey = str;
        }
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mAppName = str;
        }
    }

    public void setAppType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mAppType = i;
        }
    }

    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mIconUrl = str;
        }
    }

    public void setIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mIndex = i;
        }
    }

    public void setIsNewFavor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mIsNewFavor = i;
        }
    }

    public void setPayProtected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mAppPayProtected = i;
        }
    }
}
