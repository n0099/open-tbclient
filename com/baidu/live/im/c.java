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
    private final int aJC;
    private final int aJD;
    private final int aJE;
    private final int aJF;
    private final int aJG;
    private final int aJH;
    private final int aJI;
    private ViewGroup aJJ;
    public TextView aJK;
    public ImageView aJL;
    private boolean aJM;
    public boolean aJN;
    public boolean aJO;
    private final int agG;
    public int atY;
    public int atZ;
    public int aua;
    public int aub;
    public int auc;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aJC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aJD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aJE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aJF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aJG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aJH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.agG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aJI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aJM = z;
        this.aJJ = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aJK = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aJL = (ImageView) getView().findViewById(a.g.iv_tail);
        if (this.aJM) {
            this.aJK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aJJ.setBackgroundDrawable(null);
            this.aJJ.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.c.a aVar) {
        boolean z = aVar.aNG;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.aNI;
        boolean z4 = aVar.aNJ;
        boolean z5 = aVar.aNK;
        boolean z6 = aVar.aNL;
        if (!this.aJM) {
            this.aJL.setVisibility(8);
            if (z) {
                int i = this.agG;
                if (this.aJN) {
                    if (this.aJO) {
                        i = this.aJC + this.aJE + this.aJF;
                        this.aJL.setVisibility(0);
                    }
                    ac(context);
                } else if (z3) {
                    this.aJK.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ad(context);
                } else if (z5) {
                    this.aJK.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aJK.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aJK.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aJK.setPadding(this.agG, this.aJC, i, this.aJD);
            } else if (z2) {
                int i2 = this.aJH;
                this.aJK.setBackgroundDrawable(null);
                this.aJK.setPadding(this.aJH, 0, i2, 0);
            } else {
                this.aJK.setBackgroundDrawable(null);
                this.aJK.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.aJM) {
            if (z) {
                this.aJK.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aJK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bt(boolean z) {
        if (z) {
            if (this.aJK != null) {
                this.aJK.setTextSize(0, this.aJI);
                this.aJK.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aJK != null) {
            this.aJK.setTextSize(0, this.aJG);
        }
    }

    private void ac(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.auc);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.aua != 0 || this.aub != 0) {
            gVar.setColors(this.atY, this.atZ, this.aua, this.aub);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.F(this.atY, this.atZ);
        }
        this.aJK.setBackgroundDrawable(gVar);
    }

    private void ad(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aJK.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.atY = 0;
        this.atZ = 0;
        this.aua = 0;
        this.aub = 0;
        this.auc = 255;
        this.aJO = false;
    }
}
