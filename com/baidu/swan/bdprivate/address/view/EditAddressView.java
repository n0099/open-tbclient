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
/* loaded from: classes11.dex */
public class EditAddressView extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppBdActionBar cbq;
    private ListView ccD;
    private com.baidu.swan.bdprivate.address.a.b ccE;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0318b.invoice_list_bg);
        setOrientation(1);
        this.cbq = new SwanAppBdActionBar(context);
        this.cbq.setBackgroundResource(17170443);
        addView(this.cbq, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.ccD = new ListView(context);
        this.ccD.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
        this.ccE = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.ccD.setAdapter((ListAdapter) this.ccE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.ccD, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccD.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.ccD.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.ccE.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.ccE;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.ccE.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.ccE.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.ccE.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.ccE.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbq;
    }
}
