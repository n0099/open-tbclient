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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private final String amV = "performance_" + System.currentTimeMillis();
    private int amW = 3000;
    private HandlerC0095a amX;
    private BufferedWriter amY;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.wT().wU();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.amX == null) {
            this.amX = new HandlerC0095a();
        }
        if (this.amY == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.amY = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.amX.removeMessages(100);
        this.amX.sendEmptyMessage(100);
    }

    public void bT(int i) {
        if (i >= 1000) {
            this.amW = i;
        }
    }

    public String wS() {
        if (this.mData != null) {
            b.wT().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.b.c(this.amY);
        this.amY = null;
        return com.baidu.swan.apps.storage.b.aD(getFilePath(), com.baidu.swan.apps.ae.b.Ji());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0095a extends Handler {
        private HandlerC0095a() {
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
                a.this.dA(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.amX != null) {
                    a.this.amX.sendEmptyMessageDelayed(100, a.this.amW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(String str) {
        if (this.amY != null) {
            try {
                this.amY.write(str);
                this.amY.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.u(com.baidu.swan.apps.ae.b.Ji(), this.amV, TbConfig.TMP_LOG_DIR_NAME);
    }
}
