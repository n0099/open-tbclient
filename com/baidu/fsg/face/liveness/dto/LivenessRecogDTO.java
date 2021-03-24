package com.baidu.fsg.face.liveness.dto;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessRecogDTO extends SapiBiometricDto {
    public static final int IMAGE_FLAG_CUTIMAGE = 1;
    public static final int IMAGE_FLAG_ORIGINIMAGE = 2;
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
    public boolean soundSwitch = false;
    public boolean randomLiveness = false;
    public boolean recordLiveness = false;
    public boolean switchVideo = false;
    public boolean recordAudio = false;
    public LivenessRecogType livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;
    public String livenessServiceId = "1";
    public String imageFlag = "0";

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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    private int returnImageFlag() {
        SapiBiometricDto a2 = c.a().a("request_data");
        if (a2 == null || !(a2 instanceof LivenessRecogDTO)) {
            return 0;
        }
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) a2;
        if (TextUtils.isEmpty(livenessRecogDTO.imageFlag)) {
            return 0;
        }
        try {
            return Integer.parseInt(livenessRecogDTO.imageFlag);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String getAccessToken() {
        HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
        return sPParamsHashmap != null ? sPParamsHashmap.get("access_token") : "";
    }

    public String getAtbc() {
        if (TextUtils.isEmpty(this.bduss)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bduss=" + this.bduss);
        sb.append(";stoken=" + this.stoken);
        return PayUtils.encrypt("phone_number", sb.toString());
    }

    public String getCertInfo() {
        if (TextUtils.isEmpty(this.realName) || TextUtils.isEmpty(this.idCardNum)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.realName);
            jSONObject.put("cert", this.idCardNum);
            jSONObject.put("bankmobile", this.phoneNum);
            return PayUtils.encrypt("phone_number", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getSpno() {
        HashMap<String, String> sPParamsHashmap = getSPParamsHashmap();
        return sPParamsHashmap != null ? sPParamsHashmap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID) : "";
    }

    public boolean isReturnCutImage() {
        return (returnImageFlag() & 1) == 1;
    }

    public boolean isReturnOriginImage() {
        return (returnImageFlag() & 2) == 2;
    }

    public boolean isVideoRecog() {
        return !TextUtils.isEmpty(this.livenessServiceId) && this.livenessServiceId.equals("2");
    }
}
