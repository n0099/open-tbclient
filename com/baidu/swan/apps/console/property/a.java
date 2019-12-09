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
    private final String aHn = "performance_" + System.currentTimeMillis();
    private int aHo = 3000;
    private HandlerC0165a aHp;
    private BufferedWriter aHq;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Dp().Dq();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.aHp == null) {
            this.aHp = new HandlerC0165a();
        }
        if (this.aHq == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.aHq = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.aHp.removeMessages(100);
        this.aHp.sendEmptyMessage(100);
    }

    public void cP(int i) {
        if (i >= 1000) {
            this.aHo = i;
        }
    }

    public String Do() {
        if (this.mData != null) {
            b.Dp().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.a.b(this.aHq);
        this.aHq = null;
        return com.baidu.swan.apps.storage.b.aN(getFilePath(), com.baidu.swan.apps.ae.b.Rm());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0165a extends Handler {
        private HandlerC0165a() {
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
                if (a.this.aHp != null) {
                    a.this.aHp.sendEmptyMessageDelayed(100, a.this.aHo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(String str) {
        if (this.aHq != null) {
            try {
                this.aHq.write(str);
                this.aHq.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.A(com.baidu.swan.apps.ae.b.Rm(), this.aHn, TbConfig.TMP_LOG_DIR_NAME);
    }
}
