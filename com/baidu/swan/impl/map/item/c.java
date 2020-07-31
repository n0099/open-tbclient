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
    public String bVn;
    public Context context;
    public List<b> cpI;
    public List<a> cpL;
    public String drl;
    @NonNull
    public TextureMapView drm;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.cpI = new ArrayList();
        this.cpL = new ArrayList();
        this.drl = cVar.bVm;
        this.id = cVar.bVl;
        this.bVn = cVar.bVn;
        this.context = context;
        this.drm = new TextureMapView(context);
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
        for (b bVar : this.cpI) {
            if (marker == bVar.dqX) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> uc(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.cpI) {
            if (bVar.dqW != null && TextUtils.equals(str, bVar.dqW.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aN(View view) {
        for (a aVar : this.cpL) {
            if (aVar.dqV == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.cpI) {
            this.drm.removeView(bVar.drb);
        }
        this.cpI.clear();
        for (a aVar : this.cpL) {
            this.drm.removeView(aVar.dqV);
        }
        this.cpL.clear();
        this.drm.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dt */
    public TextureMapView ba(@NonNull Context context) {
        return this.drm;
    }
}
