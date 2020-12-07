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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cLb = com.baidu.swan.apps.am.e.dId.id;
    public static final String cLc = com.baidu.swan.apps.am.e.dIb.id;
    public static final String cLd = com.baidu.swan.apps.am.e.dIc.id;
    public static final String cLe = com.baidu.swan.apps.am.e.dIg.id;
    public static final String cLf = com.baidu.swan.apps.am.e.dIi.id;
    public static final String cLg = com.baidu.swan.apps.am.e.dIe.id;
    public static final String cLh = com.baidu.swan.apps.am.e.dIf.id;
    public static final String cLi = com.baidu.swan.apps.am.e.dIh.id;
    public static final String cLj = com.baidu.swan.apps.am.e.dIj.id;
    public static final String cLk = com.baidu.swan.apps.am.e.dIk.id;
    private int cKX;
    private d cLl;
    private e cLm;
    private Choreographer$FrameCallbackC0422b cLn;
    private a cLo;
    private ConcurrentMap<String, Object> cLp;
    private boolean cLq;
    private int cLr;

    /* loaded from: classes25.dex */
    private static class c {
        public static final b cLw = new b();
    }

    private b() {
        this.cLp = new ConcurrentHashMap();
        this.cKX = 1000;
    }

    public static b aoF() {
        return c.cLw;
    }

    public Map<String, Object> aoG() {
        this.cLr++;
        aoH();
        return this.cLp;
    }

    public void recycle() {
        int i = this.cLr - 1;
        this.cLr = i;
        if (i <= 0) {
            aoI();
        }
    }

    private void aoH() {
        if (this.cLq) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cLq = true;
        this.cLn = new Choreographer$FrameCallbackC0422b();
        Choreographer.getInstance().postFrameCallback(this.cLn);
        this.cLo = new a();
        this.cLm = new e();
        com.baidu.swan.apps.am.e.aOs().a(this.cLm, com.baidu.swan.apps.am.e.dId, com.baidu.swan.apps.am.e.dIb, com.baidu.swan.apps.am.e.dIc, com.baidu.swan.apps.am.e.dIi, com.baidu.swan.apps.am.e.dIe, com.baidu.swan.apps.am.e.dIf, com.baidu.swan.apps.am.e.dIg, com.baidu.swan.apps.am.e.dIh, com.baidu.swan.apps.am.e.dIj, com.baidu.swan.apps.am.e.dIk);
        this.cLl = new d();
        this.cLl.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void aoI() {
        if (!this.cLq) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cLq = false;
        if (this.cLl != null) {
            this.cLl.removeMessages(0);
            this.cLl = null;
        }
        if (this.cLm != null) {
            com.baidu.swan.apps.am.e.aOs().b(this.cLm, new com.baidu.swan.apps.am.c[0]);
            this.cLm = null;
        }
        this.cLn = null;
        this.cLo = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cLp != null) {
                b.this.aoJ();
                b.this.cLp.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.aza().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cLl != null) {
                    b.this.cLl.sendEmptyMessageDelayed(0, b.this.cKX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoJ() {
        if (!this.cLo.cLs) {
            p.postOnIO(this.cLo, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements Runnable {
        private boolean cLs;
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
            this.cLs = true;
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
                        b.this.cLp.put("cpu", a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cLs = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cLs = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cLs = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cLs = false;
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
    /* loaded from: classes25.dex */
    public class Choreographer$FrameCallbackC0422b implements Choreographer.FrameCallback {
        long cLu;
        int cLv;

        private Choreographer$FrameCallbackC0422b() {
            this.cLu = -1L;
            this.cLv = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cLq) {
                if (this.cLu > 0 && this.cLv != (i = (int) ((1.0d / (j - this.cLu)) * 1.0E9d))) {
                    this.cLv = i;
                    b.this.cLp.put("frame", Integer.valueOf(i));
                }
                this.cLu = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: c */
        public void M(Set<com.baidu.swan.apps.am.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.am.c<?> cVar : set) {
                    b.this.cLp.put(cVar.id, cVar.aOr());
                }
            }
        }
    }
}
