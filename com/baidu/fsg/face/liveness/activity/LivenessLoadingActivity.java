package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.beans.g;
import com.baidu.fsg.face.liveness.beans.i;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LoadingDialog f35241b;

    /* renamed from: c  reason: collision with root package name */
    public i f35242c;

    /* renamed from: d  reason: collision with root package name */
    public g f35243d;

    /* renamed from: e  reason: collision with root package name */
    public LivenessRecogDTO f35244e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35245f;

    /* renamed from: g  reason: collision with root package name */
    public LivenessRecogCallback f35246g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-62931914, "Lcom/baidu/fsg/face/liveness/activity/LivenessLoadingActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-62931914, "Lcom/baidu/fsg/face/liveness/activity/LivenessLoadingActivity;");
        }
    }

    public LivenessLoadingActivity() {
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
            if (this.f35246g != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(a.ERROR_CODE_MANY_CALL);
                livenessRecogResult.setResultMsg(a.ERROR_MSG_MANY_CALL);
                this.f35246g.b(livenessRecogResult);
            }
            finish();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            i iVar = new i(this);
            this.f35242c = iVar;
            iVar.setResponseCallback(this);
            g gVar = new g(this);
            this.f35243d = gVar;
            gVar.setResponseCallback(this);
            this.f35244e = (LivenessRecogDTO) c.a().a("request_data");
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
            a(this);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && isUseable(this) && this.f35241b.isShowing()) {
            this.f35241b.dismiss();
            finish();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i2 == 1) {
                d();
                LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
                RimStatisticsUtil.onEventEndWithValue(d.f35460b, i3, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  " + i3);
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i3);
                livenessRecogResult.setResultMsg(str);
                LivenessRecogCallback livenessRecogCallback = this.f35246g;
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                }
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
            } else if (i2 != 2) {
                super.handleFailure(i2, i3, str);
            } else {
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(d.f35463e, i3, arrayList);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  " + i3 + str);
                }
                d();
                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                livenessRecogResult2.setResultCode(i3);
                livenessRecogResult2.setResultMsg(str);
                LivenessRecogCallback livenessRecogCallback2 = this.f35246g;
                if (livenessRecogCallback2 != null) {
                    livenessRecogCallback2.b(livenessRecogResult2);
                }
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f3  */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse(int i2, Object obj, String str) {
        int optInt;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) != null) {
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                super.handleResponse(i2, obj, str);
                return;
            }
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(d.f35463e, 0, arrayList);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  0");
            }
            LivenessRecogDTO livenessRecogDTO = this.f35244e;
            if (livenessRecogDTO.showGuidePage) {
                if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS && !TextUtils.isEmpty(str)) {
                    try {
                        this.livenessRecogDTO.realName = new JSONObject(str).optString("display_name");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                d();
                Intent intent = new Intent(this, LivenessRecogGuidActivity.class);
                intent.setFlags(268435456);
                startActivity(intent);
                return;
            }
            d();
            Intent intent2 = new Intent(this, LivenessRecogActivity.class);
            intent2.setFlags(268435456);
            startActivity(intent2);
            return;
        }
        LivenessRecogDTO livenessRecogDTO2 = this.livenessRecogDTO;
        RimStatisticsUtil.onEventEndWithValue(d.f35460b, 0, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : "");
        LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
        if (!TextUtils.isEmpty(str)) {
            try {
                optInt = new JSONObject(str).optInt("reviewing");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            z = optInt == 1;
            this.f35245f = z;
            if (!z) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_VIDEO_IS_REVIEWING);
                LivenessRecogCallback livenessRecogCallback = this.f35246g;
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(livenessRecogResult);
                }
                d();
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            }
            RimStatisticsUtil.onEventStart(d.f35463e);
            g gVar = new g(this);
            this.f35243d = gVar;
            gVar.setResponseCallback(this);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.f35243d.execBean();
            return;
        }
        optInt = 0;
        if (optInt == 1) {
        }
        this.f35245f = z;
        if (!z) {
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

    public boolean isUseable(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity == null || activity.isFinishing() || activity.isRestricted()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    return !activity.isDestroyed();
                } catch (Error e2) {
                    e2.printStackTrace();
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            if (a) {
                a();
                LogUtil.d("hello", "loading callManyTimes");
                return;
            }
            a = true;
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            this.f35246g = livenessRecogCallback;
            if (this.livenessRecogDTO == null) {
                if (livenessRecogCallback != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-206);
                    livenessRecogResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
                    this.f35246g.b(livenessRecogResult);
                }
                finish();
                return;
            }
            setContentView(R.layout.layout_sapi_liveness_loading);
            c();
            b();
            if (this.f35244e == null) {
                finish();
            }
            if (this.f35244e.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                this.f35242c.execBean();
                RimStatisticsUtil.onEventStart(d.f35460b);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
                return;
            }
            RimStatisticsUtil.onEventStart(d.f35463e);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.f35243d.execBean();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            a = false;
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (this.f35241b == null) {
                LoadingDialog loadingDialog = new LoadingDialog(context);
                this.f35241b = loadingDialog;
                loadingDialog.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
                this.f35241b.setCancelable(false);
            }
            if ((context instanceof Activity) && isUseable((Activity) context) && !this.f35241b.isShowing()) {
                this.f35241b.show();
            }
        }
    }
}
