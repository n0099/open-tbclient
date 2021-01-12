package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class z implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduArView f1569a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(BaiduArView baiduArView) {
        this.f1569a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.f1569a.x = true;
                } else {
                    this.f1569a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.f1569a.y = true;
                } else {
                    this.f1569a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.f1569a.z = true;
                } else {
                    this.f1569a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.f1569a.B = true;
                } else {
                    this.f1569a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.f1569a.D = true;
                } else {
                    this.f1569a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.f1569a.A = true;
                } else {
                    this.f1569a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.f1569a.C = true;
                } else {
                    this.f1569a.C = false;
                }
            }
        }
    }
}
