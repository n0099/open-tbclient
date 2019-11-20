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
    public static final int bGJ = z.S(45.0f);
    private MenuItemType bGK;
    private a bGL;
    private TextView bGM;
    private int bGN = z.S(1.0f);
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
        this.bGM = new TextView(context);
        this.bGM.setText(str);
        this.bGM.setTextSize(16.0f);
        this.bGM.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.bGM.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.bGM.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bGJ);
        layoutParams.bottomMargin = this.bGN;
        layoutParams.gravity = 17;
        this.bGM.setLayoutParams(layoutParams);
        setTitle(str);
        a(menuItemType);
        this.bGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.bGL != null) {
                    OpenLocationMenuItem.this.bGL.b(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void a(a aVar) {
        this.bGL = aVar;
    }

    public MenuItemType ZI() {
        return this.bGK;
    }

    public void a(MenuItemType menuItemType) {
        this.bGK = menuItemType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView ZJ() {
        return this.bGM;
    }
}
