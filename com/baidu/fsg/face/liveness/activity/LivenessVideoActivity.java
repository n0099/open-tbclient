package com.baidu.fsg.face.liveness.activity;

import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.NetworkUtils;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.b;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.beans.n;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.datamodel.VideoFaceMatchModel;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.FaceSDKResSettings;
import com.baidu.fsg.face.liveness.utils.LivenessVideoState;
import com.baidu.fsg.face.liveness.utils.SoUtils;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.fsg.face.liveness.view.LivenessVideoUploadView;
import com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView;
import com.baidu.fsg.face.liveness.view.LivenessVideoXfordView;
import com.baidu.fsg.face.liveness.view.LrcTipTextview;
import com.baidu.fsg.face.liveness.view.LrcView;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/* loaded from: classes10.dex */
public class LivenessVideoActivity extends LivenessCameraBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f34188c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34189d = "CONSTRASTBEANTAG";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34190e = "LivenessVideoActivity";

    /* renamed from: f  reason: collision with root package name */
    public static final int f34191f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f34192g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f34193h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f34194i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final int f34195j = 3;
    public static final int k = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ArrayList<HashMap<String, byte[]>> B;
    public boolean C;
    public VideoGetPortraitModel D;
    public long[] E;
    public List<String> F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public byte[] P;
    public int Q;
    public int R;
    public int S;
    public LivenessVideoXfordView l;
    public RelativeLayout m;
    public ImageView n;
    public LrcView o;
    public LinearLayout p;
    public ImageView q;
    public TextView r;
    public LivenessVideoWarningTipTextView s;
    public LivenessVideoUploadView t;
    public LrcTipTextview u;
    public LivenessRecogCallback v;
    public GetFPResponse.LivenessConfig w;
    public int x;
    public int[] y;
    public int z;

    /* renamed from: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity$13  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass13 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(854945049, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoActivity$13;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(854945049, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoActivity$13;");
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
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[FaceStatusNewEnum.DetectRemindCodeTimeout.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[FaceStatusNewEnum.FaceLivenessActionCodeTimeout.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(52939095, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(52939095, "Lcom/baidu/fsg/face/liveness/activity/LivenessVideoActivity;");
        }
    }

    public LivenessVideoActivity() {
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
        this.x = 0;
        this.y = null;
        this.F = new ArrayList();
        this.H = -1;
        this.I = -1;
        this.J = false;
        this.M = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.l.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSED, null);
            this.s.startInvisibleAnim();
            this.o.toInvalidate();
            this.p.setVisibility(0);
            this.u.setVisibility(0);
            this.u.postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LivenessVideoState livenessVideoState = this.a.livenessVideoState;
                        livenessVideoState.currentState = 4;
                        livenessVideoState.setLrcTextStartTime();
                        this.a.livenessVideoState.updateState(5);
                        this.a.m();
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.livenessVideoState.isLrcTipAnimCalling = true;
            this.u.startLrcTipAnim(new LrcView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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

                @Override // com.baidu.fsg.face.liveness.view.LrcView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        IVideoRecordProcess iVideoRecordProcess = this.a.mProcess;
                        if (iVideoRecordProcess != null) {
                            iVideoRecordProcess.startRecord();
                            LogUtil.d("hello", "start record");
                        }
                        this.a.u.postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.20.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass20 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    LivenessVideoActivity livenessVideoActivity = this.a.a;
                                    livenessVideoActivity.livenessVideoState.isLrcTipAnimCalling = false;
                                    livenessVideoActivity.o.setLrcList(this.a.a.F);
                                    this.a.a.o.toInvalidate();
                                }
                            }
                        }, 300L);
                    }
                }
            });
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.M = true;
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_timeout_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34207b;

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
                    this.f34207b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34207b.M = false;
                        this.a.dismiss();
                        if (this.f34207b.v != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            livenessRecogResult.setResultCode(-401);
                            this.f34207b.v.b(livenessRecogResult);
                        }
                        this.f34207b.c();
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

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.sapi_liveness_upload_video_fail_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(2);
            bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34208b;

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
                    this.f34208b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.X);
                        this.a.dismiss();
                        this.f34208b.k();
                    }
                }
            });
            bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34209b;

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
                    this.f34209b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.Y);
                        this.a.dismiss();
                        g.c(g.b(this.f34209b.getActivity()));
                        this.f34209b.a(-204, a.ERROR_MSG_USER_CANCEL);
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

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(BeanConstants.rim_timeout_error);
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(2);
            bioAlertDialog.setPositiveBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34210b;

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
                    this.f34210b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        this.f34210b.k();
                    }
                }
            });
            bioAlertDialog.setNegativeBtn(getString(R.string.sapi_alert_dialog_btn_cancel), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34211b;

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
                    this.f34211b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        g.c(g.b(this.f34211b.getActivity()));
                        this.f34211b.a(-204, a.ERROR_MSG_USER_CANCEL);
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

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_interrupt_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34212b;

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
                    this.f34212b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        this.f34212b.a(-204, a.ERROR_MSG_USER_CANCEL);
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

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            RimStatisticsUtil.onEvent(d.Z);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.liveness_video_file_exceptio_dialog_msg));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34196b;

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
                    this.f34196b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        this.f34196b.a(-204, a.ERROR_MSG_USER_CANCEL);
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

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34197b;

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
                    this.f34197b = this;
                    this.a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                        this.f34197b.a(-402, LivenessRecogResult.ERROR_MSG_LIVENESS_VIDEO_TOOLARGE);
                    }
                }
            });
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void buildDataError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(a.ERROR_MSG_BUILD_DATA_ERROR);
                livenessRecogResult.setResultCode(a.ERROR_CODE_BUILD_DATA_ERROR);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void cameraException() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(false, true);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void dofaceMatch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RimStatisticsUtil.onEventStart(d.O);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.FACEMATCH):  对比接口开始");
            n nVar = (n) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 10, "CONSTRASTBEANTAG");
            LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
            if (livenessRecogDTO != null) {
                nVar.b(livenessRecogDTO);
            }
            nVar.g("image");
            nVar.d("digests");
            nVar.a(this.sKey);
            nVar.c(this.xDeviceId);
            nVar.b(this.faceData);
            nVar.e(this.livenessVideoState.reqTimes + "");
            nVar.setResponseCallback(this);
            nVar.execBean();
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, str) == null) {
            if (i2 == 10) {
                a("0", i3);
            } else if (i2 == 11) {
                a(i3);
                if (i3 == -5) {
                    p();
                } else {
                    o();
                }
            } else {
                super.handleFailure(i2, i3, str);
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
            if (i2 == 10) {
                if (obj == null || !(obj instanceof VideoFaceMatchModel)) {
                    return;
                }
                a(((VideoFaceMatchModel) obj).isContrastPass() ? "1" : "0", 0);
            } else if (i2 == 11) {
                a(0);
                if (obj != null && (obj instanceof AudioVideoUploadModel)) {
                    if (this.v != null) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(0);
                        livenessRecogResult.callbackkey = ((AudioVideoUploadModel) obj).callbackkey;
                        this.v.a(livenessRecogResult);
                        g.c(g.b(getActivity()));
                        c();
                        return;
                    }
                    return;
                }
                a(-206, a.ERROR_MSG_SERVER_ERROR);
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void notTrustedDevice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(a.ERROR_MSG_UNTRUSTED_DEVICE);
                livenessRecogResult.setResultCode(a.ERROR_CODE_UNTRUSTED_DEVICE);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onBackPressed();
            RimStatisticsUtil.onEvent(d.R);
            a(-204, a.ERROR_MSG_USER_CANCEL);
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.v = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            if (this.livenessRecogDTO == null) {
                a(-206, a.ERROR_MSG_SERVER_ERROR);
            } else if (f34188c) {
                i();
                LogUtil.d("hello", "callManyTimes");
            } else {
                f34188c = true;
                d();
                FaceSDKResSettings.initializeResId();
                if (getIntent().getExtras() != null && (serializable = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) != null && (serializable instanceof VideoGetPortraitModel)) {
                    VideoGetPortraitModel videoGetPortraitModel = (VideoGetPortraitModel) serializable;
                    this.D = videoGetPortraitModel;
                    this.E = videoGetPortraitModel.getCutTimePoints();
                    this.F = this.D.getLrcContent();
                    this.N = this.D.getVideoMaxSize();
                }
                this.livenessVideoState.currentCount = -1;
                e();
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            FaceSDKManager.getInstance().release();
            LivenessVideoXfordView livenessVideoXfordView = this.l;
            if (livenessVideoXfordView != null) {
                livenessVideoXfordView.release();
            }
            BeanManager.getInstance().removeAllBeans(f34190e);
            BeanManager.getInstance().removeAllBeans("CONSTRASTBEANTAG");
            f34188c = false;
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void onRefreshView(FaceStatusNewEnum faceStatusNewEnum, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, faceStatusNewEnum, str, i2) == null) {
            LogUtil.d("hello", "status:" + faceStatusNewEnum.toString() + ",message:" + str);
            switch (AnonymousClass13.a[faceStatusNewEnum.ordinal()]) {
                case 1:
                case 2:
                    a("非常好");
                    return;
                case 3:
                    a("请将脸部离远一点");
                    return;
                case 4:
                    a("请将脸部靠近一点");
                    return;
                case 5:
                    a("把脸移入框内");
                    return;
                case 6:
                    a("把脸移入框内");
                    return;
                case 7:
                    a("请使环境光线再亮些");
                    return;
                case 8:
                    a("缓慢抬头");
                    return;
                case 9:
                    a("缓慢低头");
                    return;
                case 10:
                    a("向左缓慢转头");
                    return;
                case 11:
                    a("向右缓慢转头");
                    return;
                case 12:
                    a("请略微低头");
                    return;
                case 13:
                    a("请略微抬头");
                    return;
                case 14:
                    a("请略微向右转头");
                    return;
                case 15:
                    a("请略微向左转头");
                    return;
                case 16:
                case 17:
                    n();
                    a("检测超时");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            LogUtil.d("hello", "onStart");
            if (this.G) {
                this.G = false;
                if (!this.livenessVideoState.isWarnCancleTipAfterOnPause() || this.M) {
                    return;
                }
                q();
                return;
            }
            getCameraPermission();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStop();
            LogUtil.d("hello", MissionEvent.MESSAGE_STOP);
            if (this.mProcess != null) {
                LogUtil.d("hello", "mProcess.release");
                this.mProcess.release();
            }
            LogUtil.d("hello", "cancel face process");
            FH.cancelFaceProcess();
            if (this.permissionFlag) {
                return;
            }
            this.G = true;
        }
    }

    public void showVideoDoneView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            RimStatisticsUtil.onEventWithValue(d.T, this.L ? "1" : "0");
            this.m.setVisibility(4);
            this.l.setVisibility(4);
            LivenessVideoUploadView livenessVideoUploadView = new LivenessVideoUploadView(getActivity());
            this.t = livenessVideoUploadView;
            ((FrameLayout) findViewById(R.id.view_stup_upload_video)).addView(livenessVideoUploadView);
            this.t.showBackgroundBitmap();
            this.t.setUploadListener(new LivenessVideoUploadView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        RimStatisticsUtil.onEvent(d.V);
                        g.c(g.b(this.a.getActivity()));
                        this.a.a(-204, a.ERROR_MSG_USER_CANCEL);
                    }
                }

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public boolean b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (NetworkUtils.isNetworkAvailable(this.a.getActivity())) {
                            return true;
                        }
                        this.a.showNoNetWorkDialog();
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        RimStatisticsUtil.onEvent(d.U);
                        this.a.k();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            RimStatisticsUtil.getInstance().triggerSending();
            LogUtil.d("hello", "triggerSending:发送日志");
            setResult(0);
            finish();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            GetFPResponse.LivenessConfig a = c.a().a(getActivity());
            this.w = a;
            if (a == null) {
                this.w = new GetFPResponse.LivenessConfig();
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (!SoUtils.loadAIModelSo(this)) {
                f();
            } else if (!FH.isInitSuc(1)) {
                g();
            } else {
                j();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-403);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_MML_FRAMEWORK_NOT_FIND);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-404);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_SAFE_MODULE_LOAD_FAIL);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-303);
                livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_FACE_SDK_INIT_FAIL);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(a.ERROR_CODE_MANY_CALL);
                livenessRecogResult.setResultMsg(a.ERROR_MSG_MANY_CALL);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
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
            FaceSDKManager.getInstance().initialize(this, "baidu-sec-face-demo-face-android", "idl-license.face-android", new IInitCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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
                        this.a.h();
                        LogUtil.d("face-init", "初始化失败 = " + i2 + " " + str);
                    }
                }

                @Override // com.baidu.pass.face.platform.listener.IInitCallback
                public void initSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        LogUtil.d("face-init", "初始化成功");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65566, this) != null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(g.b(getActivity()));
            try {
                int available = fileInputStream2.available();
                byte[] bArr = new byte[available];
                fileInputStream2.read(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.O = available;
                int i2 = available / 1048576;
                ArrayList arrayList = new ArrayList();
                arrayList.add("" + c.a().b(getApplicationContext()));
                arrayList.add(String.valueOf(this.O));
                arrayList.add(this.N + "");
                if (this.livenessRecogDTO != null) {
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                }
                RimStatisticsUtil.onEventWithValues(d.ac, arrayList);
                if (this.O == 0) {
                    r();
                } else if (i2 >= this.N) {
                    RimStatisticsUtil.onEventWithValues(d.aa, arrayList);
                    int b2 = (int) (c.a().b(getApplicationContext()) / ((i2 / this.N) + 0.5f));
                    RimStatisticsUtil.onEventWithValue(d.ab, b2 + "");
                    c.a().a(getApplicationContext(), b2);
                    s();
                } else {
                    RimStatisticsUtil.onEventStart(d.W);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.VIDEOUPLOAD):  视频上传接口开始");
                    com.baidu.fsg.face.liveness.beans.a aVar = (com.baidu.fsg.face.liveness.beans.a) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 11, f34190e);
                    UploadBean.UploadFileModel uploadFileModel = new UploadBean.UploadFileModel();
                    uploadFileModel.contentType = "video/mp4";
                    uploadFileModel.filedata = bArr;
                    uploadFileModel.fileName = "video.mp4";
                    uploadFileModel.name = "file";
                    aVar.a(this.sKey);
                    aVar.c(this.xDeviceId);
                    aVar.b(this.faceData);
                    aVar.addFile(uploadFileModel);
                    aVar.d(this.livenessVideoState.getLrcStartTimeOffset());
                    aVar.e(this.L ? "0" : "1");
                    aVar.setProgressListener(new RestMultipartEntity.ProgressListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.17
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LivenessVideoActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
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
                                this.a.runOnUiThread(new Runnable(this, j2, j3) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.17.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ long a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ long f34198b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass17 f34199c;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j3)};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f34199c = this;
                                        this.a = j2;
                                        this.f34198b = j3;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f34199c.a.t.updateProgress((int) ((((float) this.a) / ((float) this.f34198b)) * 100.0f));
                                        }
                                    }
                                });
                            }
                        }
                    });
                    aVar.setResponseCallback(this);
                    aVar.execBean();
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
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int[] iArr = new int[2];
            this.o.getLocationInWindow(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = this.l.getWidth() - rect.left;
            rect.bottom = rect.top + rect.width();
            this.faceRectGroup.a = rect;
            this.l.setFocusViewRect(rect);
            ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            layoutParams2.topMargin = (rect.top + (rect.height() / 2)) - (this.u.getMeasuredHeight() / 2);
            this.u.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            if (this.v != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                this.v.b(livenessRecogResult);
            }
            c();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_liveness_video_activity, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_cancel);
            this.n = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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
                        this.a.onBackPressed();
                    }
                }
            });
            this.m = (RelativeLayout) inflate.findViewById(R.id.content);
            this.l = (LivenessVideoXfordView) inflate.findViewById(R.id.xfordview);
            LrcView lrcView = (LrcView) inflate.findViewById(R.id.focuslayout);
            this.o = lrcView;
            lrcView.setLrcFinishInterface(new LrcView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivenessVideoActivity a;

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

                @Override // com.baidu.fsg.face.liveness.view.LrcView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LivenessVideoActivity livenessVideoActivity = this.a;
                        IVideoRecordProcess iVideoRecordProcess = livenessVideoActivity.mProcess;
                        if (iVideoRecordProcess != null) {
                            livenessVideoActivity.isRecording = false;
                            iVideoRecordProcess.stopRecord();
                            LogUtil.d("hello", "stop record");
                        }
                        this.a.livenessVideoState.updateState(6);
                        this.a.showVideoDoneView();
                    }
                }
            });
            this.s = (LivenessVideoWarningTipTextView) inflate.findViewById(R.id.toastanim);
            this.p = (LinearLayout) inflate.findViewById(R.id.ll_time_count);
            this.r = (TextView) inflate.findViewById(R.id.tv_time_count);
            this.q = (ImageView) inflate.findViewById(R.id.iv_time_count_point);
            this.q.startAnimation(AnimationUtils.loadAnimation(this, R.anim.sapi_liveness_time_count_point));
            this.u = (LrcTipTextview) inflate.findViewById(R.id.lrc_tipview);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    private void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.M = true;
            String string = !z ? getString(R.string.sapi_permission_audio) : null;
            if (!z2) {
                string = getString(R.string.sapi_permission_camera);
            }
            if (!z && !z2) {
                string = getString(R.string.sapi_permission_audio_camera);
            }
            String format = String.format(getString(R.string.sapi_permission_without_title), string);
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleMsg(format);
            bioAlertDialog.setTitleVisible(true);
            bioAlertDialog.setDialogMsg(String.format(getString(R.string.sapi_permission_without_msg1), string) + String.format(getString(R.string.sapi_permission_without_msg2), string));
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog, z2, z) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f34204b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f34205c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34206d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog, Boolean.valueOf(z2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34206d = this;
                    this.a = bioAlertDialog;
                    this.f34204b = z2;
                    this.f34205c = z;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34206d.M = false;
                        this.a.dismiss();
                        if (this.f34206d.v != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            if (!this.f34204b) {
                                livenessRecogResult.setResultCode(-304);
                            } else if (!this.f34205c) {
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            }
                            this.f34206d.v.b(livenessRecogResult);
                        }
                        this.f34206d.c();
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

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bArr, camera) == null) {
            try {
                if (this.isRecording) {
                    return;
                }
                this.isRecording = true;
                this.l.updateXfordViewState(LivenessVideoXfordView.VideoXfordViewState.SUCCESSING, new LivenessVideoXfordView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LivenessVideoActivity a;

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

                    @Override // com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.l();
                        }
                    }
                });
            } catch (Throwable th) {
                com.baidu.fsg.face.base.d.d.a(th);
            }
        }
    }

    private void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, camera) == null) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(1, cameraInfo);
            int i2 = previewSize.width;
            this.Q = i2;
            int i3 = previewSize.height;
            this.R = i3;
            this.S = cameraInfo.orientation;
            b bVar = this.faceRectGroup;
            bVar.f34067c = i2;
            bVar.f34068d = i3;
            GetFPResponse.LivenessConfig livenessConfig = this.w;
            if (livenessConfig == null || TextUtils.isEmpty(livenessConfig.min_face_size)) {
                int i4 = this.Q;
            }
            if (this.y == null) {
                this.y = new int[this.Q * this.R];
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34200b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34200b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LivenessVideoActivity livenessVideoActivity = this.f34200b;
                        LivenessVideoState livenessVideoState = livenessVideoActivity.livenessVideoState;
                        if (livenessVideoState.isWarningTipAnimCalled) {
                            livenessVideoActivity.s.startVisibleAnim();
                            this.f34200b.s.setText(this.a);
                            LivenessVideoActivity livenessVideoActivity2 = this.f34200b;
                            if (livenessVideoActivity2.livenessVideoState.currentState == 5 && livenessVideoActivity2.u.getVisibility() == 0) {
                                this.f34200b.u.setVisibility(4);
                                this.f34200b.livenessVideoState.isLrcTipViewHadGone = true;
                                return;
                            }
                            return;
                        }
                        if (livenessVideoState.currentState == 5 && livenessVideoActivity.u.getVisibility() == 0) {
                            this.f34200b.u.setVisibility(4);
                            this.f34200b.livenessVideoState.isLrcTipViewHadGone = true;
                        }
                        LivenessVideoActivity livenessVideoActivity3 = this.f34200b;
                        livenessVideoActivity3.livenessVideoState.isWarningTipAnimCalled = true;
                        livenessVideoActivity3.s.setVisibility(0);
                        this.f34200b.s.setText(this.a);
                        this.f34200b.J = true;
                        this.f34200b.s.startTranslateAnim(new LivenessVideoWarningTipTextView.a(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.18.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass18 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }

                            @Override // com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.a
                            public void b() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.a.f34200b.J = false;
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65544, this, str, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(this.livenessRecogDTO.spParams + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        arrayList.add(str);
        arrayList.add(this.livenessVideoState.reqTimes + "");
        RimStatisticsUtil.onEventEndWithValues(d.O, i2, arrayList);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || this.livenessRecogDTO == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.livenessRecogDTO.getSpno() + "");
        arrayList.add(this.livenessRecogDTO.spParams + "");
        arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
        RimStatisticsUtil.onEventEndWithValues(d.W, i2, arrayList);
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity
    public void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && z3) {
            b(z2, z);
        }
    }

    private void a(boolean z, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.M = true;
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setTitleVisible(true);
            if (!z) {
                string = getString(R.string.sapi_liveness_open_camera_no_permission);
            } else {
                string = !z2 ? getString(R.string.sapi_liveness_record_video_no_audio_permission) : "";
            }
            bioAlertDialog.setDialogMsg(string);
            bioAlertDialog.setBtnCount(1);
            bioAlertDialog.setNeutralBtn(getString(R.string.sapi_alert_dialog_btn_ok), new View.OnClickListener(this, bioAlertDialog, z, z2) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BioAlertDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f34201b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f34202c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoActivity f34203d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog, Boolean.valueOf(z), Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34203d = this;
                    this.a = bioAlertDialog;
                    this.f34201b = z;
                    this.f34202c = z2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34203d.M = false;
                        this.a.dismiss();
                        if (this.f34203d.v != null) {
                            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                            if (!this.f34201b) {
                                livenessRecogResult.setResultCode(a.ERROR_CODE_CAMERA_EXCEPTION);
                            } else if (!this.f34202c) {
                                livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
                            }
                            this.f34203d.v.b(livenessRecogResult);
                        }
                        this.f34203d.c();
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
}
