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

    public void O(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.f Ke = com.baidu.swan.apps.u.a.JG().Ke();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.u.a.Jv().BM())).addParam("data", jSONObject.toString()).cookieManager(Ke)).build().executeAsyncOnUIBack(HM());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void P(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> R = c.R(list);
            HashSet<String> hashSet = new HashSet(list);
            if (R != null) {
                hashSet.removeAll(R);
            }
            c.a("aiapp_setting_", hashSet, false);
            c.a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String ig = com.baidu.swan.apps.storage.b.ig(str);
                if (!TextUtils.isEmpty(ig)) {
                    com.baidu.swan.c.a.deleteFile(ig);
                }
                String ik = com.baidu.swan.apps.storage.b.ik(str);
                if (!TextUtils.isEmpty(ik)) {
                    com.baidu.swan.c.a.deleteFile(ik);
                }
            }
        }
    }

    public void eK(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "删除包的APS记录: " + str);
            }
            eZ(str);
            fa(str);
        }
    }

    public void eY(String str) {
        SwanAppDbControl.aZ(AppRuntime.getAppContext()).r(str, false);
        com.baidu.swan.pms.database.a.aaV().kU(str);
        com.baidu.swan.pms.database.a.aaV().b(com.baidu.swan.pms.model.f.class, str);
    }

    public void eX(String str) {
        com.baidu.swan.apps.database.subpackage.a.HJ().eX(str);
    }

    private void eZ(String str) {
        if (str != null) {
            com.baidu.a.a.c.a.F(Constants.VIA_REPORT_TYPE_QQFAVORITES, str);
            com.baidu.a.a.c.a.F("51", str);
        }
    }

    @NonNull
    private ResponseCallback<JSONObject> HM() {
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

    private void fa(String str) {
        List<String> fb;
        if (!TextUtils.isEmpty(str) && (fb = fb(str)) != null && fb.size() > 0) {
            for (String str2 : fb) {
                if (!TextUtils.isEmpty(str2)) {
                    if (DEBUG) {
                        Log.d("AbsDefaultPurger", "删除分包的APS记录: " + str + " : " + str2);
                    }
                    eZ(str2);
                }
            }
        }
    }

    private List<String> fb(String str) {
        Cursor cursor;
        Closeable closeable = null;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(com.baidu.swan.apps.database.subpackage.b.aPb, new String[]{SubPackageTable.Table.aps_package_name.toString()}, SubPackageTable.Table.app_id + " =? ", new String[]{str}, null);
            } catch (Throwable th) {
                th = th;
                closeable = " =? ";
                com.baidu.swan.c.a.b(closeable);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.c.a.b(closeable);
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
                com.baidu.swan.c.a.b(cursor);
            } catch (Exception e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.c.a.b(cursor);
                return arrayList;
            }
            return arrayList;
        }
        com.baidu.swan.c.a.b(cursor);
        return arrayList;
    }
}
