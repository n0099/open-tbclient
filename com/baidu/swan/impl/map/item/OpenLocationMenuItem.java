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
    public static final int cVu = af.C(45.0f);
    private MenuItemType cVv;
    private a cVw;
    private TextView cVx;
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
        this.cVx = new TextView(context);
        this.cVx.setText(str);
        this.cVx.setTextSize(16.0f);
        this.cVx.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.cVx.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.cVx.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cVu);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.cVx.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.cVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.cVw != null) {
                    OpenLocationMenuItem.this.cVw.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.cVw = aVar;
    }

    public MenuItemType aAo() {
        return this.cVv;
    }

    public void a(MenuItemType menuItemType) {
        this.cVv = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aAp() {
        return this.cVx;
    }
}
