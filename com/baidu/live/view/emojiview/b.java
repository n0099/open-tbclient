package com.baidu.live.view.emojiview;

import android.content.Context;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    public static List<String> bUT = new ArrayList();
    private static final HashMap<String, Integer> mMap = new HashMap<>();
    private static final HashMap<String, String> bUU = new HashMap<>();
    private static final HashMap<String, String> bUV = new HashMap<>();

    public static String O(Context context, String str) {
        return bUV.get(str);
    }

    public static void bw(Context context) {
        if (bUU != null && bUU.size() == 0) {
            bx(context);
        }
    }

    public static HashMap<String, Integer> XP() {
        return mMap;
    }

    public static HashMap<String, String> XQ() {
        return bUU;
    }

    private static void bx(Context context) {
        List<com.baidu.live.view.emojiview.a.a> XR = XR();
        if (XR == null || XR.size() == 0) {
            List<com.baidu.live.view.emojiview.a.a> by = by(context);
            bUT.clear();
            for (int i = 0; i < by.size(); i++) {
                com.baidu.live.view.emojiview.a.a aVar = by.get(i);
                mMap.put(aVar.text, Integer.valueOf(P(context, aVar.icon.split("\\.")[0])));
                bUV.put(aVar.text, aVar.id);
                bUT.add(aVar.text);
            }
            return;
        }
        bUT.clear();
        mMap.clear();
        for (int i2 = 0; i2 < XR.size(); i2++) {
            com.baidu.live.view.emojiview.a.a aVar2 = XR.get(i2);
            bUV.put(aVar2.text, aVar2.id);
            bUU.put(aVar2.text, aVar2.localPath);
            bUT.add(aVar2.text);
        }
    }

    private static List<com.baidu.live.view.emojiview.a.a> XR() {
        String str;
        String in = in(com.baidu.live.storage.b.hG(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CJ().Cv()));
        if (com.baidu.live.h.a.isDirectory(in)) {
            String str2 = in + "/info.json";
            if (com.baidu.live.h.a.existFile(str2)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(new File(str2));
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    str = new String(bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "";
                }
                List<com.baidu.live.view.emojiview.a.a> io2 = io(str);
                for (com.baidu.live.view.emojiview.a.a aVar : io2) {
                    aVar.localPath = in + "/" + aVar.icon;
                }
                return io2;
            }
            return null;
        }
        return null;
    }

    public static String in(String str) {
        if (com.baidu.live.h.a.existFile(str)) {
            if (!com.baidu.live.h.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            if (listFiles.length == 1 && listFiles[0] != null && listFiles[0].isDirectory()) {
                return in(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }

    private static int P(Context context, String str) {
        return d.iq(str);
    }

    public static List<com.baidu.live.view.emojiview.a.a> by(Context context) {
        List<com.baidu.live.view.emojiview.a.a> io2 = io(Q(context, "audio_emotion_info.json"));
        if (io2 != null) {
            return io2;
        }
        return null;
    }

    private static List<com.baidu.live.view.emojiview.a.a> io(String str) {
        int i = 0;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("packages").getJSONObject(0).optJSONArray("emoticons");
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                com.baidu.live.view.emojiview.a.a aVar = new com.baidu.live.view.emojiview.a.a();
                aVar.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                aVar.id = jSONObject.optString("id");
                aVar.text = jSONObject.optString("text");
                arrayList.add(aVar);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
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
