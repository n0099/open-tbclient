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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String cdb = com.baidu.swan.apps.am.e.dae.id;
    public static final String cdc = com.baidu.swan.apps.am.e.dac.id;
    public static final String cdd = com.baidu.swan.apps.am.e.dad.id;
    public static final String cde = com.baidu.swan.apps.am.e.dah.id;
    public static final String cdf = com.baidu.swan.apps.am.e.daj.id;
    public static final String cdg = com.baidu.swan.apps.am.e.daf.id;
    public static final String cdh = com.baidu.swan.apps.am.e.dag.id;
    public static final String cdi = com.baidu.swan.apps.am.e.dai.id;
    public static final String cdj = com.baidu.swan.apps.am.e.dak.id;
    public static final String cdk = com.baidu.swan.apps.am.e.dal.id;
    private int ccX;
    private d cdm;
    private e cdn;
    private Choreographer$FrameCallbackC0374b cdo;
    private a cdp;
    private ConcurrentMap<String, Object> cdq;
    private boolean cdr;
    private int cds;

    /* loaded from: classes8.dex */
    private static class c {
        public static final b cdx = new b();
    }

    private b() {
        this.cdq = new ConcurrentHashMap();
        this.ccX = 1000;
    }

    public static b aeq() {
        return c.cdx;
    }

    public Map<String, Object> aer() {
        this.cds++;
        aes();
        return this.cdq;
    }

    public void recycle() {
        int i = this.cds - 1;
        this.cds = i;
        if (i <= 0) {
            aet();
        }
    }

    private void aes() {
        if (this.cdr) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cdr = true;
        this.cdo = new Choreographer$FrameCallbackC0374b();
        Choreographer.getInstance().postFrameCallback(this.cdo);
        this.cdp = new a();
        this.cdn = new e();
        com.baidu.swan.apps.am.e.aEg().a(this.cdn, com.baidu.swan.apps.am.e.dae, com.baidu.swan.apps.am.e.dac, com.baidu.swan.apps.am.e.dad, com.baidu.swan.apps.am.e.daj, com.baidu.swan.apps.am.e.daf, com.baidu.swan.apps.am.e.dag, com.baidu.swan.apps.am.e.dah, com.baidu.swan.apps.am.e.dai, com.baidu.swan.apps.am.e.dak, com.baidu.swan.apps.am.e.dal);
        this.cdm = new d();
        this.cdm.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void aet() {
        if (!this.cdr) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cdr = false;
        if (this.cdm != null) {
            this.cdm.removeMessages(0);
            this.cdm = null;
        }
        if (this.cdn != null) {
            com.baidu.swan.apps.am.e.aEg().b(this.cdn, new com.baidu.swan.apps.am.c[0]);
            this.cdn = null;
        }
        this.cdo = null;
        this.cdp = null;
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
            if (b.this.cdq != null) {
                b.this.aeu();
                b.this.cdq.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.aoJ().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cdm != null) {
                    b.this.cdm.sendEmptyMessageDelayed(0, b.this.ccX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeu() {
        if (!this.cdp.cdt) {
            p.postOnIO(this.cdp, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private boolean cdt;
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
            this.cdt = true;
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
                        b.this.cdq.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cdt = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cdt = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cdt = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cdt = false;
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
    public class Choreographer$FrameCallbackC0374b implements Choreographer.FrameCallback {
        long cdv;
        int cdw;

        private Choreographer$FrameCallbackC0374b() {
            this.cdv = -1L;
            this.cdw = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cdr) {
                if (this.cdv > 0 && this.cdw != (i = (int) ((1.0d / (j - this.cdv)) * 1.0E9d))) {
                    this.cdw = i;
                    b.this.cdq.put("frame", Integer.valueOf(i));
                }
                this.cdv = j;
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
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: c */
        public void I(Set<com.baidu.swan.apps.am.c<?>> set) {
            if (set != null && set.size() > 0) {
                for (com.baidu.swan.apps.am.c<?> cVar : set) {
                    b.this.cdq.put(cVar.id, cVar.aEf());
                }
            }
        }
    }
}
