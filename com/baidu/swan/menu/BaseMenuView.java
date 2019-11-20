package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.menu.f;
/* loaded from: classes2.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView bIV;
    private View bIW;
    private final int bIX;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean aau();

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        View inflate = inflate(context, f.e.aiapp_menu_base_view_layout, this);
        this.mMaskView = inflate.findViewById(f.d.background);
        this.bIV = (TextView) inflate.findViewById(f.d.cancel);
        this.bIW = inflate.findViewById(f.d.divider);
        Resources resources = context.getResources();
        this.bIX = ((int) resources.getDimension(f.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(f.b.aiapp_menu_divider_height));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.bIX;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.bIX;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gq(int i) {
        this.mMaskView.getLayoutParams().height = this.bIX + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.bIV.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getContentView() {
        return this.mContentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        Resources resources = getResources();
        switch (swanAppMenuMode) {
            case NORMAL:
                this.mMaskView.setBackground(resources.getDrawable(f.c.swan_common_menu_content_bg));
                this.bIW.setBackgroundColor(resources.getColor(f.a.aiapp_menu_split_line_day));
                this.bIV.setBackgroundColor(resources.getColor(f.a.aiapp_menu_cancel_text_color_bg));
                this.bIV.setTextColor(resources.getColorStateList(f.a.aiapp_menu_cancel_text_color_day));
                this.bIW.setAlpha(1.0f);
                this.bIV.setAlpha(1.0f);
                return;
            default:
                return;
        }
    }
}
