package com.baidu.live.ar;

import com.baidu.live.ar.AlaFilterAndBeautyData;
import java.util.HashMap;
/* loaded from: classes11.dex */
public interface m {

    /* loaded from: classes11.dex */
    public interface a {
        Object CU();

        String getType();

        void setValue(float f);
    }

    void CS();

    void CT();

    void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey);

    void a(float f, HashMap<String, Object> hashMap);

    void a(a aVar);

    void onBlurLevelSelected(int i);

    void onClosed();

    void onFilterSelected(String str, String str2, float f);

    void t(int i, int i2);

    void u(int i, int i2);

    void v(int i, int i2);

    void w(int i, int i2);
}
