package com.baidu.live.im;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class c extends TypeAdapter.ViewHolder {
    public int Zf;
    public int Zg;
    public int Zh;
    public int Zi;
    public int Zj;
    public String Zk;
    private ViewGroup amI;
    public TextView amJ;
    public TbImageView amK;
    private boolean amL;
    public boolean amM;
    private static final int amx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int amy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int amz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int amA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int amB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int amC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int amD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int amE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int amF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int Np = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int amG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int amH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.amL = z;
        this.amI = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.amJ = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.amK = (TbImageView) getView().findViewById(a.g.iv_tail);
        this.amK.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.amK.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.amK.setAutoChangeStyle(false);
        if (this.amL) {
            this.amJ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.amI.setBackgroundDrawable(null);
            this.amI.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.amL) {
            this.amK.stopLoad();
            if (!TextUtils.isEmpty(this.Zk)) {
                this.amK.startLoad(this.Zk, 10, false, false);
                this.amK.setVisibility(0);
            } else {
                this.amK.setVisibility(8);
            }
            if (z) {
                this.amJ.setPadding(Np, amx, Np, amy);
                if (this.amM) {
                    aA(context);
                } else if (z3) {
                    this.amJ.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    this.amJ.setBackgroundResource(a.f.ala_im_msg_throne_bg);
                } else {
                    this.amJ.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
            } else if (z2) {
                this.amJ.setBackgroundDrawable(null);
                this.amJ.setPadding(amE, 0, amE, 0);
            } else {
                this.amJ.setBackgroundDrawable(null);
                this.amJ.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.amL) {
            if (z) {
                this.amJ.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.amJ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void aL(boolean z) {
        if (z) {
            if (this.amJ != null) {
                this.amJ.setTextSize(0, amH);
                this.amJ.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.amJ != null) {
            this.amJ.setTextSize(0, amC);
        }
    }

    private void aA(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.Zj);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.Zh != 0 || this.Zi != 0) {
            gVar.i(this.Zf, this.Zg, this.Zh, this.Zi);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.B(this.Zf, this.Zg);
        }
        this.amJ.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.Zf = 0;
        this.Zg = 0;
        this.Zh = 0;
        this.Zi = 0;
        this.Zj = 255;
        this.Zk = "";
    }
}
