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
    public int aHY;
    public int aHZ;
    public int aIa;
    public int aIb;
    public int aIc;
    private final int aYA;
    private final int aYB;
    private final int aYC;
    private final int aYD;
    private final int aYE;
    private final int aYF;
    private final int aYG;
    private ViewGroup aYH;
    public TextView aYI;
    public ImageView aYJ;
    public View aYK;
    public HeadImageView aYL;
    public TbImageView aYM;
    private boolean aYN;
    public boolean aYO;
    public boolean aYP;
    private final int aYy;
    private final int aYz;
    private final int ajB;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aYy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aYz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aYA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aYB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aYC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aYD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.ajB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aYE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aYF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.aYG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.aYN = z;
        this.aYH = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aYI = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aYJ = (ImageView) getView().findViewById(a.g.iv_tail);
        this.aYK = getView().findViewById(a.g.head_layout);
        this.aYL = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.aYM = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.aYL.setIsRound(true);
        this.aYL.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.aYL.setAutoChangeStyle(false);
        if (this.aYN) {
            this.aYI.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aYH.setBackgroundDrawable(null);
            this.aYH.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bcD;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bcF;
        boolean z4 = aVar.bcG;
        boolean z5 = aVar.bcH;
        boolean z6 = aVar.bcI;
        if (!this.aYN) {
            this.aYJ.setVisibility(8);
            if (z) {
                int i = this.ajB;
                if (this.aYO) {
                    if (this.aYP) {
                        i = this.aYy + this.aYA + this.aYB;
                        this.aYJ.setVisibility(0);
                    }
                    aq(context);
                } else if (z3) {
                    this.aYI.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ar(context);
                } else if (z5) {
                    this.aYI.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aYI.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aYI.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aYI.setPadding(this.ajB, this.aYy, i, this.aYz);
            } else if (z2) {
                int i2 = this.aYD;
                this.aYI.setBackgroundDrawable(null);
                this.aYI.setPadding(this.aYD, 0, i2, 0);
            } else {
                this.aYI.setBackgroundDrawable(null);
                this.aYI.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.aYM.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.aYM.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.aYM.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.aYM.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.aYG;
            if (z2) {
                this.aYM.setVisibility(0);
                i2 = this.aYG;
            } else {
                this.aYM.setVisibility(8);
                i2 = this.aYF;
            }
            this.aYL.getLayoutParams().width = i2;
            this.aYL.getLayoutParams().height = i2;
            this.aYL.stopLoad();
            this.aYL.startLoad(str, 12, false, false);
            this.aYK.setVisibility(0);
            return;
        }
        this.aYK.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.aYN) {
            if (z) {
                this.aYI.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aYI.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bL(boolean z) {
        if (z) {
            if (this.aYI != null) {
                this.aYI.setTextSize(0, this.aYE);
                this.aYI.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aYI != null) {
            this.aYI.setTextSize(0, this.aYC);
        }
    }

    private void aq(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aIc);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aIa != 0 || this.aIb != 0) {
            gVar.setColors(this.aHY, this.aHZ, this.aIa, this.aIb);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.O(this.aHY, this.aHZ);
        }
        this.aYI.setBackgroundDrawable(gVar);
    }

    private void ar(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aYI.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aHY = 0;
        this.aHZ = 0;
        this.aIa = 0;
        this.aIb = 0;
        this.aIc = 255;
        this.aYP = false;
    }
}
