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
    private d crI;
    private e crJ;
    private Choreographer$FrameCallbackC0386b crK;
    private a crL;
    private ConcurrentMap<String, Object> crM;
    private boolean crN;
    private int crO;
    private int cru;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cry = com.baidu.swan.apps.am.e.dou.id;
    public static final String crz = com.baidu.swan.apps.am.e.dos.id;
    public static final String crA = com.baidu.swan.apps.am.e.dot.id;
    public static final String crB = com.baidu.swan.apps.am.e.dox.id;
    public static final String crC = com.baidu.swan.apps.am.e.doz.id;
    public static final String crD = com.baidu.swan.apps.am.e.dov.id;
    public static final String crE = com.baidu.swan.apps.am.e.dow.id;
    public static final String crF = com.baidu.swan.apps.am.e.doy.id;
    public static final String crG = com.baidu.swan.apps.am.e.doA.id;
    public static final String crH = com.baidu.swan.apps.am.e.doB.id;

    /* loaded from: classes10.dex */
    private static class c {
        public static final b crT = new b();
    }

    private b() {
        this.crM = new ConcurrentHashMap();
        this.cru = 1000;
    }

    public static b ahL() {
        return c.crT;
    }

    public Map<String, Object> ahM() {
        this.crO++;
        ahN();
        return this.crM;
    }

    public void recycle() {
        int i = this.crO - 1;
        this.crO = i;
        if (i <= 0) {
            ahO();
        }
    }

    private void ahN() {
        if (this.crN) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.crN = true;
        this.crK = new Choreographer$FrameCallbackC0386b();
        Choreographer.getInstance().postFrameCallback(this.crK);
        this.crL = new a();
        this.crJ = new e();
        com.baidu.swan.apps.am.e.aHz().a(this.crJ, com.baidu.swan.apps.am.e.dou, com.baidu.swan.apps.am.e.dos, com.baidu.swan.apps.am.e.dot, com.baidu.swan.apps.am.e.doz, com.baidu.swan.apps.am.e.dov, com.baidu.swan.apps.am.e.dow, com.baidu.swan.apps.am.e.dox, com.baidu.swan.apps.am.e.doy, com.baidu.swan.apps.am.e.doA, com.baidu.swan.apps.am.e.doB);
        this.crI = new d();
        this.crI.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void ahO() {
        if (!this.crN) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.crN = false;
        if (this.crI != null) {
            this.crI.removeMessages(0);
            this.crI = null;
        }
        if (this.crJ != null) {
            com.baidu.swan.apps.am.e.aHz().b(this.crJ, new com.baidu.swan.apps.am.c[0]);
            this.crJ = null;
        }
        this.crK = null;
        this.crL = null;
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
            if (b.this.crM != null) {
                b.this.ahP();
                b.this.crM.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.asf().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.crI != null) {
                    b.this.crI.sendEmptyMessageDelayed(0, b.this.cru);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahP() {
        if (!this.crL.crP) {
            p.postOnIO(this.crL, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private boolean crP;
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
            this.crP = true;
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
                        b.this.crM.put(com.baidu.fsg.face.base.b.c.i, a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.crP = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.crP = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.crP = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.crP = false;
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
    public class Choreographer$FrameCallbackC0386b implements Choreographer.FrameCallback {
        long crR;
        int crS;

        private Choreographer$FrameCallbackC0386b() {
            this.crR = -1L;
            this.crS = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.crN) {
                if (this.crR > 0 && this.crS != (i = (int) ((1.0d / (j - this.crR)) * 1.0E9d))) {
                    this.crS = i;
                    b.this.crM.put("frame", Integer.valueOf(i));
                }
                this.crR = j;
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
                    b.this.crM.put(cVar.id, cVar.aHy());
                }
            }
        }
    }
}
