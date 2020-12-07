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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String agl = "performance_" + System.currentTimeMillis();
    private int cKX = 3000;
    private HandlerC0421a cKY;
    private BufferedWriter cKZ;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.aoF().aoG();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cKY == null) {
            this.cKY = new HandlerC0421a();
        }
        if (this.cKZ == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cKZ = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cKY.removeMessages(100);
        this.cKY.sendEmptyMessage(100);
    }

    public void ij(int i) {
        if (i >= 1000) {
            this.cKX = i;
        }
    }

    public String aoE() {
        if (this.mData != null) {
            b.aoF().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cKZ);
        this.cKZ = null;
        return com.baidu.swan.apps.storage.b.cH(getFilePath(), e.aJW());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private class HandlerC0421a extends Handler {
        private HandlerC0421a() {
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
                a.this.mZ(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cKY != null) {
                    a.this.cKY.sendEmptyMessageDelayed(100, a.this.cKX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ(String str) {
        if (this.cKZ != null) {
            try {
                this.cKZ.write(str);
                this.cKZ.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.Z(e.aJW(), this.agl, TbConfig.TMP_LOG_DIR_NAME);
    }
}
