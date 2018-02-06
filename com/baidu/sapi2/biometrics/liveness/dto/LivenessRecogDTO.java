package com.baidu.sapi2.biometrics.liveness.dto;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.biometrics.base.dto.SapiBiometricDto;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessRecogDTO extends SapiBiometricDto {
    public String authToken;
    public String bduss;
    public String exUid;
    public String idCardNum;
    public String phoneNum;
    public String processid;
    public String realName;
    public String serviceType;
    public String spParams;
    public String stoken;
    public String uid;
    public boolean showGuidePage = true;
    public LivenessRecogType livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;

    public String getSpno() {
        HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
        return sPParamsHashmap != null ? sPParamsHashmap.get("sp_no") : "";
    }

    public String getAccessToken() {
        HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
        return sPParamsHashmap != null ? sPParamsHashmap.get("access_token") : "";
    }

    private HashMap<String, String> getSPParamsHashmap() {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.spParams)) {
            try {
                String[] split2 = this.spParams.split("&");
                if (split2 != null && split2.length > 0) {
                    for (String str : split2) {
                        if (str != null && (split = str.split("=")) != null && split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getAtbc() {
        if (TextUtils.isEmpty(this.bduss)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bduss=" + this.bduss);
        sb.append(";stoken=" + this.stoken);
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }

    public String getCertInfo() {
        if (!TextUtils.isEmpty(this.realName) && !TextUtils.isEmpty(this.idCardNum)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.realName);
                jSONObject.put("cert", this.idCardNum);
                jSONObject.put("bankmobile", this.phoneNum);
                return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
