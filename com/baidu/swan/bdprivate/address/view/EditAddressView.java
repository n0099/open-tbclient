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
    private SwanAppBdActionBar cAL;
    private ListView cBW;
    private com.baidu.swan.bdprivate.address.a.b cBX;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0369b.invoice_list_bg);
        setOrientation(1);
        this.cAL = new SwanAppBdActionBar(context);
        this.cAL.setBackgroundResource(17170443);
        addView(this.cAL, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.cBW = new ListView(context);
        this.cBW.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState());
        this.cBX = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.cBW.setAdapter((ListAdapter) this.cBX);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.cBW, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.cBW.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.cBW.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cBX.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.cBX;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.cBX.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.cBX.p(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.cBX.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.cBX.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cAL;
    }
}
