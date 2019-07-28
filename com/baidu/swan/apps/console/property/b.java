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
    public static final String anV = com.baidu.swan.apps.ak.e.aZz.id;
    public static final String anW = com.baidu.swan.apps.ak.e.aZx.id;
    public static final String anX = com.baidu.swan.apps.ak.e.aZy.id;
    public static final String anY = com.baidu.swan.apps.ak.e.aZC.id;
    public static final String anZ = com.baidu.swan.apps.ak.e.aZA.id;
    public static final String aoa = com.baidu.swan.apps.ak.e.aZB.id;
    public static final String aob = com.baidu.swan.apps.ak.e.aZD.id;
    private int anR;
    private d aoc;
    private e aod;
    private Choreographer$FrameCallbackC0130b aoe;
    private a aof;
    private ConcurrentMap<String, Object> aog;
    private boolean aoh;
    private int aoi;

    /* loaded from: classes2.dex */
    private static class c {
        public static final b aon = new b();
    }

    private b() {
        this.aog = new ConcurrentHashMap();
        this.anR = 1000;
    }

    public static b yp() {
        return c.aon;
    }

    public Map<String, Object> yq() {
        this.aoi++;
        yr();
        return this.aog;
    }

    public void recycle() {
        int i = this.aoi - 1;
        this.aoi = i;
        if (i <= 0) {
            ys();
        }
    }

    private void yr() {
        if (this.aoh) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.aoh = true;
        this.aoe = new Choreographer$FrameCallbackC0130b();
        Choreographer.getInstance().postFrameCallback(this.aoe);
        this.aof = new a();
        this.aod = new e();
        com.baidu.swan.apps.ak.e.OZ().a(this.aod, com.baidu.swan.apps.ak.e.aZz, com.baidu.swan.apps.ak.e.aZx, com.baidu.swan.apps.ak.e.aZy, com.baidu.swan.apps.ak.e.aZA, com.baidu.swan.apps.ak.e.aZB, com.baidu.swan.apps.ak.e.aZC, com.baidu.swan.apps.ak.e.aZD);
        this.aoc = new d();
        this.aoc.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void ys() {
        if (!this.aoh) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.aoh = false;
        if (this.aoc != null) {
            this.aoc.removeMessages(0);
            this.aoc = null;
        }
        if (this.aod != null) {
            com.baidu.swan.apps.ak.e.OZ().b(this.aod, new com.baidu.swan.apps.ak.c[0]);
            this.aod = null;
        }
        this.aoe = null;
        this.aof = null;
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
            if (b.this.aog != null) {
                b.this.yt();
                b.this.aog.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.u.a.Ek().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.aoc != null) {
                    b.this.aoc.sendEmptyMessageDelayed(0, b.this.anR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt() {
        if (!this.aof.aoj) {
            j.a(this.aof, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private boolean aoj;
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
            this.aoj = true;
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
                        b.this.aog.put("cpu", a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.aoj = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.a.c(bufferedReader);
                        this.aoj = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(append);
                    this.aoj = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.a.c(append);
                this.aoj = false;
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
    public class Choreographer$FrameCallbackC0130b implements Choreographer.FrameCallback {
        long aol;
        int aom;

        private Choreographer$FrameCallbackC0130b() {
            this.aol = -1L;
            this.aom = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.aoh) {
                if (this.aol > 0 && this.aom != (i = (int) ((1.0d / (j - this.aol)) * 1.0E9d))) {
                    this.aom = i;
                    b.this.aog.put("frame", Integer.valueOf(i));
                }
                this.aol = j;
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
        public void D(Set<com.baidu.swan.apps.ak.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.ak.c<?> cVar : set) {
                    b.this.aog.put(cVar.id, cVar.OY());
                }
            }
        }
    }
}
