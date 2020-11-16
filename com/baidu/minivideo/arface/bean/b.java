package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    public static float aBK = 0.65f;
    public static float aBL = 0.2f;
    public static float aBM = 0.65f;
    public static float aBN = 0.0f;
    public static float aBO = 0.0f;
    public static float aBP = 0.0f;
    public static float aBQ = 1.0f;
    public static float aBR = 1.0f;
    public static float aBS = 0.0f;
    public static List<Point> aBT;
    public static List<Point> aBU;
    public static List<Point> aBV;
    public static List<Point> aBW;
    public static List<List<Point>> aBX;
    public float aBY = aBK;
    public float aBZ = aBL;
    public float aCa = aBM;
    public float aCb = aBN;
    public float aCc = aBO;
    public float aCd = aBP;
    public float aCe = aBQ;
    public float aCf = aBR;
    public float aCg = aBS;
    public List<Point> aCh = aBT;
    public List<Point> aCi = aBU;
    public List<Point> aCj = aBV;
    public List<Point> aCk = aBW;

    static {
        BF();
    }

    public static void BF() {
        aBT = new ArrayList();
        aBT.add(new Point(0, 0));
        aBT.add(new Point(255, 255));
        aBU = new ArrayList();
        aBU.add(new Point(0, 0));
        aBU.add(new Point(255, 255));
        aBV = new ArrayList();
        aBV.add(new Point(0, 0));
        aBV.add(new Point(255, 255));
        aBW = new ArrayList();
        aBW.add(new Point(0, 0));
        aBW.add(new Point(255, 255));
        aBX = new ArrayList();
        aBX.add(aBT);
        aBX.add(aBU);
        aBX.add(aBV);
        aBX.add(aBW);
    }

    public static b ak(JSONObject jSONObject) {
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
                bVar.aBY = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aBZ = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aCa = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aCb = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aCc = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aCd = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aCe = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aCf = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aCg = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aCh = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aCh.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aCi = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aCi.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aCj = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aCj.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aCk = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aCk.add(new Point(i2, i));
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
