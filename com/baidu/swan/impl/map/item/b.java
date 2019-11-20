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
    public List<c> aTN = new ArrayList();
    public List<a> aTQ = new ArrayList();
    public String aXq;
    public String bGx;
    public TextureMapView bGy;
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
        bVar.bGx = cVar.aXp;
        bVar.id = cVar.id;
        bVar.aXq = cVar.aXq;
        bVar.context = context;
        bVar.bGy = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.aTN) {
            if (marker == cVar.bGA) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> kO(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.aTN) {
            if (cVar.bGz != null && TextUtils.equals(str, cVar.bGz.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a aG(View view) {
        for (a aVar : this.aTQ) {
            if (aVar.bGw == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.aTN) {
            this.bGy.removeView(cVar.bGE);
        }
        this.aTN.clear();
        for (a aVar : this.aTQ) {
            this.bGy.removeView(aVar.bGw);
        }
        this.aTQ.clear();
        this.bGy.getMap().clear();
    }
}
