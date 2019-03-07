package com.baidu.pass.biometrics.face.liveness.dto;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PassFaceRecogDTO extends PassBiometricDto {
    public static final int IMAGE_FLAG_CUT_AND_ORIGIN_IMAGE = 3;
    public static final int IMAGE_FLAG_CUT_IMAGE = 1;
    public static final int IMAGE_FLAG_ORIGIN_IMAGE = 2;
    public static final int IMAGE_FLAG_WITHOUT_IMAGE = 0;
    public static final String KEY_EXTRA_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXTRA_PASS_PRODUCT_ID = "sp_no";
    public String authToken;
    public String bduss;
    public String exUid;
    public String idCardNum;
    public String passProductId;
    public String phoneNum;
    public String processid;
    public String realName;
    public String serviceType;
    public String spParams;
    public String stoken;
    public String uid;
    public PassFaceRecogType livenessType = PassFaceRecogType.RECOG_TYPE_BDUSS;
    public Map<String, String> extraParamsMap = new HashMap();
    public String imageFlag = "0";

    public String getSpParams() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.extraParamsMap.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue());
                } else {
                    sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        return sb.toString();
    }

    public String getSpno() {
        return this.extraParamsMap.get(KEY_EXTRA_PASS_PRODUCT_ID);
    }

    public String getAccessToken() {
        return this.extraParamsMap.get("access_token");
    }

    public boolean isReturnOriginImage() {
        return (returnImageFlag() & 2) == 2;
    }

    public boolean isReturnCutImage() {
        return (returnImageFlag() & 1) == 1;
    }

    private int returnImageFlag() {
        PassBiometricDto cacheData = BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
        if (cacheData != null && (cacheData instanceof PassFaceRecogDTO)) {
            PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) cacheData;
            if (!TextUtils.isEmpty(passFaceRecogDTO.imageFlag)) {
                try {
                    return Integer.parseInt(passFaceRecogDTO.imageFlag);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
