package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cOY = com.baidu.swan.apps.al.e.dPB.id;
    public static final String cOZ = com.baidu.swan.apps.al.e.dPz.id;
    public static final String cPa = com.baidu.swan.apps.al.e.dPA.id;
    public static final String cPb = com.baidu.swan.apps.al.e.dPE.id;
    public static final String cPc = com.baidu.swan.apps.al.e.dPG.id;
    public static final String cPd = com.baidu.swan.apps.al.e.dPC.id;
    public static final String cPe = com.baidu.swan.apps.al.e.dPD.id;
    public static final String cPf = com.baidu.swan.apps.al.e.dPF.id;
    public static final String cPg = com.baidu.swan.apps.al.e.dPH.id;
    public static final String cPh = com.baidu.swan.apps.al.e.dPI.id;
    private int cOU;
    private d cPi;
    private e cPj;
    private Choreographer$FrameCallbackC0400b cPk;
    private a cPl;
    private ConcurrentMap<String, Object> cPm;
    private boolean cPn;
    private int cPo;

    /* loaded from: classes8.dex */
    private static class c {
        public static final b cPt = new b();
    }

    private b() {
        this.cPm = new ConcurrentHashMap();
        this.cOU = 1000;
    }

    public static b amz() {
        return c.cPt;
    }

    public Map<String, Object> amA() {
        this.cPo++;
        amB();
        return this.cPm;
    }

    public void recycle() {
        int i = this.cPo - 1;
        this.cPo = i;
        if (i <= 0) {
            amC();
        }
    }

    private void amB() {
        if (this.cPn) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cPn = true;
        this.cPk = new Choreographer$FrameCallbackC0400b();
        Choreographer.getInstance().postFrameCallback(this.cPk);
        this.cPl = new a();
        this.cPj = new e();
        com.baidu.swan.apps.al.e.aNm().a(this.cPj, com.baidu.swan.apps.al.e.dPB, com.baidu.swan.apps.al.e.dPz, com.baidu.swan.apps.al.e.dPA, com.baidu.swan.apps.al.e.dPG, com.baidu.swan.apps.al.e.dPC, com.baidu.swan.apps.al.e.dPD, com.baidu.swan.apps.al.e.dPE, com.baidu.swan.apps.al.e.dPF, com.baidu.swan.apps.al.e.dPH, com.baidu.swan.apps.al.e.dPI);
        this.cPi = new d();
        this.cPi.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void amC() {
        if (!this.cPn) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cPn = false;
        if (this.cPi != null) {
            this.cPi.removeMessages(0);
            this.cPi = null;
        }
        if (this.cPj != null) {
            com.baidu.swan.apps.al.e.aNm().b(this.cPj, new com.baidu.swan.apps.al.c[0]);
            this.cPj = null;
        }
        this.cPk = null;
        this.cPl = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cPm != null) {
                b.this.amD();
                b.this.cPm.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.awZ().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cPi != null) {
                    b.this.cPi.sendEmptyMessageDelayed(0, b.this.cOU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amD() {
        if (!this.cPl.cPp) {
            p.a(this.cPl, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private boolean cPp;
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
            this.cPp = true;
            if (b.DEBUG) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            int myPid = Process.myPid();
            ?? append = new StringBuilder().append("top -n 1 | grep ");
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", append.append(myPid).toString()}).getInputStream()));
                    try {
                        String a2 = a(bufferedReader);
                        b.this.cPm.put("cpu", a2);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a2);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cPp = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cPp = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cPp = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cPp = false;
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
    /* loaded from: classes8.dex */
    public class Choreographer$FrameCallbackC0400b implements Choreographer.FrameCallback {
        long cPr;
        int cPs;

        private Choreographer$FrameCallbackC0400b() {
            this.cPr = -1L;
            this.cPs = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cPn) {
                if (this.cPr > 0 && this.cPs != (i = (int) ((1.0d / (j - this.cPr)) * 1.0E9d))) {
                    this.cPs = i;
                    b.this.cPm.put("frame", Integer.valueOf(i));
                }
                this.cPr = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: c */
        public void N(Set<com.baidu.swan.apps.al.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.al.c<?> cVar : set) {
                    b.this.cPm.put(cVar.id, cVar.aNl());
                }
            }
        }
    }
}
