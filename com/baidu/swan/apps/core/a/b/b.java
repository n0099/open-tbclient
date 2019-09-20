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
    private a.InterfaceC0141a aqB;
    private c aqC;
    private List<UbcFlowEvent> aqi;
    private String aqx;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0141a interfaceC0141a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.aqB = interfaceC0141a;
        this.aqi = new ArrayList();
        this.aqC = new c();
        this.aqC.mAppId = str;
        this.aqi.add(new UbcFlowEvent("na_aps_start_req"));
        this.aqx = str2;
    }
}
