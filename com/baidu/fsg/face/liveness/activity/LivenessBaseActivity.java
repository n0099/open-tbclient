package com.baidu.fsg.face.liveness.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.fsg.base.activity.BeanActivity;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class LivenessBaseActivity extends BeanActivity {
    public LivenessRecogDTO livenessRecogDTO;

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

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    public boolean isSupportLiuHai() {
        return true;
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("LivenessRecogDTO");
            if (serializable != null && (serializable instanceof LivenessRecogDTO)) {
                this.livenessRecogDTO = (LivenessRecogDTO) serializable;
                c.a().a("request_data", this.livenessRecogDTO);
            }
        } else {
            this.livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        }
        if (isSupportLiuHai()) {
            customLiuHai();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("LivenessRecogDTO", this.livenessRecogDTO);
    }

    public void showNoNetWorkDialog() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.rim_liveness_no_network_tip));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.rim_liveness_network_set), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessBaseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                try {
                    LivenessBaseActivity.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.rim_liveness_cancle), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessBaseActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }
}
