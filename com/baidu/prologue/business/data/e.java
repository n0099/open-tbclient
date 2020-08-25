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
/* loaded from: classes9.dex */
public class e {
    protected static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    public String aDg;
    public String action;
    public int advisible;
    public String bKI;
    public String bKJ;
    public String bKK;
    public int bKL;
    public int bKM;
    public String[] bKN;
    public String[] bKO;
    public int bKP;
    public int bKQ;
    public int bKR = 0;
    public boolean bKS = false;
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

    public boolean VA() {
        return TextUtils.equals(this.bKJ, "splash_image");
    }

    public boolean isFullScreen() {
        return this.type == 1;
    }

    public static void a(e eVar, e eVar2) {
        a.a(eVar, eVar2);
    }

    public String VB() {
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, this);
        return jSONObject.toString();
    }

    public static e af(JSONObject jSONObject) {
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

    public static e ag(JSONObject jSONObject) {
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

    public static List<e> p(JSONArray jSONArray) {
        e ag;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                ag = ag((JSONObject) jSONArray.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("SplashData", "wqd--->splash parser JSONException: ");
                    e.printStackTrace();
                }
            }
            if (ag == null) {
                break;
            }
            if (ag.advisible == 1 && !g(ag)) {
                if (DEBUG) {
                    Log.d("SplashData", "物料不合法抛弃： splashDataItem:  i=" + i + ",content" + ag.toString());
                }
            } else {
                arrayList.add(ag);
                if (DEBUG) {
                    Log.d("SplashData", "splashDataItem:  i=" + i + ",content" + ag.toString());
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
        new com.baidu.prologue.business.data.b(eVar).aN(eVar.VA() ? "BC0263" : "BC0265", str);
        return false;
    }

    /* loaded from: classes9.dex */
    public static class a {
        static void a(e eVar, e eVar2) {
            eVar.advisible = eVar2.advisible;
            eVar.id = eVar2.id;
            eVar.bKI = eVar2.bKI;
            eVar.ext = eVar2.ext;
            eVar.bKJ = eVar2.bKJ;
            eVar.type = eVar2.type;
            eVar.url = eVar2.url;
            eVar.width = eVar2.width;
            eVar.height = eVar2.height;
            eVar.md5 = eVar2.md5;
            eVar.aDg = eVar2.aDg;
            eVar.bKK = eVar2.bKK;
            eVar.bKL = eVar2.bKL;
            eVar.bKM = eVar2.bKM;
            eVar.action = eVar2.action;
            eVar.bKN = eVar2.bKN;
            eVar.bKO = eVar2.bKO;
            eVar.start = eVar2.start;
            eVar.end = eVar2.end;
            eVar.bKP = eVar2.bKP;
            eVar.bKQ = eVar2.bKQ;
            eVar.bKR = eVar2.bKR;
        }

        static void a(JSONObject jSONObject, e eVar) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                    eVar.advisible = optJSONObject.optInt("advisible", 1);
                    eVar.id = optJSONObject.optString("id");
                    eVar.bKI = optJSONObject.optString("ukey");
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
                            eVar.bKJ = optJSONObject4.optString("layout");
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                eVar.type = optJSONObject5.optInt("type");
                                eVar.aDg = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                eVar.action = optJSONObject5.optString("action");
                                eVar.bKK = optJSONObject5.optString("flag_name");
                                eVar.bKL = optJSONObject5.optInt("logo_type");
                                eVar.bKM = optJSONObject5.optInt("display");
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                if (eVar.VA() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.d(optJSONArray5.optJSONObject(0), eVar);
                                } else {
                                    c.d(optJSONObject5, eVar);
                                }
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                eVar.bKN = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    eVar.bKN[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                eVar.bKO = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    eVar.bKO[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                eVar.start = jSONObject2.optLong("start");
                                eVar.end = jSONObject2.optLong("end");
                                eVar.bKP = optJSONObject6.optInt("expose_interval");
                                eVar.bKQ = optJSONObject6.optInt("expose_times");
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
                eVar.bKI = jSONObject.optString("ukey");
                eVar.ext = jSONObject.optString("extra");
                eVar.bKJ = jSONObject.optString("layout");
                eVar.type = jSONObject.optInt("type");
                eVar.aDg = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                eVar.action = jSONObject.optString("action");
                eVar.bKK = jSONObject.optString("flag_name");
                eVar.bKL = jSONObject.optInt("logo_type");
                eVar.bKM = jSONObject.optInt("display");
                if (eVar.VA()) {
                    b.d(jSONObject, eVar);
                } else {
                    c.d(jSONObject, eVar);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                if (optJSONArray != null) {
                    eVar.bKN = new String[optJSONArray.length()];
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        eVar.bKN[i] = optJSONArray.optString(i);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                if (optJSONArray2 != null) {
                    eVar.bKO = new String[optJSONArray2.length()];
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        eVar.bKO[i2] = optJSONArray2.optString(i2);
                    }
                }
                eVar.start = jSONObject.optLong("start");
                eVar.end = jSONObject.optLong("end");
                eVar.bKP = jSONObject.optInt("expose_interval");
                eVar.bKQ = jSONObject.optInt("expose_times");
                eVar.preloadType = jSONObject.optInt("preload_type");
                eVar.bKR = jSONObject.optInt("curRate");
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
                jSONObject.put("ukey", eVar.bKI);
                jSONObject.put("extra", eVar.ext);
                jSONObject.put("layout", eVar.bKJ);
                jSONObject.put("type", eVar.type);
                jSONObject.put(BigdayActivityConfig.JUMP_URL, eVar.aDg);
                jSONObject.put("action", eVar.action);
                jSONObject.put("flag_name", eVar.bKK);
                jSONObject.put("logo_type", eVar.bKL);
                jSONObject.put("display", eVar.bKM);
                jSONObject.put("start", eVar.start);
                jSONObject.put("end", eVar.end);
                jSONObject.put("expose_times", eVar.bKQ);
                jSONObject.put("expose_interval", eVar.bKP);
                jSONObject.put("preload_type", eVar.preloadType);
                jSONObject.put("curRate", eVar.bKR);
                if (eVar.bKN != null) {
                    if (com.baidu.prologue.a.c.d.hasKitKat()) {
                        jSONObject.put("show_urls", new JSONArray(eVar.bKN));
                    } else {
                        jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(eVar.bKN)));
                    }
                }
                if (eVar.bKO != null) {
                    if (com.baidu.prologue.a.c.d.hasKitKat()) {
                        jSONObject.put("click_urls", new JSONArray(eVar.bKO));
                    } else {
                        jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(eVar.bKO)));
                    }
                }
                if (eVar.VA()) {
                    b.c(jSONObject, eVar);
                } else {
                    c.c(jSONObject, eVar);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
