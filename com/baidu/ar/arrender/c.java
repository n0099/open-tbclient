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
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends e implements OrientationManager.OrientationListener, l {
    private static boolean gS = true;
    private b R;
    private a gI;
    private Runnable gJ;
    private o gK;
    protected Runnable gL;
    protected j gM;
    private Runnable gN;
    private m gO;
    private Runnable gP;
    private float gQ;
    private int gR;
    private int gT;
    private long gU;
    private long gV;
    private ARRenderFpsCallback gW;
    private List<String> u;

    /* loaded from: classes3.dex */
    public interface a {
        void onInputSizeChange(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, looper, bVar, eGLContext, str);
        this.gR = 0;
        this.gT = 0;
    }

    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, String str) {
        this(context, looper, bVar, null, str);
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        return this.u == null || !this.u.contains(cVar.ab());
    }

    private void bz() {
        if (!this.hy || this.gR < 0) {
            return;
        }
        if (this.gR == 3) {
            this.hx.setEngineBlendState(0);
        } else if (this.gR == 0) {
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
        hashMap.put("front_camera", Integer.valueOf(z ? 0 : 1));
        this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
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
        if (this.hx != null) {
            this.hx.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
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
        if (this.hx != null) {
            this.hx.setInteraction(bVar);
        }
    }

    public void a(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setOnNeedCacheFrameListener(onNeedCacheFrameListener);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(TakePictureCallback takePictureCallback) {
        if (this.hx == null || this.hx.getARPRenderer() == null) {
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
        switch (iVar.bS()) {
            case INT:
                this.hx.adjustFilterWithIntParam(iVar.getFilterName(), iVar.bQ(), ((Integer) iVar.bR()).intValue(), iVar.getTimestamp());
                return;
            case FLOAT:
                this.hx.adjustFilterWithFloatParam(iVar.getFilterName(), iVar.bQ(), ((Float) iVar.bR()).floatValue(), iVar.getTimestamp());
                return;
            case FLOAT_ARRAY:
                this.hx.adjustFilterWithFloatArrayParam(iVar.getFilterName(), iVar.bQ(), (float[]) iVar.bR(), iVar.getTimestamp());
                return;
            case STRING:
                this.hx.adjustFilterWithStringParam(iVar.getFilterName(), iVar.bQ(), (String) iVar.bR(), iVar.getTimestamp());
                return;
            default:
                com.baidu.ar.h.b.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
                return;
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(j jVar) {
        if (this.hx == null || this.hx.getARPRenderer() == null || jVar == null) {
            com.baidu.ar.h.b.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.gM = jVar;
        if (this.gL == null) {
            this.gL = new Runnable() { // from class: com.baidu.ar.arrender.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gM == null || TextUtils.isEmpty(c.this.gM.getNodeName()) || c.this.gM.bT() == null || c.this.hx == null || c.this.a((com.baidu.ar.ability.c) c.this.gM)) {
                        return;
                    }
                    c.this.hx.updateNodeUniform(c.this.gM.getNodeName(), c.this.gM.bT());
                }
            };
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(this.gL);
        this.hx.getARPRenderer().runAsyncOnRenderContext(this.gL);
    }

    @Override // com.baidu.ar.arrender.l
    public void a(m mVar) {
        if (this.hx == null || this.hx.getARPRenderer() == null || mVar == null || a((com.baidu.ar.ability.c) mVar)) {
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
        if (this.hx == null || this.hx.getARPRenderer() == null || oVar == null || a(oVar)) {
            com.baidu.ar.h.b.b("ARRenderer", "updateRenderNodeData error!!!");
        } else if (!z) {
            this.hx.updateAlgoDataToNode(oVar.getWidth(), oVar.getHeight(), oVar.bZ());
        } else {
            this.gK = oVar;
            if (this.gJ == null) {
                this.gJ = new Runnable() { // from class: com.baidu.ar.arrender.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hx.updateAlgoDataToNode(c.this.gK.getWidth(), c.this.gK.getHeight(), c.this.gK.bZ());
                    }
                };
            }
            this.hx.getARPRenderer().cancelAysncRenderTask(this.gJ);
            this.hx.getARPRenderer().runAsyncOnRenderContext(this.gJ);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(com.baidu.ar.imu.b bVar) {
        if (this.hA != null) {
            this.hA.h(bVar.getTypeValue());
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void a(Object obj, int i, int i2) {
        super.a(obj, i, i2);
        if (this.gI != null) {
            this.gI.onInputSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void a(final String str, final Object obj) {
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hz != null) {
                    c.this.hz.setDataPipKV(str, obj);
                }
            }
        });
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    @Override // com.baidu.ar.arrender.e
    protected void a(boolean z) {
        com.baidu.ar.h.b.c("ARRenderer", "onCameraSwitch front = " + z);
        super.a(z);
        if (this.hx != null && this.hx.getARPRenderer() != null) {
            this.hx.getARPRenderer().setCameraFace(z);
        }
        if (this.hx != null) {
            this.hx.setIsFrontCamera(z);
        }
        if (this.V != null && this.V.isCameraInput()) {
            this.V.setFrontCamera(z);
        }
        n(!z);
        bw();
        this.gR = 3;
    }

    protected boolean a(com.baidu.ar.ability.c cVar) {
        return !cVar.ae() && (b(cVar) || c(cVar));
    }

    @Override // com.baidu.ar.arrender.l
    public void aJ() {
        if (this.hA != null) {
            this.hA.aJ();
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
        int[] iArr = {i};
        com.baidu.ar.h.b.c("ARRenderer", "addAlgoCache type = " + i + " && sync = " + z);
        this.hx.addAlgoType(iArr, z ? 1 : 0);
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
        if (this.hx != null) {
            this.hx.disableCaseLutTexture();
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
        if (this.hx == null || (currentScene = this.hx.getCurrentScene()) == null) {
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
        if (this.R != null) {
            this.R.a(i, i2);
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
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setAlgoPts(j);
    }

    @Override // com.baidu.ar.arrender.l
    public Matrixf4x4 getInitialTransform() {
        IARPScene currentScene;
        IARPCamera activeCamera;
        if (this.hx == null || (currentScene = this.hx.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
            return null;
        }
        return activeCamera.getInitialTransform();
    }

    @Override // com.baidu.ar.arrender.l
    public void initWorldAxis() {
        if (this.hx != null) {
            this.hx.initWorldAxis();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public boolean isDriverdByARPVersion() {
        if (this.hx != null) {
            return this.hx.isDriverdByARPVersion();
        }
        return false;
    }

    public void j(boolean z) {
        com.baidu.ar.h.b.k("ARRenderer", "enableSyncRender enable = " + z);
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setSourceSyncProperty(z);
    }

    @Override // com.baidu.ar.arrender.l
    public void k(boolean z) {
        if (this.hx != null) {
            this.hx.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public boolean l(boolean z) {
        if (this.hx == null || this.hx.getCurrentScene() == null) {
            return false;
        }
        return this.hx.getCurrentScene().setVisible(z);
    }

    @Override // com.baidu.ar.arrender.l
    public void m(boolean z) {
        if (this.hd != null) {
            this.hd.i(z);
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
        if (this.gW != null && (this.gW.listenType() & 2) != 0) {
            this.gW.onRenderFinished();
        }
        super.onRenderFinished(j);
        if (gS) {
            com.baidu.ar.h.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.gU));
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderStartedListener
    public void onRenderStarted(long j) {
        if (this.gW != null && (this.gW.listenType() & 1) != 0) {
            this.gW.onRenderStarted();
        }
        if (gS) {
            if (this.gU != 0) {
                com.baidu.ar.h.b.c("profile_frame_interval", "= " + (System.currentTimeMillis() - this.gU));
                if (this.gT == 50) {
                    int i = (int) (50000 / this.gV);
                    com.baidu.ar.h.b.c("profile_frame_fps_avg", "= " + i);
                    com.baidu.ar.h.b.c("profile_frame_interval_avg", "= " + (this.gV / 50));
                    this.gT = 0;
                    this.gV = 0L;
                    if (this.gW != null && (this.gW.listenType() & 4) != 0) {
                        this.gW.renderFps(i);
                    }
                } else {
                    this.gT++;
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
    public /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
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
        if (this.hx != null) {
            this.hC = true;
            this.hx.pauseScene();
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
        if (this.hx != null) {
            this.hx.resumeScene();
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
        if (this.hx != null) {
            this.hx.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void sceneWorldPositionToOrigin() {
        if (this.hx != null) {
            this.hx.sceneWorldPositionToOrigin();
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
        if (this.hx == null || this.hx.getARPRenderer() == null) {
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
        if (this.hB != null) {
            this.hB.a(context, viewGroup, this);
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
        if (this.hB != null) {
            this.hB.b(context, viewGroup, null);
        }
    }

    @Override // com.baidu.ar.arrender.l
    public void setOffScreenGuideWork(boolean z) {
        IARPScene currentScene;
        if (this.hx == null || (currentScene = this.hx.getCurrentScene()) == null) {
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
        if (this.hx != null) {
            return this.hx.adjustFilterWithCasePathParam(str);
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.f
    public /* bridge */ /* synthetic */ void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        super.updatePixelReader(pixelReadParams, pixelRotation);
    }
}
