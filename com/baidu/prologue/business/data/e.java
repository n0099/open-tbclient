package com.baidu.prologue.business.data;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    protected static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    public String action;
    public int advisible;
    public String aqV;
    public String bsq;
    public String bsr;
    public String bss;
    public int bst;
    public int bsu;
    public String[] bsv;
    public String[] bsw;
    public int bsx;
    public int bsy;
    public long end;
    public String ext;
    public int height;
    public String id;
    public String md5;
    public int preloadType;
    public long start;
    public int type;
    public String url;
    public int width;
    public int bsz = 0;
    public boolean bsA = false;

    public boolean LX() {
        return TextUtils.equals(this.bsr, "splash_image");
    }

    public boolean isFullScreen() {
        return this.type == 1;
    }

    public static void a(e eVar, e eVar2) {
        a.a(eVar, eVar2);
    }

    public String LY() {
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, this);
        return jSONObject.toString();
    }

    public static e Q(JSONObject jSONObject) {
        e eVar = new e();
        try {
            a.b(jSONObject, eVar);
            if (DEBUG) {
                Log.d("SplashData", "createFromJson() item.toString(): " + eVar.toString());
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static e R(JSONObject jSONObject) {
        try {
            e eVar = new e();
            a.a(jSONObject, eVar);
            if (DEBUG) {
                Log.d("SplashData", "createFromJson() item.toString(): " + eVar.toString());
                return eVar;
            }
            return eVar;
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("SplashData", "createFromJson() Exception e: ");
                e.printStackTrace();
            }
            return null;
        }
    }

    public static List<e> o(JSONArray jSONArray) {
        e R;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                R = R((JSONObject) jSONArray.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("SplashData", "wqd--->splash parser JSONException: ");
                    e.printStackTrace();
                }
            }
            if (R == null) {
                break;
            }
            if (R.advisible == 1 && !g(R)) {
                if (DEBUG) {
                    Log.d("SplashData", "物料不合法抛弃： splashDataItem:  i=" + i + ",content" + R.toString());
                }
            } else {
                arrayList.add(R);
                if (DEBUG) {
                    Log.d("SplashData", "splashDataItem:  i=" + i + ",content" + R.toString());
                }
            }
        }
        return arrayList;
    }

    private static boolean g(e eVar) {
        boolean z;
        String str = "";
        if (TextUtils.isEmpty(eVar.ext)) {
            str = "7";
            z = false;
        } else {
            z = true;
        }
        if (z && TextUtils.isEmpty(eVar.url)) {
            str = "66";
            z = false;
        }
        if (z && TextUtils.isEmpty(eVar.md5)) {
            str = "67";
            z = false;
        }
        if (z && System.currentTimeMillis() / 1000 > eVar.end) {
            str = "68";
            z = false;
        }
        if (z) {
            return true;
        }
        new com.baidu.prologue.business.data.b(eVar).as(eVar.LX() ? "BC0263" : "BC0265", str);
        return false;
    }

    /* loaded from: classes6.dex */
    public static class a {
        static void a(e eVar, e eVar2) {
            eVar.advisible = eVar2.advisible;
            eVar.id = eVar2.id;
            eVar.bsq = eVar2.bsq;
            eVar.ext = eVar2.ext;
            eVar.bsr = eVar2.bsr;
            eVar.type = eVar2.type;
            eVar.url = eVar2.url;
            eVar.width = eVar2.width;
            eVar.height = eVar2.height;
            eVar.md5 = eVar2.md5;
            eVar.aqV = eVar2.aqV;
            eVar.bss = eVar2.bss;
            eVar.bst = eVar2.bst;
            eVar.bsu = eVar2.bsu;
            eVar.action = eVar2.action;
            eVar.bsv = eVar2.bsv;
            eVar.bsw = eVar2.bsw;
            eVar.start = eVar2.start;
            eVar.end = eVar2.end;
            eVar.bsx = eVar2.bsx;
            eVar.bsy = eVar2.bsy;
            eVar.bsz = eVar2.bsz;
        }

        static void a(JSONObject jSONObject, e eVar) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                    eVar.advisible = optJSONObject.optInt("advisible", 1);
                    eVar.id = optJSONObject.optString("id");
                    eVar.bsq = optJSONObject.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString("k");
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    eVar.ext = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 != null && (optJSONObject2 = optJSONArray3.optJSONObject(0)) != null) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                        if (optJSONArray4 == null) {
                            String optString3 = optJSONObject2.optString("info");
                            if (!TextUtils.isEmpty(optString3)) {
                                optJSONArray4 = new JSONArray(optString3);
                            }
                        }
                        if (optJSONArray4 != null) {
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                            eVar.bsr = optJSONObject4.optString("layout");
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                eVar.type = optJSONObject5.optInt("type");
                                eVar.aqV = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                eVar.action = optJSONObject5.optString("action");
                                eVar.bss = optJSONObject5.optString("flag_name");
                                eVar.bst = optJSONObject5.optInt("logo_type");
                                eVar.bsu = optJSONObject5.optInt("display");
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                if (eVar.LX() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.d(optJSONArray5.optJSONObject(0), eVar);
                                } else {
                                    c.d(optJSONObject5, eVar);
                                }
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                eVar.bsv = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    eVar.bsv[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                eVar.bsw = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    eVar.bsw[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                eVar.start = jSONObject2.optLong("start");
                                eVar.end = jSONObject2.optLong("end");
                                eVar.bsx = optJSONObject6.optInt("expose_interval");
                                eVar.bsy = optJSONObject6.optInt("expose_times");
                                eVar.preloadType = optJSONObject6.optInt("preload_type");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (e.DEBUG) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e.printStackTrace();
                }
            }
        }

        static void b(JSONObject jSONObject, e eVar) {
            try {
                eVar.advisible = jSONObject.optInt("advisible");
                eVar.id = jSONObject.optString("id");
                eVar.bsq = jSONObject.optString("ukey");
                eVar.ext = jSONObject.optString("extra");
                eVar.bsr = jSONObject.optString("layout");
                eVar.type = jSONObject.optInt("type");
                eVar.aqV = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                eVar.action = jSONObject.optString("action");
                eVar.bss = jSONObject.optString("flag_name");
                eVar.bst = jSONObject.optInt("logo_type");
                eVar.bsu = jSONObject.optInt("display");
                if (eVar.LX()) {
                    b.d(jSONObject, eVar);
                } else {
                    c.d(jSONObject, eVar);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                if (optJSONArray != null) {
                    eVar.bsv = new String[optJSONArray.length()];
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        eVar.bsv[i] = optJSONArray.optString(i);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                if (optJSONArray2 != null) {
                    eVar.bsw = new String[optJSONArray2.length()];
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        eVar.bsw[i2] = optJSONArray2.optString(i2);
                    }
                }
                eVar.start = jSONObject.optLong("start");
                eVar.end = jSONObject.optLong("end");
                eVar.bsx = jSONObject.optInt("expose_interval");
                eVar.bsy = jSONObject.optInt("expose_times");
                eVar.preloadType = jSONObject.optInt("preload_type");
                eVar.bsz = jSONObject.optInt("curRate");
            } catch (Exception e) {
                if (e.DEBUG) {
                    Log.d("SplashData", "createFromJson() Exception e: ");
                    e.printStackTrace();
                }
            }
        }

        static void c(JSONObject jSONObject, e eVar) {
            try {
                jSONObject.put("advisible", eVar.advisible);
                jSONObject.put("id", eVar.id);
                jSONObject.put("ukey", eVar.bsq);
                jSONObject.put("extra", eVar.ext);
                jSONObject.put("layout", eVar.bsr);
                jSONObject.put("type", eVar.type);
                jSONObject.put(BigdayActivityConfig.JUMP_URL, eVar.aqV);
                jSONObject.put("action", eVar.action);
                jSONObject.put("flag_name", eVar.bss);
                jSONObject.put("logo_type", eVar.bst);
                jSONObject.put("display", eVar.bsu);
                jSONObject.put("start", eVar.start);
                jSONObject.put("end", eVar.end);
                jSONObject.put("expose_times", eVar.bsy);
                jSONObject.put("expose_interval", eVar.bsx);
                jSONObject.put("preload_type", eVar.preloadType);
                jSONObject.put("curRate", eVar.bsz);
                if (eVar.bsv != null) {
                    if (com.baidu.prologue.a.c.d.hasKitKat()) {
                        jSONObject.put("show_urls", new JSONArray(eVar.bsv));
                    } else {
                        jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(eVar.bsv)));
                    }
                }
                if (eVar.bsw != null) {
                    if (com.baidu.prologue.a.c.d.hasKitKat()) {
                        jSONObject.put("click_urls", new JSONArray(eVar.bsw));
                    } else {
                        jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(eVar.bsw)));
                    }
                }
                if (eVar.LX()) {
                    b.c(jSONObject, eVar);
                } else {
                    c.c(jSONObject, eVar);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        static void d(JSONObject jSONObject, e eVar) {
            if (jSONObject != null) {
                try {
                    eVar.url = jSONObject.optString("url");
                    eVar.width = jSONObject.optInt("width");
                    eVar.height = jSONObject.optInt("height");
                    eVar.md5 = jSONObject.optString("imageMd5");
                } catch (Exception e) {
                    if (e.DEBUG) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e.printStackTrace();
                    }
                }
            }
        }

        static void c(JSONObject jSONObject, e eVar) {
            try {
                jSONObject.put("url", eVar.url);
                jSONObject.put("imageMd5", eVar.md5);
                jSONObject.put("width", eVar.width);
                jSONObject.put("height", eVar.height);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        static void d(JSONObject jSONObject, e eVar) {
            if (jSONObject != null) {
                try {
                    eVar.url = jSONObject.optString("url");
                    eVar.width = jSONObject.optInt("width");
                    eVar.height = jSONObject.optInt("height");
                    eVar.md5 = jSONObject.optString("md5");
                } catch (Exception e) {
                    if (e.DEBUG) {
                        Log.d("SplashData", "createFromJson() Exception e: ");
                        e.printStackTrace();
                    }
                }
            }
        }

        static void c(JSONObject jSONObject, e eVar) {
            try {
                jSONObject.put("url", eVar.url);
                jSONObject.put("md5", eVar.md5);
                jSONObject.put("width", eVar.width);
                jSONObject.put("height", eVar.height);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
