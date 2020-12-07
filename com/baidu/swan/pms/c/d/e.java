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
        int yQ;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aXD() != null && bVar.beE() == null && (yQ = com.baidu.swan.pms.database.a.bdF().yQ(bVar.getBundleId())) >= 0) {
                bVar.aZ(a.aY(com.baidu.swan.pms.database.a.bdF().ag(bVar.getBundleId(), yQ)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> eok;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aXD() {
            return this.mPaths;
        }

        public void C(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> beE() {
            return this.eok;
        }

        public void aZ(@Nullable List<a> list) {
            this.eok = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        private final String eoj;
        private String mType;
        private long mVersion = 0;

        public a(String str) {
            this.eoj = str;
        }

        public String beD() {
            return this.eoj;
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

        public void dt(long j) {
            this.mVersion = j;
        }

        @NonNull
        public static List<a> aY(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.emZ);
                    aVar.setType(gVar.enf ? "independent" : "normal");
                    aVar.dt(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
