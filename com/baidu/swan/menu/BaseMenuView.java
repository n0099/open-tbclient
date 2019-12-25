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
/* loaded from: classes9.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView cun;
    private View cuo;
    private final int cup;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean aqc();

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
        this.cun = (TextView) inflate.findViewById(g.d.cancel);
        this.cuo = inflate.findViewById(g.d.divider);
        Resources resources = context.getResources();
        this.cup = ((int) resources.getDimension(g.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(g.b.aiapp_menu_divider_height));
    }

    View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.cup;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.cup;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hV(int i) {
        this.mMaskView.getLayoutParams().height = this.cup + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.cun.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getContentView() {
        return this.mContentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqd() {
        Resources resources = getResources();
        this.mMaskView.setBackground(resources.getDrawable(g.c.swan_common_menu_content_bg));
        this.cuo.setBackgroundColor(resources.getColor(g.a.aiapp_menu_split_line_day));
        this.cun.setBackgroundColor(resources.getColor(g.a.aiapp_menu_cancel_text_color_bg));
        this.cun.setTextColor(resources.getColorStateList(g.a.aiapp_menu_cancel_text_color_day));
        this.cuo.setAlpha(1.0f);
        this.cun.setAlpha(1.0f);
    }
}
