package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int asX;
    private int daZ;
    private boolean dba;
    private String dbb;
    private int dbc;
    private Rect dbd;
    private int dbe;
    private int dbf;
    private int dbg;
    private RectF dbh;
    private int dbi;
    private int dbj;
    private int dbk;
    private int dbl;
    private Paint dbm;
    private RectF dbn;
    private boolean dbo;
    private int dbp;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dbo = false;
        this.dbp = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dbo = false;
        this.dbp = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dbo = false;
        this.dbp = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dbi = this.dbf >= this.dbg ? this.mShadowRadius + this.dbf : this.mShadowRadius + this.dbg;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dbi * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dbi * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight();
            if (this.dbo) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dbi, this.dbi, this.dbi + intrinsicWidth, this.dbi + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dbo) {
                this.dbh.set(this.dbi, this.dbi, this.dbi + intrinsicWidth, this.dbi + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dbh, this.dbj, this.dbj, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dbh, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dbb)) {
                if (this.dbb.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dbi + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dbi;
            if (this.dbo) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dbk / 2);
            int i2 = intrinsicHeight - (this.dbk / 2);
            int i3 = intrinsicWidth + (this.dbk / 2);
            int i4 = intrinsicHeight + (this.dbk / 2);
            this.dbn.set(i, i2, i3, i4);
            canvas.drawOval(this.dbn, this.dbm);
            this.dbn.set((i - this.dbl) - this.dbk, i2, i - this.dbl, i4);
            canvas.drawOval(this.dbn, this.dbm);
            this.dbn.set(this.dbl + i3, i2, i3 + this.dbl + this.dbk, i4);
            canvas.drawOval(this.dbn, this.dbm);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dbb) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dbb, 0, this.dbb.length(), this.dbd);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dbi + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dbo) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dbb, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aES();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dbo) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dbd = new Rect();
        this.asX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dbe = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dbf = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dbg = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dbf, this.dbg, am.getColor(R.color.cp_cont_h_alpha66));
        this.dbh = new RectF();
        this.dbj = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dbk = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dbl = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dbm = new Paint();
        this.dbm.setAntiAlias(true);
        this.dbm.setStyle(Paint.Style.FILL);
        this.dbm.setColor(am.getColor(R.color.cp_cont_a));
        this.dbn = new RectF();
    }

    private void aES() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dbc = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dbb = null;
        } else if (i < 10) {
            this.dbb = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dbb = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dbb = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dbb = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.daZ) {
            this.dba = true;
        } else {
            this.dba = false;
        }
        this.daZ = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dbo = z;
    }

    public void onChangeSkinType() {
        this.dbp = TbadkApplication.getInst().getSkinType();
        if (this.daZ > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.daZ);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dbm.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dbf, this.dbg, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dba) {
            this.dba = false;
            requestLayout();
        }
        invalidate();
    }
}
