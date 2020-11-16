package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class OpenLocationMenuItem {
    public static final int ebU = ah.M(45.0f);
    private MenuItemType ebV;
    private a ebW;
    private TextView ebX;
    private int mMarginBottom = ah.M(1.0f);
    private String mTitle;

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.ebX = new TextView(context);
        this.ebX.setText(str);
        this.ebX.setTextSize(16.0f);
        this.ebX.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.ebX.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.ebX.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ebU);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.ebX.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.ebX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.ebW != null) {
                    OpenLocationMenuItem.this.ebW.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.ebW = aVar;
    }

    public MenuItemType aZb() {
        return this.ebV;
    }

    public void a(MenuItemType menuItemType) {
        this.ebV = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aZc() {
        return this.ebX;
    }
}
