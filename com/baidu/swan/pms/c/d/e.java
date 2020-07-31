package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes19.dex */
public class e extends com.baidu.swan.pms.c.d.b {
    @WorkerThread
    public e(List<b> list, @Nullable com.baidu.swan.pms.f.a aVar) {
        super((List<? extends b.a>) list, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d.b
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull b.a aVar, @Nullable com.baidu.swan.pms.f.a aVar2) {
        int us;
        super.a(map, map2, aVar, aVar2);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.aEE() != null && bVar.aLT() == null && (us = com.baidu.swan.pms.database.a.aKS().us(bVar.getBundleId())) >= 0) {
                bVar.ay(a.ax(com.baidu.swan.pms.database.a.aKS().aa(bVar.getBundleId(), us)));
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class b extends b.a {
        @Nullable
        private List<a> dxn;
        @Nullable
        private String[] mPaths;

        public b(String str) {
            super(str);
        }

        @Nullable
        public String[] aEE() {
            return this.mPaths;
        }

        public void z(@Nullable String[] strArr) {
            this.mPaths = strArr;
        }

        @Nullable
        public List<a> aLT() {
            return this.dxn;
        }

        public void ay(@Nullable List<a> list) {
            this.dxn = list;
        }
    }

    /* loaded from: classes19.dex */
    public static class a {
        private final String dxm;
        private String mType;
        private int mVersion = 0;

        public a(String str) {
            this.dxm = str;
        }

        public String aLS() {
            return this.dxm;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public int getVersion() {
            return this.mVersion;
        }

        public void setVersion(int i) {
            this.mVersion = i;
        }

        @NonNull
        public static List<a> ax(@Nullable List<com.baidu.swan.pms.model.g> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return arrayList;
            }
            for (com.baidu.swan.pms.model.g gVar : list) {
                if (gVar != null) {
                    a aVar = new a(gVar.dvZ);
                    aVar.setType(gVar.dwl ? "independent" : "normal");
                    aVar.setVersion(gVar.versionCode);
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }
}
