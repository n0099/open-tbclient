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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.a<TextureMapView, com.baidu.swan.apps.w.a.c> {
    public String cNQ;
    public Context context;
    public List<b> dkg;
    public List<a> dkj;
    public String ese;
    @NonNull
    public TextureMapView esf;
    public String id;
    public boolean isShowLocation;

    public c(@NonNull Context context, @NonNull com.baidu.swan.apps.w.a.c cVar) {
        super(context, cVar);
        this.dkg = new ArrayList();
        this.dkj = new ArrayList();
        this.ese = cVar.cNP;
        this.id = cVar.cNO;
        this.cNQ = cVar.cNQ;
        this.context = context;
        this.esf = new TextureMapView(context);
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
        for (b bVar : this.dkg) {
            if (marker == bVar.erQ) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> yG(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.dkg) {
            if (bVar.erP != null && TextUtils.equals(str, bVar.erP.id)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public a bi(View view) {
        for (a aVar : this.dkj) {
            if (aVar.erO == view) {
                return aVar;
            }
        }
        return null;
    }

    public void clear() {
        for (b bVar : this.dkg) {
            this.esf.removeView(bVar.erU);
        }
        this.dkg.clear();
        for (a aVar : this.dkj) {
            this.esf.removeView(aVar.erO);
        }
        this.dkj.clear();
        this.esf.getMap().clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: eD */
    public TextureMapView cx(@NonNull Context context) {
        return this.esf;
    }
}
