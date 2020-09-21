package com.baidu.live.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdIListPage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class PbListView extends BdIListPage {
    private String endText;
    private int lineColor;
    private ImageView lineView;
    private LinearLayout mContainer;
    private int mContainerBackgroundColorResId;
    private Context mContext;
    private View mEmpty;
    private int mEmptyBgColorId;
    private boolean mIsMoreViewVisible;
    private int mNoMoreTextColorId;
    private View.OnClickListener mOnClickListener;
    private ProgressBar mProgressBar;
    private View mRoot;
    private int mSkinType;
    private int mTextColor;
    private float mTextSize;
    private TextView mTextView;
    private LinearLayout mTopExtraView;

    /* loaded from: classes4.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public String getEndText() {
        return this.endText;
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.mEmpty = null;
        this.mEmptyBgColorId = 0;
        this.endText = null;
        this.mContainer = null;
        this.mTextColor = 0;
        this.mNoMoreTextColorId = a.d.sdk_cp_cont_e;
        this.lineColor = a.d.sdk_cp_bg_line_b;
        this.lineView = null;
        this.mTopExtraView = null;
        this.mIsMoreViewVisible = true;
        this.mSkinType = -1;
        this.mTextSize = 11.0f;
        this.mContainerBackgroundColorResId = 0;
        this.mContext = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
    public View createView() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(a.h.sdk_new_pb_list_more, (ViewGroup) null);
        this.mContainer = (LinearLayout) this.mRoot.findViewById(a.g.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(a.g.pb_more_text);
        this.mTextView.setTextSize(this.mTextSize);
        if (this.mIsMoreViewVisible) {
            this.mContainer.setVisibility(0);
        } else {
            this.mContainer.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(a.g.progress);
        this.lineView = (ImageView) this.mRoot.findViewById(a.g.pb_more_view_top_line);
        this.mEmpty = this.mRoot.findViewById(a.g.empty_view);
        this.mTopExtraView = (LinearLayout) this.mRoot.findViewById(a.g.pb_more_top_extra_view);
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
        layoutParams.height = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds1);
        this.lineView.setLayoutParams(layoutParams);
    }

    public void setDividerLineHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lineView.getLayoutParams();
        layoutParams.height = i;
        this.lineView.setLayoutParams(layoutParams);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, BdUtilHelper.getDimens(this.mContext, i));
    }

    public void setmTextSize(float f) {
        this.mTextSize = f;
    }

    public LinearLayout getTopExtraView() {
        return this.mTopExtraView;
    }

    public void setTopExtraViewVisible() {
        if (this.mTopExtraView.getVisibility() != 0) {
            this.mTopExtraView.setVisibility(0);
        }
    }

    public void setTopExtraViewGone() {
        if (8 != this.mTopExtraView.getVisibility()) {
            this.mTopExtraView.setVisibility(8);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(a.i.sdk_loading));
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void endLoadData() {
        this.mProgressBar.setVisibility(8);
        if (this.endText != null) {
            this.mTextView.setText(this.endText);
        } else {
            this.mTextView.setText(this.mContext.getText(a.i.sdk_pb_load_more));
        }
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void endLoadDataWithNoMore() {
        setText(this.mContext.getResources().getString(a.i.sdk_list_no_more));
        endLoadData();
    }

    public void endLoadDataWithNoMore(String str) {
        setText(str);
        endLoadData();
    }

    public void showEndLoadData() {
        this.mTextView.setVisibility(0);
        this.mContainer.setVisibility(0);
        endLoadData();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(a.i.sdk_loading));
    }

    public void setBackground(int i) {
        SkinManager.setBackgroundResource(this.mContainer, i);
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContainer.getLayoutParams());
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        this.endText = str;
        this.mTextView.setText(str);
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

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
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
        boolean z = false;
        if (this.mSkinType != -1) {
            i = this.mSkinType;
        }
        String charSequence = this.mTextView.getText().toString();
        if (charSequence.equals(this.mContext.getText(a.i.sdk_pb_load_more))) {
            color = SkinManager.getColor(i, a.d.sdk_common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(a.i.sdk_loading))) {
            color = SkinManager.getColor(i, a.d.sdk_common_color_10039);
        } else if (charSequence.equals(this.mContext.getText(a.i.sdk_list_no_more)) || charSequence.equals(this.mContext.getText(a.i.sdk_list_has_no_more))) {
            color = SkinManager.getColor(i, a.d.sdk_common_color_10005);
            z = true;
        } else if (charSequence.equals(this.mContext.getText(a.i.sdk_list_no_more_new))) {
            color = SkinManager.getColor(i, a.d.sdk_cp_cont_e);
        } else {
            color = charSequence.equals(this.mContext.getText(a.i.sdk_list_click_load_more)) ? SkinManager.getColor(i, a.d.sdk_cp_cont_d) : 0;
        }
        if (z && this.mNoMoreTextColorId != 0) {
            color = SkinManager.getColor(i, this.mNoMoreTextColorId);
        }
        if (color == 0 && this.mTextColor != 0 && !z) {
            color = this.mTextColor;
        }
        if (color != 0) {
            this.mTextView.setTextColor(color);
        }
        SkinManager.setImageResource(this.lineView, this.lineColor, i);
        if (this.mContainerBackgroundColorResId == 0) {
            SkinManager.setBackgroundResource(this.mContainer, a.d.sdk_cp_bg_line_d, i);
        } else if (this.mContainerBackgroundColorResId > 0) {
            SkinManager.setBackgroundResource(this.mContainer, this.mContainerBackgroundColorResId, i);
        }
        if (this.mEmptyBgColorId != 0) {
            SkinManager.setBackgroundColor(this.mEmpty, this.mEmptyBgColorId, i);
        }
    }

    public void showEmptyView(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mEmpty.getLayoutParams());
        layoutParams.height = i;
        this.mEmpty.setLayoutParams(layoutParams);
        this.mEmpty.setVisibility(0);
    }

    public void setEmptyBgColorId(int i) {
        this.mEmptyBgColorId = i;
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
}
