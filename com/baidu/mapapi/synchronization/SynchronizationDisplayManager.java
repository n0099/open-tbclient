package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapsdkplatform.comapi.synchronization.a.a;
/* loaded from: classes4.dex */
public class SynchronizationDisplayManager {
    private static final String a = SynchronizationDisplayManager.class.getSimpleName();
    private a b;

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.b = new a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.g();
        }
    }

    public Marker getCarMarker() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            return null;
        }
        return this.b.f();
    }

    public Marker getEndPositionMarker() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            return null;
        }
        return this.b.e();
    }

    public Marker getStartPositionMarker() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            return null;
        }
        return this.b.d();
    }

    public void onPause() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.b();
        }
    }

    public void onResume() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a();
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a(synchronizationDisplayListener);
        }
    }

    public void release() {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.c();
        }
    }

    public void setDriverPositionFreshFrequency(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.b(i);
        }
    }

    public void setOperatedMapFrozenInterval(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.c(i);
        }
    }

    public void setUnOperatedMapFrozenInterval(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.d(i);
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.b(synchronizationDisplayListener);
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.c(view);
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a(displayOptions);
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.b(view);
        }
    }

    public void updateOrderState(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a(i);
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a(roleOptions);
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
        } else {
            this.b.a(view);
        }
    }
}
