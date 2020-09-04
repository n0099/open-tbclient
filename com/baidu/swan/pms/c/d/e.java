package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class e extends com.baidu.swan.pms.c.d.b {
    @WorkerThread
    public e(List<b> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d.b
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull b.a aVar, @Nullable com.baidu.swan.pms.utils.a aVar2) {
        int wC;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aNs() != null && bVar.aUs() == null && (wC = com.baidu.swan.pms.database.a.aTt().wC(bVar.getBundleId())) >= 0) {
                bVar.ay(a.ax(com.baidu.swan.pms.database.a.aTt().ac(bVar.getBundleId(), wC)));
            }
        }
    }

    /* loaded from: classes14.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> dGw;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aNs() {
            return this.mPaths;
        }

        public void A(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> aUs() {
            return this.dGw;
        }

        public void ay(@Nullable List<a> list) {
            this.dGw = list;
        }
    }

    /* loaded from: classes14.dex */
    public static class a {
        private final String dGv;
        private String mType;
        private long mVersion = 0;

        public a(String str) {
            this.dGv = str;
        }

        public String aUr() {
            return this.dGv;
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

        public void cn(long j) {
            this.mVersion = j;
        }

        @NonNull
        public static List<a> ax(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.dFn);
                    aVar.setType(gVar.dFs ? "independent" : "normal");
                    aVar.cn(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
