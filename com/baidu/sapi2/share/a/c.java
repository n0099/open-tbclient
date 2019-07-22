package com.baidu.sapi2.share.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.a.b;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static final String a = c.class.getSimpleName();
    public static final String b = "face_login_model";
    public static final String c = "face_login_model_v2";
    public static final String d = "livingunames";
    public static final long e = 1;
    public static final long f = 0;
    private static final int h = 10;
    public Context g = SapiAccountManager.getInstance().getConfignation().context;

    public void a(Context context, String str) {
        a(new b.a(str, System.currentTimeMillis()), false);
    }

    public void a(String str) {
        if (!SapiContext.getInstance(this.g).getShareCommonStorageEnabel() || TextUtils.isEmpty(str) || !SapiContext.getInstance(this.g).shareLivingunameEnable()) {
            Log.i(a, "setV2ShareFaceUids false");
            return;
        }
        ShareStorage shareStorage = new ShareStorage();
        shareStorage.setSp(c, str);
        shareStorage.setSd(MD5Util.toMd5(c.getBytes(), false), str);
    }

    public void a() {
        try {
            String faceLoginUid = SapiContext.getInstance(this.g).getFaceLoginUid();
            b.a aVar = null;
            if (!TextUtils.isEmpty(faceLoginUid)) {
                aVar = new b.a(faceLoginUid, 1L);
            }
            a(aVar, true);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    private void a(b.a aVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (aVar != null) {
            arrayList.add(aVar);
        }
        a(arrayList, z);
    }

    public void a(List<b.a> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        arrayList.addAll(c());
        arrayList.addAll(d());
        arrayList.addAll(e());
        arrayList.addAll(f());
        Map<String, Long> a2 = a(arrayList);
        if (!a2.isEmpty()) {
            if (z) {
                if (b(a2)) {
                    SapiAccountManager.getInstance().getAccountService().checkFaceLoginEnable(this.g, a2);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getAccountService().checkFaceLoginEnable(this.g, a2);
        }
    }

    public String a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d, SapiUtils.map2JsonArray(map, "livinguname", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
            return jSONObject.toString();
        } catch (JSONException e2) {
            return null;
        }
    }

    private Map<String, Long> a(List<b.a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null || list.isEmpty()) {
            return linkedHashMap;
        }
        Collections.sort(list);
        for (b.a aVar : list) {
            if (!linkedHashMap.containsKey(aVar.a)) {
                linkedHashMap.put(aVar.a, Long.valueOf(aVar.b));
            }
        }
        if (linkedHashMap.size() > 10) {
            Iterator it = linkedHashMap.entrySet().iterator();
            int size = linkedHashMap.size() - 10;
            for (int i = 0; it.hasNext() && i < size; i++) {
                it.next();
                it.remove();
            }
        }
        return linkedHashMap;
    }

    private List<b.a> c() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance(this.g).shareLivingunameEnable()) {
            List<Intent> a2 = com.baidu.sapi2.share.c.a(this.g);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                b d2 = d(shareStorage.getSp(intent.getComponent().getPackageName(), b));
                if (d2 != null) {
                    arrayList.add(new b.a(d2.f, 0L));
                }
            }
            b d3 = d(shareStorage.getSd(MD5Util.toMd5(b.getBytes(), false)));
            if (d3 != null) {
                arrayList.add(new b.a(d3.f, 0L));
            }
            return arrayList;
        }
        return arrayList;
    }

    private List<b.a> d() {
        return b(SapiContext.getInstance(this.g).getV2FaceLivingUnames());
    }

    private List<b.a> e() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance(this.g).shareLivingunameEnable()) {
            List<Intent> a2 = com.baidu.sapi2.share.c.a(this.g);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                arrayList.addAll(b(shareStorage.getSp(intent.getComponent().getPackageName(), c)));
            }
            arrayList.addAll(b(shareStorage.getSd(MD5Util.toMd5(c.getBytes(), false))));
            return arrayList;
        }
        return arrayList;
    }

    private List<b.a> f() {
        ArrayList arrayList = new ArrayList();
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null) {
            for (SapiAccount sapiAccount : loginAccounts) {
                arrayList.add(new b.a(sapiAccount.bduss, 0L));
            }
        }
        return arrayList;
    }

    public List<b.a> b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(d);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new b.a(optString, optLong));
                    }
                }
            }
        } catch (JSONException e2) {
        }
        return arrayList;
    }

    public Map<String, Long> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(d);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, Long.valueOf(optLong));
                    }
                }
            }
        } catch (JSONException e2) {
        }
        return hashMap;
    }

    public b d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            b a2 = b.a(new JSONObject(str));
            if (TextUtils.isEmpty(a2.f)) {
                return null;
            }
            if (a2.j.equals(SapiUtils.getClientId(this.g))) {
                return a2;
            }
            return null;
        } catch (JSONException e2) {
            return null;
        }
    }

    public void e(String str) {
        if (SapiContext.getInstance(this.g).getShareCommonStorageEnabel() && SapiContext.getInstance(this.g).shareLivingunameEnable() && !TextUtils.isEmpty(str)) {
            b bVar = new b();
            bVar.j = SapiUtils.getClientId(this.g);
            bVar.f = str;
            if (SapiAccountManager.getInstance().isLogin()) {
                bVar.i = SapiAccountManager.getInstance().getSession().displayname;
            }
            String jSONObject = bVar.a().toString();
            ShareStorage shareStorage = new ShareStorage();
            if (!jSONObject.equals(shareStorage.getSp(b))) {
                shareStorage.setSp(b, jSONObject);
            }
            String md5 = MD5Util.toMd5(b.getBytes(), false);
            if (!jSONObject.equals(shareStorage.getSd(md5))) {
                shareStorage.setSd(md5, jSONObject);
            }
        }
    }

    public boolean b(Map<String, Long> map) {
        String v2FaceLoginCheckResults = SapiContext.getInstance(this.g).getV2FaceLoginCheckResults();
        a aVar = new a();
        aVar.a(v2FaceLoginCheckResults);
        if (aVar.e.size() != map.size()) {
            Log.i(a, "meetReqFaceLoginCheck", "num not equal");
            return true;
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!aVar.e.containsKey(key)) {
                Log.i(a, "meetReqFaceLoginCheck", "num equal but uid not equal");
                return true;
            } else if (aVar.e.get(key).a != 0) {
                Log.i(a, "meetReqFaceLoginCheck", "exist uid can't not face login");
                return true;
            }
        }
        if (System.currentTimeMillis() - SapiContext.getInstance(this.g).getLastFaceLoginCheckTime() >= SapiContext.getInstance(this.g).getFaceLoginCheckFreq() * 60 * 60 * 1000) {
            Log.i(a, "meetReqFaceLoginCheck", "time meet");
            return true;
        }
        return false;
    }

    public boolean b() {
        return !TextUtils.isEmpty(SapiContext.getInstance(this.g).geSupFaceLoginType()) && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
    }
}
