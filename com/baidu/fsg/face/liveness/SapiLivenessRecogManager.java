package com.baidu.fsg.face.liveness;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SapiLivenessRecogManager implements com.baidu.fsg.face.base.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MAX_CALL_INTERNAL_TIME = 300;
    public static final String TAG = "SapiLivenessRecog";
    public static SapiLivenessRecogManager a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LivenessRecogCallback f34112b;

    /* renamed from: c  reason: collision with root package name */
    public long f34113c;

    /* renamed from: d  reason: collision with root package name */
    public long f34114d;

    public SapiLivenessRecogManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(LivenessRecogCallback livenessRecogCallback, LivenessRecogDTO livenessRecogDTO, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, livenessRecogCallback, livenessRecogDTO, context) == null) {
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
            this.f34112b = livenessRecogCallback;
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
            this.f34114d = System.currentTimeMillis();
            Intent intent3 = new Intent(context, LivenessLoadingActivity.class);
            intent3.setFlags(268435456);
            context.startActivity(intent3);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            a(context);
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            this.f34113c = System.currentTimeMillis();
        }
    }

    public static synchronized SapiLivenessRecogManager getInstance() {
        InterceptResult invokeV;
        SapiLivenessRecogManager sapiLivenessRecogManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (SapiLivenessRecogManager.class) {
                if (a == null) {
                    a = new SapiLivenessRecogManager();
                }
                sapiLivenessRecogManager = a;
            }
            return sapiLivenessRecogManager;
        }
        return (SapiLivenessRecogManager) invokeV.objValue;
    }

    public void checkSo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            com.baidu.fsg.face.base.b.d.a(context, 4);
        }
    }

    public void cleanLivenessRecogCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34112b = null;
        }
    }

    @Override // com.baidu.fsg.face.base.b
    public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, aVar, sapiBiometricDto, context) == null) {
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
    }

    public LivenessRecogCallback getLivenessRecogCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34112b : (LivenessRecogCallback) invokeV.objValue;
    }

    private void b(LivenessRecogCallback livenessRecogCallback, LivenessRecogDTO livenessRecogDTO, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, livenessRecogCallback, livenessRecogDTO, context) == null) {
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
            this.f34112b = livenessRecogCallback;
            Intent intent = new Intent(context, LivenessVideoLoadingActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, context) { // from class: com.baidu.fsg.face.liveness.SapiLivenessRecogManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SapiLivenessRecogManager f34115b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34115b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Intent intent = new Intent();
                        intent.setAction(LivenessLoadingActivity.CLOSE_LOADING_ACTION);
                        this.a.sendBroadcast(intent);
                    }
                }
            }, System.currentTimeMillis() - this.f34114d >= 1000 ? 0L : 1000L);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? System.currentTimeMillis() - this.f34113c < 300 : invokeV.booleanValue;
    }
}
