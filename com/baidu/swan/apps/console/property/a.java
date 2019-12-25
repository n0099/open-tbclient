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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String Iq = "performance_" + System.currentTimeMillis();
    private int bfo = 3000;
    private HandlerC0224a bfp;
    private BufferedWriter bfq;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Jo().Jp();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bfp == null) {
            this.bfp = new HandlerC0224a();
        }
        if (this.bfq == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bfq = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bfp.removeMessages(100);
        this.bfp.sendEmptyMessage(100);
    }

    public void dW(int i) {
        if (i >= 1000) {
            this.bfo = i;
        }
    }

    public String Jn() {
        if (this.mData != null) {
            b.Jo().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.d.c.closeSafely(this.bfq);
        this.bfq = null;
        return com.baidu.swan.apps.storage.b.bh(getFilePath(), e.ZU());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class HandlerC0224a extends Handler {
        private HandlerC0224a() {
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
                a.this.gm(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.bfp != null) {
                    a.this.bfp.sendEmptyMessageDelayed(100, a.this.bfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(String str) {
        if (this.bfq != null) {
            try {
                this.bfq.write(str);
                this.bfq.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.G(e.ZU(), this.Iq, TbConfig.TMP_LOG_DIR_NAME);
    }
}
