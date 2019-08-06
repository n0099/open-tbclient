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
    private ImageView can;
    private boolean cao;
    private Context mContext;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View cam = null;
    private int cap = 0;
    private String caq = null;
    private LinearLayout car = null;
    private int mTextColor = 0;
    private int cas = R.color.cp_cont_e;
    private int cat = R.color.cp_bg_line_b;
    private ImageView cau = null;
    private LinearLayout cav = null;
    private boolean caw = true;
    private int mSkinType = -1;
    private int cax = 0;
    public boolean cay = false;

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
        this.car = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.can = (ImageView) this.mRoot.findViewById(R.id.no_data_image);
        if (this.caw) {
            this.car.setVisibility(0);
        } else {
            this.car.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.cau = (ImageView) this.mRoot.findViewById(R.id.pb_more_view_top_line);
        this.cam = this.mRoot.findViewById(R.id.empty_view);
        this.cav = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_top_extra_view);
        return this.mRoot;
    }

    public void eq(boolean z) {
        this.caw = z;
    }

    public void iQ(int i) {
        this.cat = i;
    }

    public void akB() {
        this.cau.setVisibility(0);
    }

    public void akC() {
        this.cau.setVisibility(8);
    }

    public void akD() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cau.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.cau.setLayoutParams(layoutParams);
    }

    public void akE() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cau.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1);
        this.cau.setLayoutParams(layoutParams);
    }

    public void iR(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cau.getLayoutParams();
        layoutParams.height = i;
        this.cau.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void akF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akG() {
        this.mProgressBar.setVisibility(8);
        if (this.caq != null) {
            this.mTextView.setText(this.caq);
        } else {
            this.mTextView.setText(this.mContext.getText(R.string.pb_load_more));
        }
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void akH() {
        setText(this.mContext.getResources().getString(R.string.list_no_more));
        akG();
    }

    public void akI() {
        this.mTextView.setVisibility(0);
        this.car.setVisibility(0);
        akG();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
    }

    public void iS(int i) {
        am.k(this.car, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.car.getLayoutParams());
        layoutParams.height = i;
        this.car.setLayoutParams(layoutParams);
    }

    public void akJ() {
        this.mRoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void akK() {
        this.cao = false;
        this.can.setVisibility(8);
        hideEmptyView();
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void W(String str, int i) {
        this.caq = str;
        this.mTextView.setText(str);
        this.cao = true;
        this.can.setVisibility(0);
        iV(TbadkCoreApplication.getInst().getSkinType());
        iY(i);
        this.cay = false;
    }

    public void setText(String str) {
        this.caq = str;
        this.mTextView.setText(str);
        this.cao = false;
        this.can.setVisibility(8);
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void iT(int i) {
        this.cas = i;
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
        this.cax = i;
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
        if (z && this.cas != 0) {
            color = am.getColor(i, this.cas);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        am.b(this.cau, this.cat, i);
        if (this.cax == 0) {
            am.g(this.car, R.color.cp_bg_line_d, i);
        } else if (this.cax > 0) {
            am.g(this.car, this.cax, i);
        }
        if (this.cap != 0) {
            am.h(this.cam, this.cap, i);
        }
        if (this.cao) {
            am.c(this.can, (int) R.drawable.pic_emotion_gray_03);
            am.j(this.mTextView, R.color.cp_cont_d);
        }
    }

    public void iW(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cam.getLayoutParams());
        layoutParams.height = i;
        this.cam.setLayoutParams(layoutParams);
        this.cam.setVisibility(0);
    }

    public void hideEmptyView() {
        this.cam.setVisibility(8);
    }

    public void akL() {
        this.cav.setVisibility(0);
        this.cau.setVisibility(0);
        this.car.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void iX(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cam.getLayoutParams());
        layoutParams.height = i;
        this.cam.setLayoutParams(layoutParams);
        this.cam.setVisibility(0);
        this.cav.setVisibility(8);
        this.cau.setVisibility(8);
        this.car.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean pP() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean akM() {
        return this.cao;
    }

    public void iY(int i) {
        int ah = (com.baidu.adp.lib.util.l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.tbds589))) / 2;
        if (i > 0) {
            ah -= i / 2;
        }
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds156);
        int i2 = (i == 0 || ah < dimension) ? dimension : ah;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.can.getLayoutParams();
        layoutParams.topMargin = i2;
        this.can.setLayoutParams(layoutParams);
        iW(dimension);
    }
}
