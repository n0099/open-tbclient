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
    private String aJN;
    private a.InterfaceC0173a aJR;
    private c aJS;
    private List<UbcFlowEvent> aJy;
    private String mAppId;
    private Context mContext;

    public b(Context context, String str, a.InterfaceC0173a interfaceC0173a, String str2) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.aJR = interfaceC0173a;
        this.aJy = new ArrayList();
        this.aJS = new c();
        this.aJS.mAppId = str;
        this.aJy.add(new UbcFlowEvent("na_aps_start_req"));
        this.aJN = str2;
    }
}
