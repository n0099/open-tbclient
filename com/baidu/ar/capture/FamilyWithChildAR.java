package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c.l;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.a.g;
import com.baidu.ar.face.a.h;
import com.baidu.ar.lua.LuaMsgListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    private AlgoHandleController ch;
    private LuaMsgListener ci;
    private ICaptureAbilityListener kd;
    private d kp;
    private d kq;
    private com.baidu.ar.c.e kr;
    private com.baidu.ar.c.e ks;
    private com.baidu.ar.c.e kt;
    private ICallbackWith<ICaptureResult> ku;
    private e kw;
    private a kz;
    private int kn = 720;
    private int ko = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private volatile boolean kv = false;
    private boolean kx = false;
    private boolean ky = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str) {
        if (this.kp == null) {
            this.kp = new d(PixelReadParams.DEFAULT_FILTER_ID, this.kn, this.ko);
            this.kr = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
                @Override // com.baidu.ar.c.e
                public void a(com.baidu.ar.c.b bVar) {
                    if (FamilyWithChildAR.this.kv && (bVar instanceof c)) {
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
            a(this.kp, this.kr);
        }
        if (this.kq != null && !this.kq.cm().equals(str)) {
            a(this.kq);
            this.kq = null;
        }
        if (this.kq == null) {
            if (TextUtils.isEmpty(str)) {
                str = "target";
            }
            this.kq = new d(str, this.kn, this.ko);
            this.ks = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
                @Override // com.baidu.ar.c.e
                public void a(com.baidu.ar.c.b bVar) {
                    if (FamilyWithChildAR.this.kv && (bVar instanceof c)) {
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
            a(this.kq, this.ks);
        }
        if (this.ky) {
            return;
        }
        this.ky = true;
        this.kt = new com.baidu.ar.c.e() { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (FamilyWithChildAR.this.kv && (bVar instanceof g)) {
                    FamilyWithChildAR.this.a((g) bVar);
                }
                if (FamilyWithChildAR.this.ch != null) {
                    FamilyWithChildAR.this.ch.destroyHandle(bVar.cF());
                } else {
                    AlgoHandleAdapter.destroyHandle(bVar.cF());
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a("FaceDetector", this.kt, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Log.d("ChildLook", "camera time: " + cVar.getTimestamp());
        if ((this.kw == null || this.kw.kg == null) && b((com.baidu.ar.c.b) cVar) && this.kw != null) {
            this.kp.t(false);
            this.kw.kg = cVar.getData();
            co();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        h du;
        if (this.kx) {
            return;
        }
        Log.d("ChildLook", "face time: " + gVar.getTimestamp());
        if (!b(gVar) || (du = gVar.du()) == null) {
            return;
        }
        this.kx = true;
        FaceResultData c = com.baidu.ar.face.b.c(du);
        com.baidu.ar.arrender.l lVar = (com.baidu.ar.arrender.l) gVar.cE();
        if (c != null && lVar != null) {
            c.setAlgoImageWidth(lVar.bK());
            c.setAlgoImageHeight(lVar.bL());
        }
        if (this.kw != null) {
            this.kw.km = c;
        }
        co();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Log.d("ChildLook", "output time: " + cVar.getTimestamp());
        if ((this.kw == null || this.kw.kh == null) && b((com.baidu.ar.c.b) cVar) && this.kw != null) {
            this.kq.t(false);
            this.kw.kh = cVar.getData();
            co();
        }
    }

    private boolean b(com.baidu.ar.c.b bVar) {
        if (this.kw != null) {
            if (this.kw.getTimestamp() == bVar.getTimestamp()) {
                return true;
            }
            if (bVar.getTimestamp() <= this.kw.getTimestamp()) {
                return false;
            }
            this.kw = null;
            this.kp.t(true);
            this.kq.t(true);
            this.kx = false;
        }
        if (this.kw == null) {
            this.kw = new e();
            this.kw.timestamp = bVar.getTimestamp();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        this.ky = false;
        if (this.kt != null) {
            a("FaceDetector", this.kt);
            this.kt = null;
        }
        if (this.kp != null) {
            a(this.kp);
        }
        if (this.kq != null) {
            a(this.kq);
        }
        this.kq = null;
        this.kp = null;
        this.kr = null;
        this.ks = null;
    }

    private void co() {
        if (!this.kv || this.kw == null || this.ku == null || this.kw.kg == null || this.kw.kh == null || !this.kx) {
            return;
        }
        u(false);
        this.kw.kk = this.kn;
        this.kw.kl = this.ko;
        d(new Runnable() { // from class: com.baidu.ar.capture.FamilyWithChildAR.5
            @Override // java.lang.Runnable
            public void run() {
                FamilyWithChildAR.this.cn();
                FamilyWithChildAR.this.ku.run(FamilyWithChildAR.this.kw);
                FamilyWithChildAR.this.kw = null;
            }
        });
        this.kx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (iCallbackWith != null) {
            this.ku = iCallbackWith;
        }
        if (this.kv) {
            return;
        }
        this.kx = false;
        this.kw = null;
        u(true);
    }

    private void d(Runnable runnable) {
        if (this.kz == null) {
            this.kz = new a("FamilyWithChildAR");
            this.kz.start();
        }
        this.kz.execute(runnable);
    }

    private void u(boolean z) {
        if (this.kp == null || this.kq == null) {
            return;
        }
        this.kv = z;
        this.kp.t(z);
        this.kq.t(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null || this.ch.getHandleType(j) != 23) {
            return;
        }
        this.ch.destroyHandle(j);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        R(null);
        d(iCallbackWith);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.kd != null) {
            this.kd.onClose();
        }
        this.kd = null;
        if (this.ci != null) {
            b(this.ci);
            this.ci = null;
        }
        cn();
        if (this.kz != null) {
            this.kz.stop();
            this.kz = null;
        }
        this.ku = null;
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        j r = r();
        if (r != null) {
            r.r(23);
        }
        super.release();
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        if (strArr == null || strArr.length <= 0 || r() == null) {
            return;
        }
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        long a = f.a(this.ch, strArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        if (bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        long a = f.a(this.ch, bitmapArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        this.kd = iCaptureAbilityListener;
        if (iCaptureAbilityListener != null) {
            iCaptureAbilityListener.onOpen();
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        this.ku = iCallbackWith;
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.R > this.S) {
            this.kn = this.S;
            this.ko = this.R;
        } else {
            this.kn = this.R;
            this.ko = this.S;
        }
        this.ch = new AlgoHandleController();
        this.ci = new LuaMsgListener() { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap2) {
                String str = (String) hashMap2.get(LuaMessageHelper.KEY_EVENT_NAME);
                if ("get_pixel_frame".equals(str)) {
                    FamilyWithChildAR.this.R((String) hashMap2.get("filter_id"));
                    FamilyWithChildAR.this.d((ICallbackWith<ICaptureResult>) null);
                } else if (!LuaMessageHelper.KEY_RECEIVE_LUA_MESSAGE.NEED_FACE.equals(str) || FamilyWithChildAR.this.kd == null) {
                } else {
                    FamilyWithChildAR.this.kd.onOpen();
                }
            }
        };
        a(this.ci);
        j r = r();
        if (r != null) {
            r.a(23, false);
        }
    }
}
