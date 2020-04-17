package com.baidu.swan.facade.provider.processor;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.facade.provider.processor.a {
    private static final String[] bRI = {IMConstants.MSG_ROW_ID, "app_id", "app_key", "app_sign", "version_code", SharedPrefConfig.VERSION_NAME, "description", "app_status", "status_detail", "status_desc", "resume_date", "icon_url", "app_name", "service_category", "subject_info", "type", "pkg_size", "app_category", "orientation", "create_time", "favorite_time"};

    @Override // com.baidu.swan.facade.provider.processor.a
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        List<C0355b> arG = arG();
        if (arG.isEmpty()) {
            return null;
        }
        HashMap<String, PMSAppInfo> arJ = com.baidu.swan.facade.provider.a.a.arJ();
        if (arJ.isEmpty()) {
            return null;
        }
        Collections.sort(arG, new a());
        MatrixCursor matrixCursor = new MatrixCursor(bRI, arG.size());
        int i = 0;
        Iterator<C0355b> it = arG.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return matrixCursor;
            }
            C0355b next = it.next();
            PMSAppInfo pMSAppInfo = arJ.get(next.appId);
            if (pMSAppInfo != null) {
                a(matrixCursor, i2, next, pMSAppInfo);
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    private void a(MatrixCursor matrixCursor, int i, C0355b c0355b, PMSAppInfo pMSAppInfo) {
        if (matrixCursor != null && i >= 0 && c0355b != null && pMSAppInfo != null) {
            matrixCursor.newRow().add(IMConstants.MSG_ROW_ID, Integer.valueOf(i)).add("app_id", pMSAppInfo.appId).add("app_key", pMSAppInfo.appKey).add("app_sign", Long.valueOf(pMSAppInfo.appSign)).add("version_code", Integer.valueOf(pMSAppInfo.versionCode)).add(SharedPrefConfig.VERSION_NAME, pMSAppInfo.versionName).add("description", pMSAppInfo.description).add("app_status", Integer.valueOf(pMSAppInfo.appStatus)).add("status_detail", pMSAppInfo.statusDetail).add("status_desc", pMSAppInfo.statusDesc).add("resume_date", pMSAppInfo.resumeDate).add("icon_url", pMSAppInfo.iconUrl).add("app_name", pMSAppInfo.appName).add("service_category", pMSAppInfo.serviceCategory).add("subject_info", pMSAppInfo.subjectInfo).add("type", Integer.valueOf(pMSAppInfo.type)).add("pkg_size", Long.valueOf(pMSAppInfo.pkgSize)).add("app_category", Integer.valueOf(pMSAppInfo.appCategory)).add("orientation", Integer.valueOf(pMSAppInfo.orientation)).add("create_time", Long.valueOf(pMSAppInfo.createTime)).add("favorite_time", Long.valueOf(c0355b.bRK));
        }
    }

    private List<C0355b> arG() {
        Cursor a2 = SwanAppDbControl.bO(AppRuntime.getAppContext()).a(null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (a2 != null && a2.moveToFirst()) {
            int columnIndex = a2.getColumnIndex("app_id");
            int columnIndex2 = a2.getColumnIndex("favorite_time");
            do {
                arrayList.add(new C0355b(a2.getString(columnIndex), a2.getLong(columnIndex2)));
            } while (a2.moveToNext());
            com.baidu.swan.d.c.closeSafely(a2);
            return arrayList;
        }
        com.baidu.swan.d.c.closeSafely(a2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.facade.provider.processor.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0355b {
        String appId;
        long bRK;

        C0355b(String str, long j) {
            this.appId = str;
            this.bRK = j;
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Comparator<C0355b> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0355b c0355b, C0355b c0355b2) {
            return Long.compare(c0355b2.bRK, c0355b.bRK);
        }
    }
}
