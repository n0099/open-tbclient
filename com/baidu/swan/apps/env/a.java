package com.baidu.swan.apps.env;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.database.subpackage.SubPackageTable;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void p(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.f Ff = com.baidu.swan.apps.u.a.EH().Ff();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.u.a.Ew().wN())).addParam("data", jSONObject.toString()).cookieManager(Ff)).build().executeAsyncOnUIBack(CN());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void q(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> s = c.s(list);
            HashSet<String> hashSet = new HashSet(list);
            if (s != null) {
                hashSet.removeAll(s);
            }
            c.a("aiapp_setting_", hashSet, false);
            c.a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String hA = com.baidu.swan.apps.storage.b.hA(str);
                if (!TextUtils.isEmpty(hA)) {
                    com.baidu.swan.c.a.deleteFile(hA);
                }
                String hE = com.baidu.swan.apps.storage.b.hE(str);
                if (!TextUtils.isEmpty(hE)) {
                    com.baidu.swan.c.a.deleteFile(hE);
                }
            }
        }
    }

    public void eb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "删除包的APS记录: " + str);
            }
            eq(str);
            er(str);
        }
    }

    public void ep(String str) {
        SwanAppDbControl.aX(AppRuntime.getAppContext()).o(str, false);
        com.baidu.swan.pms.database.a.We().kq(str);
        com.baidu.swan.pms.database.a.We().c(com.baidu.swan.pms.model.f.class, str);
    }

    public void eo(String str) {
        com.baidu.swan.apps.database.subpackage.a.CK().eo(str);
    }

    private void eq(String str) {
        if (str != null) {
            com.baidu.b.a.c.a.N(Constants.VIA_REPORT_TYPE_QQFAVORITES, str);
            com.baidu.b.a.c.a.N("51", str);
        }
    }

    @NonNull
    private ResponseCallback<JSONObject> CN() {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.env.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (a.DEBUG) {
                    Log.d("AbsDefaultPurger", "parseResponse");
                }
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (a.DEBUG) {
                    Log.e("AbsDefaultPurger", "onSuccess: ");
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (a.DEBUG) {
                    Log.e("AbsDefaultPurger", "onFail: " + exc);
                }
            }
        };
    }

    private void er(String str) {
        List<String> es;
        if (!TextUtils.isEmpty(str) && (es = es(str)) != null && es.size() > 0) {
            for (String str2 : es) {
                if (!TextUtils.isEmpty(str2)) {
                    if (DEBUG) {
                        Log.d("AbsDefaultPurger", "删除分包的APS记录: " + str + " : " + str2);
                    }
                    eq(str2);
                }
            }
        }
    }

    private List<String> es(String str) {
        Cursor cursor;
        Closeable closeable = null;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.subpackage.b.avG, new String[]{SubPackageTable.Table.aps_package_name.toString()}, SubPackageTable.Table.app_id + " =? ", new String[]{str}, null);
            } catch (Throwable th) {
                th = th;
                closeable = " =? ";
                com.baidu.swan.c.a.c(closeable);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.c.a.c(closeable);
            throw th;
        }
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex(SubPackageTable.Table.aps_package_name.toString());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndex);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                com.baidu.swan.c.a.c(cursor);
            } catch (Exception e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.c.a.c(cursor);
                return arrayList;
            }
            return arrayList;
        }
        com.baidu.swan.c.a.c(cursor);
        return arrayList;
    }
}
