package com.baidu.live.ar;

import com.baidu.live.ar.AlaFilterAndBeautyData;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface k {

    /* loaded from: classes4.dex */
    public interface a {
        Object Cm();

        String getType();

        void setValue(float f);
    }

    void Cj();

    void Ck();

    void Cl();

    void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey);

    void a(float f, HashMap<String, Object> hashMap);

    void a(a aVar);

    void onBlurLevelSelected(int i);

    void onFilterSelected(String str, String str2, float f);

    void s(int i, int i2);

    void t(int i, int i2);

    void u(int i, int i2);

    void v(int i, int i2);
}
