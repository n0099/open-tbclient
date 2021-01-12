package com.baidu.live.view.emojiview;

import android.content.Context;
import android.util.Log;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static final String[] bRe = new String[20];
    public static final String[] bRf = new String[20];
    public static final String[] bRg = new String[20];
    public static final String[] bRh = new String[20];
    public static final String[] bRi = new String[20];
    public static final String[] bRj = new String[20];
    public static final String[] bRk = new String[20];
    public static final String[] bRl = new String[20];
    public static final String[] bRm = new String[20];
    public static final String[] bRn = new String[20];
    private static final HashMap<String, Integer> mMap = new HashMap<>();
    private static final HashMap<String, String> bRo = new HashMap<>();

    public static String O(Context context, String str) {
        return bRo.get(str);
    }

    public static void bt(Context context) {
        if (mMap != null && mMap.size() == 0) {
            bu(context);
        }
    }

    public static HashMap<String, Integer> Wg() {
        return mMap;
    }

    private static void bu(Context context) {
        List<com.baidu.live.view.emojiview.a.a> bv = bv(context);
        for (int i = 0; i < bv.size(); i++) {
            com.baidu.live.view.emojiview.a.a aVar = bv.get(i);
            mMap.put(aVar.text, Integer.valueOf(P(context, aVar.icon.split("\\.")[0])));
            bRo.put(aVar.text, aVar.id);
            if (i < 20) {
                bRe[i] = aVar.text;
            } else if (i >= 20 && i < 40) {
                bRf[i - 20] = aVar.text;
            } else if (i >= 40 && i < 60) {
                bRg[i - 40] = aVar.text;
            } else if (i >= 60 && i < 80) {
                bRh[i - 60] = aVar.text;
            } else if (i >= 80 && i < 100) {
                bRi[i - 80] = aVar.text;
            } else if (i >= 100 && i < 120) {
                bRj[i - 100] = aVar.text;
            } else if (i >= 120 && i < 140) {
                bRk[i - 120] = aVar.text;
            } else if (i >= 140 && i < 160) {
                bRl[i - 140] = aVar.text;
            } else if (i >= 160 && i < 180) {
                bRm[i - 160] = aVar.text;
            } else if (i >= 180 && i < 200) {
                bRn[i - 180] = aVar.text;
            }
        }
    }

    private static int P(Context context, String str) {
        return d.hS(str);
    }

    public static List<com.baidu.live.view.emojiview.a.a> bv(Context context) {
        String Q = Q(context, "audio_emotion_info.json");
        Log.e("hyder", Q);
        try {
            JSONArray optJSONArray = new JSONObject(Q).optJSONArray("packages").getJSONObject(0).optJSONArray("emoticons");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                com.baidu.live.view.emojiview.a.a aVar = new com.baidu.live.view.emojiview.a.a();
                aVar.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                aVar.id = jSONObject.optString("id");
                aVar.text = jSONObject.optString("text");
                arrayList.add(aVar);
            }
            Log.e("hyder", ((com.baidu.live.view.emojiview.a.a) arrayList.get(0)).icon);
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=4] */
    public static String Q(Context context, String str) {
        Closeable closeable;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getAssets().open(str));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        close(bufferedReader);
                        close(inputStreamReader);
                        return sb.toString();
                    }
                }
                close(bufferedReader);
                close(inputStreamReader);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                close(closeable);
                close(inputStreamReader);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            inputStreamReader = null;
        }
        return sb.toString();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
