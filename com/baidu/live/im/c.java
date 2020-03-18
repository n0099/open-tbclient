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
    public int abA;
    public int abB;
    public int abC;
    public String abD;
    public int aby;
    public int abz;
    private ViewGroup aqY;
    public TextView aqZ;
    public TbImageView ara;
    private boolean arb;
    public boolean arc;
    private static final int aqN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds4);
    private static final int aqO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds6);
    private static final int aqP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aqQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int aqR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds12);
    private static final int aqS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds26);
    private static final int aqT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds6);
    private static final int aqU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds10);
    private static final int aqV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds18);
    private static final int NW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
    private static final int aqW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds34);
    private static final int aqX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds48);

    public c(Context context, boolean z) {
        super(LayoutInflater.from(context).inflate(a.h.ala_msg_item_layout, (ViewGroup) null));
        this.arb = z;
        this.aqY = (ViewGroup) getView().findViewById(a.g.ala_msg_root_layout);
        this.aqZ = (TextView) getView().findViewById(a.g.ala_msg_content);
        this.ara = (TbImageView) getView().findViewById(a.g.iv_tail);
        this.ara.setDefaultBgResource(a.f.sdk_shape_transparent);
        this.ara.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.ara.setAutoChangeStyle(false);
        if (this.arb) {
            this.aqZ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.aqY.setBackgroundDrawable(null);
            this.aqY.setPadding(0, 0, 0, 0);
        }
    }

    public void a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.arb) {
            this.ara.stopLoad();
            if (!TextUtils.isEmpty(this.abD)) {
                this.ara.startLoad(this.abD, 10, false, false);
                this.ara.setVisibility(0);
            } else {
                this.ara.setVisibility(8);
            }
            if (z) {
                this.aqZ.setPadding(NW, aqN, NW, aqO);
                if (this.arc) {
                    aC(context);
                } else if (z3) {
                    this.aqZ.setBackgroundResource(a.f.ala_im_msg_redpacket_bg);
                } else if (z4) {
                    this.aqZ.setBackgroundResource(a.f.ala_im_msg_throne_bg);
                } else {
                    this.aqZ.setBackgroundResource(a.f.ala_im_msg_normal_bg);
                }
            } else if (z2) {
                this.aqZ.setBackgroundDrawable(null);
                this.aqZ.setPadding(aqU, 0, aqU, 0);
            } else {
                this.aqZ.setBackgroundDrawable(null);
                this.aqZ.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void g(Context context, boolean z) {
        if (!this.arb) {
            if (z) {
                this.aqZ.setShadowLayer(1.0f, 2.0f, 2.0f, context.getResources().getColor(a.d.sdk_black_alpha30));
            } else {
                this.aqZ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void aQ(boolean z) {
        if (z) {
            if (this.aqZ != null) {
                this.aqZ.setTextSize(0, aqX);
                this.aqZ.setTypeface(Typeface.defaultFromStyle(1));
            }
        } else if (this.aqZ != null) {
            this.aqZ.setTextSize(0, aqS);
        }
    }

    private void aC(Context context) {
        com.baidu.live.view.g gVar = new com.baidu.live.view.g();
        gVar.setAlpha(this.abC);
        gVar.setCornerRadius(context.getResources().getDimensionPixelOffset(a.e.sdk_tbds36));
        if (this.abA != 0 || this.abB != 0) {
            gVar.i(this.aby, this.abz, this.abA, this.abB);
            gVar.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        } else {
            gVar.G(this.aby, this.abz);
        }
        this.aqZ.setBackgroundDrawable(gVar);
    }

    public void reset() {
        this.aby = 0;
        this.abz = 0;
        this.abA = 0;
        this.abB = 0;
        this.abC = 255;
        this.abD = "";
    }
}
