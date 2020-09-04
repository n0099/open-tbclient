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
    public static final String cdf = com.baidu.swan.apps.am.e.dai.id;
    public static final String cdg = com.baidu.swan.apps.am.e.dag.id;
    public static final String cdh = com.baidu.swan.apps.am.e.dah.id;
    public static final String cdi = com.baidu.swan.apps.am.e.dal.id;
    public static final String cdj = com.baidu.swan.apps.am.e.dan.id;
    public static final String cdk = com.baidu.swan.apps.am.e.daj.id;
    public static final String cdm = com.baidu.swan.apps.am.e.dak.id;
    public static final String cdn = com.baidu.swan.apps.am.e.dam.id;
    public static final String cdo = com.baidu.swan.apps.am.e.dao.id;
    public static final String cdp = com.baidu.swan.apps.am.e.dap.id;
    private int cdb;
    private d cdq;
    private e cdr;
    private Choreographer$FrameCallbackC0374b cds;
    private a cdt;
    private ConcurrentMap<String, Object> cdu;
    private boolean cdv;
    private int cdw;

    /* loaded from: classes8.dex */
    private static class c {
        public static final b cdB = new b();
    }

    private b() {
        this.cdu = new ConcurrentHashMap();
        this.cdb = 1000;
    }

    public static b aeq() {
        return c.cdB;
    }

    public Map<String, Object> aer() {
        this.cdw++;
        aes();
        return this.cdu;
    }

    public void recycle() {
        int i = this.cdw - 1;
        this.cdw = i;
        if (i <= 0) {
            aet();
        }
    }

    private void aes() {
        if (this.cdv) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.cdv = true;
        this.cds = new Choreographer$FrameCallbackC0374b();
        Choreographer.getInstance().postFrameCallback(this.cds);
        this.cdt = new a();
        this.cdr = new e();
        com.baidu.swan.apps.am.e.aEg().a(this.cdr, com.baidu.swan.apps.am.e.dai, com.baidu.swan.apps.am.e.dag, com.baidu.swan.apps.am.e.dah, com.baidu.swan.apps.am.e.dan, com.baidu.swan.apps.am.e.daj, com.baidu.swan.apps.am.e.dak, com.baidu.swan.apps.am.e.dal, com.baidu.swan.apps.am.e.dam, com.baidu.swan.apps.am.e.dao, com.baidu.swan.apps.am.e.dap);
        this.cdq = new d();
        this.cdq.sendEmptyMessage(0);
        if (DEBUG) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    private void aet() {
        if (!this.cdv) {
            if (DEBUG) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.cdv = false;
        if (this.cdq != null) {
            this.cdq.removeMessages(0);
            this.cdq = null;
        }
        if (this.cdr != null) {
            com.baidu.swan.apps.am.e.aEg().b(this.cdr, new com.baidu.swan.apps.am.c[0]);
            this.cdr = null;
        }
        this.cds = null;
        this.cdt = null;
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
            if (b.this.cdu != null) {
                b.this.aeu();
                b.this.cdu.put("mem", Long.valueOf(((ActivityManager) com.baidu.swan.apps.t.a.aoJ().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.cdq != null) {
                    b.this.cdq.sendEmptyMessageDelayed(0, b.this.cdb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeu() {
        if (!this.cdt.cdx) {
            p.postOnIO(this.cdt, "swanAppCpuMonitor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private boolean cdx;
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
            this.cdx = true;
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
                        b.this.cdu.put(com.baidu.fsg.face.base.b.c.i, a);
                        if (b.DEBUG) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + a);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cdx = false;
                    } catch (IOException e) {
                        e = e;
                        if (b.DEBUG) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e);
                        }
                        com.baidu.swan.c.d.closeSafely(bufferedReader);
                        this.cdx = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(append);
                    this.cdx = false;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                append = 0;
                com.baidu.swan.c.d.closeSafely(append);
                this.cdx = false;
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
        int cdA;
        long cdz;

        private Choreographer$FrameCallbackC0374b() {
            this.cdz = -1L;
            this.cdA = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.cdv) {
                if (this.cdz > 0 && this.cdA != (i = (int) ((1.0d / (j - this.cdz)) * 1.0E9d))) {
                    this.cdA = i;
                    b.this.cdu.put("frame", Integer.valueOf(i));
                }
                this.cdz = j;
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
                    b.this.cdu.put(cVar.id, cVar.aEf());
                }
            }
        }
    }
}
