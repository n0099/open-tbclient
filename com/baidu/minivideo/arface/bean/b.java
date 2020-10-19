package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {
    public static float aCK = 0.65f;
    public static float aCL = 0.2f;
    public static float aCM = 0.65f;
    public static float aCN = 0.0f;
    public static float aCO = 0.0f;
    public static float aCP = 0.0f;
    public static float aCQ = 1.0f;
    public static float aCR = 1.0f;
    public static float aCS = 0.0f;
    public static List<Point> aCT;
    public static List<Point> aCU;
    public static List<Point> aCV;
    public static List<Point> aCW;
    public static List<List<Point>> aCX;
    public float aCY = aCK;
    public float aCZ = aCL;
    public float aDa = aCM;
    public float aDb = aCN;
    public float aDc = aCO;
    public float aDd = aCP;
    public float aDe = aCQ;
    public float aDf = aCR;
    public float aDg = aCS;
    public List<Point> aDh = aCT;
    public List<Point> aDi = aCU;
    public List<Point> aDj = aCV;
    public List<Point> aDk = aCW;

    static {
        BW();
    }

    public static void BW() {
        aCT = new ArrayList();
        aCT.add(new Point(0, 0));
        aCT.add(new Point(255, 255));
        aCU = new ArrayList();
        aCU.add(new Point(0, 0));
        aCU.add(new Point(255, 255));
        aCV = new ArrayList();
        aCV.add(new Point(0, 0));
        aCV.add(new Point(255, 255));
        aCW = new ArrayList();
        aCW.add(new Point(0, 0));
        aCW.add(new Point(255, 255));
        aCX = new ArrayList();
        aCX.add(aCT);
        aCX.add(aCU);
        aCX.add(aCV);
        aCX.add(aCW);
    }

    public static b ah(JSONObject jSONObject) {
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
                bVar.aCY = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aCZ = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aDa = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aDb = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aDc = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aDd = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aDe = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aDf = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aDg = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aDh = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aDh.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aDi = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aDi.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aDj = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aDj.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aDk = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aDk.add(new Point(i2, i));
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
