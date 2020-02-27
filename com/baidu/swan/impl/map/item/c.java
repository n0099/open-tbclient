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
    public String bim;
    public List<b> bzM;
    public List<a> bzP;
    public Context context;
    public String cwq;
    @NonNull
    public TextureMapView cwr;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bzM = new ArrayList();
        this.bzP = new ArrayList();
        this.cwq = cVar.bil;
        this.id = cVar.bik;
        this.bim = cVar.bim;
        this.context = context;
        this.cwr = new TextureMapView(context);
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
        for (b bVar : this.bzM) {
            if (marker == bVar.cwc) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> qb(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bzM) {
            if (bVar.cwb != null && TextUtils.equals(str, bVar.cwb.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.bzP) {
            if (aVar.cwa == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bzM) {
            this.cwr.removeView(bVar.cwg);
        }
        this.bzM.clear();
        for (a aVar : this.bzP) {
            this.cwr.removeView(aVar.cwa);
        }
        this.bzP.clear();
        this.cwr.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dy */
    public TextureMapView bn(@NonNull Context context) {
        return this.cwr;
    }
}
