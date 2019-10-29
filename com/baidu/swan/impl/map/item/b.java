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
    public List<c> aUf = new ArrayList();
    public List<a> aUi = new ArrayList();
    public String aXI;
    public String bHo;
    public TextureMapView bHp;
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
        bVar.bHo = cVar.aXH;
        bVar.id = cVar.id;
        bVar.aXI = cVar.aXI;
        bVar.context = context;
        bVar.bHp = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.aUf) {
            if (marker == cVar.bHr) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> kO(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.aUf) {
            if (cVar.bHq != null && TextUtils.equals(str, cVar.bHq.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a aG(View view) {
        for (a aVar : this.aUi) {
            if (aVar.bHn == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.aUf) {
            this.bHp.removeView(cVar.bHv);
        }
        this.aUf.clear();
        for (a aVar : this.aUi) {
            this.bHp.removeView(aVar.bHn);
        }
        this.aUi.clear();
        this.bHp.getMap().clear();
    }
}
