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
import com.baidu.pass.biometrics.face.liveness.c.b;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraPreview;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.http.ReqPriority;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
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
public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard {
    public static final int A0 = 1008;
    public static final int B0 = 1009;
    public static final int C0 = 1010;
    public static final int D0 = 1011;
    public static final int E0 = 1013;
    public static final String EXTRA_TIME_POINT_START = "time_point_start";
    public static final int F0 = 101;
    public static final FaceTracker.ActionType G0 = FaceTracker.ActionType.RECOGNIZE;
    public static final String k0 = "LivenessRecog";
    public static final int l0 = 2002;
    public static final int m0 = 7126;
    public static final int n0 = 7127;
    public static final int o0 = 255;
    public static final int p0 = 0;
    public static final int q0 = 1;
    public static final int r0 = 2;
    public static final int s0 = 3;
    public static final int t0 = 4;
    public static final int u0 = 1001;
    public static final int v0 = 1002;
    public static final int w0 = 1003;
    public static final int x0 = 1005;
    public static final int y0 = 1006;
    public static final int z0 = 1007;
    public int A;
    public com.baidu.pass.biometrics.face.liveness.c.b B;
    public FaceInfo[] C;
    public FaceTracker.ErrCode D;
    public int[] F;
    public int I;
    public ArrayList<HashMap<String, byte[]>> J;
    public String K;
    public com.baidu.pass.biometrics.face.liveness.d.a N;
    public byte[] O;
    public int R;
    public int S;
    public int T;
    public p V;
    public byte[] X;
    public ProgressStatus Z;
    public TimerTask a0;
    public boolean b0;
    public boolean c0;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f9087f;
    public String[] f0;

    /* renamed from: g  reason: collision with root package name */
    public CircleProgressView f9088g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9089h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f9090i;
    public com.baidu.pass.biometrics.face.liveness.b.b i0;
    public ImageView j;
    public TextView k;
    public CameraPreview l;
    public CircleImageView m;
    public CircleImageView n;
    public LinearLayout o;
    public boolean p;
    public com.baidu.pass.biometrics.face.liveness.b.c q;
    public com.baidu.pass.biometrics.face.liveness.b.a r;
    public PassFaceRecogCallback s;
    public SdkConfigOptions.LivenessConfigOption t;
    public int u;
    public long v;
    public HeadPose w;
    public HeadPose x;
    public int y;
    public FaceTracker z;

    /* renamed from: e  reason: collision with root package name */
    public int f9086e = 112;
    public int E = -1;
    public Map<Integer, SoftReference<Bitmap>> G = new ConcurrentHashMap();
    public boolean H = false;
    public List<byte[]> L = new ArrayList();
    public boolean M = false;
    public int P = 0;
    public int[] Q = null;
    public int U = -1;
    public boolean W = false;
    public Timer Y = new Timer(true);
    public final s d0 = new s(this);
    public List<HeadPose> e0 = new ArrayList();
    public Camera.PreviewCallback j0 = new g();

    /* loaded from: classes2.dex */
    public enum HeadPose {
        EYES_BLINK(0, 1),
        DOWN(1, 2),
        UP(2, 4),
        TURN_LEFT(3, 8),
        TURN_RIGHT(4, 16),
        MOUTH_OPEN(5, 32);
        

        /* renamed from: a  reason: collision with root package name */
        public int f9092a;

        /* renamed from: b  reason: collision with root package name */
        public int f9093b;

        HeadPose(int i2, int i3) {
            this.f9092a = i2;
            this.f9093b = i3;
        }

        public static HeadPose getHeadPoseByIndex(Integer num) {
            HeadPose[] values;
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.f9092a) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }

        public static HeadPose getHeadPoseByValues(Integer num) {
            HeadPose[] values;
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.f9093b) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }

        public int getIndex() {
            return this.f9092a;
        }

        public int getValue() {
            return this.f9093b;
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
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f9095a;

        public a(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f9095a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9095a.dismiss();
            PassLivenessRecogActivity.this.E();
            PassLivenessRecogActivity.this.i0.A = 1;
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f9097a;

        public b(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f9097a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9097a.dismiss();
            PassLivenessRecogActivity.this.i0.D = 1;
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
        public final /* synthetic */ Animation f9099a;

        public c(Animation animation) {
            this.f9099a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PassLivenessRecogActivity.this.j.startAnimation(this.f9099a);
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
            PassLivenessRecogActivity.this.q();
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            PassLivenessRecogActivity.this.a(str);
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9103a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f9104b;

        static {
            int[] iArr = new int[ProgressStatus.values().length];
            f9104b = iArr;
            try {
                iArr[ProgressStatus.GO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9104b[ProgressStatus.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[HeadPose.values().length];
            f9103a = iArr2;
            try {
                iArr2[HeadPose.EYES_BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9103a[HeadPose.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9103a[HeadPose.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9103a[HeadPose.TURN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9103a[HeadPose.TURN_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9103a[HeadPose.MOUTH_OPEN.ordinal()] = 6;
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
            if (!PassLivenessRecogActivity.this.c0 || PassLivenessRecogActivity.this.q.f9143a == 0 || PassLivenessRecogActivity.this.q.f9143a == 10 || PassLivenessRecogActivity.this.q.f9143a == 17 || PassLivenessRecogActivity.this.q.f9143a == 19 || PassLivenessRecogActivity.this.q.f9143a == 18) {
                return;
            }
            try {
                if (PassLivenessRecogActivity.this.P > 0) {
                    return;
                }
                PassLivenessRecogActivity.this.O = bArr;
                PassLivenessRecogActivity.this.X = bArr;
                PassLivenessRecogActivity.this.a(camera);
                PassLivenessRecogActivity.this.V = new p(PassLivenessRecogActivity.this, null);
                PassLivenessRecogActivity.this.V.execute(new Void[0]);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements b.InterfaceC0115b {
        public h() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.c.b.InterfaceC0115b
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
                PassLivenessRecogActivity.this.f9088g.setShowTick(false);
            } else {
                PassLivenessRecogActivity.this.f9088g.setShowTick(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.a();
            PassLivenessRecogActivity.this.E();
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f9109a;

        public k(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.f9109a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f9109a);
            PassLivenessRecogActivity.this.q.f9149g = true;
            PassLivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f9111a;

        public l(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.f9111a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f9111a);
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
            PassLivenessRecogActivity.this.N.dismiss();
            PassLivenessRecogActivity.this.q.f9149g = false;
            if (PassLivenessRecogActivity.this.s != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-307);
                PassLivenessRecogActivity.this.s.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-307);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, PassLivenessRecogActivity.this.getPackageName(), null));
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
            PassLivenessRecogActivity.this.N.dismiss();
            PassLivenessRecogActivity.this.q.f9149g = false;
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
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f9115a;

        public o(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f9115a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassLivenessRecogActivity.this.i0.a();
            PassLivenessRecogActivity.this.i0.B = 1;
            PassLivenessRecogActivity.this.q.f9143a = 1;
            PassLivenessRecogActivity.this.i0.a();
            PassLivenessRecogActivity.this.C();
            PassLivenessRecogActivity.this.q.f9146d = System.currentTimeMillis();
            this.f9115a.dismiss();
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
            PassLivenessRecogActivity.g(PassLivenessRecogActivity.this);
            PassLivenessRecogActivity.this.d();
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
            PassLivenessRecogActivity.h(PassLivenessRecogActivity.this);
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
                if (PassLivenessRecogActivity.this.f9088g == null || (progress = PassLivenessRecogActivity.this.f9088g.getProgress()) <= 0) {
                    return;
                }
                PassLivenessRecogActivity.this.f9088g.setProgress(progress - 1);
            }
        }

        public q() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PassLivenessRecogActivity.this.f9088g != null) {
                PassLivenessRecogActivity.this.f9088g.post(new a());
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
                if (PassLivenessRecogActivity.this.f9088g == null || (progress = PassLivenessRecogActivity.this.f9088g.getProgress()) >= 100) {
                    return;
                }
                PassLivenessRecogActivity.this.f9088g.setProgress(progress + 1);
            }
        }

        public r() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PassLivenessRecogActivity.this.f9088g != null) {
                PassLivenessRecogActivity.this.f9088g.post(new a());
            }
        }

        public /* synthetic */ r(PassLivenessRecogActivity passLivenessRecogActivity, g gVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class s extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<PassLivenessRecogActivity> f9122a;

        public s(PassLivenessRecogActivity passLivenessRecogActivity) {
            this.f9122a = new WeakReference<>(passLivenessRecogActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            PassLivenessRecogActivity passLivenessRecogActivity = this.f9122a.get();
            if (passLivenessRecogActivity != null) {
                int i2 = message.what;
                if (i2 == 101) {
                    passLivenessRecogActivity.c0 = true;
                } else if (i2 != 1013) {
                    switch (i2) {
                        case 1001:
                            passLivenessRecogActivity.v();
                            passLivenessRecogActivity.w();
                            passLivenessRecogActivity.h();
                            return;
                        case 1002:
                            if (!passLivenessRecogActivity.q.f9144b) {
                                passLivenessRecogActivity.f9089h.setVisibility(0);
                                passLivenessRecogActivity.b(3);
                                passLivenessRecogActivity.a(ProgressStatus.BACK);
                            }
                            passLivenessRecogActivity.v();
                            passLivenessRecogActivity.w();
                            return;
                        case 1003:
                            passLivenessRecogActivity.b(3);
                            passLivenessRecogActivity.a(ProgressStatus.BACK);
                            passLivenessRecogActivity.v();
                            passLivenessRecogActivity.w();
                            return;
                        default:
                            switch (i2) {
                                case 1005:
                                    passLivenessRecogActivity.b(2);
                                    passLivenessRecogActivity.a(ProgressStatus.BACK);
                                    return;
                                case 1006:
                                    passLivenessRecogActivity.b(4);
                                    passLivenessRecogActivity.a(ProgressStatus.BACK);
                                    passLivenessRecogActivity.v();
                                    passLivenessRecogActivity.w();
                                    return;
                                case 1007:
                                    passLivenessRecogActivity.b(1);
                                    passLivenessRecogActivity.a(ProgressStatus.BACK);
                                    passLivenessRecogActivity.v();
                                    passLivenessRecogActivity.w();
                                    return;
                                case 1008:
                                    passLivenessRecogActivity.b(0);
                                    passLivenessRecogActivity.a(ProgressStatus.BACK);
                                    passLivenessRecogActivity.v();
                                    passLivenessRecogActivity.w();
                                    return;
                                case 1009:
                                    passLivenessRecogActivity.E = -1;
                                    passLivenessRecogActivity.f9090i.setVisibility(8);
                                    passLivenessRecogActivity.f9089h.setVisibility(0);
                                    passLivenessRecogActivity.r.f9128a = false;
                                    passLivenessRecogActivity.a(ProgressStatus.GO);
                                    return;
                                case 1010:
                                    passLivenessRecogActivity.D();
                                    return;
                                case 1011:
                                    passLivenessRecogActivity.E = -1;
                                    passLivenessRecogActivity.f9089h.setText("");
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    passLivenessRecogActivity.t();
                }
            }
        }
    }

    private void A() {
        this.q.f9149g = true;
        if (this.N == null) {
            com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
            this.N = aVar;
            aVar.b(getString(R.string.pass_bio_permission_request));
            this.N.b(true);
            this.N.c(getString(R.string.pass_liveness_permission_camera));
            this.N.c(getString(R.string.pass_bio_alert_dialog_btn_go_setting), new m());
            this.N.a(getString(R.string.pass_bio_alert_dialog_btn_cancel), new n());
        }
        this.N.setCancelable(false);
        if (isFinishing() || this.N.isShowing()) {
            return;
        }
        this.N.show();
    }

    private void B() {
        this.i0.z = 1;
        this.q.f9143a = 17;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.q.f9146d = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.c cVar = this.q;
        if (cVar.f9143a == 0) {
            cVar.f9143a = 1;
        }
        this.i0.J = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.x = this.w;
        this.f9089h.setVisibility(0);
        if (this.f0 != null) {
            int index = this.w.getIndex();
            String[] strArr = this.f0;
            if (index < strArr.length) {
                this.f9089h.setText(strArr[this.w.getIndex()]);
            }
        }
        HeadPose headPose = this.x;
        if (headPose == null || headPose != this.w) {
            HeadPose headPose2 = this.w;
            if (headPose2 == HeadPose.EYES_BLINK) {
                this.q.f9143a = 5;
                this.i0.L = System.currentTimeMillis();
            } else if (headPose2 == HeadPose.MOUTH_OPEN) {
                this.q.f9143a = 7;
                this.i0.N = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.s != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.s.onFailure(passFaceRecogResult);
        }
    }

    public static /* synthetic */ int g(PassLivenessRecogActivity passLivenessRecogActivity) {
        int i2 = passLivenessRecogActivity.P + 1;
        passLivenessRecogActivity.P = i2;
        return i2;
    }

    public static /* synthetic */ int h(PassLivenessRecogActivity passLivenessRecogActivity) {
        int i2 = passLivenessRecogActivity.P - 1;
        passLivenessRecogActivity.P = i2;
        return i2;
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    private void y() {
        this.i0.C = 1;
        this.q.f9143a = 17;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
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

    private void z() {
        if (this.X == null) {
            return;
        }
        CircleProgressView circleProgressView = this.f9088g;
        if (circleProgressView != null) {
            circleProgressView.setVisibility(8);
        }
        showLoadingView(this.X);
        this.b0 = true;
    }

    public void addRandomActionList(List<HeadPose> list, Integer num, HeadPose headPose) {
        if (list != null && (num.intValue() & headPose.getValue()) == headPose.getValue()) {
            list.add(headPose);
        }
    }

    public boolean checkFaceInfo() {
        if (this.H) {
            return false;
        }
        if (o()) {
            Message message = new Message();
            message.what = 1001;
            this.d0.sendMessage(message);
            return false;
        }
        FaceInfo[] faceInfoArr = this.C;
        if (!b(faceInfoArr)) {
            Message message2 = new Message();
            message2.what = 1002;
            this.d0.sendMessage(message2);
            this.q.f9145c = false;
            return false;
        } else if (!a(faceInfoArr)) {
            Message message3 = new Message();
            message3.what = 1003;
            this.d0.sendMessage(message3);
            this.q.f9145c = false;
            return false;
        } else {
            this.q.f9145c = true;
            FaceTracker.ErrCode errCode = this.D;
            if (errCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                Message message4 = new Message();
                message4.what = 1005;
                this.d0.sendMessage(message4);
                return false;
            } else if (!this.g0 && a(faceInfoArr[0], errCode)) {
                Message message5 = new Message();
                message5.what = 1006;
                this.d0.sendMessage(message5);
                return false;
            } else if (!this.g0 && PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, this.F)) {
                Message message6 = new Message();
                message6.what = 1007;
                this.d0.sendMessage(message6);
                return false;
            } else if (this.g0 || !PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, this.F)) {
                return true;
            } else {
                Message message7 = new Message();
                message7.what = 1008;
                this.d0.sendMessage(message7);
                return false;
            }
        }
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
        this.f9087f = viewGroup;
        setContentView(viewGroup);
        l();
        n();
        x();
        this.B.a(new h());
        u();
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CameraPreview cameraPreview = this.l;
        if (cameraPreview != null) {
            cameraPreview.b();
        }
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.B;
        if (bVar != null) {
            bVar.b();
        }
        s sVar = this.d0;
        if (sVar != null) {
            sVar.removeCallbacksAndMessages(null);
        }
        this.H = true;
        this.Q = null;
        this.O = null;
        this.L.clear();
        this.L = null;
        this.X = null;
        TimerTask timerTask = this.a0;
        if (timerTask != null) {
            timerTask.cancel();
            this.Y.purge();
            this.a0 = null;
            this.Y = null;
        }
        try {
            c();
            a(this.f9087f);
            this.f9087f.removeCallbacks(null);
            this.f9087f = null;
            System.gc();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        a();
        if (i2 == 4) {
            E();
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
        this.W = true;
        if (this.q.f9149g) {
            return;
        }
        this.c0 = false;
        CameraPreview cameraPreview = this.l;
        if (cameraPreview != null) {
            cameraPreview.b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.q.f9149g = false;
        if (i2 == 2002) {
            if (iArr.length > 0 && iArr[0] == 0) {
                C();
                this.i0.F = System.currentTimeMillis();
                boolean s2 = s();
                com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
                bVar.f9135d = 1;
                bVar.f9136e = 1;
                if (s2) {
                    bVar.G = System.currentTimeMillis();
                    return;
                }
                return;
            }
            A();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.W) {
            this.W = false;
            if (this.b0) {
                return;
            }
            com.baidu.pass.biometrics.face.liveness.b.c cVar = this.q;
            if (cVar.f9149g) {
                return;
            }
            int i2 = cVar.f9143a;
            if (i2 < 10) {
                C();
                s();
            } else if (i2 == 17) {
                s();
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
            a2 = com.baidu.pass.biometrics.face.liveness.c.c.a(this, a2);
        }
        this.m.setImageBitmap(a2);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void d() {
        if (this.O == null || this.Q == null || this.H) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            FaceSDK.getARGBFromYUVimg(this.O, this.Q, this.R, this.S, this.T, 1);
            this.D = this.z.face_verification(this.Q, this.R, this.S, FaceSDK.ImgType.ARGB, G0, "", "", "");
            this.C = this.z.get_TrackedFaceInfo();
            if (this.c0 && checkFaceInfo()) {
                if (!this.q.f9144b) {
                    this.q.f9144b = true;
                    Message message = new Message();
                    message.what = 1009;
                    this.d0.sendMessage(message);
                    this.q.f9143a = 2;
                }
                this.i0.K = System.currentTimeMillis();
                if (this.L == null) {
                    this.L = new ArrayList();
                }
                int i2 = (this.C == null || this.C.length <= 0 || this.C[0] == null) ? 0 : this.C[0].face_id;
                if (i2 != 0 && i2 != this.U) {
                    this.L.clear();
                }
                this.U = i2;
                if (this.L.size() < 3) {
                    if (this.O != null) {
                        this.L.add(this.O);
                        return;
                    }
                    return;
                } else if (this.h0 || b()) {
                    this.i0.f9138g = 1;
                    this.O = null;
                    this.q.f9143a = 9;
                    Message message2 = new Message();
                    message2.what = 1013;
                    this.d0.sendMessage(message2);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Log.w(k0, "idl tracker time" + currentTimeMillis2);
                    com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
                    bVar.H = bVar.H + currentTimeMillis2;
                    this.i0.I++;
                    return;
                } else {
                    return;
                }
            }
            this.z.clearTrackedFaces();
            this.q.f9144b = false;
            this.i0.f9138g = 0;
            this.i0.J = System.currentTimeMillis();
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    private String e() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (this.t.isOriginImg()) {
            List<byte[]> list = this.L;
            if (list == null || list.isEmpty() || this.L.size() < this.I) {
                return "";
            }
            while (i2 < this.I) {
                Bitmap a2 = com.baidu.pass.biometrics.face.liveness.c.a.a(this.L.get(i2), this.R, this.S);
                PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
                if (passFaceRecogDTO == null) {
                    sb.append(Base64Utils.encodeToString(com.baidu.pass.biometrics.face.liveness.c.a.a(a2, 80)));
                    if (i2 != this.I - 1) {
                        sb.append(",");
                    }
                } else {
                    int i3 = passFaceRecogDTO.quality;
                    sb.append(Base64Utils.encodeToString(com.baidu.pass.biometrics.face.liveness.c.a.a(a2, i3 != 0 ? i3 : 80)));
                    if (i2 != this.I - 1) {
                        sb.append(",");
                    }
                }
                i2++;
            }
        } else {
            ArrayList<HashMap<String, byte[]>> arrayList = this.J;
            if (arrayList == null || arrayList.isEmpty() || this.J.size() < this.I) {
                return "";
            }
            while (i2 < this.I) {
                sb.append(Base64Utils.encodeToString(this.J.get(i2).get("data")));
                if (i2 != this.I - 1) {
                    sb.append(",");
                }
                i2++;
            }
        }
        String sb2 = sb.toString();
        this.K = sb2;
        return sb2;
    }

    private int f() {
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

    private void g() {
        while (this.e0.size() < 3) {
            HeadPose headPoseByIndex = HeadPose.getHeadPoseByIndex(Integer.valueOf(new Random().nextInt(6)));
            if (!this.e0.contains(headPoseByIndex)) {
                this.e0.add(headPoseByIndex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.baidu.pass.biometrics.face.liveness.b.c cVar = this.q;
        cVar.f9146d = 0L;
        if (!cVar.f9148f) {
            B();
            this.q.f9148f = true;
            return;
        }
        y();
    }

    private void i() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty("frfsd_ai")) {
            try {
                FaceTracker faceTracker = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
                this.z = faceTracker;
                faceTracker.set_isFineAlign(false);
                this.z.set_isVerifyLive(true);
                this.z.set_min_face_size(this.t.getMinFaceSize());
                this.z.set_illum_thr(this.t.getIllumThr());
                this.z.set_track_by_detection_interval(this.t.getTrackInterval());
                this.z.set_detect_in_video_interval(this.t.getDetectInterval());
                this.z.set_eulur_angle_thr(this.t.getYaw(), this.t.getPitch(), this.t.getRoll());
                this.z.set_max_reg_img_num(this.t.getMaxRegImgNum());
                this.z.set_prefetch_reg_img_interval(this.t.getPrefetchRegImgInterval());
                this.z.set_cropFaceSize(this.t.getCropFaceSize());
                this.z.set_cropFaceEnlargeRatio(this.t.getCropFaceRatio());
                return;
            } catch (Exception e2) {
                throw new Exception("init faceTracker failure: " + e2.getMessage());
            }
        }
        throw new Exception("idlToken or apiKey is empty");
    }

    private void j() {
        try {
            i();
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

    private void k() {
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.t = livenessConfigOption;
        this.u = livenessConfigOption.getRecogtimeInterval();
        this.v = this.t.getRecogActionType();
    }

    private void l() {
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
        this.f0 = getResources().getStringArray(R.array.pass_liveness_head_pose);
        this.q = new com.baidu.pass.biometrics.face.liveness.b.c();
        this.r = new com.baidu.pass.biometrics.face.liveness.b.a();
        this.q.f9146d = System.currentTimeMillis();
        this.s = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        k();
        m();
        this.w = this.e0.get(this.y);
        j();
        this.A = f();
        this.B = new com.baidu.pass.biometrics.face.liveness.c.b(this);
    }

    private void m() {
        List<Integer> list;
        List<HeadPose> list2 = this.e0;
        if (list2 == null) {
            this.e0 = new ArrayList();
        } else {
            list2.clear();
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
        if (livenessConfigOption != null && (list = livenessConfigOption.action) != null && !list.isEmpty()) {
            try {
                b(this.t.action);
                return;
            } catch (Exception unused) {
                g();
                return;
            }
        }
        g();
    }

    private void n() {
        if (this.i0 == null) {
            this.i0 = new com.baidu.pass.biometrics.face.liveness.b.b();
        }
        this.i0.E = getIntent().getLongExtra(EXTRA_TIME_POINT_START, System.currentTimeMillis());
        com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
        bVar.f9137f = 1;
        PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
        bVar.f9133b = passFaceRecogDTO != null ? passFaceRecogDTO.getSpno() : "unknown";
        com.baidu.pass.biometrics.face.liveness.b.b bVar2 = this.i0;
        bVar2.n = this.A;
        bVar2.o = 1;
        PassFaceRecogDTO passFaceRecogDTO2 = this.mPassFaceRecogDTO;
        bVar2.f9132a = passFaceRecogDTO2 != null ? passFaceRecogDTO2.livenessType.getRecogTypeName() : "unknown_type";
    }

    private boolean o() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.c cVar = this.q;
        long j2 = cVar.f9146d;
        return currentTimeMillis - j2 > cVar.f9147e && j2 > 0;
    }

    private void p() {
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
        httpHashMapWrap.put("image", e());
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.t.isOriginImg() ? "1" : "0");
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, this.f9086e);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.s != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-206);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            this.s.onFailure(passFaceRecogResult);
            setActivityResult(-1);
        }
        this.i0.r = "pass";
        a(-206);
    }

    private void r() {
        if (this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
        httpHashMapWrap.put("image", e());
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.t.isOriginImg() ? "1" : "0");
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, this.f9086e);
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

    private boolean s() {
        boolean z = false;
        try {
        } catch (Exception e2) {
            Log.e(k0, e2);
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.b();
            }
        }
        if (this.l == null) {
            return false;
        }
        this.d0.sendEmptyMessageDelayed(101, 800L);
        this.l.c();
        this.l.setPreviewCallback(this.j0);
        Camera.Size previewSize = this.l.getPreviewSize();
        com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
        bVar.f9134c = previewSize.height + "," + previewSize.width;
        z = true;
        if (!z) {
            A();
        } else {
            CameraPreview cameraPreview2 = this.l;
            if (cameraPreview2 != null) {
                cameraPreview2.getPreviewSize();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        int i2 = this.q.f9143a;
        if (i2 == 0 || i2 == 17 || i2 == 19 || i2 == 18 || i2 == 10 || i2 != 9 || this.D != FaceTracker.ErrCode.OK) {
            return;
        }
        a(ProgressStatus.GO);
        FaceVerifyData[] faceVerifyDataArr = this.z.get_FaceVerifyData(0);
        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
            return;
        }
        this.q.f9143a = 10;
        this.c0 = false;
        z();
        a(a(faceVerifyDataArr));
    }

    @TargetApi(23)
    private void u() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
            if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
                this.q.f9149g = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            } else if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
                bVar.c(getString(R.string.pass_bio_pmn_ok), new k(bVar));
                bVar.a(getString(R.string.pass_bio_pmn_cancel), new l(bVar));
                bVar.b(String.format(getString(R.string.pass_bio_pmn_title_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.a(String.format(getString(R.string.pass_bio_pmn_msg_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                bVar.show();
                return;
            } else {
                this.q.f9149g = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            }
        }
        C();
        this.i0.F = System.currentTimeMillis();
        if (s()) {
            com.baidu.pass.biometrics.face.liveness.b.b bVar2 = this.i0;
            bVar2.f9135d = 1;
            bVar2.G = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.y = 0;
        this.w = this.e0.get(0);
        this.g0 = false;
        this.h0 = false;
        this.q.f9144b = false;
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.r;
        aVar.f9129b = false;
        aVar.f9130c = false;
        List<byte[]> list = this.L;
        if (list == null) {
            this.L = new ArrayList();
        } else {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f9090i.setVisibility(4);
        this.f9089h.setVisibility(0);
        this.E = -1;
        this.f9089h.setText(R.string.pass_liveness_frist_text);
    }

    private void x() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        this.f9088g = (CircleProgressView) findViewById(R.id.pass_bio_liveness_recog_cpv);
        TextView textView = (TextView) findViewById(R.id.pass_bio_liveness_recog_tip_text);
        this.f9089h = textView;
        textView.setText(R.string.pass_liveness_frist_text);
        this.f9088g.setNormalColor(Color.parseColor("#FFE0E0E0"));
        this.f9088g.setOnChangeListener(new i());
        this.f9090i = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.j = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.k = (TextView) findViewById(R.id.tv_pose_warning_tip);
        setBrightness(this, 255);
        ((ImageView) findViewById(R.id.pass_bio_liveness_recog_close)).setOnClickListener(new j());
        this.l = (CameraPreview) findViewById(R.id.pass_bio_camera_pre_view);
        this.m = (CircleImageView) findViewById(R.id.pass_bio_circle_image_view);
        this.n = (CircleImageView) findViewById(R.id.pass_bio_circle_hide_view);
        this.o = (LinearLayout) findViewById(R.id.pass_bio_loading_view);
    }

    private void c() {
        for (SoftReference<Bitmap> softReference : this.G.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private void b(List<Integer> list) {
        int i2;
        int i3;
        int i4;
        if (this.e0 == null) {
            this.e0 = new ArrayList();
        }
        int size = list.size() - 1;
        while (true) {
            boolean z = false;
            if (size <= 0) {
                break;
            }
            Integer num = list.get(size);
            if (num != null) {
                if ((num.intValue() == HeadPose.EYES_BLINK.f9093b || num.intValue() == HeadPose.DOWN.f9093b || num.intValue() == HeadPose.UP.f9093b || num.intValue() == HeadPose.TURN_LEFT.f9093b || num.intValue() == HeadPose.TURN_RIGHT.f9093b || num.intValue() == HeadPose.MOUTH_OPEN.f9093b) ? true : true) {
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
                boolArr[i6] = Boolean.valueOf(num2.intValue() == HeadPose.EYES_BLINK.f9093b || num2.intValue() == HeadPose.DOWN.f9093b || num2.intValue() == HeadPose.UP.f9093b || num2.intValue() == HeadPose.TURN_LEFT.f9093b || num2.intValue() == HeadPose.TURN_RIGHT.f9093b || num2.intValue() == HeadPose.MOUTH_OPEN.f9093b);
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
        this.e0.addAll(Arrays.asList(headPoseArr));
        while (this.e0.contains(null)) {
            this.e0.remove((Object) null);
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
        this.c0 = false;
        this.i0.P = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
        bVar.Q = i2;
        bVar.a(this);
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    private boolean a(float f2) {
        return f2 <= ((float) this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void a(Camera camera) {
        if (this.R == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.l.a()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.R = previewSize.width;
            this.S = previewSize.height;
            this.T = cameraInfo.orientation;
        }
        if (this.F == null) {
            this.F = r5;
            int[] iArr = {this.S, this.R};
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
        if (livenessConfigOption == null || TextUtils.isEmpty(livenessConfigOption.minFaceSize)) {
            if (this.R > 640 && this.S > 480) {
                this.z.set_min_face_size(200);
            } else {
                this.z.set_min_face_size(100);
            }
        }
        if (this.Q == null) {
            this.Q = new int[this.R * this.S];
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
        return faceInfoArr != null && faceInfoArr.length > 0 && PassBiometricUtil.isFaceInsideRound(faceInfoArr[0].landmarks, this.F);
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

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        if (!this.M && a(f2)) {
            this.M = true;
            this.B.b();
            com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
            bVar.m = f2;
            bVar.l = 1;
        }
    }

    private boolean b(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f9090i.setVisibility(0);
        if (this.E != i2) {
            if (i2 == 1) {
                this.i0.v++;
                this.k.setText(getString(R.string.pass_liveness_tofar_from_camera));
            } else if (i2 == 0) {
                this.i0.u++;
                this.k.setText(getString(R.string.pass_liveness_tonear_from_camera));
            } else if (i2 == 2) {
                this.i0.y++;
                this.k.setText(getString(R.string.pass_liveness_brightness_too_dark));
            } else if (i2 == 4) {
                this.i0.w++;
                this.k.setText(getString(R.string.pass_liveness_face_to_screen));
            } else {
                this.i0.x++;
                this.k.setText(getString(R.string.pass_liveness_put_face_round));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new c(loadAnimation));
            if (!this.r.f9128a) {
                this.j.startAnimation(loadAnimation);
                this.r.f9128a = true;
            }
        }
        this.E = i2;
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
            this.I = size;
            this.J = arrayList;
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
            if (livenessConfigOption != null) {
                this.I = livenessConfigOption.getRecogUploadPortraitCount(size);
            }
            if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                r();
            } else {
                p();
            }
        }
    }

    private boolean b() {
        boolean is_live;
        if (this.H) {
            return false;
        }
        if (o()) {
            Message message = new Message();
            message.what = 1001;
            this.d0.sendMessage(message);
            return false;
        }
        FaceInfo[] faceInfoArr = this.C;
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        this.g0 = true;
        Message message2 = new Message();
        message2.what = 1010;
        this.d0.sendMessage(message2);
        this.q.f9143a = 3;
        switch (f.f9103a[this.w.ordinal()]) {
            case 1:
                is_live = faceInfoArr[0].is_live();
                this.q.f9143a = 6;
                com.baidu.pass.biometrics.face.liveness.b.b bVar = this.i0;
                bVar.p = com.baidu.pass.biometrics.face.liveness.b.b.a0;
                if (is_live) {
                    bVar.f9140i++;
                    bVar.M = System.currentTimeMillis();
                    this.i0.k = com.baidu.pass.biometrics.face.liveness.b.b.a0;
                    break;
                }
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
                this.q.f9143a = 8;
                com.baidu.pass.biometrics.face.liveness.b.b bVar2 = this.i0;
                bVar2.p = com.baidu.pass.biometrics.face.liveness.b.b.b0;
                if (is_live) {
                    bVar2.j++;
                    bVar2.O = System.currentTimeMillis();
                    this.i0.k = com.baidu.pass.biometrics.face.liveness.b.b.b0;
                    break;
                }
                break;
            default:
                is_live = false;
                break;
        }
        Log.e("LivenessRecogmode", "is_live:" + faceInfoArr[0].is_live() + " , head_up:" + faceInfoArr[0].is_live_head_up() + " , head_down:" + faceInfoArr[0].is_live_head_down() + " , turn_right:" + faceInfoArr[0].is_live_head_turn_right() + " , turn_left:" + faceInfoArr[0].is_live_head_turn_left() + " , live_mouth:" + faceInfoArr[0].is_live_mouth());
        if (!is_live) {
            Message message3 = new Message();
            message3.what = 1009;
            this.d0.sendMessage(message3);
            this.q.f9143a = 2;
            return false;
        } else if (this.y != this.e0.size() - 1) {
            List<HeadPose> list = this.e0;
            int i2 = this.y + 1;
            this.y = i2;
            this.w = list.get(i2);
            return false;
        } else {
            this.g0 = false;
            this.h0 = true;
            Message message4 = new Message();
            message4.what = 1011;
            this.d0.sendMessage(message4);
            return true;
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
            this.i0.r = com.baidu.pass.biometrics.face.liveness.b.b.g0;
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
            q();
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
                if (this.L != null && !this.L.isEmpty()) {
                    Bitmap a3 = com.baidu.pass.biometrics.face.liveness.c.a.a(this.L.get(0), this.R, this.S);
                    int i2 = 80;
                    if (this.mPassFaceRecogDTO == null) {
                        a2 = com.baidu.pass.biometrics.face.liveness.c.a.a(a3, 80);
                    } else {
                        if (this.mPassFaceRecogDTO.quality != 0) {
                            i2 = this.mPassFaceRecogDTO.quality;
                        }
                        a2 = com.baidu.pass.biometrics.face.liveness.c.a.a(a3, i2);
                    }
                    passFaceRecogResult.originalImage = Base64Utils.encodeToString(a2);
                    if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEIMAGE) {
                        passFaceRecogResult.faceimage = Base64Utils.encodeToString(a2);
                    }
                }
                if (this.J != null && !this.J.isEmpty()) {
                    if (this.mPassFaceRecogDTO.livenessType != PassFaceRecogType.RECOG_TYPE_FACEIMAGE && (encode = Base64Utils.encode(this.J.get(0).get("data"))) != null) {
                        passFaceRecogResult.faceimage = new String(encode);
                    }
                    byte[] bArr = this.J.get(0).get(LightappBusinessClient.MTD_DIGEST);
                    if (bArr != null) {
                        passFaceRecogResult.imgdigests = new String(bArr);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (contrastPortraitResult.isProcessPass()) {
            this.i0.r = "pass";
            this.s.onSuccess(passFaceRecogResult);
        } else {
            this.i0.r = com.baidu.pass.biometrics.face.liveness.b.b.g0;
            this.s.onFailure(passFaceRecogResult);
        }
        a(passFaceRecogResult.getResultCode());
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
                    if (this.L != null && !this.L.isEmpty()) {
                        Bitmap a3 = com.baidu.pass.biometrics.face.liveness.c.a.a(this.L.get(0), this.R, this.S);
                        int i2 = 80;
                        if (this.mPassFaceRecogDTO == null) {
                            a2 = com.baidu.pass.biometrics.face.liveness.c.a.a(a3, 80);
                        } else {
                            if (this.mPassFaceRecogDTO.quality != 0) {
                                i2 = this.mPassFaceRecogDTO.quality;
                            }
                            a2 = com.baidu.pass.biometrics.face.liveness.c.a.a(a3, i2);
                        }
                        passFaceRecogResult.originalImage = Base64Utils.encodeToString(a2);
                    }
                    if (this.J != null && !this.J.isEmpty()) {
                        byte[] encode = Base64Utils.encode(this.J.get(0).get("data"));
                        if (encode != null) {
                            passFaceRecogResult.faceimage = new String(encode);
                        }
                        byte[] bArr = this.J.get(0).get(LightappBusinessClient.MTD_DIGEST);
                        if (bArr != null) {
                            passFaceRecogResult.imgdigests = new String(bArr);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            passFaceRecogResult.setResultCode(0);
            this.i0.r = "pass";
            this.s.onSuccess(passFaceRecogResult);
            a(passFaceRecogResult.getResultCode());
        } catch (JSONException unused2) {
            a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProgressStatus progressStatus) {
        ProgressStatus progressStatus2 = this.Z;
        if ((progressStatus2 == null || progressStatus2 != progressStatus) && this.Y != null) {
            this.Z = progressStatus;
            int i2 = f.f9104b[progressStatus.ordinal()];
            if (i2 == 1) {
                TimerTask timerTask = this.a0;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.Y.purge();
                }
                r rVar = new r(this, null);
                this.a0 = rVar;
                this.Y.schedule(rVar, 0L, 10L);
            } else if (i2 != 2) {
            } else {
                TimerTask timerTask2 = this.a0;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    this.Y.purge();
                }
                q qVar = new q(this, null);
                this.a0 = qVar;
                this.Y.schedule(qVar, 0L, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i2 = this.q.f9143a;
        if (i2 < 4) {
            this.i0.s = com.baidu.pass.biometrics.face.liveness.b.b.c0;
        } else if (i2 < 9) {
            HeadPose headPose = this.w;
            if (headPose == HeadPose.EYES_BLINK) {
                this.i0.s = com.baidu.pass.biometrics.face.liveness.b.b.d0;
            } else if (headPose == HeadPose.MOUTH_OPEN) {
                this.i0.s = com.baidu.pass.biometrics.face.liveness.b.b.e0;
            }
        }
    }
}
