package com.baidu.mobads.nativecpu;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR(TbConfig.ST_TYPE_REG),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");
    

    /* renamed from: a  reason: collision with root package name */
    String f3402a;

    CpuLpFontSize(String str) {
        this.f3402a = str;
    }

    public String getValue() {
        return this.f3402a;
    }
}
