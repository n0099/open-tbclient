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
    public int aJv;
    public int aJw;
    public int aJx;
    public int aJy;
    public int aJz;
    private final int akb;
    private final int baX;
    private final int baY;
    private final int baZ;
    private final int bba;
    private final int bbb;
    private final int bbc;
    private final int bbd;
    private final int bbe;
    private final int bbf;
    private ViewGroup bbg;
    public TextView bbh;
    public ImageView bbi;
    public View bbj;
    public HeadImageView bbk;
    public TbImageView bbl;
    private boolean bbm;
    public boolean bbn;
    public boolean bbo;

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.baX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        this.baY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
        this.baZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.bba = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds36);
        this.bbb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
        this.bbc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        this.akb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        this.bbd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);
        this.bbe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        this.bbf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds45);
        this.bbm = z;
        this.bbg = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.bbh = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.bbi = (ImageView) getView().findViewById(a.g.iv_tail);
        this.bbj = getView().findViewById(a.g.head_layout);
        this.bbk = (HeadImageView) getView().findViewById(a.g.head_imageView);
        this.bbl = (TbImageView) getView().findViewById(a.g.headBorder_imageView);
        this.bbk.setIsRound(true);
        this.bbk.setBorderColor(context.getResources().getColor(a.d.sdk_black_alpha10));
        this.bbk.setAutoChangeStyle(false);
        if (this.bbm) {
            this.bbh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.bbg.setBackgroundDrawable(null);
            this.bbg.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, com.baidu.live.im.e.a aVar) {
        boolean z = aVar.bfu;
        boolean z2 = aVar.isNormal;
        boolean z3 = aVar.bfw;
        boolean z4 = aVar.bfx;
        boolean z5 = aVar.bfy;
        boolean z6 = aVar.bfz;
        if (!this.bbm) {
            this.bbi.setVisibility(8);
            if (z) {
                int i = this.akb;
                if (this.bbn) {
                    if (this.bbo) {
                        i = this.baX + this.baZ + this.bba;
                        this.bbi.setVisibility(0);
                    }
                    aq(context);
                } else if (z3) {
                    this.bbh.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    ar(context);
                } else if (z5) {
                    this.bbh.setBackgroundResource(a.f.ala_im_msg_guardclub_join_bg);
                } else if (z6) {
                    this.bbh.setBackgroundResource(a.f.ala_im_msg_goods_tips_bg);
                } else {
                    this.bbh.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
                this.bbh.setPadding(this.akb, this.baX, i, this.baY);
            } else if (z2) {
                int i2 = this.bbc;
                this.bbh.setBackgroundDrawable(null);
                this.bbh.setPadding(this.bbc, 0, i2, 0);
            } else {
                this.bbh.setBackgroundDrawable(null);
                this.bbh.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        int i2;
        boolean z2 = true;
        if (z) {
            if (i == 4) {
                this.bbl.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
            } else if (i == 5) {
                this.bbl.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
            } else if (i == 6) {
                this.bbl.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
            } else if (i == 7) {
                this.bbl.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
            } else {
                z2 = false;
            }
            int i3 = this.bbf;
            if (z2) {
                this.bbl.setVisibility(0);
                i2 = this.bbf;
            } else {
                this.bbl.setVisibility(8);
                i2 = this.bbe;
            }
            this.bbk.getLayoutParams().width = i2;
            this.bbk.getLayoutParams().height = i2;
            this.bbk.stopLoad();
            this.bbk.startLoad(str, 12, false, false);
            this.bbj.setVisibility(0);
            return;
        }
        this.bbj.setVisibility(8);
    }

    public void i(Context context, boolean z) {
        if (!this.bbm) {
            if (z) {
                this.bbh.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.bbh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void bN(boolean z) {
        if (z) {
            if (this.bbh != null) {
                this.bbh.setTextSize(0, this.bbd);
                this.bbh.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.bbh != null) {
            this.bbh.setTextSize(0, this.bbb);
        }
    }

    private void aq(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.aJz);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        if (this.aJx != 0 || this.aJy != 0) {
            gVar.setColors(this.aJv, this.aJw, this.aJx, this.aJy);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.O(this.aJv, this.aJw);
        }
        this.bbh.setBackgroundDrawable(gVar);
    }

    private void ar(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds39));
        gVar.setColors(Color.parseColor("#66d87100"), Color.parseColor("#66ecb721"), Color.parseColor("#ffac51"), Color.parseColor("#ffdb76"));
        gVar.setStrokeWidth(1.0f);
        this.bbh.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aJv = 0;
        this.aJw = 0;
        this.aJx = 0;
        this.aJy = 0;
        this.aJz = 255;
        this.bbo = false;
    }
}
