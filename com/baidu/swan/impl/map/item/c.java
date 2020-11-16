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
    public String cCc;
    public List<b> cYn;
    public List<a> cYq;
    public Context context;
    public String ebZ;
    @NonNull
    public TextureMapView eca;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cYn = new ArrayList();
        this.cYq = new ArrayList();
        this.ebZ = cVar.cCb;
        this.id = cVar.cCa;
        this.cCc = cVar.cCc;
        this.context = context;
        this.eca = new TextureMapView(context);
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
        for (b bVar : this.cYn) {
            if (marker == bVar.ebL) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> ya(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cYn) {
            if (bVar.ebK != null && TextUtils.equals(str, bVar.ebK.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aX(View view) {
        for (a aVar : this.cYq) {
            if (aVar.ebJ == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cYn) {
            this.eca.removeView(bVar.ebP);
        }
        this.cYn.clear();
        for (a aVar : this.cYq) {
            this.eca.removeView(aVar.ebJ);
        }
        this.cYq.clear();
        this.eca.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dE */
    public TextureMapView bk(@NonNull Context context) {
        return this.eca;
    }
}
