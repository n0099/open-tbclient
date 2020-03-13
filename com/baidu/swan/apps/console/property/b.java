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
    private d bkD;
    private e bkE;
    private Choreographer$FrameCallbackC0237b bkF;
    private a bkG;
    private ConcurrentMap<String, Object> bkH;
    private boolean bkI;
    private int bkJ;
    private int bks;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bkw = com.baidu.swan.apps.ap.e.bXN.id;
    public static final String bkx = com.baidu.swan.apps.ap.e.bXL.id;
    public static final String bky = com.baidu.swan.apps.ap.e.bXM.id;
    public static final String bkz = com.baidu.swan.apps.ap.e.bXQ.id;
    public static final String bkA = com.baidu.swan.apps.ap.e.bXO.id;
    public static final String bkB = com.baidu.swan.apps.ap.e.bXP.id;
    public static final String bkC = com.baidu.swan.apps.ap.e.bXR.id;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b bkO = new b();
    }

    private b() {
        this.bkH = new ConcurrentHashMap();
        this.bks = 1000;
    }

    public static b Mb() {
        return c.bkO;
    }

    public Map<String, Object> Mc() {
        this.bkJ++;
        Md();
        return this.bkH;
    }

    public void recycle() {
        int i = this.bkJ - 1;
        this.bkJ = i;
        if (i <= 0) {
            Me();
        }
    }

    private void Md() {
        if (this.bkI) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bkI = true;
        this.bkF = new Choreographer$FrameCallbackC0237b();
        Choreographer.getInstance().postFrameCallback(this.bkF);
        this.bkG = new a();
        this.bkE = new e();
        com.baidu.swan.apps.ap.e.ago().a(this.bkE, com.baidu.swan.apps.ap.e.bXN, com.baidu.swan.apps.ap.e.bXL, com.baidu.swan.apps.ap.e.bXM, com.baidu.swan.apps.ap.e.bXO, com.baidu.swan.apps.ap.e.bXP, com.baidu.swan.apps.ap.e.bXQ, com.baidu.swan.apps.ap.e.bXR);
        this.bkD = new d();
        this.bkD.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Me() {
        if (!this.bkI) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bkI = false;
        if (this.bkD != null) {
            this.bkD.removeMessages(0);
            this.bkD = null;
        }
        if (this.bkE != null) {
            com.baidu.swan.apps.ap.e.ago().b(this.bkE, new com.baidu.swan.apps.ap.c[0]);
            this.bkE = null;
        }
        this.bkF = null;
        this.bkG = null;
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
            if (b.this.bkH != null) {
                b.this.Mf();
                b.this.bkH.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.TW().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bkD != null) {
                    b.this.bkD.sendEmptyMessageDelayed(0, b.this.bks);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mf() {
        if (!this.bkG.bkK) {
            m.postOnIO(this.bkG, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bkK;
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
            this.bkK = true;
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
                        b.this.bkH.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bkK = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bkK = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bkK = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bkK = false;
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
        long bkM;
        int bkN;

        private Choreographer$FrameCallbackC0237b() {
            this.bkM = -1L;
            this.bkN = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bkI) {
                if (this.bkM > 0 && this.bkN != (i = (int) ((1.0d / (j - this.bkM)) * 1.0E9d))) {
                    this.bkN = i;
                    b.this.bkH.put("frame", Integer.valueOf(i));
                }
                this.bkM = j;
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
                    b.this.bkH.put(cVar.id, cVar.agn());
                }
            }
        }
    }
}
