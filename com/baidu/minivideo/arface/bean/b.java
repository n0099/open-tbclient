package com.baidu.minivideo.arface.bean;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static float atV = 0.65f;
    public static float atW = 0.2f;
    public static float atX = 0.65f;
    public static float atY = 0.0f;
    public static float atZ = 0.7f;
    public static float aua = 0.03f;
    public static float aub = 0.86f;
    public static float auc = 0.79f;
    public static float aud = 0.9f;
    public static List<Point> aue;
    public static List<Point> auf;
    public static List<Point> aug;
    public static List<Point> auh;
    public static List<List<Point>> aui;
    public float auj = atV;
    public float auk = atW;
    public float aul = atX;
    public float aum = atY;
    public float aun = atZ;
    public float auo = aua;
    public float aup = aub;
    public float auq = auc;
    public float aur = aud;
    public List<Point> aus = aue;
    public List<Point> aut = auf;
    public List<Point> auu = aug;
    public List<Point> auv = auh;

    static {
        vm();
    }

    public static void vm() {
        aue = new ArrayList();
        aue.add(new Point(0, 0));
        aue.add(new Point(75, 61));
        aue.add(new Point(175, 172));
        aue.add(new Point(255, 255));
        auf = new ArrayList();
        auf.add(new Point(0, 0));
        auf.add(new Point(121, 122));
        auf.add(new Point(255, 255));
        aug = new ArrayList();
        aug.add(new Point(0, 0));
        aug.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 117));
        aug.add(new Point(255, 255));
        auh = new ArrayList();
        auh.add(new Point(0, 0));
        auh.add(new Point(127, 111));
        auh.add(new Point(255, 255));
        aui = new ArrayList();
        aui.add(aue);
        aui.add(auf);
        aui.add(aug);
        aui.add(auh);
    }

    public static b Z(JSONObject jSONObject) {
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
                bVar.auj = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.auk = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aul = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aum = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aun = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.auo = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aup = (float) jSONObject.optDouble("intensity_contrast");
            bVar.auq = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aur = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aus = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt(Config.EVENT_HEAT_X);
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aus.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aut = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt(Config.EVENT_HEAT_X);
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aut.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.auu = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt(Config.EVENT_HEAT_X);
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.auu.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.auv = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt(Config.EVENT_HEAT_X);
                            i = jSONObject7.optInt("y");
                        }
                        bVar.auv.add(new Point(i2, i));
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
