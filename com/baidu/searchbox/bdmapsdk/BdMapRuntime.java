package com.baidu.searchbox.bdmapsdk;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.bdmapsdk.ioc.IBdMapContext;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class BdMapRuntime {
    private static final String MODULE_TAG = "BdMapRuntime";

    static {
        SDKInitializer.initialize(AppRuntime.getAppContext());
        SDKInitializer.setCoordType(CoordType.GCJ02);
        SDKInitializer.setHttpsEnable(true);
    }

    public static IBdMapContext getBdMapContext() {
        return null;
    }

    public static void makeSureMapSDKInit() {
    }
}
