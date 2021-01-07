package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.ao.ah;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class OpenLocationMenuItem {
    public static final int erZ = ah.O(45.0f);
    private MenuItemType esa;
    private a esb;
    private TextView esc;
    private int mMarginBottom = ah.O(1.0f);
    private String mTitle;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.esc = new TextView(context);
        this.esc.setText(str);
        this.esc.setTextSize(16.0f);
        this.esc.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.esc.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.esc.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, erZ);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.esc.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.esc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.esb != null) {
                    OpenLocationMenuItem.this.esb.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.esb = aVar;
    }

    public MenuItemType bez() {
        return this.esa;
    }

    public void a(MenuItemType menuItemType) {
        this.esa = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView beA() {
        return this.esc;
    }
}
