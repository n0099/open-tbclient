package com.baidu.ar.parser;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.AttrData;
import com.baidu.ar.bean.FunctionType;
import com.baidu.ar.bean.TipBean;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.bean.b;
import com.baidu.ar.bean.d;
import com.baidu.ar.bean.e;
import com.baidu.ar.bean.f;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.representation.c;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Constants;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ParserJson {
    private ParserJson() {
    }

    private static ARResource a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("ar_key");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        int optInt = jSONObject.optInt("ar_type");
        String optString2 = jSONObject.optString(ARResourceKey.THUMBNAIL);
        String optString3 = jSONObject.optString(ARResourceKey.HTTP_VERSION_CODE);
        ARResource aRResource = new ARResource();
        aRResource.setKey(optString);
        aRResource.setType(optInt);
        aRResource.setThumbnailUrl(optString2);
        aRResource.setVersionCode(optString3);
        return aRResource;
    }

    private static TipBean a(JSONObject jSONObject, String str) {
        int parseInt;
        TipBean tipBean = new TipBean();
        try {
            if (jSONObject.has("udt_tip_simple")) {
                tipBean.setDemarcateTip(jSONObject.getString("udt_tip_simple"));
            }
            if (jSONObject.has("udt_tip_detail")) {
                tipBean.setDemarcateFailedTip(jSONObject.getString("udt_tip_detail"));
            }
            if (jSONObject.has(TrackReferenceTypeBox.TYPE1)) {
                tipBean.setHint(jSONObject.getString(TrackReferenceTypeBox.TYPE1));
            }
            if (jSONObject.has("too_far_hint")) {
                tipBean.setTooFarHint(jSONObject.getString("too_far_hint"));
            }
            if (jSONObject.has("too_near_hint")) {
                tipBean.setTooNearHint(jSONObject.getString("too_near_hint"));
            }
            if (jSONObject.has("not_find_hint")) {
                tipBean.setNotFindHint(jSONObject.getString("not_find_hint"));
            }
            if (jSONObject.has("far_threshold")) {
                tipBean.setFarThreshold(Float.parseFloat(jSONObject.getString("far_threshold")));
            }
            if (jSONObject.has("near_threshold")) {
                tipBean.setNearThreshold(Float.parseFloat(jSONObject.getString("near_threshold")));
            }
            if (jSONObject.has("case_type") && (parseInt = Integer.parseInt(jSONObject.getString("case_type"))) >= 0 && parseInt < AttrData.CaseType.values().length) {
                tipBean.setCaseType(AttrData.CaseType.values()[parseInt]);
            }
            if (jSONObject.has("udt_mode")) {
                tipBean.setUdtMode(Integer.parseInt(jSONObject.getString("udt_mode")));
            }
            if (jSONObject.has("help_url")) {
                tipBean.setHelpUrl(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("help_url_show_once")) {
                tipBean.setHelpUrlShowOnce(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("help_url_show_once")) {
                tipBean.setHelpUrlShowOnce(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("slam_texture_tip")) {
                tipBean.setFindPerfectPlane(jSONObject.getString("slam_texture_tip"));
            }
            if (jSONObject.has("help_url")) {
                tipBean.setPlayDesUrl(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("slam_device_orientation_tip")) {
                tipBean.setAlignPlane(jSONObject.getString("slam_device_orientation_tip"));
            }
            if (jSONObject.has("image_target_path")) {
                tipBean.setTrackTargePicPath(jSONObject.getString("image_target_path"));
            }
            if (jSONObject.has("hide_shot_immediately")) {
                tipBean.setHideCaptureGroupImmediately(jSONObject.getInt("hide_shot_immediately"));
            }
            if (jSONObject.has("show_tips_by_case")) {
                tipBean.setShowTipsByCase(jSONObject.getInt("show_tips_by_case"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipBean;
    }

    private static c a(String str) {
        c cVar = new c();
        try {
            String[] split = str.split(",");
            cVar.a(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue(), Float.valueOf(split[2]).floatValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    private static f b(JSONObject jSONObject, String str) {
        f fVar = new f();
        try {
            if (str.length() > 0) {
                fVar.a(str.substring(0, str.lastIndexOf(47)));
            }
            if (jSONObject.has("id")) {
                fVar.b(jSONObject.getString("id"));
            }
            if (jSONObject.has("name")) {
                fVar.c(jSONObject.getString("name"));
            }
            if (jSONObject.has("model_path")) {
                fVar.d(jSONObject.getString("model_path"));
            }
            if (jSONObject.has("template_width")) {
                fVar.c(jSONObject.getInt("template_width"));
            }
            if (jSONObject.has("template_height")) {
                fVar.d(jSONObject.getInt("template_height"));
            }
            if (jSONObject.has("target_width")) {
                fVar.a(jSONObject.getInt("target_width"));
            }
            if (jSONObject.has("target_height")) {
                fVar.b(jSONObject.getInt("target_height"));
            }
            if (jSONObject.has("centre_pos")) {
                fVar.a(a(jSONObject.getString("centre_pos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Constants.DEBUG) {
            ARLog.d(fVar.toString());
        }
        return fVar;
    }

    public static ARResource parseARResource(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        ARResource aRResource = new ARResource();
        try {
            if (ARConfig.isAipAuth()) {
                if (!jSONObject.has("data")) {
                    ARLog.e("parseARResource error");
                    return null;
                }
                jSONObject = jSONObject.getJSONObject("data");
            }
            if (jSONObject.has(ARResourceKey.HTTP_ERR_CODE)) {
                aRResource.setErrCode(jSONObject.getInt(ARResourceKey.HTTP_ERR_CODE));
            }
            if (jSONObject.has(ARResourceKey.HTTP_ERR_MSG)) {
                aRResource.setErrMsg(jSONObject.getString(ARResourceKey.HTTP_ERR_MSG));
            }
            if (jSONObject.has(ARResourceKey.HTTP_RET)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(ARResourceKey.HTTP_RET);
                if (jSONObject2.has("ar_key")) {
                    aRResource.setKey(jSONObject2.getString("ar_key"));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_RESOURCE)) {
                    aRResource.setResourceUrl(jSONObject2.getString(ARResourceKey.HTTP_AR_RESOURCE));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_MULTI_RESOURCE)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(ARResourceKey.HTTP_AR_MULTI_RESOURCE);
                    String[] strArr = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr[i2] = jSONArray.getString(i2);
                    }
                    aRResource.setMultiResourceUrl(strArr);
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_REDIRECT_URL)) {
                    aRResource.setRedirectUrl(jSONObject2.getString(ARResourceKey.HTTP_AR_REDIRECT_URL));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_VERSION_CODE)) {
                    aRResource.setVersionCode(jSONObject2.getString(ARResourceKey.HTTP_VERSION_CODE));
                }
                if (jSONObject2.has("ar_type")) {
                    aRResource.setType(Integer.parseInt(jSONObject2.getString("ar_type")));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_MD5)) {
                    aRResource.setZipMD5(jSONObject2.getString(ARResourceKey.HTTP_AR_MD5));
                }
                if (jSONObject2.has(ARResourceKey.AR_HARDWARE_SATISFIED)) {
                    aRResource.setHardwareSatisfied(jSONObject2.getBoolean(ARResourceKey.AR_HARDWARE_SATISFIED));
                }
                if (jSONObject2.has(ARResourceKey.AC_ID)) {
                    aRResource.setAcId(jSONObject2.getString(ARResourceKey.AC_ID));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_REFUSED)) {
                    aRResource.setRefused(Integer.parseInt(jSONObject2.getString(ARResourceKey.HTTP_REFUSED)) == 1);
                }
                if (jSONObject2.has(ARResourceKey.SHOW_AUDIO_DIALOG)) {
                    aRResource.setShowAudioDialog(jSONObject2.getBoolean(ARResourceKey.SHOW_AUDIO_DIALOG));
                }
                aRResource.setCodeDownloadUrl(jSONObject2.optString(ARResourceKey.AR_CODE_URL));
                JSONArray optJSONArray = jSONObject2.optJSONArray(ARResourceKey.HTTP_POWER);
                if (optJSONArray != null) {
                    HashMap hashMap = new HashMap();
                    while (true) {
                        int i3 = i;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(FunctionType.getValueOf(next), Boolean.valueOf(optJSONObject.getBoolean(next)));
                            }
                        }
                        i = i3 + 1;
                    }
                    aRResource.setFunctionMap(hashMap);
                }
            }
            return aRResource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TrackRes parseCaseConfig(String str, String str2, String str3) {
        TrackRes trackRes;
        Exception e;
        String defaultJsonPath = ARFileUtils.getDefaultJsonPath(str);
        String targetJsonPath = ARFileUtils.getTargetJsonPath(str);
        try {
            trackRes = (!new File(defaultJsonPath).exists() || TextUtils.isEmpty(str2)) ? null : parseDefaultJSON(str2, defaultJsonPath);
            if (trackRes == null) {
                try {
                    return (!new File(targetJsonPath).exists() || TextUtils.isEmpty(str3)) ? trackRes : parseTrackRes(str3, targetJsonPath);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return trackRes;
                }
            }
            return trackRes;
        } catch (Exception e3) {
            trackRes = null;
            e = e3;
        }
    }

    public static TrackRes parseDefaultJSON(String str, String str2) {
        Exception exc;
        TrackRes trackRes;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ar_configs")) {
                JSONArray jSONArray = jSONObject.getJSONArray("ar_configs");
                if (jSONArray.length() != 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                    if (jSONObject2.has("ar_target")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("ar_target");
                        TrackRes trackRes2 = new TrackRes();
                        try {
                            if (jSONObject3.has("targets")) {
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("targets");
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < jSONArray2.length(); i++) {
                                    try {
                                        arrayList.add(b((JSONObject) jSONArray2.get(i), str2));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                trackRes2.setTargetBeanList(arrayList);
                            }
                            if (jSONObject3.has("UI")) {
                                trackRes2.setTipBean(a(jSONObject3.getJSONObject("UI"), str2));
                            }
                            if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                                trackRes2.setService(parseService(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE), str2));
                            }
                            return trackRes2;
                        } catch (Exception e2) {
                            trackRes = trackRes2;
                            exc = e2;
                            exc.printStackTrace();
                            return trackRes;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            exc = e3;
            trackRes = null;
        }
    }

    public static com.baidu.ar.bean.a parseDuMixRes(String str) {
        com.baidu.ar.bean.a aVar;
        Exception e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new com.baidu.ar.bean.a();
            try {
                if (jSONObject.has(ARConfigKey.OLD_AR_TYPE)) {
                    aVar.a(jSONObject.getInt(ARConfigKey.OLD_AR_TYPE));
                }
                if (jSONObject.has("supportFrontCamera")) {
                    aVar.a(jSONObject.getBoolean("supportFrontCamera"));
                }
                if (jSONObject.has("containMusic")) {
                    aVar.b(jSONObject.getBoolean("containMusic"));
                    return aVar;
                }
                return aVar;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e3) {
            aVar = null;
            e = e3;
        }
    }

    public static b parsePaddle(JSONObject jSONObject, String str) {
        b bVar = new b();
        try {
            if (jSONObject.has(ClientCookie.PATH_ATTR)) {
                bVar.a(jSONObject.getString(ClientCookie.PATH_ATTR));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bVar;
    }

    public static List<ARResource> parseRecommendList(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || jSONObject.optInt("errorNum", -1) != 0 || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            ARResource a = a(optJSONArray.optJSONObject(i));
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static d parseService(JSONObject jSONObject, String str) {
        d dVar = new d();
        try {
            if (jSONObject.has("open_track_service")) {
                dVar.a(jSONObject.getInt("open_track_service"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dVar;
    }

    public static e parseSlamModel(JSONObject jSONObject, String str) {
        e eVar = new e();
        try {
            if (jSONObject.has("id")) {
                eVar.a(jSONObject.getString("id"));
            }
            if (jSONObject.has("place_type")) {
                eVar.a(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has("position")) {
                eVar.b(jSONObject.getString("position"));
            }
            if (jSONObject.has("distance")) {
                eVar.b(jSONObject.getInt("distance"));
            }
            if (jSONObject.has("pitch_angle")) {
                eVar.c(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has("rotation")) {
                eVar.c(jSONObject.getString("rotation"));
            }
            if (jSONObject.has("immediately_place_model")) {
                eVar.a(jSONObject.getInt("immediately_place_model") == 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eVar;
    }

    public static TrackRes parseTrackRes(String str, String str2) {
        try {
            TrackRes trackRes = new TrackRes();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("targets")) {
                JSONArray jSONArray = jSONObject.getJSONArray("targets");
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    try {
                        arrayList.add(b((JSONObject) jSONArray.get(i2), str2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i = i2 + 1;
                }
                trackRes.setTargetBeanList(arrayList);
            }
            if (jSONObject.has("UI")) {
                trackRes.setTipBean(a(jSONObject.getJSONObject("UI"), str2));
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                trackRes.setService(parseService(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE), str2));
            }
            if (jSONObject.has("slam_model")) {
                trackRes.setSlamModel(parseSlamModel(jSONObject.getJSONObject("slam_model"), str2));
            }
            if (jSONObject.has("paddle_model")) {
                trackRes.setPaddle(parsePaddle(jSONObject.getJSONObject("paddle_model"), str2));
            }
            return trackRes;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
