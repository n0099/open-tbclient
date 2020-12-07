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
    public int aPA;
    public int aPw;
    public int aPx;
    public int aPy;
    public int aPz;
    private final int aly;
    private final int bjV;
    private final int bjW;
    private final int bjX;
    private final int bjY;
    private final int bjZ;
    private final int bka;
    private final int bkb;
    private final int bkc;
    private final int bkd;
    private ViewGroup bke;
    public TextView bkf;
    public ImageView bkg;
    public View bkh;
    public HeadImageView bki;
    public TbImageView bkj;
    private boolean bkk;
    public boolean bkl;
    public boolean bkm;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.bjV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.bjW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bjX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.bjY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.bjZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.bka = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.aly = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.bkb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.bkc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.bkd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.bkk = z;
        this.bke = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bkf = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bkg = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bkh = getView().findViewById(a.f.head_layout);
        this.bki = (HeadImageView) getView().findViewById(a.f.head_imageView);
        this.bkj = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bki.setIsRound(true);
        this.bki.setBorderColor(context.getResources().getColor(a.c.sdk_black_alpha10));
        this.bki.setAutoChangeStyle(false);
        if (this.bkk) {
            this.bkf.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bke.setBackgroundDrawable(null);
            this.bke.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bps;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bpu;
        boolean z4 = aVar.bpv;
        boolean z5 = aVar.bpw;
        boolean z6 = aVar.bpx;
        if (!this.bkk) {
            this.bkg.setVisibility(8);
            if (z) {
                int i = this.aly;
                if (this.bkl) {
                    if (this.bkm) {
                        i = this.bjV + this.bjX + this.bjY;
                        this.bkg.setVisibility(0);
                    }
                    aW(context);
                } else if (z3) {
                    this.bkf.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    aX(context);
                } else if (z5) {
                    this.bkf.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bkf.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.bkf.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bkf.setPadding(this.aly, this.bjV, i, this.bjW);
            } else if (z2) {
                int i2 = this.bka;
                this.bkf.setBackgroundDrawable(null);
                this.bkf.setPadding(this.bka, 0, i2, 0);
            } else {
                this.bkf.setBackgroundDrawable(null);
                this.bkf.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bkj.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bkj.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bkj.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bkj.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.bkd;
            if (z2) {
                this.bkj.setVisibility(0);
                i2 = this.bkd;
            } else {
                this.bkj.setVisibility(8);
                i2 = this.bkc;
            }
            this.bki.getLayoutParams().width = i2;
            this.bki.getLayoutParams().height = i2;
            this.bki.stopLoad();
            this.bki.startLoad(str, 12, false, false);
            this.bkh.setVisibility(0);
            return;
        }
        this.bkh.setVisibility(8);
    }

    public void m(Context context, boolean z) {
        if (!this.bkk) {
            if (z) {
                this.bkf.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.bkf.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void ce(boolean z) {
        if (z) {
            if (this.bkf != null) {
                this.bkf.setTextSize(0, this.bkb);
                this.bkf.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bkf != null) {
            this.bkf.setTextSize(0, this.bjZ);
        }
    }

    private void aW(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aPA);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aPy != 0 || this.aPz != 0) {
            fVar.setColors(this.aPw, this.aPx, this.aPy, this.aPz);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aPw, this.aPx);
        }
        this.bkf.setBackgroundDrawable(fVar);
    }

    private void aX(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bkf.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aPw = 0;
        this.aPx = 0;
        this.aPy = 0;
        this.aPz = 0;
        this.aPA = 255;
        this.bkm = false;
    }
}
