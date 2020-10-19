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
    public int aMA;
    public int aMB;
    public int aMC;
    public int aMD;
    public int aME;
    private final int akt;
    private final int beH;
    private final int beI;
    private final int beJ;
    private final int beK;
    private final int beL;
    private final int beM;
    private final int beN;
    private final int beO;
    private final int beP;
    private ViewGroup beQ;
    public TextView beR;
    public ImageView beS;
    public View beT;
    public HeadImageView beU;
    public TbImageView beV;
    private boolean beW;
    public boolean beX;
    public boolean beY;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.beH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.beI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.beJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.beK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.beL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.beM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.akt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.beN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.beO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.beP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.beW = z;
        this.beQ = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.beR = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.beS = (ImageView) getView().findViewById(a.g.iv_tail);
        this.beT = getView().findViewById(a.g.head_layout);
        this.beU = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.beV = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.beU.setIsRound(true);
        this.beU.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.beU.setAutoChangeStyle(false);
        if (this.beW) {
            this.beR.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.beQ.setBackgroundDrawable(null);
            this.beQ.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bjf;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bjh;
        boolean z4 = aVar.bji;
        boolean z5 = aVar.bjj;
        boolean z6 = aVar.bjk;
        if (!this.beW) {
            this.beS.setVisibility(8);
            if (z) {
                int i = this.akt;
                if (this.beX) {
                    if (this.beY) {
                        i = this.beH + this.beJ + this.beK;
                        this.beS.setVisibility(0);
                    }
                    at(context);
                } else if (z3) {
                    this.beR.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    au(context);
                } else if (z5) {
                    this.beR.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.beR.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.beR.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.beR.setPadding(this.akt, this.beH, i, this.beI);
            } else if (z2) {
                int i2 = this.beM;
                this.beR.setBackgroundDrawable(null);
                this.beR.setPadding(this.beM, 0, i2, 0);
            } else {
                this.beR.setBackgroundDrawable(null);
                this.beR.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.beV.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.beV.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.beV.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.beV.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.beP;
            if (z2) {
                this.beV.setVisibility(0);
                i2 = this.beP;
            } else {
                this.beV.setVisibility(8);
                i2 = this.beO;
            }
            this.beU.getLayoutParams().width = i2;
            this.beU.getLayoutParams().height = i2;
            this.beU.stopLoad();
            this.beU.startLoad(str, 12, false, false);
            this.beT.setVisibility(0);
            return;
        }
        this.beT.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.beW) {
            if (z) {
                this.beR.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.beR.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bQ(boolean z) {
        if (z) {
            if (this.beR != null) {
                this.beR.setTextSize(0, this.beN);
                this.beR.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.beR != null) {
            this.beR.setTextSize(0, this.beL);
        }
    }

    private void at(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aME);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aMC != 0 || this.aMD != 0) {
            gVar.setColors(this.aMA, this.aMB, this.aMC, this.aMD);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.O(this.aMA, this.aMB);
        }
        this.beR.setBackgroundDrawable(gVar);
    }

    private void au(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.beR.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aMA = 0;
        this.aMB = 0;
        this.aMC = 0;
        this.aMD = 0;
        this.aME = 255;
        this.beY = false;
    }
}
