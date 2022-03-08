package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoDraftTempBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mFilterId;
    public String mPath;
    public float mSpeed;
    public String mStickerId;

    public VideoDraftTempBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static List<VideoDraftTempBean> arrayToBean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        VideoDraftTempBean videoDraftTempBean = new VideoDraftTempBean();
                        JSONObject jSONObject = new JSONObject((String) jSONArray.get(i2));
                        videoDraftTempBean.mPath = jSONObject.optString("path");
                        videoDraftTempBean.mSpeed = jSONObject.optInt("speed");
                        videoDraftTempBean.mStickerId = jSONObject.optString(FaceItem.DIR_STICKER);
                        videoDraftTempBean.mFilterId = jSONObject.optString(CloudControlRequest.REQUEST_KEY_FILTER);
                        arrayList.add(videoDraftTempBean);
                    }
                }
            } catch (JSONException unused) {
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static JSONArray getStickersFilters(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                if (jSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject = new JSONObject((String) jSONArray2.get(i3));
                        if (i2 == 1) {
                            String optString = jSONObject.optString(FaceItem.DIR_STICKER);
                            if (!TextUtils.isEmpty(optString) && !hashSet.contains(optString)) {
                                hashSet.add(optString);
                                jSONArray.put(optString);
                            }
                        } else if (i2 == 2) {
                            String optString2 = jSONObject.optString(CloudControlRequest.REQUEST_KEY_FILTER);
                            if (!TextUtils.isEmpty(optString2) && !hashSet.contains(optString2)) {
                                hashSet.add(optString2);
                                jSONArray.put(optString2);
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
            }
            return jSONArray;
        }
        return (JSONArray) invokeLI.objValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("path", this.mPath);
                jSONObject.put("speed", this.mSpeed);
                jSONObject.put(FaceItem.DIR_STICKER, this.mStickerId);
                jSONObject.put(CloudControlRequest.REQUEST_KEY_FILTER, this.mFilterId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String toJsonString(VideoDraftTempBean videoDraftTempBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, videoDraftTempBean)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("path", videoDraftTempBean.mPath);
                jSONObject.put("speed", videoDraftTempBean.mSpeed);
                jSONObject.put(FaceItem.DIR_STICKER, videoDraftTempBean.mStickerId);
                jSONObject.put(CloudControlRequest.REQUEST_KEY_FILTER, videoDraftTempBean.mFilterId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
