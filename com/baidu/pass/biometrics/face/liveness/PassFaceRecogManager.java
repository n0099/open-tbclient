package com.baidu.pass.biometrics.face.liveness;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.pass.biometrics.face.liveness.activity.LivenessLoadingActivity;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
/* loaded from: classes2.dex */
public class PassFaceRecogManager implements PassBiometric {
    public static final long MAX_CALL_INTERNAL_TIME = 300;
    public static final String TAG = "SapiLivenessRecog";
    private static PassFaceRecogManager instance;
    private PassBiometricConfiguration configuration;
    private long lastCallTime;
    private PassFaceRecogCallback passFaceRecogCallback;
    private long startLoadingTime;

    private PassFaceRecogManager() {
    }

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (instance == null) {
                instance = new PassFaceRecogManager();
            }
            passFaceRecogManager = instance;
        }
        return passFaceRecogManager;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration == null) {
            throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
        }
        if (TextUtils.isEmpty(passBiometricConfiguration.tpl) || TextUtils.isEmpty(passBiometricConfiguration.appId) || TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }
        this.configuration = passBiometricConfiguration;
        ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
        BeanConstants.tpl = passBiometricConfiguration.tpl;
        BeanConstants.appid = passBiometricConfiguration.appId;
        BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
        SoManager.checkVersion(getInstance().getConfiguration());
    }

    public PassBiometricConfiguration getConfiguration() {
        return this.configuration;
    }

    private void startLivenessRecogize(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (passFaceRecogDTO == null) {
            passFaceRecogResult.setResultCode(-205);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
            if (passFaceRecogCallback != null) {
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return;
            }
            return;
        }
        if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                passFaceRecogResult.setResultCode(101);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(passFaceRecogDTO.realName) || TextUtils.isEmpty(passFaceRecogDTO.idCardNum)) && TextUtils.isEmpty(passFaceRecogDTO.getAccessToken())) {
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogDTO.exUid = "1";
            }
        } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
        } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
            passFaceRecogResult.setResultCode(-205);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
            if (passFaceRecogCallback != null) {
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return;
            }
            return;
        }
        this.passFaceRecogCallback = passFaceRecogCallback;
        if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            Intent intent = new Intent(context, LivenessRecogActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        this.startLoadingTime = System.currentTimeMillis();
        Intent intent2 = new Intent(context, LivenessLoadingActivity.class);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }

    private void preInitLinessRecogDTO(PassFaceRecogDTO passFaceRecogDTO) {
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
        BeanDataCache.getInstance().addToCache(BeanDataCache.KEY, passFaceRecogDTO);
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.passFaceRecogCallback;
    }

    public void cleanPassFaceRecogCallback() {
        this.passFaceRecogCallback = null;
    }

    private void closeLoading(final Context context) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setAction(LivenessLoadingActivity.CLOSE_LOADING_ACTION);
                context.sendBroadcast(intent);
            }
        }, System.currentTimeMillis() - this.startLoadingTime >= 1000 ? 0L : 1000L);
    }

    private boolean meetFrequencyControl() {
        return System.currentTimeMillis() - this.lastCallTime < 300;
    }

    private void resetViews(Context context) {
        closeLoading(context);
    }

    private void initData(Context context) {
        this.lastCallTime = System.currentTimeMillis();
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        if (passBiometricCallback == null) {
            throw new IllegalArgumentException(PassBiometricCallback.class.getSimpleName() + " can't be null");
        }
        if (passBiometricOperation == null) {
            throw new IllegalArgumentException(PassBiometricOperation.class.getSimpleName() + " can't be null");
        }
        if (passBiometricDto == null) {
            throw new IllegalArgumentException(PassBiometricDto.class.getSimpleName() + " can't be null");
        }
        if (((PassFaceOperation) passBiometricOperation).operationType == PassFaceOperation.OperationType.RECOGNIZE && !meetFrequencyControl()) {
            resetViews(context);
            initData(context);
            PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
            preInitLinessRecogDTO(passFaceRecogDTO);
            startLivenessRecogize((PassFaceRecogCallback) passBiometricCallback, passFaceRecogDTO, context);
        }
    }
}
