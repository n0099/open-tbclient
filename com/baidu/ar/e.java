package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthCallback;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.n;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.c;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.filter.a B;
    public DuMixInput V;
    public DuMixOutput W;
    public DuMixCallback aa;
    public List<Integer> ab;
    public com.baidu.ar.lua.c ac;
    public b ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public CaseModel ah;
    public String ai;
    public String aj;
    public volatile boolean ak;
    public CaseModel al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public boolean ap;
    public boolean aq;
    public boolean ar;
    public a as;
    public ConcurrentHashMap<PixelReadParams, PixelReadListener> at;

    /* renamed from: d  reason: collision with root package name */
    public DefaultParams f33066d;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.ar.lua.b f33067f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.ar.arrender.c f33068g;
    public Context mContext;

    /* renamed from: com.baidu.ar.e$8  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass8 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] ax;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921041394, "Lcom/baidu/ar/e$8;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1921041394, "Lcom/baidu/ar/e$8;");
                    return;
                }
            }
            int[] iArr = new int[ARType.values().length];
            ax = iArr;
            try {
                iArr[ARType.IMU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ax[ARType.TRACK_2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ax[ARType.CLOUD_IR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ax[ARType.ON_DEVICE_IR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                ax[ARType.VO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e au;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
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
            this.au = eVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 4001:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_CREATE_CASE");
                        CaseModel caseModel = (CaseModel) message.obj;
                        this.au.c(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                        return;
                    case 4002:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_DESTROY_CASE");
                        this.au.J();
                        return;
                    case 4003:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CREATE");
                        this.au.K();
                        return;
                    case 4004:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CHANGE");
                        this.au.c((List) ((HashMap) message.obj).get("filter_name_list"));
                        return;
                    case 4005:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_CREATE");
                        this.au.L();
                        return;
                    case 4006:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_DESTROY");
                        this.au.M();
                        return;
                    case 4007:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_CREATE");
                        this.au.N();
                        return;
                    case 4008:
                        com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_DESTROY");
                        this.au.O();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public e(Context context, DefaultParams defaultParams, HandlerThread handlerThread) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, defaultParams, handlerThread};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ak = false;
        this.am = false;
        this.an = true;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.ar = true;
        this.mContext = context;
        this.f33066d = defaultParams;
        this.as = new a(this, handlerThread.getLooper());
        this.at = new ConcurrentHashMap<>();
    }

    private void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.ab = Arrays.asList(12, 50, 6, 7, 8, 9);
            com.baidu.ar.lua.c cVar = new com.baidu.ar.lua.c(this) { // from class: com.baidu.ar.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e au;

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
                    this.au = this;
                }

                @Override // com.baidu.ar.lua.c
                public void a(int i2, int i3, HashMap<String, Object> hashMap) {
                    a aVar;
                    a aVar2;
                    int i4;
                    Message message;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, hashMap) == null) {
                        com.baidu.ar.h.b.c("ControllerHelper", "onEngineMessage msgType = " + i2 + " && msgId = " + i3);
                        if (i2 != 12) {
                            if (i2 == 50) {
                                if (this.au.as != null) {
                                    aVar = this.au.as;
                                    message = this.au.as.obtainMessage(4004, hashMap);
                                    aVar.sendMessage(message);
                                }
                                return;
                            }
                            switch (i2) {
                                case 6:
                                    if (this.au.as != null) {
                                        aVar = this.au.as;
                                        aVar2 = this.au.as;
                                        i4 = 4005;
                                        break;
                                    } else {
                                        return;
                                    }
                                case 7:
                                    if (this.au.as != null) {
                                        aVar = this.au.as;
                                        aVar2 = this.au.as;
                                        i4 = 4006;
                                        break;
                                    } else {
                                        return;
                                    }
                                case 8:
                                    this.au.f33068g.bw();
                                    if (this.au.as != null) {
                                        aVar = this.au.as;
                                        aVar2 = this.au.as;
                                        i4 = 4007;
                                        break;
                                    } else {
                                        return;
                                    }
                                case 9:
                                    if (this.au.as != null) {
                                        aVar = this.au.as;
                                        aVar2 = this.au.as;
                                        i4 = 4008;
                                        break;
                                    } else {
                                        return;
                                    }
                                default:
                                    return;
                            }
                        } else if (this.au.as == null) {
                            return;
                        } else {
                            aVar = this.au.as;
                            aVar2 = this.au.as;
                            i4 = 4003;
                        }
                        message = aVar2.obtainMessage(i4);
                        aVar.sendMessage(message);
                    }
                }

                @Override // com.baidu.ar.lua.c
                public List<Integer> n() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.au.ab : (List) invokeV.objValue;
                }
            };
            this.ac = cVar;
            com.baidu.ar.lua.b bVar = this.f33067f;
            if (bVar != null) {
                bVar.c(cVar);
            }
        }
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.ar.libloader.a.load(this.mContext, new ILibLoader.b(this) { // from class: com.baidu.ar.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e au;

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
                    this.au = this;
                }

                @Override // com.baidu.ar.libloader.ILibLoader.b
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }
            });
        }
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ARAuth.loadAuthInfo(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        Bitmap createTipBitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f33068g == null || this.W == null || (createTipBitmap = ARAuth.createTipBitmap(this.mContext)) == null) {
            return;
        }
        float outputWidth = ((this.W.getOutputWidth() * createTipBitmap.getHeight()) * 0.78125f) / (this.W.getOutputHeight() * createTipBitmap.getWidth());
        this.f33068g.a(createTipBitmap, 0.109375f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.ad == null) {
            return;
        }
        if (this.ao && this.al != null && I()) {
            this.ad.g();
        } else {
            this.ad.f();
        }
    }

    private boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            ARType aRType = this.al.mCaseType;
            return (aRType == null || aRType == ARType.FACE) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            H();
            com.baidu.ar.arrender.c cVar = this.f33068g;
            if (cVar != null) {
                cVar.bB();
            }
            StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.bv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.ae = true;
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null && !this.ap) {
                aVar.eE();
            }
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            b bVar = this.ad;
            if (bVar != null) {
                bVar.e();
            }
            com.baidu.ar.arrender.c cVar = this.f33068g;
            if (cVar != null) {
                cVar.o(true);
            }
            this.af = true;
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        DuMixCallback duMixCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (duMixCallback = this.aa) == null) {
            return;
        }
        duMixCallback.onRelease();
        this.aa = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.am = true;
            this.ap = false;
            b bVar = this.ad;
            if (bVar != null) {
                bVar.onCaseCreate(this.ai + File.separator + "ar");
            }
            if ((this.ao || this.aq) && (aVar = this.as) != null) {
                aVar.removeMessages(4002);
                a aVar2 = this.as;
                aVar2.sendMessage(aVar2.obtainMessage(4002));
            } else {
                this.an = true;
            }
            DuMixCallback duMixCallback = this.aa;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(true, this.ai, this.aj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        CaseModel caseModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.am = false;
            H();
            b bVar = this.ad;
            if (bVar != null) {
                bVar.onCaseDestroy();
            }
            if (!this.ao || (caseModel = this.al) == null || this.as == null) {
                this.an = true;
                this.ai = null;
                this.aj = null;
                com.baidu.ar.filter.a aVar = this.B;
                if (aVar != null) {
                    aVar.am(null);
                }
            } else {
                this.ap = true;
                CaseModel caseModel2 = new CaseModel(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                this.as.removeMessages(4001);
                a aVar2 = this.as;
                aVar2.sendMessageDelayed(aVar2.obtainMessage(4001, caseModel2), 100L);
            }
            this.al = null;
            this.ao = false;
            this.aq = false;
            DuMixCallback duMixCallback = this.aa;
            if (duMixCallback != null) {
                duMixCallback.onCaseDestroy();
            }
        }
    }

    private void P() {
        DuMixCallback duMixCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.ae && this.af && !this.ag && (duMixCallback = this.aa) != null) {
            this.ag = true;
            duMixCallback.onSetup(true, this.V, this.W);
        }
    }

    private void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("continuous_mapping", m("interaction_plane_move"));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("limit_radius", 1);
            hashMap2.put("radius_min", Float.valueOf(0.0f));
            hashMap2.put("radius_max", Float.valueOf(3000.0f));
            hashMap2.put("limit_step_length", 1);
            hashMap2.put("step_length", Float.valueOf(80.0f));
            hashMap2.put("limit_far_frustum", 1);
            hashMap2.put("move_leave_callback", 1);
            hashMap.put("plane_move_config", hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("limit_world_axis", 1);
            hashMap3.put("world_axis", "y");
            hashMap.put("rotate_config", hashMap3);
            HashMap hashMap4 = new HashMap();
            hashMap4.put("limit_distance_factor", 1);
            hashMap.put("scale_config", hashMap4);
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("continuous_mapping", m("interaction_space_move"));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("limit_radius_invariant", Integer.valueOf(i2));
            hashMap.put("space_move_config", hashMap2);
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
        }
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, this, str, str2, str3) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str2, str3);
            hashMap.put("event_data", hashMap2);
            com.baidu.ar.lua.b bVar = this.f33067f;
            if (bVar != null) {
                bVar.b(1902, hashMap);
            }
        }
    }

    private void b(ARType aRType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, aRType) == null) {
            int i2 = AnonymousClass8.ax[aRType.ordinal()];
            if (i2 == 1) {
                a(1);
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                a(0);
            } else if (i2 != 5) {
            } else {
                Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        a aVar;
        Message obtainMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, this, aRType, str, str2) == null) {
            com.baidu.ar.h.b.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.an + " && mCaseSwitched = " + this.ao);
            if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
                com.baidu.ar.h.b.b("ControllerHelper", "casePath is empty!!!");
                DuMixCallback duMixCallback = this.aa;
                if (duMixCallback != null) {
                    duMixCallback.onCaseCreate(false, str, str2);
                }
            } else if (this.ak) {
                com.baidu.ar.h.b.b("ControllerHelper", "auth rejected");
            } else {
                CaseModel caseModel = new CaseModel(aRType, str + File.separator + "ar", str2);
                if (this.an) {
                    this.an = false;
                    com.baidu.ar.h.b.c("ControllerHelper", "executeLoadCase mCaseLoaded = " + this.am);
                    if (this.am) {
                        this.al = caseModel;
                        this.ao = true;
                        aVar = this.as;
                        obtainMessage = aVar.obtainMessage(4002);
                    } else {
                        aVar = this.as;
                        obtainMessage = aVar.obtainMessage(4001, caseModel);
                    }
                    aVar.sendMessage(obtainMessage);
                } else {
                    this.al = caseModel;
                    this.ao = true;
                }
                this.aq = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, this, aRType, str, str2) == null) {
            if (this.ak) {
                com.baidu.ar.h.b.b("ControllerHelper", "handleCreateCase ignored; auth rejected");
                return;
            }
            if (aRType != null) {
                ARConfig.setARType(aRType.getTypeValue());
                b(aRType);
            }
            ARConfig.setARKey(str2);
            if (this.ar) {
                this.ar = false;
                StatisticApi.onEvent(StatisticConstants.EVENT_CASE_FIRST);
            }
            StatisticApi.onEventStart(StatisticConstants.EVENT_CASE_START);
            if (this.f33068g != null && !TextUtils.isEmpty(str)) {
                String substring = str.substring(0, str.lastIndexOf(File.separator + "ar"));
                this.ai = substring;
                this.aj = str2;
                com.baidu.ar.filter.a aVar = this.B;
                if (aVar != null) {
                    aVar.am(substring);
                }
                if (this.f33066d.isUseInputSizeInEngine() || aRType == ARType.FACE || aRType == ARType.VPAS) {
                    this.f33068g.p(false);
                } else {
                    this.f33068g.p(true);
                }
                this.f33068g.L(str);
            }
            if (aRType == null || (bVar = this.ad) == null) {
                return;
            }
            bVar.a(aRType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        com.baidu.ar.filter.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, list) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.f(list);
    }

    public static String getSoDownLoadDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                com.baidu.ar.h.b.b("ControllerHelper", "get so download dir error");
                return null;
            }
            File file = new File(context.getFilesDir(), "arlibs");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    private HashMap<String, Object> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, this, str)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("gesture_scroll", str);
            hashMap.put("gesture_two_finger_scroll", "interaction_rotate");
            hashMap.put("gesture_two_finger_pinch", "interaction_scale_down");
            hashMap.put("gesture_two_finger_unpinch", "interaction_scale_up");
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public void A() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.as) == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ARAuth.doAuth(this.mContext, new IAuthCallback(this) { // from class: com.baidu.ar.e.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e au;
                public boolean aw;

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
                    this.au = this;
                    this.aw = false;
                }

                @Override // com.baidu.ar.auth.IAuthCallback
                public void onError(String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                        com.baidu.ar.h.b.b("ControllerHelper", String.format("auth fail feature: %d msg: %s", Integer.valueOf(i2), str));
                        if (i2 == 0) {
                            this.au.ak = true;
                            if (this.au.as != null) {
                                this.au.as.sendMessage(this.au.as.obtainMessage(4002));
                            }
                        }
                        if (this.aw || !ARAuth.isShowAuthTip()) {
                            return;
                        }
                        this.aw = true;
                        this.au.G();
                    }
                }

                @Override // com.baidu.ar.auth.IAuthCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.baidu.ar.h.b.c("ControllerHelper", "auth success");
                    }
                }
            });
        }
    }

    public void F() {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (concurrentHashMap = this.at) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<PixelReadParams, PixelReadListener> entry : this.at.entrySet()) {
            this.f33068g.createPixelReader(entry.getKey(), entry.getValue());
        }
        this.at.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.baidu.ar.libloader.ILibLoader] */
    public void a(DuMixController duMixController) {
        com.baidu.ar.libloader.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, duMixController) == null) {
            String soDownLoadDir = getSoDownLoadDir(this.mContext);
            Object a2 = n.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
            if (a2 != null) {
                cVar = (ILibLoader) a2;
            } else if (TextUtils.isEmpty(soDownLoadDir) || com.baidu.ar.libloader.a.isRegistered()) {
                com.baidu.ar.libloader.a.fg();
                return;
            } else {
                com.baidu.ar.libloader.c cVar2 = new com.baidu.ar.libloader.c(soDownLoadDir);
                cVar2.a(new c.a(this) { // from class: com.baidu.ar.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ e au;

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
                        this.au = this;
                    }

                    @Override // com.baidu.ar.libloader.c.a
                    public void a(String str, String str2) {
                        DuMixCallback duMixCallback;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) || (duMixCallback = this.au.aa) == null) {
                            return;
                        }
                        duMixCallback.onError(DuMixErrorType.LibraryError, str2, str);
                    }
                });
                cVar = cVar2;
            }
            com.baidu.ar.libloader.a.a(cVar);
        }
    }

    public void a(com.baidu.ar.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.a(new ICallbackWith<String>(this) { // from class: com.baidu.ar.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e au;

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
                this.au = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: n */
            public void run(String str) {
                DuMixCallback duMixCallback;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || (duMixCallback = this.au.aa) == null) {
                    return;
                }
                duMixCallback.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
            }
        });
        bVar.b(new ICallbackWith<JSONObject>(this, bVar) { // from class: com.baidu.ar.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e au;
            public final /* synthetic */ com.baidu.ar.a.b av;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.au = this;
                this.av = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b */
            public void run(JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) || this.au.f33068g == null) {
                    return;
                }
                if (jSONObject != null) {
                    this.au.f33068g.a(jSONObject);
                } else if (this.av != null) {
                    this.au.f33068g.setLocalDeviceGrade(this.av.ag());
                }
            }
        });
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, pixelReadParams, pixelReadListener) == null) || (concurrentHashMap = this.at) == null) {
            return;
        }
        concurrentHashMap.put(pixelReadParams, pixelReadListener);
    }

    public void a(com.baidu.ar.arrender.c cVar, b bVar, com.baidu.ar.filter.a aVar, com.baidu.ar.lua.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, cVar, bVar, aVar, bVar2) == null) {
            this.f33068g = cVar;
            this.ad = bVar;
            this.B = aVar;
            this.f33067f = bVar2;
        }
    }

    public void clearCase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.ar.h.b.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.an + " && mCaseLoaded = " + this.am);
            if (this.an && this.am) {
                this.an = false;
                a aVar = this.as;
                if (aVar != null) {
                    aVar.sendMessage(aVar.obtainMessage(4002));
                }
            } else {
                this.al = null;
                this.aq = true;
            }
            this.ah = null;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            a("recorder_video", "msg", str);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            a("dumix_system_message", "system_message", str);
        }
    }

    public void loadCase(ARType aRType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, aRType, str, str2) == null) {
            if (this.ak) {
                com.baidu.ar.h.b.b("ControllerHelper", "auth rejected");
                return;
            }
            CaseModel caseModel = new CaseModel(aRType, str, str2);
            CaseModel caseModel2 = this.ah;
            if (caseModel2 == null || !caseModel.equals(caseModel2)) {
                this.ah = caseModel;
                com.baidu.ar.libloader.a.prepareCaseRes(aRType, str, str2, new ILibLoader.a(this) { // from class: com.baidu.ar.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ e au;

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
                        this.au = this;
                    }

                    @Override // com.baidu.ar.libloader.ILibLoader.a
                    public void a(ARType aRType2, String str3, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, aRType2, str3, str4) == null) {
                            this.au.b(aRType2, str3, str4);
                        }
                    }
                });
                return;
            }
            com.baidu.ar.h.b.c("ControllerHelper", "loadCase() case has loaded!!!");
            DuMixCallback duMixCallback = this.aa;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(true, str, str2);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.at;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
                this.at = null;
            }
            this.f33068g = null;
            this.ad = null;
            this.B = null;
            this.V = null;
            this.W = null;
            this.mContext = null;
            this.f33066d = null;
            this.ab = null;
            this.ac = null;
            this.f33067f = null;
            this.as = null;
        }
    }

    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, duMixInput, duMixOutput, duMixCallback) == null) {
            this.V = duMixInput;
            this.W = duMixOutput;
            this.aa = duMixCallback;
            B();
            D();
            C();
        }
    }
}
