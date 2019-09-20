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
    public List<c> aAR = new ArrayList();
    public List<a> aAU = new ArrayList();
    public String aEt;
    public String boC;
    public TextureMapView boD;
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
        bVar.boC = cVar.aEs;
        bVar.id = cVar.id;
        bVar.aEt = cVar.aEt;
        bVar.context = context;
        bVar.boD = new TextureMapView(context);
        bVar.isShowLocation = cVar.isShowLocation;
        return bVar;
    }

    public c b(Marker marker) {
        for (c cVar : this.aAR) {
            if (marker == cVar.boF) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> km(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (c cVar : this.aAR) {
            if (cVar.boE != null && TextUtils.equals(str, cVar.boE.id)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public a aA(View view) {
        for (a aVar : this.aAU) {
            if (aVar.boB == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (c cVar : this.aAR) {
            this.boD.removeView(cVar.boJ);
        }
        this.aAR.clear();
        for (a aVar : this.aAU) {
            this.boD.removeView(aVar.boB);
        }
        this.aAU.clear();
        this.boD.getMap().clear();
    }
}
