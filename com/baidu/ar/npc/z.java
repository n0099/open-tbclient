package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class z implements ArBridge.d {
    final /* synthetic */ BaiduArView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(BaiduArView baiduArView) {
        this.a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.a.x = true;
                } else {
                    this.a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.a.y = true;
                } else {
                    this.a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.a.z = true;
                } else {
                    this.a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.a.B = true;
                } else {
                    this.a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.a.D = true;
                } else {
                    this.a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.a.A = true;
                } else {
                    this.a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.a.C = true;
                } else {
                    this.a.C = false;
                }
            }
        }
    }
}
