package com.baidu.mapapi.cloud;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.platform.comjni.map.cloud.ICloudCenter;
import com.baidu.platform.comjni.map.cloud.a;
/* loaded from: classes3.dex */
public class CloudManager {
    private static final String a = CloudManager.class.getSimpleName();
    private static CloudManager b;
    private ICloudCenter c;

    private CloudManager() {
    }

    private boolean a(BaseCloudSearchInfo baseCloudSearchInfo) {
        String a2;
        if (baseCloudSearchInfo == null || (a2 = baseCloudSearchInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.c.a(a2);
    }

    public static CloudManager getInstance() {
        if (b == null) {
            b = new CloudManager();
        }
        return b;
    }

    public boolean boundSearch(BoundSearchInfo boundSearchInfo) {
        return a(boundSearchInfo);
    }

    public void destroy() {
        if (this.c != null) {
            this.c = null;
            BMapManager.destroy();
        }
    }

    public boolean detailSearch(DetailSearchInfo detailSearchInfo) {
        String a2;
        if (detailSearchInfo == null || (a2 = detailSearchInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.c.b(a2);
    }

    public void init() {
        if (this.c == null) {
            BMapManager.init();
            this.c = new a();
        }
    }

    public void init(CloudListener cloudListener) {
        if (this.c == null) {
            BMapManager.init();
            this.c = new a();
            this.c.a(cloudListener);
        }
    }

    public boolean localSearch(LocalSearchInfo localSearchInfo) {
        return a(localSearchInfo);
    }

    public boolean nearbySearch(NearbySearchInfo nearbySearchInfo) {
        return a(nearbySearchInfo);
    }

    public void registerListener(CloudListener cloudListener) {
        if (this.c == null) {
            return;
        }
        if (cloudListener == null) {
            throw new BaiduMapSDKException("the CloudListener should not be null.");
        }
        this.c.a(cloudListener);
    }

    public boolean rgcSearch(CloudRgcInfo cloudRgcInfo) {
        String a2;
        if (cloudRgcInfo == null || (a2 = cloudRgcInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.c.c(a2);
    }

    public void unregisterListener() {
        if (this.c == null) {
            return;
        }
        this.c.a((CloudListener) null);
    }
}
