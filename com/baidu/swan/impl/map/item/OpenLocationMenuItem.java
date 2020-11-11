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
    public static final int edC = ah.N(45.0f);
    private MenuItemType edD;
    private a edE;
    private TextView edF;
    private int mMarginBottom = ah.N(1.0f);
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
        this.edF = new TextView(context);
        this.edF.setText(str);
        this.edF.setTextSize(16.0f);
        this.edF.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.edF.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.edF.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, edC);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.edF.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.edF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.edE != null) {
                    OpenLocationMenuItem.this.edE.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.edE = aVar;
    }

    public MenuItemType aZI() {
        return this.edD;
    }

    public void a(MenuItemType menuItemType) {
        this.edD = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aZJ() {
        return this.edF;
    }
}
