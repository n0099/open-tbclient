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
    public static final int ept = ah.P(45.0f);
    private MenuItemType epu;
    private a epv;
    private TextView epw;
    private int mMarginBottom = ah.P(1.0f);
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
        this.epw = new TextView(context);
        this.epw.setText(str);
        this.epw.setTextSize(16.0f);
        this.epw.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.epw.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.epw.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ept);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.epw.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.epw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.epv != null) {
                    OpenLocationMenuItem.this.epv.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.epv = aVar;
    }

    public MenuItemType baS() {
        return this.epu;
    }

    public void a(MenuItemType menuItemType) {
        this.epu = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView baT() {
        return this.epw;
    }
}
