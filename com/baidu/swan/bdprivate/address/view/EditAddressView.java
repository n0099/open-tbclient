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
/* loaded from: classes9.dex */
public class EditAddressView extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private SwanAppBdActionBar bXb;
    private ListView bYm;
    private com.baidu.swan.bdprivate.address.a.b bYn;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0306b.invoice_list_bg);
        setOrientation(1);
        this.bXb = new SwanAppBdActionBar(context);
        this.bXb.setBackgroundResource(17170443);
        addView(this.bXb, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.bYm = new ListView(context);
        this.bYm.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
        this.bYn = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.bYm.setAdapter((ListAdapter) this.bYn);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.bYm, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bYm.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.bYm.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bYn.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.bYn;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.bYn.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.bYn.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.bYn.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.bYn.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.bXb;
    }
}
