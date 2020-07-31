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
/* loaded from: classes11.dex */
public class c extends e implements OrientationManager.OrientationListener, j {
    private static boolean hp = true;
    private a Q;
    private Runnable hg;
    private m hh;
    protected Runnable hi;
    protected i hj;
    private Runnable hk;
    private k hl;
    private Runnable hm;
    private float hn;
    private int ho;
    private int hq;
    private long hr;
    private long hs;
    private List<String> u;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, int i2);
    }

    public c(Context context, com.baidu.ar.lua.b bVar) {
        super(context, bVar);
        this.ho = 0;
        this.hq = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, bVar, eGLContext);
        this.ho = 0;
        this.hq = 0;
    }

    private boolean b(com.baidu.ar.ability.c cVar) {
        return this.u == null || !this.u.contains(cVar.Z());
    }

    private void bu() {
        if (!this.hQ || this.ho < 0) {
            return;
        }
        if (this.ho == 3) {
            this.hP.setEngineBlendState(0);
        } else if (this.ho == 0) {
            this.hP.setEngineBlendState(1);
        }
        this.ho--;
    }

    private boolean c(com.baidu.ar.ability.c cVar) {
        return cVar.aa() && cVar.ab() != this.hY;
    }

    private void o(boolean z) {
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

    @Override // com.baidu.ar.arrender.j
    public void a(float f) {
        if (this.hO == null || this.hP == null) {
            return;
        }
        this.hn = f;
        if (this.hm == null) {
            this.hm = new Runnable() { // from class: com.baidu.ar.arrender.c.4
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aY;
                    ARPScene currentScene = c.this.hP.getCurrentScene();
                    if (currentScene == null || (aY = currentScene.aY()) == null) {
                        return;
                    }
                    aY.a(c.this.hn);
                }
            };
        }
        this.hO.cancelAysncRenderTask(this.hm);
        this.hO.runAsyncOnRenderContext(this.hm);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(int i, boolean z) {
        if (this.hP == null || !this.hQ || i < 0) {
            return;
        }
        int[] iArr = {i};
        com.baidu.ar.f.b.c("ARRenderer", "addAlgoCache type = " + i + " && sync = " + z);
        this.hP.addAlgoType(iArr, z ? 1 : 0);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(long j, String str) {
        if (this.hP == null || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ar.ability.c cVar = new com.baidu.ar.ability.c();
        cVar.o(str);
        cVar.setTimestamp(AlgoHandleAdapter.getHandleTimeStamp(j));
        cVar.d(AlgoHandleAdapter.getHandleIsFront(j));
        cVar.c(AlgoHandleAdapter.getHandleEnableSync(j));
        if (a(cVar)) {
            return;
        }
        this.hP.setAlgoDataHandle(j);
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        if (this.hO != null) {
            this.hO.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(PointF pointF, boolean z) {
        b.a(pointF, z, this.W, this.aa);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(ARPEngine.e eVar) {
        if (this.hP != null) {
            this.hP.setInteraction(eVar);
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
        if (this.hO != null) {
            this.hO.setOnNeedCacheFrameListener(onNeedCacheFrameListener);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(TakePictureCallback takePictureCallback) {
        if (this.hO != null) {
            this.hO.getSnapShot(takePictureCallback, this.aa.getOutputWidth(), this.aa.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
        }
    }

    public void a(a aVar) {
        this.Q = aVar;
    }

    @Override // com.baidu.ar.arrender.j
    public void a(h hVar) {
        if (this.hO == null || hVar == null || a((com.baidu.ar.ability.c) hVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateFilterData error!!!");
            return;
        }
        switch (hVar.bI()) {
            case INT:
                this.hO.adjustFilterWithIntParam(hVar.getFilterName(), hVar.bG(), ((Integer) hVar.bH()).intValue(), hVar.getTimestamp());
                return;
            case FLOAT:
                this.hO.adjustFilterWithFloatParam(hVar.getFilterName(), hVar.bG(), ((Float) hVar.bH()).floatValue(), hVar.getTimestamp());
                return;
            case FLOAT_ARRAY:
                this.hO.adjustFilterWithFloatArrayParam(hVar.getFilterName(), hVar.bG(), (float[]) hVar.bH(), hVar.getTimestamp());
                return;
            case STRING:
                this.hO.adjustFilterWithStringParam(hVar.getFilterName(), hVar.bG(), (String) hVar.bH(), hVar.getTimestamp());
                return;
            default:
                com.baidu.ar.f.b.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
                return;
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(final i iVar) {
        if (this.hO == null || iVar == null) {
            com.baidu.ar.f.b.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.hj = iVar;
        if (this.hi == null) {
            this.hi = new Runnable() { // from class: com.baidu.ar.arrender.c.2
                @Override // java.lang.Runnable
                public void run() {
                    ARPScene currentScene;
                    if (c.this.hj == null || TextUtils.isEmpty(c.this.hj.getNodeName()) || c.this.hj.bJ() == null || c.this.hP == null || c.this.a((com.baidu.ar.ability.c) c.this.hj) || (currentScene = c.this.hP.getCurrentScene()) == null || currentScene.D(iVar.getNodeName()) == null) {
                        return;
                    }
                    ARPNode D = currentScene.D(c.this.hj.getNodeName());
                    for (Map.Entry<String, Object> entry : c.this.hj.bJ().entrySet()) {
                        D.a(entry.getKey(), entry.getValue());
                    }
                }
            };
        }
        this.hO.cancelAysncRenderTask(this.hi);
        this.hO.runAsyncOnRenderContext(this.hi);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(k kVar) {
        if (this.hO == null || this.hP == null || kVar == null || a((com.baidu.ar.ability.c) kVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateRenderCameraData error!!!");
            return;
        }
        this.hl = kVar;
        if (this.hk == null) {
            this.hk = new Runnable() { // from class: com.baidu.ar.arrender.c.3
                @Override // java.lang.Runnable
                public void run() {
                    ARPCamera aY;
                    ARPScene currentScene = c.this.hP.getCurrentScene();
                    if (currentScene == null || (aY = currentScene.aY()) == null) {
                        return;
                    }
                    aY.a(c.this.hl.getMatrix());
                }
            };
        }
        this.hO.cancelAysncRenderTask(this.hk);
        this.hO.runAsyncOnRenderContext(this.hk);
    }

    @Override // com.baidu.ar.arrender.j
    public void a(m mVar, boolean z) {
        if (this.hO == null || this.hP == null || mVar == null || a(mVar)) {
            com.baidu.ar.f.b.b("ARRenderer", "updateRenderNodeData error!!!");
        } else if (!z) {
            this.hP.updateAlgoDataToNode(mVar.getWidth(), mVar.getHeight(), mVar.bM());
        } else {
            this.hh = mVar;
            if (this.hg == null) {
                this.hg = new Runnable() { // from class: com.baidu.ar.arrender.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hP.updateAlgoDataToNode(c.this.hh.getWidth(), c.this.hh.getHeight(), c.this.hh.bM());
                    }
                };
            }
            this.hO.cancelAysncRenderTask(this.hg);
            this.hO.runAsyncOnRenderContext(this.hg);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void a(com.baidu.ar.imu.b bVar) {
        if (this.hP != null) {
            this.hP.setImuType(bVar.getTypeValue());
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
        if (this.hO != null) {
            this.hO.setCameraFace(z);
        }
        if (this.hP != null) {
            this.hP.setIsFrontCamera(z);
        }
        if (this.W != null && this.W.isCameraInput()) {
            this.W.setFrontCamera(z);
        }
        o(!z);
        br();
        this.ho = 3;
    }

    protected boolean a(com.baidu.ar.ability.c cVar) {
        return !cVar.ac() && (b(cVar) || c(cVar));
    }

    @Override // com.baidu.ar.arrender.j
    public void aK() {
        if (this.hU != null) {
            this.hU.aK();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public Matrixf4x4 aW() {
        ARPScene currentScene;
        ARPCamera aY;
        if (this.hP == null || (currentScene = this.hP.getCurrentScene()) == null || (aY = currentScene.aY()) == null) {
            return null;
        }
        return aY.aW();
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addOutputSurface(DuMixOutput duMixOutput) {
        super.addOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.arrender.j
    public void b(final String str, final Object obj) {
        if (this.hO == null) {
            return;
        }
        this.hO.runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hT != null) {
                    c.this.hT.setDataPipKV(str, obj);
                }
            }
        });
    }

    public DuMixInput bo() {
        return this.W;
    }

    public DuMixOutput bp() {
        return this.aa;
    }

    @Override // com.baidu.ar.arrender.j
    public void bq() {
        if (this.hO != null) {
            this.hO.disableCaseLutTexture();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void br() {
        onRotateOrientation(OrientationManager.getGlobalOrientation());
    }

    @Override // com.baidu.ar.arrender.j
    public String bs() {
        return this.mCasePath;
    }

    @Override // com.baidu.ar.arrender.j
    public void bt() {
        ARPScene currentScene;
        if (this.hP == null || (currentScene = this.hP.getCurrentScene()) == null) {
            return;
        }
        currentScene.ba();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bv() {
        super.bv();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bw() {
        super.bw();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void bx() {
        super.bx();
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ com.baidu.ar.steploading.d by() {
        return super.by();
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
        if (this.hO != null) {
            this.hO.setAlgoPts(j);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void h(boolean z) {
        ARPScene currentScene;
        if (this.hP == null || (currentScene = this.hP.getCurrentScene()) == null) {
            return;
        }
        currentScene.h(z);
    }

    @Override // com.baidu.ar.arrender.j
    public boolean isDriverdByARPVersion() {
        if (this.hP != null) {
            return this.hP.isDriverdByARPVersion();
        }
        return false;
    }

    public void k(boolean z) {
        com.baidu.ar.f.b.i("ARRenderer", "enableSyncRender enable = " + z);
        if (this.hO != null) {
            this.hO.setSourceSyncProperty(z);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void l(boolean z) {
        if (this.hP != null) {
            this.hP.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.j
    public boolean m(boolean z) {
        if (this.hP == null || this.hP.getCurrentScene() == null) {
            return false;
        }
        return this.hP.getCurrentScene().g(z);
    }

    @Override // com.baidu.ar.arrender.j
    public void n(boolean z) {
        if (this.hR != null) {
            this.hR.j(z);
        }
    }

    @Override // com.baidu.ar.arrender.e, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public /* bridge */ /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        super.onFrameAvailable(surfaceTexture);
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        super.onRenderFinished();
        if (hp) {
            com.baidu.ar.f.b.c("profile_frame_time_cpu", "= " + (System.currentTimeMillis() - this.hr));
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderStartedListener
    public void onRenderStarted() {
        if (hp) {
            if (this.hr != 0) {
                com.baidu.ar.f.b.c("profile_frame_interval", "= " + (System.currentTimeMillis() - this.hr));
                if (this.hq == 50) {
                    com.baidu.ar.f.b.c("profile_frame_fps_avg", "= " + (50000 / this.hs));
                    com.baidu.ar.f.b.c("profile_frame_interval_avg", "= " + (this.hs / 50));
                    this.hq = 0;
                    this.hs = 0L;
                } else {
                    this.hq++;
                    this.hs += System.currentTimeMillis() - this.hr;
                }
            }
            this.hr = System.currentTimeMillis();
        }
        super.onRenderStarted();
        bu();
    }

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.f != null) {
            com.baidu.ar.f.b.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
            this.f.b(4001, b.a(orientation));
        }
    }

    @Override // com.baidu.ar.arrender.e, android.view.View.OnTouchListener
    public /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void p(boolean z) {
        super.p(z);
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    public void pauseScene() {
        com.baidu.ar.f.b.c("ARRenderer", "pauseScene()");
        if (this.hP != null) {
            this.hW = true;
            this.hP.pause();
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void q(boolean z) {
        super.q(z);
    }

    @Override // com.baidu.ar.arrender.j
    public void r(int i) {
        if (this.hP == null || !this.hQ || i < 0) {
            return;
        }
        com.baidu.ar.f.b.c("ARRenderer", "removeAlgoCache type = " + i);
        this.hP.removeAlgoType(new int[]{i});
    }

    @Override // com.baidu.ar.arrender.e
    public void release() {
        this.u = null;
        this.Q = null;
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
        if (this.hP != null) {
            this.hP.resume();
            this.hW = false;
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
        if (this.hP != null) {
            this.hP.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.j
    public void sceneWorldPositionToOrigin() {
        if (this.hP != null) {
            this.hP.sceneWorldPositionToOrigin();
        }
    }

    @Override // com.baidu.ar.arrender.e, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setCameraSwitchListener(f fVar) {
        super.setCameraSwitchListener(fVar);
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hV != null) {
            this.hV.a(context, viewGroup, this);
        }
    }

    @Override // com.baidu.ar.arrender.e
    public /* bridge */ /* synthetic */ void setLocalDeviceGrade(int i) {
        super.setLocalDeviceGrade(i);
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.hV != null) {
            this.hV.b(context, viewGroup, null);
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

    @Override // com.baidu.ar.arrender.j
    public String updateFilterCase(String str) {
        if (this.hO != null) {
            return this.hO.adjustFilterWithCasePathParam(str);
        }
        return null;
    }
}
