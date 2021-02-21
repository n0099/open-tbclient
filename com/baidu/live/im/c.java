package com.baidu.live.im;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.image.loader.interfaces.GenerateImageAddressImpl;
import com.baidu.live.adp.lib.image.loader.interfaces.IGenerateImageAddress;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
/* loaded from: classes11.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aOv;
    public int aOw;
    public int aOx;
    public int aOy;
    public int aOz;
    private final int akY;
    private final int bkb;
    private final int bkc;
    private final int bkd;
    private final int bke;
    private final int bkf;
    private final int bkg;
    private final int bkh;
    private final int bki;
    private final int bkj;
    private ViewGroup bkk;
    public TextView bkl;
    public ImageView bkm;
    public View bkn;
    public SimpleDraweeView bko;
    public TbImageView bkp;
    private boolean bkq;
    public boolean bkr;
    public boolean bks;
    private int bkt;
    private IGenerateImageAddress mGenImgAddress;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.bkb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.bkc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bkd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.bke = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.bkf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.bkg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.akY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.bkh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.bki = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.bkj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.mGenImgAddress = new GenerateImageAddressImpl();
        this.bkq = z;
        this.bkk = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bkl = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bkm = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bkn = getView().findViewById(a.f.head_layout);
        this.bkp = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bko = (SimpleDraweeView) getView().findViewById(a.f.head_imageView);
        com.facebook.drawee.generic.a hierarchy = this.bko.getHierarchy();
        hierarchy.a(a.e.sdk_icon_default_avatar100, p.b.pDW);
        hierarchy.b(a.e.sdk_icon_default_avatar100, p.b.pDW);
        hierarchy.b(p.b.pDW);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.Br(true);
        hierarchy.a(roundingParams);
        if (this.bkq) {
            this.bkl.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bkk.setBackgroundDrawable(null);
            this.bkk.setPadding(0, 0, 0, 0);
        }
    }

    public void dz(int i) {
        this.bkt = i;
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bpO;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bpQ;
        boolean z4 = aVar.bpR;
        boolean z5 = aVar.bpS;
        boolean z6 = aVar.bpT;
        boolean z7 = aVar.isMysteriousMan;
        boolean z8 = aVar.bpV;
        boolean z9 = aVar.isGroup;
        if (!this.bkq) {
            this.bkm.setVisibility(8);
            if (z) {
                int i = this.akY;
                if (this.bkr) {
                    if (this.bks) {
                        i = this.bkb + this.bkd + this.bke;
                        this.bkm.setVisibility(0);
                    }
                    aU(context);
                } else if (z3) {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z7) {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_mysterious_man_bg);
                } else if (z4) {
                    aV(context);
                } else if (z5) {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else if (z8) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(this.bkt);
                    gradientDrawable.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
                    this.bkl.setBackgroundDrawable(gradientDrawable);
                } else if (z9) {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                } else {
                    this.bkl.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bkl.setPadding(this.akY, this.bkb, i, this.bkc);
            } else if (z2) {
                int i2 = this.bkg;
                this.bkl.setBackgroundDrawable(null);
                this.bkl.setPadding(this.bkg, 0, i2, 0);
            } else {
                this.bkl.setBackgroundDrawable(null);
                this.bkl.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        boolean z2;
        int i2;
        boolean z3 = true;
        if (z) {
            if (i == 4) {
                this.bkp.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
                z2 = true;
            } else if (i == 5) {
                this.bkp.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                z2 = true;
            } else if (i == 6) {
                this.bkp.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                z2 = true;
            } else if (i == 7) {
                this.bkp.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = this.bkj;
            if (z2) {
                this.bkp.setVisibility(0);
                i2 = this.bkj;
            } else {
                this.bkp.setVisibility(8);
                i2 = this.bki;
            }
            this.bko.getLayoutParams().width = i2;
            this.bko.getLayoutParams().height = i2;
            Object tag = this.bko.getTag();
            if (tag != null && (tag instanceof String) && TextUtils.equals((String) tag, str)) {
                z3 = false;
            }
            if (z3) {
                this.bko.setImageURI(Uri.parse(this.mGenImgAddress.generateUrl(str, 12)));
                this.bko.setTag(str);
            }
            this.bkn.setVisibility(0);
            return;
        }
        this.bkn.setVisibility(8);
    }

    public void n(Context context, boolean z) {
        if (!this.bkq) {
            if (z) {
                this.bkl.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.bkl.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void ci(boolean z) {
        if (z) {
            if (this.bkl != null) {
                this.bkl.setTextSize(0, this.bkh);
                this.bkl.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bkl != null) {
            this.bkl.setTextSize(0, this.bkf);
        }
    }

    private void aU(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aOz);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aOx != 0 || this.aOy != 0) {
            fVar.setColors(this.aOv, this.aOw, this.aOx, this.aOy);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aOv, this.aOw);
        }
        this.bkl.setBackgroundDrawable(fVar);
    }

    private void aV(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bkl.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aOv = 0;
        this.aOw = 0;
        this.aOx = 0;
        this.aOy = 0;
        this.aOz = 255;
        this.bks = false;
    }
}
