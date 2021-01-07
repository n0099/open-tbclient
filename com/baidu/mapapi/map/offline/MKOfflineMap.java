package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2925a = MKOfflineMap.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private n f2926b;
    private MKOfflineMapListener c;

    public void destroy() {
        this.f2926b.d(0);
        this.f2926b.b((r) null);
        this.f2926b.b();
        j.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<q> e = this.f2926b.e();
        if (e == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<q> it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<m> c = this.f2926b.c();
        if (c == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<m> d = this.f2926b.d();
        if (d == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        q g = this.f2926b.g(i);
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
        ArrayList<q> e = this.f2926b.e();
        if (e != null) {
            int size = e.size();
            i = size;
            i2 = size;
        } else {
            i = 0;
            i2 = 0;
        }
        this.f2926b.a(z, true);
        ArrayList<q> e2 = this.f2926b.e();
        if (e2 != null) {
            i = e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        j.a();
        this.f2926b = n.a();
        if (this.f2926b == null) {
            return false;
        }
        this.f2926b.a(new a(this));
        this.c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.f2926b.c(i);
    }

    public boolean remove(int i) {
        return this.f2926b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<m> a2 = this.f2926b.a(str);
        if (a2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        if (this.f2926b == null) {
            return false;
        }
        if (this.f2926b.e() != null) {
            Iterator<q> it = this.f2926b.e().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.f3194a.f3192a == i) {
                    if (next.f3194a.j || next.f3194a.l == 2 || next.f3194a.l == 3 || next.f3194a.l == 6) {
                        return this.f2926b.b(i);
                    }
                    return false;
                }
            }
        }
        return this.f2926b.a(i);
    }

    public boolean update(int i) {
        if (this.f2926b == null) {
            return false;
        }
        if (this.f2926b.e() != null) {
            Iterator<q> it = this.f2926b.e().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.f3194a.f3192a == i) {
                    if (next.f3194a.j) {
                        return this.f2926b.f(i);
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
