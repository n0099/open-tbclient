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
import com.baidu.swan.pms.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends a {
    private c blG = new c();

    @Override // com.baidu.swan.pms.database.a
    public <T extends f> boolean c(T t) {
        return d(t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends f> boolean c(Class<T> cls, String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.blG.n(cls), "bundle_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean N(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri n = this.blG.n(com.baidu.swan.pms.model.a.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i));
            return AppRuntime.getAppContext().getContentResolver().update(n, contentValues, "app_id =? ", new String[]{str}) > 0;
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean jk(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.blG.n(com.baidu.swan.pms.model.a.class), "app_id =? ", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean f(com.baidu.swan.pms.model.a aVar) {
        try {
            com.baidu.swan.pms.database.a.b m = this.blG.m(aVar.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.blG.n(aVar.getClass()), m.U(aVar));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.swan.pms.database.a
    public com.baidu.swan.pms.model.a jj(String str) {
        return jl(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, com.baidu.swan.pms.model.a> Rz() {
        HashMap hashMap = new HashMap();
        List<com.baidu.swan.pms.model.a> a = a(com.baidu.swan.pms.model.a.class, null, null, null);
        if (a != null && a.size() > 0) {
            for (com.baidu.swan.pms.model.a aVar : a) {
                if (aVar != null) {
                    hashMap.put(aVar.appId, aVar);
                }
            }
        }
        return hashMap;
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean a(g gVar, List<i> list, com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.model.c cVar, com.baidu.swan.pms.model.a aVar) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (gVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.blG.n(g.class)).withValues(this.blG.m(g.class).U(gVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b m = this.blG.m(i.class);
            for (i iVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.blG.n(i.class)).withValues(m.U(iVar)).build());
            }
        }
        if (eVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.blG.n(com.baidu.swan.pms.model.e.class)).withValues(this.blG.m(com.baidu.swan.pms.model.e.class).U(eVar)).build());
        }
        if (cVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.blG.n(com.baidu.swan.pms.model.c.class)).withValues(this.blG.m(com.baidu.swan.pms.model.c.class).U(cVar)).build());
        }
        if (aVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.blG.n(com.baidu.swan.pms.model.a.class)).withValues(this.blG.m(com.baidu.swan.pms.model.a.class).U(aVar)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(com.baidu.swan.pms.database.provider.b.AUTHORITY, arrayList);
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
            if (e.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public <T extends f> boolean d(T t) {
        try {
            com.baidu.swan.pms.database.a.b m = this.blG.m(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.blG.n(t.getClass()), m.U(t));
            if (insert != null) {
                if (ContentUris.parseId(insert) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public com.baidu.swan.pms.model.a jl(String str) {
        try {
            com.baidu.swan.pms.database.a.b m = this.blG.m(com.baidu.swan.pms.model.a.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.blG.n(com.baidu.swan.pms.model.a.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
            if (query != null) {
                return (com.baidu.swan.pms.model.a) m.l(query);
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <T> List<T> a(Class<T> cls, String str, String[] strArr, String str2) {
        try {
            com.baidu.swan.pms.database.a.b<T> m = this.blG.m(cls);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.blG.n(cls), null, str, strArr, str2);
            if (query != null) {
                return m.j(query);
            }
        } catch (Exception e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
