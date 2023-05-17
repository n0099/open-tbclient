package com.baidu.tbadk.core.util.schemeaction;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UriBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_DEFAULT = 0;
    public static final String PARAMS = "params";
    public transient /* synthetic */ FieldHolder $fh;
    public int mEnterAnim;
    public int mExitAnim;
    public Bundle mExtra;
    public int mFlags;
    public boolean mFromWebView;
    public String mHost;
    public boolean mIsValidated;
    public Bundle mParamsObject;
    public String mPath;
    public int mRequestCode;
    public String mScheme;
    public int mSchemeFrom;
    public Object mTransObj;
    public Uri mUri;
    public Object mUriTransObj;

    public UriBuilder(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestCode = -1;
        this.mFlags = -1;
        this.mEnterAnim = -1;
        this.mExitAnim = -1;
        this.mFromWebView = false;
        this.mIsValidated = false;
        this.mSchemeFrom = 0;
        uri(uri);
    }

    public UriBuilder uri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, uri)) == null) {
            this.mUri = uri;
            if (uri != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.i("builder uri = " + uri);
                }
                this.mIsValidated = parseUri();
            } else if (BdLog.isDebugMode()) {
                BdLog.i("builder uri = null");
            }
            return this;
        }
        return (UriBuilder) invokeL.objValue;
    }

    public UriBuilder(String str) {
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
        this.mRequestCode = -1;
        this.mFlags = -1;
        this.mEnterAnim = -1;
        this.mExitAnim = -1;
        this.mFromWebView = false;
        this.mIsValidated = false;
        this.mSchemeFrom = 0;
        uri(str);
    }

    public UriBuilder uri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            Uri uri = null;
            try {
                if (!TextUtils.isEmpty(str)) {
                    uri = Uri.parse(str);
                }
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("builder uri e = " + th.toString());
                }
            }
            return uri(uri);
        }
        return (UriBuilder) invokeL.objValue;
    }

    public UriBuilder(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRequestCode = -1;
        this.mFlags = -1;
        this.mEnterAnim = -1;
        this.mExitAnim = -1;
        this.mFromWebView = false;
        this.mIsValidated = false;
        this.mSchemeFrom = 0;
        this.mUriTransObj = obj;
        uri(str);
    }

    private boolean parseUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            try {
                this.mScheme = this.mUri.getScheme();
                this.mHost = this.mUri.getHost();
                String path = this.mUri.getPath();
                this.mPath = path;
                if (!TextUtils.isEmpty(path) && this.mPath.endsWith("/")) {
                    this.mPath = this.mPath.substring(0, this.mPath.length() - 1);
                }
                Set<String> queryParameterNames = this.mUri.getQueryParameterNames();
                if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                    if (this.mExtra == null) {
                        this.mExtra = new Bundle();
                    }
                    if (this.mParamsObject == null) {
                        this.mParamsObject = new Bundle();
                    }
                    this.mExtra.clear();
                    this.mParamsObject.clear();
                    for (String str : queryParameterNames) {
                        String queryParameter = this.mUri.getQueryParameter(str);
                        if (TextUtils.equals(str, "params")) {
                            try {
                                JSONObject jSONObject = new JSONObject(queryParameter);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    String optString = jSONObject.optString(next, "");
                                    this.mExtra.putString(next, optString);
                                    this.mParamsObject.putString(next, optString);
                                }
                            } catch (Exception e) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("builder parseUri e = " + e.toString());
                                }
                            }
                        } else {
                            this.mExtra.putString(str, queryParameter);
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("builder parseUri te = " + th.toString());
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public UriBuilder extra(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            Bundle bundle2 = this.mExtra;
            if (bundle2 != null) {
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
            } else {
                this.mExtra = bundle;
            }
            return this;
        }
        return (UriBuilder) invokeL.objValue;
    }

    public UriBuilder flags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.mFlags = i;
            return this;
        }
        return (UriBuilder) invokeI.objValue;
    }

    public UriBuilder fromWebView(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.mFromWebView = z;
            return this;
        }
        return (UriBuilder) invokeZ.objValue;
    }

    public String getExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return getExtra(str, null);
        }
        return (String) invokeL.objValue;
    }

    public UriBuilder requestCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            this.mRequestCode = i;
            return this;
        }
        return (UriBuilder) invokeI.objValue;
    }

    public UriBuilder schemeFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.mSchemeFrom = i;
            return this;
        }
        return (UriBuilder) invokeI.objValue;
    }

    public void setTransObj(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            this.mTransObj = obj;
        }
    }

    public int getEnterAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEnterAnim;
        }
        return invokeV.intValue;
    }

    public int getExitAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExitAnim;
        }
        return invokeV.intValue;
    }

    public Bundle getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mExtra == null) {
                this.mExtra = new Bundle();
            }
            return this.mExtra;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mFlags;
        }
        return invokeV.intValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mHost;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getParamsObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mParamsObject;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mPath;
        }
        return (String) invokeV.objValue;
    }

    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mRequestCode;
        }
        return invokeV.intValue;
    }

    public String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mScheme;
        }
        return (String) invokeV.objValue;
    }

    public int getSchemeFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mSchemeFrom;
        }
        return invokeV.intValue;
    }

    public Object getTransObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTransObj;
        }
        return invokeV.objValue;
    }

    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mUri;
        }
        return (Uri) invokeV.objValue;
    }

    public String getUriString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Uri uri = this.mUri;
            if (uri != null) {
                return uri.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Object getUriTransObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mUriTransObj;
        }
        return invokeV.objValue;
    }

    public boolean isFromWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mFromWebView;
        }
        return invokeV.booleanValue;
    }

    public boolean isValidated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mIsValidated;
        }
        return invokeV.booleanValue;
    }

    public String getExtra(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            Bundle bundle = this.mExtra;
            if (bundle != null) {
                return bundle.getString(str, str2);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public UriBuilder transitionAnim(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i, i2)) == null) {
            this.mEnterAnim = i;
            this.mExitAnim = i2;
            return this;
        }
        return (UriBuilder) invokeII.objValue;
    }
}
