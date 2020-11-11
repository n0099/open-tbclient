package com.baidu.fsg.face.liveness;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
/* loaded from: classes17.dex */
public class SapiLivenessRecogManager implements com.baidu.fsg.face.base.b {
    public static final long MAX_CALL_INTERNAL_TIME = 300;
    public static final String TAG = "SapiLivenessRecog";

    /* renamed from: a  reason: collision with root package name */
    private static SapiLivenessRecogManager f1596a;
    private LivenessRecogCallback b;
    private long c;
    private long d;

    private SapiLivenessRecogManager() {
    }

    public static synchronized SapiLivenessRecogManager getInstance() {
        SapiLivenessRecogManager sapiLivenessRecogManager;
        synchronized (SapiLivenessRecogManager.class) {
            if (f1596a == null) {
                f1596a = new SapiLivenessRecogManager();
            }
            sapiLivenessRecogManager = f1596a;
        }
        return sapiLivenessRecogManager;
    }

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
        if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(livenessRecogDTO.bduss)) {
                livenessRecogResult.setResultCode(101);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_NO_LOGIN);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(livenessRecogDTO.authToken)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(livenessRecogDTO.realName) || TextUtils.isEmpty(livenessRecogDTO.idCardNum)) && TextUtils.isEmpty(livenessRecogDTO.getAccessToken())) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            if (TextUtils.isEmpty(livenessRecogDTO.exUid)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(livenessRecogDTO.exUid)) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        this.b = livenessRecogCallback;
        if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            if (livenessRecogDTO.showGuidePage) {
                Intent intent = new Intent(context, LivenessRecogGuidActivity.class);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, LivenessRecogActivity.class);
            intent2.setFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        this.d = System.currentTimeMillis();
        Intent intent3 = new Intent(context, LivenessLoadingActivity.class);
        intent3.setFlags(268435456);
        context.startActivity(intent3);
    }

    public LivenessRecogCallback getLivenessRecogCallback() {
        return this.b;
    }

    public void cleanLivenessRecogCallback() {
        this.b = null;
    }

    private void a(final Context context) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.SapiLivenessRecogManager.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setAction(LivenessLoadingActivity.CLOSE_LOADING_ACTION);
                context.sendBroadcast(intent);
            }
        }, System.currentTimeMillis() - this.d >= 1000 ? 0L : 1000L);
    }

    private boolean a() {
        return System.currentTimeMillis() - this.c < 300;
    }

    private void b(Context context) {
        a(context);
    }

    private void c(Context context) {
        this.c = System.currentTimeMillis();
    }

    public void checkSo(Context context) {
        com.baidu.fsg.face.base.b.d.a(context, 4);
    }

    @Override // com.baidu.fsg.face.base.b
    public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
        if (aVar == null) {
            throw new IllegalArgumentException(com.baidu.fsg.face.base.a.a.class.getSimpleName() + " can't be null");
        }
        if (eVar == null) {
            throw new IllegalArgumentException(e.class.getSimpleName() + " can't be null");
        }
        if (sapiBiometricDto == null) {
            throw new IllegalArgumentException(SapiBiometricDto.class.getSimpleName() + " can't be null");
        }
        SapiLivenessOperation sapiLivenessOperation = (SapiLivenessOperation) eVar;
        if (sapiLivenessOperation.operationType == SapiLivenessOperation.OperationType.RECOGNIZE) {
            if (!a()) {
                b(context);
                c(context);
                a((LivenessRecogCallback) aVar, (LivenessRecogDTO) sapiBiometricDto, context);
            }
        } else if (sapiLivenessOperation.operationType == SapiLivenessOperation.OperationType.VIDEORECOG && !a()) {
            c(context);
            b((LivenessRecogCallback) aVar, (LivenessRecogDTO) sapiBiometricDto, context);
        }
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
        if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            if (TextUtils.isEmpty(livenessRecogDTO.bduss)) {
                livenessRecogResult.setResultCode(101);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_NO_LOGIN);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
            if (TextUtils.isEmpty(livenessRecogDTO.authToken)) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
            if ((TextUtils.isEmpty(livenessRecogDTO.realName) || TextUtils.isEmpty(livenessRecogDTO.idCardNum)) && TextUtils.isEmpty(livenessRecogDTO.getAccessToken())) {
                livenessRecogResult.setResultCode(-205);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                    return;
                }
                return;
            }
        } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(livenessRecogDTO.exUid)) {
            livenessRecogResult.setResultCode(-205);
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_PARAM);
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
                return;
            }
            return;
        }
        this.b = livenessRecogCallback;
        Intent intent = new Intent(context, LivenessVideoLoadingActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
