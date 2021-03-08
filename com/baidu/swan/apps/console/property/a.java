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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HandlerC0399a cOV;
    private BufferedWriter cOW;
    private Map<String, Object> mData;
    private final String mLogFileName = "performance_" + System.currentTimeMillis();
    private int cOU = 3000;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.amz().amA();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cOV == null) {
            this.cOV = new HandlerC0399a();
        }
        if (this.cOW == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cOW = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cOV.removeMessages(100);
        this.cOV.sendEmptyMessage(100);
    }

    public void gB(int i) {
        if (i >= 1000) {
            this.cOU = i;
        }
    }

    public String amy() {
        if (this.mData != null) {
            b.amz().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cOW);
        this.cOW = null;
        return com.baidu.swan.apps.storage.b.cz(getFilePath(), e.aIP());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class HandlerC0399a extends Handler {
        private HandlerC0399a() {
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
                a.this.mg(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cOV != null) {
                    a.this.cOV.sendEmptyMessageDelayed(100, a.this.cOU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg(String str) {
        if (this.cOW != null) {
            try {
                this.cOW.write(str);
                this.cOW.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.ac(e.aIP(), this.mLogFileName, TbConfig.TMP_LOG_DIR_NAME);
    }
}
