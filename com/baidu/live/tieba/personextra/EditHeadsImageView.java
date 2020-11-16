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
    private int bAV;
    private int bAW;
    private float bAX;
    private float bAY;
    private int bBa;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bBa = 0;
        this.bAY = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bBa = 0;
        this.bAY = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bBa = 0;
        this.bAY = 1.0f;
        init();
    }

    private void init() {
        this.bBa = getResources().getColor(a.c.sdk_ph_common_color_10226);
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
        float width = this.bAY * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bAV = (int) (((i4 - i2) - width) * this.bAX);
        this.bAW = (int) (((i4 - i2) - width) * (1.0f - this.bAX));
        setOffset(0, this.bAV, 0, this.bAW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.bBa);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap cL(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.bAV, getWidth(), (getHeight() - this.bAW) - this.bAV);
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
        this.bAY = f;
        invalidate();
    }
}
