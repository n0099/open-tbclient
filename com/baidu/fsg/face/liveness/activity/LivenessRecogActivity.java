package com.baidu.fsg.face.liveness.activity;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
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
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.base.d.h;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.i;
import com.baidu.fsg.face.liveness.beans.j;
import com.baidu.fsg.face.liveness.beans.l;
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
import com.baidu.fsg.face.liveness.view.BlurringView;
import com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView;
import com.baidu.fsg.face.liveness.view.ConstrastLoadingView;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.fsg.face.liveness.view.RecordVideoTipDialog;
import com.baidu.fsg.face.liveness.view.UploadingFileView;
import com.baidu.fsg.face.liveness.view.XfordView;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.tencent.connect.common.Constants;
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
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    private static final FaceTracker.ActionType au = FaceTracker.ActionType.RECOGNIZE;
    private static final String b = "LivenessRecogActivity";
    private static final String c = "CONSTRASTBEANTAG";
    private static final int d = 2002;
    private static final int e = 2003;
    private static final int f = 2004;
    private static final int g = 1;
    private static final int h = 1;
    private static final int i = 0;
    private static final int j = 7057;
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = 4;
    private static final int p = 5;
    private static final int q = 255;
    private static final int r = 1;
    private static final int s = 5000;
    private static final int t = 200;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private LivenessRecogCallback A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private FrameLayout F;
    private ImageView G;
    private TextView H;
    private FrameLayout I;
    private ImageView J;
    private TextView K;
    private ConstrastLoadingView L;
    private ConstrastLoadingTipsView M;
    private RelativeLayout N;
    private ImageView O;
    private TextView P;
    private LinearLayout Q;
    private ImageView R;
    private TextView S;
    private CameraSurfaceView T;
    private ImageView U;
    private LoadingDialog V;
    private BioAlertDialog W;
    private BioAlertDialog X;
    private BioAlertDialog Y;
    private BioAlertDialog Z;
    private Handler aB;
    private d aC;
    private a aD;
    private long aE;
    private b aI;
    private com.baidu.fsg.face.liveness.camera.b aJ;
    private ViewGroup aK;
    private AnimationDrawable aL;
    private int aQ;
    private long aR;
    private GetFPResponse.LivenessConfig aS;
    private String aW;
    private String aX;
    private com.baidu.fsg.face.liveness.c aZ;
    private RecordVideoTipDialog aa;
    private BioAlertDialog ab;
    private BioAlertDialog ac;
    private XfordView ad;
    private UploadingFileView ae;
    private View af;
    private View ag;
    private View ah;
    private View ai;
    private View aj;
    private View ak;
    private RelativeLayout al;
    private View am;
    private View an;
    private TextView ao;
    private LivenessRecogResult ap;
    private MediaPlayer aq;
    private FaceTracker ar;
    private FaceInfo[] as;
    private String[] av;
    private int aw;
    private f ax;
    private int[] ay;
    private FaceTracker.ErrCode az;
    private com.baidu.fsg.face.liveness.b bb;
    private int bc;
    private int bd;
    private ArrayList<HashMap<String, byte[]>> be;
    private boolean bf;
    private byte[] bg;
    private byte[] bh;
    private byte[] bl;
    private int bm;
    private int bn;
    private int bo;
    private int z = -1;
    private int[] at = null;
    private boolean aA = false;
    private boolean aF = false;
    private boolean aG = true;
    private int aH = 0;
    private Map<Integer, SoftReference<Bitmap>> aM = new ConcurrentHashMap();
    private List<int[]> aN = new ArrayList();
    private Handler aO = new Handler(Looper.getMainLooper());
    private Runnable aP = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1
        @Override // java.lang.Runnable
        public void run() {
            LivenessRecogActivity.this.aw = 1;
            LivenessRecogActivity.this.S.setText(String.format("00:%02d", Integer.valueOf(LivenessRecogActivity.this.aD.n)));
            LivenessRecogActivity.this.aO.postDelayed(LivenessRecogActivity.this.aP, 1000L);
            int size = LivenessRecogActivity.this.aY.size() - (LivenessRecogActivity.this.aD.n / (LivenessRecogActivity.this.aV + 1));
            if (LivenessRecogActivity.this.aD.n <= 0 || LivenessRecogActivity.this.aD.n % (LivenessRecogActivity.this.aV + 1) != 0) {
                if (LivenessRecogActivity.this.aD.n == 0) {
                    LivenessRecogActivity.this.aJ.e();
                    LivenessRecogActivity.this.R.clearAnimation();
                    LivenessRecogActivity.this.aO.removeCallbacks(LivenessRecogActivity.this.aP);
                    LivenessRecogActivity.this.showVideoDoneView();
                    LivenessRecogActivity.this.aJ.c();
                    LivenessRecogActivity.this.aC.u = 15;
                }
            } else {
                LivenessRecogActivity.this.F.setVisibility(0);
                LivenessRecogActivity.this.a(0, 4, (String) LivenessRecogActivity.this.aY.get(size));
            }
            a aVar = LivenessRecogActivity.this.aD;
            aVar.n--;
        }
    };
    private boolean aT = false;
    private int aU = 15;
    private int aV = 5;
    private List<String> aY = new ArrayList();
    private boolean ba = false;
    private boolean bi = false;
    private Runnable bj = new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (LivenessRecogActivity.this.aR == 2) {
                LivenessRecogActivity.this.aC.u = 5;
                LivenessRecogActivity.this.aw = 0;
            } else {
                LivenessRecogActivity.this.aC.u = 7;
                LivenessRecogActivity.this.aw = 5;
            }
            long currentTimeMillis = 20000 - (System.currentTimeMillis() - LivenessRecogActivity.this.aC.C);
            if (currentTimeMillis < 5000) {
                LivenessRecogActivity.this.aC.D = 25000 - currentTimeMillis;
            }
        }
    };
    private View.OnClickListener bk = new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.re_video_container) {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.J();
                LivenessRecogActivity.this.u();
            } else if (id == R.id.video_finish_container) {
                if (h.g(LivenessRecogActivity.this)) {
                    LivenessRecogActivity.this.af.setVisibility(8);
                    LivenessRecogActivity.this.ag.setVisibility(8);
                    LivenessRecogActivity.this.ae.setVisibility(0);
                    LivenessRecogActivity.this.ah.setVisibility(0);
                    LivenessRecogActivity.this.T();
                    return;
                }
                LivenessRecogActivity.this.x();
            } else if (id == R.id.ok_btn) {
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogActivity.this.A.a(LivenessRecogActivity.this.ap);
                }
                if (LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                LivenessRecogActivity.this.a(true);
            }
        }
    };
    Camera.PreviewCallback a = new Camera.PreviewCallback() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.26
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (LivenessRecogActivity.this.bb != null) {
                LivenessRecogActivity.this.bb.a();
            }
            if (LivenessRecogActivity.this.aC.u != 0 && LivenessRecogActivity.this.aC.u != 10 && LivenessRecogActivity.this.aC.u != 14 && LivenessRecogActivity.this.aC.u != 17 && LivenessRecogActivity.this.aC.u != 15 && LivenessRecogActivity.this.aC.u != 16 && LivenessRecogActivity.this.aC.u != 19 && LivenessRecogActivity.this.aC.u != 18) {
                try {
                    if (LivenessRecogActivity.this.aH <= 0) {
                        LivenessRecogActivity.this.bl = bArr;
                        LivenessRecogActivity.this.a(camera);
                        LivenessRecogActivity.this.aI = new b();
                        LivenessRecogActivity.this.aI.execute(new Void[0]);
                    }
                } catch (Throwable th) {
                    com.baidu.fsg.face.base.d.d.a(th);
                }
            }
        }
    };
    private boolean bp = false;
    private int bq = -1;

    static /* synthetic */ int X(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.aH + 1;
        livenessRecogActivity.aH = i2;
        return i2;
    }

    static /* synthetic */ int Z(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.aH - 1;
        livenessRecogActivity.aH = i2;
        return i2;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bf = bundle.getBoolean("hasCameraReadyStatistics", false);
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
        requestWindowFeature(1);
        getWindow().addFlags(67108864);
        getWindow().addFlags(128);
        this.aK = (ViewGroup) View.inflate(this, R.layout.layout_sapi_liveness_recognize, null);
        setContentView(this.aK);
        f();
        d();
        if (!this.aT) {
            t();
            return;
        }
        b("0");
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        b.a g2 = this.aJ.g();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, g2.b, g2.a, Bitmap.Config.ARGB_8888);
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

    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$34] */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, final String str) {
        if (i2 == 5) {
            if (obj == null || !(obj instanceof UploadContrastPortraitModel)) {
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
                return;
            }
            final UploadContrastPortraitModel uploadContrastPortraitModel = (UploadContrastPortraitModel) obj;
            a(uploadContrastPortraitModel.isContrastPass() ? "1" : "0", 0);
            this.aX = uploadContrastPortraitModel.callbackkey;
            if (uploadContrastPortraitModel.isFinish()) {
                BeanManager.getInstance().removeAllBeans(c);
                if (uploadContrastPortraitModel.isGotoRecordvideo()) {
                    b("2");
                    this.L.clearAnim();
                    this.aJ.b();
                    v();
                    return;
                } else if (uploadContrastPortraitModel.isProcessPass()) {
                    if (this.bb != null) {
                        this.bb.a(com.baidu.fsg.face.liveness.d.f);
                    }
                    if (uploadContrastPortraitModel.need_confirm != null) {
                        this.L.clearAnim();
                        this.M.initData(uploadContrastPortraitModel);
                        this.M.setVisibility(0);
                        this.ao.setVisibility(8);
                        if (this.livenessRecogDTO != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.livenessRecogDTO.getSpno() + "");
                            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                            RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.B, arrayList);
                        }
                        this.M.setOnClickListener(new ConstrastLoadingTipsView.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.23
                            @Override // com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.a
                            public void a() {
                                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                                    arrayList2.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.C, arrayList2);
                                }
                                LivenessRecogActivity.this.L.setVisible(0);
                                LivenessRecogActivity.this.M.setVisibility(8);
                                LivenessRecogActivity.this.a(uploadContrastPortraitModel);
                            }

                            @Override // com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.a
                            public void b() {
                                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(LivenessRecogActivity.this.livenessRecogDTO.getSpno() + "");
                                    arrayList2.add(TextUtils.isEmpty(LivenessRecogActivity.this.livenessRecogDTO.processid) ? "" : LivenessRecogActivity.this.livenessRecogDTO.processid);
                                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.D, arrayList2);
                                }
                                LivenessRecogActivity.this.setActivityResult(0);
                                LivenessRecogActivity.this.a(!LivenessRecogActivity.this.aG);
                                LivenessRecogActivity.this.M.setVisibility(8);
                            }
                        });
                        return;
                    }
                    a(uploadContrastPortraitModel);
                    return;
                } else {
                    a(uploadContrastPortraitModel);
                    return;
                }
            }
            U();
        } else if (i2 == 6) {
            W();
            if (obj != null && (obj instanceof GetRecordVedioQuestionModel)) {
                GetRecordVedioQuestionModel getRecordVedioQuestionModel = (GetRecordVedioQuestionModel) obj;
                if (TextUtils.isEmpty(getRecordVedioQuestionModel.callbackkey) || getRecordVedioQuestionModel.question == null || getRecordVedioQuestionModel.question.length == 0) {
                    c(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                    return;
                }
                this.aW = getRecordVedioQuestionModel.callbackkey;
                this.aY = Arrays.asList(getRecordVedioQuestionModel.question);
                this.aV = getRecordVedioQuestionModel.questiontime;
                r();
                return;
            }
            handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == 7) {
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.livenessRecogDTO.getSpno() + "");
                arrayList2.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, 0, arrayList2);
            }
            this.aC.x = false;
            if (obj != null && (obj instanceof UploadVideoModel)) {
                UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
                if (!this.aC.y) {
                    g.b(g.b(getActivity()));
                    this.ap = new LivenessRecogResult();
                    this.ap.callbackkey = uploadVideoModel.callbackkey;
                    this.ap.video = uploadVideoModel.video;
                    this.ap.setResultCode(0);
                    this.ae.showUpSucView();
                    I();
                }
            }
        } else if (i2 == 8) {
            if (TextUtils.isEmpty(str)) {
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
                return;
            }
            a(0);
            BeanManager.getInstance().removeAllBeans(c);
            if (this.A != null) {
                new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.34
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
                            if (LivenessRecogActivity.this.aN.size() > 0) {
                                livenessRecogResult.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.aN.get(LivenessRecogActivity.this.aN.size() - LivenessRecogActivity.this.bd));
                            }
                            if (LivenessRecogActivity.this.bg != null && (encode = Base64Utils.encode(LivenessRecogActivity.this.bg)) != null) {
                                livenessRecogResult.faceimage = new String(encode);
                            }
                            if (LivenessRecogActivity.this.bh != null) {
                                livenessRecogResult.imgdigests = new String(LivenessRecogActivity.this.bh);
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
                        LivenessRecogActivity.this.A.a(livenessRecogResult);
                        if (LivenessRecogActivity.this.aG) {
                            LivenessRecogActivity.this.setActivityResult(-1);
                        }
                        LivenessRecogActivity.this.a(true);
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$39] */
    public void a(final UploadContrastPortraitModel uploadContrastPortraitModel) {
        if (this.A != null && uploadContrastPortraitModel != null) {
            new AsyncTask<Void, Void, LivenessRecogResult>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39
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
                    if (!TextUtils.isEmpty(uploadContrastPortraitModel.imgdigests) && LivenessRecogActivity.this.be != null && LivenessRecogActivity.this.be.size() > 0) {
                        int size = LivenessRecogActivity.this.be.size();
                        while (true) {
                            if (i2 < size) {
                                byte[] bArr = (byte[]) ((HashMap) LivenessRecogActivity.this.be.get(i2)).get("digest");
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
                            if (LivenessRecogActivity.this.livenessRecogDTO.isReturnOriginImage() && LivenessRecogActivity.this.aN.size() > 0) {
                                livenessRecogResult.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.aN.get((LivenessRecogActivity.this.aN.size() - i2) - 1));
                            }
                            if (LivenessRecogActivity.this.livenessRecogDTO.isReturnCutImage()) {
                                byte[] bArr2 = (byte[]) ((HashMap) LivenessRecogActivity.this.be.get(i2)).get("data");
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
                        LivenessRecogActivity.this.A.a(livenessRecogResult);
                    } else {
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    if (LivenessRecogActivity.this.aG) {
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
            if (this.bi) {
                BeanManager.getInstance().removeAllBeans(c);
                if (this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(i3);
                    livenessRecogResult.setResultMsg(str);
                    this.A.b(livenessRecogResult);
                    setActivityResult(-1);
                    a(true);
                    return;
                }
                return;
            }
            U();
        } else if (i2 == 6) {
            W();
            c(str);
        } else if (i2 == 7) {
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, i3, arrayList);
            }
            this.aC.x = false;
            if (!this.aC.y) {
                if (i3 == j) {
                    B();
                } else {
                    A();
                }
            }
        } else if (i2 == 8) {
            a(i3);
            a(i3, str);
        } else if (i2 == 12) {
            LogUtil.d("hello", SmsLoginView.StatEvent.LOGIN_FAILURE);
        } else {
            super.handleFailure(i2, i3, str);
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
            BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), "ABTestEnd", livenessBgStyleABTestContent.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(livenessBgStyleABTestContent.toString());
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventWithValues("ABTestEnd", arrayList);
        }
    }

    private void a(int i2, String str) {
        if (this.bd == this.bc) {
            BeanManager.getInstance().removeAllBeans(c);
            if (this.A != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                this.A.b(livenessRecogResult);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        V();
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
        if (this.ba) {
            this.ba = false;
            if (this.aC.z) {
                m();
                z();
                this.aC.z = false;
            } else if (!this.aC.F) {
                if (this.aC.u < 12) {
                    q();
                    m();
                } else if (this.aC.u == 18 || this.aC.u == 17) {
                    m();
                }
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ba = true;
        if (!this.aC.F) {
            this.ax.cancel();
            if (this.aC.u == 14) {
                this.aC.z = true;
                this.O.clearAnimation();
                this.aJ.e();
                this.R.clearAnimation();
                this.aO.removeCallbacks(this.aP);
                return;
            }
            this.aJ.d();
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
        bundle.putBoolean("hasCameraReadyStatistics", this.bf);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(b);
        BeanManager.getInstance().removeAllBeans(c);
        this.aA = true;
        this.at = null;
        this.bl = null;
        this.aN.clear();
        this.aN = null;
        try {
            a();
            this.aK.removeView(this.T);
            this.T = null;
            a(this.aK);
            this.aK.removeCallbacks(null);
            this.aK = null;
            this.aB.removeCallbacksAndMessages(null);
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
        for (SoftReference<Bitmap> softReference : this.aM.values()) {
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
        if (this.A != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.A.b(livenessRecogResult);
        }
    }

    private void c() {
        if (this.E != null) {
            this.E.clearAnimation();
        }
        if (this.D != null) {
            this.D.setImageBitmap(b(R.drawable.sapi_liveness_recog_face_failed));
        }
        this.aC = null;
        this.aD = null;
        this.as = null;
    }

    private void d() {
        com.baidu.fsg.face.base.d.f.b(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        this.B = (ImageView) findViewById(R.id.btn_cancel);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.aC.x) {
                    LivenessRecogActivity.this.aZ.a();
                    LivenessRecogActivity.this.y();
                    return;
                }
                if (LivenessRecogActivity.this.bb != null) {
                    LivenessRecogActivity.this.bb.a(com.baidu.fsg.face.liveness.d.o);
                }
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                if (LivenessRecogActivity.this.aC.u == 14) {
                    LivenessRecogActivity.this.aJ.e();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
                LivenessRecogActivity.this.aJ.d();
            }
        });
        this.C = (ImageView) findViewById(R.id.btn_switch_voice);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.aF = !LivenessRecogActivity.this.aF;
                ArrayList arrayList = new ArrayList();
                arrayList.add(LivenessRecogActivity.this.aF ? "1" : "0");
                arrayList.add(LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.d, arrayList);
                if (LivenessRecogActivity.this.aF) {
                    LivenessRecogActivity.this.C.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
                } else {
                    LivenessRecogActivity.this.C.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
                }
            }
        });
        this.F = (FrameLayout) findViewById(R.id.layout_pose_tip);
        this.H = (TextView) findViewById(R.id.tv_pose_tip);
        this.G = (ImageView) findViewById(R.id.iv_pose_bg);
        this.I = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.J = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.K = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.L = (ConstrastLoadingView) findViewById(R.id.constrastLoadingView);
        this.M = (ConstrastLoadingTipsView) findViewById(R.id.constrastLoadingTipsView);
        this.D = (ImageView) findViewById(R.id.img_face_recognized_state);
        this.D.setImageBitmap(b(R.drawable.sapi_liveness_recog_face_failed));
        this.E = (ImageView) findViewById(R.id.img_face_recognizing_anim);
        O();
        this.T = new CameraSurfaceView(this, null);
        this.aK.addView(this.T, 0, new ViewGroup.LayoutParams(-2, -1));
        this.aJ = new com.baidu.fsg.face.liveness.camera.b();
        this.T.setCameraInterface(this.aJ);
        this.T.setVisibility(4);
        this.ad = (XfordView) findViewById(R.id.xfordview);
        this.ao = (TextView) findViewById(R.id.tv_msg_tips);
        if (this.aS == null || this.aS.sp_conf == null || TextUtils.isEmpty(this.aS.sp_conf.tip_msg)) {
            this.ao.setVisibility(8);
            return;
        }
        this.ao.setVisibility(0);
        this.ao.setText(this.aS.sp_conf.tip_msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        if (this.aR == 1) {
            this.aw = 0;
        } else {
            this.aw = 5;
        }
        return this.aw;
    }

    private void f() {
        this.aG = this.livenessRecogDTO.showGuidePage;
        this.aT = com.baidu.fsg.face.liveness.beans.c.a().a(getActivity()).getSwitchRecordVideo() && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS;
        this.av = getResources().getStringArray(R.array.sapi_liveness_head_pose);
        this.aB = new Handler(Looper.getMainLooper(), this);
        this.aC = new d();
        this.aD = new a();
        this.ax = new f(5000L, 200L);
        this.aC.C = System.currentTimeMillis();
        this.bb = new com.baidu.fsg.face.liveness.b(this.livenessRecogDTO);
        this.bb.a = System.currentTimeMillis();
        this.A = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        g();
        this.aw = e();
        if (this.aT) {
            l();
        } else {
            i();
        }
    }

    private void g() {
        this.aS = com.baidu.fsg.face.liveness.beans.c.a().a(getActivity());
        if (this.aS == null) {
            this.aS = new GetFPResponse.LivenessConfig();
        }
        this.aQ = this.aS.getRecogtimeInterval();
        this.aR = this.aS.getRecogActionType();
        if (this.ad != null && LivenessABTestUtil.getInstance(getApplicationContext()).isWhiteBgEnable()) {
            this.ad.setBgPaintColor(-1);
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
            BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), "ABTestStart", livenessBgStyleABTestContent.toString());
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
            if (!this.aG && this.A != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
                this.A.b(livenessRecogResult);
            }
            setActivityResult(0);
            a(this.aG ? false : true);
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
            this.ar = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
            this.ar.set_isFineAlign(false);
            this.ar.set_isVerifyLive(true);
            if (this.aS == null) {
                this.aS = new GetFPResponse.LivenessConfig();
            }
            this.ar.set_min_face_size(this.aS.getMinFaceSize());
            this.ar.set_illum_thr(this.aS.getIllumThr());
            this.ar.set_track_by_detection_interval(this.aS.getTrackInterval());
            this.ar.set_detect_in_video_interval(this.aS.getDetectInterval());
            this.ar.set_eulur_angle_thr(this.aS.getYaw(), this.aS.getPitch(), this.aS.getRoll());
            this.ar.set_max_reg_img_num(this.aS.getMaxRegImgNum(this.livenessRecogDTO.getSpno()));
            this.ar.set_prefetch_reg_img_interval(this.aS.getPrefetchRegImgInterval());
            this.ar.set_cropFaceSize(this.aS.getCropFaceSize());
            this.ar.set_cropFaceEnlargeRatio(this.aS.getCropFaceRatio());
        } catch (Exception e2) {
            throw new Exception("init faceTracker failure: " + e2.getMessage());
        }
    }

    private void l() {
    }

    private boolean m() {
        this.T.setVisibility(4);
        boolean a2 = this.aJ.a(this, 3);
        if (!a2) {
            E();
        } else {
            a(this.aJ.g());
            this.aJ.a(this.a);
            this.T.startPreview();
        }
        this.T.setVisibility(0);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera) {
        if (this.bm == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.aJ.f()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.bm = previewSize.width;
            this.bn = previewSize.height;
            this.bo = cameraInfo.orientation;
        }
        if (this.ay == null) {
            this.ay = new int[2];
            this.ay[0] = this.bn;
            this.ay[1] = this.bm;
        }
        if (this.aS == null || TextUtils.isEmpty(this.aS.min_face_size)) {
            if (this.bm > 640 && this.bn > 480) {
                this.ar.set_min_face_size(200);
            } else {
                this.ar.set_min_face_size(100);
            }
        }
        if (this.bb != null && this.bb.b == 0) {
            this.bb.c = this.bn;
            this.bb.b = this.bm;
            this.bb.a(com.baidu.fsg.face.liveness.d.t);
        }
        if (this.at == null) {
            this.at = new int[this.bm * this.bn];
        }
    }

    private void a(b.a aVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.T.getLayoutParams());
        b.a b2 = b(aVar);
        if (b2 == null || (b2.a == aVar.a && b2.b == aVar.b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = b2.a;
            layoutParams.height = b2.b;
        }
        this.T.setLayoutParams(layoutParams);
    }

    private void n() {
        if (!this.bf && this.livenessRecogDTO != null) {
            this.bf = true;
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
        this.I.setVisibility(4);
        this.z = -1;
        this.H.setText(R.string.sapi_liveness_put_face_round);
        if (this.D != null) {
            this.D.setImageBitmap(b(R.drawable.sapi_liveness_recog_face_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.I.setVisibility(4);
        this.H.setVisibility(4);
        this.z = -1;
        if (this.D != null) {
            this.D.setImageBitmap(b(R.drawable.sapi_liveness_recog_face_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.aC.C = System.currentTimeMillis();
        if (!this.aT) {
            a(0, 0, (String) null);
            this.ax.start();
        }
    }

    private void r() {
        this.aD.n = this.aY.size() * (this.aV + 1);
        this.aU = this.aD.n;
        this.H.setVisibility(4);
        Q();
        this.aJ.b();
    }

    private b.a b(b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b.a s2 = s();
        b.a aVar2 = new b.a(aVar.a, aVar.b);
        float f2 = aVar.a / aVar.b;
        float f3 = s2.b / s2.a;
        if (Math.abs(f2 - f3) > 0.02d) {
            if (f2 < f3) {
                aVar2.a = (s2.b * aVar.b) / aVar.a;
                aVar2.b = s2.b;
                return aVar2;
            }
            aVar2.a = s2.a;
            aVar2.b = (s2.a * aVar.a) / aVar.b;
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
        String[] strArr = {"android.permission.CAMERA"};
        if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
            DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.42
                @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                @RequiresApi(api = 23)
                public void isAllAgree(boolean z) {
                    if (z) {
                        LivenessRecogActivity.this.aC.F = true;
                        LivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
                        return;
                    }
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
            return;
        }
        q();
        if (m()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.aC.u = 12;
        this.C.setVisibility(4);
        this.I.setVisibility(4);
        this.F.setVisibility(4);
        String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.CAMERA"};
        if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
            DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.43
                @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                @RequiresApi(api = 23)
                public void isAllAgree(boolean z) {
                    if (z) {
                        LivenessRecogActivity.this.aC.F = true;
                        LivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"}, 2004);
                        return;
                    }
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
            return;
        }
        this.aC.u = 14;
        if (this.aa != null && this.aa.isShowing()) {
            this.aa.dismiss();
        }
        if (m()) {
            getRecordVideoQuestions();
        }
    }

    private void v() {
        this.aC.u = 18;
        this.aB.removeCallbacks(this.bj);
        this.aa = new RecordVideoTipDialog(this);
        this.aa.setMenuItemClickListener(new RecordVideoTipDialog.a() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.2
            @Override // com.baidu.fsg.face.liveness.view.RecordVideoTipDialog.a
            public void a() {
                LivenessRecogActivity.this.aC.u = 1;
                LivenessRecogActivity.this.t();
                LivenessRecogActivity.this.as = null;
                LivenessRecogActivity.this.aD.l = false;
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aD.j = false;
                LivenessRecogActivity.this.aD.k = false;
                LivenessRecogActivity.this.aw = LivenessRecogActivity.this.e();
                LivenessRecogActivity.this.aC.C = System.currentTimeMillis();
                LivenessRecogActivity.this.aa.dismiss();
            }

            @Override // com.baidu.fsg.face.liveness.view.RecordVideoTipDialog.a
            public void b() {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.u();
                LivenessRecogActivity.this.aa.dismiss();
            }

            @Override // com.baidu.fsg.face.liveness.view.RecordVideoTipDialog.a
            public void c() {
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
                LivenessRecogActivity.this.aa.dismiss();
            }
        });
        this.aa.setCancelable(false);
        if (!isFinishing() && !this.aa.isShowing()) {
            this.aa.show();
        }
    }

    private void w() {
        this.aC.u = 17;
        this.aB.removeCallbacks(this.bj);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_liveness_dialog_recognized_time_out_title));
        bioAlertDialog.setTimeOutVisible(0);
        bioAlertDialog.setMessageText(getString(R.string.sapi_liveness_dialog_recognized_time_out_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_dialog_recognized_fail_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aC.u = 1;
                LivenessRecogActivity.this.q();
                LivenessRecogActivity.this.aw = LivenessRecogActivity.this.e();
                LivenessRecogActivity.this.aD.j = false;
                LivenessRecogActivity.this.aD.k = false;
                LivenessRecogActivity.this.aC.C = System.currentTimeMillis();
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_biometric_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aJ.d();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_alert_dialog_default_msg_text));
        bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_liveness_record_video_moible_network_tip), S()));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_record_video_moible_network_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.af.setVisibility(8);
                LivenessRecogActivity.this.ag.setVisibility(8);
                LivenessRecogActivity.this.ae.setVisibility(0);
                LivenessRecogActivity.this.ah.setVisibility(0);
                LivenessRecogActivity.this.T();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void c(String str) {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_alert_dialog_default_msg_text));
        bioAlertDialog.setDialogMsg(str);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_try_again), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.getRecordVideoQuestions();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.ab == null) {
            this.ab = new BioAlertDialog(this);
            this.ab.setTitleMsg(getString(R.string.sapi_alert_dialog_default_msg_text));
            this.ab.setDialogMsg(getString(R.string.sapi_liveness_record_up_interrupt));
            this.ab.setPositiveBtn(getString(R.string.sapi_liveness_record_up_interrupt_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.aC.y = false;
                    LivenessRecogActivity.this.ab.dismiss();
                    LivenessRecogActivity.this.T();
                }
            });
            this.ab.setNegativeBtn(getString(R.string.sapi_liveness_record_up_interrupt_btn_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.b(g.b(LivenessRecogActivity.this.getActivity()));
                    LivenessRecogActivity.this.aC.y = false;
                    LivenessRecogActivity.this.ae.dynamicWaveView.stopAnim();
                    LivenessRecogActivity.this.ab.dismiss();
                    if (!LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.b();
                    }
                    LivenessRecogActivity.this.setActivityResult(0);
                    LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
                }
            });
            this.ab.setCancelable(false);
        }
        if (!isFinishing() && !this.ab.isShowing()) {
            this.aC.y = true;
            this.ab.show();
        }
    }

    private void z() {
        if (this.ac == null) {
            this.ac = new BioAlertDialog(this);
            this.ac.setTitleMsg(getString(R.string.sapi_liveness_record_video_fail_dialog_title));
            this.ac.setPositiveBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.p();
                    LivenessRecogActivity.this.ac.dismiss();
                    LivenessRecogActivity.this.u();
                }
            });
            this.ac.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.ac.dismiss();
                    if (!LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.b();
                    }
                    LivenessRecogActivity.this.setActivityResult(0);
                    LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
                }
            });
            this.ac.setCancelable(false);
        }
        if (!isFinishing() && !this.ac.isShowing()) {
            this.ac.show();
        }
    }

    private void A() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_reupload), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.T();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                g.b(g.b(LivenessRecogActivity.this.getActivity()));
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void B() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_liveness_record_video_title_upload_timeout));
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_up_time_out_tip));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_record_video_record_again), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.J();
                LivenessRecogActivity.this.p();
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.u();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aG ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void C() {
        this.aC.u = 17;
        this.aB.removeCallbacks(this.bj);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_recog_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.setActivityResult(-1);
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-301);
                    LivenessRecogActivity.this.A.b(livenessRecogResult);
                }
                LivenessRecogActivity.this.a(true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void D() {
        this.aC.F = true;
        if (this.W == null) {
            this.W = new BioAlertDialog(this);
            this.W.setTitleMsg(getString(R.string.sapi_permission_request));
            this.W.setTitleVisible(true);
            this.W.setDialogMsg(String.format(getString(R.string.sapi_liveness_permission_camera), h.c(this)));
            this.W.setBtnCount(1);
            this.W.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.W.dismiss();
                    LivenessRecogActivity.this.aC.F = false;
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.W.setCancelable(false);
        if (!isFinishing() && !this.W.isShowing()) {
            this.W.show();
        }
    }

    private void E() {
        this.aC.u = 19;
        if (this.X == null) {
            this.X = new BioAlertDialog(this);
            this.X.setTitleVisible(true);
            this.X.setDialogMsg(getString(R.string.sapi_liveness_open_camera_no_permission));
            this.X.setBtnCount(1);
            this.X.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.X.dismiss();
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.X.setCancelable(false);
        if (!isFinishing() && !this.X.isShowing()) {
            this.X.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleVisible(true);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_no_audio_permission));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (LivenessRecogActivity.this.aG) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                    LivenessRecogActivity.this.A.b(livenessRecogResult);
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
        if (this.Y == null) {
            this.Y = new BioAlertDialog(this);
            this.Y.setTitleMsg(format);
            this.Y.setTitleVisible(true);
            this.Y.setDialogMsg(str2);
            this.Y.setBtnCount(1);
            this.Y.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Y.dismiss();
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
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

    private void G() {
        if (this.Z == null) {
            this.Z = new BioAlertDialog(this);
            this.Z.setTitleVisible(true);
            this.Z.setDialogMsg(getString(R.string.sapi_liveness_video_record_failed));
            this.Z.setBtnCount(1);
            this.Z.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Z.dismiss();
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-304);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        if (!isFinishing() && !this.Z.isShowing()) {
            this.Z.show();
        }
    }

    private boolean H() {
        this.aC.u = 14;
        if (this.aJ.b(this)) {
            return true;
        }
        F();
        return false;
    }

    public void showVideoDoneView() {
        if (this.an == null) {
            View inflate = ((ViewStub) findViewById(R.id.view_stup_upload_video)).inflate();
            this.an = inflate.findViewById(R.id.view_stub_container);
            this.am = inflate.findViewById(R.id.upload_video_container);
            this.ae = (UploadingFileView) inflate.findViewById(R.id.uploading_file_view);
            this.ah = inflate.findViewById(R.id.uploading_tv);
            this.ai = inflate.findViewById(R.id.uploading_success_tv);
            this.aj = inflate.findViewById(R.id.uploading_success_prompt_tv);
            this.ak = inflate.findViewById(R.id.ok_btn);
            this.af = inflate.findViewById(R.id.re_video_container);
            this.ag = inflate.findViewById(R.id.video_finish_container);
            this.U = (ImageView) inflate.findViewById(R.id.img_canvas_view);
            this.al = (RelativeLayout) inflate.findViewById(R.id.blurring_view_container);
            this.af.setOnClickListener(this.bk);
            this.ag.setOnClickListener(this.bk);
            this.ak.setOnClickListener(this.bk);
        } else if (this.an.getVisibility() != 0) {
            this.an.setVisibility(0);
        }
        this.ad.setVisibility(8);
        this.D.setVisibility(8);
        this.H.setVisibility(8);
        this.S.setVisibility(8);
        this.R.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 10) {
            String b2 = g.b(getActivity());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(b2);
            this.U.setImageBitmap(mediaMetadataRetriever.getFrameAtTime(3000000L));
            if (Build.VERSION.SDK_INT >= 17) {
                BlurringView blurringView = new BlurringView(this);
                blurringView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.al.addView(blurringView);
                blurringView.setBlurredView(this.U);
                blurringView.invalidate();
                return;
            }
            this.am.setBackgroundResource(R.drawable.sapi_liveness_record_video_done_mask);
            return;
        }
        this.am.setBackgroundResource(R.drawable.sapi_liveness_record_video_done_mask);
    }

    private void I() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        this.B.setVisibility(8);
        this.ah.setVisibility(8);
        this.ai.setVisibility(0);
        this.aj.setVisibility(0);
        this.ak.setVisibility(0);
        this.ai.startAnimation(alphaAnimation);
        this.aj.startAnimation(alphaAnimation);
        this.ak.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.af.setVisibility(0);
        this.ag.setVisibility(0);
        this.ad.setVisibility(0);
        this.D.setVisibility(0);
        this.S.setVisibility(0);
        this.R.setVisibility(0);
        this.an.setVisibility(8);
        this.ae.setVisibility(8);
        this.ah.setVisibility(8);
        this.ai.setVisibility(8);
        this.aj.setVisibility(8);
        this.ak.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.bl != null && this.at != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                FaceSDK.getARGBFromYUVimg(this.bl, this.at, this.bm, this.bn, this.bo, 1);
                this.az = this.ar.face_verification(this.at, this.bm, this.bn, FaceSDK.ImgType.ARGB, au, "", "", "");
                this.as = this.ar.get_TrackedFaceInfo();
                int i2 = (this.as == null || this.as.length <= 0 || this.as[0] == null) ? 0 : this.as[0].face_id;
                if (i2 != 0 && i2 != this.bq) {
                    this.aN.clear();
                }
                this.bq = i2;
                if (this.az == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    if (this.bp) {
                        this.aN.clear();
                        this.bp = false;
                    }
                    if (this.at != null) {
                        this.aN.add(Arrays.copyOf(this.at, this.at.length));
                    }
                } else if (this.az == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    if (this.at != null) {
                        this.aN.add(Arrays.copyOf(this.at, this.at.length));
                    }
                    this.bp = true;
                }
                this.bl = null;
                if (this.aS == null || !this.aS.isStatisticsEnable()) {
                    this.at = null;
                }
                if (this.bb != null) {
                    this.bb.a(this.az);
                    if (this.aC != null && !this.aC.v && !this.aC.E) {
                        this.bb.b(this.az);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (this.bb != null) {
                    this.bb.a(currentTimeMillis2);
                }
                if (this.aC.u == 6 && this.bb != null) {
                    this.bb.b(currentTimeMillis2);
                }
            } catch (Throwable th) {
                com.baidu.fsg.face.base.d.d.a(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b extends AsyncTask<Void, Void, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.X(LivenessRecogActivity.this);
            LivenessRecogActivity.this.K();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.Z(LivenessRecogActivity.this);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends CountDownTimer {
        public f(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (LivenessRecogActivity.this.aC.u != 0 && LivenessRecogActivity.this.aC.u != 17 && LivenessRecogActivity.this.aC.u != 19 && LivenessRecogActivity.this.aC.u != 18 && LivenessRecogActivity.this.aC.u != 14 && LivenessRecogActivity.this.aC.u != 15 && LivenessRecogActivity.this.aC.u != 16) {
                FaceInfo[] faceInfoArr = LivenessRecogActivity.this.as;
                if (LivenessRecogActivity.this.aC.u == 1) {
                    if (LivenessRecogActivity.this.L()) {
                        LivenessRecogActivity.this.M();
                        return;
                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        if (LivenessRecogActivity.this.az == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.c(2);
                            if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                                LivenessRecogActivity.this.bb.b("2");
                                return;
                            }
                            return;
                        } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.az)) {
                            LivenessRecogActivity.this.c(4);
                            if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                                if (LivenessRecogActivity.this.c(faceInfoArr[0], LivenessRecogActivity.this.az)) {
                                    LivenessRecogActivity.this.bb.b("0");
                                    return;
                                } else if (LivenessRecogActivity.this.d(faceInfoArr[0], LivenessRecogActivity.this.az)) {
                                    LivenessRecogActivity.this.bb.b("1");
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                            if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                                LivenessRecogActivity.this.bb.b("3");
                            }
                            LivenessRecogActivity.this.z = -1;
                            LivenessRecogActivity.this.I.setVisibility(8);
                            LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_failed));
                            LivenessRecogActivity.this.aC.v = false;
                            return;
                        } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                            LivenessRecogActivity.this.c(1);
                            if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                                LivenessRecogActivity.this.bb.b("4");
                                return;
                            }
                            return;
                        } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                            LivenessRecogActivity.this.c(0);
                            if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                                LivenessRecogActivity.this.bb.b("5");
                                return;
                            }
                            return;
                        } else {
                            LivenessRecogActivity.this.z = -1;
                            LivenessRecogActivity.this.I.setVisibility(8);
                            LivenessRecogActivity.this.aC.u = 2;
                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.g, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                            LogUtil.d("hello", "onEvent(StatServiceEvent.FACEDETECTED):  监测到人脸");
                            if (!LivenessRecogActivity.this.aC.v) {
                                LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_successed));
                                LivenessRecogActivity.this.aE = System.currentTimeMillis();
                                LivenessRecogActivity.this.aC.v = true;
                            }
                            LivenessRecogActivity.this.P();
                            return;
                        }
                    } else {
                        if (LivenessRecogActivity.this.bb != null && LivenessRecogActivity.this.aC != null && !LivenessRecogActivity.this.aC.v && !LivenessRecogActivity.this.aC.E) {
                            LivenessRecogActivity.this.bb.b(Constants.VIA_SHARE_TYPE_INFO);
                        }
                        LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_failed));
                        LivenessRecogActivity.this.aC.v = false;
                        LivenessRecogActivity.this.z = -1;
                        LivenessRecogActivity.this.I.setVisibility(8);
                        return;
                    }
                }
                if (LivenessRecogActivity.this.aC.u == 4) {
                    if (LivenessRecogActivity.this.L()) {
                        LivenessRecogActivity.this.M();
                        return;
                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        LivenessRecogActivity.this.z = -1;
                        LivenessRecogActivity.this.I.setVisibility(8);
                        if (LivenessRecogActivity.this.d(faceInfoArr)) {
                            if (LivenessRecogActivity.this.b(faceInfoArr)) {
                                if (LivenessRecogActivity.this.aR == 1) {
                                    LivenessRecogActivity.this.aC.u = 5;
                                } else {
                                    LivenessRecogActivity.this.aC.u = 7;
                                }
                                long j2 = LivenessRecogActivity.this.aQ * 1000;
                                if (j2 < 20000) {
                                    LivenessRecogActivity.this.aB.postDelayed(LivenessRecogActivity.this.bj, j2);
                                }
                            } else {
                                LivenessRecogActivity.this.aC.u = 1;
                                LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_failed));
                                LivenessRecogActivity.this.aC.v = false;
                                return;
                            }
                        }
                    } else {
                        LivenessRecogActivity.this.aC.u = 1;
                        LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_failed));
                        LivenessRecogActivity.this.aC.v = false;
                        return;
                    }
                }
                if (LivenessRecogActivity.this.aC.u == 5) {
                    if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        LivenessRecogActivity.this.z = -1;
                        LivenessRecogActivity.this.I.setVisibility(8);
                        if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aD.j) {
                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.h, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWBLINK):  提示眨眨眼");
                            LivenessRecogActivity.this.a(0, 1, (String) null);
                            LivenessRecogActivity.this.aD.j = true;
                        }
                    }
                } else if (LivenessRecogActivity.this.aC.u == 7 && LivenessRecogActivity.this.c(faceInfoArr)) {
                    LivenessRecogActivity.this.z = -1;
                    LivenessRecogActivity.this.I.setVisibility(8);
                    if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aD.k) {
                        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.j, LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                        LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWMOUTH):  提示张张嘴");
                        LivenessRecogActivity.this.a(0, 3, (String) null);
                        LivenessRecogActivity.this.aD.k = true;
                    }
                }
                if (LivenessRecogActivity.this.aC.u == 6 || LivenessRecogActivity.this.aC.u == 8) {
                    if (LivenessRecogActivity.this.L()) {
                        LivenessRecogActivity.this.M();
                        return;
                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        if (LivenessRecogActivity.this.az == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.c(2);
                            return;
                        } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.az)) {
                            LivenessRecogActivity.this.c(4);
                            return;
                        } else if (!LivenessRecogActivity.this.d(faceInfoArr)) {
                            LivenessRecogActivity.this.z = -1;
                            LivenessRecogActivity.this.I.setVisibility(8);
                            return;
                        } else if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                            LivenessRecogActivity.this.c(1);
                            return;
                        } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                            LivenessRecogActivity.this.c(0);
                            return;
                        } else {
                            LivenessRecogActivity.this.z = -1;
                            LivenessRecogActivity.this.I.setVisibility(8);
                            LivenessRecogActivity.this.a(faceInfoArr);
                        }
                    } else {
                        LivenessRecogActivity.this.c(3);
                        LivenessRecogActivity.this.aC.w = false;
                        return;
                    }
                }
                if (LivenessRecogActivity.this.aC.u == 9) {
                    if (LivenessRecogActivity.this.L()) {
                        LivenessRecogActivity.this.M();
                        return;
                    } else if (LivenessRecogActivity.this.c(faceInfoArr)) {
                        if (LivenessRecogActivity.this.az == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.c(2);
                            return;
                        } else if (LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.az)) {
                            LivenessRecogActivity.this.c(4);
                            return;
                        } else if (LivenessRecogActivity.this.d(faceInfoArr)) {
                            if (h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                                LivenessRecogActivity.this.c(1);
                                return;
                            } else if (h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.ay)) {
                                LivenessRecogActivity.this.c(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.z = -1;
                                LivenessRecogActivity.this.I.setVisibility(8);
                            }
                        }
                    } else {
                        LivenessRecogActivity.this.c(3);
                        LivenessRecogActivity.this.aC.w = false;
                        return;
                    }
                }
                if (LivenessRecogActivity.this.c(faceInfoArr) && !LivenessRecogActivity.this.aA && LivenessRecogActivity.this.aC.u == 9 && LivenessRecogActivity.this.az == FaceTracker.ErrCode.OK) {
                    FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.ar.get_FaceVerifyData(0);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0");
                    arrayList.add(LivenessRecogActivity.this.livenessRecogDTO != null ? LivenessRecogActivity.this.livenessRecogDTO.getSpno() : "");
                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.p, arrayList);
                    LogUtil.d("hello", "onEventWithValue(StatServiceEvent.RETRIEVEDIMAGE):  获取到活体图片的数量  " + (faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0"));
                    if (LivenessRecogActivity.this.a(faceInfoArr[0], LivenessRecogActivity.this.az) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                        LivenessRecogActivity.this.aC.u = 10;
                        LivenessRecogActivity.this.aB.removeCallbacks(LivenessRecogActivity.this.bj);
                        LivenessRecogActivity.this.ax.cancel();
                        LivenessRecogActivity.this.aJ.c();
                        LivenessRecogActivity.this.L.setVisible(0);
                        LivenessRecogActivity.this.b(LivenessRecogActivity.this.a(faceVerifyDataArr));
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!LivenessRecogActivity.this.aA) {
                LivenessRecogActivity.this.ax.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        return System.currentTimeMillis() - this.aC.C > this.aC.D && this.aC.C > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.aC.C = 0L;
        if (!this.aC.E) {
            if (this.bb != null) {
                this.bb.a(com.baidu.fsg.face.liveness.d.l);
            }
            LogUtil.d("hello", "onEvent(StatServiceEvent.FIRSTTIMEOUT):  一次超时");
            w();
            this.aC.E = true;
            N();
            return;
        }
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.m, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.SECONDTIMEOUT):  两次超时");
        if (this.aS != null && this.livenessRecogDTO != null && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS && this.aS.shouldRecordVideo(this.livenessRecogDTO.getSpno())) {
            b("1");
            v();
            return;
        }
        C();
    }

    private void N() {
        if (this.at != null && this.aS != null && this.aS.isStatisticsEnable()) {
            if (!"1".equals(this.aS.report_type) || (this.aC != null && !this.aC.v)) {
                new Thread(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.27
                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar = (j) FaceSDKBeansFactory.getInstance().getBean(LivenessRecogActivity.this.getActivity(), 12, LivenessRecogActivity.b);
                        jVar.c(LivenessRecogActivity.this.a(LivenessRecogActivity.this.at));
                        if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                            jVar.a(LivenessRecogActivity.this.livenessRecogDTO);
                        }
                        if (LivenessRecogActivity.this.aS != null) {
                            jVar.a(LivenessRecogActivity.this.aS.report_type);
                        }
                        if (LivenessRecogActivity.this.bb != null) {
                            jVar.a(LivenessRecogActivity.this.bb.d, LivenessRecogActivity.this.bb.e);
                        }
                        jVar.setResponseCallback(LivenessRecogActivity.this);
                        jVar.execBean();
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

    private void O() {
        this.aL = new AnimationDrawable();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(b(R.drawable.sapi_liveness_face_recognizing_anim2));
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(b(R.drawable.sapi_liveness_face_recognizing_anim3));
        this.aL.addFrame(bitmapDrawable, 120);
        this.aL.addFrame(bitmapDrawable2, 120);
        this.aL.setOneShot(false);
        this.E.setImageDrawable(this.aL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(int i2) {
        Bitmap bitmap;
        if (!this.aM.containsKey(Integer.valueOf(i2)) || this.aM.get(Integer.valueOf(i2)) == null || (bitmap = this.aM.get(Integer.valueOf(i2)).get()) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i2, options);
            options.inSampleSize = h.a(options, dimensionPixelSize2, dimensionPixelSize);
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
            this.aM.put(Integer.valueOf(i2), new SoftReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceInfo[] faceInfoArr) {
        boolean z = false;
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            return;
        }
        if ((this.aC.u == 6 || this.aC.u == 8) && this.aC.u != 9) {
            switch (this.aw) {
                case 0:
                    z = faceInfoArr[0].is_live();
                    break;
                case 1:
                    z = faceInfoArr[0].is_live_head_down();
                    break;
                case 2:
                    z = faceInfoArr[0].is_live_head_up();
                    break;
                case 3:
                    z = faceInfoArr[0].is_live_head_turn_left();
                    break;
                case 4:
                    z = faceInfoArr[0].is_live_head_turn_right();
                    break;
                case 5:
                    z = faceInfoArr[0].is_live_mouth();
                    break;
            }
            if (z) {
                if (this.aw == 0) {
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTBLINK):  检测到眨眼");
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.i, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
                } else if (this.aw == 5) {
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.k, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTMOUTH):  检测到张嘴");
                }
                this.aC.u = 9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        return faceInfoArr == null || faceInfoArr.length <= 0 || !(h.b(faceInfoArr[0].landmarks, this.ay) || h.c(faceInfoArr[0].landmarks, this.ay));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && h.a(faceInfoArr[0].landmarks, this.ay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        return faceInfo != null && this.az == FaceTracker.ErrCode.OK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, final int i3, final String str) {
        this.G.clearAnimation();
        this.F.clearAnimation();
        b(i3, str);
        if (i2 == 0) {
            if (i3 == 0) {
                d(2);
            } else if (i3 == 1) {
                d(0);
            } else if (i3 == 2) {
                d(3);
            } else if (i3 == 3) {
                d(8);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_bottom_to_midd);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LivenessRecogActivity.this.a(1, i3, str);
                        }
                    }, 300L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.H.setVisibility(0);
            this.H.setTextColor(Color.rgb(255, 255, 255));
            this.F.startAnimation(loadAnimation);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_midd_to_top);
        this.F.startAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.29
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LivenessRecogActivity.this.aC.u == 0) {
                    LivenessRecogActivity.this.aC.u = 1;
                } else if (LivenessRecogActivity.this.aC.u == 5) {
                    LivenessRecogActivity.this.aC.u = 6;
                } else if (LivenessRecogActivity.this.aC.u == 7) {
                    LivenessRecogActivity.this.aC.u = 8;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.G.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_alpha_midd_to_top));
        this.H.setVisibility(0);
        if (LivenessABTestUtil.getInstance(getApplicationContext()).isWhiteBgEnable()) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(300L);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.setIntValues(1, 100);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.30
                private IntEvaluator b = new IntEvaluator();

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int intValue = this.b.evaluate(((Integer) valueAnimator2.getAnimatedValue()).intValue() / 100.0f, (Integer) 255, (Integer) 51).intValue();
                    LivenessRecogActivity.this.H.setTextColor(Color.rgb(intValue, intValue, intValue));
                }
            });
            valueAnimator.start();
        }
    }

    private void b(int i2, String str) {
        if (i2 == 0) {
            this.H.setText(R.string.sapi_liveness_put_face_round);
        } else if (i2 == 1) {
            if (this.av != null && this.aw < this.av.length) {
                this.H.setText(this.av[this.aw]);
            }
        } else if (i2 == 2) {
            if (this.av != null && this.aw < this.av.length) {
                this.H.setText(this.av[this.aw]);
            }
        } else if (i2 == 3) {
            if (this.av != null && this.aw < this.av.length) {
                this.H.setText(this.av[this.aw]);
            }
        } else if (i2 == 4) {
            this.H.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        this.I.setVisibility(0);
        if (this.z != i2) {
            if (i2 == 1) {
                this.K.setText(getString(R.string.sapi_liveness_tofar_from_camera));
                d(7);
            } else if (i2 == 0) {
                this.K.setText(getString(R.string.sapi_liveness_tonear_from_camera));
                d(6);
            } else if (i2 == 2) {
                this.K.setText(getString(R.string.sapi_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                this.K.setText(getString(R.string.sapi_liveness_face_to_screen));
            } else {
                d(2);
                this.K.setText(getString(R.string.sapi_liveness_put_face_round));
            }
            final Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_warning);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.31
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.J.startAnimation(loadAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (!this.aD.i) {
                this.J.startAnimation(loadAnimation);
                this.aD.i = true;
            }
        }
        this.z = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.aC.u = 3;
        this.E.setVisibility(0);
        d(4);
        this.aL.start();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.32
            @Override // java.lang.Runnable
            public void run() {
                LivenessRecogActivity.this.aL.stop();
                LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.sapi_liveness_recog_face_successed));
                LivenessRecogActivity.this.E.setVisibility(8);
                LivenessRecogActivity.this.aC.u = 4;
            }
        }, 1200L);
    }

    private void Q() {
        this.aD.m = 0;
        if (this.N == null) {
            View inflate = ((ViewStub) findViewById(R.id.ll_video_tip_view_stub)).inflate();
            this.N = (RelativeLayout) inflate.findViewById(R.id.ll_video_tip);
            this.O = (ImageView) inflate.findViewById(R.id.iv_video_count_down);
            this.P = (TextView) inflate.findViewById(R.id.tv_video_tip);
            this.Q = (LinearLayout) inflate.findViewById(R.id.ll_time_count);
            this.R = (ImageView) inflate.findViewById(R.id.iv_time_count_point);
            this.S = (TextView) inflate.findViewById(R.id.tv_time_count);
        } else {
            this.N.setVisibility(0);
        }
        this.S.setText(String.format("00:%02d", Integer.valueOf(this.aD.n)));
        this.P.setVisibility(0);
        this.P.setText(R.string.sapi_liveness_video_start_record_later);
        this.O.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.spai_liveness_video_scale_count_down);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.33
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessRecogActivity.this.aD.m++;
                if (LivenessRecogActivity.this.aD.m != 1 || LivenessRecogActivity.this.aD.m > 3) {
                    if (LivenessRecogActivity.this.aD.m != 3 || LivenessRecogActivity.this.aD.m > 3) {
                        if (LivenessRecogActivity.this.aD.m > 4) {
                            LivenessRecogActivity.this.O.setVisibility(4);
                            LivenessRecogActivity.this.P.setText(R.string.sapi_liveness_video_start_record);
                            LivenessRecogActivity.this.P.postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.33.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!LivenessRecogActivity.this.aC.z) {
                                        LivenessRecogActivity.this.P.setVisibility(8);
                                        LivenessRecogActivity.this.R();
                                    }
                                }
                            }, 300L);
                            return;
                        }
                        return;
                    }
                    LivenessRecogActivity.this.O.setImageResource(R.drawable.sapi_liveness_video_count_down_1);
                    LivenessRecogActivity.this.O.startAnimation(animation);
                    return;
                }
                LivenessRecogActivity.this.O.setImageResource(R.drawable.sapi_liveness_video_count_down_2);
                animation.reset();
                LivenessRecogActivity.this.O.startAnimation(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.O.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (H() && !this.aC.z) {
            this.Q.setVisibility(0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.35
                @Override // java.lang.Runnable
                public void run() {
                    LivenessRecogActivity.this.R.startAnimation(AnimationUtils.loadAnimation(LivenessRecogActivity.this, R.anim.sapi_liveness_time_count_point));
                }
            }, 2000L);
            this.aO.postDelayed(this.aP, 1000L);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.36
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(g.b(LivenessRecogActivity.this.getActivity()));
                    if (!file.exists() || file.length() <= 0) {
                        LivenessRecogActivity.this.aJ.e();
                        LivenessRecogActivity.this.F();
                        LivenessRecogActivity.this.R.clearAnimation();
                        LivenessRecogActivity.this.aO.removeCallbacks(LivenessRecogActivity.this.aP);
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
            if (Math.abs(faceInfo.headPose[0]) >= (this.aS != null ? this.aS.getPitch() : 15)) {
                return true;
            }
            if (Math.abs(faceInfo.headPose[1]) >= (this.aS != null ? this.aS.getYaw() : 15)) {
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
            if (Math.abs(faceInfo.headPose[0]) >= (this.aS != null ? this.aS.getPitch() : 15)) {
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
            if (Math.abs(faceInfo.headPose[1]) >= (this.aS != null ? this.aS.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - this.aE > j2;
    }

    private void d(int i2) {
        try {
            if (this.aq == null || (!this.aq.isPlaying() && i2 < e.j.length)) {
                this.aq = MediaPlayer.create(this, e.j[i2]);
                if (this.aq != null) {
                    this.aq.setOnErrorListener(new c());
                    setVolumeControlStream(3);
                    if (!this.aF) {
                        this.aq.setVolume(0.0f, 0.0f);
                    }
                    this.aq.start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
            if (this.aC.x) {
                this.aZ.a();
                y();
                return false;
            }
            if (this.bb != null) {
                this.bb.a(com.baidu.fsg.face.liveness.d.o);
            }
            if (!this.aG) {
                b();
            }
            if (this.aC.u == 14) {
                this.aJ.e();
            }
            this.aJ.d();
            setActivityResult(0);
            a(this.aG ? false : true);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3 = 0;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.aC.F = false;
        if (i2 == 2002) {
            if (iArr[0] == 0) {
                q();
                if (m()) {
                    n();
                    return;
                }
                return;
            }
            D();
        } else if (i2 == 2004) {
            int i4 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
            if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                i3 = 1;
            }
            if (i4 == 1 && i3 == 1) {
                if (this.aa != null && this.aa.isShowing()) {
                    this.aa.dismiss();
                }
                this.aC.u = 14;
                m();
                getRecordVideoQuestions();
                return;
            }
            a(i4, i3);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.bb != null) {
            this.bb.a(com.baidu.fsg.face.liveness.d.r);
            this.bb.a(com.baidu.fsg.face.liveness.d.s);
            this.bb.a(com.baidu.fsg.face.liveness.d.u);
            this.bb.a(com.baidu.fsg.face.liveness.d.v);
        }
        if (z) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending():  发送日志");
        }
        if (this.ax != null) {
            this.ax.cancel();
        }
        try {
            if (this.aq != null) {
                this.aq.stop();
                this.aq.release();
                this.aq = null;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3108=4, 3103=4] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String S() {
        FileInputStream fileInputStream;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(g.b(getActivity()));
            try {
                int available = fileInputStream.available();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        i2 = available;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        i2 = available;
                    }
                } else {
                    i2 = available;
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
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
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
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
        com.baidu.fsg.face.liveness.beans.g gVar = (com.baidu.fsg.face.liveness.beans.g) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, b);
        gVar.setResponseCallback(this);
        gVar.execBean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3162=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T() {
        FileInputStream fileInputStream;
        this.aC.x = true;
        this.ae.setProgress(0);
        this.aC.u = 16;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(g.b(this));
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
                    RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.y);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
                    l lVar = (l) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, b);
                    UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                    uploadFileModel.filedata = bArr;
                    uploadFileModel.fileName = "video.3gp";
                    uploadFileModel.name = "file";
                    lVar.addFile(uploadFileModel);
                    lVar.a(this.aW);
                    lVar.b(this.aX);
                    lVar.setProgressListener(new RestMultipartEntity.ProgressListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.37
                        @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                        public void transferred(long j2, long j3) {
                            LogUtil.d("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                            LogUtil.d("hello", "progress:  " + ((int) ((((float) j2) / ((float) j3)) * 100.0f)));
                            LivenessRecogActivity.this.ae.setProgress((int) ((((float) j2) / ((float) j3)) * 100.0f));
                        }
                    });
                    lVar.setResponseCallback(this);
                    lVar.execBean();
                } catch (Exception e3) {
                    A();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$38] */
    public void b(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                int i2;
                int i3;
                Bitmap createBitmap;
                LivenessRecogActivity.this.bc = 0;
                LivenessRecogActivity.this.bd = 0;
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
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-306);
                        livenessRecogResult.setResultMsg(com.baidu.fsg.face.liveness.c.e);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    if (LivenessRecogActivity.this.aG) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    LivenessRecogActivity.this.a(true);
                    return;
                }
                LivenessRecogActivity.this.bc = arrayList.size();
                LivenessRecogActivity.this.be = arrayList;
                if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                    if (LivenessRecogActivity.this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                        if (LivenessRecogActivity.this.aS != null) {
                            LivenessRecogActivity.this.bc = LivenessRecogActivity.this.aS.getRecogUploadPortraitCount(LivenessRecogActivity.this.bc);
                        }
                        LivenessRecogActivity.this.V();
                        return;
                    }
                    LivenessRecogActivity.this.U();
                }
            }
        }.execute(faceVerifyDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.bi) {
            BeanManager.getInstance().removeAllBeans(c);
            if (this.A != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-206);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                this.A.b(livenessRecogResult);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        this.bd++;
        if (this.be == null || this.bd > this.be.size()) {
            BeanManager.getInstance().removeAllBeans(c);
            if (this.A != null) {
                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                livenessRecogResult2.setResultCode(-206);
                livenessRecogResult2.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                this.A.b(livenessRecogResult2);
                setActivityResult(-1);
                a(true);
                return;
            }
            return;
        }
        if (this.bd == 1) {
            RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.q);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
        }
        byte[] bArr = this.be.get(this.bd - 1).get("data");
        byte[] bArr2 = this.be.get(this.bd - 1).get("digest");
        this.bi = this.bd == this.be.size();
        i iVar = (i) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 5, c);
        if (this.livenessRecogDTO != null) {
            iVar.a(this.livenessRecogDTO);
        }
        if (bArr2 != null) {
            iVar.a(new String(bArr2));
        }
        if (bArr != null) {
            iVar.c(Base64Utils.encodeToString(bArr));
        }
        iVar.setResponseCallback(this);
        iVar.a(this.bi);
        iVar.b(this.aX);
        iVar.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.bd++;
        if (this.be != null && this.bd <= this.bc && this.bd <= this.be.size()) {
            this.bg = this.be.get(this.bd - 1).get("data");
            this.bh = this.be.get(this.bd - 1).get("digest");
            this.bi = this.bd == this.be.size();
            if (this.bd == 1) {
                RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.H);
            }
            com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 8, c);
            if (this.bh != null) {
                dVar.a(new String(this.bh));
            }
            new UploadBean.UploadFileModel().contentType = "image/png";
            dVar.c(Base64Utils.encodeToString(this.bg));
            dVar.setResponseCallback(this);
            dVar.a(this.bi);
            dVar.execBean();
        }
    }

    private void d(String str) {
        if (!isFinishing()) {
            this.V = new LoadingDialog(this);
            this.V.setMessage(str);
            this.V.show();
        }
    }

    private void W() {
        if (this.V != null && !isFinishing() && this.V.isShowing()) {
            this.V.dismiss();
        }
    }

    private int X() {
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
    /* loaded from: classes3.dex */
    public class d {
        static final int A = 5000;
        static final int B = 20000;
        static final int a = 0;
        static final int b = 1;
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
    /* loaded from: classes3.dex */
    public class a {
        static final int a = 0;
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final long f = 300;
        static final long g = 1000;
        static final int h = 7;
        private static final int q = 0;
        private static final int r = 1;
        boolean i = false;
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
    /* loaded from: classes3.dex */
    public static class e {
        static final int a = 0;
        static final int b = 1;
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
