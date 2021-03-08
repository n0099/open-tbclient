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
/* loaded from: classes10.dex */
public final class b {
    public static List<String> bWt = new ArrayList();
    private static final HashMap<String, Integer> mMap = new HashMap<>();
    private static final HashMap<String, String> bWu = new HashMap<>();
    private static final HashMap<String, String> bWv = new HashMap<>();

    public static String O(Context context, String str) {
        return bWv.get(str);
    }

    public static void bv(Context context) {
        if (bWu != null && bWu.size() == 0) {
            bw(context);
        }
    }

    public static HashMap<String, Integer> XS() {
        return mMap;
    }

    public static HashMap<String, String> XT() {
        return bWu;
    }

    private static void bw(Context context) {
        List<com.baidu.live.view.emojiview.a.a> XU = XU();
        if (XU == null || XU.size() == 0) {
            List<com.baidu.live.view.emojiview.a.a> bx = bx(context);
            bWt.clear();
            for (int i = 0; i < bx.size(); i++) {
                com.baidu.live.view.emojiview.a.a aVar = bx.get(i);
                mMap.put(aVar.text, Integer.valueOf(P(context, aVar.icon.split("\\.")[0])));
                bWv.put(aVar.text, aVar.id);
                bWt.add(aVar.text);
            }
            return;
        }
        bWt.clear();
        mMap.clear();
        for (int i2 = 0; i2 < XU.size(); i2++) {
            com.baidu.live.view.emojiview.a.a aVar2 = XU.get(i2);
            bWv.put(aVar2.text, aVar2.id);
            bWu.put(aVar2.text, aVar2.localPath);
            bWt.add(aVar2.text);
        }
    }

    private static List<com.baidu.live.view.emojiview.a.a> XU() {
        String str;
        String it = it(com.baidu.live.storage.b.hM(com.baidu.live.ae.a.Qm().bwx.aOT.aSI.CM().Cy()));
        if (com.baidu.live.h.a.isDirectory(it)) {
            String str2 = it + "/info.json";
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
                List<com.baidu.live.view.emojiview.a.a> iu = iu(str);
                for (com.baidu.live.view.emojiview.a.a aVar : iu) {
                    aVar.localPath = it + "/" + aVar.icon;
                }
                return iu;
            }
            return null;
        }
        return null;
    }

    public static String it(String str) {
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
                return it(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }

    private static int P(Context context, String str) {
        return d.iw(str);
    }

    public static List<com.baidu.live.view.emojiview.a.a> bx(Context context) {
        List<com.baidu.live.view.emojiview.a.a> iu = iu(Q(context, "audio_emotion_info.json"));
        if (iu != null) {
            return iu;
        }
        return null;
    }

    private static List<com.baidu.live.view.emojiview.a.a> iu(String str) {
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
