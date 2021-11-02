package com.baidu.mobads.container.adrequest;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.error.XAdErrorCodeTransformer;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class XAdResponseInfo implements IXAdResponseInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XAdResponseInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<IXAdInstanceInfo> adInstanceList;
    public int adsNum;
    public String baiduidOfCookie;
    public String defaultFillInThemeForStaticAds;
    public String errorCode;
    public String errorMessage;
    public String exp2;
    public String extentionActionExp;
    public int intIcon;
    public int latitude;
    public int longitude;
    public int lunpan;
    public JSONObject mOriginResponseObject;
    public long mTimeStamp;
    public Boolean openPointModeForWall;
    public String pointUnitForWall;
    public String requestId;

    /* JADX DEBUG: Throwable added to exception handler: 'JSONException', keep only Throwable */
    public XAdResponseInfo(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adsNum = 0;
        this.openPointModeForWall = Boolean.FALSE;
        this.lunpan = -1;
        this.intIcon = -1;
        this.adInstanceList = new ArrayList<>();
        this.mTimeStamp = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        this.mOriginResponseObject = jSONObject;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("ad");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.adInstanceList.add(new XAdInstanceInfoExt(optJSONArray.getJSONObject(i4)));
                }
            }
            this.adsNum = this.mOriginResponseObject.optInt("n", 0);
            this.longitude = this.mOriginResponseObject.optInt("x", 0);
            this.latitude = this.mOriginResponseObject.optInt("y", 0);
            this.openPointModeForWall = Boolean.valueOf(this.mOriginResponseObject.optInt("m", 0) == 1);
            this.pointUnitForWall = this.mOriginResponseObject.optString("u", "");
            this.exp2 = this.mOriginResponseObject.optString("exp2", StringUtil.EMPTY_ARRAY);
            this.extentionActionExp = this.mOriginResponseObject.optString("ext_act", StringUtil.EMPTY_ARRAY);
            this.lunpan = this.mOriginResponseObject.optInt("lunpan", -1);
            this.intIcon = this.mOriginResponseObject.optInt("intIcon", -1);
            this.baiduidOfCookie = this.mOriginResponseObject.optString("ck", "");
            this.requestId = this.mOriginResponseObject.optString(IAdRequestParam.REQ_ID);
            this.errorCode = this.mOriginResponseObject.optString("error_code", "");
            this.errorMessage = this.mOriginResponseObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
            this.defaultFillInThemeForStaticAds = this.mOriginResponseObject.getString(AdLandingpageOpen.EXTRA_LP_THEME);
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.adInstanceList : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getAdsNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.adsNum : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getBaiduidOfCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.baiduidOfCookie : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getDefaultFillInThemeForStaticAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.defaultFillInThemeForStaticAds : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? XAdErrorCodeTransformer.errorCodeConvert(this.errorCode) : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!TextUtils.isEmpty(this.errorMessage)) {
                return this.errorMessage;
            }
            String errorMsg = XAdErrorCodeTransformer.errorMsg(this.errorCode);
            if (errorMsg != null) {
                this.errorMessage = errorMsg;
            } else {
                this.errorMessage = "";
            }
            return this.errorMessage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getExp2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.exp2 : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getExtentionActionExp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.extentionActionExp : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getIntIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.intIcon : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getLunpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.lunpan : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public Boolean getOpenPointModeForWall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.openPointModeForWall : (Boolean) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getOriginResponseStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = this.mOriginResponseObject;
            return jSONObject != null ? jSONObject.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getPointUnitForWall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.pointUnitForWall : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.adInstanceList.size() > 0) {
                return this.adInstanceList.get(0);
            }
            return null;
        }
        return (IXAdInstanceInfo) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.requestId : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.adInstanceList = arrayList;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setAdsNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.adsNum = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setBaiduidOfCookie(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.baiduidOfCookie = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setDefaultFillInThemeForStaticAds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.defaultFillInThemeForStaticAds = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setErrorCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.errorCode = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setErrorMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.errorMessage = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setExp2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.exp2 = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setExtentionActionExp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.extentionActionExp = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setIntIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.intIcon = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setLunpan(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.lunpan = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setOpenPointModeForWall(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bool) == null) {
            this.openPointModeForWall = bool;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setOriginResponseStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setPointUnitForWall(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.pointUnitForWall = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setRequestId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.requestId = str;
        }
    }
}
