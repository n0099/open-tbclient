package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* loaded from: classes.dex */
public class z implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4227a;

    public z(BaiduArView baiduArView) {
        this.f4227a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.f4227a.x = true;
                } else {
                    this.f4227a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.f4227a.y = true;
                } else {
                    this.f4227a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.f4227a.z = true;
                } else {
                    this.f4227a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.f4227a.B = true;
                } else {
                    this.f4227a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.f4227a.D = true;
                } else {
                    this.f4227a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.f4227a.A = true;
                } else {
                    this.f4227a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.f4227a.C = true;
                } else {
                    this.f4227a.C = false;
                }
            }
        }
    }
}
