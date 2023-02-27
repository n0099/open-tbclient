package com.baidu.searchbox.crius.util;

import android.view.View;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class SizeSpec {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static int round(float f) {
        return (int) (f > 0.0f ? f + 0.5d : f - 0.5d);
    }

    /* renamed from: com.baidu.searchbox.crius.util.SizeSpec$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$crius$CriusMeasureMode;

        static {
            int[] iArr = new int[CriusMeasureMode.values().length];
            $SwitchMap$com$baidu$crius$CriusMeasureMode = iArr;
            try {
                iArr[CriusMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusMeasureMode[CriusMeasureMode.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusMeasureMode[CriusMeasureMode.AT_MOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int getMode(int i) {
        return View.MeasureSpec.getMode(i);
    }

    public static int getSize(int i) {
        return View.MeasureSpec.getSize(i);
    }

    public static String toString(int i) {
        return View.MeasureSpec.toString(i);
    }

    public static int makeSizeSpec(int i, int i2) {
        return View.MeasureSpec.makeMeasureSpec(i, i2);
    }

    public static int makeSizeSpecFromCssSpec(float f, CriusMeasureMode criusMeasureMode) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusMeasureMode[criusMeasureMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (!DEBUG) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unexpected YogaMeasureMode: " + criusMeasureMode);
                }
                return makeSizeSpec(round(f), Integer.MIN_VALUE);
            }
            return makeSizeSpec(0, 0);
        }
        return makeSizeSpec(round(f), 1073741824);
    }

    public static int resolveSize(int i, int i2) {
        int mode = getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    if (!DEBUG) {
                        return 0;
                    }
                    throw new IllegalStateException("Unexpected size mode: " + getMode(i));
                }
                return getSize(i);
            }
            return i2;
        }
        return Math.min(getSize(i), i2);
    }
}
