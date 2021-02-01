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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HandlerC0393a cNv;
    private BufferedWriter cNw;
    private Map<String, Object> mData;
    private final String mLogFileName = "performance_" + System.currentTimeMillis();
    private int cNu = 3000;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.amw().amx();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cNv == null) {
            this.cNv = new HandlerC0393a();
        }
        if (this.cNw == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cNw = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cNv.removeMessages(100);
        this.cNv.sendEmptyMessage(100);
    }

    public void gA(int i) {
        if (i >= 1000) {
            this.cNu = i;
        }
    }

    public String amv() {
        if (this.mData != null) {
            b.amw().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cNw);
        this.cNw = null;
        return com.baidu.swan.apps.storage.b.cz(getFilePath(), e.aIM());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class HandlerC0393a extends Handler {
        private HandlerC0393a() {
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
                a.this.lZ(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cNv != null) {
                    a.this.cNv.sendEmptyMessageDelayed(100, a.this.cNu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(String str) {
        if (this.cNw != null) {
            try {
                this.cNw.write(str);
                this.cNw.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.ac(e.aIM(), this.mLogFileName, TbConfig.TMP_LOG_DIR_NAME);
    }
}
