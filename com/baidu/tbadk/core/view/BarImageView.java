package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BarImageView extends TbClipImageView {
    private TbImageView.b Id;
    private int cmU;
    private boolean cmV;
    private Bitmap cmW;
    private Bitmap cmX;
    private Canvas cmY;
    private PaintFlagsDrawFilter cmZ;
    private int gi;
    private int mDefaultBgId;
    private int mDefaultId;
    private Path mPath;

    public BarImageView(Context context) {
        this(context, null, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultId = R.drawable.icon_default_ba_120;
        this.mDefaultBgId = R.color.cp_bg_line_e;
        this.mPath = new Path();
        this.cmU = 0;
        this.gi = 0;
        this.cmV = false;
        this.Id = new TbImageView.b() { // from class: com.baidu.tbadk.core.view.BarImageView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbImageView.getLayoutParams();
                    Path path = new Path();
                    path.reset();
                    int measuredWidth = tbImageView.getMeasuredWidth();
                    int i2 = (0 + measuredWidth) / 2;
                    int measuredHeight = tbImageView.getMeasuredHeight();
                    int i3 = (0 + measuredHeight) / 2;
                    path.moveTo(i2, 0);
                    path.quadTo(measuredWidth, 0 - com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), measuredWidth, i3);
                    path.quadTo(measuredWidth, com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6) + measuredHeight, i2, measuredHeight);
                    path.quadTo(0, measuredHeight + com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), 0, i3);
                    path.quadTo(0, 0 - com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6), i2, 0);
                    path.close();
                    BarImageView.this.tU.mPaint.setColor(am.getColor(R.color.white_alpha100));
                    BarImageView.this.tU.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.getDimens(BarImageView.this.getContext(), R.dimen.tbds6));
                    BarImageView.this.tU.mPaint.setStyle(Paint.Style.STROKE);
                    BarImageView.this.tU.mPaint.setAntiAlias(true);
                    canvas.drawPath(path, BarImageView.this.tU.mPaint);
                    canvas.clipPath(path);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        setDrawerType(0);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(R.drawable.icon_default_ba_120);
        setDefaultBgResource(this.mDefaultBgId);
    }

    private Bitmap ac(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPath(this.mPath, this.tU.mPaint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.tU == null || this.tU.mPaint == null) {
            super.onDraw(canvas);
        } else if (!this.cmV) {
            super.onDraw(canvas);
        } else {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mPath.reset();
            float f = measuredWidth;
            float f2 = (0.0f + f) / 2.0f;
            float f3 = measuredHeight;
            float f4 = (0.0f + f3) / 2.0f;
            this.mPath.moveTo(f2, 0.0f);
            this.mPath.cubicTo(measuredWidth - 14.0f, 0.0f, measuredWidth, 14.0f, f, f4);
            this.mPath.cubicTo(measuredWidth, measuredWidth - 14.0f, measuredWidth - 14.0f, measuredWidth, f2, f3);
            this.mPath.cubicTo(14.0f, measuredWidth, 0.0f, measuredWidth - 14.0f, 0.0f, f4);
            this.mPath.cubicTo(0.0f, 14.0f, 14.0f, 0.0f, f2, 0.0f);
            this.mPath.close();
            this.tU.mBorderPaint.setStyle(Paint.Style.FILL);
            this.tU.mBorderPaint.setColor(am.getColor(getStrokeColorResId()));
            canvas.drawPath(this.mPath, this.tU.mBorderPaint);
            this.mPath.reset();
            float strokeWith = getStrokeWith();
            float f5 = measuredWidth / 2;
            this.mPath.moveTo(f5, strokeWith);
            this.mPath.cubicTo((measuredWidth - strokeWith) - 14.0f, strokeWith, measuredWidth - strokeWith, 14.0f + strokeWith, measuredWidth - strokeWith, f5);
            this.mPath.cubicTo(measuredWidth - strokeWith, (measuredWidth - strokeWith) - 14.0f, (measuredWidth - strokeWith) - 14.0f, measuredWidth - strokeWith, f5, measuredWidth - strokeWith);
            this.mPath.cubicTo(strokeWith + 14.0f, measuredWidth - strokeWith, strokeWith, (measuredWidth - strokeWith) - 14.0f, strokeWith, f5);
            this.mPath.cubicTo(strokeWith, strokeWith + 14.0f, strokeWith + 14.0f, strokeWith, f5, strokeWith);
            this.mPath.close();
            if (this.cmZ == null) {
                this.cmZ = new PaintFlagsDrawFilter(0, 3);
            }
            canvas.setDrawFilter(this.cmZ);
            if (this.cmW == null) {
                this.cmW = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            }
            if (this.cmY == null) {
                this.cmY = new Canvas(this.cmW);
            }
            super.onDraw(this.cmY);
            if (this.cmX == null) {
                this.cmX = ac(measuredWidth, measuredHeight);
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
            canvas.drawBitmap(this.cmX, 0.0f, 0.0f, this.tU.mPaint);
            this.tU.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.cmW, 0.0f, 0.0f, this.tU.mPaint);
            this.tU.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    public void setStrokeWith(int i) {
        this.cmU = i;
    }

    public int getStrokeWith() {
        return this.cmU;
    }

    private int getStrokeColorResId() {
        return this.gi;
    }

    public void setStrokeColorResId(int i) {
        this.gi = i;
    }

    public void setShowOval(boolean z) {
        this.cmV = z;
    }
}
