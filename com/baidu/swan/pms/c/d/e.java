package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e extends com.baidu.swan.pms.c.d.b {
    @WorkerThread
    public e(List<b> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d.b
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull b.a aVar, @Nullable com.baidu.swan.pms.utils.a aVar2) {
        int yj;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aUy() != null && bVar.bbz() == null && (yj = com.baidu.swan.pms.database.a.baA().yj(bVar.getBundleId())) >= 0) {
                bVar.aW(a.aV(com.baidu.swan.pms.database.a.baA().af(bVar.getBundleId(), yj)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> ehi;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aUy() {
            return this.mPaths;
        }

        public void C(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> bbz() {
            return this.ehi;
        }

        public void aW(@Nullable List<a> list) {
            this.ehi = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        private final String ehh;
        private String mType;
        private long mVersion = 0;

        public a(String str) {
            this.ehh = str;
        }

        public String bby() {
            return this.ehh;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public long getVersion() {
            return this.mVersion;
        }

        public void cU(long j) {
            this.mVersion = j;
        }

        @NonNull
        public static List<a> aV(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.efY);
                    aVar.setType(gVar.egd ? "independent" : "normal");
                    aVar.cU(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
