package com.baidu.sso.q;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
/* loaded from: classes2.dex */
public enum b {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, RomUtils.MANUFACTURER_VIVO),
    OPPO(3, RomUtils.MANUFACTURER_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, ManufacturerUtils.SAMSUNG),
    MEIZU(8, "meizu"),
    ALPS(9, "alps"),
    NUBIA(10, "nubia");
    
    public int n;
    public String o;

    b(int i2, String str) {
        this.n = i2;
        this.o = str;
    }

    public static b a(String str) {
        b[] values;
        if (TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        for (b bVar : values()) {
            if (bVar.o.equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return UNSUPPORT;
    }
}
