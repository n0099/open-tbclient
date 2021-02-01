package com.baidu.fsg.face.liveness.activity;

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
import com.baidu.fsg.face.base.b.d;
import com.baidu.fsg.face.base.d.e;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.beans.n;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.datamodel.VideoFaceMatchModel;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
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

    /* renamed from: b  reason: collision with root package name */
    private static final String f2200b = "CONSTRASTBEANTAG";
    private static final String c = "LivenessVideoActivity";
    private static final int d = -1;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private int B;
    private int C;
    private ArrayList<HashMap<String, byte[]>> D;
    private boolean E;
    private byte[] F;
    private byte[] G;
    private VideoGetPortraitModel H;
    private long[] I;
    private boolean L;
    private boolean P;
    private boolean Q;
    private int S;
    private int T;
    private byte[] U;
    private int V;
    private int W;
    private int X;
    private LivenessVideoXfordView j;
    private RelativeLayout k;
    private ImageView l;
    private LrcView m;
    private LinearLayout n;
    private ImageView o;
    private TextView p;
    private LivenessVideoWarningTipTextView q;
    private LivenessVideoUploadView r;
    private LrcTipTextview s;
    private LivenessRecogCallback t;
    private FaceTracker u;
    private GetFPResponse.LivenessConfig v;
    private a x;
    private FaceTracker.ErrCode y;
    private FaceInfo[] z;
    private int w = 0;
    private int[] A = null;
    private List<String> J = new ArrayList();
    private LivenessVideoState K = new LivenessVideoState();
    private int M = -1;
    private int N = -1;
    private boolean O = false;
    private boolean R = false;

    static /* synthetic */ int e(LivenessVideoActivity livenessVideoActivity) {
        int i2 = livenessVideoActivity.w - 1;
        livenessVideoActivity.w = i2;
        return i2;
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
            this.H = (VideoGetPortraitModel) serializable;
            this.I = this.H.getCutTimePoints();
            this.J = this.H.getLrcContent();
            this.S = this.H.getVideoMaxSize();
        }
        startVideoOrCamera();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.L) {
            this.L = false;
            if (this.K.isWarnCancleTipAfterOnPause() && !this.R) {
                s();
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.permissionFlag) {
            this.L = true;
            stopVideoOrCamera();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        RimStatisticsUtil.getInstance().triggerSending();
        LogUtil.d("hello", "triggerSending:发送日志");
        stopVideoOrCamera();
        setResult(0);
        finish();
    }

    private void f() {
        this.v = c.a().a(getActivity());
        if (this.v == null) {
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
        if (!d.a(this, 4, null)) {
            throw new Exception("load so failure");
        }
    }

    private void i() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty("frfsd_ai")) {
            throw new Exception("idlToken or apiKey is empty");
        }
        try {
            this.u = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
            this.u.set_isFineAlign(false);
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
        } catch (Exception e2) {
            throw new Exception("init faceTracker failure: " + e2.getMessage());
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    View a() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_liveness_video_activity, (ViewGroup) null);
        this.l = (ImageView) inflate.findViewById(R.id.btn_cancel);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoActivity.this.onBackPressed();
            }
        });
        this.k = (RelativeLayout) inflate.findViewById(R.id.content);
        this.j = (LivenessVideoXfordView) inflate.findViewById(R.id.xfordview);
        this.m = (LrcView) inflate.findViewById(R.id.focuslayout);
        this.m.setLrcFinishInterface(new LrcView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.12
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void b() {
        int[] iArr = new int[2];
        this.m.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = this.j.getWidth() - rect.left;
        rect.bottom = rect.top + rect.width();
        this.faceRectGroup.f2085a = rect;
        this.j.setFocusViewRect(rect);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.width = rect.width();
        layoutParams.height = rect.height();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams2.topMargin = ((rect.height() / 2) + rect.top) - (this.s.getMeasuredHeight() / 2);
        this.s.setLayoutParams(layoutParams2);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void a(byte[] bArr, Camera camera) {
        try {
            if (this.w <= 0) {
                if (this.K.currentState == 5) {
                    if (this.P) {
                        this.Q = true;
                    } else {
                        return;
                    }
                }
                this.U = bArr;
                a(camera);
                this.w++;
                this.x = new a();
                this.x.execute(new Void[0]);
            }
        } catch (Throwable th) {
            com.baidu.fsg.face.base.d.d.a(th);
        }
    }

    public void showVideoDoneView() {
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.T, this.Q ? "1" : "0");
        this.k.setVisibility(4);
        this.j.setVisibility(4);
        this.r = new LivenessVideoUploadView(getActivity());
        ((FrameLayout) findViewById(R.id.view_stup_upload_video)).addView(this.r);
        this.r.showBackgroundBitmap();
        this.r.setUploadListener(new LivenessVideoUploadView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.18
            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
            public void a() {
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.V);
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
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.U);
                LivenessVideoActivity.this.j();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [408=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(g.b(getActivity()));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                this.T = bArr.length;
                int i2 = this.T / 1048576;
                ArrayList arrayList = new ArrayList();
                arrayList.add("" + c.a().b(getApplicationContext()));
                arrayList.add(String.valueOf(this.T));
                arrayList.add(this.S + "");
                if (this.livenessRecogDTO != null) {
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                }
                RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.ac, arrayList);
                if (this.T == 0) {
                    t();
                } else if (i2 >= this.S) {
                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.aa, arrayList);
                    int b2 = (int) (c.a().b(getApplicationContext()) / ((i2 / this.S) + 0.5f));
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.ab, b2 + "");
                    c.a().a(getApplicationContext(), b2);
                    u();
                } else {
                    RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.W);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
                    com.baidu.fsg.face.liveness.beans.a aVar = (com.baidu.fsg.face.liveness.beans.a) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 11, c);
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
                            LogUtil.d("hello", "progress:  " + ((int) ((((float) j) / ((float) j2)) * 100.0f)));
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
            } catch (Exception e3) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
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
        this.V = previewSize.width;
        this.W = previewSize.height;
        this.X = cameraInfo.orientation;
        this.faceRectGroup.c = this.V;
        this.faceRectGroup.d = this.W;
        if (this.v == null || TextUtils.isEmpty(this.v.min_face_size)) {
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

    /* loaded from: classes5.dex */
    private class a extends AsyncTask<Void, Void, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
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
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessVideoActivity.e(LivenessVideoActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean z;
        if (this.U != null && this.A != null) {
            try {
                FaceSDK.getARGBFromYUVimg(this.U, this.A, this.V, this.W, this.X, 1);
                this.U = null;
                this.y = this.u.face_verification(this.A, this.V, this.W, FaceSDK.ImgType.ARGB, FaceTracker.ActionType.RECOGNIZE, "", "", "");
                this.A = null;
                this.z = this.u.get_TrackedFaceInfo();
                if (a(this.z)) {
                    if (b(this.z)) {
                        if (e.c(this.z[0].landmarks, this.faceRectGroup)) {
                            this.N = 1;
                            z = false;
                        } else if (e.b(this.z[0].landmarks, this.faceRectGroup)) {
                            this.N = 0;
                            z = false;
                        } else if (this.y == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            this.N = 2;
                            z = false;
                        } else if (a(this.z[0], this.y)) {
                            this.N = 4;
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        this.N = 3;
                        z = false;
                    }
                } else {
                    this.N = 3;
                    z = false;
                }
                if (z) {
                    if (!this.O) {
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
                                RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.p, faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0");
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
                            RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.P);
                            LivenessVideoActivity.this.p();
                            LivenessVideoActivity.this.stopVideoOrCamera();
                        }
                    });
                } else if (this.K.isVideoStateLostFaceTimeout()) {
                    runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.Q);
                            LivenessVideoActivity.this.p();
                            LivenessVideoActivity.this.m.stopLrc();
                            LivenessVideoActivity.this.stopVideoOrCamera();
                        }
                    });
                }
            } catch (Throwable th) {
                com.baidu.fsg.face.base.d.d.a(th);
            }
        }
    }

    private boolean a(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    private boolean b(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && e.a(faceInfoArr[0].landmarks, this.faceRectGroup);
    }

    private boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            if (Math.abs(faceInfo.headPose[0]) >= (this.v != null ? this.v.getPitch() : 15)) {
                return true;
            }
            if (Math.abs(faceInfo.headPose[1]) >= (this.v != null ? this.v.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    private void a(int i2) {
        if (!this.O && !this.K.isLrcTipAnimCalling) {
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
    }

    private void a(final String str) {
        runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (!LivenessVideoActivity.this.K.isWarningTipAnimCalled) {
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
                    return;
                }
                LivenessVideoActivity.this.q.startVisibleAnim();
                LivenessVideoActivity.this.q.setText(str);
                if (LivenessVideoActivity.this.K.currentState == 5 && LivenessVideoActivity.this.s.getVisibility() == 0) {
                    LivenessVideoActivity.this.s.setVisibility(4);
                    LivenessVideoActivity.this.K.isLrcTipViewHadGone = true;
                }
            }
        });
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

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.fsg.face.liveness.activity.LivenessVideoActivity$4] */
    private void a(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
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
                        hashMap.put("digest", bArr);
                        arrayList.add(hashMap);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                if (arrayList != null && arrayList.size() > 0) {
                    LivenessVideoActivity.this.B = arrayList.size();
                    LivenessVideoActivity.this.D = arrayList;
                    if (LivenessVideoActivity.this.v != null) {
                        LivenessVideoActivity.this.B = LivenessVideoActivity.this.v.getRecogUploadPortraitCount(LivenessVideoActivity.this.B);
                    }
                    LivenessVideoActivity.this.l();
                    LivenessVideoActivity.this.K.reqTimes++;
                    return;
                }
                Toast.makeText(LivenessVideoActivity.this.getActivity(), "系统异常，失败回调", 1).show();
            }
        }.execute(faceVerifyDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.D != null && this.D.size() != 0) {
            this.F = this.D.get(0).get("data");
            this.G = this.D.get(0).get("digest");
            m();
        }
    }

    private void m() {
        RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.O);
        LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
        n nVar = (n) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 10, f2200b);
        if (this.livenessRecogDTO != null) {
            nVar.a(this.livenessRecogDTO);
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        super.handleResponse(i2, obj, str);
        if (i2 == 10) {
            if (obj != null && (obj instanceof VideoFaceMatchModel)) {
                a(((VideoFaceMatchModel) obj).isContrastPass() ? "1" : "0", 0);
            }
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

    private void a(String str, int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(this.livenessRecogDTO.spParams + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            arrayList.add(str);
            arrayList.add(this.K.reqTimes + "");
            RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.O, i2, arrayList);
        }
    }

    private void c(int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(this.livenessRecogDTO.spParams + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.W, i2, arrayList);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void c() {
        this.K.setProcessStartTime();
        this.K.updateState(1);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void a(boolean z) {
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void d() {
        this.P = true;
        RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.N);
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
            BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), com.baidu.fsg.face.liveness.d.N, jSONObject.toString());
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    void a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            b(z2, z);
        } else {
            a(z, z2);
        }
    }

    private void a(final boolean z, final boolean z2) {
        this.R = true;
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleVisible(true);
        String str = "";
        if (!z) {
            str = getString(R.string.sapi_liveness_video_record_failed);
        } else if (!z2) {
            str = getString(R.string.sapi_liveness_record_video_no_audio_permission);
        }
        bioAlertDialog.setDialogMsg(str);
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void b(final boolean z, final boolean z2) {
        this.R = true;
        String str = null;
        if (!z) {
            str = getString(R.string.sapi_permission_audio);
        }
        if (!z2) {
            str = getString(R.string.sapi_permission_camera);
        }
        if (!z && !z2) {
            str = getString(R.string.sapi_permission_audio_camera);
        }
        String format = String.format(getString(R.string.sapi_permission_without_title), str);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(format);
        bioAlertDialog.setTitleVisible(true);
        bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_permission_without_msg1), str) + String.format(getString(R.string.sapi_permission_without_msg2), str));
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void q() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.X);
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.j();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.Y);
                bioAlertDialog.dismiss();
                g.b(g.b(LivenessVideoActivity.this.getActivity()));
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.T + "");
        arrayList.add(String.valueOf(NetworkUtils.getNetworkType(getApplicationContext())));
        if (this.livenessRecogDTO != null) {
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        }
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.ad, arrayList);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(BeanConstants.rim_timeout_error);
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(2);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.X);
                bioAlertDialog.dismiss();
                LivenessVideoActivity.this.j();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.Y);
                bioAlertDialog.dismiss();
                g.b(g.b(LivenessVideoActivity.this.getActivity()));
                LivenessVideoActivity.this.a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void s() {
        RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.S);
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void t() {
        RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.Z);
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        RimStatisticsUtil.onEvent(com.baidu.fsg.face.liveness.d.R);
        a(-204, com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            this.j.release();
        }
        BeanManager.getInstance().removeAllBeans(c);
        BeanManager.getInstance().removeAllBeans(f2200b);
    }
}
