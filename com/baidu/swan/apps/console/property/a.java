package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String IU = "performance_" + System.currentTimeMillis();
    private int bkF = 3000;
    private HandlerC0236a bkG;
    private BufferedWriter bkH;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Me().Mf();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bkG == null) {
            this.bkG = new HandlerC0236a();
        }
        if (this.bkH == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bkH = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bkG.removeMessages(100);
        this.bkG.sendEmptyMessage(100);
    }

    public void en(int i) {
        if (i >= 1000) {
            this.bkF = i;
        }
    }

    public String Md() {
        if (this.mData != null) {
            b.Me().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        com.baidu.swan.d.c.closeSafely(this.bkH);
        this.bkH = null;
        return com.baidu.swan.apps.storage.b.bq(getFilePath(), e.acK());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class HandlerC0236a extends Handler {
        private HandlerC0236a() {
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
                a.this.gE(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.bkG != null) {
                    a.this.bkG.sendEmptyMessageDelayed(100, a.this.bkF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(String str) {
        if (this.bkH != null) {
            try {
                this.bkH.write(str);
                this.bkH.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.H(e.acK(), this.IU, TbConfig.TMP_LOG_DIR_NAME);
    }
}
