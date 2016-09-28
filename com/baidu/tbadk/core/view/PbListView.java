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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView Wl = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MM = null;
    private View agq = null;
    private String agr = null;
    private LinearLayout ags = null;
    private int mTextColor = 0;
    private int agt = r.d.cp_bg_line_b;
    private ImageView agu = null;
    private LinearLayout agv = null;
    private int agw = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (agx) with 'values()' method */
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
    public View kk() {
        this.MM = LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.ags = (LinearLayout) this.MM.findViewById(r.g.pb_more_view);
        this.Wl = (TextView) this.MM.findViewById(r.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.agu = (ImageView) this.MM.findViewById(r.g.pb_more_view_top_line);
        this.agq = this.MM.findViewById(r.g.empty_view);
        this.agv = (LinearLayout) this.MM.findViewById(r.g.pb_more_top_extra_view);
        return this.MM;
    }

    public void wu() {
        this.agu.setVisibility(0);
    }

    public void wv() {
        this.agu.setVisibility(8);
    }

    public void ww() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agu.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.agu.setLayoutParams(layoutParams);
    }

    public void wx() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agu.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds1);
        this.agu.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.Wl.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public LinearLayout wy() {
        return this.agv;
    }

    public void wz() {
        if (this.agv.getVisibility() != 0) {
            this.agv.setVisibility(0);
        }
    }

    public void wA() {
        if (8 != this.agv.getVisibility()) {
            this.agv.setVisibility(8);
        }
    }

    public void wB() {
        this.mProgressBar.setVisibility(0);
        this.Wl.setText(this.mContext.getText(r.j.loading));
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wC() {
        this.mProgressBar.setVisibility(8);
        if (this.agr != null) {
            this.Wl.setText(this.agr);
        } else {
            this.Wl.setText(this.mContext.getText(r.j.pb_load_more));
        }
        dh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void wD() {
        this.mProgressBar.setVisibility(0);
        this.Wl.setText(this.mContext.getText(r.j.loading));
    }

    public void df(int i) {
        av.k(this.ags, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ags.getLayoutParams());
        layoutParams.height = i;
        this.ags.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agr = str;
        this.Wl.setText(str);
        dh(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.MM);
        }
    }

    public void dg(int i) {
        this.agw = i;
    }

    public void dh(int i) {
        String charSequence = this.Wl.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(r.j.pb_load_more))) {
            i2 = av.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.loading))) {
            i2 = av.getColor(r.d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(r.j.list_no_more))) {
            i2 = av.getColor(r.d.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.Wl.setTextColor(i2);
        }
        av.c(this.agu, this.agt);
        if (this.agw == 0) {
            av.k(this.ags, r.d.cp_bg_line_d);
        } else if (this.agw > 0) {
            av.k(this.ags, this.agw);
        }
    }

    public void di(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agq.getLayoutParams());
        layoutParams.height = i;
        this.agq.setLayoutParams(layoutParams);
        this.agq.setVisibility(0);
    }

    public void wE() {
        this.agq.setVisibility(8);
    }

    public void wF() {
        this.agv.setVisibility(0);
        this.agu.setVisibility(0);
        this.ags.setVisibility(0);
        this.Wl.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        wE();
    }

    public void dj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agq.getLayoutParams());
        layoutParams.height = i;
        this.agq.setLayoutParams(layoutParams);
        this.agq.setVisibility(0);
        this.agv.setVisibility(8);
        this.agu.setVisibility(8);
        this.ags.setVisibility(8);
        this.Wl.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean wG() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
