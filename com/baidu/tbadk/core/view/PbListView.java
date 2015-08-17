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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View aeR = null;
    private String aeS = null;
    private LinearLayout adt = null;
    private int mTextColor = 0;
    private ImageView aeT = null;
    private int aeU = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (aeV) with 'values()' method */
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
    public View nq() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_more, (ViewGroup) null);
        this.adt = (LinearLayout) this.mRoot.findViewById(i.f.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.aeT = (ImageView) this.mRoot.findViewById(i.f.pb_more_view_top_line);
        this.aeR = this.mRoot.findViewById(i.f.empty_view);
        return this.mRoot;
    }

    public void vA() {
        this.aeT.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.C0057i.loading));
        cG(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void vB() {
        this.mProgressBar.setVisibility(8);
        if (this.aeS != null) {
            this.mTextView.setText(this.aeS);
        } else {
            this.mTextView.setText(this.mContext.getText(i.C0057i.pb_load_more));
        }
        cG(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(i.C0057i.loading));
    }

    public void cE(int i) {
        al.i(this.adt, i);
    }

    public void setText(String str) {
        this.aeS = str;
        this.mTextView.setText(str);
        cG(TbadkCoreApplication.m411getInst().getSkinType());
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

    public void cF(int i) {
        this.aeU = i;
    }

    public void cG(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(i.C0057i.pb_load_more))) {
            i2 = al.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.C0057i.loading))) {
            i2 = al.getColor(i.c.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(i.C0057i.list_no_more))) {
            i2 = al.getColor(i.c.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        al.c(this.aeT, i.c.cp_bg_line_b);
        if (this.aeU == 0) {
            al.i(this.adt, i.c.cp_bg_line_d);
        } else if (this.aeU > 0) {
            al.i(this.adt, this.aeU);
        }
    }

    public void cH(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeR.getLayoutParams());
        layoutParams.height = i;
        this.aeR.setLayoutParams(layoutParams);
        this.aeR.setVisibility(0);
    }

    public void vC() {
        this.aeR.setVisibility(8);
    }
}
