package com.baidu.live.im;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c extends TypeAdapter.ViewHolder {
    public int abn;
    public int abo;
    public int abp;
    public int abq;
    public int abr;
    public String abt;
    private ViewGroup aqO;
    public TextView aqP;
    public TbImageView aqQ;
    private boolean aqR;
    public boolean aqS;
    private static final int aqD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int aqE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int aqF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aqG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int aqH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int aqI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int aqJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int aqK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int aqL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int NV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int aqM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int aqN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aqR = z;
        this.aqO = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aqP = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.aqQ = (TbImageView) getView().findViewById(a.g.iv_tail);
        this.aqQ.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.aqQ.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.aqQ.setAutoChangeStyle(false);
        if (this.aqR) {
            this.aqP.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aqO.setBackgroundDrawable(null);
            this.aqO.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.aqR) {
            this.aqQ.stopLoad();
            if (!TextUtils.isEmpty(this.abt)) {
                this.aqQ.startLoad(this.abt, 10, false, false);
                this.aqQ.setVisibility(0);
            } else {
                this.aqQ.setVisibility(8);
            }
            if (z) {
                this.aqP.setPadding(NV, aqD, NV, aqE);
                if (this.aqS) {
                    aD(context);
                } else if (z3) {
                    this.aqP.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    this.aqP.setBackgroundResource(a.f.ala_im_msg_throne_bg);
                } else {
                    this.aqP.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
            } else if (z2) {
                this.aqP.setBackgroundDrawable(null);
                this.aqP.setPadding(aqK, 0, aqK, 0);
            } else {
                this.aqP.setBackgroundDrawable(null);
                this.aqP.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.aqR) {
            if (z) {
                this.aqP.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aqP.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void aQ(boolean z) {
        if (z) {
            if (this.aqP != null) {
                this.aqP.setTextSize(0, aqN);
                this.aqP.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aqP != null) {
            this.aqP.setTextSize(0, aqI);
        }
    }

    private void aD(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.abr);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.abp != 0 || this.abq != 0) {
            gVar.i(this.abn, this.abo, this.abp, this.abq);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.G(this.abn, this.abo);
        }
        this.aqP.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.abn = 0;
        this.abo = 0;
        this.abp = 0;
        this.abq = 0;
        this.abr = 255;
        this.abt = "";
    }
}
