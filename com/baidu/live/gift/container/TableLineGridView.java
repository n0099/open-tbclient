package com.baidu.live.gift.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.tbadk.core.view.BdGridView;
/* loaded from: classes4.dex */
public class TableLineGridView extends BdGridView {
    private int aNu;
    private int columnCount;
    private int mWidth;
    private int rowCount;

    public TableLineGridView(Context context) {
        super(context);
    }

    public TableLineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TableLineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        int i = 1;
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.aNu);
            paint.setStrokeWidth(this.mWidth);
            int width = childAt.getWidth() * this.columnCount;
            int height = childAt.getHeight() * this.rowCount;
            int width2 = childAt.getWidth();
            int height2 = childAt.getHeight();
            for (int i2 = 1; i2 < this.rowCount; i2++) {
                canvas.drawLine(0.0f, height2 * i2, width, height2 * i2, paint);
            }
            while (true) {
                int i3 = i;
                if (i3 < this.columnCount) {
                    canvas.drawLine(width2 * i3, 0.0f, width2 * i3, height, paint);
                    i = i3 + 1;
                } else {
                    super.dispatchDraw(canvas);
                    return;
                }
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
        return this.aNu;
    }

    public void setBackgroundLineResource(int i) {
        this.aNu = i;
    }

    public void setStokeWidth(int i) {
        this.mWidth = i;
    }
}
