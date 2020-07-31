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
import com.baidu.swan.apps.aq.p;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes7.dex */
public class b {
    private d bXC;
    private e bXD;
    private Choreographer$FrameCallbackC0333b bXE;
    private a bXF;
    private ConcurrentMap<String, Object> bXG;
    private boolean bXH;
    private int bXI;
    private int bXo;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bXs = com.baidu.swan.apps.an.e.cRe.id;
    public static final String bXt = com.baidu.swan.apps.an.e.cRc.id;
    public static final String bXu = com.baidu.swan.apps.an.e.cRd.id;
    public static final String bXv = com.baidu.swan.apps.an.e.cRh.id;
    public static final String bXw = com.baidu.swan.apps.an.e.cRj.id;
    public static final String bXx = com.baidu.swan.apps.an.e.cRf.id;
    public static final String bXy = com.baidu.swan.apps.an.e.cRg.id;
    public static final String bXz = com.baidu.swan.apps.an.e.cRi.id;
    public static final String bXA = com.baidu.swan.apps.an.e.cRk.id;
    public static final String bXB = com.baidu.swan.apps.an.e.cRl.id;

    /* loaded from: classes7.dex */
    private static class c {
        public static final b bXN = new b();
    }

    private b() {
        this.bXG = new ConcurrentHashMap();
        this.bXo = 1000;
    }

    public static b Yk() {
        return c.bXN;
    }

    public Map<String, Object> Yl() {
        this.bXI++;
        Ym();
        return this.bXG;
    }

    public void recycle() {
        int i = this.bXI - 1;
        this.bXI = i;
        if (i <= 0) {
            Yn();
        }
    }

    private void Ym() {
        if (this.bXH) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bXH = true;
        this.bXE = new Choreographer$FrameCallbackC0333b();
        Choreographer.getInstance().postFrameCallback(this.bXE);
        this.bXF = new a();
        this.bXD = new e();
        com.baidu.swan.apps.an.e.avX().a(this.bXD, com.baidu.swan.apps.an.e.cRe, com.baidu.swan.apps.an.e.cRc, com.baidu.swan.apps.an.e.cRd, com.baidu.swan.apps.an.e.cRj, com.baidu.swan.apps.an.e.cRf, com.baidu.swan.apps.an.e.cRg, com.baidu.swan.apps.an.e.cRh, com.baidu.swan.apps.an.e.cRi, com.baidu.swan.apps.an.e.cRk, com.baidu.swan.apps.an.e.cRl);
        this.bXC = new d();
        this.bXC.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Yn() {
        if (!this.bXH) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bXH = false;
        if (this.bXC != null) {
            this.bXC.removeMessages(0);
            this.bXC = null;
        }
        if (this.bXD != null) {
            com.baidu.swan.apps.an.e.avX().b(this.bXD, new com.baidu.swan.apps.an.c[0]);
            this.bXD = null;
        }
        this.bXE = null;
        this.bXF = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.bXG != null) {
                b.this.Yo();
                b.this.bXG.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.ahj().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bXC != null) {
                    b.this.bXC.sendEmptyMessageDelayed(0, b.this.bXo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yo() {
        if (!this.bXF.bXJ) {
            p.postOnIO(this.bXF, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private boolean bXJ;
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
            this.bXJ = true;
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
                        b.this.bXG.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.d.closeSafely(bufferedReader);
                        this.bXJ = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.d.closeSafely(bufferedReader);
                        this.bXJ = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.d.closeSafely(append);
                    this.bXJ = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.d.closeSafely(append);
                this.bXJ = false;
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
    /* loaded from: classes7.dex */
    public class Choreographer$FrameCallbackC0333b implements Choreographer.FrameCallback {
        long bXL;
        int bXM;

        private Choreographer$FrameCallbackC0333b() {
            this.bXL = -1L;
            this.bXM = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bXH) {
                if (this.bXL > 0 && this.bXM != (i = (int) ((1.0d / (j - this.bXL)) * 1.0E9d))) {
                    this.bXM = i;
                    b.this.bXG.put("frame", Integer.valueOf(i));
                }
                this.bXL = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: c */
        public void H(Set<com.baidu.swan.apps.an.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.an.c<?> cVar : set) {
                    b.this.bXG.put(cVar.id, cVar.avW());
                }
            }
        }
    }
}
