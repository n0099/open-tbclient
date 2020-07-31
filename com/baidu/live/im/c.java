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
/* loaded from: classes4.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aCO;
    public int aCP;
    public int aCQ;
    public int aCR;
    public int aCS;
    public boolean aTA;
    public boolean aTB;
    private final int aTk;
    private final int aTl;
    private final int aTm;
    private final int aTn;
    private final int aTo;
    private final int aTp;
    private final int aTq;
    private final int aTr;
    private final int aTs;
    private ViewGroup aTt;
    public TextView aTu;
    public ImageView aTv;
    public View aTw;
    public HeadImageView aTx;
    public TbImageView aTy;
    private boolean aTz;
    private final int aim;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aTk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aTl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aTm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aTn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aTo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aTp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.aim = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aTq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aTr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.aTs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.aTz = z;
        this.aTt = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aTu = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aTv = (ImageView) getView().findViewById(a.g.iv_tail);
        this.aTw = getView().findViewById(a.g.head_layout);
        this.aTx = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.aTy = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.aTx.setIsRound(true);
        this.aTx.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.aTx.setAutoChangeStyle(false);
        if (this.aTz) {
            this.aTu.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aTt.setBackgroundDrawable(null);
            this.aTt.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.aXn;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.aXp;
        boolean z4 = aVar.aXq;
        boolean z5 = aVar.aXr;
        boolean z6 = aVar.aXs;
        if (!this.aTz) {
            this.aTv.setVisibility(8);
            if (z) {
                int i = this.aim;
                if (this.aTA) {
                    if (this.aTB) {
                        i = this.aTk + this.aTm + this.aTn;
                        this.aTv.setVisibility(0);
                    }
                    an(context);
                } else if (z3) {
                    this.aTu.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ao(context);
                } else if (z5) {
                    this.aTu.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aTu.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aTu.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aTu.setPadding(this.aim, this.aTk, i, this.aTl);
            } else if (z2) {
                int i2 = this.aTp;
                this.aTu.setBackgroundDrawable(null);
                this.aTu.setPadding(this.aTp, 0, i2, 0);
            } else {
                this.aTu.setBackgroundDrawable(null);
                this.aTu.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.aTy.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.aTy.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.aTy.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.aTy.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.aTs;
            if (z2) {
                this.aTy.setVisibility(0);
                i2 = this.aTs;
            } else {
                this.aTy.setVisibility(8);
                i2 = this.aTr;
            }
            this.aTx.getLayoutParams().width = i2;
            this.aTx.getLayoutParams().height = i2;
            this.aTx.stopLoad();
            this.aTx.startLoad(str, 12, false, false);
            this.aTw.setVisibility(0);
            return;
        }
        this.aTw.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.aTz) {
            if (z) {
                this.aTu.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aTu.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bG(boolean z) {
        if (z) {
            if (this.aTu != null) {
                this.aTu.setTextSize(0, this.aTq);
                this.aTu.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aTu != null) {
            this.aTu.setTextSize(0, this.aTo);
        }
    }

    private void an(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aCS);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aCQ != 0 || this.aCR != 0) {
            gVar.setColors(this.aCO, this.aCP, this.aCQ, this.aCR);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.K(this.aCO, this.aCP);
        }
        this.aTu.setBackgroundDrawable(gVar);
    }

    private void ao(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aTu.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aCO = 0;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCR = 0;
        this.aCS = 255;
        this.aTB = false;
    }
}
