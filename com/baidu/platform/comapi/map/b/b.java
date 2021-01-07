package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private MapController f4322b;
    private com.baidu.platform.comapi.map.b.a.b c;

    /* renamed from: a  reason: collision with root package name */
    a.InterfaceC0291a f4321a = new c(this);
    private com.baidu.platform.comapi.map.b.a.a d = new com.baidu.platform.comapi.map.b.a.a(this.f4321a);

    public b(MapController mapController) {
        this.f4322b = mapController;
        this.c = new com.baidu.platform.comapi.map.b.a.b(new com.baidu.platform.comapi.map.b.b.b(mapController));
    }

    public void a(MotionEvent motionEvent) {
        this.c.a(motionEvent);
        this.d.a(motionEvent);
    }
}
