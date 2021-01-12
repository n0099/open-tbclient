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
    private final String afT = "performance_" + System.currentTimeMillis();
    private int cLg = 3000;
    private HandlerC0396a cLh;
    private BufferedWriter cLi;
    private Map<String, Object> mData;

    public void startMonitor() {
        if (this.mData == null) {
            this.mData = b.alY().alZ();
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Start monitor logcat");
        }
        if (this.cLh == null) {
            this.cLh = new HandlerC0396a();
        }
        if (this.cLi == null) {
            File file = new File(getFilePath());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.cLi = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Create log file fail", e);
            }
        }
        this.cLh.removeMessages(100);
        this.cLh.sendEmptyMessage(100);
    }

    public void gx(int i) {
        if (i >= 1000) {
            this.cLg = i;
        }
    }

    public String alX() {
        if (this.mData != null) {
            b.alY().recycle();
            this.mData = null;
            com.baidu.swan.apps.console.c.i("PropertyLogcat", "Stop monitor logcat");
        }
        d.closeSafely(this.cLi);
        this.cLi = null;
        return com.baidu.swan.apps.storage.b.cF(getFilePath(), e.aIt());
    }

    /* renamed from: com.baidu.swan.apps.console.property.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class HandlerC0396a extends Handler {
        private HandlerC0396a() {
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
                a.this.lH(jSONObject.toString());
                com.baidu.swan.apps.console.c.i("PropertyLogcat", jSONObject.toString());
                if (a.this.cLh != null) {
                    a.this.cLh.sendEmptyMessageDelayed(100, a.this.cLg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(String str) {
        if (this.cLi != null) {
            try {
                this.cLi.write(str);
                this.cLi.write(10);
                com.baidu.swan.apps.console.c.i("PropertyLogcat", "Export logcat success");
            } catch (IOException e) {
                com.baidu.swan.apps.console.c.e("PropertyLogcat", "Logcat write fail", e);
            }
        }
    }

    private String getFilePath() {
        return com.baidu.swan.apps.storage.b.ab(e.aIt(), this.afT, TbConfig.TMP_LOG_DIR_NAME);
    }
}
