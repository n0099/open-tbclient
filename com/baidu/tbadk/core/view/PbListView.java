package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView Tl = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KA = null;
    private View ada = null;
    private String adb = null;
    private LinearLayout adc = null;
    private int mTextColor = 0;
    private int ade = u.d.cp_bg_line_b;
    private ImageView adf = null;
    private LinearLayout adg = null;
    private int adh = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (adi) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jp() {
        this.KA = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_more, (ViewGroup) null);
        this.adc = (LinearLayout) this.KA.findViewById(u.g.pb_more_view);
        this.Tl = (TextView) this.KA.findViewById(u.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.KA.findViewById(u.g.progress);
        this.adf = (ImageView) this.KA.findViewById(u.g.pb_more_view_top_line);
        this.ada = this.KA.findViewById(u.g.empty_view);
        this.adg = (LinearLayout) this.KA.findViewById(u.g.pb_more_top_extra_view);
        return this.KA;
    }

    public void va() {
        this.adf.setVisibility(0);
    }

    public void vb() {
        this.adf.setVisibility(8);
    }

    public void vc() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adf.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.adf.setLayoutParams(layoutParams);
    }

    public void vd() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adf.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds1);
        this.adf.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Tl.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    public LinearLayout ve() {
        return this.adg;
    }

    public void vf() {
        if (this.adg.getVisibility() != 0) {
            this.adg.setVisibility(0);
        }
    }

    public void vg() {
        if (8 != this.adg.getVisibility()) {
            this.adg.setVisibility(8);
        }
    }

    public void vh() {
        this.mProgressBar.setVisibility(0);
        this.Tl.setText(this.mContext.getText(u.j.loading));
        cT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void vi() {
        this.mProgressBar.setVisibility(8);
        if (this.adb != null) {
            this.Tl.setText(this.adb);
        } else {
            this.Tl.setText(this.mContext.getText(u.j.pb_load_more));
        }
        cT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void vj() {
        this.mProgressBar.setVisibility(0);
        this.Tl.setText(this.mContext.getText(u.j.loading));
    }

    public void cR(int i) {
        av.k(this.adc, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adc.getLayoutParams());
        layoutParams.height = i;
        this.adc.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.adb = str;
        this.Tl.setText(str);
        cT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.KA);
        }
    }

    public void cS(int i) {
        this.adh = i;
    }

    public void cT(int i) {
        String charSequence = this.Tl.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(u.j.pb_load_more))) {
            i2 = av.getColor(u.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(u.j.loading))) {
            i2 = av.getColor(u.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(u.j.list_no_more))) {
            i2 = av.getColor(u.d.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Tl.setTextColor(i2);
        }
        av.c(this.adf, this.ade);
        if (this.adh == 0) {
            av.k(this.adc, u.d.cp_bg_line_d);
        } else if (this.adh > 0) {
            av.k(this.adc, this.adh);
        }
    }

    public void cU(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ada.getLayoutParams());
        layoutParams.height = i;
        this.ada.setLayoutParams(layoutParams);
        this.ada.setVisibility(0);
    }

    public void vk() {
        this.ada.setVisibility(8);
    }

    public void vl() {
        this.adg.setVisibility(0);
        this.adf.setVisibility(0);
        this.adc.setVisibility(0);
        this.Tl.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        vk();
    }

    public void cV(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ada.getLayoutParams());
        layoutParams.height = i;
        this.ada.setLayoutParams(layoutParams);
        this.ada.setVisibility(0);
        this.adg.setVisibility(8);
        this.adf.setVisibility(8);
        this.adc.setVisibility(8);
        this.Tl.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
