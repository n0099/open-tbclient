package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static List<Point> aAd;
    public static List<Point> aAe;
    public static List<Point> aAf;
    public static List<Point> aAg;
    public static List<List<Point>> aAh;
    public float aAi = azU;
    public float aAj = azV;
    public float aAk = azW;
    public float aAl = azX;
    public float aAm = azY;
    public float aAn = azZ;
    public float aAo = aAa;
    public float aAp = aAb;
    public float aAq = aAc;
    public List<Point> aAr = aAd;
    public List<Point> aAs = aAe;
    public List<Point> aAt = aAf;
    public List<Point> aAu = aAg;
    public static float azU = 0.65f;
    public static float azV = 0.2f;
    public static float azW = 0.65f;
    public static float azX = 0.0f;
    public static float azY = 0.0f;
    public static float azZ = 0.0f;
    public static float aAa = 1.0f;
    public static float aAb = 1.0f;
    public static float aAc = 0.0f;

    static {
        yK();
    }

    public static void yK() {
        aAd = new ArrayList();
        aAd.add(new Point(0, 0));
        aAd.add(new Point(255, 255));
        aAe = new ArrayList();
        aAe.add(new Point(0, 0));
        aAe.add(new Point(255, 255));
        aAf = new ArrayList();
        aAf.add(new Point(0, 0));
        aAf.add(new Point(255, 255));
        aAg = new ArrayList();
        aAg.add(new Point(0, 0));
        aAg.add(new Point(255, 255));
        aAh = new ArrayList();
        aAh.add(aAd);
        aAh.add(aAe);
        aAh.add(aAf);
        aAh.add(aAg);
    }

    public static b au(JSONObject jSONObject) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("female");
            if (jSONObject2 != null) {
                bVar.aAi = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aAj = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aAk = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aAl = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aAm = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aAn = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aAo = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aAp = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aAq = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aAr = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt(Config.EVENT_HEAT_X);
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aAr.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aAs = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt(Config.EVENT_HEAT_X);
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aAs.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aAt = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt(Config.EVENT_HEAT_X);
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aAt.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aAu = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt(Config.EVENT_HEAT_X);
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aAu.add(new Point(i2, i));
                    }
                    return bVar;
                }
                return bVar;
            }
            return bVar;
        } catch (JSONException e) {
            return null;
        }
    }
}
