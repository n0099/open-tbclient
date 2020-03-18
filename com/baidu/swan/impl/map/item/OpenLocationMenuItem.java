package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class OpenLocationMenuItem {
    public static final int cwy = af.S(45.0f);
    private a cwA;
    private TextView cwB;
    private MenuItemType cwz;
    private int mMarginBottom = af.S(1.0f);
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
        this.cwB = new TextView(context);
        this.cwB.setText(str);
        this.cwB.setTextSize(16.0f);
        this.cwB.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.cwB.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.cwB.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cwy);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.cwB.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.cwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.cwA != null) {
                    OpenLocationMenuItem.this.cwA.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.cwA = aVar;
    }

    public MenuItemType asd() {
        return this.cwz;
    }

    public void a(MenuItemType menuItemType) {
        this.cwz = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView ase() {
        return this.cwB;
    }
}
