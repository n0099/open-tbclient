package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
/* loaded from: classes.dex */
public class n extends BdGridView {
    private int ajS;
    private int columnCount;
    private int rowCount;

    public n(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.ajS);
            paint.setStrokeWidth(1.0f);
            int width = childAt.getWidth() * this.columnCount;
            int height = childAt.getHeight() * this.rowCount;
            int width2 = childAt.getWidth();
            int height2 = childAt.getHeight();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.rowCount) {
                    break;
                }
                canvas.drawLine(0.0f, height2 * i2, width, height2 * i2, paint);
                i = i2 + 1;
            }
            for (int i3 = 0; i3 < this.columnCount; i3++) {
                canvas.drawLine(width2 * i3, 0.0f, width2 * i3, height, paint);
            }
        }
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(int i) {
        this.rowCount = i;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public void setColumnCount(int i) {
        this.columnCount = i;
    }

    public int getBackgroundLineResource() {
        return this.ajS;
    }

    public void setBackgroundLineResource(int i) {
        this.ajS = i;
    }
}
