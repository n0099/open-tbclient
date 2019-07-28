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
    private final String anQ = "performance_" + System.currentTimeMillis();
    private int anR = 3000;
    private HandlerC0129a anS;
    private BufferedWriter anT;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.yp().yq();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.anS == null) {
            this.anS = new HandlerC0129a();
        }
        if (this.anT == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.anT = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.anS.removeMessages(100);
        this.anS.sendEmptyMessage(100);
    }

    public void bS(int i) {
        if (i >= 1000) {
            this.anR = i;
        }
    }

    public String yo() {
        if (this.mData != null) {
            b.yp().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.a.c(this.anT);
        this.anT = null;
        return com.baidu.swan.apps.storage.b.aG(getFilePath(), com.baidu.swan.apps.ae.b.Mo());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0129a extends Handler {
        private HandlerC0129a() {
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
                a.this.dt(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.anS != null) {
                    a.this.anS.sendEmptyMessageDelayed(100, a.this.anR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(String str) {
        if (this.anT != null) {
            try {
                this.anT.write(str);
                this.anT.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.u(com.baidu.swan.apps.ae.b.Mo(), this.anQ, TbConfig.TMP_LOG_DIR_NAME);
    }
}
