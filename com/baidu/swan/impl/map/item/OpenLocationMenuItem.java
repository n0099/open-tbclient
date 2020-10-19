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
    public static final int dPo = ah.J(45.0f);
    private MenuItemType dPp;
    private a dPq;
    private TextView dPr;
    private int mMarginBottom = ah.J(1.0f);
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
        this.dPr = new TextView(context);
        this.dPr.setText(str);
        this.dPr.setTextSize(16.0f);
        this.dPr.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dPr.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dPr.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dPo);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dPr.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dPq != null) {
                    OpenLocationMenuItem.this.dPq.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dPq = aVar;
    }

    public MenuItemType aVo() {
        return this.dPp;
    }

    public void a(MenuItemType menuItemType) {
        this.dPp = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aVp() {
        return this.dPr;
    }
}
