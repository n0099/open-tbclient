package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.mapsdkplatform.comapi.map.u;
import com.baidu.mapsdkplatform.comapi.map.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7122a = "MKOfflineMap";

    /* renamed from: b  reason: collision with root package name */
    public r f7123b;

    /* renamed from: c  reason: collision with root package name */
    public MKOfflineMapListener f7124c;

    public void destroy() {
        this.f7123b.d(0);
        this.f7123b.b((v) null);
        this.f7123b.b();
        i.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<u> e2 = this.f7123b.e();
        if (e2 == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<u> it = e2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<q> c2 = this.f7123b.c();
        if (c2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<q> it = c2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<q> d2 = this.f7123b.d();
        if (d2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<q> it = d2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        u g2 = this.f7123b.g(i);
        if (g2 == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(g2.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int i;
        ArrayList<u> e2 = this.f7123b.e();
        int i2 = 0;
        if (e2 != null) {
            i2 = e2.size();
            i = i2;
        } else {
            i = 0;
        }
        this.f7123b.a(z, true);
        ArrayList<u> e3 = this.f7123b.e();
        if (e3 != null) {
            i = e3.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        i.a();
        r a2 = r.a();
        this.f7123b = a2;
        if (a2 == null) {
            return false;
        }
        a2.a(new a(this));
        this.f7124c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.f7123b.c(i);
    }

    public boolean remove(int i) {
        return this.f7123b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<q> a2 = this.f7123b.a(str);
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
        int i2;
        r rVar = this.f7123b;
        if (rVar == null) {
            return false;
        }
        if (rVar.e() != null) {
            Iterator<u> it = this.f7123b.e().iterator();
            while (it.hasNext()) {
                t tVar = it.next().f7713a;
                if (tVar.f7705a == i) {
                    if (tVar.j || (i2 = tVar.l) == 2 || i2 == 3 || i2 == 6) {
                        return this.f7123b.b(i);
                    }
                    return false;
                }
            }
        }
        return this.f7123b.a(i);
    }

    public boolean update(int i) {
        r rVar = this.f7123b;
        if (rVar != null && rVar.e() != null) {
            Iterator<u> it = this.f7123b.e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                t tVar = it.next().f7713a;
                if (tVar.f7705a == i) {
                    if (tVar.j) {
                        return this.f7123b.f(i);
                    }
                }
            }
        }
        return false;
    }
}
