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
    private View Rr = null;
    private View alb = null;
    private String alc = null;
    private LinearLayout ald = null;
    private int mTextColor = 0;
    private int ale = w.e.cp_bg_line_b;
    private ImageView alf = null;
    private LinearLayout alg = null;
    private int alh = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (ali) with 'values()' method */
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
    public View le() {
        this.Rr = LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.ald = (LinearLayout) this.Rr.findViewById(w.h.pb_more_view);
        this.mTextView = (TextView) this.Rr.findViewById(w.h.pb_more_text);
        this.mProgressBar = (ProgressBar) this.Rr.findViewById(w.h.progress);
        this.alf = (ImageView) this.Rr.findViewById(w.h.pb_more_view_top_line);
        this.alb = this.Rr.findViewById(w.h.empty_view);
        this.alg = (LinearLayout) this.Rr.findViewById(w.h.pb_more_top_extra_view);
        return this.Rr;
    }

    public void wW() {
        this.alf.setVisibility(0);
    }

    public void wX() {
        this.alf.setVisibility(8);
    }

    public void wY() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alf.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.alf.setLayoutParams(layoutParams);
    }

    public void wZ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alf.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
        this.alf.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public LinearLayout xa() {
        return this.alg;
    }

    public void xb() {
        if (this.alg.getVisibility() != 0) {
            this.alg.setVisibility(0);
        }
    }

    public void xc() {
        if (8 != this.alg.getVisibility()) {
            this.alg.setVisibility(8);
        }
    }

    public void xd() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void xe() {
        this.mProgressBar.setVisibility(8);
        if (this.alc != null) {
            this.mTextView.setText(this.alc);
        } else {
            this.mTextView.setText(this.mContext.getText(w.l.pb_load_more));
        }
        dk(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void xf() {
        this.mTextView.setVisibility(0);
        this.ald.setVisibility(0);
        xe();
    }

    public void xg() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(w.l.loading));
    }

    public void di(int i) {
        com.baidu.tbadk.core.util.aq.j(this.ald, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ald.getLayoutParams());
        layoutParams.height = i;
        this.ald.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.alc = str;
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
            this.mOnClickListener.onClick(this.Rr);
        }
    }

    public void dj(int i) {
        this.alh = i;
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
        com.baidu.tbadk.core.util.aq.c(this.alf, this.ale);
        if (this.alh == 0) {
            com.baidu.tbadk.core.util.aq.j(this.ald, w.e.cp_bg_line_d);
        } else if (this.alh > 0) {
            com.baidu.tbadk.core.util.aq.j(this.ald, this.alh);
        }
    }

    public void dl(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alb.getLayoutParams());
        layoutParams.height = i;
        this.alb.setLayoutParams(layoutParams);
        this.alb.setVisibility(0);
    }

    public void xh() {
        this.alb.setVisibility(8);
    }

    public void xi() {
        this.alg.setVisibility(0);
        this.alf.setVisibility(0);
        this.ald.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        xh();
    }

    public void dm(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.alb.getLayoutParams());
        layoutParams.height = i;
        this.alb.setLayoutParams(layoutParams);
        this.alb.setVisibility(0);
        this.alg.setVisibility(8);
        this.alf.setVisibility(8);
        this.ald.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean xj() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }
}
