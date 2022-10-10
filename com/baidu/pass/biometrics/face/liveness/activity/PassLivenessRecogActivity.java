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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.pass.biometrics.face.liveness.enums.ProgressStatus;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.http.ReqPriority;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.Degree;
import com.baidu.sofire.face.api.FaceApi;
import com.baidu.sofire.face.api.FaceProcessCallback;
import com.baidu.sofire.face.api.FaceVerifyInfo;
import com.baidu.sofire.face.api.RequestInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.fun.ad.sdk.FunAdSdk;
import com.google.protobuf.CodedInputStream;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard, FaceProcessCallback, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String O = "PassLivenessRecogActivity";
    public static final int P = 2002;
    public static final int Q = 7126;
    public static final int R = 7127;
    public static final int S = 112;
    public static final int T = 255;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Timer B;
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
    public Boolean M;
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
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public a(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                this.b.r();
                this.b.E.A = 1;
                this.b.setActivityResult(0);
                this.b.a(-204);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public b(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                this.b.E.D = 1;
                this.b.setActivityResult(-1);
                if (this.b.H != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-301);
                    this.b.H.onFailure(passFaceRecogResult);
                }
                this.b.a(-301);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements PixelCopy.OnPixelCopyFinishedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PixelCopyCallback a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ PassLivenessRecogActivity c;

        public c(PassLivenessRecogActivity passLivenessRecogActivity, PixelCopyCallback pixelCopyCallback, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, pixelCopyCallback, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = passLivenessRecogActivity;
            this.a = pixelCopyCallback;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                this.a.onFinsh(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PassLivenessRecogActivity passLivenessRecogActivity, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.E.Q = i;
                this.a.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.b(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PassLivenessRecogActivity passLivenessRecogActivity, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.E.Q = i;
                this.a.f();
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.a(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
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
    public class g implements b.InterfaceC0118b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        public g(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.c.b.InterfaceC0118b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                this.a.b(f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements CircleProgressView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        public h(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView.b
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                if (f == 100.0f) {
                    this.a.f.setShowTick(false);
                } else {
                    this.a.f.setShowTick(true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public i(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewUtility.dismissDialog(this.b, this.a);
                this.b.y = true;
                this.b.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public j(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewUtility.dismissDialog(this.b, this.a);
                if (this.b.H != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                    this.b.H.onFailure(passFaceRecogResult);
                }
                this.b.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        public k(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o.dismiss();
                this.a.y = false;
                if (this.a.H != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                    this.a.H.onFailure(passFaceRecogResult);
                }
                this.a.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                if (intent.resolveActivity(this.a.getPackageManager()) != null) {
                    this.a.startActivity(intent);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        public l(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o.dismiss();
                this.a.y = false;
                if (this.a.H != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                    this.a.H.onFailure(passFaceRecogResult);
                }
                this.a.a((int) PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements PixelCopyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassLivenessRecogActivity a;

        public m(PassLivenessRecogActivity passLivenessRecogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passLivenessRecogActivity;
        }

        @Override // com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback
        public void onFinsh(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.a.l.setImageBitmap(com.baidu.pass.biometrics.face.liveness.c.c.a(this.a, bitmap));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public n(PassLivenessRecogActivity passLivenessRecogActivity, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.i.startAnimation(this.a);
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

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a a;
        public final /* synthetic */ PassLivenessRecogActivity b;

        public o(PassLivenessRecogActivity passLivenessRecogActivity, com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passLivenessRecogActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passLivenessRecogActivity;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.E.a();
                this.b.E.B = 1;
                this.b.onResume();
                this.a.dismiss();
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
        this.u = false;
        this.v = true;
        this.w = true;
        this.B = new Timer(true);
        this.M = Boolean.TRUE;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.h.setVisibility(4);
            this.g.setVisibility(0);
            this.g.setText(R.string.pass_liveness_frist_text);
            this.F = null;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
            this.f = (CircleProgressView) findViewById(R.id.pass_bio_liveness_recog_cpv);
            this.g = (TextView) findViewById(R.id.pass_bio_liveness_recog_tip_text);
            this.f.setNormalColor(Color.parseColor("#FFE0E0E0"));
            this.f.setOnChangeListener(new h(this));
            this.h = (FrameLayout) findViewById(R.id.layout_pose_warning);
            this.i = (ImageView) findViewById(R.id.iv_pose_warning_tip);
            this.j = (TextView) findViewById(R.id.tv_pose_warning_tip);
            this.k = (CameraSurfaceView) findViewById(R.id.pass_bio_camera_pre_view);
            this.l = (CircleImageView) findViewById(R.id.pass_bio_circle_image_view);
            this.m = (CircleImageView) findViewById(R.id.pass_bio_circle_hide_view);
            this.n = (LinearLayout) findViewById(R.id.pass_bio_loading_view);
            setBrightness(this, 255);
            ((ImageView) findViewById(R.id.pass_bio_liveness_recog_close)).setOnClickListener(this);
            PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
            if (passFaceRecogDTO == null || !passFaceRecogDTO.needAuthorizeCertInfo) {
                return;
            }
            this.N = passFaceRecogDTO.extraParamsMap.get("yyOrderId");
            this.M = Boolean.FALSE;
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091d8d)).setText(R.string.home_face_yy_title);
            this.K = (ImageView) findViewById(R.id.pass_bio_circle_image_yy_view);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.pass_bio_liveness_recog_yy_bottom);
            this.L = relativeLayout;
            relativeLayout.setVisibility(0);
            this.K.setVisibility(0);
            findViewById(R.id.pass_bio_liveness_recog_tv_href).setOnClickListener(this);
            findViewById(R.id.pass_bio_liveness_recog_argee_btn).setOnClickListener(this);
            this.g.setText(R.string.home_face_yy_tips);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.E.C = 1;
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

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            CircleProgressView circleProgressView = this.f;
            if (circleProgressView != null) {
                circleProgressView.setVisibility(8);
            }
            showLoadingView();
            this.t = true;
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.y = true;
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

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.l.c();
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            i();
            onPause();
            if (this.v) {
                p();
                this.v = false;
                return;
            }
            k();
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.E.z = 1;
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

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            this.h.setVisibility(8);
            this.h.clearAnimation();
            this.s = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65583, this) == null) || this.H == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_USER_CANCEL);
        passFaceRecogResult.setResultCode(-204);
        this.H.onFailure(passFaceRecogResult);
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65584, null, activity, i2) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = i2 * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void animStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void backBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r();
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

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.setVisibility(0);
            this.l.setBackgroundColor(-1);
            this.g.setText(R.string.pass_liveness_frist_text);
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBeginBuildData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onBeginCollectFaceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            if (aVar.J == 0) {
                aVar.J = System.currentTimeMillis();
            }
            this.G = System.currentTimeMillis();
            this.k.setVisibility(0);
            this.A = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2.getId() == R.id.pass_bio_liveness_recog_close) {
                r();
                a();
                setActivityResult(0);
                a(-204);
            } else if (view2.getId() == R.id.pass_bio_liveness_recog_argee_btn) {
                this.L.setVisibility(8);
                this.K.setVisibility(8);
                this.M = Boolean.TRUE;
                g();
            } else if (view2.getId() == R.id.pass_bio_liveness_recog_tv_href) {
                startActivity(new Intent(this, YYProtocolActivity.class));
            }
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i2)}) == null) {
            Log.w("new_face", "faceStatusNewEnum " + faceStatusNewEnum + ",message = " + str);
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            aVar.I = aVar.I + 1;
            if (this.x) {
                if (this.A) {
                    n();
                    this.A = false;
                }
                switch (f.a[faceStatusNewEnum.ordinal()]) {
                    case 1:
                        q();
                        if (Build.VERSION.SDK_INT >= 24) {
                            getBitmapFromSurfaceView(this.k, new m(this));
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
                        o();
                        break;
                }
                this.E.J = System.currentTimeMillis();
            }
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onConfigCamera(Camera camera, Rect rect, Rect rect2, Degree degree) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, camera, rect, rect2, degree) == null) || this.k == null) {
            return;
        }
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
            d();
            e();
            j();
            this.r.a(new g(this));
            h();
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
            try {
                System.gc();
            } catch (Exception e2) {
                Log.e("TAG", e2.getMessage());
            }
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onDeviceCheckResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onEnd(int i2, RequestInfo requestInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, requestInfo) == null) {
            Log.e("new_face", "onEnd() i = " + i2 + ",requestInfo = ");
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            aVar.H = aVar.H + (System.currentTimeMillis() - this.G);
            this.g.setVisibility(4);
            if (this.H == null) {
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
            }
            PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
            passFaceRecogResult2.setResultCode(i2);
            this.H.onFailure(passFaceRecogResult2);
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
                r();
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
            if (this.y) {
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
            this.y = false;
            if (i2 == 2002) {
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.E.F = System.currentTimeMillis();
                    com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
                    aVar.d = 1;
                    aVar.e = 1;
                    g();
                    return;
                }
                m();
            }
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.t || this.y) {
                return;
            }
            g();
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void onTestFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bitmap) == null) {
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
    public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, livenessTypeEnum) == null) {
        }
    }

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
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

    @Override // com.baidu.sofire.face.api.FaceProcessCallback
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
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            if (this.E == null) {
                this.E = new com.baidu.pass.biometrics.face.liveness.b.a();
            }
            this.E.E = System.currentTimeMillis();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            aVar.f = 1;
            PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
            aVar.b = passFaceRecogDTO != null ? passFaceRecogDTO.getSpno() : "unknown";
            com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.E;
            aVar2.n = this.q;
            aVar2.o = 1;
            PassFaceRecogDTO passFaceRecogDTO2 = this.mPassFaceRecogDTO;
            aVar2.a = passFaceRecogDTO2 != null ? passFaceRecogDTO2.livenessType.getRecogTypeName() : "unknown_type";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
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
    }

    private void g() {
        CameraSurfaceView cameraSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65571, this) == null) || (cameraSurfaceView = this.k) == null || cameraSurfaceView.getHolder() == null || this.x || !this.M.booleanValue()) {
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

    @TargetApi(23)
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
                if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
                    this.y = true;
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
                    this.y = true;
                    requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2002);
                    return;
                }
            }
            this.E.F = System.currentTimeMillis();
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void b(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(65554, this, f2) == null) && !this.u && a(f2)) {
            this.u = true;
            this.r.b();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            aVar.m = f2;
            aVar.l = 1;
        }
    }

    private boolean a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65551, this, f2)) == null) ? f2 <= ((float) this.q) : invokeF.booleanValue;
    }

    private void a(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2.getBackground() != null) {
            view2.getBackground().setCallback(null);
            view2.setBackgroundResource(0);
        }
        if (view2 instanceof ImageView) {
            ((ImageView) view2).setImageBitmap(null);
        }
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
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

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            FaceApi.cancelFaceProcess();
            this.x = false;
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, str) == null) || this.w) {
            return;
        }
        this.h.setVisibility(0);
        this.j.setText(str);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
        loadAnimation.setAnimationListener(new n(this, loadAnimation));
        if (this.s) {
            return;
        }
        this.i.startAnimation(loadAnimation);
        this.s = true;
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
        try {
            if (this.mPassFaceRecogDTO.extraParams != null) {
                for (String str4 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                    httpHashMapWrap.put(str4, (String) this.mPassFaceRecogDTO.extraParams.get(str4));
                }
            }
        } catch (Exception e2) {
            com.baidu.sapi2.utils.Log.e(O, e2.getMessage());
        }
        httpHashMapWrap.put(FunAdSdk.PLATFORM_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new d(this, Looper.getMainLooper()));
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            a(ProgressStatus.BACK);
            this.g.setVisibility(0);
            this.g.setText(str);
            e(str);
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            this.w = false;
            a(ProgressStatus.GO);
            this.g.setText(str);
            this.g.setVisibility(0);
            q();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            if (aVar.K == 0) {
                aVar.g = 1;
                aVar.K = System.currentTimeMillis();
            }
        }
    }

    private void a(RequestInfo requestInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, requestInfo) == null) || requestInfo == null) {
            return;
        }
        JSONObject jSONObject = requestInfo.data;
        String optString = jSONObject != null ? jSONObject.optString("data") : null;
        l();
        if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            b(requestInfo.sKey, requestInfo.xDeviceId, optString);
        } else {
            a(requestInfo.sKey, requestInfo.xDeviceId, optString);
        }
    }

    private void a(ProgressStatus progressStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, progressStatus) == null) {
            ProgressStatus progressStatus2 = this.D;
            if ((progressStatus2 != null && progressStatus2 == progressStatus) || this.B == null || this.D == progressStatus) {
                return;
            }
            this.D = progressStatus;
            int i2 = f.b[progressStatus.ordinal()];
            if (i2 == 1) {
                TimerTask timerTask = this.C;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.B.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.b bVar = new com.baidu.pass.biometrics.face.liveness.enums.b(this.f);
                this.C = bVar;
                this.B.schedule(bVar, 0L, 10L);
            } else if (i2 != 2) {
            } else {
                TimerTask timerTask2 = this.C;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    this.B.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.a aVar = new com.baidu.pass.biometrics.face.liveness.enums.a(this.f);
                this.C = aVar;
                this.B.schedule(aVar, 0L, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, str) == null) || this.H == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        passFaceRecogResult.setResultCode(i2);
        passFaceRecogResult.setResultMsg(str);
        this.H.onFailure(passFaceRecogResult);
        setActivityResult(-1);
        this.E.r = com.baidu.pass.biometrics.face.liveness.b.a.g0;
        a(passFaceRecogResult.getResultCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, str) == null) || this.H == null) {
            return;
        }
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("retCode");
            String optString = jSONObject.optString("retMsg");
            this.E.Q = optInt;
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject(TiebaStatic.LogFields.RESULT);
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, this, str, str2, str3) == null) || this.mPassFaceRecogDTO == null) {
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
        try {
            if (this.mPassFaceRecogDTO.extraParams != null) {
                for (String str4 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                    httpHashMapWrap.put(str4, (String) this.mPassFaceRecogDTO.extraParams.get(str4));
                }
            }
        } catch (Exception e3) {
            com.baidu.sapi2.utils.Log.e(O, e3.getMessage());
        }
        httpHashMapWrap.put(FunAdSdk.PLATFORM_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new e(this, Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("retCode");
                this.E.Q = optInt;
                String optString = jSONObject.optString("retMsg");
                contrastPortraitResult.setResultCode(optInt);
                contrastPortraitResult.setResultMsg(optString);
                if (contrastPortraitResult.getResultCode() == 0) {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(TiebaStatic.LogFields.RESULT);
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
    }

    @TargetApi(3)
    private void a(ContrastPortraitResult contrastPortraitResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, contrastPortraitResult) == null) || this.H == null || contrastPortraitResult == null) {
            return;
        }
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LivenessTypeEnum livenessTypeEnum = this.F;
            if (livenessTypeEnum == null) {
                this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.c0;
            } else if (livenessTypeEnum == LivenessTypeEnum.Eye) {
                this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.d0;
            } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
                this.E.s = com.baidu.pass.biometrics.face.liveness.b.a.e0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.E;
            if (aVar != null) {
                aVar.P = System.currentTimeMillis();
                this.E.a(this);
            }
            PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
            finish();
        }
    }
}
