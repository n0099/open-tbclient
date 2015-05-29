package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.e {
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private String ZR = null;
    private LinearLayout Yv = null;
    private int mTextColor = 0;
    private ImageView ZS = null;
    private int ZT = 0;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (ZU) with 'values()' method */
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

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        this.mRoot = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.new_pb_list_more, null);
        this.Yv = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.q.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.q.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        this.ZS = (ImageView) this.mRoot.findViewById(com.baidu.tieba.q.pb_more_view_top_line);
        return this.mRoot;
    }

    public void uw() {
        this.ZS.setVisibility(0);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.t.loading));
        cy(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void ux() {
        this.mProgressBar.setVisibility(8);
        if (this.ZR != null) {
            this.mTextView.setText(this.ZR);
        } else {
            this.mTextView.setText(this.mContext.getText(com.baidu.tieba.t.pb_load_more));
        }
        cy(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cw(int i) {
        com.baidu.tbadk.core.util.ay.i(this.Yv, i);
    }

    public void setText(String str) {
        this.ZR = str;
        this.mTextView.setText(str);
        cy(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void cx(int i) {
        this.ZT = i;
    }

    public void cy(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(com.baidu.tieba.t.pb_load_more))) {
            i2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.t.loading))) {
            i2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.t.list_no_more))) {
            i2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.pb_list_morebutton_nomore_text);
        }
        if (this.mTextColor != 0) {
            i2 = this.mTextColor;
        }
        if (i2 != 0) {
            this.mTextView.setTextColor(i2);
        }
        com.baidu.tbadk.core.util.ay.c(this.ZS, com.baidu.tieba.n.cp_bg_line_b);
        if (this.ZT == 0) {
            com.baidu.tbadk.core.util.ay.i(this.Yv, com.baidu.tieba.n.cp_bg_line_d);
        } else if (this.ZT > 0) {
            com.baidu.tbadk.core.util.ay.i(this.Yv, this.ZT);
        }
    }
}
