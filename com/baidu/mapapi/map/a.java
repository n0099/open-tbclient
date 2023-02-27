package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements Overlay.a {
    public final /* synthetic */ BaiduMap a;

    public a(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public LatLngBounds a(Overlay overlay) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        dVar = this.a.j;
        if (dVar != null && overlay != null) {
            Bundle bundle = new Bundle();
            overlay.a(bundle);
            dVar2 = this.a.j;
            return dVar2.b(bundle);
        }
        return null;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public boolean d(Overlay overlay) {
        List list;
        List list2;
        list = this.a.k;
        if (list != null) {
            list2 = this.a.k;
            if (!list2.contains(overlay)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void b(Overlay overlay) {
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
        z = this.a.X;
        if (z) {
            return;
        }
        if (overlay != null) {
            list6 = this.a.k;
            if (list6.contains(overlay)) {
                Bundle a = overlay.a();
                dVar3 = this.a.j;
                if (dVar3 != null) {
                    dVar4 = this.a.j;
                    dVar4.f(a);
                }
                list7 = this.a.k;
                list7.remove(overlay);
            }
        }
        if (overlay != null) {
            list4 = this.a.m;
            if (list4.contains(overlay)) {
                list5 = this.a.m;
                list5.remove(overlay);
            }
        }
        if (overlay == null) {
            return;
        }
        list = this.a.l;
        if (list.contains(overlay)) {
            Marker marker = (Marker) overlay;
            if (marker.s == null) {
                return;
            }
            list2 = this.a.l;
            list2.remove(marker);
            list3 = this.a.l;
            if (list3.size() != 0) {
                return;
            }
            dVar = this.a.j;
            if (dVar == null) {
                return;
            }
            dVar2 = this.a.j;
            dVar2.c(false);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void c(Overlay overlay) {
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
        com.baidu.mapsdkplatform.comapi.map.d dVar6;
        List list8;
        z = this.a.X;
        if (z) {
            return;
        }
        if (overlay != null) {
            list4 = this.a.k;
            if (list4.contains(overlay)) {
                boolean z4 = false;
                if (overlay instanceof Marker) {
                    Marker marker = (Marker) overlay;
                    if (marker.b != null) {
                        ArrayList<BitmapDescriptor> arrayList = marker.s;
                        if (arrayList != null && arrayList.size() > 1) {
                            Bundle bundle = new Bundle();
                            dVar5 = this.a.j;
                            if (dVar5 != null) {
                                z3 = this.a.X;
                                if (!z3) {
                                    marker.remove();
                                    marker.s.clear();
                                    dVar6 = this.a.j;
                                    dVar6.c(overlay.a(bundle));
                                    list8 = this.a.k;
                                    list8.add(overlay);
                                    z4 = true;
                                }
                            }
                        }
                    } else {
                        ArrayList<BitmapDescriptor> arrayList2 = marker.s;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            list5 = this.a.l;
                            if (list5.contains(marker)) {
                                list7 = this.a.l;
                                list7.remove(marker);
                            }
                            list6 = this.a.l;
                            list6.add(marker);
                            dVar3 = this.a.j;
                            if (dVar3 != null) {
                                dVar4 = this.a.j;
                                dVar4.c(true);
                            }
                        }
                    }
                }
                dVar = this.a.j;
                if (dVar != null && !z4) {
                    z2 = this.a.X;
                    if (!z2) {
                        Bundle bundle2 = new Bundle();
                        dVar2 = this.a.j;
                        dVar2.e(overlay.a(bundle2));
                    }
                }
            }
        }
        list = this.a.m;
        if (list.contains(overlay)) {
            list3 = this.a.m;
            list3.remove(overlay);
        }
        if (overlay instanceof Marker) {
            list2 = this.a.m;
            list2.add((Marker) overlay);
        }
    }
}
