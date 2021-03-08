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
    public static float aCZ = 0.65f;
    public static float aDa = 0.2f;
    public static float aDb = 0.65f;
    public static float aDc = 0.0f;
    public static float aDd = 0.0f;
    public static float aDe = 0.0f;
    public static float aDf = 1.0f;
    public static float aDg = 1.0f;
    public static float aDh = 0.0f;
    public static List<Point> aDi;
    public static List<Point> aDj;
    public static List<Point> aDk;
    public static List<Point> aDl;
    public static List<List<Point>> aDm;
    public float aDn = aCZ;
    public float aDo = aDa;
    public float aDp = aDb;
    public float aDq = aDc;
    public float aDr = aDd;
    public float aDs = aDe;
    public float aDt = aDf;
    public float aDu = aDg;
    public float aDv = aDh;
    public List<Point> aDw = aDi;
    public List<Point> aDx = aDj;
    public List<Point> aDy = aDk;
    public List<Point> aDz = aDl;

    static {
        zu();
    }

    public static void zu() {
        aDi = new ArrayList();
        aDi.add(new Point(0, 0));
        aDi.add(new Point(255, 255));
        aDj = new ArrayList();
        aDj.add(new Point(0, 0));
        aDj.add(new Point(255, 255));
        aDk = new ArrayList();
        aDk.add(new Point(0, 0));
        aDk.add(new Point(255, 255));
        aDl = new ArrayList();
        aDl.add(new Point(0, 0));
        aDl.add(new Point(255, 255));
        aDm = new ArrayList();
        aDm.add(aDi);
        aDm.add(aDj);
        aDm.add(aDk);
        aDm.add(aDl);
    }

    public static b ay(JSONObject jSONObject) {
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
                bVar.aDn = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aDo = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aDp = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aDq = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aDr = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aDs = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aDt = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aDu = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aDv = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aDw = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt(Config.EVENT_HEAT_X);
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aDw.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aDx = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt(Config.EVENT_HEAT_X);
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aDx.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aDy = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt(Config.EVENT_HEAT_X);
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aDy.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aDz = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt(Config.EVENT_HEAT_X);
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aDz.add(new Point(i2, i));
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
