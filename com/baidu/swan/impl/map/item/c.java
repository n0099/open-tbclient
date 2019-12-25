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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.z.a.c> {
    public String bdj;
    public List<b> buP;
    public List<a> buS;
    public Context context;
    public String csd;
    @NonNull
    public TextureMapView cse;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.buP = new ArrayList();
        this.buS = new ArrayList();
        this.csd = cVar.bdi;
        this.id = cVar.bdh;
        this.bdj = cVar.bdj;
        this.context = context;
        this.cse = new TextureMapView(context);
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
        for (b bVar : this.buP) {
            if (marker == bVar.crP) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> pJ(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.buP) {
            if (bVar.crO != null && TextUtils.equals(str, bVar.crO.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aE(View view) {
        for (a aVar : this.buS) {
            if (aVar.crN == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.buP) {
            this.cse.removeView(bVar.crT);
        }
        this.buP.clear();
        for (a aVar : this.buS) {
            this.cse.removeView(aVar.crN);
        }
        this.buS.clear();
        this.cse.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: du */
    public TextureMapView bj(@NonNull Context context) {
        return this.cse;
    }
}
