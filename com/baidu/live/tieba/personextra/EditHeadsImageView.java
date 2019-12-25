package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes2.dex */
public class EditHeadsImageView extends DragImageView {
    private int awa;
    private int awb;
    private float awc;
    private float awd;
    private int awf;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awf = 0;
        this.awd = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awf = 0;
        this.awd = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awf = 0;
        this.awd = 1.0f;
        init();
    }

    private void init() {
        this.awf = getResources().getColor(a.d.sdk_ph_common_color_10226);
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
        float width = this.awd * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.awa = (int) (((i4 - i2) - width) * this.awc);
        this.awb = (int) (((i4 - i2) - width) * (1.0f - this.awc));
        setOffset(0, this.awa, 0, this.awb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.awf);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap ba(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.awa, getWidth(), (getHeight() - this.awb) - this.awa);
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
        this.awd = f;
        invalidate();
    }
}
