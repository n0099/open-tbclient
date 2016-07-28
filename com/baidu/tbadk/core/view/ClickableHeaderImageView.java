package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private be abb;
    private View.OnClickListener abc;
    private int abd;
    private final int abe;
    public boolean abf;
    public boolean abg;
    private int abh;
    private Drawable abi;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.abd = 0;
        this.abf = false;
        this.abg = false;
        this.abh = 0;
        this.abi = null;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.abe = com.baidu.adp.lib.util.k.c(context, u.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abd = 0;
        this.abf = false;
        this.abg = false;
        this.abh = 0;
        this.abi = null;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.abe = com.baidu.adp.lib.util.k.c(context, u.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(be beVar) {
        if (beVar != null && beVar.getAuthor() != null) {
            this.abb = beVar;
            setContentDescription(String.valueOf(beVar.getAuthor().getName_show()) + this.mContext.getString(u.j.somebodys_portrait));
            c(beVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            be beVar = new be();
            beVar.setAuthor(metaData);
            setData(beVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.abc = onClickListener;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.abh != 0) {
                Paint paint = new Paint();
                paint.setColor(this.abh);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.abf && !this.abg) {
                Drawable drawable = this.abi == null ? av.getDrawable(u.f.pic_home_shen_avatar) : this.abi;
                if (drawable != null) {
                    int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.abf) {
                        drawable.setBounds((width - c) - this.abd, (height - c) - this.abd, width - this.abd, height - this.abd);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.abf = true;
        setDefaultResource(17170445);
        setDefaultErrorResource(u.f.icon_default_avatar100);
        setDefaultBgResource(u.d.cp_bg_line_e);
        setIsRound(true);
        if (i > 0) {
            this.abd = com.baidu.adp.lib.util.k.c(this.mContext, i);
        }
        if (i < 0) {
            this.abf = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.abf = false;
        setDefaultResource(17170445);
        setDefaultErrorResource(u.f.icon_default_avatar100);
        setDefaultBgResource(u.d.cp_bg_line_e);
        setIsRound(true);
        this.abd = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.abh = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.abi = drawable;
    }

    public void setIsBigV(boolean z) {
        this.abg = z;
    }
}
