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
    private final String afj = "performance_" + System.currentTimeMillis();
    private int cru = 3000;
    private HandlerC0385a crv;
    private BufferedWriter crw;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.ahL().ahM();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.crv == null) {
            this.crv = new HandlerC0385a();
        }
        if (this.crw == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.crw = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.crv.removeMessages(100);
        this.crv.sendEmptyMessage(100);
    }

    public void hu(int i) {
        if (i >= 1000) {
            this.cru = i;
        }
    }

    public String ahK() {
        if (this.mData != null) {
            b.ahL().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.crw);
        this.crw = null;
        return com.baidu.swan.apps.storage.b.cu(getFilePath(), e.aDc());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class HandlerC0385a extends Handler {
        private HandlerC0385a() {
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
                a.this.lQ(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.crv != null) {
                    a.this.crv.sendEmptyMessageDelayed(100, a.this.cru);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(String str) {
        if (this.crw != null) {
            try {
                this.crw.write(str);
                this.crw.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.P(e.aDc(), this.afj, TbConfig.TMP_LOG_DIR_NAME);
    }
}
