package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2924a = MKOfflineMap.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private n f2925b;
    private MKOfflineMapListener c;

    public void destroy() {
        this.f2925b.d(0);
        this.f2925b.b((r) null);
        this.f2925b.b();
        j.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<q> e = this.f2925b.e();
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
        ArrayList<m> c = this.f2925b.c();
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
        ArrayList<m> d = this.f2925b.d();
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
        q g = this.f2925b.g(i);
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
        ArrayList<q> e = this.f2925b.e();
        if (e != null) {
            int size = e.size();
            i = size;
            i2 = size;
        } else {
            i = 0;
            i2 = 0;
        }
        this.f2925b.a(z, true);
        ArrayList<q> e2 = this.f2925b.e();
        if (e2 != null) {
            i = e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        j.a();
        this.f2925b = n.a();
        if (this.f2925b == null) {
            return false;
        }
        this.f2925b.a(new a(this));
        this.c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.f2925b.c(i);
    }

    public boolean remove(int i) {
        return this.f2925b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<m> a2 = this.f2925b.a(str);
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
        if (this.f2925b == null) {
            return false;
        }
        if (this.f2925b.e() != null) {
            Iterator<q> it = this.f2925b.e().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.f3193a.f3191a == i) {
                    if (next.f3193a.j || next.f3193a.l == 2 || next.f3193a.l == 3 || next.f3193a.l == 6) {
                        return this.f2925b.b(i);
                    }
                    return false;
                }
            }
        }
        return this.f2925b.a(i);
    }

    public boolean update(int i) {
        if (this.f2925b == null) {
            return false;
        }
        if (this.f2925b.e() != null) {
            Iterator<q> it = this.f2925b.e().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.f3193a.f3191a == i) {
                    if (next.f3193a.j) {
                        return this.f2925b.f(i);
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
