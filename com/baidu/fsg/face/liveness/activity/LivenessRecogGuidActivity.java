package com.baidu.fsg.face.liveness.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LivenessRecogGuidActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_PARAM_SWITCH_RECORD_VIDEO = "extra_switch_record_video";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Button f5801a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f5802b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f5803c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5804d;

    /* renamed from: e  reason: collision with root package name */
    public LivenessRecogCallback f5805e;

    /* renamed from: f  reason: collision with root package name */
    public String f5806f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5807g;

    public LivenessRecogGuidActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5806f = null;
        this.f5807g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (this.f5805e != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(a.ERROR_MSG_USER_CANCEL);
                livenessRecogResult.setResultCode(-204);
                this.f5805e.b(livenessRecogResult);
            }
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            RimStatisticsUtil.onEventWithValue(d.n, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
            LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending:发送日志");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            startActivityForResult(new Intent(this, LivenessRecogActivity.class), 1001);
            System.gc();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1001 && i3 == -1) {
                finish();
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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
            b();
            if (!this.f5807g) {
                setContentView(R.layout.layout_sapi_liveness_guide_page);
            } else {
                setContentView(R.layout.layout_sapi_liveness_record_video_guide_page);
            }
            a();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                c();
                finish();
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Button button = (Button) findViewById(R.id.btn_start_photo);
            this.f5801a = button;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogGuidActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogGuidActivity f5808a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5808a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LivenessRecogDTO livenessRecogDTO = this.f5808a.livenessRecogDTO;
                        RimStatisticsUtil.onEventWithValue(d.f6004c, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                        LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                        this.f5808a.d();
                    }
                }
            });
            ImageView imageView = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
            this.f5802b = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogGuidActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogGuidActivity f5809a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5809a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f5809a.c();
                        this.f5809a.finish();
                    }
                }
            });
            this.f5803c = (TextView) findViewById(R.id.tv_name);
            this.f5806f = this.livenessRecogDTO.realName;
            this.f5804d = (ImageView) findViewById(R.id.guide_imageview);
            if (!TextUtils.isEmpty(this.f5806f)) {
                String format = String.format(getString(R.string.sapi_liveness_guide_photo_tip), this.f5806f);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_recog_guide_tip_color));
                if (format.indexOf("*") > 0) {
                    spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf("*"), format.indexOf("*") + this.f5806f.length(), 33);
                } else {
                    spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf(this.f5806f), format.indexOf(this.f5806f) + this.f5806f.length(), 33);
                }
                this.f5803c.setText(spannableStringBuilder);
            } else {
                this.f5803c.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), ""));
            }
            this.f5804d.setImageBitmap(a(R.drawable.sapi_liveness_recognized_time_out_guide));
            f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f5805e = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            this.f5807g = c.a().a(getActivity()).getSwitchRecordVideo() && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS;
        }
    }

    private Bitmap a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i2, options);
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(getResources(), i2, options);
        }
        return (Bitmap) invokeI.objValue;
    }
}
