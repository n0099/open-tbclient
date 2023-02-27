package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.o;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.s;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    public static final String a = "MKOfflineMap";
    public o b;
    public MKOfflineMapListener c;

    public void destroy() {
        this.b.d(0);
        this.b.b((s) null);
        this.b.b();
        j.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<r> e = this.b.e();
        if (e == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<r> it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<n> c = this.b.c();
        if (c == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<n> it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<n> d = this.b.d();
        if (d == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<n> it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        r g = this.b.g(i);
        if (g == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(g.a());
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int i;
        ArrayList<r> e = this.b.e();
        int i2 = 0;
        if (e != null) {
            i2 = e.size();
            i = i2;
        } else {
            i = 0;
        }
        this.b.a(z, true);
        ArrayList<r> e2 = this.b.e();
        if (e2 != null) {
            i = e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        j.a();
        o a2 = o.a();
        this.b = a2;
        if (a2 == null) {
            return false;
        }
        a2.a(new a(this));
        this.c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.b.c(i);
    }

    public boolean remove(int i) {
        return this.b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<n> a2 = this.b.a(str);
        if (a2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<n> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        int i2;
        o oVar = this.b;
        if (oVar == null) {
            return false;
        }
        if (oVar.e() != null) {
            Iterator<r> it = this.b.e().iterator();
            while (it.hasNext()) {
                q qVar = it.next().a;
                if (qVar.a == i) {
                    if (!qVar.j && (i2 = qVar.l) != 2 && i2 != 3 && i2 != 6) {
                        return false;
                    }
                    return this.b.b(i);
                }
            }
        }
        return this.b.a(i);
    }

    public boolean update(int i) {
        o oVar = this.b;
        if (oVar != null && oVar.e() != null) {
            Iterator<r> it = this.b.e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q qVar = it.next().a;
                if (qVar.a == i) {
                    if (qVar.j) {
                        return this.b.f(i);
                    }
                }
            }
        }
        return false;
    }
}
