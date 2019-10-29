package com.baidu.sapi2.share.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static final String a = b.class.getSimpleName();
    private static final String b = "face_login_model_v2";
    private static final String c = "livingunames";
    private static final int d = 10;
    private Context e = SapiAccountManager.getInstance().getConfignation().context;

    public void a(Context context, List<a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.addAll(b());
        arrayList.addAll(c());
        Map<String, Long> a2 = a(arrayList);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : a2.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("livinguname", str);
                jSONObject2.put("time", a2.get(str));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException e) {
            Log.i(e);
        }
        String a3 = a(a2);
        b(a3);
        SapiContext.getInstance(context).setV2FaceLivingunames(a3);
        SapiContext.getInstance(context).setV2FaceLoginCheckResults(jSONObject.toString());
    }

    public void a(Context context, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new a(str, System.currentTimeMillis()));
        }
        a(context, arrayList);
    }

    private String a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(c, SapiUtils.map2JsonArray(map, "livinguname", "time"));
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private void b(String str) {
        if (!SapiContext.getInstance(this.e).getShareCommonStorageEnabel() || TextUtils.isEmpty(str) || !SapiContext.getInstance(this.e).shareLivingunameEnable()) {
            Log.i(a, "setV2ShareFaceUids false");
            return;
        }
        ShareStorage shareStorage = new ShareStorage();
        shareStorage.setSp(b, str);
        shareStorage.setSd(MD5Util.toMd5(b.getBytes(), false), str);
    }

    private Map<String, Long> a(List<a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null || list.isEmpty()) {
            return linkedHashMap;
        }
        Collections.sort(list);
        for (a aVar : list) {
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

    private List<a> b() {
        return a(SapiContext.getInstance(this.e).getV2FaceLivingUnames());
    }

    private List<a> c() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance(this.e).shareLivingunameEnable()) {
            List<Intent> a2 = c.a(this.e);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                arrayList.addAll(a(shareStorage.getSp(intent.getComponent().getPackageName(), b)));
            }
            arrayList.addAll(a(shareStorage.getSd(MD5Util.toMd5(b.getBytes(), false))));
            return arrayList;
        }
        return arrayList;
    }

    public List<a> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(c);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong("time", 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new a(optString, optLong));
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public boolean a() {
        JSONObject v2FaceLoginCheckResults = SapiContext.getInstance(this.e).getV2FaceLoginCheckResults();
        return v2FaceLoginCheckResults != null && v2FaceLoginCheckResults.has("list") && v2FaceLoginCheckResults.optJSONArray("list").length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
    }
}
