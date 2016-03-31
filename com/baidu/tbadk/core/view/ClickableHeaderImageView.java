package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private com.baidu.tbadk.core.data.as aeC;
    private View.OnClickListener aeD;
    private int aeE;
    private final int aeF;
    private boolean aeG;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aeE = 0;
        this.aeG = false;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aeF = com.baidu.adp.lib.util.k.c(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeE = 0;
        this.aeG = false;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aeF = com.baidu.adp.lib.util.k.c(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && asVar.getAuthor() != null) {
            this.aeC = asVar;
            setContentDescription(String.valueOf(asVar.getAuthor().getName_show()) + this.mContext.getString(t.j.somebodys_portrait));
            c(asVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
            asVar.setAuthor(metaData);
            setData(asVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aeD = onClickListener;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        if (this.aeG && canvas != null && (drawable = at.getDrawable(t.f.pic_home_shen_avatar)) != null) {
            int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
            int width = getWidth();
            int height = getHeight();
            if (this.aeG) {
                drawable.setBounds((width - c) - this.aeE, (height - c) - this.aeE, width - this.aeE, height - this.aeE);
            }
            drawable.draw(canvas);
        }
    }

    public void setGodIconMargin(int i) {
        this.aeG = true;
        setDefaultResource(17170445);
        setDefaultErrorResource(t.f.icon_default_avatar100);
        setDefaultBgResource(t.d.cp_bg_line_e);
        setIsRound(true);
        if (i != 0) {
            this.aeE = com.baidu.adp.lib.util.k.c(this.mContext, i);
        }
        invalidate();
    }
}
