package com.baidu.ar.face;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.l;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.f.g;
import com.baidu.ar.face.a.d;
import com.baidu.ar.face.a.h;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.b.a;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class FaceAR extends c implements IFace {
    private static final String TAG = FaceAR.class.getSimpleName();
    private LuaMsgListener ci;
    private e ly;
    private com.baidu.ar.face.attributes.a mO;
    private d mr;
    private FaceListener ms;
    private int[] mx;
    private a.C0085a mz;
    private List<String> mt = new ArrayList();
    private String mu = null;
    private String mv = null;
    private int mw = 0;
    private a.b my = null;
    private int mA = 0;
    private boolean mB = false;
    private boolean mC = false;
    private boolean mD = false;
    private boolean mE = false;
    private boolean mF = false;
    private boolean mG = true;
    private boolean mH = true;
    private int mI = 4;
    private int mJ = this.mI;
    private boolean mK = false;
    private int mL = 180;
    private int mM = 320;
    private AlgoHandleController ch = null;
    private boolean mN = true;
    private int mp = -1;

    private boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String f = g.f(new File(com.baidu.ar.f.a.aI(str)));
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            this.mB = b.b(f, false);
            this.mC = b.c(f, false);
            this.mD = b.d(f, false);
            this.mE = b.e(f, false);
            this.mF = b.f(f, false);
            this.mG = b.g(f, this.mA != 0);
            this.mJ = b.b(f, 1);
            if (this.mJ > 1 && !com.baidu.ar.auth.a.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
                this.mJ = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject.has("mainTriggers")) {
                    this.mt.clear();
                    this.mt.add(jSONObject.getString("mainTriggers"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        if (hVar.dc() == null || hVar.dc().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = hVar.dc().getFaceFrame();
        if (faceFrame.getTriggersList() == null || faceFrame.getTriggersList().size() <= 0) {
            return;
        }
        for (String[] strArr : faceFrame.getTriggersList()) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (this.mu != null && this.mu.contains(str) && this.ms != null) {
                        this.ms.onTriggerFired(str);
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.mK != z && r() != null && this.mp >= 0) {
            r().r(this.mp);
            if (!z2) {
                r().a(this.mp, z);
            }
        }
        this.mK = z;
        if (this.mr != null) {
            this.mr.E(this.mK);
        }
        b(this.mK);
        if (r() != null) {
            r().l(this.mK);
        }
        this.mN = true;
    }

    private void a(int[] iArr) {
        int[] iArr2 = null;
        try {
            iArr2 = b.a(this.mx, iArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr2 != null && iArr != null && iArr.length > this.mw) {
            for (int i : iArr2) {
                HashMap hashMap = new HashMap();
                hashMap.put("param_algo_faceid", String.valueOf(i));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
            }
        } else if (iArr2 != null && (iArr == null || iArr.length < this.mw)) {
            for (int i2 : iArr2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_algo_faceid", String.valueOf(i2));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
            }
        }
        this.mx = iArr;
    }

    private void aj() {
        if (this.ci == null) {
            this.ci = new LuaMsgListener() { // from class: com.baidu.ar.face.FaceAR.2
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    int k = b.k(hashMap);
                    if (k >= 0) {
                        FaceAR.this.a(k == 2, false);
                    }
                }
            };
        }
        a(this.ci);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        if (hVar.dc() == null || hVar.dc().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = hVar.dc().getFaceFrame();
        if (faceFrame.getTrackedPointsList() == null || faceFrame.getTrackedPointsList().size() <= 0) {
            this.mw = 0;
            if (TextUtils.isEmpty(this.mv) || this.mx == null) {
                return;
            }
            a((int[]) null);
            return;
        }
        FAUPoint2D[] fAUPoint2DArr = faceFrame.getTrackedPointsList().get(0);
        int size = faceFrame.getTrackedPointsList().size();
        if (TextUtils.isEmpty(this.mv) || fAUPoint2DArr.length <= 0) {
            return;
        }
        if (faceFrame.getFaceIDList() != null && this.mw != size) {
            a(faceFrame.getFaceIDList());
        }
        this.mw = size;
    }

    private void cM() {
        if (this.mr != null) {
            if (q().contains("ability_face_model")) {
                this.mr.o("ability_face_model");
            } else if (q().contains("ability_makeup_filter")) {
                this.mr.o("ability_makeup_filter");
            }
        }
    }

    private void cN() {
        this.mB = false;
        this.mC = false;
        this.mD = false;
        this.mE = false;
        this.mF = false;
        this.mJ = this.mI;
        this.mG = this.mA != 0;
        this.mH = true;
    }

    private void cO() {
        com.baidu.ar.face.a.a.cT().C(this.mA);
        if (this.mz != null) {
            com.baidu.ar.face.a.a.cT().a(Float.parseFloat(this.mz.oP), Float.parseFloat(this.mz.oQ));
            com.baidu.ar.face.a.a.cT().e(Float.parseFloat(this.mz.oR));
        }
        com.baidu.ar.face.a.a.cT().y(this.mG);
        com.baidu.ar.face.a.a.cT().A(this.mH);
        com.baidu.ar.face.a.a.cT().z(this.mF);
        com.baidu.ar.face.a.a.cT().a(this.mB, this.mC, this.mD);
        com.baidu.ar.face.a.a.cT().B(this.mE);
        int i = this.mJ;
        if (!TextUtils.isEmpty(this.mv)) {
            i = this.mI < this.mJ ? this.mI : this.mJ;
        }
        com.baidu.ar.face.a.a.cT().D(i);
        com.baidu.ar.face.a.a.cT().b(this.my.nn);
    }

    private void cP() {
        int i;
        int i2 = 180;
        if (this.U) {
            this.mL = 180;
            this.mM = 320;
            return;
        }
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
        this.mL = i2;
        this.mM = i;
    }

    private com.baidu.ar.face.a.e cQ() {
        cP();
        com.baidu.ar.face.a.e eVar = new com.baidu.ar.face.a.e();
        eVar.E(this.mL);
        eVar.F(this.mM);
        if (this.my == null) {
            return eVar;
        }
        eVar.V(this.my.oU);
        eVar.W(this.my.oT);
        eVar.ad(this.my.oY);
        eVar.ae(this.my.oZ);
        a.C0085a c0085a = null;
        String str = this.my.oV;
        String str2 = this.my.oW;
        String str3 = this.my.oX;
        com.baidu.ar.f.b.c(TAG, "classification result：" + this.my.pe);
        switch (this.my.pe) {
            case 0:
                this.mI = 1;
                c0085a = this.my.pb;
                break;
            case 1:
                this.mI = 1;
                c0085a = this.my.pc;
                break;
            case 2:
                this.mI = 4;
                c0085a = this.my.pd;
                break;
            default:
                com.baidu.ar.f.b.b(TAG, "createFaceParams() device not support!!!");
                break;
        }
        this.mJ = this.mI;
        if (c0085a != null) {
            this.mz = c0085a;
            this.mA = b.a(c0085a.oM, str, str2, str3);
            eVar.X(c0085a.oL);
            eVar.Y(str);
            eVar.Z(str2);
            eVar.aa(str3);
            eVar.ab(c0085a.oN);
            eVar.ac(c0085a.oO);
            eVar.setTrackingSmoothAlpha(Float.parseFloat(c0085a.oP));
            eVar.setTrackingSmoothThreshold(Float.parseFloat(c0085a.oQ));
            eVar.setTrackingMouthThreshold(Float.parseFloat(c0085a.oR));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR() {
        if (this.mN) {
            x(true);
            this.mN = false;
        }
    }

    private float cS() {
        if (this.R == 0 || this.S == 0) {
            return 56.144978f;
        }
        int i = this.T;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.R : this.S) * 0.5f, 0.94375f * Math.max(this.R, this.S)) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        j r = r();
        if (j <= 0 || r == null || q() == null || q().size() <= 0) {
            return;
        }
        r.a(j, q().get(0));
        a(j);
    }

    private void x(boolean z) {
        com.baidu.ar.filter.a s = s();
        if (s != null) {
            boolean z2 = z && this.mK && q().contains("ability_makeup_filter");
            s.a(FilterNode.makeupFilter, z2);
            s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf(z2 ? 1 : 0));
            s.dw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null) {
            return;
        }
        try {
            if (this.ch.getHandleType(j) != 10 || this.mr == null) {
                return;
            }
            long handleFaceHandle = AlgoHandleAdapter.getHandleFaceHandle(j);
            if (handleFaceHandle > 0) {
                AlgoHandleAdapter.setHandleFaceHandle(j, 0L);
                if (this.mr != null) {
                    this.mr.b(handleFaceHandle);
                }
            }
            this.mr.r(j);
        } catch (Exception e) {
            Log.e("FaceAR", "Destory algoHandle failed.  " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
        cM();
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        com.baidu.ar.f.b.c(TAG, "onCaseCreate start!!!");
        this.mv = str;
        boolean U = U(str);
        if (!U) {
            this.mv = null;
        }
        j r = r();
        if (r != null) {
            r.m(true);
            r.a(cS());
        }
        if (TextUtils.isEmpty(this.mv)) {
            cN();
        } else {
            this.mB = this.mB;
            this.mC = this.mC;
            this.mD = this.mD;
            this.mE = this.mE;
            this.mF = this.mF;
            this.mG = this.mG || this.mA != 0;
            if (!this.mH) {
            }
            this.mH = true;
        }
        if (!U) {
            this.mJ = 1;
        }
        cO();
        if (this.mt != null && this.mt.size() > 0) {
            this.mu = this.mt.get(this.mt.size() - 1);
        }
        if (this.ms != null) {
            this.ms.onStickerLoadingFinished(this.mt);
        }
        if (this.mJ > 1) {
            x(false);
        } else {
            x(true);
        }
        cM();
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        boolean z = true;
        com.baidu.ar.f.b.c(TAG, "onCaseDestroy!!!");
        this.mv = null;
        this.mu = null;
        this.mw = 0;
        if (this.mA != 2 && this.mA != 1) {
            z = false;
        }
        a(z, false);
        a((int[]) null);
        cN();
        cO();
        cM();
    }

    @Override // com.baidu.ar.c
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.c
    public void release() {
        com.baidu.ar.f.b.c(TAG, "release");
        a(false, true);
        a((int[]) null);
        x(false);
        this.mN = false;
        if (this.mr != null) {
            this.mr.a((AlgoHandleController) null);
        }
        a(this.mr);
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        if (this.mO != null) {
            this.mO.release();
        }
        if (r() != null) {
            r().r(10);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.ms = faceListener;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        boolean z = true;
        com.baidu.ar.f.b.c(TAG, "setup");
        super.setup(hashMap);
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        JSONObject t = t();
        com.baidu.ar.face.b.a aVar = new com.baidu.ar.face.b.a();
        if (t == null || t.toString().trim().equals("{}")) {
            com.baidu.ar.f.b.b(TAG, "abilityScheme is null, use default config!");
            this.my = aVar.a(getFaceModelPath(), (JSONObject) null);
        } else {
            com.baidu.ar.f.b.c(TAG, "start parse abilityScheme config: " + t.toString());
            this.my = aVar.a(getFaceModelPath(), t);
        }
        if (r() != null) {
            this.mv = r().bs();
        }
        this.mr = new d();
        this.mr.a(this.ch);
        cM();
        this.ly = new e() { // from class: com.baidu.ar.face.FaceAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                h du;
                if (bVar == null || !(bVar instanceof com.baidu.ar.face.a.g) || (du = ((com.baidu.ar.face.a.g) bVar).du()) == null) {
                    return;
                }
                FaceResultData c = b.c(du);
                l lVar = (l) bVar.cE();
                if (lVar != null) {
                    c.setAlgoImageWidth(lVar.bK());
                    c.setAlgoImageHeight(lVar.bL());
                }
                FaceAR.this.mIsFrontCamera = du.isFrontCamera();
                if (FaceAR.this.mO != null) {
                    FaceAR.this.mO.a(du, c, FaceAR.this.mL, FaceAR.this.mM);
                }
                if (FaceAR.this.ms != null) {
                    FaceAR.this.ms.onFaceResult(c);
                }
                FaceAR.this.q(du.de());
                FaceAR.this.cR();
                FaceAR.this.a(du);
                FaceAR.this.b(du);
            }

            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.l lVar) {
                com.baidu.ar.f.b.c(FaceAR.TAG, "FaceDetector onSetup result = " + lVar.isSuccess());
                FaceAR.this.mp = lVar.cL();
                j r = FaceAR.this.r();
                if (r != null) {
                    r.a(FaceAR.this.mp, FaceAR.this.mK);
                }
            }

            @Override // com.baidu.ar.c.e
            public void b(com.baidu.ar.c.l lVar) {
                com.baidu.ar.f.b.c(FaceAR.TAG, "FaceDetector onRelease result = " + lVar.isSuccess());
            }
        };
        com.baidu.ar.face.a.a.cT().setContext(getContext());
        com.baidu.ar.face.a.e cQ = cQ();
        this.mG = this.mA != 0;
        if (this.mA != 2 && this.mA != 1) {
            z = false;
        }
        a(z, false);
        this.mr.F(u());
        this.mr.a(cQ);
        a(this.mr, this.ly);
        this.mO = new com.baidu.ar.face.attributes.a();
        this.mO.b(getContext(), this.my.pa);
        cO();
        aj();
    }
}
