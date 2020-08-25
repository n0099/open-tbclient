package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class OpenLocationMenuItem {
    public static final int dBi = ah.H(45.0f);
    private MenuItemType dBj;
    private a dBk;
    private TextView dBl;
    private int mMarginBottom = ah.H(1.0f);
    private String mTitle;

    /* loaded from: classes19.dex */
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

    /* loaded from: classes19.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.dBl = new TextView(context);
        this.dBl.setText(str);
        this.dBl.setTextSize(16.0f);
        this.dBl.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dBl.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dBl.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dBi);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dBl.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dBk != null) {
                    OpenLocationMenuItem.this.dBk.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dBk = aVar;
    }

    public MenuItemType aRT() {
        return this.dBj;
    }

    public void a(MenuItemType menuItemType) {
        this.dBj = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aRU() {
        return this.dBl;
    }
}
