package com.baidu.searchbox.fluency.utils;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "dp2px", "(I)F", "", "toFloatSafely", "(Ljava/lang/String;)F", "toIntSafely", "(Ljava/lang/String;)I", "lib-fps_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class CommonUtilsKt {
    public static final float dp2px(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (i * system.getDisplayMetrics().density) + 0.5f;
    }

    public static final float toFloatSafely(String toFloatSafely) {
        Intrinsics.checkNotNullParameter(toFloatSafely, "$this$toFloatSafely");
        try {
            return Float.parseFloat(toFloatSafely);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static final int toIntSafely(String toIntSafely) {
        Intrinsics.checkNotNullParameter(toIntSafely, "$this$toIntSafely");
        try {
            return Integer.parseInt(toIntSafely);
        } catch (Exception unused) {
            return 0;
        }
    }
}
