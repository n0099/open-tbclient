package com.baidu.swan.pms.c.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends com.baidu.swan.pms.c.d.b {
    @WorkerThread
    public e(List<b> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d.b
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull b.a aVar, @Nullable com.baidu.swan.pms.utils.a aVar2) {
        int xX;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aWq() != null && bVar.bdt() == null && (xX = com.baidu.swan.pms.database.a.bcv().xX(bVar.getBundleId())) >= 0) {
                bVar.bb(a.ba(com.baidu.swan.pms.database.a.bcv().ak(bVar.getBundleId(), xX)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> evl;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aWq() {
            return this.mPaths;
        }

        public void J(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> bdt() {
            return this.evl;
        }

        public void bb(@Nullable List<a> list) {
            this.evl = list;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private final String evj;
        private long evk = 0;
        private String mType;

        public a(String str) {
            this.evj = str;
        }

        public String bds() {
            return this.evj;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public long getVersion() {
            return this.evk;
        }

        public void setVersion(long j) {
            this.evk = j;
        }

        @NonNull
        public static List<a> ba(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.euc);
                    aVar.setType(gVar.euh ? "independent" : "normal");
                    aVar.setVersion(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
