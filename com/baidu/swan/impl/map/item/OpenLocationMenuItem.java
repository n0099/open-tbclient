package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.ao.ah;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class OpenLocationMenuItem {
    public static final int enk = ah.O(45.0f);
    private MenuItemType enl;
    private a enm;
    private TextView enn;
    private int mMarginBottom = ah.O(1.0f);
    private String mTitle;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.enn = new TextView(context);
        this.enn.setText(str);
        this.enn.setTextSize(16.0f);
        this.enn.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.enn.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.enn.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, enk);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.enn.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.enn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.enm != null) {
                    OpenLocationMenuItem.this.enm.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.enm = aVar;
    }

    public MenuItemType baF() {
        return this.enl;
    }

    public void a(MenuItemType menuItemType) {
        this.enl = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView baG() {
        return this.enn;
    }
}
