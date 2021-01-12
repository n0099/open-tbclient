package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cLk = com.baidu.swan.apps.al.e.dLW.id;
    public static final String cLl = com.baidu.swan.apps.al.e.dLU.id;
    public static final String cLm = com.baidu.swan.apps.al.e.dLV.id;
    public static final String cLn = com.baidu.swan.apps.al.e.dLZ.id;
    public static final String cLo = com.baidu.swan.apps.al.e.dMb.id;
    public static final String cLp = com.baidu.swan.apps.al.e.dLX.id;
    public static final String cLq = com.baidu.swan.apps.al.e.dLY.id;
    public static final String cLr = com.baidu.swan.apps.al.e.dMa.id;
    public static final String cLs = com.baidu.swan.apps.al.e.dMc.id;
    public static final String cLt = com.baidu.swan.apps.al.e.dMd.id;
    private int cLA;
    private int cLg;
    private d cLu;
    private e cLv;
    private Choreographer$FrameCallbackC0397b cLw;
    private a cLx;
    private ConcurrentMap<String, Object> cLy;
    private boolean cLz;

    /* loaded from: classes8.dex */
    private static class c {
        public static final b cLF = new b();
    }

    private b() {
        this.cLy = new ConcurrentHashMap();
        this.cLg = 1000;
    }

    public static b alY() {
        return c.cLF;
    }

    public Map<String, Object> alZ() {
        this.cLA++;
        ama();
        return this.cLy;
    }

    public void recycle() {
        int i = this.cLA - 1;
        this.cLA = i;
        if (i <= 0) {
            amb();
        }
    }

    private void ama() {
        if (this.cLz) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cLz = true;
        this.cLw = new Choreographer$FrameCallbackC0397b();
        Choreographer.getInstance().postFrameCallback(this.cLw);
        this.cLx = new a();
        this.cLv = new e();
        com.baidu.swan.apps.al.e.aMQ().a(this.cLv, com.baidu.swan.apps.al.e.dLW, com.baidu.swan.apps.al.e.dLU, com.baidu.swan.apps.al.e.dLV, com.baidu.swan.apps.al.e.dMb, com.baidu.swan.apps.al.e.dLX, com.baidu.swan.apps.al.e.dLY, com.baidu.swan.apps.al.e.dLZ, com.baidu.swan.apps.al.e.dMa, com.baidu.swan.apps.al.e.dMc, com.baidu.swan.apps.al.e.dMd);
        this.cLu = new d();
        this.cLu.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void amb() {
        if (!this.cLz) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cLz = false;
        if (this.cLu != null) {
            this.cLu.removeMessages(0);
            this.cLu = null;
        }
        if (this.cLv != null) {
            com.baidu.swan.apps.al.e.aMQ().b(this.cLv, new com.baidu.swan.apps.al.c[0]);
            this.cLv = null;
        }
        this.cLw = null;
        this.cLx = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cLy != null) {
                b.this.amc();
                b.this.cLy.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.awy().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cLu != null) {
                    b.this.cLu.sendEmptyMessageDelayed(0, b.this.cLg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amc() {
        if (!this.cLx.cLB) {
            p.a(this.cLx, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private boolean cLB;
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
            this.cLB = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IXAdRequestInfo.SCREEN_HEIGHT, "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a2 = a(bufferedReader);
                        b.this.cLy.put("cpu", a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cLB = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cLB = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cLB = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cLB = false;
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
    /* loaded from: classes8.dex */
    public class Choreographer$FrameCallbackC0397b implements Choreographer.FrameCallback {
        long cLD;
        int cLE;

        private Choreographer$FrameCallbackC0397b() {
            this.cLD = -1L;
            this.cLE = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cLz) {
                if (this.cLD > 0 && this.cLE != (i = (int) ((1.0d / (j - this.cLD)) * 1.0E9d))) {
                    this.cLE = i;
                    b.this.cLy.put("frame", Integer.valueOf(i));
                }
                this.cLD = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: c */
        public void L(Set<com.baidu.swan.apps.al.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.al.c<?> cVar : set) {
                    b.this.cLy.put(cVar.id, cVar.aMP());
                }
            }
        }
    }
}
