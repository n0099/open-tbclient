package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.o;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class LivenessVideoLoadingActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_VIDEOGETPORTRAITMODEL = "VideoGetPortraitModel";
    public static final String TAG = "LivenessVideoLoadingActivity";
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LoadingDialog f35189b;

    /* renamed from: c  reason: collision with root package name */
    public LivenessRecogCallback f35190c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1553933179, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoLoadingActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1553933179, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoLoadingActivity;");
        }
    }

    public LivenessVideoLoadingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.f35190c != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(a.ERROR_CODE_MANY_CALL);
                livenessRecogResult.setResultMsg(a.ERROR_MSG_MANY_CALL);
                this.f35190c.b(livenessRecogResult);
            }
            finish();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
            a(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.f35189b == null) {
            return;
        }
        if (isFinishing() && this.f35189b.isShowing()) {
            return;
        }
        this.f35189b.dismiss();
        finish();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            o oVar = (o) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 9, TAG);
            oVar.setResponseCallback(this);
            oVar.execBean();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i2 != 9) {
                super.handleFailure(i2, i3, str);
                return;
            }
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(d.f35307e, i3, arrayList);
            }
            c();
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultCode(i3);
            livenessRecogResult.setResultMsg(str);
            LivenessRecogCallback livenessRecogCallback = this.f35190c;
            if (livenessRecogCallback != null) {
                livenessRecogCallback.b(livenessRecogResult);
            }
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending():  发送日志");
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            if (i2 != 9) {
                super.handleResponse(i2, obj, str);
                return;
            }
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(this.livenessRecogDTO.spParams + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(d.J, 0, arrayList);
            }
            if (obj == null || !(obj instanceof VideoGetPortraitModel)) {
                return;
            }
            VideoGetPortraitModel videoGetPortraitModel = (VideoGetPortraitModel) obj;
            c();
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO != null && livenessRecogDTO.showGuidePage) {
                Intent intent = new Intent(this, LivenessVideoGuidActivity.class);
                intent.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
                intent.setFlags(268435456);
                startActivity(intent);
                return;
            }
            c();
            Intent intent2 = new Intent(this, LivenessVideoActivity.class);
            intent2.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
            intent2.setFlags(268435456);
            startActivity(intent2);
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity
    public boolean isRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (a) {
                a();
                LogUtil.d("hello", "loading callManyTimes");
                return;
            }
            a = true;
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            this.f35190c = livenessRecogCallback;
            if (this.livenessRecogDTO == null) {
                if (livenessRecogCallback != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-206);
                    livenessRecogResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
                    this.f35190c.b(livenessRecogResult);
                }
                finish();
                return;
            }
            setContentView(R.layout.layout_sapi_liveness_loading);
            b();
            d();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            a = false;
            BeanManager.getInstance().removeAllBeans(TAG);
        }
    }

    private void a(Context context) {
        LoadingDialog loadingDialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (this.f35189b == null) {
                LoadingDialog loadingDialog2 = new LoadingDialog(context);
                this.f35189b = loadingDialog2;
                loadingDialog2.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
                this.f35189b.setCancelable(false);
            }
            if (((Activity) context).isFinishing() || (loadingDialog = this.f35189b) == null || loadingDialog.isShowing()) {
                return;
            }
            this.f35189b.show();
        }
    }
}
