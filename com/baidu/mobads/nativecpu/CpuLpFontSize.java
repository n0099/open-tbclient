package com.baidu.mobads.nativecpu;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR(TbConfig.ST_TYPE_REG),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");
    

    /* renamed from: a  reason: collision with root package name */
    String f2425a;

    CpuLpFontSize(String str) {
        this.f2425a = str;
    }

    public String getValue() {
        return this.f2425a;
    }
}
