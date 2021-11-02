package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdElementInfo> mAdList;
    public int mAdsNum;

    public AdResponseInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdsNum = 0;
        this.mAdList = new ArrayList();
    }

    public static AdResponseInfo fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            AdResponseInfo adResponseInfo = new AdResponseInfo();
            if (TextUtils.isEmpty(str)) {
                return adResponseInfo;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (str != null) {
                    adResponseInfo.mAdsNum = jSONObject.optInt("n", 0);
                    adResponseInfo.mAdList = AdElementInfo.fromJsonArray(jSONObject.optJSONArray("ad"));
                    return adResponseInfo;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return adResponseInfo;
        }
        return (AdResponseInfo) invokeL.objValue;
    }

    public List<AdElementInfo> getAdInstanceInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdList : (List) invokeV.objValue;
    }
}
