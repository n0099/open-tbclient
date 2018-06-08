package com.baidu.sapi2.biometrics.liveness.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.biometrics.liveness.SapiLivenessRecogManager;
import com.baidu.sapi2.biometrics.liveness.beans.FaceSDKBeansFactory;
import com.baidu.sapi2.biometrics.liveness.beans.i;
import com.baidu.sapi2.biometrics.liveness.callback.LivenessRecogCallback;
import com.baidu.sapi2.biometrics.liveness.camera.CameraSurfaceView;
import com.baidu.sapi2.biometrics.liveness.camera.a;
import com.baidu.sapi2.biometrics.liveness.datamodel.GetRecordVedioQuestionModel;
import com.baidu.sapi2.biometrics.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.sapi2.biometrics.liveness.datamodel.UploadVideoModel;
import com.baidu.sapi2.biometrics.liveness.e;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.biometrics.liveness.utils.SapiStatService;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessSerializableMap;
import com.baidu.sapi2.biometrics.liveness.view.BioAlertDialog;
import com.baidu.sapi2.biometrics.liveness.view.BlurringView;
import com.baidu.sapi2.biometrics.liveness.view.ConstrastLoadingView;
import com.baidu.sapi2.biometrics.liveness.view.LoadingDialog;
import com.baidu.sapi2.biometrics.liveness.view.RecordVideoTipDialog;
import com.baidu.sapi2.biometrics.liveness.view.UploadingFileView;
import com.baidu.sapi2.biometrics.liveness.view.XfordView;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    private static final FaceTracker.ActionType av = FaceTracker.ActionType.RECOGNIZE;
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
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private ConstrastLoadingView O;
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
    private FaceTracker.ErrCode aA;
    private Handler aC;
    private d aD;
    private a aE;
    private f aF;
    private long aG;
    private b aK;
    private com.baidu.sapi2.biometrics.liveness.camera.a aL;
    private ViewGroup aM;
    private AnimationDrawable aN;
    private int aS;
    private long aT;
    private GetFPResponse.LivenessConfig aU;
    private String aY;
    private String aZ;
    private BioAlertDialog aa;
    private BioAlertDialog ab;
    private RecordVideoTipDialog ac;
    private BioAlertDialog ad;
    private BioAlertDialog ae;
    private XfordView af;
    private UploadingFileView ag;
    private View ah;
    private View ai;
    private View aj;
    private View ak;
    private View al;
    private View am;
    private RelativeLayout an;
    private View ao;
    private View ap;
    private LivenessRecogResult aq;
    private MediaPlayer ar;
    private FaceTracker as;
    private FaceInfo[] at;
    private String[] aw;
    private int ax;
    private g ay;
    private int[] az;
    private com.baidu.sapi2.biometrics.liveness.e bb;
    private com.baidu.sapi2.biometrics.liveness.c bd;
    private int be;
    private int bf;
    private ArrayList<HashMap<String, byte[]>> bg;
    private boolean bh;
    private byte[] bi;
    private byte[] bj;
    private byte[] bm;
    private int bn;
    private int bo;
    private int bp;
    private int z = -1;
    private int[] au = null;
    private boolean aB = false;
    private boolean aH = true;
    private boolean aI = true;
    private int aJ = 0;
    private Map<Integer, SoftReference<Bitmap>> aO = new ConcurrentHashMap();
    private List<int[]> aP = new ArrayList();
    private Handler aQ = new Handler(Looper.getMainLooper());
    private Runnable aR = new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.1
        @Override // java.lang.Runnable
        public void run() {
            LivenessRecogActivity.this.ax = 1;
            LivenessRecogActivity.this.U.setText(String.format("00:%02d", Integer.valueOf(LivenessRecogActivity.this.aE.n)));
            LivenessRecogActivity.this.aQ.postDelayed(LivenessRecogActivity.this.aR, 1000L);
            int size = LivenessRecogActivity.this.ba.size() - (LivenessRecogActivity.this.aE.n / (LivenessRecogActivity.this.aX + 1));
            if (LivenessRecogActivity.this.aE.n <= 0 || LivenessRecogActivity.this.aE.n % (LivenessRecogActivity.this.aX + 1) != 0) {
                if (LivenessRecogActivity.this.aE.n == 0) {
                    LivenessRecogActivity.this.aL.e();
                    LivenessRecogActivity.this.T.clearAnimation();
                    LivenessRecogActivity.this.aQ.removeCallbacks(LivenessRecogActivity.this.aR);
                    LivenessRecogActivity.this.showVideoDoneView();
                    LivenessRecogActivity.this.aL.c();
                    LivenessRecogActivity.this.aD.u = 15;
                }
            } else {
                LivenessRecogActivity.this.F.setVisibility(0);
                LivenessRecogActivity.this.a(0, 4, (String) LivenessRecogActivity.this.ba.get(size));
            }
            a aVar = LivenessRecogActivity.this.aE;
            aVar.n--;
        }
    };
    private boolean aV = true;
    private int aW = 15;
    private int aX = 5;
    private List<String> ba = new ArrayList();
    private boolean bc = false;
    private Runnable bk = new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (LivenessRecogActivity.this.aT == 2) {
                LivenessRecogActivity.this.aF.ag++;
                LivenessRecogActivity.this.aD.u = 5;
                LivenessRecogActivity.this.ax = 0;
            } else {
                LivenessRecogActivity.this.aF.ah++;
                LivenessRecogActivity.this.aD.u = 7;
                LivenessRecogActivity.this.ax = 5;
            }
            long currentTimeMillis = 20000 - (System.currentTimeMillis() - LivenessRecogActivity.this.aD.C);
            if (currentTimeMillis < TbConfig.NOTIFY_SOUND_INTERVAL) {
                LivenessRecogActivity.this.aD.D = 25000 - currentTimeMillis;
            }
        }
    };
    private View.OnClickListener bl = new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.re_video_container) {
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.aF.a();
                LivenessRecogActivity.this.J();
                LivenessRecogActivity.this.u();
            } else if (id == R.id.video_finish_container) {
                if (com.baidu.fsg.biometrics.base.d.h.h(LivenessRecogActivity.this)) {
                    LivenessRecogActivity.this.ah.setVisibility(8);
                    LivenessRecogActivity.this.ai.setVisibility(8);
                    LivenessRecogActivity.this.ag.setVisibility(0);
                    LivenessRecogActivity.this.aj.setVisibility(0);
                    LivenessRecogActivity.this.T();
                    return;
                }
                LivenessRecogActivity.this.x();
            } else if (id == R.id.ok_btn) {
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogActivity.this.A.a(LivenessRecogActivity.this.aq);
                }
                if (LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                LivenessRecogActivity.this.aF.aa = 0;
                LivenessRecogActivity.this.aF.af = 1;
                LivenessRecogActivity.this.a(true);
            }
        }
    };
    Camera.PreviewCallback a = new Camera.PreviewCallback() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.22
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (LivenessRecogActivity.this.bd != null) {
                LivenessRecogActivity.this.bd.a();
            }
            if (LivenessRecogActivity.this.aD.u != 0 && LivenessRecogActivity.this.aD.u != 10 && LivenessRecogActivity.this.aD.u != 14 && LivenessRecogActivity.this.aD.u != 17 && LivenessRecogActivity.this.aD.u != 15 && LivenessRecogActivity.this.aD.u != 16 && LivenessRecogActivity.this.aD.u != 19 && LivenessRecogActivity.this.aD.u != 18) {
                try {
                    if (LivenessRecogActivity.this.aJ <= 0) {
                        LivenessRecogActivity.this.bm = bArr;
                        LivenessRecogActivity.this.a(camera);
                        LivenessRecogActivity.this.aK = new b();
                        LivenessRecogActivity.this.aK.execute(new Void[0]);
                    }
                } catch (Throwable th) {
                    com.baidu.fsg.biometrics.base.d.c.a(th);
                }
            }
        }
    };
    private boolean bq = false;
    private int br = -1;

    static /* synthetic */ int Z(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.aJ + 1;
        livenessRecogActivity.aJ = i2;
        return i2;
    }

    static /* synthetic */ int ab(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.aJ - 1;
        livenessRecogActivity.aJ = i2;
        return i2;
    }

    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bh = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        if (this.livenessRecogDTO != null) {
            requestWindowFeature(1);
            getWindow().addFlags(67108864);
            getWindow().addFlags(128);
            this.aM = (ViewGroup) View.inflate(this, R.layout.layout_sapi_liveness_recognize, null);
            setContentView(this.aM);
            d();
            f();
            if (this.aU != null && this.livenessRecogDTO != null && this.aU.shouldRecogTextCustom(this.livenessRecogDTO.getSpno())) {
                this.O.setRecogTextViewTxt(this.aU.custom_verifytext);
            }
            if (!this.aV) {
                t();
                return;
            }
            a("0");
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        a.C0082a g2 = this.aL.g();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, g2.b, g2.a, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new String(Base64Utils.encode(byteArrayOutputStream.toByteArray()));
    }

    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, final String str) {
        byte[] encode;
        if (i2 == 5) {
            if (obj == null || !(obj instanceof UploadContrastPortraitModel)) {
                a("0", 0);
                a(-206, com.baidu.fsg.biometrics.base.c.a.ERROR_MSG_SERVER_ERROR, "");
                return;
            }
            final UploadContrastPortraitModel uploadContrastPortraitModel = (UploadContrastPortraitModel) obj;
            LogUtil.d("hello", "onEventEndWithValue(StatServiceEvent.FACEMATCH):  对比接口结束0   " + uploadContrastPortraitModel.contrastres);
            if (!uploadContrastPortraitModel.isContrastPass()) {
                this.aF.ak = 1;
            }
            this.aZ = uploadContrastPortraitModel.callbackkey;
            if (uploadContrastPortraitModel.isGotoRecordvideo()) {
                a(uploadContrastPortraitModel.isContrastPass() ? "1" : "0", 0);
                a("2");
                BeanManager.getInstance().removeAllBeans(c);
                this.O.clearAnim();
                this.aL.b();
                v();
            } else if (!uploadContrastPortraitModel.isTrustResult()) {
                a(uploadContrastPortraitModel.isContrastPass() ? "1" : "0", 0);
                BeanManager.getInstance().removeAllBeans(c);
                if (this.bd != null) {
                    this.bd.a(com.baidu.sapi2.biometrics.liveness.f.e);
                }
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.E.setVisibility(8);
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                if (this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(0);
                    livenessRecogResult.callbackkey = uploadContrastPortraitModel.callbackkey;
                    if (this.aP.size() > 0) {
                        livenessRecogResult.originalImage = a(this.aP.get(this.aP.size() - this.bf));
                    }
                    if (this.bi != null && (encode = Base64Utils.encode(this.bi)) != null) {
                        livenessRecogResult.faceimage = new String(encode);
                    }
                    if (this.bj != null) {
                        livenessRecogResult.imgdigests = new String(this.bj);
                    }
                    livenessRecogResult.authSid = uploadContrastPortraitModel.authsid;
                    this.A.a(livenessRecogResult);
                    if (this.aI) {
                        setActivityResult(-1);
                    }
                    this.aF.aa = 0;
                    a(true);
                }
            } else if (uploadContrastPortraitModel.isContrastPass()) {
                a(uploadContrastPortraitModel.isContrastPass() ? "1" : "0", 0);
                BeanManager.getInstance().removeAllBeans(c);
                if (this.bd != null) {
                    this.bd.a(com.baidu.sapi2.biometrics.liveness.f.e);
                }
                this.O.startRecogSuccessAnim(new ConstrastLoadingView.a() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.23
                    @Override // com.baidu.sapi2.biometrics.liveness.view.ConstrastLoadingView.a
                    public void a() {
                        byte[] encode2;
                        LivenessRecogActivity.this.B.setVisibility(8);
                        LivenessRecogActivity.this.C.setVisibility(8);
                        LivenessRecogActivity.this.E.setVisibility(8);
                        LivenessRecogActivity.this.H.setVisibility(8);
                        LivenessRecogActivity.this.I.setVisibility(8);
                        if (LivenessRecogActivity.this.A != null) {
                            LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                            livenessRecogResult2.setResultCode(0);
                            if (LivenessRecogActivity.this.bi != null && (encode2 = Base64Utils.encode(LivenessRecogActivity.this.bi)) != null) {
                                livenessRecogResult2.faceimage = new String(encode2);
                            }
                            if (LivenessRecogActivity.this.bj != null) {
                                livenessRecogResult2.imgdigests = new String(LivenessRecogActivity.this.bj);
                            }
                            if (LivenessRecogActivity.this.aP.size() > 0) {
                                livenessRecogResult2.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.aP.get(LivenessRecogActivity.this.aP.size() - LivenessRecogActivity.this.bf));
                            }
                            livenessRecogResult2.callbackkey = uploadContrastPortraitModel.callbackkey;
                            livenessRecogResult2.authSid = uploadContrastPortraitModel.authsid;
                            LivenessRecogActivity.this.A.a(livenessRecogResult2);
                            if (LivenessRecogActivity.this.aI) {
                                LivenessRecogActivity.this.setActivityResult(-1);
                            }
                            LivenessRecogActivity.this.aF.aa = 0;
                            LivenessRecogActivity.this.a(true);
                        }
                    }
                });
            } else {
                a("0", 0);
                a(-302, e.b.i, "");
            }
        } else if (i2 == 6) {
            X();
            if (obj != null && (obj instanceof GetRecordVedioQuestionModel)) {
                GetRecordVedioQuestionModel getRecordVedioQuestionModel = (GetRecordVedioQuestionModel) obj;
                if (TextUtils.isEmpty(getRecordVedioQuestionModel.callbackkey) || getRecordVedioQuestionModel.question == null || getRecordVedioQuestionModel.question.length == 0) {
                    b(com.baidu.fsg.biometrics.base.c.a.ERROR_MSG_SERVER_ERROR);
                    return;
                }
                this.aY = getRecordVedioQuestionModel.callbackkey;
                this.ba = Arrays.asList(getRecordVedioQuestionModel.question);
                this.aX = getRecordVedioQuestionModel.questiontime;
                r();
                return;
            }
            handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == 7) {
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.sapi2.biometrics.liveness.f.w, 0, arrayList);
            }
            this.aD.x = false;
            if (obj != null && (obj instanceof UploadVideoModel)) {
                UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
                if (!this.aD.y) {
                    this.aq = new LivenessRecogResult();
                    this.aq.callbackkey = uploadVideoModel.callbackkey;
                    this.aq.video = uploadVideoModel.video;
                    this.aq.setResultCode(0);
                    this.ag.showUpSucView();
                    I();
                }
            }
        } else if (i2 == 8) {
            if (TextUtils.isEmpty(str)) {
                a(-206, com.baidu.fsg.biometrics.base.c.a.ERROR_MSG_SERVER_ERROR, "");
                return;
            }
            BeanManager.getInstance().removeAllBeans(c);
            this.O.startRecogSuccessAnim(new ConstrastLoadingView.a() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.34
                @Override // com.baidu.sapi2.biometrics.liveness.view.ConstrastLoadingView.a
                public void a() {
                    byte[] encode2;
                    LivenessRecogActivity.this.B.setVisibility(8);
                    LivenessRecogActivity.this.C.setVisibility(8);
                    LivenessRecogActivity.this.E.setVisibility(8);
                    LivenessRecogActivity.this.H.setVisibility(8);
                    LivenessRecogActivity.this.I.setVisibility(8);
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                        livenessRecogResult2.setResultCode(0);
                        try {
                            livenessRecogResult2.extraJson = new JSONObject(str);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        if (LivenessRecogActivity.this.bi != null && (encode2 = Base64Utils.encode(LivenessRecogActivity.this.bi)) != null) {
                            livenessRecogResult2.faceimage = new String(encode2);
                        }
                        if (LivenessRecogActivity.this.bj != null) {
                            livenessRecogResult2.imgdigests = new String(LivenessRecogActivity.this.bj);
                        }
                        if (LivenessRecogActivity.this.aP.size() > 0) {
                            livenessRecogResult2.originalImage = LivenessRecogActivity.this.a((int[]) LivenessRecogActivity.this.aP.get(LivenessRecogActivity.this.aP.size() - LivenessRecogActivity.this.bf));
                        }
                        LivenessRecogActivity.this.A.a(livenessRecogResult2);
                        if (LivenessRecogActivity.this.aI) {
                            LivenessRecogActivity.this.setActivityResult(-1);
                        }
                        LivenessRecogActivity.this.aF.aa = 0;
                        LivenessRecogActivity.this.a(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 5) {
            a("0", i3);
            a(i3, str, "");
        } else if (i2 == 6) {
            X();
            b(str);
        } else if (i2 == 7) {
            if (this.livenessRecogDTO != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.livenessRecogDTO.getSpno() + "");
                arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                RimStatisticsUtil.onEventEndWithValues(com.baidu.sapi2.biometrics.liveness.f.w, i3, arrayList);
            }
            this.aD.x = false;
            if (!this.aD.y) {
                if (i3 == j) {
                    B();
                    return;
                }
                this.aF.af = 0;
                A();
            }
        } else if (i2 == 8) {
            a(i3, str, "");
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
            RimStatisticsUtil.onEventEndWithValues(com.baidu.sapi2.biometrics.liveness.f.o, i2, arrayList);
        }
    }

    private void a(int i2, String str, String str2) {
        LogUtil.d("hello", "onEventEndWithValue(StatServiceEvent.FACEMATCH):  对比接口结束" + i2 + "   ");
        if (this.bf == this.be) {
            BeanManager.getInstance().removeAllBeans(c);
            this.O.clearAnim();
            if (this.A != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                this.A.b(livenessRecogResult);
                setActivityResult(-1);
                this.aF.aa = livenessRecogResult.getResultCode();
                a(true);
                return;
            }
            return;
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            arrayList.add(str);
            RimStatisticsUtil.onEventWithValues(com.baidu.sapi2.biometrics.liveness.f.v, arrayList);
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bc) {
            this.bc = false;
            if (this.aD.z) {
                m();
                z();
                this.aD.z = false;
            } else if (!this.aD.F) {
                if (this.aD.u < 12) {
                    q();
                    m();
                } else if (this.aD.u == 18 || this.aD.u == 17) {
                    m();
                }
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bc = true;
        if (!this.aD.F) {
            this.ay.cancel();
            if (this.aD.u == 14) {
                this.aD.z = true;
                this.Q.clearAnimation();
                this.aL.e();
                this.T.clearAnimation();
                this.aQ.removeCallbacks(this.aR);
                return;
            }
            this.aL.d();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.bh);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(b);
        BeanManager.getInstance().removeAllBeans(c);
        this.aB = true;
        this.au = null;
        this.bm = null;
        this.aP.clear();
        this.aP = null;
        try {
            a();
            this.aM.removeView(this.V);
            this.V = null;
            a(this.aM);
            this.aM.removeCallbacks(null);
            this.aM = null;
            this.aC.removeCallbacksAndMessages(null);
            System.gc();
        } catch (Exception e2) {
            com.baidu.fsg.biometrics.base.d.c.a(e2);
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
        for (SoftReference<Bitmap> softReference : this.aO.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.m);
        LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
        if (this.A != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(com.baidu.fsg.biometrics.base.c.a.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.A.b(livenessRecogResult);
        }
    }

    private void c() {
        if (this.E != null) {
            this.E.clearAnimation();
        }
        if (this.D != null) {
            this.D.setImageBitmap(a(R.drawable.sapi_liveness_recog_face_failed));
        }
        this.aD = null;
        this.aE = null;
        this.aF = null;
        this.at = null;
    }

    private void d() {
        com.baidu.fsg.biometrics.base.d.d.b(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        this.B = (ImageView) findViewById(R.id.btn_cancel);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessRecogActivity.this.aD.x) {
                    LivenessRecogActivity.this.bb.a();
                    LivenessRecogActivity.this.y();
                    return;
                }
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.M = true;
                if (LivenessRecogActivity.this.aF.O == 0) {
                    LivenessRecogActivity.this.aF.N = 1;
                } else {
                    LivenessRecogActivity.this.aF.N = 2;
                }
                LivenessRecogActivity.this.aF.aa = -204;
                if (LivenessRecogActivity.this.aD.u == 14) {
                    LivenessRecogActivity.this.aF.O = 0;
                    LivenessRecogActivity.this.aF.N = 3;
                }
                if (LivenessRecogActivity.this.aD.u == 14) {
                    LivenessRecogActivity.this.aL.e();
                }
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
                LivenessRecogActivity.this.aL.d();
            }
        });
        this.C = (ImageView) findViewById(R.id.btn_switch_voice);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.aH = !LivenessRecogActivity.this.aH;
                if (LivenessRecogActivity.this.aH) {
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
        this.L = (ImageView) findViewById(R.id.iv_swiping_face_1);
        this.M = (ImageView) findViewById(R.id.iv_swiping_face_2);
        this.N = (ImageView) findViewById(R.id.iv_swiping_face_3);
        this.O = (ConstrastLoadingView) findViewById(R.id.constrastLoadingView);
        this.D = (ImageView) findViewById(R.id.img_face_recognized_state);
        this.D.setImageBitmap(a(R.drawable.sapi_liveness_recog_face_failed));
        this.E = (ImageView) findViewById(R.id.img_face_recognizing_anim);
        L();
        this.V = new CameraSurfaceView(this, null);
        this.aM.addView(this.V, 0, new ViewGroup.LayoutParams(-2, -1));
        this.aL = new com.baidu.sapi2.biometrics.liveness.camera.a();
        this.V.setCameraInterface(this.aL);
        this.V.setVisibility(4);
        this.af = (XfordView) findViewById(R.id.xfordview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        if (this.aT == 1) {
            this.ax = 0;
        } else {
            this.ax = 5;
        }
        return this.ax;
    }

    private void f() {
        this.aI = this.livenessRecogDTO.showGuidePage;
        this.aV = com.baidu.sapi2.biometrics.liveness.beans.b.a().a(getActivity()).getSwitchRecordVideo() && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS;
        this.aw = getResources().getStringArray(R.array.sapi_liveness_head_pose);
        this.aC = new Handler(Looper.getMainLooper(), this);
        this.aD = new d();
        this.aE = new a();
        this.aF = new f();
        this.ay = new g(TbConfig.NOTIFY_SOUND_INTERVAL, 200L);
        this.aF.Q = System.currentTimeMillis();
        this.aD.C = System.currentTimeMillis();
        this.bd = new com.baidu.sapi2.biometrics.liveness.c();
        this.bd.a = System.currentTimeMillis();
        this.A = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        g();
        this.ax = e();
        if (this.aV) {
            l();
        } else {
            i();
        }
    }

    private void g() {
        this.aU = com.baidu.sapi2.biometrics.liveness.beans.b.a().a(getActivity());
        if (this.aU == null) {
            this.aU = new GetFPResponse.LivenessConfig();
        }
        this.aS = this.aU.getRecogtimeInterval();
        this.aT = this.aU.getRecogActionType();
    }

    private void h() {
    }

    private void i() {
        try {
            j();
            k();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (!this.aI && this.A != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
                this.A.b(livenessRecogResult);
            }
            this.aF.aa = LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
            setActivityResult(0);
            a(this.aI ? false : true);
        }
    }

    private void j() throws Exception {
        if (!com.baidu.fsg.biometrics.base.b.d.a(this, 4, new Bundle())) {
            throw new Exception("load so failure");
        }
    }

    private void k() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty("frfsd_ai")) {
            throw new Exception("idlToken or apiKey is empty");
        }
        try {
            this.as = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
            this.as.set_isFineAlign(false);
            this.as.set_isVerifyLive(true);
            if (this.aU == null) {
                this.aU = new GetFPResponse.LivenessConfig();
            }
            this.as.set_min_face_size(this.aU.getMinFaceSize());
            this.as.set_illum_thr(this.aU.getIllumThr());
            this.as.set_track_by_detection_interval(this.aU.getTrackInterval());
            this.as.set_detect_in_video_interval(this.aU.getDetectInterval());
            this.as.set_eulur_angle_thr(this.aU.getYaw(), this.aU.getPitch(), this.aU.getRoll());
            this.as.set_max_reg_img_num(this.aU.getMaxRegImgNum(this.livenessRecogDTO.getSpno()));
            this.as.set_prefetch_reg_img_interval(this.aU.getPrefetchRegImgInterval());
            this.as.set_cropFaceSize(this.aU.getCropFaceSize());
            this.as.set_cropFaceEnlargeRatio(this.aU.getCropFaceRatio());
        } catch (Exception e2) {
            throw new Exception("init faceTracker failure: " + e2.getMessage());
        }
    }

    private void l() {
    }

    private boolean m() {
        this.V.setVisibility(4);
        boolean a2 = this.aL.a(this, 3);
        if (!a2) {
            E();
        } else {
            a(this.aL.g());
            this.aF.R = System.currentTimeMillis();
            this.aL.a(this.a);
            this.V.startPreview();
        }
        this.V.setVisibility(0);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera) {
        if (this.bn == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.aL.f()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.bn = previewSize.width;
            this.bo = previewSize.height;
            this.bp = cameraInfo.orientation;
        }
        if (this.az == null) {
            this.az = new int[2];
            this.az[0] = this.bo;
            this.az[1] = this.bn;
        }
        if (this.aU == null || TextUtils.isEmpty(this.aU.min_face_size)) {
            if (this.bn > 640 && this.bo > 480) {
                this.as.set_min_face_size(200);
            } else {
                this.as.set_min_face_size(100);
            }
        }
        if (this.bd != null && this.bd.b == 0) {
            this.bd.c = this.bo;
            this.bd.b = this.bn;
            this.bd.a(com.baidu.sapi2.biometrics.liveness.f.r);
        }
        if (this.au == null) {
            this.au = new int[this.bn * this.bo];
        }
    }

    private void a(a.C0082a c0082a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.V.getLayoutParams());
        a.C0082a b2 = b(c0082a);
        if (b2 == null || (b2.a == c0082a.a && b2.b == c0082a.b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = b2.a;
            layoutParams.height = b2.b;
        }
        this.V.setLayoutParams(layoutParams);
    }

    private void n() {
        if (!this.bh && this.livenessRecogDTO != null) {
            this.bh = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            LogUtil.d("hello", "相机准备好实时埋点");
            RimStatisticsUtil.onEventWithValues(com.baidu.sapi2.biometrics.liveness.f.u, arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("processid", this.livenessRecogDTO.processid);
                if (!TextUtils.isEmpty(this.livenessRecogDTO.getCertInfo())) {
                    jSONObject.put(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_CERTINFO, this.livenessRecogDTO.getCertInfo());
                }
                if (!TextUtils.isEmpty(this.livenessRecogDTO.authToken)) {
                    jSONObject.put(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN, this.livenessRecogDTO.authToken);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            BdWalletUtils.realTimeStatistics(getActivity().getApplicationContext(), this.livenessRecogDTO.spParams, this.livenessRecogDTO.getAtbc(), com.baidu.sapi2.biometrics.liveness.f.u, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.I.setVisibility(4);
        this.z = -1;
        this.H.setText(R.string.sapi_liveness_put_face_round);
        if (this.D != null) {
            this.D.setImageBitmap(a(R.drawable.sapi_liveness_recog_face_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.I.setVisibility(4);
        this.H.setVisibility(4);
        this.z = -1;
        if (this.D != null) {
            this.D.setImageBitmap(a(R.drawable.sapi_liveness_recog_face_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.aD.C = System.currentTimeMillis();
        if (!this.aV) {
            a(0, 0, (String) null);
            this.ay.start();
        }
    }

    private void r() {
        this.aF.ad = 2;
        this.aE.n = this.ba.size() * (this.aX + 1);
        this.aW = this.aE.n;
        this.H.setVisibility(4);
        P();
        this.aL.b();
    }

    private a.C0082a b(a.C0082a c0082a) {
        if (c0082a == null) {
            return null;
        }
        a.C0082a s2 = s();
        a.C0082a c0082a2 = new a.C0082a(c0082a.a, c0082a.b);
        float f2 = c0082a.a / c0082a.b;
        float f3 = s2.b / s2.a;
        if (Math.abs(f2 - f3) > 0.02d) {
            if (f2 < f3) {
                c0082a2.a = (s2.b * c0082a.b) / c0082a.a;
                c0082a2.b = s2.b;
                return c0082a2;
            }
            c0082a2.a = s2.a;
            c0082a2.b = (s2.a * c0082a.a) / c0082a.b;
            return c0082a2;
        }
        return c0082a2;
    }

    private a.C0082a s() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new a.C0082a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + com.baidu.fsg.biometrics.base.d.d.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.CAMERA") != 0) {
            this.aD.F = true;
            requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
            return;
        }
        q();
        if (m()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.aD.u = 12;
        this.C.setVisibility(4);
        this.I.setVisibility(4);
        this.F.setVisibility(4);
        if ((Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.RECORD_AUDIO") != 0) || (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.CAMERA") != 0)) {
            this.aD.F = true;
            requestPermissions(new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"}, 2004);
            return;
        }
        this.aD.u = 14;
        if (this.ac != null && this.ac.isShowing()) {
            this.ac.dismiss();
        }
        if (m()) {
            getRecordVideoQuestions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.aD.u = 18;
        this.aC.removeCallbacks(this.bk);
        this.aF.P++;
        this.ac = new RecordVideoTipDialog(this);
        this.ac.setMenuItemClickListener(new RecordVideoTipDialog.a() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.38
            @Override // com.baidu.sapi2.biometrics.liveness.view.RecordVideoTipDialog.a
            public void a() {
                LivenessRecogActivity.this.aD.u = 1;
                LivenessRecogActivity.this.t();
                LivenessRecogActivity.this.at = null;
                LivenessRecogActivity.this.aE.l = false;
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aE.j = false;
                LivenessRecogActivity.this.aE.k = false;
                LivenessRecogActivity.this.aF.b();
                LivenessRecogActivity.this.aF.ak = 0;
                LivenessRecogActivity.this.aF.aj = 0;
                LivenessRecogActivity.this.ax = LivenessRecogActivity.this.e();
                LivenessRecogActivity.this.aF.S = System.currentTimeMillis();
                LivenessRecogActivity.this.aD.C = System.currentTimeMillis();
                LivenessRecogActivity.this.ac.dismiss();
            }

            @Override // com.baidu.sapi2.biometrics.liveness.view.RecordVideoTipDialog.a
            public void b() {
                LivenessRecogActivity.this.aF.aj = 1;
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.u();
                LivenessRecogActivity.this.ac.dismiss();
            }

            @Override // com.baidu.sapi2.biometrics.liveness.view.RecordVideoTipDialog.a
            public void c() {
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.ak = 0;
                LivenessRecogActivity.this.aF.aj = 0;
                LivenessRecogActivity.this.aF.M = true;
                LivenessRecogActivity.this.aF.N = 3;
                LivenessRecogActivity.this.aF.aa = -204;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
                LivenessRecogActivity.this.ac.dismiss();
            }
        });
        this.ac.setCancelable(false);
        if (!isFinishing() && !this.ac.isShowing()) {
            this.ac.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.aD.u = 17;
        this.aC.removeCallbacks(this.bk);
        this.aF.O = 1;
        this.aF.ae++;
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_liveness_dialog_recognized_time_out_title));
        bioAlertDialog.setTimeOutVisible(0);
        bioAlertDialog.setMessageText(getString(R.string.sapi_liveness_dialog_recognized_time_out_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_dialog_recognized_fail_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.39
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.aF.b();
                LivenessRecogActivity.this.o();
                LivenessRecogActivity.this.aD.u = 1;
                LivenessRecogActivity.this.q();
                LivenessRecogActivity.this.ax = LivenessRecogActivity.this.e();
                LivenessRecogActivity.this.aF.S = System.currentTimeMillis();
                LivenessRecogActivity.this.aE.j = false;
                LivenessRecogActivity.this.aE.k = false;
                LivenessRecogActivity.this.aD.C = System.currentTimeMillis();
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_biometric_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.M = true;
                LivenessRecogActivity.this.aF.N = 1;
                LivenessRecogActivity.this.aL.d();
                LivenessRecogActivity.this.aF.aa = -204;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
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
        bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_liveness_record_video_moible_network_tip), R()));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_record_video_moible_network_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.ah.setVisibility(8);
                LivenessRecogActivity.this.ai.setVisibility(8);
                LivenessRecogActivity.this.ag.setVisibility(0);
                LivenessRecogActivity.this.aj.setVisibility(0);
                LivenessRecogActivity.this.T();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.3
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

    private void b(String str) {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_alert_dialog_default_msg_text));
        bioAlertDialog.setDialogMsg(str);
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_try_again), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.getRecordVideoQuestions();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.M = true;
                LivenessRecogActivity.this.aF.N = 3;
                LivenessRecogActivity.this.aF.aa = -204;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.ad == null) {
            this.ad = new BioAlertDialog(this);
            this.ad.setTitleMsg(getString(R.string.sapi_alert_dialog_default_msg_text));
            this.ad.setDialogMsg(getString(R.string.sapi_liveness_record_up_interrupt));
            this.ad.setPositiveBtn(getString(R.string.sapi_liveness_record_up_interrupt_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.aD.y = false;
                    LivenessRecogActivity.this.ad.dismiss();
                    LivenessRecogActivity.this.T();
                }
            });
            this.ad.setNegativeBtn(getString(R.string.sapi_liveness_record_up_interrupt_btn_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.aD.y = false;
                    LivenessRecogActivity.this.ag.dynamicWaveView.stopAnim();
                    LivenessRecogActivity.this.ad.dismiss();
                    if (!LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.b();
                    }
                    LivenessRecogActivity.this.aF.M = true;
                    LivenessRecogActivity.this.aF.N = 3;
                    LivenessRecogActivity.this.aF.aa = -204;
                    LivenessRecogActivity.this.setActivityResult(0);
                    LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
                }
            });
            this.ad.setCancelable(false);
        }
        if (!isFinishing() && !this.ad.isShowing()) {
            this.aD.y = true;
            this.ad.show();
        }
    }

    private void z() {
        if (this.ae == null) {
            this.ae = new BioAlertDialog(this);
            this.ae.setTitleMsg(getString(R.string.sapi_liveness_record_video_fail_dialog_title));
            this.ae.setPositiveBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.p();
                    LivenessRecogActivity.this.aF.a();
                    LivenessRecogActivity.this.ae.dismiss();
                    LivenessRecogActivity.this.u();
                }
            });
            this.ae.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.ae.dismiss();
                    if (!LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.b();
                    }
                    LivenessRecogActivity.this.aF.M = true;
                    LivenessRecogActivity.this.aF.N = 3;
                    LivenessRecogActivity.this.aF.aa = -204;
                    LivenessRecogActivity.this.setActivityResult(0);
                    LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
                }
            });
            this.ae.setCancelable(false);
        }
        if (!isFinishing() && !this.ae.isShowing()) {
            this.ae.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_reupload), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.T();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.M = true;
                LivenessRecogActivity.this.aF.N = 3;
                LivenessRecogActivity.this.aF.aa = -204;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.sapi_liveness_record_video_title_upload_timeout));
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_up_time_out_tip));
        bioAlertDialog.setPositiveBtn(getString(R.string.sapi_liveness_record_video_record_again), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.J();
                LivenessRecogActivity.this.p();
                LivenessRecogActivity.this.aF.a();
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.u();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (!LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.b();
                }
                LivenessRecogActivity.this.aF.M = true;
                LivenessRecogActivity.this.aF.N = 3;
                LivenessRecogActivity.this.aF.aa = -204;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.a(LivenessRecogActivity.this.aI ? false : true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.aD.u = 17;
        this.aC.removeCallbacks(this.bk);
        this.aF.ae++;
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_recog_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.setActivityResult(-1);
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-301);
                    LivenessRecogActivity.this.A.b(livenessRecogResult);
                }
                LivenessRecogActivity.this.aF.aa = -301;
                LivenessRecogActivity.this.a(true);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void D() {
        this.aD.F = true;
        if (this.Y == null) {
            this.Y = new BioAlertDialog(this);
            this.Y.setTitleMsg(getString(R.string.sapi_permission_request));
            this.Y.setTitleVisible(true);
            this.Y.setDialogMsg(String.format(getString(R.string.sapi_liveness_permission_camera), com.baidu.fsg.biometrics.base.d.h.d(this)));
            this.Y.setBtnCount(1);
            this.Y.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Y.dismiss();
                    LivenessRecogActivity.this.aD.F = false;
                    if (LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.aF.aa = LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.Y.setCancelable(false);
        if (!isFinishing() && !this.Y.isShowing()) {
            this.Y.show();
        }
    }

    private void E() {
        this.aD.u = 19;
        if (this.Z == null) {
            this.Z = new BioAlertDialog(this);
            this.Z.setTitleVisible(true);
            this.Z.setDialogMsg(getString(R.string.sapi_liveness_open_camera_no_permission));
            this.Z.setBtnCount(1);
            this.Z.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.Z.dismiss();
                    if (LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.aF.aa = LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
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
    public void F() {
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleVisible(true);
        bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_no_audio_permission));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                if (LivenessRecogActivity.this.aI) {
                    LivenessRecogActivity.this.setActivityResult(-1);
                }
                if (LivenessRecogActivity.this.A != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                    LivenessRecogActivity.this.A.b(livenessRecogResult);
                }
                LivenessRecogActivity.this.aF.aa = LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
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
            this.aa.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.aa.dismiss();
                    if (LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.aF.aa = LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        this.aa.setCancelable(false);
        if (!isFinishing() && !this.aa.isShowing()) {
            this.aa.show();
        }
    }

    private void G() {
        if (this.ab == null) {
            this.ab = new BioAlertDialog(this);
            this.ab.setTitleVisible(true);
            this.ab.setDialogMsg(getString(R.string.sapi_liveness_video_record_failed));
            this.ab.setBtnCount(1);
            this.ab.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.ab.dismiss();
                    if (LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    if (LivenessRecogActivity.this.A != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(-304);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    LivenessRecogActivity.this.aF.aa = -304;
                    LivenessRecogActivity.this.a(true);
                }
            });
        }
        if (!isFinishing() && !this.ab.isShowing()) {
            this.ab.show();
        }
    }

    private boolean H() {
        this.aD.u = 14;
        if (this.aL.b(this)) {
            return true;
        }
        F();
        return false;
    }

    public void showVideoDoneView() {
        if (this.ap == null) {
            View inflate = ((ViewStub) findViewById(R.id.view_stup_upload_video)).inflate();
            this.ap = inflate.findViewById(R.id.view_stub_container);
            this.ao = inflate.findViewById(R.id.upload_video_container);
            this.ag = (UploadingFileView) inflate.findViewById(R.id.uploading_file_view);
            this.aj = inflate.findViewById(R.id.uploading_tv);
            this.ak = inflate.findViewById(R.id.uploading_success_tv);
            this.al = inflate.findViewById(R.id.uploading_success_prompt_tv);
            this.am = inflate.findViewById(R.id.ok_btn);
            this.ah = inflate.findViewById(R.id.re_video_container);
            this.ai = inflate.findViewById(R.id.video_finish_container);
            this.W = (ImageView) inflate.findViewById(R.id.img_canvas_view);
            this.an = (RelativeLayout) inflate.findViewById(R.id.blurring_view_container);
            this.ah.setOnClickListener(this.bl);
            this.ai.setOnClickListener(this.bl);
            this.am.setOnClickListener(this.bl);
        } else if (this.ap.getVisibility() != 0) {
            this.ap.setVisibility(0);
        }
        this.af.setVisibility(8);
        this.D.setVisibility(8);
        this.H.setVisibility(8);
        this.U.setVisibility(8);
        this.T.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 10) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(com.baidu.fsg.biometrics.base.d.f.a(this) + File.separator + com.baidu.fsg.biometrics.base.d.f.b);
            this.W.setImageBitmap(mediaMetadataRetriever.getFrameAtTime(3000000L));
            if (Build.VERSION.SDK_INT >= 17) {
                BlurringView blurringView = new BlurringView(this);
                blurringView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.an.addView(blurringView);
                blurringView.setBlurredView(this.W);
                blurringView.invalidate();
                return;
            }
            this.ao.setBackgroundResource(R.drawable.sapi_liveness_record_video_done_mask);
            return;
        }
        this.ao.setBackgroundResource(R.drawable.sapi_liveness_record_video_done_mask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        this.B.setVisibility(8);
        this.aj.setVisibility(8);
        this.ak.setVisibility(0);
        this.al.setVisibility(0);
        this.am.setVisibility(0);
        this.ak.startAnimation(alphaAnimation);
        this.al.startAnimation(alphaAnimation);
        this.am.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.ah.setVisibility(0);
        this.ai.setVisibility(0);
        this.af.setVisibility(0);
        this.D.setVisibility(0);
        this.U.setVisibility(0);
        this.T.setVisibility(0);
        this.ap.setVisibility(8);
        this.ag.setVisibility(8);
        this.aj.setVisibility(8);
        this.ak.setVisibility(8);
        this.al.setVisibility(8);
        this.am.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.bm != null && this.au != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                FaceSDK.getARGBFromYUVimg(this.bm, this.au, this.bn, this.bo, this.bp, 1);
                long currentTimeMillis2 = System.currentTimeMillis();
                long currentTimeMillis3 = System.currentTimeMillis();
                this.aA = this.as.face_verification(this.au, this.bn, this.bo, FaceSDK.ImgType.ARGB, av, "", "", "");
                this.at = this.as.get_TrackedFaceInfo();
                int i2 = 0;
                if (this.at != null && this.at.length > 0 && this.at[0] != null) {
                    i2 = this.at[0].face_id;
                }
                if (i2 != 0 && i2 != this.br) {
                    this.aP.clear();
                }
                this.br = i2;
                if (this.aA == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    if (this.bq) {
                        this.aP.clear();
                        this.bq = false;
                    }
                    this.aP.add(this.au);
                } else if (this.aA == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    this.aP.add(this.au);
                    this.bq = true;
                }
                this.bm = null;
                this.au = null;
                if (this.bd != null) {
                    this.bd.a(this.aA);
                }
                LogUtil.d("hello", this.aA == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE ? "PITCH_OUT_OF_RANGE" : "eeee");
                long currentTimeMillis4 = System.currentTimeMillis();
                long currentTimeMillis5 = System.currentTimeMillis();
                h hVar = new h();
                hVar.b = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                if (this.bd != null) {
                    this.bd.a(currentTimeMillis6);
                }
                if (this.aD.u == 1) {
                    this.aF.an.add(Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    this.aF.ao.add(Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
                    this.aF.ap.add(Long.valueOf(currentTimeMillis5 - currentTimeMillis4));
                    this.aF.al.add(Long.valueOf(hVar.b));
                } else if (this.aD.u == 6) {
                    this.aF.an.add(Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    this.aF.ao.add(Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
                    this.aF.ap.add(Long.valueOf(currentTimeMillis5 - currentTimeMillis4));
                    this.aF.am.add(Long.valueOf(hVar.b));
                    if (this.bd != null) {
                        this.bd.b(currentTimeMillis6);
                    }
                }
            } catch (Throwable th) {
                com.baidu.fsg.biometrics.base.d.c.a(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends AsyncTask<Void, Void, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.Z(LivenessRecogActivity.this);
            LivenessRecogActivity.this.K();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.ab(LivenessRecogActivity.this);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends CountDownTimer {
        public g(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FaceInfo[] faceInfoArr = LivenessRecogActivity.this.at;
            if (System.currentTimeMillis() - LivenessRecogActivity.this.aD.C > LivenessRecogActivity.this.aD.D && LivenessRecogActivity.this.aD.C > 0 && LivenessRecogActivity.this.aD.u != 10 && LivenessRecogActivity.this.aD.u != 17 && LivenessRecogActivity.this.aD.u != 19 && LivenessRecogActivity.this.aD.u != 18 && LivenessRecogActivity.this.aD.u != 14 && LivenessRecogActivity.this.aD.u != 15 && LivenessRecogActivity.this.aD.u != 16) {
                LivenessRecogActivity.this.aD.C = 0L;
                if (!LivenessRecogActivity.this.aD.E) {
                    RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.k);
                    LogUtil.d("hello", "onEvent(StatServiceEvent.FIRSTTIMEOUT):  一次超时");
                    LivenessRecogActivity.this.w();
                    LivenessRecogActivity.this.aD.E = true;
                } else {
                    RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.l);
                    LogUtil.d("hello", "onEvent(StatServiceEvent.SECONDTIMEOUT):  两次超时");
                    if (LivenessRecogActivity.this.aU == null || LivenessRecogActivity.this.livenessRecogDTO == null || LivenessRecogActivity.this.livenessRecogDTO.livenessType != LivenessRecogType.RECOG_TYPE_BDUSS || !LivenessRecogActivity.this.aU.shouldRecordVideo(LivenessRecogActivity.this.livenessRecogDTO.getSpno())) {
                        LivenessRecogActivity.this.C();
                    } else {
                        LivenessRecogActivity.this.a("1");
                        LivenessRecogActivity.this.v();
                        LivenessRecogActivity.this.aF.aj = 1;
                    }
                }
            }
            if (LivenessRecogActivity.this.aD.u != 0 && LivenessRecogActivity.this.aD.u != 17 && LivenessRecogActivity.this.aD.u != 19 && LivenessRecogActivity.this.aD.u != 18 && LivenessRecogActivity.this.aD.u != 14 && LivenessRecogActivity.this.aD.u != 15 && LivenessRecogActivity.this.aD.u != 16) {
                if (LivenessRecogActivity.this.c(faceInfoArr)) {
                    if (!LivenessRecogActivity.this.d(faceInfoArr) || !com.baidu.fsg.biometrics.base.d.h.c(faceInfoArr[0].landmarks, LivenessRecogActivity.this.az) || (LivenessRecogActivity.this.aD.u != 1 && LivenessRecogActivity.this.aD.u != 6 && LivenessRecogActivity.this.aD.u != 8 && LivenessRecogActivity.this.aD.u != 9)) {
                        if (!LivenessRecogActivity.this.d(faceInfoArr) || !com.baidu.fsg.biometrics.base.d.h.b(faceInfoArr[0].landmarks, LivenessRecogActivity.this.az) || (LivenessRecogActivity.this.aD.u != 1 && LivenessRecogActivity.this.aD.u != 6 && LivenessRecogActivity.this.aD.u != 8 && LivenessRecogActivity.this.aD.u != 9)) {
                            if (LivenessRecogActivity.this.aA != FaceTracker.ErrCode.POOR_ILLUMINATION || (LivenessRecogActivity.this.aD.u != 1 && LivenessRecogActivity.this.aD.u != 6 && LivenessRecogActivity.this.aD.u != 8 && LivenessRecogActivity.this.aD.u != 9)) {
                                if (!LivenessRecogActivity.this.b(faceInfoArr[0], LivenessRecogActivity.this.aA) || (LivenessRecogActivity.this.aD.u != 1 && LivenessRecogActivity.this.aD.u != 6 && LivenessRecogActivity.this.aD.u != 8 && LivenessRecogActivity.this.aD.u != 9)) {
                                    LivenessRecogActivity.this.z = -1;
                                    LivenessRecogActivity.this.I.setVisibility(8);
                                } else {
                                    LivenessRecogActivity.this.b(4);
                                    return;
                                }
                            } else {
                                LivenessRecogActivity.this.b(2);
                                return;
                            }
                        } else {
                            LivenessRecogActivity.this.b(0);
                            return;
                        }
                    } else {
                        LivenessRecogActivity.this.b(1);
                        return;
                    }
                } else if (LivenessRecogActivity.this.aD.u == 1) {
                    LivenessRecogActivity.this.z = -1;
                    LivenessRecogActivity.this.I.setVisibility(8);
                }
                if (LivenessRecogActivity.this.aD.u == 1 || LivenessRecogActivity.this.aD.u == 4) {
                    if (!LivenessRecogActivity.this.d(faceInfoArr) || LivenessRecogActivity.this.aD.u != 1) {
                        if (LivenessRecogActivity.this.d(faceInfoArr) || LivenessRecogActivity.this.aD.u != 1) {
                            if (!LivenessRecogActivity.this.d(faceInfoArr) && LivenessRecogActivity.this.aD.u == 4) {
                                LivenessRecogActivity.this.aD.u = 1;
                                LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.a(R.drawable.sapi_liveness_recog_face_failed));
                                LivenessRecogActivity.this.aD.v = false;
                                LivenessRecogActivity.this.aF.S = System.currentTimeMillis();
                                LivenessRecogActivity.this.aF.U = System.currentTimeMillis();
                                LivenessRecogActivity.this.aF.W = System.currentTimeMillis();
                                LivenessRecogActivity.this.aF.T = 0L;
                                LivenessRecogActivity.this.aF.V = 0L;
                                LivenessRecogActivity.this.aF.X = 0L;
                                LivenessRecogActivity.this.aF.ab = 0;
                                return;
                            }
                        } else {
                            LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.a(R.drawable.sapi_liveness_recog_face_failed));
                            LivenessRecogActivity.this.aD.v = false;
                            return;
                        }
                    } else {
                        LivenessRecogActivity.this.aF.T = System.currentTimeMillis();
                        LivenessRecogActivity.this.aD.u = 2;
                        RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.f);
                        LogUtil.d("hello", "onEvent(StatServiceEvent.FACEDETECTED):  监测到人脸");
                    }
                }
                if (LivenessRecogActivity.this.aD.u == 4) {
                    if (LivenessRecogActivity.this.b(faceInfoArr)) {
                        if (LivenessRecogActivity.this.aT == 1) {
                            LivenessRecogActivity.this.aF.ag++;
                            LivenessRecogActivity.this.aD.u = 5;
                        } else {
                            LivenessRecogActivity.this.aF.ah++;
                            LivenessRecogActivity.this.aD.u = 7;
                        }
                        long j2 = LivenessRecogActivity.this.aS * 1000;
                        if (j2 < 20000) {
                            LivenessRecogActivity.this.aC.postDelayed(LivenessRecogActivity.this.bk, j2);
                        }
                    } else {
                        LivenessRecogActivity.this.aD.u = 1;
                        LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.a(R.drawable.sapi_liveness_recog_face_failed));
                        LivenessRecogActivity.this.aD.v = false;
                    }
                }
                if (LivenessRecogActivity.this.aD.u == 2 && !LivenessRecogActivity.this.aD.v) {
                    LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.a(R.drawable.sapi_liveness_recog_face_successed));
                    LivenessRecogActivity.this.aG = System.currentTimeMillis();
                    LivenessRecogActivity.this.aD.v = true;
                }
                if (LivenessRecogActivity.this.c(faceInfoArr) && LivenessRecogActivity.this.aD.u == 11) {
                    LivenessRecogActivity.this.aD.u = 1;
                }
                if ((faceInfoArr == null || faceInfoArr.length == 0) && (LivenessRecogActivity.this.aD.u == 6 || LivenessRecogActivity.this.aD.u == 8 || LivenessRecogActivity.this.aD.u == 9)) {
                    LivenessRecogActivity.this.b(3);
                    LivenessRecogActivity.this.aD.w = false;
                    LivenessRecogActivity.this.aF.U = System.currentTimeMillis();
                    LivenessRecogActivity.this.aF.V = 0L;
                    LivenessRecogActivity.this.aF.W = System.currentTimeMillis();
                    LivenessRecogActivity.this.aF.X = 0L;
                    LivenessRecogActivity.this.aF.S = System.currentTimeMillis();
                    LivenessRecogActivity.this.aF.T = 0L;
                    LivenessRecogActivity.this.aF.ab = 0;
                }
                if (LivenessRecogActivity.this.d(faceInfoArr) && LivenessRecogActivity.this.aD.u == 6 && !LivenessRecogActivity.this.aD.w && LivenessRecogActivity.this.aF.T == 0) {
                    LivenessRecogActivity.this.aF.T = System.currentTimeMillis();
                    LivenessRecogActivity.this.aD.w = true;
                }
                if (LivenessRecogActivity.this.aD.u != 2 || !LivenessRecogActivity.this.a(300L)) {
                    if (LivenessRecogActivity.this.aD.u == 5) {
                        if (LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aE.j) {
                            RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.g);
                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWBLINK):  提示眨眨眼");
                            LivenessRecogActivity.this.a(0, 1, (String) null);
                            LivenessRecogActivity.this.aE.j = true;
                        }
                    } else if (LivenessRecogActivity.this.aD.u == 7 && LivenessRecogActivity.this.d(faceInfoArr) && !LivenessRecogActivity.this.aE.k) {
                        RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.i);
                        LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWMOUTH):  提示张张嘴");
                        LivenessRecogActivity.this.a(0, 3, (String) null);
                        LivenessRecogActivity.this.aE.k = true;
                    }
                    if ((LivenessRecogActivity.this.aD.u == 6 || LivenessRecogActivity.this.aD.u == 8) && LivenessRecogActivity.this.aD.u != 10 && LivenessRecogActivity.this.aD.u != 9) {
                        LivenessRecogActivity.this.a(faceInfoArr);
                    }
                    LivenessRecogActivity.this.aF.ai = LivenessRecogActivity.this.aA != null ? LivenessRecogActivity.this.aA.ordinal() : 0;
                    if (LivenessRecogActivity.this.c(faceInfoArr) && !LivenessRecogActivity.this.aB && LivenessRecogActivity.this.aD.u == 9 && LivenessRecogActivity.this.aA == FaceTracker.ErrCode.OK) {
                        FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.as.get_FaceVerifyData(0);
                        RimStatisticsUtil.onEventWithValue(com.baidu.sapi2.biometrics.liveness.f.n, faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0");
                        LogUtil.d("hello", "onEventWithValue(StatServiceEvent.RETRIEVEDIMAGE):  获取到活体图片的数量  " + (faceVerifyDataArr != null ? faceVerifyDataArr.length + "" : "0"));
                        LivenessRecogActivity.this.aF.Y = 1;
                        if (LivenessRecogActivity.this.a(faceInfoArr[0], LivenessRecogActivity.this.aA) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                            LivenessRecogActivity.this.aD.u = 10;
                            LivenessRecogActivity.this.aC.removeCallbacks(LivenessRecogActivity.this.bk);
                            LivenessRecogActivity.this.ay.cancel();
                            LivenessRecogActivity.this.aL.c();
                            LivenessRecogActivity.this.N();
                            LivenessRecogActivity.this.b(LivenessRecogActivity.this.a(faceVerifyDataArr));
                            return;
                        }
                        return;
                    }
                    return;
                }
                LivenessRecogActivity.this.M();
                LivenessRecogActivity.this.aG = System.currentTimeMillis();
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!LivenessRecogActivity.this.aB) {
                LivenessRecogActivity.this.ay.start();
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

    private void L() {
        this.aN = new AnimationDrawable();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(a(R.drawable.sapi_liveness_face_recognizing_anim2));
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(a(R.drawable.sapi_liveness_face_recognizing_anim3));
        this.aN.addFrame(bitmapDrawable, 80);
        this.aN.addFrame(bitmapDrawable2, 80);
        this.aN.setOneShot(false);
        this.E.setImageDrawable(this.aN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(int i2) {
        Bitmap bitmap;
        if (!this.aO.containsKey(Integer.valueOf(i2)) || this.aO.get(Integer.valueOf(i2)) == null || (bitmap = this.aO.get(Integer.valueOf(i2)).get()) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i2, options);
            options.inSampleSize = com.baidu.fsg.biometrics.base.d.h.a(options, dimensionPixelSize2, dimensionPixelSize);
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
            this.aO.put(Integer.valueOf(i2), new SoftReference<>(decodeResource));
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
        if ((this.aD.u == 6 || this.aD.u == 8) && this.aD.u != 9) {
            switch (this.ax) {
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
                if (this.ax == 0) {
                    this.aF.V = System.currentTimeMillis();
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTBLINK):  检测到眨眼");
                    RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.h);
                } else if (this.ax == 5) {
                    this.aF.X = System.currentTimeMillis();
                    RimStatisticsUtil.onEvent(com.baidu.sapi2.biometrics.liveness.f.j);
                    LogUtil.d("hello", "onEvent(StatServiceEvent.DETECTMOUTH):  检测到张嘴");
                }
                this.aD.u = 9;
                if (this.aF.O == 0) {
                    this.aF.ab = 1;
                } else if (this.aF.O >= 1) {
                    this.aF.ab = 2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        return faceInfoArr == null || faceInfoArr.length <= 0 || !(com.baidu.fsg.biometrics.base.d.h.b(faceInfoArr[0].landmarks, this.az) || com.baidu.fsg.biometrics.base.d.h.c(faceInfoArr[0].landmarks, this.az));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && com.baidu.fsg.biometrics.base.d.h.a(faceInfoArr[0].landmarks, this.az);
    }

    private com.baidu.sapi2.biometrics.liveness.camera.b a(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.aL.f()) {
            Camera.getCameraInfo(1, cameraInfo);
        } else {
            Camera.getCameraInfo(0, cameraInfo);
        }
        return new com.baidu.sapi2.biometrics.liveness.camera.b(bArr, previewSize.width, previewSize.height, cameraInfo.orientation, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        return faceInfo != null && this.aA == FaceTracker.ErrCode.OK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, final int i3, final String str) {
        this.G.clearAnimation();
        this.F.clearAnimation();
        a(i3, str);
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
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.24
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.24.1
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
            this.F.startAnimation(loadAnimation);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_midd_to_top);
        this.F.startAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.25
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LivenessRecogActivity.this.aD.u == 0) {
                    LivenessRecogActivity.this.aF.S = System.currentTimeMillis();
                    LivenessRecogActivity.this.aD.u = 1;
                } else if (LivenessRecogActivity.this.aD.u == 5) {
                    LivenessRecogActivity.this.aF.U = System.currentTimeMillis();
                    LivenessRecogActivity.this.aD.u = 6;
                } else if (LivenessRecogActivity.this.aD.u == 7) {
                    LivenessRecogActivity.this.aF.W = System.currentTimeMillis();
                    LivenessRecogActivity.this.aD.u = 8;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.G.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_alpha_midd_to_top));
        this.H.setVisibility(0);
    }

    private void a(int i2, String str) {
        if (i2 == 0) {
            this.H.setText(R.string.sapi_liveness_put_face_round);
        } else if (i2 == 1) {
            this.H.setText(this.aw[this.ax]);
        } else if (i2 == 2) {
            this.H.setText(this.aw[this.ax]);
        } else if (i2 == 3) {
            this.H.setText(this.aw[this.ax]);
        } else if (i2 == 4) {
            this.H.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
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
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.26
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
            if (!this.aE.i) {
                this.J.startAnimation(loadAnimation);
                this.aE.i = true;
            }
        }
        this.z = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.aD.u = 3;
        this.E.setVisibility(0);
        d(4);
        this.aN.start();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.27
            @Override // java.lang.Runnable
            public void run() {
                LivenessRecogActivity.this.aN.stop();
                LivenessRecogActivity.this.D.setImageBitmap(LivenessRecogActivity.this.a(R.drawable.sapi_liveness_recog_face_successed));
                LivenessRecogActivity.this.E.setVisibility(8);
                LivenessRecogActivity.this.aD.u = 4;
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (!this.aE.l) {
            d(5);
            this.aE.l = true;
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.N.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_swiping_face_top_2_bottom);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_swiping_face_middle_2_top);
            this.L.startAnimation(loadAnimation);
            this.M.startAnimation(loadAnimation2);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.28
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.O();
                    LivenessRecogActivity.this.O.setVisible(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.L.clearAnimation();
        this.M.clearAnimation();
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void P() {
        this.aE.m = 0;
        if (this.P == null) {
            View inflate = ((ViewStub) findViewById(R.id.ll_video_tip_view_stub)).inflate();
            this.P = (RelativeLayout) inflate.findViewById(R.id.ll_video_tip);
            this.Q = (ImageView) inflate.findViewById(R.id.iv_video_count_down);
            this.R = (TextView) inflate.findViewById(R.id.tv_video_tip);
            this.S = (LinearLayout) inflate.findViewById(R.id.ll_time_count);
            this.T = (ImageView) inflate.findViewById(R.id.iv_time_count_point);
            this.U = (TextView) inflate.findViewById(R.id.tv_time_count);
        } else {
            this.P.setVisibility(0);
        }
        this.U.setText(String.format("00:%02d", Integer.valueOf(this.aE.n)));
        this.R.setVisibility(0);
        this.R.setText(R.string.sapi_liveness_video_start_record_later);
        this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.spai_liveness_video_scale_count_down);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.29
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessRecogActivity.this.aE.m++;
                if (LivenessRecogActivity.this.aE.m != 1 || LivenessRecogActivity.this.aE.m > 3) {
                    if (LivenessRecogActivity.this.aE.m != 3 || LivenessRecogActivity.this.aE.m > 3) {
                        if (LivenessRecogActivity.this.aE.m > 4) {
                            LivenessRecogActivity.this.Q.setVisibility(4);
                            LivenessRecogActivity.this.R.setText(R.string.sapi_liveness_video_start_record);
                            LivenessRecogActivity.this.R.postDelayed(new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.29.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!LivenessRecogActivity.this.aD.z) {
                                        LivenessRecogActivity.this.R.setVisibility(8);
                                        LivenessRecogActivity.this.Q();
                                    }
                                }
                            }, 300L);
                            return;
                        }
                        return;
                    }
                    LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_1);
                    LivenessRecogActivity.this.Q.startAnimation(animation);
                    return;
                }
                LivenessRecogActivity.this.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_2);
                animation.reset();
                LivenessRecogActivity.this.Q.startAnimation(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.Q.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (H() && !this.aD.z) {
            this.S.setVisibility(0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.30
                @Override // java.lang.Runnable
                public void run() {
                    LivenessRecogActivity.this.T.startAnimation(AnimationUtils.loadAnimation(LivenessRecogActivity.this, R.anim.sapi_liveness_time_count_point));
                }
            }, 2000L);
            this.aQ.postDelayed(this.aR, 1000L);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.31
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(com.baidu.fsg.biometrics.base.d.f.a(LivenessRecogActivity.this) + File.separator + com.baidu.fsg.biometrics.base.d.f.b);
                    if (!file.exists() || file.length() <= 0) {
                        LivenessRecogActivity.this.aL.e();
                        LivenessRecogActivity.this.F();
                        LivenessRecogActivity.this.T.clearAnimation();
                        LivenessRecogActivity.this.aQ.removeCallbacks(LivenessRecogActivity.this.aR);
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
            if (Math.abs(faceInfo.headPose[0]) >= (this.aU != null ? this.aU.getPitch() : 15)) {
                return true;
            }
            if (Math.abs(faceInfo.headPose[1]) >= (this.aU != null ? this.aU.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    private void c(int i2) {
        this.H.setText(this.aw[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j2) {
        return System.currentTimeMillis() - this.aG > j2;
    }

    private void d(int i2) {
        if (this.ar == null || !this.ar.isPlaying()) {
            this.ar = MediaPlayer.create(this, e.j[i2]);
            if (this.ar != null) {
                this.ar.setOnErrorListener(new c());
                setVolumeControlStream(3);
                if (!this.aH) {
                    this.ar.setVolume(0.0f, 0.0f);
                }
                this.ar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
            if (this.aD.x) {
                this.bb.a();
                y();
                return false;
            }
            if (!this.aI) {
                b();
            }
            this.aF.M = true;
            if (this.aF.O == 0) {
                this.aF.N = 1;
            } else {
                this.aF.N = 2;
            }
            this.aF.aa = -204;
            if (this.aD.u == 14) {
                this.aF.O = 0;
                this.aF.N = 3;
            }
            if (this.aD.u == 14) {
                this.aL.e();
            }
            this.aL.d();
            setActivityResult(0);
            a(this.aI ? false : true);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3 = 0;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.aD.F = false;
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
                if (this.ac != null && this.ac.isShowing()) {
                    this.ac.dismiss();
                }
                this.aD.u = 14;
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
        if (this.bd != null) {
            this.bd.a(com.baidu.sapi2.biometrics.liveness.f.p);
        }
        if (this.bd != null) {
            this.bd.a(com.baidu.sapi2.biometrics.liveness.f.q);
            this.bd.a(com.baidu.sapi2.biometrics.liveness.f.s);
            this.bd.a(com.baidu.sapi2.biometrics.liveness.f.t);
        }
        if (z) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending():  发送日志");
            this.aF.d();
        }
        if (this.ay != null) {
            this.ay.cancel();
        }
        try {
            if (this.ar != null) {
                this.ar.stop();
                this.ar.release();
            }
        } catch (Exception e2) {
            com.baidu.fsg.biometrics.base.d.c.a(e2);
        }
        finish();
    }

    public void setActivityResult(int i2) {
        this.aF.c();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(f.p, this.aF.N);
        bundle.putSerializable(f.L, this.aF.as);
        intent.putExtras(bundle);
        setResult(i2, intent);
    }

    private String R() {
        int i2;
        try {
            i2 = new FileInputStream(com.baidu.fsg.biometrics.base.d.f.a(this) + File.separator + com.baidu.fsg.biometrics.base.d.f.b).available();
        } catch (Exception e2) {
            i2 = 0;
        }
        if (i2 < 1024) {
            return "1KB";
        }
        if (i2 < 1023488) {
            String str = Math.round(i2 / 1024.0d) + "KB";
            if (str.contains(".0KB")) {
                return str.replace(".0KB", "KB");
            }
            return str;
        }
        String str2 = String.format("%.1f", Double.valueOf(i2 / 1048576.0d)) + "M";
        if (str2.contains(".0M")) {
            return str2.replace(".0M", "M");
        }
        return str2;
    }

    public void getRecordVideoQuestions() {
        c(getString(R.string.sapi_loading));
        com.baidu.sapi2.biometrics.liveness.beans.f fVar = (com.baidu.sapi2.biometrics.liveness.beans.f) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, b);
        fVar.setResponseCallback(this);
        fVar.execBean();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void S() {
        byte[] bArr;
        this.aD.u = 16;
        try {
            FileInputStream fileInputStream = new FileInputStream(com.baidu.fsg.biometrics.base.d.f.a(this) + File.separator + com.baidu.fsg.biometrics.base.d.f.b);
            bArr = new byte[fileInputStream.available()];
            try {
                fileInputStream.read(bArr);
            } catch (Exception e2) {
                e = e2;
                A();
                com.baidu.fsg.biometrics.base.d.c.a(e);
                this.bb = new com.baidu.sapi2.biometrics.liveness.e(this);
                if (bArr == null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
        }
        this.bb = new com.baidu.sapi2.biometrics.liveness.e(this);
        if (bArr == null) {
            com.baidu.sapi2.biometrics.liveness.e eVar = this.bb;
            com.baidu.sapi2.biometrics.liveness.e eVar2 = this.bb;
            eVar2.getClass();
            eVar.a(new e.a(eVar2) { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.32
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    eVar2.getClass();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.biometrics.base.a.a
                /* renamed from: b  reason: avoid collision after fix types in other method */
                public void a(e.b bVar) {
                    if (!LivenessRecogActivity.this.aD.y) {
                        LivenessRecogActivity.this.aq = new LivenessRecogResult();
                        LivenessRecogActivity.this.aq.callbackkey = bVar.k;
                        LivenessRecogActivity.this.aq.setResultCode(0);
                        LivenessRecogActivity.this.ag.showUpSucView();
                        LivenessRecogActivity.this.I();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.biometrics.base.a.a
                /* renamed from: c */
                public void b(e.b bVar) {
                    if (!LivenessRecogActivity.this.aD.y) {
                        if (bVar.getResultCode() == 5) {
                            LivenessRecogActivity.this.B();
                            return;
                        }
                        LivenessRecogActivity.this.aF.af = 0;
                        LivenessRecogActivity.this.A();
                    }
                }

                @Override // com.baidu.sapi2.biometrics.liveness.e.a
                public void a(int i2) {
                    LivenessRecogActivity.this.ag.setProgress(i2);
                }

                @Override // com.baidu.fsg.biometrics.base.a.a
                public void onStart() {
                    LivenessRecogActivity.this.aD.x = true;
                    LivenessRecogActivity.this.ag.setProgress(0);
                }

                @Override // com.baidu.fsg.biometrics.base.a.a
                public void onFinish() {
                    LivenessRecogActivity.this.aD.x = false;
                }
            }, this.livenessRecogDTO.serviceType, this.livenessRecogDTO.bduss, this.livenessRecogDTO.stoken, "", bArr, null, 1, "", this.aY, this.aZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.aD.x = true;
        this.ag.setProgress(0);
        this.aD.u = 16;
        try {
            FileInputStream fileInputStream = new FileInputStream(com.baidu.fsg.biometrics.base.d.f.a(this) + File.separator + com.baidu.fsg.biometrics.base.d.f.b);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            RimStatisticsUtil.onEventStart(com.baidu.sapi2.biometrics.liveness.f.w);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
            i iVar = (i) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, b);
            UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
            uploadFileModel.filedata = bArr;
            uploadFileModel.fileName = "video.3gp";
            uploadFileModel.name = "file";
            iVar.addFile(uploadFileModel);
            iVar.a(this.aY);
            iVar.b(this.aZ);
            iVar.setProgressListener(new RestMultipartEntity.ProgressListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.33
                @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                public void transferred(long j2, long j3) {
                    LogUtil.d("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                    LogUtil.d("hello", "progress:  " + ((int) ((((float) j2) / ((float) j3)) * 100.0f)));
                    LivenessRecogActivity.this.ag.setProgress((int) ((((float) j2) / ((float) j3)) * 100.0f));
                }
            });
            iVar.setResponseCallback(this);
            iVar.execBean();
        } catch (Exception e2) {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity$35] */
    public void b(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity.35
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                int i2;
                int i3;
                Bitmap createBitmap;
                LivenessRecogActivity.this.be = 0;
                LivenessRecogActivity.this.bf = 0;
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
                        livenessRecogResult.setResultMsg(e.b.h);
                        LivenessRecogActivity.this.A.b(livenessRecogResult);
                    }
                    if (LivenessRecogActivity.this.aI) {
                        LivenessRecogActivity.this.setActivityResult(-1);
                    }
                    LivenessRecogActivity.this.aF.aa = -306;
                    LivenessRecogActivity.this.a(true);
                    return;
                }
                LivenessRecogActivity.this.be = arrayList.size();
                LivenessRecogActivity.this.bg = arrayList;
                if (LivenessRecogActivity.this.aU != null) {
                    LivenessRecogActivity.this.be = LivenessRecogActivity.this.aU.getRecogUploadPortraitCount(LivenessRecogActivity.this.be);
                }
                LivenessRecogActivity.this.U();
            }
        }.execute(faceVerifyDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.bf++;
        if (this.bg != null && this.bf <= this.be && this.bf <= this.bg.size()) {
            this.bi = this.bg.get(this.bf - 1).get("data");
            this.bj = this.bg.get(this.bf - 1).get("digest");
            if (this.livenessRecogDTO != null) {
                if (this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                    W();
                } else {
                    V();
                }
            }
        }
    }

    private void V() {
        if (this.bf == 1) {
            RimStatisticsUtil.onEventStart(com.baidu.sapi2.biometrics.liveness.f.o);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
        }
        com.baidu.sapi2.biometrics.liveness.beans.h hVar = (com.baidu.sapi2.biometrics.liveness.beans.h) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 5, c);
        if (this.livenessRecogDTO != null) {
            hVar.a(this.livenessRecogDTO.serviceType);
        }
        if (this.bj != null) {
            hVar.b(new String(this.bj));
        }
        UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
        uploadFileModel.contentType = "image/png";
        uploadFileModel.filedata = this.bi;
        uploadFileModel.fileName = "portrait.png";
        uploadFileModel.name = "file";
        hVar.addFile(uploadFileModel);
        hVar.setResponseCallback(this);
        hVar.execBean();
    }

    private void W() {
        if (this.bf == 1) {
        }
        com.baidu.sapi2.biometrics.liveness.beans.c cVar = (com.baidu.sapi2.biometrics.liveness.beans.c) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 8, c);
        if (this.bj != null) {
            cVar.a(new String(this.bj));
        }
        UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
        uploadFileModel.contentType = "image/png";
        uploadFileModel.filedata = this.bi;
        uploadFileModel.fileName = "portrait.png";
        uploadFileModel.name = "file";
        cVar.addFile(uploadFileModel);
        cVar.setResponseCallback(this);
        cVar.execBean();
    }

    private void c(String str) {
        if (!isFinishing()) {
            this.X = new LoadingDialog(this);
            this.X.setMessage(str);
            this.X.show();
        }
    }

    private void X() {
        if (this.X != null && !isFinishing() && this.X.isShowing()) {
            this.X.dismiss();
        }
    }

    private int Y() {
        try {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
            if (identifier <= 0) {
                return 75;
            }
            return getResources().getDimensionPixelSize(identifier);
        } catch (Exception e2) {
            com.baidu.fsg.biometrics.base.d.c.a(e2);
            return 75;
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public static final String A = "liveness_twice_recog_fail_video";
        public static final String B = "liveness_contrast_face_fail_video";
        public static final String C = "uid";
        public static final String D = "bio_processid";
        public static final String E = "liveness_subpro";
        public static final String F = "tpl";
        public static final String G = "bio_cuid";
        public static final String H = "device_model";
        public static final String I = "phone_sys";
        public static final String J = "network";
        public static final String K = "camera_liveness_face";
        public static final String L = "serializable_map";
        public static final String a = "display";
        public static final String b = "preview";
        public static final String c = "liveness_alert_video";
        public static final String d = "liveness_camera_ready";
        public static final String e = "liveness_face_recog";
        public static final String f = "liveness_blink";
        public static final String g = "liveness_getverifydata";
        public static final String h = "t_take_photo";
        public static final String i = "liveness_error_code";
        public static final String j = "t_get_argbs";
        public static final String k = "t_face_tracking";
        public static final String l = "t_face_track_done";
        public static final String m = "find_face_inter";
        public static final String n = "track_inter";
        public static final String o = "liveness_enter";
        public static final String p = "liveness_cancel_step";
        public static final String q = "liveness_success_step";
        public static final String r = "liveness_recog_timeout";
        public static final String s = "liveness_video_upload_result";
        public static final String t = "liveness_async_result";
        public static final String u = "liveness_prepare_data_result";
        public static final String v = "liveness_blink_count";
        public static final String w = "liveness_open_mouth_count";
        public static final String x = "liveness_open_mouth";
        public static final String y = "liveness_recog_type_online";
        public static final String z = "liveness_recog_time_online";
        int N;
        int O;
        int P;
        long Q;
        long R;
        long S;
        long T;
        long U;
        long V;
        long W;
        long X;
        int Y;
        long Z;
        int aa;
        int ab;
        long ac;
        int ai;
        a.C0082a aq;
        boolean M = false;
        int ad = 1;
        int ae = 0;
        int af = 0;
        int ag = 0;
        int ah = 0;
        int aj = 0;
        int ak = 0;
        List<Long> al = new ArrayList();
        List<Long> am = new ArrayList();
        List<Long> an = new ArrayList();
        List<Long> ao = new ArrayList();
        List<Long> ap = new ArrayList();
        private LivenessSerializableMap as = new LivenessSerializableMap();

        public f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.N = 0;
            this.O = 0;
            this.P = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.S = System.currentTimeMillis();
            this.T = 0L;
            this.U = System.currentTimeMillis();
            this.V = 0L;
            this.W = System.currentTimeMillis();
            this.X = 0L;
            this.Y = 0;
            this.Z = 0L;
            this.ab = 0;
            this.aa = 0;
            this.M = false;
            this.an.clear();
            this.ao.clear();
            this.ap.clear();
            this.al.clear();
            this.am.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> c() {
            String str;
            String str2;
            long j2 = this.V - this.U;
            long j3 = this.X - this.W;
            Display defaultDisplay = ((WindowManager) LivenessRecogActivity.this.getSystemService("window")).getDefaultDisplay();
            HashMap hashMap = new HashMap();
            hashMap.put("display", defaultDisplay.getWidth() + "," + defaultDisplay.getHeight());
            this.aq = LivenessRecogActivity.this.aL.g();
            if (this.aq != null) {
                hashMap.put(b, this.aq.a + "," + this.aq.b);
            }
            hashMap.put(c, String.valueOf(this.P));
            hashMap.put(d, this.R - this.Q > 0 ? String.valueOf(this.R - this.Q) : "0");
            hashMap.put(e, this.T - this.S > 0 ? String.valueOf(this.T - this.S) : "0");
            hashMap.put(f, j2 > 0 ? String.valueOf(j2) : "0");
            hashMap.put(g, this.Y + "");
            hashMap.put(h, this.Z - this.V > 0 ? String.valueOf(this.Z - this.V) : "0");
            hashMap.put(v, this.ag + "");
            hashMap.put(w, this.ah + "");
            hashMap.put(x, j3 > 0 ? String.valueOf(j3) : "0");
            hashMap.put(y, LivenessRecogActivity.this.aT + "");
            hashMap.put(z, LivenessRecogActivity.this.aS + "");
            hashMap.put(i, this.aa + "");
            try {
                hashMap.put(j, TextUtils.join(",", LivenessRecogActivity.this.aF.an));
                hashMap.put(k, TextUtils.join(",", LivenessRecogActivity.this.aF.ao));
                hashMap.put(l, TextUtils.join(",", LivenessRecogActivity.this.aF.ap));
                if (LivenessRecogActivity.this.aF.al.size() > 0) {
                    str = TextUtils.join(",", LivenessRecogActivity.this.aF.al);
                } else {
                    str = "0";
                }
                hashMap.put(m, str);
                if (LivenessRecogActivity.this.aF.am.size() > 0) {
                    str2 = TextUtils.join(",", LivenessRecogActivity.this.aF.am);
                } else {
                    str2 = "0";
                }
                hashMap.put(n, str2);
            } catch (Exception e2) {
                com.baidu.fsg.biometrics.base.d.c.a(e2);
            }
            hashMap.put(o, this.ad + "");
            hashMap.put(p, this.N + "");
            hashMap.put(q, this.ab + "");
            hashMap.put(r, this.ae + "");
            hashMap.put(s, this.af + "");
            hashMap.put(t, "1");
            hashMap.put(u, this.ai + "");
            hashMap.put(A, this.aj + "");
            hashMap.put(B, this.ak + "");
            if (LivenessRecogActivity.this.livenessRecogDTO != null) {
                hashMap.put("uid", LivenessRecogActivity.this.livenessRecogDTO.uid);
                hashMap.put(D, LivenessRecogActivity.this.livenessRecogDTO.processid);
                hashMap.put(E, LivenessRecogActivity.this.livenessRecogDTO.getSpno());
            }
            hashMap.put("tpl", "frfsd_ai");
            hashMap.put(G, com.baidu.fsg.biometrics.base.d.h.f(LivenessRecogActivity.this));
            hashMap.put(H, com.baidu.fsg.biometrics.base.d.h.b());
            hashMap.put(I, com.baidu.fsg.biometrics.base.d.h.a());
            hashMap.put(J, com.baidu.fsg.biometrics.base.d.g.a(LivenessRecogActivity.this));
            this.as.setMap(hashMap);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            SapiStatService.onEvent(K, c(), LivenessRecogActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h {
        int a = 0;
        long b;

        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
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
