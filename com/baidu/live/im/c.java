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
/* loaded from: classes11.dex */
public class c extends TypeAdapter.ViewHolder {
    public int aQl;
    public int aQm;
    public int aQn;
    public int aQo;
    public int aQp;
    private final int ama;
    private final int blA;
    private final int blB;
    private final int blC;
    private final int blD;
    private final int blE;
    private final int blF;
    private final int blG;
    private final int blH;
    private ViewGroup blI;
    public TextView blJ;
    public ImageView blK;
    public View blL;
    public SimpleDraweeView blM;
    public TbImageView blN;
    private boolean blO;
    public boolean blP;
    public boolean blQ;
    private final int blz;
    private IGenerateImageAddress mGenImgAddress;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.ala_msg_item_layout, (ViewGroup) null));
        this.blz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds4);
        this.blA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.blB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.blC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds36);
        this.blD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds26);
        this.blE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        this.ama = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        this.blF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds48);
        this.blG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds56);
        this.blH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds45);
        this.mGenImgAddress = new GenerateImageAddressImpl();
        this.blO = z;
        this.blI = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.blJ = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.blK = (ImageView) getView().findViewById(a.f.iv_tail);
        this.blL = getView().findViewById(a.f.head_layout);
        this.blN = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.blM = (SimpleDraweeView) getView().findViewById(a.f.head_imageView);
        com.facebook.drawee.generic.a hierarchy = this.blM.getHierarchy();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            hierarchy.a(a.e.sdk_icon_default_avatar100_hk, p.b.pxH);
            hierarchy.b(a.e.sdk_icon_default_avatar100_hk, p.b.pxH);
        } else {
            hierarchy.a(a.e.sdk_icon_default_avatar100, p.b.pxH);
            hierarchy.b(a.e.sdk_icon_default_avatar100, p.b.pxH);
        }
        hierarchy.b(p.b.pxH);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.Bc(true);
        hierarchy.a(roundingParams);
        if (this.blO) {
            this.blJ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.blI.setBackgroundDrawable(null);
            this.blI.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bra;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.brc;
        boolean z4 = aVar.brd;
        boolean z5 = aVar.bre;
        boolean z6 = aVar.brf;
        boolean z7 = aVar.isMysteriousMan;
        if (!this.blO) {
            this.blK.setVisibility(8);
            if (z) {
                int i = this.ama;
                if (this.blP) {
                    if (this.blQ) {
                        i = this.blz + this.blB + this.blC;
                        this.blK.setVisibility(0);
                    }
                    aV(context);
                } else if (z3) {
                    this.blJ.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z7) {
                    this.blJ.setBackgroundResource(a.e.ala_im_msg_mysterious_man_bg);
                } else if (z4) {
                    aW(context);
                } else if (z5) {
                    this.blJ.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.blJ.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.blJ.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.blJ.setPadding(this.ama, this.blz, i, this.blA);
            } else if (z2) {
                int i2 = this.blE;
                this.blJ.setBackgroundDrawable(null);
                this.blJ.setPadding(this.blE, 0, i2, 0);
            } else {
                this.blJ.setBackgroundDrawable(null);
                this.blJ.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        boolean z2;
        int i2;
        boolean z3 = true;
        if (z) {
            if (i == 4) {
                this.blN.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
                z2 = true;
            } else if (i == 5) {
                this.blN.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                z2 = true;
            } else if (i == 6) {
                this.blN.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                z2 = true;
            } else if (i == 7) {
                this.blN.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = this.blH;
            if (z2) {
                this.blN.setVisibility(0);
                i2 = this.blH;
            } else {
                this.blN.setVisibility(8);
                i2 = this.blG;
            }
            this.blM.getLayoutParams().width = i2;
            this.blM.getLayoutParams().height = i2;
            Object tag = this.blM.getTag();
            if (tag != null && (tag instanceof String) && TextUtils.equals((String) tag, str)) {
                z3 = false;
            }
            if (z3) {
                this.blM.setImageURI(Uri.parse(this.mGenImgAddress.generateUrl(str, 12)));
                this.blM.setTag(str);
            }
            this.blL.setVisibility(0);
            return;
        }
        this.blL.setVisibility(8);
    }

    public void m(Context context, boolean z) {
        if (!this.blO) {
            if (z) {
                this.blJ.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.c.sdk_black_alpha30));
            } else {
                this.blJ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void ce(boolean z) {
        if (z) {
            if (this.blJ != null) {
                this.blJ.setTextSize(0, this.blF);
                this.blJ.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.blJ != null) {
            this.blJ.setTextSize(0, this.blD);
        }
    }

    private void aV(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setAlpha(this.aQp);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aQn != 0 || this.aQo != 0) {
            fVar.setColors(this.aQl, this.aQm, this.aQn, this.aQo);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aQl, this.aQm);
        }
        this.blJ.setBackgroundDrawable(fVar);
    }

    private void aW(Context context) {
        com.baidu.live.view.f fVar = new com.baidu.live.view.f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.blJ.setBackgroundDrawable(fVar);
    }

    public void reset() {
        this.aQl = 0;
        this.aQm = 0;
        this.aQn = 0;
        this.aQo = 0;
        this.aQp = 255;
        this.blQ = false;
    }
}
