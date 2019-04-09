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
    public static final int bhy = x.ad(45.0f);
    private a bhA;
    private TextView bhB;
    private int bhC = x.ad(1.0f);
    private MenuItemType bhz;
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
        this.bhB = new TextView(context);
        this.bhB.setText(str);
        this.bhB.setTextSize(16.0f);
        this.bhB.setBackground(context.getResources().getDrawable(d.f.openlocation_bottommenu_itemclick_selector));
        this.bhB.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bhB.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bhy);
        layoutParams.bottomMargin = this.bhC;
        layoutParams.gravity = 17;
        this.bhB.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bhB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bhA != null) {
                    OpenLocationMenuItem.this.bhA.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bhA = aVar;
    }

    public MenuItemType Qn() {
        return this.bhz;
    }

    public void a(MenuItemType menuItemType) {
        this.bhz = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView Qo() {
        return this.bhB;
    }
}
