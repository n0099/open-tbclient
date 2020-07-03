package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.aq.ag;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class OpenLocationMenuItem {
    public static final int dlm = ag.D(45.0f);
    private MenuItemType dln;
    private a dlo;
    private TextView dlp;
    private int mMarginBottom = ag.D(1.0f);
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
        this.dlp = new TextView(context);
        this.dlp.setText(str);
        this.dlp.setTextSize(16.0f);
        this.dlp.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.dlp.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dlp.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dlm);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.dlp.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.dlp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.dlo != null) {
                    OpenLocationMenuItem.this.dlo.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.dlo = aVar;
    }

    public MenuItemType aFm() {
        return this.dln;
    }

    public void a(MenuItemType menuItemType) {
        this.dln = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView aFn() {
        return this.dlp;
    }
}
