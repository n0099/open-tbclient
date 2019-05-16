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
    private a.InterfaceC0130a apA;
    private c apB;
    private List<UbcFlowEvent> apg;
    private String apw;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0130a interfaceC0130a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.apA = interfaceC0130a;
        this.apg = new ArrayList();
        this.apB = new c();
        this.apB.mAppId = str;
        this.apg.add(new UbcFlowEvent("na_aps_start_req"));
        this.apw = str2;
    }
}
