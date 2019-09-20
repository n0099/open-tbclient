package com.baidu.swan.games.subpackage.aps;

import android.content.Context;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.games.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private SwanGameSubPackageAPSInfo blR;
    private Context mContext;

    public a(Context context, SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        super(swanGameSubPackageAPSInfo.key);
        this.mContext = context;
        this.blR = swanGameSubPackageAPSInfo;
    }
}
