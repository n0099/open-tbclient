package com.baidu.ar.face;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.k;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.FaceDetector;
import com.baidu.ar.face.detector.j;
import com.baidu.ar.face.detector.l;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.g.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class FaceAR extends com.baidu.ar.c implements IFace {
    private static final String TAG = FaceAR.class.getSimpleName();
    private LuaMsgListener bZ;
    private FaceDetector mZ;
    private e mg;
    private FaceListener na;
    private int[] nf;
    private a.C0084a nj;
    private com.baidu.ar.face.attributes.a nk;
    private List<String> nb = new ArrayList();
    private String nc = null;
    private String nd = null;
    private int ne = 0;
    private int ng = 0;
    b nh = new b();
    private a.b ni = null;
    private AlgoHandleController bY = null;
    private int mX = -1;
    private boolean nl = false;
    private Object mLock = new Object();

    private boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String f = i.f(new File(com.baidu.ar.g.a.aM(str)));
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            this.nh.b(f, this.ng);
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject.has("mainTriggers")) {
                    this.nb.clear();
                    this.nb.add(jSONObject.getString("mainTriggers"));
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
        if (mVar.eD() == null || mVar.eD().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eD().getFaceFrame();
        if (faceFrame.getTriggersList() == null || faceFrame.getTriggersList().size() <= 0) {
            return;
        }
        for (String[] strArr : faceFrame.getTriggersList()) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (this.nc != null && this.nc.contains(str) && this.na != null) {
                        this.na.onTriggerFired(str);
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    private void a(int[] iArr) {
        int[] iArr2 = null;
        try {
            iArr2 = c.a(this.nf, iArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr2 != null && iArr != null && iArr.length > this.ne) {
            for (int i : iArr2) {
                HashMap hashMap = new HashMap();
                hashMap.put("param_algo_faceid", String.valueOf(i));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
            }
        } else if (iArr2 != null && (iArr == null || iArr.length < this.ne)) {
            for (int i2 : iArr2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_algo_faceid", String.valueOf(i2));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
            }
        }
        this.nf = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        if (mVar.eD() == null || mVar.eD().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eD().getFaceFrame();
        if (faceFrame.getTrackedPointsList() == null || faceFrame.getTrackedPointsList().size() <= 0) {
            this.ne = 0;
            if (TextUtils.isEmpty(this.nd) || this.nf == null) {
                return;
            }
            a((int[]) null);
            return;
        }
        FAUPoint2D[] fAUPoint2DArr = faceFrame.getTrackedPointsList().get(0);
        int size = faceFrame.getTrackedPointsList().size();
        if (TextUtils.isEmpty(this.nd) || fAUPoint2DArr.length <= 0) {
            return;
        }
        if (faceFrame.getFaceIDList() != null && this.ne != size) {
            a(faceFrame.getFaceIDList());
        }
        this.ne = size;
    }

    private void dm() {
        if (this.mZ != null) {
            if (q().contains("ability_face_model")) {
                this.mZ.p("ability_face_model");
            } else if (q().contains("ability_makeup_filter")) {
                this.mZ.p("ability_makeup_filter");
            }
        }
    }

    private boolean dn() {
        return this.ng == 2 || this.ng == 1;
    }

    /* renamed from: do  reason: not valid java name */
    private void m18do() {
        int i;
        if (this.U) {
            this.nh.ds();
            return;
        }
        int i2 = 180;
        int i3 = this.R;
        int i4 = this.S;
        if (this.T == 90 || this.T == 270) {
            i3 = this.S;
            i4 = this.R;
        }
        if (Float.compare((i3 * 1.0f) / i4, (180 * 1.0f) / 320) == 0) {
            i = 320;
        } else if (i3 > i4) {
            i2 = Math.round((180 / i4) * i3);
            i = 180;
        } else {
            i = Math.round(i4 * (180 / i3));
        }
        this.nh.setAlgoImageWidth(i2);
        this.nh.setAlgoImageHeight(i);
    }

    private j dp() {
        m18do();
        j jVar = new j();
        jVar.G(this.nh.getAlgoImageWidth());
        jVar.H(this.nh.getAlgoImageHeight());
        if (this.ni != null) {
            jVar.Z(this.ni.pG);
            jVar.aa(this.ni.pF);
            jVar.ah(this.ni.pK);
            jVar.ai(this.ni.pL);
            String str = this.ni.pH;
            String str2 = this.ni.pI;
            String str3 = this.ni.pJ;
            com.baidu.ar.g.b.c(TAG, "classification result：" + this.ni.pQ);
            a.C0084a a2 = this.nh.a(this.ni);
            if (a2 != null) {
                this.nj = a2;
                this.ng = c.a(a2.py, str, str2, str3);
                com.baidu.ar.g.b.c(TAG, "createFaceParams() mDeviceModelLevel = " + this.ng);
                jVar.ab(a2.px);
                jVar.ac(str);
                jVar.ad(str2);
                jVar.ae(str3);
                jVar.af(a2.pz);
                jVar.ag(a2.pA);
                jVar.setTrackingSmoothAlpha(Float.parseFloat(a2.pB));
                jVar.setTrackingSmoothThreshold(Float.parseFloat(a2.pC));
                jVar.setTrackingMouthThreshold(Float.parseFloat(a2.pD));
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq() {
        if (this.nh.dB()) {
            y(true);
            this.nh.z(false);
        }
    }

    private float dr() {
        if (this.R == 0 || this.S == 0) {
            return 56.144978f;
        }
        int i = this.T;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.R : this.S) * 0.5f, 0.94375f * Math.max(this.R, this.S)) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        k r = r();
        if (j <= 0 || r == null || q() == null) {
            return;
        }
        try {
            if (q().size() > 0) {
                r.a(j, q().get(0));
            }
        } catch (IndexOutOfBoundsException e) {
            com.baidu.ar.g.b.b(TAG, "updateRenderFaceHandle IndexOutOfBoundsException!!!!");
        } catch (NullPointerException e2) {
            com.baidu.ar.g.b.b(TAG, "updateRenderFaceHandle NullPointerException!!!!");
        }
        a(j);
    }

    private void y(boolean z) {
        com.baidu.ar.filter.a s = s();
        if (s != null) {
            boolean z2 = z && this.nh.dC() && q().contains("ability_makeup_filter");
            s.a(FilterNode.makeupFilter, z2);
            s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf(z2 ? 1 : 0));
            s.eG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null) {
            return;
        }
        try {
            if (this.bY.getHandleType(j) != 10 || this.mZ == null) {
                return;
            }
            long handleFaceHandle = AlgoHandleAdapter.getHandleFaceHandle(j);
            if (handleFaceHandle > 0) {
                AlgoHandleAdapter.setHandleFaceHandle(j, 0L);
                if (this.mZ != null) {
                    this.mZ.b(handleFaceHandle);
                }
            }
            this.mZ.s(j);
        } catch (Exception e) {
            Log.e("FaceAR", "Destory algoHandle failed.  " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
        dm();
    }

    public void configSyncStatus(boolean z) {
        this.nh.A(z);
        if (this.mZ != null) {
            this.mZ.F(z);
        }
        b(z);
        if (r() != null) {
            r().m(z);
        }
        this.nh.z(true);
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        com.baidu.ar.g.b.c(TAG, "onCaseCreate start!!!");
        this.nd = str;
        boolean V = V(str);
        if (!V) {
            this.nd = null;
        }
        k r = r();
        if (r != null) {
            r.n(true);
            r.a(dr());
        }
        if (TextUtils.isEmpty(this.nd)) {
            this.nh.y(this.ng);
        } else {
            this.nh.z(this.ng);
        }
        if (!V) {
            this.nh.dt();
        }
        this.mZ.a(this.nj, this.ng, this.nh, this.ni, this.nd);
        if (this.nb != null && this.nb.size() > 0) {
            this.nc = this.nb.get(this.nb.size() - 1);
        }
        if (this.na != null) {
            this.na.onStickerLoadingFinished(this.nb);
        }
        if (this.nh.dE() > 1) {
            y(false);
        } else {
            y(true);
        }
        dm();
        if (this.nk != null) {
            this.nk.reset();
        }
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        com.baidu.ar.g.b.c(TAG, "onCaseDestroy!!!");
        this.nd = null;
        this.nc = null;
        this.ne = 0;
        configSyncStatus(dn());
        a((int[]) null);
        this.nh.y(this.ng);
        this.mZ.a(this.nj, this.ng, this.nh, this.ni, this.nd);
        dm();
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
        com.baidu.ar.g.b.c(TAG, "release");
        synchronized (this.mLock) {
            if (this.nl) {
                this.nl = false;
                configSyncStatus(false);
                a((int[]) null);
                y(false);
                this.nh.z(false);
                if (this.mZ != null) {
                    this.mZ.a((AlgoHandleController) null);
                }
                a(this.mZ);
                if (this.bY != null) {
                    this.bY.release();
                    this.bY = null;
                }
                if (this.nk != null) {
                    this.nk.release();
                }
                k r = r();
                if (r != null) {
                    r.o(10);
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
        this.na = faceListener;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        com.baidu.ar.g.b.c(TAG, "detect_frame setup");
        synchronized (this.mLock) {
            if (this.nl) {
                return;
            }
            this.nl = true;
            boolean equals = (hashMap == null || TextUtils.isEmpty((String) hashMap.get("single_frame"))) ? false : ((String) hashMap.get("single_frame")).equals("true");
            super.setup(hashMap);
            if (this.bY == null) {
                this.bY = new AlgoHandleController();
            }
            JSONObject t = t();
            com.baidu.ar.face.a.a aVar = new com.baidu.ar.face.a.a();
            if (t == null || t.toString().trim().equals("{}")) {
                com.baidu.ar.g.b.k(TAG, "abilityScheme is null, use default config!");
                this.ni = aVar.a(getFaceModelPath(), (JSONObject) null);
            } else {
                com.baidu.ar.g.b.c(TAG, "start parse abilityScheme config: " + t.toString());
                this.ni = aVar.a(getFaceModelPath(), t);
            }
            if (r() != null) {
                this.nd = r().bA();
            }
            this.mZ = new FaceDetector();
            if (equals) {
                this.mZ.ek();
            } else {
                this.mZ.el();
            }
            this.mZ.a(this.bY);
            dm();
            this.mg = new e() { // from class: com.baidu.ar.face.FaceAR.1
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    m eB;
                    if (bVar == null || !(bVar instanceof l) || (eB = ((l) bVar).eB()) == null) {
                        return;
                    }
                    FaceResultData c = c.c(eB);
                    com.baidu.ar.arrender.m mVar = (com.baidu.ar.arrender.m) bVar.de();
                    if (mVar != null && c != null) {
                        c.setAlgoImageWidth(mVar.bY());
                        c.setAlgoImageHeight(mVar.bZ());
                    }
                    FaceAR.this.mIsFrontCamera = eB.isFrontCamera();
                    if (FaceAR.this.nk != null) {
                        FaceAR.this.nk.a(eB, c, FaceAR.this.nh.getAlgoImageWidth(), FaceAR.this.nh.getAlgoImageHeight());
                    }
                    if (FaceAR.this.na != null) {
                        FaceAR.this.na.onFaceResult(c);
                    }
                    FaceAR.this.q(eB.dO());
                    FaceAR.this.dq();
                    FaceAR.this.a(eB);
                    FaceAR.this.b(eB);
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    com.baidu.ar.g.b.c(FaceAR.TAG, "FaceDetector onSetup result = " + lVar.isSuccess());
                    FaceAR.this.mX = lVar.dl();
                    k r = FaceAR.this.r();
                    if (r != null) {
                        r.b(FaceAR.this.mX, FaceAR.this.nh.dC());
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    com.baidu.ar.g.b.c(FaceAR.TAG, "FaceDetector onRelease result = " + lVar.isSuccess());
                }
            };
            this.mZ.o(getContext());
            j dp = dp();
            this.nh.x(this.ng);
            configSyncStatus(dn());
            this.mZ.G(u());
            this.mZ.b(dp);
            a(this.mZ, this.mg);
            this.nk = new com.baidu.ar.face.attributes.a(r());
            this.nk.b(getContext(), this.ni.pM);
            this.mZ.a(this.nj, this.ng, this.nh, this.ni, this.nd);
            if (this.bZ == null) {
                this.bZ = new LuaMsgListener() { // from class: com.baidu.ar.face.FaceAR.2
                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public List<String> getMsgKeyListened() {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                        return arrayList;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public void onLuaMessage(HashMap<String, Object> hashMap2) {
                        int a2 = c.a(hashMap2, FaceAR.this.mZ.en());
                        if (a2 >= 0) {
                            FaceAR.this.configSyncStatus(a2 == 2);
                        }
                    }
                };
            }
            a(this.bZ);
            this.mZ.b((Bundle) null);
        }
    }
}
