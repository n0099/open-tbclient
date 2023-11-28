package com.baidu.swan.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.yj3;
/* loaded from: classes4.dex */
public class OpenLocationMenuItem {
    public static final int e = yj3.g(45.0f);
    public MenuItemType a;
    public b b;
    public TextView c;
    public int d = yj3.g(1.0f);

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public void e(String str) {
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (OpenLocationMenuItem.this.b != null) {
                OpenLocationMenuItem.this.b.a(OpenLocationMenuItem.this);
            }
        }
    }

    public TextView b() {
        return this.c;
    }

    public MenuItemType c() {
        return this.a;
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.c = new TextView(context);
        this.c.setText(str);
        this.c.setTextSize(16.0f);
        this.c.setBackground(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081157));
        this.c.setTextColor(-16777216);
        this.c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, e);
        layoutParams.bottomMargin = this.d;
        layoutParams.gravity = 17;
        this.c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.c.setOnClickListener(new a());
    }

    public void d(b bVar) {
        this.b = bVar;
    }

    public void f(MenuItemType menuItemType) {
        this.a = menuItemType;
    }
}
