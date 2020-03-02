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
    public String bin;
    public List<b> bzN;
    public List<a> bzQ;
    public Context context;
    public String cwr;
    @NonNull
    public TextureMapView cws;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.z.a.c cVar) {
        super(context, cVar);
        this.bzN = new ArrayList();
        this.bzQ = new ArrayList();
        this.cwr = cVar.bim;
        this.id = cVar.bil;
        this.bin = cVar.bin;
        this.context = context;
        this.cws = new TextureMapView(context);
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
        for (b bVar : this.bzN) {
            if (marker == bVar.cwd) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> qb(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.bzN) {
            if (bVar.cwc != null && TextUtils.equals(str, bVar.cwc.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a aI(View view) {
        for (a aVar : this.bzQ) {
            if (aVar.cwb == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.bzN) {
            this.cws.removeView(bVar.cwh);
        }
        this.bzN.clear();
        for (a aVar : this.bzQ) {
            this.cws.removeView(aVar.cwb);
        }
        this.bzQ.clear();
        this.cws.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: dy */
    public TextureMapView bn(@NonNull Context context) {
        return this.cws;
    }
}
