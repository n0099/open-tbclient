package com.baidu.ar.face;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.searchbox.player.model.YYOption;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FaceAR extends com.baidu.ar.c implements IFace {
    public static final String TAG = "FaceAR";
    public LuaMsgListener cc;
    public e mv;
    public com.baidu.ar.face.attributes.a nA;
    public FaceDetector np;
    public FaceListener nq;
    public int[] nv;
    public a.C0060a nz;
    public List<String> nr = new ArrayList();
    public String ns = null;
    public String nt = null;
    public int nu = 0;
    public int nw = 0;
    public b nx = new b();
    public a.b ny = null;
    public AlgoHandleController cb = null;
    public int nn = -1;
    public boolean nB = false;
    public Object mLock = new Object();

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
                    return true;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
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
                    String str2 = this.ns;
                    if (str2 != null && str2.contains(str)) {
                        FaceListener faceListener = this.nq;
                        if (faceListener != null) {
                            faceListener.onTriggerFired(str);
                        }
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    private void a(int[] iArr) {
        int[] iArr2;
        try {
            iArr2 = c.a(this.nv, iArr);
        } catch (Exception e) {
            e.printStackTrace();
            iArr2 = null;
        }
        int i = 0;
        if (iArr2 != null && iArr != null && iArr.length > this.nu) {
            int length = iArr2.length;
            while (i < length) {
                int i2 = iArr2[i];
                HashMap hashMap = new HashMap();
                hashMap.put("param_algo_faceid", String.valueOf(i2));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
                i++;
            }
        } else if (iArr2 != null && (iArr == null || iArr.length < this.nu)) {
            int length2 = iArr2.length;
            while (i < length2) {
                int i3 = iArr2[i];
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_algo_faceid", String.valueOf(i3));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
                i++;
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
            String str = "ability_face_model";
            if (!q().contains("ability_face_model")) {
                str = "ability_makeup_filter";
                if (!q().contains("ability_makeup_filter")) {
                    return;
                }
            }
            this.np.r(str);
        }
    }

    private boolean dm() {
        int i = this.nw;
        return i == 2 || i == 1;
    }

    private void dn() {
        if (this.f1034T) {
            this.nx.dr();
            return;
        }
        int i = 180;
        int i2 = 320;
        int i3 = this.mInputWidth;
        int i4 = this.mInputHeight;
        int i5 = this.S;
        if (i5 == 90 || i5 == 270) {
            i3 = this.mInputHeight;
            i4 = this.mInputWidth;
        }
        float f = i3;
        float f2 = i4;
        float f3 = 180;
        if (Float.compare((f * 1.0f) / f2, (1.0f * f3) / 320) != 0) {
            if (i3 > i4) {
                i = Math.round(f * (f3 / f2));
                i2 = 180;
            } else {
                i2 = Math.round(f2 * (f3 / f));
            }
        }
        this.nx.setAlgoImageWidth(i);
        this.nx.setAlgoImageHeight(i2);
    }

    /* renamed from: do  reason: not valid java name */
    private j m46do() {
        dn();
        j jVar = new j();
        jVar.I(this.nx.getAlgoImageWidth());
        jVar.J(this.nx.getAlgoImageHeight());
        a.b bVar = this.ny;
        if (bVar == null) {
            return jVar;
        }
        jVar.ac(bVar.pW);
        jVar.ad(this.ny.pV);
        jVar.ak(this.ny.qa);
        jVar.al(this.ny.qb);
        a.b bVar2 = this.ny;
        String str = bVar2.pX;
        String str2 = bVar2.pY;
        String str3 = bVar2.pZ;
        String str4 = TAG;
        com.baidu.ar.h.b.c(str4, "classification result：" + this.ny.qg);
        a.C0060a a = this.nx.a(this.ny);
        if (a != null) {
            this.nz = a;
            this.nw = c.a(a.pO, str, str2, str3);
            String str5 = TAG;
            com.baidu.ar.h.b.c(str5, "createFaceParams() mDeviceModelLevel = " + this.nw);
            jVar.ae(a.pN);
            jVar.af(str);
            jVar.ag(str2);
            jVar.ah(str3);
            jVar.ai(a.pP);
            jVar.aj(a.pQ);
            jVar.setTrackingSmoothAlpha(Float.parseFloat(a.pR));
            jVar.setTrackingSmoothThreshold(Float.parseFloat(a.pS));
            jVar.setTrackingMouthThreshold(Float.parseFloat(a.pT));
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
        int i;
        if (this.mInputWidth == 0 || (i = this.mInputHeight) == 0) {
            return 56.144978f;
        }
        int i2 = this.S;
        if (i2 == 90 || i2 == 270) {
            i = this.mInputWidth;
        }
        return (float) (((Math.atan2(i * 0.5f, Math.max(this.mInputWidth, this.mInputHeight) * 0.94375f) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j) {
        String str;
        String str2;
        l r = r();
        if (j <= 0 || r == null || q() == null) {
            return;
        }
        try {
            if (q().size() > 0) {
                r.a(j, q().get(0));
            }
        } catch (IndexOutOfBoundsException unused) {
            str = TAG;
            str2 = "updateRenderFaceHandle IndexOutOfBoundsException!!!!";
            com.baidu.ar.h.b.b(str, str2);
            a(j);
        } catch (NullPointerException unused2) {
            str = TAG;
            str2 = "updateRenderFaceHandle NullPointerException!!!!";
            com.baidu.ar.h.b.b(str, str2);
            a(j);
        }
        a(j);
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    private void w(boolean z) {
        com.baidu.ar.filter.a s = s();
        if (s != null) {
            ?? r3 = (z && this.nx.dB() && q().contains("ability_makeup_filter")) ? 1 : 0;
            s.a(FilterNode.makeupFilter, (boolean) r3);
            s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf((int) r3));
            s.eF();
        }
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null) {
            return;
        }
        try {
            if (algoHandleController.getHandleType(j) != 10 || this.np == null) {
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
            Log.e(TAG, "Destory algoHandle failed.  " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
        dl();
    }

    public void configSyncStatus(boolean z) {
        this.nx.y(z);
        FaceDetector faceDetector = this.np;
        if (faceDetector != null) {
            faceDetector.D(z);
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
        List<String> list = this.nr;
        if (list != null && list.size() > 0) {
            List<String> list2 = this.nr;
            this.ns = list2.get(list2.size() - 1);
        }
        FaceListener faceListener = this.nq;
        if (faceListener != null) {
            faceListener.onStickerLoadingFinished(this.nr);
        }
        if (this.nx.dD() > 1) {
            w(false);
        } else {
            w(true);
        }
        dl();
        com.baidu.ar.face.attributes.a aVar = this.nA;
        if (aVar != null) {
            aVar.reset();
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
                FaceDetector faceDetector = this.np;
                if (faceDetector != null) {
                    faceDetector.a((AlgoHandleController) null);
                }
                a(this.np);
                AlgoHandleController algoHandleController = this.cb;
                if (algoHandleController != null) {
                    algoHandleController.release();
                    this.cb = null;
                }
                com.baidu.ar.face.attributes.a aVar = this.nA;
                if (aVar != null) {
                    aVar.release();
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
        a.b a;
        com.baidu.ar.h.b.c(TAG, "detect_frame setup");
        synchronized (this.mLock) {
            if (this.nB) {
                return;
            }
            this.nB = true;
            boolean z = false;
            if (hashMap != null && !TextUtils.isEmpty((String) hashMap.get("single_frame"))) {
                z = ((String) hashMap.get("single_frame")).equals(YYOption.IsLive.VALUE_TRUE);
            }
            super.setup(hashMap);
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            JSONObject t = t();
            com.baidu.ar.face.a.a aVar = new com.baidu.ar.face.a.a();
            if (t == null || t.toString().trim().equals("{}")) {
                com.baidu.ar.h.b.k(TAG, "abilityScheme is null, use default config!");
                a = aVar.a(getFaceModelPath(), (JSONObject) null);
            } else {
                String str = TAG;
                com.baidu.ar.h.b.c(str, "start parse abilityScheme config: " + t.toString());
                a = aVar.a(getFaceModelPath(), t);
            }
            this.ny = a;
            if (r() != null) {
                this.nt = r().bx();
            }
            FaceDetector faceDetector = new FaceDetector();
            this.np = faceDetector;
            if (z) {
                faceDetector.ej();
            } else {
                faceDetector.ek();
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
                    String str2 = FaceAR.TAG;
                    com.baidu.ar.h.b.c(str2, "FaceDetector onSetup result = " + lVar.isSuccess());
                    FaceAR.this.nn = lVar.dk();
                    l r = FaceAR.this.r();
                    if (r != null) {
                        r.b(FaceAR.this.nn, FaceAR.this.nx.dB());
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    String str2 = FaceAR.TAG;
                    com.baidu.ar.h.b.c(str2, "FaceDetector onRelease result = " + lVar.isSuccess());
                }
            };
            this.np.p(getContext());
            j m46do = m46do();
            this.nx.z(this.nw);
            configSyncStatus(dm());
            this.np.E(u());
            this.np.b(m46do);
            a(this.np, this.mv);
            com.baidu.ar.face.attributes.a aVar2 = new com.baidu.ar.face.attributes.a(r());
            this.nA = aVar2;
            aVar2.b(getContext(), this.ny.qc);
            this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
            if (this.cc == null) {
                this.cc = new LuaMsgListener() { // from class: com.baidu.ar.face.FaceAR.2
                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public List<String> getMsgKeyListened() {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("event_name");
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
