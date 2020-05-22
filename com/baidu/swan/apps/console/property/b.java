package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.aq.n;
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
    public static final String bRN = com.baidu.swan.apps.an.e.cIZ.id;
    public static final String bRO = com.baidu.swan.apps.an.e.cIX.id;
    public static final String bRP = com.baidu.swan.apps.an.e.cIY.id;
    public static final String bRQ = com.baidu.swan.apps.an.e.cJc.id;
    public static final String bRR = com.baidu.swan.apps.an.e.cJe.id;
    public static final String bRS = com.baidu.swan.apps.an.e.cJa.id;
    public static final String bRT = com.baidu.swan.apps.an.e.cJb.id;
    public static final String bRU = com.baidu.swan.apps.an.e.cJd.id;
    public static final String bRV = com.baidu.swan.apps.an.e.cJf.id;
    private int bRJ;
    private d bRW;
    private e bRX;
    private Choreographer$FrameCallbackC0325b bRY;
    private a bRZ;
    private ConcurrentMap<String, Object> bSa;
    private boolean bSb;
    private int bSc;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b bSh = new b();
    }

    private b() {
        this.bSa = new ConcurrentHashMap();
        this.bRJ = 1000;
    }

    public static b Wy() {
        return c.bSh;
    }

    public Map<String, Object> Wz() {
        this.bSc++;
        WA();
        return this.bSa;
    }

    public void recycle() {
        int i = this.bSc - 1;
        this.bSc = i;
        if (i <= 0) {
            WB();
        }
    }

    private void WA() {
        if (this.bSb) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bSb = true;
        this.bRY = new Choreographer$FrameCallbackC0325b();
        Choreographer.getInstance().postFrameCallback(this.bRY);
        this.bRZ = new a();
        this.bRX = new e();
        com.baidu.swan.apps.an.e.asQ().a(this.bRX, com.baidu.swan.apps.an.e.cIZ, com.baidu.swan.apps.an.e.cIX, com.baidu.swan.apps.an.e.cIY, com.baidu.swan.apps.an.e.cJe, com.baidu.swan.apps.an.e.cJa, com.baidu.swan.apps.an.e.cJb, com.baidu.swan.apps.an.e.cJc, com.baidu.swan.apps.an.e.cJd, com.baidu.swan.apps.an.e.cJf);
        this.bRW = new d();
        this.bRW.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void WB() {
        if (!this.bSb) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bSb = false;
        if (this.bRW != null) {
            this.bRW.removeMessages(0);
            this.bRW = null;
        }
        if (this.bRX != null) {
            com.baidu.swan.apps.an.e.asQ().b(this.bRX, new com.baidu.swan.apps.an.c[0]);
            this.bRX = null;
        }
        this.bRY = null;
        this.bRZ = null;
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
            if (b.this.bSa != null) {
                b.this.WC();
                b.this.bSa.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.aeR().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bRW != null) {
                    b.this.bRW.sendEmptyMessageDelayed(0, b.this.bRJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        if (!this.bRZ.bSd) {
            n.postOnIO(this.bRZ, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bSd;
        private final String name;

        private a() {
            this.name = "swanAppCpuMonitor";
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [266=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a9 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.bSd = true;
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
                        b.this.bSa.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.e.d.closeSafely(bufferedReader);
                        this.bSd = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.e.d.closeSafely(bufferedReader);
                        this.bSd = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.e.d.closeSafely(append);
                    this.bSd = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.e.d.closeSafely(append);
                this.bSd = false;
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
    public class Choreographer$FrameCallbackC0325b implements Choreographer.FrameCallback {
        long bSf;
        int bSg;

        private Choreographer$FrameCallbackC0325b() {
            this.bSf = -1L;
            this.bSg = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bSb) {
                if (this.bSf > 0 && this.bSg != (i = (int) ((1.0d / (j - this.bSf)) * 1.0E9d))) {
                    this.bSg = i;
                    b.this.bSa.put("frame", Integer.valueOf(i));
                }
                this.bSf = j;
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
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: c */
        public void H(Set<com.baidu.swan.apps.an.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.an.c<?> cVar : set) {
                    b.this.bSa.put(cVar.id, cVar.asP());
                }
            }
        }
    }
}
