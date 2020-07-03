package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.e.d;
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
    private final String acY = "performance_" + System.currentTimeMillis();
    private int bWx = 3000;
    private HandlerC0330a bWy;
    private BufferedWriter bWz;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.XE().XF();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bWy == null) {
            this.bWy = new HandlerC0330a();
        }
        if (this.bWz == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bWz = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bWy.removeMessages(100);
        this.bWy.sendEmptyMessage(100);
    }

    public void eO(int i) {
        if (i >= 1000) {
            this.bWx = i;
        }
    }

    public String XD() {
        if (this.mData != null) {
            b.XE().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.bWz);
        this.bWz = null;
        return com.baidu.swan.apps.storage.b.bX(getFilePath(), e.apO());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class HandlerC0330a extends Handler {
        private HandlerC0330a() {
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
                a.this.ja(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.bWy != null) {
                    a.this.bWy.sendEmptyMessageDelayed(100, a.this.bWx);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(String str) {
        if (this.bWz != null) {
            try {
                this.bWz.write(str);
                this.bWz.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.L(e.apO(), this.acY, TbConfig.TMP_LOG_DIR_NAME);
    }
}
