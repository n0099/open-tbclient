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
    private List<UbcFlowEvent> apK;
    private String apZ;
    private a.InterfaceC0127a aqd;
    private c aqe;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0127a interfaceC0127a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.aqd = interfaceC0127a;
        this.apK = new ArrayList();
        this.aqe = new c();
        this.aqe.mAppId = str;
        this.apK.add(new UbcFlowEvent("na_aps_start_req"));
        this.apZ = str2;
    }
}
