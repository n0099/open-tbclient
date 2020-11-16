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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cEh = com.baidu.swan.apps.am.e.dBf.id;
    public static final String cEi = com.baidu.swan.apps.am.e.dBd.id;
    public static final String cEj = com.baidu.swan.apps.am.e.dBe.id;
    public static final String cEk = com.baidu.swan.apps.am.e.dBi.id;
    public static final String cEl = com.baidu.swan.apps.am.e.dBk.id;
    public static final String cEm = com.baidu.swan.apps.am.e.dBg.id;
    public static final String cEn = com.baidu.swan.apps.am.e.dBh.id;
    public static final String cEo = com.baidu.swan.apps.am.e.dBj.id;
    public static final String cEp = com.baidu.swan.apps.am.e.dBl.id;
    public static final String cEq = com.baidu.swan.apps.am.e.dBm.id;
    private int cEd;
    private d cEr;
    private e cEs;
    private Choreographer$FrameCallbackC0410b cEt;
    private a cEu;
    private ConcurrentMap<String, Object> cEv;
    private boolean cEw;
    private int cEx;

    /* loaded from: classes7.dex */
    private static class c {
        public static final b cEC = new b();
    }

    private b() {
        this.cEv = new ConcurrentHashMap();
        this.cEd = 1000;
    }

    public static b alx() {
        return c.cEC;
    }

    public Map<String, Object> aly() {
        this.cEx++;
        alz();
        return this.cEv;
    }

    public void recycle() {
        int i = this.cEx - 1;
        this.cEx = i;
        if (i <= 0) {
            alA();
        }
    }

    private void alz() {
        if (this.cEw) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cEw = true;
        this.cEt = new Choreographer$FrameCallbackC0410b();
        Choreographer.getInstance().postFrameCallback(this.cEt);
        this.cEu = new a();
        this.cEs = new e();
        com.baidu.swan.apps.am.e.aLl().a(this.cEs, com.baidu.swan.apps.am.e.dBf, com.baidu.swan.apps.am.e.dBd, com.baidu.swan.apps.am.e.dBe, com.baidu.swan.apps.am.e.dBk, com.baidu.swan.apps.am.e.dBg, com.baidu.swan.apps.am.e.dBh, com.baidu.swan.apps.am.e.dBi, com.baidu.swan.apps.am.e.dBj, com.baidu.swan.apps.am.e.dBl, com.baidu.swan.apps.am.e.dBm);
        this.cEr = new d();
        this.cEr.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void alA() {
        if (!this.cEw) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cEw = false;
        if (this.cEr != null) {
            this.cEr.removeMessages(0);
            this.cEr = null;
        }
        if (this.cEs != null) {
            com.baidu.swan.apps.am.e.aLl().b(this.cEs, new com.baidu.swan.apps.am.c[0]);
            this.cEs = null;
        }
        this.cEt = null;
        this.cEu = null;
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
            if (b.this.cEv != null) {
                b.this.alB();
                b.this.cEv.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.avS().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cEr != null) {
                    b.this.cEr.sendEmptyMessageDelayed(0, b.this.cEd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alB() {
        if (!this.cEu.cEy) {
            p.postOnIO(this.cEu, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private boolean cEy;
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
            this.cEy = true;
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
                        b.this.cEv.put(com.baidu.fsg.face.base.b.c.i, a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cEy = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cEy = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cEy = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cEy = false;
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
    public class Choreographer$FrameCallbackC0410b implements Choreographer.FrameCallback {
        long cEA;
        int cEB;

        private Choreographer$FrameCallbackC0410b() {
            this.cEA = -1L;
            this.cEB = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cEw) {
                if (this.cEA > 0 && this.cEB != (i = (int) ((1.0d / (j - this.cEA)) * 1.0E9d))) {
                    this.cEB = i;
                    b.this.cEv.put("frame", Integer.valueOf(i));
                }
                this.cEA = j;
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
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: c */
        public void M(Set<com.baidu.swan.apps.am.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.am.c<?> cVar : set) {
                    b.this.cEv.put(cVar.id, cVar.aLk());
                }
            }
        }
    }
}
