package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.c;
import com.baidu.sapi2.share.face.FaceLoginModel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FaceLoginService {
    public static final String KEY_FACE_LOGIN_LIVINGUNAMES = "livingunames";
    public static final String KEY_SHARE_FACE_LOGIN_V1 = "face_login_model";
    public static final String KEY_SHARE_FACE_LOGIN_V2 = "face_login_model_v2";
    public static final String TAG = FaceLoginService.class.getSimpleName();
    public static final long WEIGHT_OLD_LOCAL_STORAGE = 1;
    public static final long WEIGHT_OLD_SHARE_STORAGE = 0;
    private static final int a = 10;
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    public void syncFaceLoginUID(Context context, String str) {
        a(new FaceLoginModel.a(str, System.currentTimeMillis()), false);
    }

    public void setV2ShareFaceUids(String str) {
        if (!SapiContext.getInstance(this.context).getShareCommonStorageEnabel() || TextUtils.isEmpty(str) || !SapiContext.getInstance(this.context).shareLivingunameEnable()) {
            Log.i(TAG, "setV2ShareFaceUids false");
            return;
        }
        ShareStorage shareStorage = new ShareStorage();
        shareStorage.setSp(KEY_SHARE_FACE_LOGIN_V2, str);
        shareStorage.setSd(MD5Util.toMd5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false), str);
    }

    public void requestFaceLoginModel() {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.face.FaceLoginService.1
            @Override // java.lang.Runnable
            public void run() {
                String faceLoginUid = SapiContext.getInstance(FaceLoginService.this.context).getFaceLoginUid();
                FaceLoginModel.a aVar = null;
                if (!TextUtils.isEmpty(faceLoginUid)) {
                    aVar = new FaceLoginModel.a(faceLoginUid, 1L);
                }
                FaceLoginService.this.a(aVar, true);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceLoginModel.a aVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (aVar != null) {
            arrayList.add(aVar);
        }
        syncPriWithShare(arrayList, z);
    }

    public void syncPriWithShare(List<FaceLoginModel.a> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        arrayList.addAll(a());
        arrayList.addAll(b());
        arrayList.addAll(c());
        Map<String, Long> a2 = a(arrayList);
        if (!a2.isEmpty()) {
            if (z) {
                if (meetReqFaceLoginCheck(a2)) {
                    SapiAccountManager.getInstance().getAccountService().checkFaceLoginEnable(this.context, a2);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getAccountService().checkFaceLoginEnable(this.context, a2);
        }
    }

    public String buildV2FaceUidString(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_FACE_LOGIN_LIVINGUNAMES, SapiUtils.map2JsonArray(map, "livinguname", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private Map<String, Long> a(List<FaceLoginModel.a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null || list.isEmpty()) {
            return linkedHashMap;
        }
        Collections.sort(list, new Comparator<FaceLoginModel.a>() { // from class: com.baidu.sapi2.share.face.FaceLoginService.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(FaceLoginModel.a aVar, FaceLoginModel.a aVar2) {
                if (aVar.b - aVar2.b > 0) {
                    return 1;
                }
                return aVar.b - aVar2.b == 0 ? 0 : -1;
            }
        });
        for (FaceLoginModel.a aVar : list) {
            linkedHashMap.put(aVar.a, Long.valueOf(aVar.b));
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

    private List<FaceLoginModel.a> a() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance(this.context).shareLivingunameEnable()) {
            List<Intent> a2 = c.a(this.context);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                FaceLoginModel convertResult2Model = convertResult2Model(shareStorage.getSp(intent.getComponent().getPackageName(), KEY_SHARE_FACE_LOGIN_V1));
                if (convertResult2Model != null) {
                    arrayList.add(new FaceLoginModel.a(convertResult2Model.livingUid, 0L));
                }
            }
            FaceLoginModel convertResult2Model2 = convertResult2Model(shareStorage.getSd(MD5Util.toMd5(KEY_SHARE_FACE_LOGIN_V1.getBytes(), false)));
            if (convertResult2Model2 != null) {
                arrayList.add(new FaceLoginModel.a(convertResult2Model2.livingUid, 0L));
            }
            return arrayList;
        }
        return arrayList;
    }

    private List<FaceLoginModel.a> b() {
        return str2ShareModelV2List(SapiContext.getInstance(this.context).getV2FaceLivingUnames());
    }

    private List<FaceLoginModel.a> c() {
        ArrayList arrayList = new ArrayList();
        if (SapiContext.getInstance(this.context).shareLivingunameEnable()) {
            List<Intent> a2 = c.a(this.context);
            if (a2.isEmpty()) {
                return arrayList;
            }
            ShareStorage shareStorage = new ShareStorage();
            for (Intent intent : a2) {
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(intent.getComponent().getPackageName(), KEY_SHARE_FACE_LOGIN_V2)));
            }
            arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(MD5Util.toMd5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false))));
            return arrayList;
        }
        return arrayList;
    }

    public List<FaceLoginModel.a> str2ShareModelV2List(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_FACE_LOGIN_LIVINGUNAMES);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new FaceLoginModel.a(optString, optLong));
                    }
                }
            }
        } catch (JSONException e) {
        }
        return arrayList;
    }

    public Map<String, Long> str2ShareMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_FACE_LOGIN_LIVINGUNAMES);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L);
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, Long.valueOf(optLong));
                    }
                }
            }
        } catch (JSONException e) {
        }
        return hashMap;
    }

    public FaceLoginModel convertResult2Model(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            FaceLoginModel fromJSON = FaceLoginModel.fromJSON(new JSONObject(str));
            if (TextUtils.isEmpty(fromJSON.livingUid)) {
                return null;
            }
            if (fromJSON.cuid.equals(SapiUtils.getClientId(this.context))) {
                return fromJSON;
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    public void setFaceCheckResult2OldShareStorage(String str) {
        if (SapiContext.getInstance(this.context).getShareCommonStorageEnabel() && SapiContext.getInstance(this.context).shareLivingunameEnable() && !TextUtils.isEmpty(str)) {
            FaceLoginModel faceLoginModel = new FaceLoginModel();
            faceLoginModel.cuid = SapiUtils.getClientId(this.context);
            faceLoginModel.livingUid = str;
            if (SapiAccountManager.getInstance().isLogin()) {
                faceLoginModel.displayName = SapiAccountManager.getInstance().getSession().displayname;
            }
            String jSONObject = faceLoginModel.toJSON().toString();
            ShareStorage shareStorage = new ShareStorage();
            if (!jSONObject.equals(shareStorage.getSp(KEY_SHARE_FACE_LOGIN_V1))) {
                shareStorage.setSp(KEY_SHARE_FACE_LOGIN_V1, jSONObject);
            }
            String md5 = MD5Util.toMd5(KEY_SHARE_FACE_LOGIN_V1.getBytes(), false);
            if (!jSONObject.equals(shareStorage.getSd(md5))) {
                shareStorage.setSd(md5, jSONObject);
            }
        }
    }

    public boolean meetReqFaceLoginCheck(Map<String, Long> map) {
        String v2FaceLoginCheckResults = SapiContext.getInstance(this.context).getV2FaceLoginCheckResults();
        a aVar = new a();
        aVar.a(v2FaceLoginCheckResults);
        if (aVar.e.size() != map.size()) {
            Log.i(TAG, "meetReqFaceLoginCheck", "num not equal");
            return true;
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!aVar.e.containsKey(key)) {
                Log.i(TAG, "meetReqFaceLoginCheck", "num equal but uid not equal");
                return true;
            } else if (aVar.e.get(key).a != 0) {
                Log.i(TAG, "meetReqFaceLoginCheck", "exist uid can't not face login");
                return true;
            }
        }
        if (System.currentTimeMillis() - SapiContext.getInstance(this.context).getLastFaceLoginCheckTime() >= SapiContext.getInstance(this.context).getFaceLoginCheckFreq() * 60 * 60 * 1000) {
            Log.i(TAG, "meetReqFaceLoginCheck", "time meet");
            return true;
        }
        return false;
    }

    public boolean isSupFaceLogin() {
        return !TextUtils.isEmpty(SapiContext.getInstance(this.context).geSupFaceLoginType()) && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
    }
}
