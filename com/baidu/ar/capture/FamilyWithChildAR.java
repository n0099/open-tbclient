package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arrender.k;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.lua.LuaMsgListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    private AlgoHandleController bY;
    private LuaMsgListener bZ;
    private ICaptureAbilityListener kM;
    private d kY;
    private d kZ;
    private com.baidu.ar.d.e la;
    private com.baidu.ar.d.e lb;
    private com.baidu.ar.d.e lc;
    private ICallbackWith<ICaptureResult> ld;
    private e lf;
    private a li;
    private int kW = 720;
    private int kX = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private volatile boolean le = false;
    private boolean lg = false;
    private boolean lh = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        if (this.kY == null) {
            this.kY = new d(PixelReadParams.DEFAULT_FILTER_ID, this.kW, this.kX);
            this.la = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    if (FamilyWithChildAR.this.le && (bVar instanceof c)) {
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
            a(this.kY, this.la);
        }
        if (this.kZ != null && !this.kZ.cM().equals(str)) {
            a(this.kZ);
            this.kZ = null;
        }
        if (this.kZ == null) {
            if (TextUtils.isEmpty(str)) {
                str = "target";
            }
            this.kZ = new d(str, this.kW, this.kX);
            this.lb = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    if (FamilyWithChildAR.this.le && (bVar instanceof c)) {
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
            a(this.kZ, this.lb);
        }
        if (this.lh) {
            return;
        }
        this.lh = true;
        this.lc = new com.baidu.ar.d.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (FamilyWithChildAR.this.le && (bVar instanceof com.baidu.ar.face.detector.l)) {
                    FamilyWithChildAR.this.a((com.baidu.ar.face.detector.l) bVar);
                }
                if (FamilyWithChildAR.this.bY != null) {
                    FamilyWithChildAR.this.bY.destroyHandle(bVar.df());
                } else {
                    AlgoHandleAdapter.destroyHandle(bVar.df());
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        a("FaceDetector", this.lc, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Log.d("ChildLook", "camera time: " + cVar.getTimestamp());
        if ((this.lf == null || this.lf.kP == null) && b((com.baidu.ar.d.b) cVar) && this.lf != null) {
            if (this.kY != null) {
                this.kY.u(false);
            }
            this.lf.kP = cVar.getData();
            cO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.face.detector.l lVar) {
        m eB;
        if (this.lg) {
            return;
        }
        Log.d("ChildLook", "face time: " + lVar.getTimestamp());
        if (!b(lVar) || (eB = lVar.eB()) == null) {
            return;
        }
        this.lg = true;
        FaceResultData c = com.baidu.ar.face.c.c(eB);
        com.baidu.ar.arrender.m mVar = (com.baidu.ar.arrender.m) lVar.de();
        if (c != null && mVar != null) {
            c.setAlgoImageWidth(mVar.bY());
            c.setAlgoImageHeight(mVar.bZ());
        }
        if (this.lf != null) {
            this.lf.kV = c;
        }
        cO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Log.d("ChildLook", "output time: " + cVar.getTimestamp());
        if ((this.lf == null || this.lf.kQ == null) && b((com.baidu.ar.d.b) cVar) && this.lf != null) {
            if (this.kZ != null) {
                this.kZ.u(false);
            }
            this.lf.kQ = cVar.getData();
            cO();
        }
    }

    private void b(Runnable runnable) {
        if (this.li == null) {
            this.li = new a("FamilyWithChildAR");
            this.li.start();
        }
        this.li.execute(runnable);
    }

    private boolean b(com.baidu.ar.d.b bVar) {
        if (this.lf != null) {
            if (this.lf.getTimestamp() == bVar.getTimestamp()) {
                return true;
            }
            if (bVar.getTimestamp() <= this.lf.getTimestamp()) {
                return false;
            }
            this.lf = null;
            if (this.kY != null) {
                this.kY.u(true);
            }
            if (this.kZ != null) {
                this.kZ.u(true);
            }
            this.lg = false;
        }
        if (this.lf == null) {
            this.lf = new e();
            this.lf.timestamp = bVar.getTimestamp();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN() {
        this.lh = false;
        if (this.lc != null) {
            a("FaceDetector", this.lc);
            this.lc = null;
        }
        if (this.kY != null) {
            a(this.kY);
        }
        if (this.kZ != null) {
            a(this.kZ);
        }
        this.kZ = null;
        this.kY = null;
        this.la = null;
        this.lb = null;
    }

    private void cO() {
        if (!this.le || this.lf == null || this.ld == null || this.lf.kP == null || this.lf.kQ == null || !this.lg) {
            return;
        }
        v(false);
        this.lf.kT = this.kW;
        this.lf.kU = this.kX;
        b(new Runnable() { // from class: com.baidu.ar.capture.FamilyWithChildAR.5
            @Override // java.lang.Runnable
            public void run() {
                FamilyWithChildAR.this.cN();
                FamilyWithChildAR.this.ld.run(FamilyWithChildAR.this.lf);
                FamilyWithChildAR.this.lf = null;
            }
        });
        this.lg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (iCallbackWith != null) {
            this.ld = iCallbackWith;
        }
        if (this.le) {
            return;
        }
        this.lg = false;
        this.lf = null;
        v(true);
    }

    private void v(boolean z) {
        if (this.kY == null || this.kZ == null) {
            return;
        }
        this.le = z;
        this.kY.u(z);
        this.kZ.u(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != 23) {
            return;
        }
        this.bY.destroyHandle(j);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        S(null);
        d(iCallbackWith);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.kM != null) {
            this.kM.onClose();
        }
        this.kM = null;
        if (this.bZ != null) {
            b(this.bZ);
            this.bZ = null;
        }
        cN();
        if (this.li != null) {
            this.li.stop();
            this.li = null;
        }
        this.ld = null;
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        k r = r();
        if (r != null) {
            r.o(23);
        }
        super.release();
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (strArr == null || strArr.length <= 0 || r() == null) {
            return;
        }
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        long a = f.a(this.bY, strArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        long a = f.a(this.bY, bitmapArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        this.kM = iCaptureAbilityListener;
        if (iCaptureAbilityListener != null) {
            iCaptureAbilityListener.onOpen();
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        this.ld = iCallbackWith;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.R > this.S) {
            this.kW = this.S;
            this.kX = this.R;
        } else {
            this.kW = this.R;
            this.kX = this.S;
        }
        this.bY = new AlgoHandleController();
        this.bZ = new LuaMsgListener() { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap2) {
                String str = (String) hashMap2.get(LuaMessageHelper.KEY_EVENT_NAME);
                if ("get_pixel_frame".equals(str)) {
                    FamilyWithChildAR.this.S((String) hashMap2.get("filter_id"));
                    FamilyWithChildAR.this.d((ICallbackWith<ICaptureResult>) null);
                } else if (!LuaMessageHelper.KEY_RECEIVE_LUA_MESSAGE.NEED_FACE.equals(str) || FamilyWithChildAR.this.kM == null) {
                } else {
                    FamilyWithChildAR.this.kM.onOpen();
                }
            }
        };
        a(this.bZ);
        k r = r();
        if (r != null) {
            r.b(23, false);
        }
    }
}
