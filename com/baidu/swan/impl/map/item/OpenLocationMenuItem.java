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
    public static final int cVz = af.C(45.0f);
    private MenuItemType cVA;
    private a cVB;
    private TextView cVC;
    private int mMarginBottom = af.C(1.0f);
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
        this.cVC = new TextView(context);
        this.cVC.setText(str);
        this.cVC.setTextSize(16.0f);
        this.cVC.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.cVC.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.cVC.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cVz);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.cVC.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.cVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.cVB != null) {
                    OpenLocationMenuItem.this.cVB.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.cVB = aVar;
    }

    public MenuItemType aAo() {
        return this.cVA;
    }

    public void a(MenuItemType menuItemType) {
        this.cVA = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aAp() {
        return this.cVC;
    }
}
