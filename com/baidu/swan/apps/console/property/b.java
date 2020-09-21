package com.baidu.swan.apps.console.property;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.p;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cfh = com.baidu.swan.apps.am.e.dck.id;
    public static final String cfi = com.baidu.swan.apps.am.e.dci.id;
    public static final String cfj = com.baidu.swan.apps.am.e.dcj.id;
    public static final String cfk = com.baidu.swan.apps.am.e.dcn.id;
    public static final String cfl = com.baidu.swan.apps.am.e.dcp.id;
    public static final String cfm = com.baidu.swan.apps.am.e.dcl.id;
    public static final String cfn = com.baidu.swan.apps.am.e.dcm.id;
    public static final String cfo = com.baidu.swan.apps.am.e.dco.id;
    public static final String cfp = com.baidu.swan.apps.am.e.dcq.id;
    public static final String cfq = com.baidu.swan.apps.am.e.dcr.id;
    private int cfd;
    private d cfr;
    private e cfs;
    private Choreographer$FrameCallbackC0369b cft;
    private a cfu;
    private ConcurrentMap<String, Object> cfv;
    private boolean cfw;
    private int cfx;

    /* loaded from: classes3.dex */
    private static class c {
        public static final b cfC = new b();
    }

    private b() {
        this.cfv = new ConcurrentHashMap();
        this.cfd = 1000;
    }

    public static b afa() {
        return c.cfC;
    }

    public Map<String, Object> afb() {
        this.cfx++;
        afc();
        return this.cfv;
    }

    public void recycle() {
        int i = this.cfx - 1;
        this.cfx = i;
        if (i <= 0) {
            afd();
        }
    }

    private void afc() {
        if (this.cfw) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cfw = true;
        this.cft = new Choreographer$FrameCallbackC0369b();
        Choreographer.getInstance().postFrameCallback(this.cft);
        this.cfu = new a();
        this.cfs = new e();
        com.baidu.swan.apps.am.e.aEQ().a(this.cfs, com.baidu.swan.apps.am.e.dck, com.baidu.swan.apps.am.e.dci, com.baidu.swan.apps.am.e.dcj, com.baidu.swan.apps.am.e.dcp, com.baidu.swan.apps.am.e.dcl, com.baidu.swan.apps.am.e.dcm, com.baidu.swan.apps.am.e.dcn, com.baidu.swan.apps.am.e.dco, com.baidu.swan.apps.am.e.dcq, com.baidu.swan.apps.am.e.dcr);
        this.cfr = new d();
        this.cfr.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void afd() {
        if (!this.cfw) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cfw = false;
        if (this.cfr != null) {
            this.cfr.removeMessages(0);
            this.cfr = null;
        }
        if (this.cfs != null) {
            com.baidu.swan.apps.am.e.aEQ().b(this.cfs, new com.baidu.swan.apps.am.c[0]);
            this.cfs = null;
        }
        this.cft = null;
        this.cfu = null;
        if (DEBUG) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.cfv != null) {
                b.this.afe();
                b.this.cfv.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.apu().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cfr != null) {
                    b.this.cfr.sendEmptyMessageDelayed(0, b.this.cfd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (!this.cfu.cfy) {
            p.postOnIO(this.cfu, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private boolean cfy;
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
            this.cfy = true;
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
                        b.this.cfv.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cfy = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cfy = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cfy = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cfy = false;
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
    /* loaded from: classes3.dex */
    public class Choreographer$FrameCallbackC0369b implements Choreographer.FrameCallback {
        long cfA;
        int cfB;

        private Choreographer$FrameCallbackC0369b() {
            this.cfA = -1L;
            this.cfB = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cfw) {
                if (this.cfA > 0 && this.cfB != (i = (int) ((1.0d / (j - this.cfA)) * 1.0E9d))) {
                    this.cfB = i;
                    b.this.cfv.put("frame", Integer.valueOf(i));
                }
                this.cfA = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e implements e.a {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: c */
        public void J(Set<com.baidu.swan.apps.am.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.am.c<?> cVar : set) {
                    b.this.cfv.put(cVar.id, cVar.aEP());
                }
            }
        }
    }
}
