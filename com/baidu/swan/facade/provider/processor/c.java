package com.baidu.swan.facade.provider.processor;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.facade.provider.processor.a {
    private static final String[] cYO = {IMConstants.MSG_ROW_ID, "app_id", "app_key", "app_sign", "version_code", SharedPrefConfig.VERSION_NAME, "description", "app_status", "status_detail", "status_desc", "resume_date", "icon_url", "app_name", "service_category", "subject_info", "type", "pkg_size", "app_category", "orientation", "create_time", "app_from", "visit_time"};

    @Override // com.baidu.swan.facade.provider.processor.a
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        List<a> aQt = aQt();
        if (aQt.isEmpty()) {
            return null;
        }
        HashMap<String, PMSAppInfo> aQv = com.baidu.swan.facade.provider.a.a.aQv();
        if (aQv.isEmpty()) {
            return null;
        }
        Collections.sort(aQt, new b());
        MatrixCursor matrixCursor = new MatrixCursor(cYO, aQt.size());
        int i = 0;
        Iterator<a> it = aQt.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return matrixCursor;
            }
            a next = it.next();
            PMSAppInfo pMSAppInfo = aQv.get(next.appId);
            if (pMSAppInfo != null) {
                a(matrixCursor, i2, next, pMSAppInfo);
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    private void a(MatrixCursor matrixCursor, int i, a aVar, PMSAppInfo pMSAppInfo) {
        if (matrixCursor != null && i >= 0 && aVar != null && pMSAppInfo != null) {
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add("app_id", pMSAppInfo.appId).add("app_key", pMSAppInfo.appKey).add("app_sign", Long.valueOf(pMSAppInfo.appSign)).add("version_code", Long.valueOf(pMSAppInfo.versionCode)).add(SharedPrefConfig.VERSION_NAME, pMSAppInfo.versionName).add("description", pMSAppInfo.description).add("app_status", Integer.valueOf(pMSAppInfo.appStatus)).add("status_detail", pMSAppInfo.statusDetail).add("status_desc", pMSAppInfo.statusDesc).add("resume_date", pMSAppInfo.resumeDate).add("icon_url", pMSAppInfo.iconUrl).add("app_name", pMSAppInfo.appName).add("service_category", pMSAppInfo.serviceCategory).add("subject_info", pMSAppInfo.subjectInfo).add("type", Integer.valueOf(pMSAppInfo.type)).add("pkg_size", Long.valueOf(pMSAppInfo.pkgSize)).add("app_category", Integer.valueOf(pMSAppInfo.appCategory)).add("orientation", Integer.valueOf(pMSAppInfo.orientation)).add("create_time", Long.valueOf(pMSAppInfo.createTime)).add("app_from", aVar.from).add("visit_time", Long.valueOf(aVar.cZf));
        }
    }

    private List<a> aQt() {
        Cursor c = SwanAppDbControl.cP(AppRuntime.getAppContext()).c(null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (c != null && c.moveToFirst()) {
            int columnIndex = c.getColumnIndex("app_id");
            int columnIndex2 = c.getColumnIndex("app_from");
            int columnIndex3 = c.getColumnIndex("visit_time");
            do {
                arrayList.add(new a(c.getString(columnIndex), c.getString(columnIndex2), c.getLong(columnIndex3)));
            } while (c.moveToNext());
            com.baidu.swan.c.d.closeSafely(c);
            return arrayList;
        }
        com.baidu.swan.c.d.closeSafely(c);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        String appId;
        long cZf;
        String from;

        public a(String str, String str2, long j) {
            this.appId = str;
            this.from = str2;
            this.cZf = j;
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements Comparator<a> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return Long.compare(aVar2.cZf, aVar.cZf);
        }
    }
}
