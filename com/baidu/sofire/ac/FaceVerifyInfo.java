package com.baidu.sofire.ac;

import android.text.TextUtils;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.utility.c;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceVerifyInfo implements IFaceProcessInfo {
    public String idCardNumber;
    public FaceEnum.LivenessControl livenessControl;
    public String name;
    public String nation;
    public String phoneNumber;
    public FaceEnum.QualityControl qualityControl;
    public FaceEnum.SpoofingControl spoofingControl;
    public int verifyType;

    public FaceVerifyInfo(String str, String str2, int i2, String str3, FaceEnum.LivenessControl livenessControl, FaceEnum.SpoofingControl spoofingControl, FaceEnum.QualityControl qualityControl, String str4) {
        this.idCardNumber = str;
        this.name = str2;
        this.verifyType = i2;
        this.nation = str3;
        this.livenessControl = livenessControl;
        this.spoofingControl = spoofingControl;
        this.qualityControl = qualityControl;
        this.phoneNumber = str4;
    }

    @Override // com.baidu.sofire.ac.IFaceProcessInfo
    public JSONObject buildJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.idCardNumber)) {
                jSONObject.put("id_card_number", this.idCardNumber);
            }
            if (!TextUtils.isEmpty(this.name)) {
                jSONObject.put("name", URLEncoder.encode(this.name, "UTF-8"));
            }
            jSONObject.put("verify_type", String.valueOf(this.verifyType));
            if (this.nation != null) {
                jSONObject.put("nation", this.nation);
            }
            if (this.livenessControl != null) {
                jSONObject.put("liveness_control", this.livenessControl.name());
            }
            if (this.spoofingControl != null) {
                jSONObject.put("spoofing_control", this.spoofingControl.name());
            }
            if (this.qualityControl != null) {
                jSONObject.put("quality_control", this.qualityControl.name());
            }
            if (this.phoneNumber != null) {
                jSONObject.put("phone", this.phoneNumber);
            }
            return jSONObject;
        } catch (Throwable unused) {
            c.a();
            return null;
        }
    }
}
