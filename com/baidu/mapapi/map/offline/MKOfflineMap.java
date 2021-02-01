package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.u;
import com.baidu.mapsdkplatform.comapi.map.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2802a = MKOfflineMap.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private r f2803b;
    private MKOfflineMapListener c;

    public void destroy() {
        this.f2803b.d(0);
        this.f2803b.b((v) null);
        this.f2803b.b();
        i.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<u> e = this.f2803b.e();
        if (e == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<u> it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<q> c = this.f2803b.c();
        if (c == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<q> it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<q> d = this.f2803b.d();
        if (d == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<q> it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        u g = this.f2803b.g(i);
        if (g == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(g.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int i;
        int i2;
        ArrayList<u> e = this.f2803b.e();
        if (e != null) {
            int size = e.size();
            i = size;
            i2 = size;
        } else {
            i = 0;
            i2 = 0;
        }
        this.f2803b.a(z, true);
        ArrayList<u> e2 = this.f2803b.e();
        if (e2 != null) {
            i = e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        i.a();
        this.f2803b = r.a();
        if (this.f2803b == null) {
            return false;
        }
        this.f2803b.a(new a(this));
        this.c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.f2803b.c(i);
    }

    public boolean remove(int i) {
        return this.f2803b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<q> a2 = this.f2803b.a(str);
        if (a2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<q> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        if (this.f2803b == null) {
            return false;
        }
        if (this.f2803b.e() != null) {
            Iterator<u> it = this.f2803b.e().iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.f3072a.f3070a == i) {
                    if (next.f3072a.j || next.f3072a.l == 2 || next.f3072a.l == 3 || next.f3072a.l == 6) {
                        return this.f2803b.b(i);
                    }
                    return false;
                }
            }
        }
        return this.f2803b.a(i);
    }

    public boolean update(int i) {
        if (this.f2803b == null) {
            return false;
        }
        if (this.f2803b.e() != null) {
            Iterator<u> it = this.f2803b.e().iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.f3072a.f3070a == i) {
                    if (next.f3072a.j) {
                        return this.f2803b.f(i);
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
