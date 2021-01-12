package com.baidu.live.yuyinim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.view.f;
import com.baidu.live.yuyinim.b.b;
/* loaded from: classes10.dex */
public class a extends TypeAdapter.ViewHolder {
    public int aLA;
    public int aLB;
    public int aLC;
    public int aLy;
    public int aLz;
    private final int ali;
    public HeadImageView bWX;
    public LinearLayout bYC;
    public TextView bYD;
    public AlaEmoticonView bYE;
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
    public TbImageView bgY;
    private boolean bgZ;
    public boolean bha;
    public boolean bhb;

    public a(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.g.yuyinala_msg_item_layout, (ViewGroup) null));
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
        this.bgZ = z;
        this.bgT = (ViewGroup) getView().findViewById(a.f.ala_msg_root_layout);
        this.bYC = (LinearLayout) getView().findViewById(a.f.ll_yuyinala_content);
        this.bgU = (TextView) getView().findViewById(a.f.ala_msg_content);
        this.bYD = (TextView) getView().findViewById(a.f.tv_room_name);
        this.bgV = (ImageView) getView().findViewById(a.f.iv_tail);
        this.bgW = getView().findViewById(a.f.head_layout);
        this.bWX = (HeadImageView) getView().findViewById(a.f.head_imageView);
        this.bgY = (TbImageView) getView().findViewById(a.f.headBorder_imageView);
        this.bYE = (AlaEmoticonView) getView().findViewById(a.f.aev_ala_Emoticon);
        this.bWX.setIsRound(true);
        this.bWX.setBorderColor(context.getResources().getColor(a.c.sdk_black_alpha10));
        this.bWX.setAutoChangeStyle(false);
        if (this.bgZ) {
            this.bgU.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bgT.setBackgroundDrawable(null);
            this.bgT.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, b bVar) {
        boolean z = bVar.bmn;
        boolean z2 = bVar.isNormal;
        boolean z3 = bVar.bmq;
        boolean z4 = bVar.bmr;
        boolean z5 = bVar.bms;
        boolean z6 = bVar.bmt;
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
                    this.bYC.setBackgroundResource(a.e.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    aV(context);
                } else if (z5) {
                    this.bYC.setBackgroundResource(a.e.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bYC.setBackgroundResource(a.e.ala_im_msg_goods_tips_bg);
                } else {
                    this.bYC.setBackgroundResource(a.e.ala_im_msg_normal_bg);
                }
                this.bgU.setPadding(this.ali, this.bgK, i, this.bgL);
                this.bYD.setPadding(this.ali, 0, 0, 0);
            } else if (z2) {
                int i2 = this.bgP;
                this.bYC.setBackgroundDrawable(null);
                this.bgU.setPadding(this.bgP, 0, i2, 0);
                this.bYD.setPadding(this.bgP, 0, 0, 0);
            } else {
                this.bYC.setBackgroundDrawable(null);
                this.bgU.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bgY.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
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
            this.bWX.getLayoutParams().width = i2;
            this.bWX.getLayoutParams().height = i2;
            this.bWX.stopLoad();
            this.bWX.startLoad(str, 12, false, false);
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
        f fVar = new f();
        fVar.setAlpha(this.aLC);
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        if (this.aLA != 0 || this.aLB != 0) {
            fVar.setColors(this.aLy, this.aLz, this.aLA, this.aLB);
            fVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            fVar.N(this.aLy, this.aLz);
        }
        this.bYC.setBackgroundDrawable(fVar);
    }

    private void aV(Context context) {
        f fVar = new f();
        fVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.d.sdk_tbds39));
        fVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        fVar.setStrokeWidth(1.0f);
        this.bYC.setBackgroundDrawable(fVar);
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
