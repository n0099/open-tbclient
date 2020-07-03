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
/* loaded from: classes12.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.x.a.c> {
    public String bUv;
    public List<b> cnC;
    public List<a> cnF;
    public Context context;
    public String dlr;
    @NonNull
    public TextureMapView dls;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.x.a.c cVar) {
        super(context, cVar);
        this.cnC = new ArrayList();
        this.cnF = new ArrayList();
        this.dlr = cVar.bUu;
        this.id = cVar.bUt;
        this.bUv = cVar.bUv;
        this.context = context;
        this.dls = new TextureMapView(context);
        this.isShowLocation = cVar.isShowLocation;
    }

    public static c c(Context context, com.baidu.swan.apps.x.a.c cVar) {
        if (context == null || cVar == null || !cVar.isValid()) {
            return null;
        }
        return new c(context, cVar);
    }

    @Nullable
    public b b(Marker marker) {
        for (b bVar : this.cnC) {
            if (marker == bVar.dld) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> sZ(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cnC) {
            if (bVar.dlc != null && TextUtils.equals(str, bVar.dlc.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.cnF) {
            if (aVar.dlb == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cnC) {
            this.dls.removeView(bVar.dlh);
        }
        this.cnC.clear();
        for (a aVar : this.cnF) {
            this.dls.removeView(aVar.dlb);
        }
        this.cnF.clear();
        this.dls.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dp */
    public TextureMapView aZ(@NonNull Context context) {
        return this.dls;
    }
}
