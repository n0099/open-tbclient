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
    private d cAi;
    private e cAj;
    private Choreographer$FrameCallbackC0400b cAk;
    private a cAl;
    private ConcurrentMap<String, Object> cAm;
    private boolean cAn;
    private int cAo;
    private int czU;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String czY = com.baidu.swan.apps.am.e.dwU.id;
    public static final String czZ = com.baidu.swan.apps.am.e.dwS.id;
    public static final String cAa = com.baidu.swan.apps.am.e.dwT.id;
    public static final String cAb = com.baidu.swan.apps.am.e.dwX.id;
    public static final String cAc = com.baidu.swan.apps.am.e.dwZ.id;
    public static final String cAd = com.baidu.swan.apps.am.e.dwV.id;
    public static final String cAe = com.baidu.swan.apps.am.e.dwW.id;
    public static final String cAf = com.baidu.swan.apps.am.e.dwY.id;
    public static final String cAg = com.baidu.swan.apps.am.e.dxa.id;
    public static final String cAh = com.baidu.swan.apps.am.e.dxb.id;

    /* loaded from: classes10.dex */
    private static class c {
        public static final b cAt = new b();
    }

    private b() {
        this.cAm = new ConcurrentHashMap();
        this.czU = 1000;
    }

    public static b ajF() {
        return c.cAt;
    }

    public Map<String, Object> ajG() {
        this.cAo++;
        ajH();
        return this.cAm;
    }

    public void recycle() {
        int i = this.cAo - 1;
        this.cAo = i;
        if (i <= 0) {
            ajI();
        }
    }

    private void ajH() {
        if (this.cAn) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cAn = true;
        this.cAk = new Choreographer$FrameCallbackC0400b();
        Choreographer.getInstance().postFrameCallback(this.cAk);
        this.cAl = new a();
        this.cAj = new e();
        com.baidu.swan.apps.am.e.aJt().a(this.cAj, com.baidu.swan.apps.am.e.dwU, com.baidu.swan.apps.am.e.dwS, com.baidu.swan.apps.am.e.dwT, com.baidu.swan.apps.am.e.dwZ, com.baidu.swan.apps.am.e.dwV, com.baidu.swan.apps.am.e.dwW, com.baidu.swan.apps.am.e.dwX, com.baidu.swan.apps.am.e.dwY, com.baidu.swan.apps.am.e.dxa, com.baidu.swan.apps.am.e.dxb);
        this.cAi = new d();
        this.cAi.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void ajI() {
        if (!this.cAn) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cAn = false;
        if (this.cAi != null) {
            this.cAi.removeMessages(0);
            this.cAi = null;
        }
        if (this.cAj != null) {
            com.baidu.swan.apps.am.e.aJt().b(this.cAj, new com.baidu.swan.apps.am.c[0]);
            this.cAj = null;
        }
        this.cAk = null;
        this.cAl = null;
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
            if (b.this.cAm != null) {
                b.this.ajJ();
                b.this.cAm.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.aua().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cAi != null) {
                    b.this.cAi.sendEmptyMessageDelayed(0, b.this.czU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajJ() {
        if (!this.cAl.cAp) {
            p.postOnIO(this.cAl, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private boolean cAp;
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
            this.cAp = true;
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
                        b.this.cAm.put(com.baidu.fsg.face.base.b.c.i, a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cAp = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cAp = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cAp = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cAp = false;
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
    public class Choreographer$FrameCallbackC0400b implements Choreographer.FrameCallback {
        long cAr;
        int cAs;

        private Choreographer$FrameCallbackC0400b() {
            this.cAr = -1L;
            this.cAs = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cAn) {
                if (this.cAr > 0 && this.cAs != (i = (int) ((1.0d / (j - this.cAr)) * 1.0E9d))) {
                    this.cAs = i;
                    b.this.cAm.put("frame", Integer.valueOf(i));
                }
                this.cAr = j;
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
                    b.this.cAm.put(cVar.id, cVar.aJs());
                }
            }
        }
    }
}
