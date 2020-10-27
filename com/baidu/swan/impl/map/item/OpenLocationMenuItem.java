package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class OpenLocationMenuItem {
    public static final int dXL = ah.L(45.0f);
    private MenuItemType dXM;
    private a dXN;
    private TextView dXO;
    private int mMarginBottom = ah.L(1.0f);
    private String mTitle;

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.dXO = new TextView(context);
        this.dXO.setText(str);
        this.dXO.setTextSize(16.0f);
        this.dXO.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dXO.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dXO.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dXL);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dXO.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dXO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dXN != null) {
                    OpenLocationMenuItem.this.dXN.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dXN = aVar;
    }

    public MenuItemType aXi() {
        return this.dXM;
    }

    public void a(MenuItemType menuItemType) {
        this.dXM = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aXj() {
        return this.dXO;
    }
}
