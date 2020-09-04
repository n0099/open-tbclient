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
    private final String aeA = "performance_" + System.currentTimeMillis();
    private int cdb = 3000;
    private HandlerC0373a cdc;
    private BufferedWriter cdd;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.aeq().aer();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cdc == null) {
            this.cdc = new HandlerC0373a();
        }
        if (this.cdd == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cdd = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cdc.removeMessages(100);
        this.cdc.sendEmptyMessage(100);
    }

    public void gO(int i) {
        if (i >= 1000) {
            this.cdb = i;
        }
    }

    public String aep() {
        if (this.mData != null) {
            b.aeq().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cdd);
        this.cdd = null;
        return com.baidu.swan.apps.storage.b.cp(getFilePath(), e.azK());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class HandlerC0373a extends Handler {
        private HandlerC0373a() {
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
                a.this.kL(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cdc != null) {
                    a.this.cdc.sendEmptyMessageDelayed(100, a.this.cdb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(String str) {
        if (this.cdd != null) {
            try {
                this.cdd.write(str);
                this.cdd.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.O(e.azK(), this.aeA, TbConfig.TMP_LOG_DIR_NAME);
    }
}
