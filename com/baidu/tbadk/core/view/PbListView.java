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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private ImageView bZf;
    private boolean bZg;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View bBg = null;
    private View bZe = null;
    private int bZh = 0;
    private String bZi = null;
    private LinearLayout bZj = null;
    private int mTextColor = 0;
    private int bZk = R.color.cp_cont_e;
    private int bZl = R.color.cp_bg_line_b;
    private ImageView bZm = null;
    private LinearLayout bZn = null;
    private boolean bZo = true;
    private int mSkinType = -1;
    private int bZp = 0;
    public boolean bZq = false;

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
    public View nG() {
        this.bBg = LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.bZj = (LinearLayout) this.bBg.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
        this.bZf = (ImageView) this.bBg.findViewById(R.id.no_data_image);
        if (this.bZo) {
            this.bZj.setVisibility(0);
        } else {
            this.bZj.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.bZm = (ImageView) this.bBg.findViewById(R.id.pb_more_view_top_line);
        this.bZe = this.bBg.findViewById(R.id.empty_view);
        this.bZn = (LinearLayout) this.bBg.findViewById(R.id.pb_more_top_extra_view);
        return this.bBg;
    }

    public void em(boolean z) {
        this.bZo = z;
    }

    public void iK(int i) {
        this.bZl = i;
    }

    public void aju() {
        this.bZm.setVisibility(0);
    }

    public void ajv() {
        this.bZm.setVisibility(8);
    }

    public void ajw() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZm.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bZm.setLayoutParams(layoutParams);
    }

    public void ajx() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZm.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1);
        this.bZm.setLayoutParams(layoutParams);
    }

    public void iL(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZm.getLayoutParams();
        layoutParams.height = i;
        this.bZm.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void ajy() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ajz() {
        this.mProgressBar.setVisibility(8);
        if (this.bZi != null) {
            this.mTextView.setText(this.bZi);
        } else {
            this.mTextView.setText(this.mContext.getText(R.string.pb_load_more));
        }
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ajA() {
        setText(this.mContext.getResources().getString(R.string.list_no_more));
        ajz();
    }

    public void ajB() {
        this.mTextView.setVisibility(0);
        this.bZj.setVisibility(0);
        ajz();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
    }

    public void iM(int i) {
        al.k(this.bZj, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bZj.getLayoutParams());
        layoutParams.height = i;
        this.bZj.setLayoutParams(layoutParams);
    }

    public void ajC() {
        this.bBg.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void ajD() {
        this.bZg = false;
        this.bZf.setVisibility(8);
        hideEmptyView();
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void W(String str, int i) {
        this.bZi = str;
        this.mTextView.setText(str);
        this.bZg = true;
        this.bZf.setVisibility(0);
        iP(TbadkCoreApplication.getInst().getSkinType());
        iS(i);
        this.bZq = false;
    }

    public void setText(String str) {
        this.bZi = str;
        this.mTextView.setText(str);
        this.bZg = false;
        this.bZf.setVisibility(8);
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void iN(int i) {
        this.bZk = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.bBg);
        }
    }

    public void iO(int i) {
        this.bZp = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iP(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(R.string.pb_load_more))) {
            color = al.getColor(i, R.color.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(R.string.loading))) {
            color = al.getColor(i, R.color.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more)) || charSequence.equals(this.mContext.getText(R.string.list_has_no_more)) || charSequence.equals(this.mContext.getText(R.string.sub_pb_list_no_more))) {
            color = al.getColor(i, R.color.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more_new))) {
            color = al.getColor(i, R.color.cp_cont_e);
        } else {
            color = (charSequence.equals(this.mContext.getText(R.string.list_click_load_more)) || charSequence.equals(this.mContext.getText(R.string.really_great))) ? al.getColor(i, R.color.cp_cont_d) : 0;
        }
        if (z && this.bZk != 0) {
            color = al.getColor(i, this.bZk);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.bZm, this.bZl, i);
        if (this.bZp == 0) {
            al.g(this.bZj, R.color.cp_bg_line_d, i);
        } else if (this.bZp > 0) {
            al.g(this.bZj, this.bZp, i);
        }
        if (this.bZh != 0) {
            al.h(this.bZe, this.bZh, i);
        }
        if (this.bZg) {
            al.c(this.bZf, (int) R.drawable.pic_emotion_gray_03);
            al.j(this.mTextView, R.color.cp_cont_d);
        }
    }

    public void iQ(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bZe.getLayoutParams());
        layoutParams.height = i;
        this.bZe.setLayoutParams(layoutParams);
        this.bZe.setVisibility(0);
    }

    public void hideEmptyView() {
        this.bZe.setVisibility(8);
    }

    public void ajE() {
        this.bZn.setVisibility(0);
        this.bZm.setVisibility(0);
        this.bZj.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void iR(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bZe.getLayoutParams());
        layoutParams.height = i;
        this.bZe.setLayoutParams(layoutParams);
        this.bZe.setVisibility(0);
        this.bZn.setVisibility(8);
        this.bZm.setVisibility(8);
        this.bZj.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean pu() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean ajF() {
        return this.bZg;
    }

    public void iS(int i) {
        int ah = (com.baidu.adp.lib.util.l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.tbds589))) / 2;
        if (i > 0) {
            ah -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds156);
        int i2 = (i == 0 || ah < dimension) ? dimension : ah;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZf.getLayoutParams();
        layoutParams.topMargin = i2;
        this.bZf.setLayoutParams(layoutParams);
        iQ(dimension);
    }
}
