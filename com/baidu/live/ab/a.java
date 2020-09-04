package com.baidu.live.ab;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class a {
    public static int a(Context context, boolean z, boolean z2, boolean z3) {
        return b.c(z, z2, z3) + context.getResources().getDimensionPixelSize(a.e.sdk_tbds130) + context.getResources().getDimensionPixelOffset(a.e.sdk_ds80) + context.getResources().getDimensionPixelOffset(a.e.sdk_ds20) + context.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
    }

    public static int h(boolean z, boolean z2) {
        return b.c(z, z2, false) + b.cD(z);
    }
}
