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
    public static final int bhx = x.ad(45.0f);
    private TextView bhA;
    private int bhB = x.ad(1.0f);
    private MenuItemType bhy;
    private a bhz;
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
        this.bhA = new TextView(context);
        this.bhA.setText(str);
        this.bhA.setTextSize(16.0f);
        this.bhA.setBackground(context.getResources().getDrawable(d.f.openlocation_bottommenu_itemclick_selector));
        this.bhA.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bhA.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bhx);
        layoutParams.bottomMargin = this.bhB;
        layoutParams.gravity = 17;
        this.bhA.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bhz != null) {
                    OpenLocationMenuItem.this.bhz.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bhz = aVar;
    }

    public MenuItemType Qn() {
        return this.bhy;
    }

    public void a(MenuItemType menuItemType) {
        this.bhy = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView Qo() {
        return this.bhA;
    }
}
