package com.baidu.swan.pms.c.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
        int xE;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aWe() != null && bVar.bdg() == null && (xE = com.baidu.swan.pms.database.a.bci().xE(bVar.getBundleId())) >= 0) {
                bVar.bg(a.bf(com.baidu.swan.pms.database.a.bci().ai(bVar.getBundleId(), xE)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> etf;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aWe() {
            return this.mPaths;
        }

        public void J(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> bdg() {
            return this.etf;
        }

        public void bg(@Nullable List<a> list) {
            this.etf = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        private final String etd;
        private long ete = 0;
        private String mType;

        public a(String str) {
            this.etd = str;
        }

        public String bdf() {
            return this.etd;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public long getVersion() {
            return this.ete;
        }

        public void setVersion(long j) {
            this.ete = j;
        }

        @NonNull
        public static List<a> bf(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.erV);
                    aVar.setType(gVar.esa ? "independent" : "normal");
                    aVar.setVersion(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
