package b.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import androidx.core.content.PermissionChecker;
import com.baidu.webkit.internal.ETAG;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class al {
    private static w AW;
    private static volatile al Bv;
    private static Context f;
    private static String h = "";
    public am Bw;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private byte[] e = new byte[0];
    private SimpleDateFormat Bx = new SimpleDateFormat("HHmmss");
    private SimpleDateFormat By = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /* renamed from: b  reason: collision with root package name */
    public boolean f1058b = false;

    private al() {
    }

    public static void a(Context context, String str) {
        f = context.getApplicationContext();
        h = str;
        AW = w.G(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        new Thread(new b(this, str, z), "th_mllc").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d A[Catch: Throwable -> 0x005e, TryCatch #0 {Throwable -> 0x005e, blocks: (B:5:0x0010, B:8:0x0044, B:12:0x004d, B:13:0x0050, B:14:0x0054), top: B:22:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        boolean z;
        int i = context.getApplicationInfo().targetSdkVersion;
        int i2 = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            try {
                String str = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.CHANGE_NETWORK_STATE", "android.permission.READ_PHONE_STATE"}[i3];
                if (Build.VERSION.SDK_INT >= 23) {
                    if (i < 23) {
                        if (PermissionChecker.checkSelfPermission(context, str) != 0) {
                            z = false;
                        }
                    } else if (context.checkSelfPermission(str) != 0) {
                        z = false;
                    }
                    if (z) {
                        i2 |= 1 << i3;
                    }
                }
                z = true;
                if (z) {
                }
            } catch (Throwable th) {
                i2 = -1;
            }
        }
        m.hK();
        return Build.VERSION.SDK_INT + ETAG.ITEM_SEPARATOR + i + ETAG.ITEM_SEPARATOR + i2 + ETAG.ITEM_SEPARATOR + m.a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(al alVar) {
        synchronized (alVar.e) {
            if (alVar.c) {
                alVar.c = false;
                if (alVar.Bw != null) {
                    am amVar = alVar.Bw;
                    String stringBuffer = amVar.Bz.toString();
                    amVar.Bz.setLength(0);
                    if (!amVar.BA.d) {
                        amVar.BA.a(stringBuffer, false);
                        amVar.BA.d = true;
                    }
                    am amVar2 = amVar.BA.Bw;
                    if (amVar2 != null) {
                        amVar2.removeCallbacksAndMessages(null);
                    }
                    alVar.Bw = null;
                }
            }
        }
    }

    public static al hO() {
        if (Bv == null) {
            synchronized (al.class) {
                try {
                    if (Bv == null) {
                        Bv = new al();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Bv;
    }

    public final void a(String str, String str2) {
        if (!b() || this.Bw == null) {
            return;
        }
        Message obtainMessage = this.Bw.obtainMessage(3);
        obtainMessage.obj = this.Bx.format(new Date()) + "," + str + "," + str2;
        obtainMessage.sendToTarget();
    }

    public final boolean b() {
        boolean z;
        synchronized (this.e) {
            z = this.c;
        }
        return z;
    }

    public final int c(Looper looper) {
        int i;
        synchronized (this.e) {
            if (this.c) {
                i = -1;
            } else {
                this.c = true;
                if (this.f1058b) {
                    this.Bw = new am(this, looper);
                    o.b(this.Bw, 1);
                }
                i = 0;
            }
        }
        return i;
    }

    public final void c() {
        if (!b() || this.Bw == null) {
            return;
        }
        o.b(this.Bw, 5);
    }
}
