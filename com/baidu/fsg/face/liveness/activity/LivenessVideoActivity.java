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
import com.baidu.sapi2.biometrics.liveness.R;
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
/* loaded from: classes2.dex */
public class LivenessVideoActivity extends LivenessCameraBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final String f5788b = "CONSTRASTBEANTAG";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5789c = "LivenessVideoActivity";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5790d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5791e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5792f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5793g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5794h = 3;
    public static final int i = 4;
    public int B;
    public int C;
    public ArrayList<HashMap<String, byte[]>> D;
    public boolean E;
    public byte[] F;
    public byte[] G;
    public VideoGetPortraitModel H;
    public long[] I;
    public boolean L;
    public boolean P;
    public boolean Q;
    public int S;
    public int T;
    public byte[] U;
    public int V;
    public int W;
    public int X;
    public LivenessVideoXfordView j;
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
    public a x;
    public FaceTracker.ErrCode y;
    public FaceInfo[] z;
    public int w = 0;
    public int[] A = null;
    public List<String> J = new ArrayList();
    public LivenessVideoState K = new LivenessVideoState();
    public int M = -1;
    public int N = -1;
    public boolean O = false;
    public boolean R = false;

    public static /* synthetic */ int e(LivenessVideoActivity livenessVideoActivity) {
        int i2 = livenessVideoActivity.w - 1;
        livenessVideoActivity.w = i2;
        return i2;
    }

    private void s() {
        RimStatisticsUtil.onEvent(d.S);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_interrupt_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    private void t() {
        RimStatisticsUtil.onEvent(d.Z);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_file_exceptio_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    private void u() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.a(-402, LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
            }
        });
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z) {
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
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

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        RimStatisticsUtil.onEvent(d.R);
        a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LivenessVideoXfordView livenessVideoXfordView = this.j;
        if (livenessVideoXfordView != null) {
            livenessVideoXfordView.release();
        }
        BeanManager.getInstance().removeAllBeans(f5789c);
        BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.permissionFlag) {
            return;
        }
        this.L = true;
        stopVideoOrCamera();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.L) {
            this.L = false;
            if (!this.K.isWarnCancleTipAfterOnPause() || this.R) {
                return;
            }
            s();
        }
    }

    public void showVideoDoneView() {
        RimStatisticsUtil.onEventWithValue(d.T, this.Q ? "1" : "0");
        this.k.setVisibility(4);
        this.j.setVisibility(4);
        LivenessVideoUploadView livenessVideoUploadView = new LivenessVideoUploadView(getActivity());
        this.r = livenessVideoUploadView;
        ((FrameLayout) findViewById(R.id.view_stup_upload_video)).addView(livenessVideoUploadView);
        this.r.showBackgroundBitmap();
        this.r.setUploadListener(new LivenessVideoUploadView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.18
            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
            public void a() {
                RimStatisticsUtil.onEvent(d.V);
                g.b(g.b(LivenessVideoActivity.this.getActivity()));
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }

            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
            public boolean b() {
                if (NetworkUtils.isNetworkAvailable(LivenessVideoActivity.this.getActivity())) {
                    return true;
                }
                LivenessVideoActivity.this.showNoNetWorkDialog();
                return false;
            }

            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
            public void c() {
                RimStatisticsUtil.onEvent(d.U);
                LivenessVideoActivity.this.j();
            }
        });
    }

    /* loaded from: classes2.dex */
    public class a extends AsyncTask<Void, Void, String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            if (LivenessVideoActivity.this.K.isInitOk()) {
                LivenessVideoActivity.this.k();
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessVideoActivity.e(LivenessVideoActivity.this);
        }
    }

    private void c(int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(this.livenessRecogDTO.spParams + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(d.W, i2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        RimStatisticsUtil.getInstance().triggerSending();
        LogUtil.d("hello", "triggerSending:发送日志");
        stopVideoOrCamera();
        setResult(0);
        finish();
    }

    private void f() {
        GetFPResponse.LivenessConfig a2 = c.a().a(getActivity());
        this.v = a2;
        if (a2 == null) {
            this.v = new GetFPResponse.LivenessConfig();
        }
    }

    private void g() {
        try {
            h();
            i();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() throws Exception {
        if (!com.baidu.fsg.face.base.b.d.a(this, 4, null)) {
            throw new Exception("load so failure");
        }
    }

    private void i() throws Exception {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
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
                    com.baidu.fsg.face.liveness.beans.a aVar = (com.baidu.fsg.face.liveness.beans.a) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 11, f5789c);
                    UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                    uploadFileModel.contentType = "video/mp4";
                    uploadFileModel.filedata = bArr;
                    uploadFileModel.fileName = "video.mp4";
                    uploadFileModel.name = "file";
                    aVar.addFile(uploadFileModel);
                    aVar.a(this.K.getLrcStartTimeOffset());
                    aVar.b(this.Q ? "0" : "1");
                    aVar.setProgressListener(new RestMultipartEntity.ProgressListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.19
                        @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                        public void transferred(final long j, final long j2) {
                            LogUtil.d("hello", "uploadvideo:   num: " + j + "  total:" + j2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("progress:  ");
                            sb.append((int) ((((float) j) / ((float) j2)) * 100.0f));
                            LogUtil.d("hello", sb.toString());
                            LivenessVideoActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LivenessVideoActivity.this.r.updateProgress((int) ((((float) j) / ((float) j2)) * 100.0f));
                                }
                            });
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
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c A[Catch: all -> 0x0129, TryCatch #0 {all -> 0x0129, blocks: (B:6:0x0008, B:8:0x0041, B:10:0x0049, B:12:0x0057, B:26:0x008c, B:29:0x0091, B:31:0x00a7, B:33:0x00b1, B:35:0x00bb, B:37:0x00d0, B:39:0x00d5, B:41:0x00d8, B:42:0x00db, B:43:0x00e0, B:45:0x00e6, B:46:0x00fa, B:48:0x010f, B:49:0x0118, B:51:0x0120, B:13:0x005a, B:15:0x0068, B:16:0x006b, B:18:0x0071, B:19:0x0075, B:21:0x0081, B:22:0x0084, B:23:0x0087), top: B:56:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa A[Catch: all -> 0x0129, TryCatch #0 {all -> 0x0129, blocks: (B:6:0x0008, B:8:0x0041, B:10:0x0049, B:12:0x0057, B:26:0x008c, B:29:0x0091, B:31:0x00a7, B:33:0x00b1, B:35:0x00bb, B:37:0x00d0, B:39:0x00d5, B:41:0x00d8, B:42:0x00db, B:43:0x00e0, B:45:0x00e6, B:46:0x00fa, B:48:0x010f, B:49:0x0118, B:51:0x0120, B:13:0x005a, B:15:0x0068, B:16:0x006b, B:18:0x0071, B:19:0x0075, B:21:0x0081, B:22:0x0084, B:23:0x0087), top: B:56:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() {
        int[] iArr;
        String str;
        byte[] bArr = this.U;
        if (bArr == null || (iArr = this.A) == null) {
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
                            runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (LivenessVideoActivity.this.K.isFirstRecog()) {
                                        LivenessVideoActivity.this.j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSING, new LivenessVideoXfordView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20.1
                                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.a
                                            public void a() {
                                                LivenessVideoActivity.this.n();
                                            }
                                        });
                                    } else if (LivenessVideoActivity.this.K.currentState < 5) {
                                        LivenessVideoActivity.this.j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSING, new LivenessVideoXfordView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20.2
                                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.a
                                            public void a() {
                                            }
                                        });
                                    } else {
                                        LivenessVideoActivity.this.j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSED, null);
                                        if (!LivenessVideoActivity.this.K.isLrcTipViewHadGone) {
                                            LivenessVideoActivity.this.s.setVisibility(0);
                                        }
                                    }
                                    LivenessVideoActivity.this.q.startInvisibleAnim();
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
                                    runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.21
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            LivenessVideoActivity.this.o();
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        a(this.N);
                        runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.22
                            @Override // java.lang.Runnable
                            public void run() {
                                LivenessVideoActivity.this.j.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.FAILURE, null);
                            }
                        });
                        if (this.K.isFirstRecogTimeout()) {
                            runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.23
                                @Override // java.lang.Runnable
                                public void run() {
                                    RimStatisticsUtil.onEvent(d.P);
                                    LivenessVideoActivity.this.p();
                                    LivenessVideoActivity.this.stopVideoOrCamera();
                                }
                            });
                            return;
                        } else if (this.K.isVideoStateLostFaceTimeout()) {
                            runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.24
                                @Override // java.lang.Runnable
                                public void run() {
                                    RimStatisticsUtil.onEvent(d.Q);
                                    LivenessVideoActivity.this.p();
                                    LivenessVideoActivity.this.m.stopLrc();
                                    LivenessVideoActivity.this.stopVideoOrCamera();
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
        ArrayList<HashMap<String, byte[]>> arrayList = this.D;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.F = this.D.get(0).get("data");
        this.G = this.D.get(0).get(LightappBusinessClient.MTD_DIGEST);
        m();
    }

    private void m() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.K.currentState = 3;
        this.m.toInvalidate();
        this.n.setVisibility(0);
        this.s.setVisibility(0);
        playSound(R.raw.rim_video_lrc_tip);
        this.s.postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                LivenessVideoActivity.this.K.currentState = 4;
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.K.isLrcTipAnimCalling = true;
        this.s.startLrcTipAnim(new LrcView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.6
            @Override // com.baidu.fsg.face.liveness.view.LrcView.a
            public void a() {
                LivenessVideoActivity.this.startRecod();
                LivenessVideoActivity.this.s.postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LivenessVideoActivity.this.K.isLrcTipAnimCalling = false;
                        LivenessVideoActivity.this.m.setLrcList(LivenessVideoActivity.this.J);
                        LivenessVideoActivity.this.m.toInvalidate();
                    }
                }, 300L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.R = true;
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_timeout_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoActivity.this.R = false;
                bioAlertDialog.dismiss();
                if (LivenessVideoActivity.this.t != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_LIVENESS_VIDEO_TIMEOUT);
                    LivenessVideoActivity.this.t.b(livenessRecogResult);
                }
                LivenessVideoActivity.this.e();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    private void q() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(d.X);
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.j();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(d.Y);
                bioAlertDialog.dismiss();
                g.b(g.b(LivenessVideoActivity.this.getActivity()));
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    private void r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.T + "");
        arrayList.add(String.valueOf(NetworkUtils.getNetworkType(getApplicationContext())));
        if (this.livenessRecogDTO != null) {
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        }
        RimStatisticsUtil.onEventWithValues(d.ad, arrayList);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(BeanConstants.rim_timeout_error);
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(d.X);
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.j();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(d.Y);
                bioAlertDialog.dismiss();
                g.b(g.b(LivenessVideoActivity.this.getActivity()));
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void d() {
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void b() {
        int[] iArr = new int[2];
        this.m.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = this.j.getWidth() - rect.left;
        rect.bottom = rect.top + rect.width();
        this.faceRectGroup.f5601a = rect;
        this.j.setFocusViewRect(rect);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.width = rect.width();
        layoutParams.height = rect.height();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams2.topMargin = (rect.top + (rect.height() / 2)) - (this.s.getMeasuredHeight() / 2);
        this.s.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.t != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultCode(i2);
            livenessRecogResult.setResultMsg(str);
            this.t.b(livenessRecogResult);
        }
        e();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void c() {
        this.K.setProcessStartTime();
        this.K.updateState(1);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public View a() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_liveness_video_activity, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_cancel);
        this.l = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoActivity.this.onBackPressed();
            }
        });
        this.k = (RelativeLayout) inflate.findViewById(R.id.content);
        this.j = (LivenessVideoXfordView) inflate.findViewById(R.id.xfordview);
        LrcView lrcView = (LrcView) inflate.findViewById(R.id.focuslayout);
        this.m = lrcView;
        lrcView.setLrcFinishInterface(new LrcView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.12
            @Override // com.baidu.fsg.face.liveness.view.LrcView.a
            public void a() {
                LivenessVideoActivity.this.stopVideoOrCamera();
                LivenessVideoActivity.this.K.updateState(6);
                LivenessVideoActivity.this.showVideoDoneView();
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

    private boolean b(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && e.a(faceInfoArr[0].landmarks, this.faceRectGroup);
    }

    private void b(final int i2) {
        if (this.K.isFirstRecog()) {
            runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    LivenessVideoActivity.this.playSound(i2);
                }
            });
        }
    }

    private void b(final boolean z, final boolean z2) {
        this.R = true;
        String string = !z ? getString(R.string.sapi_permission_audio) : null;
        if (!z2) {
            string = getString(R.string.sapi_permission_camera);
        }
        if (!z && !z2) {
            string = getString(R.string.sapi_permission_audio_camera);
        }
        String format = String.format(getString(R.string.sapi_permission_without_title), string);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(format);
        bioAlertDialog.setTitleVisible(true);
        bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_permission_without_msg1), string) + String.format(getString(R.string.sapi_permission_without_msg2), string));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoActivity.this.R = false;
                bioAlertDialog.dismiss();
                if (LivenessVideoActivity.this.t != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    if (!z2) {
                        livenessRecogResult.setResultCode(-304);
                    } else if (!z) {
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                    }
                    LivenessVideoActivity.this.t.b(livenessRecogResult);
                }
                LivenessVideoActivity.this.e();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(byte[] bArr, Camera camera) {
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

    private void a(Camera camera) {
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
        bVar.f5603c = i2;
        bVar.f5604d = i3;
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

    private boolean a(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    private boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
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

    private void a(int i2) {
        if (this.O || this.K.isLrcTipAnimCalling) {
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

    private void a(final String str) {
        runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessVideoActivity.this.K.isWarningTipAnimCalled) {
                    LivenessVideoActivity.this.q.startVisibleAnim();
                    LivenessVideoActivity.this.q.setText(str);
                    if (LivenessVideoActivity.this.K.currentState == 5 && LivenessVideoActivity.this.s.getVisibility() == 0) {
                        LivenessVideoActivity.this.s.setVisibility(4);
                        LivenessVideoActivity.this.K.isLrcTipViewHadGone = true;
                        return;
                    }
                    return;
                }
                if (LivenessVideoActivity.this.K.currentState == 5 && LivenessVideoActivity.this.s.getVisibility() == 0) {
                    LivenessVideoActivity.this.s.setVisibility(4);
                    LivenessVideoActivity.this.K.isLrcTipViewHadGone = true;
                }
                LivenessVideoActivity.this.K.isWarningTipAnimCalled = true;
                LivenessVideoActivity.this.q.setVisibility(0);
                LivenessVideoActivity.this.q.setText(str);
                LivenessVideoActivity.this.O = true;
                LivenessVideoActivity.this.q.startTranslateAnim(new LivenessVideoWarningTipTextView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2.1
                    @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                    public void a() {
                    }

                    @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                    public void b() {
                        LivenessVideoActivity.this.O = false;
                    }
                });
            }
        });
    }

    private void a(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                int i2;
                int i3;
                Bitmap createBitmap;
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                if (arrayList != null && arrayList.size() > 0) {
                    LivenessVideoActivity.this.B = arrayList.size();
                    LivenessVideoActivity.this.D = arrayList;
                    if (LivenessVideoActivity.this.v != null) {
                        LivenessVideoActivity livenessVideoActivity = LivenessVideoActivity.this;
                        livenessVideoActivity.B = livenessVideoActivity.v.getRecogUploadPortraitCount(LivenessVideoActivity.this.B);
                    }
                    LivenessVideoActivity.this.l();
                    LivenessVideoActivity.this.K.reqTimes++;
                    return;
                }
                Toast.makeText(LivenessVideoActivity.this.getActivity(), "系统异常，失败回调", 1).show();
            }
        }.execute(faceVerifyDataArr);
    }

    private void a(String str, int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(this.livenessRecogDTO.spParams + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            arrayList.add(str);
            arrayList.add(this.K.reqTimes + "");
            RimStatisticsUtil.onEventEndWithValues(d.O, i2, arrayList);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            b(z2, z);
        } else {
            a(z, z2);
        }
    }

    private void a(final boolean z, final boolean z2) {
        String string;
        this.R = true;
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleVisible(true);
        if (!z) {
            string = getString(R.string.sapi_liveness_video_record_failed);
        } else {
            string = !z2 ? getString(R.string.sapi_liveness_record_video_no_audio_permission) : "";
        }
        bioAlertDialog.setDialogMsg(string);
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoActivity.this.R = false;
                bioAlertDialog.dismiss();
                if (LivenessVideoActivity.this.t != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    if (!z) {
                        livenessRecogResult.setResultCode(-304);
                    } else if (!z2) {
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                    }
                    LivenessVideoActivity.this.t.b(livenessRecogResult);
                }
                LivenessVideoActivity.this.e();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }
}
