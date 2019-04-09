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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private ImageView bRn;
    private boolean bRo;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View buc = null;
    private View bRm = null;
    private int bRp = 0;
    private String bRq = null;
    private LinearLayout bRr = null;
    private int mTextColor = 0;
    private int bRs = d.C0277d.cp_cont_e;
    private int bRt = d.C0277d.cp_bg_line_b;
    private ImageView bRu = null;
    private LinearLayout bRv = null;
    private boolean bRw = true;
    private int mSkinType = -1;
    private int bRx = 0;
    public boolean bRy = false;

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
    public View oM() {
        this.buc = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.bRr = (LinearLayout) this.buc.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.buc.findViewById(d.g.pb_more_text);
        this.bRn = (ImageView) this.buc.findViewById(d.g.no_data_image);
        if (this.bRw) {
            this.bRr.setVisibility(0);
        } else {
            this.bRr.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.buc.findViewById(d.g.progress);
        this.bRu = (ImageView) this.buc.findViewById(d.g.pb_more_view_top_line);
        this.bRm = this.buc.findViewById(d.g.empty_view);
        this.bRv = (LinearLayout) this.buc.findViewById(d.g.pb_more_top_extra_view);
        return this.buc;
    }

    public void dQ(boolean z) {
        this.bRw = z;
    }

    public void hW(int i) {
        this.bRt = i;
    }

    public void aev() {
        this.bRu.setVisibility(0);
    }

    public void aew() {
        this.bRu.setVisibility(8);
    }

    public void aex() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRu.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bRu.setLayoutParams(layoutParams);
    }

    public void aey() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRu.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1);
        this.bRu.setLayoutParams(layoutParams);
    }

    public void hX(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRu.getLayoutParams();
        layoutParams.height = i;
        this.bRu.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void aez() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
        ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aeA() {
        this.mProgressBar.setVisibility(8);
        if (this.bRq != null) {
            this.mTextView.setText(this.bRq);
        } else {
            this.mTextView.setText(this.mContext.getText(d.j.pb_load_more));
        }
        ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aeB() {
        setText(this.mContext.getResources().getString(d.j.list_no_more));
        aeA();
    }

    public void aeC() {
        this.mTextView.setVisibility(0);
        this.bRr.setVisibility(0);
        aeA();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
    }

    public void hY(int i) {
        al.k(this.bRr, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRr.getLayoutParams());
        layoutParams.height = i;
        this.bRr.setLayoutParams(layoutParams);
    }

    public void aeD() {
        this.buc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void aeE() {
        this.bRo = false;
        this.bRn.setVisibility(8);
        hideEmptyView();
        ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aa(String str, int i) {
        this.bRq = str;
        this.mTextView.setText(str);
        this.bRo = true;
        this.bRn.setVisibility(0);
        ib(TbadkCoreApplication.getInst().getSkinType());
        ie(i);
        this.bRy = false;
    }

    public void setText(String str) {
        this.bRq = str;
        this.mTextView.setText(str);
        this.bRo = false;
        this.bRn.setVisibility(8);
        ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void hZ(int i) {
        this.bRs = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.buc);
        }
    }

    public void ia(int i) {
        this.bRx = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ib(int i) {
        int color;
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(d.j.pb_load_more))) {
            color = al.getColor(i, d.C0277d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.loading))) {
            color = al.getColor(i, d.C0277d.common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more)) || charSequence.equals(this.mContext.getText(d.j.list_has_no_more)) || charSequence.equals(this.mContext.getText(d.j.sub_pb_list_no_more))) {
            color = al.getColor(i, d.C0277d.common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(d.j.list_no_more_new))) {
            color = al.getColor(i, d.C0277d.cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(d.j.list_click_load_more)) ? al.getColor(i, d.C0277d.cp_cont_d) : 0;
        }
        if (z && this.bRs != 0) {
            color = al.getColor(i, this.bRs);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.bRu, this.bRt, i);
        if (this.bRx == 0) {
            al.e(this.bRr, d.C0277d.cp_bg_line_d, i);
        } else if (this.bRx > 0) {
            al.e(this.bRr, this.bRx, i);
        }
        if (this.bRp != 0) {
            al.f(this.bRm, this.bRp, i);
        }
        if (this.bRo) {
            al.c(this.bRn, d.f.pic_emotion_gray_03);
            al.j(this.mTextView, d.C0277d.cp_cont_d);
        }
    }

    public void ic(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRm.getLayoutParams());
        layoutParams.height = i;
        this.bRm.setLayoutParams(layoutParams);
        this.bRm.setVisibility(0);
    }

    public void hideEmptyView() {
        this.bRm.setVisibility(8);
    }

    public void aeF() {
        this.bRv.setVisibility(0);
        this.bRu.setVisibility(0);
        this.bRr.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void id(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRm.getLayoutParams());
        layoutParams.height = i;
        this.bRm.setLayoutParams(layoutParams);
        this.bRm.setVisibility(0);
        this.bRv.setVisibility(8);
        this.bRu.setVisibility(8);
        this.bRr.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean qz() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean aeG() {
        return this.bRo;
    }

    public void ie(int i) {
        int aQ = (com.baidu.adp.lib.util.l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.tbds589))) / 2;
        if (i > 0) {
            aQ -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(d.e.tbds156);
        int i2 = (i == 0 || aQ < dimension) ? dimension : aQ;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRn.getLayoutParams();
        layoutParams.topMargin = i2;
        this.bRn.setLayoutParams(layoutParams);
        ic(dimension);
    }
}
