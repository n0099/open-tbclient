package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.an.x;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class OpenLocationMenuItem {
    public static final int bhu = x.ad(45.0f);
    private MenuItemType bhv;
    private a bhw;
    private TextView bhx;
    private int bhy = x.ad(1.0f);
    private String mTitle;

    /* loaded from: classes5.dex */
    public enum MenuItemType {
        OPENLOCATION_PATH,
        OPENLOCATION_STREET_VIEW,
        OPENLOCATION_CANCEL,
        OPENLOCATION_BAIDU_MAP,
        OPENLOCATION_GAODE_MAP,
        OPENLOCATION_TENCENT_MAP,
        OPENLOCATION_SOUGOU_MAP,
        OPENLOCATION_GOOGLE_MAP
    }

    /* loaded from: classes5.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.bhx = new TextView(context);
        this.bhx.setText(str);
        this.bhx.setTextSize(16.0f);
        this.bhx.setBackground(context.getResources().getDrawable(d.f.openlocation_bottommenu_itemclick_selector));
        this.bhx.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bhx.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bhu);
        layoutParams.bottomMargin = this.bhy;
        layoutParams.gravity = 17;
        this.bhx.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bhx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bhw != null) {
                    OpenLocationMenuItem.this.bhw.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bhw = aVar;
    }

    public MenuItemType Qp() {
        return this.bhv;
    }

    public void a(MenuItemType menuItemType) {
        this.bhv = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView Qq() {
        return this.bhx;
    }
}
