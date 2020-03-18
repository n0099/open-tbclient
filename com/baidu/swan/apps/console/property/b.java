package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.as.m;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bkJ = com.baidu.swan.apps.ap.e.bXY.id;
    public static final String bkK = com.baidu.swan.apps.ap.e.bXW.id;
    public static final String bkL = com.baidu.swan.apps.ap.e.bXX.id;
    public static final String bkM = com.baidu.swan.apps.ap.e.bYb.id;
    public static final String bkN = com.baidu.swan.apps.ap.e.bXZ.id;
    public static final String bkO = com.baidu.swan.apps.ap.e.bYa.id;
    public static final String bkP = com.baidu.swan.apps.ap.e.bYc.id;
    private int bkF;
    private d bkQ;
    private e bkR;
    private Choreographer$FrameCallbackC0237b bkS;
    private a bkT;
    private ConcurrentMap<String, Object> bkU;
    private boolean bkV;
    private int bkW;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b blb = new b();
    }

    private b() {
        this.bkU = new ConcurrentHashMap();
        this.bkF = 1000;
    }

    public static b Me() {
        return c.blb;
    }

    public Map<String, Object> Mf() {
        this.bkW++;
        Mg();
        return this.bkU;
    }

    public void recycle() {
        int i = this.bkW - 1;
        this.bkW = i;
        if (i <= 0) {
            Mh();
        }
    }

    private void Mg() {
        if (this.bkV) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bkV = true;
        this.bkS = new Choreographer$FrameCallbackC0237b();
        Choreographer.getInstance().postFrameCallback(this.bkS);
        this.bkT = new a();
        this.bkR = new e();
        com.baidu.swan.apps.ap.e.agr().a(this.bkR, com.baidu.swan.apps.ap.e.bXY, com.baidu.swan.apps.ap.e.bXW, com.baidu.swan.apps.ap.e.bXX, com.baidu.swan.apps.ap.e.bXZ, com.baidu.swan.apps.ap.e.bYa, com.baidu.swan.apps.ap.e.bYb, com.baidu.swan.apps.ap.e.bYc);
        this.bkQ = new d();
        this.bkQ.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Mh() {
        if (!this.bkV) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bkV = false;
        if (this.bkQ != null) {
            this.bkQ.removeMessages(0);
            this.bkQ = null;
        }
        if (this.bkR != null) {
            com.baidu.swan.apps.ap.e.agr().b(this.bkR, new com.baidu.swan.apps.ap.c[0]);
            this.bkR = null;
        }
        this.bkS = null;
        this.bkT = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.bkU != null) {
                b.this.Mi();
                b.this.bkU.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.TZ().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bkQ != null) {
                    b.this.bkQ.sendEmptyMessageDelayed(0, b.this.bkF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi() {
        if (!this.bkT.bkX) {
            m.postOnIO(this.bkT, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bkX;
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
            this.bkX = true;
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
                        b.this.bkU.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bkX = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bkX = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bkX = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bkX = false;
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
    /* loaded from: classes11.dex */
    public class Choreographer$FrameCallbackC0237b implements Choreographer.FrameCallback {
        long bkZ;
        int bla;

        private Choreographer$FrameCallbackC0237b() {
            this.bkZ = -1L;
            this.bla = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bkV) {
                if (this.bkZ > 0 && this.bla != (i = (int) ((1.0d / (j - this.bkZ)) * 1.0E9d))) {
                    this.bla = i;
                    b.this.bkU.put("frame", Integer.valueOf(i));
                }
                this.bkZ = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: b */
        public void D(Set<com.baidu.swan.apps.ap.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ap.c<?> cVar : set) {
                    b.this.bkU.put(cVar.id, cVar.agq());
                }
            }
        }
    }
}
