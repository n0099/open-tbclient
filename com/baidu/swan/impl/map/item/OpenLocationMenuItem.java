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
    public static final int eqU = ah.T(45.0f);
    private MenuItemType eqV;
    private a eqW;
    private TextView eqX;
    private int mMarginBottom = ah.T(1.0f);
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
        this.eqX = new TextView(context);
        this.eqX.setText(str);
        this.eqX.setTextSize(16.0f);
        this.eqX.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.eqX.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.eqX.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eqU);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.eqX.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.eqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.eqW != null) {
                    OpenLocationMenuItem.this.eqW.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.eqW = aVar;
    }

    public MenuItemType baV() {
        return this.eqV;
    }

    public void a(MenuItemType menuItemType) {
        this.eqV = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView baW() {
        return this.eqX;
    }
}
