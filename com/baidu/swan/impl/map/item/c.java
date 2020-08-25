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
    public String caV;
    public Context context;
    public List<a> cxB;
    public List<b> cxy;
    public String dBn;
    @NonNull
    public TextureMapView dBo;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cxy = new ArrayList();
        this.cxB = new ArrayList();
        this.dBn = cVar.caU;
        this.id = cVar.caT;
        this.caV = cVar.caV;
        this.context = context;
        this.dBo = new TextureMapView(context);
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
        for (b bVar : this.cxy) {
            if (marker == bVar.dAZ) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> ws(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cxy) {
            if (bVar.dAY != null && TextUtils.equals(str, bVar.dAY.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aP(View view) {
        for (a aVar : this.cxB) {
            if (aVar.dAX == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cxy) {
            this.dBo.removeView(bVar.dBd);
        }
        this.cxy.clear();
        for (a aVar : this.cxB) {
            this.dBo.removeView(aVar.dAX);
        }
        this.cxB.clear();
        this.dBo.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dz */
    public TextureMapView bf(@NonNull Context context) {
        return this.dBo;
    }
}
