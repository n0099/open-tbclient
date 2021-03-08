package com.baidu.spswitch.emotion;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static b cCx;
    private static Context mContext;
    private HashMap<String, a> cCy = new HashMap<>();
    private List<String> cCz = new ArrayList();

    public static b bP(Context context) {
        if (cCx == null) {
            synchronized (c.class) {
                if (cCx == null) {
                    cCx = new b(context.getApplicationContext());
                }
            }
        }
        return cCx;
    }

    private b(Context context) {
        mContext = context;
        bQ(context);
    }

    private void bQ(Context context) {
        JSONObject optJSONObject;
        try {
            JSONArray optJSONArray = new JSONObject(bR(context)).optJSONArray("packages");
            if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("emoticons");
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray2.get(i);
                        String optString = jSONObject.optString("id");
                        String optString2 = jSONObject.optString("text");
                        this.cCy.put(optString2, new a(optString, optString2, Integer.valueOf(jS(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON)))));
                    }
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("panel_emoticons");
                if (optJSONArray3 != null) {
                    int length2 = optJSONArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        String jR = jR((String) optJSONArray3.get(i2));
                        if (!TextUtils.isEmpty(jR)) {
                            this.cCz.add(jR);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String jR(String str) {
        String str2 = "";
        for (Map.Entry<String, a> entry : this.cCy.entrySet()) {
            str2 = entry.getKey();
            if (str.equals(entry.getValue().id)) {
                break;
            }
        }
        return str2;
    }

    private int jS(String str) {
        if (str == null) {
            return 0;
        }
        return mContext.getResources().getIdentifier(str.substring(0, str.indexOf(".png")), "drawable", mContext.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String bR(Context context) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(context.getApplicationContext().getAssets().open("emotion_info.json"), "utf-8"));
            if (bufferedReader != null) {
                try {
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(readLine);
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return sb.toString();
    }

    public int a(EmotionType emotionType, String str) {
        Integer num;
        switch (emotionType) {
            case EMOTION_CLASSIC_TYPE:
                a aVar = this.cCy.get(str);
                if (aVar != null) {
                    num = aVar.cCB;
                    break;
                }
            default:
                num = null;
                break;
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public String b(EmotionType emotionType, String str) {
        a aVar = null;
        switch (emotionType) {
            case EMOTION_CLASSIC_TYPE:
                aVar = this.cCy.get(str);
                break;
        }
        return aVar == null ? "" : aVar.id;
    }

    public List afM() {
        return this.cCz;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public Integer cCB;
        public String id;
        public String text;

        public a(String str, String str2, Integer num) {
            this.id = str;
            this.text = str2;
            this.cCB = num;
        }
    }
}
