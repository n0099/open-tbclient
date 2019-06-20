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
    private c brI = new c();

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean c(T t) {
        return e(t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean d(T t) {
        return f((b) t);
    }

    @Override // com.baidu.swan.pms.database.a
    public <T extends e> boolean c(Class<T> cls, String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.brI.m(cls), "bundle_id =? ", new String[]{str}) > 0) {
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
            Uri m = this.brI.m(PMSAppInfo.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i));
            return AppRuntime.getAppContext().getContentResolver().update(m, contentValues, "app_id =? ", new String[]{str}) > 0;
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // com.baidu.swan.pms.database.a
    public boolean ki(String str) {
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.brI.m(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0) {
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
            com.baidu.swan.pms.database.a.b l = this.brI.l(pMSAppInfo.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.brI.m(pMSAppInfo.getClass()), l.U(pMSAppInfo));
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
    public PMSAppInfo kh(String str) {
        return kj(str);
    }

    @Override // com.baidu.swan.pms.database.a
    public Map<String, PMSAppInfo> Vm() {
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
            arrayList.add(ContentProviderOperation.newInsert(this.brI.m(f.class)).withValues(this.brI.l(f.class).U(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            com.baidu.swan.pms.database.a.b l = this.brI.l(h.class);
            for (h hVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.brI.m(h.class)).withValues(l.U(hVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.brI.m(d.class)).withValues(this.brI.l(d.class).U(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.brI.m(com.baidu.swan.pms.model.b.class)).withValues(this.brI.l(com.baidu.swan.pms.model.b.class).U(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.brI.m(PMSAppInfo.class)).withValues(this.brI.l(PMSAppInfo.class).U(pMSAppInfo)).build());
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
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public <T extends e> boolean e(T t) {
        try {
            com.baidu.swan.pms.database.a.b l = this.brI.l(t.getClass());
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.brI.m(t.getClass()), l.U(t));
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
            if (AppRuntime.getAppContext().getContentResolver().delete(this.brI.m(t.getClass()), "bundle_id =? ", new String[]{t.bsc}) > 0) {
                return true;
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public PMSAppInfo kj(String str) {
        try {
            com.baidu.swan.pms.database.a.b l = this.brI.l(PMSAppInfo.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.brI.m(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
            if (query != null) {
                return (PMSAppInfo) l.l(query);
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
            com.baidu.swan.pms.database.a.b<T> l = this.brI.l(cls);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.brI.m(cls), null, str, strArr, str2);
            if (query != null) {
                return l.j(query);
            }
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
