package com.baidu.ar.arspeech;

import android.content.Context;
import com.baidu.ar.util.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static b a;
    private Context b;
    private JSONObject c = null;

    private b(Context context) {
        this.b = context;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public JSONObject a() {
        return this.c;
    }

    public void a(String str) {
        if (str == null || !new File(str).exists()) {
            return;
        }
        try {
            this.c = new JSONObject(d.a(this.b, str)).getJSONObject("voice");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
