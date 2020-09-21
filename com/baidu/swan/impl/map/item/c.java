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
/* loaded from: classes24.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String cdb;
    public Context context;
    public List<b> czD;
    public List<a> czG;
    public String dDs;
    @NonNull
    public TextureMapView dDt;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.czD = new ArrayList();
        this.czG = new ArrayList();
        this.dDs = cVar.cda;
        this.id = cVar.ccZ;
        this.cdb = cVar.cdb;
        this.context = context;
        this.dDt = new TextureMapView(context);
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
        for (b bVar : this.czD) {
            if (marker == bVar.dDe) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> wM(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.czD) {
            if (bVar.dDd != null && TextUtils.equals(str, bVar.dDd.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aR(View view) {
        for (a aVar : this.czG) {
            if (aVar.dDc == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.czD) {
            this.dDt.removeView(bVar.dDi);
        }
        this.czD.clear();
        for (a aVar : this.czG) {
            this.dDt.removeView(aVar.dDc);
        }
        this.czG.clear();
        this.dDt.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dy */
    public TextureMapView be(@NonNull Context context) {
        return this.dDt;
    }
}
