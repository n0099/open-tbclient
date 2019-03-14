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
    public static final String anb = com.baidu.swan.apps.ak.e.aVL.id;
    public static final String anc = com.baidu.swan.apps.ak.e.aVJ.id;
    public static final String and = com.baidu.swan.apps.ak.e.aVK.id;
    public static final String ane = com.baidu.swan.apps.ak.e.aVO.id;
    public static final String anf = com.baidu.swan.apps.ak.e.aVM.id;
    public static final String ang = com.baidu.swan.apps.ak.e.aVN.id;
    public static final String anh = com.baidu.swan.apps.ak.e.aVP.id;
    private int amX;
    private d ani;
    private e anj;
    private Choreographer$FrameCallbackC0125b ank;
    private a anl;
    private ConcurrentMap<String, Object> anm;
    private boolean ann;
    private int ano;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b ant = new b();
    }

    private b() {
        this.anm = new ConcurrentHashMap();
        this.amX = 1000;
    }

    public static b wT() {
        return c.ant;
    }

    public Map<String, Object> wU() {
        this.ano++;
        wV();
        return this.anm;
    }

    public void recycle() {
        int i = this.ano - 1;
        this.ano = i;
        if (i <= 0) {
            wW();
        }
    }

    private void wV() {
        if (this.ann) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.ann = true;
        this.ank = new Choreographer$FrameCallbackC0125b();
        Choreographer.getInstance().postFrameCallback(this.ank);
        this.anl = new a();
        this.anj = new e();
        com.baidu.swan.apps.ak.e.LG().a(this.anj, com.baidu.swan.apps.ak.e.aVL, com.baidu.swan.apps.ak.e.aVJ, com.baidu.swan.apps.ak.e.aVK, com.baidu.swan.apps.ak.e.aVM, com.baidu.swan.apps.ak.e.aVN, com.baidu.swan.apps.ak.e.aVO, com.baidu.swan.apps.ak.e.aVP);
        this.ani = new d();
        this.ani.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void wW() {
        if (!this.ann) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.ann = false;
        if (this.ani != null) {
            this.ani.removeMessages(0);
            this.ani = null;
        }
        if (this.anj != null) {
            com.baidu.swan.apps.ak.e.LG().b(this.anj, new com.baidu.swan.apps.ak.c[0]);
            this.anj = null;
        }
        this.ank = null;
        this.anl = null;
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
            if (b.this.anm != null) {
                b.this.wX();
                b.this.anm.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Cy().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.ani != null) {
                    b.this.ani.sendEmptyMessageDelayed(0, b.this.amX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX() {
        if (!this.anl.anp) {
            j.a(this.anl, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean anp;
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
            this.anp = true;
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
                        b.this.anm.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.anp = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.b.c(bufferedReader);
                        this.anp = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.b.c(append);
                    this.anp = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.b.c(append);
                this.anp = false;
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
        long anr;
        int ans;

        private Choreographer$FrameCallbackC0125b() {
            this.anr = -1L;
            this.ans = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.ann) {
                if (this.anr > 0 && this.ans != (i = (int) ((1.0d / (j - this.anr)) * 1.0E9d))) {
                    this.ans = i;
                    b.this.anm.put("frame", Integer.valueOf(i));
                }
                this.anr = j;
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
                    b.this.anm.put(cVar.id, cVar.LF());
                }
            }
        }
    }
}
