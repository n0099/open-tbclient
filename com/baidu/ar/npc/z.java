package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* loaded from: classes.dex */
public class z implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4262a;

    public z(BaiduArView baiduArView) {
        this.f4262a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.f4262a.x = true;
                } else {
                    this.f4262a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.f4262a.y = true;
                } else {
                    this.f4262a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.f4262a.z = true;
                } else {
                    this.f4262a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.f4262a.B = true;
                } else {
                    this.f4262a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.f4262a.D = true;
                } else {
                    this.f4262a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.f4262a.A = true;
                } else {
                    this.f4262a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.f4262a.C = true;
                } else {
                    this.f4262a.C = false;
                }
            }
        }
    }
}
