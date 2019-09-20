package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.menu.f;
/* loaded from: classes2.dex */
class k extends RelativeLayout {
    private int brh;
    private Context mContext;
    private ImageView mIconView;
    private TextView mTitleView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        setGravity(49);
        LayoutInflater.from(this.mContext).inflate(f.e.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(f.d.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(f.d.aiapp_menu_item_title);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(j jVar) {
        if (jVar != null) {
            f(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.brh = i;
    }

    private void f(j jVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        if (jVar.isEnable()) {
            this.mTitleView.setAlpha(1.0f);
        } else {
            this.mTitleView.setAlpha(0.3f);
        }
        this.mIconView.setEnabled(jVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        g(jVar);
    }

    private void g(j jVar) {
        setAlpha(1.0f);
        this.mTitleView.setText(jVar.cb(this.mContext));
        Drawable h = h(jVar);
        if (h != null) {
            this.mIconView.setImageDrawable(h);
            this.mIconView.setImageLevel(jVar.VP());
        }
        this.mTitleView.setTextColor(getResources().getColor(f.a.aiapp_menu_item_text));
    }

    private Drawable h(j jVar) {
        return jVar.cc(this.mContext);
    }
}
