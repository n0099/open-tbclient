package com.baidu.sapi2.share.face;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
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
    public static final int FACE_SHARE_V2_MAX_ACCOUNT_SIZE = 10;
    public static final String KEY_FACE_LOGIN_LIVINGUNAMES = "livingunames";
    public static final String KEY_SHARE_FACE_LOGIN_V2 = "face_login_model_v2";
    public static final String TAG = "FaceLoginService";
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    private List<FaceLoginModel> getUidsMapFromV2PriStrage() {
        return str2ShareModelV2List(SapiContext.getInstance().getV2FaceLivingUnames());
    }

    public boolean isSupFaceLogin() {
        JSONObject v2FaceLoginCheckResults = SapiContext.getInstance().getV2FaceLoginCheckResults();
        if (v2FaceLoginCheckResults != null && v2FaceLoginCheckResults.has("list") && v2FaceLoginCheckResults.optJSONArray("list").length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin) {
            return true;
        }
        return false;
    }

    private String buildV2FaceUidString(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_FACE_LOGIN_LIVINGUNAMES, SapiUtils.map2JsonArray(map, "livinguname", "time"));
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private Map<String, Long> getLinkedHashMap(List<FaceLoginModel> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            for (FaceLoginModel faceLoginModel : list) {
                if (!linkedHashMap.containsKey(faceLoginModel.livingUname)) {
                    linkedHashMap.put(faceLoginModel.livingUname, Long.valueOf(faceLoginModel.time));
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

    private List<FaceLoginModel> getUidsFromV2ShareStorage() {
        ArrayList arrayList = new ArrayList();
        if (!SapiContext.getInstance().shareLivingunameEnable()) {
            return arrayList;
        }
        List<String> installedApps = ShareUtils.getInstalledApps(this.context);
        if (installedApps.isEmpty()) {
            return arrayList;
        }
        ShareStorage shareStorage = new ShareStorage();
        for (String str : installedApps) {
            arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(str, KEY_SHARE_FACE_LOGIN_V2)));
        }
        arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(SecurityUtil.md5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false))));
        return arrayList;
    }

    private void setV2ShareFaceUids(String str) {
        if (SapiContext.getInstance().getShareCommonStorageEnabel() && !TextUtils.isEmpty(str) && SapiContext.getInstance().shareLivingunameEnable()) {
            ShareStorage shareStorage = new ShareStorage();
            shareStorage.setSp(KEY_SHARE_FACE_LOGIN_V2, str);
            shareStorage.setSd(SecurityUtil.md5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false), str);
            return;
        }
        Log.i(TAG, "setV2ShareFaceUids false");
    }

    public List<FaceLoginModel> str2ShareModelV2List(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_FACE_LOGIN_LIVINGUNAMES);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong("time", 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new FaceLoginModel(optString, optLong));
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
            arrayList.add(new FaceLoginModel(str, System.currentTimeMillis()));
        }
        syncFaceLoginUidList(context, arrayList);
    }

    public void syncFaceLoginUidList(Context context, List<FaceLoginModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.addAll(getUidsMapFromV2PriStrage());
        arrayList.addAll(getUidsFromV2ShareStorage());
        Map<String, Long> linkedHashMap = getLinkedHashMap(arrayList);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : linkedHashMap.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("livinguname", str);
                jSONObject2.put("time", linkedHashMap.get(str));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException e) {
            Log.i(e);
        }
        String buildV2FaceUidString = buildV2FaceUidString(linkedHashMap);
        setV2ShareFaceUids(buildV2FaceUidString);
        SapiContext.getInstance().setV2FaceLivingunames(buildV2FaceUidString);
        SapiContext.getInstance().setV2FaceLoginCheckResults(jSONObject.toString());
    }
}
