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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cPW = com.baidu.swan.apps.al.e.dQI.id;
    public static final String cPX = com.baidu.swan.apps.al.e.dQG.id;
    public static final String cPY = com.baidu.swan.apps.al.e.dQH.id;
    public static final String cPZ = com.baidu.swan.apps.al.e.dQL.id;
    public static final String cQa = com.baidu.swan.apps.al.e.dQN.id;
    public static final String cQb = com.baidu.swan.apps.al.e.dQJ.id;
    public static final String cQc = com.baidu.swan.apps.al.e.dQK.id;
    public static final String cQd = com.baidu.swan.apps.al.e.dQM.id;
    public static final String cQe = com.baidu.swan.apps.al.e.dQO.id;
    public static final String cQf = com.baidu.swan.apps.al.e.dQP.id;
    private int cPS;
    private d cQg;
    private e cQh;
    private Choreographer$FrameCallbackC0414b cQi;
    private a cQj;
    private ConcurrentMap<String, Object> cQk;
    private boolean cQl;
    private int cQm;

    /* loaded from: classes9.dex */
    private static class c {
        public static final b cQr = new b();
    }

    private b() {
        this.cQk = new ConcurrentHashMap();
        this.cPS = 1000;
    }

    public static b apT() {
        return c.cQr;
    }

    public Map<String, Object> apU() {
        this.cQm++;
        apV();
        return this.cQk;
    }

    public void recycle() {
        int i = this.cQm - 1;
        this.cQm = i;
        if (i <= 0) {
            apW();
        }
    }

    private void apV() {
        if (this.cQl) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cQl = true;
        this.cQi = new Choreographer$FrameCallbackC0414b();
        Choreographer.getInstance().postFrameCallback(this.cQi);
        this.cQj = new a();
        this.cQh = new e();
        com.baidu.swan.apps.al.e.aQK().a(this.cQh, com.baidu.swan.apps.al.e.dQI, com.baidu.swan.apps.al.e.dQG, com.baidu.swan.apps.al.e.dQH, com.baidu.swan.apps.al.e.dQN, com.baidu.swan.apps.al.e.dQJ, com.baidu.swan.apps.al.e.dQK, com.baidu.swan.apps.al.e.dQL, com.baidu.swan.apps.al.e.dQM, com.baidu.swan.apps.al.e.dQO, com.baidu.swan.apps.al.e.dQP);
        this.cQg = new d();
        this.cQg.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void apW() {
        if (!this.cQl) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cQl = false;
        if (this.cQg != null) {
            this.cQg.removeMessages(0);
            this.cQg = null;
        }
        if (this.cQh != null) {
            com.baidu.swan.apps.al.e.aQK().b(this.cQh, new com.baidu.swan.apps.al.c[0]);
            this.cQh = null;
        }
        this.cQi = null;
        this.cQj = null;
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
            if (b.this.cQk != null) {
                b.this.apX();
                b.this.cQk.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.aAs().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cQg != null) {
                    b.this.cQg.sendEmptyMessageDelayed(0, b.this.cPS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apX() {
        if (!this.cQj.cQn) {
            p.a(this.cQj, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private boolean cQn;
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
            this.cQn = true;
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
                        b.this.cQk.put("cpu", a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cQn = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cQn = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cQn = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cQn = false;
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
    public class Choreographer$FrameCallbackC0414b implements Choreographer.FrameCallback {
        long cQp;
        int cQq;

        private Choreographer$FrameCallbackC0414b() {
            this.cQp = -1L;
            this.cQq = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cQl) {
                if (this.cQp > 0 && this.cQq != (i = (int) ((1.0d / (j - this.cQp)) * 1.0E9d))) {
                    this.cQq = i;
                    b.this.cQk.put("frame", Integer.valueOf(i));
                }
                this.cQp = j;
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
                    b.this.cQk.put(cVar.id, cVar.aQJ());
                }
            }
        }
    }
}
