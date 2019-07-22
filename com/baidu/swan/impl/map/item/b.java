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
    public List<c> aAt = new ArrayList();
    public List<a> aAw = new ArrayList();
    public String aDV;
    public String boe;
    public TextureMapView bof;
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
        bVar.boe = cVar.aDU;
        bVar.id = cVar.id;
        bVar.aDV = cVar.aDV;
        bVar.context = context;
        bVar.bof = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.aAt) {
            if (marker == cVar.boh) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> kk(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.aAt) {
            if (cVar.bog != null && TextUtils.equals(str, cVar.bog.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a aA(View view) {
        for (a aVar : this.aAw) {
            if (aVar.bod == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.aAt) {
            this.bof.removeView(cVar.bol);
        }
        this.aAt.clear();
        for (a aVar : this.aAw) {
            this.bof.removeView(aVar.bod);
        }
        this.aAw.clear();
        this.bof.getMap().clear();
    }
}
