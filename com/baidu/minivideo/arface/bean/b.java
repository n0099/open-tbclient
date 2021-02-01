package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static List<Point> aBI;
    public static List<Point> aBJ;
    public static List<Point> aBK;
    public static List<Point> aBL;
    public static List<List<Point>> aBM;
    public float aBN = aBz;
    public float aBO = aBA;
    public float aBP = aBB;
    public float aBQ = aBC;
    public float aBR = aBD;
    public float aBS = aBE;
    public float aBT = aBF;
    public float aBU = aBG;
    public float aBV = aBH;
    public List<Point> aBW = aBI;
    public List<Point> aBX = aBJ;
    public List<Point> aBY = aBK;
    public List<Point> aBZ = aBL;
    public static float aBz = 0.65f;
    public static float aBA = 0.2f;
    public static float aBB = 0.65f;
    public static float aBC = 0.0f;
    public static float aBD = 0.0f;
    public static float aBE = 0.0f;
    public static float aBF = 1.0f;
    public static float aBG = 1.0f;
    public static float aBH = 0.0f;

    static {
        zr();
    }

    public static void zr() {
        aBI = new ArrayList();
        aBI.add(new Point(0, 0));
        aBI.add(new Point(255, 255));
        aBJ = new ArrayList();
        aBJ.add(new Point(0, 0));
        aBJ.add(new Point(255, 255));
        aBK = new ArrayList();
        aBK.add(new Point(0, 0));
        aBK.add(new Point(255, 255));
        aBL = new ArrayList();
        aBL.add(new Point(0, 0));
        aBL.add(new Point(255, 255));
        aBM = new ArrayList();
        aBM.add(aBI);
        aBM.add(aBJ);
        aBM.add(aBK);
        aBM.add(aBL);
    }

    public static b aw(JSONObject jSONObject) {
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
                bVar.aBN = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aBO = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aBP = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aBQ = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aBR = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aBS = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aBT = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aBU = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aBV = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aBW = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt(Config.EVENT_HEAT_X);
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aBW.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aBX = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt(Config.EVENT_HEAT_X);
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aBX.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aBY = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt(Config.EVENT_HEAT_X);
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aBY.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aBZ = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt(Config.EVENT_HEAT_X);
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aBZ.add(new Point(i2, i));
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
