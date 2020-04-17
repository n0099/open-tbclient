package com.baidu.live.im;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c extends TypeAdapter.ViewHolder {
    private final int aJA;
    private final int aJB;
    private final int aJC;
    private ViewGroup aJD;
    public TextView aJE;
    public ImageView aJF;
    private boolean aJG;
    public boolean aJH;
    public boolean aJI;
    private final int aJw;
    private final int aJx;
    private final int aJy;
    private final int aJz;
    private final int agD;
    public int atS;
    public int atT;
    public int atU;
    public int atV;
    public int atW;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aJw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aJx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aJy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aJz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aJA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aJB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.agD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aJC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aJG = z;
        this.aJD = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aJE = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aJF = (ImageView) getView().findViewById(a.g.iv_tail);
        if (this.aJG) {
            this.aJE.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aJD.setBackgroundDrawable(null);
            this.aJD.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.c.a aVar) {
        boolean z = aVar.aNA;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.aNC;
        boolean z4 = aVar.aND;
        boolean z5 = aVar.aNE;
        boolean z6 = aVar.aNF;
        if (!this.aJG) {
            this.aJF.setVisibility(8);
            if (z) {
                int i = this.agD;
                if (this.aJH) {
                    if (this.aJI) {
                        i = this.aJw + this.aJy + this.aJz;
                        this.aJF.setVisibility(0);
                    }
                    ao(context);
                } else if (z3) {
                    this.aJE.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ap(context);
                } else if (z5) {
                    this.aJE.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aJE.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aJE.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aJE.setPadding(this.agD, this.aJw, i, this.aJx);
            } else if (z2) {
                int i2 = this.aJB;
                this.aJE.setBackgroundDrawable(null);
                this.aJE.setPadding(this.aJB, 0, i2, 0);
            } else {
                this.aJE.setBackgroundDrawable(null);
                this.aJE.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.aJG) {
            if (z) {
                this.aJE.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aJE.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bt(boolean z) {
        if (z) {
            if (this.aJE != null) {
                this.aJE.setTextSize(0, this.aJC);
                this.aJE.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aJE != null) {
            this.aJE.setTextSize(0, this.aJA);
        }
    }

    private void ao(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.atW);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.atU != 0 || this.atV != 0) {
            gVar.setColors(this.atS, this.atT, this.atU, this.atV);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.F(this.atS, this.atT);
        }
        this.aJE.setBackgroundDrawable(gVar);
    }

    private void ap(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aJE.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.atS = 0;
        this.atT = 0;
        this.atU = 0;
        this.atV = 0;
        this.atW = 255;
        this.aJI = false;
    }
}
