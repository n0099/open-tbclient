package com.baidu.sapi2.biometrics.liveness.activity;

import android.os.Bundle;
import com.baidu.fsg.base.activity.BeanActivity;
import com.baidu.fsg.biometrics.base.c.a;
import com.baidu.sapi2.biometrics.liveness.SapiLivenessRecogManager;
import com.baidu.sapi2.biometrics.liveness.beans.b;
import com.baidu.sapi2.biometrics.liveness.callback.LivenessRecogCallback;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LivenessBaseActivity extends BeanActivity {
    protected LivenessRecogDTO livenessRecogDTO;

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("LivenessRecogDTO");
            if (serializable != null && (serializable instanceof LivenessRecogDTO)) {
                this.livenessRecogDTO = (LivenessRecogDTO) serializable;
                b.a().a(b.a, this.livenessRecogDTO);
            }
        } else {
            this.livenessRecogDTO = (LivenessRecogDTO) b.a().a(b.a);
        }
        if (this.livenessRecogDTO == null) {
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            if (livenessRecogCallback != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-206);
                livenessRecogResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
                livenessRecogCallback.b(livenessRecogResult);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("LivenessRecogDTO", this.livenessRecogDTO);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }
}
