package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";

    /* renamed from: a  reason: collision with root package name */
    public LoadingDialog f5873a;

    /* renamed from: b  reason: collision with root package name */
    public i f5874b;

    /* renamed from: c  reason: collision with root package name */
    public g f5875c;

    /* renamed from: d  reason: collision with root package name */
    public LivenessRecogDTO f5876d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5877e;

    private void a() {
        i iVar = new i(this);
        this.f5874b = iVar;
        iVar.setResponseCallback(this);
        g gVar = new g(this);
        this.f5875c = gVar;
        gVar.setResponseCallback(this);
        this.f5876d = (LivenessRecogDTO) c.a().a("request_data");
    }

    private void b() {
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        a(this);
    }

    private void c() {
        if (isUseable(this) && this.f5873a.isShowing()) {
            this.f5873a.dismiss();
            finish();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 1) {
            c();
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            RimStatisticsUtil.onEventEndWithValue(d.f6176b, i3, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
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
                RimStatisticsUtil.onEventEndWithValues(d.f6179e, i3, arrayList);
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse(int i2, Object obj, String str) {
        int optInt;
        boolean z;
        if (i2 != 1) {
            if (i2 != 2) {
                super.handleResponse(i2, obj, str);
                return;
            }
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(d.f6179e, 0, arrayList);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  0");
            }
            LivenessRecogDTO livenessRecogDTO = this.f5876d;
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
        RimStatisticsUtil.onEventEndWithValue(d.f6176b, 0, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : "");
        LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
        if (!TextUtils.isEmpty(str)) {
            try {
                optInt = new JSONObject(str).optInt("reviewing");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            z = optInt == 1;
            this.f5877e = z;
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
            RimStatisticsUtil.onEventStart(d.f6179e);
            g gVar = new g(this);
            this.f5875c = gVar;
            gVar.setResponseCallback(this);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.f5875c.execBean();
            return;
        }
        optInt = 0;
        if (optInt == 1) {
        }
        this.f5877e = z;
        if (!z) {
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity
    public boolean isRequestedOrientation() {
        return false;
    }

    public boolean isUseable(Activity activity) {
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        if (this.f5876d == null) {
            finish();
        }
        if (this.f5876d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            this.f5874b.execBean();
            RimStatisticsUtil.onEventStart(d.f6176b);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
            return;
        }
        RimStatisticsUtil.onEventStart(d.f6179e);
        LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
        this.f5875c.execBean();
    }

    private void a(Context context) {
        if (this.f5873a == null) {
            LoadingDialog loadingDialog = new LoadingDialog(context);
            this.f5873a = loadingDialog;
            loadingDialog.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
            this.f5873a.setCancelable(false);
        }
        if ((context instanceof Activity) && isUseable((Activity) context) && !this.f5873a.isShowing()) {
            this.f5873a.show();
        }
    }
}
