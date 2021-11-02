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
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.R;
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
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.c.b;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.enums.HeadPose;
import com.baidu.pass.biometrics.face.liveness.enums.ProgressStatus;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.FaceVerifyInfo;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.webkit.sdk.PermissionRequest;
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
/* loaded from: classes7.dex */
public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard, FaceProcessCallback, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String J = "PassLivenessRecogActivity";
    public static final int K = 2002;
    public static final int L = 7126;
    public static final int M = 7127;
    public static final int N = 255;
    public static final int O = 30000;
    public static final int P = 112;
    public static final float Q = 0.6f;
    public static final int R = 40;
    public static final int S = 220;
    public static final float T = 0.8f;
    public static final int U = 20;
    public static final int V = 200;
    public static final float W = 0.6f;
    public static final float X = 0.7f;
    public static final int Y = 3;
    public static final float Z = 1.0f;
    public static final float a0 = 0.3f;
    public static final boolean b0 = false;
    public static final boolean c0 = false;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public Timer C;
    public TimerTask D;
    public ProgressStatus E;
    public com.baidu.pass.biometrics.face.liveness.b.a F;
    public LivenessTypeEnum G;
    public long H;
    public PassFaceRecogCallback I;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f41817e;

    /* renamed from: f  reason: collision with root package name */
    public CircleProgressView f41818f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41819g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f41820h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f41821i;
    public TextView j;
    public CameraSurfaceView k;
    public CircleImageView l;
    public CircleImageView m;
    public LinearLayout n;
    public com.baidu.pass.biometrics.face.liveness.d.a o;
    public SdkConfigOptions.LivenessConfigOption p;
    public int q;
    public List<LivenessTypeEnum> r;
    public com.baidu.pass.biometrics.face.liveness.c.b s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f41822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41823b;

        public a(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41823b = passLivenessRecogActivity;
            this.f41822a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41822a.dismiss();
                this.f41823b.t();
                this.f41823b.F.A = 1;
                this.f41823b.setActivityResult(0);
                this.f41823b.a(-204);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f41824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41825b;

        public b(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41825b = passLivenessRecogActivity;
            this.f41824a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41824a.dismiss();
                this.f41825b.F.D = 1;
                this.f41825b.setActivityResult(-1);
                if (this.f41825b.I != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-301);
                    this.f41825b.I.onFailure(passFaceRecogResult);
                }
                this.f41825b.a(-301);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PixelCopy.OnPixelCopyFinishedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PixelCopyCallback f41826a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f41827b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41828c;

        public c(PassLivenessRecogActivity passLivenessRecogActivity, PixelCopyCallback pixelCopyCallback, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, pixelCopyCallback, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41828c = passLivenessRecogActivity;
            this.f41826a = pixelCopyCallback;
            this.f41827b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                this.f41826a.onFinsh(this.f41827b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41829a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PassLivenessRecogActivity passLivenessRecogActivity, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41829a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f41829a.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f41829a.b(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41830a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PassLivenessRecogActivity passLivenessRecogActivity, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41830a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f41830a.h();
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f41830a.a(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41831a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f41832b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1264232248, "Lcom/baidu/pass/biometrics/face/liveness/activity/PassLivenessRecogActivity$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1264232248, "Lcom/baidu/pass/biometrics/face/liveness/activity/PassLivenessRecogActivity$f;");
                    return;
                }
            }
            int[] iArr = new int[ProgressStatus.values().length];
            f41832b = iArr;
            try {
                iArr[ProgressStatus.GO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41832b[ProgressStatus.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            f41831a = iArr2;
            try {
                iArr2[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodePoorIllumination.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLiveEye.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYaw.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f41831a[FaceStatusNewEnum.FaceLivenessActionComplete.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f41831a[FaceStatusNewEnum.DetectRemindCodeTimeout.ordinal()] = 19;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements b.InterfaceC1647b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41833a;

        public g(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41833a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.c.b.InterfaceC1647b
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.f41833a.b(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements CircleProgressView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41834a;

        public h(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41834a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView.b
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (f2 == 100.0f) {
                    this.f41834a.f41818f.setShowTick(false);
                } else {
                    this.f41834a.f41818f.setShowTick(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f41835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41836b;

        public i(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41836b = passLivenessRecogActivity;
            this.f41835a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewUtility.dismissDialog(this.f41836b, this.f41835a);
                this.f41836b.z = true;
                this.f41836b.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f41837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41838b;

        public j(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41838b = passLivenessRecogActivity;
            this.f41837a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewUtility.dismissDialog(this.f41838b, this.f41837a);
                if (this.f41838b.I != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-307);
                    this.f41838b.I.onFailure(passFaceRecogResult);
                }
                this.f41838b.a(-307);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41839a;

        public k(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41839a = passLivenessRecogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41839a.o.dismiss();
                this.f41839a.z = false;
                if (this.f41839a.I != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-307);
                    this.f41839a.I.onFailure(passFaceRecogResult);
                }
                this.f41839a.a(-307);
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(268435456);
                intent.setData(Uri.fromParts("package", this.f41839a.getPackageName(), null));
                if (intent.resolveActivity(this.f41839a.getPackageManager()) != null) {
                    this.f41839a.startActivity(intent);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41840a;

        public l(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41840a = passLivenessRecogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41840a.o.dismiss();
                this.f41840a.z = false;
                if (this.f41840a.I != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-307);
                    this.f41840a.I.onFailure(passFaceRecogResult);
                }
                this.f41840a.a(-307);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements PixelCopyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41841a;

        public m(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41841a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback
        public void onFinsh(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.f41841a.l.setImageBitmap(com.baidu.pass.biometrics.face.liveness.c.c.a(this.f41841a, bitmap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f41842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41843b;

        public n(PassLivenessRecogActivity passLivenessRecogActivity, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41843b = passLivenessRecogActivity;
            this.f41842a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f41843b.f41821i.startAnimation(this.f41842a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f41844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassLivenessRecogActivity f41845b;

        public o(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41845b = passLivenessRecogActivity;
            this.f41844a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41845b.F.a();
                this.f41845b.F.B = 1;
                this.f41845b.onResume();
                this.f41844a.dismiss();
            }
        }
    }

    public PassLivenessRecogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = true;
        this.x = true;
        this.C = new Timer(true);
    }

    private void i() {
        CameraSurfaceView cameraSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (cameraSurfaceView = this.k) == null || cameraSurfaceView.getHolder() == null || this.y) {
            return;
        }
        SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.p;
        if (livenessConfigOption != null && livenessConfigOption.mCloseFace) {
            this.x = false;
            e("当前刷脸功能正在升级中...");
            return;
        }
        FH.startFaceVerify(this, this.k.getHolder(), this, 0, new FaceVerifyInfo(StringUtil.NULL_STRING, StringUtil.NULL_STRING, 0, null, null, null, null, StringUtil.NULL_STRING), true);
        this.y = true;
    }

    @TargetApi(23)
    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
                if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
                    this.z = true;
                    requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                    return;
                } else if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                    com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
                    bVar.c(getString(R.string.pass_bio_pmn_ok), new i(this, bVar));
                    bVar.a(getString(R.string.pass_bio_pmn_cancel), new j(this, bVar));
                    bVar.b(String.format(getString(R.string.pass_bio_pmn_title_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                    bVar.a(String.format(getString(R.string.pass_bio_pmn_msg_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                    bVar.show();
                    return;
                } else {
                    this.z = true;
                    requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                    return;
                }
            }
            this.F.F = System.currentTimeMillis();
            i();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.f41820h.setVisibility(4);
            this.f41819g.setVisibility(0);
            this.f41819g.setText(R.string.pass_liveness_frist_text);
            this.G = null;
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
            this.f41818f = (CircleProgressView) findViewById(R.id.pass_bio_liveness_recog_cpv);
            this.f41819g = (TextView) findViewById(R.id.pass_bio_liveness_recog_tip_text);
            this.f41818f.setNormalColor(Color.parseColor("#FFE0E0E0"));
            this.f41818f.setOnChangeListener(new h(this));
            this.f41820h = (FrameLayout) findViewById(R.id.layout_pose_warning);
            this.f41821i = (ImageView) findViewById(R.id.iv_pose_warning_tip);
            this.j = (TextView) findViewById(R.id.tv_pose_warning_tip);
            this.k = (CameraSurfaceView) findViewById(R.id.pass_bio_camera_pre_view);
            this.l = (CircleImageView) findViewById(R.id.pass_bio_circle_image_view);
            this.m = (CircleImageView) findViewById(R.id.pass_bio_circle_hide_view);
            this.n = (LinearLayout) findViewById(R.id.pass_bio_loading_view);
            setBrightness(this, 255);
            ((ImageView) findViewById(R.id.pass_bio_liveness_recog_close)).setOnClickListener(this);
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.F.C = 1;
            com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
            aVar.b(getString(R.string.pass_liveness_recog_fail_dialog_title));
            aVar.c(getString(R.string.pass_liveness_recog_fail_dialog_msg));
            aVar.a(1);
            aVar.b(getString(R.string.pass_bio_alert_dialog_btn_back), new b(this, aVar));
            aVar.setCancelable(false);
            if (isFinishing() || aVar.isShowing()) {
                return;
            }
            aVar.show();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            CircleProgressView circleProgressView = this.f41818f;
            if (circleProgressView != null) {
                circleProgressView.setVisibility(8);
            }
            showLoadingView();
            this.u = true;
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            this.z = true;
            if (this.o == null) {
                com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
                this.o = aVar;
                aVar.b(getString(R.string.pass_bio_permission_request));
                this.o.b(true);
                this.o.c(getString(R.string.pass_liveness_permission_camera));
                this.o.c(getString(R.string.pass_bio_alert_dialog_btn_go_setting), new k(this));
                this.o.a(getString(R.string.pass_bio_alert_dialog_btn_cancel), new l(this));
            }
            this.o.setCancelable(false);
            if (isFinishing() || this.o.isShowing()) {
                return;
            }
            this.o.show();
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.l.c();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            k();
            onPause();
            if (this.w) {
                r();
                this.w = false;
                return;
            }
            m();
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            this.F.z = 1;
            com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
            aVar.b(getString(R.string.pass_face_timeout_dialog_title));
            aVar.c(0);
            aVar.a(getString(R.string.pass_face_timeout_dialog_msg));
            aVar.c(getString(R.string.pass_bio_alert_dialog_btn_again), new o(this, aVar));
            aVar.a(getString(R.string.pass_bio_cancel), new a(this, aVar));
            aVar.setCancelable(false);
            if (isFinishing() || aVar.isShowing()) {
                return;
            }
            aVar.show();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            this.f41820h.setVisibility(8);
            this.f41820h.clearAnimation();
            this.t = false;
        }
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65585, null, activity, i2) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = i2 * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65586, this) == null) || this.I == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
        passFaceRecogResult.setResultCode(-204);
        this.I.onFailure(passFaceRecogResult);
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void animStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void backBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t();
            a();
            setActivityResult(0);
            a(-204);
        }
    }

    public void getBitmapFromSurfaceView(SurfaceView surfaceView, PixelCopyCallback pixelCopyCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, surfaceView, pixelCopyCallback) == null) || surfaceView == null) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 24) {
            PixelCopy.request(surfaceView, createBitmap, new c(this, pixelCopyCallback, createBitmap), surfaceView.getHandler());
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.setVisibility(0);
            this.l.setBackgroundColor(-1);
            this.f41819g.setText(R.string.pass_liveness_frist_text);
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onBeginBuildData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onBeginCollectFaceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
            if (aVar.J == 0) {
                aVar.J = System.currentTimeMillis();
            }
            this.H = System.currentTimeMillis();
            this.k.setVisibility(0);
            this.B = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && view.getId() == R.id.pass_bio_liveness_recog_close) {
            t();
            a();
            setActivityResult(0);
            a(-204);
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i2)}) == null) {
            String str2 = "faceStatusNewEnum " + faceStatusNewEnum + ",message = " + str;
            this.F.I++;
            if (this.y) {
                if (this.B) {
                    p();
                    this.B = false;
                }
                switch (f.f41831a[faceStatusNewEnum.ordinal()]) {
                    case 1:
                        s();
                        if (Build.VERSION.SDK_INT >= 24) {
                            getBitmapFromSurfaceView(this.k, new m(this));
                            break;
                        }
                        break;
                    case 2:
                        this.F.u++;
                        c(str);
                        break;
                    case 3:
                        this.F.v++;
                        c(str);
                        break;
                    case 4:
                        this.F.y++;
                        c(str);
                        break;
                    case 5:
                        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
                        aVar.f41852g = 0;
                        aVar.J = System.currentTimeMillis();
                        this.F.x++;
                        c(str);
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        this.F.w++;
                        c(str);
                        break;
                    case 11:
                        this.G = LivenessTypeEnum.Eye;
                        this.F.L = System.currentTimeMillis();
                        d(str);
                        break;
                    case 12:
                        this.G = LivenessTypeEnum.Mouth;
                        this.F.N = System.currentTimeMillis();
                        d(str);
                        break;
                    case 13:
                        this.G = LivenessTypeEnum.HeadUp;
                        d(str);
                        break;
                    case 14:
                        this.G = LivenessTypeEnum.HeadDown;
                        d(str);
                        break;
                    case 15:
                        this.G = LivenessTypeEnum.HeadLeft;
                        d(str);
                        break;
                    case 16:
                        this.G = LivenessTypeEnum.HeadRight;
                        d(str);
                        break;
                    case 17:
                        d(str);
                        break;
                    case 18:
                        LivenessTypeEnum livenessTypeEnum = this.G;
                        if (livenessTypeEnum == LivenessTypeEnum.Eye) {
                            com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.F;
                            aVar2.p = com.baidu.pass.biometrics.face.liveness.b.a.a0;
                            aVar2.f41854i++;
                            aVar2.M = System.currentTimeMillis();
                            this.F.k = com.baidu.pass.biometrics.face.liveness.b.a.a0;
                            break;
                        } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
                            com.baidu.pass.biometrics.face.liveness.b.a aVar3 = this.F;
                            aVar3.p = com.baidu.pass.biometrics.face.liveness.b.a.b0;
                            aVar3.j++;
                            aVar3.O = System.currentTimeMillis();
                            this.F.k = com.baidu.pass.biometrics.face.liveness.b.a.b0;
                            break;
                        }
                        break;
                    case 19:
                        q();
                        break;
                }
                this.F.J = System.currentTimeMillis();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onConfigCamera(Camera camera, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, camera, rect, rect2) == null) || this.k == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        CameraSurfaceView.a a2 = this.k.a(parameters);
        String str = "cameraSize = " + a2;
        parameters.setPreviewSize(a2.f41910a, a2.f41911b);
        camera.setParameters(parameters);
        parameters.setJpegQuality(50);
        camera.setParameters(parameters);
        if (!this.A) {
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = (int) (a2.f41910a * (layoutParams.width / a2.f41911b));
            this.k.setLayoutParams(layoutParams);
            this.A = true;
        }
        rect.set(0, 0, a2.f41911b, a2.f41910a);
        int i2 = a2.f41911b;
        rect2.set(0, 0, i2, i2);
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            requestWindowFeature(1);
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            getWindow().addFlags(128);
            super.onCreate(bundle);
            setRequestedOrientation(1);
            setContentView(R.layout.layout_pass_liveness_recognize_new);
            e();
            g();
            l();
            this.s.a(new g(this));
            j();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            com.baidu.pass.biometrics.face.liveness.c.b bVar = this.s;
            if (bVar != null) {
                bVar.b();
            }
            TimerTask timerTask = this.D;
            if (timerTask != null) {
                timerTask.cancel();
                this.C.purge();
                this.D = null;
                this.C = null;
            }
            ViewGroup viewGroup = this.f41817e;
            if (viewGroup != null) {
                a(viewGroup);
                this.f41817e.removeCallbacks(null);
                this.f41817e = null;
            }
            try {
                System.gc();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onDeviceCheckResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onEnd(int i2, RequestInfo requestInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, requestInfo) == null) {
            String str = "onEnd() i = " + i2 + ",requestInfo = ";
            this.F.H += System.currentTimeMillis() - this.H;
            this.f41819g.setVisibility(4);
            if (this.I == null) {
                return;
            }
            if (i2 != -18) {
                if (i2 == 1) {
                    a(requestInfo);
                    return;
                } else if (i2 != -5 && i2 != -4 && i2 != -3 && i2 != -2) {
                    switch (i2) {
                        case -15:
                            PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
                            if (passBiometricConfiguration != null) {
                                FH.init(this, passBiometricConfiguration.sofireAppKey, passBiometricConfiguration.sofireSecKey, passBiometricConfiguration.sofireHostID);
                            }
                            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                            passFaceRecogResult.setResultCode(i2);
                            this.I.onFailure(passFaceRecogResult);
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
            }
            PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
            passFaceRecogResult2.setResultCode(i2);
            this.I.onFailure(passFaceRecogResult2);
            a(i2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, keyEvent)) == null) {
            a();
            if (i2 == 4) {
                t();
                a();
                setActivityResult(0);
                a(-204);
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            if (this.z) {
                return;
            }
            b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.z = false;
            if (i2 == 2002) {
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.F.F = System.currentTimeMillis();
                    com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
                    aVar.f41849d = 1;
                    aVar.f41850e = 1;
                    i();
                    return;
                }
                o();
            }
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.u || this.z) {
                return;
            }
            i();
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void onTestFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bitmap) == null) {
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, livenessTypeEnum) == null) {
        }
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void setFaceInfo(FaceExtInfo faceExtInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, faceExtInfo) == null) {
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.k == null) {
            return;
        }
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    @Override // com.baidu.sofire.ac.FaceProcessCallback
    public void viewReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
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
        return invokeV.intValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            try {
                com.baidu.pass.biometrics.face.liveness.c.d.a();
                FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
                faceConfig.setBlurnessValue(0.6f);
                faceConfig.setBrightnessValue(40.0f);
                faceConfig.setBrightnessMaxValue(220.0f);
                faceConfig.setOcclusionLeftEyeValue(0.8f);
                faceConfig.setOcclusionRightEyeValue(0.8f);
                faceConfig.setOcclusionNoseValue(0.8f);
                faceConfig.setOcclusionMouthValue(0.8f);
                faceConfig.setOcclusionLeftContourValue(0.8f);
                faceConfig.setOcclusionRightContourValue(0.8f);
                faceConfig.setOcclusionChinValue(0.8f);
                faceConfig.setHeadPitchValue(20);
                faceConfig.setHeadYawValue(20);
                faceConfig.setHeadRollValue(20);
                faceConfig.setMinFaceSize(200);
                faceConfig.setNotFaceValue(0.6f);
                faceConfig.setEyeClosedValue(0.7f);
                faceConfig.setLivenessTypeList(this.r);
                faceConfig.setLivenessRandom(false);
                faceConfig.setSound(false);
                faceConfig.setTimeDetectModule(30000L);
                faceConfig.setCacheImageNum(3);
                faceConfig.setFaceFarRatio(0.3f);
                faceConfig.setFaceClosedRatio(1.0f);
                FaceSDKManager.getInstance().setFaceConfig(faceConfig);
            } catch (Exception unused) {
                if (this.I != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-303);
                    this.I.onFailure(passFaceRecogResult);
                }
                setActivityResult(0);
                a(-303);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
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
            this.I = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
            this.p = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
            f();
            d();
            this.q = c();
            this.s = new com.baidu.pass.biometrics.face.liveness.c.b(this);
        }
    }

    private void f() {
        List<Integer> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            List<LivenessTypeEnum> list2 = this.r;
            if (list2 == null) {
                this.r = new ArrayList();
            } else {
                list2.clear();
            }
            List<HeadPose> list3 = this.mPassFaceRecogDTO.poseList;
            if (list3 != null && !list3.isEmpty()) {
                com.baidu.pass.biometrics.face.liveness.c.f.b(this.r, this.mPassFaceRecogDTO.poseList);
                return;
            }
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.p;
            if (livenessConfigOption != null && (list = livenessConfigOption.action) != null && !list.isEmpty()) {
                try {
                    com.baidu.pass.biometrics.face.liveness.c.f.a(this.r, this.p.action);
                    return;
                } catch (Exception unused) {
                    com.baidu.pass.biometrics.face.liveness.c.f.b(this.r);
                    return;
                }
            }
            com.baidu.pass.biometrics.face.liveness.c.f.b(this.r);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            if (this.F == null) {
                this.F = new com.baidu.pass.biometrics.face.liveness.b.a();
            }
            this.F.E = System.currentTimeMillis();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
            aVar.f41851f = 1;
            PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
            aVar.f41847b = passFaceRecogDTO != null ? passFaceRecogDTO.getSpno() : "unknown";
            com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.F;
            aVar2.n = this.q;
            aVar2.o = 1;
            PassFaceRecogDTO passFaceRecogDTO2 = this.mPassFaceRecogDTO;
            aVar2.f41846a = passFaceRecogDTO2 != null ? passFaceRecogDTO2.livenessType.getRecogTypeName() : "unknown_type";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (this.I != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-206);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.I.onFailure(passFaceRecogResult);
                setActivityResult(-1);
            }
            this.F.r = "pass";
            a(-206);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(65554, this, f2) == null) && !this.v && a(f2)) {
            this.v = true;
            this.s.b();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
            aVar.m = f2;
            aVar.l = 1;
        }
    }

    private boolean a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65551, this, f2)) == null) ? f2 <= ((float) this.q) : invokeF.booleanValue;
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) == null) || view == null) {
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

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            FH.cancelFaceProcess();
            this.y = false;
        }
    }

    private void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65558, this, str, str2, str3) == null) || this.mPassFaceRecogDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
        httpHashMapWrap.put("image", str3);
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.p.isOriginImg() ? "1" : "0");
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
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new d(this, Looper.getMainLooper()));
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            a(ProgressStatus.BACK);
            this.f41819g.setVisibility(0);
            this.f41819g.setText(str);
            e(str);
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, str) == null) || this.x) {
            return;
        }
        this.f41820h.setVisibility(0);
        this.j.setText(str);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
        loadAnimation.setAnimationListener(new n(this, loadAnimation));
        if (this.t) {
            return;
        }
        this.f41821i.startAnimation(loadAnimation);
        this.t = true;
    }

    private void a(RequestInfo requestInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, requestInfo) == null) || requestInfo == null) {
            return;
        }
        JSONObject jSONObject = requestInfo.data;
        String optString = jSONObject != null ? jSONObject.optString("data") : null;
        n();
        if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            b(requestInfo.sKey, requestInfo.xDeviceId, optString);
        } else {
            a(requestInfo.sKey, requestInfo.xDeviceId, optString);
        }
    }

    private void a(ProgressStatus progressStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, progressStatus) == null) {
            ProgressStatus progressStatus2 = this.E;
            if ((progressStatus2 != null && progressStatus2 == progressStatus) || this.C == null || this.E == progressStatus) {
                return;
            }
            this.E = progressStatus;
            int i2 = f.f41832b[progressStatus.ordinal()];
            if (i2 == 1) {
                TimerTask timerTask = this.D;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.C.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.b bVar = new com.baidu.pass.biometrics.face.liveness.enums.b(this.f41818f);
                this.D = bVar;
                this.C.schedule(bVar, 0L, 10L);
            } else if (i2 != 2) {
            } else {
                TimerTask timerTask2 = this.D;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    this.C.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.a aVar = new com.baidu.pass.biometrics.face.liveness.enums.a(this.f41818f);
                this.D = aVar;
                this.C.schedule(aVar, 0L, 10L);
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            this.x = false;
            a(ProgressStatus.GO);
            this.f41819g.setText(str);
            this.f41819g.setVisibility(0);
            s();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
            if (aVar.K == 0) {
                aVar.f41852g = 1;
                aVar.K = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, str) == null) || this.I == null) {
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
            passFaceRecogResult.setResultCode(0);
            this.F.r = "pass";
            this.I.onSuccess(passFaceRecogResult);
            this.F.r = "pass";
            a(passFaceRecogResult.getResultCode());
        } catch (JSONException unused) {
            a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, str) == null) || this.I == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        passFaceRecogResult.setResultCode(i2);
        passFaceRecogResult.setResultMsg(str);
        this.I.onFailure(passFaceRecogResult);
        setActivityResult(-1);
        this.F.r = com.baidu.pass.biometrics.face.liveness.b.a.g0;
        a(passFaceRecogResult.getResultCode());
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, this, str, str2, str3) == null) || this.mPassFaceRecogDTO == null) {
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
        httpHashMapWrap.put("image", str3);
        httpHashMapWrap.put("version", "1");
        httpHashMapWrap.put("isOriginImg", this.p.isOriginImg() ? "1" : "0");
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
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new e(this, Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
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
                    contrastPortraitResult.finish = optJSONObject.optInt(ConstantHelper.LOG_FINISH);
                    contrastPortraitResult.imgdigests = optJSONObject.optString("imgdigests");
                    contrastPortraitResult.recordvideo = optJSONObject.optInt("recordvideo");
                }
            } catch (JSONException e2) {
                e2.getMessage();
                h();
            }
            a(contrastPortraitResult);
        }
    }

    @TargetApi(3)
    private void a(ContrastPortraitResult contrastPortraitResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, contrastPortraitResult) == null) || this.I == null || contrastPortraitResult == null) {
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
        if (contrastPortraitResult.isProcessPass()) {
            this.F.r = "pass";
            this.I.onSuccess(passFaceRecogResult);
        } else {
            this.F.r = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            this.I.onFailure(passFaceRecogResult);
        }
        a(passFaceRecogResult.getResultCode());
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LivenessTypeEnum livenessTypeEnum = this.G;
            if (livenessTypeEnum == null) {
                this.F.s = com.baidu.pass.biometrics.face.liveness.b.a.c0;
            } else if (livenessTypeEnum == LivenessTypeEnum.Eye) {
                this.F.s = com.baidu.pass.biometrics.face.liveness.b.a.d0;
            } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
                this.F.s = com.baidu.pass.biometrics.face.liveness.b.a.e0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.F;
            if (aVar != null) {
                aVar.P = System.currentTimeMillis();
                com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.F;
                aVar2.Q = i2;
                aVar2.a(this);
            }
            PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
            finish();
        }
    }
}
