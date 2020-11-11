package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.p;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cFR = com.baidu.swan.apps.am.e.dCM.id;
    public static final String cFS = com.baidu.swan.apps.am.e.dCK.id;
    public static final String cFT = com.baidu.swan.apps.am.e.dCL.id;
    public static final String cFU = com.baidu.swan.apps.am.e.dCP.id;
    public static final String cFV = com.baidu.swan.apps.am.e.dCR.id;
    public static final String cFW = com.baidu.swan.apps.am.e.dCN.id;
    public static final String cFX = com.baidu.swan.apps.am.e.dCO.id;
    public static final String cFY = com.baidu.swan.apps.am.e.dCQ.id;
    public static final String cFZ = com.baidu.swan.apps.am.e.dCS.id;
    public static final String cGa = com.baidu.swan.apps.am.e.dCT.id;
    private int cFN;
    private d cGb;
    private e cGc;
    private Choreographer$FrameCallbackC0412b cGd;
    private a cGe;
    private ConcurrentMap<String, Object> cGf;
    private boolean cGg;
    private int cGh;

    /* loaded from: classes10.dex */
    private static class c {
        public static final b cGm = new b();
    }

    private b() {
        this.cGf = new ConcurrentHashMap();
        this.cFN = 1000;
    }

    public static b amf() {
        return c.cGm;
    }

    public Map<String, Object> amg() {
        this.cGh++;
        amh();
        return this.cGf;
    }

    public void recycle() {
        int i = this.cGh - 1;
        this.cGh = i;
        if (i <= 0) {
            ami();
        }
    }

    private void amh() {
        if (this.cGg) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cGg = true;
        this.cGd = new Choreographer$FrameCallbackC0412b();
        Choreographer.getInstance().postFrameCallback(this.cGd);
        this.cGe = new a();
        this.cGc = new e();
        com.baidu.swan.apps.am.e.aLT().a(this.cGc, com.baidu.swan.apps.am.e.dCM, com.baidu.swan.apps.am.e.dCK, com.baidu.swan.apps.am.e.dCL, com.baidu.swan.apps.am.e.dCR, com.baidu.swan.apps.am.e.dCN, com.baidu.swan.apps.am.e.dCO, com.baidu.swan.apps.am.e.dCP, com.baidu.swan.apps.am.e.dCQ, com.baidu.swan.apps.am.e.dCS, com.baidu.swan.apps.am.e.dCT);
        this.cGb = new d();
        this.cGb.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void ami() {
        if (!this.cGg) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cGg = false;
        if (this.cGb != null) {
            this.cGb.removeMessages(0);
            this.cGb = null;
        }
        if (this.cGc != null) {
            com.baidu.swan.apps.am.e.aLT().b(this.cGc, new com.baidu.swan.apps.am.c[0]);
            this.cGc = null;
        }
        this.cGd = null;
        this.cGe = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cGf != null) {
                b.this.amj();
                b.this.cGf.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.awA().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cGb != null) {
                    b.this.cGb.sendEmptyMessageDelayed(0, b.this.cFN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amj() {
        if (!this.cGe.cGi) {
            p.postOnIO(this.cGe, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private boolean cGi;
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
            this.cGi = true;
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
                        b.this.cGf.put(com.baidu.fsg.face.base.b.c.i, a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cGi = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cGi = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cGi = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cGi = false;
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
    /* loaded from: classes10.dex */
    public class Choreographer$FrameCallbackC0412b implements Choreographer.FrameCallback {
        long cGk;
        int cGl;

        private Choreographer$FrameCallbackC0412b() {
            this.cGk = -1L;
            this.cGl = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cGg) {
                if (this.cGk > 0 && this.cGl != (i = (int) ((1.0d / (j - this.cGk)) * 1.0E9d))) {
                    this.cGl = i;
                    b.this.cGf.put("frame", Integer.valueOf(i));
                }
                this.cGk = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: c */
        public void M(Set<com.baidu.swan.apps.am.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.am.c<?> cVar : set) {
                    b.this.cGf.put(cVar.id, cVar.aLS());
                }
            }
        }
    }
}
