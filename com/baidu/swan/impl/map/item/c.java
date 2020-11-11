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
    public String cDM;
    public List<b> cZX;
    public Context context;
    public List<a> daa;
    public String edH;
    @NonNull
    public TextureMapView edI;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cZX = new ArrayList();
        this.daa = new ArrayList();
        this.edH = cVar.cDL;
        this.id = cVar.cDK;
        this.cDM = cVar.cDM;
        this.context = context;
        this.edI = new TextureMapView(context);
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
        for (b bVar : this.cZX) {
            if (marker == bVar.edt) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> yf(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cZX) {
            if (bVar.eds != null && TextUtils.equals(str, bVar.eds.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aX(View view) {
        for (a aVar : this.daa) {
            if (aVar.edr == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cZX) {
            this.edI.removeView(bVar.edx);
        }
        this.cZX.clear();
        for (a aVar : this.daa) {
            this.edI.removeView(aVar.edr);
        }
        this.daa.clear();
        this.edI.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dE */
    public TextureMapView bk(@NonNull Context context) {
        return this.edI;
    }
}
