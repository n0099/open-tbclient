package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String anb = "performance_" + System.currentTimeMillis();
    private int anc = 3000;
    private HandlerC0124a and;
    private BufferedWriter ane;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.wS().wT();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.and == null) {
            this.and = new HandlerC0124a();
        }
        if (this.ane == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.ane = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.and.removeMessages(100);
        this.and.sendEmptyMessage(100);
    }

    public void bS(int i) {
        if (i >= 1000) {
            this.anc = i;
        }
    }

    public String wR() {
        if (this.mData != null) {
            b.wS().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.b.c(this.ane);
        this.ane = null;
        return com.baidu.swan.apps.storage.b.aD(getFilePath(), com.baidu.swan.apps.ae.b.Jg());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0124a extends Handler {
        private HandlerC0124a() {
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
                a.this.dC(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.and != null) {
                    a.this.and.sendEmptyMessageDelayed(100, a.this.anc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(String str) {
        if (this.ane != null) {
            try {
                this.ane.write(str);
                this.ane.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.u(com.baidu.swan.apps.ae.b.Jg(), this.anb, TbConfig.TMP_LOG_DIR_NAME);
    }
}
