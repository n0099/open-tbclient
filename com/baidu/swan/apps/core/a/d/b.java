package com.baidu.swan.apps.core.a.d;

import android.content.Context;
import com.baidu.swan.apps.core.a.e;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
/* loaded from: classes2.dex */
public class b extends e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SubPackageAPSInfo apK;
    private Context mContext;

    public b(Context context, SubPackageAPSInfo subPackageAPSInfo) {
        super(subPackageAPSInfo.mKey);
        this.mContext = context;
        this.apK = subPackageAPSInfo;
    }
}
