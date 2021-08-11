package com.baidu.fsg.face.liveness.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.NetworkUtils;
import com.baidu.fsg.face.base.d.b;
import com.baidu.fsg.face.base.d.e;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.beans.n;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.datamodel.VideoFaceMatchModel;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.LivenessVideoState;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.fsg.face.liveness.view.LivenessVideoUploadView;
import com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView;
import com.baidu.fsg.face.liveness.view.LivenessVideoXfordView;
import com.baidu.fsg.face.liveness.view.LrcTipTextview;
import com.baidu.fsg.face.liveness.view.LrcView;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessVideoActivity extends LivenessCameraBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39817b = "CONSTRASTBEANTAG";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39818c = "LivenessVideoActivity";

    /* renamed from: d  reason: collision with root package name */
    public static final int f39819d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f39820e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f39821f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f39822g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f39823h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f39824i = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public int B;
    public int C;
    public ArrayList<HashMap<String, byte[]>> D;
    public boolean E;
    public byte[] F;
    public byte[] G;
    public VideoGetPortraitModel H;
    public long[] I;
    public List<String> J;
    public LivenessVideoState K;
    public boolean L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public int T;
    public byte[] U;
    public int V;
    public int W;
    public int X;

    /* renamed from: j  reason: collision with root package name */
    public LivenessVideoXfordView f39825j;
    public RelativeLayout k;
    public ImageView l;
    public LrcView m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public LivenessVideoWarningTipTextView q;
    public LivenessVideoUploadView r;
    public LrcTipTextview s;
    public LivenessRecogCallback t;
    public FaceTracker u;
    public GetFPResponse.LivenessConfig v;
    public int w;
    public a x;
    public FaceTracker.ErrCode y;
    public FaceInfo[] z;

    public LivenessVideoActivity() {
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
        this.w = 0;
        this.A = null;
        this.J = new ArrayList();
        this.K = new LivenessVideoState();
        this.M = -1;
        this.N = -1;
        this.O = false;
        this.R = false;
    }

    public static /* synthetic */ int e(LivenessVideoActivity livenessVideoActivity) {
        int i2 = livenessVideoActivity.w - 1;
        livenessVideoActivity.w = i2;
        return i2;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            RimStatisticsUtil.onEvent(d.S);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_interrupt_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39836a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39837b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39837b = this;
                    this.f39836a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39836a.dismiss();
                        this.f39837b.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            RimStatisticsUtil.onEvent(d.Z);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_file_exceptio_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39838a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39839b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39839b = this;
                    this.f39838a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39838a.dismiss();
                        this.f39839b.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39840a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39841b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39841b = this;
                    this.f39840a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39840a.dismiss();
                        this.f39841b.a(-402, LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
                    }
                }
            });
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, str) == null) {
            if (i2 == 10) {
                a("0", i3);
            } else if (i2 == 11) {
                c(i3);
                if (i3 == -5) {
                    r();
                } else {
                    q();
                }
            } else {
                super.handleFailure(i2, i3, str);
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
            if (i2 == 10) {
                if (obj == null || !(obj instanceof VideoFaceMatchModel)) {
                    return;
                }
                a(((VideoFaceMatchModel) obj).isContrastPass() ? "1" : "0", 0);
            } else if (i2 == 11) {
                c(0);
                if (obj != null && (obj instanceof AudioVideoUploadModel)) {
                    if (this.t != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(0);
                        livenessRecogResult.callbackkey = ((AudioVideoUploadModel) obj).callbackkey;
                        this.t.a(livenessRecogResult);
                        g.b(g.b(getActivity()));
                        e();
                        return;
                    }
                    return;
                }
                a(-206, com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onBackPressed();
            RimStatisticsUtil.onEvent(d.R);
            a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.livenessRecogDTO == null) {
                a(-206, com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                return;
            }
            f();
            g();
            this.t = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            if (getIntent().getExtras() != null && (serializable = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) != null && (serializable instanceof VideoGetPortraitModel)) {
                VideoGetPortraitModel videoGetPortraitModel = (VideoGetPortraitModel) serializable;
                this.H = videoGetPortraitModel;
                this.I = videoGetPortraitModel.getCutTimePoints();
                this.J = this.H.getLrcContent();
                this.S = this.H.getVideoMaxSize();
            }
            startVideoOrCamera();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            LivenessVideoXfordView livenessVideoXfordView = this.f39825j;
            if (livenessVideoXfordView != null) {
                livenessVideoXfordView.release();
            }
            BeanManager.getInstance().removeAllBeans(f39818c);
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            if (this.permissionFlag) {
                return;
            }
            this.L = true;
            stopVideoOrCamera();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (this.L) {
                this.L = false;
                if (!this.K.isWarnCancleTipAfterOnPause() || this.R) {
                    return;
                }
                s();
            }
        }
    }

    public void showVideoDoneView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RimStatisticsUtil.onEventWithValue(d.T, this.Q ? "1" : "0");
            this.k.setVisibility(4);
            this.f39825j.setVisibility(4);
            LivenessVideoUploadView livenessVideoUploadView = new LivenessVideoUploadView(getActivity());
            this.r = livenessVideoUploadView;
            ((FrameLayout) findViewById(R.id.view_stup_upload_video)).addView(livenessVideoUploadView);
            this.r.showBackgroundBitmap();
            this.r.setUploadListener(new LivenessVideoUploadView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39842a;

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
                    this.f39842a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        RimStatisticsUtil.onEvent(d.V);
                        g.b(g.b(this.f39842a.getActivity()));
                        this.f39842a.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public boolean b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (NetworkUtils.isNetworkAvailable(this.f39842a.getActivity())) {
                            return true;
                        }
                        this.f39842a.showNoNetWorkDialog();
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        RimStatisticsUtil.onEvent(d.U);
                        this.f39842a.j();
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessVideoActivity f39873a;

        public a(LivenessVideoActivity livenessVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39873a = livenessVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f39873a.K.isInitOk()) {
                    this.f39873a.k();
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onPostExecute(str);
                LivenessVideoActivity.e(this.f39873a);
            }
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65557, this, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(this.livenessRecogDTO.spParams + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(d.W, i2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending:发送日志");
            stopVideoOrCamera();
            setResult(0);
            finish();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            GetFPResponse.LivenessConfig a2 = c.a().a(getActivity());
            this.v = a2;
            if (a2 == null) {
                this.v = new GetFPResponse.LivenessConfig();
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            try {
                h();
                i();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void h() throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && !com.baidu.fsg.face.base.b.d.a(this, 4, null)) {
            throw new Exception("load so failure");
        }
    }

    private void i() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            String token = RimArmor.getInstance().getToken();
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty("frfsd_ai")) {
                try {
                    FaceTracker faceTracker = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
                    this.u = faceTracker;
                    faceTracker.set_isFineAlign(false);
                    this.u.set_isVerifyLive(true);
                    if (this.v == null) {
                        this.v = new GetFPResponse.LivenessConfig();
                    }
                    this.u.set_min_face_size(this.v.getMinFaceSize());
                    this.u.set_illum_thr(this.v.getIllumThr());
                    this.u.set_track_by_detection_interval(this.v.getTrackInterval());
                    this.u.set_detect_in_video_interval(this.v.getDetectInterval());
                    this.u.set_eulur_angle_thr(this.v.getYaw(), this.v.getPitch(), this.v.getRoll());
                    this.u.set_max_reg_img_num(this.v.getMaxRegImgNum(this.livenessRecogDTO.spParams));
                    this.u.set_prefetch_reg_img_interval(this.v.getPrefetchRegImgInterval());
                    this.u.set_cropFaceSize(this.v.getCropFaceSize());
                    this.u.set_cropFaceEnlargeRatio(this.v.getCropFaceRatio());
                    return;
                } catch (Exception e2) {
                    throw new Exception("init faceTracker failure: " + e2.getMessage());
                }
            }
            throw new Exception("idlToken or apiKey is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65569, this) != null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(g.b(getActivity()));
            try {
                int available = fileInputStream2.available();
                byte[] bArr = new byte[available];
                fileInputStream2.read(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.T = available;
                int i2 = available / 1048576;
                ArrayList arrayList = new ArrayList();
                arrayList.add("" + c.a().b(getApplicationContext()));
                arrayList.add(String.valueOf(this.T));
                arrayList.add(this.S + "");
                if (this.livenessRecogDTO != null) {
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                }
                RimStatisticsUtil.onEventWithValues(d.ac, arrayList);
                if (this.T == 0) {
                    t();
                } else if (i2 >= this.S) {
                    RimStatisticsUtil.onEventWithValues(d.aa, arrayList);
                    int b2 = (int) (c.a().b(getApplicationContext()) / ((i2 / this.S) + 0.5f));
                    RimStatisticsUtil.onEventWithValue(d.ab, b2 + "");
                    c.a().a(getApplicationContext(), b2);
                    u();
                } else {
                    RimStatisticsUtil.onEventStart(d.W);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
                    com.baidu.fsg.face.liveness.beans.a aVar = (com.baidu.fsg.face.liveness.beans.a) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 11, f39818c);
                    UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                    uploadFileModel.contentType = "video/mp4";
                    uploadFileModel.filedata = bArr;
                    uploadFileModel.fileName = "video.mp4";
                    uploadFileModel.name = "file";
                    aVar.addFile(uploadFileModel);
                    aVar.a(this.K.getLrcStartTimeOffset());
                    aVar.b(this.Q ? "0" : "1");
                    aVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.19
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ LivenessVideoActivity f39843a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39843a = this;
                        }

                        @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                        public void transferred(long j2, long j3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                                LogUtil.d("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                                StringBuilder sb = new StringBuilder();
                                sb.append("progress:  ");
                                sb.append((int) ((((float) j2) / ((float) j3)) * 100.0f));
                                LogUtil.d("hello", sb.toString());
                                this.f39843a.runOnUiThread(new Runnable(this, j2, j3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.19.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ long f39844a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ long f39845b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass19 f39846c;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3)};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f39846c = this;
                                        this.f39844a = j2;
                                        this.f39845b = j3;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f39846c.f39843a.r.updateProgress((int) ((((float) this.f39844a) / ((float) this.f39845b)) * 100.0f));
                                        }
                                    }
                                });
                            }
                        }
                    });
                    aVar.setResponseCallback(this);
                    aVar.execBean();
                }
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[Catch: all -> 0x012d, TryCatch #0 {all -> 0x012d, blocks: (B:8:0x000c, B:10:0x0045, B:12:0x004d, B:14:0x005b, B:28:0x0090, B:31:0x0095, B:33:0x00ab, B:35:0x00b5, B:37:0x00bf, B:39:0x00d4, B:41:0x00d9, B:43:0x00dc, B:44:0x00df, B:45:0x00e4, B:47:0x00ea, B:48:0x00fe, B:50:0x0113, B:51:0x011c, B:53:0x0124, B:15:0x005e, B:17:0x006c, B:18:0x006f, B:20:0x0075, B:21:0x0079, B:23:0x0085, B:24:0x0088, B:25:0x008b), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe A[Catch: all -> 0x012d, TryCatch #0 {all -> 0x012d, blocks: (B:8:0x000c, B:10:0x0045, B:12:0x004d, B:14:0x005b, B:28:0x0090, B:31:0x0095, B:33:0x00ab, B:35:0x00b5, B:37:0x00bf, B:39:0x00d4, B:41:0x00d9, B:43:0x00dc, B:44:0x00df, B:45:0x00e4, B:47:0x00ea, B:48:0x00fe, B:50:0x0113, B:51:0x011c, B:53:0x0124, B:15:0x005e, B:17:0x006c, B:18:0x006f, B:20:0x0075, B:21:0x0079, B:23:0x0085, B:24:0x0088, B:25:0x008b), top: B:61:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() {
        byte[] bArr;
        int[] iArr;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65571, this) == null) || (bArr = this.U) == null || (iArr = this.A) == null) {
            return;
        }
        try {
            FaceSDK.getARGBFromYUVimg(bArr, iArr, this.V, this.W, this.X, 1);
            this.U = null;
            this.y = this.u.face_verification(this.A, this.V, this.W, FaceSDK.ImgType.ARGB, FaceTracker.ActionType.RECOGNIZE, "", "", "");
            this.A = null;
            FaceInfo[] faceInfoArr = this.u.get_TrackedFaceInfo();
            this.z = faceInfoArr;
            boolean z = true;
            if (a(faceInfoArr)) {
                if (b(this.z)) {
                    if (e.c(this.z[0].landmarks, this.faceRectGroup)) {
                        this.N = 1;
                    } else if (e.b(this.z[0].landmarks, this.faceRectGroup)) {
                        this.N = 0;
                    } else if (this.y == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                        this.N = 2;
                    } else {
                        if (a(this.z[0], this.y)) {
                            this.N = 4;
                        }
                        if (!z) {
                            if (this.O) {
                                return;
                            }
                            runOnUiThread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ LivenessVideoActivity f39850a;

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
                                    this.f39850a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        if (this.f39850a.K.isFirstRecog()) {
                                            this.f39850a.f39825j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSING, new LivenessVideoXfordView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass20 f39851a;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.f39851a = this;
                                                }

                                                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.a
                                                public void a() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        this.f39851a.f39850a.n();
                                                    }
                                                }
                                            });
                                        } else if (this.f39850a.K.currentState < 5) {
                                            this.f39850a.f39825j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSING, new LivenessVideoXfordView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20.2
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass20 f39852a;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.f39852a = this;
                                                }

                                                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.a
                                                public void a() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    }
                                                }
                                            });
                                        } else {
                                            this.f39850a.f39825j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSED, null);
                                            if (!this.f39850a.K.isLrcTipViewHadGone) {
                                                this.f39850a.s.setVisibility(0);
                                            }
                                        }
                                        this.f39850a.q.startInvisibleAnim();
                                    }
                                }
                            });
                            this.M = -1;
                            this.K.setLastFindFaceStartTime();
                            if (this.y == FaceTracker.ErrCode.OK) {
                                if (this.K.isGotoRecogFace(this.I)) {
                                    FaceVerifyData[] faceVerifyDataArr = this.u.get_FaceVerifyData(0);
                                    if (faceVerifyDataArr != null) {
                                        str = faceVerifyDataArr.length + "";
                                    } else {
                                        str = "0";
                                    }
                                    RimStatisticsUtil.onEventWithValue(d.p, str);
                                    if (faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                                        a(faceVerifyDataArr);
                                    }
                                    this.u.clearTrackedFaces();
                                }
                                if (this.K.currentState == 4) {
                                    this.K.setLrcTextStartTime();
                                    this.K.updateState(5);
                                    runOnUiThread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.21
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ LivenessVideoActivity f39853a;

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
                                            this.f39853a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                this.f39853a.o();
                                            }
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        a(this.N);
                        runOnUiThread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.22
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LivenessVideoActivity f39854a;

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
                                this.f39854a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f39854a.f39825j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.FAILURE, null);
                                }
                            }
                        });
                        if (this.K.isFirstRecogTimeout()) {
                            runOnUiThread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.23
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ LivenessVideoActivity f39855a;

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
                                    this.f39855a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        RimStatisticsUtil.onEvent(d.P);
                                        this.f39855a.p();
                                        this.f39855a.stopVideoOrCamera();
                                    }
                                }
                            });
                            return;
                        } else if (this.K.isVideoStateLostFaceTimeout()) {
                            runOnUiThread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.24
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ LivenessVideoActivity f39856a;

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
                                    this.f39856a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        RimStatisticsUtil.onEvent(d.Q);
                                        this.f39856a.p();
                                        this.f39856a.m.stopLrc();
                                        this.f39856a.stopVideoOrCamera();
                                    }
                                }
                            });
                            return;
                        } else {
                            return;
                        }
                    }
                } else {
                    this.N = 3;
                }
            } else {
                this.N = 3;
            }
            z = false;
            if (!z) {
            }
        } catch (Throwable th) {
            com.baidu.fsg.face.base.d.d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ArrayList<HashMap<String, byte[]>> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (arrayList = this.D) == null || arrayList.size() == 0) {
            return;
        }
        this.F = this.D.get(0).get("data");
        this.G = this.D.get(0).get(LightappBusinessClient.MTD_DIGEST);
        m();
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            RimStatisticsUtil.onEventStart(d.O);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
            n nVar = (n) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 10, "CONSTRASTBEANTAG");
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO != null) {
                nVar.a(livenessRecogDTO);
            }
            if (this.G != null) {
                nVar.a(new String(this.G));
            }
            nVar.d(Base64Utils.encodeToString(this.F));
            nVar.b(this.K.reqTimes + "");
            nVar.setResponseCallback(this);
            nVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.K.currentState = 3;
            this.m.toInvalidate();
            this.n.setVisibility(0);
            this.s.setVisibility(0);
            playSound(R.raw.rim_video_lrc_tip);
            this.s.postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39860a;

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
                    this.f39860a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39860a.K.currentState = 4;
                    }
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.K.isLrcTipAnimCalling = true;
            this.s.startLrcTipAnim(new LrcView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39861a;

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
                    this.f39861a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.LrcView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39861a.startRecod();
                        this.f39861a.s.postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f39862a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f39862a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f39862a.f39861a.K.isLrcTipAnimCalling = false;
                                    this.f39862a.f39861a.m.setLrcList(this.f39862a.f39861a.J);
                                    this.f39862a.f39861a.m.toInvalidate();
                                }
                            }
                        }, 300L);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            this.R = true;
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_timeout_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39871a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39872b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39872b = this;
                    this.f39871a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39872b.R = false;
                        this.f39871a.dismiss();
                        if (this.f39872b.t != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            livenessRecogResult.setResultCode(-401);
                            this.f39872b.t.b(livenessRecogResult);
                        }
                        this.f39872b.e();
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(2);
            bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39827a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39828b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39828b = this;
                    this.f39827a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.X);
                        this.f39827a.dismiss();
                        this.f39828b.j();
                    }
                }
            });
            bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39829a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39830b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39830b = this;
                    this.f39829a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.Y);
                        this.f39829a.dismiss();
                        g.b(g.b(this.f39830b.getActivity()));
                        this.f39830b.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.T + "");
            arrayList.add(String.valueOf(NetworkUtils.getNetworkType(getApplicationContext())));
            if (this.livenessRecogDTO != null) {
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            }
            RimStatisticsUtil.onEventWithValues(d.ad, arrayList);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(BeanConstants.rim_timeout_error);
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(2);
            bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39832a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39833b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39833b = this;
                    this.f39832a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.X);
                        this.f39832a.dismiss();
                        this.f39833b.j();
                    }
                }
            });
            bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39834a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39835b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39835b = this;
                    this.f39834a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.Y);
                        this.f39834a.dismiss();
                        g.b(g.b(this.f39835b.getActivity()));
                        this.f39835b.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.P = true;
            RimStatisticsUtil.onEvent(d.N);
            if (this.livenessRecogDTO != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("processid", this.livenessRecogDTO.processid);
                    if (!TextUtils.isEmpty(this.livenessRecogDTO.getCertInfo())) {
                        jSONObject.put("certinfo", this.livenessRecogDTO.getCertInfo());
                    }
                    if (!TextUtils.isEmpty(this.livenessRecogDTO.authToken)) {
                        jSONObject.put("authtoken", this.livenessRecogDTO.authToken);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                Context applicationContext = getActivity().getApplicationContext();
                LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
                BdWalletUtils.realTimeStatistics(applicationContext, livenessRecogDTO.spParams, livenessRecogDTO.getAtbc(), d.N, jSONObject.toString());
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int[] iArr = new int[2];
            this.m.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = this.f39825j.getWidth() - rect.left;
            rect.bottom = rect.top + rect.width();
            this.faceRectGroup.f39618a = rect;
            this.f39825j.setFocusViewRect(rect);
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams2.topMargin = (rect.top + (rect.height() / 2)) - (this.s.getMeasuredHeight() / 2);
            this.s.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, str) == null) {
            if (this.t != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                this.t.b(livenessRecogResult);
            }
            e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.K.setProcessStartTime();
            this.K.updateState(1);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_liveness_video_activity, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_cancel);
            this.l = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39826a;

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
                    this.f39826a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39826a.onBackPressed();
                    }
                }
            });
            this.k = (RelativeLayout) inflate.findViewById(R.id.content);
            this.f39825j = (LivenessVideoXfordView) inflate.findViewById(R.id.xfordview);
            LrcView lrcView = (LrcView) inflate.findViewById(R.id.focuslayout);
            this.m = lrcView;
            lrcView.setLrcFinishInterface(new LrcView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39831a;

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
                    this.f39831a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.LrcView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39831a.stopVideoOrCamera();
                        this.f39831a.K.updateState(6);
                        this.f39831a.showVideoDoneView();
                    }
                }
            });
            this.q = (LivenessVideoWarningTipTextView) inflate.findViewById(R.id.toastanim);
            this.n = (LinearLayout) inflate.findViewById(R.id.ll_time_count);
            this.p = (TextView) inflate.findViewById(R.id.tv_time_count);
            this.o = (ImageView) inflate.findViewById(R.id.iv_time_count_point);
            this.o.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_time_count_point));
            this.s = (LrcTipTextview) inflate.findViewById(R.id.lrc_tipview);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    private boolean b(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, this, faceInfoArr)) == null) ? faceInfoArr != null && faceInfoArr.length > 0 && e.a(faceInfoArr[0].landmarks, this.faceRectGroup) : invokeL.booleanValue;
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65551, this, i2) == null) && this.K.isFirstRecog()) {
            runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f39857a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39858b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39858b = this;
                    this.f39857a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39858b.playSound(this.f39857a);
                    }
                }
            });
        }
    }

    private void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.R = true;
            String string = !z ? getString(R.string.sapi_permission_audio) : null;
            if (!z2) {
                string = getString(R.string.sapi_permission_camera);
            }
            if (!z && !z2) {
                string = getString(R.string.sapi_permission_audio_camera);
            }
            String format = String.format(getString(R.string.sapi_permission_without_title), string);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleMsg(format);
            bioAlertDialog.setTitleVisible(true);
            bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_permission_without_msg1), string) + String.format(getString(R.string.sapi_permission_without_msg2), string));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog, z2, z) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39867a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f39868b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f39869c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39870d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog, Boolean.valueOf(z2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39870d = this;
                    this.f39867a = bioAlertDialog;
                    this.f39868b = z2;
                    this.f39869c = z;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39870d.R = false;
                        this.f39867a.dismiss();
                        if (this.f39870d.t != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            if (!this.f39868b) {
                                livenessRecogResult.setResultCode(-304);
                            } else if (!this.f39869c) {
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            }
                            this.f39870d.t.b(livenessRecogResult);
                        }
                        this.f39870d.e();
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bArr, camera) == null) {
            try {
                if (this.w > 0) {
                    return;
                }
                if (this.K.currentState == 5) {
                    if (!this.P) {
                        return;
                    }
                    this.Q = true;
                }
                this.U = bArr;
                a(camera);
                this.w++;
                a aVar = new a();
                this.x = aVar;
                aVar.execute(new Void[0]);
            } catch (Throwable th) {
                com.baidu.fsg.face.base.d.d.a(th);
            }
        }
    }

    private void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, camera) == null) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.cameraControl.a()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            int i2 = previewSize.width;
            this.V = i2;
            int i3 = previewSize.height;
            this.W = i3;
            this.X = cameraInfo.orientation;
            b bVar = this.faceRectGroup;
            bVar.f39620c = i2;
            bVar.f39621d = i3;
            GetFPResponse.LivenessConfig livenessConfig = this.v;
            if (livenessConfig == null || TextUtils.isEmpty(livenessConfig.min_face_size)) {
                if (this.V > 640 && this.W > 480) {
                    this.u.set_min_face_size(200);
                } else {
                    this.u.set_min_face_size(100);
                }
            }
            if (this.A == null) {
                this.A = new int[this.V * this.W];
            }
        }
    }

    private boolean a(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, faceInfoArr)) == null) ? faceInfoArr != null && faceInfoArr.length > 0 : invokeL.booleanValue;
    }

    private boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, faceInfo, errCode)) == null) {
            if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                return true;
            }
            if (errCode == FaceTracker.ErrCode.OK) {
                float[] fArr = faceInfo.headPose;
                if (fArr.length == 3) {
                    float abs = Math.abs(fArr[0]);
                    GetFPResponse.LivenessConfig livenessConfig = this.v;
                    if (abs < (livenessConfig != null ? livenessConfig.getPitch() : 15)) {
                        float abs2 = Math.abs(faceInfo.headPose[1]);
                        GetFPResponse.LivenessConfig livenessConfig2 = this.v;
                        if (abs2 >= (livenessConfig2 != null ? livenessConfig2.getYaw() : 15)) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || this.O || this.K.isLrcTipAnimCalling) {
            return;
        }
        if (this.M != i2) {
            if (i2 == 1) {
                a(getString(R.string.rim_liveness_video_tofar_from_camera));
                b(R.raw.rim_video_too_far);
            } else if (i2 == 0) {
                a(getString(R.string.rim_liveness_video_tonear_from_camera));
                b(R.raw.rim_video_too_near);
            } else if (i2 == 2) {
                a(getString(R.string.sapi_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                a(getString(R.string.sapi_liveness_face_to_screen));
            } else {
                b(R.raw.rim_video_put_face_round);
                a(getString(R.string.rim_liveness_video_put_face_round));
            }
        }
        this.M = i2;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f39847a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39848b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39848b = this;
                    this.f39847a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f39848b.K.isWarningTipAnimCalled) {
                            this.f39848b.q.startVisibleAnim();
                            this.f39848b.q.setText(this.f39847a);
                            if (this.f39848b.K.currentState == 5 && this.f39848b.s.getVisibility() == 0) {
                                this.f39848b.s.setVisibility(4);
                                this.f39848b.K.isLrcTipViewHadGone = true;
                                return;
                            }
                            return;
                        }
                        if (this.f39848b.K.currentState == 5 && this.f39848b.s.getVisibility() == 0) {
                            this.f39848b.s.setVisibility(4);
                            this.f39848b.K.isLrcTipViewHadGone = true;
                        }
                        this.f39848b.K.isWarningTipAnimCalled = true;
                        this.f39848b.q.setVisibility(0);
                        this.f39848b.q.setText(this.f39847a);
                        this.f39848b.O = true;
                        this.f39848b.q.startTranslateAnim(new LivenessVideoWarningTipTextView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f39849a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f39849a = this;
                            }

                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }

                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                            public void b() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.f39849a.f39848b.O = false;
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(FaceVerifyData[] faceVerifyDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, faceVerifyDataArr) == null) {
            new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39859a;

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
                    this.f39859a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                    InterceptResult invokeL;
                    int i2;
                    int i3;
                    Bitmap createBitmap;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, faceVerifyDataArr2)) == null) {
                        ArrayList<HashMap<String, byte[]>> arrayList = new ArrayList<>();
                        for (FaceVerifyData faceVerifyData : faceVerifyDataArr2) {
                            int[] iArr = faceVerifyData.mRegImg;
                            byte[] bArr = faceVerifyData.mRegDigest;
                            if (iArr != null && iArr.length > 0 && bArr != null && bArr.length > 0 && (createBitmap = Bitmap.createBitmap((i3 = faceVerifyData.cols), (i2 = faceVerifyData.rows), Bitmap.Config.ARGB_8888)) != null) {
                                createBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i2);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                if (!createBitmap.isRecycled()) {
                                    createBitmap.recycle();
                                }
                                HashMap<String, byte[]> hashMap = new HashMap<>();
                                hashMap.put("data", byteArrayOutputStream.toByteArray());
                                hashMap.put(LightappBusinessClient.MTD_DIGEST, bArr);
                                arrayList.add(hashMap);
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        return arrayList;
                    }
                    return (ArrayList) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                        if (arrayList != null && arrayList.size() > 0) {
                            this.f39859a.B = arrayList.size();
                            this.f39859a.D = arrayList;
                            if (this.f39859a.v != null) {
                                LivenessVideoActivity livenessVideoActivity = this.f39859a;
                                livenessVideoActivity.B = livenessVideoActivity.v.getRecogUploadPortraitCount(this.f39859a.B);
                            }
                            this.f39859a.l();
                            this.f39859a.K.reqTimes++;
                            return;
                        }
                        Toast.makeText(this.f39859a.getActivity(), "系统异常，失败回调", 1).show();
                    }
                }
            }.execute(faceVerifyDataArr);
        }
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, this, str, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(this.livenessRecogDTO.spParams + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        arrayList.add(str);
        arrayList.add(this.K.reqTimes + "");
        RimStatisticsUtil.onEventEndWithValues(d.O, i2, arrayList);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z3) {
                b(z2, z);
            } else {
                a(z, z2);
            }
        }
    }

    private void a(boolean z, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.R = true;
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleVisible(true);
            if (!z) {
                string = getString(R.string.sapi_liveness_video_record_failed);
            } else {
                string = !z2 ? getString(R.string.sapi_liveness_record_video_no_audio_permission) : "";
            }
            bioAlertDialog.setDialogMsg(string);
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog, z, z2) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f39863a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f39864b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f39865c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f39866d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog, Boolean.valueOf(z), Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39866d = this;
                    this.f39863a = bioAlertDialog;
                    this.f39864b = z;
                    this.f39865c = z2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f39866d.R = false;
                        this.f39863a.dismiss();
                        if (this.f39866d.t != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            if (!this.f39864b) {
                                livenessRecogResult.setResultCode(-304);
                            } else if (!this.f39865c) {
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            }
                            this.f39866d.t.b(livenessRecogResult);
                        }
                        this.f39866d.e();
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }
}
