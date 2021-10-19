package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.renderer.OnRenderStartedListener;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.bean.StorageType;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public abstract class e extends f implements View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g D;
    public com.baidu.ar.arplay.core.engine.a hd;
    public boolean he;
    public com.baidu.ar.f.c hf;
    public com.baidu.ar.steploading.d hg;
    public com.baidu.ar.lua.a hh;
    public ConcurrentHashMap<DuMixOutput, p> hi;
    public List<FrameRenderListener> hj;
    public h hk;
    public boolean hl;
    public k hm;
    public boolean hn;
    public float[] ho;
    public float[] hp;
    public float[] hq;

    /* renamed from: com.baidu.ar.arrender.e$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] hs;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752646496, "Lcom/baidu/ar/arrender/e$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1752646496, "Lcom/baidu/ar/arrender/e$2;");
                    return;
                }
            }
            int[] iArr = new int[Watermark.CoordinateType.values().length];
            hs = iArr;
            try {
                iArr[Watermark.CoordinateType.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hs[Watermark.CoordinateType.LEFT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hs[Watermark.CoordinateType.RIGHT_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                hs[Watermark.CoordinateType.RIGHT_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, bVar, eGLContext, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, bVar, eGLContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.baidu.ar.lua.b) objArr2[1], (EGLContext) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.he = false;
        this.hj = Collections.synchronizedList(new ArrayList());
        this.hl = false;
        this.hn = false;
        this.ho = new float[16];
        this.hd = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        com.baidu.ar.f.c cVar = new com.baidu.ar.f.c(context);
        this.hf = cVar;
        cVar.b(this.f38443f);
        com.baidu.ar.lua.a aVar = new com.baidu.ar.lua.a();
        this.hh = aVar;
        aVar.b(this.f38443f);
        com.baidu.ar.steploading.d dVar = new com.baidu.ar.steploading.d(context);
        this.hg = dVar;
        dVar.b(this.f38443f);
        this.hi = new ConcurrentHashMap<>();
        boolean A = com.baidu.ar.h.p.A(this.mContext);
        this.hl = A;
        this.hd.setScreenOrientationLandscape(A);
        this.hm = new k(looper, bVar.fk(), this.hx.getARPRenderer());
        Matrix.setIdentityM(this.ho, 0);
        this.hx.getARPRenderer().setOnRenderStartedListener(this);
        this.hx.getARPRenderer().setOnRenderFinishedListener(this);
    }

    private void a(Watermark watermark) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, watermark) == null) {
            if (watermark.getBitmap() == null && !TextUtils.isEmpty(watermark.getFilePath())) {
                Bitmap bitmap = null;
                if (watermark.getStorageType() == StorageType.SDCARD) {
                    bitmap = BitmapFactory.decodeFile(watermark.getFilePath());
                } else if (watermark.getStorageType() == StorageType.ASSETS) {
                    bitmap = com.baidu.ar.h.e.f(this.mContext, watermark.getFilePath());
                }
                watermark.setBitmap(bitmap);
            }
            if (watermark.getBitmap() == null || watermark.getRotationType() == RotationType.ROTATE_0) {
                return;
            }
            watermark.setBitmap(com.baidu.ar.h.e.rotateBitmap(watermark.getBitmap(), watermark.getRotationType().getDegree()));
        }
    }

    private void a(String str, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, str, duMixInput, duMixOutput) == null) || duMixOutput == null || duMixOutput.getWatermark() == null) {
            return;
        }
        a(duMixOutput.getWatermark());
        if (duMixOutput.getWatermark().getBitmap() == null) {
            com.baidu.ar.h.b.b("ARRendererBase", "setWatermark error!!! As no watermark image!!!");
            return;
        }
        b(duMixInput, duMixOutput);
        if (this.hx == null || duMixOutput.getWatermark().getRenderRect() == null || duMixOutput.getWatermark().getRenderRect().length != 4) {
            return;
        }
        this.hx.setWatermark(str, duMixOutput.getWatermark().getBitmap(), duMixOutput.getWatermark().getRenderRect());
    }

    private float[] a(Watermark watermark, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{watermark, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float[] fArr = new float[4];
            Point startPoint = watermark.getStartPoint();
            float width = watermark.getBitmap().getWidth() * watermark.getScale();
            float height = watermark.getBitmap().getHeight() * watermark.getScale();
            int i2 = AnonymousClass2.hs[watermark.getCoordinateType().ordinal()];
            if (i2 == 1) {
                fArr[0] = (startPoint.x + f4) / f2;
                fArr[1] = (startPoint.y + f5) / f3;
            } else if (i2 == 2) {
                fArr[0] = (startPoint.x + f4) / f2;
                fArr[1] = (((f3 - f5) - startPoint.y) - height) / f3;
            } else if (i2 == 3) {
                fArr[0] = (((f2 - f4) - startPoint.x) - width) / f2;
                fArr[1] = (startPoint.y + f5) / f3;
            } else if (i2 == 4) {
                fArr[0] = (((f2 - f4) - startPoint.x) - width) / f2;
                fArr[1] = (((f3 - f5) - startPoint.y) - height) / f3;
            }
            fArr[2] = width / f2;
            fArr[3] = height / f3;
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    private void b(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, duMixInput, duMixOutput) == null) {
            Watermark watermark = duMixOutput.getWatermark();
            if (watermark.getRenderRect() != null || watermark.getStartPoint() == null) {
                return;
            }
            int outputWidth = duMixOutput.getOutputWidth();
            int outputHeight = duMixOutput.getOutputHeight();
            if (duMixOutput.getRotationType() == RotationType.ROTATE_90 || duMixOutput.getRotationType() == RotationType.ROTATE_270) {
                outputHeight = outputWidth;
                outputWidth = outputHeight;
            }
            int i3 = 0;
            if (duMixOutput.getScaleType() == ScaleType.CENTER_CROP && duMixInput != null) {
                int inputWidth = duMixInput.getInputWidth();
                int inputHeight = duMixInput.getInputHeight();
                if (duMixInput.getRotationType() == RotationType.ROTATE_90 || duMixInput.getRotationType() == RotationType.ROTATE_270) {
                    inputHeight = inputWidth;
                    inputWidth = inputHeight;
                }
                new Size(outputWidth, outputHeight);
                Size b2 = b.b(inputWidth, inputHeight, outputWidth, outputHeight);
                if (b2.getWidth() != inputWidth) {
                    i3 = (outputWidth - b2.getWidth()) / 2;
                } else if (b2.getHeight() != inputHeight) {
                    i2 = (outputHeight - b2.getHeight()) / 2;
                    watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i3, i2));
                }
            }
            i2 = 0;
            watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i3, i2));
        }
    }

    private void bG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
                this.hx.getARPRenderer().setIsRender(false);
            }
            for (int i2 = 0; i2 < 5; i2++) {
                ARPEngine aRPEngine2 = this.hx;
                if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
                    this.hx.getARPRenderer().render(System.currentTimeMillis());
                }
            }
            ARPEngine aRPEngine3 = this.hx;
            if (aRPEngine3 != null && aRPEngine3.getARPRenderer() != null) {
                this.hx.getARPRenderer().setIsRender(true);
            }
            ARPEngine aRPEngine4 = this.hx;
            if (aRPEngine4 == null || aRPEngine4.getARPRenderer() == null) {
                return;
            }
            this.hx.getARPRenderer().render(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            com.baidu.ar.h.b.c("ARRendererBase", "createCase() casePath = " + str);
            super.L(str);
            com.baidu.ar.lua.a aVar = this.hh;
            if (aVar != null) {
                aVar.fj();
            }
            com.baidu.ar.steploading.d dVar = this.hg;
            if (dVar != null) {
                dVar.switchCase(str);
            }
        }
    }

    public void a(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (gVar = this.D) == null) {
            return;
        }
        gVar.a(z);
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameRenderListener) == null) || frameRenderListener == null || (list = this.hj) == null) {
            return;
        }
        list.add(frameRenderListener);
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, duMixOutput) == null) {
            if (duMixOutput == null || duMixOutput.getOutputSurface() == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
                com.baidu.ar.h.b.b("ARRendererBase", "addOutputSurface duMixOutput is error!!!");
                return;
            }
            com.baidu.ar.h.b.c("ARRendererBase", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
            String addOutputSurface = this.hx.getARPRenderer().addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
            a(addOutputSurface, this.V, duMixOutput);
            p pVar = new p(duMixOutput);
            pVar.Q(addOutputSurface);
            ConcurrentHashMap<DuMixOutput, p> concurrentHashMap = this.hi;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(duMixOutput, pVar);
            }
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void b(Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, obj, i2, i3) == null) {
            super.b(obj, i2, i3);
            this.he = false;
        }
    }

    public com.baidu.ar.steploading.d bA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hg : (com.baidu.ar.steploading.d) invokeV.objValue;
    }

    @Override // com.baidu.ar.arrender.f
    public void bB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.baidu.ar.h.b.c("ARRendererBase", "destroyCase()");
            super.bB();
            k kVar = this.hm;
            if (kVar != null) {
                kVar.bU();
                this.hm.bV();
            }
            com.baidu.ar.f.c cVar = this.hf;
            if (cVar != null) {
                cVar.reset();
            }
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void bC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.ar.h.b.c("ARRendererBase", "startARPEngine()");
            super.bC();
            com.baidu.ar.arplay.core.engine.a aVar = this.hd;
            if (aVar != null) {
                aVar.h(true);
            }
            a(this.hn);
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void bF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.hn = this.V.isFrontCamera();
            if (this.W.getOutputFPS() > 0) {
                this.hk = new h(this.W.getOutputFPS());
            }
            k kVar = this.hm;
            if (kVar != null) {
                kVar.g(this.W.getOutputWidth(), this.W.getOutputHeight());
            }
        }
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, runnable) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.arrender.f
    public void changeOutput(DuMixOutput duMixOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, duMixOutput) == null) {
            super.changeOutput(duMixOutput);
            this.he = false;
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void changeOutputSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.changeOutputSize(i2, i3);
            this.he = false;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || this.hK) {
            return;
        }
        h hVar = this.hk;
        if (hVar != null && !hVar.bP()) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable(this) { // from class: com.baidu.ar.arrender.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e hr;

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
                    this.hr = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DuMixInput duMixInput;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (duMixInput = this.hr.V) == null || duMixInput.getInputSurface() == null) {
                        return;
                    }
                    this.hr.V.getInputSurface().updateTexImage();
                }
            });
        } else if (this.hL) {
            StatisticApi.getPerformanceApi().onFrameIn();
            this.hx.getARPRenderer().render(surfaceTexture.getTimestamp());
            StatisticApi.getPerformanceApi().onFrameOut();
        }
    }

    public void onRenderFinished(long j2) {
        List<FrameRenderListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) || (list = this.hj) == null) {
            return;
        }
        for (FrameRenderListener frameRenderListener : list) {
            frameRenderListener.onRenderFinished(j2);
        }
    }

    public void onRenderStarted(long j2) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            List<FrameRenderListener> list = this.hj;
            if (list != null) {
                for (FrameRenderListener frameRenderListener : list) {
                    frameRenderListener.onRenderStarted(j2);
                }
            }
            DuMixInput duMixInput = this.V;
            if (duMixInput != null && duMixInput.getInputSurface() != null) {
                this.V.getInputSurface().updateTexImage();
                this.V.getInputSurface().getTransformMatrix(this.ho);
            }
            DuMixInput duMixInput2 = this.V;
            if (duMixInput2 == null || !duMixInput2.isCameraInput() || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
                return;
            }
            if (this.hp == null) {
                float[] fArr = new float[16];
                this.hp = fArr;
                float[] fArr2 = this.ho;
                System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            }
            if (!Arrays.equals(this.ho, this.hp)) {
                this.hn = !this.hn;
                float[] fArr3 = this.ho;
                System.arraycopy(fArr3, 0, this.hp, 0, fArr3.length);
            }
            if (this.hq == null) {
                float[] fArr4 = new float[16];
                this.hq = fArr4;
                b.a(this.mContext, fArr4, this.hn);
                this.hx.getARPRenderer().setInputMatrix(this.hq);
            }
            boolean isFrontCamera = this.V.isFrontCamera();
            boolean z = this.hn;
            if (isFrontCamera != z) {
                b.a(this.mContext, this.hq, z);
                this.hx.getARPRenderer().setInputMatrix(this.hq);
                a(this.hn);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, motionEvent)) == null) {
            com.baidu.ar.arplay.core.engine.a aVar = this.hd;
            if (aVar == null) {
                return false;
            }
            if (!this.he) {
                if (view != null) {
                    aVar.d(view.getWidth(), view.getHeight());
                } else {
                    DuMixOutput duMixOutput = this.W;
                    if (duMixOutput != null) {
                        aVar.d(duMixOutput.getOutputWidth(), this.W.getOutputHeight());
                    }
                }
                this.he = true;
            }
            this.hd.onTouchEvent(motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.arrender.f
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            com.baidu.ar.h.b.c("ARRendererBase", "pause()");
            com.baidu.ar.arplay.core.engine.a aVar = this.hd;
            if (aVar != null) {
                aVar.onPause();
            }
            super.pause();
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            com.baidu.ar.f.c cVar = this.hf;
            if (cVar != null) {
                cVar.release();
                this.hf = null;
            }
            ConcurrentHashMap<DuMixOutput, p> concurrentHashMap = this.hi;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
                this.hi = null;
            }
            List<FrameRenderListener> list = this.hj;
            if (list != null) {
                list.clear();
                this.hj = null;
            }
            com.baidu.ar.arplay.core.engine.a aVar = this.hd;
            if (aVar != null) {
                aVar.release();
                this.hd = null;
            }
            k kVar = this.hm;
            if (kVar != null) {
                kVar.release();
                this.hm = null;
            }
            com.baidu.ar.lua.a aVar2 = this.hh;
            if (aVar2 != null) {
                aVar2.release();
                this.hh = null;
            }
            com.baidu.ar.steploading.d dVar = this.hg;
            if (dVar != null) {
                dVar.release();
                this.hg = null;
            }
            this.hk = null;
            this.D = null;
            this.ho = null;
            this.hq = null;
            this.hp = null;
            super.release();
        }
    }

    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, frameRenderListener) == null) || frameRenderListener == null || (list = this.hj) == null) {
            return;
        }
        list.remove(frameRenderListener);
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, duMixOutput) == null) {
            if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
                com.baidu.ar.h.b.b("ARRendererBase", "removeOutputSurface duMixOutput is error!!!");
            } else if (this.hi != null) {
                com.baidu.ar.h.b.c("ARRendererBase", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
                p remove = this.hi.remove(duMixOutput);
                ARPEngine aRPEngine = this.hx;
                if (aRPEngine == null || aRPEngine.getARPRenderer() == null || remove == null || TextUtils.isEmpty(remove.ca())) {
                    return;
                }
                this.hx.getARPRenderer().removeOutputTargetByAddr(remove.ca());
            }
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            DuMixInput duMixInput = this.V;
            if (duMixInput != null && duMixInput.isSingleFrame()) {
                bG();
            }
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
                return;
            }
            this.hx.getARPRenderer().render(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.baidu.ar.h.b.c("ARRendererBase", "resume()");
            super.resume();
            com.baidu.ar.arplay.core.engine.a aVar = this.hd;
            if (aVar != null) {
                aVar.onResume();
            }
        }
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, runnable) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, runnable) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, gVar) == null) {
            this.D = gVar;
        }
    }

    public void setDefaultPipeLine(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
            }
            this.aG = str;
        }
    }

    public void setInputMatrix(float[] fArr) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, fArr) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setInputMatrix(fArr);
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, duMixStateListener) == null) {
            this.hH = duMixStateListener;
        }
    }
}
