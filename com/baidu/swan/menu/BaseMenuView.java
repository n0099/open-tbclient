package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public abstract class BaseMenuView extends FrameLayout {
    private TextView erH;
    private View erI;
    private final int erJ;
    private View mContentView;
    protected Context mContext;
    private View mMaskView;

    public abstract boolean aCs();

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
        this.erH = (TextView) inflate.findViewById(f.d.cancel);
        this.erI = inflate.findViewById(f.d.divider);
        Resources resources = context.getResources();
        this.erJ = ((int) resources.getDimension(f.b.aiapp_menu_cancel_btn_height)) + ((int) resources.getDimension(f.b.aiapp_menu_divider_height));
    }

    View getBgView() {
        return this.mMaskView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (view != null) {
            int height = view.getHeight();
            if (height != 0) {
                this.mMaskView.getLayoutParams().height = height + this.erJ;
            }
            this.mContentView = view;
            layoutParams.bottomMargin = this.erJ;
            addView(view, layoutParams);
        }
    }

    public void lz(int i) {
        this.mMaskView.getLayoutParams().height = this.erJ + i;
        this.mMaskView.requestLayout();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.erH.setOnClickListener(onClickListener);
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setMode() {
        Resources resources = getResources();
        this.mMaskView.setBackground(resources.getDrawable(f.c.swan_common_menu_content_bg));
        this.erI.setBackgroundColor(resources.getColor(f.a.aiapp_menu_split_line_day));
        this.erH.setBackgroundColor(resources.getColor(f.a.aiapp_menu_cancel_text_color_bg));
        this.erH.setTextColor(resources.getColorStateList(f.a.aiapp_menu_cancel_text_color_day));
        this.erI.setAlpha(1.0f);
        this.erH.setAlpha(1.0f);
    }
}
