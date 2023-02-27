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
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends e implements OrientationManager.OrientationListener, l {
    public static boolean gS = true;
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
    public List<String> u;

    /* renamed from: com.baidu.ar.arrender.c$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] ha;

        static {
            int[] iArr = new int[i.a.values().length];
            ha = iArr;
            try {
                iArr[i.a.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ha[i.a.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ha[i.a.FLOAT_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ha[i.a.STRING.ordinal()] = 4;
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

    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, looper, bVar, eGLContext, str);
        this.gR = 0;
        this.gT = 0;
    }

    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, String str) {
        this(context, looper, bVar, null, str);
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        List<String> list = this.u;
        return list == null || !list.contains(cVar.ab());
    }

    private void bz() {
        int i;
        if (!this.hy || (i = this.gR) < 0) {
            return;
        }
        if (i == 3) {
            this.hx.setEngineBlendState(0);
        } else if (i == 0) {
            this.hx.setEngineBlendState(1);
        }
        this.gR--;
    }

    private boolean c(com.baidu.ar.ability.c cVar) {
        return cVar.ac() && cVar.ad() != this.hn;
    }

    private void n(boolean z) {
        if (this.f == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
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
        if (this.hx == null || j <= 0 || TextUtils.isEmpty(str)) {
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(PointF pointF, boolean z) {
        com.baidu.ar.arrender.b.a(pointF, z, this.V, this.W, this.hl);
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(ARPDataInteraction.b bVar) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.setInteraction(bVar);
        }
    }

    public void a(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setOnNeedCacheFrameListener(onNeedCacheFrameListener);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(TakePictureCallback takePictureCallback) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().getSnapShot(takePictureCallback, this.W.getOutputWidth(), this.W.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
    }

    public void a(a aVar) {
        this.gI = aVar;
    }

    public void a(b bVar) {
        this.R = bVar;
    }

    @Override // com.baidu.ar.arrender.l
    public void a(i iVar) {
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

    @Override // com.baidu.ar.arrender.l
    public void a(j jVar) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || jVar == null) {
            com.baidu.ar.h.b.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.gM = jVar;
        if (this.gL == null) {
            this.gL = new Runnable() { // from class: com.baidu.ar.arrender.c.2
                @Override // java.lang.Runnable
                public void run() {
                    j jVar2 = c.this.gM;
                    if (jVar2 == null || TextUtils.isEmpty(jVar2.getNodeName()) || c.this.gM.bT() == null) {
                        return;
                    }
                    c cVar = c.this;
                    if (cVar.hx == null || cVar.a((com.baidu.ar.ability.c) cVar.gM)) {
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.hx.updateNodeUniform(cVar2.gM.getNodeName(), c.this.gM.bT());
                }
            };
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(this.gL);
        this.hx.getARPRenderer().runAsyncOnRenderContext(this.gL);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(m mVar) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || mVar == null || a((com.baidu.ar.ability.c) mVar)) {
            com.baidu.ar.h.b.b("ARRenderer", "updateRenderCameraData error!!!");
            return;
        }
        this.gO = mVar;
        if (this.gN == null) {
            this.gN = new Runnable() { // from class: com.baidu.ar.arrender.c.3
                @Override // java.lang.Runnable
                public void run() {
                    IARPCamera activeCamera;
                    IARPScene currentScene = c.this.hx.getCurrentScene();
                    if (currentScene == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                        return;
                    }
                    activeCamera.setViewMatrix(c.this.gO.getMatrix());
                }
            };
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(this.gN);
        this.hx.getARPRenderer().runAsyncOnRenderContext(this.gN);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(o oVar, boolean z) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || oVar == null || a(oVar)) {
            com.baidu.ar.h.b.b("ARRenderer", "updateRenderNodeData error!!!");
        } else if (!z) {
            this.hx.updateAlgoDataToNode(oVar.getWidth(), oVar.getHeight(), oVar.bZ());
        } else {
            this.gK = oVar;
            if (this.gJ == null) {
                this.gJ = new Runnable() { // from class: com.baidu.ar.arrender.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        cVar.hx.updateAlgoDataToNode(cVar.gK.getWidth(), c.this.gK.getHeight(), c.this.gK.bZ());
                    }
                };
            }
            this.hx.getARPRenderer().cancelAysncRenderTask(this.gJ);
            this.hx.getARPRenderer().runAsyncOnRenderContext(this.gJ);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(com.baidu.ar.imu.b bVar) {
        com.baidu.ar.arplay.a.c cVar = this.hA;
        if (cVar != null) {
            cVar.h(bVar.getTypeValue());
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void a(Object obj, int i, int i2) {
        super.a(obj, i, i2);
        a aVar = this.gI;
        if (aVar != null) {
            aVar.onInputSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(final String str, final Object obj) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.arrender.a aVar = c.this.hz;
                if (aVar != null) {
                    aVar.setDataPipKV(str, obj);
                }
            }
        });
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    @Override // com.baidu.ar.arrender.e
    public void a(boolean z) {
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

    public boolean a(com.baidu.ar.ability.c cVar) {
        return !cVar.ae() && (b(cVar) || c(cVar));
    }

    @Override // com.baidu.ar.arrender.l
    public void aJ() {
        com.baidu.ar.arplay.a.c cVar = this.hA;
        if (cVar != null) {
            cVar.aJ();
        }
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
        if (this.hx == null || i < 0) {
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
        return this.V;
    }

    public DuMixOutput bu() {
        return this.W;
    }

    @Override // com.baidu.ar.arrender.l
    public void bv() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.disableCaseLutTexture();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void bw() {
        onRotateOrientation(OrientationManager.getGlobalOrientation());
    }

    @Override // com.baidu.ar.arrender.l
    public String bx() {
        return this.mCasePath;
    }

    @Override // com.baidu.ar.arrender.l
    public void by() {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
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
        super.changeOutputSize(i, i2);
        b bVar = this.R;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.createPixelReader(pixelReadParams, pixelReadListener);
    }

    public void d(List<String> list) {
        this.u = list;
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.destroyPixelReader(pixelReadParams, pixelReadListener);
    }

    public void f(long j) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setAlgoPts(j);
    }

    @Override // com.baidu.ar.arrender.l
    public Matrixf4x4 getInitialTransform() {
        IARPScene currentScene;
        IARPCamera activeCamera;
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
            return null;
        }
        return activeCamera.getInitialTransform();
    }

    @Override // com.baidu.ar.arrender.l
    public void initWorldAxis() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.initWorldAxis();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public boolean isDriverdByARPVersion() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            return aRPEngine.isDriverdByARPVersion();
        }
        return false;
    }

    public void j(boolean z) {
        com.baidu.ar.h.b.k("ARRenderer", "enableSyncRender enable = " + z);
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setSourceSyncProperty(z);
    }

    @Override // com.baidu.ar.arrender.l
    public void k(boolean z) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public boolean l(boolean z) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getCurrentScene() == null) {
            return false;
        }
        return this.hx.getCurrentScene().setVisible(z);
    }

    @Override // com.baidu.ar.arrender.l
    public void m(boolean z) {
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar != null) {
            aVar.i(z);
        }
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
        ARRenderFpsCallback aRRenderFpsCallback = this.gW;
        if (aRRenderFpsCallback != null && (aRRenderFpsCallback.listenType() & 2) != 0) {
            this.gW.onRenderFinished();
        }
        super.onRenderFinished(j);
        if (gS) {
            com.baidu.ar.h.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.gU));
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderStartedListener
    public void onRenderStarted(long j) {
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

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.f != null) {
            com.baidu.ar.h.b.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
            this.f.b(4001, com.baidu.ar.arrender.b.a(orientation));
        }
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
        com.baidu.ar.h.b.c("ARRenderer", "pauseScene()");
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            this.hC = true;
            aRPEngine.pauseScene();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void q(int i) {
        if (this.hx == null || i < 0) {
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
        this.u = null;
        this.R = null;
        this.gI = null;
        this.gW = null;
        super.release();
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
        com.baidu.ar.h.b.c("ARRenderer", "resumeScene()");
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.resumeScene();
            this.hC = false;
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void sceneWorldPositionToOrigin() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.sceneWorldPositionToOrigin();
        }
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        this.gW = aRRenderFpsCallback;
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.gQ = f;
        if (this.gP == null) {
            this.gP = new Runnable() { // from class: com.baidu.ar.arrender.c.4
                @Override // java.lang.Runnable
                public void run() {
                    IARPCamera activeCamera;
                    IARPScene currentScene = c.this.hx.getCurrentScene();
                    if (currentScene == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                        return;
                    }
                    activeCamera.setFieldOfView(c.this.gQ);
                }
            };
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(this.gP);
        this.hx.getARPRenderer().runAsyncOnRenderContext(this.gP);
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        com.baidu.ar.arplay.d.b bVar = this.hB;
        if (bVar != null) {
            bVar.a(context, viewGroup, this);
        }
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
        com.baidu.ar.arplay.d.b bVar = this.hB;
        if (bVar != null) {
            bVar.b(context, viewGroup, null);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void setOffScreenGuideWork(boolean z) {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            return aRPEngine.adjustFilterWithCasePathParam(str);
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        super.updatePixelReader(pixelReadParams, pixelRotation);
    }
}
