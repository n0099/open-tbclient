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
    public static final int bHA = z.S(45.0f);
    private MenuItemType bHB;
    private a bHC;
    private TextView bHD;
    private int bHE = z.S(1.0f);
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
        this.bHD = new TextView(context);
        this.bHD.setText(str);
        this.bHD.setTextSize(16.0f);
        this.bHD.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.bHD.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bHD.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bHA);
        layoutParams.bottomMargin = this.bHE;
        layoutParams.gravity = 17;
        this.bHD.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bHC != null) {
                    OpenLocationMenuItem.this.bHC.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bHC = aVar;
    }

    public MenuItemType ZK() {
        return this.bHB;
    }

    public void a(MenuItemType menuItemType) {
        this.bHB = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView ZL() {
        return this.bHD;
    }
}
