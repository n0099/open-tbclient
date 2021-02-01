package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
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
/* loaded from: classes6.dex */
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    private AlgoHandleController cb;
    private LuaMsgListener cc;
    private ICaptureAbilityListener lb;
    private d ln;
    private d lo;
    private com.baidu.ar.d.e lp;
    private com.baidu.ar.d.e lq;
    private com.baidu.ar.d.e lr;
    private ICallbackWith<ICaptureResult> ls;
    private e lu;
    private a lx;
    private int ll = 720;
    private int lm = 1280;
    private volatile boolean lt = false;
    private boolean lv = false;
    private boolean lw = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        if (this.ln == null) {
            this.ln = new d(PixelReadParams.DEFAULT_FILTER_ID, this.ll, this.lm);
            this.lp = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
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
            a(this.ln, this.lp);
        }
        if (this.lo != null && !this.lo.cL().equals(str)) {
            a(this.lo);
            this.lo = null;
        }
        if (this.lo == null) {
            if (TextUtils.isEmpty(str)) {
                str = "target";
            }
            this.lo = new d(str, this.ll, this.lm);
            this.lq = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
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
            a(this.lo, this.lq);
        }
        if (this.lw) {
            return;
        }
        this.lw = true;
        this.lr = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
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
        a("FaceDetector", this.lr, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Log.d("ChildLook", "camera time: " + cVar.getTimestamp());
        if ((this.lu == null || this.lu.le == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
            if (this.ln != null) {
                this.ln.s(false);
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
        if (this.lu != null) {
            this.lu.lk = c;
        }
        cN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Log.d("ChildLook", "output time: " + cVar.getTimestamp());
        if ((this.lu == null || this.lu.lf == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
            if (this.lo != null) {
                this.lo.s(false);
            }
            this.lu.lf = cVar.getData();
            cN();
        }
    }

    private void b(Runnable runnable) {
        if (this.lx == null) {
            this.lx = new a("FamilyWithChildAR");
            this.lx.start();
        }
        this.lx.execute(runnable);
    }

    private boolean b(com.baidu.ar.d.b bVar) {
        if (this.lu != null) {
            if (this.lu.getTimestamp() == bVar.getTimestamp()) {
                return true;
            }
            if (bVar.getTimestamp() <= this.lu.getTimestamp()) {
                return false;
            }
            this.lu = null;
            if (this.ln != null) {
                this.ln.s(true);
            }
            if (this.lo != null) {
                this.lo.s(true);
            }
            this.lv = false;
        }
        if (this.lu == null) {
            this.lu = new e();
            this.lu.timestamp = bVar.getTimestamp();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        this.lw = false;
        if (this.lr != null) {
            a("FaceDetector", this.lr);
            this.lr = null;
        }
        if (this.ln != null) {
            a(this.ln);
        }
        if (this.lo != null) {
            a(this.lo);
        }
        this.lo = null;
        this.ln = null;
        this.lp = null;
        this.lq = null;
    }

    private void cN() {
        if (!this.lt || this.lu == null || this.ls == null || this.lu.le == null || this.lu.lf == null || !this.lv) {
            return;
        }
        t(false);
        this.lu.li = this.ll;
        this.lu.lj = this.lm;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != 23) {
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
        if (this.lb != null) {
            this.lb.onClose();
        }
        this.lb = null;
        if (this.cc != null) {
            b(this.cc);
            this.cc = null;
        }
        cM();
        if (this.lx != null) {
            this.lx.stop();
            this.lx = null;
        }
        this.ls = null;
        if (this.cb != null) {
            this.cb.release();
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
        long a2 = f.a(this.cb, strArr, 23);
        r().a(a2, "ability_capture");
        a(a2);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        long a2 = f.a(this.cb, bitmapArr, 23);
        r().a(a2, "ability_capture");
        a(a2);
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
        if (this.mInputWidth > this.mInputHeight) {
            this.ll = this.mInputHeight;
            this.lm = this.mInputWidth;
        } else {
            this.ll = this.mInputWidth;
            this.lm = this.mInputHeight;
        }
        this.cb = new AlgoHandleController();
        this.cc = new LuaMsgListener() { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap2) {
                String str = (String) hashMap2.get(LuaMessageHelper.KEY_EVENT_NAME);
                if ("get_pixel_frame".equals(str)) {
                    FamilyWithChildAR.this.V((String) hashMap2.get("filter_id"));
                    FamilyWithChildAR.this.d((ICallbackWith<ICaptureResult>) null);
                } else if (!LuaMessageHelper.KEY_RECEIVE_LUA_MESSAGE.NEED_FACE.equals(str) || FamilyWithChildAR.this.lb == null) {
                } else {
                    FamilyWithChildAR.this.lb.onOpen();
                }
            }
        };
        a(this.cc);
        com.baidu.ar.arrender.l r = r();
        if (r != null) {
            r.b(23, false);
        }
    }
}
