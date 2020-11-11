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
    public int aOi;
    public int aOj;
    public int aOk;
    public int aOl;
    public int aOm;
    private final int aku;
    private ViewGroup bhA;
    public TextView bhB;
    public ImageView bhC;
    public View bhD;
    public HeadImageView bhE;
    public TbImageView bhF;
    private boolean bhG;
    public boolean bhH;
    public boolean bhI;
    private final int bhr;
    private final int bhs;
    private final int bht;
    private final int bhu;
    private final int bhv;
    private final int bhw;
    private final int bhx;
    private final int bhy;
    private final int bhz;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.bhr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.bhs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bht = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.bhu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.bhv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.bhw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.aku = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.bhx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.bhy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.bhz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.bhG = z;
        this.bhA = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bhB = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bhC = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bhD = getView().findViewById(a.f.head_layout);
        this.bhE = (HeadImageView) getView().findViewById(a.f.head_imageView);
        this.bhF = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bhE.setIsRound(true);
        this.bhE.setBorderColor(context.getResources().getColor(a.c.sdk_black_alpha10));
        this.bhE.setAutoChangeStyle(false);
        if (this.bhG) {
            this.bhB.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bhA.setBackgroundDrawable(null);
            this.bhA.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.blU;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.blW;
        boolean z4 = aVar.blX;
        boolean z5 = aVar.blY;
        boolean z6 = aVar.blZ;
        if (!this.bhG) {
            this.bhC.setVisibility(8);
            if (z) {
                int i = this.aku;
                if (this.bhH) {
                    if (this.bhI) {
                        i = this.bhr + this.bht + this.bhu;
                        this.bhC.setVisibility(0);
                    }
                    at(context);
                } else if (z3) {
                    this.bhB.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    au(context);
                } else if (z5) {
                    this.bhB.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bhB.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.bhB.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bhB.setPadding(this.aku, this.bhr, i, this.bhs);
            } else if (z2) {
                int i2 = this.bhw;
                this.bhB.setBackgroundDrawable(null);
                this.bhB.setPadding(this.bhw, 0, i2, 0);
            } else {
                this.bhB.setBackgroundDrawable(null);
                this.bhB.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bhF.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bhF.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bhF.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bhF.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.bhz;
            if (z2) {
                this.bhF.setVisibility(0);
                i2 = this.bhz;
            } else {
                this.bhF.setVisibility(8);
                i2 = this.bhy;
            }
            this.bhE.getLayoutParams().width = i2;
            this.bhE.getLayoutParams().height = i2;
            this.bhE.stopLoad();
            this.bhE.startLoad(str, 12, false, false);
            this.bhD.setVisibility(0);
            return;
        }
        this.bhD.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.bhG) {
            if (z) {
                this.bhB.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.bhB.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bT(boolean z) {
        if (z) {
            if (this.bhB != null) {
                this.bhB.setTextSize(0, this.bhx);
                this.bhB.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bhB != null) {
            this.bhB.setTextSize(0, this.bhv);
        }
    }

    private void at(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aOm);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aOk != 0 || this.aOl != 0) {
            fVar.setColors(this.aOi, this.aOj, this.aOk, this.aOl);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.O(this.aOi, this.aOj);
        }
        this.bhB.setBackgroundDrawable(fVar);
    }

    private void au(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bhB.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aOi = 0;
        this.aOj = 0;
        this.aOk = 0;
        this.aOl = 0;
        this.aOm = 255;
        this.bhI = false;
    }
}
