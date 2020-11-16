package com.baidu.ar.arplay.core.engine;

import com.baidu.ar.arplay.core.message.ARPMessage;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class b {
    private ARPMessage.MessageHandler fn;
    private boolean fo = false;
    private boolean fp = false;
    private boolean fq = false;
    private boolean fr = false;
    private boolean fs = false;
    private boolean ft = false;
    private boolean fu = false;
    private boolean fv = false;
    private boolean fw = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        bb();
    }

    private void bb() {
        this.fn = new ARPMessage.MessageHandler() { // from class: com.baidu.ar.arplay.core.engine.b.1
            @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            b.this.fo = true;
                        } else {
                            b.this.fo = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            b.this.fp = true;
                        } else {
                            b.this.fp = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            b.this.fq = true;
                        } else {
                            b.this.fq = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            b.this.fr = true;
                        } else {
                            b.this.fr = false;
                        }
                    }
                    if (hashMap.get("disable_swipe") != null) {
                        if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                            b.this.fs = true;
                        } else {
                            b.this.fs = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            b.this.ft = true;
                        } else {
                            b.this.ft = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            b.this.fu = true;
                        } else {
                            b.this.fu = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            b.this.fv = true;
                        } else {
                            b.this.fv = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_rotate") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                            b.this.fw = true;
                        } else {
                            b.this.fw = false;
                        }
                    }
                }
            }
        };
    }

    public boolean bc() {
        return (this.fo || this.fp) ? false : true;
    }

    public boolean bd() {
        return (this.fo || this.fq) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean be() {
        return (this.fo || this.fr) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bf() {
        return (this.fo || this.ft) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bg() {
        return (this.fo || this.fu) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bh() {
        return (this.fo || this.fs) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bi() {
        return (this.fo || this.fv) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bj() {
        return (this.fo || this.fw) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        ARPMessage.getInstance().removeMessageHandeler(this.fn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        ARPMessage.getInstance().registerMessageHandler(11, this.fn);
    }
}
