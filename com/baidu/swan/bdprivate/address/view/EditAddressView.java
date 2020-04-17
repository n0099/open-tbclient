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
    private SwanAppBdActionBar cAF;
    private ListView cBQ;
    private com.baidu.swan.bdprivate.address.a.b cBR;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0348b.invoice_list_bg);
        setOrientation(1);
        this.cAF = new SwanAppBdActionBar(context);
        this.cAF.setBackgroundResource(17170443);
        addView(this.cAF, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.cBQ = new ListView(context);
        this.cBQ.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
        this.cBR = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.cBQ.setAdapter((ListAdapter) this.cBR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.cBQ, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.cBQ.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.cBQ.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cBR.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.cBR;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.cBR.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.cBR.p(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.cBR.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.cBR.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cAF;
    }
}
