package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.b.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class OpenLocationMenuItem {

    /* renamed from: e  reason: collision with root package name */
    public static final int f12618e = h0.f(45.0f);

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f12619a;

    /* renamed from: b  reason: collision with root package name */
    public b f12620b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12621c;

    /* renamed from: d  reason: collision with root package name */
    public int f12622d = h0.f(1.0f);

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OpenLocationMenuItem.this.f12620b != null) {
                OpenLocationMenuItem.this.f12620b.a(OpenLocationMenuItem.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.f12621c = new TextView(context);
        this.f12621c.setText(str);
        this.f12621c.setTextSize(16.0f);
        this.f12621c.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.f12621c.setTextColor(-16777216);
        this.f12621c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f12618e);
        layoutParams.bottomMargin = this.f12622d;
        layoutParams.gravity = 17;
        this.f12621c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f12621c.setOnClickListener(new a());
    }

    public TextView b() {
        return this.f12621c;
    }

    public MenuItemType c() {
        return this.f12619a;
    }

    public void d(b bVar) {
        this.f12620b = bVar;
    }

    public void e(String str) {
    }

    public void f(MenuItemType menuItemType) {
        this.f12619a = menuItemType;
    }
}
