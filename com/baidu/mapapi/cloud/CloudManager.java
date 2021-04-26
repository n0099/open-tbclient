package com.baidu.mapapi.cloud;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.platform.comjni.map.cloud.ICloudCenter;
import com.baidu.platform.comjni.map.cloud.a;
/* loaded from: classes2.dex */
public class CloudManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7029a = "CloudManager";

    /* renamed from: b  reason: collision with root package name */
    public static CloudManager f7030b;

    /* renamed from: c  reason: collision with root package name */
    public ICloudCenter f7031c;

    private boolean a(BaseCloudSearchInfo baseCloudSearchInfo) {
        String a2;
        if (baseCloudSearchInfo == null || (a2 = baseCloudSearchInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.f7031c.a(a2);
    }

    public static CloudManager getInstance() {
        if (f7030b == null) {
            f7030b = new CloudManager();
        }
        return f7030b;
    }

    public boolean boundSearch(BoundSearchInfo boundSearchInfo) {
        return a(boundSearchInfo);
    }

    public void destroy() {
        if (this.f7031c != null) {
            this.f7031c = null;
            BMapManager.destroy();
        }
    }

    public boolean detailSearch(DetailSearchInfo detailSearchInfo) {
        String a2;
        if (detailSearchInfo == null || (a2 = detailSearchInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.f7031c.b(a2);
    }

    public void init() {
        if (this.f7031c == null) {
            BMapManager.init();
            this.f7031c = new a();
        }
    }

    public void init(CloudListener cloudListener) {
        if (this.f7031c == null) {
            BMapManager.init();
            a aVar = new a();
            this.f7031c = aVar;
            aVar.a(cloudListener);
        }
    }

    public boolean localSearch(LocalSearchInfo localSearchInfo) {
        return a(localSearchInfo);
    }

    public boolean nearbySearch(NearbySearchInfo nearbySearchInfo) {
        return a(nearbySearchInfo);
    }

    public void registerListener(CloudListener cloudListener) {
        ICloudCenter iCloudCenter = this.f7031c;
        if (iCloudCenter == null) {
            return;
        }
        if (cloudListener == null) {
            throw new BaiduMapSDKException("the CloudListener should not be null.");
        }
        iCloudCenter.a(cloudListener);
    }

    public boolean rgcSearch(CloudRgcInfo cloudRgcInfo) {
        String a2;
        if (cloudRgcInfo == null || (a2 = cloudRgcInfo.a()) == null || a2.equals("")) {
            return false;
        }
        return this.f7031c.c(a2);
    }

    public void unregisterListener() {
        ICloudCenter iCloudCenter = this.f7031c;
        if (iCloudCenter == null) {
            return;
        }
        iCloudCenter.a((CloudListener) null);
    }
}
