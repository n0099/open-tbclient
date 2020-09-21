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
import com.baidu.ar.arplay.core.engine.ARPCamera;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.ARPNode;
import com.baidu.ar.arplay.core.engine.ARPScene;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener;
import com.baidu.ar.arplay.core.filter.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.filter.OnRenderStartedListener;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends e implements OrientationManager.OrientationListener, k {
    private static boolean gF = true;
    private b Q;
    private Runnable gA;
    private l gB;
    private Runnable gC;
    private float gD;
    private int gE;
    private int gG;
    private long gH;
    private long gI;
    private a gv;
    private Runnable gw;
    private n gx;
    protected Runnable gy;
    protected i gz;
    private List<String> u;

    /* loaded from: classes10.dex */
    public interface a {
        void onInputSizeChange(int i, int i2);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(int i, int i2);
    }

    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar) {
        super(context, looper, bVar);
        this.gE = 0;
        this.gG = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, looper, bVar, eGLContext);
        this.gE = 0;
        this.gG = 0;
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        return this.u == null || !this.u.contains(cVar.Z());
    }

    private void bC() {
        if (!this.hb || this.gE < 0) {
            return;
        }
        if (this.gE == 3) {
            this.ha.setEngineBlendState(0);
        } else if (this.gE == 0) {
            this.ha.setEngineBlendState(1);
        }
        this.gE--;
    }

    private boolean c(com.baidu.ar.ability.c cVar) {
        return cVar.aa() && cVar.ab() != this.hk;
    }

    private void p(boolean z) {
        if (this.f == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10200);
        hashMap.put("front_camera", Integer.valueOf(z ? 0 : 1));
        this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void I(String str) {
        super.I(str);
    }

    @Override // com.baidu.ar.arrender.k
    public void a(float f) {
        if (this.gZ == null || this.ha == null) {
            return;
        }
        this.gD = f;
        if (this.gC == null) {
            this.gC = new Runnable() { // from class: com.baidu.ar.arrender.c.4
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aV;
                    ARPScene currentScene = c.this.ha.getCurrentScene();
                    if (currentScene == null || (aV = currentScene.aV()) == null) {
                        return;
                    }
                    aV.a(c.this.gD);
                }
            };
        }
        this.gZ.cancelAysncRenderTask(this.gC);
        this.gZ.runAsyncOnRenderContext(this.gC);
    }

    @Override // com.baidu.ar.arrender.k
    public void a(long j, String str) {
        if (this.ha == null || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ar.ability.c cVar = new com.baidu.ar.ability.c();
        cVar.p(str);
        cVar.setTimestamp(AlgoHandleAdapter.getHandleTimeStamp(j));
        cVar.d(AlgoHandleAdapter.getHandleIsFront(j));
        cVar.c(AlgoHandleAdapter.getHandleEnableSync(j));
        if (a(cVar)) {
            return;
        }
        this.ha.setAlgoDataHandle(j);
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        if (this.gZ != null) {
            this.gZ.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void a(PointF pointF, boolean z) {
        com.baidu.ar.arrender.b.a(pointF, z, this.W, this.aa, this.hx);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    @Override // com.baidu.ar.arrender.k
    public void a(ARPEngine.d dVar) {
        if (this.ha != null) {
            this.ha.setInteraction(dVar);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.a(pixelReadParams, pixelReadListener);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        super.a(pixelReadParams, pixelRotation);
    }

    public void a(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        if (this.gZ != null) {
            this.gZ.setOnNeedCacheFrameListener(onNeedCacheFrameListener);
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void a(TakePictureCallback takePictureCallback) {
        if (this.gZ != null) {
            this.gZ.getSnapShot(takePictureCallback, this.aa.getOutputWidth(), this.aa.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
        }
    }

    public void a(a aVar) {
        this.gv = aVar;
    }

    public void a(b bVar) {
        this.Q = bVar;
    }

    @Override // com.baidu.ar.arrender.k
    public void a(h hVar) {
        if (this.gZ == null || hVar == null || a((com.baidu.ar.ability.c) hVar) || this.hs) {
            com.baidu.ar.g.b.b("ARRenderer", "updateFilterData error!!!");
            return;
        }
        switch (hVar.bT()) {
            case INT:
                this.gZ.adjustFilterWithIntParam(hVar.getFilterName(), hVar.bR(), ((Integer) hVar.bS()).intValue(), hVar.getTimestamp());
                return;
            case FLOAT:
                this.gZ.adjustFilterWithFloatParam(hVar.getFilterName(), hVar.bR(), ((Float) hVar.bS()).floatValue(), hVar.getTimestamp());
                return;
            case FLOAT_ARRAY:
                this.gZ.adjustFilterWithFloatArrayParam(hVar.getFilterName(), hVar.bR(), (float[]) hVar.bS(), hVar.getTimestamp());
                return;
            case STRING:
                this.gZ.adjustFilterWithStringParam(hVar.getFilterName(), hVar.bR(), (String) hVar.bS(), hVar.getTimestamp());
                return;
            default:
                com.baidu.ar.g.b.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
                return;
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void a(final i iVar) {
        if (this.gZ == null || iVar == null) {
            com.baidu.ar.g.b.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.gz = iVar;
        if (this.gy == null) {
            this.gy = new Runnable() { // from class: com.baidu.ar.arrender.c.2
                @Override // java.lang.Runnable
                public void run() {
                    ARPScene currentScene;
                    if (c.this.gz == null || TextUtils.isEmpty(c.this.gz.getNodeName()) || c.this.gz.bU() == null || c.this.ha == null || c.this.a((com.baidu.ar.ability.c) c.this.gz) || (currentScene = c.this.ha.getCurrentScene()) == null || currentScene.E(iVar.getNodeName()) == null) {
                        return;
                    }
                    ARPNode E = currentScene.E(c.this.gz.getNodeName());
                    for (Map.Entry<String, Object> entry : c.this.gz.bU().entrySet()) {
                        E.a(entry.getKey(), entry.getValue());
                    }
                }
            };
        }
        this.gZ.cancelAysncRenderTask(this.gy);
        this.gZ.runAsyncOnRenderContext(this.gy);
    }

    @Override // com.baidu.ar.arrender.k
    public void a(l lVar) {
        if (this.gZ == null || this.ha == null || lVar == null || a((com.baidu.ar.ability.c) lVar)) {
            com.baidu.ar.g.b.b("ARRenderer", "updateRenderCameraData error!!!");
            return;
        }
        this.gB = lVar;
        if (this.gA == null) {
            this.gA = new Runnable() { // from class: com.baidu.ar.arrender.c.3
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aV;
                    ARPScene currentScene = c.this.ha.getCurrentScene();
                    if (currentScene == null || (aV = currentScene.aV()) == null) {
                        return;
                    }
                    aV.a(c.this.gB.getMatrix());
                }
            };
        }
        this.gZ.cancelAysncRenderTask(this.gA);
        this.gZ.runAsyncOnRenderContext(this.gA);
    }

    @Override // com.baidu.ar.arrender.k
    public void a(n nVar, boolean z) {
        if (this.gZ == null || this.ha == null || nVar == null || a(nVar)) {
            com.baidu.ar.g.b.b("ARRenderer", "updateRenderNodeData error!!!");
        } else if (!z) {
            this.ha.updateAlgoDataToNode(nVar.getWidth(), nVar.getHeight(), nVar.ca());
        } else {
            this.gx = nVar;
            if (this.gw == null) {
                this.gw = new Runnable() { // from class: com.baidu.ar.arrender.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ha.updateAlgoDataToNode(c.this.gx.getWidth(), c.this.gx.getHeight(), c.this.gx.ca());
                    }
                };
            }
            this.gZ.cancelAysncRenderTask(this.gw);
            this.gZ.runAsyncOnRenderContext(this.gw);
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void a(com.baidu.ar.imu.b bVar) {
        if (this.ha != null) {
            this.ha.setImuType(bVar.getTypeValue());
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    @Override // com.baidu.ar.arrender.e
    protected void a(boolean z) {
        com.baidu.ar.g.b.c("ARRenderer", "onCameraSwitch front = " + z);
        super.a(z);
        if (this.gZ != null) {
            this.gZ.setCameraFace(z);
        }
        if (this.ha != null) {
            this.ha.setIsFrontCamera(z);
        }
        if (this.W != null && this.W.isCameraInput()) {
            this.W.setFrontCamera(z);
        }
        p(!z);
        bz();
        this.gE = 3;
    }

    protected boolean a(com.baidu.ar.ability.c cVar) {
        return !cVar.ac() && (b(cVar) || c(cVar));
    }

    @Override // com.baidu.ar.arrender.k
    public void aI() {
        if (this.hf != null) {
            this.hf.aI();
        }
    }

    @Override // com.baidu.ar.arrender.k
    public Matrixf4x4 aT() {
        ARPScene currentScene;
        ARPCamera aV;
        if (this.ha == null || (currentScene = this.ha.getCurrentScene()) == null || (aV = currentScene.aV()) == null) {
            return null;
        }
        return aV.aT();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addOutputSurface(DuMixOutput duMixOutput) {
        super.addOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.k
    public void b(int i, boolean z) {
        if (this.ha == null || i < 0) {
            return;
        }
        int[] iArr = {i};
        com.baidu.ar.g.b.c("ARRenderer", "addAlgoCache type = " + i + " && sync = " + z);
        this.ha.addAlgoType(iArr, z ? 1 : 0);
    }

    @Override // com.baidu.ar.arrender.k
    public void b(final String str, final Object obj) {
        if (this.gZ == null) {
            return;
        }
        this.gZ.runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.he != null) {
                    c.this.he.setDataPipKV(str, obj);
                }
            }
        });
    }

    @Override // com.baidu.ar.arrender.k
    public String bA() {
        return this.mCasePath;
    }

    @Override // com.baidu.ar.arrender.k
    public void bB() {
        ARPScene currentScene;
        if (this.ha == null || (currentScene = this.ha.getCurrentScene()) == null) {
            return;
        }
        currentScene.aX();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bD() {
        super.bD();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bE() {
        super.bE();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bF() {
        super.bF();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ boolean bG() {
        return super.bG();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ com.baidu.ar.steploading.d bH() {
        return super.bH();
    }

    public DuMixInput bw() {
        return this.W;
    }

    public DuMixOutput bx() {
        return this.aa;
    }

    @Override // com.baidu.ar.arrender.k
    public void by() {
        if (this.gZ != null) {
            this.gZ.disableCaseLutTexture();
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void bz() {
        onRotateOrientation(OrientationManager.getGlobalOrientation());
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void cancelAysncRenderTask(Runnable runnable) {
        super.cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.arrender.e
    public void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2) {
        super.changeInputSize(surfaceTexture, i, i2);
        if (this.gv != null) {
            this.gv.onInputSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.e
    public void changeOutputSize(int i, int i2) {
        super.changeOutputSize(i, i2);
        if (this.Q != null) {
            this.Q.a(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.createPixelReader(pixelReadParams, pixelReadListener);
    }

    public void d(List<String> list) {
        this.u = list;
    }

    public void h(long j) {
        if (this.gZ != null) {
            this.gZ.setAlgoPts(j);
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void i(boolean z) {
        ARPScene currentScene;
        if (this.ha == null || (currentScene = this.ha.getCurrentScene()) == null) {
            return;
        }
        currentScene.i(z);
    }

    @Override // com.baidu.ar.arrender.k
    public boolean isDriverdByARPVersion() {
        if (this.ha != null) {
            return this.ha.isDriverdByARPVersion();
        }
        return false;
    }

    public void l(boolean z) {
        com.baidu.ar.g.b.k("ARRenderer", "enableSyncRender enable = " + z);
        if (this.gZ != null) {
            this.gZ.setSourceSyncProperty(z);
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void m(boolean z) {
        if (this.ha != null) {
            this.ha.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.k
    public boolean n(boolean z) {
        if (this.ha == null || this.ha.getCurrentScene() == null) {
            return false;
        }
        return this.ha.getCurrentScene().h(z);
    }

    @Override // com.baidu.ar.arrender.k
    public void o(int i) {
        if (this.ha == null || i < 0) {
            return;
        }
        com.baidu.ar.g.b.c("ARRenderer", "removeAlgoCache type = " + i);
        this.ha.removeAlgoType(new int[]{i});
    }

    @Override // com.baidu.ar.arrender.k
    public void o(boolean z) {
        if (this.hc != null) {
            this.hc.k(z);
        }
    }

    @Override // com.baidu.ar.arrender.e, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public /* bridge */ /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        super.onFrameAvailable(surfaceTexture);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        super.onRenderFinished(j);
        if (gF) {
            com.baidu.ar.g.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.gH));
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderStartedListener
    public void onRenderStarted(long j) {
        if (gF) {
            if (this.gH != 0) {
                com.baidu.ar.g.b.c("profile_frame_interval", "= " + (System.currentTimeMillis() - this.gH));
                if (this.gG == 50) {
                    com.baidu.ar.g.b.c("profile_frame_fps_avg", "= " + (50000 / this.gI));
                    com.baidu.ar.g.b.c("profile_frame_interval_avg", "= " + (this.gI / 50));
                    this.gG = 0;
                    this.gI = 0L;
                } else {
                    this.gG++;
                    this.gI += System.currentTimeMillis() - this.gH;
                }
            }
            this.gH = System.currentTimeMillis();
        }
        super.onRenderStarted(j);
        bC();
    }

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.f != null) {
            com.baidu.ar.g.b.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
            this.f.b(4001, com.baidu.ar.arrender.b.a(orientation));
        }
    }

    @Override // com.baidu.ar.arrender.e, android.view.View.OnTouchListener
    public /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    public void pauseScene() {
        com.baidu.ar.g.b.c("ARRenderer", "pauseScene()");
        if (this.ha != null) {
            this.hh = true;
            this.ha.pause();
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void q(boolean z) {
        super.q(z);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void r(boolean z) {
        super.r(z);
    }

    @Override // com.baidu.ar.arrender.e
    public void release() {
        this.u = null;
        this.Q = null;
        this.gv = null;
        super.release();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void removeOutputSurface(DuMixOutput duMixOutput) {
        super.removeOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    public void resumeScene() {
        com.baidu.ar.g.b.c("ARRenderer", "resumeScene()");
        if (this.ha != null) {
            this.ha.resume();
            this.hh = false;
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

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void s(boolean z) {
        super.s(z);
    }

    @Override // com.baidu.ar.arrender.k
    public void sceneRotateToCamera() {
        if (this.ha != null) {
            this.ha.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.k
    public void sceneWorldPositionToOrigin() {
        if (this.ha != null) {
            this.ha.sceneWorldPositionToOrigin();
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setCameraSwitchListener(f fVar) {
        super.setCameraSwitchListener(fVar);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setDefaultPipeLine(String str) {
        super.setDefaultPipeLine(str);
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hg != null) {
            this.hg.a(context, viewGroup, this);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void setLocalDeviceGrade(int i) {
        super.setLocalDeviceGrade(i);
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hg != null) {
            this.hg.b(context, viewGroup, null);
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener) {
        super.setRenderFinishedListener(onRenderFinishedListener);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setRenderStartedListener(OnRenderStartedListener onRenderStartedListener) {
        super.setRenderStartedListener(onRenderStartedListener);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setStateListener(DuMixStateListener duMixStateListener) {
        super.setStateListener(duMixStateListener);
    }

    @Override // com.baidu.ar.arrender.k
    public String updateFilterCase(String str) {
        if (this.gZ != null) {
            return this.gZ.adjustFilterWithCasePathParam(str);
        }
        return null;
    }
}
