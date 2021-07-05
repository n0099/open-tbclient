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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
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
/* loaded from: classes3.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    public static final FaceTracker.ActionType aF;
    public static final int aV = 0;
    public static final int aW = 1;
    public static final int aX = 2;
    public static final double au = 0.6d;
    public static final double av = 0.667d;
    public static final double aw = 0.3845d;
    public static final double ax = 0.667d;
    public static final double ay = 0.5d;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5705b = "LivenessRecogActivity";
    public static final int bN = 1;
    public static final int bO = 2;
    public static final int bP = 1;
    public static final int bQ = 2;
    public static final int bb = 0;
    public static final int bc = 1;
    public static final int bd = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5706c = "CONSTRASTBEANTAG";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5707d = 2002;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5708e = 2003;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5709f = 2004;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5710g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5711h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5712i = 0;
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
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
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

    /* renamed from: a  reason: collision with root package name */
    public Camera.PreviewCallback f5713a;
    public LivenessRecogResult aA;
    public MediaPlayer aB;
    public FaceTracker aC;
    public FaceInfo[] aD;
    public int[] aE;
    public String[] aG;
    public int aH;
    public f aI;
    public int[] aJ;
    public FaceTracker.ErrCode aK;
    public boolean aL;
    public Handler aM;
    public d aN;
    public a aO;
    public long aP;
    public boolean aQ;
    public boolean aR;
    public boolean aS;
    public boolean aT;
    public boolean aU;
    public int aY;
    public int aZ;
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
    public boolean bH;
    public UploadContrastPortraitModel bI;
    public boolean bJ;
    public Runnable bK;
    public int bL;
    public int bM;
    public UploadContrastPortraitModel bR;
    public long bS;
    public View.OnClickListener bT;
    public byte[] bU;
    public int bV;
    public int bW;
    public int bX;
    public Camera bY;
    public boolean bZ;
    public int ba;
    public int be;
    public int[] bf;
    public int bg;
    public b bh;
    public com.baidu.fsg.face.liveness.camera.b bi;
    public FrameLayout bj;
    public AnimationDrawable bk;
    public Map<Integer, SoftReference<Bitmap>> bl;
    public List<int[]> bm;
    public Handler bn;
    public Runnable bo;
    public int bp;
    public long bq;
    public GetFPResponse.LivenessConfig br;
    public boolean bs;
    public int bt;
    public int bu;
    public String bv;
    public String bw;
    public List<String> bx;
    public com.baidu.fsg.face.liveness.c by;
    public boolean bz;
    public int ca;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f5772a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5773b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5774c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5775d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5776e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5777f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final long f5778g = 300;

        /* renamed from: h  reason: collision with root package name */
        public static final long f5779h = 1000;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5780i = 7;
        public static final int q = 0;
        public static final int r = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public int n;
        public int o;
        public final /* synthetic */ LivenessRecogActivity p;

        public a(LivenessRecogActivity livenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = livenessRecogActivity;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = 0;
            this.n = 7;
            this.o = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                mediaPlayer.reset();
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int A = 5000;
        public static final int B = 20000;

        /* renamed from: a  reason: collision with root package name */
        public static final int f5782a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5783b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5784c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5785d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5786e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5787f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f5788g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final int f5789h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5790i = 8;
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
        public transient /* synthetic */ FieldHolder $fh;
        public long C;
        public long D;
        public boolean E;
        public boolean F;
        public final /* synthetic */ LivenessRecogActivity G;
        public int u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        public d(LivenessRecogActivity livenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.G = livenessRecogActivity;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.D = 20000L;
            this.E = false;
            this.F = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f5791a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5792b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5793c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5794d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f5795e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f5796f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f5797g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final int f5798h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f5799i = 8;
        public static int[] j;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475574697, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(475574697, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$e;");
                    return;
                }
            }
            j = new int[]{R.raw.sapi_camera_blink, R.raw.sapi_camera_found_face, R.raw.sapi_camera_put_face_round, R.raw.sapi_camera_nod, R.raw.sapi_camera_special_recg, R.raw.sapi_camera_photo_done, R.raw.sapi_camera_too_near, R.raw.sapi_camera_too_far, R.raw.sapi_camera_open_mouth};
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessRecogActivity f5800a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LivenessRecogActivity livenessRecogActivity, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessRecogActivity, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5800a = livenessRecogActivity;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5800a.aL) {
                return;
            }
            this.f5800a.aI.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:147:0x0368  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x03c4  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0446  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x044c  */
        @Override // android.os.CountDownTimer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTick(long j) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f5800a.aN == null || this.f5800a.aN.u == 0 || this.f5800a.aN.u == 17 || this.f5800a.aN.u == 19 || this.f5800a.aN.u == 18 || this.f5800a.aN.u == 14 || this.f5800a.aN.u == 15 || this.f5800a.aN.u == 16) {
                return;
            }
            FaceInfo[] faceInfoArr = this.f5800a.aD;
            String str4 = "0";
            if (this.f5800a.aN == null || this.f5800a.aN.u != 1) {
                if (this.f5800a.aN.u == 4) {
                    if (this.f5800a.M()) {
                        this.f5800a.N();
                        return;
                    } else if (this.f5800a.c(faceInfoArr)) {
                        this.f5800a.A = -1;
                        this.f5800a.L.setVisibility(8);
                        if (this.f5800a.d(faceInfoArr)) {
                            if (this.f5800a.b(faceInfoArr)) {
                                if (this.f5800a.bq == 1) {
                                    this.f5800a.aN.u = 5;
                                } else {
                                    this.f5800a.aN.u = 7;
                                }
                                str = "";
                                long j2 = this.f5800a.bp * 1000;
                                if (j2 < 20000) {
                                    this.f5800a.aM.postDelayed(this.f5800a.bK, j2);
                                }
                                if (this.f5800a.aN.u != 5) {
                                    if (this.f5800a.M()) {
                                        this.f5800a.N();
                                        return;
                                    } else if (this.f5800a.c(faceInfoArr)) {
                                        this.f5800a.A = -1;
                                        this.f5800a.L.setVisibility(8);
                                        if (this.f5800a.d(faceInfoArr) && !this.f5800a.aO.k) {
                                            LivenessRecogDTO livenessRecogDTO = this.f5800a.livenessRecogDTO;
                                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f6009h, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : str);
                                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWBLINK):  提示眨眨眼");
                                            this.f5800a.a(0, 1, (String) null);
                                            this.f5800a.aO.k = true;
                                        }
                                    }
                                } else if (this.f5800a.aN.u == 7) {
                                    if (this.f5800a.M()) {
                                        this.f5800a.N();
                                        return;
                                    } else if (this.f5800a.c(faceInfoArr)) {
                                        this.f5800a.A = -1;
                                        this.f5800a.L.setVisibility(8);
                                        if (this.f5800a.d(faceInfoArr) && !this.f5800a.aO.l) {
                                            LivenessRecogDTO livenessRecogDTO2 = this.f5800a.livenessRecogDTO;
                                            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.j, livenessRecogDTO2 != null ? livenessRecogDTO2.getSpno() : str);
                                            LogUtil.d("hello", "onEvent(StatServiceEvent.SHOWMOUTH):  提示张张嘴");
                                            this.f5800a.a(0, 3, (String) null);
                                            this.f5800a.aO.l = true;
                                        }
                                    }
                                }
                                if (this.f5800a.aN.u != 6 || this.f5800a.aN.u == 8) {
                                    if (!this.f5800a.M()) {
                                        this.f5800a.N();
                                        return;
                                    } else if (this.f5800a.c(faceInfoArr)) {
                                        if (this.f5800a.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                                            this.f5800a.c(2);
                                            return;
                                        }
                                        LivenessRecogActivity livenessRecogActivity = this.f5800a;
                                        if (livenessRecogActivity.b(faceInfoArr[0], livenessRecogActivity.aK)) {
                                            this.f5800a.c(3);
                                            return;
                                        } else if (!this.f5800a.d(faceInfoArr)) {
                                            this.f5800a.c(4);
                                            this.f5800a.A = -1;
                                            return;
                                        } else if (h.c(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                                            this.f5800a.c(1);
                                            return;
                                        } else if (!h.b(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                                            this.f5800a.A = -1;
                                            this.f5800a.L.setVisibility(8);
                                            this.f5800a.a(faceInfoArr);
                                        } else {
                                            this.f5800a.c(0);
                                            return;
                                        }
                                    } else {
                                        this.f5800a.c(4);
                                        this.f5800a.aN.w = false;
                                        return;
                                    }
                                }
                                if (this.f5800a.aN.u == 9) {
                                    if (this.f5800a.M()) {
                                        this.f5800a.N();
                                        return;
                                    } else if (this.f5800a.c(faceInfoArr)) {
                                        if (this.f5800a.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                                            this.f5800a.c(2);
                                            return;
                                        }
                                        LivenessRecogActivity livenessRecogActivity2 = this.f5800a;
                                        if (livenessRecogActivity2.b(faceInfoArr[0], livenessRecogActivity2.aK)) {
                                            this.f5800a.c(3);
                                            return;
                                        } else if (!this.f5800a.d(faceInfoArr)) {
                                            this.f5800a.c(4);
                                        } else if (h.c(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                                            this.f5800a.c(1);
                                            return;
                                        } else if (!h.b(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                                            this.f5800a.A = -1;
                                            this.f5800a.L.setVisibility(8);
                                        } else {
                                            this.f5800a.c(0);
                                            return;
                                        }
                                    } else {
                                        this.f5800a.c(4);
                                        this.f5800a.aN.w = false;
                                        return;
                                    }
                                }
                                if (this.f5800a.c(faceInfoArr) && !this.f5800a.aL && this.f5800a.aN.u == 9 && this.f5800a.aK == FaceTracker.ErrCode.OK) {
                                    FaceVerifyData[] faceVerifyDataArr = this.f5800a.aC.get_FaceVerifyData(0);
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
                                    LivenessRecogDTO livenessRecogDTO3 = this.f5800a.livenessRecogDTO;
                                    arrayList.add(livenessRecogDTO3 != null ? livenessRecogDTO3.getSpno() : str2);
                                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.p, arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("onEventWithValue(StatServiceEvent.RETRIEVEDIMAGE):  获取到活体图片的数量  ");
                                    if (faceVerifyDataArr != null) {
                                        str4 = faceVerifyDataArr.length + str2;
                                    }
                                    sb2.append(str4);
                                    LogUtil.d("hello", sb2.toString());
                                    LivenessRecogActivity livenessRecogActivity3 = this.f5800a;
                                    if (!livenessRecogActivity3.a(faceInfoArr[0], livenessRecogActivity3.aK) || faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
                                        return;
                                    }
                                    this.f5800a.aN.u = 10;
                                    this.f5800a.aM.removeCallbacks(this.f5800a.bK);
                                    this.f5800a.aI.cancel();
                                    this.f5800a.bi.c();
                                    this.f5800a.ai.setVisibility(0);
                                    this.f5800a.aj.setVisibility(0);
                                    this.f5800a.ak.setVisibility(0);
                                    this.f5800a.ah.setLineVisiable(false);
                                    this.f5800a.C.setVisibility(4);
                                    LivenessRecogActivity livenessRecogActivity4 = this.f5800a;
                                    livenessRecogActivity4.b(5, livenessRecogActivity4.getString(R.string.sapi_liveness_network_checking));
                                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                                    rotateAnimation.setRepeatCount(-1);
                                    rotateAnimation.setRepeatMode(1);
                                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                                    rotateAnimation.setInterpolator(linearInterpolator);
                                    this.f5800a.aj.startAnimation(rotateAnimation);
                                    this.f5800a.ah.updateXfordViewProgress(0.5f, 0.75f, 500L, null);
                                    this.f5800a.b(this.f5800a.a(faceVerifyDataArr));
                                    return;
                                }
                                return;
                            }
                            this.f5800a.aN.u = 1;
                            this.f5800a.aN.v = false;
                            return;
                        }
                    } else {
                        this.f5800a.aN.u = 1;
                        this.f5800a.aN.v = false;
                        return;
                    }
                }
                str = "";
                if (this.f5800a.aN.u != 5) {
                }
                if (this.f5800a.aN.u != 6) {
                }
                if (!this.f5800a.M()) {
                }
            } else if (this.f5800a.M()) {
                this.f5800a.N();
            } else if (this.f5800a.c(faceInfoArr)) {
                if (this.f5800a.aK == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                    this.f5800a.c(2);
                    if (this.f5800a.bA == null || this.f5800a.aN == null || this.f5800a.aN.v || this.f5800a.aN.E) {
                        return;
                    }
                    this.f5800a.bA.b("2");
                    return;
                }
                LivenessRecogActivity livenessRecogActivity5 = this.f5800a;
                if (livenessRecogActivity5.b(faceInfoArr[0], livenessRecogActivity5.aK)) {
                    this.f5800a.c(3);
                    if (this.f5800a.bA == null || this.f5800a.aN == null || this.f5800a.aN.v || this.f5800a.aN.E) {
                        return;
                    }
                    LivenessRecogActivity livenessRecogActivity6 = this.f5800a;
                    if (livenessRecogActivity6.c(faceInfoArr[0], livenessRecogActivity6.aK)) {
                        this.f5800a.bA.b("0");
                        return;
                    }
                    LivenessRecogActivity livenessRecogActivity7 = this.f5800a;
                    if (livenessRecogActivity7.d(faceInfoArr[0], livenessRecogActivity7.aK)) {
                        this.f5800a.bA.b("1");
                    }
                } else if (!this.f5800a.d(faceInfoArr)) {
                    this.f5800a.c(4);
                    if (this.f5800a.bA != null && this.f5800a.aN != null && !this.f5800a.aN.v && !this.f5800a.aN.E) {
                        this.f5800a.bA.b("3");
                    }
                    this.f5800a.A = -1;
                    if (this.f5800a.aN != null) {
                        this.f5800a.aN.v = false;
                    }
                } else if (h.c(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                    this.f5800a.c(1);
                    if (this.f5800a.bA == null || this.f5800a.aN == null || this.f5800a.aN.v || this.f5800a.aN.E) {
                        return;
                    }
                    this.f5800a.bA.b("4");
                } else if (!h.b(faceInfoArr[0].landmarks, this.f5800a.aJ)) {
                    this.f5800a.A = -1;
                    this.f5800a.L.setVisibility(8);
                    this.f5800a.aN.u = 2;
                    LivenessRecogDTO livenessRecogDTO4 = this.f5800a.livenessRecogDTO;
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f6008g, livenessRecogDTO4 != null ? livenessRecogDTO4.getSpno() : "");
                    LogUtil.d("hello", "onEvent(StatServiceEvent.FACEDETECTED):  监测到人脸");
                    if (!this.f5800a.aN.v) {
                        this.f5800a.aP = System.currentTimeMillis();
                        this.f5800a.aN.v = true;
                    }
                    this.f5800a.Q();
                } else {
                    this.f5800a.c(0);
                    if (this.f5800a.bA == null || this.f5800a.aN == null || this.f5800a.aN.v || this.f5800a.aN.E) {
                        return;
                    }
                    this.f5800a.bA.b("5");
                }
            } else {
                if (this.f5800a.bA != null && this.f5800a.aN != null && !this.f5800a.aN.v && !this.f5800a.aN.E) {
                    this.f5800a.bA.b("6");
                }
                if (this.f5800a.aN != null) {
                    this.f5800a.aN.v = false;
                }
                this.f5800a.A = -1;
                this.f5800a.L.setVisibility(8);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-392800758, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-392800758, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity;");
                return;
            }
        }
        aF = FaceTracker.ActionType.RECOGNIZE;
    }

    public LivenessRecogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.A = -1;
        this.aE = null;
        this.aL = false;
        this.aQ = false;
        this.aR = true;
        this.aS = false;
        this.aT = false;
        this.aU = false;
        this.aY = 0;
        this.aZ = 0;
        this.ba = 0;
        this.be = 0;
        this.bf = new int[]{5001, 5002, 7100, 7101, 7019, 7020};
        this.bg = 0;
        this.bl = new ConcurrentHashMap();
        this.bm = new ArrayList();
        this.bn = new Handler(Looper.getMainLooper());
        this.bo = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5714a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f5714a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f5714a.aH = 1;
                    this.f5714a.U.setText(String.format("00:%02d", Integer.valueOf(this.f5714a.aO.n)));
                    this.f5714a.bn.postDelayed(this.f5714a.bo, 1000L);
                    int size = this.f5714a.bx.size() - (((this.f5714a.aO.n + this.f5714a.bu) - 1) / this.f5714a.bu);
                    if (size == 0) {
                        this.f5714a.I.setText((CharSequence) this.f5714a.bx.get(size));
                        this.f5714a.J.setText(String.format(this.f5714a.getString(R.string.sapi_liveness_goto_next_question), Integer.valueOf(this.f5714a.aO.n - this.f5714a.bu)));
                    } else if (size == 1) {
                        this.f5714a.I.setText((CharSequence) this.f5714a.bx.get(size));
                        this.f5714a.J.setText(String.format(this.f5714a.getString(R.string.sapi_liveness_will_be_completed), Integer.valueOf(this.f5714a.aO.n)));
                    }
                    if (this.f5714a.aO.n == 1) {
                        this.f5714a.C.setVisibility(4);
                        this.f5714a.K.setVisibility(4);
                        this.f5714a.T.clearAnimation();
                        this.f5714a.S.setVisibility(4);
                    } else if (this.f5714a.aO.n == 0) {
                        this.f5714a.bn.removeCallbacks(this.f5714a.bo);
                        this.f5714a.bi.g();
                        this.f5714a.bi.c();
                        this.f5714a.ah.setLineVisiable(false);
                        this.f5714a.ah.setMaskVisiable(true);
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.f5714a, R.anim.sapi_liveness_video_tip_slide_top_to_middle);
                        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f5715a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.f5715a = this;
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animation) == null) {
                                    this.f5715a.f5714a.I.setText(this.f5715a.f5714a.getString(R.string.sapi_liveness_upload_video));
                                    this.f5715a.f5714a.V();
                                }
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                                }
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                                    this.f5715a.f5714a.I.setText(this.f5715a.f5714a.getString(R.string.sapi_liveness_record_success));
                                    this.f5715a.f5714a.J.setVisibility(4);
                                }
                            }
                        });
                        this.f5714a.I.startAnimation(loadAnimation);
                        this.f5714a.ao.setVisibility(0);
                        this.f5714a.ao.loadSuccess();
                        this.f5714a.aN.u = 15;
                    }
                    this.f5714a.aO.n--;
                }
            }
        };
        this.bs = false;
        this.bt = 15;
        this.bu = 5;
        this.bx = new ArrayList();
        this.bz = false;
        this.bH = false;
        this.bI = null;
        this.bJ = ApollonConstants.VIDEO_DEBUG;
        this.bK = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5718a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f5718a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f5718a.bq == 2) {
                        this.f5718a.aN.u = 5;
                        this.f5718a.aH = 0;
                    } else {
                        this.f5718a.aN.u = 7;
                        this.f5718a.aH = 5;
                    }
                    long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.f5718a.aN.C);
                    if (currentTimeMillis < 5000) {
                        this.f5718a.aN.D = 25000 - currentTimeMillis;
                    }
                }
            }
        };
        this.bL = 0;
        this.bM = 0;
        this.bR = null;
        this.bS = 0L;
        this.bT = new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.27
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5736a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f5736a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && view.getId() == R.id.tv_record_video_retry) {
                    this.f5736a.p();
                    this.f5736a.K();
                    this.f5736a.u();
                }
            }
        };
        this.f5713a = new Camera.PreviewCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5737a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f5737a = this;
            }

            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr, camera) == null) {
                    this.f5737a.bi.a(bArr);
                    if (this.f5737a.bA != null) {
                        this.f5737a.bA.a();
                    }
                    if (this.f5737a.aN.u != 0 && this.f5737a.aN.u != 10 && this.f5737a.aN.u != 14 && this.f5737a.aN.u != 17 && this.f5737a.aN.u != 15 && this.f5737a.aN.u != 16 && this.f5737a.aN.u != 19 && this.f5737a.aN.u != 18) {
                        try {
                            if (this.f5737a.bg <= 0 && !this.f5737a.aL) {
                                this.f5737a.bY = camera;
                                this.f5737a.bU = bArr;
                                this.f5737a.a(camera);
                                this.f5737a.bh = new b();
                                this.f5737a.bh.execute(new Void[0]);
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
            }
        };
        this.bZ = false;
        this.ca = -1;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65724, null, contentResolver)) == null) {
            try {
                return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
            } catch (Settings.SettingNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65732, this) == null) {
        }
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65747, null, activity, i2) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public void callbackFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.B == null) {
            return;
        }
        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
        livenessRecogResult.setResultCode(i2);
        livenessRecogResult.setResultMsg(str);
        this.B.b(livenessRecogResult);
        setActivityResult(-1);
        a(true);
    }

    public void getRecordVideoQuestions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(getString(R.string.sapi_loading));
            com.baidu.fsg.face.liveness.beans.h hVar = (com.baidu.fsg.face.liveness.beans.h) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, f5705b);
            hVar.setResponseCallback(this);
            hVar.execBean();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
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
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, message)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        UploadContrastPortraitModel uploadContrastPortraitModel;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
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
                    new AsyncTask<Void, Void, LivenessRecogResult>(this, str) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.23
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f5730a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LivenessRecogActivity f5731b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f5731b = this;
                            this.f5730a = str;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public LivenessRecogResult doInBackground(Void... voidArr) {
                            InterceptResult invokeL;
                            byte[] encode;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) {
                                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                                livenessRecogResult2.setResultCode(0);
                                try {
                                    livenessRecogResult2.extraJson = new JSONObject(this.f5730a);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                LivenessRecogActivity livenessRecogActivity = this.f5731b;
                                if (livenessRecogActivity.livenessRecogDTO != null) {
                                    if (livenessRecogActivity.bm.size() > 0) {
                                        LivenessRecogActivity livenessRecogActivity2 = this.f5731b;
                                        livenessRecogResult2.originalImage = livenessRecogActivity2.a((int[]) livenessRecogActivity2.bm.get(this.f5731b.bm.size() - this.f5731b.bC));
                                    }
                                    if (this.f5731b.bF != null && (encode = Base64Utils.encode(this.f5731b.bF)) != null) {
                                        livenessRecogResult2.faceimage = new String(encode);
                                    }
                                    if (this.f5731b.bG != null) {
                                        livenessRecogResult2.imgdigests = new String(this.f5731b.bG);
                                    }
                                }
                                return livenessRecogResult2;
                            }
                            return (LivenessRecogResult) invokeL.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public void onPostExecute(LivenessRecogResult livenessRecogResult2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessRecogResult2) == null) {
                                super.onPostExecute(livenessRecogResult2);
                                this.f5731b.B.a(livenessRecogResult2);
                                if (this.f5731b.aR) {
                                    this.f5731b.setActivityResult(-1);
                                }
                                this.f5731b.a(true);
                            }
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
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity
    public boolean isSupportLiuHai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
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
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(f5705b);
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
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, strArr, iArr) == null) {
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
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("hasCameraReadyStatistics", this.bE);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
        }
    }

    public void setActivityResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            Intent intent = new Intent();
            intent.putExtras(new Bundle());
            setResult(i2, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessRecogActivity f5781a;

        public b(LivenessRecogActivity livenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5781a = livenessRecogActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LivenessRecogActivity.ao(this.f5781a);
                this.f5781a.L();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onPostExecute(str);
                LivenessRecogActivity.aq(this.f5781a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
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
            this.af.setPositiveText(getString(R.string.rim_face_exit_record_positive), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5719a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5719a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f5719a.p();
                        this.f5719a.K();
                        this.f5719a.u();
                        this.f5719a.af.dismiss();
                    }
                }
            });
            this.af.setNegativeText(getString(R.string.rim_face_exit_record_negative), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5720a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5720a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f5720a.bA != null) {
                            this.f5720a.bA.a(com.baidu.fsg.face.liveness.d.o);
                        }
                        if (!this.f5720a.aR) {
                            this.f5720a.b();
                        }
                        if (this.f5720a.aN.u == 14) {
                            this.f5720a.bi.g();
                        }
                        this.f5720a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5720a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                        this.f5720a.bi.d();
                    }
                }
            });
            this.af.setCancelable(false);
            this.af.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            CustomExitDialog customExitDialog = new CustomExitDialog(this);
            this.ag = customExitDialog;
            customExitDialog.setDialogTitle(getString(R.string.sapi_liveness_record_up_exit));
            this.ag.setPositiveText(getString(R.string.sapi_liveness_record_up_exit_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5721a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5721a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f5721a.aN.y = false;
                        this.f5721a.ag.dismiss();
                        this.f5721a.V();
                    }
                }
            });
            this.ag.setNegativeText(getString(R.string.sapi_liveness_record_up_exit_btn_cancel), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5722a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5722a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        g.b(g.b(this.f5722a.getActivity()));
                        this.f5722a.aN.y = false;
                        this.f5722a.ag.dismiss();
                        if (!this.f5722a.aR) {
                            this.f5722a.b();
                        }
                        this.f5722a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5722a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
            this.ag.setCancelable(false);
            if (isFinishing() || this.ag.isShowing()) {
                return;
            }
            this.ag.show();
        }
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            CustomExitDialog customExitDialog = this.ad;
            if (customExitDialog == null || !customExitDialog.isShowing()) {
                CustomExitDialog customExitDialog2 = new CustomExitDialog(this);
                this.ad = customExitDialog2;
                customExitDialog2.setDialogTitle(getString(R.string.sapi_liveness_record_video_exit_dialog_title));
                this.ad.setPositiveText(getString(R.string.sapi_liveness_record_video_exit_text), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5723a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5723a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f5723a.ad.dismiss();
                            this.f5723a.p();
                            this.f5723a.ad.dismiss();
                            this.f5723a.u();
                        }
                    }
                });
                this.ad.setNegativeText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5724a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5724a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f5724a.ad.dismiss();
                            if (!this.f5724a.aR) {
                                this.f5724a.b();
                            }
                            this.f5724a.setActivityResult(0);
                            LivenessRecogActivity livenessRecogActivity = this.f5724a;
                            livenessRecogActivity.a(!livenessRecogActivity.aR);
                        }
                    }
                });
                this.ad.setCancelable(false);
                if (isFinishing() || this.ad.isShowing()) {
                    return;
                }
                this.ad.show();
            }
        }
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.O.resetView();
            this.O.setVisibility(0);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.O.setResultPageTitle(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg_retry));
            this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_upload_video_fail_dialog_reupload));
            this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5725a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5725a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5725a.O.setVisibility(8);
                        this.f5725a.V();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5725a.O.setVisibility(8);
                        if (!this.f5725a.aR) {
                            this.f5725a.b();
                        }
                        g.b(g.b(this.f5725a.getActivity()));
                        this.f5725a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5725a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.O.resetView();
            this.O.setVisibility(0);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.O.setResultPageTitle(getString(R.string.sapi_liveness_record_video_title_upload_timeout));
            this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
            this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel));
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5727a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5727a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5727a.O.setVisibility(4);
                        this.f5727a.K();
                        this.f5727a.p();
                        this.f5727a.u();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5727a.O.setVisibility(4);
                        if (!this.f5727a.aR) {
                            this.f5727a.b();
                        }
                        this.f5727a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5727a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    private void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.O.resetView();
            this.O.setVisibility(0);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.O.setResultPageTitle(getString(R.string.sapi_liveness_record_video_no_face));
            this.O.setResultPageNextTitle(getString(R.string.sapi_liveness_record_video_in_rect));
            this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
            this.O.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5728a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5728a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5728a.O.setVisibility(4);
                        this.f5728a.K();
                        this.f5728a.p();
                        this.f5728a.u();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5728a.O.setVisibility(4);
                        if (!this.f5728a.aR) {
                            this.f5728a.b();
                        }
                        this.f5728a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5728a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.aN.F = true;
            if (this.Y == null) {
                BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
                this.Y = bioAlertDialog;
                bioAlertDialog.setTitleMsg(getString(R.string.sapi_permission_request));
                this.Y.setTitleVisible(true);
                this.Y.setDialogMsg(String.format(getString(R.string.sapi_liveness_permission_camera), h.c(this)));
                this.Y.setBtnCount(1);
                this.Y.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5729a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5729a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f5729a.Y.dismiss();
                            this.f5729a.aN.F = false;
                            if (this.f5729a.aR) {
                                this.f5729a.setActivityResult(-1);
                            }
                            if (this.f5729a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.f5729a.B.b(livenessRecogResult);
                            }
                            this.f5729a.a(true);
                        }
                    }
                });
            }
            this.Y.setCancelable(false);
            if (isFinishing() || this.Y.isShowing()) {
                return;
            }
            this.Y.show();
        }
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.aN.u = 19;
            if (this.Z == null) {
                BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
                this.Z = bioAlertDialog;
                bioAlertDialog.setTitleVisible(true);
                this.Z.setDialogMsg(getString(R.string.sapi_liveness_open_camera_no_permission));
                this.Z.setBtnCount(1);
                this.Z.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5732a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5732a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f5732a.Z.dismiss();
                            if (this.f5732a.aR) {
                                this.f5732a.setActivityResult(-1);
                            }
                            if (this.f5732a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.f5732a.B.b(livenessRecogResult);
                            }
                            this.f5732a.a(true);
                        }
                    }
                });
            }
            this.Z.setCancelable(false);
            if (isFinishing() || this.Z.isShowing()) {
                return;
            }
            this.Z.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleVisible(true);
            bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_no_audio_permission));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f5733a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5734b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5734b = this;
                    this.f5733a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f5733a.dismiss();
                        if (this.f5734b.aR) {
                            this.f5734b.setActivityResult(-1);
                        }
                        if (this.f5734b.B != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            this.f5734b.B.b(livenessRecogResult);
                        }
                        this.f5734b.a(true);
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    private boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            this.aN.u = 14;
            if (this.bi.b(this)) {
                return true;
            }
            I();
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.ah.setVisibility(0);
            this.U.setVisibility(0);
            this.T.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.bU == null || this.aE == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = -com.baidu.fsg.face.liveness.camera.b.f5995i;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d dVar = this.aN;
            long j2 = dVar.C;
            return currentTimeMillis - j2 > dVar.D && j2 > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
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
    }

    private void O() {
        GetFPResponse.LivenessConfig livenessConfig;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || this.aE == null || (livenessConfig = this.br) == null || !livenessConfig.isStatisticsEnable()) {
            return;
        }
        if ("1".equals(this.br.report_type) && ((dVar = this.aN) == null || dVar.v)) {
            return;
        }
        new Thread(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.29
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5738a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5738a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k kVar = (k) FaceSDKBeansFactory.getInstance().getBean(this.f5738a.getActivity(), 12, LivenessRecogActivity.f5705b);
                    LivenessRecogActivity livenessRecogActivity = this.f5738a;
                    kVar.d(livenessRecogActivity.a(livenessRecogActivity.aE));
                    LivenessRecogDTO livenessRecogDTO = this.f5738a.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        kVar.a(livenessRecogDTO);
                    }
                    if (this.f5738a.br != null) {
                        kVar.a(this.f5738a.br.report_type);
                    }
                    if (this.f5738a.bA != null) {
                        kVar.a(this.f5738a.bA.f5896d, this.f5738a.bA.f5897e);
                    }
                    kVar.setResponseCallback(this.f5738a);
                    kVar.execBean();
                }
            }
        }).start();
    }

    private void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.bk = (AnimationDrawable) this.E.getDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.aN.u = 3;
            this.E.setVisibility(0);
            d(4);
            this.bk.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5744a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5744a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5744a.bk.stop();
                        this.f5744a.E.setVisibility(8);
                        if (this.f5744a.aN.u == 17 || this.f5744a.aN.u == 18) {
                            return;
                        }
                        this.f5744a.aN.u = 4;
                    }
                }
            }, 1500L);
            this.ah.updateXfordViewProgress(0.25f, 0.5f, 500L, null);
        }
    }

    private void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.spai_liveness_video_scale_count_down);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
            this.P.setVisibility(0);
            this.R.setVisibility(0);
            this.R.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this, loadAnimation2) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Animation f5745a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5746b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, loadAnimation2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5746b = this;
                    this.f5745a = loadAnimation2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.f5746b.aN.z) {
                        return;
                    }
                    if (this.f5746b.ad == null || !this.f5746b.ad.isShowing()) {
                        this.f5746b.R.setTextSize(14.5f);
                        this.f5746b.R.setText(R.string.sapi_liveness_video_start_record_new);
                        this.f5746b.Q.setVisibility(0);
                        this.f5746b.aO.m = 0;
                        this.f5746b.Q.startAnimation(this.f5745a);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f5746b.aN.z) {
                        return;
                    }
                    if (this.f5746b.ad == null || !this.f5746b.ad.isShowing()) {
                        this.f5746b.R.setTextSize(12.0f);
                        String string = this.f5746b.getString(R.string.sapi_liveness_video_start_record_later_new);
                        this.f5746b.aO.n = this.f5746b.bx.size() * this.f5746b.bu;
                        this.f5746b.R.setText(String.format(string, Integer.valueOf(this.f5746b.aO.n)));
                        this.f5746b.Q.setVisibility(4);
                        this.f5746b.ah.setProgress(0.0f);
                        this.f5746b.ah.setMaskVisiable(true);
                        this.f5746b.ah.setLineVisiable(false);
                        this.f5746b.S.setVisibility(4);
                    }
                }
            });
            loadAnimation2.setAnimationListener(new Animation.AnimationListener(this, loadAnimation3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Animation f5749a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5750b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, loadAnimation3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5750b = this;
                    this.f5749a = loadAnimation3;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.f5750b.aN.z) {
                        return;
                    }
                    if (this.f5750b.ad == null || !this.f5750b.ad.isShowing()) {
                        this.f5750b.aO.m++;
                        if (this.f5750b.aO.m != 1) {
                            if (this.f5750b.aO.m == 3) {
                                this.f5750b.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_1);
                                this.f5750b.Q.startAnimation(animation);
                                return;
                            } else if (this.f5750b.aO.m > 4) {
                                this.f5750b.P.setVisibility(4);
                                this.f5750b.R.setVisibility(4);
                                this.f5750b.Q.setVisibility(4);
                                this.f5750b.I.startAnimation(this.f5749a);
                                this.f5750b.ah.setMaskVisiable(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        animation.reset();
                        this.f5750b.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_2);
                        this.f5750b.Q.startAnimation(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f5750b.aN.z) {
                        return;
                    }
                    if (this.f5750b.ad == null || !this.f5750b.ad.isShowing()) {
                        if (this.f5750b.aO.m == 0) {
                            this.f5750b.Q.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
                        }
                        this.f5750b.I.setText(String.format(this.f5750b.getString(R.string.sapi_liveness_video_answer_question), Integer.valueOf(this.f5750b.bx.size())));
                    }
                }
            });
            loadAnimation3.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5751a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5751a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.f5751a.aN.z) {
                        return;
                    }
                    if (this.f5751a.ad == null || !this.f5751a.ad.isShowing()) {
                        this.f5751a.J.setVisibility(0);
                        this.f5751a.S.setVisibility(0);
                        this.f5751a.U.setText(String.format("00:%02d", Integer.valueOf(this.f5751a.aO.n)));
                        this.f5751a.S();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f5751a.aN.z) {
                        return;
                    }
                    if (this.f5751a.ad == null || !this.f5751a.ad.isShowing()) {
                        this.f5751a.I.setText((CharSequence) this.f5751a.bx.get(0));
                        this.f5751a.J.setVisibility(4);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, this) == null) && J()) {
            this.ah.setLineVisiable(true);
            this.C.setVisibility(0);
            this.K.setVisibility(0);
            this.bn.post(this.bo);
            this.ah.updateXfordViewProgress(0.0f, 1.0f, this.aO.n * 1000, null);
            this.T.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_time_count_point));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5752a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5752a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        File file = new File(g.b(this.f5752a.getActivity()));
                        if (!file.exists() || file.length() <= 0) {
                            this.f5752a.bi.g();
                            this.f5752a.bi.c();
                            this.f5752a.ah.setLineVisiable(false);
                            this.f5752a.ah.stopXfordViewProgress();
                            this.f5752a.I();
                            this.f5752a.bn.removeCallbacks(this.f5752a.bo);
                        }
                    }
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String T() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    private void U() {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
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
                m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f5705b);
                UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                uploadFileModel.filedata = bArr;
                uploadFileModel.fileName = "video.3gp";
                uploadFileModel.name = "file";
                mVar.addFile(uploadFileModel);
                mVar.d("process");
                mVar.b(this.bw);
                mVar.c(this.bw);
                mVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.38
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5753a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5753a = this;
                    }

                    @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                    public void transferred(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            LogUtil.e("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                            StringBuilder sb = new StringBuilder();
                            sb.append("progress:  ");
                            sb.append((int) ((((float) j2) / ((float) j3)) * 100.0f));
                            LogUtil.e("hello", sb.toString());
                        }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
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
                m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f5705b);
                UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                uploadFileModel.filedata = bArr;
                uploadFileModel.fileName = "video.3gp";
                uploadFileModel.name = "file";
                mVar.addFile(uploadFileModel);
                mVar.b(this.bv);
                mVar.c(this.bw);
                mVar.a("1");
                mVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5754a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5754a = this;
                    }

                    @Override // com.baidu.fsg.base.restnet.RestMultipartEntity.ProgressListener
                    public void transferred(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            LogUtil.d("hello", "uploadvideo:   num: " + j2 + "  total:" + j3);
                            StringBuilder sb = new StringBuilder();
                            sb.append("progress:  ");
                            sb.append((int) ((((float) j2) / ((float) j3)) * 100.0f));
                            LogUtil.d("hello", sb.toString());
                            this.f5754a.runOnUiThread(new Runnable(this, j2, j3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.39.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ long f5755a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ long f5756b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass39 f5757c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3)};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f5757c = this;
                                    this.f5755a = j2;
                                    this.f5756b = j3;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        TextView textView = this.f5757c.f5754a.al;
                                        textView.setText(((int) ((((float) this.f5755a) / ((float) this.f5756b)) * 100.0f)) + "%");
                                        this.f5757c.f5754a.an.setPercent(((float) this.f5755a) / ((float) this.f5756b));
                                    }
                                }
                            });
                        }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
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
    }

    private void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || this.X == null || isFinishing() || !this.X.isShowing()) {
            return;
        }
        this.X.dismiss();
    }

    private int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) {
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
        return invokeV.intValue;
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65734, this)) == null) {
            LogUtil.d("openCamera被调用了");
            this.V.setVisibility(4);
            boolean a2 = this.bi.a(this, 3);
            if (!a2) {
                H();
            } else {
                a(this.bi.i());
                this.bi.a(this.f5713a);
                this.V.startPreview();
            }
            this.V.setVisibility(0);
            return a2;
        }
        return invokeV.booleanValue;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65736, this) == null) || this.bE || this.livenessRecogDTO == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65737, this) == null) {
            this.ah.setLineVisiable(true);
            this.C.setVisibility(0);
            this.L.setVisibility(4);
            this.A = -1;
            this.G.setText(R.string.sapi_liveness_put_face_round);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65740, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65742, this) == null) {
            if (this.aS && !this.bi.e()) {
                this.bi.a((Context) this);
            }
            this.aN.C = System.currentTimeMillis();
            a(0, 0, (String) null);
            this.aI.start();
            this.ah.updateXfordViewProgress(0.0f, 0.25f, 500L, null);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65744, this) == null) {
            this.H.setVisibility(0);
            this.G.setVisibility(4);
            this.C.setVisibility(4);
            this.K.setVisibility(4);
            this.K.setOnClickListener(this.bT);
            this.bi.b();
            R();
        }
    }

    private b.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65745, this)) == null) {
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            return new b.a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + com.baidu.fsg.face.base.d.f.a(this));
        }
        return (b.a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65749, this) == null) {
            if (this.aS && this.aT) {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
            } else {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            }
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.44
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5765a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5765a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @RequiresApi(api = 23)
                    public void isAllAgree(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (z2) {
                                this.f5765a.aN.F = true;
                                if (this.f5765a.aS && this.f5765a.aT) {
                                    this.f5765a.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                                    return;
                                } else {
                                    this.f5765a.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                                    return;
                                }
                            }
                            if (this.f5765a.aR) {
                                this.f5765a.setActivityResult(-1);
                            }
                            if (this.f5765a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.f5765a.B.b(livenessRecogResult);
                            }
                            this.f5765a.a(true);
                        }
                    }
                });
            } else if (m()) {
                n();
                q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65750, this) == null) {
            this.aN.u = 12;
            this.D.setVisibility(4);
            this.L.setVisibility(4);
            this.F.setVisibility(4);
            String[] strArr = {PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.45
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5766a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5766a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @RequiresApi(api = 23)
                    public void isAllAgree(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (z2) {
                                this.f5766a.aN.F = true;
                                this.f5766a.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2004);
                                return;
                            }
                            if (this.f5766a.aR) {
                                this.f5766a.setActivityResult(-1);
                            }
                            if (this.f5766a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                                this.f5766a.B.b(livenessRecogResult);
                            }
                            this.f5766a.a(true);
                        }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65752, this) == null) {
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
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5726a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5726a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5726a.p();
                        this.f5726a.u();
                        this.f5726a.O.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5726a.aN.u = 1;
                        this.f5726a.t();
                        this.f5726a.aD = null;
                        this.f5726a.o();
                        this.f5726a.aO.k = false;
                        this.f5726a.aO.l = false;
                        LivenessRecogActivity livenessRecogActivity = this.f5726a;
                        livenessRecogActivity.aH = livenessRecogActivity.e();
                        this.f5726a.aN.C = System.currentTimeMillis();
                        this.f5726a.O.setVisibility(8);
                    }
                }
            });
            this.O.setOnCloseListener(new RimFaceResultPageTipView.b(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5739a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5739a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.f5739a.aR) {
                            this.f5739a.b();
                        }
                        this.f5739a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5739a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                        this.f5739a.O.setVisibility(8);
                    }
                }
            });
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65755, this) == null) {
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
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5768a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5768a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5768a.o();
                        this.f5768a.aN.u = 1;
                        this.f5768a.q();
                        LivenessRecogActivity livenessRecogActivity = this.f5768a;
                        livenessRecogActivity.aH = livenessRecogActivity.e();
                        this.f5768a.aO.k = false;
                        this.f5768a.aO.l = false;
                        this.f5768a.aN.C = System.currentTimeMillis();
                        this.f5768a.O.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5768a.O.setVisibility(8);
                        if (!this.f5768a.aR) {
                            this.f5768a.b();
                        }
                        this.f5768a.bi.d();
                        this.f5768a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5768a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65756, this) == null) {
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
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5769a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5769a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5769a.aN.u = 1;
                        this.f5769a.t();
                        this.f5769a.aD = null;
                        this.f5769a.o();
                        this.f5769a.aO.k = false;
                        this.f5769a.aO.l = false;
                        LivenessRecogActivity livenessRecogActivity = this.f5769a;
                        livenessRecogActivity.aH = livenessRecogActivity.e();
                        this.f5769a.aN.C = System.currentTimeMillis();
                        this.f5769a.O.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5769a.O.setVisibility(8);
                        if (!this.f5769a.aR) {
                            this.f5769a.b();
                        }
                        this.f5769a.bi.d();
                        this.f5769a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5769a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65758, this) == null) {
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
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5770a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5770a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5770a.o();
                        this.f5770a.aN.u = 1;
                        this.f5770a.q();
                        LivenessRecogActivity livenessRecogActivity = this.f5770a;
                        livenessRecogActivity.aH = livenessRecogActivity.e();
                        this.f5770a.aO.k = false;
                        this.f5770a.aO.l = false;
                        this.f5770a.aN.C = System.currentTimeMillis();
                        this.f5770a.O.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5770a.O.setVisibility(8);
                        if (!this.f5770a.aR) {
                            this.f5770a.b();
                        }
                        this.f5770a.bi.d();
                        this.f5770a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5770a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65761, this) == null) {
            this.bi.c();
            this.ah.setLineVisiable(false);
            this.aN.u = 18;
            this.aM.removeCallbacks(this.bK);
            CustomExitDialog customExitDialog = new CustomExitDialog(this);
            this.ae = customExitDialog;
            customExitDialog.setDialogTitle(getString(R.string.rim_face_exit_action_title));
            this.ae.setDialogContext(getString(R.string.rim_face_exit_action_content));
            this.ae.setPositiveText(getString(R.string.rim_face_exit_action_positive), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5716a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5716a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f5716a.o();
                        this.f5716a.aN.u = 1;
                        this.f5716a.bi.b();
                        this.f5716a.q();
                        LivenessRecogActivity livenessRecogActivity = this.f5716a;
                        livenessRecogActivity.aH = livenessRecogActivity.e();
                        this.f5716a.aO.k = false;
                        this.f5716a.aO.l = false;
                        this.f5716a.aN.C = System.currentTimeMillis();
                        this.f5716a.ae.dismiss();
                    }
                }
            });
            this.ae.setNegativeText(getString(R.string.rim_face_exit_action_negative), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5717a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5717a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f5717a.bA != null) {
                            this.f5717a.bA.a(com.baidu.fsg.face.liveness.d.o);
                        }
                        if (!this.f5717a.aR) {
                            this.f5717a.b();
                        }
                        if (this.f5717a.aN.u == 14) {
                            this.f5717a.bi.g();
                        }
                        this.f5717a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5717a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                        this.f5717a.bi.d();
                    }
                }
            });
            this.ae.setCancelable(false);
            this.ae.show();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65713, this) == null) {
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            this.aR = livenessRecogDTO.showGuidePage;
            this.aQ = livenessRecogDTO.soundSwitch;
            this.aU = livenessRecogDTO.randomLiveness;
            this.bs = livenessRecogDTO.switchVideo;
            this.aS = livenessRecogDTO.recordLiveness && Build.VERSION.SDK_INT >= 18;
            this.aG = getResources().getStringArray(R.array.sapi_liveness_head_pose);
            this.aM = new Handler(Looper.getMainLooper(), this);
            this.aN = new d(this);
            this.aO = new a(this);
            this.aI = new f(this, 5000L, 200L);
            this.aN.C = System.currentTimeMillis();
            com.baidu.fsg.face.liveness.b bVar = new com.baidu.fsg.face.liveness.b(this.livenessRecogDTO);
            this.bA = bVar;
            bVar.f5893a = System.currentTimeMillis();
            this.B = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            g();
            this.aH = e();
            if (this.bs) {
                l();
            } else {
                i();
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65717, this) == null) {
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
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65720, this) == null) {
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
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65723, this) == null) {
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
    }

    private void j() throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65727, this) == null) && !com.baidu.fsg.face.base.b.d.a(this, 4, new Bundle())) {
            throw new Exception("load so failure");
        }
    }

    private void k() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65730, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65708, this)) == null) {
            if (this.bq == 1) {
                this.aH = 0;
            } else {
                this.aH = 5;
            }
            return this.aH;
        }
        return invokeV.intValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65700, this) == null) {
            com.baidu.fsg.face.base.d.f.b(this, getResources().getColor(17170445));
            setBrightness(this, 255);
            ImageView imageView = (ImageView) findViewById(R.id.btn_cancel);
            this.C = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.42
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5763a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5763a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f5763a.aN.x) {
                            if (this.f5763a.by != null) {
                                this.f5763a.by.a();
                            }
                            this.f5763a.B();
                        } else if (this.f5763a.aN.u == 17 || this.f5763a.aN.u == 18) {
                        } else {
                            if (this.f5763a.aN.u == 12 || this.f5763a.aN.u == 14) {
                                this.f5763a.A();
                            } else {
                                this.f5763a.z();
                            }
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
            this.D.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.43
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5764a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5764a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LivenessRecogActivity livenessRecogActivity = this.f5764a;
                        livenessRecogActivity.aQ = !livenessRecogActivity.aQ;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5764a.aQ ? "1" : "0");
                        LivenessRecogDTO livenessRecogDTO = this.f5764a.livenessRecogDTO;
                        arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.f6005d, arrayList);
                        if (this.f5764a.aQ) {
                            this.f5764a.D.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
                        } else {
                            this.f5764a.D.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
                        }
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
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65690, this) == null) {
            this.aN = null;
            this.aO = null;
            this.aD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65679, this, uploadContrastPortraitModel) == null) || this.B == null || uploadContrastPortraitModel == null) {
            return;
        }
        new AsyncTask<Void, Void, LivenessRecogResult>(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.41
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ UploadContrastPortraitModel f5761a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f5762b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, uploadContrastPortraitModel};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5762b = this;
                this.f5761a = uploadContrastPortraitModel;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public LivenessRecogResult doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                LivenessRecogDTO livenessRecogDTO;
                byte[] encode;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    int i2 = 0;
                    if (this.f5761a.isProcessPass()) {
                        livenessRecogResult.setResultCode(0);
                    } else {
                        livenessRecogResult.setResultCode(-302);
                    }
                    UploadContrastPortraitModel uploadContrastPortraitModel2 = this.f5761a;
                    livenessRecogResult.callbackkey = uploadContrastPortraitModel2.callbackkey;
                    if (!TextUtils.isEmpty(uploadContrastPortraitModel2.imgdigests) && this.f5762b.bD != null && this.f5762b.bD.size() > 0) {
                        int size = this.f5762b.bD.size();
                        while (true) {
                            if (i2 >= size) {
                                i2 = -1;
                                break;
                            }
                            byte[] bArr = (byte[]) ((HashMap) this.f5762b.bD.get(i2)).get(LightappBusinessClient.MTD_DIGEST);
                            if (bArr != null && this.f5761a.imgdigests.equals(new String(bArr))) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1 && (livenessRecogDTO = this.f5762b.livenessRecogDTO) != null) {
                            if (livenessRecogDTO.isReturnOriginImage() && this.f5762b.bm.size() > 0) {
                                LivenessRecogActivity livenessRecogActivity = this.f5762b;
                                livenessRecogResult.originalImage = livenessRecogActivity.a((int[]) livenessRecogActivity.bm.get((this.f5762b.bm.size() - i2) - 1));
                            }
                            if (this.f5762b.livenessRecogDTO.isReturnCutImage()) {
                                byte[] bArr2 = (byte[]) ((HashMap) this.f5762b.bD.get(i2)).get("data");
                                if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                    livenessRecogResult.faceimage = new String(encode);
                                }
                                livenessRecogResult.imgdigests = new String(this.f5761a.imgdigests);
                            }
                        }
                    }
                    livenessRecogResult.authSid = this.f5761a.authsid;
                    return livenessRecogResult;
                }
                return (LivenessRecogResult) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(LivenessRecogResult livenessRecogResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessRecogResult) == null) {
                    super.onPostExecute(livenessRecogResult);
                    if (this.f5761a.isProcessPass()) {
                        this.f5762b.B.a(livenessRecogResult);
                    } else {
                        this.f5762b.B.b(livenessRecogResult);
                    }
                    if (this.f5762b.aR) {
                        this.f5762b.setActivityResult(-1);
                    }
                    this.f5762b.a(true);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65692, this, uploadContrastPortraitModel) == null) {
            UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
            this.O.resetView();
            this.O.setResultPageTitle(confirmBean.title_tips);
            this.O.setResultPageRiskTipVisiable(confirmBean.tip_msg);
            this.O.setResultPageConfirmText(confirmBean.confirm_msg);
            this.O.setResultPageCancelText(confirmBean.cancel_msg);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
            this.O.setVisibility(0);
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ UploadContrastPortraitModel f5758a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5759b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, uploadContrastPortraitModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5759b = this;
                    this.f5758a = uploadContrastPortraitModel;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || System.currentTimeMillis() - this.f5759b.bS < 500) {
                        return;
                    }
                    this.f5759b.bS = System.currentTimeMillis();
                    if (this.f5759b.livenessRecogDTO != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5759b.livenessRecogDTO.getSpno() + "");
                        arrayList.add(TextUtils.isEmpty(this.f5759b.livenessRecogDTO.processid) ? "" : this.f5759b.livenessRecogDTO.processid);
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.C, arrayList);
                    }
                    this.f5759b.bL = 1;
                    this.f5759b.bM = 1;
                    this.f5759b.bR = this.f5758a;
                    this.f5759b.ai.setVisibility(0);
                    this.f5759b.aj.setVisibility(0);
                    this.f5759b.ak.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f5759b.aj.startAnimation(rotateAnimation);
                    this.f5759b.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f5759b.getActivity(), 13, LivenessRecogActivity.f5705b);
                    LivenessRecogDTO livenessRecogDTO = this.f5759b.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f5759b.bM);
                    dVar.a(this.f5759b.bL);
                    dVar.setResponseCallback(this.f5759b);
                    dVar.execBean();
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || System.currentTimeMillis() - this.f5759b.bS < 500) {
                        return;
                    }
                    this.f5759b.bS = System.currentTimeMillis();
                    if (this.f5759b.livenessRecogDTO != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5759b.livenessRecogDTO.getSpno() + "");
                        arrayList.add(TextUtils.isEmpty(this.f5759b.livenessRecogDTO.processid) ? "" : this.f5759b.livenessRecogDTO.processid);
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.D, arrayList);
                    }
                    this.f5759b.bL = 2;
                    this.f5759b.bM = 1;
                    this.f5759b.bR = this.f5758a;
                    this.f5759b.ai.setVisibility(0);
                    this.f5759b.aj.setVisibility(0);
                    this.f5759b.ak.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f5759b.aj.startAnimation(rotateAnimation);
                    this.f5759b.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f5759b.getActivity(), 13, LivenessRecogActivity.f5705b);
                    LivenessRecogDTO livenessRecogDTO = this.f5759b.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f5759b.bM);
                    dVar.a(this.f5759b.bL);
                    dVar.setResponseCallback(this.f5759b);
                    dVar.execBean();
                }
            });
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65680, this, str) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        arrayList.add(str);
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.x, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, this, iArr)) == null) {
            b.a i2 = this.bi.i();
            Bitmap createBitmap = Bitmap.createBitmap(iArr, i2.f6001b, i2.f6000a, Bitmap.Config.ARGB_8888);
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
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65674, this) == null) {
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
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65693, this, str) == null) {
            this.O.resetView();
            this.O.setVisibility(0);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.O.setResultPageTitle(getString(R.string.error_msg_server_error));
            this.O.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
            this.O.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5771a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5771a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f5771a.O.setVisibility(8);
                        this.f5771a.getRecordVideoQuestions();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f5771a.O.setVisibility(8);
                        if (!this.f5771a.aR) {
                            this.f5771a.b();
                        }
                        this.f5771a.setActivityResult(0);
                        LivenessRecogActivity livenessRecogActivity = this.f5771a;
                        livenessRecogActivity.a(!livenessRecogActivity.aR);
                    }
                }
            });
        }
    }

    private void a(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, this, uploadContrastPortraitModel) == null) {
            this.aj.clearAnimation();
            this.ai.setVisibility(8);
            this.aj.setVisibility(8);
            this.ak.setVisibility(8);
            this.ah.setMaskVisiable(true);
            this.ao.loadSuccess();
            this.ao.setVisibility(0);
            this.ah.updateXfordViewProgress(0.75f, 1.0f, 1000L, new AnimatorListenerAdapter(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ UploadContrastPortraitModel f5747a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5748b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, uploadContrastPortraitModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5748b = this;
                    this.f5747a = uploadContrastPortraitModel;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.f5748b.ah.setMaskVisiable(false);
                        this.f5748b.ao.setVisibility(4);
                        super.onAnimationEnd(animator);
                        BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                        if (this.f5747a.isGotoDXMRecordvideo()) {
                            this.f5748b.v();
                        } else if (this.f5748b.be == 2) {
                            this.f5748b.v();
                        } else if (this.f5747a.isProcessPass()) {
                            if (this.f5748b.bA != null) {
                                this.f5748b.bA.a(com.baidu.fsg.face.liveness.d.f6007f);
                            }
                            UploadContrastPortraitModel uploadContrastPortraitModel2 = this.f5747a;
                            if (uploadContrastPortraitModel2.need_confirm == null) {
                                this.f5748b.b(uploadContrastPortraitModel2);
                                return;
                            }
                            this.f5748b.c(uploadContrastPortraitModel2);
                            this.f5748b.az.setVisibility(8);
                            if (this.f5748b.livenessRecogDTO != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(this.f5748b.livenessRecogDTO.getSpno() + "");
                                arrayList.add(TextUtils.isEmpty(this.f5748b.livenessRecogDTO.processid) ? "" : this.f5748b.livenessRecogDTO.processid);
                                RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.B, arrayList);
                            }
                        } else if (this.f5748b.be == 1) {
                            if (this.f5748b.aY >= 2) {
                                this.f5748b.v();
                            } else if (this.f5748b.aY == 1) {
                                this.f5748b.x();
                            } else if (this.f5748b.aZ >= 2) {
                                this.f5748b.v();
                            } else if (this.f5748b.aZ == 1) {
                                this.f5748b.x();
                            } else {
                                this.f5748b.b(this.f5747a);
                            }
                        } else {
                            this.f5748b.b(this.f5747a);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65698, this, faceInfoArr)) == null) ? faceInfoArr != null && faceInfoArr.length > 0 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65691, this, i2) == null) {
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_warning);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this, loadAnimation) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.31
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Animation f5742a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5743b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, loadAnimation};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5743b = this;
                        this.f5742a = loadAnimation;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            this.f5743b.M.startAnimation(this.f5742a);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                        }
                    }
                });
                if (!this.aO.j) {
                    this.M.startAnimation(loadAnimation);
                    this.aO.j = true;
                }
            }
            this.A = i2;
        }
    }

    private b.a b(b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65673, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            b.a s2 = s();
            b.a aVar2 = new b.a(aVar.f6000a, aVar.f6001b);
            float f2 = aVar.f6000a / aVar.f6001b;
            float f3 = s2.f6001b / s2.f6000a;
            if (Math.abs(f2 - f3) <= 0.02d) {
                return aVar2;
            }
            if (f2 < f3) {
                int i2 = s2.f6001b;
                aVar2.f6000a = (aVar.f6001b * i2) / aVar.f6000a;
                aVar2.f6001b = i2;
            } else {
                aVar2.f6000a = s2.f6000a;
                aVar2.f6001b = (s2.f6000a * aVar.f6000a) / aVar.f6001b;
            }
            return aVar2;
        }
        return (b.a) invokeL.objValue;
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65613, this, str, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.q, i2, arrayList);
        a(str);
    }

    private Bitmap b(int i2) {
        InterceptResult invokeI;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65671, this, i2)) == null) {
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
        return (Bitmap) invokeI.objValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65599, this, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.H, i2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65697, this, faceInfo, errCode)) == null) {
            if (errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                return true;
            }
            if (errCode == FaceTracker.ErrCode.OK) {
                float[] fArr = faceInfo.headPose;
                if (fArr.length == 3) {
                    float abs = Math.abs(fArr[0]);
                    GetFPResponse.LivenessConfig livenessConfig = this.br;
                    if (abs >= (livenessConfig != null ? livenessConfig.getPitch() : 15)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, this, str) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65686, this, faceInfoArr)) == null) {
            if (faceInfoArr == null || faceInfoArr.length == 0) {
                return false;
            }
            if (faceInfoArr == null || faceInfoArr.length <= 0) {
                return true;
            }
            return (h.b(faceInfoArr[0].landmarks, this.aJ) || h.c(faceInfoArr[0].landmarks, this.aJ)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65707, this, faceInfoArr)) == null) {
            Rect b2 = h.b(faceInfoArr[0].landmarks);
            int i2 = this.bi.i().f6000a;
            double a2 = h.a(this.bi.i().f6001b, this.ap);
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
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65675, this, i2, str) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65706, this, faceInfo, errCode)) == null) {
            if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE) {
                return true;
            }
            if (errCode == FaceTracker.ErrCode.OK) {
                float[] fArr = faceInfo.headPose;
                if (fArr.length == 3) {
                    float abs = Math.abs(fArr[1]);
                    GetFPResponse.LivenessConfig livenessConfig = this.br;
                    return abs >= ((float) (livenessConfig != null ? livenessConfig.getYaw() : 15));
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65685, this, faceInfo, errCode)) == null) {
            if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
                return true;
            }
            if (errCode == FaceTracker.ErrCode.OK) {
                float[] fArr = faceInfo.headPose;
                if (fArr.length == 3) {
                    float abs = Math.abs(fArr[0]);
                    GetFPResponse.LivenessConfig livenessConfig = this.br;
                    if (abs < (livenessConfig != null ? livenessConfig.getPitch() : 15)) {
                        float abs2 = Math.abs(faceInfo.headPose[1]);
                        GetFPResponse.LivenessConfig livenessConfig2 = this.br;
                        if (abs2 >= (livenessConfig2 != null ? livenessConfig2.getYaw() : 15)) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65602, this, i2, str) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65701, this, i2) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FaceVerifyData[] faceVerifyDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65681, this, faceVerifyDataArr) == null) {
            new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.40
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5760a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5760a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                    InterceptResult invokeL;
                    int i2;
                    int i3;
                    Bitmap createBitmap;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, faceVerifyDataArr2)) == null) {
                        this.f5760a.aZ = 0;
                        this.f5760a.aY = 0;
                        this.f5760a.ba = 0;
                        this.f5760a.bH = false;
                        this.f5760a.bB = 0;
                        this.f5760a.bC = 0;
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
                    return (ArrayList) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                        if (arrayList == null || arrayList.size() <= 0) {
                            if (this.f5760a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-306);
                                livenessRecogResult.setResultMsg(com.baidu.fsg.face.liveness.c.f5966e);
                                this.f5760a.B.b(livenessRecogResult);
                            }
                            if (this.f5760a.aR) {
                                this.f5760a.setActivityResult(-1);
                            }
                            this.f5760a.a(true);
                            return;
                        }
                        this.f5760a.bB = arrayList.size();
                        this.f5760a.bD = arrayList;
                        LivenessRecogActivity livenessRecogActivity = this.f5760a;
                        LivenessRecogDTO livenessRecogDTO = livenessRecogActivity.livenessRecogDTO;
                        if (livenessRecogDTO != null) {
                            if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                                if (livenessRecogActivity.br != null) {
                                    LivenessRecogActivity livenessRecogActivity2 = this.f5760a;
                                    livenessRecogActivity2.bB = livenessRecogActivity2.br.getRecogUploadPortraitCount(this.f5760a.bB);
                                }
                                this.f5760a.X();
                                return;
                            }
                            livenessRecogActivity.W();
                        }
                    }
                }
            }.execute(faceVerifyDataArr);
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65604, this, view) != null) {
            return;
        }
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65703, this, str) == null) || isFinishing()) {
            return;
        }
        LoadingDialog loadingDialog = new LoadingDialog(this);
        this.X = loadingDialog;
        loadingDialog.setMessage(str);
        this.X.show();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            for (SoftReference<Bitmap> softReference : this.bl.values()) {
                Bitmap bitmap = softReference.get();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, this, camera) == null) {
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
            if (bVar != null && bVar.f5894b == 0) {
                bVar.f5895c = this.bW;
                bVar.f5894b = this.bV;
                bVar.a(com.baidu.fsg.face.liveness.d.t);
            }
            if (this.aE == null) {
                this.aE = new int[this.bV * this.bW];
            }
        }
    }

    private void a(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, this, aVar) == null) {
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.V.getLayoutParams());
            b.a b2 = b(aVar);
            if (b2 != null && (b2.f6000a != aVar.f6000a || b2.f6001b != aVar.f6001b)) {
                int i4 = (int) (b2.f6000a * 0.667d);
                this.ap = i4;
                int i5 = (int) (b2.f6001b * 0.667d);
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
    }

    private void a(UploadVideoModel uploadVideoModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, this, uploadVideoModel) == null) {
            this.O.resetView();
            this.O.setVisibility(0);
            this.O.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
            this.O.setResultPageTitle(uploadVideoModel.getConfirmBean().title_tips);
            this.O.setResultPageRiskTipVisiable(uploadVideoModel.getConfirmBean().tip_msg);
            this.O.setResultPageConfirmText(uploadVideoModel.getConfirmBean().confirm_msg);
            this.O.setResultPageCancelText(uploadVideoModel.getConfirmBean().cancel_msg);
            this.O.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f5767a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5767a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || System.currentTimeMillis() - this.f5767a.bS < 500) {
                        return;
                    }
                    this.f5767a.bS = System.currentTimeMillis();
                    this.f5767a.bL = 1;
                    this.f5767a.bM = 2;
                    this.f5767a.ai.setVisibility(0);
                    this.f5767a.aj.setVisibility(0);
                    this.f5767a.ak.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f5767a.aj.startAnimation(rotateAnimation);
                    this.f5767a.am.setVisibility(8);
                    this.f5767a.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f5767a.getActivity(), 13, LivenessRecogActivity.f5705b);
                    LivenessRecogDTO livenessRecogDTO = this.f5767a.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f5767a.bM);
                    dVar.a(this.f5767a.bL);
                    dVar.setResponseCallback(this.f5767a);
                    dVar.execBean();
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || System.currentTimeMillis() - this.f5767a.bS < 500) {
                        return;
                    }
                    this.f5767a.bS = System.currentTimeMillis();
                    this.f5767a.bL = 2;
                    this.f5767a.bM = 2;
                    this.f5767a.ai.setVisibility(0);
                    this.f5767a.aj.setVisibility(0);
                    this.f5767a.ak.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f5767a.aj.startAnimation(rotateAnimation);
                    this.f5767a.am.setVisibility(8);
                    this.f5767a.O.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f5767a.getActivity(), 13, LivenessRecogActivity.f5705b);
                    LivenessRecogDTO livenessRecogDTO = this.f5767a.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f5767a.bM);
                    dVar.a(this.f5767a.bL);
                    dVar.setResponseCallback(this.f5767a);
                    dVar.execBean();
                }
            });
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65600, this, i2, i3) == null) {
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
                this.aa.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5735a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5735a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f5735a.aa.dismiss();
                            if (this.f5735a.aR) {
                                this.f5735a.setActivityResult(-1);
                            }
                            if (this.f5735a.B != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                                this.f5735a.B.b(livenessRecogResult);
                            }
                            this.f5735a.a(true);
                        }
                    }
                });
            }
            this.aa.setCancelable(false);
            if (isFinishing() || this.aa.isShowing()) {
                return;
            }
            this.aa.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FaceVerifyData[] a(FaceVerifyData[] faceVerifyDataArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, this, faceVerifyDataArr)) == null) {
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
        return (FaceVerifyData[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceInfo[] faceInfoArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, faceInfoArr) == null) || faceInfoArr == null || faceInfoArr.length <= 0) {
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
                    RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.f6010i, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65618, this, faceInfo, errCode)) == null) ? faceInfo != null && this.aK == FaceTracker.ErrCode.OK : invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65601, this, i2, i3, str) == null) {
            this.F.clearAnimation();
            b(i3, str);
            if (i2 == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_midd_to_top);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this, i3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.30
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f5740a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f5741b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f5741b = this;
                        this.f5740a = i3;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            int i4 = this.f5740a;
                            if (i4 == 0) {
                                this.f5741b.d(2);
                            } else if (i4 == 1) {
                                this.f5741b.d(0);
                            } else if (i4 == 2) {
                                this.f5741b.d(3);
                            } else if (i4 == 3) {
                                this.f5741b.d(8);
                            }
                            if (this.f5741b.aN.u == 0) {
                                this.f5741b.aN.u = 1;
                            } else if (this.f5741b.aN.u == 5) {
                                this.f5741b.aN.u = 6;
                            } else if (this.f5741b.aN.u == 7) {
                                this.f5741b.aN.u = 8;
                            }
                            this.f5741b.G.setTextColor(-16777216);
                            this.f5741b.G.setTextSize(25.0f);
                            this.f5741b.F.setBackground(null);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                            this.f5741b.G.setTextSize(15.0f);
                            this.f5741b.G.setTextColor(-1);
                            this.f5741b.F.setBackgroundResource(R.drawable.rim_face_liveness_toast_round);
                        }
                    }
                });
                this.F.startAnimation(loadAnimation);
                this.G.setVisibility(0);
            }
        }
    }

    private boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65616, this, j2)) == null) ? System.currentTimeMillis() - this.aP > j2 : invokeJ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65614, this, z2) == null) {
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
}
