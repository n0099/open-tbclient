package com.baidu.fsg.face.liveness;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import com.baidu.fsg.face.base.e;
import com.baidu.fsg.face.liveness.SapiLivenessOperation;
import com.baidu.fsg.face.liveness.activity.LivenessLoadingActivity;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.fsg.face.liveness.activity.LivenessRecogGuidActivity;
import com.baidu.fsg.face.liveness.activity.LivenessVideoLoadingActivity;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
/* loaded from: classes2.dex */
public class SapiLivenessRecogManager implements com.baidu.fsg.face.base.b {
    public static final long MAX_CALL_INTERNAL_TIME = 300;
    public static final String TAG = "SapiLivenessRecog";

    /* renamed from: a  reason: collision with root package name */
    public static SapiLivenessRecogManager f5601a;

    /* renamed from: b  reason: collision with root package name */
    public LivenessRecogCallback f5602b;

    /* renamed from: c  reason: collision with root package name */
    public long f5603c;

    /* renamed from: d  reason: collision with root package name */
    public long f5604d;

    private void a(LivenessRecogCallback livenessRecogCallback, LivenessRecogDTO livenessRecogDTO, Context context) {
        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
        if (livenessRecogDTO == null) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        LivenessRecogType livenessRecogType = livenessRecogDTO.livenessType;
        if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(livenessRecogDTO.bduss)) {
                livenessRecogResult.setResultCode(101);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_NO_LOGIN);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(livenessRecogDTO.authToken)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(livenessRecogDTO.realName) || TextUtils.isEmpty(livenessRecogDTO.idCardNum)) && TextUtils.isEmpty(livenessRecogDTO.getAccessToken())) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            if (TextUtils.isEmpty(livenessRecogDTO.exUid)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(livenessRecogDTO.exUid)) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        this.f5602b = livenessRecogCallback;
        if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            if (livenessRecogDTO.showGuidePage) {
                Intent intent = new Intent(context, LivenessRecogGuidActivity.class);
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, LivenessRecogActivity.class);
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent2);
            return;
        }
        this.f5604d = System.currentTimeMillis();
        Intent intent3 = new Intent(context, LivenessLoadingActivity.class);
        intent3.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent3);
    }

    private void b(Context context) {
        a(context);
    }

    private void c(Context context) {
        this.f5603c = System.currentTimeMillis();
    }

    public static synchronized SapiLivenessRecogManager getInstance() {
        SapiLivenessRecogManager sapiLivenessRecogManager;
        synchronized (SapiLivenessRecogManager.class) {
            if (f5601a == null) {
                f5601a = new SapiLivenessRecogManager();
            }
            sapiLivenessRecogManager = f5601a;
        }
        return sapiLivenessRecogManager;
    }

    public void checkSo(Context context) {
        com.baidu.fsg.face.base.b.d.a(context, 4);
    }

    public void cleanLivenessRecogCallback() {
        this.f5602b = null;
    }

    @Override // com.baidu.fsg.face.base.b
    public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
        if (aVar == null) {
            throw new IllegalArgumentException(com.baidu.fsg.face.base.a.a.class.getSimpleName() + " can't be null");
        } else if (eVar == null) {
            throw new IllegalArgumentException(e.class.getSimpleName() + " can't be null");
        } else if (sapiBiometricDto != null) {
            SapiLivenessOperation.OperationType operationType = ((SapiLivenessOperation) eVar).operationType;
            if (operationType == SapiLivenessOperation.OperationType.RECOGNIZE) {
                if (a()) {
                    return;
                }
                b(context);
                c(context);
                a((LivenessRecogCallback) aVar, (LivenessRecogDTO) sapiBiometricDto, context);
            } else if (operationType != SapiLivenessOperation.OperationType.VIDEORECOG || a()) {
            } else {
                c(context);
                b((LivenessRecogCallback) aVar, (LivenessRecogDTO) sapiBiometricDto, context);
            }
        } else {
            throw new IllegalArgumentException(SapiBiometricDto.class.getSimpleName() + " can't be null");
        }
    }

    public LivenessRecogCallback getLivenessRecogCallback() {
        return this.f5602b;
    }

    private void b(LivenessRecogCallback livenessRecogCallback, LivenessRecogDTO livenessRecogDTO, Context context) {
        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
        if (livenessRecogDTO == null) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        LivenessRecogType livenessRecogType = livenessRecogDTO.livenessType;
        if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(livenessRecogDTO.bduss)) {
                livenessRecogResult.setResultCode(101);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_NO_LOGIN);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(livenessRecogDTO.authToken)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(livenessRecogDTO.realName) || TextUtils.isEmpty(livenessRecogDTO.idCardNum)) && TextUtils.isEmpty(livenessRecogDTO.getAccessToken())) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(livenessRecogDTO.exUid)) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        this.f5602b = livenessRecogCallback;
        Intent intent = new Intent(context, LivenessVideoLoadingActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    private void a(final Context context) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.SapiLivenessRecogManager.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setAction(LivenessLoadingActivity.CLOSE_LOADING_ACTION);
                context.sendBroadcast(intent);
            }
        }, System.currentTimeMillis() - this.f5604d >= 1000 ? 0L : 1000L);
    }

    private boolean a() {
        return System.currentTimeMillis() - this.f5603c < 300;
    }
}
