package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arrender.n;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    public AlgoHandleController cb;
    public LuaMsgListener cc;
    public ICaptureAbilityListener lb;
    public d ln;
    public d lo;
    public com.baidu.ar.d.e lp;
    public com.baidu.ar.d.e lq;
    public com.baidu.ar.d.e lr;
    public ICallbackWith<ICaptureResult> ls;
    public e lu;
    public a lx;
    public int ll = 720;
    public int lm = 1280;
    public volatile boolean lt = false;
    public boolean lv = false;
    public boolean lw = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        if (this.ln == null) {
            this.ln = new d("camera", this.ll, this.lm);
            com.baidu.ar.d.e eVar = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    if (FamilyWithChildAR.this.lt && (bVar instanceof c)) {
                        FamilyWithChildAR.this.a((c) bVar);
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                }
            };
            this.lp = eVar;
            a(this.ln, eVar);
        }
        d dVar = this.lo;
        if (dVar != null && !dVar.cL().equals(str)) {
            a(this.lo);
            this.lo = null;
        }
        if (this.lo == null) {
            if (TextUtils.isEmpty(str)) {
                str = "target";
            }
            this.lo = new d(str, this.ll, this.lm);
            com.baidu.ar.d.e eVar2 = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    if (FamilyWithChildAR.this.lt && (bVar instanceof c)) {
                        FamilyWithChildAR.this.b((c) bVar);
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                }
            };
            this.lq = eVar2;
            a(this.lo, eVar2);
        }
        if (this.lw) {
            return;
        }
        this.lw = true;
        com.baidu.ar.d.e eVar3 = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (FamilyWithChildAR.this.lt && (bVar instanceof com.baidu.ar.face.detector.l)) {
                    FamilyWithChildAR.this.a((com.baidu.ar.face.detector.l) bVar);
                }
                if (FamilyWithChildAR.this.cb != null) {
                    FamilyWithChildAR.this.cb.destroyHandle(bVar.de());
                } else {
                    AlgoHandleAdapter.destroyHandle(bVar.de());
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        this.lr = eVar3;
        a("FaceDetector", eVar3, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Log.d("ChildLook", "camera time: " + cVar.getTimestamp());
        e eVar = this.lu;
        if ((eVar == null || eVar.le == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
            d dVar = this.ln;
            if (dVar != null) {
                dVar.s(false);
            }
            this.lu.le = cVar.getData();
            cN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.face.detector.l lVar) {
        m eA;
        if (this.lv) {
            return;
        }
        Log.d("ChildLook", "face time: " + lVar.getTimestamp());
        if (!b(lVar) || (eA = lVar.eA()) == null) {
            return;
        }
        this.lv = true;
        FaceResultData c = com.baidu.ar.face.c.c(eA);
        n nVar = (n) lVar.dd();
        if (c != null && nVar != null) {
            c.setAlgoImageWidth(nVar.bX());
            c.setAlgoImageHeight(nVar.bY());
        }
        e eVar = this.lu;
        if (eVar != null) {
            eVar.lk = c;
        }
        cN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Log.d("ChildLook", "output time: " + cVar.getTimestamp());
        e eVar = this.lu;
        if ((eVar == null || eVar.lf == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
            d dVar = this.lo;
            if (dVar != null) {
                dVar.s(false);
            }
            this.lu.lf = cVar.getData();
            cN();
        }
    }

    private void b(Runnable runnable) {
        if (this.lx == null) {
            a aVar = new a("FamilyWithChildAR");
            this.lx = aVar;
            aVar.start();
        }
        this.lx.execute(runnable);
    }

    private boolean b(com.baidu.ar.d.b bVar) {
        e eVar = this.lu;
        if (eVar != null) {
            if (eVar.getTimestamp() == bVar.getTimestamp()) {
                return true;
            }
            if (bVar.getTimestamp() <= this.lu.getTimestamp()) {
                return false;
            }
            this.lu = null;
            d dVar = this.ln;
            if (dVar != null) {
                dVar.s(true);
            }
            d dVar2 = this.lo;
            if (dVar2 != null) {
                dVar2.s(true);
            }
            this.lv = false;
        }
        if (this.lu == null) {
            e eVar2 = new e();
            this.lu = eVar2;
            eVar2.timestamp = bVar.getTimestamp();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        this.lw = false;
        com.baidu.ar.d.e eVar = this.lr;
        if (eVar != null) {
            a("FaceDetector", eVar);
            this.lr = null;
        }
        d dVar = this.ln;
        if (dVar != null) {
            a(dVar);
        }
        d dVar2 = this.lo;
        if (dVar2 != null) {
            a(dVar2);
        }
        this.lo = null;
        this.ln = null;
        this.lp = null;
        this.lq = null;
    }

    private void cN() {
        e eVar;
        if (!this.lt || (eVar = this.lu) == null || this.ls == null || eVar.le == null || eVar.lf == null || !this.lv) {
            return;
        }
        t(false);
        e eVar2 = this.lu;
        eVar2.li = this.ll;
        eVar2.lj = this.lm;
        b(new Runnable() { // from class: com.baidu.ar.capture.FamilyWithChildAR.5
            @Override // java.lang.Runnable
            public void run() {
                FamilyWithChildAR.this.cM();
                FamilyWithChildAR.this.ls.run(FamilyWithChildAR.this.lu);
                FamilyWithChildAR.this.lu = null;
            }
        });
        this.lv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (iCallbackWith != null) {
            this.ls = iCallbackWith;
        }
        if (this.lt) {
            return;
        }
        this.lv = false;
        this.lu = null;
        t(true);
    }

    private void t(boolean z) {
        if (this.ln == null || this.lo == null) {
            return;
        }
        this.lt = z;
        this.ln.s(z);
        this.lo.s(z);
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != 23) {
            return;
        }
        this.cb.destroyHandle(j);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        V(null);
        d(iCallbackWith);
    }

    @Override // com.baidu.ar.c
    public void release() {
        ICaptureAbilityListener iCaptureAbilityListener = this.lb;
        if (iCaptureAbilityListener != null) {
            iCaptureAbilityListener.onClose();
        }
        this.lb = null;
        LuaMsgListener luaMsgListener = this.cc;
        if (luaMsgListener != null) {
            b(luaMsgListener);
            this.cc = null;
        }
        cM();
        a aVar = this.lx;
        if (aVar != null) {
            aVar.stop();
            this.lx = null;
        }
        this.ls = null;
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.release();
            this.cb = null;
        }
        com.baidu.ar.arrender.l r = r();
        if (r != null) {
            r.q(23);
        }
        super.release();
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (strArr == null || strArr.length <= 0 || r() == null) {
            return;
        }
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        long a = f.a(this.cb, strArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        long a = f.a(this.cb, bitmapArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        this.lb = iCaptureAbilityListener;
        if (iCaptureAbilityListener != null) {
            iCaptureAbilityListener.onOpen();
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        this.ls = iCallbackWith;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        int i = this.mInputWidth;
        int i2 = this.mInputHeight;
        if (i > i2) {
            this.ll = i2;
            this.lm = i;
        } else {
            this.ll = i;
            this.lm = i2;
        }
        this.cb = new AlgoHandleController();
        LuaMsgListener luaMsgListener = new LuaMsgListener() { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList("event_name");
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap2) {
                String str = (String) hashMap2.get("event_name");
                if ("get_pixel_frame".equals(str)) {
                    FamilyWithChildAR.this.V((String) hashMap2.get("filter_id"));
                    FamilyWithChildAR.this.d((ICallbackWith<ICaptureResult>) null);
                } else if (!"need_face".equals(str) || FamilyWithChildAR.this.lb == null) {
                } else {
                    FamilyWithChildAR.this.lb.onOpen();
                }
            }
        };
        this.cc = luaMsgListener;
        a(luaMsgListener);
        com.baidu.ar.arrender.l r = r();
        if (r != null) {
            r.b(23, false);
        }
    }
}
