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
/* loaded from: classes24.dex */
public class b extends a {
    private com.baidu.swan.pms.database.a.c dHc = new com.baidu.swan.pms.database.a.c();

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
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dHc.s(cls), "bundle_id =? ", new String[]{str}) > 0) {
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
            if (AppRuntime.getAppContext().getContentResolver().update(this.dHc.s(pMSAppInfo.getClass()), this.dHc.r(pMSAppInfo.getClass()).ag(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0) {
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
    public boolean ab(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri s = this.dHc.s(PMSAppInfo.class);
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
    public boolean wU(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dHc.s(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0) {
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
            com.baidu.swan.pms.database.a.b r = this.dHc.r(pMSAppInfo.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dHc.s(pMSAppInfo.getClass()), r.ag(pMSAppInfo));
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
    public Map<String, f> aUg() {
        HashMap hashMap = new HashMap();
        List<f> a = a(f.class, "state =? ", new String[]{"10"}, "version_code ASC");
        if (a != null && a.size() > 0) {
            for (f fVar : a) {
                if (fVar != null) {
                    hashMap.put(fVar.dHr, fVar);
                }
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.database.a
    public PMSAppInfo wT(String str) {
        return wX(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, PMSAppInfo> aUh() {
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
    public boolean W(String str, String str2, String str3) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                Uri s = this.dHc.s(g.class);
                r = this.dHc.r(g.class);
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
    public List<g> ac(@NonNull String str, int i) {
        Cursor cursor;
        List<g> list;
        Cursor cursor2 = null;
        try {
            String str2 = i >= 0 ? "app_id=? and version_code=?" : "app_id=? and version_code>?";
            Uri s = this.dHc.s(g.class);
            com.baidu.swan.pms.database.a.b r = this.dHc.r(g.class);
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
    public int wV(@NonNull String str) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
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
    public void de(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dHc.s(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
            } catch (Exception e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public void wW(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dHc.s(g.class), "app_id=?", new String[]{str});
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
            arrayList.add(ContentProviderOperation.newInsert(this.dHc.s(f.class)).withValues(this.dHc.r(f.class).ag(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b r = this.dHc.r(g.class);
            for (g gVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.dHc.s(g.class)).withValues(r.ag(gVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dHc.s(com.baidu.swan.pms.model.d.class)).withValues(this.dHc.r(com.baidu.swan.pms.model.d.class).ag(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dHc.s(com.baidu.swan.pms.model.b.class)).withValues(this.dHc.r(com.baidu.swan.pms.model.b.class).ag(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dHc.s(PMSAppInfo.class)).withValues(this.dHc.r(PMSAppInfo.class).ag(pMSAppInfo)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(com.baidu.swan.pms.database.provider.b.djF, arrayList);
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
            com.baidu.swan.pms.database.a.b r = this.dHc.r(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dHc.s(t.getClass()), r.ag(t));
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
            r = this.dHc.r(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
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
    public i wS(String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b r;
        Cursor cursor2 = null;
        try {
            r = this.dHc.r(i.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
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
    private PMSAppInfo wX(String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b r;
        Cursor cursor2 = null;
        try {
            r = this.dHc.r(PMSAppInfo.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
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
                r = this.dHc.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(cls), null, str, strArr, str2);
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
                r = this.dHc.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(cls), null, str, strArr, str2);
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
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dHc.s(hVar.getClass()), "bundle_id = ?  and version_name =? ", new String[]{hVar.dHr, hVar.versionName}) > 0) {
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
            if (AppRuntime.getAppContext().getContentResolver().update(this.dHc.s(hVar.getClass()), this.dHc.r(hVar.getClass()).ag(hVar), "bundle_id = ?  and version_name =? ", new String[]{hVar.dHr, hVar.versionName}) > 0) {
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
    public h df(String str, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dHc.r(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dHc.s(h.class), null, "bundle_id = ?  and version_name =? ", new String[]{str, str2}, null);
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
