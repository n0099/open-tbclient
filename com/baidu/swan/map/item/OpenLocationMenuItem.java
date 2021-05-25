package com.baidu.swan.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.l0.a.v2.n0;
import d.a.l0.j.d;
/* loaded from: classes3.dex */
public class OpenLocationMenuItem {

    /* renamed from: e  reason: collision with root package name */
    public static final int f11759e = n0.g(45.0f);

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f11760a;

    /* renamed from: b  reason: collision with root package name */
    public b f11761b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11762c;

    /* renamed from: d  reason: collision with root package name */
    public int f11763d = n0.g(1.0f);

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
            if (OpenLocationMenuItem.this.f11761b != null) {
                OpenLocationMenuItem.this.f11761b.a(OpenLocationMenuItem.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.f11762c = new TextView(context);
        this.f11762c.setText(str);
        this.f11762c.setTextSize(16.0f);
        this.f11762c.setBackground(context.getResources().getDrawable(d.openlocation_bottommenu_itemclick_selector));
        this.f11762c.setTextColor(-16777216);
        this.f11762c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f11759e);
        layoutParams.bottomMargin = this.f11763d;
        layoutParams.gravity = 17;
        this.f11762c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f11762c.setOnClickListener(new a());
    }

    public TextView b() {
        return this.f11762c;
    }

    public MenuItemType c() {
        return this.f11760a;
    }

    public void d(b bVar) {
        this.f11761b = bVar;
    }

    public void e(String str) {
    }

    public void f(MenuItemType menuItemType) {
        this.f11760a = menuItemType;
    }
}
