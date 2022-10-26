package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RetrieveReportRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_NAME = "imsdk";
    public static final String REPORT_HOST_ONLINE = "https://mbd.baidu.com/";
    public static final String REPORT_HOST_TEST = "http://10.26.139.34:8092/";
    public static final String TAG = "RetrieveReportRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String mFileMeta;
    public String mFileid;
    public String mJobId;
    public IReportListener mListener;
    public String mOrigin;
    public String mRetrieveType;
    public String mStatus;
    public String mValue;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public RetrieveReportRequest(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, IReportListener iReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, str6, str7, iReportListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mRetrieveType = str;
        this.mValue = str2;
        this.mJobId = str3;
        this.mStatus = str4;
        this.mOrigin = str5;
        this.mFileMeta = str6;
        this.mFileid = str7;
        this.mListener = iReportListener;
    }

    private String getRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            sb.append("appname=imsdk");
            sb.append("&uid=" + Utility.getDeviceId(this.mContext));
            return sb.toString();
        }
        return (String) invokeV.objValue;
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
            sb.append("fetchlog");
            LogUtils.d(TAG, "sign string:" + ((Object) sb));
            return getMd5(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, com.baidu.android.imsdk.internal.Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData != 1 && readIntData != 2 && readIntData != 3) {
                    str = null;
                } else {
                    str = REPORT_HOST_TEST;
                }
            } else {
                str = REPORT_HOST_ONLINE;
            }
            return str + "fetchlog/appupstream" + getRequestParam();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("type", this.mRetrieveType);
                jSONObject.put("value", this.mValue);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("jobid", this.mJobId);
                jSONObject.put("version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext)));
                jSONObject.put("status", this.mStatus);
                if (!TextUtils.isEmpty(this.mOrigin)) {
                    jSONObject.put("origin", this.mOrigin);
                }
                if (!TextUtils.isEmpty(this.mFileMeta)) {
                    jSONObject.put(UploadConstant.FILEMETA, this.mFileMeta);
                }
                if (!TextUtils.isEmpty(this.mFileid)) {
                    jSONObject.put("fileid", this.mFileid);
                }
                jSONObject.put("sign", generateSign(jSONObject));
                jSONObject2.put("req", jSONObject);
                LogUtils.d(TAG, "retrieve-->getRequestParameter:" + jSONObject2.toString());
            } catch (Exception e) {
                LogUtils.d(TAG, "retrieve-->getRequestParameter error:" + e.toString());
            }
            return jSONObject2.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, bArr, th) == null) {
            LogUtils.d(TAG, "任务上传失败");
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "retrieve-->onSuccess :" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("errno", "")) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    String optString = optJSONObject.optString("jobid", "");
                    String optString2 = optJSONObject.optString("valid", "");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString2.equals("1")) {
                        LogUtils.d(TAG, "retrieve-->start upload task");
                        if (this.mListener != null) {
                            this.mListener.onSuccess(new ReportResult(optString, optString2));
                        }
                    } else {
                        LogUtils.d(TAG, "可能是无效的任务，valid-》0无效：" + optString2);
                    }
                }
            } catch (Exception e) {
                LogUtils.d(TAG, e.toString());
            }
        }
    }
}
