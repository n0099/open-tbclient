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
    private List<UbcFlowEvent> aoT;
    private String api;
    private a.InterfaceC0127a apm;
    private c apn;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0127a interfaceC0127a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.apm = interfaceC0127a;
        this.aoT = new ArrayList();
        this.apn = new c();
        this.apn.mAppId = str;
        this.aoT.add(new UbcFlowEvent("na_aps_start_req"));
        this.api = str2;
    }
}
