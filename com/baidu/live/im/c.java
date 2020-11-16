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
    public int aMx;
    public int aMy;
    public int aMz;
    private final int akx;
    private final int bfF;
    private final int bfG;
    private final int bfH;
    private final int bfI;
    private final int bfJ;
    private final int bfK;
    private final int bfL;
    private final int bfM;
    private final int bfN;
    private ViewGroup bfO;
    public TextView bfP;
    public ImageView bfQ;
    public View bfR;
    public HeadImageView bfS;
    public TbImageView bfT;
    private boolean bfU;
    public boolean bfV;
    public boolean bfW;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.bfF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.bfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bfH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.bfI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.bfJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.bfK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.akx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.bfL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.bfM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.bfN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.bfU = z;
        this.bfO = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bfP = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bfQ = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bfR = getView().findViewById(a.f.head_layout);
        this.bfS = (HeadImageView) getView().findViewById(a.f.head_imageView);
        this.bfT = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bfS.setIsRound(true);
        this.bfS.setBorderColor(context.getResources().getColor(a.c.sdk_black_alpha10));
        this.bfS.setAutoChangeStyle(false);
        if (this.bfU) {
            this.bfP.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bfO.setBackgroundDrawable(null);
            this.bfO.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bkj;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bkl;
        boolean z4 = aVar.bkm;
        boolean z5 = aVar.bkn;
        boolean z6 = aVar.bko;
        if (!this.bfU) {
            this.bfQ.setVisibility(8);
            if (z) {
                int i = this.akx;
                if (this.bfV) {
                    if (this.bfW) {
                        i = this.bfF + this.bfH + this.bfI;
                        this.bfQ.setVisibility(0);
                    }
                    at(context);
                } else if (z3) {
                    this.bfP.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    au(context);
                } else if (z5) {
                    this.bfP.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bfP.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.bfP.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bfP.setPadding(this.akx, this.bfF, i, this.bfG);
            } else if (z2) {
                int i2 = this.bfK;
                this.bfP.setBackgroundDrawable(null);
                this.bfP.setPadding(this.bfK, 0, i2, 0);
            } else {
                this.bfP.setBackgroundDrawable(null);
                this.bfP.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bfT.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bfT.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bfT.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bfT.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.bfN;
            if (z2) {
                this.bfT.setVisibility(0);
                i2 = this.bfN;
            } else {
                this.bfT.setVisibility(8);
                i2 = this.bfM;
            }
            this.bfS.getLayoutParams().width = i2;
            this.bfS.getLayoutParams().height = i2;
            this.bfS.stopLoad();
            this.bfS.startLoad(str, 12, false, false);
            this.bfR.setVisibility(0);
            return;
        }
        this.bfR.setVisibility(8);
    }

    public void h(Context context, boolean z) {
        if (!this.bfU) {
            if (z) {
                this.bfP.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.bfP.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bV(boolean z) {
        if (z) {
            if (this.bfP != null) {
                this.bfP.setTextSize(0, this.bfL);
                this.bfP.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bfP != null) {
            this.bfP.setTextSize(0, this.bfJ);
        }
    }

    private void at(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aMB);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aMz != 0 || this.aMA != 0) {
            fVar.setColors(this.aMx, this.aMy, this.aMz, this.aMA);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.O(this.aMx, this.aMy);
        }
        this.bfP.setBackgroundDrawable(fVar);
    }

    private void au(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bfP.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aMx = 0;
        this.aMy = 0;
        this.aMz = 0;
        this.aMA = 0;
        this.aMB = 255;
        this.bfW = false;
    }
}
