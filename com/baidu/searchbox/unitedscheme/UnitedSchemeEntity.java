package com.baidu.searchbox.unitedscheme;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class UnitedSchemeEntity implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final String UNITED_SCHEME;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean callbackInvoked;
    public boolean mOnlyVerify;
    public String mPageUrl;
    public HashMap<String, String> mParams;
    public int mPathLevel;
    public String[] mPaths;
    public String mReferUrl;
    public String mSource;
    public Uri mUri;
    public UnitedSchemeEntity originEntity;
    public JSONObject result;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615156285, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-615156285, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;");
                return;
            }
        }
        UNITED_SCHEME = SchemeConfig.getSchemeHead() + "://";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnitedSchemeEntity(Uri uri) {
        this(uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String getAllPath() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Uri uri = this.mUri;
            if (uri != null) {
                if (UnitedSchemeUtility.hasVersion(uri) && (path = this.mUri.getPath()) != null && path.length() > 1) {
                    return this.mUri.getPath().substring(1);
                }
                return this.mUri.getHost() + this.mUri.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getFirstPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String[] strArr = this.mPaths;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return strArr[0];
        }
        return (String) invokeV.objValue;
    }

    public String getPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPageUrl : (String) invokeV.objValue;
    }

    public String getParam(String str) {
        InterceptResult invokeL;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null || (hashMap = this.mParams) == null) {
                return null;
            }
            return hashMap.get(str);
        }
        return (String) invokeL.objValue;
    }

    public HashMap<String, String> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mParams : (HashMap) invokeV.objValue;
    }

    public String getPath(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (this.mPaths != null) {
                if (z) {
                    this.mPathLevel++;
                }
                int i2 = this.mPathLevel;
                if (i2 >= 0) {
                    String[] strArr = this.mPaths;
                    if (i2 < strArr.length) {
                        return strArr[i2];
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public String getReferUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mReferUrl : (String) invokeV.objValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSource : (String) invokeV.objValue;
    }

    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUri : (Uri) invokeV.objValue;
    }

    public boolean isAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPathLevel == this.mPaths.length - 1 : invokeV.booleanValue;
    }

    public boolean isCallbackInvoked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.callbackInvoked : invokeV.booleanValue;
    }

    public boolean isOnlyVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mOnlyVerify : invokeV.booleanValue;
    }

    public void markCallbackInvoked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.callbackInvoked = true;
            for (UnitedSchemeEntity unitedSchemeEntity = this.originEntity; unitedSchemeEntity != null; unitedSchemeEntity = unitedSchemeEntity.originEntity) {
                unitedSchemeEntity.callbackInvoked = true;
            }
        }
    }

    public void putParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            if (this.mParams == null) {
                this.mParams = new HashMap<>();
            }
            this.mParams.put(str, str2);
        }
    }

    public String removeParam(String str) {
        InterceptResult invokeL;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (str == null || (hashMap = this.mParams) == null) {
                return null;
            }
            return hashMap.remove(str);
        }
        return (String) invokeL.objValue;
    }

    public void replaceAllPath(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) || (uri = this.mUri) == null || str == null || str2 == null) {
            return;
        }
        String replace = uri.toString().replace(str, str2);
        if (TextUtils.isEmpty(replace)) {
            return;
        }
        Uri parse = Uri.parse(replace);
        this.mUri = parse;
        this.mPaths = UnitedSchemeUtility.getPaths(parse);
    }

    public void resetUriAndPath(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, uri) == null) {
            this.mUri = uri;
            this.mPaths = UnitedSchemeUtility.getPaths(uri);
        }
    }

    public void setOnlyVerify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mOnlyVerify = z;
        }
    }

    public void setPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mPageUrl = str;
        }
    }

    public void setReferUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mReferUrl = str;
        }
    }

    public UnitedSchemeEntity(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mPathLevel = -1;
        this.mOnlyVerify = false;
        this.callbackInvoked = false;
        if (uri != null) {
            this.mSource = str;
            this.mUri = uri;
            this.mPaths = UnitedSchemeUtility.getPaths(uri);
            this.mParams = UnitedSchemeUtility.getParams(uri.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public UnitedSchemeEntity m43clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.mUri;
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, this.mSource, UnitedSchemeUtility.getPaths(uri), (HashMap) this.mParams.clone());
            unitedSchemeEntity.originEntity = this;
            unitedSchemeEntity.callbackInvoked = this.callbackInvoked;
            unitedSchemeEntity.mReferUrl = this.mReferUrl;
            return unitedSchemeEntity;
        }
        return (UnitedSchemeEntity) invokeV.objValue;
    }

    public UnitedSchemeEntity(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mPathLevel = -1;
        this.mOnlyVerify = false;
        this.callbackInvoked = false;
        if (uri != null) {
            this.mUri = uri;
            this.mSource = str;
            this.mPaths = strArr;
            this.mParams = hashMap;
        }
    }
}
