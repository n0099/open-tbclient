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
    private ImageView cah;
    private boolean cai;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View cag = null;
    private int caj = 0;
    private String cak = null;
    private LinearLayout cal = null;
    private int mTextColor = 0;
    private int cam = R.color.cp_cont_e;
    private int can = R.color.cp_bg_line_b;
    private ImageView cao = null;
    private LinearLayout cap = null;
    private boolean caq = true;
    private int mSkinType = -1;
    private int car = 0;
    public boolean cas = false;

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
        this.cal = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.cah = (ImageView) this.mRoot.findViewById(R.id.no_data_image);
        if (this.caq) {
            this.cal.setVisibility(0);
        } else {
            this.cal.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.cao = (ImageView) this.mRoot.findViewById(R.id.pb_more_view_top_line);
        this.cag = this.mRoot.findViewById(R.id.empty_view);
        this.cap = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_top_extra_view);
        return this.mRoot;
    }

    public void eq(boolean z) {
        this.caq = z;
    }

    public void iQ(int i) {
        this.can = i;
    }

    public void akz() {
        this.cao.setVisibility(0);
    }

    public void akA() {
        this.cao.setVisibility(8);
    }

    public void akB() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cao.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.cao.setLayoutParams(layoutParams);
    }

    public void akC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cao.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1);
        this.cao.setLayoutParams(layoutParams);
    }

    public void iR(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cao.getLayoutParams();
        layoutParams.height = i;
        this.cao.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void akD() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akE() {
        this.mProgressBar.setVisibility(8);
        if (this.cak != null) {
            this.mTextView.setText(this.cak);
        } else {
            this.mTextView.setText(this.mContext.getText(R.string.pb_load_more));
        }
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akF() {
        setText(this.mContext.getResources().getString(R.string.list_no_more));
        akE();
    }

    public void akG() {
        this.mTextView.setVisibility(0);
        this.cal.setVisibility(0);
        akE();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
    }

    public void iS(int i) {
        am.k(this.cal, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cal.getLayoutParams());
        layoutParams.height = i;
        this.cal.setLayoutParams(layoutParams);
    }

    public void akH() {
        this.mRoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void akI() {
        this.cai = false;
        this.cah.setVisibility(8);
        hideEmptyView();
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void W(String str, int i) {
        this.cak = str;
        this.mTextView.setText(str);
        this.cai = true;
        this.cah.setVisibility(0);
        iV(TbadkCoreApplication.getInst().getSkinType());
        iY(i);
        this.cas = false;
    }

    public void setText(String str) {
        this.cak = str;
        this.mTextView.setText(str);
        this.cai = false;
        this.cah.setVisibility(8);
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void iT(int i) {
        this.cam = i;
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

    public void iU(int i) {
        this.car = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void iV(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(R.string.pb_load_more))) {
            color = am.getColor(i, R.color.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(R.string.loading))) {
            color = am.getColor(i, R.color.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more)) || charSequence.equals(this.mContext.getText(R.string.list_has_no_more)) || charSequence.equals(this.mContext.getText(R.string.sub_pb_list_no_more))) {
            color = am.getColor(i, R.color.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more_new))) {
            color = am.getColor(i, R.color.cp_cont_e);
        } else {
            color = (charSequence.equals(this.mContext.getText(R.string.list_click_load_more)) || charSequence.equals(this.mContext.getText(R.string.really_great))) ? am.getColor(i, R.color.cp_cont_d) : 0;
        }
        if (z && this.cam != 0) {
            color = am.getColor(i, this.cam);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.cao, this.can, i);
        if (this.car == 0) {
            am.g(this.cal, R.color.cp_bg_line_d, i);
        } else if (this.car > 0) {
            am.g(this.cal, this.car, i);
        }
        if (this.caj != 0) {
            am.h(this.cag, this.caj, i);
        }
        if (this.cai) {
            am.c(this.cah, (int) R.drawable.pic_emotion_gray_03);
            am.j(this.mTextView, R.color.cp_cont_d);
        }
    }

    public void iW(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cag.getLayoutParams());
        layoutParams.height = i;
        this.cag.setLayoutParams(layoutParams);
        this.cag.setVisibility(0);
    }

    public void hideEmptyView() {
        this.cag.setVisibility(8);
    }

    public void akJ() {
        this.cap.setVisibility(0);
        this.cao.setVisibility(0);
        this.cal.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void iX(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cag.getLayoutParams());
        layoutParams.height = i;
        this.cag.setLayoutParams(layoutParams);
        this.cag.setVisibility(0);
        this.cap.setVisibility(8);
        this.cao.setVisibility(8);
        this.cal.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean pP() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean akK() {
        return this.cai;
    }

    public void iY(int i) {
        int ah = (com.baidu.adp.lib.util.l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.tbds589))) / 2;
        if (i > 0) {
            ah -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds156);
        int i2 = (i == 0 || ah < dimension) ? dimension : ah;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cah.getLayoutParams();
        layoutParams.topMargin = i2;
        this.cah.setLayoutParams(layoutParams);
        iW(dimension);
    }
}
