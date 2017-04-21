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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rt = null;
    private View alc = null;
    private String ald = null;
    private LinearLayout ale = null;
    private int mTextColor = 0;
    private int alf = w.e.cp_bg_line_b;
    private ImageView alg = null;
    private LinearLayout alh = null;
    private int ali = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (alj) with 'values()' method */
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
    public View lf() {
        this.Rt = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.ale = (LinearLayout) this.Rt.findViewById(w.h.pb_more_view);
        this.mTextView = (TextView) this.Rt.findViewById(w.h.pb_more_text);
        this.mProgressBar = (ProgressBar) this.Rt.findViewById(w.h.progress);
        this.alg = (ImageView) this.Rt.findViewById(w.h.pb_more_view_top_line);
        this.alc = this.Rt.findViewById(w.h.empty_view);
        this.alh = (LinearLayout) this.Rt.findViewById(w.h.pb_more_top_extra_view);
        return this.Rt;
    }

    public void wW() {
        this.alg.setVisibility(0);
    }

    public void wX() {
        this.alg.setVisibility(8);
    }

    public void wY() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alg.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.alg.setLayoutParams(layoutParams);
    }

    public void wZ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alg.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.alg.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public LinearLayout xa() {
        return this.alh;
    }

    public void xb() {
        if (this.alh.getVisibility() != 0) {
            this.alh.setVisibility(0);
        }
    }

    public void xc() {
        if (8 != this.alh.getVisibility()) {
            this.alh.setVisibility(8);
        }
    }

    public void xd() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void xe() {
        this.mProgressBar.setVisibility(8);
        if (this.ald != null) {
            this.mTextView.setText(this.ald);
        } else {
            this.mTextView.setText(this.mContext.getText(w.l.pb_load_more));
        }
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void xf() {
        this.mTextView.setVisibility(0);
        this.ale.setVisibility(0);
        xe();
    }

    public void xg() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
    }

    public void di(int i) {
        com.baidu.tbadk.core.util.aq.j(this.ale, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ale.getLayoutParams());
        layoutParams.height = i;
        this.ale.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.ald = str;
        this.mTextView.setText(str);
        dk(TbadkCoreApplication.m9getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.Rt);
        }
    }

    public void dj(int i) {
        this.ali = i;
    }

    public void dk(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(w.l.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.loading))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(w.l.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10005);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.aq.c(this.alg, this.alf);
        if (this.ali == 0) {
            com.baidu.tbadk.core.util.aq.j(this.ale, w.e.cp_bg_line_d);
        } else if (this.ali > 0) {
            com.baidu.tbadk.core.util.aq.j(this.ale, this.ali);
        }
    }

    public void dl(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alc.getLayoutParams());
        layoutParams.height = i;
        this.alc.setLayoutParams(layoutParams);
        this.alc.setVisibility(0);
    }

    public void xh() {
        this.alc.setVisibility(8);
    }

    public void xi() {
        this.alh.setVisibility(0);
        this.alg.setVisibility(0);
        this.ale.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xh();
    }

    public void dm(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alc.getLayoutParams());
        layoutParams.height = i;
        this.alc.setLayoutParams(layoutParams);
        this.alc.setVisibility(0);
        this.alh.setVisibility(8);
        this.alg.setVisibility(8);
        this.ale.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean xj() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
