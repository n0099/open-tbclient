package com.baidu.swan.games.subpackage.aps;

import android.content.Context;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.games.b.a {
    private static final boolean DEBUG = c.DEBUG;
    private SwanGameSubPackageAPSInfo bfq;
    private Context mContext;

    public a(Context context, SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        super(swanGameSubPackageAPSInfo.key);
        this.mContext = context;
        this.bfq = swanGameSubPackageAPSInfo;
    }
}
