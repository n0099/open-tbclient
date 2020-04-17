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
/* loaded from: classes11.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView cXI;
    private View cXJ;
    private final int cXK;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean aAY();

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
        this.cXI = (TextView) inflate.findViewById(g.d.cancel);
        this.cXJ = inflate.findViewById(g.d.divider);
        Resources resources = context.getResources();
        this.cXK = ((int) resources.getDimension(g.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(g.b.aiapp_menu_divider_height));
    }

    View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.cXK;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.cXK;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void it(int i) {
        this.mMaskView.getLayoutParams().height = this.cXK + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.cXI.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getContentView() {
        return this.mContentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAZ() {
        Resources resources = getResources();
        this.mMaskView.setBackground(resources.getDrawable(g.c.swan_common_menu_content_bg));
        this.cXJ.setBackgroundColor(resources.getColor(g.a.aiapp_menu_split_line_day));
        this.cXI.setBackgroundColor(resources.getColor(g.a.aiapp_menu_cancel_text_color_bg));
        this.cXI.setTextColor(resources.getColorStateList(g.a.aiapp_menu_cancel_text_color_day));
        this.cXJ.setAlpha(1.0f);
        this.cXI.setAlpha(1.0f);
    }
}
