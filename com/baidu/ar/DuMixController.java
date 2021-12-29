package com.baidu.ar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.pixel.IPixelReader;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.l;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.ar.auth.IOfflineAuthenticator;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.h.n;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class DuMixController implements IDuMix, IPixelReader, IFilter, IPhoto, IRecord {
    public static /* synthetic */ Interceptable $ic;
    public static volatile DuMixController aM;
    public static volatile int aW;
    public static volatile Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.filter.a B;
    public DuMixInput V;
    public DuMixOutput W;
    public HandlerThread aN;
    public Handler aO;
    public Handler aP;
    public DuMixCallback aQ;
    public e aR;
    public com.baidu.ar.lua.e aS;
    public OrientationManager aT;
    public com.baidu.ar.record.a aU;
    public IContentPlatform aV;
    public DuMixCallback aa;
    public b ad;

    /* renamed from: d  reason: collision with root package name */
    public DefaultParams f33888d;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.ar.lua.b f33889f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.ar.arrender.c f33890g;
    public Context mContext;
    public com.baidu.ar.a.b w;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuMixController aX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DuMixController duMixController, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixController, looper};
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
            this.aX = duMixController;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 3000:
                        this.aX.R();
                        return;
                    case 3001:
                        this.aX.T();
                        return;
                    case 3002:
                        this.aX.U();
                        return;
                    case 3003:
                        this.aX.V();
                        return;
                    case 3004:
                        this.aX.a((CaseModel) message.obj);
                        return;
                    case 3005:
                        this.aX.W();
                        return;
                    case 3006:
                        if (this.aX.f33890g != null) {
                            this.aX.f33890g.changeOutputSize(message.arg1, message.arg2);
                            return;
                        }
                        return;
                    case 3007:
                        this.aX.W = (DuMixOutput) message.obj;
                        if (this.aX.f33890g != null) {
                            this.aX.f33890g.changeOutput(this.aX.W);
                            return;
                        }
                        return;
                    case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY /* 3008 */:
                        if (this.aX.f33890g != null) {
                            this.aX.f33890g.pauseScene();
                            return;
                        }
                        return;
                    case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_START_STAMP_KEY /* 3009 */:
                        if (this.aX.f33890g != null) {
                            this.aX.f33890g.resumeScene();
                            return;
                        }
                        return;
                    case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_END_STAMP_KEY /* 3010 */:
                        if (this.aX.f33890g != null) {
                            this.aX.f33890g.a(message.obj, message.arg1, message.arg2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1311334276, "Lcom/baidu/ar/DuMixController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1311334276, "Lcom/baidu/ar/DuMixController;");
                return;
            }
        }
        sLock = new Object();
    }

    public DuMixController(Context context, DefaultParams defaultParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, defaultParams};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        if (defaultParams != null) {
            this.f33888d = defaultParams;
        } else {
            this.f33888d = new DefaultParams();
        }
        com.baidu.ar.h.b.c("DuMixController", "create DuMixController sState = " + aW);
        if (aW == 3) {
            synchronized (sLock) {
                try {
                    com.baidu.ar.h.b.c("DuMixController", "create DuMixController wait for release!");
                    sLock.wait(3000L);
                } catch (Exception unused) {
                    com.baidu.ar.h.b.b("DuMixController", "create DuMixController wait error!!!");
                }
            }
        }
        HandlerThread handlerThread = new HandlerThread("DuMixController");
        this.aN = handlerThread;
        handlerThread.start();
        this.aO = new a(this, this.aN.getLooper());
        com.baidu.ar.c.c.cd().a(this.aN.getLooper());
        a(this.mContext, this.f33888d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.ar.h.b.c("DuMixController", "handleSetup() sState = " + aW);
            if (aW != 0 || this.aR == null || this.f33890g == null || this.B == null || this.ad == null || this.w == null) {
                return;
            }
            aW = 1;
            this.aQ = S();
            this.aR.a(this.f33890g, this.ad, this.B, this.f33889f);
            this.aR.setup(this.V, this.W, this.aQ);
            StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.V.isCameraInput() ? "camera" : "video");
            StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
            this.aT.addOrientationListener(this.f33890g);
            this.aT.enable();
            this.B.a(this.f33890g);
            com.baidu.ar.a.b bVar = this.w;
            if (bVar != null) {
                JSONObject af = bVar.af();
                if (af != null) {
                    this.f33890g.a(af);
                } else {
                    this.f33890g.setLocalDeviceGrade(this.w.ag());
                }
            }
            this.ad.a(this.f33889f, this.f33890g);
            this.f33890g.a(this.V, this.W);
            this.aR.a(this.w);
            this.aR.E();
        }
    }

    private DuMixCallback S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new DuMixCallback(this) { // from class: com.baidu.ar.DuMixController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DuMixController aX;

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
                this.aX = this;
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(boolean z, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.aX.aP == null) {
                    return;
                }
                this.aX.aP.post(new Runnable(this, z, str, str2) { // from class: com.baidu.ar.DuMixController.1.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean aY;
                    public final /* synthetic */ AnonymousClass1 bb;
                    public final /* synthetic */ String bc;
                    public final /* synthetic */ String bd;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), str, str2};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.bb = this;
                        this.aY = z;
                        this.bc = str;
                        this.bd = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DuMixCallback duMixCallback;
                        Interceptable interceptable3 = $ic;
                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (duMixCallback = this.bb.aX.aa) == null) {
                            return;
                        }
                        duMixCallback.onCaseCreate(this.aY, this.bc, this.bd);
                    }
                });
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.aX.aP == null) {
                    return;
                }
                this.aX.aP.post(new Runnable(this) { // from class: com.baidu.ar.DuMixController.1.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass1 bb;

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
                        this.bb = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DuMixCallback duMixCallback;
                        Interceptable interceptable3 = $ic;
                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (duMixCallback = this.bb.aX.aa) == null) {
                            return;
                        }
                        duMixCallback.onCaseDestroy();
                    }
                });
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.aX.aP == null) {
                    return;
                }
                this.aX.aP.post(new Runnable(this, duMixErrorType, str, str2) { // from class: com.baidu.ar.DuMixController.1.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass1 bb;
                    public final /* synthetic */ DuMixErrorType be;
                    public final /* synthetic */ String bf;
                    public final /* synthetic */ String bg;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, duMixErrorType, str, str2};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.bb = this;
                        this.be = duMixErrorType;
                        this.bf = str;
                        this.bg = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DuMixCallback duMixCallback;
                        Interceptable interceptable3 = $ic;
                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (duMixCallback = this.bb.aX.aa) == null) {
                            return;
                        }
                        duMixCallback.onError(this.be, this.bf, this.bg);
                    }
                });
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.baidu.ar.h.b.c("DuMixController", "getDuMixCallbackProxy onRelease sState = " + DuMixController.aW);
                    int unused = DuMixController.aW = 0;
                    synchronized (DuMixController.sLock) {
                        try {
                            DuMixController.sLock.notifyAll();
                        } catch (Exception unused2) {
                            com.baidu.ar.h.b.c("DuMixController", "onRelease normal!!!");
                        }
                    }
                    if (this.aX.aP != null) {
                        this.aX.aP.post(new Runnable(this) { // from class: com.baidu.ar.DuMixController.1.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 bb;

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
                                this.bb = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                DuMixCallback duMixCallback;
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (duMixCallback = this.bb.aX.aa) == null) {
                                    return;
                                }
                                duMixCallback.onRelease();
                                this.bb.aX.aa = null;
                            }
                        });
                        this.aX.aP = null;
                    }
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
                    com.baidu.ar.h.b.c("DuMixController", "getDuMixCallbackProxy onSetup sState = " + DuMixController.aW);
                    if (z) {
                        int unused = DuMixController.aW = 2;
                    }
                    if (this.aX.aR != null) {
                        this.aX.aR.F();
                    }
                    if (this.aX.aP != null) {
                        this.aX.aP.post(new Runnable(this, z, duMixInput, duMixOutput) { // from class: com.baidu.ar.DuMixController.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ boolean aY;
                            public final /* synthetic */ DuMixInput aZ;
                            public final /* synthetic */ DuMixOutput ba;
                            public final /* synthetic */ AnonymousClass1 bb;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Boolean.valueOf(z), duMixInput, duMixOutput};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.bb = this;
                                this.aY = z;
                                this.aZ = duMixInput;
                                this.ba = duMixOutput;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.bb.aX.aa == null) {
                                    return;
                                }
                                com.baidu.ar.h.b.c("DuMixController", "mDuMixCallback.onSetup()");
                                this.bb.aX.aa.onSetup(this.aY, this.aZ, this.ba);
                            }
                        });
                    }
                    synchronized (DuMixController.sLock) {
                        try {
                            DuMixController.sLock.notifyAll();
                        } catch (Exception unused2) {
                            com.baidu.ar.h.b.c("DuMixController", "onSetup normal!!!");
                        }
                    }
                }
            }
        } : (DuMixCallback) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && aW == 2) {
            b bVar = this.ad;
            if (bVar != null) {
                bVar.pause();
            }
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar != null) {
                cVar.pause();
            }
            OrientationManager orientationManager = this.aT;
            if (orientationManager != null) {
                orientationManager.disable();
            }
            StatisticApi.pause();
            e eVar = this.aR;
            if (eVar != null) {
                eVar.l("pause");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && aW == 2) {
            e eVar = this.aR;
            if (eVar != null) {
                eVar.l("resume");
            }
            StatisticApi.resume();
            OrientationManager orientationManager = this.aT;
            if (orientationManager != null) {
                orientationManager.enable();
            }
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar != null) {
                cVar.resume();
            }
            b bVar = this.ad;
            if (bVar != null) {
                bVar.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.baidu.ar.h.b.c("DuMixController", "handleRelease() sState = " + aW);
            Handler handler = this.aO;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.aO = null;
            }
            this.aV = null;
            e eVar = this.aR;
            if (eVar != null) {
                eVar.A();
            }
            com.baidu.ar.lua.e eVar2 = this.aS;
            if (eVar2 != null) {
                eVar2.release();
                this.aS = null;
            }
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.clearAllFilter();
                this.B.release();
                this.B = null;
            }
            b bVar = this.ad;
            if (bVar != null) {
                bVar.release();
                this.ad = null;
            }
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar != null) {
                cVar.release();
                this.f33890g = null;
            }
            OrientationManager orientationManager = this.aT;
            if (orientationManager != null) {
                orientationManager.destroy();
                this.aT = null;
            }
            com.baidu.ar.a.b bVar2 = this.w;
            if (bVar2 != null) {
                bVar2.release();
                this.w = null;
            }
            com.baidu.ar.libloader.a.release();
            ARAuth.release();
            StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
            StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
            StatisticApi.release();
            com.baidu.ar.lua.b bVar3 = this.f33889f;
            if (bVar3 != null) {
                bVar3.destroy();
                this.f33889f = null;
            }
            e eVar3 = this.aR;
            if (eVar3 != null) {
                eVar3.release();
                this.aR = null;
            }
            this.V = null;
            this.W = null;
            this.f33888d = null;
            this.aQ = null;
            this.mContext = null;
            com.baidu.ar.h.b.c("DuMixController", "handleRelease() end");
            HandlerThread handlerThread = this.aN;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.aN = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.aR == null || aW != 2) {
                com.baidu.ar.h.b.b("DuMixController", "handleClearCase DuMix has not setup!!!!!!");
            } else {
                this.aR.clearCase();
            }
        }
    }

    private void a(Context context, DefaultParams defaultParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, context, defaultParams) == null) {
            com.baidu.ar.h.b.c("DuMixController", "createManagers start!!!");
            if (this.aP == null) {
                this.aP = new Handler(context.getMainLooper());
            }
            com.baidu.ar.h.b.T(defaultParams.isLogEnable());
            com.baidu.ar.h.a.setPackageName(context.getPackageName());
            if (this.aT == null) {
                this.aT = new OrientationManager(context);
            }
            StatisticApi.init(context);
            if (this.aR == null) {
                e eVar = new e(context, defaultParams, this.aN);
                this.aR = eVar;
                eVar.a(this);
            }
            if (this.w == null) {
                com.baidu.ar.a.b bVar = new com.baidu.ar.a.b(context);
                this.w = bVar;
                bVar.c(defaultParams.getGradingConfig());
            }
            if (this.B == null) {
                this.B = new com.baidu.ar.filter.a(defaultParams);
                this.ad = new b(context, this.aN.getLooper(), defaultParams, this.w, this.B);
            }
            if (this.f33889f == null) {
                com.baidu.ar.lua.b bVar2 = new com.baidu.ar.lua.b(context);
                this.f33889f = bVar2;
                bVar2.setUserPlayAudio(defaultParams.isUserPlayAudio());
            }
            if (this.f33890g == null) {
                this.f33890g = defaultParams.isUseTextureIO() ? new com.baidu.ar.arrender.d(context, this.aN.getLooper(), this.f33889f, defaultParams.getShareContext(), defaultParams.get3dShaderDBPath()) : new com.baidu.ar.arrender.c(context, this.aN.getLooper(), this.f33889f, defaultParams.get3dShaderDBPath());
                if (!TextUtils.isEmpty(defaultParams.getRenderPipeline())) {
                    this.f33890g.setDefaultPipeLine(defaultParams.getRenderPipeline());
                }
            }
            com.baidu.ar.h.b.c("DuMixController", "createManagers end!!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CaseModel caseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, caseModel) == null) {
            if (this.aR != null && aW == 2) {
                this.aR.loadCase(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                return;
            }
            com.baidu.ar.h.b.b("DuMixController", "handleLoadCase DuMix has not setup!!!!!!");
            DuMixCallback duMixCallback = this.aQ;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(false, caseModel.mCasePath, caseModel.mCaseId);
            }
        }
    }

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, str, str2, str3)) == null) ? com.baidu.ar.auth.a.getAsyncAuthenticator(str, str2, str3) : (IAuthenticator) invokeLLL.objValue;
    }

    public static IAuthenticator getAuthenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? com.baidu.ar.auth.a.getAuthenticator() : (IAuthenticator) invokeV.objValue;
    }

    public static DuMixController getInstance(Context context, DefaultParams defaultParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, defaultParams)) == null) {
            if (context == null) {
                com.baidu.ar.h.b.b("DuMixController", "getInstance() context must be set!!!");
                return null;
            }
            if (aM == null) {
                synchronized (DuMixController.class) {
                    if (aM == null) {
                        aM = new DuMixController(context, defaultParams);
                    }
                }
            }
            return aM;
        }
        return (DuMixController) invokeLL.objValue;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? com.baidu.ar.auth.a.getOfflineAuthenticator() : (IOfflineAuthenticator) invokeV.objValue;
    }

    public static String getSoDownLoadDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? e.getSoDownLoadDir(context) : (String) invokeL.objValue;
    }

    public static int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? com.baidu.ar.h.c.getVersionCode() : invokeV.intValue;
    }

    public static String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? com.baidu.ar.h.c.getVersionName() : (String) invokeV.objValue;
    }

    public boolean addAbility(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? addAbility(str, str2, null) : invokeLL.booleanValue;
    }

    public boolean addAbility(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            b bVar = this.ad;
            if (bVar != null) {
                return bVar.a(str, Arrays.asList(str2), str3);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean addAbility(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list)) == null) {
            b bVar = this.ad;
            if (bVar != null) {
                return bVar.a(str, list, (String) null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, frameRenderListener) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.addFrameRenderListener(frameRenderListener);
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, luaMsgListener)) == null) {
            com.baidu.ar.lua.b bVar = this.f33889f;
            if (bVar == null || bVar.fk() == null) {
                return false;
            }
            return this.f33889f.fk().addLuaMsgListener(luaMsgListener);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void addOutput(DuMixOutput duMixOutput) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, duMixOutput) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.addOutputSurface(duMixOutput);
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, abilityType, hashMap)) == null) {
            if (this.ad == null || abilityType == null || aW != 2) {
                return false;
            }
            return this.ad.adjustAbility(abilityType.getTypeValue(), hashMap);
        }
        return invokeLL.booleanValue;
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, hashMap)) == null) {
            if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
                return false;
            }
            return this.ad.adjustAbility(str, hashMap);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            com.baidu.ar.h.b.c("DuMixController", "changeInputSize width * height = " + i2 + " * " + i3);
            Handler handler = this.aO;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_END_STAMP_KEY, i2, i3, null));
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i2, i3) == null) {
            com.baidu.ar.h.b.c("DuMixController", "changeInputSize width * height = " + i2 + " * " + i3 + " && texture = " + surfaceTexture);
            Handler handler = this.aO;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_END_STAMP_KEY, i2, i3, surfaceTexture));
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutput(DuMixOutput duMixOutput) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, duMixOutput) == null) || duMixOutput == null || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3007, duMixOutput));
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputObject(Object obj, int i2, int i3) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048587, this, obj, i2, i3) == null) || obj == null || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.b(obj, i2, i3);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            com.baidu.ar.h.b.c("DuMixController", "changeOutputSize width * height = " + i2 + " * " + i3);
            Handler handler = this.aO;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(3006, i2, i3));
            }
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bArr, iDuMixAuthCallback)) == null) ? ARAuth.checkAuth(this.mContext, bArr, iDuMixAuthCallback) : (List) invokeLL.objValue;
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, bArr, iCallbackWith, iCallbackWith2)) == null) ? ARAuth.checkAuth(this.mContext, bArr, iCallbackWith, iCallbackWith2) : (List) invokeLLL.objValue;
    }

    @Override // com.baidu.ar.filter.IFilter
    public void clearAllFilter() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.B != null && aW == 2) {
            this.B.clearAllFilter();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void clearCase() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3005));
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        e eVar;
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pixelReadParams, pixelReadListener) == null) {
            if ((aW == 0 || aW == 1) && (eVar = this.aR) != null) {
                eVar.a(pixelReadParams, pixelReadListener);
            } else if (aW != 2 || (cVar = this.f33890g) == null) {
            } else {
                cVar.createPixelReader(pixelReadParams, pixelReadListener);
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, pixelReadParams, pixelReadListener) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.destroyPixelReader(pixelReadParams, pixelReadListener);
    }

    public ARProxyManager getARProxyManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            b bVar = this.ad;
            if (bVar != null) {
                return bVar.getARProxyManager();
            }
            return null;
        }
        return (ARProxyManager) invokeV.objValue;
    }

    public l getARRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar == null || !(cVar instanceof l)) {
                return null;
            }
            return cVar;
        }
        return (l) invokeV.objValue;
    }

    public List<String> getActiveAbilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.ad == null || aW != 2) {
                return null;
            }
            return this.ad.getActiveAbilities();
        }
        return (List) invokeV.objValue;
    }

    public IContentPlatform getContentPlatform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.aV == null) {
                this.aV = (IContentPlatform) n.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.mContext});
            }
            return this.aV;
        }
        return (IContentPlatform) invokeV.objValue;
    }

    public IGLRenderer getGLRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar == null || !(cVar instanceof IGLRenderer)) {
                return null;
            }
            return (IGLRenderer) cVar;
        }
        return (IGLRenderer) invokeV.objValue;
    }

    public IStepLoading getStepLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            com.baidu.ar.arrender.c cVar = this.f33890g;
            if (cVar != null) {
                return cVar.bA();
            }
            return null;
        }
        return (IStepLoading) invokeV.objValue;
    }

    public List<String> getSupportedAbilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.ad == null || aW != 2) {
                return null;
            }
            return this.ad.getSupportedAbilities();
        }
        return (List) invokeV.objValue;
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, abilityType)) == null) {
            if (this.ad == null || abilityType == null || aW != 2) {
                return false;
            }
            return this.ad.isAbilityActive(abilityType.getTypeValue());
        }
        return invokeL.booleanValue;
    }

    public boolean isAbilityActive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
                return false;
            }
            return this.ad.isAbilityActive(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isAbilitySupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (this.ad == null || aW != 2) {
                return false;
            }
            return this.ad.isAbilitySupported(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(ARType aRType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048605, this, aRType, str, str2) == null) || this.aO == null) {
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str, str2);
        Handler handler = this.aO;
        handler.sendMessage(handler.obtainMessage(3004, caseModel));
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            loadCase(null, str, str2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, view, motionEvent)) == null) {
            if (this.f33890g == null || aW != 2) {
                return false;
            }
            return this.f33890g.onTouch(view, motionEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3001));
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.aU != null && aW == 2) {
            this.aU.pauseRecord();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void pauseScene() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY));
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            com.baidu.ar.h.b.c("DuMixController", "release() sState = " + aW);
            if (aW == 1) {
                com.baidu.ar.arrender.c cVar = this.f33890g;
                if (cVar == null || !cVar.bE()) {
                    synchronized (sLock) {
                        try {
                            com.baidu.ar.h.b.c("DuMixController", "release DuMixController wait for setup!");
                            sLock.wait(3000L);
                        } catch (Exception unused) {
                            com.baidu.ar.h.b.b("DuMixController", "release DuMixController wait error!!!");
                        }
                    }
                } else {
                    this.f33890g.q(true);
                    aW = 0;
                    aM = null;
                }
            }
            if (aW == 0) {
                aM = null;
            } else if (aW == 3) {
            } else {
                if (aW != 2) {
                    com.baidu.ar.h.b.b("DuMixController", "release error!!!");
                    return;
                }
                aW = 3;
                Handler handler = this.aO;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    Handler handler2 = this.aO;
                    handler2.sendMessage(handler2.obtainMessage(3003));
                }
                aM = null;
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, frameRenderListener) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.removeFrameRenderListener(frameRenderListener);
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, luaMsgListener)) == null) {
            com.baidu.ar.lua.b bVar = this.f33889f;
            if (bVar == null || bVar.fk() == null) {
                return false;
            }
            return this.f33889f.fk().removeLuaMsgListener(luaMsgListener);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.IDuMix
    public void removeOutput(DuMixOutput duMixOutput) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, duMixOutput) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.removeOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void resetAllFilter() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.B != null && aW == 2) {
            this.B.resetAllFilter();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3002));
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.aU != null && aW == 2) {
            this.aU.resumeRecord();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void resumeScene() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_START_STAMP_KEY));
    }

    public boolean sendLuaScript2Engine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            if (this.f33889f == null || aW != 2) {
                return false;
            }
            this.f33889f.aw(str);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, hashMap)) == null) {
            if (this.f33889f == null || aW != 2) {
                return false;
            }
            this.f33889f.b(1902, hashMap);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, aRRenderFpsCallback) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.setARRenderFpsCallback(aRRenderFpsCallback);
    }

    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048622, this, bArr, str, str2, str3) == null) {
            ARAuth.setAuthLicense(bArr, str, str2, str3);
        }
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, definedLuaListener) == null) {
            if (this.aS == null) {
                this.aS = new com.baidu.ar.lua.e(this.f33889f);
            }
            this.aS.setDefinedLuaListener(definedLuaListener);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void setFilterStateListener(FilterStateListener filterStateListener) {
        com.baidu.ar.filter.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, filterStateListener) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.setFilterStateListener(filterStateListener);
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, context, viewGroup) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.setGLWebViewUseable(context, viewGroup);
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, iLibLoaderPlugin) == null) {
            com.baidu.ar.libloader.a.setLibLoadPlugin(iLibLoaderPlugin);
        }
    }

    public void setMdlModelPath(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || (bVar = this.ad) == null) {
            return;
        }
        bVar.setMdlModelPath(str);
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048628, this, context, viewGroup) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.setNativeWebViewUseable(context, viewGroup);
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, watermark) == null) && aW == 2) {
            if (this.aU == null && this.f33890g != null) {
                this.aU = new com.baidu.ar.record.a(this.mContext, this.f33890g);
            }
            com.baidu.ar.record.a aVar = this.aU;
            if (aVar != null) {
                aVar.setRecordWatermark(watermark);
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setStateListener(DuMixStateListener duMixStateListener) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, duMixStateListener) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.setStateListener(duMixStateListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048631, this, duMixInput, duMixOutput, duMixCallback) == null) {
            com.baidu.ar.h.b.c("DuMixController", "setup() sState = " + aW);
            if (duMixInput == null || duMixOutput == null) {
                com.baidu.ar.h.b.b("DuMixController", "setup error!!! params maybe null!!!");
                if (duMixCallback != null) {
                    duMixCallback.onSetup(false, duMixInput, duMixOutput);
                    return;
                }
                return;
            }
            this.V = duMixInput;
            this.W = duMixOutput;
            this.aa = duMixCallback;
            Handler handler = this.aO;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(3000));
            }
        }
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, abilityType, hashMap)) == null) {
            if (this.ad == null || abilityType == null || aW != 2) {
                return false;
            }
            return this.ad.a(abilityType.getTypeValue(), hashMap, true);
        }
        return invokeLL.booleanValue;
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, str, hashMap)) == null) {
            if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
                return false;
            }
            return this.ad.a(str, hashMap, true);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j2, RecordCallback recordCallback) {
        DefaultParams defaultParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, Long.valueOf(j2), recordCallback}) == null) && aW == 2) {
            if (this.aU == null && this.f33890g != null) {
                this.aU = new com.baidu.ar.record.a(this.mContext, this.f33890g);
            }
            e eVar = this.aR;
            if (eVar != null) {
                eVar.k("start");
            }
            if (this.aU != null) {
                if (this.W != null && (defaultParams = this.f33888d) != null && defaultParams.isRecordAutoCrop()) {
                    this.aU.j(this.W.getOutputWidth(), this.W.getOutputHeight());
                }
                this.aU.startRecord(str, j2, recordCallback);
            }
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, abilityType)) == null) {
            if (this.ad == null || abilityType == null || aW != 2) {
                return false;
            }
            return this.ad.a(abilityType.getTypeValue(), true);
        }
        return invokeL.booleanValue;
    }

    public boolean stopAbility(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
            if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
                return false;
            }
            return this.ad.a(str, true);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && aW == 2) {
            com.baidu.ar.record.a aVar = this.aU;
            if (aVar != null) {
                aVar.stopRecord();
                this.aU = null;
            }
            e eVar = this.aR;
            if (eVar != null) {
                eVar.k(IntentConfig.STOP);
            }
        }
    }

    @Override // com.baidu.ar.photo.IPhoto
    public void takePicture(String str, PhotoCallback photoCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048638, this, str, photoCallback) == null) && this.f33890g != null && aW == 2) {
            new com.baidu.ar.photo.a().a(this.f33890g, str, photoCallback);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048639, this, filterParam, f2) == null) && this.B != null && aW == 2) {
            this.B.a(filterParam, Float.valueOf(f2));
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048640, this, filterParam, i2) == null) && this.B != null && aW == 2) {
            this.B.a(filterParam, Integer.valueOf(i2));
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048641, this, filterParam, str) == null) && this.B != null && aW == 2) {
            this.B.a(filterParam, str);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, List<Point> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048642, this, filterParam, list) == null) && list != null && aW == 2) {
            float[] fArr = new float[list.size() * 2];
            for (int i2 = 0; i2 < list.size(); i2++) {
                int i3 = i2 * 2;
                fArr[i3] = list.get(i2).x;
                fArr[i3 + 1] = list.get(i2).y;
            }
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.a(filterParam, Integer.valueOf(list.size()), "_count", false);
                this.B.a(filterParam, fArr);
            }
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048643, this, filterParam, fArr) == null) && this.B != null && aW == 2) {
            this.B.a(filterParam, fArr);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public String updateFilterCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) {
            if (this.B == null || aW != 2) {
                return null;
            }
            return this.B.updateFilterCase(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048645, this, pixelReadParams, pixelRotation) == null) || (cVar = this.f33890g) == null) {
            return;
        }
        cVar.updatePixelReader(pixelReadParams, pixelRotation);
    }
}
