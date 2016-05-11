package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private ax aab;
    private View.OnClickListener aac;
    private int aad;
    private final int aae;
    private boolean aaf;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aad = 0;
        this.aaf = false;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aae = com.baidu.adp.lib.util.k.c(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aad = 0;
        this.aaf = false;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aae = com.baidu.adp.lib.util.k.c(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(ax axVar) {
        if (axVar != null && axVar.getAuthor() != null) {
            this.aab = axVar;
            setContentDescription(String.valueOf(axVar.getAuthor().getName_show()) + this.mContext.getString(t.j.somebodys_portrait));
            c(axVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            ax axVar = new ax();
            axVar.setAuthor(metaData);
            setData(axVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aac = onClickListener;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        if (this.aaf && canvas != null && (drawable = com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_home_shen_avatar)) != null) {
            int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
            int width = getWidth();
            int height = getHeight();
            if (this.aaf) {
                drawable.setBounds((width - c) - this.aad, (height - c) - this.aad, width - this.aad, height - this.aad);
            }
            drawable.draw(canvas);
        }
    }

    public void setGodIconMargin(int i) {
        this.aaf = true;
        setDefaultResource(17170445);
        setDefaultErrorResource(t.f.icon_default_avatar100);
        setDefaultBgResource(t.d.cp_bg_line_e);
        setIsRound(true);
        if (i != 0) {
            this.aad = com.baidu.adp.lib.util.k.c(this.mContext, i);
        }
        invalidate();
    }
}
