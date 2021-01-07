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
    private final String agL = "performance_" + System.currentTimeMillis();
    private int cPS = 3000;
    private HandlerC0413a cPT;
    private BufferedWriter cPU;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.apT().apU();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cPT == null) {
            this.cPT = new HandlerC0413a();
        }
        if (this.cPU == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cPU = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cPT.removeMessages(100);
        this.cPT.sendEmptyMessage(100);
    }

    public void id(int i) {
        if (i >= 1000) {
            this.cPS = i;
        }
    }

    public String apS() {
        if (this.mData != null) {
            b.apT().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cPU);
        this.cPU = null;
        return com.baidu.swan.apps.storage.b.cG(getFilePath(), e.aMn());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class HandlerC0413a extends Handler {
        private HandlerC0413a() {
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
                a.this.mS(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cPT != null) {
                    a.this.cPT.sendEmptyMessageDelayed(100, a.this.cPS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(String str) {
        if (this.cPU != null) {
            try {
                this.cPU.write(str);
                this.cPU.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.ac(e.aMn(), this.agL, TbConfig.TMP_LOG_DIR_NAME);
    }
}
