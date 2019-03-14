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
    private ImageView bRk;
    private boolean bRl;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View btY = null;
    private View bRj = null;
    private int bRm = 0;
    private String bRn = null;
    private LinearLayout bRo = null;
    private int mTextColor = 0;
    private int bRp = d.C0277d.cp_cont_e;
    private int bRq = d.C0277d.cp_bg_line_b;
    private ImageView bRr = null;
    private LinearLayout bRs = null;
    private boolean bRt = true;
    private int mSkinType = -1;
    private int bRu = 0;
    public boolean bRv = false;

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
        this.btY = LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.bRo = (LinearLayout) this.btY.findViewById(d.g.pb_more_view);
        this.mTextView = (TextView) this.btY.findViewById(d.g.pb_more_text);
        this.bRk = (ImageView) this.btY.findViewById(d.g.no_data_image);
        if (this.bRt) {
            this.bRo.setVisibility(0);
        } else {
            this.bRo.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.btY.findViewById(d.g.progress);
        this.bRr = (ImageView) this.btY.findViewById(d.g.pb_more_view_top_line);
        this.bRj = this.btY.findViewById(d.g.empty_view);
        this.bRs = (LinearLayout) this.btY.findViewById(d.g.pb_more_top_extra_view);
        return this.btY;
    }

    public void dQ(boolean z) {
        this.bRt = z;
    }

    public void hX(int i) {
        this.bRq = i;
    }

    public void aey() {
        this.bRr.setVisibility(0);
    }

    public void aez() {
        this.bRr.setVisibility(8);
    }

    public void aeA() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRr.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.bRr.setLayoutParams(layoutParams);
    }

    public void aeB() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRr.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1);
        this.bRr.setLayoutParams(layoutParams);
    }

    public void hY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRr.getLayoutParams();
        layoutParams.height = i;
        this.bRr.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void aeC() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
        ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aeD() {
        this.mProgressBar.setVisibility(8);
        if (this.bRn != null) {
            this.mTextView.setText(this.bRn);
        } else {
            this.mTextView.setText(this.mContext.getText(d.j.pb_load_more));
        }
        ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aeE() {
        setText(this.mContext.getResources().getString(d.j.list_no_more));
        aeD();
    }

    public void aeF() {
        this.mTextView.setVisibility(0);
        this.bRo.setVisibility(0);
        aeD();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(d.j.loading));
    }

    public void hZ(int i) {
        al.k(this.bRo, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRo.getLayoutParams());
        layoutParams.height = i;
        this.bRo.setLayoutParams(layoutParams);
    }

    public void aeG() {
        this.btY.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void aeH() {
        this.bRl = false;
        this.bRk.setVisibility(8);
        hideEmptyView();
        ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aa(String str, int i) {
        this.bRn = str;
        this.mTextView.setText(str);
        this.bRl = true;
        this.bRk.setVisibility(0);
        ic(TbadkCoreApplication.getInst().getSkinType());
        m19if(i);
        this.bRv = false;
    }

    public void setText(String str) {
        this.bRn = str;
        this.mTextView.setText(str);
        this.bRl = false;
        this.bRk.setVisibility(8);
        ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void ia(int i) {
        this.bRp = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.btY);
        }
    }

    public void ib(int i) {
        this.bRu = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ic(int i) {
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
        if (z && this.bRp != 0) {
            color = al.getColor(i, this.bRp);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        al.b(this.bRr, this.bRq, i);
        if (this.bRu == 0) {
            al.e(this.bRo, d.C0277d.cp_bg_line_d, i);
        } else if (this.bRu > 0) {
            al.e(this.bRo, this.bRu, i);
        }
        if (this.bRm != 0) {
            al.f(this.bRj, this.bRm, i);
        }
        if (this.bRl) {
            al.c(this.bRk, d.f.pic_emotion_gray_03);
            al.j(this.mTextView, d.C0277d.cp_cont_d);
        }
    }

    public void id(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRj.getLayoutParams());
        layoutParams.height = i;
        this.bRj.setLayoutParams(layoutParams);
        this.bRj.setVisibility(0);
    }

    public void hideEmptyView() {
        this.bRj.setVisibility(8);
    }

    public void aeI() {
        this.bRs.setVisibility(0);
        this.bRr.setVisibility(0);
        this.bRo.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void ie(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRj.getLayoutParams());
        layoutParams.height = i;
        this.bRj.setLayoutParams(layoutParams);
        this.bRj.setVisibility(0);
        this.bRs.setVisibility(8);
        this.bRr.setVisibility(8);
        this.bRo.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean qz() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean aeJ() {
        return this.bRl;
    }

    /* renamed from: if  reason: not valid java name */
    public void m19if(int i) {
        int aQ = (com.baidu.adp.lib.util.l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.tbds589))) / 2;
        if (i > 0) {
            aQ -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(d.e.tbds156);
        int i2 = (i == 0 || aQ < dimension) ? dimension : aQ;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRk.getLayoutParams();
        layoutParams.topMargin = i2;
        this.bRk.setLayoutParams(layoutParams);
        id(dimension);
    }
}
