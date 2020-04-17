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
    public String bGK;
    public List<b> bYf;
    public List<a> bYi;
    @NonNull
    public TextureMapView cVA;
    public String cVz;
    public Context context;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bYf = new ArrayList();
        this.bYi = new ArrayList();
        this.cVz = cVar.bGJ;
        this.id = cVar.bGI;
        this.bGK = cVar.bGK;
        this.context = context;
        this.cVA = new TextureMapView(context);
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
        for (b bVar : this.bYf) {
            if (marker == bVar.cVl) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> rn(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bYf) {
            if (bVar.cVk != null && TextUtils.equals(str, bVar.cVk.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aJ(View view) {
        for (a aVar : this.bYi) {
            if (aVar.cVj == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bYf) {
            this.cVA.removeView(bVar.cVp);
        }
        this.bYf.clear();
        for (a aVar : this.bYi) {
            this.cVA.removeView(aVar.cVj);
        }
        this.bYi.clear();
        this.cVA.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dl */
    public TextureMapView ba(@NonNull Context context) {
        return this.cVA;
    }
}
