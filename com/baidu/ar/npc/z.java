package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class z implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(BaiduArView baiduArView) {
        this.f1240a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.f1240a.x = true;
                } else {
                    this.f1240a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.f1240a.y = true;
                } else {
                    this.f1240a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.f1240a.z = true;
                } else {
                    this.f1240a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.f1240a.B = true;
                } else {
                    this.f1240a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.f1240a.D = true;
                } else {
                    this.f1240a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.f1240a.A = true;
                } else {
                    this.f1240a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.f1240a.C = true;
                } else {
                    this.f1240a.C = false;
                }
            }
        }
    }
}
