package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public String aBE;
    public List<c> ayK = new ArrayList();
    public List<a> ayN = new ArrayList();
    public String bhi;
    public TextureMapView bhj;
    public Context context;
    public String id;
    public boolean isShowLocation;

    private b() {
    }

    public static b c(Context context, com.baidu.swan.apps.x.a.c cVar) {
        if (context == null || cVar == null || !cVar.isValid()) {
            return null;
        }
        b bVar = new b();
        bVar.bhi = cVar.aBD;
        bVar.id = cVar.id;
        bVar.aBE = cVar.aBE;
        bVar.context = context;
        bVar.bhj = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.ayK) {
            if (marker == cVar.bhl) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> jd(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.ayK) {
            if (cVar.bhk != null && TextUtils.equals(str, cVar.bhk.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a as(View view) {
        for (a aVar : this.ayN) {
            if (aVar.bhh == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.ayK) {
            this.bhj.removeView(cVar.bhp);
        }
        this.ayK.clear();
        for (a aVar : this.ayN) {
            this.bhj.removeView(aVar.bhh);
        }
        this.ayN.clear();
        this.bhj.getMap().clear();
    }
}
