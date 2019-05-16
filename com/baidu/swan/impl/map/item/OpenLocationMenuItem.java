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
    public static final int bnD = z.ad(45.0f);
    private MenuItemType bnE;
    private a bnF;
    private TextView bnG;
    private int bnH = z.ad(1.0f);
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
        this.bnG = new TextView(context);
        this.bnG.setText(str);
        this.bnG.setTextSize(16.0f);
        this.bnG.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.bnG.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bnG.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bnD);
        layoutParams.bottomMargin = this.bnH;
        layoutParams.gravity = 17;
        this.bnG.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bnG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bnF != null) {
                    OpenLocationMenuItem.this.bnF.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bnF = aVar;
    }

    public MenuItemType TZ() {
        return this.bnE;
    }

    public void a(MenuItemType menuItemType) {
        this.bnE = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView Ua() {
        return this.bnG;
    }
}
