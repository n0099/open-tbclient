package com.baidu.live.im;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class c extends TypeAdapter.ViewHolder {
    public int Zt;
    public int Zu;
    public int Zv;
    public int Zw;
    public int Zx;
    public String Zy;
    private ViewGroup anv;
    public TextView anw;
    public TbImageView anx;
    private boolean any;
    public boolean anz;
    private static final int ank = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int anl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int anm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int ann = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int ano = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int anp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int anq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int anr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int ans = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int Nt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int ant = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int anu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.any = z;
        this.anv = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.anw = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.anx = (TbImageView) getView().findViewById(a.g.iv_tail);
        this.anx.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.anx.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.anx.setAutoChangeStyle(false);
        if (this.any) {
            this.anw.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.anv.setBackgroundDrawable(null);
            this.anv.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.any) {
            this.anx.stopLoad();
            if (!TextUtils.isEmpty(this.Zy)) {
                this.anx.startLoad(this.Zy, 10, false, false);
                this.anx.setVisibility(0);
            } else {
                this.anx.setVisibility(8);
            }
            if (z) {
                this.anw.setPadding(Nt, ank, Nt, anl);
                if (this.anz) {
                    aA(context);
                } else if (z3) {
                    this.anw.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    this.anw.setBackgroundResource(a.f.ala_im_msg_throne_bg);
                } else {
                    this.anw.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
            } else if (z2) {
                this.anw.setBackgroundDrawable(null);
                this.anw.setPadding(anr, 0, anr, 0);
            } else {
                this.anw.setBackgroundDrawable(null);
                this.anw.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.any) {
            if (z) {
                this.anw.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.anw.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void aN(boolean z) {
        if (z) {
            if (this.anw != null) {
                this.anw.setTextSize(0, anu);
                this.anw.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.anw != null) {
            this.anw.setTextSize(0, anp);
        }
    }

    private void aA(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.Zx);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.Zv != 0 || this.Zw != 0) {
            gVar.i(this.Zt, this.Zu, this.Zv, this.Zw);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.F(this.Zt, this.Zu);
        }
        this.anw.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.Zt = 0;
        this.Zu = 0;
        this.Zv = 0;
        this.Zw = 0;
        this.Zx = 255;
        this.Zy = "";
    }
}
