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
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.z.a.c> {
    public String bdX;
    public List<b> bvD;
    public List<a> bvG;
    public Context context;
    public String cso;
    @NonNull
    public TextureMapView csp;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bvD = new ArrayList();
        this.bvG = new ArrayList();
        this.cso = cVar.bdW;
        this.id = cVar.bdV;
        this.bdX = cVar.bdX;
        this.context = context;
        this.csp = new TextureMapView(context);
        this.isShowLocation = cVar.isShowLocation;
    }

    public static c c(Context context, com.baidu.swan.apps.z.a.c cVar) {
        if (context == null || cVar == null || !cVar.isValid()) {
            return null;
        }
        return new c(context, cVar);
    }

    @Nullable
    public b b(Marker marker) {
        for (b bVar : this.bvD) {
            if (marker == bVar.csa) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> pM(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bvD) {
            if (bVar.crZ != null && TextUtils.equals(str, bVar.crZ.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.bvG) {
            if (aVar.crY == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bvD) {
            this.csp.removeView(bVar.cse);
        }
        this.bvD.clear();
        for (a aVar : this.bvG) {
            this.csp.removeView(aVar.crY);
        }
        this.bvG.clear();
        this.csp.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: du */
    public TextureMapView bj(@NonNull Context context) {
        return this.csp;
    }
}
