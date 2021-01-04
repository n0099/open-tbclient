package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static float aEH = 0.65f;
    public static float aEI = 0.2f;
    public static float aEJ = 0.65f;
    public static float aEK = 0.0f;
    public static float aEL = 0.0f;
    public static float aEM = 0.0f;
    public static float aEN = 1.0f;
    public static float aEO = 1.0f;
    public static float aEP = 0.0f;
    public static List<Point> aEQ;
    public static List<Point> aER;
    public static List<Point> aES;
    public static List<Point> aET;
    public static List<List<Point>> aEU;
    public float aEV = aEH;
    public float aEW = aEI;
    public float aEX = aEJ;
    public float aEY = aEK;
    public float aEZ = aEL;
    public float aFa = aEM;
    public float aFb = aEN;
    public float aFc = aEO;
    public float aFd = aEP;
    public List<Point> aFe = aEQ;
    public List<Point> aFf = aER;
    public List<Point> aFg = aES;
    public List<Point> aFh = aET;

    static {
        CF();
    }

    public static void CF() {
        aEQ = new ArrayList();
        aEQ.add(new Point(0, 0));
        aEQ.add(new Point(255, 255));
        aER = new ArrayList();
        aER.add(new Point(0, 0));
        aER.add(new Point(255, 255));
        aES = new ArrayList();
        aES.add(new Point(0, 0));
        aES.add(new Point(255, 255));
        aET = new ArrayList();
        aET.add(new Point(0, 0));
        aET.add(new Point(255, 255));
        aEU = new ArrayList();
        aEU.add(aEQ);
        aEU.add(aER);
        aEU.add(aES);
        aEU.add(aET);
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
                bVar.aEV = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aEW = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aEX = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aEY = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aEZ = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aFa = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aFb = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aFc = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aFd = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aFe = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aFe.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aFf = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aFf.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aFg = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aFg.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aFh = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aFh.add(new Point(i2, i));
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
