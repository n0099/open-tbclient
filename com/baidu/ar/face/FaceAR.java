package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arrender.h;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.l;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.f.g;
import com.baidu.ar.face.a.d;
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
/* loaded from: classes3.dex */
public class FaceAR extends c implements ARPEngine.f, IFace {
    private static final String TAG = FaceAR.class.getSimpleName();
    private LuaMsgListener bV;
    private d lS;
    private FaceListener lT;
    private h lU;
    private h lV;
    private e lb;
    private int[] ma;
    private a.C0081a mc;
    private com.baidu.ar.face.attributes.a mr;
    private List<String> lW = new ArrayList();
    private String lX = null;
    private String lY = null;
    private int lZ = 0;
    private a.b mb = null;
    private int md = 0;
    private boolean me = false;
    private boolean mf = false;
    private boolean mg = false;
    private boolean mh = false;
    private boolean mi = false;
    private boolean mj = true;
    private boolean mk = true;
    private int ml = 4;
    private int mm = this.ml;
    private boolean mn = false;
    private int mo = 180;
    private int mp = 320;
    private AlgoHandleController bU = null;
    private boolean mq = true;

    private boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String f = g.f(new File(com.baidu.ar.f.a.aH(str)));
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            this.me = b.b(f, false);
            this.mf = b.c(f, false);
            this.mg = b.d(f, false);
            this.mh = b.e(f, false);
            this.mi = b.f(f, false);
            this.mj = b.g(f, this.md != 0);
            this.mm = b.b(f, 1);
            if (this.mm > 1 && !com.baidu.ar.auth.a.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
                this.mm = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject.has("mainTriggers")) {
                    this.lW.clear();
                    this.lW.add(jSONObject.getString("mainTriggers"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private void V() {
        if (this.bV == null) {
            this.bV = new LuaMsgListener() { // from class: com.baidu.ar.face.FaceAR.2
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
                        FaceAR.this.mn = k == 2;
                        FaceAR.this.cy();
                    }
                }
            };
        }
        a(this.bV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (q().contains("ability_face_model") || q().contains("ability_makeup_filter")) {
            j r = r();
            if (lVar != null && r != null) {
                r.a(lVar, false);
            }
        }
        if (this.mq) {
            y(true);
            this.mq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.face.a.h hVar) {
        if (hVar.cN() == null || hVar.cN().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = hVar.cN().getFaceFrame();
        if (faceFrame.getTriggersList() == null || faceFrame.getTriggersList().size() <= 0) {
            return;
        }
        for (String[] strArr : faceFrame.getTriggersList()) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (this.lX != null && this.lX.contains(str) && this.lT != null) {
                        this.lT.onTriggerFired(str);
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.face.a.h hVar, String str) {
        if (this.lU == null) {
            this.lU = new h();
            this.lU.setFilterName("globalFaceFilter");
            this.lU.K("landmarks");
        }
        if (c(hVar)) {
            d(hVar);
            if (this.lV == null) {
                this.lV = new h();
                this.lV.setFilterName("globalFaceFilter");
                this.lV.K("faceCount");
            }
            this.lV.q(hVar.cN().getFaceFrame().getTrackedPointsList().size());
            this.lV.setTimestamp(hVar.getTimestamp());
            this.lV.o(str);
            if (r() != null) {
                r().a(this.lV);
            }
        } else {
            this.lU.b((float[]) null);
            this.lU.setTimestamp(0L);
        }
        this.lU.o(str);
        if (r() != null) {
            r().a(this.lU);
        }
    }

    private void a(int[] iArr) {
        int[] iArr2 = null;
        try {
            iArr2 = b.a(this.ma, iArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr2 != null && iArr != null && iArr.length > this.lZ) {
            for (int i : iArr2) {
                HashMap hashMap = new HashMap();
                hashMap.put("param_algo_faceid", String.valueOf(i));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
            }
        } else if (iArr2 != null && (iArr == null || iArr.length < this.lZ)) {
            for (int i2 : iArr2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_algo_faceid", String.valueOf(i2));
                StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
            }
        }
        this.ma = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.ar.face.a.h hVar) {
        if (hVar.cN() == null || hVar.cN().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = hVar.cN().getFaceFrame();
        if (faceFrame.getTrackedPointsList() == null || faceFrame.getTrackedPointsList().size() <= 0) {
            this.lZ = 0;
            if (TextUtils.isEmpty(this.lY) || this.ma == null) {
                return;
            }
            a((int[]) null);
            return;
        }
        FAUPoint2D[] fAUPoint2DArr = faceFrame.getTrackedPointsList().get(0);
        int size = faceFrame.getTrackedPointsList().size();
        if (TextUtils.isEmpty(this.lY) || fAUPoint2DArr.length <= 0) {
            return;
        }
        if (faceFrame.getFaceIDList() != null && this.lZ != size) {
            a(faceFrame.getFaceIDList());
        }
        this.lZ = size;
    }

    private boolean c(com.baidu.ar.face.a.h hVar) {
        if (q().contains("ability_face_filter")) {
            if (hVar.cN() == null || hVar.cN().getFaceFrame() == null || hVar.cN().getFaceFrame().getTrackedPointsList() == null) {
                return false;
            }
            List<FAUPoint2D[]> trackedPointsList = hVar.cN().getFaceFrame().getTrackedPointsList();
            if (trackedPointsList == null || trackedPointsList.size() < 1 || trackedPointsList.get(0).length < 95) {
                return false;
            }
            return (Float.isNaN(trackedPointsList.get(0)[0].getX()) || Float.isNaN(trackedPointsList.get(0)[0].getY())) ? false : true;
        }
        return false;
    }

    private com.baidu.ar.face.a.e cA() {
        cz();
        com.baidu.ar.face.a.e eVar = new com.baidu.ar.face.a.e();
        eVar.z(this.mo);
        eVar.A(this.mp);
        if (this.mb == null) {
            return eVar;
        }
        eVar.V(this.mb.ou);
        eVar.W(this.mb.ot);
        eVar.ac(this.mb.oy);
        eVar.ad(this.mb.oz);
        a.C0081a c0081a = null;
        String str = this.mb.ov;
        String str2 = this.mb.ow;
        String str3 = this.mb.ox;
        com.baidu.ar.f.b.c(TAG, "classification result：" + this.mb.oE);
        switch (this.mb.oE) {
            case 0:
                this.ml = 1;
                c0081a = this.mb.oB;
                break;
            case 1:
                this.ml = 1;
                c0081a = this.mb.oC;
                break;
            case 2:
                this.ml = 4;
                c0081a = this.mb.oD;
                break;
            default:
                com.baidu.ar.f.b.b(TAG, "createFaceParams() device not support!!!");
                break;
        }
        this.mm = this.ml;
        if (c0081a != null) {
            this.mc = c0081a;
            this.md = b.a(c0081a.on, str, str2, str3);
            eVar.X(c0081a.om);
            eVar.Y(str);
            eVar.Z(str2);
            eVar.aa(str3);
            eVar.ab(c0081a.oo);
            eVar.setTrackingSmoothAlpha(Float.parseFloat(c0081a.op));
            eVar.setTrackingSmoothThreshold(Float.parseFloat(c0081a.oq));
            eVar.setTrackingMouthThreshold(Float.parseFloat(c0081a.or));
        }
        return eVar;
    }

    private float cB() {
        if (this.S == 0 || this.T == 0) {
            return 56.144978f;
        }
        int i = this.U;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.S : this.T) * 0.5f, 0.94375f * Math.max(this.S, this.T)) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    private void cC() {
        if (r() != null) {
            l lVar = new l();
            lVar.i(-1L);
            lVar.e(true);
            r().a(lVar, true);
        }
    }

    private void cD() {
        if (this.lU == null || r() == null) {
            return;
        }
        this.lU.b((float[]) null);
        this.lU.setTimestamp(0L);
        this.lU.o("ability_face_filter");
        this.lU.e(true);
        r().a(this.lU);
    }

    private void cv() {
        if (this.lS != null) {
            if (q().contains("ability_face_model")) {
                this.lS.o("ability_face_model");
            } else if (q().contains("ability_makeup_filter")) {
                this.lS.o("ability_makeup_filter");
            }
        }
    }

    private void cw() {
        this.me = false;
        this.mf = false;
        this.mg = false;
        this.mh = false;
        this.mi = false;
        this.mm = this.ml;
        this.mj = this.md != 0;
        this.mk = true;
    }

    private void cx() {
        com.baidu.ar.face.a.a.cE().x(this.md);
        if (this.mc != null) {
            com.baidu.ar.face.a.a.cE().a(Float.parseFloat(this.mc.op), Float.parseFloat(this.mc.oq));
            com.baidu.ar.face.a.a.cE().c(Float.parseFloat(this.mc.or));
        }
        com.baidu.ar.face.a.a.cE().z(this.mj);
        com.baidu.ar.face.a.a.cE().B(this.mk);
        com.baidu.ar.face.a.a.cE().A(this.mi);
        com.baidu.ar.face.a.a.cE().a(this.me, this.mf, this.mg);
        com.baidu.ar.face.a.a.cE().C(this.mh);
        int i = this.mm;
        if (!TextUtils.isEmpty(this.lY)) {
            i = this.ml < this.mm ? this.ml : this.mm;
        }
        com.baidu.ar.face.a.a.cE().y(i);
        com.baidu.ar.face.a.a.cE().b(this.mb.mQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        if (this.lS != null) {
            this.lS.F(this.mn);
        }
        b(this.mn);
        if (r() != null) {
            r().m(this.mn);
        }
        this.mq = true;
    }

    private void cz() {
        int i;
        int i2 = 180;
        if (this.V) {
            this.mo = 180;
            this.mp = 320;
            return;
        }
        int i3 = this.S;
        int i4 = this.T;
        if (this.U == 90 || this.U == 270) {
            i3 = this.T;
            i4 = this.S;
        }
        if (Float.compare((i3 * 1.0f) / i4, (180 * 1.0f) / 320) == 0) {
            i = 320;
        } else if (i3 > i4) {
            i2 = (int) ((180 / i4) * i3);
            i = 180;
        } else {
            i = (int) (i4 * (180 / i3));
        }
        this.mo = i2;
        this.mp = i;
    }

    private void d(com.baidu.ar.face.a.h hVar) {
        List<FAUPoint2D[]> trackedPointsList = hVar.cN().getFaceFrame().getTrackedPointsList();
        int length = trackedPointsList.get(0).length;
        float[] fArr = new float[trackedPointsList.size() * length * 2];
        for (int i = 0; i < trackedPointsList.size(); i++) {
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = (i * length) + i2;
                fArr[i3 * 2] = trackedPointsList.get(i)[i2].getX() / this.mo;
                fArr[(i3 * 2) + 1] = trackedPointsList.get(i)[i2].getY() / this.mp;
            }
        }
        this.lU.b(fArr);
        this.lU.setTimestamp(hVar.getTimestamp());
    }

    private void y(boolean z) {
        com.baidu.ar.filter.a s = s();
        if (s != null) {
            boolean z2 = z && this.mn && q().contains("ability_makeup_filter");
            s.a(FilterNode.makeupFilter, z2);
            s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf(z2 ? 1 : 0));
            s.dg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != 10 || this.lS == null) {
            return;
        }
        this.lS.r(j);
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
        cv();
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        com.baidu.ar.f.b.c(TAG, "onCaseCreate start!!!");
        this.lY = str;
        boolean U = U(str);
        if (!U) {
            this.lY = null;
        }
        j r = r();
        if (r != null) {
            r.n(true);
            r.a(cB());
        }
        if (TextUtils.isEmpty(this.lY)) {
            cw();
        } else {
            this.me = this.me;
            this.mf = this.mf;
            this.mg = this.mg;
            this.mh = this.mh;
            this.mi = this.mi;
            this.mj = this.mj || this.md != 0;
            if (!this.mk) {
            }
            this.mk = true;
        }
        if (!U) {
            this.mm = 1;
        }
        cx();
        if (this.lW != null && this.lW.size() > 0) {
            this.lX = this.lW.get(this.lW.size() - 1);
        }
        if (this.lT != null) {
            this.lT.onStickerLoadingFinished(this.lW);
        }
        if (this.mm > 1) {
            y(false);
        } else {
            y(true);
        }
        cv();
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        boolean z = false;
        com.baidu.ar.f.b.c(TAG, "onCaseDestroy!!!");
        this.lY = null;
        this.lX = null;
        this.lZ = 0;
        if (this.md == 2 || this.md == 1) {
            z = true;
        }
        this.mn = z;
        cy();
        a((int[]) null);
        cw();
        cx();
        cv();
    }

    @Override // com.baidu.ar.arplay.core.engine.ARPEngine.f
    public void onFaceFrameHandleDestory(long j) {
        if (this.lS != null) {
            this.lS.b(j);
        }
    }

    @Override // com.baidu.ar.c
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.c
    public void release() {
        com.baidu.ar.f.b.c(TAG, "release");
        this.mn = false;
        cy();
        a((int[]) null);
        cC();
        cD();
        y(false);
        this.mq = false;
        if (this.lS != null) {
            this.lS.a((AlgoHandleController) null);
        }
        a(this.lS);
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        if (this.mr != null) {
            this.mr.release();
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.lT = faceListener;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        boolean z = false;
        com.baidu.ar.f.b.c(TAG, "setup");
        super.setup(hashMap);
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        JSONObject t = t();
        com.baidu.ar.face.b.a aVar = new com.baidu.ar.face.b.a();
        if (t == null || t.toString().trim().equals("{}")) {
            com.baidu.ar.f.b.b(TAG, "abilityScheme is null, use default config!");
            this.mb = aVar.a(getFaceModelPath(), (JSONObject) null);
        } else {
            com.baidu.ar.f.b.c(TAG, "start parse abilityScheme config: " + t.toString());
            this.mb = aVar.a(getFaceModelPath(), t);
        }
        j r = r();
        if (r != null) {
            this.lY = r().be();
        }
        this.lS = new d();
        this.lS.a(this.bU);
        cv();
        this.lb = new e() { // from class: com.baidu.ar.face.FaceAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                com.baidu.ar.face.a.h de2;
                if (bVar == null || !(bVar instanceof com.baidu.ar.face.a.g) || (de2 = ((com.baidu.ar.face.a.g) bVar).de()) == null) {
                    return;
                }
                FaceResultData e = b.e(de2);
                l lVar = (l) bVar.cm();
                if (lVar != null) {
                    e.setAlgoImageWidth(lVar.bw());
                    e.setAlgoImageHeight(lVar.bx());
                }
                FaceAR.this.mIsFrontCamera = de2.isFrontCamera();
                if (FaceAR.this.mr != null) {
                    FaceAR.this.mr.a(de2, e, FaceAR.this.mo, FaceAR.this.mp);
                }
                if (FaceAR.this.lT != null) {
                    FaceAR.this.lT.onFaceResult(e);
                }
                FaceAR.this.a((l) bVar.cm());
                j r2 = FaceAR.this.r();
                long cP = de2.cP();
                if (cP > 0 && r2 != null) {
                    r2.a(cP, "ability_face_model");
                }
                FaceAR.this.a(de2);
                FaceAR.this.b(de2);
                FaceAR.this.a(de2, "ability_face_filter");
            }

            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.l lVar) {
                com.baidu.ar.f.b.c(FaceAR.TAG, "FaceDetector onSetup result = " + lVar.isSuccess());
            }

            @Override // com.baidu.ar.c.e
            public void b(com.baidu.ar.c.l lVar) {
                com.baidu.ar.f.b.c(FaceAR.TAG, "FaceDetector onRelease result = " + lVar.isSuccess());
            }
        };
        if (r != null) {
            r.setFaceCallBack(this);
        }
        com.baidu.ar.face.a.a.cE().setContext(getContext());
        com.baidu.ar.face.a.e cA = cA();
        this.mj = this.md != 0;
        if (this.md == 2 || this.md == 1) {
            z = true;
        }
        this.mn = z;
        cy();
        this.lS.a(cA);
        a(this.lS, this.lb);
        this.mr = new com.baidu.ar.face.attributes.a();
        this.mr.b(getContext(), this.mb.oA);
        cx();
        V();
    }
}
