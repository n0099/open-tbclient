package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class ai extends ah implements Runnable {
    private HandlerThread Az;
    private w Bm;
    private volatile af Bo;
    private volatile aa Bp;
    private final File c;
    private boolean d;
    private Handler e;
    private long g = 0;
    private long h = 0;
    private byte[] i = new byte[0];
    private volatile List j;

    public ai(w wVar) {
        this.Bm = null;
        this.Bm = wVar;
        this.c = new File(this.Bm.f1082a.getExternalFilesDir("data").getAbsolutePath() + "/f_c");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.e != null) {
            this.e.obtainMessage(i).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0023: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:12:0x0023 */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0024: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:12:0x0023 */
    public static byte[] a(File file) throws IOException {
        Closeable closeable;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Closeable closeable2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                closeable = closeable2;
                fileInputStream = fileInputStream2;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            b(bufferedInputStream);
                            b(fileInputStream);
                            b(byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        throw e;
                    }
                }
            } catch (IOException e2) {
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                b(closeable);
                b(fileInputStream);
                b(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            throw e3;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    private void b(File file) {
        new StringBuilder("start upload:").append(file.getName()).append(",len=").append(file.length());
        new Thread(new aj(this, file)).start();
    }

    private boolean e() {
        return this.d && this.e != null;
    }

    @SuppressLint({"MissingPermission"})
    public final void a() {
        File[] listFiles;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g < AppStatusRules.DEFAULT_GRANULARITY) {
            return;
        }
        this.h = currentTimeMillis;
        a(5);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.Bm.f1082a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && 1 == activeNetworkInfo.getType()) {
                if ((Build.VERSION.SDK_INT < 16 || !connectivityManager.isActiveNetworkMetered()) && e() && (listFiles = this.c.listFiles()) != null && listFiles.length != 0) {
                    for (File file : listFiles) {
                        if (file.isFile() && file.exists() && file.getName().startsWith("fclite_")) {
                            if (file.length() != 0) {
                                b(file);
                                this.g = System.currentTimeMillis();
                                return;
                            }
                            file.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void a(aa aaVar, af afVar, List list) {
        if (!this.f1055b || aaVar == null || System.currentTimeMillis() - aaVar.c > 10000) {
            return;
        }
        synchronized (this.i) {
            this.Bp = aaVar;
            this.Bo = afVar;
            this.j = list;
        }
        if (e()) {
            a(afVar == null ? 2 : 1);
            if (System.currentTimeMillis() - this.h > Constants.SYNC_MSG_DELAY_TIME) {
                a();
            }
        }
    }

    @Override // b.a.a.a.a.ah
    public final void b(Handler handler) {
        synchronized (this.i) {
            this.j = null;
            this.Bo = null;
            this.Bp = null;
        }
        this.h = 0L;
        this.g = 0L;
        this.d = this.c.exists() || this.c.mkdirs();
        if (this.d) {
            this.Az = new HandlerThread("fc_thread");
            this.Az.start();
            this.e = new ak(this, this.Az.getLooper());
            this.g = System.currentTimeMillis() - 50000;
        }
    }

    @Override // b.a.a.a.a.ah
    public final void c() {
        if (e()) {
            this.e.removeCallbacks(this);
            this.e.postDelayed(this, 300L);
            if (e()) {
                a(3);
            }
            a(5);
            a(4);
            a();
        }
    }

    @Override // b.a.a.a.a.ah
    public final String d() {
        return "DcPro";
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (e()) {
            this.d = false;
            this.e.removeCallbacksAndMessages(null);
            this.e = null;
            if (this.Az != null) {
                this.Az.quit();
                this.Az = null;
            }
        }
    }
}
