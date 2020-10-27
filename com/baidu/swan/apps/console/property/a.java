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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String afk = "performance_" + System.currentTimeMillis();
    private int czU = 3000;
    private HandlerC0399a czV;
    private BufferedWriter czW;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.ajF().ajG();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.czV == null) {
            this.czV = new HandlerC0399a();
        }
        if (this.czW == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.czW = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.czV.removeMessages(100);
        this.czV.sendEmptyMessage(100);
    }

    public void hF(int i) {
        if (i >= 1000) {
            this.czU = i;
        }
    }

    public String ajE() {
        if (this.mData != null) {
            b.ajF().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.czW);
        this.czW = null;
        return com.baidu.swan.apps.storage.b.cB(getFilePath(), e.aEW());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
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
                a.this.mj(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.czV != null) {
                    a.this.czV.sendEmptyMessageDelayed(100, a.this.czU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(String str) {
        if (this.czW != null) {
            try {
                this.czW.write(str);
                this.czW.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.W(e.aEW(), this.afk, TbConfig.TMP_LOG_DIR_NAME);
    }
}
