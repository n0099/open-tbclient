package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.d.d;
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
    private final String acT = "performance_" + System.currentTimeMillis();
    private int bXo = 3000;
    private HandlerC0332a bXp;
    private BufferedWriter bXq;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Yk().Yl();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bXp == null) {
            this.bXp = new HandlerC0332a();
        }
        if (this.bXq == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bXq = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bXp.removeMessages(100);
        this.bXp.sendEmptyMessage(100);
    }

    public void eQ(int i) {
        if (i >= 1000) {
            this.bXo = i;
        }
    }

    public String Yj() {
        if (this.mData != null) {
            b.Yk().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.bXq);
        this.bXq = null;
        return com.baidu.swan.apps.storage.b.bY(getFilePath(), e.arx());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class HandlerC0332a extends Handler {
        private HandlerC0332a() {
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
                a.this.jk(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.bXp != null) {
                    a.this.bXp.sendEmptyMessageDelayed(100, a.this.bXo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(String str) {
        if (this.bXq != null) {
            try {
                this.bXq.write(str);
                this.bXq.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.L(e.arx(), this.acT, TbConfig.TMP_LOG_DIR_NAME);
    }
}
