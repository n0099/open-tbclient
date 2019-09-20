package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
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
    public static final String aot = com.baidu.swan.apps.ak.e.aZX.id;
    public static final String aou = com.baidu.swan.apps.ak.e.aZV.id;
    public static final String aov = com.baidu.swan.apps.ak.e.aZW.id;
    public static final String aow = com.baidu.swan.apps.ak.e.baa.id;
    public static final String aox = com.baidu.swan.apps.ak.e.aZY.id;
    public static final String aoy = com.baidu.swan.apps.ak.e.aZZ.id;
    public static final String aoz = com.baidu.swan.apps.ak.e.bab.id;
    private d aoA;
    private e aoB;
    private Choreographer$FrameCallbackC0139b aoC;
    private a aoD;
    private ConcurrentMap<String, Object> aoE;
    private boolean aoF;
    private int aoG;
    private int aop;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b aoL = new b();
    }

    private b() {
        this.aoE = new ConcurrentHashMap();
        this.aop = 1000;
    }

    public static b yt() {
        return c.aoL;
    }

    public Map<String, Object> yu() {
        this.aoG++;
        yv();
        return this.aoE;
    }

    public void recycle() {
        int i = this.aoG - 1;
        this.aoG = i;
        if (i <= 0) {
            yw();
        }
    }

    private void yv() {
        if (this.aoF) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.aoF = true;
        this.aoC = new Choreographer$FrameCallbackC0139b();
        Choreographer.getInstance().postFrameCallback(this.aoC);
        this.aoD = new a();
        this.aoB = new e();
        com.baidu.swan.apps.ak.e.Pd().a(this.aoB, com.baidu.swan.apps.ak.e.aZX, com.baidu.swan.apps.ak.e.aZV, com.baidu.swan.apps.ak.e.aZW, com.baidu.swan.apps.ak.e.aZY, com.baidu.swan.apps.ak.e.aZZ, com.baidu.swan.apps.ak.e.baa, com.baidu.swan.apps.ak.e.bab);
        this.aoA = new d();
        this.aoA.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void yw() {
        if (!this.aoF) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.aoF = false;
        if (this.aoA != null) {
            this.aoA.removeMessages(0);
            this.aoA = null;
        }
        if (this.aoB != null) {
            com.baidu.swan.apps.ak.e.Pd().b(this.aoB, new com.baidu.swan.apps.ak.c[0]);
            this.aoB = null;
        }
        this.aoC = null;
        this.aoD = null;
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
            if (b.this.aoE != null) {
                b.this.yx();
                b.this.aoE.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Eo().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.aoA != null) {
                    b.this.aoA.sendEmptyMessageDelayed(0, b.this.aop);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx() {
        if (!this.aoD.aoH) {
            j.a(this.aoD, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean aoH;
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
            this.aoH = true;
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
                        b.this.aoE.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.aoH = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.aoH = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(append);
                    this.aoH = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.a.c(append);
                this.aoH = false;
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
    public class Choreographer$FrameCallbackC0139b implements Choreographer.FrameCallback {
        long aoJ;
        int aoK;

        private Choreographer$FrameCallbackC0139b() {
            this.aoJ = -1L;
            this.aoK = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.aoF) {
                if (this.aoJ > 0 && this.aoK != (i = (int) ((1.0d / (j - this.aoJ)) * 1.0E9d))) {
                    this.aoK = i;
                    b.this.aoE.put("frame", Integer.valueOf(i));
                }
                this.aoJ = j;
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
                    b.this.aoE.put(cVar.id, cVar.Pc());
                }
            }
        }
    }
}
