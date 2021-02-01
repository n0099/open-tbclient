package com.baidu.live.aj;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a {
    public static int b(Context context, boolean z, boolean z2, boolean z3) {
        return c.d(z, z2, z3) + context.getResources().getDimensionPixelSize(a.d.sdk_tbds130) + context.getResources().getDimensionPixelOffset(a.d.sdk_ds80) + context.getResources().getDimensionPixelOffset(a.d.sdk_ds20) + context.getResources().getDimensionPixelOffset(a.d.sdk_ds6);
    }

    public static int i(boolean z, boolean z2) {
        return c.d(z, z2, false) + c.dr(z);
    }
}
