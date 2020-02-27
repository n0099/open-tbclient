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
    private final int cyA;
    private TextView cyy;
    private View cyz;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean asJ();

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
        this.cyy = (TextView) inflate.findViewById(g.d.cancel);
        this.cyz = inflate.findViewById(g.d.divider);
        Resources resources = context.getResources();
        this.cyA = ((int) resources.getDimension(g.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(g.b.aiapp_menu_divider_height));
    }

    View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.cyA;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.cyA;
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void im(int i) {
        this.mMaskView.getLayoutParams().height = this.cyA + i;
        this.mMaskView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClickListener(View.OnClickListener onClickListener) {
        this.cyy.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getContentView() {
        return this.mContentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asK() {
        Resources resources = getResources();
        this.mMaskView.setBackground(resources.getDrawable(g.c.swan_common_menu_content_bg));
        this.cyz.setBackgroundColor(resources.getColor(g.a.aiapp_menu_split_line_day));
        this.cyy.setBackgroundColor(resources.getColor(g.a.aiapp_menu_cancel_text_color_bg));
        this.cyy.setTextColor(resources.getColorStateList(g.a.aiapp_menu_cancel_text_color_day));
        this.cyz.setAlpha(1.0f);
        this.cyy.setAlpha(1.0f);
    }
}
