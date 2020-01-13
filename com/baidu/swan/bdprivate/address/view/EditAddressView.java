package com.baidu.swan.bdprivate.address.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.swan.apps.b;
import com.baidu.swan.bdprivate.address.a.b;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class EditAddressView extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppBdActionBar bXn;
    private ListView bYy;
    private com.baidu.swan.bdprivate.address.a.b bYz;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0308b.invoice_list_bg);
        setOrientation(1);
        this.bXn = new SwanAppBdActionBar(context);
        this.bXn.setBackgroundResource(17170443);
        addView(this.bXn, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.bYy = new ListView(context);
        this.bYy.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState());
        this.bYz = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.bYy.setAdapter((ListAdapter) this.bYz);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.bYy, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bYy.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.bYy.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bYz.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.bYz;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.bYz.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.bYz.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.bYz.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.bYz.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.bXn;
    }
}
