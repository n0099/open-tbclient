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
/* loaded from: classes19.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String caZ;
    public Context context;
    public List<b> cxC;
    public List<a> cxF;
    public String dBr;
    @NonNull
    public TextureMapView dBs;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cxC = new ArrayList();
        this.cxF = new ArrayList();
        this.dBr = cVar.caY;
        this.id = cVar.caX;
        this.caZ = cVar.caZ;
        this.context = context;
        this.dBs = new TextureMapView(context);
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
        for (b bVar : this.cxC) {
            if (marker == bVar.dBd) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> wt(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cxC) {
            if (bVar.dBc != null && TextUtils.equals(str, bVar.dBc.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aP(View view) {
        for (a aVar : this.cxF) {
            if (aVar.dBb == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cxC) {
            this.dBs.removeView(bVar.dBh);
        }
        this.cxC.clear();
        for (a aVar : this.cxF) {
            this.dBs.removeView(aVar.dBb);
        }
        this.cxF.clear();
        this.dBs.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dz */
    public TextureMapView bf(@NonNull Context context) {
        return this.dBs;
    }
}
