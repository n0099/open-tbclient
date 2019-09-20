package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.an.z;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class OpenLocationMenuItem {
    public static final int boO = z.ad(45.0f);
    private MenuItemType boP;
    private a boQ;
    private TextView boR;
    private int boS = z.ad(1.0f);
    private String mTitle;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.boR = new TextView(context);
        this.boR.setText(str);
        this.boR.setTextSize(16.0f);
        this.boR.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.boR.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.boR.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, boO);
        layoutParams.bottomMargin = this.boS;
        layoutParams.gravity = 17;
        this.boR.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.boR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.boQ != null) {
                    OpenLocationMenuItem.this.boQ.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.boQ = aVar;
    }

    public MenuItemType UV() {
        return this.boP;
    }

    public void a(MenuItemType menuItemType) {
        this.boP = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView UW() {
        return this.boR;
    }
}
