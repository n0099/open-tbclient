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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String aeS = "performance_" + System.currentTimeMillis();
    private int cfd = 3000;
    private HandlerC0368a cfe;
    private BufferedWriter cff;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.afa().afb();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cfe == null) {
            this.cfe = new HandlerC0368a();
        }
        if (this.cff == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cff = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cfe.removeMessages(100);
        this.cfe.sendEmptyMessage(100);
    }

    public void gX(int i) {
        if (i >= 1000) {
            this.cfd = i;
        }
    }

    public String aeZ() {
        if (this.mData != null) {
            b.afa().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cff);
        this.cff = null;
        return com.baidu.swan.apps.storage.b.cp(getFilePath(), e.aAt());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class HandlerC0368a extends Handler {
        private HandlerC0368a() {
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
                a.this.le(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cfe != null) {
                    a.this.cfe.sendEmptyMessageDelayed(100, a.this.cfd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(String str) {
        if (this.cff != null) {
            try {
                this.cff.write(str);
                this.cff.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.O(e.aAt(), this.aeS, TbConfig.TMP_LOG_DIR_NAME);
    }
}
