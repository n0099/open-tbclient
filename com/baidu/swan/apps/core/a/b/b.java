package com.baidu.swan.apps.core.a.b;

import android.content.Context;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.a.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.v.b.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class b extends e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private List<UbcFlowEvent> aoU;
    private String apj;
    private a.InterfaceC0127a apn;
    private c apo;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0127a interfaceC0127a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.apn = interfaceC0127a;
        this.aoU = new ArrayList();
        this.apo = new c();
        this.apo.mAppId = str;
        this.aoU.add(new UbcFlowEvent("na_aps_start_req"));
        this.apj = str2;
    }
}
