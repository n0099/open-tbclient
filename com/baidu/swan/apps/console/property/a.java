package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private final String aoo = "performance_" + System.currentTimeMillis();
    private int aop = 3000;
    private HandlerC0138a aoq;
    private BufferedWriter aor;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.yt().yu();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.aoq == null) {
            this.aoq = new HandlerC0138a();
        }
        if (this.aor == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.aor = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.aoq.removeMessages(100);
        this.aoq.sendEmptyMessage(100);
    }

    public void bT(int i) {
        if (i >= 1000) {
            this.aop = i;
        }
    }

    public String ys() {
        if (this.mData != null) {
            b.yt().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.c.a.c(this.aor);
        this.aor = null;
        return com.baidu.swan.apps.storage.b.aG(getFilePath(), com.baidu.swan.apps.ae.b.Ms());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class HandlerC0138a extends Handler {
        private HandlerC0138a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.mData != null) {
                a.this.mData.put(DpStatConstants.KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.mData.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                a.this.dv(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.aoq != null) {
                    a.this.aoq.sendEmptyMessageDelayed(100, a.this.aop);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(String str) {
        if (this.aor != null) {
            try {
                this.aor.write(str);
                this.aor.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.u(com.baidu.swan.apps.ae.b.Ms(), this.aoo, TbConfig.TMP_LOG_DIR_NAME);
    }
}
