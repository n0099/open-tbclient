package com.baidu.live.im;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c extends TypeAdapter.ViewHolder {
    public FrameLayout aeZ;
    public TextView afa;
    private boolean afb;
    public boolean afc;
    public int alpha;
    public int color;
    private static final int aeP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int aeQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int aeR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aeS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int aeT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int aeU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int Hh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int aeV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int aeW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int If = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int aeX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int aeY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.afb = z;
        this.aeZ = (FrameLayout) getView().findViewById(a.g.ala_msg_root_layout);
        this.afa = (TextView) getView().findViewById(a.g.ala_msg_content);
        if (this.afb) {
            this.afa.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aeZ.setBackgroundDrawable(null);
            this.aeZ.setPadding(0, 0, 0, 0);
        }
    }

    public void b(Context context, boolean z, boolean z2) {
        if (!this.afb) {
            if (z) {
                this.afa.setPadding(If, aeP, If, aeQ);
                if (this.afc) {
                    GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(a.f.ala_im_msg_bubble_bg);
                    gradientDrawable.setColor(this.color);
                    gradientDrawable.setAlpha(this.alpha);
                    this.afa.setBackgroundDrawable(gradientDrawable);
                    return;
                }
                this.afa.setBackgroundResource(a.f.ala_im_msg_normal_bg);
            } else if (z2) {
                this.afa.setBackgroundDrawable(null);
                this.afa.setPadding(aeV, 0, aeV, 0);
            } else {
                this.afa.setBackgroundDrawable(null);
                this.afa.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.afb) {
            if (z) {
                this.afa.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.afa.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void au(boolean z) {
        if (z) {
            if (this.afa != null) {
                this.afa.setTextSize(0, aeY);
                this.afa.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.afa != null) {
            this.afa.setTextSize(0, aeU);
        }
    }
}
