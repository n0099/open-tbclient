package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.c.l;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.a.g;
import com.baidu.ar.face.a.h;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    private AlgoHandleController bU;
    private LuaMsgListener bV;
    private ICaptureAbilityListener jL;
    private d jX;
    private d jY;
    private com.baidu.ar.c.e jZ;
    private com.baidu.ar.c.e ka;
    private com.baidu.ar.c.e kb;
    private ICallbackWith<ICaptureResult> kc;
    private e ke;
    private a kh;
    private int jV = 720;
    private int jW = 1280;
    private volatile boolean kd = false;
    private boolean kf = false;
    private boolean kg = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str) {
        if (this.jX == null) {
            this.jX = new d(PixelReadParams.DEFAULT_FILTER_ID, this.jV, this.jW);
            this.jZ = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
                @Override // com.baidu.ar.c.e
                public void a(com.baidu.ar.c.b bVar) {
                    if (FamilyWithChildAR.this.kd && (bVar instanceof c)) {
                        FamilyWithChildAR.this.a((c) bVar);
                    }
                }

                @Override // com.baidu.ar.c.e
                public void a(l lVar) {
                }

                @Override // com.baidu.ar.c.e
                public void b(l lVar) {
                }
            };
            a(this.jX, this.jZ);
        }
        if (this.jY != null && !this.jY.bW().equals(str)) {
            a(this.jY);
            this.jY = null;
        }
        if (this.jY == null) {
            if (TextUtils.isEmpty(str)) {
                str = "target";
            }
            this.jY = new d(str, this.jV, this.jW);
            this.ka = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
                @Override // com.baidu.ar.c.e
                public void a(com.baidu.ar.c.b bVar) {
                    if (FamilyWithChildAR.this.kd && (bVar instanceof c)) {
                        FamilyWithChildAR.this.b((c) bVar);
                    }
                }

                @Override // com.baidu.ar.c.e
                public void a(l lVar) {
                }

                @Override // com.baidu.ar.c.e
                public void b(l lVar) {
                }
            };
            a(this.jY, this.ka);
        }
        if (this.kg) {
            return;
        }
        this.kg = true;
        this.kb = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (FamilyWithChildAR.this.kd && (bVar instanceof g)) {
                    FamilyWithChildAR.this.a((g) bVar);
                }
                if (FamilyWithChildAR.this.bU != null) {
                    FamilyWithChildAR.this.bU.destroyHandle(bVar.cn());
                } else {
                    AlgoHandleAdapter.destroyHandle(bVar.cn());
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a("FaceDetector", this.kb, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Log.d("ChildLook", "camera time: " + cVar.getTimestamp());
        if ((this.ke == null || this.ke.jO == null) && b((com.baidu.ar.c.b) cVar) && this.ke != null) {
            this.jX.u(false);
            this.ke.jO = cVar.getData();
            bY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        h de2;
        if (this.kf) {
            return;
        }
        Log.d("ChildLook", "face time: " + gVar.getTimestamp());
        if (!b(gVar) || (de2 = gVar.de()) == null) {
            return;
        }
        this.kf = true;
        FaceResultData e = com.baidu.ar.face.b.e(de2);
        com.baidu.ar.arrender.l lVar = (com.baidu.ar.arrender.l) gVar.cm();
        if (e != null && lVar != null) {
            e.setAlgoImageWidth(lVar.bw());
            e.setAlgoImageHeight(lVar.bx());
        }
        if (this.ke != null) {
            this.ke.jU = e;
        }
        bY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Log.d("ChildLook", "output time: " + cVar.getTimestamp());
        if ((this.ke == null || this.ke.jP == null) && b((com.baidu.ar.c.b) cVar) && this.ke != null) {
            this.jY.u(false);
            this.ke.jP = cVar.getData();
            bY();
        }
    }

    private boolean b(com.baidu.ar.c.b bVar) {
        if (this.ke != null) {
            if (this.ke.getTimestamp() == bVar.getTimestamp()) {
                return true;
            }
            if (bVar.getTimestamp() <= this.ke.getTimestamp()) {
                return false;
            }
            this.ke = null;
            this.jX.u(true);
            this.jY.u(true);
            this.kf = false;
        }
        if (this.ke == null) {
            this.ke = new e();
            this.ke.timestamp = bVar.getTimestamp();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX() {
        this.kg = false;
        if (this.kb != null) {
            a("FaceDetector", this.kb);
            this.kb = null;
        }
        if (this.jX != null) {
            a(this.jX);
        }
        if (this.jY != null) {
            a(this.jY);
        }
        this.jY = null;
        this.jX = null;
        this.jZ = null;
        this.ka = null;
    }

    private void bY() {
        if (!this.kd || this.ke == null || this.kc == null || this.ke.jO == null || this.ke.jP == null || !this.kf) {
            return;
        }
        v(false);
        this.ke.jS = this.jV;
        this.ke.jT = this.jW;
        d(new Runnable() { // from class: com.baidu.ar.capture.FamilyWithChildAR.5
            @Override // java.lang.Runnable
            public void run() {
                FamilyWithChildAR.this.bX();
                FamilyWithChildAR.this.kc.run(FamilyWithChildAR.this.ke);
                FamilyWithChildAR.this.ke = null;
            }
        });
        this.kf = false;
    }

    private void d(Runnable runnable) {
        if (this.kh == null) {
            this.kh = new a("FamilyWithChildAR");
            this.kh.start();
        }
        this.kh.execute(runnable);
    }

    private void v(boolean z) {
        if (this.jX == null || this.jY == null) {
            return;
        }
        this.kd = z;
        this.jX.u(z);
        this.jY.u(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != 23) {
            return;
        }
        this.bU.destroyHandle(j);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (iCallbackWith != null) {
            this.kc = iCallbackWith;
        }
        if (this.kd) {
            return;
        }
        this.kf = false;
        this.ke = null;
        v(true);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.jL != null) {
            this.jL.onClose();
        }
        this.jL = null;
        if (this.bV != null) {
            b(this.bV);
            this.bV = null;
        }
        bX();
        if (this.kh != null) {
            this.kh.stop();
            this.kh = null;
        }
        this.kc = null;
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        super.release();
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (strArr == null || strArr.length <= 0 || r() == null) {
            return;
        }
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        r().a(f.a(this.bU, strArr, 23), "ability_capture");
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        r().a(f.a(this.bU, bitmapArr, 23), "ability_capture");
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        this.jL = iCaptureAbilityListener;
        if (iCaptureAbilityListener != null) {
            iCaptureAbilityListener.onOpen();
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        this.kc = iCallbackWith;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.S > this.T) {
            this.jV = this.T;
            this.jW = this.S;
        } else {
            this.jV = this.S;
            this.jW = this.T;
        }
        this.bU = new AlgoHandleController();
        this.bV = new LuaMsgListener() { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap2) {
                String str = (String) hashMap2.get(LuaMessageHelper.KEY_EVENT_NAME);
                if ("get_pixel_frame".equals(str)) {
                    FamilyWithChildAR.this.R((String) hashMap2.get("filter_id"));
                    FamilyWithChildAR.this.capture(null);
                } else if (!LuaMessageHelper.KEY_RECEIVE_LUA_MESSAGE.NEED_FACE.equals(str) || FamilyWithChildAR.this.jL == null) {
                } else {
                    FamilyWithChildAR.this.jL.onOpen();
                }
            }
        };
        a(this.bV);
    }
}
