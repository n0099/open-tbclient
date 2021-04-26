package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class OpenLocationMenuItem {

    /* renamed from: e  reason: collision with root package name */
    public static final int f12516e = h0.f(45.0f);

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f12517a;

    /* renamed from: b  reason: collision with root package name */
    public b f12518b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12519c;

    /* renamed from: d  reason: collision with root package name */
    public int f12520d = h0.f(1.0f);

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
            if (OpenLocationMenuItem.this.f12518b != null) {
                OpenLocationMenuItem.this.f12518b.a(OpenLocationMenuItem.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.f12519c = new TextView(context);
        this.f12519c.setText(str);
        this.f12519c.setTextSize(16.0f);
        this.f12519c.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.f12519c.setTextColor(-16777216);
        this.f12519c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f12516e);
        layoutParams.bottomMargin = this.f12520d;
        layoutParams.gravity = 17;
        this.f12519c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f12519c.setOnClickListener(new a());
    }

    public TextView b() {
        return this.f12519c;
    }

    public MenuItemType c() {
        return this.f12517a;
    }

    public void d(b bVar) {
        this.f12518b = bVar;
    }

    public void e(String str) {
    }

    public void f(MenuItemType menuItemType) {
        this.f12517a = menuItemType;
    }
}
