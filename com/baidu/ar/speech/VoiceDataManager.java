package com.baidu.ar.speech;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VoiceDataManager {
    private static VoiceDataManager a;
    private Context b;
    private JSONObject c = null;

    private VoiceDataManager(Context context) {
        this.b = context;
    }

    public static synchronized VoiceDataManager getInstance(Context context) {
        VoiceDataManager voiceDataManager;
        synchronized (VoiceDataManager.class) {
            if (a == null) {
                a = new VoiceDataManager(context);
            }
            voiceDataManager = a;
        }
        return voiceDataManager;
    }

    public JSONObject getVoiceObj() {
        return this.c;
    }

    public void parseVoiceData(String str) {
        try {
            SpeechManager.getInstance(this.b).setShowErrorTips(new JSONObject(str).getBoolean("show_error_tips"));
            this.c = new JSONObject(str).getJSONObject("voice");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("lua ", "parseVoiceData error");
        }
    }
}
