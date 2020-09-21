package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes24.dex */
public class e extends com.baidu.swan.pms.c.d.b {
    @WorkerThread
    public e(List<b> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d.b
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull b.a aVar, @Nullable com.baidu.swan.pms.utils.a aVar2) {
        int wV;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aOd() != null && bVar.aVe() == null && (wV = com.baidu.swan.pms.database.a.aUf().wV(bVar.getBundleId())) >= 0) {
                bVar.aC(a.aB(com.baidu.swan.pms.database.a.aUf().ac(bVar.getBundleId(), wV)));
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> dIA;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aOd() {
            return this.mPaths;
        }

        public void A(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> aVe() {
            return this.dIA;
        }

        public void aC(@Nullable List<a> list) {
            this.dIA = list;
        }
    }

    /* loaded from: classes24.dex */
    public static class a {
        private final String dIz;
        private String mType;
        private long mVersion = 0;

        public a(String str) {
            this.dIz = str;
        }

        public String aVd() {
            return this.dIz;
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

        public void co(long j) {
            this.mVersion = j;
        }

        @NonNull
        public static List<a> aB(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.dHr);
                    aVar.setType(gVar.dHw ? "independent" : "normal");
                    aVar.co(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
