package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
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
    public static final String ang = com.baidu.swan.apps.ak.e.aVP.id;
    public static final String anh = com.baidu.swan.apps.ak.e.aVN.id;
    public static final String ani = com.baidu.swan.apps.ak.e.aVO.id;
    public static final String anj = com.baidu.swan.apps.ak.e.aVS.id;
    public static final String ank = com.baidu.swan.apps.ak.e.aVQ.id;
    public static final String anl = com.baidu.swan.apps.ak.e.aVR.id;
    public static final String anm = com.baidu.swan.apps.ak.e.aVT.id;
    private int anc;
    private d ann;
    private e ano;
    private Choreographer$FrameCallbackC0125b anp;
    private a anq;
    private ConcurrentMap<String, Object> anr;
    private boolean ans;
    private int ant;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b any = new b();
    }

    private b() {
        this.anr = new ConcurrentHashMap();
        this.anc = 1000;
    }

    public static b wS() {
        return c.any;
    }

    public Map<String, Object> wT() {
        this.ant++;
        wU();
        return this.anr;
    }

    public void recycle() {
        int i = this.ant - 1;
        this.ant = i;
        if (i <= 0) {
            wV();
        }
    }

    private void wU() {
        if (this.ans) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.ans = true;
        this.anp = new Choreographer$FrameCallbackC0125b();
        Choreographer.getInstance().postFrameCallback(this.anp);
        this.anq = new a();
        this.ano = new e();
        com.baidu.swan.apps.ak.e.LE().a(this.ano, com.baidu.swan.apps.ak.e.aVP, com.baidu.swan.apps.ak.e.aVN, com.baidu.swan.apps.ak.e.aVO, com.baidu.swan.apps.ak.e.aVQ, com.baidu.swan.apps.ak.e.aVR, com.baidu.swan.apps.ak.e.aVS, com.baidu.swan.apps.ak.e.aVT);
        this.ann = new d();
        this.ann.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void wV() {
        if (!this.ans) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.ans = false;
        if (this.ann != null) {
            this.ann.removeMessages(0);
            this.ann = null;
        }
        if (this.ano != null) {
            com.baidu.swan.apps.ak.e.LE().b(this.ano, new com.baidu.swan.apps.ak.c[0]);
            this.ano = null;
        }
        this.anp = null;
        this.anq = null;
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
            if (b.this.anr != null) {
                b.this.wW();
                b.this.anr.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Cw().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.ann != null) {
                    b.this.ann.sendEmptyMessageDelayed(0, b.this.anc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW() {
        if (!this.anq.anu) {
            j.a(this.anq, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean anu;
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
            this.anu = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a = a(bufferedReader);
                        b.this.anr.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.anu = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.anu = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.b.c(append);
                    this.anu = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.b.c(append);
                this.anu = false;
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
    public class Choreographer$FrameCallbackC0125b implements Choreographer.FrameCallback {
        long anw;
        int anx;

        private Choreographer$FrameCallbackC0125b() {
            this.anw = -1L;
            this.anx = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.ans) {
                if (this.anw > 0 && this.anx != (i = (int) ((1.0d / (j - this.anw)) * 1.0E9d))) {
                    this.anx = i;
                    b.this.anr.put("frame", Integer.valueOf(i));
                }
                this.anw = j;
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
        @Override // com.baidu.swan.apps.an.c.a
        /* renamed from: e */
        public void D(Set<com.baidu.swan.apps.ak.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ak.c<?> cVar : set) {
                    b.this.anr.put(cVar.id, cVar.LD());
                }
            }
        }
    }
}
