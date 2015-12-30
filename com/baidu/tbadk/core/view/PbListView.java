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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View agc = null;
    private String agd = null;
    private LinearLayout age = null;
    private int mTextColor = 0;
    private int agf = n.d.cp_bg_line_b;
    private ImageView agg = null;
    private int agh = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (agi) with 'values()' method */
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
    public View mT() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_more, (ViewGroup) null);
        this.age = (LinearLayout) this.mRoot.findViewById(n.g.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(n.g.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(n.g.progress);
        this.agg = (ImageView) this.mRoot.findViewById(n.g.pb_more_view_top_line);
        this.agc = this.mRoot.findViewById(n.g.empty_view);
        return this.mRoot;
    }

    public void vO() {
        this.agg.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(n.j.loading));
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void vP() {
        this.mProgressBar.setVisibility(8);
        if (this.agd != null) {
            this.mTextView.setText(this.agd);
        } else {
            this.mTextView.setText(this.mContext.getText(n.j.pb_load_more));
        }
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(n.j.loading));
    }

    public void cN(int i) {
        as.i(this.age, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.age.getLayoutParams());
        layoutParams.height = i;
        this.age.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.agd = str;
        this.mTextView.setText(str);
        cP(TbadkCoreApplication.m411getInst().getSkinType());
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
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void cO(int i) {
        this.agh = i;
    }

    public void cP(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(n.j.pb_load_more))) {
            i2 = as.getColor(n.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(n.j.loading))) {
            i2 = as.getColor(n.d.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(n.j.list_no_more))) {
            i2 = as.getColor(n.d.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        as.c(this.agg, this.agf);
        if (this.agh == 0) {
            as.i(this.age, n.d.cp_bg_line_d);
        } else if (this.agh > 0) {
            as.i(this.age, this.agh);
        }
    }

    public void cQ(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.agc.getLayoutParams());
        layoutParams.height = i;
        this.agc.setLayoutParams(layoutParams);
        this.agc.setVisibility(0);
    }

    public void vQ() {
        this.agc.setVisibility(8);
    }
}
