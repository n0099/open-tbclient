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
    private TextView SD = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KB = null;
    private View acq = null;
    private String acr = null;
    private LinearLayout acs = null;
    private int mTextColor = 0;
    private int act = u.d.cp_bg_line_b;
    private ImageView acu = null;
    private LinearLayout acv = null;
    private int acw = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (acx) with 'values()' method */
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
    public View jq() {
        this.KB = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_more, (ViewGroup) null);
        this.acs = (LinearLayout) this.KB.findViewById(u.g.pb_more_view);
        this.SD = (TextView) this.KB.findViewById(u.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.KB.findViewById(u.g.progress);
        this.acu = (ImageView) this.KB.findViewById(u.g.pb_more_view_top_line);
        this.acq = this.KB.findViewById(u.g.empty_view);
        this.acv = (LinearLayout) this.KB.findViewById(u.g.pb_more_top_extra_view);
        return this.KB;
    }

    public void va() {
        this.acu.setVisibility(0);
    }

    public void vb() {
        this.acu.setVisibility(8);
    }

    public void vc() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acu.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.acu.setLayoutParams(layoutParams);
    }

    public void vd() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acu.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds1);
        this.acu.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.SD.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    public LinearLayout ve() {
        return this.acv;
    }

    public void vf() {
        if (this.acv.getVisibility() != 0) {
            this.acv.setVisibility(0);
        }
    }

    public void vg() {
        if (8 != this.acv.getVisibility()) {
            this.acv.setVisibility(8);
        }
    }

    public void vh() {
        this.mProgressBar.setVisibility(0);
        this.SD.setText(this.mContext.getText(u.j.loading));
        cT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void vi() {
        this.mProgressBar.setVisibility(8);
        if (this.acr != null) {
            this.SD.setText(this.acr);
        } else {
            this.SD.setText(this.mContext.getText(u.j.pb_load_more));
        }
        cT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void vj() {
        this.mProgressBar.setVisibility(0);
        this.SD.setText(this.mContext.getText(u.j.loading));
    }

    public void cR(int i) {
        av.k(this.acs, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.acs.getLayoutParams());
        layoutParams.height = i;
        this.acs.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.acr = str;
        this.SD.setText(str);
        cT(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.KB);
        }
    }

    public void cS(int i) {
        this.acw = i;
    }

    public void cT(int i) {
        String charSequence = this.SD.getText().toString();
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
            this.SD.setTextColor(i2);
        }
        av.c(this.acu, this.act);
        if (this.acw == 0) {
            av.k(this.acs, u.d.cp_bg_line_d);
        } else if (this.acw > 0) {
            av.k(this.acs, this.acw);
        }
    }

    public void cU(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.acq.getLayoutParams());
        layoutParams.height = i;
        this.acq.setLayoutParams(layoutParams);
        this.acq.setVisibility(0);
    }

    public void vk() {
        this.acq.setVisibility(8);
    }

    public void vl() {
        this.acv.setVisibility(0);
        this.acu.setVisibility(0);
        this.acs.setVisibility(0);
        this.SD.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        vk();
    }

    public void cV(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.acq.getLayoutParams());
        layoutParams.height = i;
        this.acq.setLayoutParams(layoutParams);
        this.acq.setVisibility(0);
        this.acv.setVisibility(8);
        this.acu.setVisibility(8);
        this.acs.setVisibility(8);
        this.SD.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
