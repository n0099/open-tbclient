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
    public String aDn;
    public List<c> azM = new ArrayList();
    public List<a> azP = new ArrayList();
    public String bnr;
    public TextureMapView bns;
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
        bVar.bnr = cVar.aDm;
        bVar.id = cVar.id;
        bVar.aDn = cVar.aDn;
        bVar.context = context;
        bVar.bns = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.azM) {
            if (marker == cVar.bnu) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> kc(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.azM) {
            if (cVar.bnt != null && TextUtils.equals(str, cVar.bnt.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a ay(View view) {
        for (a aVar : this.azP) {
            if (aVar.bnq == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.azM) {
            this.bns.removeView(cVar.bny);
        }
        this.azM.clear();
        for (a aVar : this.azP) {
            this.bns.removeView(aVar.bnq);
        }
        this.azP.clear();
        this.bns.getMap().clear();
    }
}
