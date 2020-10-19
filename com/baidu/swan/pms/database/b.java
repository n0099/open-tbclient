package com.baidu.swan.pms.database;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b extends a {
    private com.baidu.swan.pms.database.a.c dTd = new com.baidu.swan.pms.database.a.c();

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean c(T t) {
        return d(t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> T c(Class<T> cls, String str) {
        return (T) d(cls, str);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean b(Class<T> cls, String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dTd.s(cls), "bundle_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean s(PMSAppInfo pMSAppInfo) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().update(this.dTd.s(pMSAppInfo.getClass()), this.dTd.r(pMSAppInfo.getClass()).aj(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean ac(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri s = this.dTd.s(PMSAppInfo.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i));
            return AppRuntime.getAppContext().getContentResolver().update(s, contentValues, "app_id =? ", new String[]{str}) > 0;
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean xG(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dTd.s(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean r(PMSAppInfo pMSAppInfo) {
        try {
            com.baidu.swan.pms.database.a.b r = this.dTd.r(pMSAppInfo.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dTd.s(pMSAppInfo.getClass()), r.aj(pMSAppInfo));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, f> aWP() {
        HashMap hashMap = new HashMap();
        List<f> a2 = a(f.class, "state =? ", new String[]{"10"}, "version_code ASC");
        if (a2 != null && a2.size() > 0) {
            for (f fVar : a2) {
                if (fVar != null) {
                    hashMap.put(fVar.dTs, fVar);
                }
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.database.a
    public PMSAppInfo xF(String str) {
        return xJ(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, PMSAppInfo> aWQ() {
        HashMap hashMap = new HashMap();
        List<PMSAppInfo> b = b(PMSAppInfo.class, null, null, null);
        if (b != null && b.size() > 0) {
            for (PMSAppInfo pMSAppInfo : b) {
                if (pMSAppInfo != null) {
                    hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                }
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [254=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x0057 */
    @Override // com.baidu.swan.pms.database.a
    public boolean X(String str, String str2, String str3) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                Uri s = this.dTd.s(g.class);
                r = this.dTd.r(g.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(s, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.utils.c.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return false;
        }
        try {
            boolean z = r.j(cursor) != null;
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return z;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=4] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.swan.pms.database.a
    @WorkerThread
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<g> ad(@NonNull String str, int i) {
        Cursor cursor;
        List<g> list;
        Cursor cursor2 = null;
        try {
            String str2 = i >= 0 ? "app_id=? and version_code=?" : "app_id=? and version_code>?";
            Uri s = this.dTd.s(g.class);
            com.baidu.swan.pms.database.a.b r = this.dTd.r(g.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(s, null, str2, new String[]{str, String.valueOf(i)}, null);
            if (cursor == null || r == null) {
                list = null;
            } else {
                try {
                    try {
                        list = r.h(cursor);
                    } catch (Exception e) {
                        e = e;
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.pms.utils.c.closeSafely(cursor);
                        list = null;
                        if (list != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    com.baidu.swan.pms.utils.c.closeSafely(cursor2);
                    throw th;
                }
            }
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
        return list != null ? Collections.emptyList() : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [312=4] */
    @Override // com.baidu.swan.pms.database.a
    @WorkerThread
    public int xH(@NonNull String str) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            i = cursor.getInt(0);
                            com.baidu.swan.pms.utils.c.closeSafely(cursor);
                            return i;
                        }
                    } catch (Exception e) {
                        e = e;
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.pms.utils.c.closeSafely(cursor);
                        return -1;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    com.baidu.swan.pms.utils.c.closeSafely(cursor2);
                    throw th;
                }
            }
            i = -1;
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return i;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public void dj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dTd.s(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
            } catch (Exception e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public void xI(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dTd.s(g.class), "app_id=?", new String[]{str});
            } catch (Exception e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean a(f fVar, PMSAppInfo pMSAppInfo) {
        return a(fVar, null, null, null, pMSAppInfo);
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean a(f fVar, List<g> list, com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (fVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dTd.s(f.class)).withValues(this.dTd.r(f.class).aj(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b r = this.dTd.r(g.class);
            for (g gVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.dTd.s(g.class)).withValues(r.aj(gVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dTd.s(com.baidu.swan.pms.model.d.class)).withValues(this.dTd.r(com.baidu.swan.pms.model.d.class).aj(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dTd.s(com.baidu.swan.pms.model.b.class)).withValues(this.dTd.r(com.baidu.swan.pms.model.b.class).aj(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dTd.s(PMSAppInfo.class)).withValues(this.dTd.r(PMSAppInfo.class).aj(pMSAppInfo)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(com.baidu.swan.pms.database.provider.b.dvL, arrayList);
            if (applyBatch == null) {
                return false;
            }
            for (ContentProviderResult contentProviderResult : applyBatch) {
                if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private <T extends e> boolean d(T t) {
        try {
            com.baidu.swan.pms.database.a.b r = this.dTd.r(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dTd.s(t.getClass()), r.aj(t));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=4] */
    private <T> T d(Class<T> cls, String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b<T> r;
        Cursor cursor2 = null;
        try {
            r = this.dTd.r(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            try {
                T j = r.j(cursor);
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return j;
            } catch (Exception e2) {
                e = e2;
                if (d.DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [540=4] */
    @Override // com.baidu.swan.pms.database.a
    @Nullable
    public i xE(String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b r;
        Cursor cursor2 = null;
        try {
            r = this.dTd.r(i.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            try {
                i iVar = (i) r.j(cursor);
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return iVar;
            } catch (Exception e2) {
                e = e2;
                if (d.DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [601=4] */
    private PMSAppInfo xJ(String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b r;
        Cursor cursor2 = null;
        try {
            r = this.dTd.r(PMSAppInfo.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            try {
                PMSAppInfo pMSAppInfo = (PMSAppInfo) r.j(cursor);
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return pMSAppInfo;
            } catch (Exception e2) {
                e = e2;
                if (d.DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.pms.utils.c.closeSafely(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            com.baidu.swan.pms.utils.c.closeSafely(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x003f */
    private <T> List<T> a(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b<T> r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dTd.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(cls), null, str, strArr, str2);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.utils.c.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            List<T> h = r.h(cursor);
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return h;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [666=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x003f */
    private <T> List<T> b(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b<T> r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dTd.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(cls), null, str, strArr, str2);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.utils.c.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            List<T> h = r.h(cursor);
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return h;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean f(h hVar) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dTd.s(hVar.getClass()), "bundle_id = ?  and version_name =? ", new String[]{hVar.dTs, hVar.versionName}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean g(h hVar) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().update(this.dTd.s(hVar.getClass()), this.dTd.r(hVar.getClass()).aj(hVar), "bundle_id = ?  and version_name =? ", new String[]{hVar.dTs, hVar.versionName}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [738=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x004f */
    @Override // com.baidu.swan.pms.database.a
    public h dk(String str, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dTd.r(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dTd.s(h.class), null, "bundle_id = ?  and version_name =? ", new String[]{str, str2}, null);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.utils.c.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.utils.c.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
        try {
            h hVar = (h) r.j(cursor);
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return hVar;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.utils.c.closeSafely(cursor);
            return null;
        }
    }
}
