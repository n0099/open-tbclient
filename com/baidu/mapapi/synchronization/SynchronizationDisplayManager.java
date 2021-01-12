package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes6.dex */
public class SynchronizationDisplayManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2946a = SynchronizationDisplayManager.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.synchronization.a.a f2947b;

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f2947b = new com.baidu.mapsdkplatform.comapi.synchronization.a.a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.g();
        }
    }

    public Marker getCarMarker() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
            return null;
        }
        return this.f2947b.f();
    }

    public Marker getEndPositionMarker() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
            return null;
        }
        return this.f2947b.e();
    }

    public Marker getStartPositionMarker() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
            return null;
        }
        return this.f2947b.d();
    }

    public void onPause() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.b();
        }
    }

    public void onResume() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a();
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a(synchronizationDisplayListener);
        }
    }

    public void release() {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.c();
        }
    }

    public void setDriverPositionFreshFrequency(int i) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.b(i);
        }
    }

    public void setOperatedMapFrozenInterval(int i) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.c(i);
        }
    }

    public void setUnOperatedMapFrozenInterval(int i) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.d(i);
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.b(synchronizationDisplayListener);
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.c(view);
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a(displayOptions);
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.b(view);
        }
    }

    public void updateOrderState(int i) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a(i);
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a(roleOptions);
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        if (this.f2947b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2946a, "The implement instance is null");
        } else {
            this.f2947b.a(view);
        }
    }
}
