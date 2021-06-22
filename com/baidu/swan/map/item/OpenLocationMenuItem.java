package com.baidu.swan.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.m0.a.v2.n0;
import d.a.m0.j.d;
/* loaded from: classes3.dex */
public class OpenLocationMenuItem {

    /* renamed from: e  reason: collision with root package name */
    public static final int f11903e = n0.g(45.0f);

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f11904a;

    /* renamed from: b  reason: collision with root package name */
    public b f11905b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11906c;

    /* renamed from: d  reason: collision with root package name */
    public int f11907d = n0.g(1.0f);

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
            if (OpenLocationMenuItem.this.f11905b != null) {
                OpenLocationMenuItem.this.f11905b.a(OpenLocationMenuItem.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.f11906c = new TextView(context);
        this.f11906c.setText(str);
        this.f11906c.setTextSize(16.0f);
        this.f11906c.setBackground(context.getResources().getDrawable(d.openlocation_bottommenu_itemclick_selector));
        this.f11906c.setTextColor(-16777216);
        this.f11906c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f11903e);
        layoutParams.bottomMargin = this.f11907d;
        layoutParams.gravity = 17;
        this.f11906c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f11906c.setOnClickListener(new a());
    }

    public TextView b() {
        return this.f11906c;
    }

    public MenuItemType c() {
        return this.f11904a;
    }

    public void d(b bVar) {
        this.f11905b = bVar;
    }

    public void e(String str) {
    }

    public void f(MenuItemType menuItemType) {
        this.f11904a = menuItemType;
    }
}
