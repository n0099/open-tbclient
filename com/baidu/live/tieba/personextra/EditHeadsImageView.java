package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes4.dex */
public class EditHeadsImageView extends DragImageView {
    private int bGd;
    private int bGe;
    private float bGf;
    private float bGg;
    private int bGi;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGi = 0;
        this.bGg = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGi = 0;
        this.bGg = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGi = 0;
        this.bGg = 1.0f;
        init();
    }

    private void init() {
        this.bGi = getResources().getColor(a.c.sdk_ph_common_color_10226);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.live.tbadk.widget.DragImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.DragImageView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bGg * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bGd = (int) (((i4 - i2) - width) * this.bGf);
        this.bGe = (int) (((i4 - i2) - width) * (1.0f - this.bGf));
        setOffset(0, this.bGd, 0, this.bGe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.bGi);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap cZ(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.bGd, getWidth(), (getHeight() - this.bGe) - this.bGd);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, 48, 48, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return bitmap;
    }

    public void setCutImageHeightScale(float f) {
        this.bGg = f;
        invalidate();
    }
}
