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
    public static final int cwn = af.S(45.0f);
    private MenuItemType cwo;
    private a cwp;
    private TextView cwq;
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
        this.cwq = new TextView(context);
        this.cwq.setText(str);
        this.cwq.setTextSize(16.0f);
        this.cwq.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.cwq.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.cwq.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cwn);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.cwq.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.cwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.cwp != null) {
                    OpenLocationMenuItem.this.cwp.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.cwp = aVar;
    }

    public MenuItemType asa() {
        return this.cwo;
    }

    public void a(MenuItemType menuItemType) {
        this.cwo = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView asb() {
        return this.cwq;
    }
}
