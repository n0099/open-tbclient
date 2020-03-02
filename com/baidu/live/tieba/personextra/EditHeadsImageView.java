package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.widget.DragImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes3.dex */
public class EditHeadsImageView extends DragImageView {
    private int aBd;
    private int aBe;
    private float aBf;
    private float aBg;
    private int aBi;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBi = 0;
        this.aBg = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBi = 0;
        this.aBg = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBi = 0;
        this.aBg = 1.0f;
        init();
    }

    private void init() {
        this.aBi = getResources().getColor(a.d.sdk_ph_common_color_10226);
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
        float width = this.aBg * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBd = (int) (((i4 - i2) - width) * this.aBf);
        this.aBe = (int) (((i4 - i2) - width) * (1.0f - this.aBf));
        setOffset(0, this.aBd, 0, this.aBe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.aBi);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap bm(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aBd, getWidth(), (getHeight() - this.aBe) - this.aBd);
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
        this.aBg = f;
        invalidate();
    }
}
