package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.d;
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
/* loaded from: classes2.dex */
public class FaceLoginService {

    /* renamed from: b  reason: collision with root package name */
    public static final String f11391b = "FaceLoginService";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11392c = "face_login_model_v2";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11393d = "livingunames";

    /* renamed from: e  reason: collision with root package name */
    public static final int f11394e = 10;

    /* renamed from: a  reason: collision with root package name */
    public Context f11395a = SapiAccountManager.getInstance().getConfignation().context;

    private String a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f11393d, SapiUtils.map2JsonArray(map, "livinguname", "time"));
            return jSONObject.toString();
        } catch (JSONException unused) {
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
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(f11393d);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong("time", 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new a(optString, optLong));
                    }
                }
            }
        } catch (Exception unused) {
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
            shareStorage.setSp(f11392c, str);
            shareStorage.setSd(SecurityUtil.md5(f11392c.getBytes(), false), str);
            return;
        }
        Log.i(f11391b, "setV2ShareFaceUids false");
    }

    private Map<String, Long> a(List<a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            for (a aVar : list) {
                if (!linkedHashMap.containsKey(aVar.f11396a)) {
                    linkedHashMap.put(aVar.f11396a, Long.valueOf(aVar.f11397b));
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
        }
        return linkedHashMap;
    }

    private List<a> a() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            List<Intent> a2 = d.a(this.f11395a);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(intent.getComponent().getPackageName(), f11392c)));
            }
            arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(SecurityUtil.md5(f11392c.getBytes(), false))));
            return arrayList;
        }
        return arrayList;
    }
}
