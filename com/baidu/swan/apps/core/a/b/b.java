package com.baidu.swan.apps.core.a.b;

import android.content.Context;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.a.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class b extends e {
    private static final boolean DEBUG = c.DEBUG;
    private List<UbcFlowEvent> aoO;
    private String apd;
    private a.InterfaceC0098a aph;
    private com.baidu.swan.apps.v.b.c api;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0098a interfaceC0098a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.aph = interfaceC0098a;
        this.aoO = new ArrayList();
        this.api = new com.baidu.swan.apps.v.b.c();
        this.api.mAppId = str;
        this.aoO.add(new UbcFlowEvent("na_aps_start_req"));
        this.apd = str2;
    }
}
