package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.e;
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
/* loaded from: classes6.dex */
public class FaceLoginService {
    private static final String b = "FaceLoginService";
    private static final String c = "face_login_model_v2";
    private static final String d = "livingunames";
    private static final int e = 10;

    /* renamed from: a  reason: collision with root package name */
    private Context f3524a = SapiAccountManager.getInstance().getConfignation().context;

    private String a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d, SapiUtils.map2JsonArray(map, "livinguname", "time"));
            return jSONObject.toString();
        } catch (JSONException e2) {
            return null;
        }
    }

    private List<a> b() {
        return str2ShareModelV2List(SapiContext.getInstance().getV2FaceLivingUnames());
    }

    public boolean isSupFaceLogin() {
        JSONObject v2FaceLoginCheckResults = SapiContext.getInstance().getV2FaceLoginCheckResults();
        return v2FaceLoginCheckResults != null && v2FaceLoginCheckResults.has("list") && v2FaceLoginCheckResults.optJSONArray("list").length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
    }

    public List<a> str2ShareModelV2List(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(d);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong("time", 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new a(optString, optLong));
                    }
                }
            }
        } catch (Exception e2) {
        }
        return arrayList;
    }

    public void syncFaceLoginUID(Context context, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new a(str, System.currentTimeMillis()));
        }
        syncFaceLoginUidList(context, arrayList);
    }

    public void syncFaceLoginUidList(Context context, List<a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.addAll(b());
        arrayList.addAll(a());
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
        } catch (JSONException e2) {
            Log.i(e2);
        }
        String a3 = a(a2);
        a(a3);
        SapiContext.getInstance().setV2FaceLivingunames(a3);
        SapiContext.getInstance().setV2FaceLoginCheckResults(jSONObject.toString());
    }

    private void a(String str) {
        if (SapiContext.getInstance().getShareCommonStorageEnabel() && !TextUtils.isEmpty(str) && SapiContext.getInstance().shareLivingunameEnable()) {
            ShareStorage shareStorage = new ShareStorage();
            shareStorage.setSp(c, str);
            shareStorage.setSd(SecurityUtil.md5(c.getBytes(), false), str);
            return;
        }
        Log.i(b, "setV2ShareFaceUids false");
    }

    private Map<String, Long> a(List<a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null || list.isEmpty()) {
            return linkedHashMap;
        }
        Collections.sort(list);
        for (a aVar : list) {
            if (!linkedHashMap.containsKey(aVar.f3525a)) {
                linkedHashMap.put(aVar.f3525a, Long.valueOf(aVar.b));
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

    private List<a> a() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            List<Intent> c2 = e.c(this.f3524a);
            if (c2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : c2) {
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(intent.getComponent().getPackageName(), c)));
            }
            arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(SecurityUtil.md5(c.getBytes(), false))));
            return arrayList;
        }
        return arrayList;
    }
}
