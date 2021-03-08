package com.baidu.tbadk.core.elementsMaven.a;

import android.graphics.Path;
import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static float[] q(float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f);
        return fArr;
    }

    public static Path a(RectF rectF, float[] fArr) {
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        return path;
    }
}
