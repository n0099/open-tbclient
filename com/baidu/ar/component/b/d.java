package com.baidu.ar.component.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.speech.SpeechManager;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static d a;
    private Context b;
    private JSONObject c = null;

    private d(Context context) {
        this.b = context;
        b();
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    public JSONObject a() {
        return this.c;
    }

    public void b() {
        String readFileText = FileUtils.readFileText(ARFileUtils.getVoiceFilePath(ARConfig.getARKey()));
        if (TextUtils.isEmpty(readFileText)) {
            return;
        }
        try {
            SpeechManager.getInstance(this.b).setShowErrorTips(new JSONObject(readFileText).getBoolean("show_error_tips"));
            this.c = new JSONObject(readFileText).getJSONObject("voice");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("lua ", "parseVoiceData error");
        }
    }
}
