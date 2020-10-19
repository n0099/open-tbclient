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
    public List<b> cLI;
    public List<a> cLL;
    public Context context;
    public String cpr;
    public String dPt;
    @NonNull
    public TextureMapView dPu;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cLI = new ArrayList();
        this.cLL = new ArrayList();
        this.dPt = cVar.cpq;
        this.id = cVar.cpp;
        this.cpr = cVar.cpr;
        this.context = context;
        this.dPu = new TextureMapView(context);
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
        for (b bVar : this.cLI) {
            if (marker == bVar.dPf) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> xy(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cLI) {
            if (bVar.dPe != null && TextUtils.equals(str, bVar.dPe.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aS(View view) {
        for (a aVar : this.cLL) {
            if (aVar.dPd == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cLI) {
            this.dPu.removeView(bVar.dPj);
        }
        this.cLI.clear();
        for (a aVar : this.cLL) {
            this.dPu.removeView(aVar.dPd);
        }
        this.cLL.clear();
        this.dPu.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dE */
    public TextureMapView bk(@NonNull Context context) {
        return this.dPu;
    }
}
