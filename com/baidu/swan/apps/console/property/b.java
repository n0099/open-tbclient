package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.p;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes9.dex */
public class b {
    private d cNI;
    private e cNJ;
    private Choreographer$FrameCallbackC0394b cNK;
    private a cNL;
    private ConcurrentMap<String, Object> cNM;
    private boolean cNN;
    private int cNO;
    private int cNu;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cNy = com.baidu.swan.apps.al.e.dOa.id;
    public static final String cNz = com.baidu.swan.apps.al.e.dNY.id;
    public static final String cNA = com.baidu.swan.apps.al.e.dNZ.id;
    public static final String cNB = com.baidu.swan.apps.al.e.dOd.id;
    public static final String cNC = com.baidu.swan.apps.al.e.dOf.id;
    public static final String cND = com.baidu.swan.apps.al.e.dOb.id;
    public static final String cNE = com.baidu.swan.apps.al.e.dOc.id;
    public static final String cNF = com.baidu.swan.apps.al.e.dOe.id;
    public static final String cNG = com.baidu.swan.apps.al.e.dOg.id;
    public static final String cNH = com.baidu.swan.apps.al.e.dOh.id;

    /* loaded from: classes9.dex */
    private static class c {
        public static final b cNT = new b();
    }

    private b() {
        this.cNM = new ConcurrentHashMap();
        this.cNu = 1000;
    }

    public static b amw() {
        return c.cNT;
    }

    public Map<String, Object> amx() {
        this.cNO++;
        amy();
        return this.cNM;
    }

    public void recycle() {
        int i = this.cNO - 1;
        this.cNO = i;
        if (i <= 0) {
            amz();
        }
    }

    private void amy() {
        if (this.cNN) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cNN = true;
        this.cNK = new Choreographer$FrameCallbackC0394b();
        Choreographer.getInstance().postFrameCallback(this.cNK);
        this.cNL = new a();
        this.cNJ = new e();
        com.baidu.swan.apps.al.e.aNj().a(this.cNJ, com.baidu.swan.apps.al.e.dOa, com.baidu.swan.apps.al.e.dNY, com.baidu.swan.apps.al.e.dNZ, com.baidu.swan.apps.al.e.dOf, com.baidu.swan.apps.al.e.dOb, com.baidu.swan.apps.al.e.dOc, com.baidu.swan.apps.al.e.dOd, com.baidu.swan.apps.al.e.dOe, com.baidu.swan.apps.al.e.dOg, com.baidu.swan.apps.al.e.dOh);
        this.cNI = new d();
        this.cNI.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void amz() {
        if (!this.cNN) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cNN = false;
        if (this.cNI != null) {
            this.cNI.removeMessages(0);
            this.cNI = null;
        }
        if (this.cNJ != null) {
            com.baidu.swan.apps.al.e.aNj().b(this.cNJ, new com.baidu.swan.apps.al.c[0]);
            this.cNJ = null;
        }
        this.cNK = null;
        this.cNL = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cNM != null) {
                b.this.amA();
                b.this.cNM.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.awW().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cNI != null) {
                    b.this.cNI.sendEmptyMessageDelayed(0, b.this.cNu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amA() {
        if (!this.cNL.cNP) {
            p.a(this.cNL, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private boolean cNP;
        private final String name;

        private a() {
            this.name = "swanAppCpuMonitor";
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a9 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.cNP = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a2 = a(bufferedReader);
                        b.this.cNM.put("cpu", a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cNP = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cNP = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cNP = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cNP = false;
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
    /* loaded from: classes9.dex */
    public class Choreographer$FrameCallbackC0394b implements Choreographer.FrameCallback {
        long cNR;
        int cNS;

        private Choreographer$FrameCallbackC0394b() {
            this.cNR = -1L;
            this.cNS = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cNN) {
                if (this.cNR > 0 && this.cNS != (i = (int) ((1.0d / (j - this.cNR)) * 1.0E9d))) {
                    this.cNS = i;
                    b.this.cNM.put("frame", Integer.valueOf(i));
                }
                this.cNR = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: c */
        public void L(Set<com.baidu.swan.apps.al.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.al.c<?> cVar : set) {
                    b.this.cNM.put(cVar.id, cVar.aNi());
                }
            }
        }
    }
}
