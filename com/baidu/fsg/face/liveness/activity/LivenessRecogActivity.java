package com.baidu.fsg.face.liveness.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.DisplayUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.e;
import com.baidu.fsg.face.liveness.beans.h;
import com.baidu.fsg.face.liveness.beans.j;
import com.baidu.fsg.face.liveness.beans.m;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.datamodel.GetRecordVedioQuestionModel;
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.CameraUtils;
import com.baidu.fsg.face.liveness.utils.LivenessABTestUtil;
import com.baidu.fsg.face.liveness.utils.SoUtils;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.fsg.face.liveness.view.CustomExitDialog;
import com.baidu.fsg.face.liveness.view.CustomProgressBar;
import com.baidu.fsg.face.liveness.view.LivenessXfordView;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.fsg.face.liveness.view.RecordVideoTipDialog;
import com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView;
import com.baidu.fsg.face.liveness.view.RimSuccessView;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 3;
    public static final int B = 4;
    public static final String EXTRA_UPLOAD_ACTION_TYPE = "action_type";
    public static final int REQUEST_CODE_LIVENESS_RECOG_ACTIVITY = 1001;
    public static final int UPLOAD_IMAGE_MAX_SIZE = 524288;
    public static final int aR = 0;
    public static final int aS = 1;
    public static final int aT = 1;
    public static final int aW = 0;
    public static final int aX = 1;
    public static final int aY = 2;
    public static final double av = 0.6d;
    public static final double aw = 0.667d;
    public static final double ax = 0.3845d;
    public static final double ay = 0.667d;
    public static final double az = 0.5d;
    public static final int bB = 1;
    public static final int bC = 2;
    public static final int bD = 1;
    public static final int bE = 2;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f34135c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34136d = "LivenessRecogActivity";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34137e = "CONSTRASTBEANTAG";

    /* renamed from: f  reason: collision with root package name */
    public static final int f34138f = 2002;

    /* renamed from: g  reason: collision with root package name */
    public static final int f34139g = 2003;

    /* renamed from: h  reason: collision with root package name */
    public static final int f34140h = 2004;

    /* renamed from: i  reason: collision with root package name */
    public static final int f34141i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f34142j = 1;
    public static final int k = 0;
    public static final int l = 7057;
    public static final int m = 7401;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 4;
    public static final int s = 5;
    public static final int t = 255;
    public static final int u = 1;
    public static final int v = 5000;
    public static final int w = 200;
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int C;
    public LivenessRecogCallback D;
    public ImageView E;
    public ImageView F;
    public ImageView G;
    public FrameLayout H;
    public TextView I;
    public RelativeLayout J;
    public TextView K;
    public TextView L;
    public TextView M;
    public LinearLayout N;
    public ImageView O;
    public TextView P;
    public RimFaceResultPageTipView Q;
    public RelativeLayout R;
    public ImageView S;
    public TextView T;
    public LinearLayout U;
    public ImageView V;
    public TextView W;
    public SurfaceView X;
    public ImageView Y;
    public LoadingDialog Z;
    public FaceProcessCallback a;
    public TextView aA;
    public LivenessRecogResult aB;
    public MediaPlayer aC;
    public FaceInfo[] aD;
    public int[] aE;
    public String[] aF;
    public int aG;
    public int[] aH;
    public boolean aI;
    public Handler aJ;
    public c aK;
    public a aL;
    public long aM;
    public boolean aN;
    public boolean aO;
    public boolean aP;
    public boolean aQ;
    public int aU;
    public int aV;
    public int aZ;
    public BioAlertDialog aa;
    public BioAlertDialog ab;
    public BioAlertDialog ac;
    public BioAlertDialog ad;
    public RecordVideoTipDialog ae;
    public CustomExitDialog af;
    public CustomExitDialog ag;
    public CustomExitDialog ah;
    public CustomExitDialog ai;
    public LivenessXfordView aj;
    public ImageView ak;
    public ImageView al;
    public RelativeLayout am;
    public TextView an;
    public LinearLayout ao;
    public CustomProgressBar ap;
    public RimSuccessView aq;
    public int ar;
    public int as;
    public Rect at;
    public Rect au;

    /* renamed from: b  reason: collision with root package name */
    public RecordCallback f34143b;
    public int bA;
    public UploadContrastPortraitModel bF;
    public long bG;
    public SurfaceHolder bH;
    public String bI;
    public String bJ;
    public String bK;
    public String bL;
    public int bM;
    public int bN;
    public int bO;
    public int bP;
    public Rect bQ;
    public Rect bR;
    public IVideoRecordProcess bS;
    public View.OnClickListener bT;
    public int[] ba;
    public int bb;
    public FrameLayout bc;
    public AnimationDrawable bd;
    public List<int[]> be;
    public Handler bf;
    public Runnable bg;
    public int bh;
    public long bi;
    public GetFPResponse.LivenessConfig bj;
    public boolean bk;
    public int bl;
    public int bm;
    public String bn;
    public String bo;
    public List<String> bp;
    public com.baidu.fsg.face.liveness.c bq;
    public com.baidu.fsg.face.liveness.b br;
    public int bs;
    public int bt;
    public ArrayList<HashMap<String, byte[]>> bu;
    public boolean bv;
    public boolean bw;
    public UploadContrastPortraitModel bx;
    public boolean by;
    public int bz;

    /* renamed from: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity$39  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass39 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1857865666, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$39;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1857865666, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$39;");
                    return;
                }
            }
            int[] iArr = new int[FaceStatusNewEnum.values().length];
            a = iArr;
            try {
                iArr[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionComplete.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePoorIllumination.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveEye.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTimeout.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionCodeTimeout.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f34155b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f34156c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f34157d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f34158e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f34159f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final long f34160g = 300;

        /* renamed from: h  reason: collision with root package name */
        public static final long f34161h = 1000;

        /* renamed from: i  reason: collision with root package name */
        public static final int f34162i = 7;
        public static final int q = 0;
        public static final int r = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public boolean f34163j;
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
            this.f34163j = false;
            this.k = false;
            this.l = false;
            this.m = 0;
            this.n = 7;
            this.o = 0;
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

    /* loaded from: classes10.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int B = 5000;
        public static final int C = 20000;
        public static final int a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f34164b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f34165c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final int f34166d = 2;

        /* renamed from: e  reason: collision with root package name */
        public static final int f34167e = 3;

        /* renamed from: f  reason: collision with root package name */
        public static final int f34168f = 4;

        /* renamed from: g  reason: collision with root package name */
        public static final int f34169g = 5;

        /* renamed from: h  reason: collision with root package name */
        public static final int f34170h = 6;

        /* renamed from: i  reason: collision with root package name */
        public static final int f34171i = 7;

        /* renamed from: j  reason: collision with root package name */
        public static final int f34172j = 8;
        public static final int k = 9;
        public static final int l = 10;
        public static final int m = 11;
        public static final int n = 12;
        public static final int o = 13;
        public static final int p = 14;
        public static final int q = 15;
        public static final int r = 16;
        public static final int s = 17;
        public static final int t = 18;
        public static final int u = 19;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean A;
        public long D;
        public long E;
        public boolean F;
        public boolean G;
        public final /* synthetic */ LivenessRecogActivity H;
        public int v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        public c(LivenessRecogActivity livenessRecogActivity) {
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
            this.H = livenessRecogActivity;
            this.v = -1;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.A = false;
            this.E = 20000L;
            this.F = false;
            this.G = false;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f34173b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f34174c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f34175d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f34176e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f34177f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f34178g = 6;

        /* renamed from: h  reason: collision with root package name */
        public static final int f34179h = 7;

        /* renamed from: i  reason: collision with root package name */
        public static final int f34180i = 8;

        /* renamed from: j  reason: collision with root package name */
        public static int[] f34181j;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475574666, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(475574666, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity$d;");
                    return;
                }
            }
            f34181j = new int[]{R.raw.sapi_camera_blink, R.raw.sapi_camera_found_face, R.raw.sapi_camera_put_face_round, R.raw.sapi_camera_nod, R.raw.sapi_camera_special_recg, R.raw.sapi_camera_photo_done, R.raw.sapi_camera_too_near, R.raw.sapi_camera_too_far, R.raw.sapi_camera_open_mouth};
        }

        public d() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-392800758, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-392800758, "Lcom/baidu/fsg/face/liveness/activity/LivenessRecogActivity;");
        }
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
        this.C = -1;
        this.aE = null;
        this.aI = false;
        this.aN = false;
        this.aO = false;
        this.aP = true;
        this.aQ = false;
        this.aU = 0;
        this.aV = 0;
        this.aZ = 0;
        this.ba = new int[]{5001, 5002, 7100, 7101, 7019, 7020};
        this.bb = 0;
        this.be = new ArrayList();
        this.bf = new Handler(Looper.getMainLooper());
        this.bg = new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LivenessRecogActivity a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.aG = 1;
                    this.a.W.setText(String.format("00:%02d", Integer.valueOf(this.a.aL.n)));
                    this.a.bf.postDelayed(this.a.bg, 1000L);
                    int size = this.a.bp.size() - (((this.a.aL.n + this.a.bm) - 1) / this.a.bm);
                    if (size == 0) {
                        this.a.K.setText((CharSequence) this.a.bp.get(size));
                        this.a.L.setText(String.format(this.a.getString(R.string.sapi_liveness_goto_next_question), Integer.valueOf(this.a.aL.n - this.a.bm)));
                    } else if (size == 1) {
                        this.a.K.setText((CharSequence) this.a.bp.get(size));
                        this.a.L.setText(String.format(this.a.getString(R.string.sapi_liveness_will_be_completed), Integer.valueOf(this.a.aL.n)));
                    }
                    if (this.a.aL.n == 1) {
                        this.a.E.setVisibility(8);
                        this.a.M.setVisibility(4);
                        this.a.V.clearAnimation();
                        this.a.U.setVisibility(4);
                    } else if (this.a.aL.n == 0) {
                        this.a.bf.removeCallbacks(this.a.bg);
                        this.a.aj.setLineVisiable(false);
                        this.a.aj.setMaskVisiable(true);
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.sapi_liveness_video_tip_slide_top_to_middle);
                        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

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
                                this.a = this;
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animation) == null) {
                                    this.a.a.K.setText(this.a.a.getString(R.string.sapi_liveness_upload_video));
                                    this.a.a.T();
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
                                    if (this.a.a.bS != null) {
                                        this.a.a.bS.stopRecord();
                                        LogUtil.d("hello", "video stop record");
                                    }
                                    this.a.a.K.setText(this.a.a.getString(R.string.sapi_liveness_record_success));
                                    this.a.a.L.setVisibility(4);
                                }
                            }
                        });
                        this.a.K.startAnimation(loadAnimation);
                        this.a.aq.setVisibility(0);
                        this.a.aq.loadSuccess();
                        this.a.aK.v = 15;
                    }
                    this.a.aL.n--;
                }
            }
        };
        this.bk = false;
        this.bl = 15;
        this.bm = 5;
        this.bp = new ArrayList();
        this.bw = false;
        this.bx = null;
        this.by = ApollonConstants.VIDEO_DEBUG;
        this.bz = 0;
        this.bA = 0;
        this.bF = null;
        this.bG = 0L;
        this.a = new FaceProcessCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.44
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LivenessRecogActivity a;

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
                this.a = this;
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void animStop() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBegin() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    LogUtil.d("hello", "face onBegin called");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBeginBuildData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    LogUtil.d("hello", "face onBeginBuildData called");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBeginCollectFaceInfo() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    LogUtil.d("hello", "face onBeginCollectFaceInfo");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i4)}) == null) || this.a.aK.v == 9) {
                    return;
                }
                this.a.a(faceStatusNewEnum, str, i4);
                if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                    this.a.aK.v = 9;
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onConfigCamera(Camera camera, Rect rect, Rect rect2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048581, this, camera, rect, rect2) == null) {
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.a.bO, this.a.bP);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewSize(similarRatioSize.width, similarRatioSize.height);
                    LogUtil.d("hello", "size.width:" + similarRatioSize.width + "size.height:" + similarRatioSize.height);
                    camera.setParameters(parameters);
                    this.a.bQ = new Rect(0, 0, similarRatioSize.height, similarRatioSize.width);
                    int width = this.a.au.width();
                    double doubleValue = new BigDecimal(Double.toString((double) this.a.au.height())).divide(new BigDecimal(Double.toString((double) this.a.as)), 10, 4).doubleValue();
                    double doubleValue2 = new BigDecimal(Double.toString((double) width)).divide(new BigDecimal(Double.toString((double) this.a.ar)), 10, 4).doubleValue();
                    double height = (this.a.bQ.height() - (this.a.bQ.height() * doubleValue)) / 2.0d;
                    double width2 = (this.a.bQ.width() - (this.a.bQ.width() * doubleValue2)) / 2.0d;
                    double height2 = this.a.bQ.height() - height;
                    double width3 = this.a.bQ.width() - width2;
                    this.a.bR = new Rect((int) width2, (int) height, (int) width3, (int) height2);
                    rect.set(this.a.bQ);
                    rect2.set(this.a.bR);
                    LogUtil.d("hello", "face onConfigCamera:" + this.a.bQ.toString() + "," + this.a.bR.toString());
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onDeviceCheckResult(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i4) == null) {
                    LogUtil.d("hello", "face onDeviceCheckResult:：" + i4);
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onEnd(int i4, RequestInfo requestInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048583, this, i4, requestInfo) == null) {
                    LogUtil.d("hello", "face onEnd called:" + i4);
                    if (i4 == -2) {
                        this.a.m();
                    } else if (i4 == -3 || i4 == -4) {
                        this.a.l();
                    } else if (i4 == -5) {
                        this.a.I();
                    } else if (i4 == 1 && this.a.aK.v == 9) {
                        try {
                            this.a.bJ = requestInfo.xDeviceId;
                            this.a.bI = requestInfo.sKey;
                            this.a.bK = requestInfo.data.getString("data");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        LogUtil.d("hello", "face onEnd xDeviceId:" + this.a.bJ + ",sKey:" + this.a.bI + ",faceData:" + this.a.bK);
                        this.a.E.setVisibility(8);
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.b(5, livenessRecogActivity.getString(R.string.sapi_liveness_network_checking));
                        this.a.aj.setLineVisiable(false);
                        this.a.aj.updateXfordViewProgress(0.5f, 0.75f, 500L, null);
                        this.a.M();
                        this.a.U();
                    }
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onTestFrame(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048585, this, livenessTypeEnum) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void setFaceInfo(FaceExtInfo faceExtInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048586, this, faceExtInfo) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void viewReset() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                }
            }
        };
        this.f34143b = new RecordCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LivenessRecogActivity a;

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
                this.a = this;
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBegin() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogUtil.d("hello", "video onBegin called");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBeginBuildData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    LogUtil.d("hello", "video onBeginBuildData");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBeginRecord() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    LogUtil.d("hello", "video onBeginRecord");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onConfigCamera(Camera camera) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, camera) == null) {
                    LogUtil.d("hello", "video onConfigCamera");
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.a.bO, this.a.bP);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewSize(similarRatioSize.width, similarRatioSize.height);
                    LogUtil.d("hello", "size.width:" + similarRatioSize.width + "size.height:" + similarRatioSize.height);
                    camera.setParameters(parameters);
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onDeviceCheckResult(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    LogUtil.d("hello", "video onDeviceCheckResult:" + i4);
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onEnd(int i4, RequestInfo requestInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048581, this, i4, requestInfo) == null) {
                    LogUtil.d("hello", "video onEnd:" + i4);
                    if (i4 == -2) {
                        this.a.m();
                    } else if (i4 == -3 || i4 == -4) {
                        this.a.l();
                    } else if (i4 == -5) {
                        this.a.I();
                    } else if (i4 == 1) {
                        try {
                            this.a.bJ = requestInfo.xDeviceId;
                            this.a.bI = requestInfo.sKey;
                            g.a(requestInfo.path);
                            this.a.bK = requestInfo.data.getString("data");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048582, this, bArr, camera) == null) {
                }
            }
        };
        this.bT = new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.30
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LivenessRecogActivity a;

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
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && view.getId() == R.id.tv_record_video_retry) {
                    this.a.t();
                    this.a.K();
                    this.a.w();
                }
            }
        };
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65673, null, contentResolver)) == null) {
            try {
                return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
            } catch (Settings.SettingNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65694, null, activity, i2) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public void callbackFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.D == null) {
            return;
        }
        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
        livenessRecogResult.setResultCode(i2);
        livenessRecogResult.setResultMsg(str);
        this.D.b(livenessRecogResult);
        Q();
    }

    public void getRecordVideoQuestions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(getString(R.string.sapi_loading));
            h hVar = (h) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 6, f34136d);
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
                if (this.bw) {
                    this.al.clearAnimation();
                    this.ak.setVisibility(8);
                    this.al.setVisibility(8);
                    this.am.setVisibility(8);
                    BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                    if (this.aZ == 1) {
                        while (true) {
                            int[] iArr = this.ba;
                            if (i4 >= iArr.length) {
                                break;
                            }
                            if (i3 == iArr[i4]) {
                                this.aV++;
                            }
                            i4++;
                        }
                        if (this.aV >= 1) {
                            x();
                            return;
                        } else {
                            callbackFailure(i3, str);
                            return;
                        }
                    }
                    callbackFailure(i3, str);
                }
            } else if (i2 == 6) {
                W();
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
            } else if (this.aO && this.bx != null) {
                if (!ApollonConstants.VIDEO_DEBUG) {
                    g.c(g.c(getActivity()));
                }
                a(this.bx);
                this.bx = null;
            } else if (this.aO) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i3);
                livenessRecogResult.setResultMsg(str);
                this.D.b(livenessRecogResult);
                Q();
            } else {
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, i3, arrayList);
                }
                c cVar = this.aK;
                cVar.y = false;
                if (cVar.z) {
                    return;
                }
                if (i3 == 7057) {
                    F();
                } else if (i3 == 7401) {
                    G();
                } else {
                    E();
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
                    this.bo = uploadContrastPortraitModel2.callbackkey;
                    if (uploadContrastPortraitModel2.isFinish()) {
                        BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                        File file = new File(g.c(getActivity()));
                        if (this.aO && file.exists() && file.length() > 0) {
                            this.bx = uploadContrastPortraitModel2;
                            S();
                            return;
                        }
                        a(uploadContrastPortraitModel2);
                        return;
                    }
                    return;
                }
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
            } else if (i2 == 6) {
                W();
                if (obj != null && (obj instanceof GetRecordVedioQuestionModel)) {
                    GetRecordVedioQuestionModel getRecordVedioQuestionModel = (GetRecordVedioQuestionModel) obj;
                    if (!TextUtils.isEmpty(getRecordVedioQuestionModel.callbackkey) && (strArr = getRecordVedioQuestionModel.question) != null && strArr.length != 0) {
                        this.bn = getRecordVedioQuestionModel.callbackkey;
                        this.bp = Arrays.asList(strArr);
                        this.bm = getRecordVedioQuestionModel.questime;
                        u();
                        return;
                    }
                    c(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                    return;
                }
                handleFailure(i2, -4, ResUtils.getString(this.mAct, "rim_base_get_data_fail"));
            } else if (i2 == 7) {
                if (this.aO && this.bx != null) {
                    if (!ApollonConstants.VIDEO_DEBUG) {
                        g.c(g.c(getActivity()));
                    }
                    a(this.bx);
                    this.bx = null;
                    return;
                }
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.y, 0, arrayList);
                }
                c cVar = this.aK;
                cVar.y = false;
                if (obj == null || !(obj instanceof UploadVideoModel)) {
                    return;
                }
                UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
                if (cVar.z) {
                    return;
                }
                g.c(g.b(getActivity()));
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                this.aB = livenessRecogResult;
                livenessRecogResult.callbackkey = uploadVideoModel.callbackkey;
                livenessRecogResult.video = uploadVideoModel.video;
                livenessRecogResult.setResultCode(0);
                if (uploadVideoModel.need_confirm == null) {
                    LivenessRecogCallback livenessRecogCallback = this.D;
                    if (livenessRecogCallback != null) {
                        livenessRecogCallback.a(this.aB);
                    }
                    Q();
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
                if (this.D != null) {
                    new AsyncTask<Void, Void, LivenessRecogResult>(this, str) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LivenessRecogActivity f34144b;

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
                            this.f34144b = this;
                            this.a = str;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public LivenessRecogResult doInBackground(Void... voidArr) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) {
                                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                                livenessRecogResult2.setResultCode(0);
                                try {
                                    livenessRecogResult2.extraJson = new JSONObject(this.a);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
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
                                this.f34144b.D.a(livenessRecogResult2);
                                this.f34144b.Q();
                            }
                        }
                    }.execute(new Void[0]);
                }
            } else if (i2 == 13) {
                if (this.bA == 1 && this.bz == 1 && (uploadContrastPortraitModel = this.bF) != null) {
                    b(uploadContrastPortraitModel);
                } else if (this.bA == 1 && this.bz == 2) {
                    a();
                    Q();
                    this.Q.setVisibility(8);
                } else if (this.bA == 2 && this.bz == 1) {
                    LivenessRecogCallback livenessRecogCallback2 = this.D;
                    if (livenessRecogCallback2 != null) {
                        livenessRecogCallback2.a(this.aB);
                    }
                    Q();
                } else if (this.bA == 2 && this.bz == 2) {
                    a();
                    Q();
                    this.Q.setVisibility(8);
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
                this.bv = bundle.getBoolean("hasCameraReadyStatistics", false);
            }
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            this.D = livenessRecogCallback;
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO == null) {
                if (livenessRecogCallback != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(-206);
                    livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_SERVER_ERROR);
                    this.D.b(livenessRecogResult);
                }
                Q();
            } else if (f34135c) {
                k();
                LogUtil.d("hello", "callManyTimes");
            } else {
                f34135c = true;
                if (livenessRecogDTO.spParams.contains("video_check=2")) {
                    this.aZ = 2;
                } else if (this.livenessRecogDTO.spParams.contains("video_check=1")) {
                    this.aZ = 1;
                }
                requestWindowFeature(1);
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(128);
                FrameLayout frameLayout = (FrameLayout) View.inflate(this, R.layout.layout_sapi_liveness_recognize, null);
                this.bc = frameLayout;
                setContentView(frameLayout);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int i2 = displayMetrics.widthPixels;
                this.bM = i2;
                int i3 = displayMetrics.heightPixels;
                this.bN = i3;
                int i4 = (int) (i2 * 0.667d);
                int i5 = (i2 - i4) / 2;
                int i6 = ((int) (i3 * 0.3845d)) - (i4 / 2);
                this.au = new Rect(i5, i6, i5 + i4, i4 + i6);
                int i7 = this.bM;
                int i8 = (int) (i7 * 0.6d);
                int i9 = (i7 - i8) / 2;
                int i10 = ((int) (this.bN * 0.3845d)) - (i8 / 2);
                this.at = new Rect(i9, i10, i9 + i8, i8 + i10);
                d();
                b();
                this.aj.setFocusViewRect(this.at, this.au);
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(f34136d);
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
            this.aI = true;
            this.aE = null;
            LivenessXfordView livenessXfordView = this.aj;
            if (livenessXfordView != null) {
                livenessXfordView.release();
            }
            this.be.clear();
            this.be = null;
            try {
                this.bc.removeView(this.X);
                this.X = null;
                a(this.bc);
                this.bc.removeCallbacks(null);
                this.bc = null;
                this.aJ.removeCallbacksAndMessages(null);
                System.gc();
            } catch (Exception e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
            }
            f34135c = false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.al.getVisibility() == 0) {
                    return false;
                }
                if (this.aK.y) {
                    C();
                    return false;
                }
                com.baidu.fsg.face.liveness.b bVar = this.br;
                if (bVar != null) {
                    bVar.a(com.baidu.fsg.face.liveness.d.o);
                }
                a();
                Q();
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            int i3 = 0;
            this.aK.G = false;
            if (i2 != 2002) {
                if (i2 == 2004) {
                    int i4 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
                    if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                        i3 = 1;
                    }
                    if (i4 == 1 && i3 == 1) {
                        RecordVideoTipDialog recordVideoTipDialog = this.ae;
                        if (recordVideoTipDialog != null && recordVideoTipDialog.isShowing()) {
                            this.ae.dismiss();
                        }
                        r();
                        return;
                    }
                    a(i4, i3);
                }
            } else if (this.aO && this.aP) {
                int i5 = (iArr != null && iArr.length == 2 && iArr[0] == 0) ? 1 : 0;
                if (iArr != null && iArr.length == 2 && iArr[1] == 0) {
                    i3 = 1;
                }
                if (i5 == 1 && i3 == 1) {
                    q();
                } else {
                    a(i5, i3);
                }
            } else if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                q();
            } else {
                H();
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("hasCameraReadyStatistics", this.bv);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStart();
            LogUtil.d("hello", "recog onStart");
            c cVar = this.aK;
            if (cVar.A) {
                D();
                this.aK.A = false;
            } else if (cVar.v >= 9) {
            } else {
                if (!this.bk) {
                    v();
                } else {
                    w();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            LogUtil.d("hello", "recog onStop");
            if (this.bS != null) {
                LogUtil.d("hello", "mProcess.release");
                this.bS.release();
            }
            LogUtil.d("hello", "cancel face process");
            FH.cancelFaceProcess();
            c cVar = this.aK;
            if (!cVar.G && cVar.v == 14) {
                cVar.A = true;
                LivenessXfordView livenessXfordView = this.aj;
                if (livenessXfordView != null) {
                    livenessXfordView.setLineVisiable(false);
                    this.aj.stopXfordViewProgress();
                }
                Handler handler = this.bf;
                if (handler != null) {
                    handler.removeCallbacks(this.bg);
                }
            }
        }
    }

    public void setActivityResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            Intent intent = new Intent();
            intent.putExtras(new Bundle());
            setResult(i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            FH.cancelFaceProcess();
            this.aj.setLineVisiable(false);
            this.aK.v = 18;
            CustomExitDialog customExitDialog = new CustomExitDialog(this);
            this.ag = customExitDialog;
            customExitDialog.setDialogTitle(getString(R.string.rim_face_exit_action_title));
            this.ag.setDialogContext(getString(R.string.rim_face_exit_action_content));
            this.ag.setPositiveText(getString(R.string.rim_face_exit_action_positive), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.s();
                        this.a.aK.v = -1;
                        this.a.q();
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.aG = livenessRecogActivity.c();
                        this.a.aL.k = false;
                        this.a.aL.l = false;
                        this.a.aK.D = System.currentTimeMillis();
                        this.a.ag.dismiss();
                    }
                }
            });
            this.ag.setNegativeText(getString(R.string.rim_face_exit_action_negative), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.br != null) {
                            this.a.br.a(com.baidu.fsg.face.liveness.d.o);
                        }
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
            this.ag.setCancelable(false);
            this.ag.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            IVideoRecordProcess iVideoRecordProcess = this.bS;
            if (iVideoRecordProcess != null) {
                iVideoRecordProcess.release();
            }
            this.aj.setLineVisiable(false);
            this.aj.stopXfordViewProgress();
            this.bf.removeCallbacks(this.bg);
            this.aK.v = 18;
            CustomExitDialog customExitDialog = new CustomExitDialog(this);
            this.ah = customExitDialog;
            customExitDialog.setDialogTitle(getString(R.string.rim_face_exit_record_title));
            this.ah.setDialogContext(getString(R.string.rim_face_exit_record_content));
            this.ah.setPositiveText(getString(R.string.rim_face_exit_record_positive), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.t();
                        this.a.K();
                        this.a.w();
                        this.a.ah.dismiss();
                    }
                }
            });
            this.ah.setNegativeText(getString(R.string.rim_face_exit_record_negative), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.a.br != null) {
                            this.a.br.a(com.baidu.fsg.face.liveness.d.o);
                        }
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
            this.ah.setCancelable(false);
            this.ah.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            CustomExitDialog customExitDialog = new CustomExitDialog(this);
            this.ai = customExitDialog;
            customExitDialog.setDialogTitle(getString(R.string.sapi_liveness_record_up_exit));
            this.ai.setPositiveText(getString(R.string.sapi_liveness_record_up_exit_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.aK.z = false;
                        this.a.ai.dismiss();
                        this.a.T();
                    }
                }
            });
            this.ai.setNegativeText(getString(R.string.sapi_liveness_record_up_exit_btn_cancel), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        g.c(g.b(this.a.getActivity()));
                        this.a.aK.z = false;
                        this.a.ai.dismiss();
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
            this.ai.setCancelable(false);
            if (isFinishing() || this.ai.isShowing()) {
                return;
            }
            this.ai.show();
        }
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            CustomExitDialog customExitDialog = this.af;
            if (customExitDialog == null || !customExitDialog.isShowing()) {
                CustomExitDialog customExitDialog2 = new CustomExitDialog(this);
                this.af = customExitDialog2;
                customExitDialog2.setDialogTitle(getString(R.string.sapi_liveness_record_video_exit_dialog_title));
                this.af.setPositiveText(getString(R.string.sapi_liveness_record_video_exit_text), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.af.dismiss();
                            this.a.t();
                            this.a.af.dismiss();
                            this.a.w();
                        }
                    }
                });
                this.af.setNegativeText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.af.dismiss();
                            this.a.a();
                            this.a.Q();
                        }
                    }
                });
                this.af.setCancelable(false);
                if (isFinishing() || this.af.isShowing()) {
                    return;
                }
                this.af.show();
            }
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg_retry));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_upload_video_fail_dialog_reupload));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.T();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.a();
                        g.c(g.b(this.a.getActivity()));
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.sapi_liveness_record_video_title_upload_timeout));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_cancel));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.Q.setVisibility(4);
                        this.a.K();
                        this.a.t();
                        this.a.w();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(4);
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.sapi_liveness_record_video_no_face));
            this.Q.setResultPageNextTitle(getString(R.string.sapi_liveness_record_video_in_rect));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_record_video_record_again));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_upload_video_fail_dialog_exit));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.Q.setVisibility(4);
                        this.a.K();
                        this.a.t();
                        this.a.w();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(4);
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.aK.G = true;
            if (this.aa == null) {
                BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
                this.aa = bioAlertDialog;
                bioAlertDialog.setTitleMsg(getString(R.string.sapi_permission_request));
                this.aa.setTitleVisible(true);
                this.aa.setDialogMsg(String.format(getString(R.string.sapi_liveness_permission_camera), com.baidu.fsg.face.base.d.h.c(this)));
                this.aa.setBtnCount(1);
                this.aa.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.aa.dismiss();
                            this.a.aK.G = false;
                            if (this.a.D != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.a.D.b(livenessRecogResult);
                            }
                            this.a.Q();
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
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.aK.v = 19;
            if (this.ab == null) {
                BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
                this.ab = bioAlertDialog;
                bioAlertDialog.setTitleVisible(true);
                this.ab.setDialogMsg(getString(R.string.sapi_liveness_open_camera_no_permission));
                this.ab.setBtnCount(1);
                this.ab.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.27
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.ab.dismiss();
                            if (this.a.D != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.a.D.b(livenessRecogResult);
                            }
                            this.a.Q();
                        }
                    }
                });
            }
            this.ab.setCancelable(false);
            if (isFinishing() || this.ab.isShowing()) {
                return;
            }
            this.ab.show();
        }
    }

    private void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleVisible(true);
            bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_record_video_no_audio_permission));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f34146b;

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
                    this.f34146b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        if (this.f34146b.D != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            this.f34146b.D.b(livenessRecogResult);
                        }
                        this.f34146b.Q();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.aj.setVisibility(0);
            this.W.setVisibility(0);
            this.V.setVisibility(0);
        }
    }

    private void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.bd = (AnimationDrawable) this.G.getDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.ak.setVisibility(0);
            this.al.setVisibility(0);
            this.am.setVisibility(0);
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatMode(1);
            rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
            rotateAnimation.setInterpolator(linearInterpolator);
            this.al.startAnimation(rotateAnimation);
        }
    }

    private void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.al.clearAnimation();
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
            this.am.setVisibility(8);
        }
    }

    private void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.spai_liveness_video_scale_count_down);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_video_tip_slide_midd_to_top);
            this.R.setVisibility(0);
            this.T.setVisibility(0);
            this.T.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this, loadAnimation2) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animation a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f34149b;

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
                    this.f34149b = this;
                    this.a = loadAnimation2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.f34149b.aK.A) {
                        return;
                    }
                    if (this.f34149b.af == null || !this.f34149b.af.isShowing()) {
                        this.f34149b.T.setTextSize(14.5f);
                        this.f34149b.T.setText(R.string.sapi_liveness_video_start_record_new);
                        this.f34149b.S.setVisibility(0);
                        this.f34149b.aL.m = 0;
                        this.f34149b.S.startAnimation(this.a);
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
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f34149b.aK.A) {
                        return;
                    }
                    if (this.f34149b.af == null || !this.f34149b.af.isShowing()) {
                        this.f34149b.T.setTextSize(12.0f);
                        String string = this.f34149b.getString(R.string.sapi_liveness_video_start_record_later_new);
                        this.f34149b.aL.n = this.f34149b.bp.size() * this.f34149b.bm;
                        this.f34149b.T.setText(String.format(string, Integer.valueOf(this.f34149b.aL.n)));
                        this.f34149b.S.setVisibility(4);
                        this.f34149b.aj.setProgress(0.0f);
                        this.f34149b.aj.setMaskVisiable(true);
                        this.f34149b.aj.setLineVisiable(false);
                        this.f34149b.U.setVisibility(4);
                    }
                }
            });
            loadAnimation2.setAnimationListener(new Animation.AnimationListener(this, loadAnimation3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animation a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f34151b;

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
                    this.f34151b = this;
                    this.a = loadAnimation3;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.f34151b.aK.A) {
                        return;
                    }
                    if (this.f34151b.af == null || !this.f34151b.af.isShowing()) {
                        this.f34151b.aL.m++;
                        if (this.f34151b.aL.m != 1) {
                            if (this.f34151b.aL.m == 3) {
                                this.f34151b.S.setImageResource(R.drawable.sapi_liveness_video_count_down_1);
                                this.f34151b.S.startAnimation(animation);
                                return;
                            } else if (this.f34151b.aL.m > 4) {
                                this.f34151b.R.setVisibility(4);
                                this.f34151b.T.setVisibility(4);
                                this.f34151b.S.setVisibility(4);
                                this.f34151b.K.startAnimation(this.a);
                                this.f34151b.aj.setMaskVisiable(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        animation.reset();
                        this.f34151b.S.setImageResource(R.drawable.sapi_liveness_video_count_down_2);
                        this.f34151b.S.startAnimation(animation);
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
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f34151b.aK.A) {
                        return;
                    }
                    if (this.f34151b.af == null || !this.f34151b.af.isShowing()) {
                        if (this.f34151b.aL.m == 0) {
                            this.f34151b.S.setImageResource(R.drawable.sapi_liveness_video_count_down_3);
                        }
                        this.f34151b.K.setText(String.format(this.f34151b.getString(R.string.sapi_liveness_video_answer_question), Integer.valueOf(this.f34151b.bp.size())));
                    }
                }
            });
            loadAnimation3.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) || this.a.aK.A) {
                        return;
                    }
                    if (this.a.af == null || !this.a.af.isShowing()) {
                        this.a.L.setVisibility(0);
                        this.a.U.setVisibility(0);
                        this.a.W.setText(String.format("00:%02d", Integer.valueOf(this.a.aL.n)));
                        this.a.P();
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
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.a.aK.A) {
                        return;
                    }
                    if (this.a.af == null || !this.a.af.isShowing()) {
                        this.a.K.setText((CharSequence) this.a.bp.get(0));
                        this.a.L.setVisibility(4);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            IVideoRecordProcess iVideoRecordProcess = this.bS;
            if (iVideoRecordProcess != null) {
                iVideoRecordProcess.startRecord();
                LogUtil.d("hello", "video start record");
            }
            this.aj.setLineVisiable(true);
            this.E.setVisibility(0);
            this.M.setVisibility(0);
            this.bf.post(this.bg);
            this.aj.updateXfordViewProgress(0.0f, 1.0f, this.aL.n * 1000, null);
            this.V.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_time_count_point));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            try {
                if (this.aC != null) {
                    this.aC.stop();
                    this.aC.release();
                    this.aC = null;
                }
            } catch (Exception e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
            }
            setActivityResult(-1);
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String R() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
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

    private void S() {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
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
                m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f34136d);
                UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                uploadFileModel.filedata = bArr;
                uploadFileModel.fileName = "video.3gp";
                uploadFileModel.name = "file";
                mVar.addFile(uploadFileModel);
                mVar.g("process");
                mVar.e(this.bo);
                mVar.f(this.bo);
                mVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
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
    public void T() {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            this.aK.y = true;
            this.aq.setVisibility(4);
            this.ap.setPercent(0.0f);
            this.ao.setVisibility(0);
            this.aK.v = 16;
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
                m mVar = (m) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 7, f34136d);
                UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                uploadFileModel.filedata = bArr;
                uploadFileModel.fileName = "video.3gp";
                uploadFileModel.name = "file";
                mVar.a(this.bI);
                mVar.c(this.bJ);
                mVar.b(this.bK);
                mVar.addFile(uploadFileModel);
                mVar.e(this.bn);
                mVar.f(this.bo);
                mVar.d("1");
                mVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.38
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
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
                            this.a.runOnUiThread(new Runnable(this, j2, j3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.38.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ long a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ long f34152b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass38 f34153c;

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
                                    this.f34153c = this;
                                    this.a = j2;
                                    this.f34152b = j3;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        TextView textView = this.f34153c.a.an;
                                        textView.setText(((int) ((((float) this.a) / ((float) this.f34152b)) * 100.0f)) + "%");
                                        this.f34153c.a.ap.setPercent(((float) this.a) / ((float) this.f34152b));
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
                E();
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
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.bw = true;
            j jVar = (j) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 5, "CONSTRASTBEANTAG");
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO != null) {
                jVar.a(livenessRecogDTO);
            }
            jVar.g("image");
            jVar.e("digests");
            jVar.a(this.bI);
            jVar.c(this.bJ);
            jVar.b(this.bK);
            jVar.d("1");
            jVar.setResponseCallback(this);
            jVar.a(this.bw);
            jVar.execBean();
        }
    }

    private void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            int i2 = this.bt + 1;
            this.bt = i2;
            ArrayList<HashMap<String, byte[]>> arrayList = this.bu;
            if (arrayList == null || i2 > this.bs || i2 > arrayList.size()) {
                return;
            }
            this.bw = this.bt == this.bu.size();
            if (this.bt == 1) {
                RimStatisticsUtil.onEventStart(com.baidu.fsg.face.liveness.d.H);
            }
            e eVar = (e) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 8, "CONSTRASTBEANTAG");
            new UploadBean.UploadFileModel().contentType = "image/png";
            eVar.setResponseCallback(this);
            eVar.a(this.bw);
            eVar.execBean();
        }
    }

    private void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65582, this) == null) || this.Z == null || isFinishing() || !this.Z.isShowing()) {
            return;
        }
        this.Z.dismiss();
    }

    private int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
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

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65668, this) == null) {
            if (!SoUtils.loadAIModelSo(this)) {
                h();
            } else if (!FH.isInitSuc(1)) {
                i();
            } else {
                n();
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65670, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-403);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_MML_FRAMEWORK_NOT_FIND);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65672, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-404);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_SAFE_MODULE_LOAD_FAIL);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65675, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-303);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_FACE_SDK_INIT_FAIL);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65677, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(com.baidu.fsg.face.base.c.a.ERROR_CODE_MANY_CALL);
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_MANY_CALL);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65679, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_UNTRUSTED_DEVICE);
                livenessRecogResult.setResultCode(com.baidu.fsg.face.base.c.a.ERROR_CODE_UNTRUSTED_DEVICE);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65681, this) == null) {
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_BUILD_DATA_ERROR);
                livenessRecogResult.setResultCode(com.baidu.fsg.face.base.c.a.ERROR_CODE_BUILD_DATA_ERROR);
                this.D.b(livenessRecogResult);
            }
            Q();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65683, this) == null) {
            FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Random().nextInt(100) % 2 == 0 ? LivenessTypeEnum.Eye : LivenessTypeEnum.Mouth);
            faceConfig.setLivenessTypeList(arrayList);
            faceConfig.setCacheImageNum(1);
            faceConfig.setOutputImageType(1);
            faceConfig.setBlurnessValue(0.8f);
            faceConfig.setBrightnessValue(30.0f);
            faceConfig.setBrightnessMaxValue(240.0f);
            faceConfig.setOcclusionLeftEyeValue(0.95f);
            faceConfig.setOcclusionRightEyeValue(0.95f);
            faceConfig.setOcclusionNoseValue(0.95f);
            faceConfig.setOcclusionMouthValue(0.95f);
            faceConfig.setOcclusionLeftContourValue(0.95f);
            faceConfig.setOcclusionRightContourValue(0.95f);
            faceConfig.setOcclusionChinValue(0.95f);
            faceConfig.setHeadPitchValue(30);
            faceConfig.setHeadYawValue(18);
            faceConfig.setHeadRollValue(30);
            FaceSDKManager.getInstance().setFaceConfig(faceConfig);
            FaceSDKManager.getInstance().initialize(this, "baidu-sec-face-demo-face-android", "idl-license.face-android", new IInitCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.42
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.pass.face.platform.listener.IInitCallback
                public void initFailure(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.a.j();
                        LogUtil.d("hello", "初始化失败 = " + i2 + " " + str);
                    }
                }

                @Override // com.baidu.pass.face.platform.listener.IInitCallback
                public void initSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        LogUtil.d("hello", "初始化成功");
                    }
                }
            });
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65684, this) == null) {
            LogUtil.d("hello", "doSurfaceChange");
            this.X.setVisibility(4);
            this.X.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65687, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.X.getLayoutParams());
            int i2 = (int) (this.bO * 0.667d);
            this.ar = i2;
            int i3 = (int) (this.bP * 0.667d);
            this.as = i3;
            layoutParams.width = i2;
            layoutParams.height = i3;
            LogUtil.d("surfaceHeight:" + this.as + "，surfaceWidth:" + this.ar);
            double d2 = ((double) this.bN) * 0.3845d;
            layoutParams.topMargin = (int) (d2 - (((double) this.as) * 0.5d));
            layoutParams.gravity = 1;
            this.X.setLayoutParams(layoutParams);
            int dip2px = DisplayUtils.dip2px(this, 35.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.H.getLayoutParams());
            int i4 = (int) (d2 - (dip2px / 2));
            layoutParams2.topMargin = i4;
            layoutParams2.gravity = 1;
            this.H.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.N.getLayoutParams());
            layoutParams3.topMargin = i4;
            layoutParams3.gravity = 1;
            this.N.setLayoutParams(layoutParams3);
            int dip2px2 = DisplayUtils.dip2px(this, 62.0f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.J.getLayoutParams());
            layoutParams4.topMargin = (int) ((d2 - (this.au.width() / 2)) - dip2px2);
            layoutParams4.gravity = 1;
            this.J.setLayoutParams(layoutParams4);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.G.getLayoutParams());
            layoutParams5.width = this.at.width();
            layoutParams5.height = this.at.width();
            layoutParams5.topMargin = (int) (d2 - (this.at.width() / 2));
            layoutParams5.gravity = 1;
            this.G.setLayoutParams(layoutParams5);
            int width = this.at.width() / 3;
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(this.G.getLayoutParams());
            layoutParams6.width = width;
            layoutParams6.height = width;
            layoutParams6.topMargin = (int) (d2 - (width / 2));
            layoutParams6.gravity = 1;
            this.ak.setLayoutParams(layoutParams6);
            this.al.setLayoutParams(layoutParams6);
            int width2 = this.at.width() / 3;
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(this.aq.getLayoutParams());
            layoutParams7.width = width2;
            layoutParams7.height = width2;
            layoutParams7.topMargin = (int) (d2 - (width2 / 2));
            layoutParams7.gravity = 1;
            this.aq.setLayoutParams(layoutParams7);
            int dip2px3 = DisplayUtils.dip2px(this, 84.5f);
            FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(this.R.getLayoutParams());
            layoutParams8.topMargin = (int) (d2 - (dip2px3 / 2));
            layoutParams8.gravity = 1;
            this.R.setLayoutParams(layoutParams8);
            int dip2px4 = DisplayUtils.dip2px(this, 25.5f);
            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(this.U.getLayoutParams());
            layoutParams9.topMargin = (int) (((this.bM * 0.667d) / 2.0d) + d2 + dip2px4);
            layoutParams9.gravity = 1;
            this.U.setLayoutParams(layoutParams9);
            int dip2px5 = DisplayUtils.dip2px(this, 42.5f);
            FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(this.ao.getLayoutParams());
            layoutParams10.topMargin = (int) (d2 - (dip2px5 / 2));
            layoutParams10.gravity = 1;
            this.ao.setLayoutParams(layoutParams10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65689, this) == null) {
            LogUtil.d("hello", "startFaceVerify");
            this.aK.v = 0;
            a(1, 0, (String) null);
            this.aj.updateXfordViewProgress(0.0f, 0.25f, 500L, null);
            this.bH.addCallback(new SurfaceHolder.Callback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.43
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
                        if (i3 == this.a.bM) {
                            this.a.bO = i3;
                            this.a.bP = i4;
                            this.a.p();
                        }
                        LogUtil.d("hello", "face surfaceChanged,surWidth:" + i3 + ",surHeight:" + i4);
                        if (this.a.aK.v != 0) {
                            return;
                        }
                        this.a.aK.v = 1;
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        FH.startFaceVerify(livenessRecogActivity, livenessRecogActivity.bH, this.a.a, 0, null, true);
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                    }
                }
            });
            o();
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65691, this) == null) {
            if (this.bS != null) {
                LogUtil.d("hello", "mProcess.release");
                this.bS.release();
            }
            LogUtil.d("hello", "startFaceRecord");
            this.aK.v = 12;
            this.bH.addCallback(new SurfaceHolder.Callback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
                        if (i3 == this.a.bM) {
                            this.a.bO = i3;
                            this.a.bP = i4;
                            this.a.p();
                        }
                        LogUtil.d("hello", "video surfaceChanged,surWidth:" + i3 + ",surHeight:" + i4);
                        if (this.a.aK.v != 12) {
                            return;
                        }
                        this.a.aK.v = 14;
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.bS = FH.getVideoRecordProcess(livenessRecogActivity, livenessRecogActivity.bH, this.a.f34143b, -1);
                        LogUtil.d("hello", "get video process mProcess:" + this.a.bS);
                        if (this.a.bS != null) {
                            this.a.bS.prepare();
                            LogUtil.d("hello", "video prepare");
                        }
                        this.a.getRecordVideoQuestions();
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                    }
                }
            });
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65692, this) == null) {
            this.aj.setLineVisiable(true);
            this.E.setVisibility(0);
            this.N.setVisibility(4);
            this.C = -1;
            this.I.setText(R.string.sapi_liveness_put_face_round);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65696, this) == null) {
            this.aj.stopXfordViewProgress();
            Handler handler = this.bf;
            if (handler != null) {
                handler.removeCallbacks(this.bg);
            }
            this.T.clearAnimation();
            this.T.setVisibility(4);
            this.aL.m = -100;
            this.S.clearAnimation();
            this.S.setVisibility(4);
            this.K.clearAnimation();
            this.K.setText(R.string.sapi_liveness_put_face_round_new);
            this.L.setVisibility(4);
            this.ap.setPercent(0.0f);
            this.ao.setVisibility(4);
            this.T.removeCallbacks(null);
            this.N.setVisibility(4);
            this.I.setVisibility(4);
            this.C = -1;
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65697, this) == null) {
            this.J.setVisibility(0);
            this.I.setVisibility(4);
            this.E.setVisibility(8);
            this.M.setVisibility(4);
            this.M.setOnClickListener(this.bT);
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65700, this) == null) {
            if (this.aO && this.aP) {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
            } else {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            }
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @RequiresApi(api = 23)
                    public void isAllAgree(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (z2) {
                                this.a.aK.G = true;
                                if (this.a.aO && this.a.aP) {
                                    this.a.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                                    return;
                                } else {
                                    this.a.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                                    return;
                                }
                            }
                            if (this.a.D != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(-307);
                                this.a.D.b(livenessRecogResult);
                            }
                            this.a.Q();
                        }
                    }
                });
            } else {
                q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65702, this) == null) {
            this.F.setVisibility(4);
            this.N.setVisibility(4);
            this.H.setVisibility(4);
            String[] strArr = {PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @RequiresApi(api = 23)
                    public void isAllAgree(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            if (z2) {
                                this.a.aK.G = true;
                                this.a.requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE, PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2004);
                                return;
                            }
                            if (this.a.D != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                                this.a.D.b(livenessRecogResult);
                            }
                            this.a.Q();
                        }
                    }
                });
                return;
            }
            RecordVideoTipDialog recordVideoTipDialog = this.ae;
            if (recordVideoTipDialog != null && recordVideoTipDialog.isShowing()) {
                this.ae.dismiss();
            }
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65704, this) == null) {
            b("2");
            this.aK.v = 18;
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_safe);
            this.Q.setResultPageTitle(getString(R.string.rim_face_result_success_record));
            this.Q.setResultPageNextTitleBold(getString(R.string.rim_face_result_record_video));
            this.Q.setResultPageConfirmText(getString(R.string.rim_face_result_start_record));
            this.Q.setResultPageCancelText(getString(R.string.rim_face_result_retry_liveness));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.t();
                        this.a.w();
                        this.a.Q.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.aK.v = -1;
                        this.a.v();
                        this.a.aD = null;
                        this.a.s();
                        this.a.aL.k = false;
                        this.a.aL.l = false;
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.aG = livenessRecogActivity.c();
                        this.a.aK.D = System.currentTimeMillis();
                        this.a.Q.setVisibility(8);
                    }
                }
            });
            this.Q.setOnCloseListener(new RimFaceResultPageTipView.b(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                        this.a.Q();
                        this.a.Q.setVisibility(8);
                    }
                }
            });
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65705, this) == null) {
            FH.cancelFaceProcess();
            this.aK.v = 17;
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.sapi_liveness_dialog_recognized_timeout_title));
            this.Q.setResultPageNextTitle(getString(R.string.sapi_liveness_dialog_recognized_timeout_next_title));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.s();
                        this.a.q();
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.aG = livenessRecogActivity.c();
                        this.a.aL.k = false;
                        this.a.aL.l = false;
                        this.a.aK.D = System.currentTimeMillis();
                        this.a.Q.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65707, this) == null) {
            FH.cancelFaceProcess();
            this.aK.v = 17;
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.sapi_liveness_dialog_recognized_device_title));
            this.Q.setResultPageNextTitle(getString(R.string.sapi_liveness_dialog_recognized_failed_next_title));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.s();
                        this.a.q();
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.aG = livenessRecogActivity.c();
                        this.a.aL.k = false;
                        this.a.aL.l = false;
                        this.a.aK.D = System.currentTimeMillis();
                        this.a.Q.setVisibility(8);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65659, this) == null) {
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            this.aN = livenessRecogDTO.soundSwitch;
            this.aQ = livenessRecogDTO.randomLiveness;
            this.bk = livenessRecogDTO.switchVideo;
            this.aO = livenessRecogDTO.recordLiveness && Build.VERSION.SDK_INT >= 18;
            this.aF = getResources().getStringArray(R.array.sapi_liveness_head_pose);
            this.aJ = new Handler(Looper.getMainLooper(), this);
            c cVar = new c(this);
            this.aK = cVar;
            cVar.v = -1;
            this.aL = new a(this);
            this.aK.D = System.currentTimeMillis();
            com.baidu.fsg.face.liveness.b bVar = new com.baidu.fsg.face.liveness.b(this.livenessRecogDTO);
            this.br = bVar;
            bVar.a = System.currentTimeMillis();
            e();
            this.aG = c();
            if (this.bk) {
                return;
            }
            g();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65663, this) == null) {
            GetFPResponse.LivenessConfig a2 = com.baidu.fsg.face.liveness.beans.c.a().a(getActivity());
            this.bj = a2;
            if (a2 == null) {
                this.bj = new GetFPResponse.LivenessConfig();
            }
            this.bh = this.bj.getRecogtimeInterval();
            if (this.aQ) {
                this.bi = new Random().nextInt(100) % 2 == 0 ? 1L : 2L;
            } else {
                this.bi = this.bj.getRecogActionType();
            }
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO == null || livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_FACEDETECT) {
                return;
            }
            f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65665, this) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65649, this)) == null) {
            if (this.bi == 1) {
                this.aG = 0;
            } else {
                this.aG = 5;
            }
            return this.aG;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65647, this, uploadContrastPortraitModel) == null) || this.D == null || uploadContrastPortraitModel == null) {
            return;
        }
        new AsyncTask<Void, Void, LivenessRecogResult>(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.34
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UploadContrastPortraitModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LivenessRecogActivity f34150b;

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
                this.f34150b = this;
                this.a = uploadContrastPortraitModel;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public LivenessRecogResult doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    if (this.a.isProcessPass()) {
                        livenessRecogResult.setResultCode(0);
                    } else {
                        livenessRecogResult.setResultCode(-302);
                    }
                    UploadContrastPortraitModel uploadContrastPortraitModel2 = this.a;
                    livenessRecogResult.callbackkey = uploadContrastPortraitModel2.callbackkey;
                    livenessRecogResult.authSid = uploadContrastPortraitModel2.authsid;
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
                    if (this.a.isProcessPass()) {
                        this.f34150b.D.a(livenessRecogResult);
                    } else {
                        this.f34150b.D.b(livenessRecogResult);
                    }
                    this.f34150b.Q();
                }
            }
        }.execute(new Void[0]);
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65648, this, str) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        arrayList.add(str);
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.x, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65655, this, uploadContrastPortraitModel) == null) {
            UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
            this.Q.resetView();
            this.Q.setResultPageTitle(confirmBean.title_tips);
            this.Q.setResultPageRiskTipVisiable(confirmBean.tip_msg);
            this.Q.setResultPageConfirmText(confirmBean.confirm_msg);
            this.Q.setResultPageCancelText(confirmBean.cancel_msg);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
            this.Q.setVisibility(0);
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadContrastPortraitModel a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessRecogActivity f34154b;

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
                    this.f34154b = this;
                    this.a = uploadContrastPortraitModel;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || System.currentTimeMillis() - this.f34154b.bG < 500) {
                        return;
                    }
                    this.f34154b.bG = System.currentTimeMillis();
                    if (this.f34154b.livenessRecogDTO != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f34154b.livenessRecogDTO.getSpno() + "");
                        arrayList.add(TextUtils.isEmpty(this.f34154b.livenessRecogDTO.processid) ? "" : this.f34154b.livenessRecogDTO.processid);
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.C, arrayList);
                    }
                    this.f34154b.bz = 1;
                    this.f34154b.bA = 1;
                    this.f34154b.bF = this.a;
                    this.f34154b.ak.setVisibility(0);
                    this.f34154b.al.setVisibility(0);
                    this.f34154b.am.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f34154b.al.startAnimation(rotateAnimation);
                    this.f34154b.Q.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f34154b.getActivity(), 13, LivenessRecogActivity.f34136d);
                    LivenessRecogDTO livenessRecogDTO = this.f34154b.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f34154b.bA);
                    dVar.a(this.f34154b.bz);
                    dVar.setResponseCallback(this.f34154b);
                    dVar.execBean();
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || System.currentTimeMillis() - this.f34154b.bG < 500) {
                        return;
                    }
                    this.f34154b.bG = System.currentTimeMillis();
                    if (this.f34154b.livenessRecogDTO != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f34154b.livenessRecogDTO.getSpno() + "");
                        arrayList.add(TextUtils.isEmpty(this.f34154b.livenessRecogDTO.processid) ? "" : this.f34154b.livenessRecogDTO.processid);
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.D, arrayList);
                    }
                    this.f34154b.bz = 2;
                    this.f34154b.bA = 1;
                    this.f34154b.bF = this.a;
                    this.f34154b.ak.setVisibility(0);
                    this.f34154b.al.setVisibility(0);
                    this.f34154b.am.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.f34154b.al.startAnimation(rotateAnimation);
                    this.f34154b.Q.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.f34154b.getActivity(), 13, LivenessRecogActivity.f34136d);
                    LivenessRecogDTO livenessRecogDTO = this.f34154b.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.f34154b.bA);
                    dVar.a(this.f34154b.bz);
                    dVar.setResponseCallback(this.f34154b);
                    dVar.execBean();
                }
            });
        }
    }

    private void a(UploadContrastPortraitModel uploadContrastPortraitModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, this, uploadContrastPortraitModel) == null) {
            this.al.clearAnimation();
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
            this.am.setVisibility(8);
            this.aj.setMaskVisiable(true);
            this.aq.loadSuccess();
            this.aq.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 11) {
                this.aj.updateXfordViewProgress(0.75f, 1.0f, 1000L, new AnimatorListenerAdapter(this, uploadContrastPortraitModel) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.23
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UploadContrastPortraitModel a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f34145b;

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
                        this.f34145b = this;
                        this.a = uploadContrastPortraitModel;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            this.f34145b.aj.setMaskVisiable(false);
                            this.f34145b.aq.setVisibility(4);
                            super.onAnimationEnd(animator);
                            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                            if (this.a.isGotoDXMRecordvideo() || this.f34145b.aZ == 2) {
                                this.f34145b.x();
                            } else if (this.a.isProcessPass()) {
                                if (this.f34145b.br != null) {
                                    this.f34145b.br.a(com.baidu.fsg.face.liveness.d.f34342f);
                                }
                                UploadContrastPortraitModel uploadContrastPortraitModel2 = this.a;
                                if (uploadContrastPortraitModel2.need_confirm == null) {
                                    this.f34145b.b(uploadContrastPortraitModel2);
                                    return;
                                }
                                this.f34145b.c(uploadContrastPortraitModel2);
                                this.f34145b.aA.setVisibility(8);
                                if (this.f34145b.livenessRecogDTO != null) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(this.f34145b.livenessRecogDTO.getSpno() + "");
                                    arrayList.add(TextUtils.isEmpty(this.f34145b.livenessRecogDTO.processid) ? "" : this.f34145b.livenessRecogDTO.processid);
                                    RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.B, arrayList);
                                }
                            } else if (this.f34145b.aZ != 1) {
                                this.f34145b.b(this.a);
                            } else if (this.a.isGotoRecordvideo()) {
                                this.f34145b.x();
                            } else {
                                this.f34145b.b(this.a);
                            }
                        }
                    }
                });
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65643, this) == null) {
            f.b(this, getResources().getColor(17170445));
            setBrightness(this, 255);
            ImageView imageView = (ImageView) findViewById(R.id.btn_cancel);
            this.E = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.40
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.al.getVisibility() == 0) {
                        return;
                    }
                    if (this.a.aK.y) {
                        this.a.C();
                    } else if (this.a.aK.v < 9) {
                        this.a.A();
                    } else {
                        this.a.B();
                    }
                }
            });
            ImageView imageView2 = (ImageView) findViewById(R.id.btn_switch_voice);
            this.F = imageView2;
            if (this.aN) {
                imageView2.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
            } else {
                imageView2.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
            }
            this.F.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.41
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LivenessRecogActivity livenessRecogActivity = this.a;
                        livenessRecogActivity.aN = !livenessRecogActivity.aN;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.a.aN ? "1" : "0");
                        LivenessRecogDTO livenessRecogDTO = this.a.livenessRecogDTO;
                        arrayList.add(livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.f34340d, arrayList);
                        if (this.a.aN) {
                            this.a.F.setImageResource(R.drawable.sapi_liveness_switch_sound_open);
                        } else {
                            this.a.F.setImageResource(R.drawable.sapi_liveness_switch_sound_close);
                        }
                    }
                }
            });
            this.H = (FrameLayout) findViewById(R.id.layout_pose_tip);
            this.I = (TextView) findViewById(R.id.tv_pose_tip);
            this.J = (RelativeLayout) findViewById(R.id.layout_question_tip);
            this.K = (TextView) findViewById(R.id.tv_question_tip);
            this.L = (TextView) findViewById(R.id.tv_question_next_tip);
            this.M = (TextView) findViewById(R.id.tv_record_video_retry);
            this.N = (LinearLayout) findViewById(R.id.layout_pose_warning);
            this.O = (ImageView) findViewById(R.id.iv_pose_warning_tip);
            this.P = (TextView) findViewById(R.id.tv_pose_warning_tip);
            this.Q = (RimFaceResultPageTipView) findViewById(R.id.constrastLoadingTipsView);
            this.G = (ImageView) findViewById(R.id.img_face_recognizing_light_anim);
            L();
            SurfaceView surfaceView = new SurfaceView(this);
            this.X = surfaceView;
            this.bH = surfaceView.getHolder();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            this.X.setLayoutParams(layoutParams);
            this.bc.addView(this.X, 0, layoutParams);
            this.X.setVisibility(4);
            this.aj = (LivenessXfordView) this.bc.findViewById(R.id.xfordview);
            this.aA = (TextView) findViewById(R.id.tv_msg_tips);
            this.R = (RelativeLayout) findViewById(R.id.ll_video_tip);
            this.S = (ImageView) findViewById(R.id.iv_video_count_down);
            this.T = (TextView) findViewById(R.id.tv_video_tip);
            this.U = (LinearLayout) findViewById(R.id.ll_time_count);
            this.V = (ImageView) findViewById(R.id.iv_time_count_point);
            this.W = (TextView) findViewById(R.id.tv_time_count);
            this.al = (ImageView) findViewById(R.id.iv_recog_circle);
            this.ak = (ImageView) findViewById(R.id.iv_recog_logo);
            this.am = (RelativeLayout) findViewById(R.id.layout_background);
            this.an = (TextView) findViewById(R.id.tv_show_progress);
            this.ap = (CustomProgressBar) findViewById(R.id.custom_progress);
            this.ao = (LinearLayout) findViewById(R.id.layout_show_progress);
            this.aq = (RimSuccessView) findViewById(R.id.custom_success_view);
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65656, this, str) == null) {
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_error);
            this.Q.setResultPageTitle(getString(R.string.error_msg_server_error));
            this.Q.setResultPageConfirmText(getString(R.string.sapi_liveness_dialog_recognized_timeout_retry));
            this.Q.setResultPageCancelText(getString(R.string.sapi_liveness_dialog_recognized_timeout_exit));
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.getRecordVideoQuestions();
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.Q.setVisibility(8);
                        this.a.a();
                        this.a.Q();
                    }
                }
            });
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65660, this, str) == null) || isFinishing()) {
            return;
        }
        LoadingDialog loadingDialog = new LoadingDialog(this);
        this.Z = loadingDialog;
        loadingDialog.setMessage(str);
        this.Z.show();
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65607, this, str, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.q, i2, arrayList);
        a(str);
    }

    private void c(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65654, this, i2, str) == null) {
            this.N.setVisibility(0);
            if (this.C != i2) {
                this.P.setText(str);
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_warning);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this, loadAnimation) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.32
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Animation a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f34148b;

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
                        this.f34148b = this;
                        this.a = loadAnimation;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            this.f34148b.O.startAnimation(this.a);
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
                if (!this.aL.f34163j) {
                    this.O.startAnimation(loadAnimation);
                    this.aL.f34163j = true;
                }
            }
            this.C = i2;
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65595, this, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(com.baidu.fsg.face.liveness.d.H, i2, arrayList);
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, this, str) == null) {
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

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65598, this, i2, str) == null) {
            if (this.bt == this.bs) {
                BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
                if (this.D != null) {
                    LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                    livenessRecogResult.setResultCode(i2);
                    livenessRecogResult.setResultMsg(str);
                    this.D.b(livenessRecogResult);
                    Q();
                    return;
                }
                return;
            }
            V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65645, this, i2, str) == null) {
            if (i2 == 0) {
                this.I.setText(R.string.sapi_liveness_put_face_in_round);
            } else if (i2 == 1) {
                String[] strArr = this.aF;
                if (strArr == null || (i5 = this.aG) >= strArr.length) {
                    return;
                }
                this.I.setText(strArr[i5]);
            } else if (i2 == 2) {
                String[] strArr2 = this.aF;
                if (strArr2 == null || (i4 = this.aG) >= strArr2.length) {
                    return;
                }
                this.I.setText(strArr2[i4]);
            } else if (i2 == 3) {
                String[] strArr3 = this.aF;
                if (strArr3 == null || (i3 = this.aG) >= strArr3.length) {
                    return;
                }
                this.I.setText(strArr3[i3]);
            } else if (i2 == 4) {
                this.I.setText(str);
            } else if (i2 == 5) {
                this.I.setText(str);
            }
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65599, this, view) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65644, this, i2) == null) {
            try {
                if (this.aC == null || (!this.aC.isPlaying() && i2 < d.f34181j.length)) {
                    MediaPlayer create = MediaPlayer.create(this, d.f34181j[i2]);
                    this.aC = create;
                    if (create == null) {
                        return;
                    }
                    create.setOnErrorListener(new b());
                    setVolumeControlStream(3);
                    if (!this.aN) {
                        this.aC.setVolume(0.0f, 0.0f);
                    }
                    this.aC.start();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.n, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
            LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
            if (this.D != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                livenessRecogResult.setResultCode(-204);
                this.D.b(livenessRecogResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceStatusNewEnum faceStatusNewEnum, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65605, this, faceStatusNewEnum, str, i2) == null) {
            LogUtil.d("hello", "status:" + faceStatusNewEnum.toString() + ",message:" + str);
            switch (AnonymousClass39.a[faceStatusNewEnum.ordinal()]) {
                case 3:
                    c(faceStatusNewEnum.ordinal(), "请将脸部离远一点");
                    return;
                case 4:
                    c(faceStatusNewEnum.ordinal(), "请将脸部靠近一点");
                    return;
                case 5:
                    c(faceStatusNewEnum.ordinal(), "把脸移入框内");
                    return;
                case 6:
                    c(faceStatusNewEnum.ordinal(), "把脸移入框内");
                    return;
                case 7:
                    c(faceStatusNewEnum.ordinal(), "请使环境光线再亮些");
                    return;
                case 8:
                    this.C = faceStatusNewEnum.ordinal();
                    this.N.setVisibility(4);
                    c cVar = this.aK;
                    if (cVar.v != 6) {
                        this.aG = 0;
                        cVar.v = 6;
                        a(1, 1, (String) null);
                        return;
                    }
                    return;
                case 9:
                    this.C = faceStatusNewEnum.ordinal();
                    this.N.setVisibility(4);
                    c cVar2 = this.aK;
                    if (cVar2.v != 8) {
                        this.aG = 5;
                        cVar2.v = 8;
                        a(1, 3, (String) null);
                        return;
                    }
                    return;
                case 10:
                    c(faceStatusNewEnum.ordinal(), "缓慢抬头");
                    return;
                case 11:
                    c(faceStatusNewEnum.ordinal(), "缓慢低头");
                    return;
                case 12:
                    c(faceStatusNewEnum.ordinal(), "向左缓慢转头");
                    return;
                case 13:
                    c(faceStatusNewEnum.ordinal(), "向右缓慢转头");
                    return;
                case 14:
                    c(faceStatusNewEnum.ordinal(), "请略微低头");
                    return;
                case 15:
                    c(faceStatusNewEnum.ordinal(), "请略微抬头");
                    return;
                case 16:
                    c(faceStatusNewEnum.ordinal(), "请略微向右转头");
                    return;
                case 17:
                    c(faceStatusNewEnum.ordinal(), "请略微向左转头");
                    return;
                case 18:
                    y();
                    return;
                default:
                    return;
            }
        }
    }

    private void a(UploadVideoModel uploadVideoModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, this, uploadVideoModel) == null) {
            this.Q.resetView();
            this.Q.setVisibility(0);
            this.Q.setResultPageImg(R.drawable.rim_face_liveness_result_ok);
            this.Q.setResultPageTitle(uploadVideoModel.getConfirmBean().title_tips);
            this.Q.setResultPageRiskTipVisiable(uploadVideoModel.getConfirmBean().tip_msg);
            this.Q.setResultPageConfirmText(uploadVideoModel.getConfirmBean().confirm_msg);
            this.Q.setResultPageCancelText(uploadVideoModel.getConfirmBean().cancel_msg);
            this.Q.setOnClickListener(new RimFaceResultPageTipView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessRecogActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || System.currentTimeMillis() - this.a.bG < 500) {
                        return;
                    }
                    this.a.bG = System.currentTimeMillis();
                    this.a.bz = 1;
                    this.a.bA = 2;
                    this.a.ak.setVisibility(0);
                    this.a.al.setVisibility(0);
                    this.a.am.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.a.al.startAnimation(rotateAnimation);
                    this.a.ao.setVisibility(8);
                    this.a.Q.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.a.getActivity(), 13, LivenessRecogActivity.f34136d);
                    LivenessRecogDTO livenessRecogDTO = this.a.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.a.bA);
                    dVar.a(this.a.bz);
                    dVar.setResponseCallback(this.a);
                    dVar.execBean();
                }

                @Override // com.baidu.fsg.face.liveness.view.RimFaceResultPageTipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || System.currentTimeMillis() - this.a.bG < 500) {
                        return;
                    }
                    this.a.bG = System.currentTimeMillis();
                    this.a.bz = 2;
                    this.a.bA = 2;
                    this.a.ak.setVisibility(0);
                    this.a.al.setVisibility(0);
                    this.a.am.setVisibility(0);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setRepeatCount(-1);
                    rotateAnimation.setRepeatMode(1);
                    rotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
                    rotateAnimation.setInterpolator(linearInterpolator);
                    this.a.al.startAnimation(rotateAnimation);
                    this.a.ao.setVisibility(8);
                    this.a.Q.setVisibility(8);
                    com.baidu.fsg.face.liveness.beans.d dVar = (com.baidu.fsg.face.liveness.beans.d) FaceSDKBeansFactory.getInstance().getBean(this.a.getActivity(), 13, LivenessRecogActivity.f34136d);
                    LivenessRecogDTO livenessRecogDTO = this.a.livenessRecogDTO;
                    if (livenessRecogDTO != null) {
                        dVar.a(livenessRecogDTO);
                    }
                    dVar.b(this.a.bA);
                    dVar.a(this.a.bz);
                    dVar.setResponseCallback(this.a);
                    dVar.execBean();
                }
            });
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65596, this, i2, i3) == null) {
            String string = i2 != 1 ? getString(R.string.sapi_permission_audio) : null;
            if (i3 != 1) {
                string = getString(R.string.sapi_permission_camera);
            }
            if (i2 != 1 && i3 != 1) {
                string = getString(R.string.sapi_permission_audio_camera);
            }
            String format = String.format(getString(R.string.sapi_permission_without_title), string);
            String str = String.format(getString(R.string.sapi_permission_without_msg1), string) + String.format(getString(R.string.sapi_permission_without_msg2), string);
            if (this.ac == null) {
                BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
                this.ac = bioAlertDialog;
                bioAlertDialog.setTitleMsg(format);
                this.ac.setTitleVisible(true);
                this.ac.setDialogMsg(str);
                this.ac.setBtnCount(1);
                this.ac.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.29
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessRecogActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.ac.dismiss();
                            if (this.a.D != null) {
                                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                                this.a.D.b(livenessRecogResult);
                            }
                            this.a.Q();
                        }
                    }
                });
            }
            this.ac.setCancelable(false);
            if (isFinishing() || this.ac.isShowing()) {
                return;
            }
            this.ac.show();
        }
    }

    private void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65597, this, i2, i3, str) == null) {
            this.H.clearAnimation();
            b(i3, str);
            if (i2 == 1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_tip_slide_midd_to_top);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this, i3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogActivity.31
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LivenessRecogActivity f34147b;

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
                        this.f34147b = this;
                        this.a = i3;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    @RequiresApi(api = 16)
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            int i4 = this.a;
                            if (i4 == 0) {
                                this.f34147b.b(2);
                            } else if (i4 == 1) {
                                this.f34147b.b(0);
                            } else if (i4 == 3) {
                                this.f34147b.b(8);
                            }
                            this.f34147b.I.setTextColor(-16777216);
                            this.f34147b.I.setTextSize(25.0f);
                            this.f34147b.H.setBackground(null);
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
                            this.f34147b.I.setTextSize(15.0f);
                            this.f34147b.I.setTextColor(-1);
                            this.f34147b.H.setBackgroundResource(R.drawable.rim_face_liveness_toast_round);
                        }
                    }
                });
                this.H.startAnimation(loadAnimation);
                this.I.setVisibility(0);
            }
        }
    }
}
