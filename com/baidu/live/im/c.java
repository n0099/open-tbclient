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
/* loaded from: classes10.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aPV;
    public int aPW;
    public int aPX;
    public int aPY;
    public int aPZ;
    private final int amr;
    private final int blB;
    private final int blC;
    private final int blD;
    private final int blE;
    private final int blF;
    private final int blG;
    private final int blH;
    private final int blI;
    private final int blJ;
    private ViewGroup blK;
    public TextView blL;
    public ImageView blM;
    public View blN;
    public SimpleDraweeView blO;
    public TbImageView blP;
    private boolean blQ;
    public boolean blR;
    public boolean blS;
    private int blT;
    private IGenerateImageAddress mGenImgAddress;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.blB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.blC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.blD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.blE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.blF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.blG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.amr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.blH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.blI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.blJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.mGenImgAddress = new GenerateImageAddressImpl();
        this.blQ = z;
        this.blK = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.blL = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.blM = (ImageView) getView().findViewById(a.f.iv_tail);
        this.blN = getView().findViewById(a.f.head_layout);
        this.blP = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.blO = (SimpleDraweeView) getView().findViewById(a.f.head_imageView);
        com.facebook.drawee.generic.a hierarchy = this.blO.getHierarchy();
        hierarchy.a(a.e.sdk_icon_default_avatar100, p.b.pGb);
        hierarchy.b(a.e.sdk_icon_default_avatar100, p.b.pGb);
        hierarchy.b(p.b.pGb);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.Bp(true);
        hierarchy.a(roundingParams);
        if (this.blQ) {
            this.blL.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.blK.setBackgroundDrawable(null);
            this.blK.setPadding(0, 0, 0, 0);
        }
    }

    public void dA(int i) {
        this.blT = i;
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bro;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.brq;
        boolean z4 = aVar.brr;
        boolean z5 = aVar.brs;
        boolean z6 = aVar.brt;
        boolean z7 = aVar.isMysteriousMan;
        boolean z8 = aVar.brv;
        boolean z9 = aVar.isGroup;
        if (!this.blQ) {
            this.blM.setVisibility(8);
            if (z) {
                int i = this.amr;
                if (this.blR) {
                    if (this.blS) {
                        i = this.blB + this.blD + this.blE;
                        this.blM.setVisibility(0);
                    }
                    aT(context);
                } else if (z3) {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z7) {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_mysterious_man_bg);
                } else if (z4) {
                    aU(context);
                } else if (z5) {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else if (z8) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(this.blT);
                    gradientDrawable.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
                    this.blL.setBackgroundDrawable(gradientDrawable);
                } else if (z9) {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                } else {
                    this.blL.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.blL.setPadding(this.amr, this.blB, i, this.blC);
            } else if (z2) {
                int i2 = this.blG;
                this.blL.setBackgroundDrawable(null);
                this.blL.setPadding(this.blG, 0, i2, 0);
            } else {
                this.blL.setBackgroundDrawable(null);
                this.blL.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        boolean z2;
        int i2;
        boolean z3 = true;
        if (z) {
            if (i == 4) {
                this.blP.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
                z2 = true;
            } else if (i == 5) {
                this.blP.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                z2 = true;
            } else if (i == 6) {
                this.blP.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                z2 = true;
            } else if (i == 7) {
                this.blP.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = this.blJ;
            if (z2) {
                this.blP.setVisibility(0);
                i2 = this.blJ;
            } else {
                this.blP.setVisibility(8);
                i2 = this.blI;
            }
            this.blO.getLayoutParams().width = i2;
            this.blO.getLayoutParams().height = i2;
            Object tag = this.blO.getTag();
            if (tag != null && (tag instanceof String) && TextUtils.equals((String) tag, str)) {
                z3 = false;
            }
            if (z3) {
                this.blO.setImageURI(Uri.parse(this.mGenImgAddress.generateUrl(str, 12)));
                this.blO.setTag(str);
            }
            this.blN.setVisibility(0);
            return;
        }
        this.blN.setVisibility(8);
    }

    public void n(Context context, boolean z) {
        if (!this.blQ) {
            if (z) {
                this.blL.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.blL.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void ci(boolean z) {
        if (z) {
            if (this.blL != null) {
                this.blL.setTextSize(0, this.blH);
                this.blL.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.blL != null) {
            this.blL.setTextSize(0, this.blF);
        }
    }

    private void aT(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aPZ);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aPX != 0 || this.aPY != 0) {
            fVar.setColors(this.aPV, this.aPW, this.aPX, this.aPY);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aPV, this.aPW);
        }
        this.blL.setBackgroundDrawable(fVar);
    }

    private void aU(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.blL.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aPV = 0;
        this.aPW = 0;
        this.aPX = 0;
        this.aPY = 0;
        this.aPZ = 255;
        this.blS = false;
    }
}
