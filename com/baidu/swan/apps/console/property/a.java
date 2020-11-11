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
    private int cFN = 3000;
    private HandlerC0411a cFO;
    private BufferedWriter cFP;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.amf().amg();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cFO == null) {
            this.cFO = new HandlerC0411a();
        }
        if (this.cFP == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cFP = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cFO.removeMessages(100);
        this.cFO.sendEmptyMessage(100);
    }

    public void hP(int i) {
        if (i >= 1000) {
            this.cFN = i;
        }
    }

    public String ame() {
        if (this.mData != null) {
            b.amf().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cFP);
        this.cFP = null;
        return com.baidu.swan.apps.storage.b.cB(getFilePath(), e.aHw());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class HandlerC0411a extends Handler {
        private HandlerC0411a() {
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
                a.this.my(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cFO != null) {
                    a.this.cFO.sendEmptyMessageDelayed(100, a.this.cFN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (this.cFP != null) {
            try {
                this.cFP.write(str);
                this.cFP.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.W(e.aHw(), this.afk, TbConfig.TMP_LOG_DIR_NAME);
    }
}
