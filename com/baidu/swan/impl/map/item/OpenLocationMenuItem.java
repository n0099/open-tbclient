package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.ag;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class OpenLocationMenuItem {
    public static final int dgA = ag.B(45.0f);
    private MenuItemType dgB;
    private a dgC;
    private TextView dgD;
    private int mMarginBottom = ag.B(1.0f);
    private String mTitle;

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.dgD = new TextView(context);
        this.dgD.setText(str);
        this.dgD.setTextSize(16.0f);
        this.dgD.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dgD.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dgD.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dgA);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dgD.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dgD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dgC != null) {
                    OpenLocationMenuItem.this.dgC.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dgC = aVar;
    }

    public MenuItemType aEg() {
        return this.dgB;
    }

    public void a(MenuItemType menuItemType) {
        this.dgB = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aEh() {
        return this.dgD;
    }
}
