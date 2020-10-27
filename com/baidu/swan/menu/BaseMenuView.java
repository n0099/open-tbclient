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
/* loaded from: classes14.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView dZY;
    private View dZZ;
    private final int eaa;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean azu();

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
        this.dZY = (TextView) inflate.findViewById(g.d.cancel);
        this.dZZ = inflate.findViewById(g.d.divider);
        Resources resources = context.getResources();
        this.eaa = ((int) resources.getDimension(g.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(g.b.aiapp_menu_divider_height));
    }

    View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.eaa;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.eaa;
            addView(view, layoutParams);
        }
    }

    public void mq(int i) {
        this.mMaskView.getLayoutParams().height = this.eaa + i;
        this.mMaskView.requestLayout();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.dZY.setOnClickListener(onClickListener);
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setMode() {
        Resources resources = getResources();
        this.mMaskView.setBackground(resources.getDrawable(g.c.swan_common_menu_content_bg));
        this.dZZ.setBackgroundColor(resources.getColor(g.a.aiapp_menu_split_line_day));
        this.dZY.setBackgroundColor(resources.getColor(g.a.aiapp_menu_cancel_text_color_bg));
        this.dZY.setTextColor(resources.getColorStateList(g.a.aiapp_menu_cancel_text_color_day));
        this.dZZ.setAlpha(1.0f);
        this.dZY.setAlpha(1.0f);
    }
}
