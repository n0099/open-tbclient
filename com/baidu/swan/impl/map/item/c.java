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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String cLs;
    public Context context;
    public List<b> dhC;
    public List<a> dhF;
    public String epy;
    @NonNull
    public TextureMapView epz;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.dhC = new ArrayList();
        this.dhF = new ArrayList();
        this.epy = cVar.cLr;
        this.id = cVar.cLq;
        this.cLs = cVar.cLs;
        this.context = context;
        this.epz = new TextureMapView(context);
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
        for (b bVar : this.dhC) {
            if (marker == bVar.epk) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> xO(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.dhC) {
            if (bVar.epj != null && TextUtils.equals(str, bVar.epj.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a be(View view) {
        for (a aVar : this.dhF) {
            if (aVar.epi == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.dhC) {
            this.epz.removeView(bVar.epo);
        }
        this.dhC.clear();
        for (a aVar : this.dhF) {
            this.epz.removeView(aVar.epi);
        }
        this.dhF.clear();
        this.epz.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: eB */
    public TextureMapView cv(@NonNull Context context) {
        return this.epz;
    }
}
