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
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.b {
    private ImageView fkN;
    private boolean fkP;
    private Context mContext;
    private final int fkJ = R.drawable.new_pic_emotion_03;
    private final int fkK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
    private final int fkL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
    private final int fkM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;
    private View mEmpty = null;
    private int fkO = this.fkJ;
    private int mEmptyBgColorId = 0;
    private String endText = null;
    private LinearLayout mContainer = null;
    private int mTextColor = 0;
    private int mNoMoreTextColorId = R.color.CAM_X0110;
    private int lineColor = R.color.CAM_X0205;
    private ImageView lineView = null;
    private LinearLayout mTopExtraView = null;
    private boolean mIsMoreViewVisible = true;
    private int mSkinType = -1;
    private int mContainerBackgroundColorResId = 0;
    public boolean fkQ = false;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public String getEndText() {
        return this.endText;
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.mContainer = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.fkN = (ImageView) this.mRoot.findViewById(R.id.no_data_image);
        if (this.mIsMoreViewVisible) {
            this.mContainer.setVisibility(0);
        } else {
            this.mContainer.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.lineView = (ImageView) this.mRoot.findViewById(R.id.pb_more_view_top_line);
        this.mEmpty = this.mRoot.findViewById(R.id.empty_view);
        this.mTopExtraView = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_top_extra_view);
        return this.mRoot;
    }

    public void setIsMoreViewVisible(boolean z) {
        this.mIsMoreViewVisible = z;
    }

    public void setLineColorResource(int i) {
        this.lineColor = i;
    }

    public void setLineVisible() {
        this.lineView.setVisibility(0);
    }

    public void setLineGone() {
        this.lineView.setVisibility(8);
    }

    public void setLineNoMargin() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lineView.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.lineView.setLayoutParams(layoutParams);
    }

    public void setLightLine() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lineView.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1);
        this.lineView.setLayoutParams(layoutParams);
    }

    public void setDividerLineHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lineView.getLayoutParams();
        layoutParams.height = i;
        this.lineView.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
    }

    public void setTopExtraViewGone() {
        if (8 != this.mTopExtraView.getVisibility()) {
            this.mTopExtraView.setVisibility(8);
        }
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void endLoadData() {
        this.mProgressBar.setVisibility(8);
        if (this.endText != null) {
            this.mTextView.setText(this.endText);
        } else {
            this.mTextView.setText(this.mContext.getText(R.string.pb_load_more));
        }
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void endLoadDataWithNoMore() {
        setText(this.mContext.getResources().getString(R.string.list_no_more));
        endLoadData();
    }

    public void showEndLoadData() {
        this.mTextView.setVisibility(0);
        this.mContainer.setVisibility(0);
        endLoadData();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(R.string.loading));
    }

    public void setBackground(int i) {
        ao.setBackgroundResource(this.mContainer, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContainer.getLayoutParams());
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public void bxC() {
        this.mRoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void bxD() {
        this.fkP = false;
        this.fkN.setVisibility(8);
        hideEmptyView();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = this.fkM;
        layoutParams.bottomMargin = 0;
        this.mContainer.setLayoutParams(layoutParams);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ar(String str, int i) {
        this.endText = str;
        this.mTextView.setText(str);
        this.fkP = true;
        this.fkN.setVisibility(0);
        this.fkO = this.fkJ;
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        re(i);
        this.fkQ = false;
    }

    public void as(String str, int i) {
        this.endText = str;
        this.mTextView.setText(str);
        this.fkP = true;
        this.fkN.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkN.getLayoutParams();
        layoutParams.topMargin = i;
        this.fkN.setLayoutParams(layoutParams);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void t(String str, @DrawableRes int i, int i2) {
        this.endText = str;
        this.mTextView.setText(str);
        this.fkP = true;
        this.fkO = i;
        this.fkN.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkN.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = this.fkK;
        this.fkN.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams2.height = -2;
        layoutParams2.bottomMargin = this.fkL;
        this.mContainer.setLayoutParams(layoutParams2);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setText(String str) {
        at(str, this.fkM);
    }

    public void at(String str, int i) {
        this.endText = str;
        this.mTextView.setText(str);
        this.fkP = false;
        this.fkN.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.mContainer.setLayoutParams(layoutParams);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setNoMoreTextColorId(int i) {
        this.mNoMoreTextColorId = i;
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

    public void setContainerBackgroundColorResId(int i) {
        this.mContainerBackgroundColorResId = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void changeSkin(int i) {
        int color;
        boolean z;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(R.string.pb_load_more))) {
            color = ao.getColor(i, R.color.CAM_X0109);
            z = false;
        } else if (charSequence.equals(this.mContext.getText(R.string.loading))) {
            color = ao.getColor(i, R.color.CAM_X0109);
            z = false;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more)) || charSequence.equals(this.mContext.getText(R.string.list_has_no_more)) || charSequence.equals(this.mContext.getText(R.string.sub_pb_list_no_more))) {
            color = ao.getColor(i, R.color.CAM_X0109);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_no_more_new))) {
            color = ao.getColor(i, R.color.CAM_X0110);
            z = false;
        } else if (charSequence.equals(this.mContext.getText(R.string.list_click_load_more)) || charSequence.equals(this.mContext.getText(R.string.really_great))) {
            color = ao.getColor(i, R.color.CAM_X0109);
            z = false;
        } else {
            color = 0;
            z = false;
        }
        if (z && this.mNoMoreTextColorId != 0) {
            color = ao.getColor(i, this.mNoMoreTextColorId);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        ao.setImageResource(this.lineView, this.lineColor, i);
        if (this.mContainerBackgroundColorResId == 0) {
            ao.setBackgroundResource(this.mContainer, R.color.CAM_X0201, i);
        } else if (this.mContainerBackgroundColorResId > 0) {
            ao.setBackgroundResource(this.mContainer, this.mContainerBackgroundColorResId, i);
        }
        if (this.mEmptyBgColorId != 0) {
            ao.setBackgroundColor(this.mEmpty, this.mEmptyBgColorId, i);
        }
        if (this.fkP) {
            ao.setImageResource(this.fkN, this.fkO);
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0109);
        }
    }

    public void showEmptyView(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mEmpty.getLayoutParams());
        layoutParams.height = i;
        this.mEmpty.setLayoutParams(layoutParams);
        this.mEmpty.setVisibility(0);
    }

    public void rd(int i) {
        if (this.mTopExtraView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTopExtraView.getLayoutParams();
            layoutParams.height = i;
            this.mTopExtraView.setLayoutParams(layoutParams);
            this.mTopExtraView.setVisibility(0);
        }
    }

    public void hideEmptyView() {
        this.mEmpty.setVisibility(8);
    }

    public void showLoadingViewWithoutEmptyView() {
        this.mTopExtraView.setVisibility(0);
        this.lineView.setVisibility(0);
        this.mContainer.setVisibility(0);
        this.mTextView.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        hideEmptyView();
    }

    public void hideWithoutEmptyView(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mEmpty.getLayoutParams());
        layoutParams.height = i;
        this.mEmpty.setLayoutParams(layoutParams);
        this.mEmpty.setVisibility(0);
        this.mTopExtraView.setVisibility(8);
        this.lineView.setVisibility(8);
        this.mContainer.setVisibility(8);
        this.mTextView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public boolean bxE() {
        return this.fkP;
    }

    public void re(int i) {
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds156);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkN.getLayoutParams();
        layoutParams.topMargin = dimension;
        this.fkN.setLayoutParams(layoutParams);
        showEmptyView(dimension);
    }

    public void setVisibility(int i) {
        this.mRoot.setVisibility(i);
    }
}
