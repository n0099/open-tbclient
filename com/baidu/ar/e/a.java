package com.baidu.ar.e;

import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.AttrData;
import com.baidu.ar.bean.FunctionType;
import com.baidu.ar.bean.b;
import com.baidu.ar.bean.d;
import com.baidu.ar.bean.e;
import com.baidu.ar.representation.c;
import com.baidu.ar.util.Constants;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final String a = a.class.getSimpleName();

    private a() {
    }

    public static ARResource a(JSONObject jSONObject) {
        ARResource aRResource = new ARResource();
        try {
            if (jSONObject.has(Constants.HTTP_ERR_CODE)) {
                aRResource.a(jSONObject.getInt(Constants.HTTP_ERR_CODE));
            }
            if (jSONObject.has(Constants.HTTP_ERR_MSG)) {
                aRResource.a(jSONObject.getString(Constants.HTTP_ERR_MSG));
            }
            if (jSONObject.has(Constants.HTTP_RET)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.HTTP_RET);
                if (jSONObject2.has(Constants.AR_KEY)) {
                    aRResource.b(jSONObject2.getString(Constants.AR_KEY));
                }
                if (jSONObject2.has(Constants.HTTP_AR_RESOURCE)) {
                    aRResource.c(jSONObject2.getString(Constants.HTTP_AR_RESOURCE));
                }
                if (jSONObject2.has(Constants.HTTP_AR_MULTI_RESOURCE)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(Constants.HTTP_AR_MULTI_RESOURCE);
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    aRResource.a(strArr);
                }
                if (jSONObject2.has(Constants.HTTP_AR_REDIRECT_URL)) {
                    aRResource.d(jSONObject2.getString(Constants.HTTP_AR_REDIRECT_URL));
                }
                if (jSONObject2.has(Constants.HTTP_VERSION_CODE)) {
                    aRResource.e(jSONObject2.getString(Constants.HTTP_VERSION_CODE));
                }
                if (jSONObject2.has("ar_type")) {
                    aRResource.b(Integer.parseInt(jSONObject2.getString("ar_type")));
                }
                if (jSONObject2.has(Constants.HTTP_AR_MD5)) {
                    aRResource.f(jSONObject2.getString(Constants.HTTP_AR_MD5));
                }
                if (jSONObject2.has(Constants.AR_HARDWARE_SATISFIED)) {
                    aRResource.b(jSONObject2.getBoolean(Constants.AR_HARDWARE_SATISFIED));
                }
                if (jSONObject2.has(Constants.AC_ID)) {
                    aRResource.g(jSONObject2.getString(Constants.AC_ID));
                }
                if (jSONObject2.has(Constants.HTTP_REFUSED)) {
                    if (Integer.parseInt(jSONObject2.getString(Constants.HTTP_REFUSED)) == 1) {
                        aRResource.a(true);
                    } else {
                        aRResource.a(false);
                    }
                }
                if (jSONObject2.has(Constants.SHOW_AUDIO_DIALOG)) {
                    aRResource.c(jSONObject2.getBoolean(Constants.SHOW_AUDIO_DIALOG));
                }
                aRResource.h(jSONObject2.optString(Constants.AR_CODE_URL));
                JSONArray optJSONArray = jSONObject2.optJSONArray(Constants.HTTP_POWER);
                if (optJSONArray != null) {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(FunctionType.a(next), Boolean.valueOf(optJSONObject.getBoolean(next)));
                            }
                        }
                    }
                    aRResource.a(hashMap);
                }
            }
            return aRResource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static d a(JSONObject jSONObject, String str) {
        d dVar = new d();
        try {
            if (jSONObject.has("udt_tip_simple")) {
                dVar.a(jSONObject.getString("udt_tip_simple"));
            }
            if (jSONObject.has("udt_tip_detail")) {
                dVar.b(jSONObject.getString("udt_tip_detail"));
            }
            if (jSONObject.has(TrackReferenceTypeBox.TYPE1)) {
                dVar.c(jSONObject.getString(TrackReferenceTypeBox.TYPE1));
            }
            if (jSONObject.has("too_far_hint")) {
                dVar.d(jSONObject.getString("too_far_hint"));
            }
            if (jSONObject.has("too_near_hint")) {
                dVar.e(jSONObject.getString("too_near_hint"));
            }
            if (jSONObject.has("not_find_hint")) {
                dVar.f(jSONObject.getString("not_find_hint"));
            }
            if (jSONObject.has("far_threshold")) {
                dVar.a(Float.parseFloat(jSONObject.getString("far_threshold")));
            }
            if (jSONObject.has("near_threshold")) {
                dVar.b(Float.parseFloat(jSONObject.getString("near_threshold")));
            }
            if (jSONObject.has("case_type")) {
                dVar.a(AttrData.CaseType.values()[Integer.parseInt(jSONObject.getString("case_type"))]);
            }
            if (jSONObject.has("udt_mode")) {
                dVar.b(Integer.parseInt(jSONObject.getString("udt_mode")));
            }
            if (jSONObject.has("help_url")) {
                dVar.g(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("help_url_show_once")) {
                dVar.a(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("help_url_show_once")) {
                dVar.a(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("slam_texture_tip")) {
                dVar.h(jSONObject.getString("slam_texture_tip"));
            }
            if (jSONObject.has("help_url")) {
                dVar.i(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("slam_device_orientation_tip")) {
                dVar.j(jSONObject.getString("slam_device_orientation_tip"));
            }
            if (jSONObject.has("image_target_path")) {
                dVar.k(jSONObject.getString("image_target_path"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dVar;
    }

    public static e a(String str, String str2) {
        e eVar = new e();
        try {
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
                eVar.a(arrayList);
            }
            if (jSONObject.has("UI")) {
                eVar.a(a(jSONObject.getJSONObject("UI"), str2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return eVar;
    }

    private static c a(String str) {
        c cVar = new c();
        try {
            String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            cVar.a(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue(), Float.valueOf(split[2]).floatValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    public static b b(JSONObject jSONObject, String str) {
        b bVar = new b();
        try {
            if (str.length() > 0) {
                bVar.a(str.substring(0, str.lastIndexOf(47)));
            }
            if (jSONObject.has("id")) {
                bVar.b(jSONObject.getString("id"));
            }
            if (jSONObject.has("name")) {
                bVar.c(jSONObject.getString("name"));
            }
            if (jSONObject.has("model_path")) {
                bVar.d(jSONObject.getString("model_path"));
            }
            if (jSONObject.has("template_width")) {
                bVar.c(jSONObject.getInt("template_width"));
            }
            if (jSONObject.has("template_height")) {
                bVar.d(jSONObject.getInt("template_height"));
            }
            if (jSONObject.has("target_width")) {
                bVar.a(jSONObject.getInt("target_width"));
            }
            if (jSONObject.has("target_height")) {
                bVar.b(jSONObject.getInt("target_height"));
            }
            if (jSONObject.has("centre_pos")) {
                bVar.a(a(jSONObject.getString("centre_pos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Constants.DEBUG) {
            com.baidu.ar.util.b.a(bVar.toString());
        }
        return bVar;
    }
}
