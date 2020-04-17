package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String abY = "performance_" + System.currentTimeMillis();
    private int bIN = 3000;
    private HandlerC0266a bIO;
    private BufferedWriter bIP;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.TS().TT();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bIO == null) {
            this.bIO = new HandlerC0266a();
        }
        if (this.bIP == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bIP = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bIO.removeMessages(100);
        this.bIO.sendEmptyMessage(100);
    }

    public void es(int i) {
        if (i >= 1000) {
            this.bIN = i;
        }
    }

    public String TR() {
        if (this.mData != null) {
            b.TS().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.d.c.closeSafely(this.bIP);
        this.bIP = null;
        return com.baidu.swan.apps.storage.b.bA(getFilePath(), e.akP());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class HandlerC0266a extends Handler {
        private HandlerC0266a() {
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
                a.this.hR(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.bIO != null) {
                    a.this.bIO.sendEmptyMessageDelayed(100, a.this.bIN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(String str) {
        if (this.bIP != null) {
            try {
                this.bIP.write(str);
                this.bIP.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.H(e.akP(), this.abY, TbConfig.TMP_LOG_DIR_NAME);
    }
}
