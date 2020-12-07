package com.baidu.ar.arplay.core.engine;

import com.baidu.ar.arplay.core.message.ARPMessage;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private ARPMessage.MessageHandler fv;
    private boolean fw = false;
    private boolean fx = false;
    private boolean fy = false;
    private boolean fz = false;
    private boolean fA = false;
    private boolean fB = false;
    private boolean fC = false;
    private boolean fD = false;
    private boolean fE = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        aV();
    }

    private void aV() {
        this.fv = new ARPMessage.MessageHandler() { // from class: com.baidu.ar.arplay.core.engine.b.1
            @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            b.this.fw = true;
                        } else {
                            b.this.fw = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            b.this.fx = true;
                        } else {
                            b.this.fx = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            b.this.fy = true;
                        } else {
                            b.this.fy = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            b.this.fz = true;
                        } else {
                            b.this.fz = false;
                        }
                    }
                    if (hashMap.get("disable_swipe") != null) {
                        if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                            b.this.fA = true;
                        } else {
                            b.this.fA = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            b.this.fB = true;
                        } else {
                            b.this.fB = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            b.this.fC = true;
                        } else {
                            b.this.fC = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            b.this.fD = true;
                        } else {
                            b.this.fD = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_rotate") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                            b.this.fE = true;
                        } else {
                            b.this.fE = false;
                        }
                    }
                }
            }
        };
    }

    public boolean aW() {
        return (this.fw || this.fx) ? false : true;
    }

    public boolean aX() {
        return (this.fw || this.fy) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aY() {
        return (this.fw || this.fz) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aZ() {
        return (this.fw || this.fB) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ba() {
        return (this.fw || this.fC) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bb() {
        return (this.fw || this.fA) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bc() {
        return (this.fw || this.fD) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bd() {
        return (this.fw || this.fE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        ARPMessage.getInstance().removeMessageHandeler(this.fv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        ARPMessage.getInstance().registerMessageHandler(11, this.fv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.fv = null;
    }
}
