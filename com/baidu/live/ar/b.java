package com.baidu.live.ar;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static List<Point> aDE;
    public static List<Point> aDF;
    public static List<Point> aDG;
    public static List<Point> aDH;
    public static List<List<Point>> aDI;
    public float aDJ = aDv;
    public float aDK = aDw;
    public float aDL = aDx;
    public float aDM = aDy;
    public float aDN = aDz;
    public float aDO = aDA;
    public float aDP = aDB;
    public float aDQ = aDC;
    public float aDR = aDD;
    public List<Point> aDS = aDE;
    public List<Point> aDT = aDF;
    public List<Point> aDU = aDG;
    public List<Point> aDV = aDH;
    public static float aDv = 0.65f;
    public static float aDw = 0.2f;
    public static float aDx = 0.65f;
    public static float aDy = 0.0f;
    public static float aDz = 0.7f;
    public static float aDA = 0.03f;
    public static float aDB = 0.86f;
    public static float aDC = 0.79f;
    public static float aDD = 0.9f;

    static {
        Co();
    }

    public static void Co() {
        aDE = new ArrayList();
        aDE.add(new Point(0, 0));
        aDE.add(new Point(75, 61));
        aDE.add(new Point(175, 172));
        aDE.add(new Point(255, 255));
        aDF = new ArrayList();
        aDF.add(new Point(0, 0));
        aDF.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_DROP, 122));
        aDF.add(new Point(255, 255));
        aDG = new ArrayList();
        aDG.add(new Point(0, 0));
        aDG.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 117));
        aDG.add(new Point(255, 255));
        aDH = new ArrayList();
        aDH.add(new Point(0, 0));
        aDH.add(new Point(127, 111));
        aDH.add(new Point(255, 255));
        aDI = new ArrayList();
        aDI.add(aDE);
        aDI.add(aDF);
        aDI.add(aDG);
        aDI.add(aDH);
    }

    public static b w(JSONObject jSONObject) {
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
                bVar.aDJ = (float) jSONObject2.optDouble("intensity_smooth");
                bVar.aDK = (float) jSONObject2.optDouble("intensity_white");
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("male");
            if (jSONObject3 != null) {
                bVar.aDL = (float) jSONObject3.optDouble("intensity_smooth");
                bVar.aDM = (float) jSONObject3.optDouble("intensity_white");
            }
            bVar.aDN = (float) jSONObject.optDouble("intensity_sharpness");
            bVar.aDO = (float) jSONObject.optDouble("intensity_brightness");
            bVar.aDP = (float) jSONObject.optDouble("intensity_contrast");
            bVar.aDQ = (float) jSONObject.optDouble("intensity_saturation");
            JSONObject optJSONObject = jSONObject.optJSONObject("curves");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                bVar.aDR = (float) optJSONObject.optDouble("intensity_curves");
                JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.aDS = new CopyOnWriteArrayList();
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                        if (jSONObject4 == null || jSONObject4.length() <= 0) {
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i8 = jSONObject4.optInt("x");
                            i7 = jSONObject4.optInt("y");
                        }
                        bVar.aDS.add(new Point(i8, i7));
                    }
                }
                JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    bVar.aDT = new CopyOnWriteArrayList();
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            i5 = 0;
                            i6 = 0;
                        } else {
                            i6 = jSONObject5.optInt("x");
                            i5 = jSONObject5.optInt("y");
                        }
                        bVar.aDT.add(new Point(i6, i5));
                    }
                }
                JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    bVar.aDU = new CopyOnWriteArrayList();
                    for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                        JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                        if (jSONObject6 == null || jSONObject6.length() <= 0) {
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i4 = jSONObject6.optInt("x");
                            i3 = jSONObject6.optInt("y");
                        }
                        bVar.aDU.add(new Point(i4, i3));
                    }
                }
                JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    bVar.aDV = new CopyOnWriteArrayList();
                    for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                        if (jSONObject7 == null || jSONObject7.length() <= 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            i2 = jSONObject7.optInt("x");
                            i = jSONObject7.optInt("y");
                        }
                        bVar.aDV.add(new Point(i2, i));
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

    public static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        JSONObject jSONObject4;
        float f8;
        float f9;
        float f10 = -1.0f;
        if (jSONObject == null && jSONObject2 == null) {
            return false;
        }
        if (jSONObject != null || jSONObject2 == null) {
            if (jSONObject == null || jSONObject2 != null) {
                if (jSONObject != null) {
                    try {
                        jSONObject3 = jSONObject.getJSONObject("quality");
                    } catch (JSONException e) {
                        f = -1.0f;
                        f2 = -1.0f;
                        f3 = -1.0f;
                        f4 = -1.0f;
                        f5 = -1.0f;
                        f6 = -1.0f;
                        f7 = -1.0f;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    JSONObject jSONObject5 = jSONObject3.getJSONObject("female");
                    if (jSONObject5 != null) {
                        float optDouble = (float) jSONObject5.optDouble("intensity_smooth");
                        try {
                            f8 = (float) jSONObject5.optDouble("intensity_white");
                            f9 = optDouble;
                        } catch (JSONException e2) {
                            f2 = -1.0f;
                            f3 = -1.0f;
                            f4 = -1.0f;
                            f5 = -1.0f;
                            f6 = -1.0f;
                            f7 = optDouble;
                            f = -1.0f;
                        }
                    } else {
                        f8 = -1.0f;
                        f9 = -1.0f;
                    }
                    try {
                        JSONObject jSONObject6 = jSONObject3.getJSONObject("male");
                        if (jSONObject6 != null) {
                            float optDouble2 = (float) jSONObject6.optDouble("intensity_smooth");
                            try {
                                f4 = (float) jSONObject6.optDouble("intensity_white");
                                f5 = optDouble2;
                                f6 = f8;
                                f7 = f9;
                            } catch (JSONException e3) {
                                f4 = -1.0f;
                                f5 = optDouble2;
                                f6 = f8;
                                f7 = f9;
                                f2 = -1.0f;
                                f3 = -1.0f;
                                f = -1.0f;
                            }
                        } else {
                            f4 = -1.0f;
                            f5 = -1.0f;
                            f6 = f8;
                            f7 = f9;
                        }
                    } catch (JSONException e4) {
                        f = -1.0f;
                        f4 = -1.0f;
                        f5 = -1.0f;
                        f6 = f8;
                        f7 = f9;
                        f2 = -1.0f;
                        f3 = -1.0f;
                    }
                } else {
                    f4 = -1.0f;
                    f5 = -1.0f;
                    f6 = -1.0f;
                    f7 = -1.0f;
                }
                if (jSONObject2 != null) {
                    try {
                        jSONObject4 = jSONObject2.getJSONObject("quality");
                    } catch (JSONException e5) {
                        f = -1.0f;
                        f2 = -1.0f;
                        f3 = -1.0f;
                    }
                } else {
                    jSONObject4 = null;
                }
                if (jSONObject4 != null) {
                    JSONObject jSONObject7 = jSONObject4.getJSONObject("female");
                    if (jSONObject7 != null) {
                        f3 = (float) jSONObject7.optDouble("intensity_smooth");
                        try {
                            f2 = (float) jSONObject7.optDouble("intensity_white");
                        } catch (JSONException e6) {
                            f = -1.0f;
                            f2 = -1.0f;
                        }
                    } else {
                        f2 = -1.0f;
                        f3 = -1.0f;
                    }
                    try {
                        JSONObject jSONObject8 = jSONObject4.getJSONObject("male");
                        if (jSONObject8 != null) {
                            f = (float) jSONObject8.optDouble("intensity_smooth");
                            try {
                                f10 = (float) jSONObject8.optDouble("intensity_white");
                            } catch (JSONException e7) {
                            }
                        } else {
                            f = -1.0f;
                        }
                    } catch (JSONException e8) {
                        f = -1.0f;
                    }
                } else {
                    f = -1.0f;
                    f2 = -1.0f;
                    f3 = -1.0f;
                }
                return (f7 == f3 && f6 == f2 && f5 == f && f4 == f10) ? false : true;
            }
            return false;
        }
        return true;
    }
}
