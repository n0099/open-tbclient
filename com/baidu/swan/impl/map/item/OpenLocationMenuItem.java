package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.b.g0.a.i2.h0;
/* loaded from: classes3.dex */
public class OpenLocationMenuItem {

    /* renamed from: e  reason: collision with root package name */
    public static final int f12610e = h0.f(45.0f);

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f12611a;

    /* renamed from: b  reason: collision with root package name */
    public b f12612b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12613c;

    /* renamed from: d  reason: collision with root package name */
    public int f12614d = h0.f(1.0f);

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
            if (OpenLocationMenuItem.this.f12612b != null) {
                OpenLocationMenuItem.this.f12612b.a(OpenLocationMenuItem.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.f12613c = new TextView(context);
        this.f12613c.setText(str);
        this.f12613c.setTextSize(16.0f);
        this.f12613c.setBackground(context.getResources().getDrawable(R.drawable.openlocation_bottommenu_itemclick_selector));
        this.f12613c.setTextColor(-16777216);
        this.f12613c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f12610e);
        layoutParams.bottomMargin = this.f12614d;
        layoutParams.gravity = 17;
        this.f12613c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f12613c.setOnClickListener(new a());
    }

    public TextView b() {
        return this.f12613c;
    }

    public MenuItemType c() {
        return this.f12611a;
    }

    public void d(b bVar) {
        this.f12612b = bVar;
    }

    public void e(String str) {
    }

    public void f(MenuItemType menuItemType) {
        this.f12611a = menuItemType;
    }
}
