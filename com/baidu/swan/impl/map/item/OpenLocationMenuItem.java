package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.ai;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class OpenLocationMenuItem {
    public static final int drg = ai.D(45.0f);
    private MenuItemType drh;
    private a dri;
    private TextView drj;
    private int mMarginBottom = ai.D(1.0f);
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
        this.drj = new TextView(context);
        this.drj.setText(str);
        this.drj.setTextSize(16.0f);
        this.drj.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.drj.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.drj.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, drg);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.drj.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.drj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dri != null) {
                    OpenLocationMenuItem.this.dri.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dri = aVar;
    }

    public MenuItemType aJd() {
        return this.drh;
    }

    public void a(MenuItemType menuItemType) {
        this.drh = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aJe() {
        return this.drj;
    }
}
