package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.RSA;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.c.b;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.enums.ProgressStatus;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.http.ReqPriority;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.Degree;
import com.baidu.sofire.face.api.FaceApi;
import com.baidu.sofire.face.api.FaceProcessCallback;
import com.baidu.sofire.face.api.FaceVerifyInfo;
import com.baidu.sofire.face.api.RequestInfo;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.fun.ad.sdk.FunAdSdk;
import com.google.protobuf.CodedInputStream;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard, FaceProcessCallback, View.OnClickListener {
    public static final String Q = "PassLivenessRecogActivity";
    public static final int R = 2002;
    public static final int S = 7126;
    public static final int T = 7127;
    public static final int U = 112;
    public static final int V = 255;
    public boolean A;
    public TimerTask C;
    public ProgressStatus D;
    public com.baidu.pass.biometrics.face.liveness.b.a E;
    public LivenessTypeEnum F;
    public long G;
    public PassFaceRecogCallback H;
    public TextView I;
    public TextView J;
    public ImageView K;
    public RelativeLayout L;
    public String N;
    public ViewGroup e;
    public CircleProgressView f;
    public TextView g;
    public FrameLayout h;
    public ImageView i;
    public TextView j;
    public CameraSurfaceView k;
    public CircleImageView l;
    public CircleImageView m;
    public LinearLayout n;
    public com.baidu.pass.biometrics.face.liveness.d.a o;
    public SdkConfigOptions.LivenessConfigOption p;
    public int q;
    public com.baidu.pass.biometrics.face.liveness.c.b r;
    public boolean s;
    public boolean t;
    public boolean x;
    public boolean y;
    public boolean z;
    public boolean u = false;
    public boolean v = true;
    public boolean w = true;
    public Timer B = new Timer(true);
    public Boolean M = Boolean.TRUE;
    public boolean O = false;
    public boolean P = false;

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void animStop() {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBeginBuildData() {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onDeviceCheckResult(int i2) {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onTestFrame(Bitmap bitmap) {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void setFaceInfo(FaceExtInfo faceExtInfo) {
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void viewReset() {
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;

        public a(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PassLivenessRecogActivity.this.E.a();
            PassLivenessRecogActivity.this.E.B = 1;
            PassLivenessRecogActivity.this.onResume();
            this.a.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;

        public b(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.dismiss();
            PassLivenessRecogActivity.this.u();
            PassLivenessRecogActivity.this.E.A = 1;
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;

        public c(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.dismiss();
            PassLivenessRecogActivity.this.E.D = 1;
            PassLivenessRecogActivity.this.setActivityResult(-1);
            if (PassLivenessRecogActivity.this.H != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-301);
                PassLivenessRecogActivity.this.H.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a(-301);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements PixelCopy.OnPixelCopyFinishedListener {
        public final /* synthetic */ PixelCopyCallback a;
        public final /* synthetic */ Bitmap b;

        public d(PixelCopyCallback pixelCopyCallback, Bitmap bitmap) {
            this.a = pixelCopyCallback;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.a.onFinsh(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends HttpHandlerWrap {
        public e(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            PassLivenessRecogActivity.this.b(str);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            PassLivenessRecogActivity.this.E.Q = i;
            PassLivenessRecogActivity.this.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends HttpHandlerWrap {
        public f(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            PassLivenessRecogActivity.this.a(str);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            PassLivenessRecogActivity.this.E.Q = i;
            PassLivenessRecogActivity.this.f();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;

        public g(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PassLivenessRecogActivity.this.onResume();
            this.a.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;

        public h(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.dismiss();
            PassLivenessRecogActivity.this.u();
            PassLivenessRecogActivity.this.a();
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a(-204);
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class i {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ProgressStatus.values().length];
            b = iArr;
            try {
                iArr[ProgressStatus.GO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ProgressStatus.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            a = iArr2;
            try {
                iArr2[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePoorIllumination.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveEye.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYaw.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionComplete.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTimeout.ordinal()] = 19;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements b.InterfaceC0120b {
        public j() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.c.b.InterfaceC0120b
        public void a(float f) {
            PassLivenessRecogActivity.this.b(f);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements CircleProgressView.b {
        public k() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView.b
        public void a(float f, float f2) {
            if (f == 100.0f) {
                PassLivenessRecogActivity.this.f.setShowTick(false);
            } else {
                PassLivenessRecogActivity.this.f.setShowTick(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;

        public l(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.a);
            PassLivenessRecogActivity.this.y = true;
            PassLivenessRecogActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;

        public m(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.a);
            if (PassLivenessRecogActivity.this.H != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                PassLivenessRecogActivity.this.H.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
        }
    }

    /* loaded from: classes2.dex */
    public class n extends HttpHandlerWrap {
        public n(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (PassLivenessRecogActivity.this.isFinishing()) {
                return;
            }
            PassLivenessRecogActivity.this.hideLoadingView();
            PassLivenessRecogActivity.this.g();
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            if (PassLivenessRecogActivity.this.isFinishing()) {
                return;
            }
            PassLivenessRecogActivity.this.hideLoadingView();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code") == 110000) {
                    PassLivenessRecogActivity.this.O = true;
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        String[] split = optJSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS).split("_");
                        String str2 = split[0];
                        String str3 = split[1];
                        String decrypt = RSA.decrypt(str2);
                        String trim = new String(SecurityUtil.aesDecrypt(Base64.decode(str3, 0), new StringBuffer(decrypt).reverse().toString(), decrypt), "UTF-8").trim();
                        if (TextUtils.isEmpty(trim)) {
                            PassLivenessRecogActivity.this.g();
                            return;
                        }
                        String[] split2 = trim.replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "").split(",");
                        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
                        if (faceConfig == null) {
                            faceConfig = new FaceConfig();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (String str4 : split2) {
                            char c = 65535;
                            switch (str4.hashCode()) {
                                case 49:
                                    if (str4.equals("1")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 50:
                                    if (str4.equals("2")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 51:
                                    if (str4.equals("3")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 52:
                                    if (str4.equals("4")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 53:
                                    if (str4.equals("5")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 54:
                                    if (str4.equals("6")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c != 3) {
                                            if (c != 4) {
                                                if (c == 5) {
                                                    arrayList.add(LivenessTypeEnum.HeadDown);
                                                }
                                            } else {
                                                arrayList.add(LivenessTypeEnum.HeadUp);
                                            }
                                        } else {
                                            arrayList.add(LivenessTypeEnum.HeadRight);
                                        }
                                    } else {
                                        arrayList.add(LivenessTypeEnum.HeadLeft);
                                    }
                                } else {
                                    arrayList.add(LivenessTypeEnum.Mouth);
                                }
                            } else {
                                arrayList.add(LivenessTypeEnum.Eye);
                            }
                        }
                        faceConfig.setLivenessTypeList(arrayList);
                        FaceSDKManager.getInstance().setFaceConfig(faceConfig);
                    }
                }
            } catch (Exception e) {
                Log.e("requestLivingAction", "Exception = " + e.getMessage());
                e.printStackTrace();
            }
            PassLivenessRecogActivity.this.g();
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PassLivenessRecogActivity.this.o.dismiss();
            PassLivenessRecogActivity.this.y = false;
            if (PassLivenessRecogActivity.this.H != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                PassLivenessRecogActivity.this.H.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setData(Uri.fromParts("package", PassLivenessRecogActivity.this.getPackageName(), null));
            if (intent.resolveActivity(PassLivenessRecogActivity.this.getPackageManager()) != null) {
                PassLivenessRecogActivity.this.startActivity(intent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PassLivenessRecogActivity.this.o.dismiss();
            PassLivenessRecogActivity.this.y = false;
            if (PassLivenessRecogActivity.this.H != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                PassLivenessRecogActivity.this.H.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
        }
    }

    /* loaded from: classes2.dex */
    public class q implements PixelCopyCallback {
        public q() {
        }

        @Override // com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback
        public void onFinsh(Bitmap bitmap) {
            PassLivenessRecogActivity.this.l.setImageBitmap(com.baidu.pass.biometrics.face.liveness.c.c.a(PassLivenessRecogActivity.this, bitmap));
        }
    }

    /* loaded from: classes2.dex */
    public class r implements Animation.AnimationListener {
        public final /* synthetic */ Animation a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public r(Animation animation) {
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PassLivenessRecogActivity.this.i.startAnimation(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LivenessTypeEnum livenessTypeEnum = this.F;
        if (livenessTypeEnum == null) {
            this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.c0;
        } else if (livenessTypeEnum == LivenessTypeEnum.Eye) {
            this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.d0;
        } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
            this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.e0;
        }
    }

    private void b() {
        FaceApi.cancelFaceProcess();
        this.x = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.H != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-206);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            this.H.onFailure(passFaceRecogResult);
            setActivityResult(-1);
        }
        this.E.r = "pass";
        a(-206);
    }

    private void i() {
        if (!this.O) {
            k();
        } else {
            g();
        }
    }

    private void l() {
        this.h.setVisibility(4);
        this.g.setVisibility(0);
        this.g.setText(R.string.obfuscated_res_0x7f0f0e43);
        this.F = null;
    }

    private void o() {
        CircleProgressView circleProgressView = this.f;
        if (circleProgressView != null) {
            circleProgressView.setVisibility(8);
        }
        showLoadingView();
        this.t = true;
    }

    private void q() {
        this.l.c();
    }

    private void r() {
        l();
        onPause();
        if (this.v) {
            s();
            this.v = false;
            return;
        }
        n();
    }

    private void t() {
        this.h.setVisibility(8);
        this.h.clearAnimation();
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.H != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.H.onFailure(passFaceRecogResult);
        }
    }

    public void backBtnClick() {
        u();
        a();
        setActivityResult(0);
        a(-204);
    }

    public void hideLoadingView() {
        if (this.k == null) {
            return;
        }
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBegin() {
        this.l.setVisibility(0);
        this.l.setBackgroundColor(-1);
        this.g.setText(R.string.obfuscated_res_0x7f0f0e43);
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBeginCollectFaceInfo() {
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        if (aVar.J == 0) {
            aVar.J = System.currentTimeMillis();
        }
        this.G = System.currentTimeMillis();
        this.k.setVisibility(0);
        this.A = true;
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.y) {
            return;
        }
        this.P = true;
        b();
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.t && !this.y && this.P) {
            this.P = false;
            i();
        }
    }

    public void showLoadingView() {
        if (this.k == null) {
            return;
        }
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        if (aVar != null) {
            aVar.P = System.currentTimeMillis();
            this.E.a(this);
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        if (this.u || !a(f2)) {
            return;
        }
        this.u = true;
        this.r.b();
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        aVar.m = f2;
        aVar.l = 1;
    }

    private void c(String str) {
        a(ProgressStatus.BACK);
        this.g.setVisibility(0);
        this.g.setText(str);
        e(str);
    }

    private void d(String str) {
        this.w = false;
        a(ProgressStatus.GO);
        this.g.setText(str);
        this.g.setVisibility(0);
        t();
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        if (aVar.K == 0) {
            aVar.g = 1;
            aVar.K = System.currentTimeMillis();
        }
    }

    private void e(String str) {
        if (this.w) {
            return;
        }
        this.h.setVisibility(0);
        this.j.setText(str);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f0100f0);
        loadAnimation.setAnimationListener(new r(loadAnimation));
        if (!this.s) {
            this.i.startAnimation(loadAnimation);
            this.s = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.H != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(i2);
            passFaceRecogResult.setResultMsg(str);
            this.H.onFailure(passFaceRecogResult);
            setActivityResult(-1);
            this.E.r = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            a(passFaceRecogResult.getResultCode());
        }
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = i2 * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public void getBitmapFromSurfaceView(SurfaceView surfaceView, PixelCopyCallback pixelCopyCallback) {
        if (surfaceView == null) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 24) {
            PixelCopy.request(surfaceView, createBitmap, new d(pixelCopyCallback, createBitmap), surfaceView.getHandler());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            a();
            h();
            return false;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    private void a(View view2) {
        if (view2 == null) {
            return;
        }
        if (view2.getBackground() != null) {
            view2.getBackground().setCallback(null);
            view2.setBackgroundResource(0);
        }
        if (view2 instanceof ImageView) {
            ((ImageView) view2).setImageBitmap(null);
        }
        if (view2 instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (i2 < viewGroup.getChildCount()) {
                    a(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    viewGroup.removeAllViews();
                    view2.setBackgroundResource(0);
                    return;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.obfuscated_res_0x7f091936) {
            h();
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091935) {
            this.L.setVisibility(8);
            this.K.setVisibility(8);
            this.M = Boolean.TRUE;
            i();
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091939) {
            startActivity(new Intent(this, YYProtocolActivity.class));
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
        setContentView(R.layout.obfuscated_res_0x7f0d04f5);
        d();
        e();
        m();
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.r;
        if (bVar != null) {
            bVar.a(new j());
        }
        j();
    }

    @TargetApi(3)
    private void a(ContrastPortraitResult contrastPortraitResult) {
        if (this.H != null && contrastPortraitResult != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            if (contrastPortraitResult.isProcessPass()) {
                passFaceRecogResult.setResultCode(0);
            } else {
                passFaceRecogResult.setResultCode(contrastPortraitResult.getResultCode());
                passFaceRecogResult.setResultMsg(contrastPortraitResult.getResultMsg());
            }
            passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
            passFaceRecogResult.authSid = contrastPortraitResult.authsid;
            if (contrastPortraitResult.isProcessPass()) {
                this.E.r = "pass";
                this.H.onSuccess(passFaceRecogResult);
            } else {
                this.E.r = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                this.H.onFailure(passFaceRecogResult);
            }
            a(passFaceRecogResult.getResultCode());
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.y = false;
        if (i2 == 2002) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.E.F = System.currentTimeMillis();
                com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
                aVar.d = 1;
                aVar.e = 1;
                i();
                return;
            }
            p();
        }
    }

    private void a(ProgressStatus progressStatus) {
        ProgressStatus progressStatus2 = this.D;
        if ((progressStatus2 != null && progressStatus2 == progressStatus) || this.B == null || this.D == progressStatus) {
            return;
        }
        this.D = progressStatus;
        int i2 = i.b[progressStatus.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                TimerTask timerTask = this.C;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.B.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.a aVar = new com.baidu.pass.biometrics.face.liveness.enums.a(this.f);
                this.C = aVar;
                this.B.schedule(aVar, 0L, 10L);
                return;
            }
            return;
        }
        TimerTask timerTask2 = this.C;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.B.purge();
        }
        com.baidu.pass.biometrics.face.liveness.enums.b bVar = new com.baidu.pass.biometrics.face.liveness.enums.b(this.f);
        this.C = bVar;
        this.B.schedule(bVar, 0L, 10L);
    }

    private void a(RequestInfo requestInfo) {
        if (requestInfo == null) {
            return;
        }
        JSONObject jSONObject = requestInfo.data;
        String str = null;
        if (jSONObject != null) {
            str = jSONObject.optString("data");
        }
        o();
        if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            b(requestInfo.sKey, requestInfo.xDeviceId, str);
        } else {
            a(requestInfo.sKey, requestInfo.xDeviceId, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("retCode");
            this.E.Q = optInt;
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
            Log.e("TAG", e2.getMessage());
            f();
        }
        a(contrastPortraitResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.H == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("retCode");
            String optString = jSONObject.optString("retMsg");
            this.E.Q = optInt;
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("result");
            passFaceRecogResult.extraJson = jSONObject2;
            String optString2 = jSONObject2.optString("faceid");
            passFaceRecogResult.callbackkey = optString2;
            if (TextUtils.isEmpty(optString2)) {
                a(optInt, optString);
                return;
            }
            passFaceRecogResult.setResultCode(0);
            this.E.r = "pass";
            this.H.onSuccess(passFaceRecogResult);
            this.E.r = "pass";
            a(passFaceRecogResult.getResultCode());
        } catch (JSONException unused) {
            a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }

    private void a(String str, String str2, String str3) {
        String str4;
        if (this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        PassFaceRecogType passFaceRecogType = this.mPassFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put("type", "contrastportrait");
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            httpHashMapWrap.put("type", "certinfo");
            httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.mPassFaceRecogDTO.realName);
                jSONObject.put("cert", this.mPassFaceRecogDTO.idCardNum);
                jSONObject.put("bankmobile", this.mPassFaceRecogDTO.phoneNum);
                if (!TextUtils.isEmpty(this.N)) {
                    jSONObject.put("yyOrderId", this.N);
                }
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
            httpHashMapWrap.put("type", ConstPath.KEY_DETECT);
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
        }
        httpHashMapWrap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.mPassFaceRecogDTO.serviceType);
        httpHashMapWrap.put("image", str3);
        httpHashMapWrap.put("version", "1");
        if (this.p.isOriginImg()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        httpHashMapWrap.put("isOriginImg", str4);
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, 112);
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
        httpHashMapWrap.put("last", "1");
        if (!TextUtils.isEmpty(str)) {
            httpHashMapWrap.put("sKey", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("xDeviceId", str2);
        }
        httpHashMapWrap.put("isSafeSDK", "1");
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("face_debug", String.valueOf(this.mPassFaceRecogDTO.faceDebug));
        try {
            if (this.mPassFaceRecogDTO.extraParams != null) {
                for (String str5 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                    httpHashMapWrap.put(str5, (String) this.mPassFaceRecogDTO.extraParams.get(str5));
                }
            }
        } catch (Exception e3) {
            com.baidu.sapi2.utils.Log.e(Q, e3.getMessage());
        }
        httpHashMapWrap.put(FunAdSdk.PLATFORM_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new f(Looper.getMainLooper()));
    }

    private boolean a(float f2) {
        if (f2 <= this.q) {
            return true;
        }
        return false;
    }

    private void b(String str, String str2, String str3) {
        String str4;
        if (this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
        httpHashMapWrap.put("image", str3);
        httpHashMapWrap.put("version", "1");
        if (this.p.isOriginImg()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        httpHashMapWrap.put("isOriginImg", str4);
        String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, 112);
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
        if (!TextUtils.isEmpty(str)) {
            httpHashMapWrap.put("sKey", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("xDeviceId", str2);
        }
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("isSafeSDK", "1");
        httpHashMapWrap.put("face_debug", String.valueOf(this.mPassFaceRecogDTO.faceDebug));
        try {
            if (this.mPassFaceRecogDTO.extraParams != null) {
                for (String str5 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                    httpHashMapWrap.put(str5, (String) this.mPassFaceRecogDTO.extraParams.get(str5));
                }
            }
        } catch (Exception e2) {
            com.baidu.sapi2.utils.Log.e(Q, e2.getMessage());
        }
        httpHashMapWrap.put(FunAdSdk.PLATFORM_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new e(Looper.getMainLooper()));
    }

    private int c() {
        List<Integer> aBtestIllumList = this.p.getABtestIllumList();
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

    private void d() {
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
        this.H = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        this.p = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.q = c();
        this.r = new com.baidu.pass.biometrics.face.liveness.c.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        CameraSurfaceView cameraSurfaceView = this.k;
        if (cameraSurfaceView == null || cameraSurfaceView.getHolder() == null || this.x || !this.M.booleanValue()) {
            return;
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.p;
        if (livenessConfigOption != null && livenessConfigOption.mCloseFace) {
            this.w = false;
            e("当前刷脸功能正在升级中...");
        } else if (this.p != null) {
            FaceApi.startFaceSurfaceLiveness(this, this.k.getHolder(), this, 0, new FaceVerifyInfo(StringUtil.NULL_STRING, StringUtil.NULL_STRING, 0, null, null, null, null, StringUtil.NULL_STRING), true, this.p.getRecogUploadPortraitCount(3));
            this.x = true;
        }
    }

    private void s() {
        this.E.z = 1;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
        aVar.b(getString(R.string.obfuscated_res_0x7f0f0e42));
        aVar.c(0);
        aVar.a(getString(R.string.obfuscated_res_0x7f0f0e41));
        aVar.c(getString(R.string.obfuscated_res_0x7f0f0e1b), new a(aVar));
        aVar.a(getString(R.string.obfuscated_res_0x7f0f0e21), new b(aVar));
        aVar.setCancelable(false);
        if (!isFinishing() && !aVar.isShowing()) {
            aVar.show();
        }
    }

    private void e() {
        String str;
        String str2;
        if (this.E == null) {
            this.E = new com.baidu.pass.biometrics.face.liveness.b.a();
        }
        this.E.E = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        aVar.f = 1;
        PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
        if (passFaceRecogDTO != null) {
            str = passFaceRecogDTO.getSpno();
        } else {
            str = "unknown";
        }
        aVar.b = str;
        com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.E;
        aVar2.n = this.q;
        aVar2.o = 1;
        PassFaceRecogDTO passFaceRecogDTO2 = this.mPassFaceRecogDTO;
        if (passFaceRecogDTO2 != null) {
            str2 = passFaceRecogDTO2.livenessType.getRecogTypeName();
        } else {
            str2 = "unknown_type";
        }
        aVar2.a = str2;
    }

    private void h() {
        l();
        onPause();
        com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
        bVar.c("继续刷脸", new g(bVar));
        bVar.a("放弃刷脸", new h(bVar));
        bVar.a(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080756));
        bVar.b("确定放弃刷脸吗？");
        bVar.a("刷脸验证通过后可以提升帐号的安全性和使用的便捷性，建议您继续完成刷脸验证~");
        bVar.show();
    }

    private void n() {
        this.E.C = 1;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
        aVar.b(getString(R.string.obfuscated_res_0x7f0f0e48));
        aVar.c(getString(R.string.obfuscated_res_0x7f0f0e47));
        aVar.a(1);
        aVar.b(getString(R.string.obfuscated_res_0x7f0f0e1c), new c(aVar));
        aVar.setCancelable(false);
        if (!isFinishing() && !aVar.isShowing()) {
            aVar.show();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.r;
        if (bVar != null) {
            bVar.b();
        }
        TimerTask timerTask = this.C;
        if (timerTask != null) {
            timerTask.cancel();
            this.B.purge();
            this.C = null;
            this.B = null;
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            a(viewGroup);
            this.e.removeCallbacks(null);
            this.e = null;
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        try {
            System.gc();
        } catch (Exception e2) {
            Log.e("TAG", e2.getMessage());
        }
    }

    @TargetApi(23)
    private void j() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
            if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
                this.y = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            } else if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
                bVar.c(getString(R.string.obfuscated_res_0x7f0f0e3b), new l(bVar));
                bVar.a(getString(R.string.obfuscated_res_0x7f0f0e39), new m(bVar));
                bVar.b(String.format(getString(R.string.obfuscated_res_0x7f0f0e3c), PassBiometricUtil.getAppName(this), getString(R.string.obfuscated_res_0x7f0f0e38)));
                bVar.a(String.format(getString(R.string.obfuscated_res_0x7f0f0e3a), PassBiometricUtil.getAppName(this), getString(R.string.obfuscated_res_0x7f0f0e38)));
                bVar.show();
                return;
            } else {
                this.y = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                return;
            }
        }
        this.E.F = System.currentTimeMillis();
        i();
    }

    private void k() {
        if (this.mPassFaceRecogDTO == null || this.mConfiguration == null) {
            return;
        }
        showLoadingView();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("tpl", this.mConfiguration.tpl);
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put("clientfrom", "native");
        JSONObject jSONObject = new JSONObject();
        PassFaceRecogType passFaceRecogType = this.mPassFaceRecogDTO.livenessType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put("type", "bduss");
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            try {
                httpHashMapWrap.put("type", "certinfo");
                jSONObject.put("name", this.mPassFaceRecogDTO.realName);
                jSONObject.put("cert", this.mPassFaceRecogDTO.idCardNum);
                httpHashMapWrap.put("idnum", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
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
            httpHashMapWrap.put("type", ConstPath.KEY_DETECT);
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
        }
        httpHashMapWrap.put(FunAdSdk.PLATFORM_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getLivingActionUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new n(Looper.getMainLooper()));
    }

    private void m() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        this.f = (CircleProgressView) findViewById(R.id.obfuscated_res_0x7f091937);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091938);
        this.f.setNormalColor(Color.parseColor("#FFE0E0E0"));
        this.f.setOnChangeListener(new k());
        this.h = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091409);
        this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f09118c);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0925e4);
        this.k = (CameraSurfaceView) findViewById(R.id.obfuscated_res_0x7f09192c);
        this.l = (CircleImageView) findViewById(R.id.obfuscated_res_0x7f09192e);
        this.m = (CircleImageView) findViewById(R.id.obfuscated_res_0x7f09192d);
        this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09193b);
        setBrightness(this, 255);
        ((ImageView) findViewById(R.id.obfuscated_res_0x7f091936)).setOnClickListener(this);
        PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
        if (passFaceRecogDTO != null && passFaceRecogDTO.needAuthorizeCertInfo) {
            this.N = passFaceRecogDTO.extraParamsMap.get("yyOrderId");
            this.M = Boolean.FALSE;
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091f4f)).setText(R.string.obfuscated_res_0x7f0f090d);
            this.K = (ImageView) findViewById(R.id.obfuscated_res_0x7f09192f);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09193a);
            this.L = relativeLayout;
            relativeLayout.setVisibility(0);
            this.K.setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f091939).setOnClickListener(this);
            findViewById(R.id.obfuscated_res_0x7f091935).setOnClickListener(this);
            this.g.setText(R.string.obfuscated_res_0x7f0f0909);
        }
    }

    private void p() {
        this.y = true;
        if (this.o == null) {
            com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
            this.o = aVar;
            aVar.b(getString(R.string.obfuscated_res_0x7f0f0e37));
            this.o.b(true);
            this.o.c(getString(R.string.obfuscated_res_0x7f0f0e45));
            this.o.c(getString(R.string.obfuscated_res_0x7f0f0e1e), new o());
            this.o.a(getString(R.string.obfuscated_res_0x7f0f0e1d), new p());
        }
        this.o.setCancelable(false);
        if (!isFinishing() && !this.o.isShowing()) {
            this.o.show();
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
        Log.w("new_face", "faceStatusNewEnum " + faceStatusNewEnum + ",message = " + str);
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        aVar.I = aVar.I + 1;
        if (!this.x) {
            return;
        }
        if (this.A) {
            q();
            this.A = false;
        }
        switch (i.a[faceStatusNewEnum.ordinal()]) {
            case 1:
                t();
                if (Build.VERSION.SDK_INT >= 24) {
                    getBitmapFromSurfaceView(this.k, new q());
                    break;
                }
                break;
            case 2:
                this.E.u++;
                c(str);
                break;
            case 3:
                this.E.v++;
                c(str);
                break;
            case 4:
                this.E.y++;
                c(str);
                break;
            case 5:
                com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.E;
                aVar2.g = 0;
                aVar2.J = System.currentTimeMillis();
                this.E.x++;
                c(str);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.E.w++;
                c(str);
                break;
            case 11:
                this.F = LivenessTypeEnum.Eye;
                this.E.L = System.currentTimeMillis();
                d(str);
                break;
            case 12:
                this.F = LivenessTypeEnum.Mouth;
                this.E.N = System.currentTimeMillis();
                d(str);
                break;
            case 13:
                this.F = LivenessTypeEnum.HeadUp;
                d(str);
                break;
            case 14:
                this.F = LivenessTypeEnum.HeadDown;
                d(str);
                break;
            case 15:
                this.F = LivenessTypeEnum.HeadLeft;
                d(str);
                break;
            case 16:
                this.F = LivenessTypeEnum.HeadRight;
                d(str);
                break;
            case 17:
                d(str);
                break;
            case 18:
                LivenessTypeEnum livenessTypeEnum = this.F;
                if (livenessTypeEnum == LivenessTypeEnum.Eye) {
                    com.baidu.pass.biometrics.face.liveness.b.a aVar3 = this.E;
                    aVar3.p = com.baidu.pass.biometrics.face.liveness.b.a.a0;
                    aVar3.i++;
                    aVar3.M = System.currentTimeMillis();
                    this.E.k = com.baidu.pass.biometrics.face.liveness.b.a.a0;
                    break;
                } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
                    com.baidu.pass.biometrics.face.liveness.b.a aVar4 = this.E;
                    aVar4.p = "mouth";
                    aVar4.j++;
                    aVar4.O = System.currentTimeMillis();
                    this.E.k = "mouth";
                    break;
                }
                break;
            case 19:
                r();
                break;
        }
        this.E.J = System.currentTimeMillis();
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onConfigCamera(Camera camera, Rect rect, Rect rect2, Degree degree) {
        if (this.k != null) {
            Camera.Parameters parameters = camera.getParameters();
            CameraSurfaceView.a a2 = this.k.a(parameters);
            Log.e("new_face", "cameraSize = " + a2);
            parameters.setPreviewSize(a2.a, a2.b);
            camera.setParameters(parameters);
            parameters.setJpegQuality(50);
            camera.setParameters(parameters);
            if (!this.z) {
                ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
                layoutParams.height = (int) (a2.a * (layoutParams.width / a2.b));
                this.k.setLayoutParams(layoutParams);
                this.z = true;
            }
            rect.set(0, 0, a2.b, a2.a);
            int i2 = a2.b;
            rect2.set(0, 0, i2, i2);
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onEnd(int i2, RequestInfo requestInfo) {
        Log.e("new_face", "onEnd() i = " + i2 + ",requestInfo = ");
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
        aVar.H = aVar.H + (System.currentTimeMillis() - this.G);
        this.g.setVisibility(4);
        if (this.H == null) {
            return;
        }
        if (i2 != -18) {
            if (i2 != 1) {
                if (i2 != -5 && i2 != -4 && i2 != -3 && i2 != -2) {
                    switch (i2) {
                        case -15:
                            PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
                            if (passBiometricConfiguration != null) {
                                FH.init(this, passBiometricConfiguration.sofireAppKey, passBiometricConfiguration.sofireSecKey, passBiometricConfiguration.sofireHostID);
                            }
                            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                            passFaceRecogResult.setResultCode(i2);
                            this.H.onFailure(passFaceRecogResult);
                            a(i2);
                            return;
                        case -14:
                        case -13:
                        case -12:
                        case -11:
                        case -10:
                        case -9:
                        case -8:
                        case -7:
                            break;
                        default:
                            return;
                    }
                }
            } else {
                a(requestInfo);
                return;
            }
        }
        PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
        passFaceRecogResult2.setResultCode(i2);
        this.H.onFailure(passFaceRecogResult2);
        a(i2);
    }
}
