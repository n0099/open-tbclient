package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.aq.n;
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
    public static final String bWB = com.baidu.swan.apps.an.e.cNJ.id;
    public static final String bWC = com.baidu.swan.apps.an.e.cNH.id;
    public static final String bWD = com.baidu.swan.apps.an.e.cNI.id;
    public static final String bWE = com.baidu.swan.apps.an.e.cNM.id;
    public static final String bWF = com.baidu.swan.apps.an.e.cNO.id;
    public static final String bWG = com.baidu.swan.apps.an.e.cNK.id;
    public static final String bWH = com.baidu.swan.apps.an.e.cNL.id;
    public static final String bWI = com.baidu.swan.apps.an.e.cNN.id;
    public static final String bWJ = com.baidu.swan.apps.an.e.cNP.id;
    private d bWK;
    private e bWL;
    private Choreographer$FrameCallbackC0331b bWM;
    private a bWN;
    private ConcurrentMap<String, Object> bWO;
    private boolean bWP;
    private int bWQ;
    private int bWx;

    /* loaded from: classes11.dex */
    private static class c {
        public static final b bWV = new b();
    }

    private b() {
        this.bWO = new ConcurrentHashMap();
        this.bWx = 1000;
    }

    public static b XE() {
        return c.bWV;
    }

    public Map<String, Object> XF() {
        this.bWQ++;
        XG();
        return this.bWO;
    }

    public void recycle() {
        int i = this.bWQ - 1;
        this.bWQ = i;
        if (i <= 0) {
            XH();
        }
    }

    private void XG() {
        if (this.bWP) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bWP = true;
        this.bWM = new Choreographer$FrameCallbackC0331b();
        Choreographer.getInstance().postFrameCallback(this.bWM);
        this.bWN = new a();
        this.bWL = new e();
        com.baidu.swan.apps.an.e.atW().a(this.bWL, com.baidu.swan.apps.an.e.cNJ, com.baidu.swan.apps.an.e.cNH, com.baidu.swan.apps.an.e.cNI, com.baidu.swan.apps.an.e.cNO, com.baidu.swan.apps.an.e.cNK, com.baidu.swan.apps.an.e.cNL, com.baidu.swan.apps.an.e.cNM, com.baidu.swan.apps.an.e.cNN, com.baidu.swan.apps.an.e.cNP);
        this.bWK = new d();
        this.bWK.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void XH() {
        if (!this.bWP) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bWP = false;
        if (this.bWK != null) {
            this.bWK.removeMessages(0);
            this.bWK = null;
        }
        if (this.bWL != null) {
            com.baidu.swan.apps.an.e.atW().b(this.bWL, new com.baidu.swan.apps.an.c[0]);
            this.bWL = null;
        }
        this.bWM = null;
        this.bWN = null;
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
            if (b.this.bWO != null) {
                b.this.XI();
                b.this.bWO.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.afX().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bWK != null) {
                    b.this.bWK.sendEmptyMessageDelayed(0, b.this.bWx);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        if (!this.bWN.bWR) {
            n.postOnIO(this.bWN, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private boolean bWR;
        private final String name;

        private a() {
            this.name = "swanAppCpuMonitor";
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [266=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a9 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.bWR = true;
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
                        b.this.bWO.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.e.d.closeSafely(bufferedReader);
                        this.bWR = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.e.d.closeSafely(bufferedReader);
                        this.bWR = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.e.d.closeSafely(append);
                    this.bWR = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.e.d.closeSafely(append);
                this.bWR = false;
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
    public class Choreographer$FrameCallbackC0331b implements Choreographer.FrameCallback {
        long bWT;
        int bWU;

        private Choreographer$FrameCallbackC0331b() {
            this.bWT = -1L;
            this.bWU = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bWP) {
                if (this.bWT > 0 && this.bWU != (i = (int) ((1.0d / (j - this.bWT)) * 1.0E9d))) {
                    this.bWU = i;
                    b.this.bWO.put("frame", Integer.valueOf(i));
                }
                this.bWT = j;
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
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: c */
        public void H(Set<com.baidu.swan.apps.an.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.an.c<?> cVar : set) {
                    b.this.bWO.put(cVar.id, cVar.atV());
                }
            }
        }
    }
}
