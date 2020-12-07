package com.baidu.ar.face;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.n;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.FaceDetector;
import com.baidu.ar.face.detector.j;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.h.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class FaceAR extends com.baidu.ar.c implements IFace {
    private static final String TAG = FaceAR.class.getSimpleName();
    private LuaMsgListener cc;
    private e mv;
    private com.baidu.ar.face.attributes.a nA;
    private FaceDetector np;
    private FaceListener nq;
    private int[] nv;
    private a.C0086a nz;
    private List<String> nr = new ArrayList();
    private String ns = null;
    private String nt = null;
    private int nu = 0;
    private int nw = 0;
    b nx = new b();
    private a.b ny = null;
    private AlgoHandleController cb = null;
    private int nn = -1;
    private boolean nB = false;
    private Object mLock = new Object();

    private boolean Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String f = i.f(new File(com.baidu.ar.h.a.aP(str)));
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            this.nx.b(f, this.nw);
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject.has("mainTriggers")) {
                    this.nr.clear();
                    this.nr.add(jSONObject.getString("mainTriggers"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar.eC() == null || mVar.eC().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eC().getFaceFrame();
        if (faceFrame.getTriggersList() == null || faceFrame.getTriggersList().size() <= 0) {
            return;
        }
        for (String[] strArr : faceFrame.getTriggersList()) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (this.ns != null && this.ns.contains(str)) {
                        if (this.nq != null) {
                            this.nq.onTriggerFired(str);
                        }
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    private void a(int[] iArr) {
        int[] iArr2 = null;
        try {
            iArr2 = c.a(this.nv, iArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr2 != null && iArr != null && iArr.length > this.nu) {
            for (int i : iArr2) {
                HashMap hashMap = new HashMap();
                hashMap.put("param_algo_faceid", String.valueOf(i));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
            }
        } else if (iArr2 != null && (iArr == null || iArr.length < this.nu)) {
            for (int i2 : iArr2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_algo_faceid", String.valueOf(i2));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
            }
        }
        this.nv = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        if (mVar.eC() == null || mVar.eC().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eC().getFaceFrame();
        if (faceFrame.getTrackedPointsList() == null || faceFrame.getTrackedPointsList().size() <= 0) {
            this.nu = 0;
            if (TextUtils.isEmpty(this.nt) || this.nv == null) {
                return;
            }
            a((int[]) null);
            return;
        }
        FAUPoint2D[] fAUPoint2DArr = faceFrame.getTrackedPointsList().get(0);
        int size = faceFrame.getTrackedPointsList().size();
        if (TextUtils.isEmpty(this.nt) || fAUPoint2DArr.length <= 0) {
            return;
        }
        if (faceFrame.getFaceIDList() != null && this.nu != size) {
            a(faceFrame.getFaceIDList());
        }
        this.nu = size;
    }

    private void dl() {
        if (this.np != null) {
            if (q().contains("ability_face_model")) {
                this.np.r("ability_face_model");
            } else if (q().contains("ability_makeup_filter")) {
                this.np.r("ability_makeup_filter");
            }
        }
    }

    private boolean dm() {
        return this.nw == 2 || this.nw == 1;
    }

    private void dn() {
        int i;
        if (this.T) {
            this.nx.dr();
            return;
        }
        int i2 = 180;
        int i3 = this.mInputWidth;
        int i4 = this.mInputHeight;
        if (this.S == 90 || this.S == 270) {
            i3 = this.mInputHeight;
            i4 = this.mInputWidth;
        }
        if (Float.compare((i3 * 1.0f) / i4, (180 * 1.0f) / 320) == 0) {
            i = 320;
        } else if (i3 > i4) {
            i2 = Math.round((180 / i4) * i3);
            i = 180;
        } else {
            i = Math.round(i4 * (180 / i3));
        }
        this.nx.setAlgoImageWidth(i2);
        this.nx.setAlgoImageHeight(i);
    }

    /* renamed from: do  reason: not valid java name */
    private j m17do() {
        dn();
        j jVar = new j();
        jVar.I(this.nx.getAlgoImageWidth());
        jVar.J(this.nx.getAlgoImageHeight());
        if (this.ny != null) {
            jVar.ac(this.ny.pW);
            jVar.ad(this.ny.pV);
            jVar.ak(this.ny.qa);
            jVar.al(this.ny.qb);
            String str = this.ny.pX;
            String str2 = this.ny.pY;
            String str3 = this.ny.pZ;
            com.baidu.ar.h.b.c(TAG, "classification result：" + this.ny.qg);
            a.C0086a a2 = this.nx.a(this.ny);
            if (a2 != null) {
                this.nz = a2;
                this.nw = c.a(a2.pO, str, str2, str3);
                com.baidu.ar.h.b.c(TAG, "createFaceParams() mDeviceModelLevel = " + this.nw);
                jVar.ae(a2.pN);
                jVar.af(str);
                jVar.ag(str2);
                jVar.ah(str3);
                jVar.ai(a2.pP);
                jVar.aj(a2.pQ);
                jVar.setTrackingSmoothAlpha(Float.parseFloat(a2.pR));
                jVar.setTrackingSmoothThreshold(Float.parseFloat(a2.pS));
                jVar.setTrackingMouthThreshold(Float.parseFloat(a2.pT));
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp() {
        if (this.nx.dA()) {
            w(true);
            this.nx.x(false);
        }
    }

    private float dq() {
        if (this.mInputWidth == 0 || this.mInputHeight == 0) {
            return 56.144978f;
        }
        int i = this.S;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.mInputWidth : this.mInputHeight) * 0.5f, 0.94375f * Math.max(this.mInputWidth, this.mInputHeight)) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j) {
        l r = r();
        if (j <= 0 || r == null || q() == null) {
            return;
        }
        try {
            if (q().size() > 0) {
                r.a(j, q().get(0));
            }
        } catch (IndexOutOfBoundsException e) {
            com.baidu.ar.h.b.b(TAG, "updateRenderFaceHandle IndexOutOfBoundsException!!!!");
        } catch (NullPointerException e2) {
            com.baidu.ar.h.b.b(TAG, "updateRenderFaceHandle NullPointerException!!!!");
        }
        a(j);
    }

    private void w(boolean z) {
        com.baidu.ar.filter.a s = s();
        if (s != null) {
            boolean z2 = z && this.nx.dB() && q().contains("ability_makeup_filter");
            s.a(FilterNode.makeupFilter, z2);
            s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf(z2 ? 1 : 0));
            s.eF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null) {
            return;
        }
        try {
            if (this.cb.getHandleType(j) != 10 || this.np == null) {
                return;
            }
            long handleFaceHandle = AlgoHandleAdapter.getHandleFaceHandle(j);
            if (handleFaceHandle > 0) {
                AlgoHandleAdapter.setHandleFaceHandle(j, 0L);
                if (this.np != null) {
                    this.np.b(handleFaceHandle);
                }
            }
            this.np.q(j);
        } catch (Exception e) {
            Log.e("FaceAR", "Destory algoHandle failed.  " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
        dl();
    }

    public void configSyncStatus(boolean z) {
        this.nx.y(z);
        if (this.np != null) {
            this.np.D(z);
        }
        b(z);
        if (r() != null) {
            r().k(z);
        }
        this.nx.x(true);
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        com.baidu.ar.h.b.c(TAG, "onCaseCreate start!!!");
        this.nt = str;
        boolean Y = Y(str);
        if (!Y) {
            this.nt = null;
        }
        l r = r();
        if (r != null) {
            r.l(true);
            r.setFieldOfView(dq());
        }
        if (TextUtils.isEmpty(this.nt)) {
            this.nx.A(this.nw);
        } else {
            this.nx.B(this.nw);
        }
        if (!Y) {
            this.nx.ds();
        }
        this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
        if (this.nr != null && this.nr.size() > 0) {
            this.ns = this.nr.get(this.nr.size() - 1);
        }
        if (this.nq != null) {
            this.nq.onStickerLoadingFinished(this.nr);
        }
        if (this.nx.dD() > 1) {
            w(false);
        } else {
            w(true);
        }
        dl();
        if (this.nA != null) {
            this.nA.reset();
        }
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        com.baidu.ar.h.b.c(TAG, "onCaseDestroy!!!");
        this.nt = null;
        this.ns = null;
        this.nu = 0;
        configSyncStatus(dm());
        a((int[]) null);
        this.nx.A(this.nw);
        this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
        dl();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i, int i2) {
        super.onInputSizeChange(i, i2);
    }

    @Override // com.baidu.ar.c
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.c
    public void release() {
        com.baidu.ar.h.b.c(TAG, "release");
        synchronized (this.mLock) {
            if (this.nB) {
                this.nB = false;
                configSyncStatus(false);
                a((int[]) null);
                w(false);
                this.nx.x(false);
                if (this.np != null) {
                    this.np.a((AlgoHandleController) null);
                }
                a(this.np);
                if (this.cb != null) {
                    this.cb.release();
                    this.cb = null;
                }
                if (this.nA != null) {
                    this.nA.release();
                }
                l r = r();
                if (r != null) {
                    r.q(10);
                }
                super.release();
            }
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.nq = faceListener;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        com.baidu.ar.h.b.c(TAG, "detect_frame setup");
        synchronized (this.mLock) {
            if (this.nB) {
                return;
            }
            this.nB = true;
            boolean equals = (hashMap == null || TextUtils.isEmpty((String) hashMap.get("single_frame"))) ? false : ((String) hashMap.get("single_frame")).equals("true");
            super.setup(hashMap);
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            JSONObject t = t();
            com.baidu.ar.face.a.a aVar = new com.baidu.ar.face.a.a();
            if (t == null || t.toString().trim().equals("{}")) {
                com.baidu.ar.h.b.k(TAG, "abilityScheme is null, use default config!");
                this.ny = aVar.a(getFaceModelPath(), (JSONObject) null);
            } else {
                com.baidu.ar.h.b.c(TAG, "start parse abilityScheme config: " + t.toString());
                this.ny = aVar.a(getFaceModelPath(), t);
            }
            if (r() != null) {
                this.nt = r().bx();
            }
            this.np = new FaceDetector();
            if (equals) {
                this.np.ej();
            } else {
                this.np.ek();
            }
            this.np.a(this.cb);
            dl();
            this.mv = new e() { // from class: com.baidu.ar.face.FaceAR.1
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    m eA;
                    if (bVar == null || !(bVar instanceof com.baidu.ar.face.detector.l) || (eA = ((com.baidu.ar.face.detector.l) bVar).eA()) == null) {
                        return;
                    }
                    FaceResultData c = c.c(eA);
                    n nVar = (n) bVar.dd();
                    if (nVar != null && c != null) {
                        c.setAlgoImageWidth(nVar.bX());
                        c.setAlgoImageHeight(nVar.bY());
                    }
                    FaceAR.this.mIsFrontCamera = eA.isFrontCamera();
                    if (FaceAR.this.nA != null) {
                        FaceAR.this.nA.a(eA, c, FaceAR.this.nx.getAlgoImageWidth(), FaceAR.this.nx.getAlgoImageHeight());
                    }
                    if (FaceAR.this.nq != null) {
                        FaceAR.this.nq.onFaceResult(c);
                    }
                    FaceAR.this.o(eA.dN());
                    FaceAR.this.dp();
                    FaceAR.this.a(eA);
                    FaceAR.this.b(eA);
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    com.baidu.ar.h.b.c(FaceAR.TAG, "FaceDetector onSetup result = " + lVar.isSuccess());
                    FaceAR.this.nn = lVar.dk();
                    l r = FaceAR.this.r();
                    if (r != null) {
                        r.b(FaceAR.this.nn, FaceAR.this.nx.dB());
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    com.baidu.ar.h.b.c(FaceAR.TAG, "FaceDetector onRelease result = " + lVar.isSuccess());
                }
            };
            this.np.p(getContext());
            j m17do = m17do();
            this.nx.z(this.nw);
            configSyncStatus(dm());
            this.np.E(u());
            this.np.b(m17do);
            a(this.np, this.mv);
            this.nA = new com.baidu.ar.face.attributes.a(r());
            this.nA.b(getContext(), this.ny.qc);
            this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
            if (this.cc == null) {
                this.cc = new LuaMsgListener() { // from class: com.baidu.ar.face.FaceAR.2
                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public List<String> getMsgKeyListened() {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                        return arrayList;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public void onLuaMessage(HashMap<String, Object> hashMap2) {
                        int a2 = c.a(hashMap2, FaceAR.this.np.em());
                        if (a2 >= 0) {
                            FaceAR.this.configSyncStatus(a2 == 2);
                        }
                    }
                };
            }
            a(this.cc);
            this.np.b((Bundle) null);
        }
    }
}
