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
    private c aJA;
    private List<UbcFlowEvent> aJg;
    private String aJv;
    private a.InterfaceC0168a aJz;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0168a interfaceC0168a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.aJz = interfaceC0168a;
        this.aJg = new ArrayList();
        this.aJA = new c();
        this.aJA.mAppId = str;
        this.aJg.add(new UbcFlowEvent("na_aps_start_req"));
        this.aJv = str2;
    }
}
