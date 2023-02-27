package com.baidu.ar.arrender;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
/* loaded from: classes.dex */
public class k {
    public Handler aO;
    public List<String> ic;
    public LuaMsgListener ie;

    /* renamed from: if  reason: not valid java name */
    public com.baidu.ar.lua.d f1if;
    public IARPRenderer ig;
    public PixelReadParams ih;
    public PixelReadListener ii;

    public k(Looper looper, com.baidu.ar.lua.d dVar, IARPRenderer iARPRenderer) {
        if (looper == null || dVar == null || iARPRenderer == null) {
            com.baidu.ar.h.b.b("FrameCapture", "create FrameCapture error!!! As params NULLLLL!!!");
        }
        this.aO = new Handler(looper);
        this.f1if = dVar;
        this.ig = iARPRenderer;
    }

    private void a(com.baidu.ar.lua.d dVar) {
        this.ic = Arrays.asList("event_name");
        LuaMsgListener luaMsgListener = new LuaMsgListener() { // from class: com.baidu.ar.arrender.k.3
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return k.this.ic;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                PixelReadParams pixelReadParams;
                PixelRotation pixelRotation;
                if (k.this.ig == null || k.this.ih == null || k.this.ii == null) {
                    return;
                }
                String str = (String) hashMap.get("event_name");
                com.baidu.ar.h.b.c("FrameCapture", "createLuaCaptureListener eventName = " + str);
                if (!"capture_frame".equals(str)) {
                    if ("clear_capture".equals(str)) {
                        k.this.ig.clearCaptureData();
                        return;
                    }
                    return;
                }
                k.this.ih.setPreFilterID((String) hashMap.get("filter_id"));
                if (k.this.ih.getPreFilterID().equals("camera") || TextUtils.isEmpty(k.this.ih.getPreFilterID())) {
                    if (k.this.ig.isFrontCamera()) {
                        pixelReadParams = k.this.ih;
                        pixelRotation = PixelRotation.RotateRightFlipHorizontal;
                    } else {
                        pixelReadParams = k.this.ih;
                        pixelRotation = PixelRotation.RotateRight;
                    }
                    pixelReadParams.setPixelRotate(pixelRotation);
                }
                k.this.ig.createPixelReaderByPreFilterID(k.this.ih, k.this.ii);
            }
        };
        this.ie = luaMsgListener;
        dVar.addLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW() {
        Handler handler = this.aO;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.arrender.k.2
                @Override // java.lang.Runnable
                public void run() {
                    k.this.bU();
                }
            });
        }
    }

    private void h(int i, int i2) {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.ih = pixelReadParams;
        pixelReadParams.setOutputWidth(i);
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

    public void bU() {
        PixelReadParams pixelReadParams;
        PixelReadListener pixelReadListener;
        IARPRenderer iARPRenderer = this.ig;
        if (iARPRenderer == null || (pixelReadParams = this.ih) == null || (pixelReadListener = this.ii) == null) {
            return;
        }
        iARPRenderer.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void bV() {
        IARPRenderer iARPRenderer = this.ig;
        if (iARPRenderer != null) {
            iARPRenderer.clearCaptureData();
        }
    }

    public void g(int i, int i2) {
        h(i, i2);
        a(this.f1if);
    }

    public void release() {
        LuaMsgListener luaMsgListener;
        Handler handler = this.aO;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aO = null;
        }
        com.baidu.ar.lua.d dVar = this.f1if;
        if (dVar != null && (luaMsgListener = this.ie) != null) {
            dVar.removeLuaMsgListener(luaMsgListener);
        }
        this.f1if = null;
        this.ie = null;
        this.ic = null;
        this.ih = null;
        this.ii = null;
        this.ig = null;
    }
}
