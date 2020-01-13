package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class OpenLocationMenuItem {
    public static final int csj = af.S(45.0f);
    private MenuItemType csk;
    private a csl;
    private TextView csm;
    private int mMarginBottom = af.S(1.0f);
    private String mTitle;

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public interface a {
        void b(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.csm = new TextView(context);
        this.csm.setText(str);
        this.csm.setTextSize(16.0f);
        this.csm.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.csm.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.csm.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, csj);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.csm.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.csm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.csl != null) {
                    OpenLocationMenuItem.this.csl.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.csl = aVar;
    }

    public MenuItemType apL() {
        return this.csk;
    }

    public void a(MenuItemType menuItemType) {
        this.csk = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView apM() {
        return this.csm;
    }
}
