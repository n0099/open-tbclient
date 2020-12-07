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
    public static final int eiV = ah.M(45.0f);
    private MenuItemType eiW;
    private a eiX;
    private TextView eiY;
    private int mMarginBottom = ah.M(1.0f);
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
        this.eiY = new TextView(context);
        this.eiY.setText(str);
        this.eiY.setTextSize(16.0f);
        this.eiY.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.eiY.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.eiY.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eiV);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.eiY.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.eiY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.eiX != null) {
                    OpenLocationMenuItem.this.eiX.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.eiX = aVar;
    }

    public MenuItemType bcg() {
        return this.eiW;
    }

    public void a(MenuItemType menuItemType) {
        this.eiW = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView bch() {
        return this.eiY;
    }
}
