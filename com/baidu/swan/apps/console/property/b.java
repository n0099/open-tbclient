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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bgh = com.baidu.swan.apps.ap.e.bTH.id;
    public static final String bgi = com.baidu.swan.apps.ap.e.bTF.id;
    public static final String bgj = com.baidu.swan.apps.ap.e.bTG.id;
    public static final String bgk = com.baidu.swan.apps.ap.e.bTK.id;
    public static final String bgl = com.baidu.swan.apps.ap.e.bTI.id;
    public static final String bgm = com.baidu.swan.apps.ap.e.bTJ.id;
    public static final String bgn = com.baidu.swan.apps.ap.e.bTL.id;
    private int bgd;
    private d bgo;
    private e bgp;
    private Choreographer$FrameCallbackC0227b bgq;
    private a bgr;
    private ConcurrentMap<String, Object> bgt;
    private boolean bgu;
    private int bgv;

    /* loaded from: classes10.dex */
    private static class c {
        public static final b bgA = new b();
    }

    private b() {
        this.bgt = new ConcurrentHashMap();
        this.bgd = 1000;
    }

    public static b JK() {
        return c.bgA;
    }

    public Map<String, Object> JL() {
        this.bgv++;
        JM();
        return this.bgt;
    }

    public void recycle() {
        int i = this.bgv - 1;
        this.bgv = i;
        if (i <= 0) {
            JN();
        }
    }

    private void JM() {
        if (this.bgu) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bgu = true;
        this.bgq = new Choreographer$FrameCallbackC0227b();
        Choreographer.getInstance().postFrameCallback(this.bgq);
        this.bgr = new a();
        this.bgp = new e();
        com.baidu.swan.apps.ap.e.adY().a(this.bgp, com.baidu.swan.apps.ap.e.bTH, com.baidu.swan.apps.ap.e.bTF, com.baidu.swan.apps.ap.e.bTG, com.baidu.swan.apps.ap.e.bTI, com.baidu.swan.apps.ap.e.bTJ, com.baidu.swan.apps.ap.e.bTK, com.baidu.swan.apps.ap.e.bTL);
        this.bgo = new d();
        this.bgo.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void JN() {
        if (!this.bgu) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bgu = false;
        if (this.bgo != null) {
            this.bgo.removeMessages(0);
            this.bgo = null;
        }
        if (this.bgp != null) {
            com.baidu.swan.apps.ap.e.adY().b(this.bgp, new com.baidu.swan.apps.ap.c[0]);
            this.bgp = null;
        }
        this.bgq = null;
        this.bgr = null;
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
            if (b.this.bgt != null) {
                b.this.JO();
                b.this.bgt.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.RG().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bgo != null) {
                    b.this.bgo.sendEmptyMessageDelayed(0, b.this.bgd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (!this.bgr.bgw) {
            m.postOnIO(this.bgr, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private boolean bgw;
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
            this.bgw = true;
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
                        b.this.bgt.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bgw = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bgw = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bgw = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bgw = false;
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
    public class Choreographer$FrameCallbackC0227b implements Choreographer.FrameCallback {
        long bgy;
        int bgz;

        private Choreographer$FrameCallbackC0227b() {
            this.bgy = -1L;
            this.bgz = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bgu) {
                if (this.bgy > 0 && this.bgz != (i = (int) ((1.0d / (j - this.bgy)) * 1.0E9d))) {
                    this.bgz = i;
                    b.this.bgt.put("frame", Integer.valueOf(i));
                }
                this.bgy = j;
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
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: b */
        public void B(Set<com.baidu.swan.apps.ap.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ap.c<?> cVar : set) {
                    b.this.bgt.put(cVar.id, cVar.adX());
                }
            }
        }
    }
}
