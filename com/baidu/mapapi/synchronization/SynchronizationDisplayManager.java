package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class SynchronizationDisplayManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7395a = "SynchronizationDisplayManager";

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.a.a f7396b;

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f7396b = new com.baidu.mapsdkplatform.comapi.synchronization.a.a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.g();
        }
    }

    public Marker getCarMarker() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
            return null;
        }
        return aVar.f();
    }

    public Marker getEndPositionMarker() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
            return null;
        }
        return aVar.e();
    }

    public Marker getStartPositionMarker() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
            return null;
        }
        return aVar.d();
    }

    public void onPause() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.b();
        }
    }

    public void onResume() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a();
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a(synchronizationDisplayListener);
        }
    }

    public void release() {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.c();
        }
    }

    public void setDriverPositionFreshFrequency(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.b(i);
        }
    }

    public void setOperatedMapFrozenInterval(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.c(i);
        }
    }

    public void setUnOperatedMapFrozenInterval(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.d(i);
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.b(synchronizationDisplayListener);
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.c(view);
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a(displayOptions);
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.b(view);
        }
    }

    public void updateOrderState(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a(i);
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a(roleOptions);
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f7396b;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7395a, "The implement instance is null");
        } else {
            aVar.a(view);
        }
    }
}
