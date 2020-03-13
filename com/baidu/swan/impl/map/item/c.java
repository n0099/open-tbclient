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
    public String bip;
    public List<b> bzO;
    public List<a> bzR;
    public Context context;
    public String cws;
    @NonNull
    public TextureMapView cwt;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bzO = new ArrayList();
        this.bzR = new ArrayList();
        this.cws = cVar.bin;
        this.id = cVar.bim;
        this.bip = cVar.bip;
        this.context = context;
        this.cwt = new TextureMapView(context);
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
        for (b bVar : this.bzO) {
            if (marker == bVar.cwe) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> qb(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bzO) {
            if (bVar.cwd != null && TextUtils.equals(str, bVar.cwd.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.bzR) {
            if (aVar.cwc == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bzO) {
            this.cwt.removeView(bVar.cwi);
        }
        this.bzO.clear();
        for (a aVar : this.bzR) {
            this.cwt.removeView(aVar.cwc);
        }
        this.bzR.clear();
        this.cwt.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dy */
    public TextureMapView bn(@NonNull Context context) {
        return this.cwt;
    }
}
