package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arrender.i;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends e implements OrientationManager.OrientationListener, l {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean gS = true;
    public transient /* synthetic */ FieldHolder $fh;
    public b R;
    public a gI;
    public Runnable gJ;
    public o gK;
    public Runnable gL;
    public j gM;
    public Runnable gN;
    public m gO;
    public Runnable gP;
    public float gQ;
    public int gR;
    public int gT;
    public long gU;
    public long gV;
    public ARRenderFpsCallback gW;
    public List u;

    /* renamed from: com.baidu.ar.arrender.c$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass6 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] ha;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752705954, "Lcom/baidu/ar/arrender/c$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1752705954, "Lcom/baidu/ar/arrender/c$6;");
                    return;
                }
            }
            int[] iArr = new int[i.a.values().length];
            ha = iArr;
            try {
                iArr[i.a.hW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ha[i.a.hX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ha[i.a.hY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ha[i.a.hZ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void onInputSizeChange(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1642045456, "Lcom/baidu/ar/arrender/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1642045456, "Lcom/baidu/ar/arrender/c;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, looper, bVar, eGLContext, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, bVar, eGLContext, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Looper) objArr2[1], (com.baidu.ar.lua.b) objArr2[2], (EGLContext) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gR = 0;
        this.gT = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, String str) {
        this(context, looper, bVar, null, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, bVar, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Looper) objArr2[1], (com.baidu.ar.lua.b) objArr2[2], (EGLContext) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, cVar)) == null) {
            List list = this.u;
            return list == null || !list.contains(cVar.ab());
        }
        return invokeL.booleanValue;
    }

    private void bz() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.hy && (i = this.gR) >= 0) {
            if (i == 3) {
                this.hx.setEngineBlendState(0);
            } else if (i == 0) {
                this.hx.setEngineBlendState(1);
            }
            this.gR--;
        }
    }

    private boolean c(com.baidu.ar.ability.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, cVar)) == null) ? cVar.ac() && cVar.ad() != this.hn : invokeL.booleanValue;
    }

    private void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || this.f == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", 10200);
        hashMap.put("front_camera", Integer.valueOf(!z ? 1 : 0));
        this.f.b(1902, hashMap);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void L(String str) {
        super.L(str);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) || this.hx == null || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ar.ability.c cVar = new com.baidu.ar.ability.c();
        cVar.r(str);
        cVar.setTimestamp(AlgoHandleAdapter.getHandleTimeStamp(j));
        cVar.d(AlgoHandleAdapter.getHandleIsFront(j));
        cVar.c(AlgoHandleAdapter.getHandleEnableSync(j));
        if (a(cVar)) {
            return;
        }
        this.hx.setAlgoDataHandle(j);
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
    }

    @Override // com.baidu.ar.arrender.l
    public void a(PointF pointF, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, pointF, z) == null) {
            com.baidu.ar.arrender.b.a(pointF, z, this.V, this.W, this.hl);
        }
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(ARPDataInteraction.b bVar) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.setInteraction(bVar);
    }

    public void a(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, onNeedCacheFrameListener) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setOnNeedCacheFrameListener(onNeedCacheFrameListener);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(TakePictureCallback takePictureCallback) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, takePictureCallback) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().getSnapShot(takePictureCallback, this.W.getOutputWidth(), this.W.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.gI = aVar;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.R = bVar;
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
            if (this.hx == null || iVar == null || a((com.baidu.ar.ability.c) iVar) || this.hJ) {
                com.baidu.ar.h.b.b("ARRenderer", "updateFilterData error!!!");
                return;
            }
            int i = AnonymousClass6.ha[iVar.bS().ordinal()];
            if (i == 1) {
                this.hx.adjustFilterWithIntParam(iVar.getFilterName(), iVar.bQ(), ((Integer) iVar.bR()).intValue(), iVar.getTimestamp());
            } else if (i == 2) {
                this.hx.adjustFilterWithFloatParam(iVar.getFilterName(), iVar.bQ(), ((Float) iVar.bR()).floatValue(), iVar.getTimestamp());
            } else if (i == 3) {
                this.hx.adjustFilterWithFloatArrayParam(iVar.getFilterName(), iVar.bQ(), (float[]) iVar.bR(), iVar.getTimestamp());
            } else if (i != 4) {
                com.baidu.ar.h.b.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
            } else {
                this.hx.adjustFilterWithStringParam(iVar.getFilterName(), iVar.bQ(), (String) iVar.bR(), iVar.getTimestamp());
            }
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || jVar == null) {
                com.baidu.ar.h.b.b("ARRenderer", "updateFilterNodeData error!!!");
                return;
            }
            this.gM = jVar;
            if (this.gL == null) {
                this.gL = new Runnable(this) { // from class: com.baidu.ar.arrender.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c gX;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.gX = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        j jVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (jVar2 = this.gX.gM) == null || TextUtils.isEmpty(jVar2.getNodeName()) || this.gX.gM.bT() == null) {
                            return;
                        }
                        c cVar = this.gX;
                        if (cVar.hx == null || cVar.a((com.baidu.ar.ability.c) cVar.gM)) {
                            return;
                        }
                        c cVar2 = this.gX;
                        cVar2.hx.updateNodeUniform(cVar2.gM.getNodeName(), this.gX.gM.bT());
                    }
                };
            }
            this.hx.getARPRenderer().cancelAysncRenderTask(this.gL);
            this.hx.getARPRenderer().runAsyncOnRenderContext(this.gL);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mVar) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || mVar == null || a((com.baidu.ar.ability.c) mVar)) {
                com.baidu.ar.h.b.b("ARRenderer", "updateRenderCameraData error!!!");
                return;
            }
            this.gO = mVar;
            if (this.gN == null) {
                this.gN = new Runnable(this) { // from class: com.baidu.ar.arrender.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c gX;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.gX = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IARPScene currentScene;
                        IARPCamera activeCamera;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (currentScene = this.gX.hx.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                            return;
                        }
                        activeCamera.setViewMatrix(this.gX.gO.getMatrix());
                    }
                };
            }
            this.hx.getARPRenderer().cancelAysncRenderTask(this.gN);
            this.hx.getARPRenderer().runAsyncOnRenderContext(this.gN);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(o oVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, oVar, z) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || oVar == null || a(oVar)) {
                com.baidu.ar.h.b.b("ARRenderer", "updateRenderNodeData error!!!");
            } else if (!z) {
                this.hx.updateAlgoDataToNode(oVar.getWidth(), oVar.getHeight(), oVar.bZ());
            } else {
                this.gK = oVar;
                if (this.gJ == null) {
                    this.gJ = new Runnable(this) { // from class: com.baidu.ar.arrender.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ c gX;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.gX = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                c cVar = this.gX;
                                cVar.hx.updateAlgoDataToNode(cVar.gK.getWidth(), this.gX.gK.getHeight(), this.gX.gK.bZ());
                            }
                        }
                    };
                }
                this.hx.getARPRenderer().cancelAysncRenderTask(this.gJ);
                this.hx.getARPRenderer().runAsyncOnRenderContext(this.gJ);
            }
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(com.baidu.ar.imu.b bVar) {
        com.baidu.ar.arplay.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || (cVar = this.hA) == null) {
            return;
        }
        cVar.h(bVar.getTypeValue());
    }

    @Override // com.baidu.ar.arrender.f
    public void a(Object obj, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, obj, i, i2) == null) {
            super.a(obj, i, i2);
            a aVar = this.gI;
            if (aVar != null) {
                aVar.onInputSizeChange(i, i2);
            }
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(String str, Object obj) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, obj) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(new Runnable(this, str, obj) { // from class: com.baidu.ar.arrender.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c gX;
            public final /* synthetic */ String gY;
            public final /* synthetic */ Object gZ;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, obj};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.gX = this;
                this.gY = str;
                this.gZ = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.arrender.a aVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar = this.gX.hz) == null) {
                    return;
                }
                aVar.setDataPipKV(this.gY, this.gZ);
            }
        });
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    @Override // com.baidu.ar.arrender.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            com.baidu.ar.h.b.c("ARRenderer", "onCameraSwitch front = " + z);
            super.a(z);
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
                this.hx.getARPRenderer().setCameraFace(z);
            }
            ARPEngine aRPEngine2 = this.hx;
            if (aRPEngine2 != null) {
                aRPEngine2.setIsFrontCamera(z);
            }
            DuMixInput duMixInput = this.V;
            if (duMixInput != null && duMixInput.isCameraInput()) {
                this.V.setFrontCamera(z);
            }
            n(!z);
            bw();
            this.gR = 3;
        }
    }

    public boolean a(com.baidu.ar.ability.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cVar)) == null) ? !cVar.ae() && (b(cVar) || c(cVar)) : invokeL.booleanValue;
    }

    @Override // com.baidu.ar.arrender.l
    public void aJ() {
        com.baidu.ar.arplay.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (cVar = this.hA) == null) {
            return;
        }
        cVar.aJ();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        super.addFrameRenderListener(frameRenderListener);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addOutputSurface(DuMixOutput duMixOutput) {
        super.addOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.l
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.hx == null || i < 0) {
            return;
        }
        com.baidu.ar.h.b.c("ARRenderer", "addAlgoCache type = " + i + " && sync = " + z);
        this.hx.addAlgoType(new int[]{i}, z ? 1 : 0);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void b(Object obj, int i, int i2) {
        super.b(obj, i, i2);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ com.baidu.ar.steploading.d bA() {
        return super.bA();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void bB() {
        super.bB();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void bC() {
        super.bC();
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void bD() {
        super.bD();
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ boolean bE() {
        return super.bE();
    }

    public DuMixInput bt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.V : (DuMixInput) invokeV.objValue;
    }

    public DuMixOutput bu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.W : (DuMixOutput) invokeV.objValue;
    }

    @Override // com.baidu.ar.arrender.l
    public void bv() {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.disableCaseLutTexture();
    }

    @Override // com.baidu.ar.arrender.l
    public void bw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onRotateOrientation(OrientationManager.getGlobalOrientation());
        }
    }

    @Override // com.baidu.ar.arrender.l
    public String bx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mCasePath : (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.arrender.l
    public void by() {
        ARPEngine aRPEngine;
        IARPScene currentScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (aRPEngine = this.hx) == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
            return;
        }
        currentScene.relocate();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void cancelAysncRenderTask(Runnable runnable) {
        super.cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public void changeOutputSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
            super.changeOutputSize(i, i2);
            b bVar = this.R;
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.createPixelReader(pixelReadParams, pixelReadListener);
    }

    public void d(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, list) == null) {
            this.u = list;
        }
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.destroyPixelReader(pixelReadParams, pixelReadListener);
    }

    public void f(long j) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048618, this, j) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setAlgoPts(j);
    }

    @Override // com.baidu.ar.arrender.l
    public Matrixf4x4 getInitialTransform() {
        InterceptResult invokeV;
        IARPScene currentScene;
        IARPCamera activeCamera;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                return null;
            }
            return activeCamera.getInitialTransform();
        }
        return (Matrixf4x4) invokeV.objValue;
    }

    @Override // com.baidu.ar.arrender.l
    public void initWorldAxis() {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.initWorldAxis();
    }

    @Override // com.baidu.ar.arrender.l
    public boolean isDriverdByARPVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                return aRPEngine.isDriverdByARPVersion();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            com.baidu.ar.h.b.k("ARRenderer", "enableSyncRender enable = " + z);
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
                return;
            }
            this.hx.getARPRenderer().setSourceSyncProperty(z);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void k(boolean z) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
    }

    @Override // com.baidu.ar.arrender.l
    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048624, this, z)) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getCurrentScene() == null) {
                return false;
            }
            return this.hx.getCurrentScene().setVisible(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.ar.arrender.l
    public void m(boolean z) {
        com.baidu.ar.arplay.core.engine.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || (aVar = this.hd) == null) {
            return;
        }
        aVar.i(z);
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void o(boolean z) {
        super.o(z);
    }

    @Override // com.baidu.ar.arrender.e, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public /* bridge */ /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        super.onFrameAvailable(surfaceTexture);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            ARRenderFpsCallback aRRenderFpsCallback = this.gW;
            if (aRRenderFpsCallback != null && (aRRenderFpsCallback.listenType() & 2) != 0) {
                this.gW.onRenderFinished();
            }
            super.onRenderFinished(j);
            if (gS) {
                com.baidu.ar.h.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.gU));
            }
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderStartedListener
    public void onRenderStarted(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            ARRenderFpsCallback aRRenderFpsCallback = this.gW;
            if (aRRenderFpsCallback != null && (aRRenderFpsCallback.listenType() & 1) != 0) {
                this.gW.onRenderStarted();
            }
            if (gS) {
                if (this.gU != 0) {
                    com.baidu.ar.h.b.c("profile_frame_interval", "= " + (System.currentTimeMillis() - this.gU));
                    int i = this.gT;
                    if (i == 50) {
                        int i2 = (int) (50000 / this.gV);
                        com.baidu.ar.h.b.c("profile_frame_fps_avg", "= " + i2);
                        com.baidu.ar.h.b.c("profile_frame_interval_avg", "= " + (this.gV / 50));
                        this.gT = 0;
                        this.gV = 0L;
                        ARRenderFpsCallback aRRenderFpsCallback2 = this.gW;
                        if (aRRenderFpsCallback2 != null && (aRRenderFpsCallback2.listenType() & 4) != 0) {
                            this.gW.renderFps(i2);
                        }
                    } else {
                        this.gT = i + 1;
                        this.gV += System.currentTimeMillis() - this.gU;
                    }
                }
                this.gU = System.currentTimeMillis();
            }
            super.onRenderStarted(j);
            bz();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, orientation) == null) || this.f == null) {
            return;
        }
        com.baidu.ar.h.b.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
        this.f.b(4001, com.baidu.ar.arrender.b.a(orientation));
    }

    @Override // com.baidu.ar.arrender.e, android.view.View.OnTouchListener
    public /* bridge */ /* synthetic */ boolean onTouch(View view2, MotionEvent motionEvent) {
        return super.onTouch(view2, motionEvent);
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void p(boolean z) {
        super.p(z);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    public void pauseScene() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            com.baidu.ar.h.b.c("ARRenderer", "pauseScene()");
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                this.hC = true;
                aRPEngine.pauseScene();
            }
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048635, this, i) == null) || this.hx == null || i < 0) {
            return;
        }
        com.baidu.ar.h.b.c("ARRenderer", "removeAlgoCache type = " + i);
        this.hx.removeAlgoType(new int[]{i});
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void q(boolean z) {
        super.q(z);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.u = null;
            this.R = null;
            this.gI = null;
            this.gW = null;
            super.release();
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        super.removeFrameRenderListener(frameRenderListener);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void removeOutputSurface(DuMixOutput duMixOutput) {
        super.removeOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void render() {
        super.render();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    public void resumeScene() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            com.baidu.ar.h.b.c("ARRenderer", "resumeScene()");
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.resumeScene();
                this.hC = false;
            }
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void runAsyncOnRenderContext(Runnable runnable) {
        super.runAsyncOnRenderContext(runnable);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void runSyncOnRenderContext(Runnable runnable) {
        super.runSyncOnRenderContext(runnable);
    }

    @Override // com.baidu.ar.arrender.l
    public void sceneRotateToCamera() {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.sceneRotateToCamera();
    }

    @Override // com.baidu.ar.arrender.l
    public void sceneWorldPositionToOrigin() {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (aRPEngine = this.hx) == null) {
            return;
        }
        aRPEngine.sceneWorldPositionToOrigin();
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, aRRenderFpsCallback) == null) {
            this.gW = aRRenderFpsCallback;
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setCameraSwitchListener(g gVar) {
        super.setCameraSwitchListener(gVar);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setDefaultPipeLine(String str) {
        super.setDefaultPipeLine(str);
    }

    @Override // com.baidu.ar.arrender.l
    public void setFieldOfView(float f) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048650, this, f) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.gQ = f;
        if (this.gP == null) {
            this.gP = new Runnable(this) { // from class: com.baidu.ar.arrender.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c gX;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.gX = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IARPScene currentScene;
                    IARPCamera activeCamera;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (currentScene = this.gX.hx.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                        return;
                    }
                    activeCamera.setFieldOfView(this.gX.gQ);
                }
            };
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(this.gP);
        this.hx.getARPRenderer().runAsyncOnRenderContext(this.gP);
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        com.baidu.ar.arplay.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048651, this, context, viewGroup) == null) || (bVar = this.hB) == null) {
            return;
        }
        bVar.a(context, viewGroup, this);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setInputMatrix(float[] fArr) {
        super.setInputMatrix(fArr);
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void setLocalDeviceGrade(int i) {
        super.setLocalDeviceGrade(i);
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        com.baidu.ar.arplay.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048654, this, context, viewGroup) == null) || (bVar = this.hB) == null) {
            return;
        }
        bVar.b(context, viewGroup, null);
    }

    @Override // com.baidu.ar.arrender.l
    public void setOffScreenGuideWork(boolean z) {
        ARPEngine aRPEngine;
        IARPScene currentScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048655, this, z) == null) || (aRPEngine = this.hx) == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
            return;
        }
        currentScene.setOffScreenGuideWork(z);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setStateListener(DuMixStateListener duMixStateListener) {
        super.setStateListener(duMixStateListener);
    }

    @Override // com.baidu.ar.arrender.l
    public String updateFilterCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, str)) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                return aRPEngine.adjustFilterWithCasePathParam(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        super.updatePixelReader(pixelReadParams, pixelRotation);
    }
}
