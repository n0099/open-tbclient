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
    public FrameLayout aeH;
    public TextView aeI;
    private boolean aeJ;
    public boolean aeK;
    public int alpha;
    public int color;
    private static final int aex = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int aey = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int aez = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aeA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int aeB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int aeC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int GF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int aeD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int aeE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int HE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int aeF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int aeG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.aeJ = z;
        this.aeH = (FrameLayout) getView().findViewById(a.g.ala_msg_root_layout);
        this.aeI = (TextView) getView().findViewById(a.g.ala_msg_content);
        if (this.aeJ) {
            this.aeI.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aeH.setBackgroundDrawable(null);
            this.aeH.setPadding(0, 0, 0, 0);
        }
    }

    public void b(Context context, boolean z, boolean z2) {
        if (!this.aeJ) {
            if (z) {
                this.aeI.setPadding(HE, aex, HE, aey);
                if (this.aeK) {
                    GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(a.f.ala_im_msg_bubble_bg);
                    gradientDrawable.setColor(this.color);
                    gradientDrawable.setAlpha(this.alpha);
                    this.aeI.setBackgroundDrawable(gradientDrawable);
                    return;
                }
                this.aeI.setBackgroundResource(a.f.ala_im_msg_normal_bg);
            } else if (z2) {
                this.aeI.setBackgroundDrawable(null);
                this.aeI.setPadding(aeD, 0, aeD, 0);
            } else {
                this.aeI.setBackgroundDrawable(null);
                this.aeI.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.aeJ) {
            if (z) {
                this.aeI.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aeI.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void au(boolean z) {
        if (z) {
            if (this.aeI != null) {
                this.aeI.setTextSize(0, aeG);
                this.aeI.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aeI != null) {
            this.aeI.setTextSize(0, aeC);
        }
    }
}
