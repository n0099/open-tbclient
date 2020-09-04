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
    public static float ayZ = 0.65f;
    public static float aza = 0.2f;
    public static float azb = 0.65f;
    public static float azc = 0.0f;
    public static float azd = 0.0f;
    public static float aze = 0.0f;
    public static float azf = 1.0f;
    public static float azg = 1.0f;
    public static float azh = 0.0f;
    public static List<Point> azi;
    public static List<Point> azj;
    public static List<Point> azk;
    public static List<Point> azl;
    public static List<List<Point>> azm;
    public float azn = ayZ;
    public float azo = aza;
    public float azp = azb;
    public float azq = azc;
    public float azr = azd;
    public float azs = aze;
    public float azt = azf;
    public float azu = azg;
    public float azv = azh;
    public List<Point> azw = azi;
    public List<Point> azx = azj;
    public List<Point> azy = azk;
    public List<Point> azz = azl;

    static {
        AK();
    }

    public static void AK() {
        azi = new ArrayList();
        azi.add(new Point(0, 0));
        azi.add(new Point(255, 255));
        azj = new ArrayList();
        azj.add(new Point(0, 0));
        azj.add(new Point(255, 255));
        azk = new ArrayList();
        azk.add(new Point(0, 0));
        azk.add(new Point(255, 255));
        azl = new ArrayList();
        azl.add(new Point(0, 0));
        azl.add(new Point(255, 255));
        azm = new ArrayList();
        azm.add(azi);
        azm.add(azj);
        azm.add(azk);
        azm.add(azl);
    }

    public static b ab(JSONObject jSONObject) {
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
                bVar.azn = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.azo = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.azp = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.azq = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.azr = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.azs = (float) jSONObject.optDouble("intensity_brightness");
            bVar.azt = (float) jSONObject.optDouble("intensity_contrast");
            bVar.azu = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.azv = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.azw = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.azw.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.azx = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.azx.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.azy = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.azy.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.azz = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.azz.add(new Point(i2, i));
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
