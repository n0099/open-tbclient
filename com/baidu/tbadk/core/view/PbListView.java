package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private ImageView cbg;
    private boolean cbh;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View cbf = null;
    private int cbi = 0;
    private String cbj = null;
    private LinearLayout cbk = null;
    private int mTextColor = 0;
    private int cbl = R.color.cp_cont_e;
    private int cbm = R.color.cp_bg_line_e;
    private ImageView cbn = null;
    private LinearLayout cbo = null;
    private boolean cbp = true;
    private int mSkinType = -1;
    private int cbq = 0;
    public boolean cbr = false;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View nZ() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.cbk = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.cbg = (ImageView) this.mRoot.findViewById(R.id.no_data_image);
        if (this.cbp) {
            this.cbk.setVisibility(0);
        } else {
            this.cbk.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.cbn = (ImageView) this.mRoot.findViewById(R.id.pb_more_view_top_line);
        this.cbf = this.mRoot.findViewById(R.id.empty_view);
        this.cbo = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_top_extra_view);
        return this.mRoot;
    }

    public void et(boolean z) {
        this.cbp = z;
    }

    public void iT(int i) {
        this.cbm = i;
    }

    public void akN() {
        this.cbn.setVisibility(0);
    }

    public void akO() {
        this.cbn.setVisibility(8);
    }

    public void akP() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbn.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.cbn.setLayoutParams(layoutParams);
    }

    public void akQ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbn.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1);
        this.cbn.setLayoutParams(layoutParams);
    }

    public void iU(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbn.getLayoutParams();
        layoutParams.height = i;
        this.cbn.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void akR() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akS() {
        this.mProgressBar.setVisibility(8);
        if (this.cbj != null) {
            this.mTextView.setText(this.cbj);
        } else {
            this.mTextView.setText(this.mContext.getText(R.string.pb_load_more));
        }
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akT() {
        setText(this.mContext.getResources().getString(R.string.list_no_more));
        akS();
    }

    public void akU() {
        this.mTextView.setVisibility(0);
        this.cbk.setVisibility(0);
        akS();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
    }

    public void iV(int i) {
        am.k(this.cbk, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cbk.getLayoutParams());
        layoutParams.height = i;
        this.cbk.setLayoutParams(layoutParams);
    }

    public void akV() {
        this.mRoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void akW() {
        this.cbh = false;
        this.cbg.setVisibility(8);
        hideEmptyView();
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void W(String str, int i) {
        this.cbj = str;
        this.mTextView.setText(str);
        this.cbh = true;
        this.cbg.setVisibility(0);
        iY(TbadkCoreApplication.getInst().getSkinType());
        jb(i);
        this.cbr = false;
    }

    public void setText(String str) {
        this.cbj = str;
        this.mTextView.setText(str);
        this.cbh = false;
        this.cbg.setVisibility(8);
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void iW(int i) {
        this.cbl = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void iX(int i) {
        this.cbq = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iY(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(R.string.pb_load_more))) {
            color = am.getColor(i, R.color.cp_cont_d);
        } else if (charSequence.equals(this.mContext.getText(R.string.loading))) {
            color = am.getColor(i, R.color.cp_cont_d);
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more)) || charSequence.equals(this.mContext.getText(R.string.list_has_no_more)) || charSequence.equals(this.mContext.getText(R.string.sub_pb_list_no_more))) {
            color = am.getColor(i, R.color.cp_cont_d);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more_new))) {
            color = am.getColor(i, R.color.cp_cont_e);
        } else {
            color = (charSequence.equals(this.mContext.getText(R.string.list_click_load_more)) || charSequence.equals(this.mContext.getText(R.string.really_great))) ? am.getColor(i, R.color.cp_cont_d) : 0;
        }
        if (z && this.cbl != 0) {
            color = am.getColor(i, this.cbl);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.cbn, this.cbm, i);
        if (this.cbq == 0) {
            am.g(this.cbk, R.color.cp_bg_line_d, i);
        } else if (this.cbq > 0) {
            am.g(this.cbk, this.cbq, i);
        }
        if (this.cbi != 0) {
            am.h(this.cbf, this.cbi, i);
        }
        if (this.cbh) {
            am.c(this.cbg, (int) R.drawable.pic_emotion_gray_03);
            am.j(this.mTextView, R.color.cp_cont_d);
        }
    }

    public void iZ(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cbf.getLayoutParams());
        layoutParams.height = i;
        this.cbf.setLayoutParams(layoutParams);
        this.cbf.setVisibility(0);
    }

    public void hideEmptyView() {
        this.cbf.setVisibility(8);
    }

    public void akX() {
        this.cbo.setVisibility(0);
        this.cbn.setVisibility(0);
        this.cbk.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void ja(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cbf.getLayoutParams());
        layoutParams.height = i;
        this.cbf.setLayoutParams(layoutParams);
        this.cbf.setVisibility(0);
        this.cbo.setVisibility(8);
        this.cbn.setVisibility(8);
        this.cbk.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean pQ() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean akY() {
        return this.cbh;
    }

    public void jb(int i) {
        int ah = (com.baidu.adp.lib.util.l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.tbds589))) / 2;
        if (i > 0) {
            ah -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds156);
        int i2 = (i == 0 || ah < dimension) ? dimension : ah;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbg.getLayoutParams();
        layoutParams.topMargin = i2;
        this.cbg.setLayoutParams(layoutParams);
        iZ(dimension);
    }
}
