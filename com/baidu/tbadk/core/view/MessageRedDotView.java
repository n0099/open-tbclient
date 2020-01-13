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
    private int atJ;
    private int dbA;
    private int dbk;
    private boolean dbl;
    private String dbm;
    private int dbn;
    private Rect dbo;
    private int dbp;
    private int dbq;
    private int dbr;
    private RectF dbs;
    private int dbt;
    private int dbu;
    private int dbv;
    private int dbw;
    private Paint dbx;
    private RectF dby;
    private boolean dbz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dbz = false;
        this.dbA = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dbz = false;
        this.dbA = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dbz = false;
        this.dbA = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dbt = this.dbq >= this.dbr ? this.mShadowRadius + this.dbq : this.mShadowRadius + this.dbr;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dbt * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dbt * 2));
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
            if (this.dbz) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dbt, this.dbt, this.dbt + intrinsicWidth, this.dbt + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dbz) {
                this.dbs.set(this.dbt, this.dbt, this.dbt + intrinsicWidth, this.dbt + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dbs, this.dbu, this.dbu, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dbs, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dbm)) {
                if (this.dbm.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dbt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dbt;
            if (this.dbz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dbv / 2);
            int i2 = intrinsicHeight - (this.dbv / 2);
            int i3 = intrinsicWidth + (this.dbv / 2);
            int i4 = intrinsicHeight + (this.dbv / 2);
            this.dby.set(i, i2, i3, i4);
            canvas.drawOval(this.dby, this.dbx);
            this.dby.set((i - this.dbw) - this.dbv, i2, i - this.dbw, i4);
            canvas.drawOval(this.dby, this.dbx);
            this.dby.set(this.dbw + i3, i2, i3 + this.dbw + this.dbv, i4);
            canvas.drawOval(this.dby, this.dbx);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dbm) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dbm, 0, this.dbm.length(), this.dbo);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dbt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dbz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dbm, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aFl();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dbz) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dbo = new Rect();
        this.atJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dbp = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dbq = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dbr = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dbq, this.dbr, am.getColor(R.color.cp_cont_h_alpha66));
        this.dbs = new RectF();
        this.dbu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dbv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dbw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dbx = new Paint();
        this.dbx.setAntiAlias(true);
        this.dbx.setStyle(Paint.Style.FILL);
        this.dbx.setColor(am.getColor(R.color.cp_cont_a));
        this.dby = new RectF();
    }

    private void aFl() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dbn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dbm = null;
        } else if (i < 10) {
            this.dbm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dbm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dbm = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dbm = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dbk) {
            this.dbl = true;
        } else {
            this.dbl = false;
        }
        this.dbk = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dbz = z;
    }

    public void onChangeSkinType() {
        this.dbA = TbadkApplication.getInst().getSkinType();
        if (this.dbk > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dbk);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dbx.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dbq, this.dbr, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dbl) {
            this.dbl = false;
            requestLayout();
        }
        invalidate();
    }
}
