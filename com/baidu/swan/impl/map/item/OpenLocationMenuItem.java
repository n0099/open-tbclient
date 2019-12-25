package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class OpenLocationMenuItem {
    public static final int crY = af.T(45.0f);
    private MenuItemType crZ;
    private a csa;
    private TextView csb;
    private int mMarginBottom = af.T(1.0f);
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
        this.csb = new TextView(context);
        this.csb.setText(str);
        this.csb.setTextSize(16.0f);
        this.csb.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.csb.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.csb.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, crY);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.csb.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.csb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.csa != null) {
                    OpenLocationMenuItem.this.csa.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.csa = aVar;
    }

    public MenuItemType aps() {
        return this.crZ;
    }

    public void a(MenuItemType menuItemType) {
        this.crZ = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView apt() {
        return this.csb;
    }
}
