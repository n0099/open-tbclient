package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricOperation;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.base.dynamicupdate.SoManager;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.a.a;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
/* loaded from: classes11.dex */
public class PassFaceRecogManager implements PassBiometric {

    /* renamed from: a  reason: collision with root package name */
    private static final long f2723a = 300;
    private static PassFaceRecogManager b;
    private PassBiometricConfiguration c;
    private PassFaceRecogCallback d;
    private long e;

    private PassFaceRecogManager() {
    }

    private void a(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (passFaceRecogDTO == null) {
            passFaceRecogResult.setResultCode(-205);
            if (passFaceRecogCallback != null) {
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return;
            }
            return;
        }
        PassFaceRecogType passFaceRecogType = passFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                passFaceRecogResult.setResultCode(101);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(passFaceRecogDTO.realName) || TextUtils.isEmpty(passFaceRecogDTO.idCardNum)) && TextUtils.isEmpty(passFaceRecogDTO.getAccessToken())) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogDTO.exUid = "1";
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
            passFaceRecogResult.setResultCode(-205);
            if (passFaceRecogCallback != null) {
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return;
            }
            return;
        }
        this.d = passFaceRecogCallback;
        Intent intent = new Intent(context, LivenessRecogActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    private boolean b() {
        return System.currentTimeMillis() - this.e < 300;
    }

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (b == null) {
                b = new PassFaceRecogManager();
            }
            passFaceRecogManager = b;
        }
        return passFaceRecogManager;
    }

    public void cleanPassFaceRecogCallback() {
        this.d = null;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration != null) {
            if (!TextUtils.isEmpty(passBiometricConfiguration.tpl) && !TextUtils.isEmpty(passBiometricConfiguration.appId) && !TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
                this.c = passBiometricConfiguration;
                ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
                BeanConstants.tpl = passBiometricConfiguration.tpl;
                BeanConstants.appid = passBiometricConfiguration.appId;
                BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
                SoManager.checkVersion(getInstance().getConfiguration());
                return;
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }
        throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        if (passBiometricCallback == null) {
            throw new IllegalArgumentException(PassBiometricCallback.class.getSimpleName() + " can't be null");
        }
        if (passBiometricOperation == null) {
            throw new IllegalArgumentException(PassBiometricOperation.class.getSimpleName() + " can't be null");
        }
        if (passBiometricDto != null) {
            if (((PassFaceOperation) passBiometricOperation).operationType == PassFaceOperation.OperationType.RECOGNIZE && !b()) {
                a();
                PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
                a(passFaceRecogDTO);
                a((PassFaceRecogCallback) passBiometricCallback, passFaceRecogDTO, context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(PassBiometricDto.class.getSimpleName() + " can't be null");
    }

    public PassBiometricConfiguration getConfiguration() {
        return this.c;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.d;
    }

    private void a(PassFaceRecogDTO passFaceRecogDTO) {
        if (TextUtils.isEmpty(passFaceRecogDTO.passProductId) && (passFaceRecogDTO.extraParamsMap.isEmpty() || TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID)))) {
            throw new IllegalArgumentException("PassFaceRecogDTO.passProductId can't be empty");
        }
        if (TextUtils.isEmpty(passFaceRecogDTO.serviceType)) {
            passFaceRecogDTO.serviceType = "1008";
        }
        if (TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID))) {
            passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, passFaceRecogDTO.passProductId);
        }
        passFaceRecogDTO.processid = PassBiometricUtil.getUUID();
        a.a().a("request_data", passFaceRecogDTO);
    }

    private void a() {
        this.e = System.currentTimeMillis();
    }
}
