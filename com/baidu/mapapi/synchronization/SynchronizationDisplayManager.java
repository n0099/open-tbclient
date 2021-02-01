package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes4.dex */
public class SynchronizationDisplayManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2944a = SynchronizationDisplayManager.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.synchronization.a.a f2945b;

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f2945b = new com.baidu.mapsdkplatform.comapi.synchronization.a.a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.g();
        }
    }

    public Marker getCarMarker() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
            return null;
        }
        return this.f2945b.f();
    }

    public Marker getEndPositionMarker() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
            return null;
        }
        return this.f2945b.e();
    }

    public Marker getStartPositionMarker() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
            return null;
        }
        return this.f2945b.d();
    }

    public void onPause() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.b();
        }
    }

    public void onResume() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a();
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a(synchronizationDisplayListener);
        }
    }

    public void release() {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.c();
        }
    }

    public void setDriverPositionFreshFrequency(int i) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.b(i);
        }
    }

    public void setOperatedMapFrozenInterval(int i) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.c(i);
        }
    }

    public void setUnOperatedMapFrozenInterval(int i) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.d(i);
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.b(synchronizationDisplayListener);
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.c(view);
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a(displayOptions);
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.b(view);
        }
    }

    public void updateOrderState(int i) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a(i);
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a(roleOptions);
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        if (this.f2945b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2944a, "The implement instance is null");
        } else {
            this.f2945b.a(view);
        }
    }
}
