package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.c.d;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String afp = "performance_" + System.currentTimeMillis();
    private int cEd = 3000;
    private HandlerC0409a cEe;
    private BufferedWriter cEf;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.alx().aly();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cEe == null) {
            this.cEe = new HandlerC0409a();
        }
        if (this.cEf == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cEf = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cEe.removeMessages(100);
        this.cEe.sendEmptyMessage(100);
    }

    public void hL(int i) {
        if (i >= 1000) {
            this.cEd = i;
        }
    }

    public String alw() {
        if (this.mData != null) {
            b.alx().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cEf);
        this.cEf = null;
        return com.baidu.swan.apps.storage.b.cA(getFilePath(), e.aGO());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class HandlerC0409a extends Handler {
        private HandlerC0409a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.mData != null) {
                a.this.mData.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.mData.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                a.this.ms(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cEe != null) {
                    a.this.cEe.sendEmptyMessageDelayed(100, a.this.cEd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str) {
        if (this.cEf != null) {
            try {
                this.cEf.write(str);
                this.cEf.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.W(e.aGO(), this.afp, TbConfig.TMP_LOG_DIR_NAME);
    }
}
