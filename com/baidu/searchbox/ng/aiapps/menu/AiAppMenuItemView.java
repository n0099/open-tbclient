package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
class AiAppMenuItemView extends RelativeLayout {
    private Context mContext;
    private ImageView mIconView;
    private int mMenuStyle;
    private TextView mTitleView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AiAppMenuItemView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        setGravity(17);
        LayoutInflater.from(this.mContext).inflate(R.layout.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(R.id.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(R.id.aiapp_menu_item_title);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(AiAppMenuItem aiAppMenuItem) {
        if (aiAppMenuItem != null) {
            setItemView(aiAppMenuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.mMenuStyle = i;
    }

    private void setItemView(AiAppMenuItem aiAppMenuItem) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setSingleLine();
        if (aiAppMenuItem.isEnable()) {
            this.mTitleView.setAlpha(1.0f);
        } else {
            this.mTitleView.setAlpha(0.3f);
        }
        this.mIconView.setEnabled(aiAppMenuItem.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        updateItemUI(aiAppMenuItem);
    }

    private void updateItemUI(AiAppMenuItem aiAppMenuItem) {
        setAlpha(1.0f);
        this.mTitleView.setText(aiAppMenuItem.getTitle(this.mContext));
        Drawable icon = getIcon(aiAppMenuItem);
        if (icon != null) {
            this.mIconView.setImageDrawable(icon);
            this.mIconView.setImageLevel(aiAppMenuItem.getImgLevel());
        }
        this.mTitleView.setTextColor(getResources().getColor(R.color.aiapp_menu_item_text));
    }

    private Drawable getIcon(AiAppMenuItem aiAppMenuItem) {
        return aiAppMenuItem.getIcon(this.mContext);
    }
}
