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
    private TextView bJM;
    private View bJN;
    private final int bJO;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean aaw();

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
        this.bJM = (TextView) inflate.findViewById(f.d.cancel);
        this.bJN = inflate.findViewById(f.d.divider);
        Resources resources = context.getResources();
        this.bJO = ((int) resources.getDimension(f.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(f.b.aiapp_menu_divider_height));
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
                this.mMaskView.getLayoutParams().height = height + this.bJO;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.bJO;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gr(int i) {
        this.mMaskView.getLayoutParams().height = this.bJO + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.bJM.setOnClickListener(onClickListener);
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
                this.bJN.setBackgroundColor(resources.getColor(f.a.aiapp_menu_split_line_day));
                this.bJM.setBackgroundColor(resources.getColor(f.a.aiapp_menu_cancel_text_color_bg));
                this.bJM.setTextColor(resources.getColorStateList(f.a.aiapp_menu_cancel_text_color_day));
                this.bJN.setAlpha(1.0f);
                this.bJM.setAlpha(1.0f);
                return;
            default:
                return;
        }
    }
}
