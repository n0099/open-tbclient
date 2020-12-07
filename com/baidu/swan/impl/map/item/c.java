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
    public String cIX;
    public Context context;
    public List<b> dfm;
    public List<a> dfp;
    public String eja;
    @NonNull
    public TextureMapView ejb;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.dfm = new ArrayList();
        this.dfp = new ArrayList();
        this.eja = cVar.cIW;
        this.id = cVar.cIV;
        this.cIX = cVar.cIX;
        this.context = context;
        this.ejb = new TextureMapView(context);
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
        for (b bVar : this.dfm) {
            if (marker == bVar.eiM) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> yH(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.dfm) {
            if (bVar.eiL != null && TextUtils.equals(str, bVar.eiL.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aZ(View view) {
        for (a aVar : this.dfp) {
            if (aVar.eiK == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.dfm) {
            this.ejb.removeView(bVar.eiQ);
        }
        this.dfm.clear();
        for (a aVar : this.dfp) {
            this.ejb.removeView(aVar.eiK);
        }
        this.dfp.clear();
        this.ejb.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: ek */
    public TextureMapView bQ(@NonNull Context context) {
        return this.ejb;
    }
}
