package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.activity.BaseActivity;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.a.a;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class LivenessBaseActivity extends BaseActivity {
    public PassBiometricConfiguration mConfiguration;
    public PassFaceRecogDTO mPassFaceRecogDTO;

    public String getFaceDetectUrl() {
        return this.mConfiguration.passDomain + PassBioEnv.FACE_DETECT_URI;
    }

    public String getLivingActionUrl() {
        return this.mConfiguration.passDomain + PassBioEnv.LIVING_ACTION;
    }

    public String getPortraitContrastUrl() {
        return this.mConfiguration.passDomain + PassBioEnv.GET_UPLOAD_PHOTO_CONTRAST_URI;
    }

    @TargetApi(27)
    public void customLiuHai() {
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            try {
                Field declaredField = attributes.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                declaredField.setAccessible(true);
                declaredField.set(attributes, Integer.valueOf(WindowManager.LayoutParams.class.getField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt(WindowManager.LayoutParams.class)));
            } catch (Exception unused) {
            }
            getWindow().setAttributes(attributes);
        }
    }

    public String getAtbc(PassFaceRecogDTO passFaceRecogDTO) {
        StringBuilder sb = new StringBuilder();
        if (passFaceRecogDTO != null) {
            sb.append("bduss=");
            sb.append(passFaceRecogDTO.bduss);
            sb.append(";stoken=");
            sb.append(passFaceRecogDTO.stoken);
        }
        return sb.toString();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("PassFaceRecogDTO", this.mPassFaceRecogDTO);
    }

    public void setActivityResult(int i) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i, intent);
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("PassFaceRecogDTO");
            if (serializable instanceof PassFaceRecogDTO) {
                this.mPassFaceRecogDTO = (PassFaceRecogDTO) serializable;
                a.b().a(a.c, this.mPassFaceRecogDTO);
            }
        } else {
            this.mPassFaceRecogDTO = (PassFaceRecogDTO) a.b().a(a.c);
        }
        this.mConfiguration = PassFaceRecogManager.getInstance().getConfiguration();
        customLiuHai();
    }
}
