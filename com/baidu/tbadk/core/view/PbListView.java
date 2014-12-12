package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.i {
    private LinearLayout Mg;
    private String Nm;
    private ImageView Nn;
    private int No;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private ProgressBar mProgressBar;
    private View mRoot;
    private int mTextColor;
    private TextView mTextView;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (Np) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public String qx() {
        return this.Nm;
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.Nm = null;
        this.Mg = null;
        this.mTextColor = 0;
        this.Nn = null;
        this.No = 0;
        this.mContext = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jx() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.new_pb_list_more, null);
        this.Mg = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.Nn = (ImageView) this.mRoot.findViewById(com.baidu.tieba.w.pb_more_view_top_line);
        return this.mRoot;
    }

    public void qy() {
        this.Nn.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.z.loading));
        cl(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void qz() {
        this.mProgressBar.setVisibility(8);
        if (this.Nm != null) {
            this.mTextView.setText(this.Nm);
        } else {
            this.mTextView.setText(this.mContext.getText(com.baidu.tieba.z.pb_load_more));
        }
        cl(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void cj(int i) {
        com.baidu.tbadk.core.util.ax.i(this.Mg, i);
    }

    public void setText(String str) {
        this.Nm = str;
        this.mTextView.setText(str);
        cl(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void ck(int i) {
        this.No = i;
    }

    public void cl(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.loading))) {
            i2 = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.z.no_more_to_load))) {
            i2 = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.ax.c(this.Nn, com.baidu.tieba.t.cp_bg_line_b);
        if (this.No == 0) {
            com.baidu.tbadk.core.util.ax.i(this.Mg, com.baidu.tieba.t.cp_bg_line_d);
        } else if (this.No > 0) {
            com.baidu.tbadk.core.util.ax.i(this.Mg, this.No);
        }
    }
}
