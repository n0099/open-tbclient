package com.baidu.lbsapi.panoramaview;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.lbsapi.model.BaiduPanoData;
import com.baidu.lbsapi.model.BaiduPoiPanoData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.pano.platform.c.c;
import com.baidu.pano.platform.c.f;
import com.baidu.pano.platform.c.i;
import com.baidu.pano.platform.comjni.JNITool;
import com.baidu.webkit.internal.ETAG;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PanoramaRequest {
    private static PanoramaRequest b;

    /* renamed from: a  reason: collision with root package name */
    private Context f1889a;

    private PanoramaRequest(Context context) {
        this.f1889a = context;
    }

    public static PanoramaRequest getInstance(Context context) {
        if (b == null) {
            b = new PanoramaRequest(context);
        }
        return b;
    }

    public String getPanoramaByIIdWithJson(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The parameter iid can't be null or empty string!");
        }
        return c(c.a(this.f1889a).b(i.f2727a + "&iid=" + str + ETAG.ITEM_SEPARATOR + f.a(this.f1889a).toString()));
    }

    public String getPanoramaRecommendInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The parameter pid can't be null or empty string!");
        }
        return c.a(this.f1889a).b(i.b + "&sid=" + str + ETAG.ITEM_SEPARATOR + f.a(this.f1889a).toString());
    }

    public String getPoiInfoByUidWithJson(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The parameter uid can't be null or empty string!");
        }
        return c.a(this.f1889a).b(i.e + "&action=1&uid=" + str + ETAG.ITEM_SEPARATOR + f.a(this.f1889a).toString());
    }

    public BaiduPanoData getPanoramaInfoByLatLon(double d, double d2) {
        return getPanoramaInfoByMercator((int) JNITool.ll2mc(d, d2).x, (int) JNITool.ll2mc(d, d2).y);
    }

    public BaiduPanoData getPanoramaInfoByMercator(int i, int i2) {
        return a(c.a(this.f1889a).b(i.d + "&x=" + i + "&y=" + i2 + "&action=1&" + f.a(this.f1889a).toString()));
    }

    public BaiduPoiPanoData getPanoramaInfoByUid(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The parameter uid can't be null or empty string!");
        }
        return b(c.a(this.f1889a).b(i.e + "&uid=" + str + "&action=1&" + f.a(this.f1889a).toString()));
    }

    private BaiduPanoData a(String str) {
        BaiduPanoData baiduPanoData = new BaiduPanoData();
        if (!TextUtils.isEmpty(str)) {
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
                baiduPanoData.setErrorCode(jSONObject.has("result") ? jSONObject.getJSONObject("result").optInt(BdStatsConstant.StatsType.ERROR, 404) : 404);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return baiduPanoData;
    }

    private BaiduPoiPanoData b(String str) {
        BaiduPoiPanoData baiduPoiPanoData = new BaiduPoiPanoData();
        if (!TextUtils.isEmpty(str)) {
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
                baiduPoiPanoData.setErrorCode(jSONObject.has("result") ? jSONObject.getJSONObject("result").optInt(BdStatsConstant.StatsType.ERROR, 404) : 404);
            } catch (JSONException e) {
                e.printStackTrace();
            }
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
}
