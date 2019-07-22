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
    public static final int boq = z.ad(45.0f);
    private MenuItemType bor;
    private a bos;
    private TextView bot;
    private int bou = z.ad(1.0f);
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
        this.bot = new TextView(context);
        this.bot.setText(str);
        this.bot.setTextSize(16.0f);
        this.bot.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.bot.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bot.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, boq);
        layoutParams.bottomMargin = this.bou;
        layoutParams.gravity = 17;
        this.bot.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bos != null) {
                    OpenLocationMenuItem.this.bos.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bos = aVar;
    }

    public MenuItemType UR() {
        return this.bor;
    }

    public void a(MenuItemType menuItemType) {
        this.bor = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView US() {
        return this.bot;
    }
}
