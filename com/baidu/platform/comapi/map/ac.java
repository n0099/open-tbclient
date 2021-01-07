package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class ac implements com.baidu.platform.comjni.map.basemap.a {

    /* renamed from: a  reason: collision with root package name */
    static final String f4295a = ac.class.getName();

    /* renamed from: b  reason: collision with root package name */
    HashMap<Long, InnerOverlay> f4296b = new HashMap<>();
    AppBaseMap c;

    public ac(AppBaseMap appBaseMap) {
        this.c = null;
        this.c = appBaseMap;
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j, int i) {
        long currentTimeMillis = w.f4367a ? System.currentTimeMillis() : 0L;
        InnerOverlay innerOverlay = this.f4296b.get(Long.valueOf(j));
        if (innerOverlay != null) {
            String data = innerOverlay.getData();
            if (this.c.LayersIsShow(j)) {
                bundle.putString("jsondata", data);
                Bundle param = innerOverlay.getParam();
                if (param != null) {
                    bundle.putBundle("param", param);
                }
            } else {
                bundle.putString("jsondata", null);
            }
            if (w.f4367a) {
                w.a(f4295a, "MapLayerDataReq:" + j + " tag:" + innerOverlay.getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms] LayerData:" + data);
            }
            return innerOverlay.getType();
        }
        return 0;
    }

    public void a() {
        if (this.c != null) {
            for (Long l : this.f4296b.keySet()) {
                if (l.longValue() > 0) {
                    this.c.ClearLayer(l.longValue());
                    this.c.RemoveLayer(l.longValue());
                }
            }
        }
        this.f4296b.clear();
    }

    public void a(InnerOverlay innerOverlay) {
        this.f4296b.put(Long.valueOf(innerOverlay.mLayerID), innerOverlay);
        innerOverlay.SetMapParam(innerOverlay.mLayerID, this.c);
    }

    public void a(Overlay overlay) {
        this.f4296b.remove(Long.valueOf(overlay.mLayerID));
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j) {
        return this.f4296b.containsKey(Long.valueOf(j));
    }
}
