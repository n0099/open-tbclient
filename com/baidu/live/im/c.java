package com.baidu.live.im;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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
/* loaded from: classes10.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aLA;
    public int aLB;
    public int aLC;
    public int aLy;
    public int aLz;
    private final int ali;
    private final int bgK;
    private final int bgL;
    private final int bgM;
    private final int bgN;
    private final int bgO;
    private final int bgP;
    private final int bgQ;
    private final int bgR;
    private final int bgS;
    private ViewGroup bgT;
    public TextView bgU;
    public ImageView bgV;
    public View bgW;
    public SimpleDraweeView bgX;
    public TbImageView bgY;
    private boolean bgZ;
    public boolean bha;
    public boolean bhb;
    private IGenerateImageAddress mGenImgAddress;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.bgK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.bgL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bgM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.bgN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.bgO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.bgP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.ali = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.bgQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.bgR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.bgS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.mGenImgAddress = new GenerateImageAddressImpl();
        this.bgZ = z;
        this.bgT = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bgU = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bgV = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bgW = getView().findViewById(a.f.head_layout);
        this.bgY = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bgX = (SimpleDraweeView) getView().findViewById(a.f.head_imageView);
        com.facebook.drawee.generic.a hierarchy = this.bgX.getHierarchy();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            hierarchy.a(a.e.sdk_icon_default_avatar100_hk, p.b.ptm);
            hierarchy.b(a.e.sdk_icon_default_avatar100_hk, p.b.ptm);
        } else {
            hierarchy.a(a.e.sdk_icon_default_avatar100, p.b.ptm);
            hierarchy.b(a.e.sdk_icon_default_avatar100, p.b.ptm);
        }
        hierarchy.b(p.b.ptm);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.AY(true);
        hierarchy.a(roundingParams);
        if (this.bgZ) {
            this.bgU.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bgT.setBackgroundDrawable(null);
            this.bgT.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bmn;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bmq;
        boolean z4 = aVar.bmr;
        boolean z5 = aVar.bms;
        boolean z6 = aVar.bmt;
        boolean z7 = aVar.isMysteriousMan;
        if (!this.bgZ) {
            this.bgV.setVisibility(8);
            if (z) {
                int i = this.ali;
                if (this.bha) {
                    if (this.bhb) {
                        i = this.bgK + this.bgM + this.bgN;
                        this.bgV.setVisibility(0);
                    }
                    aU(context);
                } else if (z3) {
                    this.bgU.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z7) {
                    this.bgU.setBackgroundResource(a.e.ala_im_msg_mysterious_man_bg);
                } else if (z4) {
                    aV(context);
                } else if (z5) {
                    this.bgU.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bgU.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.bgU.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bgU.setPadding(this.ali, this.bgK, i, this.bgL);
            } else if (z2) {
                int i2 = this.bgP;
                this.bgU.setBackgroundDrawable(null);
                this.bgU.setPadding(this.bgP, 0, i2, 0);
            } else {
                this.bgU.setBackgroundDrawable(null);
                this.bgU.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        boolean z2;
        int i2;
        boolean z3 = true;
        if (z) {
            if (i == 4) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
                z2 = true;
            } else if (i == 5) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                z2 = true;
            } else if (i == 6) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                z2 = true;
            } else if (i == 7) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = this.bgS;
            if (z2) {
                this.bgY.setVisibility(0);
                i2 = this.bgS;
            } else {
                this.bgY.setVisibility(8);
                i2 = this.bgR;
            }
            this.bgX.getLayoutParams().width = i2;
            this.bgX.getLayoutParams().height = i2;
            Object tag = this.bgX.getTag();
            if (tag != null && (tag instanceof String) && TextUtils.equals((String) tag, str)) {
                z3 = false;
            }
            if (z3) {
                this.bgX.setImageURI(Uri.parse(this.mGenImgAddress.generateUrl(str, 12)));
                this.bgX.setTag(str);
            }
            this.bgW.setVisibility(0);
            return;
        }
        this.bgW.setVisibility(8);
    }

    public void m(Context context, boolean z) {
        if (!this.bgZ) {
            if (z) {
                this.bgU.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.bgU.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void ca(boolean z) {
        if (z) {
            if (this.bgU != null) {
                this.bgU.setTextSize(0, this.bgQ);
                this.bgU.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bgU != null) {
            this.bgU.setTextSize(0, this.bgO);
        }
    }

    private void aU(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aLC);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aLA != 0 || this.aLB != 0) {
            fVar.setColors(this.aLy, this.aLz, this.aLA, this.aLB);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aLy, this.aLz);
        }
        this.bgU.setBackgroundDrawable(fVar);
    }

    private void aV(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bgU.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aLy = 0;
        this.aLz = 0;
        this.aLA = 0;
        this.aLB = 0;
        this.aLC = 255;
        this.bhb = false;
    }
}
