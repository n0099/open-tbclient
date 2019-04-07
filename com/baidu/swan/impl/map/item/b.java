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
    public String aBH;
    public List<c> ayN = new ArrayList();
    public List<a> ayQ = new ArrayList();
    public String bhl;
    public TextureMapView bhm;
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
        bVar.bhl = cVar.aBG;
        bVar.id = cVar.id;
        bVar.aBH = cVar.aBH;
        bVar.context = context;
        bVar.bhm = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.ayN) {
            if (marker == cVar.bho) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> je(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.ayN) {
            if (cVar.bhn != null && TextUtils.equals(str, cVar.bhn.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a as(View view) {
        for (a aVar : this.ayQ) {
            if (aVar.bhk == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.ayN) {
            this.bhm.removeView(cVar.bhs);
        }
        this.ayN.clear();
        for (a aVar : this.ayQ) {
            this.bhm.removeView(aVar.bhk);
        }
        this.ayQ.clear();
        this.bhm.getMap().clear();
    }
}
