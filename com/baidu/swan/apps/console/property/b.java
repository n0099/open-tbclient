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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String bfs = com.baidu.swan.apps.ap.e.bTv.id;
    public static final String bft = com.baidu.swan.apps.ap.e.bTt.id;
    public static final String bfu = com.baidu.swan.apps.ap.e.bTu.id;
    public static final String bfv = com.baidu.swan.apps.ap.e.bTy.id;
    public static final String bfw = com.baidu.swan.apps.ap.e.bTw.id;
    public static final String bfx = com.baidu.swan.apps.ap.e.bTx.id;
    public static final String bfy = com.baidu.swan.apps.ap.e.bTz.id;
    private e bfA;
    private Choreographer$FrameCallbackC0225b bfB;
    private a bfC;
    private ConcurrentMap<String, Object> bfD;
    private boolean bfE;
    private int bfF;
    private int bfo;
    private d bfz;

    /* loaded from: classes9.dex */
    private static class c {
        public static final b bfK = new b();
    }

    private b() {
        this.bfD = new ConcurrentHashMap();
        this.bfo = 1000;
    }

    public static b Jo() {
        return c.bfK;
    }

    public Map<String, Object> Jp() {
        this.bfF++;
        Jq();
        return this.bfD;
    }

    public void recycle() {
        int i = this.bfF - 1;
        this.bfF = i;
        if (i <= 0) {
            Jr();
        }
    }

    private void Jq() {
        if (this.bfE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.bfE = true;
        this.bfB = new Choreographer$FrameCallbackC0225b();
        Choreographer.getInstance().postFrameCallback(this.bfB);
        this.bfC = new a();
        this.bfA = new e();
        com.baidu.swan.apps.ap.e.adF().a(this.bfA, com.baidu.swan.apps.ap.e.bTv, com.baidu.swan.apps.ap.e.bTt, com.baidu.swan.apps.ap.e.bTu, com.baidu.swan.apps.ap.e.bTw, com.baidu.swan.apps.ap.e.bTx, com.baidu.swan.apps.ap.e.bTy, com.baidu.swan.apps.ap.e.bTz);
        this.bfz = new d();
        this.bfz.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Jr() {
        if (!this.bfE) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.bfE = false;
        if (this.bfz != null) {
            this.bfz.removeMessages(0);
            this.bfz = null;
        }
        if (this.bfA != null) {
            com.baidu.swan.apps.ap.e.adF().b(this.bfA, new com.baidu.swan.apps.ap.c[0]);
            this.bfA = null;
        }
        this.bfB = null;
        this.bfC = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.bfD != null) {
                b.this.Js();
                b.this.bfD.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.w.a.Rk().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.bfz != null) {
                    b.this.bfz.sendEmptyMessageDelayed(0, b.this.bfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Js() {
        if (!this.bfC.bfG) {
            m.postOnIO(this.bfC, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private boolean bfG;
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
            this.bfG = true;
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
                        b.this.bfD.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bfG = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.d.c.closeSafely(bufferedReader);
                        this.bfG = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(append);
                    this.bfG = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.d.c.closeSafely(append);
                this.bfG = false;
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
    /* loaded from: classes9.dex */
    public class Choreographer$FrameCallbackC0225b implements Choreographer.FrameCallback {
        long bfI;
        int bfJ;

        private Choreographer$FrameCallbackC0225b() {
            this.bfI = -1L;
            this.bfJ = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.bfE) {
                if (this.bfI > 0 && this.bfJ != (i = (int) ((1.0d / (j - this.bfI)) * 1.0E9d))) {
                    this.bfJ = i;
                    b.this.bfD.put("frame", Integer.valueOf(i));
                }
                this.bfI = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: b */
        public void B(Set<com.baidu.swan.apps.ap.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ap.c<?> cVar : set) {
                    b.this.bfD.put(cVar.id, cVar.adE());
                }
            }
        }
    }
}
