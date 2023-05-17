package com.baidu.searchbox.config.utils;

import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b¨\u0006\u0004"}, d2 = {"roundByPolicy", "", "", "roundPolicy", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MathUtilKt {
    public static final int roundByPolicy(float f, int i) {
        double ceil;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return MathKt__MathJVMKt.roundToInt(f);
                }
                return MathKt__MathJVMKt.roundToInt(f);
            }
            ceil = Math.floor(f);
        } else {
            ceil = Math.ceil(f);
        }
        return (int) ceil;
    }
}
