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
    public String bGP;
    public List<b> bYl;
    public List<a> bYo;
    public String cVE;
    @NonNull
    public TextureMapView cVF;
    public Context context;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bYl = new ArrayList();
        this.bYo = new ArrayList();
        this.cVE = cVar.bGO;
        this.id = cVar.bGN;
        this.bGP = cVar.bGP;
        this.context = context;
        this.cVF = new TextureMapView(context);
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
        for (b bVar : this.bYl) {
            if (marker == bVar.cVq) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> rn(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bYl) {
            if (bVar.cVp != null && TextUtils.equals(str, bVar.cVp.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aJ(View view) {
        for (a aVar : this.bYo) {
            if (aVar.cVo == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bYl) {
            this.cVF.removeView(bVar.cVu);
        }
        this.bYl.clear();
        for (a aVar : this.bYo) {
            this.cVF.removeView(aVar.cVo);
        }
        this.bYo.clear();
        this.cVF.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: cZ */
    public TextureMapView aO(@NonNull Context context) {
        return this.cVF;
    }
}
