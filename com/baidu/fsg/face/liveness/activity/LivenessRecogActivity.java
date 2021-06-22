package com.baidu.fsg.face.liveness.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.DisplayUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.base.d.h;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.j;
import com.baidu.fsg.face.liveness.beans.k;
import com.baidu.fsg.face.liveness.beans.m;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.camera.CameraSurfaceView;
import com.baidu.fsg.face.liveness.camera.b;
import com.baidu.fsg.face.liveness.datamodel.GetRecordVedioQuestionModel;
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.LivenessABTestUtil;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.fsg.face.liveness.view.CustomExitDialog;
import com.baidu.fsg.face.liveness.view.CustomProgressBar;
import com.baidu.fsg.face.liveness.view.CustomSuccessView;
import com.baidu.fsg.face.liveness.view.LivenessXfordView;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.fsg.face.liveness.view.RecordVideoTipDialog;
import com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
import com.qq.e.comm.constants.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    public static final FaceTracker.ActionType aF = FaceTracker.ActionType.RECOGNIZE;
    public static final int aV = 0;
    public static final int aW = 1;
    public static final int aX = 2;
    public static final double au = 0.6d;
    public static final double av = 0.667d;
    public static final double aw = 0.3845d;
    public static final double ax = 0.667d;
    public static final double ay = 0.5d;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5675b = "LivenessRecogActivity";
    public static final int bN = 1;
    public static final int bO = 2;
    public static final int bP = 1;
    public static final int bQ = 2;
    public static final int bb = 0;
    public static final int bc = 1;
    public static final int bd = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5676c = "CONSTRASTBEANTAG";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5677d = 2002;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5678e = 2003;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5679f = 2004;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5680g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5681h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5682i = 0;
    public static final int j = 7057;
    public static final int k = 7401;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 255;
    public static final int s = 1;
    public static final int t = 5000;
    public static final int u = 200;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 4;
    public LivenessRecogCallback B;
    public ImageView C;
    public ImageView D;
    public ImageView E;
    public FrameLayout F;
    public TextView G;
    public RelativeLayout H;
    public TextView I;
    public TextView J;
    public TextView K;
    public LinearLayout L;
    public ImageView M;
    public TextView N;
    public RimFaceResultPageTipView O;
    public RelativeLayout P;
    public ImageView Q;
    public TextView R;
    public LinearLayout S;
    public ImageView T;
    public TextView U;
    public CameraSurfaceView V;
    public ImageView W;
    public LoadingDialog X;
    public BioAlertDialog Y;
    public BioAlertDialog Z;
    public LivenessRecogResult aA;
    public MediaPlayer aB;
    public FaceTracker aC;
    public FaceInfo[] aD;
    public String[] aG;
    public int aH;
    public f aI;
    public int[] aJ;
    public FaceTracker.ErrCode aK;
    public Handler aM;
    public d aN;
    public a aO;
    public long aP;
    public BioAlertDialog aa;
    public BioAlertDialog ab;
    public RecordVideoTipDialog ac;
    public CustomExitDialog ad;
    public CustomExitDialog ae;
    public CustomExitDialog af;
    public CustomExitDialog ag;
    public LivenessXfordView ah;
    public ImageView ai;
    public ImageView aj;
    public RelativeLayout ak;
    public TextView al;
    public LinearLayout am;
    public CustomProgressBar an;
    public CustomSuccessView ao;
    public int ap;
    public int aq;
    public Rect ar;
    public Rect as;
    public Rect at;
    public TextView az;
    public com.baidu.fsg.face.liveness.b bA;
    public int bB;
    public int bC;
    public ArrayList<HashMap<String, byte[]>> bD;
    public boolean bE;
    public byte[] bF;
    public byte[] bG;
    public byte[] bU;
    public int bV;
    public int bW;
    public int bX;
    public Camera bY;
    public b bh;
    public com.baidu.fsg.face.liveness.camera.b bi;
    public FrameLayout bj;
    public AnimationDrawable bk;
    public int bp;
    public long bq;
    public GetFPResponse.LivenessConfig br;
    public String bv;
    public String bw;
    public com.baidu.fsg.face.liveness.c by;
    public int A = -1;
    public int[] aE = null;
    public boolean aL = false;
    public boolean aQ = false;
    public boolean aR = true;
    public boolean aS = false;
    public boolean aT = false;
    public boolean aU = false;
    public int aY = 0;
    public int aZ = 0;
    public int ba = 0;
    public int be = 0;
    public int[] bf = {ErrorCode.SERVER_JSON_PARSE_ERROR, ErrorCode.VIDEO_DOWNLOAD_FAIL, 7100, 7101, 7019, 7020};
    public int bg = 0;
    public Map<Integer, SoftReference<Bitmap>> bl = new ConcurrentHashMap();
    public List<int[]> bm = new ArrayList();
    public Handler bn = new Handler(Looper.getMainLooper());
    public Runnable bo = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1
        @Override // java.lang.Runnable
        public void run() {
            LivenessRecogActivity.this.aH = 1;
            LivenessRecogActivity.this.U.setText(String.format("00:%02d", Integer.valueOf(LivenessRecogActivity.this.aO.n)));
            LivenessRecogActivity.this.bn.postDelayed(LivenessRecogActivity.this.bo, 1000L);
            int size = LivenessRecogActivity.this.bx.size() - (((LivenessRecogActivity.this.aO.n + LivenessRecogActivity.this.bu) - 1) / LivenessRecogActivity.this.bu);
            if (size == 0) {
                LivenessRecogActivity.this.I.setText((CharSequence) LivenessRecogActivity.this.bx.get(size));
                LivenessRecogActivity.this.J.setText(String.format(LivenessRecogActivity.this.getString(R.string.sapi_liveness_goto_next_question), Integer.valueOf(LivenessRecogActivity.this.aO.n - LivenessRecogActivity.this.bu)));
            } else if (size == 1) {
                LivenessRecogActivity.this.I.setText((CharSequence) LivenessRecogActivity.this.bx.get(size));
                LivenessRecogActivity.this.J.setText(String.format(LivenessRecogActivity.this.getString(R.string.sapi_liveness_will_be_completed), Integer.valueOf(LivenessRecogActivity.this.aO.n)));
            }
            if (LivenessRecogActivity.this.aO.n == 1) {
                LivenessRecogActivity.this.C.setVisibility(4);
                LivenessRecogActivity.this.K.setVisibility(4);
                LivenessRecogActivity.this.T.clearAnimation();
                LivenessRecogActivity.this.S.setVisibility(4);
            } else if (LivenessRecogActivity.this.aO.n == 0) {
                LivenessRecogActivity.this.bn.removeCallbacks(LivenessRecogActivity.this.bo);
                LivenessRecogActivity.this.bi.g();
                LivenessRecogActivity.this.bi.c();
                LivenessRecogActivity.this.ah.setLineVisiable(false);
                LivenessRecogActivity.this.ah.setMaskVisiable(true);
                Animation loadAnimation = AnimationUtils.loadAnimation(LivenessRecogActivity.this, R.anim.sapi_liveness_video_tip_slide_top_to_middle);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        LivenessRecogActivity.this.I.setText(LivenessRecogActivity.this.getString(R.string.sapi_liveness_upload_video));
                        LivenessRecogActivity.this.V();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        LivenessRecogActivity.this.I.setText(LivenessRecogActivity.this.getString(R.string.sapi_liveness_record_success));
                        LivenessRecogActivity.this.J.setVisibility(4);
                    }
                });
                LivenessRecogActivity.this.I.startAnimation(loadAnimation);
                LivenessRecogActivity.this.ao.setVisibility(0);
                LivenessRecogActivity.this.ao.loadSuccess();
                LivenessRecogActivity.this.aN.u = 15;
            }
            LivenessRecogActivity.this.aO.n--;
        }
    };
    public boolean bs = false;
    public int bt = 15;
    public int bu = 5;
    public List<String> bx = new ArrayList();
    public boolean bz = false;
    public boolean bH = false;
    public UploadContrastPortraitModel bI = null;
    public boolean bJ = ApollonConstants.VIDEO_DEBUG;
    public Runnable bK = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (LivenessRecogActivity.this.bq == 2) {
                LivenessRecogActivity.this.aN.u = 5;
                LivenessRecogActivity.this.aH = 0;
            } else {
                LivenessRecogActivity.this.aN.u = 7;
                LivenessRecogActivity.this.aH = 5;
            }
            long currentTimeMillis = 20000 - (System.currentTimeMillis() - LivenessRecogActivity.this.aN.C);
            if (currentTimeMillis < 5000) {
                LivenessRecogActivity.this.aN.D = 25000 - currentTimeMillis;
            }
        }
    };
    public int bL = 0;
    public int bM = 0;
    public UploadContrastPortraitModel bR = null;
    public long bS = 0;
    public View.OnClickListener bT = new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tv_record_video_retry) {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.K();
                LivenessRecogActivity.this.u();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Camera.PreviewCallback f5683a = new Camera.PreviewCallback() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            LivenessRecogActivity.this.bi.a(bArr);
            if (LivenessRecogActivity.this.bA != null) {
                LivenessRecogActivity.this.bA.a();
            }
            if (LivenessRecogActivity.this.aN.u != 0 && LivenessRecogActivity.this.aN.u != 10 && LivenessRecogActivity.this.aN.u != 14 && LivenessRecogActivity.this.aN.u != 17 && LivenessRecogActivity.this.aN.u != 15 && LivenessRecogActivity.this.aN.u != 16 && LivenessRecogActivity.this.aN.u != 19 && LivenessRecogActivity.this.aN.u != 18) {
                try {
                    if (LivenessRecogActivity.this.bg <= 0 && !LivenessRecogActivity.this.aL) {
                        LivenessRecogActivity.this.bY = camera;
                        LivenessRecogActivity.this.bU = bArr;
                        LivenessRecogActivity.this.a(camera);
                        LivenessRecogActivity.this.bh = new b();
                        LivenessRecogActivity.this.bh.execute(new Void[0]);
                        return;
                    }
                    camera.addCallbackBuffer(bArr);
                    return;
                } catch (Throwable th) {
                    com.baidu.fsg.face.base.d.d.a(th);
                    return;
                }
            }
            camera.addCallbackBuffer(bArr);
        }
    };
    public boolean bZ = false;
    public int ca = -1;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5742a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5743b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5744c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5745d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5746e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5747f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final long f5748g = 300;

        /* renamed from: h  reason: collision with root package name */
        public static final long f5749h = 1000;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5750i = 7;
        public static final int q = 0;
        public static final int r = 1;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public int m = 0;
        public int n = 7;
        public int o = 0;

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements MediaPlayer.OnErrorListener {
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            mediaPlayer.reset();
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static final int A = 5000;
        public static final int B = 20000;

        /* renamed from: a  reason: collision with root package name */
        public static final int f5752a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5753b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5754c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5755d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5756e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5757f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f5758g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final int f5759h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5760i = 8;
        public static final int j = 9;
        public static final int k = 10;
        public static final int l = 11;
        public static final int m = 12;
        public static final int n = 13;
        public static final int o = 14;
        public static final int p = 15;
        public static final int q = 16;
        public static final int r = 17;
        public static final int s = 18;
        public static final int t = 19;
        public long C;
        public int u = 0;
        public boolean v = false;
        public boolean w = false;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;
        public long D = 20000;
        public boolean E = false;
        public boolean F = false;

        public d() {
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5761a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5762b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5763c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5764d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5765e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5766f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f5767g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final int f5768h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5769i = 8;
        public static int[] j = {R.raw.sapi_camera_blink, R.raw.sapi_camera_found_face, R.raw.sapi_camera_put_face_round, R.raw.sapi_camera_nod, R.raw.sapi_camera_special_recg, R.raw.sapi_camera_photo_done, R.raw.sapi_camera_too_near, R.raw.sapi_camera_too_far, R.raw.sapi_camera_open_mouth};
    }

    /* loaded from: classes2.dex */
    public class f extends CountDownTimer {
        public f(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (LivenessRecogActivity.this.aL) {
                return;
            }
            LivenessRecogActivity.this.aI.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:145:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x03c0  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0442  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0448  */
        @Override // android.os.CountDownTimer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTick(long j) {
            String str;
            String str2;
            String str3;
            if (LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.u == 0 || LivenessRecogActivity.this.aN.u == 17 || LivenessRecogActivity.this.aN.u == 19 || LivenessRecogActivity.this.aN.u == 18 || LivenessRecogActivity.this.aN.u == 14 || LivenessRecogActivity.this.aN.u == 15 || LivenessRecogActivity.this.aN.u == 16) {
                return;
            }
            FaceInfo[] faceInfoArr = LivenessRecogActivity.this.aD;
            String str4 = "0";
            if (LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.u != 1) {
                if (LivenessRecogActivity.this.aN.u == 4) {
                    if (LivenessRecogActivity.this.M()) {
                        LivenessRecogActivity.this.N();
                        return;
                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        LivenessRecogActivity.this.A = -1;
                        LivenessRecogActivity.this.L.setVisibility(8);
                        if (LivenessRecogActivity.this.d(faceInfoArr)) {
                            if (LivenessRecogActivity.this.b(faceInfoArr)) {
                                if (LivenessRecogActivity.this.bq == 1) {
                                    LivenessRecogActivity.this.aN.u = 5;
                                } else {
                                    LivenessRecogActivity.this.aN.u = 7;
                                }
                                str = "";
                                long j2 = LivenessRecogActivity.this.bp * 1000;
                                if (j2 < 20000) {
                                    LivenessRecogActivity.this.aM.postDelayed(LivenessRecogActivity.this.bK, j2);
                                }
                                if (LivenessRecogActivity.this.aN.u != 5) {
                                    if (LivenessRecogActivity.this.M()) {
                                        LivenessRecogActivity.this.N();
                                        return;
                                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                                        LivenessRecogActivity.this.A = -1;
                                        LivenessRecogActivity.this.L.setVisibility(8);
                                        if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aO.k) {
                                            LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f5979h, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : str);
                                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWBLINK):  提示眨眨眼");
                                            LivenessRecogActivity.this.a(0, 1, (String) null);
                                            LivenessRecogActivity.this.aO.k = true;
                                        }
                                    }
                                } else if (LivenessRecogActivity.this.aN.u == 7) {
                                    if (LivenessRecogActivity.this.M()) {
                                        LivenessRecogActivity.this.N();
                                        return;
                                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                                        LivenessRecogActivity.this.A = -1;
                                        LivenessRecogActivity.this.L.setVisibility(8);
                                        if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aO.l) {
                                            LivenessRecogDTO livenessRecogDTO2 = LivenessRecogActivity.this.livenessRecogDTO;
                                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.j, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : str);
                                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWMOUTH):  提示张张嘴");
                                            LivenessRecogActivity.this.a(0, 3, (String) null);
                                            LivenessRecogActivity.this.aO.l = true;
                                        }
                                    }
                                }
                                if (LivenessRecogActivity.this.aN.u != 6 || LivenessRecogActivity.this.aN.u == 8) {
                                    if (!LivenessRecogActivity.this.M()) {
                                        LivenessRecogActivity.this.N();
                                        return;
                                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                                        if (LivenessRecogActivity.this.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                                            LivenessRecogActivity.this.c(2);
                                            return;
                                        }
                                        LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                                        if (livenessRecogActivity.b(faceInfoArr[0], livenessRecogActivity.aK)) {
                                            LivenessRecogActivity.this.c(3);
                                            return;
                                        } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                                            LivenessRecogActivity.this.c(4);
                                            LivenessRecogActivity.this.A = -1;
                                            return;
                                        } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                            LivenessRecogActivity.this.c(1);
                                            return;
                                        } else if (!h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                            LivenessRecogActivity.this.A = -1;
                                            LivenessRecogActivity.this.L.setVisibility(8);
                                            LivenessRecogActivity.this.a(faceInfoArr);
                                        } else {
                                            LivenessRecogActivity.this.c(0);
                                            return;
                                        }
                                    } else {
                                        LivenessRecogActivity.this.c(4);
                                        LivenessRecogActivity.this.aN.w = false;
                                        return;
                                    }
                                }
                                if (LivenessRecogActivity.this.aN.u == 9) {
                                    if (LivenessRecogActivity.this.M()) {
                                        LivenessRecogActivity.this.N();
                                        return;
                                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                                        if (LivenessRecogActivity.this.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                                            LivenessRecogActivity.this.c(2);
                                            return;
                                        }
                                        LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                                        if (livenessRecogActivity2.b(faceInfoArr[0], livenessRecogActivity2.aK)) {
                                            LivenessRecogActivity.this.c(3);
                                            return;
                                        } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                                            LivenessRecogActivity.this.c(4);
                                        } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                            LivenessRecogActivity.this.c(1);
                                            return;
                                        } else if (!h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                            LivenessRecogActivity.this.A = -1;
                                            LivenessRecogActivity.this.L.setVisibility(8);
                                        } else {
                                            LivenessRecogActivity.this.c(0);
                                            return;
                                        }
                                    } else {
                                        LivenessRecogActivity.this.c(4);
                                        LivenessRecogActivity.this.aN.w = false;
                                        return;
                                    }
                                }
                                if (LivenessRecogActivity.this.c(faceInfoArr) && !LivenessRecogActivity.this.aL && LivenessRecogActivity.this.aN.u == 9 && LivenessRecogActivity.this.aK == FaceTracker.ErrCode.OK) {
                                    FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.aC.get_FaceVerifyData(0);
                                    ArrayList arrayList = new ArrayList();
                                    if (faceVerifyDataArr != null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(faceVerifyDataArr.length);
                                        str2 = str;
                                        sb.append(str2);
                                        str3 = sb.toString();
                                    } else {
                                        str2 = str;
                                        str3 = "0";
                                    }
                                    arrayList.add(str3);
                                    LivenessRecogDTO livenessRecogDTO3 = LivenessRecogActivity.this.livenessRecogDTO;
                                    arrayList.add(livenessRecogDTO3 != null ? livenessRecogDTO3.getSpno() : str2);
                                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.p, arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("onEventWithValue(StatServiceEvent.RETRIEVEDIMAGE):  获取到活体图片的数量  ");
                                    if (faceVerifyDataArr != null) {
                                        str4 = faceVerifyDataArr.length + str2;
                                    }
                                    sb2.append(str4);
                                    LogUtil.d("hello", sb2.toString());
                                    LivenessRecogActivity livenessRecogActivity3 = LivenessRecogActivity.this;
                                    if (!livenessRecogActivity3.a(faceInfoArr[0], livenessRecogActivity3.aK) || faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
                                        return;
                                    }
                                    LivenessRecogActivity.this.aN.u = 10;
                                    LivenessRecogActivity.this.aM.removeCallbacks(LivenessRecogActivity.this.bK);
                                    LivenessRecogActivity.this.aI.cancel();
                                    LivenessRecogActivity.this.bi.c();
                                    LivenessRecogActivity.this.ai.setVisibility(0);
                                    LivenessRecogActivity.this.aj.setVisibility(0);
                                    LivenessRecogActivity.this.ak.setVisibility(0);
                                    LivenessRecogActivity.this.ah.setLineVisiable(false);
                                    LivenessRecogActivity.this.C.setVisibility(4);
                                    LivenessRecogActivity livenessRecogActivity4 = LivenessRecogActivity.this;
                                    livenessRecogActivity4.b(5, livenessRecogActivity4.getString(R.string.sapi_liveness_network_checking));
                                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                                    rotateAnimation.setRepeatCount(-1);
                                    rotateAnimation.setRepeatMode(1);
                                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                                    rotateAnimation.setInterpolator(linearInterpolator);
                                    LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                                    LivenessRecogActivity.this.ah.updateXfordViewProgress(0.5f, 0.75f, 500L, null);
                                    LivenessRecogActivity.this.b(LivenessRecogActivity.this.a(faceVerifyDataArr));
                                    return;
                                }
                                return;
                            }
                            LivenessRecogActivity.this.aN.u = 1;
                            LivenessRecogActivity.this.aN.v = false;
                            return;
                        }
                    } else {
                        LivenessRecogActivity.this.aN.u = 1;
                        LivenessRecogActivity.this.aN.v = false;
                        return;
                    }
                }
                str = "";
                if (LivenessRecogActivity.this.aN.u != 5) {
                }
                if (LivenessRecogActivity.this.aN.u != 6) {
                }
                if (!LivenessRecogActivity.this.M()) {
                }
            } else if (LivenessRecogActivity.this.M()) {
                LivenessRecogActivity.this.N();
            } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                if (LivenessRecogActivity.this.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                    LivenessRecogActivity.this.c(2);
                    if (LivenessRecogActivity.this.bA == null || LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.v || LivenessRecogActivity.this.aN.E) {
                        return;
                    }
                    LivenessRecogActivity.this.bA.b("2");
                    return;
                }
                LivenessRecogActivity livenessRecogActivity5 = LivenessRecogActivity.this;
                if (livenessRecogActivity5.b(faceInfoArr[0], livenessRecogActivity5.aK)) {
                    LivenessRecogActivity.this.c(3);
                    if (LivenessRecogActivity.this.bA == null || LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.v || LivenessRecogActivity.this.aN.E) {
                        return;
                    }
                    LivenessRecogActivity livenessRecogActivity6 = LivenessRecogActivity.this;
                    if (livenessRecogActivity6.c(faceInfoArr[0], livenessRecogActivity6.aK)) {
                        LivenessRecogActivity.this.bA.b("0");
                        return;
                    }
                    LivenessRecogActivity livenessRecogActivity7 = LivenessRecogActivity.this;
                    if (livenessRecogActivity7.d(faceInfoArr[0], livenessRecogActivity7.aK)) {
                        LivenessRecogActivity.this.bA.b("1");
                    }
                } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                    LivenessRecogActivity.this.c(4);
                    if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                        LivenessRecogActivity.this.bA.b("3");
                    }
                    LivenessRecogActivity.this.A = -1;
                    if (LivenessRecogActivity.this.aN != null) {
                        LivenessRecogActivity.this.aN.v = false;
                    }
                } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                    LivenessRecogActivity.this.c(1);
                    if (LivenessRecogActivity.this.bA == null || LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.v || LivenessRecogActivity.this.aN.E) {
                        return;
                    }
                    LivenessRecogActivity.this.bA.b("4");
                } else if (!h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                    LivenessRecogActivity.this.A = -1;
                    LivenessRecogActivity.this.L.setVisibility(8);
                    LivenessRecogActivity.this.aN.u = 2;
                    LivenessRecogDTO livenessRecogDTO4 = LivenessRecogActivity.this.livenessRecogDTO;
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f5978g, livenessRecogDTO4 != null ? livenessRecogDTO4.getSpno() : "");
                    LogUtil.d("hello", "onEvent(StatServiceEvent.FACEDETECTED):  监测到人脸");
                    if (!LivenessRecogActivity.this.aN.v) {
                        LivenessRecogActivity.this.aP = System.currentTimeMillis();
                        LivenessRecogActivity.this.aN.v = true;
                    }
                    LivenessRecogActivity.this.Q();
                } else {
                    LivenessRecogActivity.this.c(0);
                    if (LivenessRecogActivity.this.bA == null || LivenessRecogActivity.this.aN == null || LivenessRecogActivity.this.aN.v || LivenessRecogActivity.this.aN.E) {
                        return;
                    }
                    LivenessRecogActivity.this.bA.b("5");
                }
            } else {
                if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                    LivenessRecogActivity.this.bA.b("6");
                }
                if (LivenessRecogActivity.this.aN != null) {
                    LivenessRecogActivity.this.aN.v = false;
                }
                LivenessRecogActivity.this.A = -1;
                LivenessRecogActivity.this.L.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ int ao(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.bg + 1;
        livenessRecogActivity.bg = i2;
        return i2;
    }

    public static /* synthetic */ int aq(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.bg - 1;
        livenessRecogActivity.bg = i2;
        return i2;
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void l() {
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public void callbackFailure(int i2, String str) {
        if (this.B != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultCode(i2);
            livenessRecogResult.setResultMsg(str);
            this.B.b(livenessRecogResult);
            setActivityResult(-1);
            a(true);
        }
    }

    public void getRecordVideoQuestions() {
        d(getString(R.string.sapi_loading));
        com.baidu.fsg.face.liveness.beans.h hVar = (com.baidu.fsg.face.liveness.beans.h) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, f5675b);
        hVar.setResponseCallback(this);
        hVar.execBean();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        int i4 = 0;
        if (i2 == 5) {
            a("0", i3);
            if (this.be == 1) {
                while (true) {
                    int[] iArr = this.bf;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    if (i3 == iArr[i4]) {
                        this.aZ++;
                    }
                    i4++;
                }
            }
            if (this.bH) {
                this.aj.clearAnimation();
                this.ai.setVisibility(8);
                this.aj.setVisibility(8);
                this.ak.setVisibility(8);
                BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                if (this.be == 1 && this.ba < 1) {
                    int i5 = this.aY;
                    if (i5 >= 2) {
                        v();
                        return;
                    } else if (i5 == 1) {
                        x();
                        return;
                    } else {
                        int i6 = this.aZ;
                        if (i6 >= 2) {
                            v();
                            return;
                        } else if (i6 == 1) {
                            x();
                            return;
                        } else {
                            callbackFailure(i3, str);
                            return;
                        }
                    }
                }
                callbackFailure(i3, str);
                return;
            }
            W();
        } else if (i2 == 6) {
            Y();
            c(str);
        } else if (i2 != 7) {
            if (i2 == 8) {
                a(i3);
                a(i3, str);
            } else if (i2 == 12) {
                LogUtil.d("hello", SmsLoginView.f.l);
            } else if (i2 == 13) {
                callbackFailure(i3, str);
            } else {
                super.handleFailure(i2, i3, str);
            }
        } else if (this.aS && this.bI != null) {
            if (!ApollonConstants.VIDEO_DEBUG) {
                g.b(g.c(getActivity()));
            }
            a(this.bI);
            this.bI = null;
        } else if (this.aS) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultCode(i3);
            livenessRecogResult.setResultMsg(str);
            this.B.b(livenessRecogResult);
            setActivityResult(-1);
            a(true);
        } else {
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, i3, arrayList);
            }
            d dVar = this.aN;
            dVar.x = false;
            if (dVar.y) {
                return;
            }
            if (i3 == 7057) {
                E();
            } else if (i3 == 7401) {
                F();
            } else {
                D();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, final String str) {
        UploadContrastPortraitModel uploadContrastPortraitModel;
        String[] strArr;
        if (i2 == 5) {
            if (obj != null && (obj instanceof UploadContrastPortraitModel)) {
                UploadContrastPortraitModel uploadContrastPortraitModel2 = (UploadContrastPortraitModel) obj;
                a(uploadContrastPortraitModel2.isContrastPass() ? "1" : "0", 0);
                this.bw = uploadContrastPortraitModel2.callbackkey;
                if (uploadContrastPortraitModel2.isGotoRecordvideo()) {
                    this.aY++;
                }
                this.ba += uploadContrastPortraitModel2.contrastres;
                if (uploadContrastPortraitModel2.isFinish()) {
                    BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                    File file = new File(g.c(getActivity()));
                    if (this.aS && file.exists() && file.length() > 0) {
                        this.bI = uploadContrastPortraitModel2;
                        U();
                        return;
                    }
                    a(uploadContrastPortraitModel2);
                    return;
                }
                W();
                return;
            }
            handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == 6) {
            Y();
            if (obj != null && (obj instanceof GetRecordVedioQuestionModel)) {
                GetRecordVedioQuestionModel getRecordVedioQuestionModel = (GetRecordVedioQuestionModel) obj;
                if (!TextUtils.isEmpty(getRecordVedioQuestionModel.callbackkey) && (strArr = getRecordVedioQuestionModel.question) != null && strArr.length != 0) {
                    this.bv = getRecordVedioQuestionModel.callbackkey;
                    this.bx = Arrays.asList(strArr);
                    this.bu = getRecordVedioQuestionModel.questime;
                    r();
                    return;
                }
                c(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                return;
            }
            handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == 7) {
            if (this.aS && this.bI != null) {
                if (!ApollonConstants.VIDEO_DEBUG) {
                    g.b(g.c(getActivity()));
                }
                a(this.bI);
                this.bI = null;
                return;
            }
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, 0, arrayList);
            }
            d dVar = this.aN;
            dVar.x = false;
            if (obj == null || !(obj instanceof UploadVideoModel)) {
                return;
            }
            UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
            if (dVar.y) {
                return;
            }
            g.b(g.b(getActivity()));
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            this.aA = livenessRecogResult;
            livenessRecogResult.callbackkey = uploadVideoModel.callbackkey;
            livenessRecogResult.video = uploadVideoModel.video;
            livenessRecogResult.setResultCode(0);
            if (uploadVideoModel.need_confirm == null) {
                LivenessRecogCallback livenessRecogCallback = this.B;
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.a(this.aA);
                }
                if (this.aR) {
                    setActivityResult(-1);
                }
                a(true);
                return;
            }
            a(uploadVideoModel);
        } else if (i2 == 8) {
            if (TextUtils.isEmpty(str)) {
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
                return;
            }
            a(0);
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
            if (this.B != null) {
                new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.23
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public LivenessRecogResult doInBackground(Void... voidArr) {
                        byte[] encode;
                        LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                        livenessRecogResult2.setResultCode(0);
                        try {
                            livenessRecogResult2.extraJson = new JSONObject(str);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                        if (livenessRecogActivity.livenessRecogDTO != null) {
                            if (livenessRecogActivity.bm.size() > 0) {
                                LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                                livenessRecogResult2.originalImage = livenessRecogActivity2.a((int[]) livenessRecogActivity2.bm.get(LivenessRecogActivity.this.bm.size() - LivenessRecogActivity.this.bC));
                            }
                            if (LivenessRecogActivity.this.bF != null && (encode = Base64Utils.encode(LivenessRecogActivity.this.bF)) != null) {
                                livenessRecogResult2.faceimage = new String(encode);
                            }
                            if (LivenessRecogActivity.this.bG != null) {
                                livenessRecogResult2.imgdigests = new String(LivenessRecogActivity.this.bG);
                            }
                        }
                        return livenessRecogResult2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public void onPostExecute(LivenessRecogResult livenessRecogResult2) {
                        super.onPostExecute(livenessRecogResult2);
                        LivenessRecogActivity.this.B.a(livenessRecogResult2);
                        if (LivenessRecogActivity.this.aR) {
                            LivenessRecogActivity.this.setActivityResult(-1);
                        }
                        LivenessRecogActivity.this.a(true);
                    }
                }.execute(new Void[0]);
            }
        } else if (i2 == 13) {
            if (this.bM == 1 && this.bL == 1 && (uploadContrastPortraitModel = this.bR) != null) {
                b(uploadContrastPortraitModel);
            } else if (this.bM == 1 && this.bL == 2) {
                if (!this.aR) {
                    b();
                }
                setActivityResult(0);
                a(!this.aR);
                this.O.setVisibility(8);
            } else if (this.bM == 2 && this.bL == 1) {
                LivenessRecogCallback livenessRecogCallback2 = this.B;
                if (livenessRecogCallback2 != null) {
                    livenessRecogCallback2.a(this.aA);
                }
                if (this.aR) {
                    setActivityResult(-1);
                }
                a(true);
            } else if (this.bM == 2 && this.bL == 2) {
                if (!this.aR) {
                    b();
                }
                setActivityResult(0);
                a(!this.aR);
                this.O.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity
    public boolean isSupportLiuHai() {
        return true;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bE = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        if (livenessRecogDTO == null) {
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            if (livenessRecogCallback != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-206);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                livenessRecogCallback.b(livenessRecogResult);
            }
            finish();
            return;
        }
        if (livenessRecogDTO.spParams.contains("video_check=2")) {
            this.be = 2;
        } else if (this.livenessRecogDTO.spParams.contains("video_check=1")) {
            this.be = 1;
        }
        requestWindowFeature(1);
        getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        getWindow().addFlags(128);
        FrameLayout frameLayout = (FrameLayout) View.inflate(this, R.layout.layout_sapi_liveness_recognize, null);
        this.bj = frameLayout;
        setContentView(frameLayout);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        double d2 = i2;
        int i3 = (int) (0.667d * d2);
        int i4 = (i2 - i3) / 2;
        int i5 = (int) (displayMetrics.heightPixels * 0.3845d);
        int i6 = i5 - (i3 / 2);
        this.at = new Rect(i4, i6, i4 + i3, i3 + i6);
        int i7 = (int) (d2 * 0.6d);
        int i8 = (i2 - i7) / 2;
        int i9 = i5 - (i7 / 2);
        this.as = new Rect(i8, i9, i8 + i7, i7 + i9);
        f();
        d();
        this.ah.setFocusViewRect(this.as, this.at);
        if (!this.bs) {
            t();
            return;
        }
        b("0");
        u();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(f5675b);
        BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
        this.aL = true;
        this.aE = null;
        this.bU = null;
        LivenessXfordView livenessXfordView = this.ah;
        if (livenessXfordView != null) {
            livenessXfordView.release();
        }
        this.bm.clear();
        this.bm = null;
        try {
            a();
            this.bj.removeView(this.V);
            this.V = null;
            a(this.bj);
            this.bj.removeCallbacks(null);
            this.bj = null;
            this.aM.removeCallbacksAndMessages(null);
            System.gc();
        } catch (Exception e2) {
            com.baidu.fsg.face.base.d.d.a(e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.aN.x) {
                com.baidu.fsg.face.liveness.c cVar = this.by;
                if (cVar != null) {
                    cVar.a();
                }
                B();
                return false;
            }
            com.baidu.fsg.face.liveness.b bVar = this.bA;
            if (bVar != null) {
                bVar.a(com.baidu.fsg.face.liveness.d.o);
            }
            if (!this.aR) {
                b();
            }
            if (this.aN.u == 14) {
                this.bi.g();
            }
            this.bi.d();
            setActivityResult(0);
            a(!this.aR);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bz = true;
        if (this.aN.F) {
            return;
        }
        this.aI.cancel();
        d dVar = this.aN;
        if (dVar.u == 14) {
            dVar.z = true;
            LivenessXfordView livenessXfordView = this.ah;
            if (livenessXfordView != null) {
                livenessXfordView.setLineVisiable(false);
                this.ah.stopXfordViewProgress();
            }
            com.baidu.fsg.face.liveness.camera.b bVar = this.bi;
            if (bVar != null) {
                bVar.g();
                this.bi.c();
            }
            Handler handler = this.bn;
            if (handler != null) {
                handler.removeCallbacks(this.bo);
                return;
            }
            return;
        }
        this.bi.d();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int i3 = 0;
        this.aN.F = false;
        if (i2 != 2002) {
            if (i2 == 2004) {
                int i4 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
                if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                    i3 = 1;
                }
                if (i4 == 1 && i3 == 1) {
                    RecordVideoTipDialog recordVideoTipDialog = this.ac;
                    if (recordVideoTipDialog != null && recordVideoTipDialog.isShowing()) {
                        this.ac.dismiss();
                    }
                    this.aN.u = 14;
                    m();
                    getRecordVideoQuestions();
                    return;
                }
                a(i4, i3);
            }
        } else if (this.aS && this.aT) {
            int i5 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
            if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                i3 = 1;
            }
            if (i5 == 1 && i3 == 1) {
                if (m()) {
                    n();
                    q();
                    return;
                }
                return;
            }
            a(i5, i3);
        } else if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
            if (m()) {
                n();
                q();
            }
        } else {
            G();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.aQ) {
            this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
        } else {
            this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
        }
        if (this.bz) {
            this.bz = false;
            d dVar = this.aN;
            if (dVar.z) {
                C();
                this.aN.z = false;
            } else if (dVar.F) {
            } else {
                if (this.aS && dVar.u == 10) {
                    m();
                    return;
                }
                int i2 = this.aN.u;
                if (i2 < 12) {
                    if (m()) {
                        q();
                    }
                } else if (i2 == 18 || i2 == 17) {
                    m();
                }
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.bE);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void setActivityResult(int i2) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i2, intent);
    }

    /* loaded from: classes2.dex */
    public class b extends AsyncTask<Void, Void, String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.ao(LivenessRecogActivity.this);
            LivenessRecogActivity.this.L();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.aq(LivenessRecogActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.bi.g();
        this.bi.c();
        this.ah.setLineVisiable(false);
        this.ah.stopXfordViewProgress();
        this.bn.removeCallbacks(this.bo);
        this.aN.u = 18;
        CustomExitDialog customExitDialog = new CustomExitDialog(this);
        this.af = customExitDialog;
        customExitDialog.setDialogTitle(getString(R.string.rim_face_exit_record_title));
        this.af.setDialogContext(getString(R.string.rim_face_exit_record_content));
        this.af.setPositiveText(getString(R.string.rim_face_exit_record_positive), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.K();
                LivenessRecogActivity.this.u();
                LivenessRecogActivity.this.af.dismiss();
            }
        });
        this.af.setNegativeText(getString(R.string.rim_face_exit_record_negative), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.bA != null) {
                    LivenessRecogActivity.this.bA.a(com.baidu.fsg.face.liveness.d.o);
                }
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                if (LivenessRecogActivity.this.aN.u == 14) {
                    LivenessRecogActivity.this.bi.g();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
                LivenessRecogActivity.this.bi.d();
            }
        });
        this.af.setCancelable(false);
        this.af.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        CustomExitDialog customExitDialog = new CustomExitDialog(this);
        this.ag = customExitDialog;
        customExitDialog.setDialogTitle(getString(R.string.sapi_liveness_record_up_exit));
        this.ag.setPositiveText(getString(R.string.sapi_liveness_record_up_exit_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.aN.y = false;
                LivenessRecogActivity.this.ag.dismiss();
                LivenessRecogActivity.this.V();
            }
        });
        this.ag.setNegativeText(getString(R.string.sapi_liveness_record_up_exit_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.b(g.b(LivenessRecogActivity.this.getActivity()));
                LivenessRecogActivity.this.aN.y = false;
                LivenessRecogActivity.this.ag.dismiss();
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
        this.ag.setCancelable(false);
        if (isFinishing() || this.ag.isShowing()) {
            return;
        }
        this.ag.show();
    }

    private void C() {
        CustomExitDialog customExitDialog = this.ad;
        if (customExitDialog == null || !customExitDialog.isShowing()) {
            CustomExitDialog customExitDialog2 = new CustomExitDialog(this);
            this.ad = customExitDialog2;
            customExitDialog2.setDialogTitle(getString(R.string.sapi_liveness_record_video_exit_dialog_title));
            this.ad.setPositiveText(getString(R.string.sapi_liveness_record_video_exit_text), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.ad.dismiss();
                    LivenessRecogActivity.this.p();
                    LivenessRecogActivity.this.ad.dismiss();
                    LivenessRecogActivity.this.u();
                }
            });
            this.ad.setNegativeText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.ad.dismiss();
                    if (!LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.b();
                    }
                    LivenessRecogActivity.this.setActivityResult(0);
                    LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                    livenessRecogActivity.a(!livenessRecogActivity.aR);
                }
            });
            this.ad.setCancelable(false);
            if (isFinishing() || this.ad.isShowing()) {
                return;
            }
            this.ad.show();
        }
    }

    private void D() {
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg_retry));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_upload_video_fail_dialog_reupload));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.19
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.O.setVisibility(8);
                LivenessRecogActivity.this.V();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(8);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                g.b(g.b(LivenessRecogActivity.this.getActivity()));
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    private void E() {
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_record_video_title_upload_timeout));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.20
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.O.setVisibility(4);
                LivenessRecogActivity.this.K();
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.u();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(4);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    private void F() {
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_record_video_no_face));
        this.O.setResultPageNextTitle(getString(R.string.sapi_liveness_record_video_in_rect));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.21
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.O.setVisibility(4);
                LivenessRecogActivity.this.K();
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.u();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(4);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    private void G() {
        this.aN.F = true;
        if (this.Y == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            this.Y = bioAlertDialog;
            bioAlertDialog.setTitleMsg(getString(R.string.sapi_permission_request));
            this.Y.setTitleVisible(true);
            this.Y.setDialogMsg(String.format(getString(R.string.sapi_liveness_permission_camera), h.c(this)));
            this.Y.setBtnCount(1);
            this.Y.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Y.dismiss();
                    LivenessRecogActivity.this.aN.F = false;
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-307);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.Y.setCancelable(false);
        if (isFinishing() || this.Y.isShowing()) {
            return;
        }
        this.Y.show();
    }

    private void H() {
        this.aN.u = 19;
        if (this.Z == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            this.Z = bioAlertDialog;
            bioAlertDialog.setTitleVisible(true);
            this.Z.setDialogMsg(getString(R.string.sapi_liveness_open_camera_no_permission));
            this.Z.setBtnCount(1);
            this.Z.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Z.dismiss();
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-307);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.Z.setCancelable(false);
        if (isFinishing() || this.Z.isShowing()) {
            return;
        }
        this.Z.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleVisible(true);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_no_audio_permission));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                if (LivenessRecogActivity.this.B != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                    LivenessRecogActivity.this.B.b(livenessRecogResult);
                }
                LivenessRecogActivity.this.a(true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (isFinishing() || bioAlertDialog.isShowing()) {
            return;
        }
        bioAlertDialog.show();
    }

    private boolean J() {
        this.aN.u = 14;
        if (this.bi.b(this)) {
            return true;
        }
        I();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.ah.setVisibility(0);
        this.U.setVisibility(0);
        this.T.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.bU == null || this.aE == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = -com.baidu.fsg.face.liveness.camera.b.f5965i;
            this.bX = i2;
            FaceSDK.getARGBFromYUVimg(this.bU, this.aE, this.bV, this.bW, i2, 1);
            this.aK = this.aC.face_verification(this.aE, this.bV, this.bW, FaceSDK.ImgType.ARGB, aF, "", "", "");
            FaceInfo[] faceInfoArr = this.aC.get_TrackedFaceInfo();
            this.aD = faceInfoArr;
            int i3 = (faceInfoArr == null || faceInfoArr.length <= 0 || faceInfoArr[0] == null) ? 0 : faceInfoArr[0].face_id;
            if (i3 != 0 && i3 != this.ca) {
                this.bm.clear();
            }
            this.ca = i3;
            if (this.aK == FaceTracker.ErrCode.DATA_HIT_ONE) {
                if (this.bZ) {
                    this.bm.clear();
                    this.bZ = false;
                }
                if (this.aE != null) {
                    this.bm.add(Arrays.copyOf(this.aE, this.aE.length));
                }
            } else if (this.aK == FaceTracker.ErrCode.DATA_HIT_LAST) {
                if (this.aE != null) {
                    this.bm.add(Arrays.copyOf(this.aE, this.aE.length));
                }
                this.bZ = true;
            }
            this.bY.addCallbackBuffer(this.bU);
            this.bU = null;
            if (this.br == null || !this.br.isStatisticsEnable()) {
                this.aE = null;
            }
            if (this.bA != null) {
                this.bA.a(this.aK);
                if (this.aN != null && !this.aN.v && !this.aN.E) {
                    this.bA.b(this.aK);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.bA != null) {
                this.bA.a(currentTimeMillis2);
            }
            if (this.aN == null || this.aN.u != 6 || this.bA == null) {
                return;
            }
            this.bA.b(currentTimeMillis2);
        } catch (Throwable th) {
            com.baidu.fsg.face.base.d.d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        long currentTimeMillis = System.currentTimeMillis();
        d dVar = this.aN;
        long j2 = dVar.C;
        return currentTimeMillis - j2 > dVar.D && j2 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.aS && this.bi.e()) {
            this.bi.f();
        }
        d dVar = this.aN;
        dVar.C = 0L;
        if (!dVar.E) {
            com.baidu.fsg.face.liveness.b bVar = this.bA;
            if (bVar != null) {
                bVar.a(com.baidu.fsg.face.liveness.d.l);
            }
            LogUtil.d("hello", "onEvent(StatServiceEvent.FIRSTTIMEOUT):  一次超时");
            w();
            this.aN.E = true;
            O();
            return;
        }
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.m, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.SECONDTIMEOUT):  两次超时");
        if (this.be == 1) {
            b("1");
            v();
            return;
        }
        y();
    }

    private void O() {
        GetFPResponse.LivenessConfig livenessConfig;
        d dVar;
        if (this.aE == null || (livenessConfig = this.br) == null || !livenessConfig.isStatisticsEnable()) {
            return;
        }
        if ("1".equals(this.br.report_type) && ((dVar = this.aN) == null || dVar.v)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.29
            @Override // java.lang.Runnable
            public void run() {
                k kVar = (k) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 12, LivenessRecogActivity.f5675b);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                kVar.d(livenessRecogActivity.a(livenessRecogActivity.aE));
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    kVar.a(livenessRecogDTO);
                }
                if (LivenessRecogActivity.this.br != null) {
                    kVar.a(LivenessRecogActivity.this.br.report_type);
                }
                if (LivenessRecogActivity.this.bA != null) {
                    kVar.a(LivenessRecogActivity.this.bA.f5866d, LivenessRecogActivity.this.bA.f5867e);
                }
                kVar.setResponseCallback(LivenessRecogActivity.this);
                kVar.execBean();
            }
        }).start();
    }

    private void P() {
        this.bk = (AnimationDrawable) this.E.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.aN.u = 3;
        this.E.setVisibility(0);
        d(4);
        this.bk.start();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.32
            @Override // java.lang.Runnable
            public void run() {
                LivenessRecogActivity.this.bk.stop();
                LivenessRecogActivity.this.E.setVisibility(8);
                if (LivenessRecogActivity.this.aN.u == 17 || LivenessRecogActivity.this.aN.u == 18) {
                    return;
                }
                LivenessRecogActivity.this.aN.u = 4;
            }
        }, 1500L);
        this.ah.updateXfordViewProgress(0.25f, 0.5f, 500L, null);
    }

    private void R() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.spai_liveness_video_scale_count_down);
        final Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
        this.P.setVisibility(0);
        this.R.setVisibility(0);
        this.R.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.33
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    LivenessRecogActivity.this.R.setTextSize(14.5f);
                    LivenessRecogActivity.this.R.setText(R.string.sapi_liveness_video_start_record_new);
                    LivenessRecogActivity.this.Q.setVisibility(0);
                    LivenessRecogActivity.this.aO.m = 0;
                    LivenessRecogActivity.this.Q.startAnimation(loadAnimation2);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    LivenessRecogActivity.this.R.setTextSize(12.0f);
                    String string = LivenessRecogActivity.this.getString(R.string.sapi_liveness_video_start_record_later_new);
                    LivenessRecogActivity.this.aO.n = LivenessRecogActivity.this.bx.size() * LivenessRecogActivity.this.bu;
                    LivenessRecogActivity.this.R.setText(String.format(string, Integer.valueOf(LivenessRecogActivity.this.aO.n)));
                    LivenessRecogActivity.this.Q.setVisibility(4);
                    LivenessRecogActivity.this.ah.setProgress(0.0f);
                    LivenessRecogActivity.this.ah.setMaskVisiable(true);
                    LivenessRecogActivity.this.ah.setLineVisiable(false);
                    LivenessRecogActivity.this.S.setVisibility(4);
                }
            }
        });
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.35
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    LivenessRecogActivity.this.aO.m++;
                    if (LivenessRecogActivity.this.aO.m != 1) {
                        if (LivenessRecogActivity.this.aO.m == 3) {
                            LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_1);
                            LivenessRecogActivity.this.Q.startAnimation(animation);
                            return;
                        } else if (LivenessRecogActivity.this.aO.m > 4) {
                            LivenessRecogActivity.this.P.setVisibility(4);
                            LivenessRecogActivity.this.R.setVisibility(4);
                            LivenessRecogActivity.this.Q.setVisibility(4);
                            LivenessRecogActivity.this.I.startAnimation(loadAnimation3);
                            LivenessRecogActivity.this.ah.setMaskVisiable(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    animation.reset();
                    LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_2);
                    LivenessRecogActivity.this.Q.startAnimation(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    if (LivenessRecogActivity.this.aO.m == 0) {
                        LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
                    }
                    LivenessRecogActivity.this.I.setText(String.format(LivenessRecogActivity.this.getString(R.string.sapi_liveness_video_answer_question), Integer.valueOf(LivenessRecogActivity.this.bx.size())));
                }
            }
        });
        loadAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.36
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    LivenessRecogActivity.this.J.setVisibility(0);
                    LivenessRecogActivity.this.S.setVisibility(0);
                    LivenessRecogActivity.this.U.setText(String.format("00:%02d", Integer.valueOf(LivenessRecogActivity.this.aO.n)));
                    LivenessRecogActivity.this.S();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (LivenessRecogActivity.this.aN.z) {
                    return;
                }
                if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                    LivenessRecogActivity.this.I.setText((CharSequence) LivenessRecogActivity.this.bx.get(0));
                    LivenessRecogActivity.this.J.setVisibility(4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (J()) {
            this.ah.setLineVisiable(true);
            this.C.setVisibility(0);
            this.K.setVisibility(0);
            this.bn.post(this.bo);
            this.ah.updateXfordViewProgress(0.0f, 1.0f, this.aO.n * 1000, null);
            this.T.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_time_count_point));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.37
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(g.b(LivenessRecogActivity.this.getActivity()));
                    if (!file.exists() || file.length() <= 0) {
                        LivenessRecogActivity.this.bi.g();
                        LivenessRecogActivity.this.bi.c();
                        LivenessRecogActivity.this.ah.setLineVisiable(false);
                        LivenessRecogActivity.this.ah.stopXfordViewProgress();
                        LivenessRecogActivity.this.I();
                        LivenessRecogActivity.this.bn.removeCallbacks(LivenessRecogActivity.this.bo);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String T() {
        int i2;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(g.b(getActivity()));
            try {
                i2 = fileInputStream2.available();
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
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
                i2 = 0;
                if (i2 >= 1024) {
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
        if (i2 >= 1024) {
            return "1KB";
        }
        if (i2 < 1023488) {
            StringBuilder sb = new StringBuilder();
            sb.append(Math.round(i2 / 1024.0d));
            sb.append("KB");
            String sb2 = sb.toString();
            return sb2.contains(".0KB") ? sb2.replace(".0KB", "KB") : sb2;
        }
        String str = String.format("%.1f", Double.valueOf(i2 / 1048576.0d)) + "M";
        return str.contains(".0M") ? str.replace(".0M", "M") : str;
    }

    private void U() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(g.c(getActivity()));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f5675b);
            UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
            uploadFileModel.filedata = bArr;
            uploadFileModel.fileName = "video.3gp";
            uploadFileModel.name = "file";
            mVar.addFile(uploadFileModel);
            mVar.d("process");
            mVar.b(this.bw);
            mVar.c(this.bw);
            mVar.setProgressListener(new RestMultipartEntity.ProgressListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.38
                @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                public void transferred(long j2, long j3) {
                    LogUtil.e("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("progress:  ");
                    sb.append((int) ((((float) j2) / ((float) j3)) * 100.0f));
                    LogUtil.e("hello", sb.toString());
                }
            });
            mVar.setResponseCallback(this);
            mVar.execBean();
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            LogUtil.d(e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        FileInputStream fileInputStream;
        this.aN.x = true;
        this.ao.setVisibility(4);
        this.an.setPercent(0.0f);
        this.am.setVisibility(0);
        this.aN.u = 16;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(g.b(this));
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.y);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
            m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f5675b);
            UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
            uploadFileModel.filedata = bArr;
            uploadFileModel.fileName = "video.3gp";
            uploadFileModel.name = "file";
            mVar.addFile(uploadFileModel);
            mVar.b(this.bv);
            mVar.c(this.bw);
            mVar.a("1");
            mVar.setProgressListener(new RestMultipartEntity.ProgressListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39
                @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                public void transferred(final long j2, final long j3) {
                    LogUtil.d("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("progress:  ");
                    sb.append((int) ((((float) j2) / ((float) j3)) * 100.0f));
                    LogUtil.d("hello", sb.toString());
                    LivenessRecogActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = LivenessRecogActivity.this.al;
                            textView.setText(((int) ((((float) j2) / ((float) j3)) * 100.0f)) + "%");
                            LivenessRecogActivity.this.an.setPercent(((float) j2) / ((float) j3));
                        }
                    });
                }
            });
            mVar.setResponseCallback(this);
            mVar.execBean();
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            D();
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.bH) {
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
            if (this.B != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-206);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                this.B.b(livenessRecogResult);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        int i2 = this.bC + 1;
        this.bC = i2;
        ArrayList<HashMap<String, byte[]>> arrayList = this.bD;
        if (arrayList != null && i2 <= arrayList.size()) {
            if (this.bC == 1) {
                RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.q);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
            }
            byte[] bArr = this.bD.get(this.bC - 1).get("data");
            byte[] bArr2 = this.bD.get(this.bC - 1).get(LightappBusinessClient.MTD_DIGEST);
            this.bH = this.bC == this.bD.size();
            j jVar = (j) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 5, "CONSTRASTBEANTAG");
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO != null) {
                jVar.a(livenessRecogDTO);
            }
            if (bArr2 != null) {
                jVar.b(new String(bArr2));
            }
            if (bArr != null) {
                jVar.d(Base64Utils.encodeToString(bArr));
            }
            jVar.a("1");
            jVar.setResponseCallback(this);
            jVar.a(this.bH);
            jVar.c(this.bw);
            jVar.execBean();
            return;
        }
        BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
        if (this.B != null) {
            LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
            livenessRecogResult2.setResultCode(-206);
            livenessRecogResult2.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
            this.B.b(livenessRecogResult2);
            setActivityResult(-1);
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        int i2 = this.bC + 1;
        this.bC = i2;
        ArrayList<HashMap<String, byte[]>> arrayList = this.bD;
        if (arrayList == null || i2 > this.bB || i2 > arrayList.size()) {
            return;
        }
        this.bF = this.bD.get(this.bC - 1).get("data");
        this.bG = this.bD.get(this.bC - 1).get(LightappBusinessClient.MTD_DIGEST);
        this.bH = this.bC == this.bD.size();
        if (this.bC == 1) {
            RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.H);
        }
        com.baidu.fsg.face.liveness.beans.e eVar = (com.baidu.fsg.face.liveness.beans.e) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 8, "CONSTRASTBEANTAG");
        if (this.bG != null) {
            eVar.a(new String(this.bG));
        }
        new UploadBean.UploadFileModel().contentType = "image/png";
        eVar.d(Base64Utils.encodeToString(this.bF));
        eVar.setResponseCallback(this);
        eVar.a(this.bH);
        eVar.execBean();
    }

    private void Y() {
        if (this.X == null || isFinishing() || !this.X.isShowing()) {
            return;
        }
        this.X.dismiss();
    }

    private int Z() {
        try {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return getResources().getDimensionPixelSize(identifier);
            }
            return 75;
        } catch (Exception e2) {
            com.baidu.fsg.face.base.d.d.a(e2);
            return 75;
        }
    }

    private boolean m() {
        LogUtil.d("openCamera被调用了");
        this.V.setVisibility(4);
        boolean a2 = this.bi.a(this, 3);
        if (!a2) {
            H();
        } else {
            a(this.bi.i());
            this.bi.a(this.f5683a);
            this.V.startPreview();
        }
        this.V.setVisibility(0);
        return a2;
    }

    private void n() {
        if (this.bE || this.livenessRecogDTO == null) {
            return;
        }
        this.bE = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        LogUtil.d("hello", "相机准备好实时埋点");
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.w, arrayList);
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
        BdWalletUtils.realTimeStatistics(applicationContext, livenessRecogDTO.spParams, livenessRecogDTO.getAtbc(), com.baidu.fsg.face.liveness.d.w, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.ah.setLineVisiable(true);
        this.C.setVisibility(0);
        this.L.setVisibility(4);
        this.A = -1;
        this.G.setText(R.string.sapi_liveness_put_face_round);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.ah.stopXfordViewProgress();
        Handler handler = this.bn;
        if (handler != null) {
            handler.removeCallbacks(this.bo);
        }
        this.R.clearAnimation();
        this.R.setVisibility(4);
        this.aO.m = -100;
        this.Q.clearAnimation();
        this.Q.setVisibility(4);
        this.I.clearAnimation();
        this.I.setText(R.string.sapi_liveness_put_face_round_new);
        this.J.setVisibility(4);
        this.an.setPercent(0.0f);
        this.am.setVisibility(4);
        this.R.removeCallbacks(null);
        this.L.setVisibility(4);
        this.G.setVisibility(4);
        this.A = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.aS && !this.bi.e()) {
            this.bi.a((Context) this);
        }
        this.aN.C = System.currentTimeMillis();
        a(0, 0, (String) null);
        this.aI.start();
        this.ah.updateXfordViewProgress(0.0f, 0.25f, 500L, null);
    }

    private void r() {
        this.H.setVisibility(0);
        this.G.setVisibility(4);
        this.C.setVisibility(4);
        this.K.setVisibility(4);
        this.K.setOnClickListener(this.bT);
        this.bi.b();
        R();
    }

    private b.a s() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new b.a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + com.baidu.fsg.face.base.d.f.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String[] strArr;
        if (this.aS && this.aT) {
            strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
        } else {
            strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
        }
        if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
            DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.44
                @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                @RequiresApi(api = 23)
                public void isAllAgree(boolean z2) {
                    if (z2) {
                        LivenessRecogActivity.this.aN.F = true;
                        if (LivenessRecogActivity.this.aS && LivenessRecogActivity.this.aT) {
                            LivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                            return;
                        } else {
                            LivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                            return;
                        }
                    }
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-307);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        } else if (m()) {
            n();
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.aN.u = 12;
        this.D.setVisibility(4);
        this.L.setVisibility(4);
        this.F.setVisibility(4);
        String[] strArr = {PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE};
        if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
            DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.45
                @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                @RequiresApi(api = 23)
                public void isAllAgree(boolean z2) {
                    if (z2) {
                        LivenessRecogActivity.this.aN.F = true;
                        LivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2004);
                        return;
                    }
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
            return;
        }
        this.aN.u = 14;
        RecordVideoTipDialog recordVideoTipDialog = this.ac;
        if (recordVideoTipDialog != null && recordVideoTipDialog.isShowing()) {
            this.ac.dismiss();
        }
        if (m()) {
            getRecordVideoQuestions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        b("2");
        this.bi.b();
        this.aN.u = 18;
        this.aM.removeCallbacks(this.bK);
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_safe);
        this.O.setResultPageTitle(getString(R.string.rim_face_result_success_record));
        this.O.setResultPageNextTitleBold(getString(R.string.rim_face_result_record_video));
        this.O.setResultPageConfirmText(getString(R.string.rim_face_result_start_record));
        this.O.setResultPageCancelText(getString(R.string.rim_face_result_retry_liveness));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.2
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.u();
                LivenessRecogActivity.this.O.setVisibility(8);
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.t();
                LivenessRecogActivity.this.aD = null;
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aO.k = false;
                LivenessRecogActivity.this.aO.l = false;
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aH = livenessRecogActivity.e();
                LivenessRecogActivity.this.aN.C = System.currentTimeMillis();
                LivenessRecogActivity.this.O.setVisibility(8);
            }
        });
        this.O.setOnCloseListener(new RimFaceResultPageTipView.b() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.3
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.b
            public void a() {
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
                LivenessRecogActivity.this.O.setVisibility(8);
            }
        });
    }

    private void w() {
        if (this.aS && this.bi.e()) {
            this.bi.f();
        }
        this.aN.u = 17;
        this.aM.removeCallbacks(this.bK);
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_dialog_recognized_timeout_title));
        this.O.setResultPageNextTitle(getString(R.string.sapi_liveness_dialog_recognized_timeout_next_title));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.6
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.q();
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aH = livenessRecogActivity.e();
                LivenessRecogActivity.this.aO.k = false;
                LivenessRecogActivity.this.aO.l = false;
                LivenessRecogActivity.this.aN.C = System.currentTimeMillis();
                LivenessRecogActivity.this.O.setVisibility(8);
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(8);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.bi.d();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.aS && this.bi.e()) {
            this.bi.f();
        }
        this.aN.u = 18;
        this.aM.removeCallbacks(this.bK);
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_dialog_recognized_failed_title));
        this.O.setResultPageNextTitle(getString(R.string.sapi_liveness_dialog_recognized_failed_next_title));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.7
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.t();
                LivenessRecogActivity.this.aD = null;
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aO.k = false;
                LivenessRecogActivity.this.aO.l = false;
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aH = livenessRecogActivity.e();
                LivenessRecogActivity.this.aN.C = System.currentTimeMillis();
                LivenessRecogActivity.this.O.setVisibility(8);
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(8);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.bi.d();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    private void y() {
        if (this.aS && this.bi.e()) {
            this.bi.f();
        }
        this.aN.u = 17;
        this.aM.removeCallbacks(this.bK);
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.sapi_liveness_dialog_recognized_device_title));
        this.O.setResultPageNextTitle(getString(R.string.sapi_liveness_dialog_recognized_failed_next_title));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.8
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.q();
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aH = livenessRecogActivity.e();
                LivenessRecogActivity.this.aO.k = false;
                LivenessRecogActivity.this.aO.l = false;
                LivenessRecogActivity.this.aN.C = System.currentTimeMillis();
                LivenessRecogActivity.this.O.setVisibility(8);
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(8);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.bi.d();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.bi.c();
        this.ah.setLineVisiable(false);
        this.aN.u = 18;
        this.aM.removeCallbacks(this.bK);
        CustomExitDialog customExitDialog = new CustomExitDialog(this);
        this.ae = customExitDialog;
        customExitDialog.setDialogTitle(getString(R.string.rim_face_exit_action_title));
        this.ae.setDialogContext(getString(R.string.rim_face_exit_action_content));
        this.ae.setPositiveText(getString(R.string.rim_face_exit_action_positive), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.bi.b();
                LivenessRecogActivity.this.q();
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aH = livenessRecogActivity.e();
                LivenessRecogActivity.this.aO.k = false;
                LivenessRecogActivity.this.aO.l = false;
                LivenessRecogActivity.this.aN.C = System.currentTimeMillis();
                LivenessRecogActivity.this.ae.dismiss();
            }
        });
        this.ae.setNegativeText(getString(R.string.rim_face_exit_action_negative), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.bA != null) {
                    LivenessRecogActivity.this.bA.a(com.baidu.fsg.face.liveness.d.o);
                }
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                if (LivenessRecogActivity.this.aN.u == 14) {
                    LivenessRecogActivity.this.bi.g();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
                LivenessRecogActivity.this.bi.d();
            }
        });
        this.ae.setCancelable(false);
        this.ae.show();
    }

    private void f() {
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        this.aR = livenessRecogDTO.showGuidePage;
        this.aQ = livenessRecogDTO.soundSwitch;
        this.aU = livenessRecogDTO.randomLiveness;
        this.bs = livenessRecogDTO.switchVideo;
        this.aS = livenessRecogDTO.recordLiveness && Build.VERSION.SDK_INT >= 18;
        this.aG = getResources().getStringArray(R.array.sapi_liveness_head_pose);
        this.aM = new Handler(Looper.getMainLooper(), this);
        this.aN = new d();
        this.aO = new a();
        this.aI = new f(5000L, 200L);
        this.aN.C = System.currentTimeMillis();
        com.baidu.fsg.face.liveness.b bVar = new com.baidu.fsg.face.liveness.b(this.livenessRecogDTO);
        this.bA = bVar;
        bVar.f5863a = System.currentTimeMillis();
        this.B = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        g();
        this.aH = e();
        if (this.bs) {
            l();
        } else {
            i();
        }
    }

    private void g() {
        GetFPResponse.LivenessConfig a2 = com.baidu.fsg.face.liveness.beans.c.a().a(getActivity());
        this.br = a2;
        if (a2 == null) {
            this.br = new GetFPResponse.LivenessConfig();
        }
        this.bp = this.br.getRecogtimeInterval();
        if (this.aU) {
            this.bq = new Random().nextInt(100) % 2 == 0 ? 1L : 2L;
        } else {
            this.bq = this.br.getRecogActionType();
        }
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        if (livenessRecogDTO == null || livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            return;
        }
        h();
    }

    private void h() {
        JSONObject livenessBgStyleABTestContent = LivenessABTestUtil.getInstance(getApplicationContext()).getLivenessBgStyleABTestContent();
        if (livenessBgStyleABTestContent == null) {
            return;
        }
        try {
            if (this.livenessRecogDTO != null) {
                livenessBgStyleABTestContent.put("processid", this.livenessRecogDTO.processid);
            }
            livenessBgStyleABTestContent.put("exp_time", System.currentTimeMillis() + "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.livenessRecogDTO != null) {
            Context applicationContext = getActivity().getApplicationContext();
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            BdWalletUtils.realTimeStatistics(applicationContext, livenessRecogDTO.spParams, livenessRecogDTO.getAtbc(), "ABTestStart", livenessBgStyleABTestContent.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(livenessBgStyleABTestContent.toString());
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventWithValues("ABTestStart", arrayList);
        }
    }

    private void i() {
        try {
            j();
            k();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (!this.aR && this.B != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-303);
                this.B.b(livenessRecogResult);
            }
            setActivityResult(0);
            a(!this.aR);
        }
    }

    private void j() throws Exception {
        if (!com.baidu.fsg.face.base.b.d.a(this, 4, new Bundle())) {
            throw new Exception("load so failure");
        }
    }

    private void k() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty("frfsd_ai")) {
            try {
                FaceTracker faceTracker = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
                this.aC = faceTracker;
                faceTracker.set_isFineAlign(false);
                this.aC.set_isVerifyLive(true);
                if (this.br == null) {
                    this.br = new GetFPResponse.LivenessConfig();
                }
                this.aC.set_min_face_size(this.br.getMinFaceSize());
                this.aC.set_illum_thr(this.br.getIllumThr());
                this.aC.set_track_by_detection_interval(this.br.getTrackInterval());
                this.aC.set_detect_in_video_interval(this.br.getDetectInterval());
                this.aC.set_eulur_angle_thr(this.br.getYaw(), this.br.getPitch(), this.br.getRoll());
                this.aC.set_max_reg_img_num(this.br.getMaxRegImgNum(this.livenessRecogDTO.getSpno()));
                this.aC.set_prefetch_reg_img_interval(this.br.getPrefetchRegImgInterval());
                this.aC.set_cropFaceSize(this.br.getCropFaceSize());
                this.aC.set_cropFaceEnlargeRatio(this.br.getCropFaceRatio());
                return;
            } catch (Exception e2) {
                throw new Exception("init faceTracker failure: " + e2.getMessage());
            }
        }
        throw new Exception("idlToken or apiKey is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        if (this.bq == 1) {
            this.aH = 0;
        } else {
            this.aH = 5;
        }
        return this.aH;
    }

    private void d() {
        com.baidu.fsg.face.base.d.f.b(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        ImageView imageView = (ImageView) findViewById(R.id.btn_cancel);
        this.C = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.42
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.aN.x) {
                    if (LivenessRecogActivity.this.by != null) {
                        LivenessRecogActivity.this.by.a();
                    }
                    LivenessRecogActivity.this.B();
                } else if (LivenessRecogActivity.this.aN.u == 17 || LivenessRecogActivity.this.aN.u == 18) {
                } else {
                    if (LivenessRecogActivity.this.aN.u == 12 || LivenessRecogActivity.this.aN.u == 14) {
                        LivenessRecogActivity.this.A();
                    } else {
                        LivenessRecogActivity.this.z();
                    }
                }
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.btn_switch_voice);
        this.D = imageView2;
        if (this.aQ) {
            imageView2.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
        } else {
            imageView2.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
        }
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.aQ = !livenessRecogActivity.aQ;
                ArrayList arrayList = new ArrayList();
                arrayList.add(LivenessRecogActivity.this.aQ ? "1" : "0");
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.f5975d, arrayList);
                if (LivenessRecogActivity.this.aQ) {
                    LivenessRecogActivity.this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
                } else {
                    LivenessRecogActivity.this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
                }
            }
        });
        this.F = (FrameLayout) findViewById(R.id.layout_pose_tip);
        this.G = (TextView) findViewById(R.id.tv_pose_tip);
        this.H = (RelativeLayout) findViewById(R.id.layout_question_tip);
        this.I = (TextView) findViewById(R.id.tv_question_tip);
        this.J = (TextView) findViewById(R.id.tv_question_next_tip);
        this.K = (TextView) findViewById(R.id.tv_record_video_retry);
        this.L = (LinearLayout) findViewById(R.id.layout_pose_warning);
        this.M = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.N = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.O = (RimFaceResultPageTipView) findViewById(R.id.constrastLoadingTipsView);
        this.E = (ImageView) findViewById(R.id.img_face_recognizing_light_anim);
        P();
        this.V = new CameraSurfaceView(this, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        this.V.setLayoutParams(layoutParams);
        this.bj.addView(this.V, 0, layoutParams);
        com.baidu.fsg.face.liveness.camera.b bVar = new com.baidu.fsg.face.liveness.camera.b();
        this.bi = bVar;
        bVar.a(this.aS);
        this.V.setCameraInterface(this.bi);
        this.V.setVisibility(4);
        this.ah = (LivenessXfordView) this.bj.findViewById(R.id.xfordview);
        this.az = (TextView) findViewById(R.id.tv_msg_tips);
        this.P = (RelativeLayout) findViewById(R.id.ll_video_tip);
        this.Q = (ImageView) findViewById(R.id.iv_video_count_down);
        this.R = (TextView) findViewById(R.id.tv_video_tip);
        this.S = (LinearLayout) findViewById(R.id.ll_time_count);
        this.T = (ImageView) findViewById(R.id.iv_time_count_point);
        this.U = (TextView) findViewById(R.id.tv_time_count);
        this.aj = (ImageView) findViewById(R.id.iv_recog_circle);
        this.ai = (ImageView) findViewById(R.id.iv_recog_logo);
        this.ak = (RelativeLayout) findViewById(R.id.layout_background);
        this.al = (TextView) findViewById(R.id.tv_show_progress);
        this.an = (CustomProgressBar) findViewById(R.id.custom_progress);
        this.am = (LinearLayout) findViewById(R.id.layout_show_progress);
        this.ao = (CustomSuccessView) findViewById(R.id.custom_success_view);
    }

    private void c() {
        this.aN = null;
        this.aO = null;
        this.aD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UploadContrastPortraitModel uploadContrastPortraitModel) {
        if (this.B == null || uploadContrastPortraitModel == null) {
            return;
        }
        new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.41
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public LivenessRecogResult doInBackground(Void... voidArr) {
                LivenessRecogDTO livenessRecogDTO;
                byte[] encode;
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                int i2 = 0;
                if (uploadContrastPortraitModel.isProcessPass()) {
                    livenessRecogResult.setResultCode(0);
                } else {
                    livenessRecogResult.setResultCode(-302);
                }
                UploadContrastPortraitModel uploadContrastPortraitModel2 = uploadContrastPortraitModel;
                livenessRecogResult.callbackkey = uploadContrastPortraitModel2.callbackkey;
                if (!TextUtils.isEmpty(uploadContrastPortraitModel2.imgdigests) && LivenessRecogActivity.this.bD != null && LivenessRecogActivity.this.bD.size() > 0) {
                    int size = LivenessRecogActivity.this.bD.size();
                    while (true) {
                        if (i2 >= size) {
                            i2 = -1;
                            break;
                        }
                        byte[] bArr = (byte[]) ((HashMap) LivenessRecogActivity.this.bD.get(i2)).get(LightappBusinessClient.MTD_DIGEST);
                        if (bArr != null && uploadContrastPortraitModel.imgdigests.equals(new String(bArr))) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 != -1 && (livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO) != null) {
                        if (livenessRecogDTO.isReturnOriginImage() && LivenessRecogActivity.this.bm.size() > 0) {
                            LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                            livenessRecogResult.originalImage = livenessRecogActivity.a((int[]) livenessRecogActivity.bm.get((LivenessRecogActivity.this.bm.size() - i2) - 1));
                        }
                        if (LivenessRecogActivity.this.livenessRecogDTO.isReturnCutImage()) {
                            byte[] bArr2 = (byte[]) ((HashMap) LivenessRecogActivity.this.bD.get(i2)).get("data");
                            if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                livenessRecogResult.faceimage = new String(encode);
                            }
                            livenessRecogResult.imgdigests = new String(uploadContrastPortraitModel.imgdigests);
                        }
                    }
                }
                livenessRecogResult.authSid = uploadContrastPortraitModel.authsid;
                return livenessRecogResult;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(LivenessRecogResult livenessRecogResult) {
                super.onPostExecute(livenessRecogResult);
                if (uploadContrastPortraitModel.isProcessPass()) {
                    LivenessRecogActivity.this.B.a(livenessRecogResult);
                } else {
                    LivenessRecogActivity.this.B.b(livenessRecogResult);
                }
                if (LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                LivenessRecogActivity.this.a(true);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final UploadContrastPortraitModel uploadContrastPortraitModel) {
        UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
        this.O.resetView();
        this.O.setResultPageTitle(confirmBean.title_tips);
        this.O.setResultPageRiskTipVisiable(confirmBean.tip_msg);
        this.O.setResultPageConfirmText(confirmBean.confirm_msg);
        this.O.setResultPageCancelText(confirmBean.cancel_msg);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
        this.O.setVisibility(0);
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.4
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS < 500) {
                    return;
                }
                LivenessRecogActivity.this.bS = System.currentTimeMillis();
                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.C, arrayList);
                }
                LivenessRecogActivity.this.bL = 1;
                LivenessRecogActivity.this.bM = 1;
                LivenessRecogActivity.this.bR = uploadContrastPortraitModel;
                LivenessRecogActivity.this.ai.setVisibility(0);
                LivenessRecogActivity.this.aj.setVisibility(0);
                LivenessRecogActivity.this.ak.setVisibility(0);
                LinearInterpolator linearInterpolator = new LinearInterpolator();
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setRepeatMode(1);
                rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                rotateAnimation.setInterpolator(linearInterpolator);
                LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                LivenessRecogActivity.this.O.setVisibility(8);
                com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f5675b);
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    dVar.a(livenessRecogDTO);
                }
                dVar.b(LivenessRecogActivity.this.bM);
                dVar.a(LivenessRecogActivity.this.bL);
                dVar.setResponseCallback(LivenessRecogActivity.this);
                dVar.execBean();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS < 500) {
                    return;
                }
                LivenessRecogActivity.this.bS = System.currentTimeMillis();
                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.D, arrayList);
                }
                LivenessRecogActivity.this.bL = 2;
                LivenessRecogActivity.this.bM = 1;
                LivenessRecogActivity.this.bR = uploadContrastPortraitModel;
                LivenessRecogActivity.this.ai.setVisibility(0);
                LivenessRecogActivity.this.aj.setVisibility(0);
                LivenessRecogActivity.this.ak.setVisibility(0);
                LinearInterpolator linearInterpolator = new LinearInterpolator();
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setRepeatMode(1);
                rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                rotateAnimation.setInterpolator(linearInterpolator);
                LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                LivenessRecogActivity.this.O.setVisibility(8);
                com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f5675b);
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    dVar.a(livenessRecogDTO);
                }
                dVar.b(LivenessRecogActivity.this.bM);
                dVar.a(LivenessRecogActivity.this.bL);
                dVar.setResponseCallback(LivenessRecogActivity.this);
                dVar.execBean();
            }
        });
    }

    private void b(String str) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            arrayList.add(str);
            RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.x, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        b.a i2 = this.bi.i();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i2.f5971b, i2.f5970a, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new String(Base64Utils.encode(byteArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.n, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
        if (this.B != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.B.b(livenessRecogResult);
        }
    }

    private void c(String str) {
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
        this.O.setResultPageTitle(getString(R.string.error_msg_server_error));
        this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
        this.O.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.9
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                LivenessRecogActivity.this.O.setVisibility(8);
                LivenessRecogActivity.this.getRecordVideoQuestions();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                LivenessRecogActivity.this.O.setVisibility(8);
                if (!LivenessRecogActivity.this.aR) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                livenessRecogActivity.a(!livenessRecogActivity.aR);
            }
        });
    }

    private void a(final UploadContrastPortraitModel uploadContrastPortraitModel) {
        this.aj.clearAnimation();
        this.ai.setVisibility(8);
        this.aj.setVisibility(8);
        this.ak.setVisibility(8);
        this.ah.setMaskVisiable(true);
        this.ao.loadSuccess();
        this.ao.setVisibility(0);
        this.ah.updateXfordViewProgress(0.75f, 1.0f, 1000L, new AnimatorListenerAdapter() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivenessRecogActivity.this.ah.setMaskVisiable(false);
                LivenessRecogActivity.this.ao.setVisibility(4);
                super.onAnimationEnd(animator);
                BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                if (uploadContrastPortraitModel.isGotoDXMRecordvideo()) {
                    LivenessRecogActivity.this.v();
                } else if (LivenessRecogActivity.this.be == 2) {
                    LivenessRecogActivity.this.v();
                } else if (uploadContrastPortraitModel.isProcessPass()) {
                    if (LivenessRecogActivity.this.bA != null) {
                        LivenessRecogActivity.this.bA.a(com.baidu.fsg.face.liveness.d.f5977f);
                    }
                    UploadContrastPortraitModel uploadContrastPortraitModel2 = uploadContrastPortraitModel;
                    if (uploadContrastPortraitModel2.need_confirm == null) {
                        LivenessRecogActivity.this.b(uploadContrastPortraitModel2);
                        return;
                    }
                    LivenessRecogActivity.this.c(uploadContrastPortraitModel2);
                    LivenessRecogActivity.this.az.setVisibility(8);
                    if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                        arrayList.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.B, arrayList);
                    }
                } else if (LivenessRecogActivity.this.be == 1) {
                    if (LivenessRecogActivity.this.aY >= 2) {
                        LivenessRecogActivity.this.v();
                    } else if (LivenessRecogActivity.this.aY == 1) {
                        LivenessRecogActivity.this.x();
                    } else if (LivenessRecogActivity.this.aZ >= 2) {
                        LivenessRecogActivity.this.v();
                    } else if (LivenessRecogActivity.this.aZ == 1) {
                        LivenessRecogActivity.this.x();
                    } else {
                        LivenessRecogActivity.this.b(uploadContrastPortraitModel);
                    }
                } else {
                    LivenessRecogActivity.this.b(uploadContrastPortraitModel);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        this.L.setVisibility(0);
        if (this.A != i2) {
            if (i2 == 1) {
                this.N.setText(getString(R.string.sapi_liveness_tofar_from_camera));
                d(7);
            } else if (i2 == 0) {
                this.N.setText(getString(R.string.sapi_liveness_tonear_from_camera));
                d(6);
            } else if (i2 == 2) {
                this.N.setText(getString(R.string.sapi_liveness_brightness_too_dark));
            } else if (i2 == 3) {
                this.N.setText(getString(R.string.sapi_liveness_face_to_screen));
            } else if (i2 == 4) {
                this.N.setText(getString(R.string.sapi_liveness_put_face_round));
                d(2);
            }
            final Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_warning);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.31
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.M.startAnimation(loadAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            if (!this.aO.j) {
                this.M.startAnimation(loadAnimation);
                this.aO.j = true;
            }
        }
        this.A = i2;
    }

    private b.a b(b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b.a s2 = s();
        b.a aVar2 = new b.a(aVar.f5970a, aVar.f5971b);
        float f2 = aVar.f5970a / aVar.f5971b;
        float f3 = s2.f5971b / s2.f5970a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar2;
        }
        if (f2 < f3) {
            int i2 = s2.f5971b;
            aVar2.f5970a = (aVar.f5971b * i2) / aVar.f5970a;
            aVar2.f5971b = i2;
        } else {
            aVar2.f5970a = s2.f5970a;
            aVar2.f5971b = (s2.f5970a * aVar.f5970a) / aVar.f5971b;
        }
        return aVar2;
    }

    private void a(String str, int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.q, i2, arrayList);
            a(str);
        }
    }

    private Bitmap b(int i2) {
        Bitmap bitmap;
        if (!this.bl.containsKey(Integer.valueOf(i2)) || this.bl.get(Integer.valueOf(i2)) == null || (bitmap = this.bl.get(Integer.valueOf(i2)).get()) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i2, options);
            options.inSampleSize = h.a(options, dimensionPixelSize2, dimensionPixelSize);
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
            this.bl.put(Integer.valueOf(i2), new SoftReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    private void a(int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.H, i2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            float abs = Math.abs(faceInfo.headPose[0]);
            GetFPResponse.LivenessConfig livenessConfig = this.br;
            if (abs >= (livenessConfig != null ? livenessConfig.getPitch() : 15)) {
                return true;
            }
        }
        return false;
    }

    private void a(String str) {
        JSONObject livenessBgStyleABTestContent = LivenessABTestUtil.getInstance(getApplicationContext()).getLivenessBgStyleABTestContent();
        if (livenessBgStyleABTestContent == null) {
            return;
        }
        try {
            if (this.livenessRecogDTO != null) {
                livenessBgStyleABTestContent.put("processid", this.livenessRecogDTO.processid);
            }
            livenessBgStyleABTestContent.put("exp_time", System.currentTimeMillis() + "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("liveness_contrastpass", str);
            livenessBgStyleABTestContent.put("exp_result", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.livenessRecogDTO != null) {
            Context applicationContext = getActivity().getApplicationContext();
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            BdWalletUtils.realTimeStatistics(applicationContext, livenessRecogDTO.spParams, livenessRecogDTO.getAtbc(), "ABTestEnd", livenessBgStyleABTestContent.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(livenessBgStyleABTestContent.toString());
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventWithValues("ABTestEnd", arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            return true;
        }
        return (h.b(faceInfoArr[0].landmarks, this.aJ) || h.c(faceInfoArr[0].landmarks, this.aJ)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        Rect b2 = h.b(faceInfoArr[0].landmarks);
        int i2 = this.bi.i().f5970a;
        double a2 = h.a(this.bi.i().f5971b, this.ap);
        double a3 = h.a(i2, this.aq);
        Rect rect = this.at;
        int i3 = rect.left;
        Rect rect2 = this.ar;
        int i4 = (int) ((i3 - rect2.left) * a2);
        int i5 = rect.top;
        int i6 = (int) ((i5 - rect2.top) * a3);
        Rect rect3 = new Rect(i4, i6, ((int) ((rect.right - i3) * a2)) + i4, ((int) ((rect.bottom - i5) * a3)) + i6);
        return rect3.left < b2.left && rect3.right > b2.right && rect3.bottom > b2.bottom && rect3.top < b2.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        int i3;
        int i4;
        int i5;
        if (i2 == 0) {
            this.G.setText(R.string.sapi_liveness_put_face_in_round);
        } else if (i2 == 1) {
            String[] strArr = this.aG;
            if (strArr == null || (i5 = this.aH) >= strArr.length) {
                return;
            }
            this.G.setText(strArr[i5]);
        } else if (i2 == 2) {
            String[] strArr2 = this.aG;
            if (strArr2 == null || (i4 = this.aH) >= strArr2.length) {
                return;
            }
            this.G.setText(strArr2[i4]);
        } else if (i2 == 3) {
            String[] strArr3 = this.aG;
            if (strArr3 == null || (i3 = this.aH) >= strArr3.length) {
                return;
            }
            this.G.setText(strArr3[i3]);
        } else if (i2 == 4) {
            this.G.setText(str);
        } else if (i2 == 5) {
            this.G.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            float abs = Math.abs(faceInfo.headPose[1]);
            GetFPResponse.LivenessConfig livenessConfig = this.br;
            return abs >= ((float) (livenessConfig != null ? livenessConfig.getYaw() : 15));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            float abs = Math.abs(faceInfo.headPose[0]);
            GetFPResponse.LivenessConfig livenessConfig = this.br;
            if (abs < (livenessConfig != null ? livenessConfig.getPitch() : 15)) {
                float abs2 = Math.abs(faceInfo.headPose[1]);
                GetFPResponse.LivenessConfig livenessConfig2 = this.br;
                if (abs2 >= (livenessConfig2 != null ? livenessConfig2.getYaw() : 15)) {
                }
            }
            return true;
        }
        return false;
    }

    private void a(int i2, String str) {
        if (this.bC == this.bB) {
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
            if (this.B != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                this.B.b(livenessRecogResult);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        try {
            if (this.aB == null || (!this.aB.isPlaying() && i2 < e.j.length)) {
                MediaPlayer create = MediaPlayer.create(this, e.j[i2]);
                this.aB = create;
                if (create == null) {
                    return;
                }
                create.setOnErrorListener(new c());
                setVolumeControlStream(3);
                if (!this.aQ) {
                    this.aB.setVolume(0.0f, 0.0f);
                }
                this.aB.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.40
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                int i2;
                int i3;
                Bitmap createBitmap;
                LivenessRecogActivity.this.aZ = 0;
                LivenessRecogActivity.this.aY = 0;
                LivenessRecogActivity.this.ba = 0;
                LivenessRecogActivity.this.bH = false;
                LivenessRecogActivity.this.bB = 0;
                LivenessRecogActivity.this.bC = 0;
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
                if (arrayList == null || arrayList.size() <= 0) {
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-306);
                        livenessRecogResult.setResultMsg(com.baidu.fsg.face.liveness.c.f5936e);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    LivenessRecogActivity.this.a(true);
                    return;
                }
                LivenessRecogActivity.this.bB = arrayList.size();
                LivenessRecogActivity.this.bD = arrayList;
                LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                LivenessRecogDTO livenessRecogDTO = livenessRecogActivity.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                        if (livenessRecogActivity.br != null) {
                            LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                            livenessRecogActivity2.bB = livenessRecogActivity2.br.getRecogUploadPortraitCount(LivenessRecogActivity.this.bB);
                        }
                        LivenessRecogActivity.this.X();
                        return;
                    }
                    livenessRecogActivity.W();
                }
            }
        }.execute(faceVerifyDataArr);
    }

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
            view.setBackgroundResource(0);
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 < viewGroup.getChildCount()) {
                a(viewGroup.getChildAt(i2));
                i2++;
            } else {
                viewGroup.removeAllViews();
                view.setBackgroundResource(0);
                return;
            }
        }
    }

    private void d(String str) {
        if (isFinishing()) {
            return;
        }
        LoadingDialog loadingDialog = new LoadingDialog(this);
        this.X = loadingDialog;
        loadingDialog.setMessage(str);
        this.X.show();
    }

    private void a() {
        for (SoftReference<Bitmap> softReference : this.bl.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera) {
        if (this.bV == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.bi.h()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.bV = previewSize.width;
            this.bW = previewSize.height;
            this.bX = cameraInfo.orientation;
        }
        if (this.aJ == null) {
            this.aJ = r5;
            int[] iArr = {this.bW, this.bV};
        }
        GetFPResponse.LivenessConfig livenessConfig = this.br;
        if (livenessConfig == null || TextUtils.isEmpty(livenessConfig.min_face_size)) {
            if (this.bV > 640 && this.bW > 480) {
                this.aC.set_min_face_size(200);
            } else {
                this.aC.set_min_face_size(100);
            }
        }
        com.baidu.fsg.face.liveness.b bVar = this.bA;
        if (bVar != null && bVar.f5864b == 0) {
            bVar.f5865c = this.bW;
            bVar.f5864b = this.bV;
            bVar.a(com.baidu.fsg.face.liveness.d.t);
        }
        if (this.aE == null) {
            this.aE = new int[this.bV * this.bW];
        }
    }

    private void a(b.a aVar) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.V.getLayoutParams());
        b.a b2 = b(aVar);
        if (b2 != null && (b2.f5970a != aVar.f5970a || b2.f5971b != aVar.f5971b)) {
            int i4 = (int) (b2.f5970a * 0.667d);
            this.ap = i4;
            int i5 = (int) (b2.f5971b * 0.667d);
            this.aq = i5;
            layoutParams.width = i4;
            layoutParams.height = i5;
        } else {
            int i6 = (int) (i2 * 0.667d);
            this.ap = i6;
            int i7 = (int) (i3 * 0.667d);
            this.aq = i7;
            layoutParams.width = i6;
            layoutParams.height = i7;
        }
        LogUtil.d("surfaceHeight:" + this.aq + "，surfaceWidth:" + this.ap);
        double d2 = ((double) i3) * 0.3845d;
        layoutParams.topMargin = (int) (d2 - (((double) this.aq) * 0.5d));
        layoutParams.gravity = 1;
        this.V.setLayoutParams(layoutParams);
        int i8 = this.ap;
        int i9 = (i2 - i8) / 2;
        int i10 = layoutParams.topMargin;
        this.ar = new Rect(i9, i10, i8 + i9, this.aq + i10);
        int dip2px = DisplayUtils.dip2px(this, 35.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.F.getLayoutParams());
        int i11 = (int) (d2 - (dip2px / 2));
        layoutParams2.topMargin = i11;
        layoutParams2.gravity = 1;
        this.F.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.L.getLayoutParams());
        layoutParams3.topMargin = i11;
        layoutParams3.gravity = 1;
        this.L.setLayoutParams(layoutParams3);
        int dip2px2 = DisplayUtils.dip2px(this, 62.0f);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.H.getLayoutParams());
        layoutParams4.topMargin = (int) ((d2 - (this.at.width() / 2)) - dip2px2);
        layoutParams4.gravity = 1;
        this.H.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.E.getLayoutParams());
        layoutParams5.width = this.as.width();
        layoutParams5.height = this.as.width();
        layoutParams5.topMargin = (int) (d2 - (this.as.width() / 2));
        layoutParams5.gravity = 1;
        this.E.setLayoutParams(layoutParams5);
        int width = this.as.width() / 3;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(this.E.getLayoutParams());
        layoutParams6.width = width;
        layoutParams6.height = width;
        layoutParams6.topMargin = (int) (d2 - (width / 2));
        layoutParams6.gravity = 1;
        this.ai.setLayoutParams(layoutParams6);
        this.aj.setLayoutParams(layoutParams6);
        int width2 = this.as.width() / 3;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(this.ao.getLayoutParams());
        layoutParams7.width = width2;
        layoutParams7.height = width2;
        layoutParams7.topMargin = (int) (d2 - (width2 / 2));
        layoutParams7.gravity = 1;
        this.ao.setLayoutParams(layoutParams7);
        int dip2px3 = DisplayUtils.dip2px(this, 84.5f);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(this.P.getLayoutParams());
        layoutParams8.topMargin = (int) (d2 - (dip2px3 / 2));
        layoutParams8.gravity = 1;
        this.P.setLayoutParams(layoutParams8);
        int dip2px4 = DisplayUtils.dip2px(this, 25.5f);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(this.S.getLayoutParams());
        layoutParams9.topMargin = (int) (((i2 * 0.667d) / 2.0d) + d2 + dip2px4);
        layoutParams9.gravity = 1;
        this.S.setLayoutParams(layoutParams9);
        int dip2px5 = DisplayUtils.dip2px(this, 42.5f);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(this.am.getLayoutParams());
        layoutParams10.topMargin = (int) (d2 - (dip2px5 / 2));
        layoutParams10.gravity = 1;
        this.am.setLayoutParams(layoutParams10);
    }

    private void a(UploadVideoModel uploadVideoModel) {
        this.O.resetView();
        this.O.setVisibility(0);
        this.O.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
        this.O.setResultPageTitle(uploadVideoModel.getConfirmBean().title_tips);
        this.O.setResultPageRiskTipVisiable(uploadVideoModel.getConfirmBean().tip_msg);
        this.O.setResultPageConfirmText(uploadVideoModel.getConfirmBean().confirm_msg);
        this.O.setResultPageCancelText(uploadVideoModel.getConfirmBean().cancel_msg);
        this.O.setOnClickListener(new RimFaceResultPageTipView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.5
            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void a() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS < 500) {
                    return;
                }
                LivenessRecogActivity.this.bS = System.currentTimeMillis();
                LivenessRecogActivity.this.bL = 1;
                LivenessRecogActivity.this.bM = 2;
                LivenessRecogActivity.this.ai.setVisibility(0);
                LivenessRecogActivity.this.aj.setVisibility(0);
                LivenessRecogActivity.this.ak.setVisibility(0);
                LinearInterpolator linearInterpolator = new LinearInterpolator();
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setRepeatMode(1);
                rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                rotateAnimation.setInterpolator(linearInterpolator);
                LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                LivenessRecogActivity.this.am.setVisibility(8);
                LivenessRecogActivity.this.O.setVisibility(8);
                com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f5675b);
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    dVar.a(livenessRecogDTO);
                }
                dVar.b(LivenessRecogActivity.this.bM);
                dVar.a(LivenessRecogActivity.this.bL);
                dVar.setResponseCallback(LivenessRecogActivity.this);
                dVar.execBean();
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS < 500) {
                    return;
                }
                LivenessRecogActivity.this.bS = System.currentTimeMillis();
                LivenessRecogActivity.this.bL = 2;
                LivenessRecogActivity.this.bM = 2;
                LivenessRecogActivity.this.ai.setVisibility(0);
                LivenessRecogActivity.this.aj.setVisibility(0);
                LivenessRecogActivity.this.ak.setVisibility(0);
                LinearInterpolator linearInterpolator = new LinearInterpolator();
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setRepeatMode(1);
                rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                rotateAnimation.setInterpolator(linearInterpolator);
                LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                LivenessRecogActivity.this.am.setVisibility(8);
                LivenessRecogActivity.this.O.setVisibility(8);
                com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f5675b);
                LivenessRecogDTO livenessRecogDTO = LivenessRecogActivity.this.livenessRecogDTO;
                if (livenessRecogDTO != null) {
                    dVar.a(livenessRecogDTO);
                }
                dVar.b(LivenessRecogActivity.this.bM);
                dVar.a(LivenessRecogActivity.this.bL);
                dVar.setResponseCallback(LivenessRecogActivity.this);
                dVar.execBean();
            }
        });
    }

    private void a(int i2, int i3) {
        String string = i2 != 1 ? getString(R.string.sapi_permission_audio) : null;
        if (i3 != 1) {
            string = getString(R.string.sapi_permission_camera);
        }
        if (i2 != 1 && i3 != 1) {
            string = getString(R.string.sapi_permission_audio_camera);
        }
        String format = String.format(getString(R.string.sapi_permission_without_title), string);
        String str = String.format(getString(R.string.sapi_permission_without_msg1), string) + String.format(getString(R.string.sapi_permission_without_msg2), string);
        if (this.aa == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            this.aa = bioAlertDialog;
            bioAlertDialog.setTitleMsg(format);
            this.aa.setTitleVisible(true);
            this.aa.setDialogMsg(str);
            this.aa.setBtnCount(1);
            this.aa.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.aa.dismiss();
                    if (LivenessRecogActivity.this.aR) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                        LivenessRecogActivity.this.B.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.aa.setCancelable(false);
        if (isFinishing() || this.aa.isShowing()) {
            return;
        }
        this.aa.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FaceVerifyData[] a(FaceVerifyData[] faceVerifyDataArr) {
        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
            return null;
        }
        int length = faceVerifyDataArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            LogUtil.d("hello", "原始数据照片签名" + i2 + "    :" + faceVerifyDataArr[i2].mRegDigest);
        }
        FaceVerifyData[] faceVerifyDataArr2 = new FaceVerifyData[faceVerifyDataArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            faceVerifyDataArr2[i3] = faceVerifyDataArr[(length - 1) - i3];
            LogUtil.d("hello", "翻转后数据照片签名" + i3 + "    :" + faceVerifyDataArr[i3].mRegDigest);
        }
        return faceVerifyDataArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            return;
        }
        int i2 = this.aN.u;
        if ((i2 == 6 || i2 == 8) && this.aN.u != 9) {
            int i3 = this.aH;
            boolean z2 = false;
            if (i3 == 0) {
                z2 = faceInfoArr[0].is_live();
            } else if (i3 == 1) {
                z2 = faceInfoArr[0].is_live_head_down();
            } else if (i3 == 2) {
                z2 = faceInfoArr[0].is_live_head_up();
            } else if (i3 == 3) {
                z2 = faceInfoArr[0].is_live_head_turn_left();
            } else if (i3 == 4) {
                z2 = faceInfoArr[0].is_live_head_turn_right();
            } else if (i3 == 5) {
                z2 = faceInfoArr[0].is_live_mouth();
            }
            if (z2) {
                int i4 = this.aH;
                if (i4 == 0) {
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTBLINK):  检测到眨眼");
                    LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f5980i, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                } else if (i4 == 5) {
                    LivenessRecogDTO livenessRecogDTO2 = this.livenessRecogDTO;
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.k, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : "");
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTMOUTH):  检测到张嘴");
                }
                this.aN.u = 9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        return faceInfo != null && this.aK == FaceTracker.ErrCode.OK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, final int i3, String str) {
        this.F.clearAnimation();
        b(i3, str);
        if (i2 == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_midd_to_top);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.30
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    int i4 = i3;
                    if (i4 == 0) {
                        LivenessRecogActivity.this.d(2);
                    } else if (i4 == 1) {
                        LivenessRecogActivity.this.d(0);
                    } else if (i4 == 2) {
                        LivenessRecogActivity.this.d(3);
                    } else if (i4 == 3) {
                        LivenessRecogActivity.this.d(8);
                    }
                    if (LivenessRecogActivity.this.aN.u == 0) {
                        LivenessRecogActivity.this.aN.u = 1;
                    } else if (LivenessRecogActivity.this.aN.u == 5) {
                        LivenessRecogActivity.this.aN.u = 6;
                    } else if (LivenessRecogActivity.this.aN.u == 7) {
                        LivenessRecogActivity.this.aN.u = 8;
                    }
                    LivenessRecogActivity.this.G.setTextColor(-16777216);
                    LivenessRecogActivity.this.G.setTextSize(25.0f);
                    LivenessRecogActivity.this.F.setBackground(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    LivenessRecogActivity.this.G.setTextSize(15.0f);
                    LivenessRecogActivity.this.G.setTextColor(-1);
                    LivenessRecogActivity.this.F.setBackgroundResource(R.drawable.rim_face_liveness_toast_round);
                }
            });
            this.F.startAnimation(loadAnimation);
            this.G.setVisibility(0);
        }
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - this.aP > j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        com.baidu.fsg.face.liveness.b bVar = this.bA;
        if (bVar != null) {
            bVar.a(com.baidu.fsg.face.liveness.d.r);
            this.bA.a(com.baidu.fsg.face.liveness.d.s);
            this.bA.a(com.baidu.fsg.face.liveness.d.u);
            this.bA.a(com.baidu.fsg.face.liveness.d.v);
        }
        if (z2) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending():  发送日志");
        }
        f fVar = this.aI;
        if (fVar != null) {
            fVar.cancel();
        }
        try {
            if (this.aB != null) {
                this.aB.stop();
                this.aB.release();
                this.aB = null;
            }
        } catch (Exception e2) {
            com.baidu.fsg.face.base.d.d.a(e2);
        }
        finish();
    }
}
