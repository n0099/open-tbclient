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
import androidx.core.view.ViewCompat;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.HttpConstants;
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
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.webkit.sdk.PermissionRequest;
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
/* loaded from: classes6.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    private static final FaceTracker.ActionType aF = FaceTracker.ActionType.RECOGNIZE;
    private static final int aV = 0;
    private static final int aW = 1;
    private static final int aX = 2;
    private static final double au = 0.6d;
    private static final double av = 0.667d;
    private static final double aw = 0.3845d;
    private static final double ax = 0.667d;
    private static final double ay = 0.5d;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2181b = "LivenessRecogActivity";
    private static final int bN = 1;
    private static final int bO = 2;
    private static final int bP = 1;
    private static final int bQ = 2;
    private static final int bb = 0;
    private static final int bc = 1;
    private static final int bd = 2;
    private static final String c = "CONSTRASTBEANTAG";
    private static final int d = 2002;
    private static final int e = 2003;
    private static final int f = 2004;
    private static final int g = 1;
    private static final int h = 1;
    private static final int i = 0;
    private static final int j = 7057;
    private static final int k = 7401;
    private static final int l = 0;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 255;
    private static final int s = 1;
    private static final int t = 5000;
    private static final int u = 200;
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 3;
    private static final int z = 4;
    private LivenessRecogCallback B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private FrameLayout F;
    private TextView G;
    private RelativeLayout H;
    private TextView I;
    private TextView J;
    private TextView K;
    private LinearLayout L;
    private ImageView M;
    private TextView N;
    private RimFaceResultPageTipView O;
    private RelativeLayout P;
    private ImageView Q;
    private TextView R;
    private LinearLayout S;
    private ImageView T;
    private TextView U;
    private CameraSurfaceView V;
    private ImageView W;
    private LoadingDialog X;
    private BioAlertDialog Y;
    private BioAlertDialog Z;
    private LivenessRecogResult aA;
    private MediaPlayer aB;
    private FaceTracker aC;
    private FaceInfo[] aD;
    private String[] aG;
    private int aH;
    private f aI;
    private int[] aJ;
    private FaceTracker.ErrCode aK;
    private Handler aM;
    private d aN;
    private a aO;
    private long aP;
    private BioAlertDialog aa;
    private BioAlertDialog ab;
    private RecordVideoTipDialog ac;
    private CustomExitDialog ad;
    private CustomExitDialog ae;
    private CustomExitDialog af;
    private CustomExitDialog ag;
    private LivenessXfordView ah;
    private ImageView ai;
    private ImageView aj;
    private RelativeLayout ak;
    private TextView al;
    private LinearLayout am;
    private CustomProgressBar an;
    private CustomSuccessView ao;
    private int ap;
    private int aq;
    private Rect ar;
    private Rect as;
    private Rect at;
    private TextView az;
    private com.baidu.fsg.face.liveness.b bA;
    private int bB;
    private int bC;
    private ArrayList<HashMap<String, byte[]>> bD;
    private boolean bE;
    private byte[] bF;
    private byte[] bG;
    private byte[] bU;
    private int bV;
    private int bW;
    private int bX;
    private Camera bY;
    private b bh;
    private com.baidu.fsg.face.liveness.camera.b bi;
    private FrameLayout bj;
    private AnimationDrawable bk;
    private int bp;
    private long bq;
    private GetFPResponse.LivenessConfig br;
    private String bv;
    private String bw;
    private com.baidu.fsg.face.liveness.c by;
    private int A = -1;
    private int[] aE = null;
    private boolean aL = false;
    private boolean aQ = false;
    private boolean aR = true;
    private boolean aS = false;
    private boolean aT = false;
    private boolean aU = false;
    private int aY = 0;
    private int aZ = 0;
    private int ba = 0;
    private int be = 0;
    private int[] bf = {ARPMessageType.MSG_TYPE_RES_REQUEST, 5002, 7100, 7101, 7019, 7020};
    private int bg = 0;
    private Map<Integer, SoftReference<Bitmap>> bl = new ConcurrentHashMap();
    private List<int[]> bm = new ArrayList();
    private Handler bn = new Handler(Looper.getMainLooper());
    private Runnable bo = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1
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
                    public void onAnimationStart(Animation animation) {
                        LivenessRecogActivity.this.I.setText(LivenessRecogActivity.this.getString(R.string.sapi_liveness_record_success));
                        LivenessRecogActivity.this.J.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        LivenessRecogActivity.this.I.setText(LivenessRecogActivity.this.getString(R.string.sapi_liveness_upload_video));
                        LivenessRecogActivity.this.V();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                LivenessRecogActivity.this.I.startAnimation(loadAnimation);
                LivenessRecogActivity.this.ao.setVisibility(0);
                LivenessRecogActivity.this.ao.loadSuccess();
                LivenessRecogActivity.this.aN.u = 15;
            }
            a aVar = LivenessRecogActivity.this.aO;
            aVar.n--;
        }
    };
    private boolean bs = false;
    private int bt = 15;
    private int bu = 5;
    private List<String> bx = new ArrayList();
    private boolean bz = false;
    private boolean bH = false;
    private UploadContrastPortraitModel bI = null;
    private boolean bJ = ApollonConstants.VIDEO_DEBUG;
    private Runnable bK = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.12
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
    private int bL = 0;
    private int bM = 0;
    private UploadContrastPortraitModel bR = null;
    private long bS = 0;
    private View.OnClickListener bT = new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.27
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
    Camera.PreviewCallback f2182a = new Camera.PreviewCallback() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28
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
                    } else {
                        camera.addCallbackBuffer(bArr);
                    }
                    return;
                } catch (Throwable th) {
                    com.baidu.fsg.face.base.d.d.a(th);
                    return;
                }
            }
            camera.addCallbackBuffer(bArr);
        }
    };
    private boolean bZ = false;
    private int ca = -1;

    static /* synthetic */ int ao(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.bg + 1;
        livenessRecogActivity.bg = i2;
        return i2;
    }

    static /* synthetic */ int aq(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.bg - 1;
        livenessRecogActivity.bg = i2;
        return i2;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bE = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        if (this.livenessRecogDTO == null) {
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
        if (this.livenessRecogDTO.spParams.contains("video_check=2")) {
            this.be = 2;
        } else if (this.livenessRecogDTO.spParams.contains("video_check=1")) {
            this.be = 1;
        }
        requestWindowFeature(1);
        getWindow().addFlags(67108864);
        getWindow().addFlags(128);
        this.bj = (FrameLayout) View.inflate(this, R.layout.layout_sapi_liveness_recognize, null);
        setContentView(this.bj);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = (int) (i2 * 0.667d);
        int i5 = (i2 - i4) / 2;
        int i6 = ((int) (i3 * aw)) - (i4 / 2);
        this.at = new Rect(i5, i6, i5 + i4, i4 + i6);
        int i7 = (int) (i2 * 0.6d);
        int i8 = (i2 - i7) / 2;
        int i9 = ((int) (i3 * aw)) - (i7 / 2);
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity
    protected boolean isSupportLiuHai() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        b.a i2 = this.bi.i();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i2.f2350b, i2.f2349a, Bitmap.Config.ARGB_8888);
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

    /* JADX WARN: Type inference failed for: r0v30, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$23] */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, final String str) {
        if (i2 == 5) {
            if (obj == null || !(obj instanceof UploadContrastPortraitModel)) {
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
                return;
            }
            UploadContrastPortraitModel uploadContrastPortraitModel = (UploadContrastPortraitModel) obj;
            a(uploadContrastPortraitModel.isContrastPass() ? "1" : "0", 0);
            this.bw = uploadContrastPortraitModel.callbackkey;
            if (uploadContrastPortraitModel.isGotoRecordvideo()) {
                this.aY++;
            }
            this.ba += uploadContrastPortraitModel.contrastres;
            if (uploadContrastPortraitModel.isFinish()) {
                BeanManager.getInstance().removeAllBeans(c);
                File file = new File(g.c(getActivity()));
                if (this.aS && file.exists() && file.length() > 0) {
                    this.bI = uploadContrastPortraitModel;
                    U();
                    return;
                }
                a(uploadContrastPortraitModel);
                return;
            }
            W();
        } else if (i2 == 6) {
            Y();
            if (obj != null && (obj instanceof GetRecordVedioQuestionModel)) {
                GetRecordVedioQuestionModel getRecordVedioQuestionModel = (GetRecordVedioQuestionModel) obj;
                if (TextUtils.isEmpty(getRecordVedioQuestionModel.callbackkey) || getRecordVedioQuestionModel.question == null || getRecordVedioQuestionModel.question.length == 0) {
                    c(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                    return;
                }
                this.bv = getRecordVedioQuestionModel.callbackkey;
                this.bx = Arrays.asList(getRecordVedioQuestionModel.question);
                this.bu = getRecordVedioQuestionModel.questime;
                r();
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
            this.aN.x = false;
            if (obj != null && (obj instanceof UploadVideoModel)) {
                UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
                if (!this.aN.y) {
                    g.b(g.b(getActivity()));
                    this.aA = new LivenessRecogResult();
                    this.aA.callbackkey = uploadVideoModel.callbackkey;
                    this.aA.video = uploadVideoModel.video;
                    this.aA.setResultCode(0);
                    if (uploadVideoModel.need_confirm == null) {
                        if (this.B != null) {
                            this.B.a(this.aA);
                        }
                        if (this.aR) {
                            setActivityResult(-1);
                        }
                        a(true);
                        return;
                    }
                    a(uploadVideoModel);
                }
            }
        } else if (i2 == 8) {
            if (TextUtils.isEmpty(str)) {
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
                return;
            }
            a(0);
            BeanManager.getInstance().removeAllBeans(c);
            if (this.B != null) {
                new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.23
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public LivenessRecogResult doInBackground(Void... voidArr) {
                        byte[] encode;
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(0);
                        try {
                            livenessRecogResult.extraJson = new JSONObject(str);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                            if (LivenessRecogActivity.this.bm.size() > 0) {
                                livenessRecogResult.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.bm.get(LivenessRecogActivity.this.bm.size() - LivenessRecogActivity.this.bC));
                            }
                            if (LivenessRecogActivity.this.bF != null && (encode = Base64Utils.encode(LivenessRecogActivity.this.bF)) != null) {
                                livenessRecogResult.faceimage = new String(encode);
                            }
                            if (LivenessRecogActivity.this.bG != null) {
                                livenessRecogResult.imgdigests = new String(LivenessRecogActivity.this.bG);
                            }
                        }
                        return livenessRecogResult;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public void onPostExecute(LivenessRecogResult livenessRecogResult) {
                        super.onPostExecute(livenessRecogResult);
                        LivenessRecogActivity.this.B.a(livenessRecogResult);
                        if (LivenessRecogActivity.this.aR) {
                            LivenessRecogActivity.this.setActivityResult(-1);
                        }
                        LivenessRecogActivity.this.a(true);
                    }
                }.execute(new Void[0]);
            }
        } else if (i2 == 13) {
            if (this.bM == 1 && this.bL == 1 && this.bR != null) {
                b(this.bR);
            } else if (this.bM == 1 && this.bL == 2) {
                if (!this.aR) {
                    b();
                }
                setActivityResult(0);
                a(!this.aR);
                this.O.setVisibility(8);
            } else if (this.bM == 2 && this.bL == 1) {
                if (this.B != null) {
                    this.B.a(this.aA);
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
                a(this.aR ? false : true);
                this.O.setVisibility(8);
            }
        }
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
                BeanManager.getInstance().removeAllBeans(LivenessRecogActivity.c);
                if (uploadContrastPortraitModel.isGotoDXMRecordvideo()) {
                    LivenessRecogActivity.this.v();
                } else if (LivenessRecogActivity.this.be == 2) {
                    LivenessRecogActivity.this.v();
                } else if (uploadContrastPortraitModel.isProcessPass()) {
                    if (LivenessRecogActivity.this.bA != null) {
                        LivenessRecogActivity.this.bA.a(com.baidu.fsg.face.liveness.d.f);
                    }
                    if (uploadContrastPortraitModel.need_confirm != null) {
                        LivenessRecogActivity.this.c(uploadContrastPortraitModel);
                        LivenessRecogActivity.this.az.setVisibility(8);
                        if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                            arrayList.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                            RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.B, arrayList);
                            return;
                        }
                        return;
                    }
                    LivenessRecogActivity.this.b(uploadContrastPortraitModel);
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
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$41] */
    public void b(final UploadContrastPortraitModel uploadContrastPortraitModel) {
        if (this.B != null && uploadContrastPortraitModel != null) {
            new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.41
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public LivenessRecogResult doInBackground(Void... voidArr) {
                    byte[] encode;
                    int i2 = 0;
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    if (uploadContrastPortraitModel.isProcessPass()) {
                        livenessRecogResult.setResultCode(0);
                    } else {
                        livenessRecogResult.setResultCode(-302);
                    }
                    livenessRecogResult.callbackkey = uploadContrastPortraitModel.callbackkey;
                    if (!TextUtils.isEmpty(uploadContrastPortraitModel.imgdigests) && LivenessRecogActivity.this.bD != null && LivenessRecogActivity.this.bD.size() > 0) {
                        int size = LivenessRecogActivity.this.bD.size();
                        while (true) {
                            if (i2 < size) {
                                byte[] bArr = (byte[]) ((HashMap) LivenessRecogActivity.this.bD.get(i2)).get("digest");
                                if (bArr != null && uploadContrastPortraitModel.imgdigests.equals(new String(bArr))) {
                                    break;
                                }
                                i2++;
                            } else {
                                i2 = -1;
                                break;
                            }
                        }
                        if (i2 != -1 && LivenessRecogActivity.this.livenessRecogDTO != null) {
                            if (LivenessRecogActivity.this.livenessRecogDTO.isReturnOriginImage() && LivenessRecogActivity.this.bm.size() > 0) {
                                livenessRecogResult.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.bm.get((LivenessRecogActivity.this.bm.size() - i2) - 1));
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
                /* JADX INFO: Access modifiers changed from: protected */
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
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 5) {
            a("0", i3);
            if (this.be == 1) {
                for (int i4 = 0; i4 < this.bf.length; i4++) {
                    if (i3 == this.bf[i4]) {
                        this.aZ++;
                    }
                }
            }
            if (this.bH) {
                this.aj.clearAnimation();
                this.ai.setVisibility(8);
                this.aj.setVisibility(8);
                this.ak.setVisibility(8);
                BeanManager.getInstance().removeAllBeans(c);
                if (this.be == 1 && this.ba < 1) {
                    if (this.aY >= 2) {
                        v();
                        return;
                    } else if (this.aY == 1) {
                        x();
                        return;
                    } else if (this.aZ >= 2) {
                        v();
                        return;
                    } else if (this.aZ == 1) {
                        x();
                        return;
                    } else {
                        callbackFailure(i3, str);
                        return;
                    }
                }
                callbackFailure(i3, str);
                return;
            }
            W();
        } else if (i2 == 6) {
            Y();
            c(str);
        } else if (i2 == 7) {
            if (this.aS && this.bI != null) {
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
                this.aN.x = false;
                if (!this.aN.y) {
                    if (i3 == j) {
                        E();
                    } else if (i3 == k) {
                        F();
                    } else {
                        D();
                    }
                }
            }
        } else if (i2 == 8) {
            a(i3);
            a(i3, str);
        } else if (i2 == 12) {
            LogUtil.d("hello", SmsLoginView.f.l);
        } else if (i2 == 13) {
            callbackFailure(i3, str);
        } else {
            super.handleFailure(i2, i3, str);
        }
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

    private void a(int i2) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.H, i2, arrayList);
        }
    }

    private void a(String str) {
        JSONObject livenessBgStyleABTestContent = LivenessABTestUtil.getInstance(getApplicationContext()).getLivenessBgStyleABTestContent();
        if (livenessBgStyleABTestContent != null) {
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
                BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), "ABTestEnd", livenessBgStyleABTestContent.toString());
                ArrayList arrayList = new ArrayList();
                arrayList.add(livenessBgStyleABTestContent.toString());
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventWithValues("ABTestEnd", arrayList);
            }
        }
    }

    private void a(int i2, String str) {
        if (this.bC == this.bB) {
            BeanManager.getInstance().removeAllBeans(c);
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

    private void b(String str) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            arrayList.add(str);
            RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.x, arrayList);
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
            if (this.aN.z) {
                C();
                this.aN.z = false;
            } else if (!this.aN.F) {
                if (this.aS && this.aN.u == 10) {
                    m();
                } else if (this.aN.u < 12) {
                    if (m()) {
                        q();
                    }
                } else if (this.aN.u == 18 || this.aN.u == 17) {
                    m();
                }
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bz = true;
        if (!this.aN.F) {
            this.aI.cancel();
            if (this.aN.u == 14) {
                this.aN.z = true;
                if (this.ah != null) {
                    this.ah.setLineVisiable(false);
                    this.ah.stopXfordViewProgress();
                }
                if (this.bi != null) {
                    this.bi.g();
                    this.bi.c();
                }
                if (this.bn != null) {
                    this.bn.removeCallbacks(this.bo);
                    return;
                }
                return;
            }
            this.bi.d();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.bE);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(f2181b);
        BeanManager.getInstance().removeAllBeans(c);
        this.aL = true;
        this.aE = null;
        this.bU = null;
        if (this.ah != null) {
            this.ah.release();
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

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
            view.setBackgroundResource(0);
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        }
        if (view instanceof ViewGroup) {
            for (int i2 = 0; i2 < ((ViewGroup) view).getChildCount(); i2++) {
                a(((ViewGroup) view).getChildAt(i2));
            }
            ((ViewGroup) view).removeAllViews();
            view.setBackgroundResource(0);
        }
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
    public void b() {
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.n, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
        if (this.B != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.B.b(livenessRecogResult);
        }
    }

    private void c() {
        this.aN = null;
        this.aO = null;
        this.aD = null;
    }

    private void d() {
        com.baidu.fsg.face.base.d.f.b(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        this.C = (ImageView) findViewById(R.id.btn_cancel);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.42
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.aN.x) {
                    if (LivenessRecogActivity.this.by != null) {
                        LivenessRecogActivity.this.by.a();
                    }
                    LivenessRecogActivity.this.B();
                } else if (LivenessRecogActivity.this.aN.u != 17 && LivenessRecogActivity.this.aN.u != 18) {
                    if (LivenessRecogActivity.this.aN.u == 12 || LivenessRecogActivity.this.aN.u == 14) {
                        LivenessRecogActivity.this.A();
                    } else {
                        LivenessRecogActivity.this.z();
                    }
                }
            }
        });
        this.D = (ImageView) findViewById(R.id.btn_switch_voice);
        if (this.aQ) {
            this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
        } else {
            this.D.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
        }
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.aQ = !LivenessRecogActivity.this.aQ;
                ArrayList arrayList = new ArrayList();
                arrayList.add(LivenessRecogActivity.this.aQ ? "1" : "0");
                arrayList.add(LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.d, arrayList);
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
        this.bi = new com.baidu.fsg.face.liveness.camera.b();
        this.bi.a(this.aS);
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

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        if (this.bq == 1) {
            this.aH = 0;
        } else {
            this.aH = 5;
        }
        return this.aH;
    }

    private void f() {
        this.aR = this.livenessRecogDTO.showGuidePage;
        this.aQ = this.livenessRecogDTO.soundSwitch;
        this.aU = this.livenessRecogDTO.randomLiveness;
        this.bs = this.livenessRecogDTO.switchVideo;
        this.aS = this.livenessRecogDTO.recordLiveness && Build.VERSION.SDK_INT >= 18;
        this.aG = getResources().getStringArray(R.array.sapi_liveness_head_pose);
        this.aM = new Handler(Looper.getMainLooper(), this);
        this.aN = new d();
        this.aO = new a();
        this.aI = new f(5000L, 200L);
        this.aN.C = System.currentTimeMillis();
        this.bA = new com.baidu.fsg.face.liveness.b(this.livenessRecogDTO);
        this.bA.f2314a = System.currentTimeMillis();
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
        this.br = com.baidu.fsg.face.liveness.beans.c.a().a(getActivity());
        if (this.br == null) {
            this.br = new GetFPResponse.LivenessConfig();
        }
        this.bp = this.br.getRecogtimeInterval();
        if (this.aU) {
            this.bq = new Random().nextInt(100) % 2 == 0 ? 1L : 2L;
        } else {
            this.bq = this.br.getRecogActionType();
        }
        if (this.livenessRecogDTO != null && this.livenessRecogDTO.livenessType != LivenessRecogType.RECOG_TYPE_FACEDETECT) {
            h();
        }
    }

    private void h() {
        JSONObject livenessBgStyleABTestContent = LivenessABTestUtil.getInstance(getApplicationContext()).getLivenessBgStyleABTestContent();
        if (livenessBgStyleABTestContent != null) {
            try {
                if (this.livenessRecogDTO != null) {
                    livenessBgStyleABTestContent.put("processid", this.livenessRecogDTO.processid);
                }
                livenessBgStyleABTestContent.put("exp_time", System.currentTimeMillis() + "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.livenessRecogDTO != null) {
                BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), "ABTestStart", livenessBgStyleABTestContent.toString());
                ArrayList arrayList = new ArrayList();
                arrayList.add(livenessBgStyleABTestContent.toString());
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventWithValues("ABTestStart", arrayList);
            }
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
            a(this.aR ? false : true);
        }
    }

    private void j() throws Exception {
        if (!com.baidu.fsg.face.base.b.d.a(this, 4, new Bundle())) {
            throw new Exception("load so failure");
        }
    }

    private void k() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty("frfsd_ai")) {
            throw new Exception("idlToken or apiKey is empty");
        }
        try {
            this.aC = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
            this.aC.set_isFineAlign(false);
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
        } catch (Exception e2) {
            throw new Exception("init faceTracker failure: " + e2.getMessage());
        }
    }

    private void l() {
    }

    private boolean m() {
        LogUtil.d("openCamera被调用了");
        this.V.setVisibility(4);
        boolean a2 = this.bi.a(this, 3);
        if (!a2) {
            H();
        } else {
            a(this.bi.i());
            this.bi.a(this.f2182a);
            this.V.startPreview();
        }
        this.V.setVisibility(0);
        return a2;
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
            this.aJ = new int[2];
            this.aJ[0] = this.bW;
            this.aJ[1] = this.bV;
        }
        if (this.br == null || TextUtils.isEmpty(this.br.min_face_size)) {
            if (this.bV > 640 && this.bW > 480) {
                this.aC.set_min_face_size(200);
            } else {
                this.aC.set_min_face_size(100);
            }
        }
        if (this.bA != null && this.bA.f2315b == 0) {
            this.bA.c = this.bW;
            this.bA.f2315b = this.bV;
            this.bA.a(com.baidu.fsg.face.liveness.d.t);
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
        if (b2 == null || (b2.f2349a == aVar.f2349a && b2.f2350b == aVar.f2350b)) {
            this.ap = (int) (i2 * 0.667d);
            this.aq = (int) (i3 * 0.667d);
            layoutParams.width = this.ap;
            layoutParams.height = this.aq;
        } else {
            this.ap = (int) (b2.f2349a * 0.667d);
            this.aq = (int) (b2.f2350b * 0.667d);
            layoutParams.width = this.ap;
            layoutParams.height = this.aq;
        }
        LogUtil.d("surfaceHeight:" + this.aq + "，surfaceWidth:" + this.ap);
        double d2 = i3 * aw;
        layoutParams.topMargin = (int) (d2 - (this.aq * ay));
        layoutParams.gravity = 1;
        this.V.setLayoutParams(layoutParams);
        int i4 = (i2 - this.ap) / 2;
        int i5 = layoutParams.topMargin;
        this.ar = new Rect(i4, i5, this.ap + i4, this.aq + i5);
        int dip2px = DisplayUtils.dip2px(this, 35.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.F.getLayoutParams());
        layoutParams2.topMargin = (int) (d2 - (dip2px / 2));
        layoutParams2.gravity = 1;
        this.F.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.L.getLayoutParams());
        layoutParams3.topMargin = (int) (d2 - (dip2px / 2));
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
        layoutParams9.topMargin = (int) (dip2px4 + ((i2 * 0.667d) / 2.0d) + d2);
        layoutParams9.gravity = 1;
        this.S.setLayoutParams(layoutParams9);
        int dip2px5 = DisplayUtils.dip2px(this, 42.5f);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(this.am.getLayoutParams());
        layoutParams10.topMargin = (int) (d2 - (dip2px5 / 2));
        layoutParams10.gravity = 1;
        this.am.setLayoutParams(layoutParams10);
    }

    private void n() {
        if (!this.bE && this.livenessRecogDTO != null) {
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
            BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), com.baidu.fsg.face.liveness.d.w, jSONObject.toString());
        }
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
        if (this.bn != null) {
            this.bn.removeCallbacks(this.bo);
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

    private b.a b(b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b.a s2 = s();
        b.a aVar2 = new b.a(aVar.f2349a, aVar.f2350b);
        float f2 = aVar.f2349a / aVar.f2350b;
        float f3 = s2.f2350b / s2.f2349a;
        if (Math.abs(f2 - f3) > 0.02d) {
            if (f2 < f3) {
                aVar2.f2349a = (s2.f2350b * aVar.f2350b) / aVar.f2349a;
                aVar2.f2350b = s2.f2350b;
                return aVar2;
            }
            aVar2.f2349a = s2.f2349a;
            aVar2.f2350b = (s2.f2349a * aVar.f2349a) / aVar.f2350b;
            return aVar2;
        }
        return aVar2;
    }

    private b.a s() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new b.a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + com.baidu.fsg.face.base.d.f.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String[] strArr = (this.aS && this.aT) ? new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE} : new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
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
        if (this.ac != null && this.ac.isShowing()) {
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
                LivenessRecogActivity.this.aH = LivenessRecogActivity.this.e();
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
                LivenessRecogActivity.this.O.setVisibility(8);
            }
        });
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
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS >= 500) {
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
                    rotateAnimation.setDuration(1200L);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                    LivenessRecogActivity.this.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f2181b);
                    if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                        dVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                    }
                    dVar.b(LivenessRecogActivity.this.bM);
                    dVar.a(LivenessRecogActivity.this.bL);
                    dVar.setResponseCallback(LivenessRecogActivity.this);
                    dVar.execBean();
                }
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS >= 500) {
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
                    rotateAnimation.setDuration(1200L);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                    LivenessRecogActivity.this.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f2181b);
                    if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                        dVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                    }
                    dVar.b(LivenessRecogActivity.this.bM);
                    dVar.a(LivenessRecogActivity.this.bL);
                    dVar.setResponseCallback(LivenessRecogActivity.this);
                    dVar.execBean();
                }
            }
        });
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
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS >= 500) {
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
                    rotateAnimation.setDuration(1200L);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                    LivenessRecogActivity.this.am.setVisibility(8);
                    LivenessRecogActivity.this.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f2181b);
                    if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                        dVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                    }
                    dVar.b(LivenessRecogActivity.this.bM);
                    dVar.a(LivenessRecogActivity.this.bL);
                    dVar.setResponseCallback(LivenessRecogActivity.this);
                    dVar.execBean();
                }
            }

            @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
            public void b() {
                if (System.currentTimeMillis() - LivenessRecogActivity.this.bS >= 500) {
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
                    rotateAnimation.setDuration(1200L);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                    LivenessRecogActivity.this.am.setVisibility(8);
                    LivenessRecogActivity.this.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 13, LivenessRecogActivity.f2181b);
                    if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                        dVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                    }
                    dVar.b(LivenessRecogActivity.this.bM);
                    dVar.a(LivenessRecogActivity.this.bL);
                    dVar.setResponseCallback(LivenessRecogActivity.this);
                    dVar.execBean();
                }
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
                LivenessRecogActivity.this.aH = LivenessRecogActivity.this.e();
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
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
                LivenessRecogActivity.this.aH = LivenessRecogActivity.this.e();
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
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
                LivenessRecogActivity.this.aH = LivenessRecogActivity.this.e();
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
            }
        });
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.bi.c();
        this.ah.setLineVisiable(false);
        this.aN.u = 18;
        this.aM.removeCallbacks(this.bK);
        this.ae = new CustomExitDialog(this);
        this.ae.setDialogTitle(getString(R.string.rim_face_exit_action_title));
        this.ae.setDialogContext(getString(R.string.rim_face_exit_action_content));
        this.ae.setPositiveText(getString(R.string.rim_face_exit_action_positive), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aN.u = 1;
                LivenessRecogActivity.this.bi.b();
                LivenessRecogActivity.this.q();
                LivenessRecogActivity.this.aH = LivenessRecogActivity.this.e();
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
                LivenessRecogActivity.this.bi.d();
            }
        });
        this.ae.setCancelable(false);
        this.ae.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.bi.g();
        this.bi.c();
        this.ah.setLineVisiable(false);
        this.ah.stopXfordViewProgress();
        this.bn.removeCallbacks(this.bo);
        this.aN.u = 18;
        this.af = new CustomExitDialog(this);
        this.af.setDialogTitle(getString(R.string.rim_face_exit_record_title));
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
                LivenessRecogActivity.this.bi.d();
            }
        });
        this.af.setCancelable(false);
        this.af.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.ag = new CustomExitDialog(this);
        this.ag.setDialogTitle(getString(R.string.sapi_liveness_record_up_exit));
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
            }
        });
        this.ag.setCancelable(false);
        if (!isFinishing() && !this.ag.isShowing()) {
            this.ag.show();
        }
    }

    private void C() {
        if (this.ad == null || !this.ad.isShowing()) {
            this.ad = new CustomExitDialog(this);
            this.ad.setDialogTitle(getString(R.string.sapi_liveness_record_video_exit_dialog_title));
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
                    LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
                }
            });
            this.ad.setCancelable(false);
            if (!isFinishing() && !this.ad.isShowing()) {
                this.ad.show();
            }
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
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
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aR ? false : true);
            }
        });
    }

    private void G() {
        this.aN.F = true;
        if (this.Y == null) {
            this.Y = new BioAlertDialog(this);
            this.Y.setTitleMsg(getString(R.string.sapi_permission_request));
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
        if (!isFinishing() && !this.Y.isShowing()) {
            this.Y.show();
        }
    }

    private void H() {
        this.aN.u = 19;
        if (this.Z == null) {
            this.Z = new BioAlertDialog(this);
            this.Z.setTitleVisible(true);
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
        if (!isFinishing() && !this.Z.isShowing()) {
            this.Z.show();
        }
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
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void a(int i2, int i3) {
        String str = null;
        if (i2 != 1) {
            str = getString(R.string.sapi_permission_audio);
        }
        if (i3 != 1) {
            str = getString(R.string.sapi_permission_camera);
        }
        if (i2 != 1 && i3 != 1) {
            str = getString(R.string.sapi_permission_audio_camera);
        }
        String format = String.format(getString(R.string.sapi_permission_without_title), str);
        String str2 = String.format(getString(R.string.sapi_permission_without_msg1), str) + String.format(getString(R.string.sapi_permission_without_msg2), str);
        if (this.aa == null) {
            this.aa = new BioAlertDialog(this);
            this.aa.setTitleMsg(format);
            this.aa.setTitleVisible(true);
            this.aa.setDialogMsg(str2);
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
        if (!isFinishing() && !this.aa.isShowing()) {
            this.aa.show();
        }
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
        if (this.bU != null && this.aE != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.bX = -com.baidu.fsg.face.liveness.camera.b.i;
                FaceSDK.getARGBFromYUVimg(this.bU, this.aE, this.bV, this.bW, this.bX, 1);
                this.aK = this.aC.face_verification(this.aE, this.bV, this.bW, FaceSDK.ImgType.ARGB, aF, "", "", "");
                this.aD = this.aC.get_TrackedFaceInfo();
                int i2 = (this.aD == null || this.aD.length <= 0 || this.aD[0] == null) ? 0 : this.aD[0].face_id;
                if (i2 != 0 && i2 != this.ca) {
                    this.bm.clear();
                }
                this.ca = i2;
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
                if (this.aN != null && this.aN.u == 6 && this.bA != null) {
                    this.bA.b(currentTimeMillis2);
                }
            } catch (Throwable th) {
                com.baidu.fsg.face.base.d.d.a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b extends AsyncTask<Void, Void, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.ao(LivenessRecogActivity.this);
            LivenessRecogActivity.this.L();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.aq(LivenessRecogActivity.this);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f extends CountDownTimer {
        public f(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (LivenessRecogActivity.this.aN != null && LivenessRecogActivity.this.aN.u != 0 && LivenessRecogActivity.this.aN.u != 17 && LivenessRecogActivity.this.aN.u != 19 && LivenessRecogActivity.this.aN.u != 18 && LivenessRecogActivity.this.aN.u != 14 && LivenessRecogActivity.this.aN.u != 15 && LivenessRecogActivity.this.aN.u != 16) {
                FaceInfo[] faceInfoArr = LivenessRecogActivity.this.aD;
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
                                    long j2 = LivenessRecogActivity.this.bp * 1000;
                                    if (j2 < 20000) {
                                        LivenessRecogActivity.this.aM.postDelayed(LivenessRecogActivity.this.bK, j2);
                                    }
                                } else {
                                    LivenessRecogActivity.this.aN.u = 1;
                                    LivenessRecogActivity.this.aN.v = false;
                                    return;
                                }
                            }
                        } else {
                            LivenessRecogActivity.this.aN.u = 1;
                            LivenessRecogActivity.this.aN.v = false;
                            return;
                        }
                    }
                    if (LivenessRecogActivity.this.aN.u == 5) {
                        if (LivenessRecogActivity.this.M()) {
                            LivenessRecogActivity.this.N();
                            return;
                        } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                            LivenessRecogActivity.this.A = -1;
                            LivenessRecogActivity.this.L.setVisibility(8);
                            if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aO.k) {
                                RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.h, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
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
                                RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.j, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                                LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWMOUTH):  提示张张嘴");
                                LivenessRecogActivity.this.a(0, 3, (String) null);
                                LivenessRecogActivity.this.aO.l = true;
                            }
                        }
                    }
                    if (LivenessRecogActivity.this.aN.u == 6 || LivenessRecogActivity.this.aN.u == 8) {
                        if (LivenessRecogActivity.this.M()) {
                            LivenessRecogActivity.this.N();
                            return;
                        } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                            if (LivenessRecogActivity.this.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                                LivenessRecogActivity.this.c(2);
                                return;
                            } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.aK)) {
                                LivenessRecogActivity.this.c(3);
                                return;
                            } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                                LivenessRecogActivity.this.c(4);
                                LivenessRecogActivity.this.A = -1;
                                return;
                            } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                LivenessRecogActivity.this.c(1);
                                return;
                            } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                LivenessRecogActivity.this.c(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.A = -1;
                                LivenessRecogActivity.this.L.setVisibility(8);
                                LivenessRecogActivity.this.a(faceInfoArr);
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
                            } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.aK)) {
                                LivenessRecogActivity.this.c(3);
                                return;
                            } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                                LivenessRecogActivity.this.c(4);
                            } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                LivenessRecogActivity.this.c(1);
                                return;
                            } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                                LivenessRecogActivity.this.c(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.A = -1;
                                LivenessRecogActivity.this.L.setVisibility(8);
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
                        arrayList.add(faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0");
                        arrayList.add(LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.p, arrayList);
                        LogUtil.d("hello", "onEventWithValue(StatServiceEvent.RETRIEVEDIMAGE):  获取到活体图片的数量  " + (faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0"));
                        if (LivenessRecogActivity.this.a(faceInfoArr[0], LivenessRecogActivity.this.aK) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                            LivenessRecogActivity.this.aN.u = 10;
                            LivenessRecogActivity.this.aM.removeCallbacks(LivenessRecogActivity.this.bK);
                            LivenessRecogActivity.this.aI.cancel();
                            LivenessRecogActivity.this.bi.c();
                            LivenessRecogActivity.this.ai.setVisibility(0);
                            LivenessRecogActivity.this.aj.setVisibility(0);
                            LivenessRecogActivity.this.ak.setVisibility(0);
                            LivenessRecogActivity.this.ah.setLineVisiable(false);
                            LivenessRecogActivity.this.C.setVisibility(4);
                            LivenessRecogActivity.this.b(5, LivenessRecogActivity.this.getString(R.string.sapi_liveness_network_checking));
                            LinearInterpolator linearInterpolator = new LinearInterpolator();
                            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                            rotateAnimation.setRepeatCount(-1);
                            rotateAnimation.setRepeatMode(1);
                            rotateAnimation.setDuration(1200L);
                            rotateAnimation.setInterpolator(linearInterpolator);
                            LivenessRecogActivity.this.aj.startAnimation(rotateAnimation);
                            LivenessRecogActivity.this.ah.updateXfordViewProgress(0.5f, 0.75f, 500L, null);
                            LivenessRecogActivity.this.b(LivenessRecogActivity.this.a(faceVerifyDataArr));
                        }
                    }
                } else if (LivenessRecogActivity.this.M()) {
                    LivenessRecogActivity.this.N();
                } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                    if (LivenessRecogActivity.this.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                        LivenessRecogActivity.this.c(2);
                        if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                            LivenessRecogActivity.this.bA.b("2");
                        }
                    } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.aK)) {
                        LivenessRecogActivity.this.c(3);
                        if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                            if (LivenessRecogActivity.this.c(faceInfoArr[0], LivenessRecogActivity.this.aK)) {
                                LivenessRecogActivity.this.bA.b("0");
                            } else if (LivenessRecogActivity.this.d(faceInfoArr[0], LivenessRecogActivity.this.aK)) {
                                LivenessRecogActivity.this.bA.b("1");
                            }
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
                        if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                            LivenessRecogActivity.this.bA.b("4");
                        }
                    } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.aJ)) {
                        LivenessRecogActivity.this.c(0);
                        if (LivenessRecogActivity.this.bA != null && LivenessRecogActivity.this.aN != null && !LivenessRecogActivity.this.aN.v && !LivenessRecogActivity.this.aN.E) {
                            LivenessRecogActivity.this.bA.b("5");
                        }
                    } else {
                        LivenessRecogActivity.this.A = -1;
                        LivenessRecogActivity.this.L.setVisibility(8);
                        LivenessRecogActivity.this.aN.u = 2;
                        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.g, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                        LogUtil.d("hello", "onEvent(StatServiceEvent.FACEDETECTED):  监测到人脸");
                        if (!LivenessRecogActivity.this.aN.v) {
                            LivenessRecogActivity.this.aP = System.currentTimeMillis();
                            LivenessRecogActivity.this.aN.v = true;
                        }
                        LivenessRecogActivity.this.Q();
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

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!LivenessRecogActivity.this.aL) {
                LivenessRecogActivity.this.aI.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        return System.currentTimeMillis() - this.aN.C > this.aN.D && this.aN.C > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.aS && this.bi.e()) {
            this.bi.f();
        }
        this.aN.C = 0L;
        if (!this.aN.E) {
            if (this.bA != null) {
                this.bA.a(com.baidu.fsg.face.liveness.d.l);
            }
            LogUtil.d("hello", "onEvent(StatServiceEvent.FIRSTTIMEOUT):  一次超时");
            w();
            this.aN.E = true;
            O();
            return;
        }
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.m, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.SECONDTIMEOUT):  两次超时");
        if (this.be == 1) {
            b("1");
            v();
            return;
        }
        y();
    }

    private void O() {
        if (this.aE != null && this.br != null && this.br.isStatisticsEnable()) {
            if (!"1".equals(this.br.report_type) || (this.aN != null && !this.aN.v)) {
                new Thread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.29
                    @Override // java.lang.Runnable
                    public void run() {
                        k kVar = (k) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 12, LivenessRecogActivity.f2181b);
                        kVar.d(LivenessRecogActivity.this.a(LivenessRecogActivity.this.aE));
                        if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                            kVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                        }
                        if (LivenessRecogActivity.this.br != null) {
                            kVar.a(LivenessRecogActivity.this.br.report_type);
                        }
                        if (LivenessRecogActivity.this.bA != null) {
                            kVar.a(LivenessRecogActivity.this.bA.d, LivenessRecogActivity.this.bA.e);
                        }
                        kVar.setResponseCallback(LivenessRecogActivity.this);
                        kVar.execBean();
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FaceVerifyData[] a(FaceVerifyData[] faceVerifyDataArr) {
        FaceVerifyData[] faceVerifyDataArr2 = null;
        if (faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
            int length = faceVerifyDataArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                LogUtil.d("hello", "原始数据照片签名" + i2 + "    :" + faceVerifyDataArr[i2].mRegDigest);
            }
            faceVerifyDataArr2 = new FaceVerifyData[faceVerifyDataArr.length];
            for (int i3 = 0; i3 < length; i3++) {
                faceVerifyDataArr2[i3] = faceVerifyDataArr[(length - 1) - i3];
                LogUtil.d("hello", "翻转后数据照片签名" + i3 + "    :" + faceVerifyDataArr[i3].mRegDigest);
            }
        }
        return faceVerifyDataArr2;
    }

    private void P() {
        this.bk = (AnimationDrawable) this.E.getDrawable();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceInfo[] faceInfoArr) {
        boolean z2 = false;
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            return;
        }
        if ((this.aN.u == 6 || this.aN.u == 8) && this.aN.u != 9) {
            switch (this.aH) {
                case 0:
                    z2 = faceInfoArr[0].is_live();
                    break;
                case 1:
                    z2 = faceInfoArr[0].is_live_head_down();
                    break;
                case 2:
                    z2 = faceInfoArr[0].is_live_head_up();
                    break;
                case 3:
                    z2 = faceInfoArr[0].is_live_head_turn_left();
                    break;
                case 4:
                    z2 = faceInfoArr[0].is_live_head_turn_right();
                    break;
                case 5:
                    z2 = faceInfoArr[0].is_live_mouth();
                    break;
            }
            if (z2) {
                if (this.aH == 0) {
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTBLINK):  检测到眨眼");
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.i, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
                } else if (this.aH == 5) {
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.k, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTMOUTH):  检测到张嘴");
                }
                this.aN.u = 9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        return faceInfoArr == null || faceInfoArr.length <= 0 || !(h.b(faceInfoArr[0].landmarks, this.aJ) || h.c(faceInfoArr[0].landmarks, this.aJ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        Rect b2 = h.b(faceInfoArr[0].landmarks);
        int i2 = this.bi.i().f2349a;
        double a2 = h.a(this.bi.i().f2350b, this.ap);
        double a3 = h.a(i2, this.aq);
        int i3 = (int) ((this.at.left - this.ar.left) * a2);
        int i4 = (int) ((this.at.top - this.ar.top) * a3);
        Rect rect = new Rect(i3, i4, ((int) (a2 * (this.at.right - this.at.left))) + i3, ((int) (a3 * (this.at.bottom - this.at.top))) + i4);
        return rect.left < b2.left && rect.right > b2.right && rect.bottom > b2.bottom && rect.top < b2.top;
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
                public void onAnimationStart(Animation animation) {
                    LivenessRecogActivity.this.G.setTextSize(15.0f);
                    LivenessRecogActivity.this.G.setTextColor(-1);
                    LivenessRecogActivity.this.F.setBackgroundResource(R.drawable.rim_face_liveness_toast_round);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (i3 == 0) {
                        LivenessRecogActivity.this.d(2);
                    } else if (i3 == 1) {
                        LivenessRecogActivity.this.d(0);
                    } else if (i3 == 2) {
                        LivenessRecogActivity.this.d(3);
                    } else if (i3 == 3) {
                        LivenessRecogActivity.this.d(8);
                    }
                    if (LivenessRecogActivity.this.aN.u == 0) {
                        LivenessRecogActivity.this.aN.u = 1;
                    } else if (LivenessRecogActivity.this.aN.u == 5) {
                        LivenessRecogActivity.this.aN.u = 6;
                    } else if (LivenessRecogActivity.this.aN.u == 7) {
                        LivenessRecogActivity.this.aN.u = 8;
                    }
                    LivenessRecogActivity.this.G.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    LivenessRecogActivity.this.G.setTextSize(25.0f);
                    LivenessRecogActivity.this.F.setBackground(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.F.startAnimation(loadAnimation);
            this.G.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        if (i2 == 0) {
            this.G.setText(R.string.sapi_liveness_put_face_in_round);
        } else if (i2 == 1) {
            if (this.aG != null && this.aH < this.aG.length) {
                this.G.setText(this.aG[this.aH]);
            }
        } else if (i2 == 2) {
            if (this.aG != null && this.aH < this.aG.length) {
                this.G.setText(this.aG[this.aH]);
            }
        } else if (i2 == 3) {
            if (this.aG != null && this.aH < this.aG.length) {
                this.G.setText(this.aG[this.aH]);
            }
        } else if (i2 == 4) {
            this.G.setText(str);
        } else if (i2 == 5) {
            this.G.setText(str);
        }
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
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.M.startAnimation(loadAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (!this.aO.j) {
                this.M.startAnimation(loadAnimation);
                this.aO.j = true;
            }
        }
        this.A = i2;
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
                if (LivenessRecogActivity.this.aN.u != 17 && LivenessRecogActivity.this.aN.u != 18) {
                    LivenessRecogActivity.this.aN.u = 4;
                }
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
            public void onAnimationStart(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
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
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
                    if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                        LivenessRecogActivity.this.R.setTextSize(14.5f);
                        LivenessRecogActivity.this.R.setText(R.string.sapi_liveness_video_start_record_new);
                        LivenessRecogActivity.this.Q.setVisibility(0);
                        LivenessRecogActivity.this.aO.m = 0;
                        LivenessRecogActivity.this.Q.startAnimation(loadAnimation2);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.35
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
                    if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                        if (LivenessRecogActivity.this.aO.m == 0) {
                            LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
                        }
                        LivenessRecogActivity.this.I.setText(String.format(LivenessRecogActivity.this.getString(R.string.sapi_liveness_video_answer_question), Integer.valueOf(LivenessRecogActivity.this.bx.size())));
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
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
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        loadAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.36
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
                    if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                        LivenessRecogActivity.this.I.setText((CharSequence) LivenessRecogActivity.this.bx.get(0));
                        LivenessRecogActivity.this.J.setVisibility(4);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!LivenessRecogActivity.this.aN.z) {
                    if (LivenessRecogActivity.this.ad == null || !LivenessRecogActivity.this.ad.isShowing()) {
                        LivenessRecogActivity.this.J.setVisibility(0);
                        LivenessRecogActivity.this.S.setVisibility(0);
                        LivenessRecogActivity.this.U.setText(String.format("00:%02d", Integer.valueOf(LivenessRecogActivity.this.aO.n)));
                        LivenessRecogActivity.this.S();
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            if (Math.abs(faceInfo.headPose[0]) >= (this.br != null ? this.br.getPitch() : 15)) {
                return true;
            }
            if (Math.abs(faceInfo.headPose[1]) >= (this.br != null ? this.br.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            if (Math.abs(faceInfo.headPose[0]) >= (this.br != null ? this.br.getPitch() : 15)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            if (Math.abs(faceInfo.headPose[1]) >= (this.br != null ? this.br.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - this.aP > j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        try {
            if (this.aB == null || (!this.aB.isPlaying() && i2 < e.j.length)) {
                this.aB = MediaPlayer.create(this, e.j[i2]);
                if (this.aB != null) {
                    this.aB.setOnErrorListener(new c());
                    setVolumeControlStream(3);
                    if (!this.aQ) {
                        this.aB.setVolume(0.0f, 0.0f);
                    }
                    this.aB.start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            mediaPlayer.reset();
            return false;
        }
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.aN.x) {
                if (this.by != null) {
                    this.by.a();
                }
                B();
                return false;
            }
            if (this.bA != null) {
                this.bA.a(com.baidu.fsg.face.liveness.d.o);
            }
            if (!this.aR) {
                b();
            }
            if (this.aN.u == 14) {
                this.bi.g();
            }
            this.bi.d();
            setActivityResult(0);
            a(this.aR ? false : true);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3 = 0;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.aN.F = false;
        if (i2 == 2002) {
            if (this.aS && this.aT) {
                int i4 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
                if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                    i3 = 1;
                }
                if (i4 == 1 && i3 == 1) {
                    if (m()) {
                        n();
                        q();
                        return;
                    }
                    return;
                }
                a(i4, i3);
            } else if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                if (m()) {
                    n();
                    q();
                }
            } else {
                G();
            }
        } else if (i2 == 2004) {
            int i5 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
            if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                i3 = 1;
            }
            if (i5 == 1 && i3 == 1) {
                if (this.ac != null && this.ac.isShowing()) {
                    this.ac.dismiss();
                }
                this.aN.u = 14;
                m();
                getRecordVideoQuestions();
                return;
            }
            a(i5, i3);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.bA != null) {
            this.bA.a(com.baidu.fsg.face.liveness.d.r);
            this.bA.a(com.baidu.fsg.face.liveness.d.s);
            this.bA.a(com.baidu.fsg.face.liveness.d.u);
            this.bA.a(com.baidu.fsg.face.liveness.d.v);
        }
        if (z2) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending():  发送日志");
        }
        if (this.aI != null) {
            this.aI.cancel();
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

    public void setActivityResult(int i2) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i2, intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3880=4] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String T() {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i2;
        try {
            fileInputStream2 = new FileInputStream(g.b(getActivity()));
            try {
                int available = fileInputStream2.available();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        i2 = available;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        i2 = available;
                    }
                } else {
                    i2 = available;
                }
            } catch (Exception e3) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        i2 = 0;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 >= 1024) {
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
        if (i2 >= 1024) {
            return "1KB";
        }
        if (i2 < 1023488) {
            String str = Math.round(i2 / 1024.0d) + "KB";
            return str.contains(".0KB") ? str.replace(".0KB", "KB") : str;
        }
        String str2 = String.format("%.1f", Double.valueOf(i2 / 1048576.0d)) + "M";
        return str2.contains(".0M") ? str2.replace(".0M", "M") : str2;
    }

    public void getRecordVideoQuestions() {
        d(getString(R.string.sapi_loading));
        com.baidu.fsg.face.liveness.beans.h hVar = (com.baidu.fsg.face.liveness.beans.h) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, f2181b);
        hVar.setResponseCallback(this);
        hVar.execBean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3937=4] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(g.c(getActivity()));
            try {
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f2181b);
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
                            LogUtil.e("hello", "progress:  " + ((int) ((((float) j2) / ((float) j3)) * 100.0f)));
                        }
                    });
                    mVar.setResponseCallback(this);
                    mVar.execBean();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    LogUtil.d(e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
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
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3990=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V() {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        this.aN.x = true;
        this.ao.setVisibility(4);
        this.an.setPercent(0.0f);
        this.am.setVisibility(0);
        this.aN.u = 16;
        try {
            fileInputStream2 = new FileInputStream(g.b(this));
            try {
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
                    RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.y);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
                    m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f2181b);
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
                            LogUtil.d("hello", "progress:  " + ((int) ((((float) j2) / ((float) j3)) * 100.0f)));
                            LivenessRecogActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LivenessRecogActivity.this.al.setText(((int) ((((float) j2) / ((float) j3)) * 100.0f)) + "%");
                                    LivenessRecogActivity.this.an.setPercent(((float) j2) / ((float) j3));
                                }
                            });
                        }
                    });
                    mVar.setResponseCallback(this);
                    mVar.execBean();
                } catch (Exception e3) {
                    D();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
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
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$40] */
    public void b(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.40
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
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
                if (arrayList == null || arrayList.size() <= 0) {
                    if (LivenessRecogActivity.this.B != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-306);
                        livenessRecogResult.setResultMsg(com.baidu.fsg.face.liveness.c.e);
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
                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                    if (LivenessRecogActivity.this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                        if (LivenessRecogActivity.this.br != null) {
                            LivenessRecogActivity.this.bB = LivenessRecogActivity.this.br.getRecogUploadPortraitCount(LivenessRecogActivity.this.bB);
                        }
                        LivenessRecogActivity.this.X();
                        return;
                    }
                    LivenessRecogActivity.this.W();
                }
            }
        }.execute(faceVerifyDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.bH) {
            BeanManager.getInstance().removeAllBeans(c);
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
        this.bC++;
        if (this.bD == null || this.bC > this.bD.size()) {
            BeanManager.getInstance().removeAllBeans(c);
            if (this.B != null) {
                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                livenessRecogResult2.setResultCode(-206);
                livenessRecogResult2.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                this.B.b(livenessRecogResult2);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        if (this.bC == 1) {
            RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.q);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
        }
        byte[] bArr = this.bD.get(this.bC - 1).get("data");
        byte[] bArr2 = this.bD.get(this.bC - 1).get("digest");
        this.bH = this.bC == this.bD.size();
        j jVar = (j) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 5, c);
        if (this.livenessRecogDTO != null) {
            jVar.a(this.livenessRecogDTO);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.bC++;
        if (this.bD != null && this.bC <= this.bB && this.bC <= this.bD.size()) {
            this.bF = this.bD.get(this.bC - 1).get("data");
            this.bG = this.bD.get(this.bC - 1).get("digest");
            this.bH = this.bC == this.bD.size();
            if (this.bC == 1) {
                RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.H);
            }
            com.baidu.fsg.face.liveness.beans.e eVar = (com.baidu.fsg.face.liveness.beans.e) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 8, c);
            if (this.bG != null) {
                eVar.a(new String(this.bG));
            }
            new UploadBean.UploadFileModel().contentType = "image/png";
            eVar.d(Base64Utils.encodeToString(this.bF));
            eVar.setResponseCallback(this);
            eVar.a(this.bH);
            eVar.execBean();
        }
    }

    private void d(String str) {
        if (!isFinishing()) {
            this.X = new LoadingDialog(this);
            this.X.setMessage(str);
            this.X.show();
        }
    }

    private void Y() {
        if (this.X != null && !isFinishing() && this.X.isShowing()) {
            this.X.dismiss();
        }
    }

    private int Z() {
        try {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
            if (identifier <= 0) {
                return 75;
            }
            return getResources().getDimensionPixelSize(identifier);
        } catch (Exception e2) {
            com.baidu.fsg.face.base.d.d.a(e2);
            return 75;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d {
        static final int A = 5000;
        static final int B = 20000;

        /* renamed from: a  reason: collision with root package name */
        static final int f2243a = 0;

        /* renamed from: b  reason: collision with root package name */
        static final int f2244b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;
        static final int h = 7;
        static final int i = 8;
        static final int j = 9;
        static final int k = 10;
        static final int l = 11;
        static final int m = 12;
        static final int n = 13;
        static final int o = 14;
        static final int p = 15;
        static final int q = 16;
        static final int r = 17;
        static final int s = 18;
        static final int t = 19;
        long C;
        int u = 0;
        boolean v = false;
        boolean w = false;
        boolean x = false;
        boolean y = false;
        boolean z = false;
        long D = 20000;
        boolean E = false;
        boolean F = false;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f2240a = 0;

        /* renamed from: b  reason: collision with root package name */
        static final int f2241b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final long g = 300;
        static final long h = 1000;
        static final int i = 7;
        private static final int q = 0;
        private static final int r = 1;
        boolean j = false;
        boolean k = false;
        boolean l = false;
        int m = 0;
        int n = 7;
        int o = 0;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        static final int f2245a = 0;

        /* renamed from: b  reason: collision with root package name */
        static final int f2246b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;
        static final int h = 7;
        static final int i = 8;
        static int[] j = {R.raw.sapi_camera_blink, R.raw.sapi_camera_found_face, R.raw.sapi_camera_put_face_round, R.raw.sapi_camera_nod, R.raw.sapi_camera_special_recg, R.raw.sapi_camera_photo_done, R.raw.sapi_camera_too_near, R.raw.sapi_camera_too_far, R.raw.sapi_camera_open_mouth};

        e() {
        }
    }
}
