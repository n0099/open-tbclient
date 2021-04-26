package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.pass.biometrics.R;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.armor.RimArmor;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.d.b;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraPreview;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.http.ReqPriority;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard, Handler.Callback {
    public static final int A0 = 1010;
    public static final int B0 = 1011;
    public static final int C0 = 1013;
    public static final int D0 = 101;
    public static final FaceTracker.ActionType E0 = FaceTracker.ActionType.RECOGNIZE;
    public static final String i0 = "LivenessRecog";
    public static final int j0 = 2002;
    public static final int k0 = 7126;
    public static final int l0 = 7127;
    public static final int m0 = 255;
    public static final int n0 = 0;
    public static final int o0 = 1;
    public static final int p0 = 2;
    public static final int q0 = 3;
    public static final int r0 = 4;
    public static final int s0 = 1001;
    public static final int t0 = 1002;
    public static final int u0 = 1003;
    public static final int v0 = 1005;
    public static final int w0 = 1006;
    public static final int x0 = 1007;
    public static final int y0 = 1008;
    public static final int z0 = 1009;
    public com.baidu.pass.biometrics.face.liveness.d.b A;
    public FaceInfo[] B;
    public FaceTracker.ErrCode C;
    public int[] E;
    public int H;
    public ArrayList<HashMap<String, byte[]>> I;
    public String J;
    public com.baidu.pass.biometrics.face.liveness.e.a M;
    public byte[] N;
    public int Q;
    public int R;
    public int S;
    public p U;
    public byte[] W;
    public ProgressStatus Y;
    public TimerTask Z;
    public boolean a0;
    public boolean b0;
    public Handler c0;
    public String[] e0;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f9504f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public CircleProgressView f9505g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9506h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f9507i;
    public ImageView j;
    public TextView k;
    public CameraPreview l;
    public CircleImageView m;
    public CircleImageView n;
    public LinearLayout o;
    public boolean p;
    public com.baidu.pass.biometrics.face.liveness.c.b q;
    public com.baidu.pass.biometrics.face.liveness.c.a r;
    public PassFaceRecogCallback s;
    public SdkConfigOptions.LivenessConfigOption t;
    public int u;
    public long v;
    public HeadPose w;
    public int x;
    public FaceTracker y;
    public int z;

    /* renamed from: e  reason: collision with root package name */
    public int f9503e = 112;
    public int D = -1;
    public Map<Integer, SoftReference<Bitmap>> F = new ConcurrentHashMap();
    public boolean G = false;
    public List<byte[]> K = new ArrayList();
    public boolean L = false;
    public int O = 0;
    public int[] P = null;
    public int T = -1;
    public boolean V = false;
    public Timer X = new Timer(true);
    public List<HeadPose> d0 = new ArrayList();
    public Camera.PreviewCallback h0 = new g();

    /* loaded from: classes2.dex */
    public enum HeadPose {
        EYES_BLINK(0, 1),
        DOWN(1, 2),
        UP(2, 4),
        TURN_LEFT(3, 8),
        TURN_RIGHT(4, 16),
        MOUTH_OPEN(5, 32);
        

        /* renamed from: a  reason: collision with root package name */
        public int f9509a;

        /* renamed from: b  reason: collision with root package name */
        public int f9510b;

        HeadPose(int i2, int i3) {
            this.f9509a = i2;
            this.f9510b = i3;
        }

        public static HeadPose getHeadPoseByIndex(Integer num) {
            HeadPose[] values;
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.f9509a) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }

        public static HeadPose getHeadPoseByValues(Integer num) {
            HeadPose[] values;
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.f9510b) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }

        public int getIndex() {
            return this.f9509a;
        }

        public int getValue() {
            return this.f9510b;
        }
    }

    /* loaded from: classes2.dex */
    public enum ProgressStatus {
        GO,
        BACK
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.e.a f9512a;

        public a(com.baidu.pass.biometrics.face.liveness.e.a aVar) {
            this.f9512a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9512a.dismiss();
            PassLivenessRecogActivity.this.C();
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.e.a f9514a;

        public b(com.baidu.pass.biometrics.face.liveness.e.a aVar) {
            this.f9514a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9514a.dismiss();
            PassLivenessRecogActivity.this.setActivityResult(-1);
            if (PassLivenessRecogActivity.this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-301);
                PassLivenessRecogActivity.this.s.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-301);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f9516a;

        public c(Animation animation) {
            this.f9516a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PassLivenessRecogActivity.this.j.startAnimation(this.f9516a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {
        public d(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            PassLivenessRecogActivity.this.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            PassLivenessRecogActivity.this.b(str);
        }
    }

    /* loaded from: classes2.dex */
    public class e extends HttpHandlerWrap {
        public e(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            PassLivenessRecogActivity.this.o();
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            PassLivenessRecogActivity.this.a(str);
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9520a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f9521b;

        static {
            int[] iArr = new int[ProgressStatus.values().length];
            f9521b = iArr;
            try {
                iArr[ProgressStatus.GO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9521b[ProgressStatus.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[HeadPose.values().length];
            f9520a = iArr2;
            try {
                iArr2[HeadPose.EYES_BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9520a[HeadPose.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9520a[HeadPose.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9520a[HeadPose.TURN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9520a[HeadPose.TURN_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9520a[HeadPose.MOUTH_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Camera.PreviewCallback {
        public g() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (!PassLivenessRecogActivity.this.b0 || PassLivenessRecogActivity.this.q.f9563a == 0 || PassLivenessRecogActivity.this.q.f9563a == 18 || PassLivenessRecogActivity.this.q.f9563a == 20 || PassLivenessRecogActivity.this.q.f9563a == 22 || PassLivenessRecogActivity.this.q.f9563a == 21) {
                return;
            }
            try {
                if (PassLivenessRecogActivity.this.O > 0) {
                    return;
                }
                PassLivenessRecogActivity.this.N = bArr;
                PassLivenessRecogActivity.this.W = bArr;
                PassLivenessRecogActivity.this.a(camera);
                PassLivenessRecogActivity.this.U = new p(PassLivenessRecogActivity.this, null);
                PassLivenessRecogActivity.this.U.execute(new Void[0]);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements b.InterfaceC0116b {
        public h() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.d.b.InterfaceC0116b
        public void a(float f2) {
            PassLivenessRecogActivity.this.b(f2);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements CircleProgressView.b {
        public i() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView.b
        public void a(float f2, float f3) {
            if (f2 == 100.0f) {
                PassLivenessRecogActivity.this.f9505g.setShowTick(false);
            } else {
                PassLivenessRecogActivity.this.f9505g.setShowTick(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.C();
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.e.b f9526a;

        public k(com.baidu.pass.biometrics.face.liveness.e.b bVar) {
            this.f9526a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f9526a);
            PassLivenessRecogActivity.this.q.f9569g = true;
            PassLivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.e.b f9528a;

        public l(com.baidu.pass.biometrics.face.liveness.e.b bVar) {
            this.f9528a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f9528a);
            if (PassLivenessRecogActivity.this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-307);
                PassLivenessRecogActivity.this.s.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-307);
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.M.dismiss();
            PassLivenessRecogActivity.this.q.f9569g = false;
            if (PassLivenessRecogActivity.this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-307);
                PassLivenessRecogActivity.this.s.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-307);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setData(Uri.fromParts("package", PassLivenessRecogActivity.this.getPackageName(), null));
            if (intent.resolveActivity(PassLivenessRecogActivity.this.getPackageManager()) != null) {
                PassLivenessRecogActivity.this.startActivity(intent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.M.dismiss();
            PassLivenessRecogActivity.this.q.f9569g = false;
            if (PassLivenessRecogActivity.this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-307);
                PassLivenessRecogActivity.this.s.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-307);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.e.a f9532a;

        public o(com.baidu.pass.biometrics.face.liveness.e.a aVar) {
            this.f9532a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.q.f9563a = 1;
            PassLivenessRecogActivity.this.A();
            PassLivenessRecogActivity.this.q.f9566d = System.currentTimeMillis();
            this.f9532a.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class p extends AsyncTask<Void, Void, String> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            PassLivenessRecogActivity.k(PassLivenessRecogActivity.this);
            PassLivenessRecogActivity.this.c();
            return null;
        }

        public /* synthetic */ p(PassLivenessRecogActivity passLivenessRecogActivity, g gVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            PassLivenessRecogActivity.l(PassLivenessRecogActivity.this);
        }
    }

    /* loaded from: classes2.dex */
    public class q extends TimerTask {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int progress;
                if (PassLivenessRecogActivity.this.f9505g == null || (progress = PassLivenessRecogActivity.this.f9505g.getProgress()) <= 0) {
                    return;
                }
                PassLivenessRecogActivity.this.f9505g.setProgress(progress - 1);
            }
        }

        public q() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PassLivenessRecogActivity.this.f9505g != null) {
                PassLivenessRecogActivity.this.f9505g.post(new a());
            }
        }

        public /* synthetic */ q(PassLivenessRecogActivity passLivenessRecogActivity, g gVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class r extends TimerTask {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int progress;
                if (PassLivenessRecogActivity.this.f9505g == null || (progress = PassLivenessRecogActivity.this.f9505g.getProgress()) >= 100) {
                    return;
                }
                PassLivenessRecogActivity.this.f9505g.setProgress(progress + 1);
            }
        }

        public r() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PassLivenessRecogActivity.this.f9505g != null) {
                PassLivenessRecogActivity.this.f9505g.post(new a());
            }
        }

        public /* synthetic */ r(PassLivenessRecogActivity passLivenessRecogActivity, g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.q.f9566d = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.q;
        if (bVar.f9563a == 0) {
            bVar.f9563a = 1;
        }
    }

    private void B() {
        this.f9506h.setVisibility(0);
        if (this.e0 != null) {
            int index = this.w.getIndex();
            String[] strArr = this.e0;
            if (index < strArr.length) {
                this.f9506h.setText(strArr[this.w.getIndex()]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.s != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.s.onFailure(passFaceRecogResult);
        }
    }

    public static /* synthetic */ int k(PassLivenessRecogActivity passLivenessRecogActivity) {
        int i2 = passLivenessRecogActivity.O + 1;
        passLivenessRecogActivity.O = i2;
        return i2;
    }

    public static /* synthetic */ int l(PassLivenessRecogActivity passLivenessRecogActivity) {
        int i2 = passLivenessRecogActivity.O - 1;
        passLivenessRecogActivity.O = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.s != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-206);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            this.s.onFailure(passFaceRecogResult);
            setActivityResult(-1);
        }
        a(-206);
    }

    private void p() {
        if (this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
        httpHashMapWrap.put("image", d());
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.t.isOriginImg() ? "1" : "0");
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, this.f9503e);
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new d(Looper.getMainLooper()));
    }

    private boolean q() {
        boolean z = false;
        try {
        } catch (Exception e2) {
            Log.e(i0, e2);
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.b();
            }
        }
        if (this.l == null) {
            return false;
        }
        this.c0.sendEmptyMessageDelayed(101, 800L);
        this.l.c();
        this.l.setPreviewCallback(this.h0);
        z = true;
        if (!z) {
            y();
        } else {
            CameraPreview cameraPreview2 = this.l;
            if (cameraPreview2 != null) {
                cameraPreview2.getPreviewSize();
            }
        }
        return z;
    }

    private void r() {
        int i2 = this.q.f9563a;
        if (i2 == 0 || i2 == 20 || i2 == 22 || i2 == 21 || i2 == 18 || i2 != 17 || this.C != FaceTracker.ErrCode.OK) {
            return;
        }
        a(ProgressStatus.GO);
        FaceVerifyData[] faceVerifyDataArr = this.y.get_FaceVerifyData(0);
        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
            return;
        }
        this.q.f9563a = 18;
        this.b0 = false;
        x();
        a(a(faceVerifyDataArr));
    }

    @TargetApi(23)
    private void s() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
            if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
                this.q.f9569g = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            } else if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                com.baidu.pass.biometrics.face.liveness.e.b bVar = new com.baidu.pass.biometrics.face.liveness.e.b(this);
                bVar.c(getString(R.string.pass_bio_pmn_ok), new k(bVar));
                bVar.a(getString(R.string.pass_bio_pmn_cancel), new l(bVar));
                bVar.b(String.format(getString(R.string.pass_bio_pmn_title_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.a(String.format(getString(R.string.pass_bio_pmn_msg_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.show();
                return;
            } else {
                this.q.f9569g = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            }
        }
        A();
        q();
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    private void t() {
        this.x = 0;
        this.w = this.d0.get(0);
        this.f0 = false;
        this.g0 = false;
        this.q.f9564b = false;
        com.baidu.pass.biometrics.face.liveness.c.a aVar = this.r;
        aVar.f9558b = false;
        aVar.f9559c = false;
        List<byte[]> list = this.K;
        if (list == null) {
            this.K = new ArrayList();
        } else {
            list.clear();
        }
    }

    private void u() {
        this.f9507i.setVisibility(4);
        this.f9506h.setVisibility(0);
        this.D = -1;
        this.f9506h.setText(R.string.pass_liveness_frist_text);
    }

    private void v() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        this.f9505g = (CircleProgressView) findViewById(R.id.pass_bio_liveness_recog_cpv);
        TextView textView = (TextView) findViewById(R.id.pass_bio_liveness_recog_tip_text);
        this.f9506h = textView;
        textView.setText(R.string.pass_liveness_frist_text);
        this.f9505g.setNormalColor(Color.parseColor("#FFE0E0E0"));
        this.f9505g.setOnChangeListener(new i());
        this.f9507i = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.j = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.k = (TextView) findViewById(R.id.tv_pose_warning_tip);
        setBrightness(this, 255);
        ((ImageView) findViewById(R.id.pass_bio_liveness_recog_close)).setOnClickListener(new j());
        this.l = (CameraPreview) findViewById(R.id.pass_bio_camera_pre_view);
        this.m = (CircleImageView) findViewById(R.id.pass_bio_circle_image_view);
        this.n = (CircleImageView) findViewById(R.id.pass_bio_circle_hide_view);
        this.o = (LinearLayout) findViewById(R.id.pass_bio_loading_view);
    }

    private void w() {
        this.q.f9563a = 20;
        com.baidu.pass.biometrics.face.liveness.e.a aVar = new com.baidu.pass.biometrics.face.liveness.e.a(this);
        aVar.b(getString(R.string.pass_liveness_recog_fail_dialog_title));
        aVar.c(getString(R.string.pass_liveness_recog_fail_dialog_msg));
        aVar.a(1);
        aVar.b(getString(R.string.pass_bio_alert_dialog_btn_back), new b(aVar));
        aVar.setCancelable(false);
        if (isFinishing() || aVar.isShowing()) {
            return;
        }
        aVar.show();
    }

    private void x() {
        if (this.W == null) {
            return;
        }
        CircleProgressView circleProgressView = this.f9505g;
        if (circleProgressView != null) {
            circleProgressView.setVisibility(8);
        }
        showLoadingView(this.W);
        this.a0 = true;
    }

    private void y() {
        this.q.f9569g = true;
        if (this.M == null) {
            com.baidu.pass.biometrics.face.liveness.e.a aVar = new com.baidu.pass.biometrics.face.liveness.e.a(this);
            this.M = aVar;
            aVar.b(getString(R.string.pass_bio_permission_request));
            this.M.b(true);
            this.M.c(getString(R.string.pass_liveness_permission_camera));
            this.M.c(getString(R.string.pass_bio_alert_dialog_btn_go_setting), new m());
            this.M.a(getString(R.string.pass_bio_alert_dialog_btn_cancel), new n());
        }
        this.M.setCancelable(false);
        if (isFinishing() || this.M.isShowing()) {
            return;
        }
        this.M.show();
    }

    private void z() {
        this.q.f9563a = 20;
        com.baidu.pass.biometrics.face.liveness.e.a aVar = new com.baidu.pass.biometrics.face.liveness.e.a(this);
        aVar.b(getString(R.string.pass_face_timeout_dialog_title));
        aVar.c(0);
        aVar.a(getString(R.string.pass_face_timeout_dialog_msg));
        aVar.c(getString(R.string.pass_bio_alert_dialog_btn_again), new o(aVar));
        aVar.a(getString(R.string.pass_bio_cancel), new a(aVar));
        aVar.setCancelable(false);
        if (isFinishing() || aVar.isShowing()) {
            return;
        }
        aVar.show();
    }

    public void addRandomActionList(List<HeadPose> list, Integer num, HeadPose headPose) {
        if (list != null && (num.intValue() & headPose.getValue()) == headPose.getValue()) {
            list.add(headPose);
        }
    }

    public boolean checkFaceInfo() {
        if (this.G) {
            return false;
        }
        if (m()) {
            Message message = new Message();
            message.what = 1001;
            this.c0.sendMessage(message);
            return false;
        }
        FaceInfo[] faceInfoArr = this.B;
        if (!b(faceInfoArr)) {
            Message message2 = new Message();
            message2.what = 1002;
            this.c0.sendMessage(message2);
            return false;
        } else if (!a(faceInfoArr)) {
            Message message3 = new Message();
            message3.what = 1003;
            this.c0.sendMessage(message3);
            return false;
        } else {
            FaceTracker.ErrCode errCode = this.C;
            if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                Message message4 = new Message();
                message4.what = 1005;
                this.c0.sendMessage(message4);
                return false;
            } else if (!this.f0 && a(faceInfoArr[0], errCode)) {
                Message message5 = new Message();
                message5.what = 1006;
                this.c0.sendMessage(message5);
                return false;
            } else if (!this.f0 && PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, this.E)) {
                Message message6 = new Message();
                message6.what = 1007;
                this.c0.sendMessage(message6);
                return false;
            } else if (this.f0 || !PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, this.E)) {
                return true;
            } else {
                Message message7 = new Message();
                message7.what = 1008;
                this.c0.sendMessage(message7);
                return false;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.b0 = true;
        } else if (i2 != 1013) {
            switch (i2) {
                case 1001:
                    t();
                    u();
                    g();
                    break;
                case 1002:
                    if (this.q.f9564b) {
                        this.f9506h.setVisibility(0);
                        b(3);
                        a(ProgressStatus.BACK);
                    }
                    t();
                    u();
                    break;
                case 1003:
                    b(3);
                    a(ProgressStatus.BACK);
                    t();
                    u();
                    break;
                default:
                    switch (i2) {
                        case 1005:
                            b(2);
                            a(ProgressStatus.BACK);
                            break;
                        case 1006:
                            b(4);
                            a(ProgressStatus.BACK);
                            t();
                            u();
                            break;
                        case 1007:
                            b(1);
                            a(ProgressStatus.BACK);
                            t();
                            u();
                            break;
                        case 1008:
                            b(0);
                            a(ProgressStatus.BACK);
                            t();
                            u();
                            break;
                        case 1009:
                            this.D = -1;
                            this.f9507i.setVisibility(8);
                            this.f9506h.setVisibility(0);
                            this.r.f9557a = false;
                            a(ProgressStatus.GO);
                            break;
                        case 1010:
                            B();
                            break;
                        case 1011:
                            this.D = -1;
                            this.f9506h.setText("");
                            break;
                    }
            }
        } else {
            r();
        }
        return false;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (bundle != null) {
            this.p = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, R.layout.layout_pass_liveness_recognize_new, null);
        this.f9504f = viewGroup;
        setContentView(viewGroup);
        k();
        v();
        this.A.a(new h());
        s();
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CameraPreview cameraPreview = this.l;
        if (cameraPreview != null) {
            cameraPreview.b();
        }
        com.baidu.pass.biometrics.face.liveness.d.b bVar = this.A;
        if (bVar != null) {
            bVar.b();
        }
        Handler handler = this.c0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.G = true;
        this.P = null;
        this.N = null;
        this.K.clear();
        this.K = null;
        this.W = null;
        TimerTask timerTask = this.Z;
        if (timerTask != null) {
            timerTask.cancel();
            this.X.purge();
            this.Z = null;
            this.X = null;
        }
        try {
            b();
            a(this.f9504f);
            this.f9504f.removeCallbacks(null);
            this.f9504f = null;
            System.gc();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            C();
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.b();
            }
            setActivityResult(0);
            a(-204);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.V = true;
        if (this.q.f9569g) {
            return;
        }
        this.b0 = false;
        CameraPreview cameraPreview = this.l;
        if (cameraPreview != null) {
            cameraPreview.b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.q.f9569g = false;
        if (i2 == 2002) {
            if (iArr.length > 0 && iArr[0] == 0) {
                A();
                q();
                return;
            }
            y();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.V) {
            this.V = false;
            if (this.a0) {
                return;
            }
            com.baidu.pass.biometrics.face.liveness.c.b bVar = this.q;
            if (bVar.f9569g) {
                return;
            }
            int i2 = bVar.f9563a;
            if (i2 < 18) {
                A();
                q();
            } else if (i2 == 20) {
                q();
            }
        }
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.p);
    }

    public void showLoadingView(byte[] bArr) {
        CameraPreview cameraPreview = this.l;
        if (cameraPreview == null) {
            return;
        }
        Bitmap a2 = cameraPreview.a(bArr);
        if (Build.VERSION.SDK_INT >= 17) {
            a2 = com.baidu.pass.biometrics.face.liveness.d.c.a(this, a2);
        }
        this.m.setImageBitmap(a2);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void c() {
        int[] iArr;
        byte[] bArr = this.N;
        if (bArr == null || (iArr = this.P) == null || this.G) {
            return;
        }
        try {
            FaceSDK.getARGBFromYUVimg(bArr, iArr, this.Q, this.R, this.S, 1);
            this.C = this.y.face_verification(this.P, this.Q, this.R, FaceSDK.ImgType.ARGB, E0, "", "", "");
            this.B = this.y.get_TrackedFaceInfo();
            if (this.b0 && checkFaceInfo()) {
                if (!this.q.f9564b) {
                    this.q.f9564b = true;
                    Message message = new Message();
                    message.what = 1009;
                    this.c0.sendMessage(message);
                }
                if (this.K == null) {
                    this.K = new ArrayList();
                }
                int i2 = 0;
                if (this.B != null && this.B.length > 0 && this.B[0] != null) {
                    i2 = this.B[0].face_id;
                }
                if (i2 != 0 && i2 != this.T) {
                    this.K.clear();
                }
                this.T = i2;
                if (this.K.size() < 3) {
                    if (this.N != null) {
                        this.K.add(this.N);
                        return;
                    }
                    return;
                } else if (this.g0 || a()) {
                    this.N = null;
                    this.q.f9563a = 17;
                    Message message2 = new Message();
                    message2.what = 1013;
                    this.c0.sendMessage(message2);
                    return;
                } else {
                    return;
                }
            }
            this.y.clearTrackedFaces();
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (this.t.isOriginImg()) {
            List<byte[]> list = this.K;
            if (list == null || list.isEmpty() || this.K.size() < this.H) {
                return "";
            }
            while (i2 < this.H) {
                Bitmap a2 = com.baidu.pass.biometrics.face.liveness.d.a.a(this.K.get(i2), this.Q, this.R);
                PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
                if (passFaceRecogDTO == null) {
                    sb.append(Base64Utils.encodeToString(com.baidu.pass.biometrics.face.liveness.d.a.a(a2, 80)));
                    if (i2 != this.H - 1) {
                        sb.append(",");
                    }
                } else {
                    int i3 = passFaceRecogDTO.quality;
                    sb.append(Base64Utils.encodeToString(com.baidu.pass.biometrics.face.liveness.d.a.a(a2, i3 != 0 ? i3 : 80)));
                    if (i2 != this.H - 1) {
                        sb.append(",");
                    }
                }
                i2++;
            }
        } else {
            ArrayList<HashMap<String, byte[]>> arrayList = this.I;
            if (arrayList == null || arrayList.isEmpty() || this.I.size() < this.H) {
                return "";
            }
            while (i2 < this.H) {
                sb.append(Base64Utils.encodeToString(this.I.get(i2).get("data")));
                if (i2 != this.H - 1) {
                    sb.append(",");
                }
                i2++;
            }
        }
        String sb2 = sb.toString();
        this.J = sb2;
        return sb2;
    }

    private int e() {
        List<Integer> aBtestIllumList = this.t.getABtestIllumList();
        if (aBtestIllumList != null && !aBtestIllumList.isEmpty()) {
            int illumVlaueGray = LocalConfigOptions.getInstance(this).getIllumVlaueGray();
            if (illumVlaueGray == -1) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                illumVlaueGray = random.nextInt(aBtestIllumList.size());
                LocalConfigOptions.getInstance(this).setIllumValueGray(illumVlaueGray);
            }
            if (illumVlaueGray >= 0 && illumVlaueGray <= aBtestIllumList.size() - 1) {
                return aBtestIllumList.get(illumVlaueGray).intValue();
            }
        }
        return 8;
    }

    private void f() {
        while (this.d0.size() < 3) {
            HeadPose headPoseByIndex = HeadPose.getHeadPoseByIndex(Integer.valueOf(new Random().nextInt(6)));
            if (!this.d0.contains(headPoseByIndex)) {
                this.d0.add(headPoseByIndex);
            }
        }
    }

    private void g() {
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.q;
        bVar.f9566d = 0L;
        if (!bVar.f9568f) {
            z();
            this.q.f9568f = true;
            return;
        }
        w();
    }

    private void h() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty("frfsd_ai")) {
            try {
                FaceTracker faceTracker = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
                this.y = faceTracker;
                faceTracker.set_isFineAlign(false);
                this.y.set_isVerifyLive(true);
                this.y.set_min_face_size(this.t.getMinFaceSize());
                this.y.set_illum_thr(this.t.getIllumThr());
                this.y.set_track_by_detection_interval(this.t.getTrackInterval());
                this.y.set_detect_in_video_interval(this.t.getDetectInterval());
                this.y.set_eulur_angle_thr(this.t.getYaw(), this.t.getPitch(), this.t.getRoll());
                this.y.set_max_reg_img_num(this.t.getMaxRegImgNum());
                this.y.set_prefetch_reg_img_interval(this.t.getPrefetchRegImgInterval());
                this.y.set_cropFaceSize(this.t.getCropFaceSize());
                this.y.set_cropFaceEnlargeRatio(this.t.getCropFaceRatio());
                return;
            } catch (Exception e2) {
                throw new Exception("init faceTracker failure: " + e2.getMessage());
            }
        }
        throw new Exception("idlToken or apiKey is empty");
    }

    private void i() {
        try {
            h();
        } catch (Exception unused) {
            if (this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-303);
                this.s.onFailure(passFaceRecogResult);
            }
            setActivityResult(0);
            a(-303);
        }
    }

    private void j() {
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.t = livenessConfigOption;
        this.u = livenessConfigOption.getRecogtimeInterval();
        this.v = this.t.getRecogActionType();
    }

    private void k() {
        if (this.mPassFaceRecogDTO == null) {
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
        this.c0 = new Handler(Looper.getMainLooper(), this);
        this.e0 = getResources().getStringArray(R.array.pass_liveness_head_pose);
        this.q = new com.baidu.pass.biometrics.face.liveness.c.b();
        this.r = new com.baidu.pass.biometrics.face.liveness.c.a();
        this.q.f9566d = System.currentTimeMillis();
        this.s = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        j();
        l();
        this.w = this.d0.get(this.x);
        i();
        this.z = e();
        this.A = new com.baidu.pass.biometrics.face.liveness.d.b(this);
    }

    private void l() {
        List<Integer> list;
        List<HeadPose> list2 = this.d0;
        if (list2 == null) {
            this.d0 = new ArrayList();
        } else {
            list2.clear();
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
        if (livenessConfigOption != null && (list = livenessConfigOption.action) != null && !list.isEmpty()) {
            try {
                b(this.t.action);
                return;
            } catch (Exception unused) {
                f();
                return;
            }
        }
        f();
    }

    private boolean m() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.q;
        long j2 = bVar.f9566d;
        return currentTimeMillis - j2 > bVar.f9567e && j2 > 0;
    }

    private void n() {
        if (this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        PassFaceRecogType passFaceRecogType = this.mPassFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put("type", "contrastportrait");
            httpHashMapWrap.put(NetworkBean.PARAM_COOKIE, PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            httpHashMapWrap.put("type", "certinfo");
            httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.mPassFaceRecogDTO.realName);
                jSONObject.put("cert", this.mPassFaceRecogDTO.idCardNum);
                jSONObject.put("bankmobile", this.mPassFaceRecogDTO.phoneNum);
                httpHashMapWrap.put("certinfo", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            httpHashMapWrap.put("type", "authtoken");
            httpHashMapWrap.put("authtoken", this.mPassFaceRecogDTO.authToken);
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
            httpHashMapWrap.put("type", "outer");
            httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEIMAGE) {
            httpHashMapWrap.put("type", "detect");
            httpHashMapWrap.put(NetworkBean.PARAM_COOKIE, PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
        }
        httpHashMapWrap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.mPassFaceRecogDTO.serviceType);
        httpHashMapWrap.put("image", d());
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.t.isOriginImg() ? "1" : "0");
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, this.f9503e);
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
        httpHashMapWrap.put("last", "1");
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new e(Looper.getMainLooper()));
    }

    private void b(List<Integer> list) {
        int i2;
        int i3;
        int i4;
        if (this.d0 == null) {
            this.d0 = new ArrayList();
        }
        int size = list.size() - 1;
        while (true) {
            boolean z = false;
            if (size <= 0) {
                break;
            }
            Integer num = list.get(size);
            if (num != null) {
                if ((num.intValue() == HeadPose.EYES_BLINK.f9510b || num.intValue() == HeadPose.DOWN.f9510b || num.intValue() == HeadPose.UP.f9510b || num.intValue() == HeadPose.TURN_LEFT.f9510b || num.intValue() == HeadPose.TURN_RIGHT.f9510b || num.intValue() == HeadPose.MOUTH_OPEN.f9510b) ? true : true) {
                    int i5 = size - 1;
                    if (list.get(i5) != null && num.equals(list.get(i5))) {
                        list.remove(num);
                    }
                }
            }
            size--;
        }
        int size2 = list.size();
        Boolean[] boolArr = new Boolean[size2];
        int size3 = list.size();
        HeadPose[] headPoseArr = new HeadPose[size3];
        for (int i6 = 0; i6 < list.size(); i6++) {
            Integer num2 = list.get(i6);
            if (num2 != null) {
                boolArr[i6] = Boolean.valueOf(num2.intValue() == HeadPose.EYES_BLINK.f9510b || num2.intValue() == HeadPose.DOWN.f9510b || num2.intValue() == HeadPose.UP.f9510b || num2.intValue() == HeadPose.TURN_LEFT.f9510b || num2.intValue() == HeadPose.TURN_RIGHT.f9510b || num2.intValue() == HeadPose.MOUTH_OPEN.f9510b);
                if (boolArr[i6].booleanValue()) {
                    headPoseArr[i6] = HeadPose.getHeadPoseByValues(num2);
                }
            }
        }
        for (int i7 = 0; i7 < size2; i7++) {
            if (!boolArr[i7].booleanValue()) {
                Integer num3 = list.get(i7);
                ArrayList arrayList = new ArrayList();
                addRandomActionList(arrayList, num3, HeadPose.EYES_BLINK);
                addRandomActionList(arrayList, num3, HeadPose.DOWN);
                addRandomActionList(arrayList, num3, HeadPose.UP);
                addRandomActionList(arrayList, num3, HeadPose.TURN_LEFT);
                addRandomActionList(arrayList, num3, HeadPose.TURN_RIGHT);
                addRandomActionList(arrayList, num3, HeadPose.MOUTH_OPEN);
                if (!arrayList.isEmpty()) {
                    if (a(list)) {
                        for (int i8 = 0; i8 < size3; i8++) {
                            arrayList.remove(headPoseArr[i8]);
                        }
                    } else if (i7 != 0 || (i4 = i7 + 1) >= size2) {
                        if (i7 != size2 - 1 || i7 - 1 <= 0) {
                            int i9 = i7 + 1;
                            if (i9 < size2 && i7 - 1 > 0) {
                                if (boolArr[i9].booleanValue()) {
                                    arrayList.remove(headPoseArr[i9]);
                                }
                                if (boolArr[i2].booleanValue()) {
                                    arrayList.remove(headPoseArr[i2]);
                                }
                            }
                        } else if (boolArr[i3].booleanValue()) {
                            arrayList.remove(headPoseArr[i3]);
                        }
                    } else if (boolArr[i4].booleanValue()) {
                        arrayList.remove(headPoseArr[i4]);
                    }
                    if (!arrayList.isEmpty()) {
                        headPoseArr[i7] = arrayList.get(new Random().nextInt(arrayList.size()));
                        boolArr[i7] = Boolean.TRUE;
                    }
                }
            }
        }
        this.d0.addAll(Arrays.asList(headPoseArr));
        while (this.d0.contains(null)) {
            this.d0.remove((Object) null);
        }
    }

    private boolean a(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Integer num = list.get(0);
        for (Integer num2 : list) {
            if (num == null || !num.equals(num2) || num2.intValue() != 63) {
                return false;
            }
            num = num2;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.b0 = false;
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    private boolean a(float f2) {
        return f2 <= ((float) this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void a(Camera camera) {
        if (this.Q == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.l.a()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.Q = previewSize.width;
            this.R = previewSize.height;
            this.S = cameraInfo.orientation;
        }
        if (this.E == null) {
            this.E = r5;
            int[] iArr = {this.R, this.Q};
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
        if (livenessConfigOption == null || TextUtils.isEmpty(livenessConfigOption.minFaceSize)) {
            if (this.Q > 640 && this.R > 480) {
                this.y.set_min_face_size(200);
            } else {
                this.y.set_min_face_size(100);
            }
        }
        if (this.P == null) {
            this.P = new int[this.Q * this.R];
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

    private boolean a(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
            int pitch = livenessConfigOption != null ? livenessConfigOption.getPitch() : 15;
            SdkConfigOptions.LivenessConfigOption livenessConfigOption2 = this.t;
            if (Math.abs(faceInfo.headPose[0]) >= (livenessConfigOption2 != null ? livenessConfigOption2.getYaw() : 15) || Math.abs(faceInfo.headPose[1]) >= pitch) {
                return true;
            }
        }
        return false;
    }

    private boolean a(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && PassBiometricUtil.isFaceInsideRound(faceInfoArr[0].landmarks, this.E);
    }

    private boolean a() {
        boolean is_live;
        if (this.G) {
            return false;
        }
        if (m()) {
            Message message = new Message();
            message.what = 1001;
            this.c0.sendMessage(message);
            return false;
        }
        FaceInfo[] faceInfoArr = this.B;
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        this.f0 = true;
        Message message2 = new Message();
        message2.what = 1010;
        this.c0.sendMessage(message2);
        switch (f.f9520a[this.w.ordinal()]) {
            case 1:
                is_live = faceInfoArr[0].is_live();
                break;
            case 2:
                is_live = faceInfoArr[0].is_live_head_down();
                break;
            case 3:
                is_live = faceInfoArr[0].is_live_head_up();
                break;
            case 4:
                is_live = faceInfoArr[0].is_live_head_turn_right();
                break;
            case 5:
                is_live = faceInfoArr[0].is_live_head_turn_left();
                break;
            case 6:
                is_live = faceInfoArr[0].is_live_mouth();
                break;
            default:
                is_live = false;
                break;
        }
        Log.e("LivenessRecogmode", "is_live:" + faceInfoArr[0].is_live() + " , head_up:" + faceInfoArr[0].is_live_head_up() + " , head_down:" + faceInfoArr[0].is_live_head_down() + " , turn_right:" + faceInfoArr[0].is_live_head_turn_right() + " , turn_left:" + faceInfoArr[0].is_live_head_turn_left() + " , live_mouth:" + faceInfoArr[0].is_live_mouth());
        if (!is_live) {
            Message message3 = new Message();
            message3.what = 1009;
            this.c0.sendMessage(message3);
            return false;
        } else if (this.x != this.d0.size() - 1) {
            List<HeadPose> list = this.d0;
            int i2 = this.x + 1;
            this.x = i2;
            this.w = list.get(i2);
            return false;
        } else {
            this.f0 = false;
            this.g0 = true;
            Message message4 = new Message();
            message4.what = 1011;
            this.c0.sendMessage(message4);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        if (!this.L && a(f2)) {
            this.L = true;
            this.A.b();
        }
    }

    private void b() {
        for (SoftReference<Bitmap> softReference : this.F.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private boolean b(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    private void b(int i2) {
        this.f9507i.setVisibility(0);
        if (this.D != i2) {
            if (i2 == 1) {
                this.k.setText(getString(R.string.pass_liveness_tofar_from_camera));
            } else if (i2 == 0) {
                this.k.setText(getString(R.string.pass_liveness_tonear_from_camera));
            } else if (i2 == 2) {
                this.k.setText(getString(R.string.pass_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                this.k.setText(getString(R.string.pass_liveness_face_to_screen));
            } else {
                this.k.setText(getString(R.string.pass_liveness_put_face_round));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new c(loadAnimation));
            if (!this.r.f9557a) {
                this.j.startAnimation(loadAnimation);
                this.r.f9557a = true;
            }
        }
        this.D = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        byte[] a2;
        if (this.s == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("result");
            passFaceRecogResult.extraJson = jSONObject;
            String optString = jSONObject.optString("faceid");
            passFaceRecogResult.callbackkey = optString;
            if (TextUtils.isEmpty(optString)) {
                a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                return;
            }
            try {
                if (this.mPassFaceRecogDTO != null) {
                    if (this.K != null && !this.K.isEmpty()) {
                        Bitmap a3 = com.baidu.pass.biometrics.face.liveness.d.a.a(this.K.get(0), this.Q, this.R);
                        int i2 = 80;
                        if (this.mPassFaceRecogDTO == null) {
                            a2 = com.baidu.pass.biometrics.face.liveness.d.a.a(a3, 80);
                        } else {
                            if (this.mPassFaceRecogDTO.quality != 0) {
                                i2 = this.mPassFaceRecogDTO.quality;
                            }
                            a2 = com.baidu.pass.biometrics.face.liveness.d.a.a(a3, i2);
                        }
                        passFaceRecogResult.originalImage = Base64Utils.encodeToString(a2);
                    }
                    if (this.I != null && !this.I.isEmpty()) {
                        byte[] encode = Base64Utils.encode(this.I.get(0).get("data"));
                        if (encode != null) {
                            passFaceRecogResult.faceimage = new String(encode);
                        }
                        byte[] bArr = this.I.get(0).get(LightappBusinessClient.MTD_DIGEST);
                        if (bArr != null) {
                            passFaceRecogResult.imgdigests = new String(bArr);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            passFaceRecogResult.setResultCode(0);
            this.s.onSuccess(passFaceRecogResult);
            a(passFaceRecogResult.getResultCode());
        } catch (JSONException unused2) {
            a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }

    private ArrayList<HashMap<String, byte[]>> a(FaceVerifyData[] faceVerifyDataArr) {
        int i2;
        int i3;
        Bitmap createBitmap;
        ArrayList<HashMap<String, byte[]>> arrayList = new ArrayList<>();
        for (FaceVerifyData faceVerifyData : faceVerifyDataArr) {
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

    private void a(ArrayList<HashMap<String, byte[]>> arrayList) {
        if (arrayList.isEmpty()) {
            if (this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-306);
                passFaceRecogResult.setResultMsg(PassFaceRecogResult.ERROR_MSG_IMAGE_FILE_EMPTY);
                this.s.onFailure(passFaceRecogResult);
            }
            a(-306);
        } else if (this.mPassFaceRecogDTO == null) {
        } else {
            int size = arrayList.size();
            this.H = size;
            this.I = arrayList;
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
            if (livenessConfigOption != null) {
                this.H = livenessConfigOption.getRecogUploadPortraitCount(size);
            }
            if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                p();
            } else {
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.s != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(i2);
            passFaceRecogResult.setResultMsg(str);
            this.s.onFailure(passFaceRecogResult);
            setActivityResult(-1);
            a(passFaceRecogResult.getResultCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(BaiduRimConstants.RETCODE_KEY);
            String optString = jSONObject.optString("retMsg");
            contrastPortraitResult.setResultCode(optInt);
            contrastPortraitResult.setResultMsg(optString);
            if (contrastPortraitResult.getResultCode() == 0) {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                    contrastPortraitResult.authsid = optJSONObject.optString("authsid");
                }
                contrastPortraitResult.callbackkey = optJSONObject.optString("callbackkey");
                contrastPortraitResult.contrastres = optJSONObject.optInt("contrastres");
                contrastPortraitResult.finalres = optJSONObject.optInt("finalres");
                contrastPortraitResult.finish = optJSONObject.optInt("finish");
                contrastPortraitResult.imgdigests = optJSONObject.optString("imgdigests");
                contrastPortraitResult.recordvideo = optJSONObject.optInt("recordvideo");
            }
        } catch (JSONException e2) {
            Log.e(e2);
            o();
        }
        a(contrastPortraitResult);
    }

    @TargetApi(3)
    private void a(ContrastPortraitResult contrastPortraitResult) {
        byte[] encode;
        byte[] a2;
        if (this.s == null || contrastPortraitResult == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        if (contrastPortraitResult.isProcessPass()) {
            passFaceRecogResult.setResultCode(0);
        } else if (contrastPortraitResult.getResultCode() != 7126 && contrastPortraitResult.getResultCode() != 7127) {
            passFaceRecogResult.setResultCode(-302);
        } else {
            passFaceRecogResult.setResultCode(contrastPortraitResult.getResultCode());
            passFaceRecogResult.setResultMsg(contrastPortraitResult.getResultMsg());
        }
        passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
        passFaceRecogResult.authSid = contrastPortraitResult.authsid;
        try {
            if (this.mPassFaceRecogDTO != null) {
                if (this.K != null && !this.K.isEmpty()) {
                    Bitmap a3 = com.baidu.pass.biometrics.face.liveness.d.a.a(this.K.get(0), this.Q, this.R);
                    int i2 = 80;
                    if (this.mPassFaceRecogDTO == null) {
                        a2 = com.baidu.pass.biometrics.face.liveness.d.a.a(a3, 80);
                    } else {
                        if (this.mPassFaceRecogDTO.quality != 0) {
                            i2 = this.mPassFaceRecogDTO.quality;
                        }
                        a2 = com.baidu.pass.biometrics.face.liveness.d.a.a(a3, i2);
                    }
                    passFaceRecogResult.originalImage = Base64Utils.encodeToString(a2);
                    if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEIMAGE) {
                        passFaceRecogResult.faceimage = Base64Utils.encodeToString(a2);
                    }
                }
                if (this.I != null && !this.I.isEmpty()) {
                    if (this.mPassFaceRecogDTO.livenessType != PassFaceRecogType.RECOG_TYPE_FACEIMAGE && (encode = Base64Utils.encode(this.I.get(0).get("data"))) != null) {
                        passFaceRecogResult.faceimage = new String(encode);
                    }
                    byte[] bArr = this.I.get(0).get(LightappBusinessClient.MTD_DIGEST);
                    if (bArr != null) {
                        passFaceRecogResult.imgdigests = new String(bArr);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (contrastPortraitResult.isProcessPass()) {
            this.s.onSuccess(passFaceRecogResult);
        } else {
            this.s.onFailure(passFaceRecogResult);
        }
        a(passFaceRecogResult.getResultCode());
    }

    private void a(ProgressStatus progressStatus) {
        ProgressStatus progressStatus2 = this.Y;
        if ((progressStatus2 == null || progressStatus2 != progressStatus) && this.X != null) {
            this.Y = progressStatus;
            int i2 = f.f9521b[progressStatus.ordinal()];
            if (i2 == 1) {
                TimerTask timerTask = this.Z;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.X.purge();
                }
                r rVar = new r(this, null);
                this.Z = rVar;
                this.X.schedule(rVar, 0L, 10L);
            } else if (i2 != 2) {
            } else {
                TimerTask timerTask2 = this.Z;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    this.X.purge();
                }
                q qVar = new q(this, null);
                this.Z = qVar;
                this.X.schedule(qVar, 0L, 10L);
            }
        }
    }
}
