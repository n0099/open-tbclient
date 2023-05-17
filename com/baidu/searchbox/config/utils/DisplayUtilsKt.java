package com.baidu.searchbox.config.utils;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\t\u0010\u0004\u001a\u00020\u0005H\u0082\b\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"STANDARD_SCREEN", "", "isInit", "", "initIfNeed", "", "toStandardScreen", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DisplayUtilsKt {
    public static float STANDARD_SCREEN = 1.0f;
    public static boolean isInit;

    public static final void initIfNeed() {
        if (isInit) {
            return;
        }
        try {
            isInit = true;
            STANDARD_SCREEN = Math.min(3 / AppRuntime.getAppContext().getResources().getDisplayMetrics().density, STANDARD_SCREEN);
        } catch (Exception e) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e.printStackTrace();
            }
        }
    }

    public static final float toStandardScreen(float f) {
        if (!isInit) {
            try {
                isInit = true;
                STANDARD_SCREEN = Math.min(3 / AppRuntime.getAppContext().getResources().getDisplayMetrics().density, STANDARD_SCREEN);
            } catch (Exception e) {
                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                    e.printStackTrace();
                }
            }
        }
        return STANDARD_SCREEN * f;
    }
}
