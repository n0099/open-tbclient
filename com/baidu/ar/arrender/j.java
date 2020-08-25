package com.baidu.ar.arrender;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.arplay.core.filter.ARPFilter;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private Handler aL;
    private ARPFilter gZ;
    private List<String> hO;
    private LuaMsgListener hP;
    private com.baidu.ar.lua.d hQ;
    private PixelReadParams hR;
    private PixelReadListener hS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Looper looper, com.baidu.ar.lua.d dVar, ARPFilter aRPFilter) {
        if (looper == null || dVar == null || aRPFilter == null) {
            com.baidu.ar.g.b.b("FrameCapture", "create FrameCapture error!!! As params NULLLLL!!!");
        }
        this.aL = new Handler(looper);
        this.hQ = dVar;
        this.gZ = aRPFilter;
    }

    private void a(com.baidu.ar.lua.d dVar) {
        this.hO = Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
        this.hP = new LuaMsgListener() { // from class: com.baidu.ar.arrender.j.3
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return j.this.hO;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (j.this.gZ == null || j.this.hR == null || j.this.hS == null) {
                    return;
                }
                String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
                com.baidu.ar.g.b.c("FrameCapture", "createLuaCaptureListener eventName = " + str);
                if (!"capture_frame".equals(str)) {
                    if ("clear_capture".equals(str)) {
                        j.this.gZ.clearCaptureData();
                        return;
                    }
                    return;
                }
                j.this.hR.setPreFilterID((String) hashMap.get("filter_id"));
                if (j.this.hR.getPreFilterID().equals(PixelReadParams.DEFAULT_FILTER_ID) || TextUtils.isEmpty(j.this.hR.getPreFilterID())) {
                    if (j.this.gZ.isFrontCamera()) {
                        j.this.hR.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                    } else {
                        j.this.hR.setPixelRotate(PixelRotation.RotateRight);
                    }
                }
                j.this.gZ.createPixelReaderByPreFilterID(j.this.hR, j.this.hS);
            }
        };
        dVar.addLuaMsgListener(this.hP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX() {
        if (this.aL != null) {
            this.aL.post(new Runnable() { // from class: com.baidu.ar.arrender.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.bV();
                }
            });
        }
    }

    private void h(int i, int i2) {
        this.hR = new PixelReadParams(PixelType.RGBA);
        this.hR.setOutputWidth(i);
        this.hR.setOutputHeight(i2);
        this.hR.setFrameType(PixelReadParams.FrameType.SINGLE_FRAME);
        this.hS = new PixelReadListener() { // from class: com.baidu.ar.arrender.j.1
            @Override // com.baidu.ar.arplay.core.engine.pixel.PixelReadListener
            public boolean onPixelRead(FramePixels framePixels) {
                if (framePixels == null || j.this.gZ == null) {
                    return false;
                }
                com.baidu.ar.g.b.c("FrameCapture", "onPixelRead textureID = " + framePixels.getTextureID());
                j.this.gZ.setCaptureData(framePixels.getTextureID());
                j.this.bX();
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bV() {
        if (this.gZ == null || this.hR == null || this.hS == null) {
            return;
        }
        this.gZ.destroyPixelReaderByPreFilterID(this.hR, this.hS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bW() {
        if (this.gZ != null) {
            this.gZ.clearCaptureData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i, int i2) {
        h(i, i2);
        a(this.hQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.aL != null) {
            this.aL.removeCallbacksAndMessages(null);
            this.aL = null;
        }
        if (this.hQ != null && this.hP != null) {
            this.hQ.removeLuaMsgListener(this.hP);
        }
        this.hQ = null;
        this.hP = null;
        this.hO = null;
        this.hR = null;
        this.hS = null;
        this.gZ = null;
    }
}
