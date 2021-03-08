package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String cMS;
    public Context context;
    public List<b> djg;
    public List<a> djj;
    public String eqZ;
    @NonNull
    public TextureMapView era;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.djg = new ArrayList();
        this.djj = new ArrayList();
        this.eqZ = cVar.cMR;
        this.id = cVar.cMQ;
        this.cMS = cVar.cMS;
        this.context = context;
        this.era = new TextureMapView(context);
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
        for (b bVar : this.djg) {
            if (marker == bVar.eqL) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> xV(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.djg) {
            if (bVar.eqK != null && TextUtils.equals(str, bVar.eqK.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a be(View view) {
        for (a aVar : this.djj) {
            if (aVar.eqJ == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.djg) {
            this.era.removeView(bVar.eqP);
        }
        this.djg.clear();
        for (a aVar : this.djj) {
            this.era.removeView(aVar.eqJ);
        }
        this.djj.clear();
        this.era.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: eA */
    public TextureMapView cu(@NonNull Context context) {
        return this.era;
    }
}
