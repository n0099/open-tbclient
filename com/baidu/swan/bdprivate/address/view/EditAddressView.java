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
    private SwanAppBdActionBar cbr;
    private ListView ccE;
    private com.baidu.swan.bdprivate.address.a.b ccF;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0318b.invoice_list_bg);
        setOrientation(1);
        this.cbr = new SwanAppBdActionBar(context);
        this.cbr.setBackgroundResource(17170443);
        addView(this.cbr, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.ccE = new ListView(context);
        this.ccE.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        this.ccF = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.ccE.setAdapter((ListAdapter) this.ccF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.ccE, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccE.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.ccE.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.ccF.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.ccF;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.ccF.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.ccF.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.ccF.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.ccF.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbr;
    }
}
