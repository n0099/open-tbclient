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
    private SwanAppBdActionBar cbE;
    private ListView ccQ;
    private com.baidu.swan.bdprivate.address.a.b ccR;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0318b.invoice_list_bg);
        setOrientation(1);
        this.cbE = new SwanAppBdActionBar(context);
        this.cbE.setBackgroundResource(17170443);
        addView(this.cbE, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.ccQ = new ListView(context);
        this.ccQ.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
        this.ccR = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.ccQ.setAdapter((ListAdapter) this.ccR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.ccQ, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccQ.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.ccQ.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.ccR.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.ccR;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.ccR.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.ccR.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.ccR.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.ccR.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbE;
    }
}
