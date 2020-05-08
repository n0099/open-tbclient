package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.as.m;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bIW = com.baidu.swan.apps.ap.e.cwW.id;
    public static final String bIX = com.baidu.swan.apps.ap.e.cwU.id;
    public static final String bIY = com.baidu.swan.apps.ap.e.cwV.id;
    public static final String bIZ = com.baidu.swan.apps.ap.e.cwZ.id;
    public static final String bJa = com.baidu.swan.apps.ap.e.cwX.id;
    public static final String bJb = com.baidu.swan.apps.ap.e.cwY.id;
    public static final String bJc = com.baidu.swan.apps.ap.e.cxa.id;
    private int bIS;
    private d bJd;
    private e bJe;
    private Choreographer$FrameCallbackC0288b bJf;
    private a bJg;
    private ConcurrentMap<String, Object> bJh;
    private boolean bJi;
    private int bJj;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b bJo = new b();
    }

    private b() {
        this.bJh = new ConcurrentHashMap();
        this.bIS = 1000;
    }

    public static b TR() {
        return c.bJo;
    }

    public Map<String, Object> TS() {
        this.bJj++;
        TT();
        return this.bJh;
    }

    public void recycle() {
        int i = this.bJj - 1;
        this.bJj = i;
        if (i <= 0) {
            TU();
        }
    }

    private void TT() {
        if (this.bJi) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bJi = true;
        this.bJf = new Choreographer$FrameCallbackC0288b();
        Choreographer.getInstance().postFrameCallback(this.bJf);
        this.bJg = new a();
        this.bJe = new e();
        com.baidu.swan.apps.ap.e.aov().a(this.bJe, com.baidu.swan.apps.ap.e.cwW, com.baidu.swan.apps.ap.e.cwU, com.baidu.swan.apps.ap.e.cwV, com.baidu.swan.apps.ap.e.cwX, com.baidu.swan.apps.ap.e.cwY, com.baidu.swan.apps.ap.e.cwZ, com.baidu.swan.apps.ap.e.cxa);
        this.bJd = new d();
        this.bJd.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void TU() {
        if (!this.bJi) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bJi = false;
        if (this.bJd != null) {
            this.bJd.removeMessages(0);
            this.bJd = null;
        }
        if (this.bJe != null) {
            com.baidu.swan.apps.ap.e.aov().b(this.bJe, new com.baidu.swan.apps.ap.c[0]);
            this.bJe = null;
        }
        this.bJf = null;
        this.bJg = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.bJh != null) {
                b.this.TV();
                b.this.bJh.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.abN().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bJd != null) {
                    b.this.bJd.sendEmptyMessageDelayed(0, b.this.bIS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TV() {
        if (!this.bJg.bJk) {
            m.postOnIO(this.bJg, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bJk;
        private final String name;

        private a() {
            this.name = "swanAppCpuMonitor";
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a9 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.bJk = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IXAdRequestInfo.SCREEN_HEIGHT, "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a = a(bufferedReader);
                        b.this.bJh.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bJk = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bJk = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bJk = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bJk = false;
                throw th;
            }
        }

        private String a(BufferedReader bufferedReader) throws IOException {
            char read;
            int i = 0;
            char[] cArr = new char[4];
            if (Build.VERSION.SDK_INT >= 26) {
                int i2 = 0;
                boolean z = true;
                int i3 = 0;
                do {
                    char read2 = (char) bufferedReader.read();
                    if (z && read2 != ' ') {
                        i2++;
                    }
                    if (i2 == 9) {
                        if (read2 == '.' || read2 == ' ') {
                            break;
                        }
                        cArr[i3] = read2;
                        i3++;
                    }
                    z = read2 == ' ';
                    if (i2 > 9 || read2 == 65535) {
                        break;
                    }
                } while (i3 < cArr.length);
                try {
                    i = Integer.parseInt(String.valueOf(cArr, 0, i3)) / Runtime.getRuntime().availableProcessors();
                } catch (NumberFormatException e) {
                    if (b.DEBUG) {
                        Log.e("PropertyMonitor", "get CPU Fail : " + e.getMessage());
                    }
                }
                return i + "%";
            }
            int i4 = 0;
            do {
                read = (char) bufferedReader.read();
                if (read == ' ' || i4 == 4) {
                    i4 = 0;
                } else {
                    cArr[i4] = read;
                    i4++;
                }
                if (read == '%') {
                    break;
                }
            } while (read != 65535);
            return String.valueOf(cArr, 0, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.property.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class Choreographer$FrameCallbackC0288b implements Choreographer.FrameCallback {
        long bJm;
        int bJn;

        private Choreographer$FrameCallbackC0288b() {
            this.bJm = -1L;
            this.bJn = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bJi) {
                if (this.bJm > 0 && this.bJn != (i = (int) ((1.0d / (j - this.bJm)) * 1.0E9d))) {
                    this.bJn = i;
                    b.this.bJh.put("frame", Integer.valueOf(i));
                }
                this.bJm = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: c */
        public void F(Set<com.baidu.swan.apps.ap.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ap.c<?> cVar : set) {
                    b.this.bJh.put(cVar.id, cVar.aou());
                }
            }
        }
    }
}
