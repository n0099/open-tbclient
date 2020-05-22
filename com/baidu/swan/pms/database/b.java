package com.baidu.swan.pms.database;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.database.a.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b extends a {
    private c dlj = new c();

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean c(T t) {
        return d((b) t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> T c(Class<T> cls, String str) {
        return (T) d(cls, str);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean b(Class<T> cls, String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dlj.s(cls), "bundle_id =? ", new String[]{str}) > 0) {
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
    public boolean Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri s = this.dlj.s(PMSAppInfo.class);
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
    public boolean tg(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dlj.s(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0) {
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
    public boolean o(PMSAppInfo pMSAppInfo) {
        try {
            com.baidu.swan.pms.database.a.b r = this.dlj.r(pMSAppInfo.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dlj.s(pMSAppInfo.getClass()), r.af(pMSAppInfo));
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
    public Map<String, f> aFW() {
        HashMap hashMap = new HashMap();
        List<f> a = a(f.class, "state =? ", new String[]{"10"}, "version_code DESC");
        if (a != null && a.size() > 0) {
            for (f fVar : a) {
                if (fVar != null) {
                    hashMap.put(fVar.dlx, fVar);
                }
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.database.a
    public PMSAppInfo tf(String str) {
        return ti(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, PMSAppInfo> aFX() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [247=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x0057 */
    @Override // com.baidu.swan.pms.database.a
    public boolean V(String str, String str2, String str3) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                Uri s = this.dlj.s(g.class);
                r = this.dlj.r(g.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(s, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.f.b.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.f.b.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return false;
        }
        try {
            boolean z = r.j(cursor) != null;
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return z;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return false;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public void cJ(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dlj.s(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
            } catch (Exception e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public void th(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.dlj.s(g.class), "app_id=?", new String[]{str});
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
            arrayList.add(ContentProviderOperation.newInsert(this.dlj.s(f.class)).withValues(this.dlj.r(f.class).af(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b r = this.dlj.r(g.class);
            for (g gVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.dlj.s(g.class)).withValues(r.af(gVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dlj.s(com.baidu.swan.pms.model.d.class)).withValues(this.dlj.r(com.baidu.swan.pms.model.d.class).af(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dlj.s(com.baidu.swan.pms.model.b.class)).withValues(this.dlj.r(com.baidu.swan.pms.model.b.class).af(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.dlj.s(PMSAppInfo.class)).withValues(this.dlj.r(PMSAppInfo.class).af(pMSAppInfo)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(com.baidu.swan.pms.database.provider.b.cPg, arrayList);
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
            com.baidu.swan.pms.database.a.b r = this.dlj.r(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.dlj.s(t.getClass()), r.af(t));
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [447=4] */
    private <T> T d(Class<T> cls, String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b<T> r;
        Cursor cursor2 = null;
        try {
            r = this.dlj.r(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dlj.s(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.swan.pms.f.b.closeSafely(cursor2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            try {
                T j = r.j(cursor);
                com.baidu.swan.pms.f.b.closeSafely(cursor);
                return j;
            } catch (Exception e2) {
                e = e2;
                if (d.DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.pms.f.b.closeSafely(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            com.baidu.swan.pms.f.b.closeSafely(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [479=4] */
    private PMSAppInfo ti(String str) {
        Cursor cursor;
        com.baidu.swan.pms.database.a.b r;
        Cursor cursor2 = null;
        try {
            r = this.dlj.r(PMSAppInfo.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.dlj.s(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.swan.pms.f.b.closeSafely(cursor2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            try {
                PMSAppInfo pMSAppInfo = (PMSAppInfo) r.j(cursor);
                com.baidu.swan.pms.f.b.closeSafely(cursor);
                return pMSAppInfo;
            } catch (Exception e2) {
                e = e2;
                if (d.DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.pms.f.b.closeSafely(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            com.baidu.swan.pms.f.b.closeSafely(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [511=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x003f */
    private <T> List<T> a(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b<T> r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dlj.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dlj.s(cls), null, str, strArr, str2);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.f.b.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.f.b.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            List<T> h = r.h(cursor);
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return h;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [544=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x003f */
    private <T> List<T> b(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b<T> r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dlj.r(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dlj.s(cls), null, str, strArr, str2);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.f.b.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.f.b.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            List<T> h = r.h(cursor);
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return h;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean f(h hVar) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.dlj.s(hVar.getClass()), "bundle_id = ?  and version_name =? ", new String[]{hVar.dlx, hVar.versionName}) > 0) {
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
            if (AppRuntime.getAppContext().getContentResolver().update(this.dlj.s(hVar.getClass()), this.dlj.r(hVar.getClass()).af(hVar), "bundle_id = ?  and version_name =? ", new String[]{hVar.dlx, hVar.versionName}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [616=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004f: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x004f */
    @Override // com.baidu.swan.pms.database.a
    public h cK(String str, String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dlj.r(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.dlj.s(h.class), null, "bundle_id = ?  and version_name =? ", new String[]{str, str2}, null);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.f.b.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.f.b.closeSafely(closeable2);
            throw th;
        }
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            h hVar = (h) r.j(cursor);
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return hVar;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [649=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0065: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x0065 */
    @Override // com.baidu.swan.pms.database.a
    public com.baidu.swan.pms.b.a cL(@NonNull String str, @NonNull String str2) {
        Cursor cursor;
        Closeable closeable;
        com.baidu.swan.pms.database.a.b r;
        Uri s;
        Closeable closeable2 = null;
        try {
            try {
                r = this.dlj.r(com.baidu.swan.pms.b.a.class);
                s = this.dlj.s(com.baidu.swan.pms.b.a.class);
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.swan.pms.f.b.closeSafely(closeable2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.pms.f.b.closeSafely(closeable2);
            throw th;
        }
        if (r == null || s == null) {
            if (d.DEBUG) {
                throw new RuntimeException("dao or contentUri is null");
            }
            com.baidu.swan.pms.f.b.closeSafely(null);
            return null;
        }
        cursor = AppRuntime.getAppContext().getContentResolver().query(s, null, "app_id = ?  and bundle_id =? ", new String[]{str, str2}, null);
        if (cursor == null) {
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
        try {
            com.baidu.swan.pms.b.a aVar = (com.baidu.swan.pms.b.a) r.j(cursor);
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return aVar;
        } catch (Exception e2) {
            e = e2;
            if (d.DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.pms.f.b.closeSafely(cursor);
            return null;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean d(@NonNull com.baidu.swan.pms.b.a aVar) {
        try {
            com.baidu.swan.pms.database.a.b r = this.dlj.r(aVar.getClass());
            Uri s = this.dlj.s(aVar.getClass());
            if (r == null || s == null) {
                if (d.DEBUG) {
                    throw new RuntimeException("dao or contentUri is null");
                }
                return false;
            }
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(s, r.af(aVar));
            return insert != null && ContentUris.parseId(insert) > 0;
        } catch (Exception e) {
            if (d.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
