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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c extends TypeAdapter.ViewHolder {
    private boolean aPA;
    public boolean aPB;
    public boolean aPC;
    private final int aPl;
    private final int aPm;
    private final int aPn;
    private final int aPo;
    private final int aPp;
    private final int aPq;
    private final int aPr;
    private final int aPs;
    private final int aPt;
    private ViewGroup aPu;
    public TextView aPv;
    public ImageView aPw;
    public View aPx;
    public HeadImageView aPy;
    public TbImageView aPz;
    private final int ahk;
    public int azc;
    public int azd;
    public int aze;
    public int azf;
    public int azg;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aPl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.aPm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.aPn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.aPo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.aPp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.aPq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.ahk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.aPr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.aPs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.aPt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.aPA = z;
        this.aPu = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aPv = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aPw = (ImageView) getView().findViewById(a.g.iv_tail);
        this.aPx = getView().findViewById(a.g.head_layout);
        this.aPy = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.aPz = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.aPy.setIsRound(true);
        this.aPy.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.aPy.setAutoChangeStyle(false);
        if (this.aPA) {
            this.aPv.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aPu.setBackgroundDrawable(null);
            this.aPu.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.c.a aVar) {
        boolean z = aVar.aTM;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.aTO;
        boolean z4 = aVar.aTP;
        boolean z5 = aVar.aTQ;
        boolean z6 = aVar.aTR;
        if (!this.aPA) {
            this.aPw.setVisibility(8);
            if (z) {
                int i = this.ahk;
                if (this.aPB) {
                    if (this.aPC) {
                        i = this.aPl + this.aPn + this.aPo;
                        this.aPw.setVisibility(0);
                    }
                    am(context);
                } else if (z3) {
                    this.aPv.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    an(context);
                } else if (z5) {
                    this.aPv.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.aPv.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.aPv.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.aPv.setPadding(this.ahk, this.aPl, i, this.aPm);
            } else if (z2) {
                int i2 = this.aPq;
                this.aPv.setBackgroundDrawable(null);
                this.aPv.setPadding(this.aPq, 0, i2, 0);
            } else {
                this.aPv.setBackgroundDrawable(null);
                this.aPv.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.aPz.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.aPz.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.aPz.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.aPz.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.aPt;
            if (z2) {
                this.aPz.setVisibility(0);
                i2 = this.aPt;
            } else {
                this.aPz.setVisibility(8);
                i2 = this.aPs;
            }
            this.aPy.getLayoutParams().width = i2;
            this.aPy.getLayoutParams().height = i2;
            this.aPy.stopLoad();
            this.aPy.startLoad(str, 12, false, false);
            this.aPx.setVisibility(0);
            return;
        }
        this.aPx.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.aPA) {
            if (z) {
                this.aPv.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aPv.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bD(boolean z) {
        if (z) {
            if (this.aPv != null) {
                this.aPv.setTextSize(0, this.aPr);
                this.aPv.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aPv != null) {
            this.aPv.setTextSize(0, this.aPp);
        }
    }

    private void am(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.azg);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aze != 0 || this.azf != 0) {
            gVar.setColors(this.azc, this.azd, this.aze, this.azf);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.I(this.azc, this.azd);
        }
        this.aPv.setBackgroundDrawable(gVar);
    }

    private void an(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.aPv.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.azc = 0;
        this.azd = 0;
        this.aze = 0;
        this.azf = 0;
        this.azg = 255;
        this.aPC = false;
    }
}
