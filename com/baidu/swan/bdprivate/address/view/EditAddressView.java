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
    private SwanAppBdActionBar cbt;
    private ListView ccF;
    private com.baidu.swan.bdprivate.address.a.b ccG;

    public EditAddressView(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.swan.bdprivate.address.c.b bVar) {
        setBackgroundResource(b.C0318b.invoice_list_bg);
        setOrientation(1);
        this.cbt = new SwanAppBdActionBar(context);
        this.cbt.setBackgroundResource(17170443);
        addView(this.cbt, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelOffset(b.c.aiapps_normal_base_action_bar_height)));
        this.ccF = new ListView(context);
        this.ccF.setDividerHeight(0);
        onNightModeChanged(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        this.ccG = new com.baidu.swan.bdprivate.address.a.b(context);
        g(bVar);
        this.ccF.setAdapter((ListAdapter) this.ccG);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 1, 0, 0);
        addView(this.ccF, layoutParams);
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccF.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.ccF.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.ccG.getDeliveryEditData();
    }

    public com.baidu.swan.bdprivate.address.a.b getEditAdapter() {
        return this.ccG;
    }

    public void g(com.baidu.swan.bdprivate.address.c.b bVar) {
        if (bVar != null) {
            this.ccG.setData(com.baidu.swan.bdprivate.address.c.b.e(bVar));
            this.ccG.r(com.baidu.swan.bdprivate.address.c.b.b(bVar));
            this.ccG.s(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.ccG.setDeliveryEditChangedListener(aVar);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbt;
    }
}
