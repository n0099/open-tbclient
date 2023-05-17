package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CommentRedTipLayout extends LinearLayout implements IFontSizeViewListener {
    public static final String COMMENT_ZERO = "0";
    public static final int STATIC_LEFT_MARGIN = -24;
    public BadgeView mCommentTips;
    public RedTipImageView mCommentsView;
    public View.OnClickListener onClickListener;

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return true;
    }

    public CommentRedTipLayout(Context context) {
        this(context, null);
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0206, (ViewGroup) this, true);
        BadgeView badgeView = (BadgeView) findViewById(R.id.obfuscated_res_0x7f09074d);
        this.mCommentTips = badgeView;
        badgeView.setType(BadgeView.Type.SMALL_TEXT);
        RedTipImageView redTipImageView = (RedTipImageView) findViewById(R.id.obfuscated_res_0x7f090765);
        this.mCommentsView = redTipImageView;
        redTipImageView.setIcon(R.drawable.obfuscated_res_0x7f08050c);
    }

    public void setCommentViewIcon(int i) {
        this.mCommentsView.setIcon(i);
    }

    public void setCommentViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.mCommentsView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        RedTipImageView redTipImageView = this.mCommentsView;
        if (redTipImageView != null) {
            redTipImageView.setIsResponseFontSize(z);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.mCommentsView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.toolbar.CommentRedTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommentRedTipLayout.this.onClickListener.onClick(CommentRedTipLayout.this);
            }
        });
        super.setOnClickListener(onClickListener);
    }

    public CommentRedTipLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentRedTipLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initLayout(context);
    }

    private int getTopMargin() {
        if (FontSizeHelper.getFontSizeType() > 2) {
            return 3;
        }
        return 6;
    }

    public String getCommentTip() {
        BadgeView badgeView = this.mCommentTips;
        if (badgeView != null && badgeView.getText() != null && !TextUtils.isEmpty(this.mCommentTips.getText().toString())) {
            return this.mCommentTips.getText().toString();
        }
        return "";
    }

    public TextView getCommentTips() {
        return this.mCommentTips;
    }

    public RedTipImageView getCommentsView() {
        return this.mCommentsView;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        RedTipImageView redTipImageView = this.mCommentsView;
        if (redTipImageView != null) {
            redTipImageView.onFontSizeChange();
        }
        BadgeView badgeView = this.mCommentTips;
        if (badgeView != null) {
            badgeView.setBadgeMargin(-24, getTopMargin(), 0, 0);
        }
    }

    public CommonToolBar setCommentsStatus(CommonToolBar commonToolBar, ToolBarNewType toolBarNewType, String str) {
        commonToolBar.setSoFa(false);
        if (toolBarNewType == ToolBarNewType.STRING_TIP) {
            if (getVisibility() != 0) {
                return commonToolBar;
            }
            if (!commonToolBar.isCloseComment() && this.mCommentTips != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.equals("0", str)) {
                    if (commonToolBar.isEnableSoFa()) {
                        this.mCommentTips.setText(getResources().getString(R.string.obfuscated_res_0x7f0f047c));
                        this.mCommentTips.setVisibility(0);
                        commonToolBar.setSoFa(true);
                    } else {
                        this.mCommentTips.setVisibility(8);
                    }
                } else {
                    this.mCommentTips.setText(str);
                    this.mCommentTips.setVisibility(0);
                }
                this.mCommentTips.setBadgeMargin(-24, getTopMargin(), 0, 0);
            }
            this.mCommentsView.setNewTip(null, "");
        } else {
            BadgeView badgeView = this.mCommentTips;
            if (badgeView != null) {
                badgeView.setVisibility(8);
            }
            this.mCommentsView.setNewTip(toolBarNewType, str);
        }
        return commonToolBar;
    }
}
