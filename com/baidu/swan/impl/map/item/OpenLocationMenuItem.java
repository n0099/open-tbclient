package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.ap.ah;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class OpenLocationMenuItem {
    public static final int dDn = ah.H(45.0f);
    private MenuItemType dDo;
    private a dDp;
    private TextView dDq;
    private int mMarginBottom = ah.H(1.0f);
    private String mTitle;

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.dDq = new TextView(context);
        this.dDq.setText(str);
        this.dDq.setTextSize(16.0f);
        this.dDq.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dDq.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dDq.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dDn);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dDq.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dDp != null) {
                    OpenLocationMenuItem.this.dDp.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dDp = aVar;
    }

    public MenuItemType aSF() {
        return this.dDo;
    }

    public void a(MenuItemType menuItemType) {
        this.dDo = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aSG() {
        return this.dDq;
    }
}
