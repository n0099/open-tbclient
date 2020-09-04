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
/* loaded from: classes7.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aIa;
    public int aIb;
    public int aIc;
    public int aId;
    public int aIe;
    private final int aYA;
    private final int aYB;
    private final int aYC;
    private final int aYD;
    private final int aYE;
    private final int aYF;
    private final int aYG;
    private final int aYH;
    private final int aYI;
    private ViewGroup aYJ;
    public TextView aYK;
    public ImageView aYL;
    public View aYM;
    public HeadImageView aYN;
    public TbImageView aYO;
    private boolean aYP;
    public boolean aYQ;
    public boolean aYR;
    private final int ajD;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aYA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aYB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aYC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aYD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aYE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aYF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.ajD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aYG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aYH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.aYI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.aYP = z;
        this.aYJ = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aYK = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aYL = (ImageView) getView().findViewById(a.g.iv_tail);
        this.aYM = getView().findViewById(a.g.head_layout);
        this.aYN = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.aYO = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.aYN.setIsRound(true);
        this.aYN.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.aYN.setAutoChangeStyle(false);
        if (this.aYP) {
            this.aYK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aYJ.setBackgroundDrawable(null);
            this.aYJ.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bcF;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bcH;
        boolean z4 = aVar.bcI;
        boolean z5 = aVar.bcJ;
        boolean z6 = aVar.bcK;
        if (!this.aYP) {
            this.aYL.setVisibility(8);
            if (z) {
                int i = this.ajD;
                if (this.aYQ) {
                    if (this.aYR) {
                        i = this.aYA + this.aYC + this.aYD;
                        this.aYL.setVisibility(0);
                    }
                    aq(context);
                } else if (z3) {
                    this.aYK.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ar(context);
                } else if (z5) {
                    this.aYK.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aYK.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aYK.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aYK.setPadding(this.ajD, this.aYA, i, this.aYB);
            } else if (z2) {
                int i2 = this.aYF;
                this.aYK.setBackgroundDrawable(null);
                this.aYK.setPadding(this.aYF, 0, i2, 0);
            } else {
                this.aYK.setBackgroundDrawable(null);
                this.aYK.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.aYO.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.aYO.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.aYO.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.aYO.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.aYI;
            if (z2) {
                this.aYO.setVisibility(0);
                i2 = this.aYI;
            } else {
                this.aYO.setVisibility(8);
                i2 = this.aYH;
            }
            this.aYN.getLayoutParams().width = i2;
            this.aYN.getLayoutParams().height = i2;
            this.aYN.stopLoad();
            this.aYN.startLoad(str, 12, false, false);
            this.aYM.setVisibility(0);
            return;
        }
        this.aYM.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.aYP) {
            if (z) {
                this.aYK.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aYK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bL(boolean z) {
        if (z) {
            if (this.aYK != null) {
                this.aYK.setTextSize(0, this.aYG);
                this.aYK.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aYK != null) {
            this.aYK.setTextSize(0, this.aYE);
        }
    }

    private void aq(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aIe);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aIc != 0 || this.aId != 0) {
            gVar.setColors(this.aIa, this.aIb, this.aIc, this.aId);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.O(this.aIa, this.aIb);
        }
        this.aYK.setBackgroundDrawable(gVar);
    }

    private void ar(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aYK.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aIa = 0;
        this.aIb = 0;
        this.aIc = 0;
        this.aId = 0;
        this.aIe = 255;
        this.aYR = false;
    }
}
