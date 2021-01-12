package com.baidu.swan.impl.map.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String cJe;
    public Context context;
    public List<b> dfr;
    public List<a> dfu;
    public String enp;
    @NonNull
    public TextureMapView enq;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.dfr = new ArrayList();
        this.dfu = new ArrayList();
        this.enp = cVar.cJd;
        this.id = cVar.cJc;
        this.cJe = cVar.cJe;
        this.context = context;
        this.enq = new TextureMapView(context);
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
        for (b bVar : this.dfr) {
            if (marker == bVar.ena) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> xv(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.dfr) {
            if (bVar.emZ != null && TextUtils.equals(str, bVar.emZ.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a bi(View view) {
        for (a aVar : this.dfu) {
            if (aVar.emY == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.dfr) {
            this.enq.removeView(bVar.enf);
        }
        this.dfr.clear();
        for (a aVar : this.dfu) {
            this.enq.removeView(aVar.emY);
        }
        this.dfu.clear();
        this.enq.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: eC */
    public TextureMapView cw(@NonNull Context context) {
        return this.enq;
    }
}
