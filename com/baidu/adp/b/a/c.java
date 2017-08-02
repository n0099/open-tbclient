package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BY = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.BF.Cc) {
            float f = this.BF.Cd / 2.0f;
            if (!this.BF.Cg) {
                this.BB.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.BA.left, this.BA.top, this.Bz);
            PointF a2 = a(this.BA.right, this.BA.bottom, this.Bz);
            this.BB.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bz != null) {
            canvas.concat(this.Bz);
        }
        if (dVar.iC()) {
            Bitmap bitmap = dVar.BZ.getBitmap();
            this.BY.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BY, this.BA, this.mPaint);
            return;
        }
        this.BY.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Ca.a(canvas, this.BY, this.BA, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BF.Cc) {
            canvas.drawRect(this.BB, this.Bx);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BF.Ck != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.By.setColor(this.BF.Ck);
            canvas.drawRect(this.BI, this.By);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
