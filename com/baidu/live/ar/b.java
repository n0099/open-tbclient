package com.baidu.live.ar;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static float aCZ = 0.65f;
    public static float aDa = 0.2f;
    public static float aDb = 0.65f;
    public static float aDc = 0.0f;
    public static float aDd = 0.7f;
    public static float aDe = 0.03f;
    public static float aDf = 0.86f;
    public static float aDg = 0.79f;
    public static float aDh = 0.9f;
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
        aDi.add(new Point(75, 61));
        aDi.add(new Point(175, 172));
        aDi.add(new Point(255, 255));
        aDj = new ArrayList();
        aDj.add(new Point(0, 0));
        aDj.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_DROP, 122));
        aDj.add(new Point(255, 255));
        aDk = new ArrayList();
        aDk.add(new Point(0, 0));
        aDk.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 117));
        aDk.add(new Point(255, 255));
        aDl = new ArrayList();
        aDl.add(new Point(0, 0));
        aDl.add(new Point(ThunderNetStateService.NetState.SYSNET_UNKNOWN, 111));
        aDl.add(new Point(255, 255));
        aDm = new ArrayList();
        aDm.add(aDi);
        aDm.add(aDj);
        aDm.add(aDk);
        aDm.add(aDl);
    }

    public static b y(JSONObject jSONObject) {
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        JSONObject jSONObject4 = null;
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
                        f8 = f4;
                        if (f7 != f3) {
                        }
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    JSONObject jSONObject5 = jSONObject3.getJSONObject("female");
                    if (jSONObject5 != null) {
                        float optDouble = (float) jSONObject5.optDouble("intensity_smooth");
                        try {
                            f6 = (float) jSONObject5.optDouble("intensity_white");
                            f7 = optDouble;
                        } catch (JSONException e2) {
                            f = -1.0f;
                            f2 = -1.0f;
                            f3 = -1.0f;
                            f4 = -1.0f;
                            f5 = -1.0f;
                            f6 = -1.0f;
                            f7 = optDouble;
                            f8 = f4;
                            if (f7 != f3) {
                            }
                        }
                    } else {
                        f6 = -1.0f;
                        f7 = -1.0f;
                    }
                    try {
                        JSONObject jSONObject6 = jSONObject3.getJSONObject("male");
                        if (jSONObject6 != null) {
                            f5 = (float) jSONObject6.optDouble("intensity_smooth");
                            try {
                                f8 = (float) jSONObject6.optDouble("intensity_white");
                            } catch (JSONException e3) {
                                f = -1.0f;
                                f2 = -1.0f;
                                f3 = -1.0f;
                                f4 = -1.0f;
                                f8 = f4;
                                if (f7 != f3) {
                                }
                            }
                        } else {
                            f8 = -1.0f;
                            f5 = -1.0f;
                        }
                    } catch (JSONException e4) {
                        f = -1.0f;
                        f2 = -1.0f;
                        f3 = -1.0f;
                        f4 = -1.0f;
                        f5 = -1.0f;
                    }
                } else {
                    f8 = -1.0f;
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
                        f4 = f8;
                        f8 = f4;
                        if (f7 != f3) {
                        }
                    }
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
                            f4 = f8;
                            f8 = f4;
                            if (f7 != f3) {
                            }
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
                                f9 = (float) jSONObject8.optDouble("intensity_white");
                            } catch (JSONException e7) {
                                f4 = f8;
                                f8 = f4;
                                if (f7 != f3) {
                                }
                            }
                        } else {
                            f9 = -1.0f;
                            f = -1.0f;
                        }
                    } catch (JSONException e8) {
                        f = -1.0f;
                        f4 = f8;
                    }
                } else {
                    f9 = -1.0f;
                    f = -1.0f;
                    f2 = -1.0f;
                    f3 = -1.0f;
                }
                f10 = f9;
                return (f7 != f3 && f6 == f2 && f5 == f && f8 == f10) ? false : true;
            }
            return false;
        }
        return true;
    }
}
