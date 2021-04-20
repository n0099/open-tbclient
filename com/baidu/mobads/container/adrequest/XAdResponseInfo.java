package com.baidu.mobads.container.adrequest;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.error.XAdErrorCodeTransformer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdResponseInfo implements IXAdResponseInfo {
    public static final String TAG = "XAdResponseInfo";
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
    public Boolean openPointModeForWall;
    public String pointUnitForWall;
    public String requestId;
    public ArrayList<IXAdInstanceInfo> adInstanceList = new ArrayList<>();
    public long mTimeStamp = System.currentTimeMillis();

    /* JADX DEBUG: Throwable added to exception handler: 'JSONException', keep only Throwable */
    public XAdResponseInfo(String str) throws JSONException {
        this.adsNum = 0;
        this.openPointModeForWall = Boolean.FALSE;
        this.lunpan = -1;
        this.intIcon = -1;
        JSONObject jSONObject = new JSONObject(str);
        this.mOriginResponseObject = jSONObject;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("ad");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.adInstanceList.add(new XAdInstanceInfoExt(optJSONArray.getJSONObject(i)));
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
            this.errorMessage = this.mOriginResponseObject.optString("error_msg", "");
            this.defaultFillInThemeForStaticAds = this.mOriginResponseObject.getString(AdLandingpageOpen.EXTRA_LP_THEME);
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.adInstanceList;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getAdsNum() {
        return this.adsNum;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getBaiduidOfCookie() {
        return this.baiduidOfCookie;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getDefaultFillInThemeForStaticAds() {
        return this.defaultFillInThemeForStaticAds;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getErrorCode() {
        return XAdErrorCodeTransformer.errorCodeConvert(this.errorCode);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getErrorMessage() {
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

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getExp2() {
        return this.exp2;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getExtentionActionExp() {
        return this.extentionActionExp;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getIntIcon() {
        return this.intIcon;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public int getLunpan() {
        return this.lunpan;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public Boolean getOpenPointModeForWall() {
        return this.openPointModeForWall;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getOriginResponseStr() {
        JSONObject jSONObject = this.mOriginResponseObject;
        return jSONObject != null ? jSONObject.toString() : "";
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getPointUnitForWall() {
        return this.pointUnitForWall;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        if (this.adInstanceList.size() > 0) {
            return this.adInstanceList.get(0);
        }
        return null;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.adInstanceList = arrayList;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setAdsNum(int i) {
        this.adsNum = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setBaiduidOfCookie(String str) {
        this.baiduidOfCookie = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setDefaultFillInThemeForStaticAds(String str) {
        this.defaultFillInThemeForStaticAds = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setExp2(String str) {
        this.exp2 = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setExtentionActionExp(String str) {
        this.extentionActionExp = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setIntIcon(int i) {
        this.intIcon = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setLunpan(int i) {
        this.lunpan = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setOpenPointModeForWall(Boolean bool) {
        this.openPointModeForWall = bool;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setOriginResponseStr(String str) {
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setPointUnitForWall(String str) {
        this.pointUnitForWall = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdResponseInfo
    public void setRequestId(String str) {
        this.requestId = str;
    }
}
