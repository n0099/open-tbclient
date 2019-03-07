package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.activity.BaseActivity;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.view.BioAlertDialog;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class LivenessBaseActivity extends BaseActivity {
    public PassBiometricConfiguration configuration;
    protected PassFaceRecogDTO passFaceRecogDTO;

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("PassFaceRecogDTO");
            if (serializable != null && (serializable instanceof PassFaceRecogDTO)) {
                this.passFaceRecogDTO = (PassFaceRecogDTO) serializable;
                BeanDataCache.getInstance().addToCache(BeanDataCache.KEY, this.passFaceRecogDTO);
            }
        } else {
            this.passFaceRecogDTO = (PassFaceRecogDTO) BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
        }
        this.configuration = PassFaceRecogManager.getInstance().getConfiguration();
        customLiuHai();
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("PassFaceRecogDTO", this.passFaceRecogDTO);
    }

    protected void showNoNetWorkDialog() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.pass_liveness_no_network_tip));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.pass_liveness_network_set), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                try {
                    LivenessBaseActivity.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.pass_liveness_cancle), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
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

    public String getPortraitContrastUrl() {
        return this.configuration.passDomain + PassBioEnv.GET_UPLOAD_PHOTO_CONTRAST_URI;
    }

    public String getFaceDetectUrl() {
        return this.configuration.passDomain + PassBioEnv.FACE_DETECT_URI;
    }
}
