package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView mCancelView;
    private final int mContentBottomMargin;
    private View mContentView;
    protected Context mContext;
    private View mDividerView;
    private View mMaskView;

    public abstract boolean isHighMenu();

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        View inflate = inflate(context, R.layout.aiapp_menu_base_view_layout, this);
        this.mMaskView = inflate.findViewById(R.id.background);
        this.mCancelView = (TextView) inflate.findViewById(R.id.cancel);
        this.mDividerView = inflate.findViewById(R.id.divider);
        Resources resources = context.getResources();
        this.mContentBottomMargin = ((int) resources.getDimension(R.dimen.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(R.dimen.aiapp_menu_divider_height));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.mContentBottomMargin;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.mContentBottomMargin;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustBgHeight(int i) {
        this.mMaskView.getLayoutParams().height = this.mContentBottomMargin + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mCancelView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getContentView() {
        return this.mContentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(AiAppMenuMode aiAppMenuMode) {
        Resources resources = getResources();
        switch (aiAppMenuMode) {
            case NORMAL:
                this.mMaskView.setBackgroundColor(resources.getColor(R.color.aiapp_menu_content_bg));
                this.mDividerView.setBackgroundColor(resources.getColor(R.color.aiapp_menu_split_line_day));
                this.mCancelView.setBackgroundColor(resources.getColor(R.color.aiapp_menu_cancel_text_color_bg));
                this.mCancelView.setTextColor(resources.getColorStateList(R.color.aiapp_menu_cancel_text_color_day));
                this.mDividerView.setAlpha(1.0f);
                this.mCancelView.setAlpha(1.0f);
                return;
            default:
                return;
        }
    }
}
