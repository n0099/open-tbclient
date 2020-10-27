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
    public int aNf;
    public int aNg;
    public int aNh;
    public int aNi;
    public int aNj;
    private final int aku;
    private final int bfX;
    private final int bfY;
    private final int bfZ;
    private final int bga;
    private final int bgb;
    private final int bgc;
    private final int bgd;
    private final int bge;
    private final int bgf;
    private ViewGroup bgg;
    public TextView bgh;
    public ImageView bgi;
    public View bgj;
    public HeadImageView bgk;
    public TbImageView bgl;
    private boolean bgm;
    public boolean bgn;
    public boolean bgo;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.bfX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.bfY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.bfZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.bga = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.bgb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.bgc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.aku = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.bgd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.bge = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.bgf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.bgm = z;
        this.bgg = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.bgh = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.bgi = (ImageView) getView().findViewById(a.g.iv_tail);
        this.bgj = getView().findViewById(a.g.head_layout);
        this.bgk = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.bgl = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.bgk.setIsRound(true);
        this.bgk.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.bgk.setAutoChangeStyle(false);
        if (this.bgm) {
            this.bgh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bgg.setBackgroundDrawable(null);
            this.bgg.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bkA;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bkC;
        boolean z4 = aVar.bkD;
        boolean z5 = aVar.bkE;
        boolean z6 = aVar.bkF;
        if (!this.bgm) {
            this.bgi.setVisibility(8);
            if (z) {
                int i = this.aku;
                if (this.bgn) {
                    if (this.bgo) {
                        i = this.bfX + this.bfZ + this.bga;
                        this.bgi.setVisibility(0);
                    }
                    at(context);
                } else if (z3) {
                    this.bgh.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    au(context);
                } else if (z5) {
                    this.bgh.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bgh.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.bgh.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.bgh.setPadding(this.aku, this.bfX, i, this.bfY);
            } else if (z2) {
                int i2 = this.bgc;
                this.bgh.setBackgroundDrawable(null);
                this.bgh.setPadding(this.bgc, 0, i2, 0);
            } else {
                this.bgh.setBackgroundDrawable(null);
                this.bgh.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bgl.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bgl.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bgl.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bgl.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.bgf;
            if (z2) {
                this.bgl.setVisibility(0);
                i2 = this.bgf;
            } else {
                this.bgl.setVisibility(8);
                i2 = this.bge;
            }
            this.bgk.getLayoutParams().width = i2;
            this.bgk.getLayoutParams().height = i2;
            this.bgk.stopLoad();
            this.bgk.startLoad(str, 12, false, false);
            this.bgj.setVisibility(0);
            return;
        }
        this.bgj.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.bgm) {
            if (z) {
                this.bgh.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.bgh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bS(boolean z) {
        if (z) {
            if (this.bgh != null) {
                this.bgh.setTextSize(0, this.bgd);
                this.bgh.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bgh != null) {
            this.bgh.setTextSize(0, this.bgb);
        }
    }

    private void at(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aNj);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aNh != 0 || this.aNi != 0) {
            gVar.setColors(this.aNf, this.aNg, this.aNh, this.aNi);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.O(this.aNf, this.aNg);
        }
        this.bgh.setBackgroundDrawable(gVar);
    }

    private void au(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.bgh.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aNf = 0;
        this.aNg = 0;
        this.aNh = 0;
        this.aNi = 0;
        this.aNj = 255;
        this.bgo = false;
    }
}
