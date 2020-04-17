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
    public static final String bIR = com.baidu.swan.apps.ap.e.cwQ.id;
    public static final String bIS = com.baidu.swan.apps.ap.e.cwO.id;
    public static final String bIT = com.baidu.swan.apps.ap.e.cwP.id;
    public static final String bIU = com.baidu.swan.apps.ap.e.cwT.id;
    public static final String bIV = com.baidu.swan.apps.ap.e.cwR.id;
    public static final String bIW = com.baidu.swan.apps.ap.e.cwS.id;
    public static final String bIX = com.baidu.swan.apps.ap.e.cwU.id;
    private int bIN;
    private d bIY;
    private e bIZ;
    private Choreographer$FrameCallbackC0267b bJa;
    private a bJb;
    private ConcurrentMap<String, Object> bJc;
    private boolean bJd;
    private int bJe;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b bJj = new b();
    }

    private b() {
        this.bJc = new ConcurrentHashMap();
        this.bIN = 1000;
    }

    public static b TS() {
        return c.bJj;
    }

    public Map<String, Object> TT() {
        this.bJe++;
        TU();
        return this.bJc;
    }

    public void recycle() {
        int i = this.bJe - 1;
        this.bJe = i;
        if (i <= 0) {
            TV();
        }
    }

    private void TU() {
        if (this.bJd) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bJd = true;
        this.bJa = new Choreographer$FrameCallbackC0267b();
        Choreographer.getInstance().postFrameCallback(this.bJa);
        this.bJb = new a();
        this.bIZ = new e();
        com.baidu.swan.apps.ap.e.aow().a(this.bIZ, com.baidu.swan.apps.ap.e.cwQ, com.baidu.swan.apps.ap.e.cwO, com.baidu.swan.apps.ap.e.cwP, com.baidu.swan.apps.ap.e.cwR, com.baidu.swan.apps.ap.e.cwS, com.baidu.swan.apps.ap.e.cwT, com.baidu.swan.apps.ap.e.cwU);
        this.bIY = new d();
        this.bIY.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void TV() {
        if (!this.bJd) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bJd = false;
        if (this.bIY != null) {
            this.bIY.removeMessages(0);
            this.bIY = null;
        }
        if (this.bIZ != null) {
            com.baidu.swan.apps.ap.e.aow().b(this.bIZ, new com.baidu.swan.apps.ap.c[0]);
            this.bIZ = null;
        }
        this.bJa = null;
        this.bJb = null;
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
            if (b.this.bJc != null) {
                b.this.TW();
                b.this.bJc.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.abO().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bIY != null) {
                    b.this.bIY.sendEmptyMessageDelayed(0, b.this.bIN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TW() {
        if (!this.bJb.bJf) {
            m.postOnIO(this.bJb, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bJf;
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
            this.bJf = true;
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
                        b.this.bJc.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bJf = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bJf = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bJf = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bJf = false;
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
    public class Choreographer$FrameCallbackC0267b implements Choreographer.FrameCallback {
        long bJh;
        int bJi;

        private Choreographer$FrameCallbackC0267b() {
            this.bJh = -1L;
            this.bJi = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bJd) {
                if (this.bJh > 0 && this.bJi != (i = (int) ((1.0d / (j - this.bJh)) * 1.0E9d))) {
                    this.bJi = i;
                    b.this.bJc.put("frame", Integer.valueOf(i));
                }
                this.bJh = j;
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
        public void E(Set<com.baidu.swan.apps.ap.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ap.c<?> cVar : set) {
                    b.this.bJc.put(cVar.id, cVar.aov());
                }
            }
        }
    }
}
