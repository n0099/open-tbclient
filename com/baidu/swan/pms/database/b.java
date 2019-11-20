package com.baidu.swan.pms.database;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.a.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends a {
    private c bKO = new c();

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean c(T t) {
        return e(t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean d(T t) {
        return f((b) t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean b(Class<T> cls, String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.bKO.k(cls), "bundle_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean I(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri k = this.bKO.k(PMSAppInfo.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i));
            return AppRuntime.getAppContext().getContentResolver().update(k, contentValues, "app_id =? ", new String[]{str}) > 0;
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean kU(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.bKO.k(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean f(PMSAppInfo pMSAppInfo) {
        try {
            com.baidu.swan.pms.database.a.b j = this.bKO.j(pMSAppInfo.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.bKO.k(pMSAppInfo.getClass()), j.S(pMSAppInfo));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public PMSAppInfo kT(String str) {
        return kV(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, PMSAppInfo> aaW() {
        HashMap hashMap = new HashMap();
        List<PMSAppInfo> a = a(PMSAppInfo.class, null, null, null);
        if (a != null && a.size() > 0) {
            for (PMSAppInfo pMSAppInfo : a) {
                if (pMSAppInfo != null) {
                    hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                }
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean a(f fVar, List<h> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (fVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.bKO.k(f.class)).withValues(this.bKO.j(f.class).S(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b j = this.bKO.j(h.class);
            for (h hVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.bKO.k(h.class)).withValues(j.S(hVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.bKO.k(d.class)).withValues(this.bKO.j(d.class).S(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.bKO.k(com.baidu.swan.pms.model.b.class)).withValues(this.bKO.j(com.baidu.swan.pms.model.b.class).S(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.bKO.k(PMSAppInfo.class)).withValues(this.bKO.j(PMSAppInfo.class).S(pMSAppInfo)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(com.baidu.swan.pms.database.provider.b.aPa, arrayList);
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
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public <T extends e> boolean e(T t) {
        try {
            com.baidu.swan.pms.database.a.b j = this.bKO.j(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.bKO.k(t.getClass()), j.S(t));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public <T extends e> boolean f(T t) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.bKO.k(t.getClass()), "bundle_id =? ", new String[]{t.bLj}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public PMSAppInfo kV(String str) {
        try {
            com.baidu.swan.pms.database.a.b j = this.bKO.j(PMSAppInfo.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.bKO.k(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
            if (query != null) {
                return (PMSAppInfo) j.h(query);
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <T> List<T> a(Class<T> cls, String str, String[] strArr, String str2) {
        try {
            com.baidu.swan.pms.database.a.b<T> j = this.bKO.j(cls);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.bKO.k(cls), null, str, strArr, str2);
            if (query != null) {
                return j.f(query);
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
