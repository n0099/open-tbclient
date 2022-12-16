package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseHttpRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mIsNeedSaveToDb;
    public int mPriority;
    public int mType;
    public String mUUId;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public abstract String getHost();

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 15000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new byte[0] : (byte[]) invokeV.objValue;
    }

    public abstract void onFailure(int i, byte[] bArr, Throwable th);

    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, bArr) == null) {
        }
    }

    public void saveRequestToDB(Context context, BaseHttpRequest baseHttpRequest, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, baseHttpRequest, str) == null) {
        }
    }

    public BaseHttpRequest() {
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
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public BaseHttpRequest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
        this.mIsNeedSaveToDb = z;
    }

    public static String getHostUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
            if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return "https://pim.baidu.com/";
                    }
                    return Constants.URL_HTTP_BOX;
                }
                return Constants.URL_HTTP_QA;
            }
            return "http://rd-im-server.bcc-szth.baidu.com:8080/";
        }
        return (String) invokeL.objValue;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return Utility.byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public void setUUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mUUId = str;
        }
    }

    public String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            TreeSet<String> treeSet = new TreeSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                treeSet.add(keys.next());
            }
            for (String str : treeSet) {
                sb.append(str);
                sb.append("=");
                sb.append(jSONObject.opt(str));
            }
            return getMd5(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public String getUUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mUUId;
        }
        return (String) invokeV.objValue;
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        InterceptResult invokeILL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i, bArr, th)) == null) {
            if (bArr != null) {
                str = new String(bArr);
            } else {
                str = "";
            }
            if (th == null && i != 1005) {
                str = "http response is error! response code:" + i;
                i = 1011;
            }
            return new Pair<>(Integer.valueOf(i), str);
        }
        return (Pair) invokeILL.objValue;
    }
}
