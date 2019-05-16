package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String ans = com.baidu.swan.apps.ak.e.aYP.id;
    public static final String ant = com.baidu.swan.apps.ak.e.aYN.id;
    public static final String anu = com.baidu.swan.apps.ak.e.aYO.id;
    public static final String anv = com.baidu.swan.apps.ak.e.aYS.id;
    public static final String anw = com.baidu.swan.apps.ak.e.aYQ.id;
    public static final String anx = com.baidu.swan.apps.ak.e.aYR.id;
    public static final String any = com.baidu.swan.apps.ak.e.aYT.id;
    private e anA;
    private Choreographer$FrameCallbackC0128b anB;
    private a anC;
    private ConcurrentMap<String, Object> anD;
    private boolean anE;
    private int anF;
    private int ano;
    private d anz;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b anK = new b();
    }

    private b() {
        this.anD = new ConcurrentHashMap();
        this.ano = 1000;
    }

    public static b xK() {
        return c.anK;
    }

    public Map<String, Object> xL() {
        this.anF++;
        xM();
        return this.anD;
    }

    public void recycle() {
        int i = this.anF - 1;
        this.anF = i;
        if (i <= 0) {
            xN();
        }
    }

    private void xM() {
        if (this.anE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.anE = true;
        this.anB = new Choreographer$FrameCallbackC0128b();
        Choreographer.getInstance().postFrameCallback(this.anB);
        this.anC = new a();
        this.anA = new e();
        com.baidu.swan.apps.ak.e.Ok().a(this.anA, com.baidu.swan.apps.ak.e.aYP, com.baidu.swan.apps.ak.e.aYN, com.baidu.swan.apps.ak.e.aYO, com.baidu.swan.apps.ak.e.aYQ, com.baidu.swan.apps.ak.e.aYR, com.baidu.swan.apps.ak.e.aYS, com.baidu.swan.apps.ak.e.aYT);
        this.anz = new d();
        this.anz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void xN() {
        if (!this.anE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.anE = false;
        if (this.anz != null) {
            this.anz.removeMessages(0);
            this.anz = null;
        }
        if (this.anA != null) {
            com.baidu.swan.apps.ak.e.Ok().b(this.anA, new com.baidu.swan.apps.ak.c[0]);
            this.anA = null;
        }
        this.anB = null;
        this.anC = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.anD != null) {
                b.this.xO();
                b.this.anD.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.DB().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.anz != null) {
                    b.this.anz.sendEmptyMessageDelayed(0, b.this.ano);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO() {
        if (!this.anC.anG) {
            j.a(this.anC, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean anG;
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
            this.anG = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a = a(bufferedReader);
                        b.this.anD.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.anG = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.anG = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(append);
                    this.anG = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.a.c(append);
                this.anG = false;
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
    /* loaded from: classes2.dex */
    public class Choreographer$FrameCallbackC0128b implements Choreographer.FrameCallback {
        long anI;
        int anJ;

        private Choreographer$FrameCallbackC0128b() {
            this.anI = -1L;
            this.anJ = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.anE) {
                if (this.anI > 0 && this.anJ != (i = (int) ((1.0d / (j - this.anI)) * 1.0E9d))) {
                    this.anJ = i;
                    b.this.anD.put("frame", Integer.valueOf(i));
                }
                this.anI = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: b */
        public void D(Set<com.baidu.swan.apps.ak.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ak.c<?> cVar : set) {
                    b.this.anD.put(cVar.id, cVar.Oj());
                }
            }
        }
    }
}
