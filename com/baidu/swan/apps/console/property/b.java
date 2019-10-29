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
    public static final String aHK = com.baidu.swan.apps.ak.e.bsW.id;
    public static final String aHL = com.baidu.swan.apps.ak.e.bsU.id;
    public static final String aHM = com.baidu.swan.apps.ak.e.bsV.id;
    public static final String aHN = com.baidu.swan.apps.ak.e.bsZ.id;
    public static final String aHO = com.baidu.swan.apps.ak.e.bsX.id;
    public static final String aHP = com.baidu.swan.apps.ak.e.bsY.id;
    public static final String aHQ = com.baidu.swan.apps.ak.e.bta.id;
    private int aHG;
    private d aHR;
    private e aHS;
    private Choreographer$FrameCallbackC0171b aHT;
    private a aHU;
    private ConcurrentMap<String, Object> aHV;
    private boolean aHW;
    private int aHX;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b aIc = new b();
    }

    private b() {
        this.aHV = new ConcurrentHashMap();
        this.aHG = 1000;
    }

    public static b Do() {
        return c.aIc;
    }

    public Map<String, Object> Dp() {
        this.aHX++;
        Dq();
        return this.aHV;
    }

    public void recycle() {
        int i = this.aHX - 1;
        this.aHX = i;
        if (i <= 0) {
            Dr();
        }
    }

    private void Dq() {
        if (this.aHW) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.aHW = true;
        this.aHT = new Choreographer$FrameCallbackC0171b();
        Choreographer.getInstance().postFrameCallback(this.aHT);
        this.aHU = new a();
        this.aHS = new e();
        com.baidu.swan.apps.ak.e.TT().a(this.aHS, com.baidu.swan.apps.ak.e.bsW, com.baidu.swan.apps.ak.e.bsU, com.baidu.swan.apps.ak.e.bsV, com.baidu.swan.apps.ak.e.bsX, com.baidu.swan.apps.ak.e.bsY, com.baidu.swan.apps.ak.e.bsZ, com.baidu.swan.apps.ak.e.bta);
        this.aHR = new d();
        this.aHR.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void Dr() {
        if (!this.aHW) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.aHW = false;
        if (this.aHR != null) {
            this.aHR.removeMessages(0);
            this.aHR = null;
        }
        if (this.aHS != null) {
            com.baidu.swan.apps.ak.e.TT().b(this.aHS, new com.baidu.swan.apps.ak.c[0]);
            this.aHS = null;
        }
        this.aHT = null;
        this.aHU = null;
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
            if (b.this.aHV != null) {
                b.this.Ds();
                b.this.aHV.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Ji().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.aHR != null) {
                    b.this.aHR.sendEmptyMessageDelayed(0, b.this.aHG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds() {
        if (!this.aHU.aHY) {
            j.a(this.aHU, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean aHY;
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
            this.aHY = true;
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
                        b.this.aHV.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.a.b(bufferedReader);
                        this.aHY = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.a.b(bufferedReader);
                        this.aHY = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.b(append);
                    this.aHY = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.a.b(append);
                this.aHY = false;
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
    public class Choreographer$FrameCallbackC0171b implements Choreographer.FrameCallback {
        long aIa;
        int aIb;

        private Choreographer$FrameCallbackC0171b() {
            this.aIa = -1L;
            this.aIb = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.aHW) {
                if (this.aIa > 0 && this.aIb != (i = (int) ((1.0d / (j - this.aIa)) * 1.0E9d))) {
                    this.aIb = i;
                    b.this.aHV.put("frame", Integer.valueOf(i));
                }
                this.aIa = j;
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
                    b.this.aHV.put(cVar.id, cVar.TS());
                }
            }
        }
    }
}
