package com.baidu.pass.biometrics.face.liveness.activity;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.pass.biometrics.base.armor.RimArmor;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SoManager;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.ConstrastLoadingView;
import com.baidu.pass.biometrics.face.liveness.view.XfordView;
import com.baidu.webkit.sdk.PermissionRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@TargetApi(3)
/* loaded from: classes18.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static final String EXTRA_TIME_POINT_START = "time_point_start";

    /* renamed from: a  reason: collision with root package name */
    private static final String f2725a = "LivenessRecog";
    private static final int b = 2002;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 255;
    private static final int j = 1;
    private static final int k = 5000;
    private static final int l = 200;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final FaceTracker.ActionType r = FaceTracker.ActionType.RECOGNIZE;
    private TextView A;
    private ConstrastLoadingView B;
    private com.baidu.pass.biometrics.face.liveness.b.b C;
    private com.baidu.pass.biometrics.face.liveness.view.a D;
    private XfordView E;
    private FaceTracker F;
    private FaceInfo[] G;
    private String[] I;
    private int J;
    private d K;
    private int[] L;
    private FaceTracker.ErrCode M;
    private Handler O;
    private c P;
    private a Q;
    private long R;
    private b T;
    private com.baidu.pass.biometrics.face.liveness.b.a U;
    private ViewGroup V;
    private int Y;
    private long Z;
    private SdkConfigOptions.LivenessConfigOption aa;
    private String ba;
    private int ea;
    private int fa;
    private ArrayList<HashMap<String, byte[]>> ga;
    private boolean ha;
    private byte[] ia;
    private byte[] ja;
    private int oa;
    private com.baidu.pass.biometrics.face.liveness.d.b pa;
    private byte[] ra;
    private int sa;
    private PassFaceRecogCallback t;
    private int ta;
    private ImageView u;
    private int ua;
    private ImageView v;
    private FrameLayout w;
    private TextView x;
    private FrameLayout y;
    private ImageView z;
    private int s = -1;
    private int[] H = null;
    private boolean N = false;
    private int S = 0;
    private Map<Integer, SoftReference<Bitmap>> W = new ConcurrentHashMap();
    private List<int[]> X = new ArrayList();
    private boolean ca = false;
    private com.baidu.pass.biometrics.face.liveness.c.a da = new com.baidu.pass.biometrics.face.liveness.c.a();
    private boolean ka = false;
    private boolean la = true;
    private boolean ma = false;
    private boolean na = true;
    private Runnable qa = new j(this);
    Camera.PreviewCallback va = new com.baidu.pass.biometrics.face.liveness.activity.c(this);
    private boolean wa = false;
    private int xa = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f2726a = 0;
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        private static final int e = 0;
        private static final int f = 1;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends AsyncTask<Void, Void, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.n(LivenessRecogActivity.this);
            LivenessRecogActivity.this.e();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(LivenessRecogActivity livenessRecogActivity, j jVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessRecogActivity.o(LivenessRecogActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        static final int f2728a = 0;
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
        static final int m = 17;
        static final int n = 18;
        static final int o = 19;
        static final int p = 20;
        static final int q = 5000;
        static final int r = 20000;
        long v;
        int s = 0;
        boolean t = false;
        boolean u = false;
        long w = 20000;
        boolean x = false;
        boolean y = false;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d extends CountDownTimer {
        public d(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (LivenessRecogActivity.this.N) {
                return;
            }
            LivenessRecogActivity.this.K.start();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (LivenessRecogActivity.this.P.s != 0 && LivenessRecogActivity.this.P.s != 17 && LivenessRecogActivity.this.P.s != 19 && LivenessRecogActivity.this.P.s != 18 && LivenessRecogActivity.this.P.s != 10) {
                FaceInfo[] faceInfoArr = LivenessRecogActivity.this.G;
                if (LivenessRecogActivity.this.P.s == 1) {
                    if (LivenessRecogActivity.this.n()) {
                        LivenessRecogActivity.this.i();
                        return;
                    } else if (LivenessRecogActivity.this.b(faceInfoArr)) {
                        if (LivenessRecogActivity.this.M == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.d(2);
                            return;
                        }
                        LivenessRecogActivity livenessRecogActivity = LivenessRecogActivity.this;
                        if (livenessRecogActivity.a(faceInfoArr[0], livenessRecogActivity.M)) {
                            LivenessRecogActivity.this.d(4);
                            return;
                        } else if (!LivenessRecogActivity.this.a(faceInfoArr)) {
                            LivenessRecogActivity.this.s = -1;
                            LivenessRecogActivity.this.y.setVisibility(8);
                            LivenessRecogActivity.this.v.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.pass_liveness_recog_face_failed));
                            LivenessRecogActivity.this.P.t = false;
                            LivenessRecogActivity.this.da.w = 0;
                            Log.w(LivenessRecogActivity.f2725a, "STATE_START_RECOGNIZE, livenessStat.resetTimePoint()");
                            return;
                        } else if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                            LivenessRecogActivity.this.d(1);
                            return;
                        } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                            LivenessRecogActivity.this.d(0);
                            return;
                        } else {
                            LivenessRecogActivity.this.s = -1;
                            LivenessRecogActivity.this.y.setVisibility(8);
                            LivenessRecogActivity.this.P.s = 2;
                            if (!LivenessRecogActivity.this.P.t) {
                                LivenessRecogActivity.this.v.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.pass_liveness_recog_face_successed));
                                LivenessRecogActivity.this.R = System.currentTimeMillis();
                                LivenessRecogActivity.this.P.t = true;
                            }
                            LivenessRecogActivity.this.x();
                            LivenessRecogActivity.this.c(faceInfoArr);
                            return;
                        }
                    } else {
                        LivenessRecogActivity.this.v.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.pass_liveness_recog_face_failed));
                        LivenessRecogActivity.this.P.t = false;
                        LivenessRecogActivity.this.s = -1;
                        LivenessRecogActivity.this.y.setVisibility(8);
                        return;
                    }
                }
                if (LivenessRecogActivity.this.P.s == 4) {
                    if (LivenessRecogActivity.this.n()) {
                        LivenessRecogActivity.this.i();
                        return;
                    } else if (!LivenessRecogActivity.this.b(faceInfoArr)) {
                        LivenessRecogActivity.this.P.s = 1;
                        LivenessRecogActivity.this.v.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.pass_liveness_recog_face_failed));
                        LivenessRecogActivity.this.da.a();
                        Log.w(LivenessRecogActivity.f2725a, "STATE_FIND_FACE_SPECIAL_ANIM_DONE NO FACE, livenessStat.resetTimePoint()");
                        LivenessRecogActivity.this.P.t = false;
                        LivenessRecogActivity.this.da.w = 0;
                        LivenessRecogActivity.this.da.Z = System.currentTimeMillis();
                        return;
                    } else {
                        LivenessRecogActivity.this.s = -1;
                        LivenessRecogActivity.this.y.setVisibility(8);
                        if (LivenessRecogActivity.this.a(faceInfoArr)) {
                            if (LivenessRecogActivity.this.d(faceInfoArr)) {
                                if (LivenessRecogActivity.this.Z == 1) {
                                    LivenessRecogActivity.this.P.s = 5;
                                } else {
                                    LivenessRecogActivity.this.P.s = 7;
                                }
                                LivenessRecogActivity.this.da.ba = System.currentTimeMillis();
                                LivenessRecogActivity.this.da.da = System.currentTimeMillis();
                                Log.w(LivenessRecogActivity.f2725a, "timePointLivingMouthStart" + LivenessRecogActivity.this.da.da);
                                LivenessRecogActivity.this.c(faceInfoArr);
                                long j2 = LivenessRecogActivity.this.Y * 1000;
                                if (j2 < 20000) {
                                    LivenessRecogActivity.this.O.postDelayed(LivenessRecogActivity.this.qa, j2);
                                }
                            } else {
                                LivenessRecogActivity.this.P.s = 1;
                                LivenessRecogActivity.this.v.setImageBitmap(LivenessRecogActivity.this.b(R.drawable.pass_liveness_recog_face_failed));
                                LivenessRecogActivity.this.da.a();
                                Log.w(LivenessRecogActivity.f2725a, "STATE_FIND_FACE_SPECIAL_ANIM_DONE, livenessStat.resetTimePoint()");
                                LivenessRecogActivity.this.P.t = false;
                                LivenessRecogActivity.this.da.w = 0;
                                LivenessRecogActivity.this.da.Z = System.currentTimeMillis();
                                return;
                            }
                        }
                    }
                }
                if (LivenessRecogActivity.this.P.s != 5) {
                    if (LivenessRecogActivity.this.P.s == 7) {
                        if (LivenessRecogActivity.this.b(faceInfoArr)) {
                            LivenessRecogActivity.this.s = -1;
                            LivenessRecogActivity.this.y.setVisibility(8);
                        }
                        if (!LivenessRecogActivity.this.Q.i) {
                            LivenessRecogActivity.this.c(3);
                            LivenessRecogActivity.this.Q.i = true;
                        }
                    }
                } else {
                    if (LivenessRecogActivity.this.b(faceInfoArr)) {
                        LivenessRecogActivity.this.s = -1;
                        LivenessRecogActivity.this.y.setVisibility(8);
                    }
                    if (!LivenessRecogActivity.this.Q.h) {
                        LivenessRecogActivity.this.c(1);
                        LivenessRecogActivity.this.Q.h = true;
                    }
                }
                Log.e(LivenessRecogActivity.f2725a, "state STATE_START_TRACK_BLICK state", Integer.valueOf(LivenessRecogActivity.this.P.s));
                if (LivenessRecogActivity.this.P.s == 6 || LivenessRecogActivity.this.P.s == 8) {
                    Log.e(LivenessRecogActivity.f2725a, "state STATE_START_TRACK_BLICK");
                    if (LivenessRecogActivity.this.n()) {
                        LivenessRecogActivity.this.i();
                        return;
                    } else if (LivenessRecogActivity.this.b(faceInfoArr)) {
                        if (LivenessRecogActivity.this.M == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.d(2);
                            return;
                        }
                        LivenessRecogActivity livenessRecogActivity2 = LivenessRecogActivity.this;
                        if (livenessRecogActivity2.a(faceInfoArr[0], livenessRecogActivity2.M)) {
                            LivenessRecogActivity.this.d(4);
                            return;
                        } else if (!LivenessRecogActivity.this.a(faceInfoArr)) {
                            LivenessRecogActivity.this.s = -1;
                            LivenessRecogActivity.this.y.setVisibility(8);
                            return;
                        } else if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                            LivenessRecogActivity.this.d(1);
                            return;
                        } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                            LivenessRecogActivity.this.d(0);
                            return;
                        } else {
                            LivenessRecogActivity.this.s = -1;
                            LivenessRecogActivity.this.y.setVisibility(8);
                            LivenessRecogActivity.this.c(faceInfoArr);
                        }
                    } else {
                        LivenessRecogActivity.this.d(3);
                        LivenessRecogActivity.this.P.u = false;
                        return;
                    }
                }
                if (LivenessRecogActivity.this.P.s == 9) {
                    if (LivenessRecogActivity.this.n()) {
                        LivenessRecogActivity.this.i();
                        return;
                    } else if (LivenessRecogActivity.this.b(faceInfoArr)) {
                        if (LivenessRecogActivity.this.M == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.d(2);
                            return;
                        }
                        LivenessRecogActivity livenessRecogActivity3 = LivenessRecogActivity.this;
                        if (livenessRecogActivity3.a(faceInfoArr[0], livenessRecogActivity3.M)) {
                            LivenessRecogActivity.this.d(4);
                            return;
                        } else if (LivenessRecogActivity.this.a(faceInfoArr)) {
                            if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                                LivenessRecogActivity.this.d(1);
                                return;
                            } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.L)) {
                                LivenessRecogActivity.this.d(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.s = -1;
                                LivenessRecogActivity.this.y.setVisibility(8);
                            }
                        }
                    } else {
                        LivenessRecogActivity.this.d(3);
                        LivenessRecogActivity.this.P.u = false;
                        return;
                    }
                }
                Log.w(LivenessRecogActivity.f2725a, "onTick|state" + LivenessRecogActivity.this.P.s + "|errcode|" + LivenessRecogActivity.this.M);
                if (LivenessRecogActivity.this.b(faceInfoArr) && !LivenessRecogActivity.this.N) {
                    if ((LivenessRecogActivity.this.P.s == 9 || LivenessRecogActivity.this.P.s == 20) && LivenessRecogActivity.this.M == FaceTracker.ErrCode.OK) {
                        FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.F.get_FaceVerifyData(0);
                        LivenessRecogActivity.this.da.ha = true;
                        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
                            LivenessRecogActivity.this.da.G = 0;
                        } else {
                            LivenessRecogActivity.this.da.G = 1;
                        }
                        Object[] objArr = new Object[1];
                        objArr[0] = "livenessdone|faceVerifyDatas length|" + (faceVerifyDataArr != null ? Integer.valueOf(faceVerifyDataArr.length) : "0") + "|state|" + LivenessRecogActivity.this.P.s;
                        Log.w(LivenessRecogActivity.f2725a, objArr);
                        LivenessRecogActivity livenessRecogActivity4 = LivenessRecogActivity.this;
                        if (livenessRecogActivity4.b(faceInfoArr[0], livenessRecogActivity4.M) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                            LivenessRecogActivity.this.P.s = 10;
                            LivenessRecogActivity.this.O.removeCallbacks(LivenessRecogActivity.this.qa);
                            LivenessRecogActivity.this.K.cancel();
                            LivenessRecogActivity.this.U.f();
                            LivenessRecogActivity.this.B.setVisible(0);
                            LivenessRecogActivity.this.a(LivenessRecogActivity.this.b(faceVerifyDataArr));
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ int n(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.S + 1;
        livenessRecogActivity.S = i2;
        return i2;
    }

    static /* synthetic */ int o(LivenessRecogActivity livenessRecogActivity) {
        int i2 = livenessRecogActivity.S - 1;
        livenessRecogActivity.S = i2;
        return i2;
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
        if (bundle != null) {
            this.ha = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        requestWindowFeature(1);
        getWindow().addFlags(67108864);
        getWindow().addFlags(128);
        this.V = (ViewGroup) View.inflate(this, R.layout.layout_pass_liveness_recognize, null);
        setContentView(this.V);
        this.da.U = getIntent().getLongExtra(EXTRA_TIME_POINT_START, System.currentTimeMillis());
        this.da.v = 1;
        if (this.passFaceRecogDTO == null) {
            PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
            if (passFaceRecogCallback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
            a(-205);
            return;
        }
        j();
        if (!this.aa.closeSkipLiving) {
            this.la = this.passFaceRecogDTO.guideLiveness;
        }
        s();
        this.pa.a(new k(this));
        q();
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.pass.biometrics.face.liveness.d.b bVar = this.pa;
        if (bVar != null) {
            bVar.b();
        }
        this.N = true;
        this.H = null;
        this.ra = null;
        this.X.clear();
        this.X = null;
        try {
            b();
            this.V.removeView(this.C);
            this.C = null;
            a(this.V);
            this.V.removeCallbacks(null);
            this.V = null;
            this.O.removeCallbacksAndMessages(null);
            System.gc();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            y();
            a();
            this.U.a();
            setActivityResult(0);
            a(-204);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ca = true;
        if (!this.P.y) {
            this.K.cancel();
            this.U.a();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.P.y = false;
        if (i2 == 2002) {
            if (iArr.length > 0 && iArr[0] == 0) {
                com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
                aVar.t = 1;
                aVar.u = 1;
                aVar.V = System.currentTimeMillis();
                w();
                if (p()) {
                    this.da.W = System.currentTimeMillis();
                    return;
                }
                return;
            }
            u();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ca) {
            this.ca = false;
            c cVar = this.P;
            if (!cVar.y) {
                int i2 = cVar.s;
                if (i2 < 10) {
                    w();
                    p();
                } else if (i2 == 17) {
                    p();
                }
            }
        }
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.ha);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    public void setActivityResult(int i2) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        c cVar = this.P;
        cVar.v = 0L;
        if (!cVar.x) {
            v();
            this.P.x = true;
            return;
        }
        t();
    }

    private void j() {
        this.I = getResources().getStringArray(R.array.pass_liveness_head_pose);
        this.O = new Handler(Looper.getMainLooper(), this);
        this.P = new c();
        this.Q = new a();
        this.K = new d(5000L, 200L);
        this.P.v = System.currentTimeMillis();
        this.da.r = this.passFaceRecogDTO.getSpno();
        this.t = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        m();
        this.J = g();
        l();
        this.oa = h();
        this.da.D = this.oa;
        this.pa = new com.baidu.pass.biometrics.face.liveness.d.b(this);
    }

    private void k() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty("frfsd_ai")) {
            try {
                this.F = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
                this.F.set_isFineAlign(false);
                this.F.set_isVerifyLive(true);
                this.F.set_min_face_size(this.aa.getMinFaceSize());
                this.F.set_illum_thr(this.aa.getIllumThr());
                this.F.set_track_by_detection_interval(this.aa.getTrackInterval());
                this.F.set_detect_in_video_interval(this.aa.getDetectInterval());
                this.F.set_eulur_angle_thr(this.aa.getYaw(), this.aa.getPitch(), this.aa.getRoll());
                this.F.set_max_reg_img_num(this.aa.getMaxRegImgNum());
                this.F.set_prefetch_reg_img_interval(this.aa.getPrefetchRegImgInterval());
                this.F.set_cropFaceSize(this.aa.getCropFaceSize());
                this.F.set_cropFaceEnlargeRatio(this.aa.getCropFaceRatio());
                return;
            } catch (Exception e2) {
                throw new Exception("init faceTracker failure: " + e2.getMessage());
            }
        }
        throw new Exception("idlToken or apiKey is empty");
    }

    private void l() {
        try {
            o();
            k();
        } catch (Exception e2) {
            if (this.t != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-303);
                this.t.onFailure(passFaceRecogResult);
            }
            setActivityResult(0);
            a(-303);
        }
    }

    private void m() {
        this.aa = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.Y = this.aa.getRecogtimeInterval();
        this.Z = this.aa.getRecogActionType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        Log.e(f2725a, "processState.wholeProcessStartTime", Long.valueOf(this.P.v));
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = this.P;
        long j2 = cVar.v;
        return currentTimeMillis - j2 > cVar.w && j2 > 0;
    }

    private void o() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putString("uuid", this.passFaceRecogDTO.processid);
        bundle.putString("tpl", BeanConstants.tpl);
        bundle.putString("productId", this.passFaceRecogDTO.getSpno());
        if (!SoManager.load(this, bundle)) {
            throw new Exception("load so failure");
        }
    }

    private boolean p() {
        this.C.setVisibility(4);
        boolean a2 = this.U.a(this, 3);
        if (!a2) {
            u();
        } else {
            a.C0272a c2 = this.U.c();
            a(c2);
            this.U.a(this.va);
            this.C.a();
            this.da.s = c2.b + Constants.ACCEPT_TIME_SEPARATOR_SP + c2.f2749a;
        }
        this.C.setVisibility(0);
        return a2;
    }

    @TargetApi(23)
    private void q() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (!this.configuration.showPmnRationaleDialog) {
                this.P.y = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            } else if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                com.baidu.pass.biometrics.face.liveness.view.b bVar = new com.baidu.pass.biometrics.face.liveness.view.b(this);
                bVar.c(getString(R.string.pass_bio_pmn_ok), new n(this, bVar));
                bVar.a(getString(R.string.pass_bio_pmn_cancel), new o(this, bVar));
                bVar.b(String.format(getString(R.string.pass_bio_pmn_title_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.a(String.format(getString(R.string.pass_bio_pmn_msg_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.show();
                return;
            } else {
                this.P.y = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            }
        }
        this.da.V = System.currentTimeMillis();
        w();
        if (p()) {
            com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
            aVar.t = 1;
            aVar.W = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.y.setVisibility(4);
        this.s = -1;
        this.x.setText(R.string.pass_liveness_put_face_round);
        if (this.v != null) {
            this.v.setImageBitmap(b(R.drawable.pass_liveness_recog_face_failed));
        }
    }

    private void s() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        this.u = (ImageView) findViewById(R.id.btn_cancel);
        this.u.setOnClickListener(new m(this));
        this.w = (FrameLayout) findViewById(R.id.layout_pose_tip);
        this.x = (TextView) findViewById(R.id.tv_pose_tip);
        this.y = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.z = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.A = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.B = (ConstrastLoadingView) findViewById(R.id.constrastLoadingView);
        this.v = (ImageView) findViewById(R.id.img_face_recognized_state);
        this.v.setImageBitmap(b(R.drawable.pass_liveness_recog_face_failed));
        this.C = new com.baidu.pass.biometrics.face.liveness.b.b(this, null);
        this.V.addView(this.C, 0, new ViewGroup.LayoutParams(-2, -1));
        this.U = new com.baidu.pass.biometrics.face.liveness.b.a();
        this.C.setCameraInterface(this.U);
        this.C.setVisibility(4);
        this.E = (XfordView) findViewById(R.id.xfordview);
    }

    private void t() {
        this.da.S = 1;
        this.P.s = 17;
        this.O.removeCallbacks(this.qa);
        com.baidu.pass.biometrics.face.liveness.view.a aVar = new com.baidu.pass.biometrics.face.liveness.view.a(this);
        aVar.c(getString(R.string.pass_liveness_recog_fail_dialog_title));
        aVar.a(getString(R.string.pass_liveness_recog_fail_dialog_msg));
        aVar.a(1);
        aVar.b(getString(R.string.pass_bio_alert_dialog_btn_back), new r(this, aVar));
        aVar.setCancelable(false);
        if (isFinishing() || aVar.isShowing()) {
            return;
        }
        aVar.show();
    }

    private void u() {
        this.P.y = true;
        if (this.D == null) {
            this.D = new com.baidu.pass.biometrics.face.liveness.view.a(this);
            this.D.c(getString(R.string.pass_bio_permission_request));
            this.D.a(true);
            this.D.a(getString(R.string.pass_liveness_permission_camera));
            this.D.c(getString(R.string.pass_bio_alert_dialog_btn_go_setting), new com.baidu.pass.biometrics.face.liveness.activity.a(this));
            this.D.a(getString(R.string.pass_bio_alert_dialog_btn_cancel), new com.baidu.pass.biometrics.face.liveness.activity.b(this));
        }
        this.D.setCancelable(false);
        if (isFinishing() || this.D.isShowing()) {
            return;
        }
        this.D.show();
    }

    private void v() {
        this.da.P = 1;
        this.P.s = 17;
        this.O.removeCallbacks(this.qa);
        com.baidu.pass.biometrics.face.liveness.view.a aVar = new com.baidu.pass.biometrics.face.liveness.view.a(this);
        aVar.c(getString(R.string.pass_face_timeout_dialog_title));
        aVar.c(0);
        aVar.b(getString(R.string.pass_face_timeout_dialog_msg));
        aVar.c(getString(R.string.pass_bio_alert_dialog_btn_ok), new p(this, aVar));
        aVar.a(getString(R.string.pass_bio_cancel), new q(this, aVar));
        aVar.setCancelable(false);
        if (isFinishing() || aVar.isShowing()) {
            return;
        }
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.P.v = System.currentTimeMillis();
        c(0);
        this.K.start();
        this.da.Z = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        c cVar = this.P;
        cVar.s = 3;
        if (this.la) {
            cVar.s = 4;
        } else {
            cVar.s = 20;
        }
        this.v.setImageBitmap(b(R.drawable.pass_liveness_recog_face_successed));
        this.da.aa = System.currentTimeMillis();
        Log.w(f2725a, "livenessStat.timePointFindFaceDone:" + this.da.aa);
        com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
        aVar.x++;
        aVar.w = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.t != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.t.onFailure(passFaceRecogResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void e() {
        if (this.ra != null && this.H != null && !this.N) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                FaceSDK.getARGBFromYUVimg(this.ra, this.H, this.sa, this.ta, this.ua, 1);
                this.M = this.F.face_verification(this.H, this.sa, this.ta, FaceSDK.ImgType.ARGB, r, "", "", "");
                Object[] objArr = new Object[1];
                objArr[0] = "errorcode:" + this.M;
                Log.w(f2725a, objArr);
                this.G = this.F.get_TrackedFaceInfo();
                int i2 = (this.G == null || this.G.length <= 0 || this.G[0] == null) ? 0 : this.G[0].face_id;
                if (i2 != 0 && i2 != this.xa) {
                    this.X.clear();
                }
                this.xa = i2;
                if (this.M == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    if (this.wa) {
                        this.X.clear();
                        this.wa = false;
                    }
                    if (this.H != null) {
                        this.X.add(Arrays.copyOf(this.H, this.H.length));
                    }
                } else if (this.M == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    if (this.H != null) {
                        this.X.add(Arrays.copyOf(this.H, this.H.length));
                    }
                    this.wa = true;
                }
                this.ra = null;
                if (this.G != null && this.G.length > 0 && this.G[0] != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = "idl tracker time" + currentTimeMillis2;
                    Log.w(f2725a, objArr2);
                    com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
                    aVar.X = currentTimeMillis2 + aVar.X;
                    this.da.Y++;
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    private a.C0272a f() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new a.C0272a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        if (this.Z == 1) {
            this.J = 0;
        } else {
            this.J = 5;
        }
        return this.J;
    }

    private int h() {
        List<Integer> aBtestIllumList = this.aa.getABtestIllumList();
        int illumVlaueGray = LocalConfigOptions.getInstance(this).getIllumVlaueGray();
        if (illumVlaueGray == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            illumVlaueGray = random.nextInt(aBtestIllumList.size());
            LocalConfigOptions.getInstance(this).setIllumValueGray(illumVlaueGray);
            Log.w(f2725a, "getOnlineIllum random" + illumVlaueGray);
        }
        Log.w(f2725a, "getOnlineIllum" + illumVlaueGray);
        return aBtestIllumList.get(illumVlaueGray).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f7, code lost:
        if (r0 == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(FaceInfo[] faceInfoArr) {
        int i2;
        boolean is_live_mouth;
        boolean is_live;
        boolean is_live_head_down;
        if (faceInfoArr == null || faceInfoArr.length <= 0 || (i2 = this.P.s) < 1 || i2 >= 9) {
            return;
        }
        switch (this.J) {
            case 0:
                is_live_mouth = faceInfoArr[0].is_live_mouth();
                is_live = faceInfoArr[0].is_live();
                if (!is_live) {
                }
                is_live_head_down = true;
                break;
            case 1:
                is_live = false;
                is_live_head_down = faceInfoArr[0].is_live_head_down();
                is_live_mouth = false;
                break;
            case 2:
                is_live = false;
                is_live_head_down = faceInfoArr[0].is_live_head_up();
                is_live_mouth = false;
                break;
            case 3:
                is_live = false;
                is_live_head_down = faceInfoArr[0].is_live_head_turn_left();
                is_live_mouth = false;
                break;
            case 4:
                is_live = false;
                is_live_head_down = faceInfoArr[0].is_live_head_turn_right();
                is_live_mouth = false;
                break;
            case 5:
                is_live_mouth = faceInfoArr[0].is_live_mouth();
                is_live = faceInfoArr[0].is_live();
                if (!is_live) {
                }
                is_live_head_down = true;
                break;
            default:
                is_live_mouth = false;
                is_live = false;
                is_live_head_down = false;
                break;
        }
        Log.w(f2725a, "liveNessDetect|isLiveNess|" + is_live_head_down);
        if (is_live_head_down) {
            if (is_live) {
                com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
                aVar.y++;
                aVar.ca = System.currentTimeMillis();
                this.da.A = com.baidu.pass.biometrics.face.liveness.c.a.h;
                Log.w(f2725a, "timePointLivingEyePass:" + this.da.ca);
            } else if (is_live_mouth) {
                com.baidu.pass.biometrics.face.liveness.c.a aVar2 = this.da;
                aVar2.z++;
                aVar2.ea = System.currentTimeMillis();
                this.da.A = com.baidu.pass.biometrics.face.liveness.c.a.i;
                Log.w(f2725a, "timePointLivingMouthPass:" + this.da.ea);
            }
            if (this.P.s < 7) {
                this.da.F = com.baidu.pass.biometrics.face.liveness.c.a.h;
            } else {
                this.da.F = com.baidu.pass.biometrics.face.liveness.c.a.i;
            }
            Log.w(f2725a, "isLiveNess ProcessState:" + this.P.s);
            this.P.s = 9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        return faceInfoArr == null || faceInfoArr.length <= 0 || !(PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, this.L) || PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, this.L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        this.y.setVisibility(0);
        if (this.s != i2) {
            if (i2 == 1) {
                this.da.L++;
                this.A.setText(getString(R.string.pass_liveness_tofar_from_camera));
            } else if (i2 == 0) {
                this.da.K++;
                this.A.setText(getString(R.string.pass_liveness_tonear_from_camera));
            } else if (i2 == 2) {
                this.da.O++;
                this.A.setText(getString(R.string.pass_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                this.da.M++;
                this.A.setText(getString(R.string.pass_liveness_face_to_screen));
            } else {
                this.da.N++;
                this.A.setText(getString(R.string.pass_liveness_put_face_round));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new e(this, loadAnimation));
            if (!this.Q.g) {
                this.z.startAnimation(loadAnimation);
                this.Q.g = true;
            }
        }
        this.s = i2;
    }

    private void b() {
        for (SoftReference<Bitmap> softReference : this.W.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        a.C0272a c2 = this.U.c();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, c2.b, c2.f2749a, Bitmap.Config.ARGB_8888);
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

    private a.C0272a b(a.C0272a c0272a) {
        if (c0272a == null) {
            return null;
        }
        a.C0272a f2 = f();
        a.C0272a c0272a2 = new a.C0272a(c0272a.f2749a, c0272a.b);
        float f3 = c0272a.f2749a / c0272a.b;
        float f4 = f2.b / f2.f2749a;
        if (Math.abs(f3 - f4) > 0.02d) {
            if (f3 < f4) {
                int i2 = f2.b;
                c0272a2.f2749a = (c0272a.b * i2) / c0272a.f2749a;
                c0272a2.b = i2;
                return c0272a2;
            }
            c0272a2.f2749a = f2.f2749a;
            c0272a2.b = (f2.f2749a * c0272a.f2749a) / c0272a.b;
            return c0272a2;
        }
        return c0272a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FaceVerifyData[] b(FaceVerifyData[] faceVerifyDataArr) {
        FaceVerifyData[] faceVerifyDataArr2 = null;
        if (faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
            int length = faceVerifyDataArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Log.d("hello", "原始数据照片签名" + i2 + "    :" + faceVerifyDataArr[i2].mRegDigest);
            }
            faceVerifyDataArr2 = new FaceVerifyData[faceVerifyDataArr.length];
            for (int i3 = 0; i3 < length; i3++) {
                faceVerifyDataArr2[i3] = faceVerifyDataArr[(length - 1) - i3];
                Log.d("hello", "翻转后数据照片签名" + i3 + "    :" + faceVerifyDataArr[i3].mRegDigest);
            }
        }
        return faceVerifyDataArr2;
    }

    @TargetApi(3)
    private void a(ContrastPortraitResult contrastPortraitResult) {
        if (this.t == null || contrastPortraitResult == null) {
            return;
        }
        new l(this, contrastPortraitResult).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.ka) {
            if (this.t != null) {
                this.da.H = "fail";
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-206);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.t.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                a(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        this.fa++;
        ArrayList<HashMap<String, byte[]>> arrayList = this.ga;
        if (arrayList != null && this.fa <= arrayList.size()) {
            byte[] bArr = this.ga.get(this.fa - 1).get("data");
            byte[] bArr2 = this.ga.get(this.fa - 1).get("digest");
            this.ka = this.fa == this.ga.size();
            a(bArr2 == null ? null : new String(bArr2), bArr == null ? null : Base64Utils.encodeToString(bArr), this.ka, this.ba);
        } else if (this.t != null) {
            this.da.H = "fail";
            PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
            passFaceRecogResult2.setResultCode(-206);
            passFaceRecogResult2.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            this.t.onFailure(passFaceRecogResult2);
            setActivityResult(-1);
            a(passFaceRecogResult2.getResultCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.fa == this.ea) {
            this.da.H = "fail";
            if (this.t != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(i2);
                passFaceRecogResult.setResultMsg(str);
                this.t.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                a(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(int i2) {
        Bitmap bitmap;
        if (!this.W.containsKey(Integer.valueOf(i2)) || this.W.get(Integer.valueOf(i2)) == null || (bitmap = this.W.get(Integer.valueOf(i2)).get()) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_width);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i2, options);
            options.inSampleSize = PassBiometricUtil.calculateInSampleSize(options, dimensionPixelSize2, dimensionPixelSize);
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
            this.W.put(Integer.valueOf(i2), new SoftReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void c(int i2) {
        e(i2);
        c cVar = this.P;
        int i3 = cVar.s;
        if (i3 == 0) {
            cVar.s = 1;
        } else if (i3 == 5) {
            cVar.s = 6;
        } else if (i3 == 7) {
            cVar.s = 8;
        }
        this.w.setVisibility(0);
        this.x.setVisibility(0);
    }

    private void e(int i2) {
        String[] strArr;
        int i3;
        int i4;
        int i5;
        if (i2 == 0) {
            this.x.setText(R.string.pass_liveness_put_face_round);
        } else if (i2 == 1) {
            String[] strArr2 = this.I;
            if (strArr2 != null && (i5 = this.J) < strArr2.length) {
                this.x.setText(strArr2[i5]);
            }
        } else if (i2 == 2) {
            String[] strArr3 = this.I;
            if (strArr3 != null && (i4 = this.J) < strArr3.length) {
                this.x.setText(strArr3[i4]);
            }
        } else if (i2 != 3 || (strArr = this.I) == null || (i3 = this.J) >= strArr.length) {
        } else {
            this.x.setText(strArr[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ContrastPortraitResult contrastPortraitResult) {
        if (contrastPortraitResult.getResultCode() != 0) {
            b(contrastPortraitResult);
            this.da.H = "fail";
            return;
        }
        this.ba = contrastPortraitResult.callbackkey;
        if (contrastPortraitResult.isFinish()) {
            if (contrastPortraitResult.isProcessPass()) {
                a(contrastPortraitResult);
                return;
            } else {
                a(contrastPortraitResult);
                return;
            }
        }
        d();
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        return faceInfo != null && this.M == FaceTracker.ErrCode.OK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        if (!this.ma) {
            this.da.C = f2;
            if (a(f2)) {
                this.ma = true;
                this.da.B = 1;
                this.pa.b();
                if (Build.VERSION.SDK_INT >= 11) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setDuration(200L);
                    valueAnimator.setInterpolator(new LinearInterpolator());
                    valueAnimator.setIntValues(1, 100);
                    valueAnimator.addUpdateListener(new com.baidu.pass.biometrics.face.liveness.activity.d(this));
                    valueAnimator.start();
                    return;
                }
                this.x.setTextColor(-11447983);
                XfordView xfordView = this.E;
                if (xfordView != null) {
                    xfordView.setBgPaintColor(-1);
                    this.E.postInvalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i2;
        this.fa++;
        ArrayList<HashMap<String, byte[]>> arrayList = this.ga;
        if (arrayList != null && (i2 = this.fa) <= this.ea && i2 <= arrayList.size()) {
            this.ia = this.ga.get(this.fa - 1).get("data");
            this.ja = this.ga.get(this.fa - 1).get("digest");
            this.ka = this.fa == this.ga.size();
            byte[] bArr = this.ja;
            a(bArr != null ? new String(bArr) : null, Base64Utils.encodeToString(this.ia), this.ka);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i2 = this.P.s;
        if (i2 < 4) {
            this.da.I = com.baidu.pass.biometrics.face.liveness.c.a.j;
        } else if (i2 >= 4 && i2 < 9) {
            int i3 = this.J;
            if (i3 == 0) {
                this.da.I = com.baidu.pass.biometrics.face.liveness.c.a.k;
            } else if (i3 == 5) {
                this.da.I = com.baidu.pass.biometrics.face.liveness.c.a.l;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void a(Camera camera) {
        if (this.sa == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.U.d()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.sa = previewSize.width;
            this.ta = previewSize.height;
            this.ua = cameraInfo.orientation;
        }
        if (this.L == null) {
            this.L = new int[2];
            int[] iArr = this.L;
            iArr[0] = this.ta;
            iArr[1] = this.sa;
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.aa;
        if (livenessConfigOption == null || TextUtils.isEmpty(livenessConfigOption.minFaceSize)) {
            if (this.sa > 640 && this.ta > 480) {
                this.F.set_min_face_size(200);
            } else {
                this.F.set_min_face_size(100);
            }
        }
        if (this.H == null) {
            this.H = new int[this.sa * this.ta];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ContrastPortraitResult contrastPortraitResult) {
        if (this.ka) {
            this.da.H = "fail";
            if (this.t != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(contrastPortraitResult.getResultCode());
                passFaceRecogResult.setResultMsg(contrastPortraitResult.getResultMsg());
                this.t.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                a(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        d();
    }

    private void a(a.C0272a c0272a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.C.getLayoutParams());
        a.C0272a b2 = b(c0272a);
        if (b2 != null && (b2.f2749a != c0272a.f2749a || b2.b != c0272a.b)) {
            layoutParams.width = b2.f2749a;
            layoutParams.height = b2.b;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.C.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && PassBiometricUtil.isFaceInsideRound(faceInfoArr[0].landmarks, this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f2) {
        Log.w(f2725a, "whiteBgIllumThr" + this.oa);
        return f2 <= ((float) this.oa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK) {
            float[] fArr = faceInfo.headPose;
            if (fArr.length == 3) {
                float abs = Math.abs(fArr[0]);
                SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.aa;
                if (abs >= (livenessConfigOption != null ? livenessConfigOption.getPitch() : 15)) {
                    return true;
                }
                float abs2 = Math.abs(faceInfo.headPose[1]);
                SdkConfigOptions.LivenessConfigOption livenessConfigOption2 = this.aa;
                if (abs2 >= (livenessConfigOption2 != null ? livenessConfigOption2.getYaw() : 15)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Log.w(f2725a, "activityFinish");
        this.da.fa = System.currentTimeMillis();
        PassFaceRecogDTO passFaceRecogDTO = this.passFaceRecogDTO;
        if (passFaceRecogDTO != null) {
            this.da.E = passFaceRecogDTO.guideLiveness ? 1 : 0;
        }
        com.baidu.pass.biometrics.face.liveness.c.a aVar = this.da;
        aVar.ga = i2;
        PassFaceRecogDTO passFaceRecogDTO2 = this.passFaceRecogDTO;
        aVar.q = passFaceRecogDTO2 != null ? passFaceRecogDTO2.livenessType.getRecogTypeName() : "unknown_type";
        this.da.a(this);
        d dVar = this.K;
        if (dVar != null) {
            dVar.cancel();
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceVerifyData[] faceVerifyDataArr) {
        new f(this).execute(faceVerifyDataArr);
    }

    private void a(String str, String str2, boolean z, String str3) {
        ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        PassFaceRecogType passFaceRecogType = this.passFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put("type", "contrastportrait");
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.passFaceRecogDTO)));
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            httpHashMapWrap.put("type", "certinfo");
            httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.passFaceRecogDTO.realName);
                jSONObject.put("cert", this.passFaceRecogDTO.idCardNum);
                jSONObject.put("bankmobile", this.passFaceRecogDTO.phoneNum);
                httpHashMapWrap.put("certinfo", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            httpHashMapWrap.put("type", "authtoken");
            httpHashMapWrap.put("authtoken", this.passFaceRecogDTO.authToken);
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
            httpHashMapWrap.put("type", "outer");
            httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
        }
        httpHashMapWrap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.passFaceRecogDTO.serviceType);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        String zid = PassBioGlobalUtils.getZid(getApplicationContext());
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put("last", z ? "1" : "0");
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("callbackkey", str3);
        }
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), httpHashMapWrap, new g(this, Looper.getMainLooper(), contrastPortraitResult));
    }

    private void a(String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        httpHashMapWrap.put("last", z ? "1" : "0");
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), httpHashMapWrap, new i(this, Looper.getMainLooper()));
    }
}
