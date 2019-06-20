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
    private final String ann = "performance_" + System.currentTimeMillis();
    private int ano = 3000;
    private HandlerC0127a anp;
    private BufferedWriter anq;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.xK().xL();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.anp == null) {
            this.anp = new HandlerC0127a();
        }
        if (this.anq == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.anq = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.anp.removeMessages(100);
        this.anp.sendEmptyMessage(100);
    }

    public void bS(int i) {
        if (i >= 1000) {
            this.ano = i;
        }
    }

    public String xJ() {
        if (this.mData != null) {
            b.xK().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.a.c(this.anq);
        this.anq = null;
        return com.baidu.swan.apps.storage.b.aG(getFilePath(), com.baidu.swan.apps.ae.b.LB());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0127a extends Handler {
        private HandlerC0127a() {
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
                a.this.m15do(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.anp != null) {
                    a.this.anp.sendEmptyMessageDelayed(100, a.this.ano);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m15do(String str) {
        if (this.anq != null) {
            try {
                this.anq.write(str);
                this.anq.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.u(com.baidu.swan.apps.ae.b.LB(), this.ann, TbConfig.TMP_LOG_DIR_NAME);
    }
}
