package com.baidu.live.ar;

import android.text.TextUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends d {
    public static b Uj = new b();
    public static b Uk = new b();
    public String Ug = "";
    public String Uh;
    private HashMap<String, Integer> Ui;

    public b() {
        this.Uh = "";
        this.Uh = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        oO();
    }

    public void oO() {
        this.Ui = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.Ui.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public int cJ(String str) {
        if (TextUtils.isEmpty(str) || this.Ui == null || this.Ui.isEmpty() || this.Ui.get(str) == null) {
            return 0;
        }
        return this.Ui.get(str).intValue();
    }
}
