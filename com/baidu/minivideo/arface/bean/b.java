package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static List<Point> aEA;
    public static List<Point> aEB;
    public static List<Point> aEC;
    public static List<List<Point>> aED;
    public static float aEq = 0.65f;
    public static float aEr = 0.2f;
    public static float aEs = 0.65f;
    public static float aEt = 0.0f;
    public static float aEu = 0.0f;
    public static float aEv = 0.0f;
    public static float aEw = 1.0f;
    public static float aEx = 1.0f;
    public static float aEy = 0.0f;
    public static List<Point> aEz;
    public float aEE = aEq;
    public float aEF = aEr;
    public float aEG = aEs;
    public float aEH = aEt;
    public float aEI = aEu;
    public float aEJ = aEv;
    public float aEK = aEw;
    public float aEL = aEx;
    public float aEM = aEy;
    public List<Point> aEN = aEz;
    public List<Point> aEO = aEA;
    public List<Point> aEP = aEB;
    public List<Point> aEQ = aEC;

    static {
        Dp();
    }

    public static void Dp() {
        aEz = new ArrayList();
        aEz.add(new Point(0, 0));
        aEz.add(new Point(255, 255));
        aEA = new ArrayList();
        aEA.add(new Point(0, 0));
        aEA.add(new Point(255, 255));
        aEB = new ArrayList();
        aEB.add(new Point(0, 0));
        aEB.add(new Point(255, 255));
        aEC = new ArrayList();
        aEC.add(new Point(0, 0));
        aEC.add(new Point(255, 255));
        aED = new ArrayList();
        aED.add(aEz);
        aED.add(aEA);
        aED.add(aEB);
        aED.add(aEC);
    }

    public static b am(JSONObject jSONObject) {
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
                bVar.aEE = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aEF = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aEG = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aEH = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aEI = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aEJ = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aEK = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aEL = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aEM = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aEN = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aEN.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aEO = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aEO.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aEP = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aEP.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aEQ = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aEQ.add(new Point(i2, i));
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
