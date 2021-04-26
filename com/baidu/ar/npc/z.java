package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.HashMap;
/* loaded from: classes.dex */
public class z implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduArView f4332a;

    public z(BaiduArView baiduArView) {
        this.f4332a = baiduArView;
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i2, int i3, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (hashMap.get("disable_all") != null) {
                if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                    this.f4332a.x = true;
                } else {
                    this.f4332a.x = false;
                }
            }
            if (hashMap.get("disable_pinch") != null) {
                if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                    this.f4332a.y = true;
                } else {
                    this.f4332a.y = false;
                }
            }
            if (hashMap.get("disable_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                    this.f4332a.z = true;
                } else {
                    this.f4332a.z = false;
                }
            }
            if (hashMap.get("disable_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                    this.f4332a.B = true;
                } else {
                    this.f4332a.B = false;
                }
            }
            if (hashMap.get("disable_long_press") != null) {
                if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                    this.f4332a.D = true;
                } else {
                    this.f4332a.D = false;
                }
            }
            if (hashMap.get("disable_double_click") != null) {
                if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                    this.f4332a.A = true;
                } else {
                    this.f4332a.A = false;
                }
            }
            if (hashMap.get("disable_two_finger_scroll") != null) {
                if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                    this.f4332a.C = true;
                } else {
                    this.f4332a.C = false;
                }
            }
        }
    }
}
