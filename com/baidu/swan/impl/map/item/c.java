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
    public String bPH;
    public List<b> ciN;
    public List<a> ciQ;
    public Context context;
    public String dgF;
    @NonNull
    public TextureMapView dgG;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.x.a.c cVar) {
        super(context, cVar);
        this.ciN = new ArrayList();
        this.ciQ = new ArrayList();
        this.dgF = cVar.bPG;
        this.id = cVar.bPF;
        this.bPH = cVar.bPH;
        this.context = context;
        this.dgG = new TextureMapView(context);
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
        for (b bVar : this.ciN) {
            if (marker == bVar.dgr) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> sR(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.ciN) {
            if (bVar.dgq != null && TextUtils.equals(str, bVar.dgq.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.ciQ) {
            if (aVar.dgp == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.ciN) {
            this.dgG.removeView(bVar.dgv);
        }
        this.ciN.clear();
        for (a aVar : this.ciQ) {
            this.dgG.removeView(aVar.dgp);
        }
        this.ciQ.clear();
        this.dgG.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: do  reason: not valid java name */
    public TextureMapView aY(@NonNull Context context) {
        return this.dgG;
    }
}
