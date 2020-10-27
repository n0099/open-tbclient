package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public List<b> cUe;
    public List<a> cUh;
    public Context context;
    public String cxT;
    public String dXQ;
    @NonNull
    public TextureMapView dXR;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cUe = new ArrayList();
        this.cUh = new ArrayList();
        this.dXQ = cVar.cxS;
        this.id = cVar.cxR;
        this.cxT = cVar.cxT;
        this.context = context;
        this.dXR = new TextureMapView(context);
        this.isShowLocation = cVar.isShowLocation;
    }

    public static c c(Context context, com.baidu.swan.apps.w.a.c cVar) {
        if (context == null || cVar == null || !cVar.isValid()) {
            return null;
        }
        return new c(context, cVar);
    }

    @Nullable
    public b b(Marker marker) {
        for (b bVar : this.cUe) {
            if (marker == bVar.dXC) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> xR(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cUe) {
            if (bVar.dXB != null && TextUtils.equals(str, bVar.dXB.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aT(View view) {
        for (a aVar : this.cUh) {
            if (aVar.dXA == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cUe) {
            this.dXR.removeView(bVar.dXG);
        }
        this.cUe.clear();
        for (a aVar : this.cUh) {
            this.dXR.removeView(aVar.dXA);
        }
        this.cUh.clear();
        this.dXR.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dE */
    public TextureMapView bk(@NonNull Context context) {
        return this.dXR;
    }
}
