package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bh acX;
    private View.OnClickListener acY;
    private int acZ;
    private final int ada;
    public boolean adb;
    public boolean adc;
    private int ade;
    private Drawable adf;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.acZ = 0;
        this.adb = false;
        this.adc = false;
        this.ade = 0;
        this.adf = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.ada = com.baidu.adp.lib.util.k.e(context, r.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acZ = 0;
        this.adb = false;
        this.adc = false;
        this.ade = 0;
        this.adf = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.ada = com.baidu.adp.lib.util.k.e(context, r.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.acX = bhVar;
            setContentDescription(String.valueOf(bhVar.getAuthor().getName_show()) + this.mContext.getString(r.l.somebodys_portrait));
            bo sz = bhVar.sz();
            if (sz != null && sz.channelId > 0) {
                getHeadView().c(sz.channelAvatar, 10, false);
            } else {
                getHeadView().c(bhVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = bhVar.getAuthor().getPendantData();
            if (sz != null && sz.channelId > 0) {
                dU(null);
            } else if (pendantData != null) {
                dU(bhVar.getAuthor().getPendantData().pL());
            } else {
                dU(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.setAuthor(metaData);
            setData(bhVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.acY = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ade != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ade);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adb && !this.adc && !vR()) {
                Drawable drawable = this.adf == null ? com.baidu.tbadk.core.util.ap.getDrawable(r.g.pic_home_shen_avatar) : this.adf;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.adb) {
                        drawable.setBounds((width - e) - this.acZ, (height - e) - this.acZ, width - this.acZ, height - this.acZ);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.adb = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.acZ = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.adb = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.adb = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.acZ = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ade = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.adf = drawable;
    }

    public void setIsBigV(boolean z) {
        this.adc = z;
    }
}
