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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView WY = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View PL = null;
    private View agq = null;
    private String agr = null;
    private LinearLayout ags = null;
    private int mTextColor = 0;
    private int agt = t.d.cp_bg_line_b;
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
    public View mZ() {
        this.PL = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.ags = (LinearLayout) this.PL.findViewById(t.g.pb_more_view);
        this.WY = (TextView) this.PL.findViewById(t.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.PL.findViewById(t.g.progress);
        this.agu = (ImageView) this.PL.findViewById(t.g.pb_more_view_top_line);
        this.agq = this.PL.findViewById(t.g.empty_view);
        this.agv = (LinearLayout) this.PL.findViewById(t.g.pb_more_top_extra_view);
        return this.PL;
    }

    public void xp() {
        this.agu.setVisibility(0);
    }

    public void xq() {
        this.agu.setVisibility(8);
    }

    public LinearLayout xr() {
        return this.agv;
    }

    public void xs() {
        if (this.agv.getVisibility() != 0) {
            this.agv.setVisibility(0);
        }
    }

    public void xt() {
        if (8 != this.agv.getVisibility()) {
            this.agv.setVisibility(8);
        }
    }

    public void xu() {
        this.mProgressBar.setVisibility(0);
        this.WY.setText(this.mContext.getText(t.j.loading));
        dj(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void xv() {
        this.mProgressBar.setVisibility(8);
        if (this.agr != null) {
            this.WY.setText(this.agr);
        } else {
            this.WY.setText(this.mContext.getText(t.j.pb_load_more));
        }
        dj(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.WY.setText(this.mContext.getText(t.j.loading));
    }

    public void dh(int i) {
        at.k(this.ags, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ags.getLayoutParams());
        layoutParams.height = i;
        this.ags.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agr = str;
        this.WY.setText(str);
        dj(TbadkCoreApplication.m411getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.PL);
        }
    }

    public void di(int i) {
        this.agw = i;
    }

    public void dj(int i) {
        String charSequence = this.WY.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(t.j.pb_load_more))) {
            i2 = at.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.loading))) {
            i2 = at.getColor(t.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(t.j.list_no_more))) {
            i2 = at.getColor(t.d.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.WY.setTextColor(i2);
        }
        at.c(this.agu, this.agt);
        if (this.agw == 0) {
            at.k(this.ags, t.d.cp_bg_line_d);
        } else if (this.agw > 0) {
            at.k(this.ags, this.agw);
        }
    }

    public void dk(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agq.getLayoutParams());
        layoutParams.height = i;
        this.agq.setLayoutParams(layoutParams);
        this.agq.setVisibility(0);
    }

    public void xw() {
        this.agq.setVisibility(8);
    }

    public void xx() {
        this.agv.setVisibility(0);
        this.agu.setVisibility(0);
        this.ags.setVisibility(0);
        this.WY.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xw();
    }

    public void dl(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agq.getLayoutParams());
        layoutParams.height = i;
        this.agq.setLayoutParams(layoutParams);
        this.agq.setVisibility(0);
        this.agv.setVisibility(8);
        this.agu.setVisibility(8);
        this.ags.setVisibility(8);
        this.WY.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }
}
