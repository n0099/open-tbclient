package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Overlay;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements Overlay.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaiduMap baiduMap) {
        this.f2058a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void a(Overlay overlay) {
        boolean z;
        List list;
        List list2;
        List list3;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        List list4;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.d dVar3;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.d dVar4;
        z = this.f2058a.U;
        if (z) {
            return;
        }
        if (overlay != null) {
            list6 = this.f2058a.k;
            if (list6.contains(overlay)) {
                Bundle a2 = overlay.a();
                dVar3 = this.f2058a.j;
                if (dVar3 != null) {
                    dVar4 = this.f2058a.j;
                    dVar4.d(a2);
                }
                list7 = this.f2058a.k;
                list7.remove(overlay);
            }
        }
        if (overlay != null) {
            list4 = this.f2058a.m;
            if (list4.contains(overlay)) {
                list5 = this.f2058a.m;
                list5.remove(overlay);
            }
        }
        if (overlay != null) {
            list = this.f2058a.l;
            if (list.contains(overlay)) {
                Marker marker = (Marker) overlay;
                if (marker.p != null) {
                    list2 = this.f2058a.l;
                    list2.remove(marker);
                    list3 = this.f2058a.l;
                    if (list3.size() == 0) {
                        dVar = this.f2058a.j;
                        if (dVar != null) {
                            dVar2 = this.f2058a.j;
                            dVar2.b(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void b(Overlay overlay) {
        boolean z;
        List list;
        List list2;
        List list3;
        List list4;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        boolean z2;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.d dVar3;
        com.baidu.mapsdkplatform.comapi.map.d dVar4;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.d dVar5;
        boolean z3;
        boolean z4;
        com.baidu.mapsdkplatform.comapi.map.d dVar6;
        List list8;
        z = this.f2058a.U;
        if (z) {
            return;
        }
        if (overlay != null) {
            list4 = this.f2058a.k;
            if (list4.contains(overlay)) {
                boolean z5 = false;
                if (overlay instanceof Marker) {
                    Marker marker = (Marker) overlay;
                    if (marker.b != null) {
                        if (marker.p != null && marker.p.size() > 1) {
                            Bundle bundle = new Bundle();
                            dVar5 = this.f2058a.j;
                            if (dVar5 != null) {
                                z4 = this.f2058a.U;
                                if (!z4) {
                                    marker.remove();
                                    marker.p.clear();
                                    dVar6 = this.f2058a.j;
                                    dVar6.b(overlay.a(bundle));
                                    list8 = this.f2058a.k;
                                    list8.add(overlay);
                                    z3 = true;
                                    z5 = z3;
                                }
                            }
                            z3 = false;
                            z5 = z3;
                        }
                    } else if (marker.p != null && marker.p.size() != 0) {
                        list5 = this.f2058a.l;
                        if (list5.contains(marker)) {
                            list7 = this.f2058a.l;
                            list7.remove(marker);
                        }
                        list6 = this.f2058a.l;
                        list6.add(marker);
                        dVar3 = this.f2058a.j;
                        if (dVar3 != null) {
                            dVar4 = this.f2058a.j;
                            dVar4.b(true);
                        }
                    }
                }
                dVar = this.f2058a.j;
                if (dVar != null && !z5) {
                    z2 = this.f2058a.U;
                    if (!z2) {
                        Bundle bundle2 = new Bundle();
                        dVar2 = this.f2058a.j;
                        dVar2.c(overlay.a(bundle2));
                    }
                }
            }
        }
        list = this.f2058a.m;
        if (list.contains(overlay)) {
            list3 = this.f2058a.m;
            list3.remove(overlay);
        }
        if (overlay instanceof Marker) {
            list2 = this.f2058a.m;
            list2.add((Marker) overlay);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public boolean c(Overlay overlay) {
        List list;
        List list2;
        list = this.f2058a.k;
        if (list != null) {
            list2 = this.f2058a.k;
            if (!list2.contains(overlay)) {
                return true;
            }
        }
        return false;
    }
}
