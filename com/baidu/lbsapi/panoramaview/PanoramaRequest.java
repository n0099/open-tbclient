package com.baidu.lbsapi.panoramaview;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.lbsapi.model.BaiduPanoData;
import com.baidu.lbsapi.model.BaiduPoiPanoData;
import com.baidu.pano.platform.c.c;
import com.baidu.pano.platform.c.f;
import com.baidu.pano.platform.c.i;
import com.baidu.pano.platform.comjni.JNITool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PanoramaRequest {

    /* renamed from: b  reason: collision with root package name */
    public static PanoramaRequest f6366b;

    /* renamed from: a  reason: collision with root package name */
    public Context f6367a;

    public PanoramaRequest(Context context) {
        this.f6367a = context;
    }

    private BaiduPanoData a(String str) {
        BaiduPanoData baiduPanoData = new BaiduPanoData();
        if (TextUtils.isEmpty(str)) {
            return baiduPanoData;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    String optString = jSONObject2.optString("ID", "");
                    jSONObject2.optString("Mode", "");
                    String optString2 = jSONObject2.optString("Rname", "");
                    int optInt = jSONObject2.optInt("X", 0);
                    int optInt2 = jSONObject2.optInt("Y", 0);
                    baiduPanoData.setX(optInt);
                    baiduPanoData.setY(optInt2);
                    baiduPanoData.setPid(optString);
                    baiduPanoData.setName(optString2);
                }
            }
            baiduPanoData.setErrorCode(jSONObject.has("result") ? jSONObject.getJSONObject("result").optInt("error", 404) : 404);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return baiduPanoData;
    }

    private BaiduPoiPanoData b(String str) {
        BaiduPoiPanoData baiduPoiPanoData = new BaiduPoiPanoData();
        if (TextUtils.isEmpty(str)) {
            return baiduPoiPanoData;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    if (jSONObject2.has("poiinfo")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("poiinfo");
                        String optString = jSONObject3.optString("IID", "");
                        String optString2 = jSONObject3.optString("PID", "");
                        String optString3 = jSONObject3.optString("UID", "");
                        int optInt = jSONObject3.optInt("X", 0);
                        int optInt2 = jSONObject3.optInt("Y", 0);
                        String optString4 = jSONObject3.optString("name", "");
                        String optString5 = jSONObject3.optString("std_tag", "");
                        baiduPoiPanoData.setX(optInt);
                        baiduPoiPanoData.setY(optInt2);
                        baiduPoiPanoData.setHeading(jSONObject3.optInt("Dir", 0));
                        baiduPoiPanoData.setPitch(jSONObject3.optInt("Pitch", 0));
                        baiduPoiPanoData.setPid(optString2);
                        baiduPoiPanoData.setUid(optString3);
                        baiduPoiPanoData.setIid(optString);
                        baiduPoiPanoData.setName(optString4);
                        baiduPoiPanoData.setPanoTag(optString5);
                    }
                }
            }
            baiduPoiPanoData.setErrorCode(jSONObject.has("result") ? jSONObject.getJSONObject("result").optInt("error", 404) : 404);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return baiduPoiPanoData;
    }

    private String c(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        Pattern compile = Pattern.compile("\"BreakX\":[0-9]{10}");
        Pattern compile2 = Pattern.compile("\"BreakY\":[0-9]{9}");
        Pattern compile3 = Pattern.compile("\"X\":[0-9]{10}");
        Pattern compile4 = Pattern.compile("\"Y\":[0-9]{9}");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(0).substring(0, matcher.group(0).length() - 2));
        }
        matcher.appendTail(stringBuffer);
        Matcher matcher2 = compile2.matcher(stringBuffer.toString());
        while (matcher2.find()) {
            matcher2.appendReplacement(stringBuffer2, matcher2.group(0).substring(0, matcher2.group(0).length() - 2));
        }
        matcher2.appendTail(stringBuffer2);
        Matcher matcher3 = compile3.matcher(stringBuffer2.toString());
        while (matcher3.find()) {
            matcher3.appendReplacement(stringBuffer3, matcher3.group(0).substring(0, matcher3.group(0).length() - 2));
        }
        matcher3.appendTail(stringBuffer3);
        Matcher matcher4 = compile4.matcher(stringBuffer3.toString());
        while (matcher4.find()) {
            matcher4.appendReplacement(stringBuffer4, matcher4.group(0).substring(0, matcher4.group(0).length() - 2));
        }
        matcher4.appendTail(stringBuffer4);
        return stringBuffer4.toString();
    }

    public static PanoramaRequest getInstance(Context context) {
        if (f6366b == null) {
            f6366b = new PanoramaRequest(context);
        }
        return f6366b;
    }

    public String getPanoramaByIIdWithJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            return c(c.a(this.f6367a).b(i.f9458a + "&iid=" + str + "&" + f.a(this.f6367a).toString()));
        }
        throw new IllegalArgumentException("The parameter iid can't be null or empty string!");
    }

    public BaiduPanoData getPanoramaInfoByLatLon(double d2, double d3) {
        return getPanoramaInfoByMercator((int) JNITool.ll2mc(d2, d3).x, (int) JNITool.ll2mc(d2, d3).y);
    }

    public BaiduPanoData getPanoramaInfoByMercator(int i, int i2) {
        return a(c.a(this.f6367a).b(i.f9461d + "&x=" + i + "&y=" + i2 + "&action=1&" + f.a(this.f6367a).toString()));
    }

    public BaiduPoiPanoData getPanoramaInfoByUid(String str) {
        if (!TextUtils.isEmpty(str)) {
            return b(c.a(this.f6367a).b(i.f9462e + "&uid=" + str + "&action=1&" + f.a(this.f6367a).toString()));
        }
        throw new IllegalArgumentException("The parameter uid can't be null or empty string!");
    }

    public String getPanoramaRecommendInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            return c.a(this.f6367a).b(i.f9459b + "&sid=" + str + "&" + f.a(this.f6367a).toString());
        }
        throw new IllegalArgumentException("The parameter pid can't be null or empty string!");
    }

    public String getPoiInfoByUidWithJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            return c.a(this.f6367a).b(i.f9462e + "&action=1&uid=" + str + "&" + f.a(this.f6367a).toString());
        }
        throw new IllegalArgumentException("The parameter uid can't be null or empty string!");
    }
}
