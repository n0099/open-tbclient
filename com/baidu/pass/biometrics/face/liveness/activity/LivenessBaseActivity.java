package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.activity.BaseActivity;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes12.dex */
public class LivenessBaseActivity extends BaseActivity {
    public PassBiometricConfiguration configuration;
    protected PassFaceRecogDTO passFaceRecogDTO;

    @TargetApi(27)
    public void customLiuHai() {
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            try {
                Field declaredField = attributes.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                declaredField.setAccessible(true);
                declaredField.set(attributes, Integer.valueOf(WindowManager.LayoutParams.class.getField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt(WindowManager.LayoutParams.class)));
            } catch (Exception e) {
            }
            getWindow().setAttributes(attributes);
        }
    }

    public String getAtbc(PassFaceRecogDTO passFaceRecogDTO) {
        StringBuilder sb = new StringBuilder();
        if (passFaceRecogDTO != null) {
            sb.append("bduss=" + passFaceRecogDTO.bduss);
            sb.append(";stoken=" + passFaceRecogDTO.stoken);
        }
        return sb.toString();
    }

    public String getFaceDetectUrl() {
        return this.configuration.passDomain + PassBioEnv.FACE_DETECT_URI;
    }

    public String getPortraitContrastUrl() {
        return this.configuration.passDomain + PassBioEnv.GET_UPLOAD_PHOTO_CONTRAST_URI;
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("PassFaceRecogDTO");
            if (serializable != null && (serializable instanceof PassFaceRecogDTO)) {
                this.passFaceRecogDTO = (PassFaceRecogDTO) serializable;
                com.baidu.pass.biometrics.face.liveness.a.a.a().a("request_data", this.passFaceRecogDTO);
            }
        } else {
            this.passFaceRecogDTO = (PassFaceRecogDTO) com.baidu.pass.biometrics.face.liveness.a.a.a().a("request_data");
        }
        this.configuration = PassFaceRecogManager.getInstance().getConfiguration();
        customLiuHai();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("PassFaceRecogDTO", this.passFaceRecogDTO);
    }
}
