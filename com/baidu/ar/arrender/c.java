package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
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
/* loaded from: classes3.dex */
public class c extends e implements OrientationManager.OrientationListener, j {
    private static boolean hf = true;
    private a R;
    private Runnable gU;
    private m gV;
    protected Runnable gW;
    protected l gX;
    protected Runnable gY;
    protected i gZ;
    private Runnable ha;
    private k hb;
    private Runnable hc;
    private float hd;
    private int he;
    private int hg;
    private long hh;
    private long hi;
    private ARPEngine.e mAlgoCallback;
    private List<String> t;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, int i2);
    }

    public c(Context context, com.baidu.ar.lua.b bVar) {
        super(context, bVar);
        this.he = 0;
        this.hg = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, bVar, eGLContext);
        this.he = 0;
        this.hg = 0;
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        return this.t == null || !this.t.contains(cVar.L());
    }

    private void bg() {
        if (!this.hC || this.he < 0) {
            return;
        }
        if (this.he == 3) {
            this.hB.setEngineBlendState(0);
        } else if (this.he == 0) {
            this.hB.setEngineBlendState(1);
        }
        this.he--;
    }

    private boolean c(com.baidu.ar.ability.c cVar) {
        return cVar.M() && cVar.N() != this.hK;
    }

    private void p(boolean z) {
        if (this.e == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10200);
        hashMap.put("front_camera", Integer.valueOf(z ? 0 : 1));
        this.e.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void F() {
        super.F();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void I(String str) {
        super.I(str);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(float f) {
        if (this.hA == null || this.hB == null) {
            return;
        }
        this.hd = f;
        if (this.hc == null) {
            this.hc = new Runnable() { // from class: com.baidu.ar.arrender.c.5
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aK;
                    ARPScene currentScene = c.this.hB.getCurrentScene();
                    if (currentScene == null || (aK = currentScene.aK()) == null) {
                        return;
                    }
                    aK.a(c.this.hd);
                }
            };
        }
        this.hA.cancelAysncRenderTask(this.hc);
        this.hA.runAsyncOnRenderContext(this.hc);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(long j, String str) {
        if (this.hB != null && j > 0 && !TextUtils.isEmpty(str)) {
            com.baidu.ar.ability.c cVar = new com.baidu.ar.ability.c();
            cVar.o(str);
            cVar.setTimestamp(AlgoHandleAdapter.getHandleTimeStamp(j));
            cVar.d(AlgoHandleAdapter.getHandleIsFront(j));
            cVar.c(AlgoHandleAdapter.getHandleEnableSync(j));
            if (!a(cVar)) {
                this.hB.setAlgoDataHandle(str, j);
                return;
            }
        }
        if (this.mAlgoCallback != null) {
            this.mAlgoCallback.a(j);
        }
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        if (this.hA != null) {
            this.hA.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(PointF pointF, boolean z) {
        b.a(pointF, z, this.aa, this.ab);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    public void a(ARPEngine.e eVar) {
        this.mAlgoCallback = eVar;
        if (this.hB != null) {
            this.hB.setAlgoCallBack(eVar);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(ARPEngine.g gVar) {
        if (this.hB != null) {
            this.hB.setInteraction(gVar);
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
        if (this.hA != null) {
            this.hA.setOnNeedCacheFrameListener(onNeedCacheFrameListener);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(TakePictureCallback takePictureCallback) {
        if (this.hA != null) {
            this.hA.getSnapShot(takePictureCallback, this.ab.getOutputWidth(), this.ab.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
        }
    }

    public void a(a aVar) {
        this.R = aVar;
    }

    @Override // com.baidu.ar.arrender.j
    public void a(h hVar) {
        if (this.hA == null || hVar == null || a((com.baidu.ar.ability.c) hVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateFilterData error!!!");
            return;
        }
        switch (hVar.bt()) {
            case INT:
                this.hA.adjustFilterWithIntParam(hVar.getFilterName(), hVar.br(), ((Integer) hVar.bs()).intValue(), hVar.getTimestamp());
                return;
            case FLOAT:
                this.hA.adjustFilterWithFloatParam(hVar.getFilterName(), hVar.br(), ((Float) hVar.bs()).floatValue(), hVar.getTimestamp());
                return;
            case FLOAT_ARRAY:
                this.hA.adjustFilterWithFloatArrayParam(hVar.getFilterName(), hVar.br(), (float[]) hVar.bs(), hVar.getTimestamp());
                return;
            case STRING:
                this.hA.adjustFilterWithStringParam(hVar.getFilterName(), hVar.br(), (String) hVar.bs(), hVar.getTimestamp());
                return;
            default:
                com.baidu.ar.f.b.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
                return;
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(final i iVar) {
        if (this.hA == null || iVar == null) {
            com.baidu.ar.f.b.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.gZ = iVar;
        if (this.gY == null) {
            this.gY = new Runnable() { // from class: com.baidu.ar.arrender.c.2
                @Override // java.lang.Runnable
                public void run() {
                    ARPScene currentScene;
                    if (c.this.gZ == null || TextUtils.isEmpty(c.this.gZ.getNodeName()) || c.this.gZ.bu() == null || c.this.hB == null || c.this.a((com.baidu.ar.ability.c) c.this.gZ) || (currentScene = c.this.hB.getCurrentScene()) == null || currentScene.D(iVar.getNodeName()) == null) {
                        return;
                    }
                    ARPNode D = currentScene.D(c.this.gZ.getNodeName());
                    for (Map.Entry<String, Object> entry : c.this.gZ.bu().entrySet()) {
                        D.a(entry.getKey(), entry.getValue());
                    }
                }
            };
        }
        this.hA.cancelAysncRenderTask(this.gY);
        this.hA.runAsyncOnRenderContext(this.gY);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(k kVar) {
        if (this.hA == null || this.hB == null || kVar == null || a((com.baidu.ar.ability.c) kVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateRenderCameraData error!!!");
            return;
        }
        this.hb = kVar;
        if (this.ha == null) {
            this.ha = new Runnable() { // from class: com.baidu.ar.arrender.c.4
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aK;
                    ARPScene currentScene = c.this.hB.getCurrentScene();
                    if (currentScene == null || (aK = currentScene.aK()) == null) {
                        return;
                    }
                    aK.a(c.this.hb.getMatrix());
                }
            };
        }
        this.hA.cancelAysncRenderTask(this.ha);
        this.hA.runAsyncOnRenderContext(this.ha);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(l lVar, boolean z) {
        if (this.hA == null || this.hB == null || lVar == null || a(lVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateRenderFaceData error!!!");
        } else if (!z) {
            this.hB.setFaceLandMarkImageSize(lVar.bw(), lVar.bx());
            this.hB.setFaceFrame(lVar.bv(), lVar.getTimestamp());
        } else {
            this.gX = lVar;
            if (this.gW == null) {
                this.gW = new Runnable() { // from class: com.baidu.ar.arrender.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hB.setFaceLandMarkImageSize(c.this.gX.bw(), c.this.gX.bx());
                        c.this.hB.setFaceFrame(c.this.gX.bv(), c.this.gX.getTimestamp());
                    }
                };
            }
            this.hA.cancelAysncRenderTask(this.gW);
            this.hA.runAsyncOnRenderContext(this.gW);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(m mVar, boolean z) {
        if (this.hA == null || this.hB == null || mVar == null || a(mVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateRenderNodeData error!!!");
        } else if (!z) {
            this.hB.updateAlgoDataToNode(mVar.getWidth(), mVar.getHeight(), mVar.by());
        } else {
            this.gV = mVar;
            if (this.gU == null) {
                this.gU = new Runnable() { // from class: com.baidu.ar.arrender.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hB.updateAlgoDataToNode(c.this.gV.getWidth(), c.this.gV.getHeight(), c.this.gV.by());
                    }
                };
            }
            this.hA.cancelAysncRenderTask(this.gU);
            this.hA.runAsyncOnRenderContext(this.gU);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(com.baidu.ar.imu.b bVar) {
        if (this.hB != null) {
            this.hB.setImuType(bVar.getTypeValue());
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    @Override // com.baidu.ar.arrender.e
    protected void a(boolean z) {
        com.baidu.ar.f.b.c("ARRenderer", "onCameraSwitch front = " + z);
        super.a(z);
        if (this.hA != null) {
            this.hA.setCameraFace(z);
        }
        if (this.hB != null) {
            this.hB.setIsFrontCamera(z);
        }
        if (this.aa != null && this.aa.isCameraInput()) {
            this.aa.setFrontCamera(z);
        }
        p(!z);
        bd();
        this.he = 3;
    }

    protected boolean a(com.baidu.ar.ability.c cVar) {
        return !cVar.O() && (b(cVar) || c(cVar));
    }

    @Override // com.baidu.ar.arrender.j
    public Matrixf4x4 aI() {
        ARPScene currentScene;
        ARPCamera aK;
        if (this.hB == null || (currentScene = this.hB.getCurrentScene()) == null || (aK = currentScene.aK()) == null) {
            return null;
        }
        return aK.aI();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addOutputSurface(DuMixOutput duMixOutput) {
        super.addOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.j
    public void aw() {
        if (this.hG != null) {
            this.hG.aw();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void b(final String str, final Object obj) {
        if (this.hA == null) {
            return;
        }
        this.hA.runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hF != null) {
                    c.this.hF.setDataPipKV(str, obj);
                }
            }
        });
    }

    public DuMixInput ba() {
        return this.aa;
    }

    public DuMixOutput bb() {
        return this.ab;
    }

    @Override // com.baidu.ar.arrender.j
    public void bc() {
        if (this.hA != null) {
            this.hA.disableCaseLutTexture();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void bd() {
        onRotateOrientation(OrientationManager.getGlobalOrientation());
    }

    @Override // com.baidu.ar.arrender.j
    public String be() {
        return this.aB;
    }

    @Override // com.baidu.ar.arrender.j
    public void bf() {
        ARPScene currentScene;
        if (this.hB == null || (currentScene = this.hB.getCurrentScene()) == null) {
            return;
        }
        currentScene.aM();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bh() {
        super.bh();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bi() {
        super.bi();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ com.baidu.ar.steploading.d bj() {
        return super.bj();
    }

    public void c(List<String> list) {
        this.t = list;
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void cancelAysncRenderTask(Runnable runnable) {
        super.cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.e
    public void changeOutputSize(int i, int i2) {
        super.changeOutputSize(i, i2);
        if (this.R != null) {
            this.R.a(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.createPixelReader(pixelReadParams, pixelReadListener);
    }

    public void h(long j) {
        if (this.hA != null) {
            this.hA.setAlgoPts(j);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void i(boolean z) {
        ARPScene currentScene;
        if (this.hB == null || (currentScene = this.hB.getCurrentScene()) == null) {
            return;
        }
        currentScene.i(z);
    }

    @Override // com.baidu.ar.arrender.j
    public boolean isDriverdByARPVersion() {
        if (this.hB != null) {
            return this.hB.isDriverdByARPVersion();
        }
        return false;
    }

    public void l(boolean z) {
        com.baidu.ar.f.b.i("ARRenderer", "enableSyncRender enable = " + z);
        if (this.hA != null) {
            this.hA.setSourceSyncProperty(z);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void m(boolean z) {
        if (this.hB != null) {
            this.hB.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public boolean n(boolean z) {
        if (this.hB == null || this.hB.getCurrentScene() == null) {
            return false;
        }
        return this.hB.getCurrentScene().h(z);
    }

    @Override // com.baidu.ar.arrender.j
    public void o(boolean z) {
        if (this.hD != null) {
            this.hD.k(z);
        }
    }

    @Override // com.baidu.ar.arrender.e, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public /* bridge */ /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        super.onFrameAvailable(surfaceTexture);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        super.onRenderFinished();
        if (hf) {
            com.baidu.ar.f.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.hh));
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderStartedListener
    public void onRenderStarted() {
        if (hf) {
            if (this.hh != 0) {
                com.baidu.ar.f.b.c("profile_frame_interval", "= " + (System.currentTimeMillis() - this.hh));
                if (this.hg == 50) {
                    com.baidu.ar.f.b.c("profile_frame_fps_avg", "= " + (50000 / this.hi));
                    com.baidu.ar.f.b.c("profile_frame_interval_avg", "= " + (this.hi / 50));
                    this.hg = 0;
                    this.hi = 0L;
                } else {
                    this.hg++;
                    this.hi += System.currentTimeMillis() - this.hh;
                }
            }
            this.hh = System.currentTimeMillis();
        }
        super.onRenderStarted();
        bg();
    }

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.e != null) {
            com.baidu.ar.f.b.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
            this.e.b(4001, b.a(orientation));
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
        com.baidu.ar.f.b.c("ARRenderer", "pauseScene()");
        if (this.hB != null) {
            this.hI = true;
            this.hB.pause();
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
        this.t = null;
        this.R = null;
        this.mAlgoCallback = null;
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
        com.baidu.ar.f.b.c("ARRenderer", "resumeScene()");
        if (this.hB != null) {
            this.hB.resume();
            this.hI = false;
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

    @Override // com.baidu.ar.arrender.j
    public void sceneRotateToCamera() {
        if (this.hB != null) {
            this.hB.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void sceneWorldPositionToOrigin() {
        if (this.hB != null) {
            this.hB.sceneWorldPositionToOrigin();
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setCameraSwitchListener(f fVar) {
        super.setCameraSwitchListener(fVar);
    }

    @Override // com.baidu.ar.arrender.j
    public void setFaceCallBack(ARPEngine.f fVar) {
        if (this.hB != null) {
            this.hB.setFaceCallBack(fVar);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hH != null) {
            this.hH.a(context, viewGroup, this);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void setLocalDeviceGrade(int i) {
        super.setLocalDeviceGrade(i);
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hH != null) {
            this.hH.b(context, viewGroup, null);
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

    @Override // com.baidu.ar.arrender.j
    public String updateFilterCase(String str) {
        if (this.hA != null) {
            return this.hA.adjustFilterWithCasePathParam(str);
        }
        return null;
    }
}
