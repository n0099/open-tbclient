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
    public static final int cwl = af.S(45.0f);
    private MenuItemType cwm;
    private a cwn;
    private TextView cwo;
    private int mMarginBottom = af.S(1.0f);
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
        this.cwo = new TextView(context);
        this.cwo.setText(str);
        this.cwo.setTextSize(16.0f);
        this.cwo.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.cwo.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.cwo.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cwl);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.cwo.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.cwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.cwn != null) {
                    OpenLocationMenuItem.this.cwn.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.cwn = aVar;
    }

    public MenuItemType arY() {
        return this.cwm;
    }

    public void a(MenuItemType menuItemType) {
        this.cwm = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView arZ() {
        return this.cwo;
    }
}
