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
    private final String aHF = "performance_" + System.currentTimeMillis();
    private int aHG = 3000;
    private HandlerC0170a aHH;
    private BufferedWriter aHI;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Do().Dp();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.aHH == null) {
            this.aHH = new HandlerC0170a();
        }
        if (this.aHI == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.aHI = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.aHH.removeMessages(100);
        this.aHH.sendEmptyMessage(100);
    }

    public void cP(int i) {
        if (i >= 1000) {
            this.aHG = i;
        }
    }

    public String Dn() {
        if (this.mData != null) {
            b.Do().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.a.b(this.aHI);
        this.aHI = null;
        return com.baidu.swan.apps.storage.b.aN(getFilePath(), com.baidu.swan.apps.ae.b.Rk());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0170a extends Handler {
        private HandlerC0170a() {
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
                a.this.ee(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.aHH != null) {
                    a.this.aHH.sendEmptyMessageDelayed(100, a.this.aHG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(String str) {
        if (this.aHI != null) {
            try {
                this.aHI.write(str);
                this.aHI.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.A(com.baidu.swan.apps.ae.b.Rk(), this.aHF, TbConfig.TMP_LOG_DIR_NAME);
    }
}
