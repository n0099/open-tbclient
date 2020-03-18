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
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.z.a.c> {
    public List<a> bAc;
    public String biC;
    public List<b> bzZ;
    public Context context;
    public String cwD;
    @NonNull
    public TextureMapView cwE;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bzZ = new ArrayList();
        this.bAc = new ArrayList();
        this.cwD = cVar.biB;
        this.id = cVar.biA;
        this.biC = cVar.biC;
        this.context = context;
        this.cwE = new TextureMapView(context);
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
        for (b bVar : this.bzZ) {
            if (marker == bVar.cwp) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> qa(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bzZ) {
            if (bVar.cwo != null && TextUtils.equals(str, bVar.cwo.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.bAc) {
            if (aVar.cwn == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bzZ) {
            this.cwE.removeView(bVar.cwt);
        }
        this.bzZ.clear();
        for (a aVar : this.bAc) {
            this.cwE.removeView(aVar.cwn);
        }
        this.bAc.clear();
        this.cwE.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dx */
    public TextureMapView bm(@NonNull Context context) {
        return this.cwE;
    }
}
