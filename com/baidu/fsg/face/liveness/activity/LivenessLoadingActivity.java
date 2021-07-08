package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoadingDialog f5717a;

    /* renamed from: b  reason: collision with root package name */
    public i f5718b;

    /* renamed from: c  reason: collision with root package name */
    public g f5719c;

    /* renamed from: d  reason: collision with root package name */
    public LivenessRecogDTO f5720d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5721e;

    public LivenessLoadingActivity() {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            i iVar = new i(this);
            this.f5718b = iVar;
            iVar.setResponseCallback(this);
            g gVar = new g(this);
            this.f5719c = gVar;
            gVar.setResponseCallback(this);
            this.f5720d = (LivenessRecogDTO) c.a().a("request_data");
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
            a(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && isUseable(this) && this.f5717a.isShowing()) {
            this.f5717a.dismiss();
            finish();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i2 == 1) {
                c();
                LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
                RimStatisticsUtil.onEventEndWithValue(d.f6020b, i3, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  " + i3);
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i3);
                livenessRecogResult.setResultMsg(str);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
            } else if (i2 != 2) {
                super.handleFailure(i2, i3, str);
            } else {
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(d.f6023e, i3, arrayList);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  " + i3 + str);
                }
                c();
                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                livenessRecogResult2.setResultCode(i3);
                livenessRecogResult2.setResultMsg(str);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult2);
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
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
                RimStatisticsUtil.onEventEndWithValues(d.f6023e, 0, arrayList);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  0");
            }
            LivenessRecogDTO livenessRecogDTO = this.f5720d;
            if (livenessRecogDTO.showGuidePage) {
                if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS && !TextUtils.isEmpty(str)) {
                    try {
                        this.livenessRecogDTO.realName = new JSONObject(str).optString("display_name");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                c();
                Intent intent = new Intent(this, LivenessRecogGuidActivity.class);
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                startActivity(intent);
                return;
            }
            c();
            Intent intent2 = new Intent(this, LivenessRecogActivity.class);
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            startActivity(intent2);
            return;
        }
        LivenessRecogDTO livenessRecogDTO2 = this.livenessRecogDTO;
        RimStatisticsUtil.onEventEndWithValue(d.f6020b, 0, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : "");
        LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
        if (!TextUtils.isEmpty(str)) {
            try {
                optInt = new JSONObject(str).optInt("reviewing");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            z = optInt == 1;
            this.f5721e = z;
            if (!z) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_VIDEO_IS_REVIEWING);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
                c();
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            }
            RimStatisticsUtil.onEventStart(d.f6023e);
            g gVar = new g(this);
            this.f5719c = gVar;
            gVar.setResponseCallback(this);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.f5719c.execBean();
            return;
        }
        optInt = 0;
        if (optInt == 1) {
        }
        this.f5721e = z;
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
            if (this.livenessRecogDTO == null) {
                LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
                if (livenessRecogCallback != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-206);
                    livenessRecogResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
                    livenessRecogCallback.b(livenessRecogResult);
                }
                finish();
                return;
            }
            setContentView(R.layout.layout_sapi_liveness_loading);
            b();
            a();
            if (this.f5720d == null) {
                finish();
            }
            if (this.f5720d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                this.f5718b.execBean();
                RimStatisticsUtil.onEventStart(d.f6020b);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
                return;
            }
            RimStatisticsUtil.onEventStart(d.f6023e);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.f5719c.execBean();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            if (this.f5717a == null) {
                LoadingDialog loadingDialog = new LoadingDialog(context);
                this.f5717a = loadingDialog;
                loadingDialog.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
                this.f5717a.setCancelable(false);
            }
            if ((context instanceof Activity) && isUseable((Activity) context) && !this.f5717a.isShowing()) {
                this.f5717a.show();
            }
        }
    }
}
