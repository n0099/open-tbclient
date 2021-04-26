package com.baidu.tbadk.core.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class RoundRectShapeWithEdge extends RectShape {
    public int edge = 0;
    public float[] mOuterRadii;
    public Path mPath;

    public RoundRectShapeWithEdge(@Nullable float[] fArr) {
        if (fArr != null && fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        }
        this.mOuterRadii = fArr;
        this.mPath = new Path();
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(this.mPath, paint);
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void onResize(float f2, float f3) {
        RectF rect = rect();
        int i2 = this.edge;
        rect.set(i2, i2, f2 - i2, f3 - i2);
        this.mPath.reset();
        float[] fArr = this.mOuterRadii;
        if (fArr != null) {
            this.mPath.addRoundRect(rect, fArr, Path.Direction.CW);
        } else {
            this.mPath.addRect(rect, Path.Direction.CW);
        }
    }

    public void setEdge(int i2) {
        this.edge = i2;
    }
}
