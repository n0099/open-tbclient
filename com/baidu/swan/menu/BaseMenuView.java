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
import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView bjN;
    private View bjO;
    private final int bjP;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean QZ();

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        View inflate = inflate(context, g.e.aiapp_menu_base_view_layout, this);
        this.mMaskView = inflate.findViewById(g.d.background);
        this.bjN = (TextView) inflate.findViewById(g.d.cancel);
        this.bjO = inflate.findViewById(g.d.divider);
        Resources resources = context.getResources();
        this.bjP = ((int) resources.getDimension(g.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(g.b.aiapp_menu_divider_height));
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
                this.mMaskView.getLayoutParams().height = height + this.bjP;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.bjP;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.mMaskView.getLayoutParams().height = this.bjP + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.bjN.setOnClickListener(onClickListener);
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
                this.mMaskView.setBackgroundColor(resources.getColor(g.a.aiapp_menu_content_bg));
                this.bjO.setBackgroundColor(resources.getColor(g.a.aiapp_menu_split_line_day));
                this.bjN.setBackgroundColor(resources.getColor(g.a.aiapp_menu_cancel_text_color_bg));
                this.bjN.setTextColor(resources.getColorStateList(g.a.aiapp_menu_cancel_text_color_day));
                this.bjO.setAlpha(1.0f);
                this.bjN.setAlpha(1.0f);
                return;
            default:
                return;
        }
    }
}
