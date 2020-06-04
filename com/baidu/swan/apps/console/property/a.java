package com.baidu.swan.apps.console.property;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.e.d;
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
    private final String act = "performance_" + System.currentTimeMillis();
    private int bRJ = 3000;
    private HandlerC0324a bRK;
    private BufferedWriter bRL;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.Wy().Wz();
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Start monitor logcat");
        }
        if (this.bRK == null) {
            this.bRK = new HandlerC0324a();
        }
        if (this.bRL == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.bRL = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.bRK.removeMessages(100);
        this.bRK.sendEmptyMessage(100);
    }

    public void eD(int i) {
        if (i >= 1000) {
            this.bRJ = i;
        }
    }

    public String Wx() {
        if (this.mData != null) {
            b.Wy().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.d("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.bRL);
        this.bRL = null;
        return com.baidu.swan.apps.storage.b.bV(getFilePath(), e.aoH());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class HandlerC0324a extends Handler {
        private HandlerC0324a() {
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
                a.this.iS(jSONObject.toString());
                com.baidu.swan.apps.console.c.d("PropertyLogcat", jSONObject.toString());
                if (a.this.bRK != null) {
                    a.this.bRK.sendEmptyMessageDelayed(100, a.this.bRJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(String str) {
        if (this.bRL != null) {
            try {
                this.bRL.write(str);
                this.bRL.write(10);
                com.baidu.swan.apps.console.c.d("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.K(e.aoH(), this.act, TbConfig.TMP_LOG_DIR_NAME);
    }
}
