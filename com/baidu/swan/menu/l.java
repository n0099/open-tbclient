package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
class l extends RelativeLayout {
    private int bjS;
    private Context mContext;
    private ImageView mIconView;
    private TextView mTitleView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        setGravity(49);
        LayoutInflater.from(this.mContext).inflate(g.e.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(g.d.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(g.d.aiapp_menu_item_title);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(k kVar) {
        if (kVar != null) {
            f(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjS = i;
    }

    private void f(k kVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        if (kVar.isEnable()) {
            this.mTitleView.setAlpha(1.0f);
        } else {
            this.mTitleView.setAlpha(0.3f);
        }
        this.mIconView.setEnabled(kVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        g(kVar);
    }

    private void g(k kVar) {
        setAlpha(1.0f);
        this.mTitleView.setText(kVar.getTitle(this.mContext));
        Drawable h = h(kVar);
        if (h != null) {
            this.mIconView.setImageDrawable(h);
            this.mIconView.setImageLevel(kVar.Rg());
        }
        this.mTitleView.setTextColor(getResources().getColor(g.a.aiapp_menu_item_text));
    }

    private Drawable h(k kVar) {
        return kVar.cy(this.mContext);
    }
}
