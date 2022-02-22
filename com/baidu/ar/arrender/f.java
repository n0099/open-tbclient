package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.ARPEngineParams;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class f implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixInput V;
    public DuMixOutput W;
    public String aG;
    public String aL;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.ar.lua.b f33048f;
    public com.baidu.ar.arplay.a.c hA;
    public com.baidu.ar.arplay.d.b hB;
    public boolean hC;
    public String hD;
    public int hE;
    public Size hF;
    public EGLContext hG;
    public DuMixStateListener hH;
    public boolean hI;
    public boolean hJ;
    public volatile boolean hK;
    public volatile boolean hL;
    public p ht;
    public boolean hu;
    public boolean hv;
    public long hw;
    public ARPEngine hx;
    public volatile boolean hy;
    public a hz;
    public String mCasePath;
    public Context mContext;

    public f(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, eGLContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hu = false;
        this.hv = false;
        this.hw = 0L;
        this.aG = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
        this.hy = false;
        this.mCasePath = null;
        this.aL = null;
        this.hG = null;
        this.hI = false;
        this.hJ = false;
        this.hK = false;
        this.hL = false;
        com.baidu.ar.h.b.c("AbstractRenderer", "create start!!!");
        com.baidu.ar.libloader.a.require(SwanKV.LIB_CPP_SHARED);
        com.baidu.ar.libloader.a.require("opencv_java3");
        com.baidu.ar.libloader.a.require("EglCore");
        this.mContext = context;
        this.f33048f = bVar;
        this.hG = eGLContext;
        this.hA = new com.baidu.ar.arplay.a.c(context);
        this.hB = com.baidu.ar.arplay.d.b.bm();
        this.hz = new a(context);
        com.baidu.ar.statistic.p.b(this.f33048f);
        this.aL = str;
        ARPEngine aRPEngine = ARPEngine.getInstance();
        this.hx = aRPEngine;
        aRPEngine.setContext(new SoftReference<>(context));
        com.baidu.ar.h.b.c("AbstractRenderer", "create end!!!");
    }

    private void M(String str) {
        com.baidu.ar.arplay.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || (bVar = this.hB) == null) {
            return;
        }
        bVar.J(str);
        File file = new File(str, "res/webview");
        if (file.exists()) {
            File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
            com.baidu.ar.h.i.b(file2);
            com.baidu.ar.h.i.a(file, file2, true);
        }
    }

    private void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65538, this, surfaceTexture, i2, i3, i4) == null) {
            int textureId = this.hx.getARPRenderer().getTextureId(this.hx.getARPRenderer().createTexture(i2, i3, i4));
            surfaceTexture.setOnFrameAvailableListener(this);
            this.hx.getARPRenderer().setInputTexture(i2, textureId, i3, i4);
            try {
                surfaceTexture.detachFromGLContext();
            } catch (Exception unused) {
                com.baidu.ar.h.b.l("AbstractRenderer", "attachInputSurface surfaceTexture.detachFromGLContext() fail!!!");
            }
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable(this, surfaceTexture, textureId) { // from class: com.baidu.ar.arrender.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SurfaceTexture hM;
                public final /* synthetic */ int hN;
                public final /* synthetic */ f hO;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surfaceTexture, Integer.valueOf(textureId)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.hO = this;
                    this.hM = surfaceTexture;
                    this.hN = textureId;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.hM.attachToGLContext(this.hN);
                            this.hO.hL = true;
                            this.hM.updateTexImage();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            surfaceTexture.setDefaultBufferSize(i3, i4);
            DuMixStateListener duMixStateListener = this.hH;
            if (duMixStateListener != null) {
                duMixStateListener.onInputSurfaceTextureAttach(surfaceTexture);
            }
        }
    }

    private Surface b(DuMixOutput duMixOutput, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, duMixOutput, obj)) == null) {
            Object outputSurface = duMixOutput.getOutputSurface();
            if (obj == null) {
                obj = outputSurface;
            }
            if (obj == null) {
                bH();
                this.hv = true;
            }
            Surface surface = null;
            if (obj instanceof SurfaceHolder) {
                SurfaceHolder surfaceHolder = (SurfaceHolder) obj;
                surface = surfaceHolder.getSurface();
                duMixOutput.setOutputSurface(surfaceHolder);
            } else if (obj instanceof SurfaceTexture) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
                surfaceTexture.setDefaultBufferSize(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
                surface = new Surface(surfaceTexture);
                duMixOutput.setOutputSurface(surfaceTexture);
            } else if (obj instanceof Surface) {
                surface = (Surface) obj;
                duMixOutput.setOutputSurface(surface);
            }
            if (surface == null) {
                com.baidu.ar.h.b.b("AbstractRenderer", "initOutputSurface outputSurface error!!!");
            }
            return surface;
        }
        return (Surface) invokeLL.objValue;
    }

    private void b(DuMixInput duMixInput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, duMixInput) == null) {
            this.hx.getARPRenderer().setUpEGLEnv(this.hG);
            this.hx.getARPRenderer().setCameraFace(duMixInput.isFrontCamera());
            PixelRotation a = b.a(duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), duMixInput.getMirriorType());
            com.baidu.ar.arplay.core.engine.e eVar = com.baidu.ar.arplay.core.engine.e.fH;
            if ((duMixInput.getInputTexture() != null && duMixInput.getInputTexture().getType() == 36197) || (duMixInput.getInputSurface() != null && duMixInput.isCameraInput())) {
                eVar = com.baidu.ar.arplay.core.engine.e.fG;
            }
            if (duMixInput.isSyncInputContent()) {
                this.hx.getARPRenderer().createSyncInputSource(a, eVar);
            } else {
                this.hx.getARPRenderer().createInputSource(a, eVar);
            }
            Size a2 = a(this.V);
            this.hx.setPreviewSize(a2.getWidth(), a2.getHeight());
        }
    }

    private void bH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable(this) { // from class: com.baidu.ar.arrender.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f hO;

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
                    this.hO = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int createTexture = (int) this.hO.hx.getARPRenderer().createTexture(3553, this.hO.W.getOutputWidth(), this.hO.W.getOutputHeight());
                        com.baidu.ar.h.b.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                        this.hO.W.setOutputSurface(new SurfaceTexture(createTexture));
                    }
                }
            });
        }
    }

    private void bK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.hx.getARPRenderer().connectCameraWithTarget();
        }
    }

    private void bL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.hx.getARPRenderer().runLuaScriptStr(this.aG);
        }
    }

    private void bM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
                this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable(this) { // from class: com.baidu.ar.arrender.f.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f hO;

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
                        this.hO = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.hO.V == null || this.hO.V.getInputSurface() == null) {
                                    return;
                                }
                                this.hO.hL = false;
                                this.hO.V.getInputSurface().detachFromGLContext();
                            } catch (Exception unused) {
                                com.baidu.ar.h.b.k("AbstractRenderer", "releaseInput() surfaceTexture.detachFromGLContext() fail!!!");
                            }
                        }
                    }
                });
            }
            DuMixInput duMixInput = this.V;
            if (duMixInput != null && duMixInput.getInputSurface() != null) {
                this.V.getInputSurface().setOnFrameAvailableListener(null);
                if (this.hu) {
                    this.V.getInputSurface().release();
                }
            }
            ARPEngine aRPEngine2 = this.hx;
            if (aRPEngine2 == null || aRPEngine2.getARPRenderer() == null || this.hw <= 0) {
                return;
            }
            this.hx.getARPRenderer().destroyTexture(this.hw);
        }
    }

    private void bN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            DuMixOutput duMixOutput = this.W;
            if (duMixOutput != null && duMixOutput.getOutputSurface() != null && this.hv) {
                ((SurfaceTexture) this.W.getOutputSurface()).release();
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.ht == null) {
                return;
            }
            this.hx.getARPRenderer().removeOutputTargetByAddr(this.ht.ca());
        }
    }

    private void bO() {
        ARPEngine aRPEngine;
        IARPRenderer aRPRenderer;
        String ca;
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || this.ht == null) {
            return;
        }
        if (com.baidu.ar.h.p.A(this.mContext)) {
            aRPRenderer = this.hx.getARPRenderer();
            ca = this.ht.ca();
            pixelRotation = PixelRotation.RotateLeft;
        } else {
            aRPRenderer = this.hx.getARPRenderer();
            ca = this.ht.ca();
            pixelRotation = PixelRotation.NoRotation;
        }
        aRPRenderer.updateOutputSurfaceRotation(ca, pixelRotation);
    }

    private SurfaceTexture c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65548, this, i2, i3, i4)) == null) {
            this.hw = this.hx.getARPRenderer().createTexture(i2, i3, i4);
            int textureId = this.hx.getARPRenderer().getTextureId(this.hw);
            SurfaceTexture surfaceTexture = new SurfaceTexture(textureId);
            surfaceTexture.setDefaultBufferSize(i3, i4);
            surfaceTexture.setOnFrameAvailableListener(this);
            this.hx.getARPRenderer().setInputTexture(i2, textureId, i3, i4);
            this.hL = true;
            return surfaceTexture;
        }
        return (SurfaceTexture) invokeIII.objValue;
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "createCase() casePath = " + str);
            a aVar = this.hz;
            if (aVar != null) {
                aVar.bq();
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.loadCaseWithResPath(str);
                DuMixOutput duMixOutput = this.W;
                if (duMixOutput != null) {
                    changeOutputSize(duMixOutput.getOutputWidth(), this.W.getOutputHeight());
                }
            }
            this.mCasePath = str;
            M(str);
        }
    }

    public Size a(DuMixInput duMixInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, duMixInput)) == null) {
            if (duMixInput == null) {
                com.baidu.ar.h.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
                return null;
            }
            Size size = this.hF;
            if (size == null || size.getWidth() == 0 || this.hF.getHeight() == 0) {
                Size size2 = new Size(duMixInput.getInputHeight(), duMixInput.getInputWidth());
                if (!duMixInput.isCameraInput() && (duMixInput.getRotationType() == RotationType.ROTATE_0 || duMixInput.getRotationType() == RotationType.ROTATE_180)) {
                    size2.setWidth(duMixInput.getInputWidth());
                    size2.setHeight(duMixInput.getInputHeight());
                }
                return size2;
            }
            return this.hF;
        }
        return (Size) invokeL.objValue;
    }

    public Size a(Size size, DuMixOutput duMixOutput) {
        InterceptResult invokeLL;
        int width;
        int height;
        int outputWidth;
        int outputHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, size, duMixOutput)) == null) {
            if (com.baidu.ar.h.p.A(this.mContext)) {
                width = size.getWidth();
                height = size.getHeight();
                outputWidth = duMixOutput.getOutputHeight();
                outputHeight = duMixOutput.getOutputWidth();
            } else {
                width = size.getWidth();
                height = size.getHeight();
                outputWidth = duMixOutput.getOutputWidth();
                outputHeight = duMixOutput.getOutputHeight();
            }
            return b.b(width, height, outputWidth, outputHeight);
        }
        return (Size) invokeLL.objValue;
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, duMixInput, duMixOutput) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "setup() start");
            if (duMixInput == null || duMixOutput == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
                return;
            }
            this.V = duMixInput;
            this.W = duMixOutput;
            b(duMixInput);
            c(duMixInput);
            a(duMixOutput, (Object) null);
            bF();
            bK();
            bI();
            com.baidu.ar.h.b.c("AbstractRenderer", "setup() end");
        }
    }

    public void a(DuMixOutput duMixOutput, Object obj) {
        Surface b2;
        String addOutputSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, duMixOutput, obj) == null) {
            if (duMixOutput.getOutputTexture() == null || duMixOutput.getOutputTexture().getId() == -1) {
                b2 = b(duMixOutput, obj);
                addOutputSurface = this.hx.getARPRenderer().addOutputSurface(b2, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
            } else {
                addOutputSurface = this.hx.getARPRenderer().addOutputTarget(duMixOutput.getOutputTexture().getType(), duMixOutput.getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(this.W.getRotationType(), this.W.getMirriorType()));
                b2 = null;
            }
            p pVar = new p(duMixOutput);
            this.ht = pVar;
            pVar.setSurface(b2);
            this.ht.Q(addOutputSurface);
            if (duMixOutput.isFitScreenAuto()) {
                bO();
            }
            Size a = a(a(this.V), this.W);
            this.hx.setWindowSize(a.getWidth(), a.getHeight());
        }
    }

    public void a(Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, obj, i2, i3) == null) || this.V == null || this.hx == null) {
            return;
        }
        bM();
        this.V.setInputWidth(i2);
        this.V.setInputHeight(i3);
        if (obj != null && (obj instanceof SurfaceTexture)) {
            this.V.setInputSurface((SurfaceTexture) obj);
        }
        c(this.V);
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || this.hx == null || jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        this.hD = jSONObject2;
        try {
            this.hx.setConfig("grading", jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public void b(Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, obj, i2, i3) == null) {
            if (obj == null || i2 <= 0 || i3 <= 0 || this.W == null || !this.hy) {
                com.baidu.ar.h.b.b("AbstractRenderer", "changeOutputSurface error!!!");
                return;
            }
            bN();
            if (obj instanceof SurfaceTexture) {
                this.W.setOutputSurface((SurfaceTexture) obj);
            } else if (obj instanceof SurfaceHolder) {
                this.W.setOutputSurface((SurfaceHolder) obj);
            } else if (!(obj instanceof Surface)) {
                com.baidu.ar.h.b.b("AbstractRenderer", "changeOutputSurface error!!! As outputSurface is not a surface!!!");
                return;
            } else {
                this.W.setOutputSurface((Surface) obj);
            }
            this.W.setOutputWidth(i2);
            this.W.setOutputHeight(i3);
            a(this.W, obj);
        }
    }

    public void bB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "destroyCase()");
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.unloadCase();
            }
            bL();
            ARPEngine aRPEngine2 = this.hx;
            if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
                this.hx.getARPRenderer().purgeMemory();
            }
            this.mCasePath = null;
            com.baidu.ar.arplay.d.b bVar = this.hB;
            if (bVar != null) {
                bVar.J(null);
            }
        }
    }

    public void bC() {
        DuMixInput duMixInput;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "startARPEngine()");
            if (this.hx == null) {
                this.hx = ARPEngine.getInstance();
            }
            if (this.hx != null && (duMixInput = this.V) != null && this.W != null) {
                Size a = a(duMixInput);
                Size a2 = a(a, this.W);
                ARPEngineParams aRPEngineParams = new ARPEngineParams();
                aRPEngineParams.setInputWidth(a.getWidth());
                aRPEngineParams.setInputHeight(a.getHeight());
                aRPEngineParams.setOutputWidth(a2.getWidth());
                aRPEngineParams.setOutputHeight(a2.getHeight());
                aRPEngineParams.setDensity(com.baidu.ar.h.p.z(this.mContext));
                if (this.V.isCameraInput()) {
                    aRPEngineParams.setIsFrontCamera(this.V.isFrontCamera());
                }
                aRPEngineParams.setShaderDBPath(this.aL);
                this.hx.createEngine(aRPEngineParams);
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.resume();
            }
            a aVar = this.hz;
            if (aVar != null) {
                aVar.bq();
            }
            try {
                if (this.hA != null) {
                    this.hA.start();
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void bD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "stopARPEngine()");
            if (this.hx == null || !this.hy) {
                com.baidu.ar.lua.b bVar = this.f33048f;
                if (bVar != null) {
                    bVar.handleMessage(7, 0, null);
                }
            } else {
                this.hx.destroyEngine();
                this.hy = false;
            }
            this.hz = null;
            com.baidu.ar.arplay.a.c cVar = this.hA;
            if (cVar != null) {
                cVar.release();
            }
        }
    }

    public boolean bE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.hI : invokeV.booleanValue;
    }

    public abstract void bF();

    public void bI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.hI = true;
            com.baidu.ar.libloader.a.require("AREngineCpp");
            com.baidu.ar.libloader.a.setLibReadyListener("AREngineCpp", new ILibLoader.c(this) { // from class: com.baidu.ar.arrender.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f hO;

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
                    this.hO = this;
                }

                @Override // com.baidu.ar.libloader.ILibLoader.c
                public void onReady() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hO.hI = false;
                        f fVar = this.hO;
                        if (fVar.hJ) {
                            return;
                        }
                        fVar.bJ();
                    }
                }
            });
        }
    }

    public void bJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.hx != null) {
                try {
                    if (TextUtils.isEmpty(this.hD)) {
                        this.hx.setLocalDeviceGrade(this.hE);
                    } else {
                        this.hx.setConfig("grading", this.hD);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            bL();
            bC();
        }
    }

    public void c(DuMixInput duMixInput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, duMixInput) == null) {
            if (duMixInput.getInputTexture() != null) {
                if (duMixInput.getInputTexture().getId() == -1) {
                    long createTexture = this.hx.getARPRenderer().createTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
                    duMixInput.getInputTexture().setHandle(createTexture);
                    duMixInput.getInputTexture().setId(this.hx.getARPRenderer().getTextureId(createTexture));
                }
                this.hx.getARPRenderer().setInputTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
                return;
            }
            int i2 = duMixInput.isCameraInput() ? 36197 : 3553;
            if (duMixInput.getInputSurface() != null) {
                a(duMixInput.getInputSurface(), i2, duMixInput.getInputWidth(), duMixInput.getInputHeight());
                return;
            }
            duMixInput.setInputSurface(c(i2, duMixInput.getInputWidth(), duMixInput.getInputHeight()));
            this.hu = true;
        }
    }

    public void changeOutput(DuMixOutput duMixOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, duMixOutput) == null) {
            bN();
            this.W = duMixOutput;
            a(duMixOutput, (Object) null);
        }
    }

    public void changeOutputSize(int i2, int i3) {
        DuMixOutput duMixOutput;
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || this.V == null || (duMixOutput = this.W) == null) {
            return;
        }
        if (duMixOutput.getOutputHeight() == i3 && this.W.getOutputWidth() == i2) {
            return;
        }
        com.baidu.ar.h.b.c("AbstractRenderer", "changeOutputSize() size = " + i2 + "x" + i3);
        Object outputSurface = this.W.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i2, i3);
        }
        this.W.setOutputWidth(i2);
        this.W.setOutputHeight(i3);
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null && (pVar = this.ht) != null && !TextUtils.isEmpty(pVar.ca())) {
            this.hx.getARPRenderer().addOutputSurface(this.ht.getSurface(), i2, i3);
        }
        if (this.hx != null) {
            Size a = a(a(this.V), this.W);
            this.hx.setWindowSize(a.getWidth(), a.getHeight());
        }
        if (this.W.isFitScreenAuto()) {
            bO();
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, pixelReadParams, pixelReadListener) == null) || !this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, pixelReadParams, pixelReadListener) == null) || !this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.hy = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                Size a = b.a(this.W.getOutputWidth(), this.W.getOutputHeight(), this.V.getInputHeight(), this.V.getInputWidth());
                this.hF = a;
                this.hx.setPreviewSize(a.getWidth(), this.hF.getHeight());
                this.hx.setWindowSize(this.W.getOutputWidth(), this.W.getOutputHeight());
                return;
            }
            this.hF = null;
            Size a2 = a(this.V);
            Size a3 = a(a2, this.W);
            this.hx.setPreviewSize(a2.getWidth(), a2.getHeight());
            this.hx.setWindowSize(a3.getWidth(), a3.getHeight());
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "pause()");
            com.baidu.ar.arplay.a.c cVar = this.hA;
            if (cVar != null) {
                cVar.release();
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.pause();
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.hJ = z;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "release() start!!!");
            this.hK = true;
            pause();
            com.baidu.ar.arplay.d.b bVar = this.hB;
            if (bVar != null) {
                bVar.release();
                this.hB = null;
            }
            com.baidu.ar.statistic.p.c(this.f33048f);
            bD();
            this.hH = null;
            bM();
            this.V = null;
            bN();
            this.W = null;
            this.ht = null;
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.destroy();
                this.hx = null;
            }
            ARPEngine.releaseInstance();
            this.mContext = null;
            this.hG = null;
            com.baidu.ar.h.b.c("AbstractRenderer", "release() end!!!");
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            com.baidu.ar.h.b.c("AbstractRenderer", "resume()");
            try {
                this.hA.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                aRPEngine.resume();
            }
        }
    }

    public void setLocalDeviceGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.hE = i2;
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null) {
                try {
                    aRPEngine.setLocalDeviceGrade(i2);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, pixelReadParams, pixelRotation) == null) || !this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        pixelReadParams.setPixelRotate(pixelRotation);
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
    }
}
