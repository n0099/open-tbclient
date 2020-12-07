package com.baidu.ar.arrender;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class k {
    private Handler aO;
    private List<String> ic;
    private LuaMsgListener ie;

    /* renamed from: if  reason: not valid java name */
    private com.baidu.ar.lua.d f1if;
    private IARPRenderer ig;
    private PixelReadParams ih;
    private PixelReadListener ii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Looper looper, com.baidu.ar.lua.d dVar, IARPRenderer iARPRenderer) {
        if (looper == null || dVar == null || iARPRenderer == null) {
            com.baidu.ar.h.b.b("FrameCapture", "create FrameCapture error!!! As params NULLLLL!!!");
        }
        this.aO = new Handler(looper);
        this.f1if = dVar;
        this.ig = iARPRenderer;
    }

    private void a(com.baidu.ar.lua.d dVar) {
        this.ic = Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
        this.ie = new LuaMsgListener() { // from class: com.baidu.ar.arrender.k.3
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return k.this.ic;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (k.this.ig == null || k.this.ih == null || k.this.ii == null) {
                    return;
                }
                String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
                com.baidu.ar.h.b.c("FrameCapture", "createLuaCaptureListener eventName = " + str);
                if (!"capture_frame".equals(str)) {
                    if ("clear_capture".equals(str)) {
                        k.this.ig.clearCaptureData();
                        return;
                    }
                    return;
                }
                k.this.ih.setPreFilterID((String) hashMap.get("filter_id"));
                if (k.this.ih.getPreFilterID().equals(PixelReadParams.DEFAULT_FILTER_ID) || TextUtils.isEmpty(k.this.ih.getPreFilterID())) {
                    if (k.this.ig.isFrontCamera()) {
                        k.this.ih.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                    } else {
                        k.this.ih.setPixelRotate(PixelRotation.RotateRight);
                    }
                }
                k.this.ig.createPixelReaderByPreFilterID(k.this.ih, k.this.ii);
            }
        };
        dVar.addLuaMsgListener(this.ie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW() {
        if (this.aO != null) {
            this.aO.post(new Runnable() { // from class: com.baidu.ar.arrender.k.2
                @Override // java.lang.Runnable
                public void run() {
                    k.this.bU();
                }
            });
        }
    }

    private void h(int i, int i2) {
        this.ih = new PixelReadParams(PixelType.RGBA);
        this.ih.setOutputWidth(i);
        this.ih.setOutputHeight(i2);
        this.ih.setFrameType(PixelReadParams.FrameType.SINGLE_FRAME);
        this.ii = new PixelReadListener() { // from class: com.baidu.ar.arrender.k.1
            @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
            public boolean onPixelRead(FramePixels framePixels) {
                if (framePixels == null || k.this.ig == null) {
                    return false;
                }
                com.baidu.ar.h.b.c("FrameCapture", "onPixelRead textureID = " + framePixels.getTextureID());
                k.this.ig.setCaptureData(framePixels.getTextureID());
                k.this.bW();
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bU() {
        if (this.ig == null || this.ih == null || this.ii == null) {
            return;
        }
        this.ig.destroyPixelReaderByPreFilterID(this.ih, this.ii);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bV() {
        if (this.ig != null) {
            this.ig.clearCaptureData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i, int i2) {
        h(i, i2);
        a(this.f1if);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.aO != null) {
            this.aO.removeCallbacksAndMessages(null);
            this.aO = null;
        }
        if (this.f1if != null && this.ie != null) {
            this.f1if.removeLuaMsgListener(this.ie);
        }
        this.f1if = null;
        this.ie = null;
        this.ic = null;
        this.ih = null;
        this.ii = null;
        this.ig = null;
    }
}
