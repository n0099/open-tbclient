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
    public static final String aHs = com.baidu.swan.apps.ak.e.bsf.id;
    public static final String aHt = com.baidu.swan.apps.ak.e.bsd.id;
    public static final String aHu = com.baidu.swan.apps.ak.e.bse.id;
    public static final String aHv = com.baidu.swan.apps.ak.e.bsi.id;
    public static final String aHw = com.baidu.swan.apps.ak.e.bsg.id;
    public static final String aHx = com.baidu.swan.apps.ak.e.bsh.id;
    public static final String aHy = com.baidu.swan.apps.ak.e.bsj.id;
    private e aHA;
    private Choreographer$FrameCallbackC0166b aHB;
    private a aHC;
    private ConcurrentMap<String, Object> aHD;
    private boolean aHE;
    private int aHF;
    private int aHo;
    private d aHz;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b aHK = new b();
    }

    private b() {
        this.aHD = new ConcurrentHashMap();
        this.aHo = 1000;
    }

    public static b Dp() {
        return c.aHK;
    }

    public Map<String, Object> Dq() {
        this.aHF++;
        Dr();
        return this.aHD;
    }

    public void recycle() {
        int i = this.aHF - 1;
        this.aHF = i;
        if (i <= 0) {
            Ds();
        }
    }

    private void Dr() {
        if (this.aHE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.aHE = true;
        this.aHB = new Choreographer$FrameCallbackC0166b();
        Choreographer.getInstance().postFrameCallback(this.aHB);
        this.aHC = new a();
        this.aHA = new e();
        com.baidu.swan.apps.ak.e.TR().a(this.aHA, com.baidu.swan.apps.ak.e.bsf, com.baidu.swan.apps.ak.e.bsd, com.baidu.swan.apps.ak.e.bse, com.baidu.swan.apps.ak.e.bsg, com.baidu.swan.apps.ak.e.bsh, com.baidu.swan.apps.ak.e.bsi, com.baidu.swan.apps.ak.e.bsj);
        this.aHz = new d();
        this.aHz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Ds() {
        if (!this.aHE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.aHE = false;
        if (this.aHz != null) {
            this.aHz.removeMessages(0);
            this.aHz = null;
        }
        if (this.aHA != null) {
            com.baidu.swan.apps.ak.e.TR().b(this.aHA, new com.baidu.swan.apps.ak.c[0]);
            this.aHA = null;
        }
        this.aHB = null;
        this.aHC = null;
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
            if (b.this.aHD != null) {
                b.this.Dt();
                b.this.aHD.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Jj().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.aHz != null) {
                    b.this.aHz.sendEmptyMessageDelayed(0, b.this.aHo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt() {
        if (!this.aHC.aHG) {
            j.a(this.aHC, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean aHG;
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
            this.aHG = true;
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
                        b.this.aHD.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.a.b(bufferedReader);
                        this.aHG = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.a.b(bufferedReader);
                        this.aHG = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.b(append);
                    this.aHG = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.a.b(append);
                this.aHG = false;
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
    public class Choreographer$FrameCallbackC0166b implements Choreographer.FrameCallback {
        long aHI;
        int aHJ;

        private Choreographer$FrameCallbackC0166b() {
            this.aHI = -1L;
            this.aHJ = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.aHE) {
                if (this.aHI > 0 && this.aHJ != (i = (int) ((1.0d / (j - this.aHI)) * 1.0E9d))) {
                    this.aHJ = i;
                    b.this.aHD.put("frame", Integer.valueOf(i));
                }
                this.aHI = j;
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
        public void B(Set<com.baidu.swan.apps.ak.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ak.c<?> cVar : set) {
                    b.this.aHD.put(cVar.id, cVar.TQ());
                }
            }
        }
    }
}
