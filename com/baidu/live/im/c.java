package com.baidu.live.im;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aBt;
    public int aBu;
    public int aBv;
    public int aBw;
    public int aBx;
    private final int aRR;
    private final int aRS;
    private final int aRT;
    private final int aRU;
    private final int aRV;
    private final int aRW;
    private final int aRX;
    private final int aRY;
    private final int aRZ;
    private ViewGroup aSa;
    public TextView aSb;
    public ImageView aSc;
    public View aSd;
    public HeadImageView aSe;
    public TbImageView aSf;
    private boolean aSg;
    public boolean aSh;
    public boolean aSi;
    private final int aiu;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aRR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aRS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aRT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aRU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aRV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aRW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.aiu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aRX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aRY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.aRZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.aSg = z;
        this.aSa = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aSb = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aSc = (ImageView) getView().findViewById(a.g.iv_tail);
        this.aSd = getView().findViewById(a.g.head_layout);
        this.aSe = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.aSf = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.aSe.setIsRound(true);
        this.aSe.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.aSe.setAutoChangeStyle(false);
        if (this.aSg) {
            this.aSb.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aSa.setBackgroundDrawable(null);
            this.aSa.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.c.a aVar) {
        boolean z = aVar.aWt;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.aWv;
        boolean z4 = aVar.aWw;
        boolean z5 = aVar.aWx;
        boolean z6 = aVar.aWy;
        if (!this.aSg) {
            this.aSc.setVisibility(8);
            if (z) {
                int i = this.aiu;
                if (this.aSh) {
                    if (this.aSi) {
                        i = this.aRR + this.aRT + this.aRU;
                        this.aSc.setVisibility(0);
                    }
                    an(context);
                } else if (z3) {
                    this.aSb.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ao(context);
                } else if (z5) {
                    this.aSb.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aSb.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aSb.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aSb.setPadding(this.aiu, this.aRR, i, this.aRS);
            } else if (z2) {
                int i2 = this.aRW;
                this.aSb.setBackgroundDrawable(null);
                this.aSb.setPadding(this.aRW, 0, i2, 0);
            } else {
                this.aSb.setBackgroundDrawable(null);
                this.aSb.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.aSf.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.aSf.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.aSf.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.aSf.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.aRZ;
            if (z2) {
                this.aSf.setVisibility(0);
                i2 = this.aRZ;
            } else {
                this.aSf.setVisibility(8);
                i2 = this.aRY;
            }
            this.aSe.getLayoutParams().width = i2;
            this.aSe.getLayoutParams().height = i2;
            this.aSe.stopLoad();
            this.aSe.startLoad(str, 12, false, false);
            this.aSd.setVisibility(0);
            return;
        }
        this.aSd.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.aSg) {
            if (z) {
                this.aSb.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aSb.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bD(boolean z) {
        if (z) {
            if (this.aSb != null) {
                this.aSb.setTextSize(0, this.aRX);
                this.aSb.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aSb != null) {
            this.aSb.setTextSize(0, this.aRV);
        }
    }

    private void an(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aBx);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aBv != 0 || this.aBw != 0) {
            gVar.setColors(this.aBt, this.aBu, this.aBv, this.aBw);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.K(this.aBt, this.aBu);
        }
        this.aSb.setBackgroundDrawable(gVar);
    }

    private void ao(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aSb.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aBt = 0;
        this.aBu = 0;
        this.aBv = 0;
        this.aBw = 0;
        this.aBx = 255;
        this.aSi = false;
    }
}
