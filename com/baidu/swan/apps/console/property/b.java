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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public static final String ana = com.baidu.swan.apps.ak.e.aVK.id;
    public static final String anb = com.baidu.swan.apps.ak.e.aVI.id;
    public static final String anc = com.baidu.swan.apps.ak.e.aVJ.id;
    public static final String and = com.baidu.swan.apps.ak.e.aVN.id;
    public static final String ane = com.baidu.swan.apps.ak.e.aVL.id;
    public static final String anf = com.baidu.swan.apps.ak.e.aVM.id;
    public static final String ang = com.baidu.swan.apps.ak.e.aVO.id;
    private int amW;
    private d anh;
    private e ani;
    private Choreographer$FrameCallbackC0096b anj;
    private a ank;
    private ConcurrentMap<String, Object> anl;
    private boolean anm;
    private int ann;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b ans = new b();
    }

    private b() {
        this.anl = new ConcurrentHashMap();
        this.amW = 1000;
    }

    public static b wT() {
        return c.ans;
    }

    public Map<String, Object> wU() {
        this.ann++;
        wV();
        return this.anl;
    }

    public void recycle() {
        int i = this.ann - 1;
        this.ann = i;
        if (i <= 0) {
            wW();
        }
    }

    private void wV() {
        if (this.anm) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.anm = true;
        this.anj = new Choreographer$FrameCallbackC0096b();
        Choreographer.getInstance().postFrameCallback(this.anj);
        this.ank = new a();
        this.ani = new e();
        com.baidu.swan.apps.ak.e.LG().a(this.ani, com.baidu.swan.apps.ak.e.aVK, com.baidu.swan.apps.ak.e.aVI, com.baidu.swan.apps.ak.e.aVJ, com.baidu.swan.apps.ak.e.aVL, com.baidu.swan.apps.ak.e.aVM, com.baidu.swan.apps.ak.e.aVN, com.baidu.swan.apps.ak.e.aVO);
        this.anh = new d();
        this.anh.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void wW() {
        if (!this.anm) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.anm = false;
        if (this.anh != null) {
            this.anh.removeMessages(0);
            this.anh = null;
        }
        if (this.ani != null) {
            com.baidu.swan.apps.ak.e.LG().b(this.ani, new com.baidu.swan.apps.ak.c[0]);
            this.ani = null;
        }
        this.anj = null;
        this.ank = null;
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
            if (b.this.anl != null) {
                b.this.wX();
                b.this.anl.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Cy().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.anh != null) {
                    b.this.anh.sendEmptyMessageDelayed(0, b.this.amW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX() {
        if (!this.ank.ano) {
            j.a(this.ank, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean ano;
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
            this.ano = true;
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
                        b.this.anl.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.ano = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.ano = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.b.c(append);
                    this.ano = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.b.c(append);
                this.ano = false;
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
    public class Choreographer$FrameCallbackC0096b implements Choreographer.FrameCallback {
        long anq;
        int anr;

        private Choreographer$FrameCallbackC0096b() {
            this.anq = -1L;
            this.anr = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.anm) {
                if (this.anq > 0 && this.anr != (i = (int) ((1.0d / (j - this.anq)) * 1.0E9d))) {
                    this.anr = i;
                    b.this.anl.put("frame", Integer.valueOf(i));
                }
                this.anq = j;
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
                    b.this.anl.put(cVar.id, cVar.LF());
                }
            }
        }
    }
}
